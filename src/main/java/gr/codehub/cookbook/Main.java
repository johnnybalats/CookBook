package gr.codehub.cookbook;

import gr.codehub.cookbook.exceptions.BusinessException;
import gr.codehub.cookbook.exceptions.InvalidAgeException;
import gr.codehub.cookbook.model.CookBook;
import gr.codehub.cookbook.model.Ingredient;
import gr.codehub.cookbook.model.Recipe;
import gr.codehub.cookbook.service.CookBookService;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

//        System.out.println("\n----- Testing Read File -----");
//        testReadFile();
//        System.out.println("\n----- Testing Cook Book -----");
//        testCookBook();
//        System.out.println("\n----- Testing Recipe Words -----");
//        testRecipeWords();

        try {
            showAge(34);
        } catch (BusinessException e) {
            e.printStackTrace();
            System.out.println("Bad luck");
        } catch (InvalidAgeException e) {
            e.printStackTrace();
            System.out.println("Bad business");
        } finally {
            System.out.println("It is over");
        }
    }

    private static void showAge(int age) throws BusinessException, InvalidAgeException {

        if (age < 1 || age > 122)
            throw new InvalidAgeException();

        if (Math.random() > 0.5)
            throw  new BusinessException(43, "Unlucky exception");

        System.out.println("The age is " + age);
    }

    private static  String readFile(File file) throws BusinessException {

        System.out.println("read file step 1");
        try {
            System.out.println("read file step 2");
            BufferedReader br = new BufferedReader((new FileReader(file)));
            System.out.println("read file step 3");
        } catch (FileNotFoundException e) {
            System.out.println("read file step 4");
            throw new BusinessException(12, "Exception occurred");
        }
        System.out.println("read file step 5");
        return "(some content from the file)";
    }

    private static void testReadFile() {
        try {
            readFile(new File("something.smth"));
        } catch (BusinessException e) {
            System.out.println("Business error: cannot see the contents of this file");
        }
    }

    private static void testCookBook() {

        CookBook cookBook = new CookBookService().createCookBook();

        List<Recipe> allRecipes = cookBook.getRecipes();
        System.out.println("\nThe book contains " + allRecipes.size() + " recipes");
        for (Recipe recipe: allRecipes)
            System.out.println("Recipe = " + recipe.getName());

        List<Ingredient> allIngredients = allRecipes
                .stream()
                .flatMap(recipe -> recipe.getIngredients().stream())
                .collect(Collectors.toList());

//        List<Ingredient> allIngredients = new ArrayList<>();
//        for (Recipe recipe: allRecipes)
//            allIngredients.addAll(recipe.getIngredients());

        System.out.println("\nThe book recipes uses " + allIngredients.size() + " ingredients (with quantities)");
        for (Ingredient ingredient: allIngredients)
            System.out.println("Ingredient = " + ingredient.getName() + ", " + ingredient.getQuantity());

//        Set<Ingredient> allUniqueIngredients = new HashSet<>(allIngredients);

        List<Ingredient> allUniqueIngredients = allIngredients
                .stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nThe book recipes uses " + allUniqueIngredients.size() + " unique ingredients (with quantities)");
        for (Ingredient ingredient: allUniqueIngredients)
            System.out.println("Unique ingredient = " + ingredient.getName() + ", " + ingredient.getQuantity());

//        Set<String> allIngredientTypes = new HashSet<>();
//        for (Ingredient ingredient: allIngredients)
//            allIngredientTypes.add(ingredient.getName());

        List<String> allIngredientTypes = allUniqueIngredients
                .stream()
                .map(i -> i.getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());


        System.out.println("\nThe book recipes uses " + allIngredientTypes.size() + " unique ingredient types");
        for (String name: allIngredientTypes)
            System.out.println("Unique ingredient type = " + name);
    }

    private static void testRecipeWords() {

        String recipeText = "ena aygo mia koutalia zaxari mia koutalia aleyri kai ena akoma aygo";
        String[] wordsArray = recipeText.split(" ");
        List<String> wordsList = Arrays.asList(wordsArray);

        List<String> longWords = wordsList
                .stream()
                .filter(word -> word.length() > 3)
                .collect(Collectors.toList());

        System.out.println("\nPrint long words with for: ");
        for (String word: longWords)
            System.out.println(word);

        System.out.println("\nPrint long words with forEach: ");
        longWords.forEach(System.out::println);

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word: wordsList) {

            Integer wordCount = wordCountMap.get(word);
            if (wordCount == null) {
                wordCount = 0;
            }
            wordCount++;
            wordCountMap.put(word, wordCount);
        }

        System.out.println("\nPrint word count with forEach: ");
        wordCountMap.forEach((name, count) -> System.out.println(name + " = " + count));

        System.out.println("\nPrint words from Map: ");
        for (String s: wordCountMap.keySet())
            System.out.println(s);

        System.out.println("\nPrint counts from Map: ");
        for (Integer s: wordCountMap.values())
            System.out.println(s);

        System.out.println("\nPrint words and counts from Map: ");
        for (Map.Entry entry: wordCountMap.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());
    }
}
