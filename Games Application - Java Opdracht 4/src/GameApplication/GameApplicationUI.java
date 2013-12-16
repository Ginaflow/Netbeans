package GameApplication;

import foxesandrabbitsGame.FoxesAndRabbits;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class GameApplicationUI
{
	// Declare a constant for the position of the active game's panel.
	// Of course you can directly use BorderLayout.CENTER, but it is used
	// in several methods and using a constant makes the code more maintainable.
	// Think about what happens if you don't use a constant, and the
	// the position of the panel needs to be changed. Surely you'll forget
	// an update...
	private final static String GAME_PANEL_POSITION = BorderLayout.CENTER;
	
	private final static String GAME_SELECTION_PANEL_POSITION = BorderLayout.WEST;
	
	// UI related fields.
	
	// Instead of this construction with a field, you can
	// use JFrame as a super class of GamesApplicationUI.
	private JFrame frameGamesApplication;
	
	// Other fields.
	
	// The JList member holds a list of the game names. Double clicking
	// on a name results in making that game the active one (and displaying it)
	private JList<String> gamesList;

	// The HashMap maps the name of a panel (for opdracht 4: Game) to the
	// panel itself.
	private HashMap<String, JPanel> panelCatalog;
        private GameCatalog gameCatalog;
        private GamesInteractionPanel interactionPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameApplicationUI window = new GameApplicationUI();
					window.frameGamesApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameApplicationUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. UI related only.
	 */
	private void initialize()
	{		 
		frameGamesApplication = new JFrame();
		frameGamesApplication.setTitle("Games Application");
		frameGamesApplication.setSize(300, 300);
		frameGamesApplication.setBounds(150, 150, 450, 300);
		frameGamesApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGamesApplication.setLayout(new BorderLayout());
                interactionPanel = new GamesInteractionPanel();
                frameGamesApplication.getContentPane().add(interactionPanel,BorderLayout.NORTH);
                
                gameCatalog = new GameCatalog();
                
                DummyGame dummyGame = new DummyGame("DummyGame");
                FoxesAndRabbits foxesandrabbits = new FoxesAndRabbits("Foxes And Rabbits");
                
                gameCatalog.addGame("DummyGame", dummyGame);
                gameCatalog.addGame("Foxes And Rabbits", foxesandrabbits);
                
		initializeGamesList();
		initializePanelCatalog();
		
	}

	/**
	 * Takes care of initialization of the games list.
	 */
	private void initializeGamesList()
	{
		gamesList = new JList<String>();
		gamesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gamesList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		String[] gameNames = {"DummyGame", "Foxes And Rabbits"};
		gamesList.setListData(gameNames);
		
		gamesList.addMouseListener(new MouseListener()
		{
				public void mousePressed(MouseEvent e) {}

			    public void mouseReleased(MouseEvent e) {}

			    public void mouseEntered(MouseEvent e) {}
			    
			    public void mouseExited(MouseEvent e) {}

			    public void mouseClicked(MouseEvent e)
			    {
			    	if(e.getClickCount() == 2)
			    	{
			    		JPanel panelToBeActivated = panelCatalog.get(gamesList.getSelectedValue());
			    		activateGamePanel(panelToBeActivated);
                                        interactionPanel.setActiveGame(gameCatalog.getGame(gamesList.getSelectedValue()));
			    	}
			    }
		});
		
		frameGamesApplication.getContentPane().add(gamesList, GAME_SELECTION_PANEL_POSITION);
	}
	
	/**
	 * Takes care of initialization of the panel catalog.
	 */
	private void initializePanelCatalog()
	{
		panelCatalog = new HashMap<String, JPanel>();
		
		JPanel someNewPanel = new JPanel();
                
                /*
                for(String x : gameCatalog.getGameNames())
                {
                    someNewPanel.add(new JLabel(x));
                    panelCatalog.put(x, gameCatalog.getGame(x).getPanel());
                }
                */
                
                someNewPanel.add(new JLabel("DummyGame"));
		panelCatalog.put("DummyGame", gameCatalog.getGame("DummyGame").getPanel());
		
		someNewPanel = new JPanel();
		someNewPanel.add(new JLabel("Lessen Quiz"));
		panelCatalog.put("DocentenQuiz Quiz", someNewPanel);
                
                someNewPanel = new JPanel();
		someNewPanel.add(new JLabel("Foxes And Rabbits"));
		panelCatalog.put("Foxes And Rabbits", gameCatalog.getGame("Foxes And Rabbits").getPanel());
	} 
	
	/**
	 * Shows the given panel on the location where a game is to be displayed.
	 * This is done in 2 steps:
	 * 	- remove the existing one
	 *  - set the given panel on the proper location and refresh in order to
	 *    make it visible
	 * 
	 * @param thePanel
	 */
	private void activateGamePanel(JPanel thePanel)
	{
		removeActiveGamePanel();
		setActiveGamePanel(thePanel);
	}
	
	/**
	 * Removes the panel of the game that is currently active from the visible part of the frame.
	 * 
	 */
	private void removeActiveGamePanel()
	{
		// First, get to the layout manager (a BorderLayout) of the frame's content pane.
		Container contentPane = frameGamesApplication.getContentPane();
		BorderLayout bl = (BorderLayout)contentPane.getLayout();
		
		// Then retrieve the panel (of which Component is a super class). The panel is
		// the center zone of the frame's BorderLayout.
		Component activeGamePanel = bl.getLayoutComponent(GAME_PANEL_POSITION);
		
		if(activeGamePanel != null)
		{			
			contentPane.remove(activeGamePanel);
		}
	}
	
	/**
	 * Sets the given panel as the active one.
	 * 
	 * @param gamePanel panel of the game to be displayed
	 */
	private void setActiveGamePanel(JPanel gamePanel)
	{
		// First, add the given panel to the frame's on the proper position.
		Container contentPane = frameGamesApplication.getContentPane();		
		contentPane.add(gamePanel, GAME_PANEL_POSITION);
		
		// Then do the UI-refresh
		frameGamesApplication.revalidate();
		frameGamesApplication.repaint();
	}
        
        private JPanel getActiveGamePanel()
        {
            BorderLayout layout = (BorderLayout) frameGamesApplication.getContentPane().getLayout();
            return (JPanel) layout.getLayoutComponent(GAME_PANEL_POSITION);
        }
}
