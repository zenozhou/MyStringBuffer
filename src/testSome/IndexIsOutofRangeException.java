package testSome;

class IndexIsOutofRangeException extends Exception{
	public IndexIsOutofRangeException() {}
	public IndexIsOutofRangeException(String gripe) {
		super(gripe);
	}
}
