/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developertask.controller;

import developertask.interfaces.IWebhook;
import developertask.interfaces.IWebhookController;
import developertask.model.Webhook;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author doisl_000
 */
public class WebhookController implements IWebhookController 
{
    // Attributes
    private ArrayList<IWebhook> _webhooks;
    private TreeMap<String, Integer> _urlMap;
    private TreeMap<String, Integer> _statusMap;
    
    // Default constructor
    public WebhookController() 
    {
        this._webhooks = new ArrayList<>();
        this._urlMap = new TreeMap<>();
        this._statusMap = new TreeMap<>();
    }
    
    // Default getter
    @Override
    public ArrayList<IWebhook> getWebhooks() {
        return this._webhooks;
    }

    // Default setter
    @Override
    public TreeMap<String, Integer>  getUrlMap() {
        return this._urlMap;
    }
    
    // Default setter
    @Override
    public TreeMap<String, Integer>  getStatusMap() {
        return this._statusMap;
    }

    // Populates the set webhooks from a .txt file. 
    @Override
    public void CreateWebhooksFromFile(String path) throws FileNotFoundException, IOException, Exception
    {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            ArrayList<IWebhook> wh_array = new ArrayList<>();
            
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
    public void CreateURLMap() 
    {
        // Populates the HashMap with every webhook and its frequency
        for(int i = 0; i < this._webhooks.size(); i++){
           String url = this._webhooks.get(i).GetRequest_to();
           Integer val = this._urlMap.get(url);
           
           if(val != null)
           {
                this._urlMap.put(url, new Integer(val + 1));
           }
           else{
                this._urlMap.put(url,1);
           }
        }
    }
    
    // Populates the containers with Status and its frequency
    @Override
    public void CreateStatusMap()
    {
        // Populates the HashMap with every webhook and its frequency
        for(int i = 0; i < this._webhooks.size(); i++){
           String status = this._webhooks.get(i).GetResponse_status();
           Integer val = this._statusMap.get(status);
           
           if(val != null)
           {
                this._statusMap.put(status, new Integer(val + 1));
           }
           else{
                this._statusMap.put(status,1);
           }
        }
    }
    
    //Sorts the TreeMap based on values
    public static <Key, Value extends Comparable<Value>> Map<Key, Value> sortByValues(final Map<Key, Value> map) {
        Comparator<Key> valueComparator = (Key k1, Key k2) -> {
            int compare = map.get(k1).compareTo(map.get(k2));
            if (compare == 0)
            {
                return 1;
            }
            else
            {
                return compare;
            }
        };

        Map<Key, Value> sortedByValues = new TreeMap<>(valueComparator.reversed());
        sortedByValues.putAll(map);
        
        return sortedByValues;
    }
    
    // Sort and print the [quantity] firts entries of the set (desc order)
    @Override
    public void SortAndPrint(TreeMap<String, Integer> map, int quantity)
    {
        Map sortedMap = sortByValues(map);
        Set set = sortedMap.entrySet();
 
        // Get an iterator
        Iterator i = set.iterator();
        if (quantity == 0)
        {
            quantity = map.size();
        }
        
        // Display elements
        while(i.hasNext() && quantity > 0) {
            Map.Entry entry = (Map.Entry)i.next();
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey());
            sb.append(" - ");
            sb.append(entry.getValue());
            System.out.println(sb.toString());
            quantity--;
        }

        System.out.println();
    }

}
