package iih.pis.ivx.dto.pisivxpythondto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 分词词性DTO DTO数据 
 * 
 */
public class PisivxPythonDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_pisivxpython() {
		return ((String) getAttrVal("Id_pisivxpython"));
	}
	/**
	 * 主键
	 * @param Id_pisivxpython
	 */
	public void setId_pisivxpython(String Id_pisivxpython) {
		setAttrVal("Id_pisivxpython", Id_pisivxpython);
	}
	/**
	 * 分词列表
	 * @return FArrayList2
	 */
	public FArrayList2 getWordslist() {
		return ((FArrayList2) getAttrVal("Wordslist"));
	}
	/**
	 * 分词列表
	 * @param Wordslist
	 */
	public void setWordslist(FArrayList2 Wordslist) {
		setAttrVal("Wordslist", Wordslist);
	}
	/**
	 * 词性列表
	 * @return FArrayList2
	 */
	public FArrayList2 getPoslist() {
		return ((FArrayList2) getAttrVal("Poslist"));
	}
	/**
	 * 词性列表
	 * @param Poslist
	 */
	public void setPoslist(FArrayList2 Poslist) {
		setAttrVal("Poslist", Poslist);
	}
}