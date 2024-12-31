package iih.nm.nqm.nmnqmcs.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmcs.d.desc.NmNqmCsExtDODesc;
import java.math.BigDecimal;

/**
 * 质量标准扩展属性 DO数据 
 * 
 */
public class NmNqmCsExtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//标准扩展属性主键
	public static final String ID_NQM_CS_EXT= "Id_nqm_cs_ext";
	//检查标准外键
	public static final String ID_NQM_CS= "Id_nqm_cs";
	//序号
	public static final String SORTNO= "Sortno";
	//扩展字段id
	public static final String ID_CS_EXT= "Id_cs_ext";
	//扩展字段编码
	public static final String SD_CS_EXT= "Sd_cs_ext";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//扩展字段名称
	public static final String NAME_CS_EXT= "Name_cs_ext";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 标准扩展属性主键
	 * @return String
	 */
	public String getId_nqm_cs_ext() {
		return ((String) getAttrVal("Id_nqm_cs_ext"));
	}	
	/**
	 * 标准扩展属性主键
	 * @param Id_nqm_cs_ext
	 */
	public void setId_nqm_cs_ext(String Id_nqm_cs_ext) {
		setAttrVal("Id_nqm_cs_ext", Id_nqm_cs_ext);
	}
	/**
	 * 检查标准外键
	 * @return String
	 */
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	/**
	 * 检查标准外键
	 * @param Id_nqm_cs
	 */
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
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
	 * 扩展字段id
	 * @return String
	 */
	public String getId_cs_ext() {
		return ((String) getAttrVal("Id_cs_ext"));
	}	
	/**
	 * 扩展字段id
	 * @param Id_cs_ext
	 */
	public void setId_cs_ext(String Id_cs_ext) {
		setAttrVal("Id_cs_ext", Id_cs_ext);
	}
	/**
	 * 扩展字段编码
	 * @return String
	 */
	public String getSd_cs_ext() {
		return ((String) getAttrVal("Sd_cs_ext"));
	}	
	/**
	 * 扩展字段编码
	 * @param Sd_cs_ext
	 */
	public void setSd_cs_ext(String Sd_cs_ext) {
		setAttrVal("Sd_cs_ext", Sd_cs_ext);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 扩展字段名称
	 * @return String
	 */
	public String getName_cs_ext() {
		return ((String) getAttrVal("Name_cs_ext"));
	}	
	/**
	 * 扩展字段名称
	 * @param Name_cs_ext
	 */
	public void setName_cs_ext(String Name_cs_ext) {
		setAttrVal("Name_cs_ext", Name_cs_ext);
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
		return "Id_nqm_cs_ext";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_CS_EXT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmCsExtDODesc.class);
	}
	
}