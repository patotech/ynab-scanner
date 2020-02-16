package cl.madduck.ynab.scanner.santander;

public class StandaloneRunner {

	public static void main( String ... args ) {
		CreditCardTransactionScanner scanner = new CreditCardTransactionScanner();
		scanner.handleRequest( 1, null );
	}
}
