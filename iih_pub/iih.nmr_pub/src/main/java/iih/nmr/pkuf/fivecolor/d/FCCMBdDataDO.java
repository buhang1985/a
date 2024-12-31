package iih.nmr.pkuf.fivecolor.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.fivecolor.d.desc.FCCMBdDataDODesc;
import java.math.BigDecimal;

/**
 * 孕产妇五色卡基础数据信息 DO数据 
 * 
 */
public class FCCMBdDataDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//五色卡业务主键
	public static final String ID_FCCMBDDATA= "Id_fccmbddata";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//疾病编码
	public static final String CODE= "Code";
	//疾病名称
	public static final String NAME= "Name";
	//评估分类
	public static final String EU_COLOR= "Eu_color";
	//是否其他
	public static final String FG_OTHER= "Fg_other";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//是否保存
	public static final String FG_SAVE= "Fg_save";
	//序号
	public static final String SORTNO= "Sortno";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 五色卡业务主键
	 * @return String
	 */
	public String getId_fccmbddata() {
		return ((String) getAttrVal("Id_fccmbddata"));
	}	
	/**
	 * 五色卡业务主键
	 * @param Id_fccmbddata
	 */
	public void setId_fccmbddata(String Id_fccmbddata) {
		setAttrVal("Id_fccmbddata", Id_fccmbddata);
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
	 * 疾病编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 疾病编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 是否其他
	 * @return FBoolean
	 */
	public FBoolean getFg_other() {
		return ((FBoolean) getAttrVal("Fg_other"));
	}	
	/**
	 * 是否其他
	 * @param Fg_other
	 */
	public void setFg_other(FBoolean Fg_other) {
		setAttrVal("Fg_other", Fg_other);
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
	 * 是否保存
	 * @return String
	 */
	public String getFg_save() {
		return ((String) getAttrVal("Fg_save"));
	}	
	/**
	 * 是否保存
	 * @param Fg_save
	 */
	public void setFg_save(String Fg_save) {
		setAttrVal("Fg_save", Fg_save);
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
		return "Id_fccmbddata";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_FCCMBD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(FCCMBdDataDODesc.class);
	}
	
}