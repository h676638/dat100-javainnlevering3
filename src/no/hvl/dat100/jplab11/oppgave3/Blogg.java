package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	Innlegg[] innleggTabell;
	int nesteLedig;

	public Blogg() {
		this.innleggTabell = new Innlegg[20];
		this.nesteLedig = 0;
	}

	public Blogg(int lengde) {
		this.innleggTabell = new Innlegg[lengde];
		this.nesteLedig = 0;
	}

	public int getAntall() {
		return this.nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return this.innleggTabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for(int i = 0 ; i < this.nesteLedig ; i++) {
			if(innlegg.erLik(this.innleggTabell[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if (finnInnlegg(innlegg) != -1) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean ledigPlass() {
		if (this.nesteLedig < this.innleggTabell.length) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (ledigPlass()) {			
			this.innleggTabell[this.nesteLedig] = innlegg;
			this.nesteLedig ++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String returnString = Integer.toString(this.nesteLedig) + "\n";
		for (int i = 0; i < this.nesteLedig; i++) {
			returnString += this.innleggTabell[i].toString();
		}
		return returnString;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}