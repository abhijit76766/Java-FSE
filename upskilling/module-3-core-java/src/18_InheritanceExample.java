class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

class InheritanceExample {
    public static void main(String[] args) {
        new Animal().makeSound();
        new Dog().makeSound();
    }
}

