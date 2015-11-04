import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        InputStream stream = HelloWorld.class.getClassLoader().getResourceAsStream("build.properties");
        props.load(stream);
        stream.close();

        System.out.println("This is MyApplication v" + props.get("build.version"));
        System.out.println("This app was built on " + props.get("build.date"));
    }

}
