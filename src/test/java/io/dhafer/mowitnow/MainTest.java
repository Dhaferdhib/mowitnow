package io.dhafer.mowitnow;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void assertFileExist() throws IOException {
        URL url = this.getClass().getResource("/test");
        File file = new File(url.getFile());
        Main main = new Main();
        main.resolveMower(file);
    }
}
