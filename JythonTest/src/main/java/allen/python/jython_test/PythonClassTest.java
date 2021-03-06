package allen.python.jython_test;

import org.python.core.PyInstance;
import org.python.util.PythonInterpreter;

public class PythonClassTest {

	PythonInterpreter interpreter = null;

	public PythonClassTest() {
		PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
		this.interpreter = new PythonInterpreter();
	}

	void execfile(final String fileName) {
		this.interpreter.execfile(fileName);
	}

	PyInstance createClass(final String className, final String opts) {
		return (PyInstance) this.interpreter.eval(className + "(" + opts + ")");
	}

	public static void main(String gargs[]) {
		PythonClassTest ie = new PythonClassTest();
		ie.execfile("hello.py");
		PyInstance hello = ie.createClass("Hello", "None");
		hello.invoke("run");
	}
}
