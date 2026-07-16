import java.util.ArrayList;
import java.util.List;

public class TextJustificationLeetcode68 {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words,maxWidth));
    }
    static List<String> fullJustify(String[] words, int maxWidth){
        List<String> result = new ArrayList<>();
        int wordIndex = 0;
        int totalWords = words.length;

        while (wordIndex < totalWords) {
            List<String> currentLineWords = new ArrayList<>();
            currentLineWords.add(words[wordIndex]);
            int currentLineLength = words[wordIndex].length();
            wordIndex++;

            while (wordIndex < totalWords &&
                    currentLineLength + 1 + words[wordIndex].length() <= maxWidth) {
                currentLineLength += 1 + words[wordIndex].length();
                currentLineWords.add(words[wordIndex]);
                wordIndex++;
            }

            if (wordIndex == totalWords || currentLineWords.size() == 1) {
                String leftJustifiedText = String.join(" ", currentLineWords);
                String rightPadding = " ".repeat(maxWidth - leftJustifiedText.length());
                result.add(leftJustifiedText + rightPadding);
                continue;
            }


            int totalSpacesNeeded = maxWidth - (currentLineLength - currentLineWords.size() + 1);
            int baseSpacesBetweenWords = totalSpacesNeeded / (currentLineWords.size() - 1);
            int extraSpaces = totalSpacesNeeded % (currentLineWords.size() - 1);

            StringBuilder currentLine = new StringBuilder();
            for (int i = 0; i < currentLineWords.size() - 1; i++) {
                currentLine.append(currentLineWords.get(i));
                int spacesToAdd = baseSpacesBetweenWords + (i < extraSpaces ? 1 : 0);
                currentLine.append(" ".repeat(spacesToAdd));
            }
            currentLine.append(currentLineWords.get(currentLineWords.size() - 1));

            result.add(currentLine.toString());
        }

        return result;
    }
}
