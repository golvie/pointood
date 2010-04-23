package ee.ood.harjutus.observers;
//Source file: C:\\Program Files\\Java\\jdk1.6.0_18\\bin\\Vaadeldav.java


public class Vaadeldav extends Vaadeldav_Subject 
{
   private int subjectState;
   
   /**
    * @roseuid 4BCEC2EE0238
    */
   public Vaadeldav() {
	   
   }
   
   /**
    * @return int
    * @roseuid 4BCEC06D030D
    */
   public int getState() {
    return 0;
   }
   
   /**
    * @param state
    * @roseuid 4BCEC06D035B
    */
   public void setState(int state) {
	   notifyObservers();
   }
}
