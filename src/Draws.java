import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
public class Draws extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4873327270682879972L;
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<Match> matches = new ArrayList<Match>();
	
	private static int state = 0;
	
	public final static int DRAFT_SEATING = 0;
	public final static int ROUND_PAIRINGS = 1;
	public final static int ROUND_STANDINGS = 2;
	
	public static JTabbedPane tabbedPane;
	
	public static int round = 0;
	public static int numRounds = 0;
	public static int numTables = 0;
	public static int numPlayers = 0;
	
	public static Font f = new Font("Trebuchet MS", 0, 50);
	
	public static void main(String[] args){
		new Draws();
		
	}
	
	public Draws(){
		
		/* Get number of Players */
		numPlayers = Integer.parseInt(JOptionPane.showInputDialog("Number of Players:"));
		/* Get player names */
		for(int i = 1; i <= numPlayers; i++){
			players.add(new Player(JOptionPane.showInputDialog("Player " + i + " Name:")));
		}
		
		
		/* Used in testing */
		//numPlayers = 6;
		//players.add(new Player("Alex"));
		//players.add(new Player("Ben"));
		//players.add(new Player("George"));
		//players.add(new Player("Ming"));
		//players.add(new Player("Tyson"));
		//players.add(new Player("Joseph"));
		
		/* Randomise seat order */
		Collections.shuffle(players);
		
		/* Calculate number of rounds and tables */
		numRounds = (int)Math.ceil(Math.log(numPlayers+1)/Math.log(2.0));
		numTables = numPlayers/2;
		
		/* Draft Seating GUI */
		JComponent j = setDraftState(DRAFT_SEATING);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Draft Seating",((GPI)j).getPanel());
		this.setSize(1440,900);
		this.setContentPane(tabbedPane);
		this.setVisible(true);
	}
	
	public static JComponent setDraftState(int newstate){
		state = newstate;
		switch(state){
				
			case DRAFT_SEATING:
				return new DraftSeatingGUI(players);
			case ROUND_PAIRINGS:
				/* First round random pairings */
				if(round==0){
					Collections.shuffle(players);
				}
				round++;
				
				
				/* Swiss Pairings */
				int[] order = SwissPairings.pair(players);
				Player bye = null;
				
				for(int i = 0; i < numTables; i++){
					matches.add(new Match(players.get(order[2*i]),players.get(order[2*i+1])));

				}
				if(numPlayers %2 != 0 ){
					bye = players.get(order[numPlayers - 1]);
					bye.bye();
				}
				
				
				/* Pairings GUI */
				return new PairingsGUI(round,matches,bye);
			case ROUND_STANDINGS:
				/* Sort players by score */
				Collections.sort(players);
				
				/* Standings GUI */
				matches.clear();
				return new StandingsGUI(round,players);
			default:
				return null;
		}
	}
	
	public static void addTab(String n, JComponent j){
		tabbedPane.addTab(n,j);
		tabbedPane.setSelectedComponent(j);
	}
	
	public static int getDraftState(){
		return state;
	}
}