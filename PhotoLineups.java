package LabProgram711;

import java.util.Scanner;
import java.util.ArrayList;

public class PhotoLineups {

	// TODO: Write method to create and output all permutations of the list of
	// names.
	public static int counter = -1;

	public static void printAllPermutations(ArrayList<String> currBag, // Bag contents
			ArrayList<String> remainingItems) { // Available items
		String bagValue = ""; // Cost of items in shopping bag
		String tmpGroceryItem; // Grocery item to add to bag
		int i; // Loop index

		if (currBag.size() == counter) { // Base case: Shopping bag full

			for (i = 0; i < currBag.size(); ++i) {
				bagValue += currBag.get(i);
				if (i < currBag.size() - 1)
					System.out.print(currBag.get(i) + ", ");
				else
					System.out.print(currBag.get(i));
			}
			System.out.println();
		} else { // Recursive case: move one
			for (i = 0; i < remainingItems.size(); ++i) { // item to bag
				// Move item into bag
				tmpGroceryItem = remainingItems.get(i);
				remainingItems.remove(i);
				currBag.add(tmpGroceryItem);

				printAllPermutations(currBag, remainingItems);

				// Take item out of bag
				remainingItems.add(i, tmpGroceryItem);
				currBag.remove(currBag.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> permList = new ArrayList<String>();
		String name;

		// TODO: Read in a list of names; stop when -1 is read. Then call recursive
		// method.

		while (scnr.hasNext()) {
			name = scnr.next();
			counter++;
			if (!name.equals("-1"))
				nameList.add(name);
			else
				break;
		}
		printAllPermutations(permList, nameList);
	}
}
