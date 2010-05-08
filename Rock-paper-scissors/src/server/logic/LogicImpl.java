package server.logic;

import java.util.ArrayList;
import java.util.List;
/**
 * Implemented class for game logic
 * @author V&N
 * @version May 8, 2010
 */
@SuppressWarnings("serial")
public class LogicImpl implements Logic {
    
	private List<String> moves;
	
	final static int PLAYER_ONE = 1;
	final static int PLAYER_TWO = 2;
	final static int TIE	   = -1;
	
	private int wins_player_one=0;
	private int wins_player_two=0;
	
	public LogicImpl() {
		moves = new ArrayList<String>();
	}

	//test
	public static void main(String[] args) {
		Logic logic = new LogicImpl();
		String[] name = {null, "one", "two"};
		logic.move("Paper");
		System.out.println(logic.getGameResult( name));
		logic.move("Paper");
		System.out.println(logic.getGameResult( name));
		logic.move("Scissors");
		logic.move("Scissors");
		//logic.move("Scissors");
		//logic.move("Paper");
		System.out.println( logic.getGameStatus() );
		
		System.out.println(logic.getGameResult( name));
		
		String str = "=> GAME OVER";
		System.out.println(str.substring(str.length()-9, str.length()));
	}
	
	@Override
	public void move(String choice) {
		moves.add( choice );
		updateGameStatus();
	}

	@Override
	public void reset() {
		moves.clear();
		wins_player_one=0;
		wins_player_two=0;
	}
	
	@Override
	public int getGameStatus() {
		
		if (!roundComplited())
			return 0;
		else if (wins_player_one > wins_player_two)
			return PLAYER_ONE;
		else if (wins_player_one < wins_player_two)
			return PLAYER_TWO;
		else
			return TIE;
	}
	
	public String getGameResult(String[] name) {
		return "Result ["+name[PLAYER_ONE]+" "+wins_player_one
				+":"+wins_player_two+" "+name[PLAYER_TWO]+"]";
	}
	
	public void updateGameStatus() {
		if (roundComplited()) {
			int last =  moves.size()-1;
			int check = checkWin(moves.get(last-1), moves.get(last));
			if (check == PLAYER_ONE)
				wins_player_one++;
			else if (check == PLAYER_TWO)
				wins_player_two++;
		}
	}
	
	private int checkWin(String first, String second) {
		if (first.equals(second))
			return TIE;
		else if (first.equals("Rock") && second.equals("Scissors")
			|| first.equals("Scissors") && second.equals("Paper")
				|| first.equals("Paper") && second.equals("Rock"))
			return PLAYER_ONE;
		else
			return PLAYER_TWO;
	}
 
	public boolean roundComplited() {
		return (moves.size() > 1 
				&& moves.size()%2 == 0)
						? true
						: false;
	}
	
	public boolean isNotStarted() {
		if (moves.size() == 0)
			return true;
		else
			return false;
	}
	
	public boolean isEnded() {
		if ((wins_player_one > 1 || wins_player_two > 1) 
			&& moves.size() > 5)
			return true;
		else
			return false;
	}
}
