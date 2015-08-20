/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developertask;

import developertask.controller.WebhookController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author doisl_000
 */
public class DeveloperTask 
{ 
    // Reads the input
    public static String ReadInput() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the path of the file:\n");
        String s = br.readLine();
        return s;
    }
    
    // Shows the three most called URLs and all the webhook status ordered by frequency
    public static void DefaultAction(String file) throws Exception
    {
        WebhookController whc = new WebhookController();
        
        // Read the file and create the Webhook objects
        whc.CreateWebhooksFromFile(file);
        
        // Create the maps of URL and Status
        whc.CreateURLMap();
        whc.CreateStatusMap();
        
        // Sort and print the maps
        whc.SortAndPrint(whc.getUrlMap(), 3);
        whc.SortAndPrint(whc.getStatusMap(), 0);
    }
    
    // Main method
    public static void main(String[] args) throws Exception 
    {   
        try
        {
            String path = ReadInput();
            DefaultAction(path); 
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.toString());
        }
    }
    
}
