import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class DraftSeatingGUI extends JComponent implements GPI{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2093934105895711621L;
	JTextField seat1 = new JTextField("1: ",15);
	JTextField seat2 = new JTextField("2: ",15);
	JTextField seat3 = new JTextField("3: ",15);
	JTextField seat4 = new JTextField("4: ",15);
	JTextField seat5 = new JTextField("5: ",15);
	JTextField seat6 = new JTextField("6: ",15);
	JTextField seat7 = new JTextField("7: ",15);
	JTextField seat8 = new JTextField("8: ",15);
	JPanel items = new JPanel();

	JButton next = new JButton("Proceed to Round 1 Pairings");
	
	private ArrayList<JTextField> textfields = new ArrayList<JTextField>();
	
	public DraftSeatingGUI(ArrayList<Player> players){
		textfields.add(seat1);
		textfields.add(seat2);
		textfields.add(seat3);
		textfields.add(seat4);
		textfields.add(seat5);
		textfields.add(seat6);
		textfields.add(seat7);
		textfields.add(seat8);

		
		for(int i = 0; i < players.size(); i++){
			textfields.get(i).setText((i+1)+": "+players.get(i).getName());
		}for(int i = players.size(); i < 8; i++){
			textfields.get(i).setText((i+1)+": "+"-----");

		}
		for(JTextField j: textfields){
			j.setBorder( null );
			j.setOpaque( false );
			j.setEditable( false );
			j.setFocusable( false );
			j.setFont(Draws.f);
		}
		
		JPanel toprow = new JPanel();
		JPanel bottomrow = new JPanel();
		toprow.add(seat1);
		toprow.add(seat2);
		toprow.add(seat3);
		toprow.add(seat4);
		bottomrow.add(seat8);
		bottomrow.add(seat7);
		bottomrow.add(seat6);
		bottomrow.add(seat5);
		
		toprow.setLayout(new BoxLayout(toprow,BoxLayout.X_AXIS));
		bottomrow.setLayout(new BoxLayout(bottomrow,BoxLayout.X_AXIS));
		
		items.add(toprow);
		items.add(bottomrow);
		items.add(next);
		next.setFont(Draws.f);
		items.setLayout(new BoxLayout(items,BoxLayout.Y_AXIS));

		next.addActionListener(new NextButtonListener());
		this.setVisible(true);
	}
	
	public JPanel getPanel(){
		return items;
	}
	
	private class NextButtonListener implements ActionListener{
		
		public void actionPerformed (ActionEvent event){
			Draws.addTab("Round 1 Pairings",((GPI)Draws.setDraftState(Draws.ROUND_PAIRINGS)).getPanel());
		}
		
	}
}

