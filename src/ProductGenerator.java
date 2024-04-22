import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.*;

public class ProductGenerator {
    public static void main(String[] args) {
        ArrayList<Product> recs = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Product p;
        boolean done = false;

        String name;
        String description;
        String ID;
        double cost;

        do {
            name = SafeInput.getNonZeroLenString(in, "Enter the Product Name");
            description = SafeInput.getNonZeroLenString(in, "Enter the Product Description");
            ID = SafeInput.getNonZeroLenString(in, "Enter the Product ID");
            cost = SafeInput.getDouble(in, "Enter the product cost");

            p = new Product(name, description, ID, cost);
            recs.add(p);

            done = SafeInput.getYNConfirm(in, "Do you want to enter any more products? ");
        }while(!done);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductData.txt");

        try {
            if(!Files.exists(file)) {
                Files.createFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            String r;
            for(Product rec : recs) {
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