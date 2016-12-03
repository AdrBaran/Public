package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import data.Library;

public class FileManager {
	public static final String FILE_NAME = "Library.o";
	
	public void writeLibraryToFile(Library lib) {
		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
				) {
			oos.writeObject(lib);
		} catch (FileNotFoundException e) {
			System.out.println("Nie odnaleziono pliku: " + FILE_NAME);
		} catch (IOException e) {
			System.out.println("Błąd podczas zapisu pliku.");
		}
	}
	
	public Library readLibraryFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		Library library= null;
		try (
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
				) {
			library = (Library)ois.readObject();
		} catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + FILE_NAME);
            throw e;
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu danych do pliku " + FILE_NAME);
            throw e;
        } catch (ClassNotFoundException e) {
            System.err.println("Nieprawidłowy format pliku");
            throw e;
        }
		
		return library;
	}
}
