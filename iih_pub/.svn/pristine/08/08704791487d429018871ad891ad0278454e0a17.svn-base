package iih.nmr.pkuf.fcapp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.fcapp.d.desc.FiveColorAppDODesc;
import java.math.BigDecimal;

/**
 * 五色卡 DO数据 
 * 
 */
public class FiveColorAppDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//孕产妇五色卡属性主键
	public static final String ID_FC_APP= "Id_fc_app";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//五色风险分类ID
	public static final String ID_FCCMBDDATA= "Id_fccmbddata";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//评估分类
	public static final String EU_COLOR= "Eu_color";
	//疾病名称
	public static final String NAME= "Name";
	//患者
	public static final String ID_PAT= "Id_pat";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 孕产妇五色卡属性主键
	 * @return String
	 */
	public String getId_fc_app() {
		return ((String) getAttrVal("Id_fc_app"));
	}	
	/**
	 * 孕产妇五色卡属性主键
	 * @param Id_fc_app
	 */
	public void setId_fc_app(String Id_fc_app) {
		setAttrVal("Id_fc_app", Id_fc_app);
	}
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
	 * 五色风险分类ID
	 * @return String
	 */
	public String getId_fccmbddata() {
		return ((String) getAttrVal("Id_fccmbddata"));
	}	
	/**
	 * 五色风险分类ID
	 * @param Id_fccmbddata
	 */
	public void setId_fccmbddata(String Id_fccmbddata) {
		setAttrVal("Id_fccmbddata", Id_fccmbddata);
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
	 * 评估分类
	 * @return Integer
	 */
	public Integer getEu_color() {
		return ((Integer) getAttrVal("Eu_color"));
	}	
	/**
	 * 评估分类
	 * @param Eu_color
	 */
	public void setEu_color(Integer Eu_color) {
		setAttrVal("Eu_color", Eu_color);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 疾病名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
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
		return "Id_fc_app";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_FCAPP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(FiveColorAppDODesc.class);
	}
	
}