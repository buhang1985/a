package iih.mp.nr.wardsrvqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病区诊疗项目查询条件 DTO数据 
 * 
 */
public class WardSrvQryConditionDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 护理病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 护理病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
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
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 医疗服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 在院就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 在院就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 入院患者id
	 * @return String
	 */
	public String getId_pat_in() {
		return ((String) getAttrVal("Id_pat_in"));
	}
	/**
	 * 入院患者id
	 * @param Id_pat_in
	 */
	public void setId_pat_in(String Id_pat_in) {
		setAttrVal("Id_pat_in", Id_pat_in);
	}
	/**
	 * 入院患者名称
	 * @return String
	 */
	public String getName_pat_in() {
		return ((String) getAttrVal("Name_pat_in"));
	}
	/**
	 * 入院患者名称
	 * @param Name_pat_in
	 */
	public void setName_pat_in(String Name_pat_in) {
		setAttrVal("Name_pat_in", Name_pat_in);
	}
	/**
	 * 出院患者id
	 * @return String
	 */
	public String getId_pat_out() {
		return ((String) getAttrVal("Id_pat_out"));
	}
	/**
	 * 出院患者id
	 * @param Id_pat_out
	 */
	public void setId_pat_out(String Id_pat_out) {
		setAttrVal("Id_pat_out", Id_pat_out);
	}
	/**
	 * 出院患者姓名
	 * @return String
	 */
	public String getName_pat_out() {
		return ((String) getAttrVal("Name_pat_out"));
	}
	/**
	 * 出院患者姓名
	 * @param Name_pat_out
	 */
	public void setName_pat_out(String Name_pat_out) {
		setAttrVal("Name_pat_out", Name_pat_out);
	}
}