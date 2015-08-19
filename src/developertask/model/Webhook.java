/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developertask.model;

import developertask.interfaces.IWebhook;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author doisl_000
 */
// This class contains information about payments
public class Webhook implements IWebhook {

    // Attributes
    private String _request_to;
    private String _response_status;

    // Default constructors
    public Webhook() 
    {
        this._request_to = "";
        this._response_status = "";
    }

    public Webhook(String request_to, String response_status) 
    {
        this._request_to = request_to;
        this._response_status = response_status;
    }

    // Default get of response_status
    public String GetResponse_status() 
    {
        return this._response_status;
    }

    // Default set of response_status
    public void SetResponse_status(String response_status) 
    {
        this._response_status = response_status;
    }

    // Default get of request_to
    public String GetRequest_to() 
    {
        return this._request_to;
    }

    // Default set of request_to
    public void SetRequest_to(String request_to) 
    {
        this._request_to = request_to;
    }

    @Override
    public Webhook ParseStringToWebhook(String log_line) throws Exception 
    {
        StringBuilder sb = new StringBuilder();

        // Regex of a Webhook
        sb.insert(0, "level=info response_body=\"\" request_to=\"(.*?)\" response_headers=map\\[.*?response_status=\"([0-9]*)\"");

        try 
        {
            Matcher m = Pattern.compile(sb.toString()).matcher(log_line);
            
            if (m.matches()) 
            {
                Webhook wh = new Webhook(m.group(1), m.group(2));
                return wh;
            }
            else
            {
                System.out.println("Error while matching pattern");
            }
        }
        catch (Exception ex) 
        {
            throw ex;
        }
        
        return null;
    }

    // Comparator override
    @Override
    public boolean equals(Object o) 
    {
        if (o instanceof Webhook) 
        {
            Webhook toCompare = (Webhook) o;
            return this._request_to.equals(toCompare._request_to) && this._response_status.equals(toCompare._response_status);
        }
        return false;
    }

    // Comparator override
    @Override
    public int hashCode() 
    {
        return this._response_status.hashCode();
    }
}
