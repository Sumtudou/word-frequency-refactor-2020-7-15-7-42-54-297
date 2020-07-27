import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {
    public String getResult(String inputStr) {

        String[] words = inputStr.split("\\s+");
        Map<String, Integer> wordTimesMap = new HashMap<>();

        for (String word : words) {
            if (!wordTimesMap.containsKey(word)) {
                wordTimesMap.put(word, 1);
            } else {
                wordTimesMap.put(word, wordTimesMap.get(word) + 1);
            }
        }

        List<Input> wordTimesList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordTimesMap.entrySet()) {
            Input input = new Input(entry.getKey(), entry.getValue());
            wordTimesList.add(input);
        }

        wordTimesList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

        StringJoiner joiner = new StringJoiner("\n");
        for (Input w : wordTimesList) {
            String s = w.getValue() + " " + w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();

    }

}
