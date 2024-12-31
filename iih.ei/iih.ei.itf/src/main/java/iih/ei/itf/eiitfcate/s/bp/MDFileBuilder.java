package iih.ei.itf.eiitfcate.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.utils.FileUtils;

/**
 * MarkDown文件构建器
 * 
 * @author hao_wu 2019-10-28
 *
 */
public class MDFileBuilder {

	public static String CODE_TYPE_XML = "xml";

	private StringBuilder _mdFileBuilder;

	public MDFileBuilder() {
		this._mdFileBuilder = new StringBuilder();
	}

	public String toString() {
		return this._mdFileBuilder.toString();
	}

	public byte[] toBytes() {
		String str = this.toString();
		if (StringUtils.isBlank(str)) {
			return null;
		}
		return str.getBytes();
	}

	public void appendH1(String text) {
		String str = String.format("# %s", text);
		_mdFileBuilder.append(str);
		this.appendNewLine();
	}

	private void appendNewLine() {
		_mdFileBuilder.append(FileUtils.NewLine);
	}

	public void appendH2(String text) {
		String str = String.format("## %s", text);
		_mdFileBuilder.append(str);
		this.appendNewLine();
	}

	public void appendH3(String text) {
		String str = String.format("### %s", text);
		_mdFileBuilder.append(str);
		this.appendNewLine();
	}

	public void appendH4(String text) {
		String str = String.format("#### %s", text);
		_mdFileBuilder.append(str);
		this.appendNewLine();
	}

	public void appendCode(String coodeType, String text) {
		String str = String.format("```%s", coodeType);
		_mdFileBuilder.append(str);
		this.appendNewLine();
		_mdFileBuilder.append(text);
		if (!text.trim().endsWith(FileUtils.NewLine) && !text.trim().endsWith("\n") && !text.trim().endsWith("\r\n")) {
			this.appendNewLine();
		}
		_mdFileBuilder.append("```");
		this.appendNewLine();
	}

	public void appendTable(String[][] table) {
		int rowCount = table.length - 1;
		int columnCount = table[0].length;

		String columnStr = String.format("| %s |", StringUtils.join(table[0], " | "));
		_mdFileBuilder.append(columnStr);
		this.appendNewLine();

		StringBuilder splitStr = new StringBuilder("| ");
		for (int i = 0; i < columnCount; i++) {
			splitStr.append("-- |");
		}
		_mdFileBuilder.append(splitStr.toString());
		this.appendNewLine();

		for (int i = 1; i <= rowCount; i++) {
			String rowStr = String.format("| %s |", StringUtils.join(table[i], " | "));
			_mdFileBuilder.append(rowStr);
			this.appendNewLine();
		}

		this.appendNewLine();
	}

	public void appendText(String text) {
		this._mdFileBuilder.append(text);
		this.appendNewLine();
	}
}
