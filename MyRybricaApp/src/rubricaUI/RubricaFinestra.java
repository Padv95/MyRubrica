package rubricaUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import rubricaClassi.Contatto;
import rubricaClassi.Rubrica;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RubricaFinestra {

	private JFrame frmMyRubrica;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JTextField txtUsername2;
	private JTextField txtEmail;
	private JTextField txtCognome;
	private JTextField txtNome;
	private JTextField txtPassword;
	private JTextField txtPassword2;
	private JTable Dasboardtable;
	JLabel lblWelcome = new JLabel("Benvenuto!");
	JScrollPane scrollPaneDashboardTable = new JScrollPane();
	JButton btnRiduciLista = new JButton("Riduci Lista");
	DefaultTableModel dtm;
	DefaultTableModel dtm2;
	private Rubrica user = new Rubrica();
	private JTextField txtNewNome;
	private JTextField txtNewCognome;
	private JTextField txtNewTelefono;
	private JTextField txtEmailContatto;
	private JTextField txtSearchname;
	private JTextField txtSearchCognome;
	private JTable table_1;
	private JTextField txtNomeUP;
	private JTextField txtCognomeUP;
	private JTable tableUP;
	DefaultTableModel dtm3;
	private JTextField txtIdUP;
	private JTextField txtNomeDel;
	private JTable tableDel;
	private JTextField txtNomeUP2;
	private JTextField txtCognomeUP2;
	private JTextField txtEmailUP;
	private JTextField txtTelefonoUP;
	private JTextField txtCognomeDel;
	private JTextField txtIdDel;
	DefaultTableModel dtm4;
	private JLabel lblUsernameUtente;
	private JLabel lblNomeUtente;
	private JLabel lblEmailUtente;
	private JLabel lblCognomeUtente;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RubricaFinestra window = new RubricaFinestra();
					window.frmMyRubrica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RubricaFinestra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmMyRubrica =  new JFrame();
		frmMyRubrica.setFont(new Font("Verdana", Font.PLAIN, 20));
		frmMyRubrica.setIconImage(Toolkit.getDefaultToolkit().getImage(RubricaFinestra.class.getResource("/immagini/FinLogo.png")));
		frmMyRubrica.setTitle("My Rubrica");
		frmMyRubrica.setBounds(100, 100, 968, 585);
		frmMyRubrica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyRubrica.getContentPane().setLayout(null);
		frmMyRubrica.setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(-11, -33, 1000, 620);
		frmMyRubrica.getContentPane().add(tabbedPane);
		
		//----------------------------------------------- Starting Panel ------------------------------------------------------------------//
		JPanel startingpanel = new JPanel();
		tabbedPane.addTab("New tab", null, startingpanel, null);
		startingpanel.setLayout(null);
		
	 
		JLabel BgImg = new JLabel("");
		BgImg.setHorizontalAlignment(SwingConstants.CENTER);
		BgImg.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/StartingPanelBgImg.jpg")));
		BgImg.setBounds(-2, 0, 990, 570);
		startingpanel.add(BgImg);
		
		
		JLabel LogoImg = new JLabel("");
		LogoImg.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/my-rubrica-high-resolution-logo-color-on-transparent-background_35.png")));
		LogoImg.setHorizontalAlignment(SwingConstants.CENTER);
		LogoImg.setBounds(0, 0, 984, 150);
		BgImg.add(LogoImg);
		
		
		JButton btnAccedi = new JButton("Accedi");
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		//btnAccedi.setBackground(new Color(79, 133, 255));
		btnAccedi.setForeground(new Color(99, 119, 223));
		//btnAccedi.setOpaque(true); //needed for apple to see the background. Don't use on windows
		btnAccedi.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnAccedi.setBounds(285, 460, 165, 50);
		BgImg.add(btnAccedi);
		
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		//btnRegistrati.setBackground(new Color(79, 133, 255));
		btnRegistrati.setForeground(new Color(99, 119, 223));
		//btnRegistrati.setOpaque(true); //needed for apple to see the background. Don't use on windows
		btnRegistrati.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnRegistrati.setBounds(520, 460, 165, 50);
		BgImg.add(btnRegistrati);
		
		
		//------------------------------------------------------- Login Panel ---------------------------------------------------------------------------//
		
		JPanel loginpanel = new JPanel();
		tabbedPane.addTab("New tab", null, loginpanel, null);
		loginpanel.setLayout(null);
		
		
		JLabel lblLoginBgImg = new JLabel("");
		lblLoginBgImg.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoginBgImg.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/LoginPanelBgImg.jpg")));
		lblLoginBgImg.setBounds(-2, 0, 990, 570);
		loginpanel.add(lblLoginBgImg);
		
		
		JLabel lblLoginTitle = new JLabel("Login");
		lblLoginTitle.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/login-_1_1_32x32.png")));
		lblLoginTitle.setForeground(new Color(255, 255, 255));
		lblLoginTitle.setFont(new Font("Verdana", Font.ITALIC, 32));
		lblLoginTitle.setBounds(100, 25, 150, 100);
		lblLoginBgImg.add(lblLoginTitle);
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblUsername.setBounds(100, 150, 165, 50);
		lblLoginBgImg.add(lblUsername);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblPassword.setBounds(100, 250, 165, 50);
		lblLoginBgImg.add(lblPassword);
		
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 20));
		passwordField.setBounds(300, 250, 250, 50);
		lblLoginBgImg.add(passwordField);
		
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtUsername.setText("");
		txtUsername.setBounds(300, 150, 250, 50);
		lblLoginBgImg.add(txtUsername);
		txtUsername.setColumns(10);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				user.setUsername(username);
				
				user.setPassword(password);
				
			
				
				if(user.isRegistrato() && user.passwordRiconosciuto()) {
					//Mi collego al DB

					user.faiLogin();
	 
					
					//Mostro messaggio di successo login
					JOptionPane.showMessageDialog(frmMyRubrica, "Accesso eseguito con successo!");
					
					if(!(user.getNome().isBlank())) {
						String saluto = "Benvenuto, " + user.getNome() +"!";
						lblWelcome.setText(saluto);
					}
					
					//chiudo questa finestra e vado alla dashboard
					tabbedPane.setSelectedIndex(3);
					
					txtUsername.setText("");
					passwordField.setText("");
					
					lblUsernameUtente.setText(user.getUsername());
					lblNomeUtente.setText(user.getNome());
					lblCognomeUtente.setText(user.getCognome());
					lblEmailUtente.setText(user.getEmail());			
				}
				else {
					//apro pannello messaggio di errore login
					JOptionPane.showMessageDialog(frmMyRubrica, "Username o password errati, o utente non registrato. Accesso negato!");
					txtUsername.setText("");
					passwordField.setText("");
				}
			}
		});
		btnLogin.setForeground(new Color(99, 119, 223));
