/*
 * Author:
 * Date:
 * Purpose:
 */
package Lab6;

import java.util.*;

public class Lab6 {
    
    private HashMap<String, Boolean> visited = null;

    //Instantiates a hasmap that maps integers to integers.
    //See Lab6Test.java for expected key => value pairs.
    public HashMap<Integer, Integer> integerToInteger(){
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(0, 5);
        return h;
    }
    //Instantiates a hashmap that maps doubles to double.
    //See Lab6Test.java for expected key => value pairs.
    public HashMap<Double, Double> doubleToDouble(){
        HashMap<Double, Double> h = new HashMap<>();
        h.put(-1.5, 5.5);
        return h;
    }
    //Instantiates a hashmap that maps lower case characters to their upper case string.
    //See Lab6Test.java for expected key => value pairs.
    public HashMap<Character, String> characterToString(){
        HashMap<Character, String> h = new HashMap<>();
        h.put('a', "A");
        h.put('b', "B");
        h.put('c', "C");
        return h;
    }
    //Instantiates a hashmap that maps computer science terms to their abbreviations.
    //See Lab6Test.java for expected key => value pairs.
    public HashMap<String, String> stringToString(){
        HashMap<String, String> h = new HashMap<>();
        h.put("Central Processing Unit", "CPU");
        h.put("Random Access Memory", "RAM");
        return h;
    }
    //Instantiates a hashmap that maps month numbers to month names.
    //See Lab6Test.java for expected key => value pairs.
    public HashMap<Integer, String> integerToString(){
        HashMap<Integer, String> h = new HashMap<>();
        h.put(0, "January");
        h.put(5, "May");
        h.put(9, "September");
        return h;
    }
    //Instantiates a hashmap that maps radix bucket names to LinkedLists containing the correct single digit entryfor that bucket.
    // Example: { bucket0 => 0, bucket1 => 1, ..., bucket9 => 0 }
    //See Lab6Test.java for expected key => value pairs.
    public HashMap<String, LinkedList<Integer>> integerToLinkedList(){
        HashMap<String, LinkedList<Integer>> h = new HashMap<>();
        LinkedList<Integer> l = new LinkedList<>();

        for(int i = 0; i < 10; i++){
            l.add(i);
            h.put("bucket"+i, l);
        }
        return h;
    }
    //Instantiates a hashmap that maps hospital names to hasmaps that map the hospital's staff names to their medical group.
    //See Lab6Test.java for expected key => value pairs.
    public HashMap<String, HashMap<String, String>> stringToHashMapOfStringToString(){
        String hospitalName = "PeaceHealth Medical Group";
        String[] hospitalStaffNames = new String[5];
        String[] hospitalStaffGroup = new String[5];
        hospitalStaffNames[0] = "Cynthia L. Brinn";
        hospitalStaffGroup[0] = "Dietitian";
        hospitalStaffNames[1] = "Peter E. Filuk";
        hospitalStaffGroup[1] = "Pediatrics";
        hospitalStaffNames[2] = "James R. Beieler";
        hospitalStaffGroup[2] = "Family Medicine";
        hospitalStaffNames[3] = "Sarah M. Langan";
        hospitalStaffGroup[3] = "Gastroenterology";
        hospitalStaffNames[4] = "Megan A. Britson";
        hospitalStaffGroup[4] = "Internal Medicine";

        HashMap<String, HashMap<String, String>> h = new HashMap<>();
        HashMap<String, String> h2 = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            h2.put(hospitalStaffNames[i], hospitalStaffGroup[i]);
        }

        h.put(hospitalName, h2);
        return h;
    }
    //Applies the paint bucket from windows paint to the pixel located at (x,y). 
    //If you are unfamiliar with the paint bucket in windows paint, it starts at a given pixel (x,y) and paints all pixels that are adjacet to and matching the color of the starting pixel.
    //The image input is black and white by the characters ' ' and '#' respectively. This paint bucket will only paint black pixels white (' ' => '#').
    //When paintBucket() is called on a black pixel (picture[x][y] == ' ') it will paint that pixel white (picture[x][y] = '#').
    //When paintBucket() is called on a white pixel (picture != ' ') it will simply return;
    //NOTE: Your paintBucket method should edit the input 2-dimensional char array.
    //HINT: If a black pixel is painted white, there may be adjacent black pixels that need to be painted white.
    //HINT: You will need to use a hashmap to keep track of the pixels you have visited to avoid a stack overflow error. See the private visited HashMap above.
    //HINT: Run "gradle run" from the command line to see the output of your paintBucket method and the correct output.
    public void paintBucket(char[][] picture, int x, int y){
        if(x < 0 || x >= picture.length){
            return;
        }
        if(y < 0 || y >= picture[0].length){
            return;
        }

        if (visited == null) {
            visited = new HashMap<>();
        }

        String s = ("" + x) + y;
        if (!visited.containsKey(s)) {
            visited.put(s, (picture[x][y] == '#'));
        }

        if (!visited.get(s)) {
            visited.put(s, true);
            picture[x][y] = '#';
            paintBucket(picture, x + 1, y);
            paintBucket(picture, x - 1, y);
            paintBucket(picture, x, y + 1);
            paintBucket(picture, x, y - 1);
        }
    }

    public void printPicture(char[][] picture){
        int i, j;
        for(i = 0; i < picture.length; i++){
            for(j = 0; j < picture[i].length-1; j++){
                System.out.print(picture[i][j]+" ");
            }
            System.out.println(picture[i][j]);
        }
    }

    public static void main(String[] args) {
        Lab6 L = new Lab6();
        char[][] inputPicture1 = {
                                    {' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', '#', '#', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#'},
                                    {'#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' '},
                                    {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', ' '},
                                    {'#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' '},
                                    {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', ' '},
                                    {' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' '},
                                    {' ', ' ', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#'},
                                    {' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
                                };
        char[][] outputPicture1 = {
                                    {' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#'},
                                    {'#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', '#', ' '},
                                    {'#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', ' '},
                                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' '},
                                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', ' '},
                                    {' ', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', '#', ' '},
                                    {' ', ' ', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#'},
                                    {' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
                                };
        char[][] inputPicture2 = {
                                    {' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#'},
                                    {'#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', '#', ' '},
                                    {'#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', ' '},
                                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' '},
                                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', ' '},
                                    {' ', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', '#', ' '},
                                    {' ', ' ', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#'},
                                    {' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
                                };
        char[][] outputPicture2 = {
                                    {' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#'},
                                    {'#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', '#', ' '},
                                    {'#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' '},
                                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' '},
                                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' '},
                                    {' ', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', '#', ' '},
                                    {' ', ' ', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#'},
                                    {' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
                                };
        System.out.println("ORIGINAL PICTURE:");
        L.printPicture(inputPicture1);
        System.out.println("CALLING paintBucket(inputPicture1, 6, 6)...");
        L.paintBucket(inputPicture1, 6, 6);
        System.out.println("YOUR PICTURE WAS:");
        L.printPicture(inputPicture1);
        System.out.println("IT SHOULD BE:");
        L.printPicture(outputPicture1);
        System.out.println("CALLING paintBucket(inputPicture2, 6, 11)...");
        L.paintBucket(inputPicture2, 6, 11);
        System.out.println("YOUR PICTURE WAS:");
        L.printPicture(inputPicture2);
        System.out.println("IT SHOULD BE:");
        L.printPicture(outputPicture2);
    }
}
