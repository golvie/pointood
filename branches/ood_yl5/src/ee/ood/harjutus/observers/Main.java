package ee.ood.harjutus.observers;
/**
 * 
 */

/**
 * @author Jaroslav Judin
 * Apr 21, 2010
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vaadeldav v = new Vaadeldav();
		v.attach(new Vaadeldav_ConcreteObserver_A());
		v.attach(new Vaadeldav_ConcreteObserver_A());
		v.attach( new ObserverB());
		v.setState(8);

	}

}
