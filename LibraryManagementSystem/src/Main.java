import java.util.Arrays;
import java.util.Comparator;

class Book {
    private final int bookId;
    private final String title;
    private final String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return bookId + " - " + title + " by " + author;
    }
}

public class Main {
    static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    static Book binarySearchByTitle(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int comparison = books[middle].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[middle];
            }
            if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "Clean Code", "Robert C. Martin"),
            new Book(102, "Effective Java", "Joshua Bloch"),
            new Book(103, "Design Patterns", "Erich Gamma")
        };

        System.out.println("Linear search: " + linearSearchByTitle(books, "Effective Java"));

        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Binary search: " + binarySearchByTitle(books, "Clean Code"));
    }
}

