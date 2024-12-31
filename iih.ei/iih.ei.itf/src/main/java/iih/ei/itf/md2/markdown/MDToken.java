package iih.ei.itf.md2.markdown;

public class MDToken {
	
	public static String QUOTE = ">";
	public static String CODE = "```";
	public static String CODE_BLANK = "    ";
	public static String HEADLINE = "#";
	public static String IMG = "![";
	public static String LINK = "[";
	public static String UNORDERED_LIST1 = "* ";
	public static String UNORDERED_LIST2 = "- ";
	public static String BOLD_WORD = "**";
	public static String ITALIC_WORD = "_";
	public static String ITALIC_WORD_2 = "*";
	public static String STRIKE_WORD = "~~";
	public static String CODE_WORD = "`";
	
	public static BlockType convert(String mdToken){
		if(mdToken.equals(QUOTE)){
			return BlockType.QUOTE;
		}else if(mdToken.equals(CODE)){
			return BlockType.CODE;
		}else if(mdToken.equals(HEADLINE)){
			return BlockType.HEADLINE;
		}else if(mdToken.equals(IMG)){
			return BlockType.IMG;
		}else if(mdToken.equals(BOLD_WORD)){
			return BlockType.BOLD_WORD;
		}else if(mdToken.equals(ITALIC_WORD) || mdToken.equals(ITALIC_WORD_2)){
			return BlockType.ITALIC_WORD;
		}else if(mdToken.equals(STRIKE_WORD)){
			return BlockType.STRIKE_WORD;
		}else if(mdToken.equals(CODE_WORD)){
			return BlockType.CODE_WORD;
		}else if(mdToken.equals(LINK)){
			return BlockType.LINK;
		}else {
			return BlockType.NONE;
		}
	}
}
