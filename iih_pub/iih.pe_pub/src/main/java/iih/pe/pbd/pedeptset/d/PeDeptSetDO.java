package iih.pe.pbd.pedeptset.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.pedeptset.d.desc.PeDeptSetDODesc;
import java.math.BigDecimal;

/**
 * 体检科室定义 DO数据 
 * 
 */
public class PeDeptSetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检科室设置主键标识
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//体检科室设置父ID
	public static final String ID_PEDEPTSET_PAR= "Id_pedeptset_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检科室编码
	public static final String CODE= "Code";
	//体检科室名称
	public static final String NAME= "Name";
	//科室英文名称
	public static final String ENAME= "Ename";
	//五笔
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//拼音
	public static final String PYCODE= "Pycode";
	//科室默认状态
	public static final String PESRVITMSTATUS= "Pesrvitmstatus";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//是否需要补录
	public static final String FG_REINPUT= "Fg_reinput";
	//是否流程检测
	public static final String FG_WFCHK= "Fg_wfchk";
	//科室体检功能路径
	public static final String DEPTFUNCPATH= "Deptfuncpath";
	//立即出报告标识
	public static final String FG_RPTRIGHTNOW= "Fg_rptrightnow";
	//导引单科室显示标识
	public static final String FG_ONGUIDE= "Fg_onguide";
	//科室导引单显示顺序
	public static final String SORTNO_GUIDE= "Sortno_guide";
	//显示顺序
	public static final String SORTNO= "Sortno";
	//导引单打印名称
	public static final String NAME_ONGUIDE= "Name_onguide";
	//科室体检注意事项
	public static final String HINT= "Hint";
	//检查地点（男）
	public static final String LOC_MAN= "Loc_man";
	//检查地点（女）
	public static final String LOC_WOMAN= "Loc_woman";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//界面类型
	public static final String DEPINFTP= "Depinftp";
	//平均检查时长
	public static final String CHKDURATION= "Chkduration";
	//检查时长类型
	public static final String CHKDURATIONTP= "Chkdurationtp";
	//工作量计算方式
	public static final String WORKLOADTP= "Workloadtp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//上级科室编码
	public static final String CODE_DEP= "Code_dep";
	//上级科室名称
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检科室设置主键标识
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	/**
	 * 体检科室设置主键标识
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 体检科室设置父ID
	 * @return String
	 */
	public String getId_pedeptset_par() {
		return ((String) getAttrVal("Id_pedeptset_par"));
	}	
	/**
	 * 体检科室设置父ID
	 * @param Id_pedeptset_par
	 */
	public void setId_pedeptset_par(String Id_pedeptset_par) {
		setAttrVal("Id_pedeptset_par", Id_pedeptset_par);
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
	 * 体检科室编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 体检科室编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 体检科室名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 体检科室名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 科室英文名称
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	/**
	 * 科室英文名称
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
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
	 * 科室默认状态
	 * @return Integer
	 */
	public Integer getPesrvitmstatus() {
		return ((Integer) getAttrVal("Pesrvitmstatus"));
	}	
	/**
	 * 科室默认状态
	 * @param Pesrvitmstatus
	 */
	public void setPesrvitmstatus(Integer Pesrvitmstatus) {
		setAttrVal("Pesrvitmstatus", Pesrvitmstatus);
	}
	/**
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 是否需要补录
	 * @return FBoolean
	 */
	public FBoolean getFg_reinput() {
		return ((FBoolean) getAttrVal("Fg_reinput"));
	}	
	/**
	 * 是否需要补录
	 * @param Fg_reinput
	 */
	public void setFg_reinput(FBoolean Fg_reinput) {
		setAttrVal("Fg_reinput", Fg_reinput);
	}
	/**
	 * 是否流程检测
	 * @return FBoolean
	 */
	public FBoolean getFg_wfchk() {
		return ((FBoolean) getAttrVal("Fg_wfchk"));
	}	
	/**
	 * 是否流程检测
	 * @param Fg_wfchk
	 */
	public void setFg_wfchk(FBoolean Fg_wfchk) {
		setAttrVal("Fg_wfchk", Fg_wfchk);
	}
	/**
	 * 科室体检功能路径
	 * @return String
	 */
	public String getDeptfuncpath() {
		return ((String) getAttrVal("Deptfuncpath"));
	}	
	/**
	 * 科室体检功能路径
	 * @param Deptfuncpath
	 */
	public void setDeptfuncpath(String Deptfuncpath) {
		setAttrVal("Deptfuncpath", Deptfuncpath);
	}
	/**
	 * 立即出报告标识
	 * @return FBoolean
	 */
	public FBoolean getFg_rptrightnow() {
		return ((FBoolean) getAttrVal("Fg_rptrightnow"));
	}	
	/**
	 * 立即出报告标识
	 * @param Fg_rptrightnow
	 */
	public void setFg_rptrightnow(FBoolean Fg_rptrightnow) {
		setAttrVal("Fg_rptrightnow", Fg_rptrightnow);
	}
	/**
	 * 导引单科室显示标识
	 * @return FBoolean
	 */
	public FBoolean getFg_onguide() {
		return ((FBoolean) getAttrVal("Fg_onguide"));
	}	
	/**
	 * 导引单科室显示标识
	 * @param Fg_onguide
	 */
	public void setFg_onguide(FBoolean Fg_onguide) {
		setAttrVal("Fg_onguide", Fg_onguide);
	}
	/**
	 * 科室导引单显示顺序
	 * @return Integer
	 */
	public Integer getSortno_guide() {
		return ((Integer) getAttrVal("Sortno_guide"));
	}	
	/**
	 * 科室导引单显示顺序
	 * @param Sortno_guide
	 */
	public void setSortno_guide(Integer Sortno_guide) {
		setAttrVal("Sortno_guide", Sortno_guide);
	}
	/**
	 * 显示顺序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 显示顺序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 导引单打印名称
	 * @return String
	 */
	public String getName_onguide() {
		return ((String) getAttrVal("Name_onguide"));
	}	
	/**
	 * 导引单打印名称
	 * @param Name_onguide
	 */
	public void setName_onguide(String Name_onguide) {
		setAttrVal("Name_onguide", Name_onguide);
	}
	/**
	 * 科室体检注意事项
	 * @return String
	 */
	public String getHint() {
		return ((String) getAttrVal("Hint"));
	}	
	/**
	 * 科室体检注意事项
	 * @param Hint
	 */
	public void setHint(String Hint) {
		setAttrVal("Hint", Hint);
	}
	/**
	 * 检查地点（男）
	 * @return String
	 */
	public String getLoc_man() {
		return ((String) getAttrVal("Loc_man"));
	}	
	/**
	 * 检查地点（男）
	 * @param Loc_man
	 */
	public void setLoc_man(String Loc_man) {
		setAttrVal("Loc_man", Loc_man);
	}
	/**
	 * 检查地点（女）
	 * @return String
	 */
	public String getLoc_woman() {
		return ((String) getAttrVal("Loc_woman"));
	}	
	/**
	 * 检查地点（女）
	 * @param Loc_woman
	 */
	public void setLoc_woman(String Loc_woman) {
		setAttrVal("Loc_woman", Loc_woman);
	}
	/**
	 * 启用标识
	 * @return Integer
	 */
	public Integer getFg_active() {
		return ((Integer) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(Integer Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 界面类型
	 * @return Integer
	 */
	public Integer getDepinftp() {
		return ((Integer) getAttrVal("Depinftp"));
	}	
	/**
	 * 界面类型
	 * @param Depinftp
	 */
	public void setDepinftp(Integer Depinftp) {
		setAttrVal("Depinftp", Depinftp);
	}
	/**
	 * 平均检查时长
	 * @return Integer
	 */
	public Integer getChkduration() {
		return ((Integer) getAttrVal("Chkduration"));
	}	
	/**
	 * 平均检查时长
	 * @param Chkduration
	 */
	public void setChkduration(Integer Chkduration) {
		setAttrVal("Chkduration", Chkduration);
	}
	/**
	 * 检查时长类型
	 * @return Integer
	 */
	public Integer getChkdurationtp() {
		return ((Integer) getAttrVal("Chkdurationtp"));
	}	
	/**
	 * 检查时长类型
	 * @param Chkdurationtp
	 */
	public void setChkdurationtp(Integer Chkdurationtp) {
		setAttrVal("Chkdurationtp", Chkdurationtp);
	}
	/**
	 * 工作量计算方式
	 * @return Integer
	 */
	public Integer getWorkloadtp() {
		return ((Integer) getAttrVal("Workloadtp"));
	}	
	/**
	 * 工作量计算方式
	 * @param Workloadtp
	 */
	public void setWorkloadtp(Integer Workloadtp) {
		setAttrVal("Workloadtp", Workloadtp);
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
	 * 上级科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 上级科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 上级科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 上级科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_pedeptset";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_deptset";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDeptSetDODesc.class);
	}
	
}