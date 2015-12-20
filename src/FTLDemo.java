/**
 * Created by 908752 on 12/20/15.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FTLDemo {

    public static void main(String[] args) {

        //Freemarker configuration object
        Configuration cfg = new Configuration();
        try {

            File dir = new File("../FreemarkerExample/src");
            System.out.println(dir.getAbsolutePath());
            cfg.setDirectoryForTemplateLoading(dir);
            //Load template from source folder
            Template template = cfg.getTemplate("helloworld.ftl");

            // Build the data-model
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("message", "Hello World!");

            //List parsing
            List<String> countries = new ArrayList<String>();
            countries.add("India");
            countries.add("United States");
            countries.add("Germany");
            countries.add("France");

            data.put("countries", countries);


            // Console output
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

            // File output
            Writer file = new FileWriter (new File("../Freemarkerexample/src/FTL_helloworld.txt"));
            template.process(data, file);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}