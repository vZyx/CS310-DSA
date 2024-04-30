public class Recursion
{
    public static void main(String[] args)
    {
        Recursion(4);
    }

    static void Recursion(int test) {
        if (test < 1)
            return;
        else {
            System.out.print(test);
            Recursion(test - 1);
            System.out.print(test);
            return;
        }
    }

}
