package com.cognizant.apigateway;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LocalRateLimitFilter implements GlobalFilter, Ordered {
    private final Map<String, WindowCounter> counters = new ConcurrentHashMap<>();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String client = exchange.getRequest().getRemoteAddress() == null
                ? "unknown"
                : exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
        WindowCounter counter = counters.compute(client, (key, old) ->
                old == null || old.isExpired() ? new WindowCounter() : old);

        if (counter.increment() > 60) {
            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private static class WindowCounter {
        private final long windowStart = Instant.now().getEpochSecond();
        private final AtomicInteger count = new AtomicInteger();

        int increment() {
            return count.incrementAndGet();
        }

        boolean isExpired() {
            return Instant.now().getEpochSecond() - windowStart >= 60;
        }
    }
}
