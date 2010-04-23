package ee.ood.yl5;

import java.util.ArrayList;
import java.util.List;


public class Poordvarav {
   
	public PoordavaravaOlek thePoordavaravaOlek = new SuletudOlek();
   
	public List<Vaatleja> vaatlejad = new ArrayList<Vaatleja>();

	public void munt() {
	   thePoordavaravaOlek.munt(this);
	}

	public void moodu() {
		thePoordavaravaOlek.moodu(this);
	}
   

	public void lukusta() {
		System.out.println("Suletud");
	}
   
	public void ava() {
		System.out.println("Avatud");
	}
   

	public void tana() {
		System.out.println("Aitäh, et kasutate meie pöördvärav :)");
	}

	public void alarm() {
		System.out.println("Alarm!!!");
		teavita("alarm");
	}
   
	public void maaraAvatuks() {
		thePoordavaravaOlek = new AvatudOlek();
		this.ava();
		thePoordavaravaOlek.munt(this);
	}
   
	public void maaraSuletuks() {
		thePoordavaravaOlek = new SuletudOlek();
		this.lukusta();
	}
	
	public void lisa(Vaatleja v) {
		vaatlejad.add(v);
	}
	
	public void eemalda(Vaatleja v) {
		vaatlejad.remove(v);
	}
	
	public void teavita(Object o) {
		for (Vaatleja v : vaatlejad) {
			v.update(o);
		}
	}
}
