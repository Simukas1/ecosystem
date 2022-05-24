package Threads;

import Animal.*;
import java.io.*;
import java.util.ArrayList;

public class Load extends Thread {

	ArrayList<Cat>cats;
	ArrayList<Dog>dogs;
	ArrayList<Bird>birds;
	String fileName;
	
	public Load(String fileName) {
		this.fileName = fileName;
	}
	
	public ArrayList<Cat> getCats() {
		return cats;
	}
	public ArrayList<Dog> getDogs() {return dogs;}
	public ArrayList<Bird> getBirds(){return birds;}
	
	public void run() {
		
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);
			DataInputStream din = new DataInputStream(file);

			int n =din.readInt();

			for (int i=0; i<n; ++i) {
				try {
					Cat a;
					a = (Cat) in.readObject();
					cats.add(a);
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

			n = din.readInt();
			for (int i=0; i<n; i++){
				try{
					Dog a;
					a = (Dog)in.readObject();
					dogs.add(a);
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}
			}

			n = din.readInt();
			for (int i=0; i<n; i++){
				try{
					Bird a;
					a = (Bird)in.readObject();
					birds.add(a);
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			file.close();
			in.close();
			
			} catch(FileNotFoundException e) {
			System.out.println("Cant find file! :(");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
