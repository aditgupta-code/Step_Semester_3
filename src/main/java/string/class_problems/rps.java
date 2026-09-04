package main.java.string.class_problems;
import java.util.Scanner;
import java.util.Random;
public class rps {
    public static void main(String[] args){
        Scanner s1 = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter number of rounds: ");
        int rounds = s1.nextInt();
        s1.nextLine(); // Consume the newline character
        int win=0, lose=0, tie=0;
        for(int i = 0; i < rounds; i++){   
            System.out.println("Enter your choice (rock, paper, scissors): ");
            String userChoice = s1.nextLine(); //Gets the user input 
            String[] choices = {"rock", "paper", "scissors"};
            String computerChoice = choices[r.nextInt(choices.length)];// Randomly selects the computer moves
            System.out.println("Computer chose: " + computerChoice);
            if(userChoice.equals(computerChoice)){
                System.out.println("It's a tie");
                tie++;
            }
            else if (userChoice.equals("rock") && computerChoice.equals("scissors")) {
                System.out.println("You win!");
                win++;
            }
            else if (userChoice.equals("rock") && computerChoice.equals("paper")) {
                System.out.println("Computer wins!");
                lose++;
            }
            else if (userChoice.equals("paper") && computerChoice.equals("rock")) {
                System.out.println("You win!");
                win++;
            }
            else if (userChoice.equals("paper") && computerChoice.equals("scissors")) {
                System.out.println("Computer wins!");
                lose++;
            }
            else if (userChoice.equals("scissors") && computerChoice.equals("rock")) {
                System.out.println("Computer wins!");
                lose++;
            }
            else{
                System.out.println("You win!");
                win++;
            }
        }
        int winrate = (win*100)/(win+lose+tie);
        System.out.println("Wins: " + win + ", Losses: " + lose + ", Ties: " + tie + ", Win Rate: " + winrate + "%");
        s1.close();
    }
}
