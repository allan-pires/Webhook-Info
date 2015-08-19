/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developertask.controller;

import developertask.model.Container;
import developertask.model.Webhook;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author doisl_000
 */
public class WebhookControllerTest {

    /**
     * Test of CreateWebhooksFromFile method, of class WebhookController.
     * @throws java.lang.Exception
     */
    @Test(expected=FileNotFoundException.class)
    public void test_CreateWebhooksFromFile_ThrowsException_when_FileNotFound() throws Exception {
        String path = "";
        WebhookController instance = new WebhookController();
        instance.CreateWebhooksFromFile(path);
    }
    
    @Test
    public void test_CreateWebhooksFromFile_RunsNormally_When_Called() throws Exception {
        String path = new File(".").getCanonicalPath();
        path += "\\test\\developertask\\controller\\test_log.txt";
        WebhookController instance = new WebhookController();
        ArrayList<Webhook> expected = new ArrayList<>();
        expected.add(new Webhook("https://grotesquemoon.de" ,"201"));
        expected.add(new Webhook("https://woodenoyster.com.br" ,"500"));
        expected.add(new Webhook("https://grotesquemoon.de" ,"500"));
        expected.add(new Webhook("https://solidwindshield.net.br" ,"400"));
        expected.add(new Webhook("https://grimpottery.net.br" ,"400"));
        
        instance.CreateWebhooksFromFile(path);
        Assert.assertTrue(expected.equals(instance.getWebhooks()));
    }

    /**
     * Tests of CreateURLContainers method, of class WebhookController.
     */
    @Test
    public void test_CreateURLContainers_RunsNormally_When_Called() {
        WebhookController instance = new WebhookController();
        instance.getWebhooks().add(new Webhook("https://grotesquemoon.de" ,"201"));
        instance.getWebhooks().add(new Webhook("https://woodenoyster.com.br" ,"500"));
        instance.getWebhooks().add(new Webhook("https://grotesquemoon.de" ,"500"));
        instance.getWebhooks().add(new Webhook("https://solidwindshield.net.br" ,"400"));
        instance.getWebhooks().add(new Webhook("https://grimpottery.net.br" ,"400"));
        instance.CreateURLContainers();
        ArrayList<Container> result = new ArrayList<>();
        result.add(new Container("https://woodenoyster.com.br", 1));
        result.add(new Container("https://grotesquemoon.de", 2));
        result.add(new Container("https://solidwindshield.net.br", 1));
        result.add(new Container("https://grimpottery.net.br", 1));
        
        Assert.assertTrue(result.get(0).equals(instance.getContainers().get(0)));
        Assert.assertTrue(result.get(1).equals(instance.getContainers().get(1)));
        Assert.assertTrue(result.get(2).equals(instance.getContainers().get(2)));
        Assert.assertTrue(result.get(3).equals(instance.getContainers().get(3)));
    }

    /**
     * Test of CreateStatusContainers method, of class WebhookController.
     */
    @Test
    public void test_CreateStatusContainers_RunsNormally_When_Called() {
        WebhookController instance = new WebhookController();
        instance.getWebhooks().add(new Webhook("https://grotesquemoon.de" ,"201"));
        instance.getWebhooks().add(new Webhook("https://woodenoyster.com.br" ,"500"));
        instance.getWebhooks().add(new Webhook("https://grotesquemoon.de" ,"500"));
        instance.getWebhooks().add(new Webhook("https://solidwindshield.net.br" ,"400"));
        instance.getWebhooks().add(new Webhook("https://grimpottery.net.br" ,"400"));
        instance.CreateStatusContainers();
        ArrayList<Container> result = new ArrayList<>();
        result.add(new Container("201", 1));
        result.add(new Container("400", 2));
        result.add(new Container("500", 2));
        
        Assert.assertTrue(result.get(0).equals(instance.getContainers().get(0)));
        Assert.assertTrue(result.get(1).equals(instance.getContainers().get(1)));
        Assert.assertTrue(result.get(2).equals(instance.getContainers().get(2)));
    }

    /**
     * Tests of SortAndPrint method, of class WebhookController.
     */
    @Test
    public void test_SortAndPrint_SortURLsCorrectly_When_Called() {
        WebhookController instance = new WebhookController();
        instance.getWebhooks().add(new Webhook("https://grotesquemoon.de" ,"201"));
        instance.getWebhooks().add(new Webhook("https://woodenoyster.com.br" ,"500"));
        instance.getWebhooks().add(new Webhook("https://grotesquemoon.de" ,"500"));
        instance.getWebhooks().add(new Webhook("https://solidwindshield.net.br" ,"400"));
        instance.getWebhooks().add(new Webhook("https://grimpottery.net.br" ,"400"));
        instance.CreateURLContainers();
        ArrayList<Container> result = new ArrayList<>();
        result.add(new Container("https://grotesquemoon.de", 2));
        result.add(new Container("https://woodenoyster.com.br", 1));
        result.add(new Container("https://solidwindshield.net.br", 1));
        instance.SortAndPrint(3);
        
        Assert.assertTrue(result.get(0).equals(instance.getContainers().get(0)));
        Assert.assertTrue(result.get(1).equals(instance.getContainers().get(1)));
        Assert.assertTrue(result.get(2).equals(instance.getContainers().get(2)));
    }
    
    @Test
    public void test_SortAndPrint_SortStatusCorrectly_When_Called() {
        WebhookController instance = new WebhookController();
        instance.getWebhooks().add(new Webhook("https://grotesquemoon.de" ,"201"));
        instance.getWebhooks().add(new Webhook("https://woodenoyster.com.br" ,"500"));
        instance.getWebhooks().add(new Webhook("https://grotesquemoon.de" ,"500"));
        instance.getWebhooks().add(new Webhook("https://solidwindshield.net.br" ,"400"));
        instance.getWebhooks().add(new Webhook("https://grimpottery.net.br" ,"400"));
        instance.CreateStatusContainers();
        ArrayList<Container> result = new ArrayList<>();
        result.add(new Container("400", 2));
        result.add(new Container("500", 2));
        result.add(new Container("201", 1));
        instance.SortAndPrint(3);
        
        Assert.assertTrue(result.get(0).equals(instance.getContainers().get(0)));
        Assert.assertTrue(result.get(1).equals(instance.getContainers().get(1)));
        Assert.assertTrue(result.get(2).equals(instance.getContainers().get(2)));
    }
    
}

