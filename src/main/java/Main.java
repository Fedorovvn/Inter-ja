import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        String s = "abacaawrtjtulgfdhklo;'o['accbghjur";
        String order = "cb9op"; //по порядку, затем произвольно

        HashMap<Integer, Integer> orderMap = new HashMap<>();
        char[] chars = order.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            orderMap.put((int) chars[i], i);
        }

        Integer[] charResult = s.chars().boxed().sorted((x, y) -> {
            if (orderMap.get(x) == null && orderMap.get(y) == null) {
                return 0;
            }
            if (orderMap.get(x) == null) {
                return 1;
            }
            if (orderMap.get(y) == null) {
                return -1;
            } else {
                return orderMap.get(x) - orderMap.get(y);
            }
        }).toArray(Integer[]::new);

        StringBuilder finalString = new StringBuilder();

        for (int i = 0; i < charResult.length; i++) {
            char c = (char) charResult[i].intValue();
            finalString.append(c);
        }

        System.out.println(finalString);
    }
}
