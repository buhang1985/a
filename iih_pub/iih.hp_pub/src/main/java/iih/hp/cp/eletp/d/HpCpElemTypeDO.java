package iih.hp.cp.eletp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletp.d.desc.HpCpElemTypeDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素类型 DO数据 
 * 
 */
public class HpCpElemTypeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//元素类型ID
	public static final String ID_ELETP= "Id_eletp";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	//序号
	public static final String SERIALNO= "Serialno";
	//父类型ID
	public static final String ID_PAR= "Id_par";
	//包标志
	public static final String FG_PKG= "Fg_pkg";
	//包显示样式
	public static final String EU_PKG_DISP_TP= "Eu_pkg_disp_tp";
	//包是否默认展开
	public static final String FG_EXPAND_DEF= "Fg_expand_def";
	//包展开方向
	public static final String EU_EXPAND_DIR= "Eu_expand_dir";
	//子元素序号显示类型
	public static final String EU_CHILD_SN_DISP_TP= "Eu_child_sn_disp_tp";
	//是否需要对照
	public static final String FG_NEEDMATCH= "Fg_needmatch";
	//对照目标位置
	public static final String TARGET_POS= "Target_pos";
	//对照数据获取SQL
	public static final String MATCH_SQL= "Match_sql";
	//需要执行确认
	public static final String FG_NEED_EXECFM= "Fg_need_execfm";
	//确认角色ID
	public static final String ID_EXE_ROLE= "Id_exe_role";
	//确认角色编码
	public static final String SD_EXE_ROLE= "Sd_exe_role";
	//元素图标
	public static final String ID_ICO= "Id_ico";
	//元素图标编码
	public static final String SD_ICO= "Sd_ico";
	//执行功能触发接口
	public static final String ID_IF_EXE_FUNC= "Id_if_exe_func";
	//执行结果判断接口
	public static final String ID_IF_EXE_RSLT= "Id_if_exe_rslt";
	//对应DO路径
	public static final String DATAOBJ= "Dataobj";
	//是否显示在患者版路径告知单
	public static final String FG_PAT_NOTICE= "Fg_pat_notice";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//继承父级元素类型ID
	public static final String ID_INHERIT_PAR= "Id_inherit_par";
	//名称
	public static final String NAME_PAR= "Name_par";
	//确认角色
	public static final String NAME_EXE_ROLE= "Name_exe_role";
	//元素图标
	public static final String ICO_NAME= "Ico_name";
	//接口名称
	public static final String NAME_IF_FUNC= "Name_if_func";
	//接口内容
	public static final String IF_FUNC_CONTENT= "If_func_content";
	//接口类型编码
	public static final String SD_IFTP_FUNC= "Sd_iftp_func";
	//接口编码
	public static final String CODE_IF_FUNC= "Code_if_func";
	//接口类型编码
	public static final String SD_IFTP_RSLT= "Sd_iftp_rslt";
	//接口名称
	public static final String NAME_IF_RSLT= "Name_if_rslt";
	//接口编码
	public static final String CODE_IF_RSLT= "Code_if_rslt";
	//接口内容
	public static final String IF_RSLT_CONTENT= "If_rslt_content";
	//继承父级元素名称
	public static final String NAME_INHERIT_PAR= "Name_inherit_par";
	//继承父级元素编码
	public static final String CODE_INHERIT_PAR= "Code_inherit_par";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 元素类型ID
	 * @return String
	 */
	public String getId_eletp() {
		return ((String) getAttrVal("Id_eletp"));
	}	
	/**
	 * 元素类型ID
	 * @param Id_eletp
	 */
	public void setId_eletp(String Id_eletp) {
		setAttrVal("Id_eletp", Id_eletp);
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
	 * 序号
	 * @return Integer
	 */
	public Integer getSerialno() {
		return ((Integer) getAttrVal("Serialno"));
	}	
	/**
	 * 序号
	 * @param Serialno
	 */
	public void setSerialno(Integer Serialno) {
		setAttrVal("Serialno", Serialno);
	}
	/**
	 * 父类型ID
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 父类型ID
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 包标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pkg() {
		return ((FBoolean) getAttrVal("Fg_pkg"));
	}	
	/**
	 * 包标志
	 * @param Fg_pkg
	 */
	public void setFg_pkg(FBoolean Fg_pkg) {
		setAttrVal("Fg_pkg", Fg_pkg);
	}
	/**
	 * 包显示样式
	 * @return Integer
	 */
	public Integer getEu_pkg_disp_tp() {
		return ((Integer) getAttrVal("Eu_pkg_disp_tp"));
	}	
	/**
	 * 包显示样式
	 * @param Eu_pkg_disp_tp
	 */
	public void setEu_pkg_disp_tp(Integer Eu_pkg_disp_tp) {
		setAttrVal("Eu_pkg_disp_tp", Eu_pkg_disp_tp);
	}
	/**
	 * 包是否默认展开
	 * @return FBoolean
	 */
	public FBoolean getFg_expand_def() {
		return ((FBoolean) getAttrVal("Fg_expand_def"));
	}	
	/**
	 * 包是否默认展开
	 * @param Fg_expand_def
	 */
	public void setFg_expand_def(FBoolean Fg_expand_def) {
		setAttrVal("Fg_expand_def", Fg_expand_def);
	}
	/**
	 * 包展开方向
	 * @return Integer
	 */
	public Integer getEu_expand_dir() {
		return ((Integer) getAttrVal("Eu_expand_dir"));
	}	
	/**
	 * 包展开方向
	 * @param Eu_expand_dir
	 */
	public void setEu_expand_dir(Integer Eu_expand_dir) {
		setAttrVal("Eu_expand_dir", Eu_expand_dir);
	}
	/**
	 * 子元素序号显示类型
	 * @return Integer
	 */
	public Integer getEu_child_sn_disp_tp() {
		return ((Integer) getAttrVal("Eu_child_sn_disp_tp"));
	}	
	/**
	 * 子元素序号显示类型
	 * @param Eu_child_sn_disp_tp
	 */
	public void setEu_child_sn_disp_tp(Integer Eu_child_sn_disp_tp) {
		setAttrVal("Eu_child_sn_disp_tp", Eu_child_sn_disp_tp);
	}
	/**
	 * 是否需要对照
	 * @return FBoolean
	 */
	public FBoolean getFg_needmatch() {
		return ((FBoolean) getAttrVal("Fg_needmatch"));
	}	
	/**
	 * 是否需要对照
	 * @param Fg_needmatch
	 */
	public void setFg_needmatch(FBoolean Fg_needmatch) {
		setAttrVal("Fg_needmatch", Fg_needmatch);
	}
	/**
	 * 对照目标位置
	 * @return String
	 */
	public String getTarget_pos() {
		return ((String) getAttrVal("Target_pos"));
	}	
	/**
	 * 对照目标位置
	 * @param Target_pos
	 */
	public void setTarget_pos(String Target_pos) {
		setAttrVal("Target_pos", Target_pos);
	}
	/**
	 * 对照数据获取SQL
	 * @return String
	 */
	public String getMatch_sql() {
		return ((String) getAttrVal("Match_sql"));
	}	
	/**
	 * 对照数据获取SQL
	 * @param Match_sql
	 */
	public void setMatch_sql(String Match_sql) {
		setAttrVal("Match_sql", Match_sql);
	}
	/**
	 * 需要执行确认
	 * @return FBoolean
	 */
	public FBoolean getFg_need_execfm() {
		return ((FBoolean) getAttrVal("Fg_need_execfm"));
	}	
	/**
	 * 需要执行确认
	 * @param Fg_need_execfm
	 */
	public void setFg_need_execfm(FBoolean Fg_need_execfm) {
		setAttrVal("Fg_need_execfm", Fg_need_execfm);
	}
	/**
	 * 确认角色ID
	 * @return String
	 */
	public String getId_exe_role() {
		return ((String) getAttrVal("Id_exe_role"));
	}	
	/**
	 * 确认角色ID
	 * @param Id_exe_role
	 */
	public void setId_exe_role(String Id_exe_role) {
		setAttrVal("Id_exe_role", Id_exe_role);
	}
	/**
	 * 确认角色编码
	 * @return String
	 */
	public String getSd_exe_role() {
		return ((String) getAttrVal("Sd_exe_role"));
	}	
	/**
	 * 确认角色编码
	 * @param Sd_exe_role
	 */
	public void setSd_exe_role(String Sd_exe_role) {
		setAttrVal("Sd_exe_role", Sd_exe_role);
	}
	/**
	 * 元素图标
	 * @return String
	 */
	public String getId_ico() {
		return ((String) getAttrVal("Id_ico"));
	}	
	/**
	 * 元素图标
	 * @param Id_ico
	 */
	public void setId_ico(String Id_ico) {
		setAttrVal("Id_ico", Id_ico);
	}
	/**
	 * 元素图标编码
	 * @return String
	 */
	public String getSd_ico() {
		return ((String) getAttrVal("Sd_ico"));
	}	
	/**
	 * 元素图标编码
	 * @param Sd_ico
	 */
	public void setSd_ico(String Sd_ico) {
		setAttrVal("Sd_ico", Sd_ico);
	}
	/**
	 * 执行功能触发接口
	 * @return String
	 */
	public String getId_if_exe_func() {
		return ((String) getAttrVal("Id_if_exe_func"));
	}	
	/**
	 * 执行功能触发接口
	 * @param Id_if_exe_func
	 */
	public void setId_if_exe_func(String Id_if_exe_func) {
		setAttrVal("Id_if_exe_func", Id_if_exe_func);
	}
	/**
	 * 执行结果判断接口
	 * @return String
	 */
	public String getId_if_exe_rslt() {
		return ((String) getAttrVal("Id_if_exe_rslt"));
	}	
	/**
	 * 执行结果判断接口
	 * @param Id_if_exe_rslt
	 */
	public void setId_if_exe_rslt(String Id_if_exe_rslt) {
		setAttrVal("Id_if_exe_rslt", Id_if_exe_rslt);
	}
	/**
	 * 对应DO路径
	 * @return String
	 */
	public String getDataobj() {
		return ((String) getAttrVal("Dataobj"));
	}	
	/**
	 * 对应DO路径
	 * @param Dataobj
	 */
	public void setDataobj(String Dataobj) {
		setAttrVal("Dataobj", Dataobj);
	}
	/**
	 * 是否显示在患者版路径告知单
	 * @return FBoolean
	 */
	public FBoolean getFg_pat_notice() {
		return ((FBoolean) getAttrVal("Fg_pat_notice"));
	}	
	/**
	 * 是否显示在患者版路径告知单
	 * @param Fg_pat_notice
	 */
	public void setFg_pat_notice(FBoolean Fg_pat_notice) {
		setAttrVal("Fg_pat_notice", Fg_pat_notice);
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
	 * 继承父级元素类型ID
	 * @return String
	 */
	public String getId_inherit_par() {
		return ((String) getAttrVal("Id_inherit_par"));
	}	
	/**
	 * 继承父级元素类型ID
	 * @param Id_inherit_par
	 */
	public void setId_inherit_par(String Id_inherit_par) {
		setAttrVal("Id_inherit_par", Id_inherit_par);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_par() {
		return ((String) getAttrVal("Name_par"));
	}	
	/**
	 * 名称
	 * @param Name_par
	 */
	public void setName_par(String Name_par) {
		setAttrVal("Name_par", Name_par);
	}
	/**
	 * 确认角色
	 * @return String
	 */
	public String getName_exe_role() {
		return ((String) getAttrVal("Name_exe_role"));
	}	
	/**
	 * 确认角色
	 * @param Name_exe_role
	 */
	public void setName_exe_role(String Name_exe_role) {
		setAttrVal("Name_exe_role", Name_exe_role);
	}
	/**
	 * 元素图标
	 * @return String
	 */
	public String getIco_name() {
		return ((String) getAttrVal("Ico_name"));
	}	
	/**
	 * 元素图标
	 * @param Ico_name
	 */
	public void setIco_name(String Ico_name) {
		setAttrVal("Ico_name", Ico_name);
	}
	/**
	 * 接口名称
	 * @return String
	 */
	public String getName_if_func() {
		return ((String) getAttrVal("Name_if_func"));
	}	
	/**
	 * 接口名称
	 * @param Name_if_func
	 */
	public void setName_if_func(String Name_if_func) {
		setAttrVal("Name_if_func", Name_if_func);
	}
	/**
	 * 接口内容
	 * @return String
	 */
	public String getIf_func_content() {
		return ((String) getAttrVal("If_func_content"));
	}	
	/**
	 * 接口内容
	 * @param If_func_content
	 */
	public void setIf_func_content(String If_func_content) {
		setAttrVal("If_func_content", If_func_content);
	}
	/**
	 * 接口类型编码
	 * @return String
	 */
	public String getSd_iftp_func() {
		return ((String) getAttrVal("Sd_iftp_func"));
	}	
	/**
	 * 接口类型编码
	 * @param Sd_iftp_func
	 */
	public void setSd_iftp_func(String Sd_iftp_func) {
		setAttrVal("Sd_iftp_func", Sd_iftp_func);
	}
	/**
	 * 接口编码
	 * @return String
	 */
	public String getCode_if_func() {
		return ((String) getAttrVal("Code_if_func"));
	}	
	/**
	 * 接口编码
	 * @param Code_if_func
	 */
	public void setCode_if_func(String Code_if_func) {
		setAttrVal("Code_if_func", Code_if_func);
	}
	/**
	 * 接口类型编码
	 * @return String
	 */
	public String getSd_iftp_rslt() {
		return ((String) getAttrVal("Sd_iftp_rslt"));
	}	
	/**
	 * 接口类型编码
	 * @param Sd_iftp_rslt
	 */
	public void setSd_iftp_rslt(String Sd_iftp_rslt) {
		setAttrVal("Sd_iftp_rslt", Sd_iftp_rslt);
	}
	/**
	 * 接口名称
	 * @return String
	 */
	public String getName_if_rslt() {
		return ((String) getAttrVal("Name_if_rslt"));
	}	
	/**
	 * 接口名称
	 * @param Name_if_rslt
	 */
	public void setName_if_rslt(String Name_if_rslt) {
		setAttrVal("Name_if_rslt", Name_if_rslt);
	}
	/**
	 * 接口编码
	 * @return String
	 */
	public String getCode_if_rslt() {
		return ((String) getAttrVal("Code_if_rslt"));
	}	
	/**
	 * 接口编码
	 * @param Code_if_rslt
	 */
	public void setCode_if_rslt(String Code_if_rslt) {
		setAttrVal("Code_if_rslt", Code_if_rslt);
	}
	/**
	 * 接口内容
	 * @return String
	 */
	public String getIf_rslt_content() {
		return ((String) getAttrVal("If_rslt_content"));
	}	
	/**
	 * 接口内容
	 * @param If_rslt_content
	 */
	public void setIf_rslt_content(String If_rslt_content) {
		setAttrVal("If_rslt_content", If_rslt_content);
	}
	/**
	 * 继承父级元素名称
	 * @return String
	 */
	public String getName_inherit_par() {
		return ((String) getAttrVal("Name_inherit_par"));
	}	
	/**
	 * 继承父级元素名称
	 * @param Name_inherit_par
	 */
	public void setName_inherit_par(String Name_inherit_par) {
		setAttrVal("Name_inherit_par", Name_inherit_par);
	}
	/**
	 * 继承父级元素编码
	 * @return String
	 */
	public String getCode_inherit_par() {
		return ((String) getAttrVal("Code_inherit_par"));
	}	
	/**
	 * 继承父级元素编码
	 * @param Code_inherit_par
	 */
	public void setCode_inherit_par(String Code_inherit_par) {
		setAttrVal("Code_inherit_par", Code_inherit_par);
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
		return "Id_eletp";
	}
	
	@Override
	public String getTableName() {	  
		return "hp_cp_eletp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemTypeDODesc.class);
	}
	
}