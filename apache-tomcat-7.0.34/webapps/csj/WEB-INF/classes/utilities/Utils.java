package utilities;

import beans.CustomerInformation;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Utils {

    public static String getTVPlan(String planID){
        String plan = "";
        if(planID.equals("basic")){
            plan = "Basic Internet/Cable TV $50/mo";
        }else if(planID.equals("medium")){
            plan = "Internet/Cable TV $75/mo";
        }else if(planID.equals("elite")){
            plan = "Elite Internet/Cable TV $100/mo";
        }
        
        return plan;
    }

    public static String getPPVEvent(String ppvID){
        String event = "";
        if(ppvID.equals("starwars")){
            event = "Star Wars XX - The big fight";
        }else if(ppvID.equals("boxing")){
            event = "Boxing - Pacquiao VS Mayweather #4";
        }
        return event;
    }
    
        public static boolean store(String fileName, HashMap map) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
    public  static HashMap read(String fileName){
        HashMap map;
        try {
            FileInputStream fos = new FileInputStream(fileName);
            ObjectInputStream oos = new ObjectInputStream(fos);
            
            map = (HashMap)oos.readObject();
            System.out.println(map);
            oos.close();
            fos.close();
        } catch (Exception ex) {
            return null;
        }
        return map;
        
    }
}
