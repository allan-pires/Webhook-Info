/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developertask.controller;

import developertask.interfaces.IWebhookController;
import developertask.model.Container;
import developertask.model.Webhook;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author doisl_000
 */
public class WebhookController implements IWebhookController 
{
    // Attributes
    private ArrayList<Webhook> _webhooks;
    private ArrayList<Container> _containers;
    
    // Default constructor
    public WebhookController() 
    {
        this._webhooks = new ArrayList<>();
        this._containers = new ArrayList<>();
    }
    
    // Default getter
    public ArrayList<Webhook> getWebhooks() {
        return this._webhooks;
    }

    // Default setter
    public ArrayList<Container> getContainers() {
        return this._containers;
    }

    // Populates the set webhooks from a .txt file. 
    @Override
    public void CreateWebhooksFromFile(String path) throws FileNotFoundException, IOException, Exception
    {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            ArrayList<Webhook> wh_array = new ArrayList<>();
            
            while (line != null) 
            {
                sb.append(line);
                
                Webhook hook = new Webhook();
                hook = hook.ParseStringToWebhook(line);
                wh_array.add(hook);
                
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            
            this._webhooks = wh_array;
        }
    }

    // Populates the containers with URLs and its frequency
    @Override
    public void CreateURLContainers() 
    {
        // Will store URLs and Frequency (not sorted)
        HashMap<String,Integer> map = new HashMap<>();
        
        // Populates the HashMap with every webhook and its frequency
        for(int i = 0; i < _webhooks.size(); i++){
           String url = _webhooks.get(i).GetRequest_to();
           Integer val = map.get(url);
           
           if(val != null)
           {
                map.put(url, new Integer(val + 1));
           }
           else{
                map.put(url,1);
           }
        }
        
        // Populates containers with values from the HashMap
        this._containers.clear();
        for(Entry<String, Integer> entry : map.entrySet()) {
            this._containers.add(new Container(entry.getKey(), entry.getValue()));
        }
    }
    
    // Populates the containers with Status and its frequency
    @Override
    public void CreateStatusContainers()
    {
        // Will store URLs and Frequency (not sorted)
        HashMap<String,Integer> map = new HashMap<>();
        
        // Populates the HashMap with every webhook and its frequency
        for(int i = 0; i < _webhooks.size(); i++){
           String status = _webhooks.get(i).GetResponse_status();
           Integer val = map.get(status);
           
           if(val != null)
           {
                map.put(status, new Integer(val + 1));
           }
           else{
                map.put(status,1);
           }
        }
        
        // Populates containers with values from the HashMap
        this._containers.clear();
        for(Entry<String, Integer> entry : map.entrySet()) {
            this._containers.add(new Container(entry.getKey(), entry.getValue()));
        }
    }
    
    // Sort and print the [quantity] firts containers (desc order)
    @Override
    public void SortAndPrint(int quantity)
    {
        if (!this._containers.isEmpty())
        {
            this._containers.sort(new Container().reversed());
            
            if (quantity == 0)
            {
                quantity = this._containers.size();
            }
            
            for (int i = 0; i < quantity; i++)
            {
                this._containers.get(i).print();
            }
            
            System.out.println();
        }
    }
}
