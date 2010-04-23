package ee.ood.harjutus.observers;
import java.util.ArrayList;
import java.util.List;

//Source file: C:\\Program Files\\Java\\jdk1.6.0_18\\bin\\Vaadeldav_Subject.java


public abstract class Vaadeldav_Subject {
   private List<Vaadeldav_Observer> observers;
   
   /**
    * @roseuid 4BCEC2EE03AE
    */
   public Vaadeldav_Subject() {
	   observers = new ArrayList<Vaadeldav_Observer>();
   }
   
   /**
    * @param observer
    * @roseuid 4BCEC06D004E
    */
   public void attach(Vaadeldav_Observer observer) {
	   observers.add(observer);
   }
   
   /**
    * @param observer
    * @roseuid 4BCEC06D00AB
    */
   public void dettach(Vaadeldav_Observer observer) {
	   observers.remove(observer);
   }
   
   /**
    * @roseuid 4BCEC06D00EA
    */
   public void notifyObservers() {
	    for (Vaadeldav_Observer o : observers) {
	    	o.update();
	    }
   }
   
   /**
    * @return int
    * @roseuid 4BCEC06D00EB
    */
   public abstract int getState();
   
   /**
    * @param state
    * @roseuid 4BCEC06D00FA
    */
   public abstract void setState(int state);
}
