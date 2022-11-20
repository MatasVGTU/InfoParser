package model;

import java.util.List;
//@JsonIgnoreProperties(ignoreUnknown = true)
public class PDFdocument {


    public String filename;
    public List<Page> page_data;


    @Override
    public String toString() {
        return "model.PDFdocument{" +
                "filename='" + filename + '\'' +
                ", page_data=" + page_data +
                '}';
    }
}
