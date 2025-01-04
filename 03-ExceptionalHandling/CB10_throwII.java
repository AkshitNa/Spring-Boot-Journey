package CB16ExceptionalHandling;

import CB16ExceptionalHandling.Exception.YoungAgeVotingException;

import java.util.Scanner;

public class CB10_throwII {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            if(age<=10){
                throw new YoungAgeVotingException();
            } else if (age<18) {
                throw new YoungAgeVotingException("You cannot vote!! Brother");
            } else if (age ==18) {
                throw new YoungAgeVotingException("Do you have Voter ID?", 18);
            } else {
                System.out.println("You can vote!!");
            }
        }catch (YoungAgeVotingException e){
            e.printStackTrace();
        }

        System.out.println("Hello voters!!");
    }
}
