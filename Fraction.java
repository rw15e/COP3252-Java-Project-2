/* Assignment 2 by Ryan Winter for COP3252*/
// class Fraction
// Author:  Bob Myers
//
// For COP3252, Java Programming

public class Fraction{

  private int numerator = 0;		// numerator (and keeps sign)
  private int denominator = 1;		// always stores positive value

  public Fraction()
  {
  }

  public Fraction(int n, int d)
  {
    if (set(n,d)==false)
	set(0,1);
  }

  // start of added code **********************************************
  
  private int gcd(int n, int d)		// psuedocode from Wiki for Euclids algorithim
  {
	while (d != 0) 
	{
		int temp = d;
		d = n % d;
		n = temp;
    }
    return n;
  }
  public Fraction simplify() 
  {
	Fraction g = new Fraction(); // creates new Fraction object called g
	g.numerator = numerator; // set object g numerator to same value as numerator
	g.denominator = denominator; // set object g denominator to same value as denominator
    for (int i=0; i<99; i++)   // loop to run 100 times
	{        
		if ((g.denominator % i == 0) && (g.numerator % i == 0))		// if both num and denom modulo = 0 then its simplfied
		{  
			g.denominator = g.denominator/i;  
			g.numerator = g.numerator/i;  
			break;
		}         	
    }
	return (g); 	// return new Fraction g that contains new simplfied
  }
  public Fraction add(Fraction f)
  {	
    f.numerator = (this.numerator * f.denominator)+(f.numerator * this.denominator);  // cross mulitply then add..
    f.denominator = this.denominator * f.denominator; 		// multiply denominators..
    return simplify();	// calls simplify function which will return a new fraction that is simplfied
  }
  
  public Fraction subtract(Fraction f)
  {
	f.numerator = (this.numerator * f.denominator)-(f.numerator * this.denominator); 	// cross mulitply then subtract..
	f.denominator = this.denominator * f.denominator;    // mulitply denominators..
    return simplify();															
  }
	
  public Fraction multiply(Fraction f)
  {
	f.numerator = this.numerator * f.numerator; 		 // mulitply numerators..							
    f.denominator = this.denominator * f.denominator;  // mulitply denominators..
    return simplify();				
  }

  public Fraction divide(Fraction f)
  {      
	f.numerator = this.numerator * f.denominator; 	// cross mulitply..
    f.denominator = this.denominator * f.numerator;   // cross mulitply..
    return simplify();
  }
  // end of added code **********************************************
  
  
  public boolean set(int n, int d)
  {
    if (d > 0)
    {
	numerator = n;
	denominator = d;
	return true;
    }
    else
	return false;
  }
  
  public String toString()
  {
    return (numerator + "/" + denominator);
  }

  public int getNumerator()
  {
    return numerator;
  }

  public int denominator()
  {
    return denominator;
  }

  public double decimal()
  {
    return (double)numerator / denominator;
  }

}