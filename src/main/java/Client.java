import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws GeneralSecurityException, IOException, SQLException {
        Scanner sc=new Scanner(System.in);
        String sheetId;
        String range;
        String url="jdbc:mysql:///connectors";
        String password="root";
        String username="root";
        String tablename="pipeline";
        System.out.println("Enter the name of the sheet ");
        sheetId=sc.nextLine();
        System.out.println("Enter the range ");
        range=sc.nextLine();
        DataReader<List<String>> sr=new SheetReader(sheetId,range);
        DataWriter<List<String>>dw=new SQLWriter(url,username,password,tablename);
        DataPipeline<List<String>,List<String>> dp=new DataPipeline<>(sr,DataProcessor::convertToUpperCase,dw);
        dp.execute();
//
    }
}