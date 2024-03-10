import  java.util.Scanner;
public class PrimeChecker {
    public static void  main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check if the entered number is prime
        boolean result = isPrime(number);

        // print the result
        System.out.println(number + " is prime: " + result);


        scanner.close();

    }
    // Function to check if a number is prime
    public static boolean isPrime(Integer n) {
        // If the number is less than 2, it's not prime
        if (n < 2) {
            return false;
        }
        // Check for divisibility from 2 to sqrt(n)
        for (Integer i = 2; i * i <= n; i++) {
            // If n is divisible by any number in this range, it's not prime
            if (n % i == 0) {
                return false;
            }
        }
        // If no divisors found, the number is prime
        return true;
    }
}
