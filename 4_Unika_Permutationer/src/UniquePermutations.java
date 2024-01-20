import java.util.*;

public class UniquePermutations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> permutations = new HashSet<>();
        generatePermutations("", input, permutations);

        List<String> sortedPermutations = new ArrayList<>(permutations);
        Collections.sort(sortedPermutations);

        for (String perm : sortedPermutations) {
            System.out.println(perm);
        }
    }

    private static void generatePermutations(String prefix, String remaining, Set<String> permutations) {
        if (remaining.length() == 0) {
            permutations.add(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutations(newPrefix, newRemaining, permutations);
        }
    }
}
