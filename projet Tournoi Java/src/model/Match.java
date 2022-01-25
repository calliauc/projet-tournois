package model;

public class Match {

	/// ATTRIBUTES
	
	protected int idExterieur ; 
	protected int idDomicile ;
	protected Integer scoreExterieur=null ; 
	protected Integer scoreDomicile=null ; 
	protected Integer idGagnant = null ; 
	protected int idJournee ; 
	protected int idTournoi ;
	
	/// CONSTRUCTOR
	
	public Match(int idExterieur, int idDomicile, int idJournee, int idTournoi) {
		this.idExterieur = idExterieur;
		this.idDomicile = idDomicile;
		this.idJournee = idJournee;
		this.idTournoi = idTournoi;
	}

	/// GETTERS
	
	public int getIdExterieur() {
		return idExterieur;
	}

	public int getIdDomicile() {
		return idDomicile;
	}
	
	public int getIdJournee() {
		return idJournee;
	}

	public int getIdTournoi() {
		return idTournoi;
	}

	
	/// SETTERS
	
	public void setIdExterieur(int idExterieur) {
		this.idExterieur = idExterieur;
	}

	
	public void setIdDomicile(int idDomicile) {
		this.idDomicile = idDomicile;
	}

	
	public void setIdJournee(int idJournee) {
		this.idJournee = idJournee;
	}

	
	public void setIdTournoi(int idTournoi) {
		this.idTournoi = idTournoi;
	}

	
	
	/// METHODS
	
	@Override
	public String toString() {
		return "Match [idExterieur=" + idExterieur + ", idDomicile=" + idDomicile + ", idJournee=" + idJournee
				+ ", idTournoi=" + idTournoi + "]";
	} 
	
	
	
	
	
	
}
