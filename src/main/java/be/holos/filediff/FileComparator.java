package be.holos.filediff;

import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dieter D'haeyere on 14/12/15.
 */
public class FileComparator {

        // Helper method for get the file content
        private  List<String> fileToLines(String fileName) {
            List<String> lines = new LinkedList<String>();
            String line = "";
            try {
                BufferedReader bReader = new BufferedReader(new InputStreamReader( FileComparator.class.getResourceAsStream(fileName)));



                while ((line = bReader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lines;
        }

    private String fetchBaseFileName(String fileName) {
        int indexOfDot = fileName.indexOf('.');
        return fileName.substring(0,indexOfDot);
    }


    public static void main(String[] args) {

            try {
                FileComparator fileComparator = new FileComparator();
                String baseFileName = fileComparator.fetchBaseFileName("vbi_sern.txt");

                File diffFile = new File(baseFileName + "_diff.txt");
                List<String> original = fileComparator.fileToLines(baseFileName + "_old.txt");
                List<String> revised = fileComparator.fileToLines(baseFileName + "_new.txt");
//            Writer writer = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream("filename.txt"), "utf-8")) {
//                writer.write("something");


                // Compute diff. Get the Patch object. Patch is the container for computed deltas.
                Patch patch = DiffUtils.diff(original, revised);

                for (Delta delta : patch.getDeltas()) {

                    appendChangeToResultingFile(diffFile, delta);

                    System.out.println(delta);
                    System.out.println(delta.getType());
//                FileUtils.writeStringToFile(diffFile, delta.getRevised().g, "utf-8");
                }
            } catch (IOException ioe) {
                // file not found
            }
        }

    private static void appendChangeToResultingFile(File diffFile, Delta delta) throws IOException {
        if (delta.getType() == Delta.TYPE.DELETE) {
            for(Object changedLine: delta.getOriginal().getLines()) {
                FileUtils.writeStringToFile(diffFile, "DELETE" + "\t" + changedLine + "\n", "utf-8", true);
            }

        } else if (delta.getType() == Delta.TYPE.CHANGE) {
            for(Object changedLine: delta.getRevised().getLines()) {
                FileUtils.writeStringToFile(diffFile, "CHANGE" + "\t" + changedLine + "\n", "utf-8", true);
            }
        } else { // Delta.TYPE.INSERT
            for(Object changedLine: delta.getRevised().getLines()) {
                FileUtils.writeStringToFile(diffFile, "INSERT" + "\t" + changedLine + "\n", "utf-8", true);
            }
        }
    }
}
