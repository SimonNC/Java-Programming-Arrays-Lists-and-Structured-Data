
/**
 * Décrivez votre classe UniqueIPTester ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class UniqueIPTester {
    public void testUniqIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are " + uniqueIPs + "IPs");
        
    }
}
