package iih.ei.itf.md2.export;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;

import iih.ei.itf.md2.markdown.Block;
import iih.ei.itf.md2.markdown.MDAnalyzer;

/**
 * 文档生成工厂
 * 
 * @author hao_wu
 * @time 2015年5月1日 下午2:35:08
 *
 */
public class FileFactory {

	public static byte[] producePdf(String mdFileContent) {
		return producePdf(mdFileContent.getBytes());
	}

	public static byte[] producePdf(byte[] mdFile) {
		Decorator decorator = BuilderFactory.build(FileExName.PDF);

		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(mdFile)));
		List<Block> list = MDAnalyzer.analyze(reader);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		decorator.beginWork(outStream);
		decorator.decorate(list);
		decorator.afterWork(null);

		byte[] outBytes = outStream.toByteArray();
		return outBytes;
	}

	public static void produce(File file, String outputFilePath) throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(file));

		produce(reader, outputFilePath);
	}

	public static void produce(InputStream is, String outputFilePath) throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		produce(reader, outputFilePath);
	}

	public static void produce(String mdText, String outputFilePath) throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new StringReader(mdText));

		produce(reader, outputFilePath);
	}

	public static void produce(BufferedReader reader, String outputFilePath) throws FileNotFoundException {
		List<Block> list = MDAnalyzer.analyze(reader);
		produce(list, outputFilePath);
	}

	public static void produce(List<Block> list, String outputFilePath) throws FileNotFoundException {
		String ext = getExtOfFile(outputFilePath);
		Decorator decorator = BuilderFactory.build(ext);

		decorator.beginWork(outputFilePath);
		decorator.decorate(list);
		decorator.afterWork(outputFilePath);
	}

	private static String getExtOfFile(String outputFilePath) {
		if (outputFilePath == null) {
			return "";
		}
		int i = outputFilePath.lastIndexOf(".");
		if (i < 0) {
			return "";
		}
		return outputFilePath.substring(i + 1);
	}
}
