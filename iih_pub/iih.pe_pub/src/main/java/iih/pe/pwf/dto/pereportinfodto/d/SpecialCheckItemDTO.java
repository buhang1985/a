package iih.pe.pwf.dto.pereportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 专科检查项目详细信息 DTO数据 
 * 
 */
public class SpecialCheckItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 专科编码
	 * @return String
	 */
	public String getSpecialinfocode() {
		return ((String) getAttrVal("Specialinfocode"));
	}
	/**
	 * 专科编码
	 * @param Specialinfocode
	 */
	public void setSpecialinfocode(String Specialinfocode) {
		setAttrVal("Specialinfocode", Specialinfocode);
	}
	/**
	 * 项目显示序号
	 * @return Integer
	 */
	public Integer getSeqno() {
		return ((Integer) getAttrVal("Seqno"));
	}
	/**
	 * 项目显示序号
	 * @param Seqno
	 */
	public void setSeqno(Integer Seqno) {
		setAttrVal("Seqno", Seqno);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 项目编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 异常描述
	 * @return String
	 */
	public String getFlagname() {
		return ((String) getAttrVal("Flagname"));
	}
	/**
	 * 异常描述
	 * @param Flagname
	 */
	public void setFlagname(String Flagname) {
		setAttrVal("Flagname", Flagname);
	}
	/**
	 * 项目的显示结果
	 * @return String
	 */
	public String getDisplayresult() {
		return ((String) getAttrVal("Displayresult"));
	}
	/**
	 * 项目的显示结果
	 * @param Displayresult
	 */
	public void setDisplayresult(String Displayresult) {
		setAttrVal("Displayresult", Displayresult);
	}
	/**
	 * 项目结果的状态编码
	 * @return String
	 */
	public String getStatuscode() {
		return ((String) getAttrVal("Statuscode"));
	}
	/**
	 * 项目结果的状态编码
	 * @param Statuscode
	 */
	public void setStatuscode(String Statuscode) {
		setAttrVal("Statuscode", Statuscode);
	}
	/**
	 * 项目的结果
	 * @return String
	 */
	public String getResult() {
		return ((String) getAttrVal("Result"));
	}
	/**
	 * 项目的结果
	 * @param Result
	 */
	public void setResult(String Result) {
		setAttrVal("Result", Result);
	}
	/**
	 * 结果部位等信息的完整内容
	 * @return String
	 */
	public String getFullcontent() {
		return ((String) getAttrVal("Fullcontent"));
	}
	/**
	 * 结果部位等信息的完整内容
	 * @param Fullcontent
	 */
	public void setFullcontent(String Fullcontent) {
		setAttrVal("Fullcontent", Fullcontent);
	}
	/**
	 * 部位等信息(此部分内容为递归)
	 * @return FArrayList2
	 */
	public FArrayList2 getPart() {
		return ((FArrayList2) getAttrVal("Part"));
	}
	/**
	 * 部位等信息(此部分内容为递归)
	 * @param Part
	 */
	public void setPart(FArrayList2 Part) {
		setAttrVal("Part", Part);
	}
}