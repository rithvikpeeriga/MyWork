package project2;

	
	public class Money {
		 
		private int dollars;
		private int cents;
		 
		public Money( String m ) {
		 
		int decimalpos = m.indexOf(".");
		 
		if( m.charAt(0) == '$' ) 
		this.dollars = Integer.parseInt( m.substring( 1, decimalpos ) );
		else
		this.dollars = Integer.parseInt( m.substring( 0, decimalpos ) );
		 
		this.cents = Integer.parseInt( m.substring( decimalpos + 1 ) );
		}
		 
		public Money( int d, int c ) {
		 
		this.dollars = d;
		this.cents = c;
		}
		 
		public Money() {
		 
		this.dollars = 0;
		this.cents = 0;
		}
		 
		// getter methods
		public int getDollars() {
		 
		return this.dollars;
		}
		 
		public int getCents() {
		 
		return this.cents;
		}
		 
		// instance methods
		public Money addMoney( Money otherM ) {
		 
		int newd = this.dollars + otherM.getDollars();
		int newc = this.cents + otherM.getCents();
		 
		if( newc >= 100 ) {
		 
		newd++;
		newc -= 100;
		}
		 
		return new Money( newd, newc );
		} // ends addMoney()
		 
		public Money subtractMoney( Money otherM ) {
		 
		int newd = this.dollars - otherM.getDollars();
		int newc = this.cents - otherM.getCents();
		 
		if( newc < 0 ) {
		 
		newd--;
		newc += 100;
		}
		 
		return new Money( newd, newc );
		} // ends subtractMoney()
		 
		public Money multiplyMoney( int times ) {
		 
		int newd = this.dollars * times;
		int newc = this.cents * times;
		 
		while( newc >= 100 ) {
		 
		newd++;
		newc -= 100;
		}
		 
		return new Money( newd, newc );
		} // ends multiplyMoney()
		 
		public int compareMoney( Money otherM ) {
		 
		if( this.dollars > otherM.getDollars() )
		return 1;
		else if( this.dollars < otherM.getDollars() )
		return -1;
		else if( this.cents > otherM.getCents() )
		return 1;
		else if( this.cents < otherM.getCents() )
		return -1;
		else
		return 0;     
		} // ends compareMoney()
		 
		 
		public String toString() {
		 
		if( this.cents < 10 )
		return "$" + this.dollars + ".0" + this.cents;
		else
		return "$" + this.dollars + "." + this.cents;
		} // ends toString()
		 
		} // ends class

	
	
	
	
		
	
	
	


