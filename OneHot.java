import java.util.HashMap;
import java.util.Map;

public class OneHot {
    public static int[] getOneHot(String word, Map<String, Integer> vocabulary) {
        int[] oneHotArray = new int[vocabulary.size()];
        int wordIndex = vocabulary.get(word);
        for (int i = 0; i < oneHotArray.length; i++) {
            if (vocabulary.containsKey(word)) {
                oneHotArray[wordIndex] = 1;
                break;
            }
        }
        return oneHotArray;
    }
    public static float[] getAverageOneHot(String[] words, Map<String, Integer> vocabulary) {
        int[] sum = new int[vocabulary.size()];
        for (int i = 0; i < words.length; i++) {
            int[] oneHot = getOneHot(words[i], vocabulary);
            for (int j = 0; j < oneHot.length; j++) {
                sum[j] = sum[j] + oneHot[j];
            }
        }
        float[] result = new float[vocabulary.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1.0f * sum[i] / words.length;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"Bear", "likes", "honey", "and", "fish"};
        Map<String, Integer> vocab = new HashMap<>();
        String word = "fish";
        String[] wordArray = {"honey", "fish"};
        for (int i = 0; i < words.length; i++) {
            vocab.put(words[i], i);
        }
        int[] arr = getOneHot(word, vocab);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        float[] average = getAverageOneHot(wordArray, vocab);
        for (int i = 0; i < average.length; i++) {
            System.out.println(average[i]);
        }
    }
}
