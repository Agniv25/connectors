import java.util.List;
import java.util.stream.Collectors;

public class DataProcessor {
    public static List<String>convertToString(List<String>rowData){
//        return rowData.stream().map(innerData->innerData.stream().map(Object::toString).collect(Collectors.toList())).collect(Collectors.toList());
        return rowData.stream().map(Object::toString).collect(Collectors.toList());

    }
    public static List<String>convertToUpperCase(List<String>rowData){
//        return rowData.stream().map(innerData->innerData.stream().map(String::toUpperCase).collect(Collectors.toList())).collect(Collectors.toList());
          return rowData.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
