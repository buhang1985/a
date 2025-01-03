package iih.en.que.board.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.que.board.d.desc.EnBrdCallDODesc;
import java.math.BigDecimal;

/**
 * 大屏叫号信息 DO数据 
 * 
 */
public class EnBrdCallDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//大屏叫号ID
	public static final String ID_ENBRDCALL= "Id_enbrdcall";
	//大屏ID
	public static final String ID_BRD= "Id_brd";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//站点编码
	public static final String CODE_SITE= "Code_site";
	//站点名称
	public static final String NAME_SITE= "Name_site";
	//就诊姓名
	public static final String NAME_PAT= "Name_pat";
	//科室名称
	public static final String NAME_DEPT= "Name_dept";
	//资源名称
	public static final String RES_NAME= "Res_name";
	//票号
	public static final String TICK_NO= "Tick_no";
	//插入时间
	public static final String DT_INSERT= "Dt_insert";
	//叫号时间
	public static final String DT_CALL= "Dt_call";
	//年龄
	public static final String AGE= "Age";
	//号别
	public static final String NAME_SRVTP= "Name_srvtp";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//大屏地址
	public static final String ADDR_BRD= "Addr_brd";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//二次屏pc
	public static final String ID_PC_BOARD2= "Id_pc_board2";
	//叫号患者姓名
	public static final String NAME_CALL_PAT= "Name_call_pat";
	//显示屏pc
	public static final String ID_PC= "Id_pc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 大屏叫号ID
	 * @return String
	 */
	public String getId_enbrdcall() {
		return ((String) getAttrVal("Id_enbrdcall"));
	}	
	/**
	 * 大屏叫号ID
	 * @param Id_enbrdcall
	 */
	public void setId_enbrdcall(String Id_enbrdcall) {
		setAttrVal("Id_enbrdcall", Id_enbrdcall);
	}
	/**
	 * 大屏ID
	 * @return String
	 */
	public String getId_brd() {
		return ((String) getAttrVal("Id_brd"));
	}	
	/**
	 * 大屏ID
	 * @param Id_brd
	 */
	public void setId_brd(String Id_brd) {
		setAttrVal("Id_brd", Id_brd);
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
	 * 站点编码
	 * @return String
	 */
	public String getCode_site() {
		return ((String) getAttrVal("Code_site"));
	}	
	/**
	 * 站点编码
	 * @param Code_site
	 */
	public void setCode_site(String Code_site) {
		setAttrVal("Code_site", Code_site);
	}
	/**
	 * 站点名称
	 * @return String
	 */
	public String getName_site() {
		return ((String) getAttrVal("Name_site"));
	}	
	/**
	 * 站点名称
	 * @param Name_site
	 */
	public void setName_site(String Name_site) {
		setAttrVal("Name_site", Name_site);
	}
	/**
	 * 就诊姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 就诊姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 资源名称
	 * @return String
	 */
	public String getRes_name() {
		return ((String) getAttrVal("Res_name"));
	}	
	/**
	 * 资源名称
	 * @param Res_name
	 */
	public void setRes_name(String Res_name) {
		setAttrVal("Res_name", Res_name);
	}
	/**
	 * 票号
	 * @return Integer
	 */
	public Integer getTick_no() {
		return ((Integer) getAttrVal("Tick_no"));
	}	
	/**
	 * 票号
	 * @param Tick_no
	 */
	public void setTick_no(Integer Tick_no) {
		setAttrVal("Tick_no", Tick_no);
	}
	/**
	 * 插入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_insert() {
		return ((FDateTime) getAttrVal("Dt_insert"));
	}	
	/**
	 * 插入时间
	 * @param Dt_insert
	 */
	public void setDt_insert(FDateTime Dt_insert) {
		setAttrVal("Dt_insert", Dt_insert);
	}
	/**
	 * 叫号时间
	 * @return FDateTime
	 */
	public FDateTime getDt_call() {
		return ((FDateTime) getAttrVal("Dt_call"));
	}	
	/**
	 * 叫号时间
	 * @param Dt_call
	 */
	public void setDt_call(FDateTime Dt_call) {
		setAttrVal("Dt_call", Dt_call);
	}
	/**
	 * 年龄
	 * @return Integer
	 */
	public Integer getAge() {
		return ((Integer) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(Integer Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 号别
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 号别
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 大屏地址
	 * @return String
	 */
	public String getAddr_brd() {
		return ((String) getAttrVal("Addr_brd"));
	}	
	/**
	 * 大屏地址
	 * @param Addr_brd
	 */
	public void setAddr_brd(String Addr_brd) {
		setAttrVal("Addr_brd", Addr_brd);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 二次屏pc
	 * @return String
	 */
	public String getId_pc_board2() {
		return ((String) getAttrVal("Id_pc_board2"));
	}	
	/**
	 * 二次屏pc
	 * @param Id_pc_board2
	 */
	public void setId_pc_board2(String Id_pc_board2) {
		setAttrVal("Id_pc_board2", Id_pc_board2);
	}
	/**
	 * 叫号患者姓名
	 * @return String
	 */
	public String getName_call_pat() {
		return ((String) getAttrVal("Name_call_pat"));
	}	
	/**
	 * 叫号患者姓名
	 * @param Name_call_pat
	 */
	public void setName_call_pat(String Name_call_pat) {
		setAttrVal("Name_call_pat", Name_call_pat);
	}
	/**
	 * 显示屏pc
	 * @return String
	 */
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}	
	/**
	 * 显示屏pc
	 * @param Id_pc
	 */
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
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
		return "Id_enbrdcall";
	}
	
	@Override
	public String getTableName() {	  
		return "en_brd_call";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnBrdCallDODesc.class);
	}
	
}