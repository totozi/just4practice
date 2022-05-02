
public class test {
	public static void main(String[] args) {
		String getVersion = org.springframework.core.SpringVersion.getVersion();
		System.out.println(getVersion);
		String version = System.getProperty("java.version");
		System.out.println("JAVA Version : " + version);
	}

}
