package iih.ei.std.d.v1.sc.mtschlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技排班列表入参 DTO数据 
 * 
 */
public class MtSchListParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班开始日期
	 * @return FDate
	 */
	public FDate getDate_b() {
		return ((FDate) getAttrVal("Date_b"));
	}	
	/**
	 * 排班开始日期
	 * @param Date_b
	 */
	public void setDate_b(FDate Date_b) {
		setAttrVal("Date_b", Date_b);
	}
	/**
	 * 排班结束日期
	 * @return FDate
	 */
	public FDate getDate_e() {
		return ((FDate) getAttrVal("Date_e"));
	}	
	/**
	 * 排班结束日期
	 * @param Date_e
	 */
	public void setDate_e(FDate Date_e) {
		setAttrVal("Date_e", Date_e);
	}
	/**
	 * 诊疗项目id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 诊疗项目id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 渠道类型
	 * @return String
	 */
	public String getChl_type() {
		return ((String) getAttrVal("Chl_type"));
	}	
	/**
	 * 渠道类型
	 * @param Chl_type
	 */
	public void setChl_type(String Chl_type) {
		setAttrVal("Chl_type", Chl_type);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getCode_opr() {
		return ((String) getAttrVal("Code_opr"));
	}	
	/**
	 * 操作员
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