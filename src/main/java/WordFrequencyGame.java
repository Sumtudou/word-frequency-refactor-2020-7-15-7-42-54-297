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
        Map<String, Integer> wordTimesMap = getWordTimesMap(words);
        List<Input> wordTimesList = getWordTimesList(wordTimesMap);
        return getResult(wordTimesList);
    }

    private String getResult(List<Input> wordTimesList) {

        StringJoiner joiner = new StringJoiner("\n");
        for (Input wordTimes : wordTimesList) {
            String wordTimesStr = wordTimes.getValue() + " " + wordTimes.getWordCount();
            joiner.add(wordTimesStr);
        }
        return joiner.toString();
    }

    private List<Input> getWordTimesList(Map<String, Integer> wordTimesMap) {
        List<Input> wordTimesList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordTimesMap.entrySet()) {
            Input input = new Input(entry.getKey(), entry.getValue());
            wordTimesList.add(input);
        }
        wordTimesList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
        return wordTimesList;
    }

    private Map<String, Integer> getWordTimesMap(String[] words) {
        Map<String, Integer> wordTimesMap = new HashMap<>();
        for (String word : words) {
            if (!wordTimesMap.containsKey(word)) {
                wordTimesMap.put(word, 1);
            } else {
                wordTimesMap.put(word, wordTimesMap.get(word) + 1);
            }
        }
        return wordTimesMap;
    }

}
