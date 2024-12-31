package iih.bd.srv.notice.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.notice.d.desc.MedNoticeDODesc;
import java.math.BigDecimal;

/**
 * 医疗注意事项 DO数据 
 * 
 */
public class MedNoticeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//注意事项主键
	public static final String ID_NOTICE= "Id_notice";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//注意事项分类
	public static final String ID_NOTICECA= "Id_noticeca";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//医疗编码体系类型
	public static final String ID_CDSYSTP= "Id_cdsystp";
	//医疗编码体系类型编码
	public static final String SD_CDSYSTP= "Sd_cdsystp";
	//注意事项类型
	public static final String ID_NOTICETP= "Id_noticetp";
	//注意事项类型编码
	public static final String SD_NOTICETP= "Sd_noticetp";
	//医疗服务分类
	public static final String ID_SRVCA= "Id_srvca";
	//关联类型
	public static final String EU_RELTP= "Eu_reltp";
	//关联服务
	public static final String ID_SRV= "Id_srv";
	//关联商品
	public static final String ID_MM= "Id_mm";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//患者注意
	public static final String FG_PATI= "Fg_pati";
	//开单注意
	public static final String FG_ORPSN= "Fg_orpsn";
	//执行注意
	public static final String FG_MPPSN= "Fg_mppsn";
	//收费注意
	public static final String FG_BLPSN= "Fg_blpsn";
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
	//客户扩展字段6
	public static final String DEF6= "Def6";
	//客户扩展字段7
	public static final String DEF7= "Def7";
	//客户扩展字段8
	public static final String DEF8= "Def8";
	//客户扩展字段9
	public static final String DEF9= "Def9";
	//客户扩展字段10
	public static final String DEF10= "Def10";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_CDSYSTP= "Name_cdsystp";
	//名称
	public static final String NAME_NOTICETP= "Name_noticetp";
	//医疗服务分类名称
	public static final String NAME_SRVCA= "Name_srvca";
	//服务分类编码
	public static final String CODE_SRVCA= "Code_srvca";
	//服务编码
	public static final String SRV_CODE= "Srv_code";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 注意事项主键
	 * @return String
	 */
	public String getId_notice() {
		return ((String) getAttrVal("Id_notice"));
	}	
	/**
	 * 注意事项主键
	 * @param Id_notice
	 */
	public void setId_notice(String Id_notice) {
		setAttrVal("Id_notice", Id_notice);
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
	 * 注意事项分类
	 * @return String
	 */
	public String getId_noticeca() {
		return ((String) getAttrVal("Id_noticeca"));
	}	
	/**
	 * 注意事项分类
	 * @param Id_noticeca
	 */
	public void setId_noticeca(String Id_noticeca) {
		setAttrVal("Id_noticeca", Id_noticeca);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 医疗编码体系类型
	 * @return String
	 */
	public String getId_cdsystp() {
		return ((String) getAttrVal("Id_cdsystp"));
	}	
	/**
	 * 医疗编码体系类型
	 * @param Id_cdsystp
	 */
	public void setId_cdsystp(String Id_cdsystp) {
		setAttrVal("Id_cdsystp", Id_cdsystp);
	}
	/**
	 * 医疗编码体系类型编码
	 * @return String
	 */
	public String getSd_cdsystp() {
		return ((String) getAttrVal("Sd_cdsystp"));
	}	
	/**
	 * 医疗编码体系类型编码
	 * @param Sd_cdsystp
	 */
	public void setSd_cdsystp(String Sd_cdsystp) {
		setAttrVal("Sd_cdsystp", Sd_cdsystp);
	}
	/**
	 * 注意事项类型
	 * @return String
	 */
	public String getId_noticetp() {
		return ((String) getAttrVal("Id_noticetp"));
	}	
	/**
	 * 注意事项类型
	 * @param Id_noticetp
	 */
	public void setId_noticetp(String Id_noticetp) {
		setAttrVal("Id_noticetp", Id_noticetp);
	}
	/**
	 * 注意事项类型编码
	 * @return String
	 */
	public String getSd_noticetp() {
		return ((String) getAttrVal("Sd_noticetp"));
	}	
	/**
	 * 注意事项类型编码
	 * @param Sd_noticetp
	 */
	public void setSd_noticetp(String Sd_noticetp) {
		setAttrVal("Sd_noticetp", Sd_noticetp);
	}
	/**
	 * 医疗服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 医疗服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 关联类型
	 * @return Integer
	 */
	public Integer getEu_reltp() {
		return ((Integer) getAttrVal("Eu_reltp"));
	}	
	/**
	 * 关联类型
	 * @param Eu_reltp
	 */
	public void setEu_reltp(Integer Eu_reltp) {
		setAttrVal("Eu_reltp", Eu_reltp);
	}
	/**
	 * 关联服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 关联服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 关联商品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 关联商品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 患者注意
	 * @return FBoolean
	 */
	public FBoolean getFg_pati() {
		return ((FBoolean) getAttrVal("Fg_pati"));
	}	
	/**
	 * 患者注意
	 * @param Fg_pati
	 */
	public void setFg_pati(FBoolean Fg_pati) {
		setAttrVal("Fg_pati", Fg_pati);
	}
	/**
	 * 开单注意
	 * @return FBoolean
	 */
	public FBoolean getFg_orpsn() {
		return ((FBoolean) getAttrVal("Fg_orpsn"));
	}	
	/**
	 * 开单注意
	 * @param Fg_orpsn
	 */
	public void setFg_orpsn(FBoolean Fg_orpsn) {
		setAttrVal("Fg_orpsn", Fg_orpsn);
	}
	/**
	 * 执行注意
	 * @return FBoolean
	 */
	public FBoolean getFg_mppsn() {
		return ((FBoolean) getAttrVal("Fg_mppsn"));
	}	
	/**
	 * 执行注意
	 * @param Fg_mppsn
	 */
	public void setFg_mppsn(FBoolean Fg_mppsn) {
		setAttrVal("Fg_mppsn", Fg_mppsn);
	}
	/**
	 * 收费注意
	 * @return FBoolean
	 */
	public FBoolean getFg_blpsn() {
		return ((FBoolean) getAttrVal("Fg_blpsn"));
	}	
	/**
	 * 收费注意
	 * @param Fg_blpsn
	 */
	public void setFg_blpsn(FBoolean Fg_blpsn) {
		setAttrVal("Fg_blpsn", Fg_blpsn);
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
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
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
	 * 名称
	 * @return String
	 */
	public String getName_cdsystp() {
		return ((String) getAttrVal("Name_cdsystp"));
	}	
	/**
	 * 名称
	 * @param Name_cdsystp
	 */
	public void setName_cdsystp(String Name_cdsystp) {
		setAttrVal("Name_cdsystp", Name_cdsystp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_noticetp() {
		return ((String) getAttrVal("Name_noticetp"));
	}	
	/**
	 * 名称
	 * @param Name_noticetp
	 */
	public void setName_noticetp(String Name_noticetp) {
		setAttrVal("Name_noticetp", Name_noticetp);
	}
	/**
	 * 医疗服务分类名称
	 * @return String
	 */
	public String getName_srvca() {
		return ((String) getAttrVal("Name_srvca"));
	}	
	/**
	 * 医疗服务分类名称
	 * @param Name_srvca
	 */
	public void setName_srvca(String Name_srvca) {
		setAttrVal("Name_srvca", Name_srvca);
	}
	/**
	 * 服务分类编码
	 * @return String
	 */
	public String getCode_srvca() {
		return ((String) getAttrVal("Code_srvca"));
	}	
	/**
	 * 服务分类编码
	 * @param Code_srvca
	 */
	public void setCode_srvca(String Code_srvca) {
		setAttrVal("Code_srvca", Code_srvca);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	/**
	 * 服务编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
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
		return "Id_notice";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_notice";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedNoticeDODesc.class);
	}
	
}