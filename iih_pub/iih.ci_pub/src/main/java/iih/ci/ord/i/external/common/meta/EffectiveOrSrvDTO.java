package iih.ci.ord.i.external.common.meta;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 有效服务项目数据传输对象 <br>
 * 临床有效服务项目为， 门诊 医嘱 已签署、未作废，服务项目未退费，在提供给各域使用时需要在进行过滤
 * 
 * @author HUMS
 *
 */
public class EffectiveOrSrvDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
	 * 医嘱主键标识
	 * 
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}

	/**
	 * 医嘱主键标识
	 * 
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	
	/**
	 * 医嘱服务项目主键
	 * 
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}

	/**
	 * 医嘱服务项目主键
	 * 
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}

	/**
	 * 就诊
	 * 
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}

	/**
	 * 就诊
	 * 
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}

	/**
	 * 就诊类型
	 * 
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}

	/**
	 * 就诊类型
	 * 
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}

	/**
	 * 医嘱名称
	 * 
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}

	/**
	 * 医嘱名称
	 * 
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	
	/**
	 * 服务项目对应的服务名称
	 * 
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}

	/**
	 * 服务项目对应的服务名称
	 * 
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}	

	/**
	 * 医嘱状态编码
	 * 
	 * @return
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}

	/**
	 * 医嘱状态编码
	 * 
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	
	/**
	 * 可退费标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}

	/**
	 * 可退费标识
	 * 
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	
	/**
	 * 服务项目记账状态编码
	 * 
	 * @return FBoolean
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}

	/**
	 * 服务项目记账状态编码
	 * 
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}

	/**
	 * 费用标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}

	/**
	 * 费用标识
	 * 
	 * @param Fg_feertnable
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	
	/**
	 * 服务项目sv标识
	 * 
	 * @return
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}

	/**
	 * 服务项目sv标识
	 * 
	 * @param sv
	 */
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}
}
