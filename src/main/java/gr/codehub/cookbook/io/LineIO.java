package gr.codehub.cookbook.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LineIO {

    public static List<String> readFile(String inFilename) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inFilename)));
        List<String> lines = new ArrayList<>();

        boolean finished = false;
        while (!finished) {

            String b = in.readLine();
            if (b == null)
                finished = true;
            else
                if (!b.isEmpty() && !b.startsWith("//"))
                    lines.add(b);
        }
        in.close();

        return lines;
    }
}
