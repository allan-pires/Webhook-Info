/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developertask.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeMap;

/**
 *
 * @author doisl_000
 */
public interface IWebhookController {
    
    // Populates the set webhooks from a .txt file. 
    public void CreateWebhooksFromFile(String path) throws FileNotFoundException, IOException, Exception;
    
    // Populates the containers with URLs and its frequency
    public void CreateURLMap();
    
    // Populates the containers with Status and its frequency
    public void CreateStatusMap();
    
    // Sort and print the [quantity] firts entries of the set (desc order)
    public void SortAndPrint(TreeMap<String, Integer> map, int quantity);
}
