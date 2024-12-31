package iih.mi.itf2.dto.dicompdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保病种(诊断)查询DTO DTO数据 
 * 
 */
public class DiCompDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 医保病种目录对照表主键
	 * @return String
	 */
	public String getId_hpdivshis() {
		return ((String) getAttrVal("Id_hpdivshis"));
	}
	/**
	 * 医保病种目录对照表主键
	 * @param Id_hpdivshis
	 */
	public void setId_hpdivshis(String Id_hpdivshis) {
		setAttrVal("Id_hpdivshis", Id_hpdivshis);
	}
	/**
	 * 医保计划主键
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划主键
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * His诊断主键
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}
	/**
	 * His诊断主键
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 对照状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}
	/**
	 * 对照状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * His诊断编码
	 * @return String
	 */
	public String getHis_didef_code() {
		return ((String) getAttrVal("His_didef_code"));
	}
	/**
	 * His诊断编码
	 * @param His_didef_code
	 */
	public void setHis_didef_code(String His_didef_code) {
		setAttrVal("His_didef_code", His_didef_code);
	}
	/**
	 * His诊断名称
	 * @return String
	 */
	public String getHis_didef_name() {
		return ((String) getAttrVal("His_didef_name"));
	}
	/**
	 * His诊断名称
	 * @param His_didef_name
	 */
	public void setHis_didef_name(String His_didef_name) {
		setAttrVal("His_didef_name", His_didef_name);
	}
	/**
	 * 医保诊断名称
	 * @return String
	 */
	public String getMi_hpdidict_name() {
		return ((String) getAttrVal("Mi_hpdidict_name"));
	}
	/**
	 * 医保诊断名称
	 * @param Mi_hpdidict_name
	 */
	public void setMi_hpdidict_name(String Mi_hpdidict_name) {
		setAttrVal("Mi_hpdidict_name", Mi_hpdidict_name);
	}
	/**
	 * 医保诊断编码
	 * @return String
	 */
	public String getMi_hpdidict_code() {
		return ((String) getAttrVal("Mi_hpdidict_code"));
	}
	/**
	 * 医保诊断编码
	 * @param Mi_hpdidict_code
	 */
	public void setMi_hpdidict_code(String Mi_hpdidict_code) {
		setAttrVal("Mi_hpdidict_code", Mi_hpdidict_code);
	}
	/**
	 * 特殊病病种标志
	 * @return String
	 */
	public String getMi_fg_di_spec() {
		return ((String) getAttrVal("Mi_fg_di_spec"));
	}
	/**
	 * 特殊病病种标志
	 * @param Mi_fg_di_spec
	 */
	public void setMi_fg_di_spec(String Mi_fg_di_spec) {
		setAttrVal("Mi_fg_di_spec", Mi_fg_di_spec);
	}
	/**
	 * 拼音助记码
	 * @return String
	 */
	public String getMi_py_code() {
		return ((String) getAttrVal("Mi_py_code"));
	}
	/**
	 * 拼音助记码
	 * @param Mi_py_code
	 */
	public void setMi_py_code(String Mi_py_code) {
		setAttrVal("Mi_py_code", Mi_py_code);
	}
	/**
	 * 五笔助记码
	 * @return String
	 */
	public String getMi_wb_code() {
		return ((String) getAttrVal("Mi_wb_code"));
	}
	/**
	 * 五笔助记码
	 * @param Mi_wb_code
	 */
	public void setMi_wb_code(String Mi_wb_code) {
		setAttrVal("Mi_wb_code", Mi_wb_code);
	}
	/**
	 * 自定义码
	 * @return String
	 */
	public String getMi_zdy_code() {
		return ((String) getAttrVal("Mi_zdy_code"));
	}
	/**
	 * 自定义码
	 * @param Mi_zdy_code
	 */
	public void setMi_zdy_code(String Mi_zdy_code) {
		setAttrVal("Mi_zdy_code", Mi_zdy_code);
	}
	/**
	 * 有效标志
	 * @return String
	 */
	public String getMi_fg_effective() {
		return ((String) getAttrVal("Mi_fg_effective"));
	}
	/**
	 * 有效标志
	 * @param Mi_fg_effective
	 */
	public void setMi_fg_effective(String Mi_fg_effective) {
		setAttrVal("Mi_fg_effective", Mi_fg_effective);
	}
	/**
	 * 经办人
	 * @return String
	 */
	public String getMi_emp_handle() {
		return ((String) getAttrVal("Mi_emp_handle"));
	}
	/**
	 * 经办人
	 * @param Mi_emp_handle
	 */
	public void setMi_emp_handle(String Mi_emp_handle) {
		setAttrVal("Mi_emp_handle", Mi_emp_handle);
	}
	/**
	 * 经办时间
	 * @return FDateTime
	 */
	public FDateTime getMi_dt_handle() {
		return ((FDateTime) getAttrVal("Mi_dt_handle"));
	}
	/**
	 * 经办时间
	 * @param Mi_dt_handle
	 */
	public void setMi_dt_handle(FDateTime Mi_dt_handle) {
		setAttrVal("Mi_dt_handle", Mi_dt_handle);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getMi_note() {
		return ((String) getAttrVal("Mi_note"));
	}
	/**
	 * 备注
	 * @param Mi_note
	 */
	public void setMi_note(String Mi_note) {
		setAttrVal("Mi_note", Mi_note);
	}
	/**
	 * 医保备用字段1
	 * @return String
	 */
	public String getMi_def1() {
		return ((String) getAttrVal("Mi_def1"));
	}
	/**
	 * 医保备用字段1
	 * @param Mi_def1
	 */
	public void setMi_def1(String Mi_def1) {
		setAttrVal("Mi_def1", Mi_def1);
	}
	/**
	 * 医保备用字段2
	 * @return String
	 */
	public String getMi_def2() {
		return ((String) getAttrVal("Mi_def2"));
	}
	/**
	 * 医保备用字段2
	 * @param Mi_def2
	 */
	public void setMi_def2(String Mi_def2) {
		setAttrVal("Mi_def2", Mi_def2);
	}
	/**
	 * 医保备用字段3
	 * @return String
	 */
	public String getMi_def3() {
		return ((String) getAttrVal("Mi_def3"));
	}
	/**
	 * 医保备用字段3
	 * @param Mi_def3
	 */
	public void setMi_def3(String Mi_def3) {
		setAttrVal("Mi_def3", Mi_def3);
	}
	/**
	 * 医保备用字段4
	 * @return String
	 */
	public String getMi_def4() {
		return ((String) getAttrVal("Mi_def4"));
	}
	/**
	 * 医保备用字段4
	 * @param Mi_def4
	 */
	public void setMi_def4(String Mi_def4) {
		setAttrVal("Mi_def4", Mi_def4);
	}
	/**
	 * 医保备用字段5
	 * @return String
	 */
	public String getMi_def5() {
		return ((String) getAttrVal("Mi_def5"));
	}
	/**
	 * 医保备用字段5
	 * @param Mi_def5
	 */
	public void setMi_def5(String Mi_def5) {
		setAttrVal("Mi_def5", Mi_def5);
	}
	/**
	 * 医保备用字段6
	 * @return String
	 */
	public String getMi_def6() {
		return ((String) getAttrVal("Mi_def6"));
	}
	/**
	 * 医保备用字段6
	 * @param Mi_def6
	 */
	public void setMi_def6(String Mi_def6) {
		setAttrVal("Mi_def6", Mi_def6);
	}
	/**
	 * 医保备用字段7
	 * @return String
	 */
	public String getMi_def7() {
		return ((String) getAttrVal("Mi_def7"));
	}
	/**
	 * 医保备用字段7
	 * @param Mi_def7
	 */
	public void setMi_def7(String Mi_def7) {
		setAttrVal("Mi_def7", Mi_def7);
	}
	/**
	 * 医保备用字段8
	 * @return String
	 */
	public String getMi_def8() {
		return ((String) getAttrVal("Mi_def8"));
	}
	/**
	 * 医保备用字段8
	 * @param Mi_def8
	 */
	public void setMi_def8(String Mi_def8) {
		setAttrVal("Mi_def8", Mi_def8);
	}
	/**
	 * 医保备用字段9
	 * @return String
	 */
	public String getMi_def9() {
		return ((String) getAttrVal("Mi_def9"));
	}
	/**
	 * 医保备用字段9
	 * @param Mi_def9
	 */
	public void setMi_def9(String Mi_def9) {
		setAttrVal("Mi_def9", Mi_def9);
	}
	/**
	 * 医保备用字段10
	 * @return String
	 */
	public String getMi_def10() {
		return ((String) getAttrVal("Mi_def10"));
	}
	/**
	 * 医保备用字段10
	 * @param Mi_def10
	 */
	public void setMi_def10(String Mi_def10) {
		setAttrVal("Mi_def10", Mi_def10);
	}
	/**
	 * 医保备用字段11
	 * @return String
	 */
	public String getMi_def11() {
		return ((String) getAttrVal("Mi_def11"));
	}
	/**
	 * 医保备用字段11
	 * @param Mi_def11
	 */
	public void setMi_def11(String Mi_def11) {
		setAttrVal("Mi_def11", Mi_def11);
	}
	/**
	 * 医保备用字段12
	 * @return String
	 */
	public String getMi_def12() {
		return ((String) getAttrVal("Mi_def12"));
	}
	/**
	 * 医保备用字段12
	 * @param Mi_def12
	 */
	public void setMi_def12(String Mi_def12) {
		setAttrVal("Mi_def12", Mi_def12);
	}
	/**
	 * 医保备用字段13
	 * @return String
	 */
	public String getMi_def13() {
		return ((String) getAttrVal("Mi_def13"));
	}
	/**
	 * 医保备用字段13
	 * @param Mi_def13
	 */
	public void setMi_def13(String Mi_def13) {
		setAttrVal("Mi_def13", Mi_def13);
	}
	/**
	 * 医保备用字段14
	 * @return String
	 */
	public String getMi_def14() {
		return ((String) getAttrVal("Mi_def14"));
	}
	/**
	 * 医保备用字段14
	 * @param Mi_def14
	 */
	public void setMi_def14(String Mi_def14) {
		setAttrVal("Mi_def14", Mi_def14);
	}
	/**
	 * 医保备用字段15
	 * @return String
	 */
	public String getMi_def15() {
		return ((String) getAttrVal("Mi_def15"));
	}
	/**
	 * 医保备用字段15
	 * @param Mi_def15
	 */
	public void setMi_def15(String Mi_def15) {
		setAttrVal("Mi_def15", Mi_def15);
	}
	/**
	 * 医保备用字段16
	 * @return String
	 */
	public String getMi_def16() {
		return ((String) getAttrVal("Mi_def16"));
	}
	/**
	 * 医保备用字段16
	 * @param Mi_def16
	 */
	public void setMi_def16(String Mi_def16) {
		setAttrVal("Mi_def16", Mi_def16);
	}
	/**
	 * 医保备用字段17
	 * @return String
	 */
	public String getMi_def17() {
		return ((String) getAttrVal("Mi_def17"));
	}
	/**
	 * 医保备用字段17
	 * @param Mi_def17
	 */
	public void setMi_def17(String Mi_def17) {
		setAttrVal("Mi_def17", Mi_def17);
	}
	/**
	 * 医保备用字段18
	 * @return String
	 */
	public String getMi_def18() {
		return ((String) getAttrVal("Mi_def18"));
	}
	/**
	 * 医保备用字段18
	 * @param Mi_def18
	 */
	public void setMi_def18(String Mi_def18) {
		setAttrVal("Mi_def18", Mi_def18);
	}
	/**
	 * 医保备用字段19
	 * @return String
	 */
	public String getMi_def19() {
		return ((String) getAttrVal("Mi_def19"));
	}
	/**
	 * 医保备用字段19
	 * @param Mi_def19
	 */
	public void setMi_def19(String Mi_def19) {
		setAttrVal("Mi_def19", Mi_def19);
	}
	/**
	 * 医保备用字段20
	 * @return String
	 */
	public String getMi_def20() {
		return ((String) getAttrVal("Mi_def20"));
	}
	/**
	 * 医保备用字段20
	 * @param Mi_def20
	 */
	public void setMi_def20(String Mi_def20) {
		setAttrVal("Mi_def20", Mi_def20);
	}
}