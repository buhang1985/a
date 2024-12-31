package iih.nm.net.dto.examquesdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 试卷DTO DTO数据 
 * 
 */
public class ExamQuExcelDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 试题id
	 * @return String
	 */
	public String getId_qu() {
		return ((String) getAttrVal("Id_qu"));
	}
	/**
	 * 试题id
	 * @param Id_qu
	 */
	public void setId_qu(String Id_qu) {
		setAttrVal("Id_qu", Id_qu);
	}
	/**
	 * 试题类型
	 * @return String
	 */
	public String getSd_type() {
		return ((String) getAttrVal("Sd_type"));
	}
	/**
	 * 试题类型
	 * @param Sd_type
	 */
	public void setSd_type(String Sd_type) {
		setAttrVal("Sd_type", Sd_type);
	}
	/**
	 * 试题编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 试题编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 题目内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}
	/**
	 * 题目内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 试题难度
	 * @return String
	 */
	public String getSd_level() {
		return ((String) getAttrVal("Sd_level"));
	}
	/**
	 * 试题难度
	 * @param Sd_level
	 */
	public void setSd_level(String Sd_level) {
		setAttrVal("Sd_level", Sd_level);
	}
	/**
	 * 分数
	 * @return FDouble
	 */
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}
	/**
	 * 分数
	 * @param Score
	 */
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
}