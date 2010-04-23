/**
 * 
 */
package ee.ood.yl5;

/**
 * @author Jaroslav Judin
 * Apr 23, 2010
 */
public class AlarmVaatleja implements Vaatleja {

	@Override
	public void update(Object o) {
		if (o.equals("alarm")) {
			System.out.println("AlarmObserver :" + o.toString());
		}
	}

}
