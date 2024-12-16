import java.sql.SQLException;
import java.util.List;

public interface DataWriter<R> {
    public void writeData(List<R> data) throws SQLException;
}
