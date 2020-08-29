package gr.codehub.cookbook;

import gr.codehub.cookbook.exceptions.BusinessException;
import gr.codehub.cookbook.model.Recipe;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static  String readFile(File file) throws BusinessException {

        System.out.println("read file step 1");
        try {
            System.out.println("read file step 2");
            BufferedReader br = new BufferedReader((new FileReader(file)));
            System.out.println("read file step 3");
        } catch (FileNotFoundException e) {
            System.out.println("read file step 4");
            throw new BusinessException();
        }
        System.out.println("read file step 5");
        return "(some content from the file)";
    }

    private static void testReadFile() {
        try {
            readFile(new File("difgywdoigvywiogyvceiwygvpvye.ce9igyiyg"));
        } catch (BusinessException e) {
            System.out.println("Business error: cannot see the contents of this file");
        }
    }

    public static void main(String[] args) {

        testReadFile();


//        Recipe r1 = new Recipe();
//        r1.setName("Boiled eggs");
//        Recipe r2 = new Recipe();
//        r2.setName("Fried eggs");
//        Recipe r3 = new Recipe();
//        r3.setName("Poached eggs");
//
//        Recipe[] recipeArray = new Recipe[15];
//        recipeArray[0] = r1;
//
//        List<Recipe> recipeList = new ArrayList<>();
//        recipeList.add(r1);
//        recipeList.add(r2);
//        recipeList.add(r3);
//        recipeList.add(r1);
//        recipeList.add(r2);
//        recipeList.add(r3);
//
//        System.out.println(recipeList.size());
//
//        Set<Recipe> set1 = new HashSet<>();
//        set1.addAll(recipeList);
//        System.out.println(set1.size());
//
//        List<Recipe> listFromSet = new ArrayList<>();
//        listFromSet.addAll(set1);
//
//        listFromSet.forEach(System.out::println);

        String recipeText = "ena aygo mia koutalia zaxari mia koutalia aleyri kai ena akoma aygo";
        String[] words = recipeText.split(" ");
        List<String> wordList = Arrays.asList(words);

        List<String> longWords = wordList
                .stream()
                .filter(word -> word.length() > 3)
                .collect(Collectors.toList());


        longWords.forEach(System.out::println);

//        System.out.println("");
//
//        for (String word: longWords)
//            System.out.println(word);
//
//
//        Map<String, Integer> wordMap = new HashMap<>();
//
//        for (String word: words) {
//
//            Integer wordCount = wordMap.get(word);
//
//            if (wordCount == null)
//                wordCount = 0;
//
//            wordCount++;
//
//            wordMap.put(word, wordCount);
//        }
//
//        System.out.println("");
//
//        wordMap
//                .forEach((name, count) -> System.out.println(name + " = " + count));

//        for (Map.Entry entry: wordMap.entrySet())
//            System.out.println(entry.getKey() + " = " + entry.getValue());
    }
}
