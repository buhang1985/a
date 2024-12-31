package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatAlDODesc;
import java.math.BigDecimal;

/**
 * 患者过敏史 DO数据 
 * 
 */
public class PiPatAlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者过敏史ID
	public static final String ID_PATAL= "Id_patal";
	//数据来源编码
	public static final String SD_DATASRC= "Sd_datasrc";
	//数据来源
	public static final String ID_DATASRC= "Id_datasrc";
	//日期
	public static final String DT_ACT= "Dt_act";
	//日期精度编码
	public static final String SD_YMD_ACT= "Sd_ymd_act";
	//日期精度
	public static final String ID_YMD_ACT= "Id_ymd_act";
	//过敏类型编码
	public static final String SD_ALTP= "Sd_altp";
	//过敏类型
	public static final String ID_ALTP= "Id_altp";
	//过敏类型名称
	public static final String NAME_ALTP= "Name_altp";
	//过敏类型描述
	public static final String DES_ALTP= "Des_altp";
	//过敏分类
	public static final String ID_ALCLA= "Id_alcla";
	//服务
	public static final String ID_SRV= "Id_srv";
	//物品
	public static final String ID_MM= "Id_mm";
	//过敏原编码
	public static final String SD_ALCLA= "Sd_alcla";
	//过敏分类名称
	public static final String NAME_ALCLA= "Name_alcla";
	//过敏分类描述
	public static final String DES_ALCLA= "Des_alcla";
	//过敏严重程度
	public static final String ID_ALDEG= "Id_aldeg";
	//过敏严重程度编码
	public static final String SD_ALDEG= "Sd_aldeg";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//医嘱id
	public static final String ID_OR= "Id_or";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//名称
	public static final String ALDEG_NAME= "Aldeg_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者过敏史ID
	 * @return String
	 */
	public String getId_patal() {
		return ((String) getAttrVal("Id_patal"));
	}	
	/**
	 * 患者过敏史ID
	 * @param Id_patal
	 */
	public void setId_patal(String Id_patal) {
		setAttrVal("Id_patal", Id_patal);
	}
	/**
	 * 数据来源编码
	 * @return String
	 */
	public String getSd_datasrc() {
		return ((String) getAttrVal("Sd_datasrc"));
	}	
	/**
	 * 数据来源编码
	 * @param Sd_datasrc
	 */
	public void setSd_datasrc(String Sd_datasrc) {
		setAttrVal("Sd_datasrc", Sd_datasrc);
	}
	/**
	 * 数据来源
	 * @return String
	 */
	public String getId_datasrc() {
		return ((String) getAttrVal("Id_datasrc"));
	}	
	/**
	 * 数据来源
	 * @param Id_datasrc
	 */
	public void setId_datasrc(String Id_datasrc) {
		setAttrVal("Id_datasrc", Id_datasrc);
	}
	/**
	 * 日期
	 * @return FDateTime
	 */
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	/**
	 * 日期
	 * @param Dt_act
	 */
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	/**
	 * 日期精度编码
	 * @return String
	 */
	public String getSd_ymd_act() {
		return ((String) getAttrVal("Sd_ymd_act"));
	}	
	/**
	 * 日期精度编码
	 * @param Sd_ymd_act
	 */
	public void setSd_ymd_act(String Sd_ymd_act) {
		setAttrVal("Sd_ymd_act", Sd_ymd_act);
	}
	/**
	 * 日期精度
	 * @return Integer
	 */
	public Integer getId_ymd_act() {
		return ((Integer) getAttrVal("Id_ymd_act"));
	}	
	/**
	 * 日期精度
	 * @param Id_ymd_act
	 */
	public void setId_ymd_act(Integer Id_ymd_act) {
		setAttrVal("Id_ymd_act", Id_ymd_act);
	}
	/**
	 * 过敏类型编码
	 * @return String
	 */
	public String getSd_altp() {
		return ((String) getAttrVal("Sd_altp"));
	}	
	/**
	 * 过敏类型编码
	 * @param Sd_altp
	 */
	public void setSd_altp(String Sd_altp) {
		setAttrVal("Sd_altp", Sd_altp);
	}
	/**
	 * 过敏类型
	 * @return String
	 */
	public String getId_altp() {
		return ((String) getAttrVal("Id_altp"));
	}	
	/**
	 * 过敏类型
	 * @param Id_altp
	 */
	public void setId_altp(String Id_altp) {
		setAttrVal("Id_altp", Id_altp);
	}
	/**
	 * 过敏类型名称
	 * @return String
	 */
	public String getName_altp() {
		return ((String) getAttrVal("Name_altp"));
	}	
	/**
	 * 过敏类型名称
	 * @param Name_altp
	 */
	public void setName_altp(String Name_altp) {
		setAttrVal("Name_altp", Name_altp);
	}
	/**
	 * 过敏类型描述
	 * @return String
	 */
	public String getDes_altp() {
		return ((String) getAttrVal("Des_altp"));
	}	
	/**
	 * 过敏类型描述
	 * @param Des_altp
	 */
	public void setDes_altp(String Des_altp) {
		setAttrVal("Des_altp", Des_altp);
	}
	/**
	 * 过敏分类
	 * @return String
	 */
	public String getId_alcla() {
		return ((String) getAttrVal("Id_alcla"));
	}	
	/**
	 * 过敏分类
	 * @param Id_alcla
	 */
	public void setId_alcla(String Id_alcla) {
		setAttrVal("Id_alcla", Id_alcla);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 过敏原编码
	 * @return String
	 */
	public String getSd_alcla() {
		return ((String) getAttrVal("Sd_alcla"));
	}	
	/**
	 * 过敏原编码
	 * @param Sd_alcla
	 */
	public void setSd_alcla(String Sd_alcla) {
		setAttrVal("Sd_alcla", Sd_alcla);
	}
	/**
	 * 过敏分类名称
	 * @return String
	 */
	public String getName_alcla() {
		return ((String) getAttrVal("Name_alcla"));
	}	
	/**
	 * 过敏分类名称
	 * @param Name_alcla
	 */
	public void setName_alcla(String Name_alcla) {
		setAttrVal("Name_alcla", Name_alcla);
	}
	/**
	 * 过敏分类描述
	 * @return String
	 */
	public String getDes_alcla() {
		return ((String) getAttrVal("Des_alcla"));
	}	
	/**
	 * 过敏分类描述
	 * @param Des_alcla
	 */
	public void setDes_alcla(String Des_alcla) {
		setAttrVal("Des_alcla", Des_alcla);
	}
	/**
	 * 过敏严重程度
	 * @return String
	 */
	public String getId_aldeg() {
		return ((String) getAttrVal("Id_aldeg"));
	}	
	/**
	 * 过敏严重程度
	 * @param Id_aldeg
	 */
	public void setId_aldeg(String Id_aldeg) {
		setAttrVal("Id_aldeg", Id_aldeg);
	}
	/**
	 * 过敏严重程度编码
	 * @return String
	 */
	public String getSd_aldeg() {
		return ((String) getAttrVal("Sd_aldeg"));
	}	
	/**
	 * 过敏严重程度编码
	 * @param Sd_aldeg
	 */
	public void setSd_aldeg(String Sd_aldeg) {
		setAttrVal("Sd_aldeg", Sd_aldeg);
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
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAldeg_name() {
		return ((String) getAttrVal("Aldeg_name"));
	}	
	/**
	 * 名称
	 * @param Aldeg_name
	 */
	public void setAldeg_name(String Aldeg_name) {
		setAttrVal("Aldeg_name", Aldeg_name);
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
		return "Id_patal";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_al";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatAlDODesc.class);
	}
	
}