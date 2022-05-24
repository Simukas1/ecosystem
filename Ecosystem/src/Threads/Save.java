package Threads;

import Animal.*;
import java.io.*;
import java.util.*;

public class Save extends Thread {
	
	ArrayList<Cat> cats;
	ArrayList<Dog> dogs;
	ArrayList<Bird> birds;
	String fileName;
	
	public Save(ArrayList<Cat> cats, ArrayList<Dog> dogs, ArrayList<Bird> birds, String fileName) {
		this.cats = cats;
		this.dogs=dogs;
		this.birds=birds;
		this.fileName = fileName;
	}
	
	public void run() {
		
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			DataOutputStream outData = new DataOutputStream(file);

			int n = cats.size();
			outData.writeInt(n);

			for(int i=0; i<cats.size(); i++) {
				out.writeObject(cats.get(i));
			}

			n = dogs.size();
			outData.writeInt(n);

			for (int i=0; i<dogs.size(); i++){
				out.writeObject(dogs.get(i));
			}

			n = birds.size();
			outData.writeInt(n);

			for (int i=0; i<birds.size(); i++){
				out.writeObject(birds.get(i));
			}

			file.close();
			out.close();
			outData.close();
		}catch(FileNotFoundException e) {
			System.out.println("File not found! :(");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
