package com.radkevich.infohandler.service;

import com.radkevich.infohandler.entity.ComponentType;
import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.entity.TextComposite;

import java.util.*;

public class TextService {

    List<TextComponent> sentence = new ArrayList<>();

    public TextService() {

    }


    private void findComponents(TextComponent textComponent, List<TextComponent> result, ComponentType componentType) {

       for(TextComponent child: textComponent.getChildren()){
           if(child.getType() == componentType){
               result.add(child);
           }else {findComponents(child,result,componentType);}
       }



    }
    private void findAllWords(TextComponent component, List<TextComponent> words) {
        for (TextComponent child : component.getChildren()) {
            if (child.getType() == ComponentType.WORD) {
                words.add(child);
            } else {

                findAllWords(child, words);
            }
        }

    }

    public int getMaxSentencesWithCommonWord(TextComponent root) {
        List<TextComponent> allSentences = new ArrayList<>();
        // Используем твой универсальный метод для поиска предложений
        findComponents(root, allSentences, ComponentType.SENTENCE);

        Map<String, Integer> wordFrequencyInSentences = new HashMap<>();

        for (TextComponent sentence : allSentences) {
            List<TextComponent> lexemesInCurrentSentence = new ArrayList<>();
            // Используем ТОТ ЖЕ метод для поиска лексем внутри конкретного предложения
            findComponents(sentence, lexemesInCurrentSentence, ComponentType.LEXEME);

            Set<String> uniqueWords = new HashSet<>();
            for (TextComponent lexemeComp : lexemesInCurrentSentence) {
                // ОЧИСТКА: переводим в нижний регистр и удаляем всё, кроме букв и цифр
                String cleanWord = lexemeComp.toString()
                        .toLowerCase()
                        .trim()
                        .replaceAll("[^a-zA-Zа-яА-Я0-9]", "");

                if (!cleanWord.isEmpty()) {
                    uniqueWords.add(cleanWord);
                }
            }

            for (String word : uniqueWords) {
                wordFrequencyInSentences.put(word, wordFrequencyInSentences.getOrDefault(word, 0) + 1);
            }
        }

        return wordFrequencyInSentences.isEmpty() ? 0 : Collections.max(wordFrequencyInSentences.values());
    }



private int countChar(TextComponent sentence, char target) {
    String text = sentence.toString().toLowerCase();
    int count = 0;
    for (char c : text.toCharArray()) {
        if (c == Character.toLowerCase(target)) count++;
    }
    return count;
}


public List<TextComponent> sortSentencesByCharCount(TextComponent root, char target) {
    List<TextComponent> sentences = new ArrayList<>();
    findComponents(root, sentences,ComponentType.SENTENCE);

    sentences.sort(Comparator.comparingInt(s -> countChar(s, target)));
    return sentences;
}

    public void swapFirstAndLastWords(TextComponent root) {

        List<TextComponent> sentences = new ArrayList<>();
        findComponents(root, sentences,ComponentType.SENTENCE);



        for (TextComponent sentence : sentences) {

            List<TextComponent> lexemes = new ArrayList<>(sentence.getChildren());

            if (lexemes.size() >= 2) {

                Collections.swap(lexemes, 0, lexemes.size() - 1);


                replaceChildren(sentence, lexemes);
            }
        }
    }


    private void replaceChildren(TextComponent parent, List<TextComponent> newChildren) {

        List<TextComponent> currentChildren = parent.getChildren();


        List<TextComponent> toRemove = new ArrayList<>(currentChildren);
        for (TextComponent child : toRemove) {
            parent.remove(child);
        }


        for (TextComponent child : newChildren) {
            parent.add(child);
        }
    }
    }



