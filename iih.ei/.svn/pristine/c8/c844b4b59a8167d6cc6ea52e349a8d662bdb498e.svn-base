package iih.ei.itf.md2.markdown.builder;

import iih.ei.itf.md2.markdown.BlockType;
import iih.ei.itf.md2.markdown.MDToken;

public class QuoteBuilder extends ListBuilder{

	public QuoteBuilder(String content){
		super(content, BlockType.QUOTE);
	}

	@Override
	public int computeCharIndex(String str) {
		return str.indexOf(MDToken.QUOTE);
	}
}
