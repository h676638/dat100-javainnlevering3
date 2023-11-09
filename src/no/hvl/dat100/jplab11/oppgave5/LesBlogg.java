package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		Innlegg innlegg;
		Blogg blogg = new Blogg();
		try {
			FileReader file = new FileReader(mappe + filnavn);
			BufferedReader reader = new BufferedReader(file);
			String x = reader.readLine();
			int amount = Integer.parseInt(x);
			x = null;
			for (int i = 0; i < amount; i++) {
				String type = reader.readLine();
				int id = Integer.parseInt(reader.readLine());
				String bruker = reader.readLine();
				String dato = reader.readLine();
				int likes = Integer.parseInt(reader.readLine());
				String tekst = reader.readLine();
				if (type.equals(TEKST)) {
					innlegg = new Tekst(id, bruker, dato, likes, tekst);
				}
				else if (type.equals(BILDE)) {
					String url = reader.readLine();
					innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
				}
				else {
					continue;
				}
				blogg.leggTilUtvid(innlegg);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return blogg;
		
	}
}
