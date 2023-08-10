package rubricaClassi;


public class Contatto implements Comparable<Contatto> {
	private int id;
	private String nome;
	private String cognome;
	private String telefono;
	private String email;
	
	private String[] dati = new String[4];
	private String[] dati2 = new String[5];

	
	public Contatto() {}
	
	
	public Contatto(String nome, String cognome, String telefono, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		dati[0]= this.nome;
		dati[1]= this.cognome;
		dati[2]= this.telefono;
		dati[3]= this.email;
	}
	
	@SuppressWarnings("removal")
	public Contatto(String nome, String cognome, String telefono, String email, int id) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.id = id;
		dati[0]= this.nome;
		dati[1]= this.cognome;
		dati[2]= this.telefono;
		dati[3]= this.email;
		dati2[0]= (new Integer(this.id)).toString();
		dati2[1]= this.nome;
		dati2[2]= this.cognome;
		dati2[3]= this.telefono;
		dati2[4]= this.email;
	}

	
	

	public int getId() {
		return id;
	}


	@SuppressWarnings("removal")
	public void setId(int id) {
		this.id = id;
		dati2[0]= (new Integer(this.id)).toString();
	}


	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String name) {
		this.nome = name;
		dati[0]= this.nome;
		dati2[1]= this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public void setCognome(String surname) {
		this.cognome = surname;
		dati[1]= this.cognome;
		dati2[2]= this.cognome;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
		dati[2]= this.telefono;
		dati2[3]= this.telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
		dati[3]= this.email;
		dati2[4]= this.email;
	}


	public String[] getDati() {
		return dati;
	}
	
	public String[] getDati2() {
		return dati2;
	}


	public void setDati(String[] dati) {
		this.dati = dati;
		this.nome = dati[0];
		this.cognome = dati[1];
		this.telefono = dati[2];
		this.email = dati[3];
		
	}
	
	public void setDati2(String[] dati2) {
		this.dati2 = dati2;
		this.nome = dati2[1];
		this.cognome = dati2[2];
		this.telefono = dati2[3];
		this.email = dati2[4];
		try {
			this.id = Integer.parseInt(dati2[0]);
		}catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	

	@Override
	public String toString() {
		return "Contatto [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", telefono=" + telefono + ", email="
				+ email + "]";
	}


	@Override
	public int compareTo(Contatto o) {
		// TODO Auto-generated method stub
		return nome.compareTo(o.nome);
	}
	
	
	
	

}
