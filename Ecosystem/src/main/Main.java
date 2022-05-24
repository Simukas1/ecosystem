package main;

import java.util.*;
import Animal.*;
import java.util.concurrent.TimeUnit;
import Threads.*;

public class Main {



	public static void main(String[] args)  {
		
		boolean end = false;
		Scanner cin = new Scanner(System.in);

		ArrayList<Cat> cats = new ArrayList<>();
		ArrayList<Dog> dogs = new ArrayList<>();
		ArrayList<Bird> birds = new ArrayList<>();

		cats.add(new Cat(10, 10));


		cats.add(new Cat(12, 10));


		Thread save = new Save(cats, dogs, birds, "rezai");
		Load load = new Load("rezai");
		
		int input;
		System.out.println("Sveiki, cia yra ekosistema.");
		
		while (!end) {
			printMap(cats, dogs, birds);
			System.out.println("Instrukcijos:\n0 - baigti zaidima\n1-load\n2-save\n3-veikti su sunimi\n4-veikti su kate\n5-veikti su pauksciu\n6-prideti suni\n7-prideti katina\n8-prideti pauksti");
			input = cin.nextInt();
			if (input == 0) {
				end = true;
			}
			else if (input == 1) {
				load.start();
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cats = load.getCats();
				dogs = load.getDogs();
				birds = load.getBirds();
			}
			else if (input == 2) {
				save.start();
			}
			else if (input == 3){
				inputIsDogs(dogs);
			}
			else if (input == 4){
				inputIsCats(cats);
			}
			else if (input == 5){
				inputIsBirds(birds);
			}
			else if (input == 6){
				System.out.println("iveskite x ir y");
				int x, y;
				x = cin.nextInt();
				y = cin.nextInt();
				dogs.add(new Dog(x, y));
			}
			else if (input == 7){
				System.out.println("iveskite x ir y");
				int x, y;
				x = cin.nextInt();
				y = cin.nextInt();
				cats.add(new Cat(x, y));
			}
			else if (input == 8){
				System.out.println("iveskite x ir y");
				int x, y;
				x = cin.nextInt();
				y = cin.nextInt();
				birds.add(new Bird(x, y));
			}
			boolean dauginosi = false;
			for (int i=0; i<cats.size(); i++){
				for (int j=i+1; j<cats.size(); j++){
					if (cats.get(i).getX()==cats.get(j).getX() && cats.get(i).getY()==cats.get(j).getY() && !dauginosi){
						System.out.println("Katinai gali daugintis. Ar norite, kad atsirastu dar vienas katinas? 0 - ne, 1 - taip");
						int n = cin.nextInt();
						if (n==1){
							cats.add(new Cat(cats.get(i).getX(), cats.get(i).getY()));
							dauginosi = true;
						}

					}
				}
			}
			for (int i=0; i<dogs.size(); i++){
				for (int j=i+1; j<dogs.size(); j++){
					if (dogs.get(i).getX()==dogs.get(j).getX() && dogs.get(i).getY()==dogs.get(j).getY() && !dauginosi){
						System.out.println("Sunys gali daugintis. Ar norite, kad atsirastu dar vienas suo? 0 - ne, 1 - taip");
						int n = cin.nextInt();
						if (n==1){
							dogs.add(new Dog(dogs.get(i).getX(), dogs.get(i).getY()));
							dauginosi = true;
						}
						break;
					}
				}
			}
		}
		cin.close();
	}
	
