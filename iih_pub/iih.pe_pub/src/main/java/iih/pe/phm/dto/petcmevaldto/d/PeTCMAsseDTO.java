package iih.pe.phm.dto.petcmevaldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检中医问卷评分结果 DTO数据 
 * 
 */
public class PeTCMAsseDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检中医评估明细主键标识
	 * @return String
	 */
	public String getId_petcmasse() {
		return ((String) getAttrVal("Id_petcmasse"));
	}
	/**
	 * 体检中医评估明细主键标识
	 * @param Id_petcmasse
	 */
	public void setId_petcmasse(String Id_petcmasse) {
		setAttrVal("Id_petcmasse", Id_petcmasse);
	}
	/**
	 * 体检预约单主键
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 体检预约单主键
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 中医体质分析判定问卷主键
	 * @return String
	 */
	public String getId_petcmconstcajudgeqa() {
		return ((String) getAttrVal("Id_petcmconstcajudgeqa"));
	}
	/**
	 * 中医体质分析判定问卷主键
	 * @param Id_petcmconstcajudgeqa
	 */
	public void setId_petcmconstcajudgeqa(String Id_petcmconstcajudgeqa) {
		setAttrVal("Id_petcmconstcajudgeqa", Id_petcmconstcajudgeqa);
	}
	/**
	 * 体检体检中医体质分型定义主键
	 * @return String
	 */
	public String getId_petcmconstcadef() {
		return ((String) getAttrVal("Id_petcmconstcadef"));
	}
	/**
	 * 体检体检中医体质分型定义主键
	 * @param Id_petcmconstcadef
	 */
	public void setId_petcmconstcadef(String Id_petcmconstcadef) {
		setAttrVal("Id_petcmconstcadef", Id_petcmconstcadef);
	}
	/**
	 * 单项分值
	 * @return Integer
	 */
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}
	/**
	 * 单项分值
	 * @param Score
	 */
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 英文名称
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}
	/**
	 * 英文名称
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
	}
	/**
	 * 分组号
	 * @return Integer
	 */
	public Integer getNo_group() {
		return ((Integer) getAttrVal("No_group"));
	}
	/**
	 * 分组号
	 * @param No_group
	 */
	public void setNo_group(Integer No_group) {
		setAttrVal("No_group", No_group);
	}
	/**
	 * 次序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 次序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 计分方式
	 * @return Integer
	 */
	public Integer getScoretp() {
		return ((Integer) getAttrVal("Scoretp"));
	}
	/**
	 * 计分方式
	 * @param Scoretp
	 */
	public void setScoretp(Integer Scoretp) {
		setAttrVal("Scoretp", Scoretp);
	}
}