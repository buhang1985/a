package iih.ei.std.d.v1.en.entlistbyquebencode.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 分诊台可分诊的挂号队列入参 DTO数据 
 * 
 */
public class EntListByQuebencodeParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 分诊台编码
	 * @return String
	 */
	public String getCode_queben() {
		return ((String) getAttrVal("Code_queben"));
	}	
	/**
	 * 分诊台编码
	 * @param Code_queben
	 */
	public void setCode_queben(String Code_queben) {
		setAttrVal("Code_queben", Code_queben);
	}
	/**
	 * 操作员编码
	 * @return String
	 */
	public String getCode_opr() {
		return ((String) getAttrVal("Code_opr"));
	}	
	/**
	 * 操作员编码
	 * @param Code_opr
	 */
	public void setCode_opr(String Code_opr) {
		setAttrVal("Code_opr", Code_opr);
	}
	/**
	 * 分页信息
	 * @return String
	 */
	public FArrayList getPageinfo() {
		return ((FArrayList) getAttrVal("Pageinfo"));
	}	
	/**
	 * 分页信息
	 * @param Pageinfo
	 */
	public void setPageinfo(FArrayList Pageinfo) {
		setAttrVal("Pageinfo", Pageinfo);
	}
}