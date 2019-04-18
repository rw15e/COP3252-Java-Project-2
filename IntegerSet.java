/* Assignment 2 by Ryan Winter for COP3252*/
import java.util.Arrays;
public class IntegerSet{
	//public static void main(String args[]){    // not supposed to have a main function...?
		
	IntegerSet intset = new IntegerSet(); // new object called intset
	boolean[] set;		// array of bool values called set
	int[] narray;
	
	public IntegerSet()
	{
		set = new boolean[100]; // will hold 101 boolean values, that will all default to false
		narray = new int[100]; // will hold 101 int values
	}
	public IntegerSet union(IntegerSet iSet) // takes in integer set, creates and returns new set that is the theoretical-union 
	{
		IntegerSet unionset = new IntegerSet(); // create new object called unionset
    	for (int i = 0; i < 100; i++) // loop that runs 101 times 
		{
			if(iSet.narray[i] != this.narray[i]) // if they arent equal then add both to union 
			{				
				unionset.narray[i] = iSet.narray[i];	
				unionset.narray[i+i] = this.narray[i];
			}
		}
	 	return unionset; // return the object that holds the union of both arrays
	}  	
	public IntegerSet intersection(IntegerSet iSet) // takes in integer set, creates and returns new set that is intersection (if its in both sets)
	{
		 IntegerSet sect = new IntegerSet();  // create new object called sect that will hold the intersection
		 for(int i = 0; i < 100; i++) // loop that runs 101 times and performs the AND operation to the calling object and iSet
		 {
			 if (iSet.narray[i] != this.narray[i])
			 {
				 sect.narray[i] = iSet.narray[i];
				 sect.narray[i+i] = this.narray[i];
			 }
		 }
		 return sect; // returns object that holds the intersection
	}
	public IntegerSet insertElement(int data) // takes in an integer and adds it to the set, and returns the set(for cascading)
	{
		narray[data] = data;
		set[data] = true;  // sets boolean value to true at given location
		return intset;
	}
	public IntegerSet deleteElement(int data) // removes argument from the set and should also return the set(for cascading)
	{
		narray[data] = 0;
		set[data] = false; // sets boolean value to false at given location
		return intset;
	}
	public boolean isEqualTo(IntegerSet iSet) // returns true if all elements of set are equal, false otherwise 
	{
		for(int i = 0; i < 100; i++) // for loop that runs 101 times, the max size of our arrays, and then tests if they are equal one item at a time
		{
			if(iSet.narray[i] != narray[i])
				return false; // if it finds that the two arrays are NOT equal at any point it will instantly return false, if the loop iterates fully it will mean both arrays are equal and return true
		}
		return true; 
	}
	public String toString()	// returns a string containing the set elements as a list of numbers, in ascending order, seperated by spaces. include only the elements prsent in set
										// use --- to represent an empty set
	{
		boolean empty = false;  // defaults to false
		String newstring = "TEST";
		
		for(int i = 0; i < 100; i++)	// loop that runs 101 times
		{
			if(set[i] == false)
			{
				empty = true;
			}
			else 
				empty = false;
		}
		
		if (empty == true) 		// if list is empty return "---"
			newstring = "---";
		else
		{
			for(int i = 0; i < 100; i++)	// loop that runs 101 times
			{
				if(set[i] == true)
				{	
					//newstring = (narray[i]); // ISSUE HERE with coverting int to string..
				}
			}
		}
		return newstring; // returns new string..		
	}	
	//} // end of main..
}
