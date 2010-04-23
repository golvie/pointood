/**
 * 
 */
package ee.ood.yl5;

/**
 * @author Jaroslav Judin
 * Apr 23, 2010
 */
public class Main {

	public static void main(String[] args) {
		Poordvarav p = new Poordvarav();
		Vaatleja v = new AlarmVaatleja();
		p.lisa(v);
		p.munt();
		p.moodu();
		p.moodu();
		p.munt();
		p.moodu();
	}

}
