package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	protected Innlegg[] innleggTabell;
	protected int nesteLedig;

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
		if (ledigPlass() && finnInnlegg(innlegg) == -1) {			
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
		Innlegg[] tmp = this.innleggTabell.clone();
		this.innleggTabell = new Innlegg[tmp.length * 2];
		int i = 0;
		for (Innlegg each: tmp) {
			this.innleggTabell[i] = each;
			i++;
		}
		tmp = null;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if(!ledigPlass()) {
			utvid();
		}
		return leggTil(innlegg);
		
	}
	
	public boolean slett(Innlegg innlegg) {
		boolean flag = false;
		for(int i = 0; i < this.nesteLedig; i++) {
			if (innlegg.erLik(this.innleggTabell[i])) {
				this.innleggTabell[i] = null;
				flag = true;
				this.nesteLedig --;
			}
			// moves every element one further back in the array so
			// that the empty space left by slett gets filled and nesteLedig remains accurate
			if (flag && this.nesteLedig > i+1) {
				this.innleggTabell[i] = this.innleggTabell[i+1];
				
			}
		}
		return flag;
	}
	
	public int[] search(String keyword) {
		int[] idList = new int[this.nesteLedig];
		int i = 0;
		for (Innlegg each: this.innleggTabell) {
			if (each.getTekst().contains(keyword)) {
				idList[i] = each.getId();
				i++;
			}
		}
		return idList;
	}
}