package rubricaClassi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.DefaultTableModel;

public class Rubrica {
	private int userId;
	private String username;
	private String password;
	private Connessione Conn;
	private String email;
	private String nome ;
	private String cognome;

	boolean loaded;
	private ArrayList<Contatto> contatti = new ArrayList<Contatto>();
	private boolean trovato;
	private boolean trovato2;
	
	public Rubrica() {}
	

	public Rubrica(String username, String password, String email, String nome, String cognome) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
	}
	

	public Rubrica(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	public void faiLogin() {
		
		Conn = new Connessione();
		
		String sql = "select nome, cognome, email, iduser_account from user_account where username='" + this.username + "' and password='" + this.password + "'";
		
		try {
			ResultSet myRs = Conn.getMyStmt().executeQuery(sql);
			while (myRs.next()) {
				//passo i dati dell'utente
				this.setNome(myRs.getString("nome"));
				this.setCognome(myRs.getString("cognome"));
				this.setEmail(myRs.getString("email"));
				this.setUserId(myRs.getInt("iduser_account"));
			}
			
			myRs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	
	public void faiLogout() {
		this.Conn.chiudiConnessione();
		this.nome = null;
		this.cognome = null;
		this.username = null;
		this.password = null;
		this.email = null;
		this.userId=0;
		loaded=false;
		trovato = false;
		contatti.clear();
	}
	
	
	public void registraUtente() {
		
		Connessione con = new Connessione();
		
		String user = this.username;
		String pass = this.password;
		String email = this.email;
		String nome = this.nome;
		String cognome = this.cognome;
		
		String sql = "insert into user_account (username, password, email, nome, cognome) values ('" 
				+user+ "', '" +pass+ "', '" +email+ "', '" +nome+ "', '" +cognome+ "')";
		
		try {
			con.getMyStmt().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			con.chiudiConnessione(); 
		}
	}
	
	
	public boolean isRegistrato() {
		
		boolean registrato = false;
		Connessione con = new Connessione();
		
		String user = this.username;
		   
		String sql = "select * from user_account where username='" + user + "'";
		
		try {
			ResultSet myRs = con.getMyStmt().executeQuery(sql);
			
			if(myRs.next()) {
				registrato = true;
				
			}
			else {
				registrato = false;
				
			}
			
			myRs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			con.chiudiConnessione();
		}
		
		return registrato;
	}
	
	public boolean passwordRiconosciuto() {
		boolean riconosciuto = false;
		Connessione con = new Connessione();
		String user = this.username;
		String password = this.password;
		
		String sql = "select * from user_account where username='" + user + "' and password='" + password + "'";
		
		try {
			ResultSet myRs = con.getMyStmt().executeQuery(sql);
			
			if(myRs.next()) {
				riconosciuto = true;
				
			}
			else {
				riconosciuto = false;
				
			}
			
			myRs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			con.chiudiConnessione();
		}
		
		return riconosciuto;
	}
	
	public void caricaContatti(DefaultTableModel tablemodel) {
		
		if(!loaded) {
			String sql = "select nome, cognome, telefono, email, id from contatto where user = '" + this.username + "'";
			
			try {
				ResultSet myRs = Conn.getMyStmt().executeQuery(sql);

				while (myRs.next()) {
					//passo i dati alla tabella
					Contatto contatto = new Contatto();
					
					contatto.setNome(myRs.getString("nome"));
					contatto.setCognome(myRs.getString("cognome"));
					contatto.setTelefono(myRs.getString("telefono"));
					contatto.setEmail(myRs.getString("email"));
					contatto.setId(myRs.getInt("id"));
					
					contatti.add(contatto);
				
				}
				
				Collections.sort(contatti);
				
				Contatto[] tmpArrCont = contatti.toArray(new Contatto[contatti.size()]);
				
				for(int i=0; i<tmpArrCont.length; i++) {
					tablemodel.addRow(tmpArrCont[i].getDati());
				}
				
				loaded = true;
				
				myRs.close();
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void aggiungiContatto(Contatto contact, DefaultTableModel tablemodel) {
		
		caricaContatti(tablemodel);
	
		String sql = "insert into contatto (nome, cognome, telefono, email, user) values ('" 
				+contact.getNome()+ "', '" +contact.getCognome()+ "', '" +contact.getTelefono()+ "', '" 
				+contact.getEmail()+ "', '" +this.getUsername()+ "')";
		
		
		try {
			Conn.getMyStmt().executeUpdate(sql);
			
			String query = "select id from contatto where nome='" 
					+contact.getNome()+ "' and telefono='" +contact.getTelefono()+ "' and email='" 
					+contact.getEmail()+"' and user='" +this.getUsername()+ "'";
			
			try {
				ResultSet myRs = Conn.getMyStmt().executeQuery(query);

				while (myRs.next()) {
					
					contact.setId(myRs.getInt("id"));
					contatti.add(contact);
					this.riordinaLista(tablemodel);
					
					
				}
				
			}catch(Exception exce1) {
					exce1.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void riordinaLista(DefaultTableModel tablemodel) {
		Collections.sort(contatti);
		
		tablemodel.setRowCount(0);
		loaded = false;
		
		Contatto[] tmpArrCont = contatti.toArray(new Contatto[contatti.size()]);
		
		for(int i=0; i<tmpArrCont.length; i++) {
			tablemodel.addRow(tmpArrCont[i].getDati());
		}
		
		loaded = true;
	}
	
	public void ricercaContatto(Contatto contact, DefaultTableModel tablemodel) {
		
		String sql = "select nome, cognome, telefono, email from contatto where user = '" + this.username 
				+ "' and nome like '" + contact.getNome() + "%' and cognome like '" + contact.getCognome() + "%'";
		
		if(contact.getCognome().isBlank()) {
			 sql = "select nome, cognome, telefono, email from contatto where user = '" + this.username 
					+ "' and nome like '" + contact.getNome() + "%'";
		}
		
		if(contact.getNome().isBlank()) {
			sql = "select nome, cognome, telefono, email from contatto where user = '" + this.username 
					+ "' and cognome like '" + contact.getCognome() + "%'";
			
		}
		
		ArrayList<Contatto> tmpArrLst = new ArrayList<Contatto>();
		
		tablemodel.setRowCount(0);
		trovato = false;
		
		try {
			ResultSet myRs = Conn.getMyStmt().executeQuery(sql);

			while (myRs.next()) {
				//passo i dati alla tabella
				Contatto contatto = new Contatto();
				
				contatto.setNome(myRs.getString("nome"));
				contatto.setCognome(myRs.getString("cognome"));
				contatto.setTelefono(myRs.getString("telefono"));
				contatto.setEmail(myRs.getString("email"));
				
				tmpArrLst.add(contatto);
			
			}
			
			if(tmpArrLst.size()>0) {
				Collections.sort(tmpArrLst);
				
				Contatto[] tmpArrCont = tmpArrLst.toArray(new Contatto[tmpArrLst.size()]);
				
				for(int i=0; i<tmpArrCont.length; i++) {
					tablemodel.addRow(tmpArrCont[i].getDati());
				}
				
				trovato = true;
			}
			else trovato = false;
			
			
			myRs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void ricercaIdContatto(Contatto contact, DefaultTableModel tablemodel) {
		
		String sql = "select id, nome, cognome, telefono, email from contatto where user = '" + this.username 
				+ "' and nome like '" + contact.getNome() + "%' and cognome like '" + contact.getCognome() + "%'";
		
		if(contact.getCognome().isBlank()) {
			 sql = "select id, nome, cognome, telefono, email from contatto where user = '" + this.username 
					+ "' and nome like '" + contact.getNome() + "%'";
		}
		
		if(contact.getNome().isBlank()) {
			sql = "select id, nome, cognome, telefono, email from contatto where user = '" + this.username 
					+ "' and cognome like '" + contact.getCognome() + "%'";
			
		}
		
		ArrayList<Contatto> tmpArrLst = new ArrayList<Contatto>();
		
		tablemodel.setRowCount(0);
		trovato2 = false;
		
		try {
			ResultSet myRs = Conn.getMyStmt().executeQuery(sql);

			while (myRs.next()) {
				//passo i dati alla tabella
				Contatto contatto = new Contatto();
				
				contatto.setNome(myRs.getString("nome"));
				contatto.setCognome(myRs.getString("cognome"));
				contatto.setTelefono(myRs.getString("telefono"));
				contatto.setEmail(myRs.getString("email"));
				contatto.setId(myRs.getInt("id"));
				
				tmpArrLst.add(contatto);
			
			}
			
			if(tmpArrLst.size()>0) {
				if(tmpArrLst.size()>1) Collections.sort(tmpArrLst);
				
				Contatto[] tmpArrCont = tmpArrLst.toArray(new Contatto[tmpArrLst.size()]);
				
				for(int i=0; i<tmpArrCont.length; i++) {
					tablemodel.addRow(tmpArrCont[i].getDati2());
				}
				trovato2 = true;
			}
			else trovato2 = false;
			
			
			
			myRs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Contatto getContattoById(int id) {
		
		String sql = "select nome, cognome, telefono, email from contatto where user = '" + this.username 
				+ "' and id='" + id + "'";
		
		Contatto contatto = new Contatto();
		
		try {
			ResultSet myRs = Conn.getMyStmt().executeQuery(sql);

			while (myRs.next()) {
				
				contatto.setNome(myRs.getString("nome"));
				contatto.setCognome(myRs.getString("cognome"));
				contatto.setTelefono(myRs.getString("telefono"));
				contatto.setEmail(myRs.getString("email"));
				contatto.setId(id);
			}
			
		}catch(Exception exce) {
			exce.printStackTrace();
		}
		
		return contatto;
	}
	
	public void aggiornaContatto(int id, Contatto nuovo, DefaultTableModel tablemodel) {
		
		String sql = "update contatto set nome = '"+nuovo.getNome()+"', cognome = '"+nuovo.getCognome()+"', telefono = '"+
		nuovo.getTelefono()+"', email = '"+nuovo.getEmail()+"' where id='" + id + "'";
		
		
		try {
			Conn.getMyStmt().executeUpdate(sql);
			int i=0;
			for(Contatto c : contatti) {
				
				if(c.getId()==nuovo.getId()) {
					contatti.set(i, nuovo);
					break;
				}
				else i++;
			}
			
			this.riordinaLista(tablemodel);
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void eliminaContatto(int id, DefaultTableModel tablemodel) {
		
		String sql = "delete from contatto where user = '" + this.username + "' and id='" + id + "'";
		
		try {
			Conn.getMyStmt().executeUpdate(sql);
			int i=0;
			for(Contatto c : contatti) {
				
				if(c.getId()==id) {
					contatti.remove(i);
					break;
				}
				else i++;
			}
			
			this.riordinaLista(tablemodel);
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void cancellaUtente () {
		
		String sql = "delete from contatto where user = '" + this.username + "';";
		
		String sql2 = "delete from user_account where iduser_account='" + this.userId + "';";
		
		try {
			Conn.getMyStmt().executeUpdate(sql);
			
			Connessione Conn2 = new Connessione();
			Conn2.getMyStmt().executeUpdate(sql2);
			
			this.faiLogout();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public String getUsername() {
		return username;
	}
	

	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getPassword() {
		return password;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public String getCognome() {
		return cognome;
	}
	

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	


	public Connessione getConn() {
		return Conn;
	}


	public boolean getTrovato() {
		return trovato;
	}


	public void setTrovato(boolean trovato) {
		this.trovato = trovato;
	}


	public boolean getTrovato2() {
		return trovato2;
	}


	public void setTrovato2(boolean trovato2) {
		this.trovato2 = trovato2;
	}
	
	void provaStampaLista() {
		System.out.println(this.contatti.toString());
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
