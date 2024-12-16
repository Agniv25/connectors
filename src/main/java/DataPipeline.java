import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataPipeline<T,R> {
    private final DataReader<T>reader;
    private final Function<T,R> processors;
    private final DataWriter<R>writer;

    public DataPipeline(DataReader<T> reader, Function<T, R>processors,DataWriter<R>writer) {
        this.reader = reader;
        this.processors = processors;
        this.writer=writer;
    }
    public void execute() throws GeneralSecurityException, IOException, SQLException {
        List<T> input=reader.readData();
        List<R>processedData=input.stream().map(processors).collect(Collectors.toList());
        writer.writeData(processedData);

    }

}
