package iih.ei.itf.md2.markdown.builder;

import iih.ei.itf.md2.markdown.BlockType;

public class OrderedListBuilder extends ListBuilder{

	public OrderedListBuilder(String content){
		super(content, BlockType.ORDERED_LIST);
	}
	
	@Override
	public int computeCharIndex(String str) {
		return str.indexOf(" ");
	}

}
