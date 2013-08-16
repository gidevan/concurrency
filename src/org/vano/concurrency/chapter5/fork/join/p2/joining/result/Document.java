package org.vano.concurrency.chapter5.fork.join.p2.joining.result;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/16/13
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Document {

    private String words[] = {"the", "hello", "goodbye", "packt", "java", "thread", "pool", "random", "class", "main"};

    public String[][] generateDocument(int numLines, int numWords, String word) {
        int counter = 0;
        String document[][] = new String[numLines][numWords];
        Random random = new Random();
        for(int i = 0; i < numLines; i++) {
            for(int j = 0; j < numWords; j++) {
                int index = random.nextInt(words.length);
                document[i][j] = words[index];
                if(document[i][j].equals(word)) {
                    counter++;
                }
            }
        }
        System.out.println("DocumentMock: The word '" + word + "' appears " + counter + " times in document");
        return document;
    }
}
