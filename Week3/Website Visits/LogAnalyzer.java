
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (Simon JORITE) 
 * @version (1.0)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     private ArrayList<String> maxDate;
     private ArrayList<Integer> myFreqs;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
         maxDate = new ArrayList<String>();
         myFreqs = new ArrayList<Integer>();
         
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource resource = new FileResource(filename);
         for(String line: resource.lines()){
             
             records.add(WebLogParser.parseEntry(line));
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
         public int findMax(){
    int theMax = myFreqs.get(0);
    int maxIndex = 0;
    for(int k=0; k < myFreqs.size(); k++){
        if (myFreqs.get(k) > theMax){
          theMax = myFreqs.get(k);
          maxIndex = k;
        }
    }
    return maxIndex;
    }
     
     public int countUniqueIPs(){
         // uniqueIPs starts as an empty list 
         ArrayList<String> uniqueIPs = new ArrayList<String>();
        // for each element le in records
        for(LogEntry le: records){
            String ipAddr = le.getIpAddress();
            //if ipAddr is not in uniqueIPs
            if(!uniqueIPs.contains(ipAddr)){
                //Add ipAddr to uniqueIPs
                uniqueIPs.add(ipAddr);
            }
        }
        
          
         return uniqueIPs.size();
     }
     
     public void printAllHigherThanNum(int num){
         for(LogEntry le: records){
             int statusCode = le.getStatusCode();
             if(statusCode > num) {
                 System.out.println("StatusCode greater than "+num+": "+statusCode);
             }
         }
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> uniqueIPs = new ArrayList<String>(); 
         ArrayList<String> uniqueIPsDates = new ArrayList<String>(); 
         for (LogEntry le : records){
             Date d = le.getAccessTime();
             String str = d.toString();
             String subStr = str.substring(4,10); 
             String ipAddr = le.getIpAddress();
             if(subStr.equals(someday) && !uniqueIPs.contains(ipAddr)){
                 uniqueIPs.add(ipAddr);
                 uniqueIPsDates.add(subStr);
                 //it works
             }
        }
         return uniqueIPs;
     }
          
     public int countUniqueIPsInRange(int low, int high){
        // uniqueIPs starts as an empty list
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry New: records) {
        // Status code in LogEntrys
        int statusCode = New.getStatusCode();
        String ipAddr = New.getIpAddress();
        //if StatusCode greater than Num
            if((statusCode >= low) && (statusCode <= high)) {
                if(!uniqueIPs.contains(ipAddr)) {
                //add ipAddr to uniqueIps
                uniqueIPs.add(ipAddr);
                }
            }
        }
        return uniqueIPs.size();
     }
     
     public HashMap countVisitsPerIP(){
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        for(LogEntry le: records){
            String ip = le.getIpAddress();
            if(!counts.containsKey(ip)){
                counts.put(ip,1);
            }
            else {
                counts.put(ip,counts.get(ip)+1);
            }
        }
        return counts;
    }
    
    public int mostNumberVisitsByIP(HashMap<String,Integer> counts){
        int index = 0;
        for(int num : counts.values()){
            if(index < num){
                index = num;
            }
        }
        return index;
    }
    
    public ArrayList iPsMostVisits(HashMap<String,Integer> counts){
         ArrayList<String> maxIPs = new ArrayList<String>();
         int index = mostNumberVisitsByIP(counts);
         for(String s :counts.keySet()){
             if(counts.get(s) == index){
                 maxIPs.add(s);
             }
         }
         return maxIPs;
    }
    
          public HashMap<String, ArrayList<String>> ipsForDays() {
    HashMap<String, ArrayList<String>> days = new HashMap<>();
    for (LogEntry le : records) {
      String date = le.getAccessTime().toString().substring(4, 10);
      if (days.containsKey(date)) {
        days.get(date).add(le.getIpAddress());
      } else {
        ArrayList<String> ips = new ArrayList<>();
        ips.add(le.getIpAddress());
        days.put(date, ips);
      }
    }
    return days;
  }
    
          public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> days) {
    int max = 0;
    String day = "";
    for (String d : days.keySet()) {
      if (days.get(d).size() > max) {
        max = days.get(d).size();
        day = d;
      }
    }
    return day;
  }
   public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String day){
        /*This method takes the hashmap from dayCountHash() method, iterates over the keys
         * and if the key is the string we insert in the tester method, it returns the arraylist
         * of ips that visited the site that day. 
         */
        System.out.println("The " + day + ", this IPs visited our website: ");
        for (String s: map.keySet()){
            if (s.contains(day)){
                return map.get(s);
            }
        }
        return null;
    } 
    
        public HashMap<String, ArrayList<String>> dayCountHash(){
        /*This hashmap will be use for the following two methods, so it is important to
         * develop it separately:*/
         HashMap<String,ArrayList<String>> datesIpMap = new HashMap<String,ArrayList<String>>();
        for(LogEntry le: records){
            ArrayList<String>ipArray = new ArrayList<String>();
            String ip = le.getIpAddress();
            Date d = le.getAccessTime();
            String str = d.toString();
            String dateStr = str.substring(4,10); 
            if(!datesIpMap.containsKey(dateStr)){
                ipArray.add(ip);
                datesIpMap.put(dateStr,ipArray);
            }
            else{
                ipArray = datesIpMap.get(dateStr);
                if (!ipArray.contains(ip)){
                    ipArray.add(ip);
                }
            }
        }
        return datesIpMap;
    }

     
     
     
     
}
