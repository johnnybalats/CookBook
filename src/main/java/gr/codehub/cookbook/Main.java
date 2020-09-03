package gr.codehub.cookbook;

import gr.codehub.cookbook.exceptions.BusinessException;
import gr.codehub.cookbook.exceptions.InvalidAgeException;
import gr.codehub.cookbook.io.*;
import gr.codehub.cookbook.model.*;
import gr.codehub.cookbook.service.CookBookService;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final String ROOT = "C:\\Users\\john\\Documents\\";

    public static void main(String[] args) {

        System.out.println("\n----- Testing BYTE IO -----");
        testByteIO();
        System.out.println("\n----- Testing DATA IO -----");
        testDataIO();
        System.out.println("\n----- Testing LINE IO -----");
        testLineIO();
        System.out.println("\n----- Testing OBJECT IO -----");
        testObjectIO();
        System.out.println("\n----- Testing MEMORY IO -----");
        testMemoryIO();
        System.out.println("\n----- Testing Exceptions -----");
        int result = setAgeHandleException();
        System.out.println("The result is " + result);
//        System.out.println("\n----- Testing Cook Book -----");
//        testCookBook();
//        System.out.println("\n----- Testing Recipe Words -----");
//        testRecipeWords();
    }

    private static void testByteIO() {

        System.out.println("Start copying files..");
        try {

            ByteIO.copyFile(ROOT + "CV_Mpalatsos_EN.pdf", ROOT + "b.pdf");
        } catch (IOException e) {

            System.out.println("Error: It was not possible to copy the file.");
        }

        System.out.println("Finished copying file!");
    }

    private static void testDataIO() {

        System.out.println("Start saving file..");
        try {

            DataIO.saveData(ROOT + "data_io.txt");
        } catch (IOException e) {

            System.out.println("Error: It was not possible to save the file.");
        }

        System.out.println("Finished saving file!");
    }

    private static void testLineIO() {

        List<String> bookLines = null;

        System.out.println("Start reading files..");
        try {

            bookLines = LineIO.readFile(ROOT + "file1.txt");
        } catch (IOException e) {

            System.out.println("Error: It was not possible to read the file.");
        }

        System.out.println("Finished saving file!");

        if (bookLines != null)
            bookLines.forEach(System.out::println);
    }

    private static void testObjectIO() {

        System.out.println("Copying an object to a new object using files..");
        try {

            Person p1 = new Person("John", 26);
            ObjectIO.saveObject(ROOT + "object_io.txt", p1);

            Person p2 = (Person) ObjectIO.readObject(ROOT + "object_io.txt");
            System.out.println(p2.getName() + " is " + p2.getAge() + " years old");
        } catch (Exception e) {

            System.out.println("Error: It was not possible to copy the object.");
        }
    }

    private static void testMemoryIO() {

        System.out.println("Copying an object to a new object in memory..");
        try {

            MemoryIO<Car> mio = new MemoryIO<>();
            Car car1 = new Car("Ford Model T", 20000);
            Car car2 = mio.copyObject(car1);
            System.out.println(car2.getModel() + " costs $" + car2.getPrice());
        } catch (Exception e) {

            System.out.println("Error: It was not possible to copy the object.");
        }
    }

    private static void showAgeWithException(int age) throws BusinessException, InvalidAgeException {

        System.out.println("Trying to set the age to " + age);
        if (age < 1 || age > 122)
            throw new InvalidAgeException();

        if (Math.random() > 0.5)
            throw  new BusinessException(43, "Unlucky exception");

        System.out.println("The age is " + age);
    }

    private static int setAgeHandleException() {

        try {

            showAgeWithException(134);
            return 0;
        } catch (BusinessException e) {
            System.out.println("Bad luck in setting age.");
            return 1;
        } catch (InvalidAgeException e) {
            System.out.println("Bad business in setting age.");
            return 2;
        } finally {
            System.out.println("Finished setting age!");
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
