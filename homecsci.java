import javax.swing.JOptionPane;
public class homecsci {

	public static void main(String[] args) {
		
	
		// create an empty array of size 5
		int[] numlist = new int[5];
		 
		// populate array with user input
		for( int i = 0; i < numlist.length; i++ ) {
		 
		numlist[ i ] = Integer.parseInt( JOptionPane.showInputDialog( "Enter num " + ( i + 1 ) ) );
		 
		} // ends for loop
		 
		// print array contents with commas
		String msg = "";
		for( int i = 0; i < numlist.length; i++ ) {
		 
		msg += numlist[ i ];
		 
		if( i != numlist.length - 1 ) {
		 
		msg += ", ";
		}
		 
		} // ends for loop
		 
		JOptionPane.showMessageDialog( null, msg );
		 
		// sum all of the values in the array
		int sum = 0;
		for( int i = 0; i < numlist.length; i++ ) {
		 
		sum += numlist[ i ];
		 
		} // ends for loop
		 
		JOptionPane.showMessageDialog( null, "The sum is " + sum );
		 
		// print the maximum value of the array
		int max = numlist[ 0 ];
		for( int i = 1; i < numlist.length; i++ ) {
		 
		if( numlist[ i ] > max ) {
		 
		max = numlist[ i ];
		}
		} // ends for loop
		 
		JOptionPane.showMessageDialog( null, "Max value is " + max );
		 
		} // ends main
		 
		} // ends class


	
