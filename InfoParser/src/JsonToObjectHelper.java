import com.fasterxml.jackson.databind.ObjectMapper;
import model.PDFdocument;

import java.io.File;
import java.io.IOException;

public class JsonToObjectHelper {

    public static PDFdocument readJson() {

        ObjectMapper mapper = new ObjectMapper();

        PDFdocument pdfdocument;
        try {
            pdfdocument = mapper.readValue(new File("C:\\Workspace\\U\\InfoParser\\InfoParser\\src\\merged.json"), PDFdocument.class);

            //System.out.println(pdfdocument);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pdfdocument;
    }

}
