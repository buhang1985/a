package iih.ci.mr.s.util.zip4j.io;

import java.io.IOException;
import java.io.InputStream;

import iih.ci.mr.s.util.zip4j.unzip.UnzipEngine;

public abstract class BaseInputStream extends InputStream {

	public int read() throws IOException {
		return 0;
	}
	
	public void seek(long pos) throws IOException {
	}
	
	public int available() throws IOException {
		return 0;
	}
	
	public UnzipEngine getUnzipEngine() {
		return null;
	}

}
