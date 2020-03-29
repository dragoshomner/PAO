package ex2;

public class Album {
	String nume;
	int anulPublicarii;
	int rating;
	
	public Album(String nume, int anulPublicarii, int rating) {
		this.nume = nume;
		this.anulPublicarii = anulPublicarii;
		this.rating = rating;
	}
	
	String getNume() {
		return nume;
	}
	
	void setNume(String nume) {
		this.nume = nume;
	}
	
	int getAnulPublicarii() {
		return anulPublicarii;
	}
	
	void setAnulPublicarii(int anulPublicarii) {
		this.anulPublicarii = anulPublicarii;
	}

	int getRating() {
		return rating;
	}
	
	void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Nume: " + nume + " Rating: " + rating + " Anul publicarii: " + anulPublicarii;
	} 
}
