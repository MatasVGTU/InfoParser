import model.PDFdocument;
import model.Page;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class LinkDownloader {

    public void downloadFile(String fileLink, String oppath){

        try{
            URL link = new URL(fileLink);
            InputStream ins = link.openStream();
            ReadableByteChannel chh = Channels.newChannel(link.openStream());
            FileOutputStream fos = new FileOutputStream(new File(oppath));
            fos.getChannel().transferFrom(chh, 0, Long.MAX_VALUE);
            fos.close();
            chh.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }

    }

    public void downloadAll(PDFdocument pdFdocument){
        for (Page page: pdFdocument.page_data){
            String filename = "C:\\Workspace\\U\\InfoParser\\InfoParser\\src\\Downloads\\page" + String.valueOf(page.page+1) + ".jpg";
            String url = page.image_url;
            downloadFile(url, filename);
        }
    }


}
