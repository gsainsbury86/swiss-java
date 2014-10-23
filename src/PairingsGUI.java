import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class PairingsGUI extends JComponent implements GPI{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6030219602416371966L;
	JTextField table1 = new JTextField("Table 1: ",15);
	JTextField table2 = new JTextField("Table 2: ",15);
	JTextField table3 = new JTextField("Table 3: ",15);
	JTextField table4 = new JTextField("Table 4: ",15);
	
	JTextField table1_seat1 = new JTextField("",15);
	JTextField table1_seat2 = new JTextField("",15);
	JTextField table2_seat1 = new JTextField("",15);
	JTextField table2_seat2 = new JTextField("",15);
	JTextField table3_seat1 = new JTextField("",15);
	JTextField table3_seat2 = new JTextField("",15);
	JTextField table4_seat1 = new JTextField("",15);
	JTextField table4_seat2 = new JTextField("",15);
	
	JTextField table1_seat1s = new JTextField("",1);
	JTextField table1_seat2s = new JTextField("",1);
	JTextField table2_seat1s = new JTextField("",1);
	JTextField table2_seat2s = new JTextField("",1);
	JTextField table3_seat1s = new JTextField("",1);
	JTextField table3_seat2s = new JTextField("",1);
	JTextField table4_seat1s = new JTextField("",1);
	JTextField table4_seat2s = new JTextField("",1);
	
	JTextField bye = new JTextField("Bye: ",15);
	JTextField bye_seat1 = new JTextField("",15);
	
	JButton submit = new JButton("Submit Scores");
	ClockLabel clock = new ClockLabel(50);

	private ArrayList<JTextField> table1fields = new ArrayList<JTextField>();
	private ArrayList<JTextField> table2fields = new ArrayList<JTextField>();
	private ArrayList<JTextField> table3fields = new ArrayList<JTextField>();
	private ArrayList<JTextField> table4fields = new ArrayList<JTextField>();
	private ArrayList<JTextField> byefields = new ArrayList<JTextField>();
	
	private ArrayList<JTextField> editable = new ArrayList<JTextField>();
	private ArrayList<JTextField> seats = new ArrayList<JTextField>();
	
	private ArrayList<Match> matches;
	private JPanel items = new JPanel();

	private String nextTitle;
	
	public PairingsGUI(int round, ArrayList<Match> matches,Player pbye){
		this.matches = matches;
		this.nextTitle = ("Round " + round + " Standings");
		
		seats.add(table1_seat1);
		seats.add(table1_seat2);
		seats.add(table2_seat1);
		seats.add(table2_seat2);
		seats.add(table3_seat1);
		seats.add(table3_seat2);
		seats.add(table4_seat1);
		seats.add(table4_seat2);
		
		table1fields.add(table1);
		table1fields.add(table1_seat1);
		table1fields.add(table1_seat1s);
		table1fields.add(table1_seat2);
		table1fields.add(table1_seat2s);
		
		table2fields.add(table2);
		table2fields.add(table2_seat1);
		table2fields.add(table2_seat1s);
		table2fields.add(table2_seat2);
		table2fields.add(table2_seat2s);
		
		table3fields.add(table3);
		table3fields.add(table3_seat1);
		table3fields.add(table3_seat1s);
		table3fields.add(table3_seat2);
		table3fields.add(table3_seat2s);
		
		table4fields.add(table4);
		table4fields.add(table4_seat1);
		table4fields.add(table4_seat1s);
		table4fields.add(table4_seat2);
		table4fields.add(table4_seat2s);
		
		byefields.add(bye);
		byefields.add(bye_seat1);
		
		editable.add(table1_seat1s);		
		editable.add(table1_seat2s);		
		editable.add(table2_seat1s);		
		editable.add(table2_seat2s);		
		editable.add(table3_seat1s);		
		editable.add(table3_seat2s);		
		editable.add(table4_seat1s);		
		editable.add(table4_seat2s);
		
		for(int i = 0; i < matches.size(); i++){
			seats.get(2*i).setText(matches.get(i).getP1().getName());
			seats.get(2*i+1).setText(matches.get(i).getP2().getName());
		}
		if(pbye != null){
			bye_seat1.setText(pbye.getName());
		}
		
		JPanel t1 = new JPanel();
		JPanel t2 = new JPanel();
		JPanel t3 = new JPanel();
		JPanel t4 = new JPanel();
		JPanel b = new JPanel();
		
		for(JTextField j: table1fields){
			j.setBorder( null );
			j.setOpaque( false );
			j.setEditable( false );
			j.setFocusable( false );

			j.setFont(Draws.f);
			t1.add(j);
		}
		
		for(JTextField j: table2fields){
			j.setBorder( null );
			j.setOpaque( false );
			j.setEditable( false );
			j.setFocusable( false );

			j.setFont(Draws.f);
			t2.add(j);
		}
		
		for(JTextField j: table3fields){
			j.setBorder( null );
			j.setOpaque( false );
			j.setEditable( false );
			j.setFocusable( false );

			j.setFont(Draws.f);
			t3.add(j);
		}
		
		for(JTextField j: table4fields){
			j.setBorder( null );
			j.setOpaque( false );
			j.setEditable( false );
			j.setFocusable( false );

			j.setFont(Draws.f);
			t4.add(j);
		}
		
		for(JTextField j: byefields){
			j.setBorder( null );
			j.setOpaque( false );
			j.setEditable( false );
			j.setFocusable( false );

			j.setFont(Draws.f);
			b.add(j);
		}
		
		int count = 0;
		for(JTextField j: editable){
			if(count < matches.size()*2){
				j.setBorder(BorderFactory.createLineBorder(Color.black));
				j.setOpaque( true );
				j.setEditable( true );
				j.setFocusable( true );

			}
			count++;
		}
		
		

		submit.setFont(Draws.f);
		clock.setFont(Draws.f);

		t1.setLayout(new BoxLayout(t1,BoxLayout.X_AXIS));
		t2.setLayout(new BoxLayout(t2,BoxLayout.X_AXIS));
		t3.setLayout(new BoxLayout(t3,BoxLayout.X_AXIS));
		t4.setLayout(new BoxLayout(t4,BoxLayout.X_AXIS));
		b.setLayout(new BoxLayout(b,BoxLayout.X_AXIS));
		items.add(clock);
		items.add(t1);
		items.add(t2);		
		items.add(t3);
		items.add(t4);		
		items.add(b);
		items.add(submit);		
		items.setLayout(new BoxLayout(items,BoxLayout.Y_AXIS));
		submit.addActionListener(new NextButtonListener());
		this.setVisible(true);
	}
	
	public JPanel getPanel(){
		return items;
	}
	
	private class NextButtonListener implements ActionListener{
		
		public void actionPerformed (ActionEvent event){
			boolean roundComplete = false;
			if(matches.size() == 1){
				try {
					matches.get(0).score(Integer.parseInt(table1_seat1s.getText()),Integer.parseInt(table1_seat2s.getText()));
					roundComplete = true;
				}
				catch (NumberFormatException e) {
					roundComplete = false;
				}
				
				
			}else if(matches.size() == 2){
				try {
					matches.get(0).score(Integer.parseInt(table1_seat1s.getText()),Integer.parseInt(table1_seat2s.getText()));
					matches.get(1).score(Integer.parseInt(table2_seat1s.getText()),Integer.parseInt(table2_seat2s.getText()));
					roundComplete = true;
				}
				catch (NumberFormatException e) {
					roundComplete = false;
				}
				
			}else if(matches.size() == 3){
				try {
					matches.get(0).score(Integer.parseInt(table1_seat1s.getText()),Integer.parseInt(table1_seat2s.getText()));
					matches.get(1).score(Integer.parseInt(table2_seat1s.getText()),Integer.parseInt(table2_seat2s.getText()));
					matches.get(2).score(Integer.parseInt(table3_seat1s.getText()),Integer.parseInt(table3_seat2s.getText()));
					roundComplete = true;
				}
				catch (NumberFormatException e) {
					roundComplete = false;
				}
				
			}else if(matches.size() == 4){
				try {
					matches.get(0).score(Integer.parseInt(table1_seat1s.getText()),Integer.parseInt(table1_seat2s.getText()));
					matches.get(1).score(Integer.parseInt(table2_seat1s.getText()),Integer.parseInt(table2_seat2s.getText()));
					matches.get(2).score(Integer.parseInt(table3_seat1s.getText()),Integer.parseInt(table3_seat2s.getText()));
					matches.get(3).score(Integer.parseInt(table4_seat1s.getText()),Integer.parseInt(table4_seat2s.getText()));
					roundComplete = true;
				}
				catch (NumberFormatException e) {
					roundComplete = false;
				}
				
			}
			
			if(roundComplete){
				Draws.addTab(nextTitle, ((GPI)Draws.setDraftState(Draws.ROUND_STANDINGS)).getPanel());
				
			}
		}
		
	}
	
	class ClockLabel extends JLabel implements ActionListener {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -3931436873177416167L;
		private SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        private boolean alarmed = false;
		
		public ClockLabel(int mins) {
			super("Round ends at: XX:XX XX");
            
            int millisecondsPerRound = 1000*60*mins;
            
            long t = Calendar.getInstance().getTimeInMillis()+millisecondsPerRound;
			Date d  = new Date();
			d.setTime(t);
            
            setText("Round ends at: " + formatter.format(d));

			Timer timer = new Timer(millisecondsPerRound, this);
			timer.start();
			
		}
		
		public void actionPerformed(ActionEvent ae) {

            // Play a sound
            if(!alarmed){
                Toolkit.getDefaultToolkit().beep();
                //MP3 mp3 = new MP3("/Users/gsainsbury86/development/Swiss Pairings/SwissPairingsJava/Fanfare.mp3");
                //mp3.play();
                alarmed = true;
            }
		}
	}
	
}