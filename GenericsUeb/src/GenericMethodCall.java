/**
 * Created by afischer on 19/12/2016.
 */
public class GenericMethodCall {


    public void callMethod() {

        Integer[] intArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] stringArray = {'H', 'e', 'l', 'l', 'o'};

        GenericMethod genMethod = new GenericMethod();

        System.out.println("Integer:");
        genMethod.printArray(intArray);
        System.out.println("Double:");
        genMethod.printArray(doubleArray);
        System.out.println("String:");
        genMethod.printArray(stringArray);


        String s = genMethod.random("Analogkäse", "Bloedsinn-Schinken");
        System.out.println(s);

    }


}
