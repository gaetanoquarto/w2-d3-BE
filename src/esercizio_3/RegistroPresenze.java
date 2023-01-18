package esercizio_3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
	
	private static final String ENCODING = "utf-8";

	public static void main(String[] args) {
		
		String fileName = "presenze.txt";
		File file = new File(fileName);
		Scanner in = new Scanner(System.in);
		String separatore = System.lineSeparator();
		
		if(file.exists()) {
			System.out.println("Carico il registro presenze...");
			
			try {
				System.out.println("Digita il nome dello studente: ");
				String nome = in.nextLine();
				System.out.println("Assegna numero presenze: ");
				int presenza = in.nextInt();
				Presenza p1 = new Presenza(nome, presenza);
				scriviSuFile(file, p1.toString(), true);
				System.out.println("Presenza aggiunta!");
			} catch(IOException e) {
			}
				System.out.println("Leggi il file:");
			
			try {
				leggiFile(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.printf("il file %s non esiste %n", fileName);			
		}
		
		in.close();

	}
	public static void scriviSuFile(File file, String str, boolean aggiungi) throws IOException {
		
		FileUtils.writeStringToFile(file, str, ENCODING, true);
	}
	public static void leggiFile(File file) throws IOException {
	String content = FileUtils.readFileToString(file, ENCODING);
		System.out.println(content);
	}

}

 class Presenza {

	String nome;
	int numPresenze;
	
	public Presenza(String nome, int numPresenze) {
		this.nome = nome;
		this.numPresenze = numPresenze;
	}
	
	@Override
	public String toString() {
		String s = String.format(this.nome + "@" + this.numPresenze + "#");		
		return s;
	}
	
}
