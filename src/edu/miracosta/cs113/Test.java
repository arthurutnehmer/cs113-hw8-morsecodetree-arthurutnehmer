package edu.miracosta.cs113;

public class Test
{
    public static void main(String[]args)
    {
        MorseCodeTree test = new MorseCodeTree();
        try
        {
            System.out.println(test.translateFromMorseCode("**** ***- **-* *-** *--* *---"));
        }

        catch(IndexOutOfBoundsException e)
        {
            System.out.println("test");
        }

    }
}
