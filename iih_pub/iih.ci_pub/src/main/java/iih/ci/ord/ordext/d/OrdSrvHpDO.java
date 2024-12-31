package iih.ci.ord.ordext.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ordext.d.desc.OrdSrvHpDODesc;
import java.math.BigDecimal;

/**
 * 医嘱项目医保信息 DO数据 
 * 
 */
public class OrdSrvHpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务项目主键
	public static final String ID_ORSRVHP= "Id_orsrvhp";
	//服务项目主键标识
	public static final String ID_OR= "Id_or";
	//医嘱编码
	public static final String CODE_OR= "Code_or";
	//医嘱项目主键
	public static final String ID_ORSRV= "Id_orsrv";
	//就诊ID
	public static final String ID_EN= "Id_en";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//患者名称
	public static final String NAME_PAT= "Name_pat";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//服务ID
	public static final String ID_SRV= "Id_srv";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//物品ID
	public static final String ID_MM= "Id_mm";
	//物品编码
	public static final String CODE_MM= "Code_mm";
	//物品名称
	public static final String NAME_MM= "Name_mm";
	//医保目录ID
	public static final String ID_HPSRVTP= "Id_hpsrvtp";
	//医保目录SD
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	//适应症判断方式
	public static final String EU_HPSRVCTRTP= "Eu_hpsrvctrtp";
	//适应症条件主键串（支付比例）
	public static final String INDICITEMID= "Indicitemid";
	//临床医保适应症判定方式
	public static final String EU_HPJUDGE= "Eu_hpjudge";
	//医嘱适应症判断结果
	public static final String EU_ORHP= "Eu_orhp";
	//医嘱服务项目适应症判断结果
	public static final String EU_ORSRVHP= "Eu_orsrvhp";
	//院内限制条件
	public static final String DES_HISLIMIT= "Des_hislimit";
	//医保限制条件
	public static final String DES_HPLIMIT= "Des_hplimit";
	//特殊病标识
	public static final String FG_SPECILL= "Fg_specill";
	//备注信息
	public static final String DES= "Des";
	//疾病病种ID
	public static final String ID_DSDEF= "Id_dsdef";
	//疾病病种编码
	public static final String CODE_DSDEF= "Code_dsdef";
	//疾病病种名称
	public static final String NAME_DSDEF= "Name_dsdef";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 服务项目主键
	 * @return String
	 */
	public String getId_orsrvhp() {
		return ((String) getAttrVal("Id_orsrvhp"));
	}	
	/**
	 * 服务项目主键
	 * @param Id_orsrvhp
	 */
	public void setId_orsrvhp(String Id_orsrvhp) {
		setAttrVal("Id_orsrvhp", Id_orsrvhp);
	}
	/**
	 * 服务项目主键标识
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 服务项目主键标识
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱项目主键
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	/**
	 * 医嘱项目主键
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	/**
	 * 就诊ID
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
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
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务ID
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
	 * 物品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品ID
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 医保目录ID
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}	
	/**
	 * 医保目录ID
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保目录SD
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	/**
	 * 医保目录SD
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 适应症判断方式
	 * @return String
	 */
	public String getEu_hpsrvctrtp() {
		return ((String) getAttrVal("Eu_hpsrvctrtp"));
	}	
	/**
	 * 适应症判断方式
	 * @param Eu_hpsrvctrtp
	 */
	public void setEu_hpsrvctrtp(String Eu_hpsrvctrtp) {
		setAttrVal("Eu_hpsrvctrtp", Eu_hpsrvctrtp);
	}
	/**
	 * 适应症条件主键串（支付比例）
	 * @return String
	 */
	public String getIndicitemid() {
		return ((String) getAttrVal("Indicitemid"));
	}	
	/**
	 * 适应症条件主键串（支付比例）
	 * @param Indicitemid
	 */
	public void setIndicitemid(String Indicitemid) {
		setAttrVal("Indicitemid", Indicitemid);
	}
	/**
	 * 临床医保适应症判定方式
	 * @return String
	 */
	public String getEu_hpjudge() {
		return ((String) getAttrVal("Eu_hpjudge"));
	}	
	/**
	 * 临床医保适应症判定方式
	 * @param Eu_hpjudge
	 */
	public void setEu_hpjudge(String Eu_hpjudge) {
		setAttrVal("Eu_hpjudge", Eu_hpjudge);
	}
	/**
	 * 医嘱适应症判断结果
	 * @return String
	 */
	public String getEu_orhp() {
		return ((String) getAttrVal("Eu_orhp"));
	}	
	/**
	 * 医嘱适应症判断结果
	 * @param Eu_orhp
	 */
	public void setEu_orhp(String Eu_orhp) {
		setAttrVal("Eu_orhp", Eu_orhp);
	}
	/**
	 * 医嘱服务项目适应症判断结果
	 * @return String
	 */
	public String getEu_orsrvhp() {
		return ((String) getAttrVal("Eu_orsrvhp"));
	}	
	/**
	 * 医嘱服务项目适应症判断结果
	 * @param Eu_orsrvhp
	 */
	public void setEu_orsrvhp(String Eu_orsrvhp) {
		setAttrVal("Eu_orsrvhp", Eu_orsrvhp);
	}
	/**
	 * 院内限制条件
	 * @return String
	 */
	public String getDes_hislimit() {
		return ((String) getAttrVal("Des_hislimit"));
	}	
	/**
	 * 院内限制条件
	 * @param Des_hislimit
	 */
	public void setDes_hislimit(String Des_hislimit) {
		setAttrVal("Des_hislimit", Des_hislimit);
	}
	/**
	 * 医保限制条件
	 * @return String
	 */
	public String getDes_hplimit() {
		return ((String) getAttrVal("Des_hplimit"));
	}	
	/**
	 * 医保限制条件
	 * @param Des_hplimit
	 */
	public void setDes_hplimit(String Des_hplimit) {
		setAttrVal("Des_hplimit", Des_hplimit);
	}
	/**
	 * 特殊病标识
	 * @return FBoolean
	 */
	public FBoolean getFg_specill() {
		return ((FBoolean) getAttrVal("Fg_specill"));
	}	
	/**
	 * 特殊病标识
	 * @param Fg_specill
	 */
	public void setFg_specill(FBoolean Fg_specill) {
		setAttrVal("Fg_specill", Fg_specill);
	}
	/**
	 * 备注信息
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注信息
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 疾病病种ID
	 * @return String
	 */
	public String getId_dsdef() {
		return ((String) getAttrVal("Id_dsdef"));
	}	
	/**
	 * 疾病病种ID
	 * @param Id_dsdef
	 */
	public void setId_dsdef(String Id_dsdef) {
		setAttrVal("Id_dsdef", Id_dsdef);
	}
	/**
	 * 疾病病种编码
	 * @return String
	 */
	public String getCode_dsdef() {
		return ((String) getAttrVal("Code_dsdef"));
	}	
	/**
	 * 疾病病种编码
	 * @param Code_dsdef
	 */
	public void setCode_dsdef(String Code_dsdef) {
		setAttrVal("Code_dsdef", Code_dsdef);
	}
	/**
	 * 疾病病种名称
	 * @return String
	 */
	public String getName_dsdef() {
		return ((String) getAttrVal("Name_dsdef"));
	}	
	/**
	 * 疾病病种名称
	 * @param Name_dsdef
	 */
	public void setName_dsdef(String Name_dsdef) {
		setAttrVal("Name_dsdef", Name_dsdef);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_orsrvhp";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_srv_hp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdSrvHpDODesc.class);
	}
	
}