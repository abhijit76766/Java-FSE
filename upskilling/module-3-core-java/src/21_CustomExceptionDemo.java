class InvalidAgeException extends Exception {
    InvalidAgeException(String message) { super(message); }
}

class CustomExceptionDemo {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) throw new InvalidAgeException("Age must be at least 18");
    }

    public static void main(String[] args) {
        try {
            validateAge(16);
        } catch (InvalidAgeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

