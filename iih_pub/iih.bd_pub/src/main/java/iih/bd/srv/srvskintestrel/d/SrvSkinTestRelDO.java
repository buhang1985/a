package iih.bd.srv.srvskintestrel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvskintestrel.d.desc.SrvSkinTestRelDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务_过敏分类和皮试项目对照关系 DO数据 
 * 
 */
public class SrvSkinTestRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_SRVSKINTESTREL= "Id_srvskintestrel";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//过敏分类
	public static final String ID_ALTP= "Id_altp";
	//过敏分类编码
	public static final String SD_ALTP= "Sd_altp";
	//药品基本分类/药品或皮试项目
	public static final String EU_SKINTESTRELTP= "Eu_skintestreltp";
	//药品基本分类
	public static final String ID_MMCA= "Id_mmca";
	//皮试服务
	public static final String ID_SRV= "Id_srv";
	//皮试药品
	public static final String ID_MM= "Id_mm";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//过敏分类名称
	public static final String NAME_ALTP= "Name_altp";
	//药品基本分类名称
	public static final String NAME_MMCA= "Name_mmca";
	//皮试服务名称
	public static final String NAME_SRV= "Name_srv";
	//皮试药品名称
	public static final String NAME_MM= "Name_mm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_srvskintestrel() {
		return ((String) getAttrVal("Id_srvskintestrel"));
	}	
	/**
	 * 主键
	 * @param Id_srvskintestrel
	 */
	public void setId_srvskintestrel(String Id_srvskintestrel) {
		setAttrVal("Id_srvskintestrel", Id_srvskintestrel);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 过敏分类
	 * @return String
	 */
	public String getId_altp() {
		return ((String) getAttrVal("Id_altp"));
	}	
	/**
	 * 过敏分类
	 * @param Id_altp
	 */
	public void setId_altp(String Id_altp) {
		setAttrVal("Id_altp", Id_altp);
	}
	/**
	 * 过敏分类编码
	 * @return String
	 */
	public String getSd_altp() {
		return ((String) getAttrVal("Sd_altp"));
	}	
	/**
	 * 过敏分类编码
	 * @param Sd_altp
	 */
	public void setSd_altp(String Sd_altp) {
		setAttrVal("Sd_altp", Sd_altp);
	}
	/**
	 * 药品基本分类/药品或皮试项目
	 * @return String
	 */
	public String getEu_skintestreltp() {
		return ((String) getAttrVal("Eu_skintestreltp"));
	}	
	/**
	 * 药品基本分类/药品或皮试项目
	 * @param Eu_skintestreltp
	 */
	public void setEu_skintestreltp(String Eu_skintestreltp) {
		setAttrVal("Eu_skintestreltp", Eu_skintestreltp);
	}
	/**
	 * 药品基本分类
	 * @return String
	 */
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	/**
	 * 药品基本分类
	 * @param Id_mmca
	 */
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	/**
	 * 皮试服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 皮试服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 皮试药品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 皮试药品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
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
	 * 过敏分类名称
	 * @return String
	 */
	public String getName_altp() {
		return ((String) getAttrVal("Name_altp"));
	}	
	/**
	 * 过敏分类名称
	 * @param Name_altp
	 */
	public void setName_altp(String Name_altp) {
		setAttrVal("Name_altp", Name_altp);
	}
	/**
	 * 药品基本分类名称
	 * @return String
	 */
	public String getName_mmca() {
		return ((String) getAttrVal("Name_mmca"));
	}	
	/**
	 * 药品基本分类名称
	 * @param Name_mmca
	 */
	public void setName_mmca(String Name_mmca) {
		setAttrVal("Name_mmca", Name_mmca);
	}
	/**
	 * 皮试服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 皮试服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 皮试药品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 皮试药品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
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
		return "Id_srvskintestrel";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_SRV_SKINTEST_REL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvSkinTestRelDODesc.class);
	}
	
}