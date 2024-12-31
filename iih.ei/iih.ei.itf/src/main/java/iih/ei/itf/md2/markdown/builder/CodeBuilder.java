package iih.ei.itf.md2.markdown.builder;

import iih.ei.itf.md2.markdown.Block;
import iih.ei.itf.md2.markdown.BlockType;
import iih.ei.itf.md2.markdown.ValuePart;

public class CodeBuilder implements BlockBuilder {

	private String content;
	private String codeType;

	public CodeBuilder(String content) {
		this.content = content;
	}

	public CodeBuilder(String content, String codeType) {
		this(content);
		this.codeType = codeType;
	}

	public Block bulid() {
		Block block = new Block();
		block.setType(BlockType.CODE);

		ValuePart valuePart;

		BlockType blockType = getBlockType();
		if (blockType == null) {
			valuePart = new ValuePart(content);
		} else {
			valuePart = new ValuePart(content, blockType);
		}

		block.setValueParts(valuePart);
		return block;
	}

	private BlockType getBlockType() {
		if ("xml".equals(this.codeType)) {
			return BlockType.CODE_XML;
		}
		return null;
	}

	public boolean isRightType() {
		return false;
	}

}
