public class Main {
    public static void main(String[] args) {
        Computer officeComputer = new Computer.Builder("Intel i5", "16GB")
                .storage("512GB SSD")
                .build();

        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", "32GB")
                .storage("2TB NVMe SSD")
                .graphicsCard("NVIDIA RTX 4070")
                .bluetoothEnabled(true)
                .build();

        System.out.println(officeComputer);
        System.out.println(gamingComputer);
    }
}

