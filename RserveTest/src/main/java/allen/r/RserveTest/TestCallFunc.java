package allen.r.RserveTest;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class TestCallFunc {
	public static void main(String a[]) {
		RConnection connection = null;

		// Run library(Rserve) and Rserve() in R first, then exit R
		try {
			/*
			 * Create a connection to Rserve instance running on default port
			 * 6311
			 */
			connection = new RConnection();
			/* Note four slashes (\\\\) in the path */
			String dir = System.getProperty("user.dir") + "/";
			dir = dir.replaceAll("\\\\", "/");
			connection.eval("source('" + dir + "MyScript.R')");
			int num1 = 10;
			int num2 = 20;
			int sum = connection.eval("myAdd(" + num1 + "," + num2 + ")").asInteger();
			System.out.println("sum(" + num1 + "," + num2 + ") = " + sum);
		} catch (RserveException e) {
			e.printStackTrace();
		} catch (REXPMismatchException e) {
			e.printStackTrace();
		}
	}
}
