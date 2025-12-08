import java.io.File;
import java.io.FileNotFoundException; //
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BST tree=new BST();
        loadWordsIntoTree(tree, "file");
    }

    public static void loadWordsIntoTree(BST tree, String file){ //idk why needed to put static but computer told me to otherwise error
        File fileName = new File(file);
        try (Scanner myReader = new Scanner(fileName)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data=data.trim();
                if(!data.isEmpty()){
                    tree.put(data);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //https://www.w3schools.com/java/java_files_read.asp
}