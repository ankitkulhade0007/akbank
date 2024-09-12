package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetIterationDemo {

    public static void main(String[] args) {
        Set<String> superpowers = new HashSet<>();
        // Superheroes and their unique abilities
        superpowers.add("Invisibility");
        superpowers.add("Teleportation");
        superpowers.add("Mind Reading");
        superpowers.add("Super Strength");
        superpowers.add("Time Travel");

        // Villains and their mischievous powers
        superpowers.add("Laser Vision");
        superpowers.add("Weather Manipulation");
        superpowers.add("Telekinesis");
        superpowers.add("Shape-Shifting");
        superpowers.add("Chaos Induction");

        for (String superPower: superpowers) {
            System.out.println(superPower.toUpperCase());
        }

        Iterator<String> iterator = superpowers.iterator();

        while (iterator.hasNext()) {
            String superPower = iterator.next();
            System.out.println(superPower.toLowerCase());
        }

        removeVowelWords();

    }
    public static Set<String> removeVowelWords () {
        // Create a HashSet of words
        Set<String> words = new HashSet<>();
        words.add("apple");
        words.add("banana");
        words.add("orange");
        words.add("lynx");
        words.add("grape");


        // Create an iterator to iterate through the HashSet
        Iterator<String> iterator = words.iterator();

        // Iterate through the HashSet and remove words containing vowels
        while (iterator.hasNext()) {
            String word = iterator.next();
            // Check if the word contains any vowels (both lowercase and uppercase)
            if (word.matches(".*[aeiouAEIOU].*")) {
                // Remove the word if it contains vowels
                iterator.remove();
            }
        }

        return words;

    }


}