	public static void printMap(ArrayList<Cat> cats, ArrayList<Dog>dogs, ArrayList<Bird> birds) {
		int catCnt=1, dogCnt=1, birdCnt=1;
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++) {
				boolean wrote = false;
				for (Cat cat : cats) {
					if (cat.getY() == i && cat.getX() == j) {
						System.out.print("C");
						System.out.print(catCnt);
						catCnt++;
						wrote = true;
						break;
					}

				}
				for (Dog dog : dogs) {
					if (dog.getY() == i && dog.getX() == j) {
						System.out.print("D");
						System.out.print(dogCnt);
						dogCnt++;
						wrote = true;
						break;
					}

				}
				for (Bird bird : birds) {
					if (bird.getY() == i && bird.getX() == j) {
						System.out.print("B");
						System.out.print(birdCnt);
						birdCnt++;
						wrote = true;
						break;
					}
				}
				if (!wrote){
					System.out.print(". ");
				}
			}
			System.out.print("\n");
		}
	}

	public static void inputIsCats(ArrayList<Cat> cats){
		if (cats.size()==0){
			return;
		}
		System.out.println("Su kuriuo katinu norite dirbti?");
		for (int i=0; i<cats.size(); i++){
			System.out.print(i+1);
			System.out.print(' ');
		}
		System.out.print('\n');
		Scanner cin = new Scanner(System.in);
		int kelintas = cin.nextInt();
		kelintas--;

		System.out.println("Ka norite daryti su katinu?");
		System.out.println("1-Judeti i virsu\n2-judeti i desine\n3-judeti i apacia\n4-judeti i kaire\n5-selinti\n6-baigti selinti");

		int input = cin.nextInt();
		if (input==1){
			cats.get(kelintas).moveUp();
		}
		else if (input == 2){
			cats.get(kelintas).moveRight();
		}
		else if (input == 3){
			cats.get(kelintas).moveDown();
		}
		else if (input == 4){
			cats.get(kelintas).moveLeft();
		}
		else if (input == 5){
			cats.get(kelintas).sneak();
		}
		else{
			cats.get(kelintas).stopSneak();
		}
	}

	public static void inputIsDogs(ArrayList<Dog> dogs){
		if (dogs.size()==0){
			return;
		}
		System.out.println("Su kuriuo suniu norite dirbti?");
		for (int i=0; i<dogs.size(); i++){
			System.out.print(i+1);
			System.out.print(' ');
		}
		System.out.print('\n');
		Scanner cin = new Scanner(System.in);
		int kelintas = cin.nextInt();
		kelintas--;

		System.out.println("Ka norite daryti su katinu?");
		System.out.println("1-Judeti i virsu\n2-judeti i desine\n3-judeti i apacia\n4-judeti i kaire\n5-begti\n6-baigti begti");

		int input = cin.nextInt();
		if (input==1){
			dogs.get(kelintas).moveUp();
		}
		else if (input == 2){
			dogs.get(kelintas).moveRight();
		}
		else if (input == 3){
			dogs.get(kelintas).moveDown();
		}
		else if (input == 4){
			dogs.get(kelintas).moveLeft();
		}
		else if (input == 5){
			dogs.get(kelintas).run();
		}
		else{
			dogs.get(kelintas).stopRun();
		}
	}


	public static void inputIsBirds(ArrayList<Bird> birds){
		if (birds.size()==0){
			return;
		}
		System.out.println("Su kuriuo pauksciu norite dirbti?");
		for (int i=0; i<birds.size(); i++){
			System.out.print(i+1);
			System.out.print(' ');
		}
		System.out.print('\n');
		Scanner cin = new Scanner(System.in);
		int kelintas = cin.nextInt();
		kelintas--;

		System.out.println("Ka norite daryti su pauksciu?");
		System.out.println("1-Judeti i virsu\n2-judeti i desine\n3-judeti i apacia\n4-judeti i kaire\n5-skrist\n6-nustoti skristi");

		int input = cin.nextInt();
		if (input==1){
			birds.get(kelintas).moveUp();
		}
		else if (input == 2){
			birds.get(kelintas).moveRight();
		}
		else if (input == 3){
			birds.get(kelintas).moveDown();
		}
		else if (input == 4){
			birds.get(kelintas).moveLeft();
		}
		else if (input == 5){
			birds.get(kelintas).sneak();
		}
		else{
			birds.get(kelintas).stopSneak();
		}
	}

}
