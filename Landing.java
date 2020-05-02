/*
 * Class Name:    Ticket
 *
 * Author:        Your Name
 * Creation Date: Monday, April 16 2018, 22:17 
 * Last Modified: Monday April 16 2018, 22:17 
 * 
 * Class Description:
 *
 */

import java.util.*;
import java.util.Random;
public class Landing {
    public static void main (String[] args) {
        int min = -10;
        int max = +10;
        Random rand =  new Random();
        int x = rand.nextInt(max-min+1) + min; //[0, max-min] -> [0+min, max-min+min] -> [min, max]
        int y = rand.nextInt(11);
        int windMin = -5;
        int windMax = 5;
        int wind = rand.nextInt(windMax-windMin+1) + windMin;
        /*int x = 8;
        int y = 9;
        int wind = 5;*/
        System.out.println("Initial position of the Ferry is x = "+x+" y = "+y);
        System.out.println("The position of the landing pad is x = 0  y = 0");
        if ( x<=-10 || x>=10 ) {
            System.out.println("Extremely bad luck, the Ferry crashed into the mountains before you could issue any commands.");
            return;
        }
        if ( wind > 0 ) {
            System.out.println("The wind is blowing at "+wind+" unit from left to right");
        } else if ( wind < 0 ) {
            System.out.println("The wind is blowing at "+Math.abs(wind)+" unit from right to left");
        } else {
            System.out.println("No wind today!!");
        }
        int attempts = rand.nextInt(11);
        Scanner keyboard = new Scanner (System.in);
        /*System.out.print("No. of attempts >> ");
        int attempts = keyboard.nextInt();
        keyboard.nextLine();*/
        if ( attempts == 0 ) {
            System.out.println("No attempts at the beginning. ");
            return;
        }
        for (;attempts > 0;) {
            System.out.println(" ");
            System.out.println("Landing menu");
            System.out.println("    Full Up");
            System.out.println("    Full Right");
            System.out.println("    Full Left");
            System.out.println("    Full Down");
            System.out.println("    Right Up");
            System.out.println("    Right Down");
            System.out.println("    Left Up");
            System.out.println("    Left Down");
            System.out.println("    Back to Orbit");
            System.out.print("Enter command >> ");
            String command = keyboard.nextLine();
            if ( command.equalsIgnoreCase("Full Up")) {
                y = y+2;
            } else if ( command.equalsIgnoreCase("Full Right")) {
                x = x+2;
            } else if ( command.equalsIgnoreCase("Full Left")) {
                x = x-2;
            } else if ( command.equalsIgnoreCase("Full Down")) {
                y = y-2;
            } else if ( command.equalsIgnoreCase("Right Up")) {
                y = y+1;
                x = x+1;
            } else if ( command.equalsIgnoreCase("Right Down")) {
                y = y-1;
                x = x+1;
            } else if ( command.equalsIgnoreCase("Left Up")) {
                y = y+1;
                x = x-1;
            } else if ( command.equalsIgnoreCase("Left Down")) {
                y = y-1;
                x = x-1;
            } else if ( command.equalsIgnoreCase("Back to Orbit")) {
                System.out.println("Position of the Ferry is x = "+x+" y = "+y);
                System.out.println("At least the Ferry is in one piece");
                System.out.println("refuel and try again");
                System.out.println("have a coffee first");
                return;
            } else {
                System.out.println("That command is not recognized");
                continue;
            }
            if ( attempts > 1 ) {
                System.out.print("Turbo on [yes/no] ? >> ");
                String turbo = keyboard.nextLine();
                 if ( turbo.equalsIgnoreCase("yes") ) {
                    attempts = attempts-2;
                    if ( command.equalsIgnoreCase("Full Up")) {
                        y = y+2;
                    } else if ( command.equalsIgnoreCase("Full Right")) {
                        x = x+2;
                    } else if ( command.equalsIgnoreCase("Full Left")) {
                        x = x-2;
                    } else if ( command.equalsIgnoreCase("Full Down")) {
                        y = y-2;
                    } else if ( command.equalsIgnoreCase("Right Up")) {
                        y = y+1;
                        x = x+1;
                    } else if ( command.equalsIgnoreCase("Right Down")) {
                        y = y-1;
                        x = x+1;
                    } else if ( command.equalsIgnoreCase("Left Up")) {
                        y = y+1;
                        x = x-1;
                    } else if ( command.equalsIgnoreCase("Left Down")) {
                        y = y-1;
                        x = x-1;
                    } 
                 } else {
                    attempts = attempts-1;
                 }
             } else {
                attempts = attempts-1;
             }
            x = x+wind;
            System.out.println("Position of the Ferry is x = "+x+" y = "+y);
            if ( x<=-10 || x>=10 ) {
                System.out.println("Ferry has crashed into the mountains");
                return;
            }  
            if ( y<0 ) {
                System.out.println("Ferry has crashed into the ground");
                return;
            } 
            if ( x == 0 && y == 0 ) {
                System.out.println("Congratulations Pilot!! Excellent flying");
                return;
            }
            System.out.println(" ");
            System.out.println("Number of attempts left: "+attempts);
            System.out.println(" ");
            if ( attempts <= 0 ) {
                System.out.println("Ferry has run out of fuel and crashed into the ground");
                return;
            }
        } 
    }
}