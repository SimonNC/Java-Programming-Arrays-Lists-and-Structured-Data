
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
        read.readFile("short-test_log");
        System.out.println(read.countUniqueIPsInRange(200,299));
    }
}
