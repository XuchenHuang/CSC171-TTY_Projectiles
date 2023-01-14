import java.util.Scanner;

public class EX2 {
		public static void main(String[] args) {
			double v; //create a new Double variable v to store the value of launch speed
			double h = 0.0; //create a new Double variable h to store the value of the wall's height
			double x = 0.0; //create a new Double variable v to store the value of the distance between the wall and the catapult 
			double angle; //create a new Double variable angle to store the value of launch angle 
			int score = 100; //create a new int variable score and set it to 100. score will be used to store user's score after each launch
			double g = 9.8; // create a new Double variable g and set it to 9.8. g represents the g is the acceleration due to gravity.
			Scanner input=new Scanner(System.in); //The System.in argument tells the scanner to read from standard input
			double ws = 0.1;// create a new Double variable ws to store the value of the moving speed of the wall and set it to 0.1m/s	
			// create a new int variable condition and set it to 1. condition will be used to set the condition of the if statement which prevent users from entering Continue in the first launch
			int condition = 1;
			
			while(score>0) { // set the condition of the while loop. when user's score is greater than 0, user can start the new launch of the game
				System.out.println("Enter your choice: Continue or New or Quit"); // ask user to enter the choice	
				long starttime = System.currentTimeMillis(); // start timing after the user enter the choice (Extra credit Q3)			
				String c = input.next(); // Use Scanner to get input from users
				if (condition == 1 && c.equals("Continue") ) { // set the condition of the if statement. This if statement make sure that users cannot enter Continue in the first launch
					System.out.println("You cannot choose Continue in the first launch! Try Again!");
					break; // end the game if user enter Continue in the first launch	
				}
				if(c.equals("New")){ // set condition of the if statement in order to start a new launch
					condition =2; // change the value of condition to 2 in order to end the if statement which make sure that user does not enter Continue in the first launch 
					h = Math.random()*20+1;// use Math.random() to generate the random value of the height of the wall
					x = Math.random()*20+1;// use Math.random() to generate the random value of the distance between the wall and the catapult
					System.out.print("Please enter your speed: "); // ask users to enter the speed
					v = input.nextDouble(); // use Scanner to get input from users
					System.out.print("Please enter your angle: "); // ask users to enter the angle 
					angle= input.nextDouble(); // use Scanner to get input from users
					long endtime = System.currentTimeMillis(); // end timing after the user enter the speed and the angle
					double timediff = (endtime - starttime)/1000; // calculate the difference between start time and end time and store the value in new double variable timediff
					double Ftime=(2*v*Math.sin(Math.toRadians(angle))/g); // calculate the fight time of the projectile motion
					timediff=timediff+Ftime; // calculate the time difference between the time user input "Continue" or "New" and the time the projectile hit the wall
					// set condition of if else statement. timediff*ws equals the distance the wall moves. If the distance that the wall moves is greater the distance between the wall and the catapult, the game ends. If it doesn't, the game continues
					if(timediff*ws<x) { 
						x=x-timediff*ws;
					//calculate the height of the projectile when it is right above the wall
					double y = x*Math.tan(Math.toRadians(angle))-(g*x*x)/(2*(v*(Math.cos(Math.toRadians(angle)))-10)*Math.cos(Math.toRadians(angle)));
					double difference = y-h; //calculate the difference between the height of the projectile when it is right above the wall and the height of wall
					
					// set the condition of the if else statement to give users different scores and print out different comments based on the result of their inputs
					if(difference <= 3 && difference > 0) { 
						System.out.println("You made it!");
						double a = 3*Math.random(); // create a new Double variable a and set it to random value between 0 and 3 in order to set teh condition of the following if else statement
						//print different encouragements based on the value of a
						if(a<1) {
							System.out.println("GOOD!");
						}
						else if(a<2) {
							System.out.println("NICE!");
						}
						else if(a<3) {
							System.out.println("AWESOME!");
						}
						score += 5; // add 5 scores when the difference between the height of the projectile when it is right above the wall and the height of wall is less than or equals to 3
					}
					else if(difference > 3) {
						System.out.println("Plenty of room!");
						score +=3; // add 3 scores when the difference between the height of the projectile when it is right above the wall and the height of wall is greater to 3
						double a = 3*Math.random();
						if(a<1) {
							System.out.println("COME ON!");
						}
						else if(a<2) {
							System.out.println("YOU CAN DO IT!");
						}
						else if(a<3) {
							System.out.println("FIGHTING!");
						}
					}
					else if(difference < 0 && difference > -3 ) {
						System.out.println("not quite over!");
						double a = 3*Math.random();
						//print different encouragements based on the value of a
						if(a<1) {
							System.out.println("YELLOWJACKET!");
						}
						else if(a<2) {
							System.out.println("MELIORA!");
						}
				
						else if(a<3) {
							System.out.println("GENESEE!");
						}
						score += 0; // add 0 scores when the projectile hits the wall, and the distance between the projectile and the top of the wall is less or equals to 3
					}
					else {
						System.out.println("Not even close!");
						double a = 3*Math.random();
						//print different encouragements based on the value of a
						if(a<1) {
							System.out.println("WORK HARD!");
						}
						else if(a<2) {
							System.out.println("STAY STRONG!");
						}
						else if(a<3) {
							System.out.println("DON'T GIVE UP!");
						}
						score -= 2; // minus 2 scores when the projectile hits the wall, and the distance between the projectile and the top of the wall is greater than 3
					}
					    score -= 1; // minus 1 score after user's each launch since each launch costs 1 score
					    System.out.println("Your score is: "+score); // print the score after user's each launch 
				}
					System.out.println("The distance is: " + x + "\nThe height is: "+ h);
					
					
				}
			else if(c.equals("Continue")) { // set condition of the if statement in order to start a new launch
					System.out.print("Please enter your speed: "); // ask users to enter the speed
					v = input.nextDouble(); // use Scanner to get input from users
					System.out.print("Please enter your angle: "); // ask users to enter the angle 
					angle= input.nextDouble(); // use Scanner to get input from users
				long endtime = System.currentTimeMillis(); // end timing after the user enter the speed and the angle
				double timediff = (endtime - starttime)/1000; // calculate the difference between start time and end time and store the value in new double variable timediff
				double Ftime=(2*v*Math.sin(Math.toRadians(angle))/g); // calculate the flight time of the projectile motion
				timediff=timediff+Ftime; // calculate the time difference between the time user input "Continue" or "New" and the time when the projectile hits the wall
				// set condition of if else statement. timediff*ws equals the distance the wall moves. If the distance that the wall moves is greater the distance between the wall and the catapult, the game ends. If it doesn't, the game continues
				if(timediff*ws <= x) {	
					x = x-timediff*ws; 
					//calculate the height of the projectile when it is right above the wall. This calculation includes the air resistance
					double y = x*Math.tan(Math.toRadians(angle))-(g*x*x)/(2*(v*(Math.cos(Math.toRadians(angle)))-10)*Math.cos(Math.toRadians(angle)));
					double difference = y-h; //calculate the difference between the height of the projectile when it is right above the wall and the height of wall
					// set the condition of the if else statement to give users different scores and print out different comments based on the result of their inputs
					if(difference <= 3 && difference > 0) {
						System.out.println("You made it!");
						double a = 3*Math.random(); // create a new Double variable a and set it to random value between 0 and 3 in order to set teh condition of the following if else statement
						//print different encouragements based on the value of a
						if(a<1) {
							System.out.println("GOOD!");
						}
						else if(a<2) {
							System.out.println("NICE!");
						}
						else if(a<3) {
							System.out.println("AWESOME!");
						}
						score += 5; // add 5 scores when the difference between the height of the projectile when it is right above the wall and the height of wall is less than or equals to 3
					}
					else if(difference > 3) {
						System.out.println("Plenty of room!");
						score +=3; // add 3 scores when the difference between the height of the projectile when it is right above the wall and the height of wall is greater to 3
						double a = 3*Math.random();
						if(a<1) {
							System.out.println("COME ON!");
						}
						else if(a<2) {
							System.out.println("YOU CAN DO IT!");
						}
						else if(a<3) {
							System.out.println("FIGHTING!");
						}
					}
					else if(difference < 0 && difference > -3 ) {
						System.out.println("not quite over!");
						double a = 3*Math.random();
						//print different encouragements based on the value of a
						if(a<1) {
							System.out.println("YELLOWJACKET!");
						}
						else if(a<2) {
							System.out.println("MELIORA!");
						}
				
						else if(a<3) {
							System.out.println("GENESEE!");
						}
						score += 0; // add 0 scores when the projectile hits the wall, and the distance between the projectile and the top of the wall is less or equals to 3
					}
					else {
						System.out.println("Not even close!");
						double a = 3*Math.random();
						//print different encouragements based on the value of a
						if(a<1) {
							System.out.println("WORK HARD!");
						}
						else if(a<2) {
							System.out.println("STAY STRONG!");
						}
						else if(a<3) {
							System.out.println("DON'T GIVE UP!");
						}
						score -= 2; // minus 2 scores when the projectile hits the wall, and the distance between the projectile and the top of the wall is greater than 3
					}					
					    score -= 1; // minus 1 score after user's each launch since each launch costs 1 score
					    System.out.println("Your score is: "+score);// print the score after user's each launch
					    System.out.println("The distance is: " + x + "\nThe height is: "+ h);
					}
				else if(timediff*ws > x) {
					System.out.println("GAME OVER!");
					break;
				}
				
				}
			else { // other conditions of the if statement that will lead the user to the end of the game
				condition = 2;
				System.out.println("Game Over!");
				break;
			}

			}
			 System.out.println("Your score is: "+score); // print score after the end of the game
		}

	}


