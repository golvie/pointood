package ee.ood.yl5;

public class AvatudOlek implements PoordavaravaOlek {
		
	public AvatudOlek() {  }


	@Override
	public void moodu(Poordvarav p) {
		p.maaraSuletuks();
	}

	@Override
	public void munt(Poordvarav p) {
		p.tana();
	}
}
