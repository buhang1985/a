package iih.ei.std.d.v1.hr.schedsiinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 班次信息 DTO数据 
 * 
 */
public class SchedSiInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 班次信息ID
	 * @return String
	 */
	public String getId_hsc_si() {
		return ((String) getAttrVal("Id_hsc_si"));
	}	
	/**
	 * 班次信息ID
	 * @param Id_hsc_si
	 */
	public void setId_hsc_si(String Id_hsc_si) {
		setAttrVal("Id_hsc_si", Id_hsc_si);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 简称
	 * @return String
	 */
	public String getName_short() {
		return ((String) getAttrVal("Name_short"));
	}	
	/**
	 * 简称
	 * @param Name_short
	 */
	public void setName_short(String Name_short) {
		setAttrVal("Name_short", Name_short);
	}
	/**
	 * 所属类型名称
	 * @return String
	 */
	public String getId_owntp() {
		return ((String) getAttrVal("Id_owntp"));
	}	
	/**
	 * 所属类型名称
	 * @param Id_owntp
	 */
	public void setId_owntp(String Id_owntp) {
		setAttrVal("Id_owntp", Id_owntp);
	}
	/**
	 * 所属类型编码
	 * @return String
	 */
	public String getSd_owntp() {
		return ((String) getAttrVal("Sd_owntp"));
	}	
	/**
	 * 所属类型编码
	 * @param Sd_owntp
	 */
	public void setSd_owntp(String Sd_owntp) {
		setAttrVal("Sd_owntp", Sd_owntp);
	}
	/**
	 * 所属科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 所属科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 排班分类名称
	 * @return String
	 */
	public String getId_sica() {
		return ((String) getAttrVal("Id_sica"));
	}	
	/**
	 * 排班分类名称
	 * @param Id_sica
	 */
	public void setId_sica(String Id_sica) {
		setAttrVal("Id_sica", Id_sica);
	}
	/**
	 * 排班分类编码
	 * @return String
	 */
	public String getSd_sica() {
		return ((String) getAttrVal("Sd_sica"));
	}	
	/**
	 * 排班分类编码
	 * @param Sd_sica
	 */
	public void setSd_sica(String Sd_sica) {
		setAttrVal("Sd_sica", Sd_sica);
	}
	/**
	 * 休息时长
	 * @return FDouble
	 */
	public FDouble getRest_dur() {
		return ((FDouble) getAttrVal("Rest_dur"));
	}	
	/**
	 * 休息时长
	 * @param Rest_dur
	 */
	public void setRest_dur(FDouble Rest_dur) {
		setAttrVal("Rest_dur", Rest_dur);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 上班时间
	 * @return FTime
	 */
	public FTime getDt_beon() {
		return ((FTime) getAttrVal("Dt_beon"));
	}	
	/**
	 * 上班时间
	 * @param Dt_beon
	 */
	public void setDt_beon(FTime Dt_beon) {
		setAttrVal("Dt_beon", Dt_beon);
	}
	/**
	 * 下班时间
	 * @return FTime
	 */
	public FTime getDt_off() {
		return ((FTime) getAttrVal("Dt_off"));
	}	
	/**
	 * 下班时间
	 * @param Dt_off
	 */
	public void setDt_off(FTime Dt_off) {
		setAttrVal("Dt_off", Dt_off);
	}
	/**
	 * 考勤时长
	 * @return FDouble
	 */
	public FDouble getDur_check() {
		return ((FDouble) getAttrVal("Dur_check"));
	}	
	/**
	 * 考勤时长
	 * @param Dur_check
	 */
	public void setDur_check(FDouble Dur_check) {
		setAttrVal("Dur_check", Dur_check);
	}
	/**
	 * 上班时间（扩展）
	 * @return FTime
	 */
	public FTime getDt_beon2() {
		return ((FTime) getAttrVal("Dt_beon2"));
	}	
	/**
	 * 上班时间（扩展）
	 * @param Dt_beon2
	 */
	public void setDt_beon2(FTime Dt_beon2) {
		setAttrVal("Dt_beon2", Dt_beon2);
	}
	/**
	 * 下班时间（扩展）
	 * @return FTime
	 */
	public FTime getDt_off2() {
		return ((FTime) getAttrVal("Dt_off2"));
	}	
	/**
	 * 下班时间（扩展）
	 * @param Dt_off2
	 */
	public void setDt_off2(FTime Dt_off2) {
		setAttrVal("Dt_off2", Dt_off2);
	}
	/**
	 * 是否启用标记
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用标记
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 操作人id
	 * @return String
	 */
	public String getId_opr() {
		return ((String) getAttrVal("Id_opr"));
	}	
	/**
	 * 操作人id
	 * @param Id_opr
	 */
	public void setId_opr(String Id_opr) {
		setAttrVal("Id_opr", Id_opr);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_opt() {
		return ((FDateTime) getAttrVal("Dt_opt"));
	}	
	/**
	 * 操作时间
	 * @param Dt_opt
	 */
	public void setDt_opt(FDateTime Dt_opt) {
		setAttrVal("Dt_opt", Dt_opt);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 所属类型
	 * @return String
	 */
	public String getName_owntp() {
		return ((String) getAttrVal("Name_owntp"));
	}	
	/**
	 * 所属类型
	 * @param Name_owntp
	 */
	public void setName_owntp(String Name_owntp) {
		setAttrVal("Name_owntp", Name_owntp);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getMemo() {
		return ((String) getAttrVal("Memo"));
	}	
	/**
	 * 备注
	 * @param Memo
	 */
	public void setMemo(String Memo) {
		setAttrVal("Memo", Memo);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 所属科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 班次分类
	 * @return String
	 */
	public String getName_sica() {
		return ((String) getAttrVal("Name_sica"));
	}	
	/**
	 * 班次分类
	 * @param Name_sica
	 */
	public void setName_sica(String Name_sica) {
		setAttrVal("Name_sica", Name_sica);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getName_opr() {
		return ((String) getAttrVal("Name_opr"));
	}	
	/**
	 * 操作人
	 * @param Name_opr
	 */
	public void setName_opr(String Name_opr) {
		setAttrVal("Name_opr", Name_opr);
	}
}