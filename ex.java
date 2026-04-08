import java.util.Scanner;
public  class ex {
    public static  void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int dividend;
        int divisor;

        System.out.print(s:"나뉨수를 입력: ");
        dividend=scanner.nextInt();
        System.out.print(s:"나눔수를 입력");
        dividend=scanner.nextInt();
        try{
            System.out.println(dividend + "를" + divisor + "로 나누면 몫은" + dividend/divisor + "입니다");
        }
        catch (ArithmeticException e)
    }
}