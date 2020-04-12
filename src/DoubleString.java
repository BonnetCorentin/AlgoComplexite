public class DoubleString {
	
	private String motA , motB;
	private String tab[][];

	public DoubleString(String mot1, String mot2) {
		this.motA = mot1;
		this.motB = mot2;
	}

	public String getMotA() {
		return motA;
	}

	public void setMotA(String motA) {
		this.motA = motA;
	}

	public String getMotB() {
		return motB;
	}

	public void setMotB(String motB) {
		this.motB = motB;
	}
	
	public String ToString() {
		return this.motA + "=" + this.motB;
	}
	
}
