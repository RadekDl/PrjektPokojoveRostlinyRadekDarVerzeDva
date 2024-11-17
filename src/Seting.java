public class Seting {
    private static String   separator;
    private static int flowerNumber = 1;

    public static String getSeparator() {
         return separator = "\t";
    }

    public static int flowerNumber() {
        return flowerNumber++;
    }
}


