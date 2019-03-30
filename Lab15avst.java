// Lab15avst.java
// 02-28-15 by Leon Schram
// The "Odd Magic Square" Program
// This is the student, starting version of the Lab15 assignment.


import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab15avst
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

      System.out.print("Enter the odd# size of the Magic Square -->  ");
      int size = input.nextInt();
      MagicSquare magic = new MagicSquare(size);

      magic.computeMagicSquare();
      magic.displayMagicSquare();
   	  magic.checkRows();          // for 100 & 110 Point Version Only
      magic.checkColumns();		 // for 100 & 110 Point Version Only
   	magic.checkDiagonals();	 	 // for 100 & 110 Point Version Only
	}
}


class MagicSquare
{
	private int size;
	private int magic[][];
	private DecimalFormat output;

	public MagicSquare(int s)
	{
		size = s;
		magic = new int[size][size];
		output = new DecimalFormat("000");
	}

	public void computeMagicSquare()
	{
		int row = 0;
		int col = size/2;
		magic[row][col] = 1;
		for (int i = 2; i < size * size +1; i++)
		{
			if(magic[(row + size -1 ) % size][(col +1)% size ] == 0                                      )
			{
				row = (row + size -1) % size;
				col = (col + 1 ) % size;
			}
			else
			{
				row = (row + 1) % size;
			}
			magic[row][col] = i;
			
			
		}



	}

	public void displayMagicSquare()
	{
		System.out.println();
		System.out.println(size + "x" + size + " Magic Square");
		System.out.println("==================");
		System.out.println();
		for( int  i = 0; i <magic.length; i++)
		{
			for(int i1 = 0; i1 < magic.length; i1++)
			{
				System.out.print(output.format(magic[i][i1]) + " " );
			}
			System.out.println();
		}
	}

	public void checkRows()
	{
		System.out.println();
		System.out.println("Checking Rows");
		System.out.println("=============");
		System.out.println();
		int row = 0;
		for(int i = 0; i < magic.length; i++)
		{
			for(int i1 = 0; i1 < magic.length; i1++)
			{
				row += magic[i][i1];
			}
			System.out.print(row + " ");
			row = 0;
		}
		
		
		
	}

	public void checkColumns()
	{
		System.out.println();
		System.out.println("Checking Columns");
		System.out.println("================");
		System.out.println();
		 int col = 0;
	        for (int i = 0; i < magic.length; i++) 
	        {
	            for (int i1 = 0; i1 < magic.length; i1++) 
	            {
	                col += magic[i][i1];
	 
	            }
	            System.out.print(col + " ");
	            col = 0;
	        }
		
   }

	public void checkDiagonals()
	{
		System.out.println();
		System.out.println("Checking Diagonals");
		System.out.println("==================");
		System.out.println();
		int diag = 0;
		for(int t = 0; t <2; t++)
		{
		for(int i = 0; i <magic.length; i++)
		{
			diag+= magic[i][i];
		}
		System.out.print(diag + " ");
		diag = 0;
		}
	}
   
}