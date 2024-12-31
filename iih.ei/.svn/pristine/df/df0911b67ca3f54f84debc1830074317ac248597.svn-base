package iih.ei.itf.md2.markdown.builder;

import java.util.List;

import iih.ei.itf.md2.markdown.Block;
import iih.ei.itf.md2.markdown.BlockType;
import iih.ei.itf.md2.markdown.MDAnalyzer;
import iih.ei.itf.md2.markdown.ValuePart;

public class CommonTextBuilder implements BlockBuilder{

	private String content;
	public CommonTextBuilder(String content){
		this.content = content;
	}
	
	public Block bulid() {
		Block block = new Block();
		
		block.setType(BlockType.NONE);
		List<ValuePart> list = MDAnalyzer.analyzeTextLine(content);
		block.setValueParts(list);
		
		return block;
	}

	public boolean isRightType() {
		return true;
	}

}
