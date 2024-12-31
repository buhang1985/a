package iih.bd.mm.warehouseinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.warehouseinfo.d.desc.WarehouseInfoDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_与仓库关系 DO数据 
 * 
 */
public class WarehouseInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗物品与仓库主键
	public static final String ID_MMWH= "Id_mmwh";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//仓库
	public static final String ID_WH= "Id_wh";
	//医疗物品
	public static final String ID_MM= "Id_mm";
	//货位
	public static final String ID_LOC= "Id_loc";
	//库存周期单位
	public static final String ID_CYCLEU= "Id_cycleu";
	//库存周期单位编码
	public static final String SD_CYCLEU= "Sd_cycleu";
	//库存周期数量
	public static final String SD_CYCLENUM= "Sd_cyclenum";
	//最高库存_基本单位
	public static final String MAXSTNUM= "Maxstnum";
	//最低库存_基本单位
	public static final String LOWSTNUM= "Lowstnum";
	//最高库存_界面包装单位
	public static final String MAXUINUM= "Maxuinum";
	//最低库存_界面包装单位
	public static final String LOWUINUM= "Lowuinum";
	//界面包装单位
	public static final String ID_MMPKGU_UI= "Id_mmpkgu_ui";
	//响应仓库
	public static final String ID_WH_SRV= "Id_wh_srv";
	//启用状态
	public static final String FG_ACTIVE= "Fg_active";
	//停发标志
	public static final String FG_OUT= "Fg_out";
	//无可用量停发标志
	public static final String FG_ST_OUT= "Fg_st_out";
	//停发人
	public static final String PSNOUT= "Psnout";
	//停发时间
	public static final String OUTTIME= "Outtime";
	//所属部门
	public static final String ID_DEP= "Id_dep";
	//基数药
	public static final String FG_BASE= "Fg_base";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//通用名
	public static final String NAMESRV= "Namesrv";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//是否按货位
	public static final String FG_LOC= "Fg_loc";
	//仓库类型编码
	public static final String SD_WHTP= "Sd_whtp";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//生产厂家名称
	public static final String SUP_NAME= "Sup_name";
	//货位名称
	public static final String LOC_NAME= "Loc_name";
	//货位编码
	public static final String LOC_CODE= "Loc_code";
	//名称
	public static final String UDI_NAME= "Udi_name";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	//仓库名称
	public static final String SRV_NAME= "Srv_name";
	//人员编码
	public static final String PSN_CODE= "Psn_code";
	//姓名
	public static final String PSN_NAME= "Psn_name";
	//部门名称
	public static final String DEP_NAME= "Dep_name";
	//部门编码
	public static final String DEP_CODE= "Dep_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗物品与仓库主键
	 * @return String
	 */
	public String getId_mmwh() {
		return ((String) getAttrVal("Id_mmwh"));
	}	
	/**
	 * 医疗物品与仓库主键
	 * @param Id_mmwh
	 */
	public void setId_mmwh(String Id_mmwh) {
		setAttrVal("Id_mmwh", Id_mmwh);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
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
	 * 货位
	 * @return String
	 */
	public String getId_loc() {
		return ((String) getAttrVal("Id_loc"));
	}	
	/**
	 * 货位
	 * @param Id_loc
	 */
	public void setId_loc(String Id_loc) {
		setAttrVal("Id_loc", Id_loc);
	}
	/**
	 * 库存周期单位
	 * @return String
	 */
	public String getId_cycleu() {
		return ((String) getAttrVal("Id_cycleu"));
	}	
	/**
	 * 库存周期单位
	 * @param Id_cycleu
	 */
	public void setId_cycleu(String Id_cycleu) {
		setAttrVal("Id_cycleu", Id_cycleu);
	}
	/**
	 * 库存周期单位编码
	 * @return String
	 */
	public String getSd_cycleu() {
		return ((String) getAttrVal("Sd_cycleu"));
	}	
	/**
	 * 库存周期单位编码
	 * @param Sd_cycleu
	 */
	public void setSd_cycleu(String Sd_cycleu) {
		setAttrVal("Sd_cycleu", Sd_cycleu);
	}
	/**
	 * 库存周期数量
	 * @return Integer
	 */
	public Integer getSd_cyclenum() {
		return ((Integer) getAttrVal("Sd_cyclenum"));
	}	
	/**
	 * 库存周期数量
	 * @param Sd_cyclenum
	 */
	public void setSd_cyclenum(Integer Sd_cyclenum) {
		setAttrVal("Sd_cyclenum", Sd_cyclenum);
	}
	/**
	 * 最高库存_基本单位
	 * @return FDouble
	 */
	public FDouble getMaxstnum() {
		return ((FDouble) getAttrVal("Maxstnum"));
	}	
	/**
	 * 最高库存_基本单位
	 * @param Maxstnum
	 */
	public void setMaxstnum(FDouble Maxstnum) {
		setAttrVal("Maxstnum", Maxstnum);
	}
	/**
	 * 最低库存_基本单位
	 * @return FDouble
	 */
	public FDouble getLowstnum() {
		return ((FDouble) getAttrVal("Lowstnum"));
	}	
	/**
	 * 最低库存_基本单位
	 * @param Lowstnum
	 */
	public void setLowstnum(FDouble Lowstnum) {
		setAttrVal("Lowstnum", Lowstnum);
	}
	/**
	 * 最高库存_界面包装单位
	 * @return FDouble
	 */
	public FDouble getMaxuinum() {
		return ((FDouble) getAttrVal("Maxuinum"));
	}	
	/**
	 * 最高库存_界面包装单位
	 * @param Maxuinum
	 */
	public void setMaxuinum(FDouble Maxuinum) {
		setAttrVal("Maxuinum", Maxuinum);
	}
	/**
	 * 最低库存_界面包装单位
	 * @return FDouble
	 */
	public FDouble getLowuinum() {
		return ((FDouble) getAttrVal("Lowuinum"));
	}	
	/**
	 * 最低库存_界面包装单位
	 * @param Lowuinum
	 */
	public void setLowuinum(FDouble Lowuinum) {
		setAttrVal("Lowuinum", Lowuinum);
	}
	/**
	 * 界面包装单位
	 * @return String
	 */
	public String getId_mmpkgu_ui() {
		return ((String) getAttrVal("Id_mmpkgu_ui"));
	}	
	/**
	 * 界面包装单位
	 * @param Id_mmpkgu_ui
	 */
	public void setId_mmpkgu_ui(String Id_mmpkgu_ui) {
		setAttrVal("Id_mmpkgu_ui", Id_mmpkgu_ui);
	}
	/**
	 * 响应仓库
	 * @return String
	 */
	public String getId_wh_srv() {
		return ((String) getAttrVal("Id_wh_srv"));
	}	
	/**
	 * 响应仓库
	 * @param Id_wh_srv
	 */
	public void setId_wh_srv(String Id_wh_srv) {
		setAttrVal("Id_wh_srv", Id_wh_srv);
	}
	/**
	 * 启用状态
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用状态
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 停发标志
	 * @return FBoolean
	 */
	public FBoolean getFg_out() {
		return ((FBoolean) getAttrVal("Fg_out"));
	}	
	/**
	 * 停发标志
	 * @param Fg_out
	 */
	public void setFg_out(FBoolean Fg_out) {
		setAttrVal("Fg_out", Fg_out);
	}
	/**
	 * 无可用量停发标志
	 * @return FBoolean
	 */
	public FBoolean getFg_st_out() {
		return ((FBoolean) getAttrVal("Fg_st_out"));
	}	
	/**
	 * 无可用量停发标志
	 * @param Fg_st_out
	 */
	public void setFg_st_out(FBoolean Fg_st_out) {
		setAttrVal("Fg_st_out", Fg_st_out);
	}
	/**
	 * 停发人
	 * @return String
	 */
	public String getPsnout() {
		return ((String) getAttrVal("Psnout"));
	}	
	/**
	 * 停发人
	 * @param Psnout
	 */
	public void setPsnout(String Psnout) {
		setAttrVal("Psnout", Psnout);
	}
	/**
	 * 停发时间
	 * @return FDateTime
	 */
	public FDateTime getOuttime() {
		return ((FDateTime) getAttrVal("Outtime"));
	}	
	/**
	 * 停发时间
	 * @param Outtime
	 */
	public void setOuttime(FDateTime Outtime) {
		setAttrVal("Outtime", Outtime);
	}
	/**
	 * 所属部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 所属部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 基数药
	 * @return FBoolean
	 */
	public FBoolean getFg_base() {
		return ((FBoolean) getAttrVal("Fg_base"));
	}	
	/**
	 * 基数药
	 * @param Fg_base
	 */
	public void setFg_base(FBoolean Fg_base) {
		setAttrVal("Fg_base", Fg_base);
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
	 * 通用名
	 * @return String
	 */
	public String getNamesrv() {
		return ((String) getAttrVal("Namesrv"));
	}	
	/**
	 * 通用名
	 * @param Namesrv
	 */
	public void setNamesrv(String Namesrv) {
		setAttrVal("Namesrv", Namesrv);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 是否按货位
	 * @return FBoolean
	 */
	public FBoolean getFg_loc() {
		return ((FBoolean) getAttrVal("Fg_loc"));
	}	
	/**
	 * 是否按货位
	 * @param Fg_loc
	 */
	public void setFg_loc(FBoolean Fg_loc) {
		setAttrVal("Fg_loc", Fg_loc);
	}
	/**
	 * 仓库类型编码
	 * @return String
	 */
	public String getSd_whtp() {
		return ((String) getAttrVal("Sd_whtp"));
	}	
	/**
	 * 仓库类型编码
	 * @param Sd_whtp
	 */
	public void setSd_whtp(String Sd_whtp) {
		setAttrVal("Sd_whtp", Sd_whtp);
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
	 * 物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
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
	/**
	 * 生产厂家名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 生产厂家名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 货位名称
	 * @return String
	 */
	public String getLoc_name() {
		return ((String) getAttrVal("Loc_name"));
	}	
	/**
	 * 货位名称
	 * @param Loc_name
	 */
	public void setLoc_name(String Loc_name) {
		setAttrVal("Loc_name", Loc_name);
	}
	/**
	 * 货位编码
	 * @return String
	 */
	public String getLoc_code() {
		return ((String) getAttrVal("Loc_code"));
	}	
	/**
	 * 货位编码
	 * @param Loc_code
	 */
	public void setLoc_code(String Loc_code) {
		setAttrVal("Loc_code", Loc_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getUdi_name() {
		return ((String) getAttrVal("Udi_name"));
	}	
	/**
	 * 名称
	 * @param Udi_name
	 */
	public void setUdi_name(String Udi_name) {
		setAttrVal("Udi_name", Udi_name);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getMmpkguname() {
		return ((String) getAttrVal("Mmpkguname"));
	}	
	/**
	 * 包装单位名称
	 * @param Mmpkguname
	 */
	public void setMmpkguname(String Mmpkguname) {
		setAttrVal("Mmpkguname", Mmpkguname);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 仓库名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getPsn_code() {
		return ((String) getAttrVal("Psn_code"));
	}	
	/**
	 * 人员编码
	 * @param Psn_code
	 */
	public void setPsn_code(String Psn_code) {
		setAttrVal("Psn_code", Psn_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getPsn_name() {
		return ((String) getAttrVal("Psn_name"));
	}	
	/**
	 * 姓名
	 * @param Psn_name
	 */
	public void setPsn_name(String Psn_name) {
		setAttrVal("Psn_name", Psn_name);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 部门名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 部门编码
	 * @return String
	 */
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	/**
	 * 部门编码
	 * @param Dep_code
	 */
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
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
		return "Id_mmwh";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MM_WH";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(WarehouseInfoDODesc.class);
	}
	
}