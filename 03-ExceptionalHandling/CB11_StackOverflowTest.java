package CB16ExceptionalHandling;

public class CB11_StackOverflowTest {

    public static int counter = 0;

    public static void main(String[] args) {

        try {
            mereKaranArjunAyeGay();
        } catch (StackOverflowError e) {
            System.out.println("Stack overflow after " + counter + " calls.");
        }
    }

    public static void mereKaranArjunAyeGay() {
        counter++;
        mereKaranArjunAyeGay(); // Recursive call
    }
}

