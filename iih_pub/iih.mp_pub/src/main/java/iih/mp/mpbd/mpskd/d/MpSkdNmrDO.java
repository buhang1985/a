package iih.mp.mpbd.mpskd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.mpskd.d.desc.MpSkdNmrDODesc;
import java.math.BigDecimal;

/**
 * 护理文书 DO数据 
 * 
 */
public class MpSkdNmrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//文书规则
	public static final String ID_SKD_NMR= "Id_skd_nmr";
	//护理任务
	public static final String ID_SKD= "Id_skd";
	//护理文书
	public static final String ID_NMR_DOC= "Id_nmr_doc";
	//数据元
	public static final String ID_DE= "Id_de";
	//文本值
	public static final String VAL= "Val";
	//最小值包含
	public static final String FG_MININ= "Fg_minin";
	//最小值
	public static final String VAL_MIN= "Val_min";
	//最大值
	public static final String VAL_MAX= "Val_max";
	//最大值包含
	public static final String FG_MAXIN= "Fg_maxin";
	//属性名称
	public static final String FIELDNAME= "Fieldname";
	//就诊状况类型
	public static final String ID_ENSTATETP= "Id_enstatetp";
	//就诊状况类型编码
	public static final String SD_ENSTATETP= "Sd_enstatetp";
	//就诊状况
	public static final String ID_ENSTATE= "Id_enstate";
	//评估时间
	public static final String ID_EVALU_TIME= "Id_evalu_time";
	//评估时间字段
	public static final String EVALUNAME= "Evaluname";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//值类型
	public static final String VALTYPE= "Valtype";
	//护理任务
	public static final String NAME_SKD= "Name_skd";
	//护理文书
	public static final String NAME_NMR_DOC= "Name_nmr_doc";
	//护理文书数据集
	public static final String ID_SET_NMR_DOC= "Id_set_nmr_doc";
	//数据元名称
	public static final String NAME_DE= "Name_de";
	//就诊状况类型
	public static final String NAME_ENSTATETP= "Name_enstatetp";
	//就诊状况
	public static final String NAME_ENSTATE= "Name_enstate";
	//评估时间字段
	public static final String NAME_EVALU_TIME= "Name_evalu_time";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 文书规则
	 * @return String
	 */
	public String getId_skd_nmr() {
		return ((String) getAttrVal("Id_skd_nmr"));
	}	
	/**
	 * 文书规则
	 * @param Id_skd_nmr
	 */
	public void setId_skd_nmr(String Id_skd_nmr) {
		setAttrVal("Id_skd_nmr", Id_skd_nmr);
	}
	/**
	 * 护理任务
	 * @return String
	 */
	public String getId_skd() {
		return ((String) getAttrVal("Id_skd"));
	}	
	/**
	 * 护理任务
	 * @param Id_skd
	 */
	public void setId_skd(String Id_skd) {
		setAttrVal("Id_skd", Id_skd);
	}
	/**
	 * 护理文书
	 * @return String
	 */
	public String getId_nmr_doc() {
		return ((String) getAttrVal("Id_nmr_doc"));
	}	
	/**
	 * 护理文书
	 * @param Id_nmr_doc
	 */
	public void setId_nmr_doc(String Id_nmr_doc) {
		setAttrVal("Id_nmr_doc", Id_nmr_doc);
	}
	/**
	 * 数据元
	 * @return String
	 */
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	/**
	 * 数据元
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	/**
	 * 文本值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	/**
	 * 文本值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 最小值包含
	 * @return FBoolean
	 */
	public FBoolean getFg_minin() {
		return ((FBoolean) getAttrVal("Fg_minin"));
	}	
	/**
	 * 最小值包含
	 * @param Fg_minin
	 */
	public void setFg_minin(FBoolean Fg_minin) {
		setAttrVal("Fg_minin", Fg_minin);
	}
	/**
	 * 最小值
	 * @return FDouble
	 */
	public FDouble getVal_min() {
		return ((FDouble) getAttrVal("Val_min"));
	}	
	/**
	 * 最小值
	 * @param Val_min
	 */
	public void setVal_min(FDouble Val_min) {
		setAttrVal("Val_min", Val_min);
	}
	/**
	 * 最大值
	 * @return FDouble
	 */
	public FDouble getVal_max() {
		return ((FDouble) getAttrVal("Val_max"));
	}	
	/**
	 * 最大值
	 * @param Val_max
	 */
	public void setVal_max(FDouble Val_max) {
		setAttrVal("Val_max", Val_max);
	}
	/**
	 * 最大值包含
	 * @return FBoolean
	 */
	public FBoolean getFg_maxin() {
		return ((FBoolean) getAttrVal("Fg_maxin"));
	}	
	/**
	 * 最大值包含
	 * @param Fg_maxin
	 */
	public void setFg_maxin(FBoolean Fg_maxin) {
		setAttrVal("Fg_maxin", Fg_maxin);
	}
	/**
	 * 属性名称
	 * @return String
	 */
	public String getFieldname() {
		return ((String) getAttrVal("Fieldname"));
	}	
	/**
	 * 属性名称
	 * @param Fieldname
	 */
	public void setFieldname(String Fieldname) {
		setAttrVal("Fieldname", Fieldname);
	}
	/**
	 * 就诊状况类型
	 * @return String
	 */
	public String getId_enstatetp() {
		return ((String) getAttrVal("Id_enstatetp"));
	}	
	/**
	 * 就诊状况类型
	 * @param Id_enstatetp
	 */
	public void setId_enstatetp(String Id_enstatetp) {
		setAttrVal("Id_enstatetp", Id_enstatetp);
	}
	/**
	 * 就诊状况类型编码
	 * @return String
	 */
	public String getSd_enstatetp() {
		return ((String) getAttrVal("Sd_enstatetp"));
	}	
	/**
	 * 就诊状况类型编码
	 * @param Sd_enstatetp
	 */
	public void setSd_enstatetp(String Sd_enstatetp) {
		setAttrVal("Sd_enstatetp", Sd_enstatetp);
	}
	/**
	 * 就诊状况
	 * @return String
	 */
	public String getId_enstate() {
		return ((String) getAttrVal("Id_enstate"));
	}	
	/**
	 * 就诊状况
	 * @param Id_enstate
	 */
	public void setId_enstate(String Id_enstate) {
		setAttrVal("Id_enstate", Id_enstate);
	}
	/**
	 * 评估时间
	 * @return String
	 */
	public String getId_evalu_time() {
		return ((String) getAttrVal("Id_evalu_time"));
	}	
	/**
	 * 评估时间
	 * @param Id_evalu_time
	 */
	public void setId_evalu_time(String Id_evalu_time) {
		setAttrVal("Id_evalu_time", Id_evalu_time);
	}
	/**
	 * 评估时间字段
	 * @return String
	 */
	public String getEvaluname() {
		return ((String) getAttrVal("Evaluname"));
	}	
	/**
	 * 评估时间字段
	 * @param Evaluname
	 */
	public void setEvaluname(String Evaluname) {
		setAttrVal("Evaluname", Evaluname);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 值类型
	 * @return Integer
	 */
	public Integer getValtype() {
		return ((Integer) getAttrVal("Valtype"));
	}	
	/**
	 * 值类型
	 * @param Valtype
	 */
	public void setValtype(Integer Valtype) {
		setAttrVal("Valtype", Valtype);
	}
	/**
	 * 护理任务
	 * @return String
	 */
	public String getName_skd() {
		return ((String) getAttrVal("Name_skd"));
	}	
	/**
	 * 护理任务
	 * @param Name_skd
	 */
	public void setName_skd(String Name_skd) {
		setAttrVal("Name_skd", Name_skd);
	}
	/**
	 * 护理文书
	 * @return String
	 */
	public String getName_nmr_doc() {
		return ((String) getAttrVal("Name_nmr_doc"));
	}	
	/**
	 * 护理文书
	 * @param Name_nmr_doc
	 */
	public void setName_nmr_doc(String Name_nmr_doc) {
		setAttrVal("Name_nmr_doc", Name_nmr_doc);
	}
	/**
	 * 护理文书数据集
	 * @return String
	 */
	public String getId_set_nmr_doc() {
		return ((String) getAttrVal("Id_set_nmr_doc"));
	}	
	/**
	 * 护理文书数据集
	 * @param Id_set_nmr_doc
	 */
	public void setId_set_nmr_doc(String Id_set_nmr_doc) {
		setAttrVal("Id_set_nmr_doc", Id_set_nmr_doc);
	}
	/**
	 * 数据元名称
	 * @return String
	 */
	public String getName_de() {
		return ((String) getAttrVal("Name_de"));
	}	
	/**
	 * 数据元名称
	 * @param Name_de
	 */
	public void setName_de(String Name_de) {
		setAttrVal("Name_de", Name_de);
	}
	/**
	 * 就诊状况类型
	 * @return String
	 */
	public String getName_enstatetp() {
		return ((String) getAttrVal("Name_enstatetp"));
	}	
	/**
	 * 就诊状况类型
	 * @param Name_enstatetp
	 */
	public void setName_enstatetp(String Name_enstatetp) {
		setAttrVal("Name_enstatetp", Name_enstatetp);
	}
	/**
	 * 就诊状况
	 * @return String
	 */
	public String getName_enstate() {
		return ((String) getAttrVal("Name_enstate"));
	}	
	/**
	 * 就诊状况
	 * @param Name_enstate
	 */
	public void setName_enstate(String Name_enstate) {
		setAttrVal("Name_enstate", Name_enstate);
	}
	/**
	 * 评估时间字段
	 * @return String
	 */
	public String getName_evalu_time() {
		return ((String) getAttrVal("Name_evalu_time"));
	}	
	/**
	 * 评估时间字段
	 * @param Name_evalu_time
	 */
	public void setName_evalu_time(String Name_evalu_time) {
		setAttrVal("Name_evalu_time", Name_evalu_time);
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
		return "Id_skd_nmr";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_skd_nmr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpSkdNmrDODesc.class);
	}
	
}