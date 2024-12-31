package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收费项目查询 DTO数据 
 * 
 */
public class OepfeeitmqryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 计费日期时间
	 * @return String
	 */
	public String getDt_cg() {
		return ((String) getAttrVal("Dt_cg"));
	}
	/**
	 * 计费日期时间
	 * @param Dt_cg
	 */
	public void setDt_cg(String Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	/**
	 * 开始计费时间
	 * @return String
	 */
	public String getDt_cg_begin() {
		return ((String) getAttrVal("Dt_cg_begin"));
	}
	/**
	 * 开始计费时间
	 * @param Dt_cg_begin
	 */
	public void setDt_cg_begin(String Dt_cg_begin) {
		setAttrVal("Dt_cg_begin", Dt_cg_begin);
	}
	/**
	 * 结束计费时间
	 * @return String
	 */
	public String getDt_cg_end() {
		return ((String) getAttrVal("Dt_cg_end"));
	}
	/**
	 * 结束计费时间
	 * @param Dt_cg_end
	 */
	public void setDt_cg_end(String Dt_cg_end) {
		setAttrVal("Dt_cg_end", Dt_cg_end);
	}
	/**
	 * 打印时间
	 * @return String
	 */
	public String getDt_print() {
		return ((String) getAttrVal("Dt_print"));
	}
	/**
	 * 打印时间
	 * @param Dt_print
	 */
	public void setDt_print(String Dt_print) {
		setAttrVal("Dt_print", Dt_print);
	}
	/**
	 * 金额(某项服务的总额)
	 * @return String
	 */
	public String getAmtsum() {
		return ((String) getAttrVal("Amtsum"));
	}
	/**
	 * 金额(某项服务的总额)
	 * @param Amtsum
	 */
	public void setAmtsum(String Amtsum) {
		setAttrVal("Amtsum", Amtsum);
	}
	/**
	 * 收入次数(所有服务的总次数)
	 * @return String
	 */
	public String getSrvcount() {
		return ((String) getAttrVal("Srvcount"));
	}
	/**
	 * 收入次数(所有服务的总次数)
	 * @param Srvcount
	 */
	public void setSrvcount(String Srvcount) {
		setAttrVal("Srvcount", Srvcount);
	}
	/**
	 * 金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 收入次数（某项服务的收入次数）
	 * @return String
	 */
	public String getCount() {
		return ((String) getAttrVal("Count"));
	}
	/**
	 * 收入次数（某项服务的收入次数）
	 * @param Count
	 */
	public void setCount(String Count) {
		setAttrVal("Count", Count);
	}
	/**
	 * 医院所属机构名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 医院所属机构名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
}