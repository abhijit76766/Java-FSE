import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LambdaExpressions {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Charlie", "Alice", "Bob"));
        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));
        System.out.println(names);
    }
}

