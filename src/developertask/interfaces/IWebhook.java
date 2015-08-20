/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developertask.interfaces;

/**
 *
 * @author doisl_000
 */
public interface IWebhook {
    // Default getter
    public String GetResponse_status();
    
    // Default getter
    public String GetRequest_to();
    
    // Default setter
    public void SetResponse_status(String response_status);
    
    // Default setter
    public void SetRequest_to(String request_to);
    
    // Tries to create a Webhook object from a string
    public IWebhook ParseStringToWebhook(String log_line) throws Exception;
}
