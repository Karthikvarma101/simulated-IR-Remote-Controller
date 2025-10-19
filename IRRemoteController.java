import java.util.Scanner;

public class IRRemote {
    private static boolean powerOn = false;
    private static int volume = 10;
    private static int channel = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("📺 IR Remote Controller Simulation");
        System.out.println("-----------------------------------");

        do {
            System.out.println("\nCurrent Status:");
            System.out.println("Power: " + (powerOn ? "ON" : "OFF"));
            System.out.println("Volume: " + volume);
            System.out.println("Channel: " + channel);

            System.out.println("\nSelect Option:");
            System.out.println("1. Power ON/OFF");
            System.out.println("2. Volume Up");
            System.out.println("3. Volume Down");
            System.out.println("4. Next Channel");
            System.out.println("5. Previous Channel");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> togglePower();
                case 2 -> increaseVolume();
                case 3 -> decreaseVolume();
                case 4 -> nextChannel();
                case 5 -> previousChannel();
                case 6 -> System.out.println("👋 Exiting IR Remote...");
                default -> System.out.println("❌ Invalid choice! Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }

    private static void togglePower() {
        powerOn = !powerOn;
        System.out.println("🔘 Power " + (powerOn ? "ON" : "OFF"));
    }

    private static void increaseVolume() {
        if (powerOn && volume < 100) {
            volume++;
            System.out.println("🔊 Volume increased to " + volume);
        } else if (!powerOn) {
            System.out.println("⚠️ Turn on the device first!");
        } else {
            System.out.println("🔇 Maximum volume reached!");
        }
    }

    private static void decreaseVolume() {
        if (powerOn && volume > 0) {
            volume--;
            System.out.println("🔉 Volume decreased to " + volume);
        } else if (!powerOn) {
            System.out.println("⚠️ Turn on the device first!");
        } else {
            System.out.println("🔇 Minimum volume reached!");
        }
    }

    private static void nextChannel() {
        if (powerOn) {
            channel++;
            System.out.println("📺 Switched to channel " + channel);
        } else {
            System.out.println("⚠️ Turn on the device first!");
        }
    }

    private static void previousChannel() {
        if (powerOn && channel > 1) {
            channel--;
            System.out.println("📺 Switched to channel " + channel);
        } else if (!powerOn) {
            System.out.println("⚠️ Turn on the device first!");
        } else {
            System.out.println("🔁 Already at the first channel!");
        }
    }
}
