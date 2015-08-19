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
    // Create a Webhook object from a string
    public IWebhook ParseStringToWebhook(String log_line) throws Exception;
}
