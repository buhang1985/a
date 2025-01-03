package iih.ei.std.d.v1.en.schlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班信息 DTO数据 
 * 
 */
public class SchInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班id
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 排班id
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getCode_doc() {
		return ((String) getAttrVal("Code_doc"));
	}	
	/**
	 * 医生编码
	 * @param Code_doc
	 */
	public void setCode_doc(String Code_doc) {
		setAttrVal("Code_doc", Code_doc);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}	
	/**
	 * 医生名称
	 * @param Name_doc
	 */
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 医生职称编码
	 * @return String
	 */
	public String getCode_emptitle() {
		return ((String) getAttrVal("Code_emptitle"));
	}	
	/**
	 * 医生职称编码
	 * @param Code_emptitle
	 */
	public void setCode_emptitle(String Code_emptitle) {
		setAttrVal("Code_emptitle", Code_emptitle);
	}
	/**
	 * 医生职称名称
	 * @return String
	 */
	public String getName_emptitle() {
		return ((String) getAttrVal("Name_emptitle"));
	}	
	/**
	 * 医生职称名称
	 * @param Name_emptitle
	 */
	public void setName_emptitle(String Name_emptitle) {
		setAttrVal("Name_emptitle", Name_emptitle);
	}
	/**
	 * 就诊日期
	 * @return String
	 */
	public String getDt_sch() {
		return ((String) getAttrVal("Dt_sch"));
	}	
	/**
	 * 就诊日期
	 * @param Dt_sch
	 */
	public void setDt_sch(String Dt_sch) {
		setAttrVal("Dt_sch", Dt_sch);
	}
	/**
	 * 午别类型编码
	 * @return String
	 */
	public String getCode_dayslottp() {
		return ((String) getAttrVal("Code_dayslottp"));
	}	
	/**
	 * 午别类型编码
	 * @param Code_dayslottp
	 */
	public void setCode_dayslottp(String Code_dayslottp) {
		setAttrVal("Code_dayslottp", Code_dayslottp);
	}
	/**
	 * 午别类型名称
	 * @return String
	 */
	public String getName_dayslottp() {
		return ((String) getAttrVal("Name_dayslottp"));
	}	
	/**
	 * 午别类型名称
	 * @param Name_dayslottp
	 */
	public void setName_dayslottp(String Name_dayslottp) {
		setAttrVal("Name_dayslottp", Name_dayslottp);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
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
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 号别编码
	 * @return String
	 */
	public String getCode_srvtp() {
		return ((String) getAttrVal("Code_srvtp"));
	}	
	/**
	 * 号别编码
	 * @param Code_srvtp
	 */
	public void setCode_srvtp(String Code_srvtp) {
		setAttrVal("Code_srvtp", Code_srvtp);
	}
	/**
	 * 号别名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 号别名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 医生特长
	 * @return String
	 */
	public String getDoc_speciality() {
		return ((String) getAttrVal("Doc_speciality"));
	}	
	/**
	 * 医生特长
	 * @param Doc_speciality
	 */
	public void setDoc_speciality(String Doc_speciality) {
		setAttrVal("Doc_speciality", Doc_speciality);
	}
	/**
	 * 总号源
	 * @return Integer
	 */
	public Integer getTotal() {
		return ((Integer) getAttrVal("Total"));
	}	
	/**
	 * 总号源
	 * @param Total
	 */
	public void setTotal(Integer Total) {
		setAttrVal("Total", Total);
	}
	/**
	 * 已使用数
	 * @return Integer
	 */
	public Integer getUsed() {
		return ((Integer) getAttrVal("Used"));
	}	
	/**
	 * 已使用数
	 * @param Used
	 */
	public void setUsed(Integer Used) {
		setAttrVal("Used", Used);
	}
	/**
	 * 剩余数
	 * @return Integer
	 */
	public Integer getRemain() {
		return ((Integer) getAttrVal("Remain"));
	}	
	/**
	 * 剩余数
	 * @param Remain
	 */
	public void setRemain(Integer Remain) {
		setAttrVal("Remain", Remain);
	}
	/**
	 * 号源池
	 * @return Integer
	 */
	public Integer getScpolcn() {
		return ((Integer) getAttrVal("Scpolcn"));
	}	
	/**
	 * 号源池
	 * @param Scpolcn
	 */
	public void setScpolcn(Integer Scpolcn) {
		setAttrVal("Scpolcn", Scpolcn);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 停止挂号时间
	 * @return FDateTime
	 */
	public FDateTime getDt_stopreg() {
		return ((FDateTime) getAttrVal("Dt_stopreg"));
	}	
	/**
	 * 停止挂号时间
	 * @param Dt_stopreg
	 */
	public void setDt_stopreg(FDateTime Dt_stopreg) {
		setAttrVal("Dt_stopreg", Dt_stopreg);
	}
	/**
	 * 资源类型编码
	 * @return String
	 */
	public String getSd_screstp() {
		return ((String) getAttrVal("Sd_screstp"));
	}	
	/**
	 * 资源类型编码
	 * @param Sd_screstp
	 */
	public void setSd_screstp(String Sd_screstp) {
		setAttrVal("Sd_screstp", Sd_screstp);
	}
}