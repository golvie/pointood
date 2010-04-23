package ee.ood.yl5;

public class SuletudOlek implements PoordavaravaOlek {
	
	public SuletudOlek() { }

	@Override
	public void moodu(Poordvarav p) {
		p.alarm();
	}

	@Override
	public void munt(Poordvarav p) {
		p.maaraAvatuks();
	}
}
