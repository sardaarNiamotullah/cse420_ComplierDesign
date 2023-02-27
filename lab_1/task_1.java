import java.io.*;
import java.util.*;
public class task_1 {
    public static void main(String[] args) {
        String keyWords[] = {"int", "float", "double", "if", "else", "String", "else", "try", "catch", "for", "while"};
        String mathOperators[] = {"+", "-", "/", "*", "="};
        String logicalOperators[] = {"<", ">", "==", "!=", "<=", ">="};
        String others[] = {",", ";", "(", ")", "{", "}", "[", "]"};

        ArrayList<String> keys = new ArrayList<String>();
        ArrayList<String> mathOp = new ArrayList<String>();
        ArrayList<String> logicalOp = new ArrayList<String>();
        ArrayList<String> num = new ArrayList<String>();
        ArrayList<String> identifiers = new ArrayList<String>();
        ArrayList<String> other = new ArrayList<String>();

        try {
            File myObj = new File("/home/niamotullah/codes/java/src/cse420_ComplierDesign/lab_1/input.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (((data.contains(",")) || data.contains(";"))) {
                    if(!other.contains(",")) other.add(",");
                    if(!other.contains(";")) other.add(";");
                }
                String splitData[] = data.split("[, ; \\s+]+");


                for (String word : splitData) {
                    if (Arrays.asList(keyWords).contains(word)) {
                        if (!keys.contains(word)) keys.add(word);
                    } else if (Arrays.asList(mathOperators).contains(word)) {
                        if (!mathOp.contains(word)) mathOp.add(word);
                    } else if (Arrays.asList(logicalOperators).contains(word)) {
                        if (!logicalOp.contains(word)) logicalOp.add(word);
                    } else if (word.startsWith("0") || word.startsWith("1") || word.startsWith("2") || word.startsWith("3") || word.startsWith("4") || word.startsWith("5") || word.startsWith("6") || word.startsWith("7") || word.startsWith("8") || word.startsWith("9")) {
                        if (!num.contains(word)) num.add(word);
                    } else {
                        if (!identifiers.contains(word) && !Arrays.asList(others).contains(word)) identifiers.add(word);
                        if (!identifiers.contains(word) && Arrays.asList(others).contains(word)) other.add(word);
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //outputs
        int len;

        System.out.print("Keywords: ");
        len = keys.size();
        for(String s: keys) {
            if (s == keys.get(len-1)) System.out.print(s);
            else System.out.print(s+", ");
        }
        System.out.println();

        System.out.print("Identifiers: ");
        len = identifiers.size();
        for(String s:identifiers) {
            if (s == identifiers.get(len-1)) System.out.print(s);
            else System.out.print(s+", ");
        }
        System.out.println();

        System.out.print("Math Operators: ");
        len = mathOp.size();
        for(String s: mathOp) {
            if (s == mathOp.get(len-1)) System.out.print(s);
            else System.out.print(s+", ");
        }
        System.out.println();

        System.out.print("Logical Operators: ");
        len = logicalOp.size();
        for(String s: logicalOp) {
            if (s == logicalOp.get(len-1)) System.out.print(s);
            else System.out.print(s+", ");
        }
        System.out.println();

        System.out.print("Numerical Values: ");
        len = num.size();
        for(String s: num) {
            if (s == num.get(len-1)) System.out.print(s);
            else System.out.print(s+", ");
        }
        System.out.println();

        System.out.print("Others: ");
        len = other.size();
        for(String s: other) {
            if (s == other.get(len-1)) System.out.print(s);
            else System.out.print(s+", ");
        }
    }
}