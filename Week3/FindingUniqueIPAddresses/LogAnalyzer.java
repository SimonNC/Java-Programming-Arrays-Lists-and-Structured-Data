
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
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
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
     
     
}
