package iih.ei.itf.md2.export;

import java.io.OutputStream;
import java.util.List;

import iih.ei.itf.md2.markdown.Block;

public interface Decorator {
	
	public void beginWork(String outputFilePath);
	
	public void beginWork(OutputStream outputStream);
	
	public void decorate(List<Block> list);
	
	public void afterWork(String outputFilePath);	
}
