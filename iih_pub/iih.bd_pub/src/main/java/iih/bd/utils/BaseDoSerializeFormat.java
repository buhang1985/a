package iih.bd.utils;

public class BaseDoSerializeFormat {

	/**
	 * 根节点名称
	 */
	private String rootName;
	/**
	 * 输出空节点
	 */
	private boolean outputBlankEle;
	/**
	 * 输出xml的默认报文头
	 */
	private boolean outputDeclaration;
	/**
	 * 输出注释
	 */
	private boolean outputComment;

	public BaseDoSerializeFormat() {
		this.outputBlankEle = false;
		this.outputDeclaration = true;
		this.outputComment = false;
	}

	public String getRootName() {
		return rootName;
	}

	public void setRootName(String rootName) {
		this.rootName = rootName;
	}

	public boolean isOutputBlankEle() {
		return outputBlankEle;
	}

	public void setOutputBlankEle(boolean outputBlankEle) {
		this.outputBlankEle = outputBlankEle;
	}

	public boolean isOutputDeclaration() {
		return outputDeclaration;
	}

	public void setOutputDeclaration(boolean outputDeclaration) {
		this.outputDeclaration = outputDeclaration;
	}

	public boolean isOutputComment() {
		return outputComment;
	}

	public void setOutputComment(boolean outputComment) {
		this.outputComment = outputComment;
	}
}
