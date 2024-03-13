
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("short-test_log");
        LogAnalyzer.printAll();
    }
      public void testprintAllHigherthanNum() {
        LogAnalyzer MyLogAnalyser = new LogAnalyzer();
        MyLogAnalyser.readFile("weblog1_log");
        MyLogAnalyser.printAllHigherThanNum(400);
    }
        public void testUniqueIPVisitsOnDay(){
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog2_log");
        read.countUniqueIPs();
        ArrayList a = read.uniqueIPVisitsOnDay("Sep 24");
        System.out.println(a.size());
    }
        public void testCountUniqueIPsInRange(){
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog2_log");
        System.out.println(read.countUniqueIPsInRange(200,299));
    }
        public void testCountVisitsPerIP(){
            LogAnalyzer read = new LogAnalyzer();
            read.readFile("short-test_log");
            HashMap<String,Integer> counts = read.countVisitsPerIP();
            System.out.println(counts); 
        
    }
    public void testMostNumberVisitsByIP(){
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog2_log");
        HashMap<String,Integer> counts = read.countVisitsPerIP();
         System.out.println(counts);
        System.out.println("The ip with more visits visited the site " + read.mostNumberVisitsByIP(counts)+ " times.");
    }
    public void testIPsMostVisits(){
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog3-short_log");
        HashMap<String,Integer> counts = read.countVisitsPerIP();
        System.out.print("These are the ip's with more visits: ");
        System.out.println(read.iPsMostVisits(counts));
    }
    public void testIPsForDays(){
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog3-short_log");
        HashMap<String,ArrayList<String>> daysIps = read.ipsForDays();
        System.out.println(daysIps);
    }
    public void testDayWithMostIPVisits(){
        String dayMostIP;
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog2_log");
        System.out.println("\nDay with most visits: " + read.dayWithMostIPVisits(read.ipsForDays()));
        
    }
       public void testIpsWithMostVisitsOnDay(){
        String dayMostIP;
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> datesIpMap = read.dayCountHash();
        System.out.println(read.iPsWithMostVisitsOnDay(datesIpMap, "Sep 29"));
        
    }
    
    
}
