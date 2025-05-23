import java.util.Random;

public class TebakAngkaLogic {
    private int target;
    private int attempts;

    public TebakAngkaLogic() {
        reset();
    }

    public void reset() {
        target = new Random().nextInt(100) + 1;
        attempts = 0;
    }

    public String cekTebakan(int input) {
        attempts++;
        if (input < target) return "Terlalu kecil!";
        else if (input > target) return "Terlalu besar!";
        else return "Tebakan benar!";
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isBenar(int input) {
        return input == target;
    }
}
