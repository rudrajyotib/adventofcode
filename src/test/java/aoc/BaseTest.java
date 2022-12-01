package aoc;

import java.net.URL;

public class BaseTest {

    public String generateCanonicalPathForResourceFile(String fileName){
        URL resource = this.getClass().getClassLoader().getResource(fileName);
        assert resource != null;
        return resource.getFile();
    }

}
