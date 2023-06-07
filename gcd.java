 import java.util.concurrent.atomic.AtomicInteger;
 import java.util.*;
 import java.io.*;
 
public class gcd
{
    // Recursive function to demonstrate the extended Euclidean algorithm.
    // It uses pointers to return multiple values.
    public static int extended_gcd(int a, int b, AtomicInteger x, AtomicInteger y)
    {
        if (a == 0)
        {
            x.set(0);
            y.set(1);
            return b;
        }
 
        AtomicInteger _x = new AtomicInteger(), _y = new AtomicInteger();
        int gcd = extended_gcd(b % a, a, _x, _y);
 
        x.set(_y.get() - (b/a) * _x.get());
        y.set(_x.get());
 
        return gcd;
    }
 
    public static void main(String[] args)
    {   System.out.println("Enter a :");
        Scanner sc=new Scanner(System.in);
          
        int a = sc.nextInt();
        System.out.println("Enter b :");
        int b = sc.nextInt();
 
        AtomicInteger x = new AtomicInteger(), y = new AtomicInteger();
 
        System.out.println("The GCD is " + extended_gcd(a, b, x, y));
        System.out.printf("x = %d, y = %d\n", x.get(), y.get());
    }
} 
