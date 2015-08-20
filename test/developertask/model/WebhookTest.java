/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developertask.model;

import developertask.interfaces.IWebhook;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author doisl_000
 */
public class WebhookTest extends TestCase{
    
    /**
     * Tests of GetResponse_status method, of class Webhook.
     */
    @Test
    public void test_GetResponse_RunsNormally_When_Called() {
        System.out.println("GetResponse_status");
        IWebhook instance = new Webhook();
        String expResult = "";
        String result = instance.GetResponse_status();
        assertEquals(expResult, result);
    }
    
    @Test
    public void test_GetResponse_RunsNormally_When_Called2() {
        System.out.println("GetResponse_status");
        IWebhook instance = new Webhook("A", "B");
        String expResult = "B";
        String result = instance.GetResponse_status();
        assertEquals(expResult, result);
    }

    /**
     * Tests of SetResponse_status method, of class Webhook.
     */
    @Test
    public void test_SetResponse_RunsNormally_When_Called() {
        System.out.println("SetResponse_status");
        String response_status = "";
        IWebhook instance = new Webhook();
        instance.SetResponse_status(response_status);
        assertEquals(response_status, instance.GetResponse_status());
    }
    
    @Test
    public void test_SetResponse_RunsNormally_When_Called2() {
        System.out.println("SetResponse_status");
        String response_status = "lorem ipsum";
        IWebhook instance = new Webhook();
        instance.SetResponse_status(response_status);
        assertEquals(response_status, instance.GetResponse_status());
    }

    /**
     * Tests of GetRequest_to method, of class Webhook.
     */
    @Test
    public void test_GetRequest_RunsNormally_When_Called() {
        System.out.println("GetRequest_to");
        IWebhook instance = new Webhook();
        String expResult = "";
        String result = instance.GetRequest_to();
        assertEquals(expResult, result);
    }
    
    @Test
    public void test_GetRequest_RunsNormally_When_Called2() {
        System.out.println("GetRequest_to");
        IWebhook instance = new Webhook("A", "B");
        String expResult = "A";
        String result = instance.GetRequest_to();
        assertEquals(expResult, result);
    }

    /**
     * Tests of SetRequest_to method, of class Webhook.
     */
    @Test
    public void test_SetRequest_to_RunsNormally_When_Called(){
        System.out.println("SetRequest_to");
        String request_to = "";
        IWebhook instance = new Webhook();
        instance.SetRequest_to(request_to);
        assertEquals(request_to, instance.GetResponse_status());
    }
    
    @Test
    public void test_SetRequest_to_RunsNormally_When_Called2() {
        System.out.println("SetRequest_to");
        String request_to = "lorem ipsum";
        IWebhook instance = new Webhook();
        instance.SetRequest_to(request_to);
        assertEquals(request_to, instance.GetRequest_to());
    }

    /**
     * Test of ParseStringToWebhook method, of class Webhook.
     * @throws java.lang.Exception
     */
    @Test
    public void test_ParseStringToWebhook_RunsNormally_When_Called() throws Exception {
        System.out.println("ParseStringToWebhook");
        String log_line = "";
        IWebhook instance = new Webhook();
        IWebhook expResult = null;
        IWebhook result = instance.ParseStringToWebhook(log_line);
        assertEquals(expResult, result);
    }
    
    @Test
    public void test_ParseStringToWebhook_RunsNormally_When_Called2() throws Exception {
        System.out.println("ParseStringToWebhook");
        String log_line = "level=info response_body=\"\" request_to=\"https://grotesquemoon.de\" response_headers=map[Server:[nginx] X-Request-Id:[1381e8cb388db085cdc3bac457dab9bf] Date:[Tue, 07 Jul 2015 18:29:52 GMT] Content-Type:[text/html; charset=utf-8] X-Powered-By:[Phusion Passenger (mod_rails/mod_rack) 3.0.17] X-Rack-Cache:[invalidate, pass] X-Runtime:[0.034645] Connection:[keep-alive] Set-Cookie:[X-Mapping-fjhppofk=A67D55AC8119CAD031E35EC35B4BCFFD; path=/] Keep-Alive:[timeout=20] Cache-Control:[max-age=0, private, must-revalidate] Status:[200] Etag:[7215ee9c7d9dc229d2921a40e899ec5f] Vary:[Accept-Encoding] X-Ua-Compatible:[IE=Edge,chrome=1]] response_status=\"201\"";
        IWebhook instance = new Webhook();
        IWebhook expResult = new Webhook("https://grotesquemoon.de", "201");
        IWebhook result = instance.ParseStringToWebhook(log_line);
        assertEquals(expResult, result);
    }
    
    @Test
    public void test_ParseStringToWebhook_Fails_When_FileHasWrongPattern() throws Exception {
        System.out.println("ParseStringToWebhook");
        String log_line = "leel=nfo resbody=\"\" req123ue://gro1235tesquemoon.de\" response_heaSe123ver:[nginx] X-Request-Id:[1381e8cb388db085cdc3bac457dab9bf] Date:[Tue, 07 Jul 2015 18:29:52 GMT] Content-Type:[text/html; charset=utf-8] X-Powered-By:[Phusion Passenger (mod_rails/mod_rack) 3.0.17] X-Rack-Cache:[invalidate, pass] X-Runtime:[0.034645] Connection:[keep-alive] Set-Cookie:[X-Mapping-fjhppofk=A67D55AC8119CAD031E35EC35B4BCFFD; path=/] Keep-Alive:[timeout=20] Cache-Control:[max-age=0, private, must-revalidate] Status:[200] Etag:[7215ee9c7d9dc229d2921a40e899ec5f] Vary:[Accept-Encoding] X-Ua-Compatible:[IE=Edge,chrome=1]] response_status=\"201\"";
        IWebhook instance = new Webhook();
        IWebhook expResult = new Webhook("https://grotesquemoon.de", "201");
        IWebhook result = instance.ParseStringToWebhook(log_line);
        Assert.assertNotSame(expResult, result);
    }

    /**
     * Test of equals method, of class Webhook.
     */
    @Test
    public void test_Equals_RunsNormally_When_Called() {
        System.out.println("equals");
        Object o = new Webhook("A", "B");
        IWebhook instance = new Webhook("C", "D");
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void test_Equals_RunsNormally_When_Called2() {
        System.out.println("equals");
        Object o = new Webhook("A", "B");
        IWebhook instance = new Webhook("A", "B");
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
}
