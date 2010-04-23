package ee.ood.harjutus.observers;
//Source file: C:\\Program Files\\Java\\jdk1.6.0_18\\bin\\Vaadeldav_ConcreteObserver_A.java


public class Vaadeldav_ConcreteObserver_A implements Vaadeldav_Observer {
   private int observerState;
   private Vaadeldav_Subject subject;
   
   /**
    * @roseuid 4BCEC2EE0322
    */
   public Vaadeldav_ConcreteObserver_A() {
	   
   }
   
   /**
    * @roseuid 4BCEC06E00AB
    */
   public void update() {
	   System.out.println("Welcome, vaatleja_A !! ");
   }
}
