import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class StandingsGUI extends JComponent implements GPI{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2348302214657245284L;
	JTextField place1 = new JTextField("1: ",15);
	JTextField place2 = new JTextField("2: ",15);
	JTextField place3 = new JTextField("3: ",15);
	JTextField place4 = new JTextField("4: ",15);
	JTextField place5 = new JTextField("5: ",15);
	JTextField place6 = new JTextField("6: ",15);
	JTextField place7 = new JTextField("7: ",15);
	JTextField place8 = new JTextField("8: ",15);
	
	JButton nextRound = new JButton("Proceed to next Round");
	
	private ArrayList<JTextField> textfields = new ArrayList<JTextField>();
	private JPanel items = new JPanel();
	private String nextTitle;

	public StandingsGUI(int round, ArrayList<Player> players){
		this.nextTitle = ("Round "+(round+1)+ " Pairings");
		
		textfields.add(place1);
		textfields.add(place2);
		textfields.add(place3);
		textfields.add(place4);
		textfields.add(place5);
		textfields.add(place6);
		textfields.add(place7);
		textfields.add(place8);
		
		
		for(int i = 0; i < players.size(); i++){
			textfields.get(i).setText((i+1)+": "+players.get(i).toString());
		}
		for(JTextField j: textfields){
			j.setBorder( null );
			j.setOpaque( false );
			j.setEditable( false );
			j.setFocusable( false );
			j.setFont(Draws.f);
		}
		
		JPanel places = new JPanel();
		places.add(place1);
		places.add(place2);
		places.add(place3);
		places.add(place4);
		places.add(place5);
		places.add(place6);
		places.add(place7);
		places.add(place8);
		
		places.setLayout(new BoxLayout(places,BoxLayout.Y_AXIS));
		if(Draws.round != Draws.numRounds){
			places.add(nextRound);
			nextRound.setFont(Draws.f);
			nextRound.addActionListener(new NextButtonListener());
		}
		items.add(places);
		this.setVisible(true);
	}
	
	public JPanel getPanel(){
		return items;
	}
	
	private class NextButtonListener implements ActionListener{
		
		public void actionPerformed (ActionEvent event){
			Draws.addTab(nextTitle,((GPI)Draws.setDraftState(Draws.ROUND_PAIRINGS)).getPanel());
		}
	}
	
}