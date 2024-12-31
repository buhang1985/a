package iih.mp.ot.otoradd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.ot.otoradd.d.desc.MpOtOrAddDODesc;
import java.math.BigDecimal;

/**
 * 医技补录项目表 DO数据 
 * 
 */
public class MpOtOrAddDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//补录项目id
	public static final String ID_OTORADD= "Id_otoradd";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//补录源医嘱id
	public static final String ID_OR= "Id_or";
	//补录医嘱
	public static final String ID_OR_ADD= "Id_or_add";
	//补录就诊
	public static final String ID_ENT= "Id_ent";
	//唯一码
	public static final String ONLYCODE= "Onlycode";
	//医疗服务
	public static final String ID_SRV= "Id_srv";
	//医学单位
	public static final String ID_MEDU= "Id_medu";
	//物品
	public static final String ID_MM= "Id_mm";
	//规格
	public static final String SPEC= "Spec";
	//包装单位
	public static final String ID_PKGU= "Id_pkgu";
	//单价
	public static final String PRICE= "Price";
	//单价(折扣价)
	public static final String PRICE_RATIO= "Price_ratio";
	//折扣率
	public static final String RATE= "Rate";
	//数量
	public static final String QUAN= "Quan";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//开单科室
	public static final String ID_DEP_OR= "Id_dep_or";
	//开单人
	public static final String ID_EMP_OR= "Id_emp_or";
	//补录时间
	public static final String DT_ADD= "Dt_add";
	//记账状态
	public static final String ID_SU_BL= "Id_su_bl";
	//记账状态编码
	public static final String SD_SU_BL= "Sd_su_bl";
	//药房科室
	public static final String ID_DEP_WH= "Id_dep_wh";
	//物品包装单位主键
	public static final String ID_MMPKGU= "Id_mmpkgu";
	//补费科室
	public static final String ID_DEP_CG= "Id_dep_cg";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 补录项目id
	 * @return String
	 */
	public String getId_otoradd() {
		return ((String) getAttrVal("Id_otoradd"));
	}	
	/**
	 * 补录项目id
	 * @param Id_otoradd
	 */
	public void setId_otoradd(String Id_otoradd) {
		setAttrVal("Id_otoradd", Id_otoradd);
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
	 * 补录源医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 补录源医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 补录医嘱
	 * @return String
	 */
	public String getId_or_add() {
		return ((String) getAttrVal("Id_or_add"));
	}	
	/**
	 * 补录医嘱
	 * @param Id_or_add
	 */
	public void setId_or_add(String Id_or_add) {
		setAttrVal("Id_or_add", Id_or_add);
	}
	/**
	 * 补录就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 补录就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}	
	/**
	 * 医学单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
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
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 包装单位
	 * @return String
	 */
	public String getId_pkgu() {
		return ((String) getAttrVal("Id_pkgu"));
	}	
	/**
	 * 包装单位
	 * @param Id_pkgu
	 */
	public void setId_pkgu(String Id_pkgu) {
		setAttrVal("Id_pkgu", Id_pkgu);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 单价(折扣价)
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}	
	/**
	 * 单价(折扣价)
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
	/**
	 * 折扣率
	 * @return FDouble
	 */
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Rate"));
	}	
	/**
	 * 折扣率
	 * @param Rate
	 */
	public void setRate(FDouble Rate) {
		setAttrVal("Rate", Rate);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}	
	/**
	 * 开单科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开单人
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}	
	/**
	 * 开单人
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 补录时间
	 * @return FDateTime
	 */
	public FDateTime getDt_add() {
		return ((FDateTime) getAttrVal("Dt_add"));
	}	
	/**
	 * 补录时间
	 * @param Dt_add
	 */
	public void setDt_add(FDateTime Dt_add) {
		setAttrVal("Dt_add", Dt_add);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}	
	/**
	 * 记账状态
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	/**
	 * 记账状态编码
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}	
	/**
	 * 记账状态编码
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 药房科室
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}	
	/**
	 * 药房科室
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 物品包装单位主键
	 * @return String
	 */
	public String getId_mmpkgu() {
		return ((String) getAttrVal("Id_mmpkgu"));
	}	
	/**
	 * 物品包装单位主键
	 * @param Id_mmpkgu
	 */
	public void setId_mmpkgu(String Id_mmpkgu) {
		setAttrVal("Id_mmpkgu", Id_mmpkgu);
	}
	/**
	 * 补费科室
	 * @return String
	 */
	public String getId_dep_cg() {
		return ((String) getAttrVal("Id_dep_cg"));
	}	
	/**
	 * 补费科室
	 * @param Id_dep_cg
	 */
	public void setId_dep_cg(String Id_dep_cg) {
		setAttrVal("Id_dep_cg", Id_dep_cg);
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
		return "Id_otoradd";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_ot_oradd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpOtOrAddDODesc.class);
	}
	
}