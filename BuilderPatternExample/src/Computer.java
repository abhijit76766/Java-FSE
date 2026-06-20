public class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String graphicsCard;
    private final boolean bluetoothEnabled;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetoothEnabled = builder.bluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", bluetoothEnabled=" + bluetoothEnabled +
                '}';
    }

    public static class Builder {
        private final String cpu;
        private final String ram;
        private String storage = "256GB SSD";
        private String graphicsCard = "Integrated graphics";
        private boolean bluetoothEnabled;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder bluetoothEnabled(boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

