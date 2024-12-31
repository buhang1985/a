package iih.nm.nqm.nmnqmkpi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmkpi.d.desc.NmNqmKpiDODesc;
import java.math.BigDecimal;

/**
 * 标准指标 DO数据 
 * 
 */
public class NmNqmKpiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//标准指标主键
	public static final String ID_NQM_KPI= "Id_nqm_kpi";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//标准外键
	public static final String ID_NQM_CS= "Id_nqm_cs";
	//指标编码
	public static final String CODE= "Code";
	//指标名称
	public static final String NAME= "Name";
	//指标分值
	public static final String VALUE= "Value";
	//指标权重
	public static final String WI= "Wi";
	//扣分类型id
	public static final String ID_POINTSTP= "Id_pointstp";
	//扣分类型
	public static final String SD_POINTSTP= "Sd_pointstp";
	//扣分方式id
	public static final String ID_POINTSWAY= "Id_pointsway";
	//扣分方式
	public static final String SD_POINTSWAY= "Sd_pointsway";
	//上级指标
	public static final String ID_PAR= "Id_par";
	//检查对象id
	public static final String ID_CHK_OBJ= "Id_chk_obj";
	//检查对象
	public static final String SD_CHK_OBJ= "Sd_chk_obj";
	//是否为必要指标
	public static final String FG_MUSTKPI= "Fg_mustkpi";
	//指标缺陷等级id
	public static final String ID_BUGBAR= "Id_bugbar";
	//指标缺陷等级
	public static final String SD_BUGBAR= "Sd_bugbar";
	//检查方法id
	public static final String ID_CHK_WAY= "Id_chk_way";
	//检查方法
	public static final String SD_CHK_WAY= "Sd_chk_way";
	//评分方法id
	public static final String ID_EVALWAY= "Id_evalway";
	//评分方法
	public static final String SD_EVALWAY= "Sd_evalway";
	//评分规则
	public static final String SCOR_RULE= "Scor_rule";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//拼音码
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String NMECODE= "Nmecode";
	//备注
	public static final String DES= "Des";
	//问题系数
	public static final String ISSUEFACTOR= "Issuefactor";
	//扩展字段1
	public static final String CTR1= "Ctr1";
	//扩展字段2
	public static final String CTR2= "Ctr2";
	//扩展字段3
	public static final String CRT3= "Crt3";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//扣分类型
	public static final String NAME_POINTSTP= "Name_pointstp";
	//扣分方式
	public static final String NAME_POINTSWAY= "Name_pointsway";
	//父级指标
	public static final String NAME_PAR= "Name_par";
	//检查对象
	public static final String NAME_CHK_OBJ= "Name_chk_obj";
	//指标缺陷等级
	public static final String NAME_BUGBAR= "Name_bugbar";
	//检查方法
	public static final String NAME_CHK_WAY= "Name_chk_way";
	//评分方法
	public static final String NAME_EVALWAY= "Name_evalway";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 标准指标主键
	 * @return String
	 */
	public String getId_nqm_kpi() {
		return ((String) getAttrVal("Id_nqm_kpi"));
	}	
	/**
	 * 标准指标主键
	 * @param Id_nqm_kpi
	 */
	public void setId_nqm_kpi(String Id_nqm_kpi) {
		setAttrVal("Id_nqm_kpi", Id_nqm_kpi);
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
	 * 标准外键
	 * @return String
	 */
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	/**
	 * 标准外键
	 * @param Id_nqm_cs
	 */
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	/**
	 * 指标编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 指标编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 指标名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 指标名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 指标分值
	 * @return FDouble
	 */
	public FDouble getValue() {
		return ((FDouble) getAttrVal("Value"));
	}	
	/**
	 * 指标分值
	 * @param Value
	 */
	public void setValue(FDouble Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 指标权重
	 * @return String
	 */
	public String getWi() {
		return ((String) getAttrVal("Wi"));
	}	
	/**
	 * 指标权重
	 * @param Wi
	 */
	public void setWi(String Wi) {
		setAttrVal("Wi", Wi);
	}
	/**
	 * 扣分类型id
	 * @return String
	 */
	public String getId_pointstp() {
		return ((String) getAttrVal("Id_pointstp"));
	}	
	/**
	 * 扣分类型id
	 * @param Id_pointstp
	 */
	public void setId_pointstp(String Id_pointstp) {
		setAttrVal("Id_pointstp", Id_pointstp);
	}
	/**
	 * 扣分类型
	 * @return String
	 */
	public String getSd_pointstp() {
		return ((String) getAttrVal("Sd_pointstp"));
	}	
	/**
	 * 扣分类型
	 * @param Sd_pointstp
	 */
	public void setSd_pointstp(String Sd_pointstp) {
		setAttrVal("Sd_pointstp", Sd_pointstp);
	}
	/**
	 * 扣分方式id
	 * @return String
	 */
	public String getId_pointsway() {
		return ((String) getAttrVal("Id_pointsway"));
	}	
	/**
	 * 扣分方式id
	 * @param Id_pointsway
	 */
	public void setId_pointsway(String Id_pointsway) {
		setAttrVal("Id_pointsway", Id_pointsway);
	}
	/**
	 * 扣分方式
	 * @return String
	 */
	public String getSd_pointsway() {
		return ((String) getAttrVal("Sd_pointsway"));
	}	
	/**
	 * 扣分方式
	 * @param Sd_pointsway
	 */
	public void setSd_pointsway(String Sd_pointsway) {
		setAttrVal("Sd_pointsway", Sd_pointsway);
	}
	/**
	 * 上级指标
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 上级指标
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 检查对象id
	 * @return String
	 */
	public String getId_chk_obj() {
		return ((String) getAttrVal("Id_chk_obj"));
	}	
	/**
	 * 检查对象id
	 * @param Id_chk_obj
	 */
	public void setId_chk_obj(String Id_chk_obj) {
		setAttrVal("Id_chk_obj", Id_chk_obj);
	}
	/**
	 * 检查对象
	 * @return String
	 */
	public String getSd_chk_obj() {
		return ((String) getAttrVal("Sd_chk_obj"));
	}	
	/**
	 * 检查对象
	 * @param Sd_chk_obj
	 */
	public void setSd_chk_obj(String Sd_chk_obj) {
		setAttrVal("Sd_chk_obj", Sd_chk_obj);
	}
	/**
	 * 是否为必要指标
	 * @return FBoolean
	 */
	public FBoolean getFg_mustkpi() {
		return ((FBoolean) getAttrVal("Fg_mustkpi"));
	}	
	/**
	 * 是否为必要指标
	 * @param Fg_mustkpi
	 */
	public void setFg_mustkpi(FBoolean Fg_mustkpi) {
		setAttrVal("Fg_mustkpi", Fg_mustkpi);
	}
	/**
	 * 指标缺陷等级id
	 * @return String
	 */
	public String getId_bugbar() {
		return ((String) getAttrVal("Id_bugbar"));
	}	
	/**
	 * 指标缺陷等级id
	 * @param Id_bugbar
	 */
	public void setId_bugbar(String Id_bugbar) {
		setAttrVal("Id_bugbar", Id_bugbar);
	}
	/**
	 * 指标缺陷等级
	 * @return String
	 */
	public String getSd_bugbar() {
		return ((String) getAttrVal("Sd_bugbar"));
	}	
	/**
	 * 指标缺陷等级
	 * @param Sd_bugbar
	 */
	public void setSd_bugbar(String Sd_bugbar) {
		setAttrVal("Sd_bugbar", Sd_bugbar);
	}
	/**
	 * 检查方法id
	 * @return String
	 */
	public String getId_chk_way() {
		return ((String) getAttrVal("Id_chk_way"));
	}	
	/**
	 * 检查方法id
	 * @param Id_chk_way
	 */
	public void setId_chk_way(String Id_chk_way) {
		setAttrVal("Id_chk_way", Id_chk_way);
	}
	/**
	 * 检查方法
	 * @return String
	 */
	public String getSd_chk_way() {
		return ((String) getAttrVal("Sd_chk_way"));
	}	
	/**
	 * 检查方法
	 * @param Sd_chk_way
	 */
	public void setSd_chk_way(String Sd_chk_way) {
		setAttrVal("Sd_chk_way", Sd_chk_way);
	}
	/**
	 * 评分方法id
	 * @return String
	 */
	public String getId_evalway() {
		return ((String) getAttrVal("Id_evalway"));
	}	
	/**
	 * 评分方法id
	 * @param Id_evalway
	 */
	public void setId_evalway(String Id_evalway) {
		setAttrVal("Id_evalway", Id_evalway);
	}
	/**
	 * 评分方法
	 * @return String
	 */
	public String getSd_evalway() {
		return ((String) getAttrVal("Sd_evalway"));
	}	
	/**
	 * 评分方法
	 * @param Sd_evalway
	 */
	public void setSd_evalway(String Sd_evalway) {
		setAttrVal("Sd_evalway", Sd_evalway);
	}
	/**
	 * 评分规则
	 * @return String
	 */
	public String getScor_rule() {
		return ((String) getAttrVal("Scor_rule"));
	}	
	/**
	 * 评分规则
	 * @param Scor_rule
	 */
	public void setScor_rule(String Scor_rule) {
		setAttrVal("Scor_rule", Scor_rule);
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
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getNmecode() {
		return ((String) getAttrVal("Nmecode"));
	}	
	/**
	 * 助记码
	 * @param Nmecode
	 */
	public void setNmecode(String Nmecode) {
		setAttrVal("Nmecode", Nmecode);
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
	 * 问题系数
	 * @return FDouble
	 */
	public FDouble getIssuefactor() {
		return ((FDouble) getAttrVal("Issuefactor"));
	}	
	/**
	 * 问题系数
	 * @param Issuefactor
	 */
	public void setIssuefactor(FDouble Issuefactor) {
		setAttrVal("Issuefactor", Issuefactor);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtr1() {
		return ((String) getAttrVal("Ctr1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctr1
	 */
	public void setCtr1(String Ctr1) {
		setAttrVal("Ctr1", Ctr1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getCtr2() {
		return ((String) getAttrVal("Ctr2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ctr2
	 */
	public void setCtr2(String Ctr2) {
		setAttrVal("Ctr2", Ctr2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getCrt3() {
		return ((String) getAttrVal("Crt3"));
	}	
	/**
	 * 扩展字段3
	 * @param Crt3
	 */
	public void setCrt3(String Crt3) {
		setAttrVal("Crt3", Crt3);
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
	 * 扣分类型
	 * @return String
	 */
	public String getName_pointstp() {
		return ((String) getAttrVal("Name_pointstp"));
	}	
	/**
	 * 扣分类型
	 * @param Name_pointstp
	 */
	public void setName_pointstp(String Name_pointstp) {
		setAttrVal("Name_pointstp", Name_pointstp);
	}
	/**
	 * 扣分方式
	 * @return String
	 */
	public String getName_pointsway() {
		return ((String) getAttrVal("Name_pointsway"));
	}	
	/**
	 * 扣分方式
	 * @param Name_pointsway
	 */
	public void setName_pointsway(String Name_pointsway) {
		setAttrVal("Name_pointsway", Name_pointsway);
	}
	/**
	 * 父级指标
	 * @return String
	 */
	public String getName_par() {
		return ((String) getAttrVal("Name_par"));
	}	
	/**
	 * 父级指标
	 * @param Name_par
	 */
	public void setName_par(String Name_par) {
		setAttrVal("Name_par", Name_par);
	}
	/**
	 * 检查对象
	 * @return String
	 */
	public String getName_chk_obj() {
		return ((String) getAttrVal("Name_chk_obj"));
	}	
	/**
	 * 检查对象
	 * @param Name_chk_obj
	 */
	public void setName_chk_obj(String Name_chk_obj) {
		setAttrVal("Name_chk_obj", Name_chk_obj);
	}
	/**
	 * 指标缺陷等级
	 * @return String
	 */
	public String getName_bugbar() {
		return ((String) getAttrVal("Name_bugbar"));
	}	
	/**
	 * 指标缺陷等级
	 * @param Name_bugbar
	 */
	public void setName_bugbar(String Name_bugbar) {
		setAttrVal("Name_bugbar", Name_bugbar);
	}
	/**
	 * 检查方法
	 * @return String
	 */
	public String getName_chk_way() {
		return ((String) getAttrVal("Name_chk_way"));
	}	
	/**
	 * 检查方法
	 * @param Name_chk_way
	 */
	public void setName_chk_way(String Name_chk_way) {
		setAttrVal("Name_chk_way", Name_chk_way);
	}
	/**
	 * 评分方法
	 * @return String
	 */
	public String getName_evalway() {
		return ((String) getAttrVal("Name_evalway"));
	}	
	/**
	 * 评分方法
	 * @param Name_evalway
	 */
	public void setName_evalway(String Name_evalway) {
		setAttrVal("Name_evalway", Name_evalway);
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
		return "Id_nqm_kpi";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_KPI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmKpiDODesc.class);
	}
	
}