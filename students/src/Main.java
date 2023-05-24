import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Invalid arguments. Please provide the choice and required data.");
            return;
        }

        int choice = Integer.parseInt(args[0]);
        Path paths = Paths.get("app/data/batch");
        FileWriter myWriter = new FileWriter(paths + "/database.txt", true);

        switch (choice) {
            case 1: {
             
                String student = args[1];
                int id = Integer.parseInt(args[2]);
                String courses = args[3];
                myWriter.write(student + ";" + id + ";" + courses + "\n");
                myWriter.close();
                break;
            }
            case 2: {
         
                String fileName = args[1];
                File[] arr = paths.toFile().listFiles();
                ArrayList<String> files = new ArrayList<>();
                if (arr != null) {
                    for (File i : arr) {
                        if (i.toString().contains("_verified")) {
                            files.add(i.getName());
                            System.out.println(i.getName());
                        }
                    }
                    int index = files.indexOf(fileName);
                    if (index >= 0) {
                        File file = new File(paths + "/" + files.get(index));
                        Scanner myReader = new Scanner(file);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            myWriter.write(data + "\n");
                        }
                        myReader.close();
                    }
                }
                myWriter.close();
                break;
            }
          
        }
    }
}
