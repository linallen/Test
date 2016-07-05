package allen.r.RjavaTest;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class Test {
	public static void main(String[] args) {
		// Start R session.
		Rengine re = new Rengine(new String[] { "--vanilla" }, false, null);
		// Check if the session is working.
		if (!re.waitForR()) {
			return;
		}
		re.assign("x", new double[] { 1.5, 2.5, 3.5 });
		REXP result = re.eval("(sum(x))");
		System.out.println("sum(x) = " + result.asDouble());
		re.end();
	}
}