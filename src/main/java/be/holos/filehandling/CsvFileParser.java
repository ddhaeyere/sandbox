package be.holos.filehandling;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author Dieter D'haeyere on 05/07/15.
 */
public class CsvFileParser {

// ParentGroup-ChildGroup;group.getTc();domain.getTc();groupOfGroup.getTc();domainOfGroupOfGroupTc




//    StringBuilder groupOfGroupManualActionsBuilder = new StringBuilder();
//    groupOfGroupManualActionsBuilder.append("add ").append(groupOfGroupTc).append("@").append(domainOfGroupOfGroupTc).append(" to ").append(groupTc).append("@").append(domainTc);
//    groupOfGroupManualActionsFile.write(groupOfGroupManualActionsBuilder.toString());
//    groupOfGroupManualActionsFile.write(NEW_LINE);
//
//
//    ldapProblemInvestigationFiles.write("ParentGroup-ChildGroup;" + group.getTc() + ";" + domain.getTc() + ";" + groupOfGroup.getTc() + ";" + domainOfGroupOfGroupTc);
//    ldapProblemInvestigationFiles.write(NEW_LINE);


    private void parseCSVFile(File file) throws IOException{
        List<String> lines = FileUtils.readLines(file);

        for(String line: lines) {
            String[] columns = line.split(";");
            for(String column: columns) {
                System.out.println(column);
            }
        }


    }

    public static void main(String[] args) {
        try {
            CsvFileParser csvFileParser = new CsvFileParser();
            URL url = CsvFileParser.class.getResource("ldapGroups.csv");
            File csvFile = new File("ldapGroups.csv");
            FileUtils.copyURLToFile(url, csvFile);
            csvFileParser.parseCSVFile(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