//		btnLogin.setBackground(new Color(99, 119, 223));
		btnLogin.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnLogin.setBounds(100, 350, 150, 50);
		lblLoginBgImg.add(btnLogin);
		
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				txtUsername.setText("");
				passwordField.setText("");
			}
		});
		btnHome.setForeground(new Color(99, 119, 223));
//		btnHome.setBackground(new Color(99, 119, 223));
		btnHome.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnHome.setBounds(350, 350, 150, 50);
		lblLoginBgImg.add(btnHome);
		
		
		JLabel lblLogo2 = new JLabel("");
		lblLogo2.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/my-rubrica-high-resolution-logo-white-on-transparent-background_2_20.png")));
		lblLogo2.setBounds(400, 425, 400, 100);
		lblLoginBgImg.add(lblLogo2);
		
		
		JButton btnForgotButton = new JButton("Non hai un'account?");
		btnForgotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
				txtUsername.setText("");
				passwordField.setText("");
			}
		});
		//btnForgotButton.setBackground(new Color(99, 119, 223));
		btnForgotButton.setForeground(new Color(99, 119, 223));
		btnForgotButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnForgotButton.setBounds(100, 450, 250, 50);
		lblLoginBgImg.add(btnForgotButton);
//		btnForgotButton.setOpaque(false);
		
		
		//SignUp Panel----------------------------------------------------------------------//
		
		JPanel signuppanel = new JPanel();
		tabbedPane.addTab("New tab", null, signuppanel, null);
		signuppanel.setLayout(null);
		
				
		JLabel lblSignupBgImg = new JLabel(" ");
		lblSignupBgImg.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSignupBgImg.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/SignUpBgImg.jpg")));
		lblSignupBgImg.setBounds(-2, 0, 990, 570);
		signuppanel.add(lblSignupBgImg);
				
				
		JLabel lblSignupTitle = new JLabel("Sign up");
		lblSignupTitle.setForeground(new Color(255, 255, 255));
		lblSignupTitle.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/login-_2_32x32.png")));
		lblSignupTitle.setFont(new Font("Verdana", Font.ITALIC, 32));
		lblSignupTitle.setBounds(75, 5, 225, 80);
		lblSignupBgImg.add(lblSignupTitle);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblNome.setBounds(570, 100, 150, 50);
		lblSignupBgImg.add(lblNome);
				
				
		txtNome = new JTextField();
		txtNome.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtNome.setBounds(725, 100, 200, 50);
		lblSignupBgImg.add(txtNome);
		txtNome.setColumns(10);
				
				
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setForeground(new Color(255, 255, 255));
		lblCognome.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblCognome.setBounds(570, 200, 150, 50);
		lblSignupBgImg.add(lblCognome);
				

		txtCognome = new JTextField();
		txtCognome.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtCognome.setBounds(725, 200, 200, 50);
		lblSignupBgImg.add(txtCognome);
		txtCognome.setColumns(10);
				
				
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblEmail.setBounds(570, 300, 150, 50);
		lblSignupBgImg.add(lblEmail);
				
				
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtEmail.setText("");
		txtEmail.setBounds(725, 300, 200, 50);
		lblSignupBgImg.add(txtEmail);
		txtEmail.setColumns(10);
				
				
		JLabel lblUsername2 = new JLabel("Username");
		lblUsername2.setForeground(new Color(99, 119, 223));
		lblUsername2.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblUsername2.setBounds(70, 100, 150, 50);
		lblSignupBgImg.add(lblUsername2);
				
				
		txtUsername2 = new JTextField();
		txtUsername2.setText(" ");
		txtUsername2.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtUsername2.setBounds(245, 100, 200, 50);
		lblSignupBgImg.add(txtUsername2);
		txtUsername2.setColumns(10);
		
		
		JLabel lblPassword2 = new JLabel("Password");
		lblPassword2.setForeground(new Color(99, 119, 223));
		lblPassword2.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblPassword2.setBounds(70, 200, 150, 50);
		lblSignupBgImg.add(lblPassword2);
		
		
		JLabel lblConfirmPassword = new JLabel("<html>Confirm <br>Password</html>");
		lblConfirmPassword.setForeground(new Color(99, 119, 223));
		lblConfirmPassword.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(70, 300, 200, 50);
		lblSignupBgImg.add(lblConfirmPassword);
				
				
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						String username2 = txtUsername2.getText();
						String password2 = txtPassword.getText();
						String password3 = txtPassword2.getText();
						String email = txtEmail.getText();
						String nome = txtNome.getText();
						String cognome = txtCognome.getText();
						
						user.setUsername(username2);
						user.setPassword(password2);
						user.setNome(nome);
						  user.setCognome(cognome);
						user.setEmail(email);
						
						if(user.isRegistrato()) {
							JOptionPane.showMessageDialog(frmMyRubrica, "Attenzione! Utente già registrato. Cambiare username o procedere direttamente al login.");
						}
						else {
							if(!(password2.equals(password3))) {
								JOptionPane.showMessageDialog(frmMyRubrica, "Attenzione! Le password non combaciano.");
							}
							else if(username2.isBlank() || password2.isBlank() || password3.isBlank() 
								|| email.isBlank() || nome.isBlank() || cognome.isBlank()	) {
								
								JOptionPane.showMessageDialog(frmMyRubrica, "Attenzione! Ci sono dei campi di dati ancora vuoti.");
							}
							else {
								
								user.registraUtente();
								
								JOptionPane.showMessageDialog(frmMyRubrica, "Registrazione avvenuta con successo! Procedere con il login");
								
								tabbedPane.setSelectedIndex(1);
								txtUsername2.setText("");
								txtEmail.setText("");
								txtPassword.setText("");
								txtPassword2.setText("");
								txtNome.setText("");
								txtCognome.setText(""); 
								
								
							}
						}   
			}
		});
		//btnSignUp.setBackground(new Color(99, 119, 223));
		btnSignUp.setForeground(new Color(99, 119, 223));
		btnSignUp.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnSignUp.setBounds(290, 410, 165, 50);
		lblSignupBgImg.add(btnSignUp);
						
						
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername2.setText("");
				txtEmail.setText("");
				txtPassword.setText("");
				txtPassword2.setText("");
				txtNome.setText("");
				txtCognome.setText("");
			}
		});
		//btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setForeground(new Color(99, 119, 223));
		btnReset.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnReset.setBounds(290, 490, 165, 50);
		lblSignupBgImg.add(btnReset);
		
		
		JButton btnHome2 = new JButton("Home");
		btnHome2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				txtUsername2.setText("");
				txtEmail.setText("");
				txtPassword.setText("");
				txtPassword2.setText("");
				txtNome.setText("");
				txtCognome.setText("");
			}
		});
		//btnHome2.setBackground(new Color(99, 119, 223));
		btnHome2.setForeground(new Color(99, 119, 223));
		btnHome2.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnHome2.setBounds(525, 410, 165, 50);
		lblSignupBgImg.add(btnHome2);
		
		
		JLabel lblLogo3 = new JLabel("");
		lblLogo3.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/my-rubrica-high-resolution-logo-color-on-transparent-background_20.png")));
		lblLogo3.setBounds(525, 475, 400, 75);
		lblSignupBgImg.add(lblLogo3);
		
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtPassword.setBounds(245, 200, 200, 50);
		lblSignupBgImg.add(txtPassword);
		txtPassword.setColumns(10);
		
		  
		txtPassword2 = new JTextField();
		txtPassword2.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtPassword2.setBounds(245, 300, 200, 50);
		lblSignupBgImg.add(txtPassword2);
		txtPassword2.setColumns(10);
						
		JButton btnNewButton_14 = new JButton("<html>Hai già un<br> account ?<br>Accedi qui.</html>");
		btnNewButton_14.setForeground(new Color(99, 119, 223));
		//btnNewButton_14.setBackground(new Color(255, 255, 255));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				txtUsername2.setText("");
				txtEmail.setText("");
				txtPassword.setText("");
				txtPassword2.setText("");
				txtNome.setText("");
				txtCognome.setText(""); 
			}
		});
		btnNewButton_14.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton_14.setBounds(70, 425, 165, 100);
		lblSignupBgImg.add(btnNewButton_14);
        btnNewButton_14.setOpaque(false);
				

		
		
		
		//Dashboard panel-----------------------------------------------------------------//
		
		JPanel dashboard = new JPanel();
		tabbedPane.addTab("New tab", null, dashboard, null);
		dashboard.setLayout(null);
		
		
		dtm = new DefaultTableModel( //dtm  dichiarato sopra
				new Object[][] {
					
				},
				new String[] {
					"Nome", "Cognome", "Telefono", "Email"
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			};
		
		
		JLabel lblDashboardBg1 = new JLabel("");
		lblDashboardBg1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDashboardBg1.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/DashboardBgImg.jpg")));
		lblDashboardBg1.setBounds(-2, 0, 990, 570);
		dashboard.add(lblDashboardBg1);
		
		
		JLabel lblLogo4 = new JLabel("");
		lblLogo4.setBackground(new Color(240, 240, 240));
		lblLogo4.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/my-rubrica-high-resolution-logo-white-on-transparent-background_2_20.png")));
		lblLogo4.setBounds(200, -5, 495, 100);
		lblDashboardBg1.add(lblLogo4);
		
		
		//JLabel lblWelcome dichiarato sopra
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 22));
		lblWelcome.setBounds(200, 95, 900, 40);
		lblDashboardBg1.add(lblWelcome);
		
		
		JButton btnCarica = new JButton("Carica Contatti");
		btnCarica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.caricaContatti(dtm);
			}
		});
		//btnCarica.setBackground(new Color(99, 119, 223));
		btnCarica.setForeground(new Color(99, 119, 223));
		btnCarica.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnCarica.setBounds(200, 160, 200, 50);
		lblDashboardBg1.add(btnCarica);
		
		
		JButton btnEspandi = new JButton("Espandi Lista");
		btnEspandi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEspandi.setEnabled(false);
				btnEspandi.setVisible(false);
				btnCarica.setEnabled(false);
				btnCarica.setVisible(false);
				lblWelcome.setVisible(false);
				scrollPaneDashboardTable.setBounds(200, 90, 700, 455);
				btnRiduciLista.setEnabled(true);
				btnRiduciLista.setVisible(true);
			}
		});
		//btnEspandi.setBackground(new Color(99, 119, 223));
		btnEspandi.setForeground(new Color(99, 119, 223));
		btnEspandi.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnEspandi.setBounds(450, 160, 200, 50);
		lblDashboardBg1.add(btnEspandi);
		
		
		//JScrollPane scrollPane = new JScrollPane();
		scrollPaneDashboardTable.setBounds(200, 240, 700, 305);
		lblDashboardBg1.add(scrollPaneDashboardTable);
		
		
		Dasboardtable = new JTable();
		Dasboardtable.setForeground(new Color(99, 119, 223));
		Dasboardtable.setFont(new Font("Verdana", Font.PLAIN, 15));
		Dasboardtable.setBackground(new Color(255, 255, 255));
		Dasboardtable.setModel(dtm);
		scrollPaneDashboardTable.setViewportView(Dasboardtable);
		
		JLabel lblDAshMenu = new JLabel("");
		lblDAshMenu.setForeground(new Color(255, 255, 255));
		lblDAshMenu.setBounds(0, 0, 170, 570);
		lblDashboardBg1.add(lblDAshMenu);
		lblDashboardBg1.setBackground(new Color(128, 128, 192));
		
		JLabel lblMyMenu = new JLabel("My Menu");
		lblMyMenu.setForeground(new Color(255, 255, 255));
		lblMyMenu.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblMyMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyMenu.setBounds(0, 0, 170, 170);
		lblDAshMenu.add(lblMyMenu);
						
		
		JButton btnAggiungiDbP = new JButton("Aggiungi ");
		btnAggiungiDbP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnAggiungiDbP.setForeground(new Color(255, 255, 255));
		btnAggiungiDbP.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnAggiungiDbP.setBackground(new Color(128, 128, 192));
		btnAggiungiDbP.setBounds(0, 170, 170, 65);
		lblDAshMenu.add(btnAggiungiDbP);
		btnAggiungiDbP.setOpaque(false);
		btnAggiungiDbP.setBorderPainted(false);
		
		JButton btnCercaDbP = new JButton("Cerca ");
		btnCercaDbP.setForeground(new Color(255, 255, 255));
		btnCercaDbP.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnCercaDbP.setBackground(new Color(0, 128, 128));
		btnCercaDbP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		btnCercaDbP.setBounds(0, 235, 170, 65);
		lblDAshMenu.add(btnCercaDbP);
		btnCercaDbP.setOpaque(false);
		btnCercaDbP.setBorderPainted(false);
		
		JButton btnModificaDbP = new JButton("Modifica ");
		btnModificaDbP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(6);
			}
		});
		btnModificaDbP.setForeground(new Color(255, 255, 255));
		btnModificaDbP.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnModificaDbP.setBackground(new Color(128, 128, 64));
		btnModificaDbP.setBounds(0, 300, 170, 65);
		lblDAshMenu.add(btnModificaDbP);
		btnModificaDbP.setOpaque(false);
		btnModificaDbP.setBorderPainted(false);
		
		JButton btnEliminaDbP = new JButton("Elimina ");
		btnEliminaDbP.setForeground(new Color(255, 255, 255));
		btnEliminaDbP.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnEliminaDbP.setBackground(new Color(255, 128, 128));
		btnEliminaDbP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(7);
			}
		});
		btnEliminaDbP.setBounds(0, 365, 170, 65);
		lblDAshMenu.add(btnEliminaDbP);
		btnEliminaDbP.setOpaque(false);
		btnEliminaDbP.setBorderPainted(false);
		
		JButton btnGestisciAccount = new JButton("Account");
		btnGestisciAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(8);
			}
		});
		btnGestisciAccount.setForeground(new Color(255, 255, 255));
		btnGestisciAccount.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnGestisciAccount.setBackground(new Color(128, 64, 64));
		btnGestisciAccount.setBounds(0, 430, 170, 65);
		lblDAshMenu.add(btnGestisciAccount);
		btnGestisciAccount.setOpaque(false);
		btnGestisciAccount.setBorderPainted(false);
		
		JButton btnLogOut = new JButton("Logout");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(frmMyRubrica, "Confermi il logout?");
				
				if(a == 0) {
					user.faiLogout();
					tabbedPane.setSelectedIndex(0);
				}
			}
		});
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnLogOut.setBackground(new Color(128, 64, 0));
		btnLogOut.setBounds(0, 495, 170, 75);
		lblDAshMenu.add(btnLogOut);
		btnLogOut.setOpaque(false);
		btnLogOut.setBorderPainted(false);
		
		JPanel MenuBGPanel = new JPanel();
		MenuBGPanel.setBackground(new Color(99, 119, 223));
		MenuBGPanel.setBounds(0, 0, 170, 560);
		lblDashboardBg1.add(MenuBGPanel);
		
		//JButton btnRiduciLista = new JButton("Riduci Lista");
		btnRiduciLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneDashboardTable.setBounds(200, 240, 700, 305);
				btnEspandi.setEnabled(true);
				btnEspandi.setVisible(true);
				btnCarica.setEnabled(true);
				btnCarica.setVisible(true);
				lblWelcome.setVisible(true);
				btnRiduciLista.setEnabled(false);
				btnRiduciLista.setVisible(false);
			}
		});
		btnRiduciLista.setEnabled(false);
		btnRiduciLista.setVisible(false);
		//btnRiduciLista.setBackground(new Color(99, 119, 223));
		btnRiduciLista.setForeground(new Color(99, 119, 223));
		btnRiduciLista.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnRiduciLista.setBounds(700, 20, 200, 50);
		lblDashboardBg1.add(btnRiduciLista);
		
		
		//ADD Panel----------------------------------------------------------------------//
		
		JPanel Addpanel = new JPanel();
		tabbedPane.addTab("New tab", null, Addpanel, null);
		Addpanel.setLayout(null);
		
		JLabel lblAddBgImg = new JLabel("");
		lblAddBgImg.setVerticalAlignment(SwingConstants.TOP);
		lblAddBgImg.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/addBgFlipped.jpg")));
		lblAddBgImg.setBounds(-2, 0, 990, 570);
		Addpanel.add(lblAddBgImg);
		
		JLabel lblNewLabel_1 = new JLabel("Nuovo Contatto");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel_1.setBounds(90, 25, 410, 50);
		lblAddBgImg.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(90, 110, 150, 50);
		lblAddBgImg.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cognome");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(90, 185, 150, 50);
		lblAddBgImg.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 20));  
		lblNewLabel_4.setBounds(90, 260, 150, 50);
		lblAddBgImg.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(90, 335, 150, 50);
		lblAddBgImg.add(lblNewLabel_5);
		
		txtNewNome = new JTextField();
		txtNewNome.setBounds(290, 110, 200, 50);
		lblAddBgImg.add(txtNewNome);
		txtNewNome.setColumns(10);
		
		txtNewCognome = new JTextField();
		txtNewCognome.setBounds(290, 185, 200, 50);
		lblAddBgImg.add(txtNewCognome);
		txtNewCognome.setColumns(10);
		
		txtNewTelefono = new JTextField();
		txtNewTelefono.setBounds(290, 260, 200, 50);
		lblAddBgImg.add(txtNewTelefono);
		txtNewTelefono.setColumns(10);
		
		txtEmailContatto = new JTextField();
		txtEmailContatto.setBounds(290, 335, 200, 50);
		lblAddBgImg.add(txtEmailContatto);
		txtEmailContatto.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("Aggiungi");
		//btnNewButton_8.setBackground(new Color(99, 119, 223));
		btnNewButton_8.setForeground(new Color(99, 119, 223));
		btnNewButton_8.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cNome = txtNewNome.getText();
				if(!(cNome.isBlank())) cNome = cNome.substring(0, 1).toUpperCase() + cNome.substring(1);
				
				String cCognome = txtNewCognome.getText();
				if(!(cCognome.isBlank()))cCognome = cCognome.substring(0, 1).toUpperCase() + cCognome.substring(1);
				
				String cTelefono = txtNewTelefono.getText();
				String cEmail = txtEmailContatto.getText();
				
				if(cNome.isBlank() && cCognome.isBlank()) {
					JOptionPane.showMessageDialog(frmMyRubrica, "<html>Attenzione! Almeno uno tra nome <br>e cognome deve essere inserito!</html>");
				}
				else if (cTelefono.isBlank() && cEmail.isBlank()) {
					JOptionPane.showMessageDialog(frmMyRubrica, "<html>Attenzione! Almeno uno tra telefono <br>e email deve essere inserito!</html>");
				}
				else {
					Contatto cont = new Contatto(cNome, cCognome, cTelefono, cEmail);
					
					user.aggiungiContatto(cont, dtm);
					
					
					JOptionPane.showMessageDialog(frmMyRubrica, "<html>Contatto aggiunto con<br>successo alla rubrica!</html>");
					
					txtNewNome.setText("");
					txtNewCognome.setText("");
					txtNewTelefono.setText("");
					txtEmailContatto.setText("");
				}
				
			}
		});
		btnNewButton_8.setBounds(90, 425, 150, 50);
		lblAddBgImg.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Back");
		//btnNewButton_9.setBackground(new Color(99, 119, 223));
		btnNewButton_9.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton_9.setForeground(new Color(99, 119, 223));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
				txtNewNome.setText("");
				txtNewCognome.setText("");
				txtNewTelefono.setText("");
				txtEmailContatto.setText("");
			}
		});
		btnNewButton_9.setBounds(340, 425, 150, 50);
		lblAddBgImg.add(btnNewButton_9);
		
		
		//Search Panel----------------------------------------------------------------------//
		
		JPanel SearchPanel = new JPanel();
		tabbedPane.addTab("New tab", null, SearchPanel, null);
		SearchPanel.setLayout(null);
		
		JLabel lblSearchBgIg = new JLabel("");
		lblSearchBgIg.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/SearchBgImg_1000x600.png")));
		lblSearchBgIg.setBounds(-2, 0, 990, 570);
		SearchPanel.add(lblSearchBgIg);
		
		JLabel lblNewLabel_6 = new JLabel("Cerca Contatto");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(329, 15, 267, 40);
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 32));
		lblSearchBgIg.add(lblNewLabel_6);
		
		JButton btnNewButton_13 = new JButton("Back");
		btnNewButton_13.setForeground(new Color(99, 119, 223));
		btnNewButton_13.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton_13.setBounds(810, 300, 100, 40);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
				
				if(dtm2.getRowCount()>0) dtm2.setRowCount(0);
				txtSearchname.setText("");
				txtSearchCognome.setText("");
			}
		});
		lblSearchBgIg.add(btnNewButton_13);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setForeground(new Color(99, 119, 223));
		btnCerca.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sNome = txtSearchname.getText();
				String sCognome = txtSearchCognome.getText();
				Contatto ctemp = new Contatto();
				ctemp.setCognome(sCognome);
				ctemp.setNome(sNome);
				
				if(!(sNome.isBlank()) || !(sCognome.isBlank())) {
					user.ricercaContatto(ctemp, dtm2);
					if (user.getTrovato()) {}
					else {
						JOptionPane.showMessageDialog(frmMyRubrica, "Contatto cercato non trovato");
					}
				}
				else {
					JOptionPane.showMessageDialog(frmMyRubrica, "Inserire almeno uno tra nome e cognome");
				}
				
			}
		});
		btnCerca.setBounds(810, 225, 100, 40);
		lblSearchBgIg.add(btnCerca);
		
		JLabel lblSearchname = new JLabel("Nome");
		lblSearchname.setForeground(new Color(255, 255, 255));
		lblSearchname.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblSearchname.setBounds(65, 100, 105, 40);
		lblSearchBgIg.add(lblSearchname);
		
		txtSearchname = new JTextField();
		txtSearchname.setBounds(170, 100, 140, 40);
		lblSearchBgIg.add(txtSearchname);
		txtSearchname.setColumns(10);
		
		JLabel lblSearchCognome = new JLabel("Cognome");
		lblSearchCognome.setForeground(new Color(255, 255, 255));
		lblSearchCognome.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblSearchCognome.setBounds(400, 100, 105, 40);
		lblSearchBgIg.add(lblSearchCognome);
		
		txtSearchCognome = new JTextField();
		txtSearchCognome.setBounds(550, 100, 150, 40);
		lblSearchBgIg.add(txtSearchCognome);
		txtSearchCognome.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(65, 150, 700, 350);
		lblSearchBgIg.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		table_1.setForeground(new Color(99, 119, 223));
		dtm2 = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome", "Cognome", "Telefono", "Email"
				});
		table_1.setModel(dtm2);
		scrollPane_1.setViewportView(table_1);
		
		
		
		//Update Panel-------------------------------------------------//
		
		JPanel UpdatePanel = new JPanel();
		tabbedPane.addTab("New tab", null, UpdatePanel, null);
		UpdatePanel.setLayout(null);
		
		JLabel lblTitoloUP = new JLabel("Modifica contatto");
		lblTitoloUP.setForeground(new Color(255, 255, 255));
		lblTitoloUP.setBounds(307, 15, 379, 40);
		lblTitoloUP.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 32));
		UpdatePanel.add(lblTitoloUP);
		
		JLabel lblNomeUP = new JLabel("Nome");
		lblNomeUP.setForeground(new Color(255, 255, 255));
		lblNomeUP.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNomeUP.setBounds(59, 91, 79, 32);
		UpdatePanel.add(lblNomeUP);
		
		txtNomeUP = new JTextField();
		txtNomeUP.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtNomeUP.setBounds(160, 91, 183, 32);
		UpdatePanel.add(txtNomeUP);
		txtNomeUP.setColumns(10);
		
		JLabel lblCognomeUp = new JLabel("Cognome");
		lblCognomeUp.setForeground(new Color(255, 255, 255));
		lblCognomeUp.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblCognomeUp.setBounds(435, 91, 125, 32);
		UpdatePanel.add(lblCognomeUp);
		
		txtCognomeUP = new JTextField();
		txtCognomeUP.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtCognomeUP.setBounds(582, 91, 183, 32);
		UpdatePanel.add(txtCognomeUP);
		txtCognomeUP.setColumns(10);
		
		JScrollPane scrollPaneUP = new JScrollPane();
		scrollPaneUP.setBounds(65, 150, 700, 120);
		UpdatePanel.add(scrollPaneUP);
		
		tableUP = new JTable();
		tableUP.setForeground(new Color(99, 119, 223));
		tableUP.setFont(new Font("Verdana", Font.PLAIN, 15));
		dtm3 = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID","Nome", "Cognome", "Telefono", "Email"
				});
		tableUP.setModel(dtm3);
		tableUP.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableUP.getColumnModel().getColumn(0).setMinWidth(10);
		tableUP.getColumnModel().getColumn(0).setMaxWidth(60);
		scrollPaneUP.setViewportView(tableUP);
		
		JButton btnTrova = new JButton("Trova");
		btnTrova.setForeground(new Color(99, 119, 223));
		btnTrova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String upNome = txtNomeUP.getText();
				String upCognome = txtCognomeUP.getText();
				Contatto ctemp = new Contatto();
				ctemp.setCognome(upCognome);
				ctemp.setNome(upNome);
				
				if(!(upNome.isBlank()) || !(upCognome.isBlank())) {
					user.ricercaIdContatto(ctemp, dtm3);
					if (user.getTrovato2()) {}
					else {
						JOptionPane.showMessageDialog(frmMyRubrica, "Contatto cercato non trovato");
					}
				}
				else {
					JOptionPane.showMessageDialog(frmMyRubrica, "Inserire almeno uno tra nome e cognome");
				}
			}
		});
		btnTrova.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnTrova.setBounds(777, 191, 140, 46);
		UpdatePanel.add(btnTrova);
		
		JLabel lblIstruzioneUP = new JLabel("Id del contatto da modificare :");
		lblIstruzioneUP.setForeground(new Color(255, 255, 255));
		lblIstruzioneUP.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblIstruzioneUP.setBounds(59, 291, 284, 32);
		UpdatePanel.add(lblIstruzioneUP);
		
		txtIdUP = new JTextField();
		txtIdUP.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtIdUP.setBounds(396, 291, 96, 32);
		UpdatePanel.add(txtIdUP);
		txtIdUP.setColumns(10);
		
		
		JLabel lblNomeUP2 = new JLabel("Nome");
		lblNomeUP2.setForeground(new Color(255, 255, 255));
		lblNomeUP2.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNomeUP2.setBounds(59, 368, 79, 32);
		UpdatePanel.add(lblNomeUP2);
		
		txtNomeUP2 = new JTextField();
		txtNomeUP2.setFont(new Font("Verdana", Font.PLAIN, 19));
		txtNomeUP2.setColumns(10);
		txtNomeUP2.setBounds(160, 368, 183, 32);
		UpdatePanel.add(txtNomeUP2);
		
		JLabel lblCognomeUp2 = new JLabel("Cognome");
		lblCognomeUp2.setForeground(new Color(255, 255, 255));
		lblCognomeUp2.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblCognomeUp2.setBounds(435, 368, 125, 32);
		UpdatePanel.add(lblCognomeUp2);
		
		txtCognomeUP2 = new JTextField();
		txtCognomeUP2.setFont(new Font("Verdana", Font.PLAIN, 19));
		txtCognomeUP2.setColumns(10);
		txtCognomeUP2.setBounds(582, 368, 183, 32);
		UpdatePanel.add(txtCognomeUP2);
		
		JLabel lblEmailUP = new JLabel("Email");
		lblEmailUP.setForeground(new Color(255, 255, 255));
		lblEmailUP.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblEmailUP.setBounds(59, 432, 96, 32);
		UpdatePanel.add(lblEmailUP);
		
		JButton btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setForeground(new Color(99, 119, 223));
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputId = txtIdUP.getText(); 
				int tId;
				
				try {
					tId = Integer.parseInt(inputId);
					
					String cNome = txtNomeUP2.getText();
					if(!(cNome.isBlank())) cNome = cNome.substring(0, 1).toUpperCase() + cNome.substring(1);
					
					String cCognome = txtCognomeUP2.getText();
					if(!(cCognome.isBlank()))cCognome = cCognome.substring(0, 1).toUpperCase() + cCognome.substring(1);
					
					String cTelefono = txtTelefonoUP.getText();
					String cEmail = txtEmailUP.getText();
					
					if(cNome.isBlank() && cCognome.isBlank()) {
						JOptionPane.showMessageDialog(frmMyRubrica, "<html>Attenzione! Almeno uno tra nome <br>e cognome deve essere inserito!</html>");
					}
					else if (cTelefono.isBlank() && cEmail.isBlank()) {
						JOptionPane.showMessageDialog(frmMyRubrica, "<html>Attenzione! Almeno uno tra telefono <br>e email deve essere inserito!</html>");
					}
					else {
						Contatto cont = new Contatto(cNome, cCognome, cTelefono, cEmail, tId);
						
						user.aggiornaContatto(tId, cont, dtm);
						
						
						JOptionPane.showMessageDialog(frmMyRubrica, "<html>Contatto aggiornato con<br>successo nella rubrica!</html>");
						
						txtNomeUP.setText("");
						txtNomeUP2.setText("");
						txtCognomeUP.setText("");
						txtCognomeUP2.setText("");
						txtEmailUP.setText("");
						txtTelefonoUP.setText("");
						txtIdUP.setText("");
						dtm3.setRowCount(0);
					}
				}catch(Exception exce2) {
					exce2.printStackTrace();
				}
				
			}
		});
		btnAggiorna.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnAggiorna.setBounds(254, 491, 140, 46);
		UpdatePanel.add(btnAggiorna);
		
		txtEmailUP = new JTextField();
		txtEmailUP.setFont(new Font("Verdana", Font.PLAIN, 19));
		txtEmailUP.setColumns(10);
		txtEmailUP.setBounds(160, 432, 183, 32);
		UpdatePanel.add(txtEmailUP);
		
		txtTelefonoUP = new JTextField();
		txtTelefonoUP.setFont(new Font("Verdana", Font.PLAIN, 19));
		txtTelefonoUP.setColumns(10);
		txtTelefonoUP.setBounds(582, 432, 183, 32);
		UpdatePanel.add(txtTelefonoUP);
		
		JLabel lblTelefonoUp = new JLabel("Telefono");
		lblTelefonoUp.setForeground(new Color(255, 255, 255));
		lblTelefonoUp.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblTelefonoUp.setBounds(435, 432, 125, 32);
		UpdatePanel.add(lblTelefonoUp);
		
		JButton btnCaricaUP = new JButton("Carica dati");
		btnCaricaUP.setForeground(new Color(99, 119, 223));
		btnCaricaUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputId = txtIdUP.getText();
				
				if(inputId.isBlank()) {
					JOptionPane.showMessageDialog(frmMyRubrica, "Inserire Id del contatto da modificare (dopo averlo cercato)");
				}
				else {
					try {
						int IdUP = Integer.parseInt(inputId);
						
						Contatto ctemp = new Contatto();
						
						ctemp = user.getContattoById(IdUP);
						
						txtNomeUP2.setText(ctemp.getNome());
						txtCognomeUP2.setText(ctemp.getCognome());
						txtEmailUP.setText(ctemp.getEmail());
						txtTelefonoUP.setText(ctemp.getTelefono());
						
					}catch (Exception exc) {
						exc.printStackTrace();
					}
				}
			}
		});
		btnCaricaUP.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnCaricaUP.setBounds(558, 285, 207, 46);
		UpdatePanel.add(btnCaricaUP);
		
		JButton btnBackUP = new JButton("Back");
		btnBackUP.setForeground(new Color(99, 119, 223));
		btnBackUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
				txtNomeUP.setText("");
				txtNomeUP2.setText("");
				txtCognomeUP.setText("");
				txtCognomeUP2.setText("");
				txtEmailUP.setText("");
				txtTelefonoUP.setText("");
				txtIdUP.setText("");
				dtm3.setRowCount(0);
			}
		});
		btnBackUP.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnBackUP.setBounds(477, 491, 140, 46);
		UpdatePanel.add(btnBackUP);
		
		JLabel lblUpdatePanelBgImg = new JLabel("");
		lblUpdatePanelBgImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdatePanelBgImg.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/SearchBgImg_1000x600.png")));
		lblUpdatePanelBgImg.setBounds(0, 0, 973, 568);
		UpdatePanel.add(lblUpdatePanelBgImg);
		
		
		//Delete Panel---------------------------------------------//
		JPanel DeletePanel = new JPanel();
		tabbedPane.addTab("New tab", null, DeletePanel, null);
		DeletePanel.setLayout(null);
		
		JLabel lblTitoloDel = new JLabel("Cancella Contatto");
		lblTitoloDel.setForeground(new Color(255, 255, 255));
		lblTitoloDel.setBounds(304, 5, 335, 40);
		lblTitoloDel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 32));
		DeletePanel.add(lblTitoloDel);
		
		JButton btnNewButton_11 = new JButton("Back");
		btnNewButton_11.setForeground(new Color(99, 119, 223));
		btnNewButton_11.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton_11.setBounds(490, 390, 149, 46);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
				txtNomeDel.setText("");
				txtCognomeDel.setText("");;
				txtIdDel.setText("");
				dtm4.setRowCount(0);
			}
		});
		DeletePanel.add(btnNewButton_11);
		
		JLabel lblNomeDel = new JLabel("Nome");
		lblNomeDel.setForeground(new Color(255, 255, 255));
		lblNomeDel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNomeDel.setBounds(65, 91, 79, 32);
		DeletePanel.add(lblNomeDel);
		
		txtNomeDel = new JTextField();
		txtNomeDel.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtNomeDel.setBounds(156, 91, 183, 32);
		DeletePanel.add(txtNomeDel);
		txtNomeDel.setColumns(10);
		
		JScrollPane scrollPaneDel = new JScrollPane();
		scrollPaneDel.setBounds(65, 164, 700, 120);
		DeletePanel.add(scrollPaneDel);
		
		tableDel = new JTable();
		dtm4 = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID","Nome", "Cognome", "Telefono", "Email"
				});
		tableDel.setModel(dtm4);
		scrollPaneDel.setViewportView(tableDel);
		
		JButton btnCancella = new JButton("Elimina");
		btnCancella.setForeground(new Color(255, 38, 0));
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputId = txtIdDel.getText(); 
				int tId;
				
				try {
					tId = Integer.parseInt(inputId);
					
					int a = JOptionPane.showConfirmDialog(frmMyRubrica, "Sicuro di voler eliminare questo contatto?");
					
					if(a==0) {
						
						user.eliminaContatto(tId, dtm);
						
						
						JOptionPane.showMessageDialog(frmMyRubrica, "<html>Contatto rimosso con<br>successo nella rubrica!</html>");
						
						txtNomeDel.setText("");
						txtCognomeDel.setText("");;
						txtIdDel.setText("");
						dtm4.setRowCount(0);
					}
					
					
				}catch(Exception exce2) {
					exce2.printStackTrace();
				}
			}
		});
		btnCancella.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnCancella.setBounds(233, 390, 149, 46);
		DeletePanel.add(btnCancella);
		
		txtCognomeDel = new JTextField();
		txtCognomeDel.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtCognomeDel.setColumns(10);
		txtCognomeDel.setBounds(582, 88, 183, 32);
		DeletePanel.add(txtCognomeDel);
		
		JLabel lblCognomeDel = new JLabel("Cognome");
		lblCognomeDel.setForeground(new Color(255, 255, 255));
		lblCognomeDel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblCognomeDel.setBounds(446, 91, 108, 32);
		DeletePanel.add(lblCognomeDel);
		
		JButton btnTrovaDel = new JButton("Trova");
		btnTrovaDel.setForeground(new Color(99, 119, 223));
		btnTrovaDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delNome = txtNomeDel.getText();
				String delCognome = txtCognomeDel.getText();
				Contatto ctemp = new Contatto();
				ctemp.setCognome(delCognome);
				ctemp.setNome(delNome);
				
				if(!(delNome.isBlank()) || !(delCognome.isBlank())) {
					user.ricercaIdContatto(ctemp, dtm4);
					if (user.getTrovato2()) {}
					else {
						JOptionPane.showMessageDialog(frmMyRubrica, "Contatto cercato non trovato");
					}
				}
				else {
					JOptionPane.showMessageDialog(frmMyRubrica, "Inserire almeno uno tra nome e cognome");
				}
			}
		});
		btnTrovaDel.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnTrovaDel.setBounds(777, 199, 140, 46);
		DeletePanel.add(btnTrovaDel);
		
		JLabel lblIstruzioniDel = new JLabel("Id del contatto da eliminare :");
		lblIstruzioniDel.setForeground(Color.WHITE);
		lblIstruzioniDel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblIstruzioniDel.setBounds(233, 313, 284, 32);
		DeletePanel.add(lblIstruzioniDel);
		
		txtIdDel = new JTextField();
		txtIdDel.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtIdDel.setColumns(10);
		txtIdDel.setBounds(543, 313, 96, 32);
		DeletePanel.add(txtIdDel);
		
		JLabel lblLogo2_1 = new JLabel("");
		lblLogo2_1.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/my-rubrica-high-resolution-logo-white-on-transparent-background_2_20.png")));
		lblLogo2_1.setBounds(233, 448, 400, 100);
		DeletePanel.add(lblLogo2_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/SearchBgImg_1000x600.png")));
		lblNewLabel.setBounds(0, 0, 973, 568);
		DeletePanel.add(lblNewLabel);
		
		//------------------------------------------------------//
		
		JPanel AccountPanel = new JPanel();
		tabbedPane.addTab("New tab", null, AccountPanel, null);
		AccountPanel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Account Info");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setBounds(116, 25, 298, 40);
		lblNewLabel_9.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 32));
		AccountPanel.add(lblNewLabel_9);
		
		JButton btnNewButton_10 = new JButton("Back");
		btnNewButton_10.setForeground(new Color(99, 119, 223));
		btnNewButton_10.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton_10.setBounds(137, 347, 147, 56);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		AccountPanel.add(btnNewButton_10);
		
		JLabel lblNewLabel_8 = new JLabel("Username :");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(116, 108, 132, 29);
		AccountPanel.add(lblNewLabel_8);
		
		lblUsernameUtente = new JLabel("Placeholder");
		lblUsernameUtente.setForeground(new Color(99, 119, 223));
		lblUsernameUtente.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblUsernameUtente.setBounds(240, 108, 255, 29);
		AccountPanel.add(lblUsernameUtente);
		
		JLabel lblNewLabel_8_1 = new JLabel("Nome :");
		lblNewLabel_8_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_8_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_8_1.setBounds(116, 215, 132, 29);
		AccountPanel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("Cognome :");
		lblNewLabel_8_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_8_2.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_8_2.setBounds(116, 162, 132, 29);
		AccountPanel.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_8_3 = new JLabel("Email :");
		lblNewLabel_8_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_8_3.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_8_3.setBounds(116, 272, 132, 29);
		AccountPanel.add(lblNewLabel_8_3);
		
		lblCognomeUtente = new JLabel("Placeholder");
		lblCognomeUtente.setForeground(new Color(99, 119, 223));
		lblCognomeUtente.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblCognomeUtente.setBounds(240, 162, 255, 29);
		AccountPanel.add(lblCognomeUtente);
		
		lblNomeUtente = new JLabel("Placeholder");
		lblNomeUtente.setForeground(new Color(99, 119, 223));
		lblNomeUtente.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNomeUtente.setBounds(201, 215, 268, 29);
		AccountPanel.add(lblNomeUtente);
		
		lblEmailUtente = new JLabel("Placeholder");
		lblEmailUtente.setForeground(new Color(99, 119, 223));
		lblEmailUtente.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblEmailUtente.setBounds(201, 272, 228, 29);
		AccountPanel.add(lblEmailUtente);
		
		JButton btnNewButton_10_1 = new JButton("Delete Account");
		btnNewButton_10_1.setForeground(new Color(255, 38, 0));
		btnNewButton_10_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(frmMyRubrica, "Sicuro di voler eliminare questo account?");
				
				if(a==0) {
					
					user.cancellaUtente();
					
					dtm.setRowCount(0);
					
					tabbedPane.setSelectedIndex(0);
					
					JOptionPane.showMessageDialog(frmMyRubrica, "<html>Account cancellato con<br>successo. Logout effettuato!</html>");
				}
			}
		});
		btnNewButton_10_1.setBounds(137, 435, 204, 56);
		AccountPanel.add(btnNewButton_10_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/SignUpBgImg.jpg")));
		lblNewLabel_7.setBounds(0, 0, 973, 568);
		AccountPanel.add(lblNewLabel_7);
		
		JLabel lblLogo3_1 = new JLabel("");
		lblLogo3_1.setIcon(new ImageIcon(RubricaFinestra.class.getResource("/immagini/my-rubrica-high-resolution-logo-color-on-transparent-background_20.png")));
		lblLogo3_1.setBounds(481, 471, 400, 75);
		lblNewLabel_7.add(lblLogo3_1);
		
		
		
	}
}
