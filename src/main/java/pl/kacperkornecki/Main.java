package pl.kacperkornecki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void  main(String[] args) {
        final List<String> names = Arrays.asList("Jakub", "Michal", "Agnieszka", "Ola", "Kasia");

        Greeter greeter = new Greeter();
        greeter.greet("Jakub"); // -> Hello Jakub

        //Greet just ladies here
        List<String> ladies = new ArrayList<String>();
        for (String name : names) {
            if (name.endsWith("a")) {
                ladies.add(name);
            }
        }
        for (String ladyName: ladies) {
            System.out.println(ladyName);
        }
    }
}

