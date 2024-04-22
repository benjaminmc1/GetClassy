import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.*;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList <Person> recs = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Person p;
        boolean done = false;

        String ID;
        String firstName;
        String lastName;
        String title;
        int YOB;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID");
            firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
            title = SafeInput.getNonZeroLenString(in, "Enter your title");
            YOB = SafeInput.getRangedInt(in, "Enter your year of birth", 1900, 9999);

            p = new Person(ID, firstName, lastName, title, YOB);
            recs.add(p);

            done = SafeInput.getYNConfirm(in, "Are you done? ");
        } while(!done);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try {
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            String r;
            for(Person rec : recs) {
                r = rec.toCSVDataRecord();
                System.out.println("Record " + r);
                writer.write(r, 0, r.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}