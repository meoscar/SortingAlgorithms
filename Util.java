public class Util {

    private static Util instance;
    public static int count;

    private Util() {
    }

    public static Util getInstance() {
        if (instance == null) {
            synchronized (Util.class) {
                instance = new Util();
            }
        }
        return instance;
    }


    public static int getCount() {
        //System.out.println(count);
        return count;
    }

    public static void resetCount() {
        count = 0;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        //System.out.println("count ++");
        count++;
    }
}
