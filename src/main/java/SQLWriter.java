import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SQLWriter implements DataWriter<List<String>> {
    private final String username;
    private final String password;
    private final String tablename;
    private final String url;
    SQLWriter(String url,String username,String password,String tablename){
        this.url=url;
        this.username=username;
        this.password=password;
        this.tablename=tablename;
    }
    public void writeData(List<List<String>> data) throws SQLException {
//
        try(Connection conn=DriverManager.getConnection(url,username,password)){
            createTable(conn,data.get(0));
            insertData(conn,data);

        }

    }
    public void createTable(Connection conn, List<String>data){
            StringBuilder query=new StringBuilder("Create table if not exists " + tablename + "(");
            for(String header:data){
                query.append(header).append(" Varchar(255),");
            }
            query.setLength(query.length()-1);
            query.append(");");
            try(Statement statement=conn.createStatement()){
                statement.execute(query.toString());
                System.out.println("table created");


            }catch(Exception e){
                System.out.println(e);
            }
            finally{
                System.out.println(query);
            }


    }
    public void insertData(Connection conn,List<List<String>>data){
        for(int i=1;i<data.size();i++){
            StringBuilder query=new StringBuilder("Insert into " + tablename + "values (");
            for( String col :data.get(i)){
                for(String val:col){

                }

            }

        }
    }
}
