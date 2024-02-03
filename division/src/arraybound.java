public class arraybound {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        try {
            int value = array[4];
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
