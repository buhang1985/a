package iih.bd.pp.prisrvcomp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.prisrvcomp.d.desc.PriSrvCompDODesc;
import java.math.BigDecimal;

/**
 * 付款策略_组合定价 DO数据 
 * 
 */
public class PriSrvCompDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//组合定价主键
	public static final String ID_PRISRVCOMP= "Id_prisrvcomp";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//被定价服务
	public static final String ID_SRV= "Id_srv";
	//序号
	public static final String SORTNO= "Sortno";
	//定价服务
	public static final String ID_SRV_BL= "Id_srv_bl";
	//医疗物品
	public static final String ID_MM= "Id_mm";
	//单位
	public static final String ID_UNIT= "Id_unit";
	//数量
	public static final String QUAN= "Quan";
	//价格
	public static final String PRICE= "Price";
	//金额
	public static final String AMT= "Amt";
	//数量可调整标志
	public static final String FG_ADJUSTABLE= "Fg_adjustable";
	//价格系数
	public static final String RATIO= "Ratio";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//定价模式
	public static final String ID_PRIMD= "Id_primd";
	//医疗物品标识
	public static final String SRV_BL_FG_MM= "Srv_bl_fg_mm";
	//物品名称
	public static final String NAME_MM= "Name_mm";
	//物品规格
	public static final String SPEC_MM= "Spec_mm";
	//单位名称
	public static final String NAME_UNIT= "Name_unit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 组合定价主键
	 * @return String
	 */
	public String getId_prisrvcomp() {
		return ((String) getAttrVal("Id_prisrvcomp"));
	}	
	/**
	 * 组合定价主键
	 * @param Id_prisrvcomp
	 */
	public void setId_prisrvcomp(String Id_prisrvcomp) {
		setAttrVal("Id_prisrvcomp", Id_prisrvcomp);
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
	 * 被定价服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 被定价服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 定价服务
	 * @return String
	 */
	public String getId_srv_bl() {
		return ((String) getAttrVal("Id_srv_bl"));
	}	
	/**
	 * 定价服务
	 * @param Id_srv_bl
	 */
	public void setId_srv_bl(String Id_srv_bl) {
		setAttrVal("Id_srv_bl", Id_srv_bl);
	}
	/**
	 * 医疗物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 医疗物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
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
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 数量可调整标志
	 * @return FBoolean
	 */
	public FBoolean getFg_adjustable() {
		return ((FBoolean) getAttrVal("Fg_adjustable"));
	}	
	/**
	 * 数量可调整标志
	 * @param Fg_adjustable
	 */
	public void setFg_adjustable(FBoolean Fg_adjustable) {
		setAttrVal("Fg_adjustable", Fg_adjustable);
	}
	/**
	 * 价格系数
	 * @return FDouble
	 */
	public FDouble getRatio() {
		return ((FDouble) getAttrVal("Ratio"));
	}	
	/**
	 * 价格系数
	 * @param Ratio
	 */
	public void setRatio(FDouble Ratio) {
		setAttrVal("Ratio", Ratio);
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
	 * 定价模式
	 * @return String
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}	
	/**
	 * 定价模式
	 * @param Id_primd
	 */
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	/**
	 * 医疗物品标识
	 * @return FBoolean
	 */
	public FBoolean getSrv_bl_fg_mm() {
		return ((FBoolean) getAttrVal("Srv_bl_fg_mm"));
	}	
	/**
	 * 医疗物品标识
	 * @param Srv_bl_fg_mm
	 */
	public void setSrv_bl_fg_mm(FBoolean Srv_bl_fg_mm) {
		setAttrVal("Srv_bl_fg_mm", Srv_bl_fg_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getSpec_mm() {
		return ((String) getAttrVal("Spec_mm"));
	}	
	/**
	 * 物品规格
	 * @param Spec_mm
	 */
	public void setSpec_mm(String Spec_mm) {
		setAttrVal("Spec_mm", Spec_mm);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
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
		return "Id_prisrvcomp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_pri_srv_comp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PriSrvCompDODesc.class);
	}
	
}