package com.browserstack;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BStackLocalTest extends BrowserStackJUnitTest {

    @Test
    public void test() {
        driver.get("http://bs-local.com:45454/");
        assertTrue("Local content not validated!", driver.getTitle().contains("BrowserStack Local"));

    }
}
