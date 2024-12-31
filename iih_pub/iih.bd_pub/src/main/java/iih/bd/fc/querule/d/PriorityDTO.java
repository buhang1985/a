package iih.bd.fc.querule.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 优先级DTO DTO数据 
 * 
 */
public class PriorityDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 优先级
	 * @return Integer
	 */
	public Integer getLevel_pri() {
		return ((Integer) getAttrVal("Level_pri"));
	}
	/**
	 * 优先级
	 * @param Level_pri
	 */
	public void setLevel_pri(Integer Level_pri) {
		setAttrVal("Level_pri", Level_pri);
	}
	/**
	 * 是否续诊
	 * @return FBoolean
	 */
	public FBoolean getFg_cont() {
		return ((FBoolean) getAttrVal("Fg_cont"));
	}
	/**
	 * 是否续诊
	 * @param Fg_cont
	 */
	public void setFg_cont(FBoolean Fg_cont) {
		setAttrVal("Fg_cont", Fg_cont);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 排班服务
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 病情等级编码
	 * @return String
	 */
	public String getCode_level_dise() {
		return ((String) getAttrVal("Code_level_dise"));
	}
	/**
	 * 病情等级编码
	 * @param Code_level_dise
	 */
	public void setCode_level_dise(String Code_level_dise) {
		setAttrVal("Code_level_dise", Code_level_dise);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 处方类型id
	 * @return String
	 */
	public String getId_prestp() {
		return ((String) getAttrVal("Id_prestp"));
	}
	/**
	 * 处方类型id
	 * @param Id_prestp
	 */
	public void setId_prestp(String Id_prestp) {
		setAttrVal("Id_prestp", Id_prestp);
	}
	/**
	 * 计划内入院
	 * @return FBoolean
	 */
	public FBoolean getFg_planip() {
		return ((FBoolean) getAttrVal("Fg_planip"));
	}
	/**
	 * 计划内入院
	 * @param Fg_planip
	 */
	public void setFg_planip(FBoolean Fg_planip) {
		setAttrVal("Fg_planip", Fg_planip);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getD_birth() {
		return ((FDate) getAttrVal("D_birth"));
	}
	/**
	 * 出生日期
	 * @param D_birth
	 */
	public void setD_birth(FDate D_birth) {
		setAttrVal("D_birth", D_birth);
	}
	/**
	 * 入院申请单id
	 * @return String
	 */
	public String getId_aptip() {
		return ((String) getAttrVal("Id_aptip"));
	}
	/**
	 * 入院申请单id
	 * @param Id_aptip
	 */
	public void setId_aptip(String Id_aptip) {
		setAttrVal("Id_aptip", Id_aptip);
	}
	/**
	 * 基数药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_base() {
		return ((FBoolean) getAttrVal("Fg_base"));
	}
	/**
	 * 基数药标志
	 * @param Fg_base
	 */
	public void setFg_base(FBoolean Fg_base) {
		setAttrVal("Fg_base", Fg_base);
	}
	/**
	 * 标签类型
	 * @return String
	 */
	public String getId_tagtp() {
		return ((String) getAttrVal("Id_tagtp"));
	}
	/**
	 * 标签类型
	 * @param Id_tagtp
	 */
	public void setId_tagtp(String Id_tagtp) {
		setAttrVal("Id_tagtp", Id_tagtp);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * VIP
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}
	/**
	 * VIP
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
}