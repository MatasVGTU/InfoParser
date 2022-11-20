package model;

import java.util.List;

public class Page {

    public int page;
    public String image_url;
    public PageSize size;
    public List<Word> words;
    public String raw_text;

//    public model.Page(int page, String url, String raw_data) {
//        this.page = page;
//        this.image_url = url;
//        this.raw_text = raw_data;
//    }


    @Override
    public String toString() {
        return "model.Page{" +
                "page=" + page +
                ", image_url='" + image_url + '\'' +
                ", size=" + size +
                ", words=" + words +
                ", raw_text='" + raw_text + '\'' +
                '}';
    }
}
