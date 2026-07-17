import java.util.List;

class StreamApiExample {
    public static void main(String[] args) {
        List<Integer> evens = List.of(1, 2, 3, 4, 5, 6)
            .stream()
            .filter(n -> n % 2 == 0)
            .toList();
        System.out.println(evens);
    }
}

