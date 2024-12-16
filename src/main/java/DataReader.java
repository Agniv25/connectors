import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
public interface DataReader<T> {
     List<T> readData() throws GeneralSecurityException, IOException;
}
