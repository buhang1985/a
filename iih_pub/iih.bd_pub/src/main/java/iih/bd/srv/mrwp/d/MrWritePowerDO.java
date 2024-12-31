package iih.bd.srv.mrwp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrwp.d.desc.MrWritePowerDODesc;
import java.math.BigDecimal;

/**
 * 病历书写权限 DO数据 
 * 
 */
public class MrWritePowerDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_MR_WP= "Id_mr_wp";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//医疗记录自定义分类
	public static final String ID_MRCACTM= "Id_mrcactm";
	//医疗记录类型
	public static final String ID_MRTP= "Id_mrtp";
	//权限模式
	public static final String ID_PM= "Id_pm";
	//权限模式编码
	public static final String SD_PM= "Sd_pm";
	//权限实体类型
	public static final String ID_PT= "Id_pt";
	//权限实体类型编码
	public static final String SD_PT= "Sd_pt";
	//序号
	public static final String SORTNO= "Sortno";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//编码
	public static final String CODE_GRP= "Code_grp";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织编码
	public static final String CODE_ORG= "Code_org";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_MRCACTM= "Name_mrcactm";
	//编码
	public static final String CODE_MRCACTM= "Code_mrcactm";
	//医疗记录类型名称
	public static final String NAME_MRTP= "Name_mrtp";
	//医疗记录类型编码
	public static final String CODE_MRTP= "Code_mrtp";
	//名称
	public static final String NAME_PM= "Name_pm";
	//编码
	public static final String CODE_PM= "Code_pm";
	//名称
	public static final String NAME_PT= "Name_pt";
	//编码
	public static final String CODE_PT= "Code_pt";
	//用户名称
	public static final String NAME_CJR= "Name_cjr";
	//用户编码
	public static final String CODE_CJR= "Code_cjr";
	//用户名称
	public static final String NAME_ZHXGR= "Name_zhxgr";
	//用户编码
	public static final String CODE_ZHXGR= "Code_zhxgr";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_mr_wp() {
		return ((String) getAttrVal("Id_mr_wp"));
	}	
	/**
	 * 主键
	 * @param Id_mr_wp
	 */
	public void setId_mr_wp(String Id_mr_wp) {
		setAttrVal("Id_mr_wp", Id_mr_wp);
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
	 * 医疗记录自定义分类
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	/**
	 * 医疗记录自定义分类
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	/**
	 * 医疗记录类型
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	/**
	 * 医疗记录类型
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 权限模式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	/**
	 * 权限模式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 权限模式编码
	 * @return String
	 */
	public String getSd_pm() {
		return ((String) getAttrVal("Sd_pm"));
	}	
	/**
	 * 权限模式编码
	 * @param Sd_pm
	 */
	public void setSd_pm(String Sd_pm) {
		setAttrVal("Sd_pm", Sd_pm);
	}
	/**
	 * 权限实体类型
	 * @return String
	 */
	public String getId_pt() {
		return ((String) getAttrVal("Id_pt"));
	}	
	/**
	 * 权限实体类型
	 * @param Id_pt
	 */
	public void setId_pt(String Id_pt) {
		setAttrVal("Id_pt", Id_pt);
	}
	/**
	 * 权限实体类型编码
	 * @return String
	 */
	public String getSd_pt() {
		return ((String) getAttrVal("Sd_pt"));
	}	
	/**
	 * 权限实体类型编码
	 * @param Sd_pt
	 */
	public void setSd_pt(String Sd_pt) {
		setAttrVal("Sd_pt", Sd_pt);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mrcactm() {
		return ((String) getAttrVal("Name_mrcactm"));
	}	
	/**
	 * 名称
	 * @param Name_mrcactm
	 */
	public void setName_mrcactm(String Name_mrcactm) {
		setAttrVal("Name_mrcactm", Name_mrcactm);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_mrcactm() {
		return ((String) getAttrVal("Code_mrcactm"));
	}	
	/**
	 * 编码
	 * @param Code_mrcactm
	 */
	public void setCode_mrcactm(String Code_mrcactm) {
		setAttrVal("Code_mrcactm", Code_mrcactm);
	}
	/**
	 * 医疗记录类型名称
	 * @return String
	 */
	public String getName_mrtp() {
		return ((String) getAttrVal("Name_mrtp"));
	}	
	/**
	 * 医疗记录类型名称
	 * @param Name_mrtp
	 */
	public void setName_mrtp(String Name_mrtp) {
		setAttrVal("Name_mrtp", Name_mrtp);
	}
	/**
	 * 医疗记录类型编码
	 * @return String
	 */
	public String getCode_mrtp() {
		return ((String) getAttrVal("Code_mrtp"));
	}	
	/**
	 * 医疗记录类型编码
	 * @param Code_mrtp
	 */
	public void setCode_mrtp(String Code_mrtp) {
		setAttrVal("Code_mrtp", Code_mrtp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}	
	/**
	 * 名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_pm() {
		return ((String) getAttrVal("Code_pm"));
	}	
	/**
	 * 编码
	 * @param Code_pm
	 */
	public void setCode_pm(String Code_pm) {
		setAttrVal("Code_pm", Code_pm);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pt() {
		return ((String) getAttrVal("Name_pt"));
	}	
	/**
	 * 名称
	 * @param Name_pt
	 */
	public void setName_pt(String Name_pt) {
		setAttrVal("Name_pt", Name_pt);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_pt() {
		return ((String) getAttrVal("Code_pt"));
	}	
	/**
	 * 编码
	 * @param Code_pt
	 */
	public void setCode_pt(String Code_pt) {
		setAttrVal("Code_pt", Code_pt);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_cjr() {
		return ((String) getAttrVal("Name_cjr"));
	}	
	/**
	 * 用户名称
	 * @param Name_cjr
	 */
	public void setName_cjr(String Name_cjr) {
		setAttrVal("Name_cjr", Name_cjr);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_cjr() {
		return ((String) getAttrVal("Code_cjr"));
	}	
	/**
	 * 用户编码
	 * @param Code_cjr
	 */
	public void setCode_cjr(String Code_cjr) {
		setAttrVal("Code_cjr", Code_cjr);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_zhxgr() {
		return ((String) getAttrVal("Name_zhxgr"));
	}	
	/**
	 * 用户名称
	 * @param Name_zhxgr
	 */
	public void setName_zhxgr(String Name_zhxgr) {
		setAttrVal("Name_zhxgr", Name_zhxgr);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_zhxgr() {
		return ((String) getAttrVal("Code_zhxgr"));
	}	
	/**
	 * 用户编码
	 * @param Code_zhxgr
	 */
	public void setCode_zhxgr(String Code_zhxgr) {
		setAttrVal("Code_zhxgr", Code_zhxgr);
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
		return "Id_mr_wp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mr_wp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrWritePowerDODesc.class);
	}
	
}