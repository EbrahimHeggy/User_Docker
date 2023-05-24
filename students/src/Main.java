import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan  = new Scanner(System.in);
        System.out.println("1- Add student data");
        System.out.println("2- Add batch students data");
        int n = scan.nextInt();
        Path paths = Paths.get("app/data/batch");
        FileWriter myWriter = new FileWriter(paths+"/database.txt",true);
        switch (n){
            case 1:
            {
                String student,courses;
                int id;
                student = scan.next();
                id = scan.nextInt();
                courses = scan.next();
                myWriter.write(student+";"+id+";"+courses+"\n");
                myWriter.close();
                break;
            }
            case 2:
            {
                File[] arr = paths.toFile().listFiles();
                ArrayList<String> files = new ArrayList<>();
                if(arr!=null){
                    for(File i :arr){
                        if(i.toString().contains("_verified")){
                            files.add(i.getName());
                            System.out.println(i.getName());
                        }
                    }
                    String fileName = scan.next();
                    int index = files.indexOf(fileName);
                    if(index>=0){
                        File file = new File(paths+"/"+files.get(index));
                        Scanner myReader = new Scanner(file);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            myWriter.write(data+"\n");
                        }
                        myReader.close();
                    }

                }
                myWriter.close();
            }
        }
    }
}
