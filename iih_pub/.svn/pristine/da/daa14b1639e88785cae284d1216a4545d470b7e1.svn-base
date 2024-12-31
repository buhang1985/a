package iih.bd.srv.srvcate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvcate.d.desc.SrvCateDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务基本分类 DO数据 
 * 
 */
public class SrvCateDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务基本分类主键标识
	public static final String ID_SRVCA= "Id_srvca";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//默认服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//默认服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务分类编码
	public static final String CODE= "Code";
	//服务分类名称
	public static final String NAME= "Name";
	//服务分类描述
	public static final String DES= "Des";
	//划价方式
	public static final String EU_BLMD= "Eu_blmd";
	//费用标识
	public static final String FG_BL= "Fg_bl";
	//物品标识
	public static final String FG_MM= "Fg_mm";
	//医嘱标识
	public static final String FG_OR= "Fg_or";
	//开立权限标识
	public static final String FG_RT= "Fg_rt";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//父级主键
	public static final String ID_PARENT= "Id_parent";
	//内部编码
	public static final String INNERCODE= "Innercode";
	//预住院标志
	public static final String FG_USE_PIP= "Fg_use_pip";
	//住院
	public static final String FG_ENTP_IP= "Fg_entp_ip";
	//门诊
	public static final String FG_ENTP_OP= "Fg_entp_op";
	//急诊流水标志
	public static final String FG_ENTP_ER= "Fg_entp_er";
	//急诊抢救标志
	public static final String FG_USE_ER1= "Fg_use_er1";
	//急诊留观标志
	public static final String FG_USE_ER2= "Fg_use_er2";
	//家庭
	public static final String FG_ENTP_FM= "Fg_entp_fm";
	//体检
	public static final String FG_ENTP_PE= "Fg_entp_pe";
	//物品绑定时机_住院
	public static final String ID_MMBIND_IP= "Id_mmbind_ip";
	//物品绑定时机编码_住院
	public static final String SD_MMBIND_IP= "Sd_mmbind_ip";
	//物品绑定时机_门诊
	public static final String ID_MMBIND_OP= "Id_mmbind_op";
	//物品绑定时机编码_门诊
	public static final String SD_MMBIND_OP= "Sd_mmbind_op";
	//物品绑定时机_急诊
	public static final String ID_MMBIND_ER= "Id_mmbind_er";
	//物品绑定时机编码_急诊
	public static final String SD_MMBIND_ER= "Sd_mmbind_er";
	//物品绑定时机_体检
	public static final String ID_MMBIND_PE= "Id_mmbind_pe";
	//物品绑定时机编码_体检
	public static final String SD_MMBIND_PE= "Sd_mmbind_pe";
	//物品绑定时机_家庭
	public static final String ID_MMBIND_FM= "Id_mmbind_fm";
	//物品绑定时机编码_家庭
	public static final String SD_MMBIND_FM= "Sd_mmbind_fm";
	//全名称
	public static final String FULLNAME= "Fullname";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String SRVTYPE_NAME= "Srvtype_name";
	//编码
	public static final String SRVTYPE_CODE= "Srvtype_code";
	//服务分类编码
	public static final String SRVCA_CODE= "Srvca_code";
	//服务分类名称
	public static final String SRVCA_NAME= "Srvca_name";
	//上级分类服务类型编码
	public static final String PARENT_SD_SRVTP= "Parent_sd_srvtp";
	//父级全名称
	public static final String FULLNAME_PAR= "Fullname_par";
	//编码
	public static final String IP_CODE= "Ip_code";
	//名称
	public static final String IP_NAME= "Ip_name";
	//名称
	public static final String OP_NAME= "Op_name";
	//编码
	public static final String OP_CODE= "Op_code";
	//名称
	public static final String ER_NAME= "Er_name";
	//编码
	public static final String ER_CODE= "Er_code";
	//编码
	public static final String PE_CODE= "Pe_code";
	//名称
	public static final String PE_NAME= "Pe_name";
	//编码
	public static final String HM_CODE= "Hm_code";
	//名称
	public static final String HM_NAME= "Hm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 服务基本分类主键标识
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 服务基本分类主键标识
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
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
	 * 默认服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 默认服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 默认服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 默认服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务分类编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 服务分类编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 服务分类名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 服务分类描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 服务分类描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 划价方式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}	
	/**
	 * 划价方式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	/**
	 * 费用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}	
	/**
	 * 费用标识
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	/**
	 * 物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}	
	/**
	 * 医嘱标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 开立权限标识
	 * @return FBoolean
	 */
	public FBoolean getFg_rt() {
		return ((FBoolean) getAttrVal("Fg_rt"));
	}	
	/**
	 * 开立权限标识
	 * @param Fg_rt
	 */
	public void setFg_rt(FBoolean Fg_rt) {
		setAttrVal("Fg_rt", Fg_rt);
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
	 * 父级主键
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	/**
	 * 父级主键
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 内部编码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	/**
	 * 内部编码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	/**
	 * 预住院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pip() {
		return ((FBoolean) getAttrVal("Fg_use_pip"));
	}	
	/**
	 * 预住院标志
	 * @param Fg_use_pip
	 */
	public void setFg_use_pip(FBoolean Fg_use_pip) {
		setAttrVal("Fg_use_pip", Fg_use_pip);
	}
	/**
	 * 住院
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_ip() {
		return ((FBoolean) getAttrVal("Fg_entp_ip"));
	}	
	/**
	 * 住院
	 * @param Fg_entp_ip
	 */
	public void setFg_entp_ip(FBoolean Fg_entp_ip) {
		setAttrVal("Fg_entp_ip", Fg_entp_ip);
	}
	/**
	 * 门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_op() {
		return ((FBoolean) getAttrVal("Fg_entp_op"));
	}	
	/**
	 * 门诊
	 * @param Fg_entp_op
	 */
	public void setFg_entp_op(FBoolean Fg_entp_op) {
		setAttrVal("Fg_entp_op", Fg_entp_op);
	}
	/**
	 * 急诊流水标志
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_er() {
		return ((FBoolean) getAttrVal("Fg_entp_er"));
	}	
	/**
	 * 急诊流水标志
	 * @param Fg_entp_er
	 */
	public void setFg_entp_er(FBoolean Fg_entp_er) {
		setAttrVal("Fg_entp_er", Fg_entp_er);
	}
	/**
	 * 急诊抢救标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	/**
	 * 急诊抢救标志
	 * @param Fg_use_er1
	 */
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	/**
	 * 急诊留观标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	/**
	 * 急诊留观标志
	 * @param Fg_use_er2
	 */
	public void setFg_use_er2(FBoolean Fg_use_er2) {
		setAttrVal("Fg_use_er2", Fg_use_er2);
	}
	/**
	 * 家庭
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_fm() {
		return ((FBoolean) getAttrVal("Fg_entp_fm"));
	}	
	/**
	 * 家庭
	 * @param Fg_entp_fm
	 */
	public void setFg_entp_fm(FBoolean Fg_entp_fm) {
		setAttrVal("Fg_entp_fm", Fg_entp_fm);
	}
	/**
	 * 体检
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_pe() {
		return ((FBoolean) getAttrVal("Fg_entp_pe"));
	}	
	/**
	 * 体检
	 * @param Fg_entp_pe
	 */
	public void setFg_entp_pe(FBoolean Fg_entp_pe) {
		setAttrVal("Fg_entp_pe", Fg_entp_pe);
	}
	/**
	 * 物品绑定时机_住院
	 * @return String
	 */
	public String getId_mmbind_ip() {
		return ((String) getAttrVal("Id_mmbind_ip"));
	}	
	/**
	 * 物品绑定时机_住院
	 * @param Id_mmbind_ip
	 */
	public void setId_mmbind_ip(String Id_mmbind_ip) {
		setAttrVal("Id_mmbind_ip", Id_mmbind_ip);
	}
	/**
	 * 物品绑定时机编码_住院
	 * @return String
	 */
	public String getSd_mmbind_ip() {
		return ((String) getAttrVal("Sd_mmbind_ip"));
	}	
	/**
	 * 物品绑定时机编码_住院
	 * @param Sd_mmbind_ip
	 */
	public void setSd_mmbind_ip(String Sd_mmbind_ip) {
		setAttrVal("Sd_mmbind_ip", Sd_mmbind_ip);
	}
	/**
	 * 物品绑定时机_门诊
	 * @return String
	 */
	public String getId_mmbind_op() {
		return ((String) getAttrVal("Id_mmbind_op"));
	}	
	/**
	 * 物品绑定时机_门诊
	 * @param Id_mmbind_op
	 */
	public void setId_mmbind_op(String Id_mmbind_op) {
		setAttrVal("Id_mmbind_op", Id_mmbind_op);
	}
	/**
	 * 物品绑定时机编码_门诊
	 * @return String
	 */
	public String getSd_mmbind_op() {
		return ((String) getAttrVal("Sd_mmbind_op"));
	}	
	/**
	 * 物品绑定时机编码_门诊
	 * @param Sd_mmbind_op
	 */
	public void setSd_mmbind_op(String Sd_mmbind_op) {
		setAttrVal("Sd_mmbind_op", Sd_mmbind_op);
	}
	/**
	 * 物品绑定时机_急诊
	 * @return String
	 */
	public String getId_mmbind_er() {
		return ((String) getAttrVal("Id_mmbind_er"));
	}	
	/**
	 * 物品绑定时机_急诊
	 * @param Id_mmbind_er
	 */
	public void setId_mmbind_er(String Id_mmbind_er) {
		setAttrVal("Id_mmbind_er", Id_mmbind_er);
	}
	/**
	 * 物品绑定时机编码_急诊
	 * @return String
	 */
	public String getSd_mmbind_er() {
		return ((String) getAttrVal("Sd_mmbind_er"));
	}	
	/**
	 * 物品绑定时机编码_急诊
	 * @param Sd_mmbind_er
	 */
	public void setSd_mmbind_er(String Sd_mmbind_er) {
		setAttrVal("Sd_mmbind_er", Sd_mmbind_er);
	}
	/**
	 * 物品绑定时机_体检
	 * @return String
	 */
	public String getId_mmbind_pe() {
		return ((String) getAttrVal("Id_mmbind_pe"));
	}	
	/**
	 * 物品绑定时机_体检
	 * @param Id_mmbind_pe
	 */
	public void setId_mmbind_pe(String Id_mmbind_pe) {
		setAttrVal("Id_mmbind_pe", Id_mmbind_pe);
	}
	/**
	 * 物品绑定时机编码_体检
	 * @return String
	 */
	public String getSd_mmbind_pe() {
		return ((String) getAttrVal("Sd_mmbind_pe"));
	}	
	/**
	 * 物品绑定时机编码_体检
	 * @param Sd_mmbind_pe
	 */
	public void setSd_mmbind_pe(String Sd_mmbind_pe) {
		setAttrVal("Sd_mmbind_pe", Sd_mmbind_pe);
	}
	/**
	 * 物品绑定时机_家庭
	 * @return String
	 */
	public String getId_mmbind_fm() {
		return ((String) getAttrVal("Id_mmbind_fm"));
	}	
	/**
	 * 物品绑定时机_家庭
	 * @param Id_mmbind_fm
	 */
	public void setId_mmbind_fm(String Id_mmbind_fm) {
		setAttrVal("Id_mmbind_fm", Id_mmbind_fm);
	}
	/**
	 * 物品绑定时机编码_家庭
	 * @return String
	 */
	public String getSd_mmbind_fm() {
		return ((String) getAttrVal("Sd_mmbind_fm"));
	}	
	/**
	 * 物品绑定时机编码_家庭
	 * @param Sd_mmbind_fm
	 */
	public void setSd_mmbind_fm(String Sd_mmbind_fm) {
		setAttrVal("Sd_mmbind_fm", Sd_mmbind_fm);
	}
	/**
	 * 全名称
	 * @return String
	 */
	public String getFullname() {
		return ((String) getAttrVal("Fullname"));
	}	
	/**
	 * 全名称
	 * @param Fullname
	 */
	public void setFullname(String Fullname) {
		setAttrVal("Fullname", Fullname);
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
	public String getSrvtype_name() {
		return ((String) getAttrVal("Srvtype_name"));
	}	
	/**
	 * 名称
	 * @param Srvtype_name
	 */
	public void setSrvtype_name(String Srvtype_name) {
		setAttrVal("Srvtype_name", Srvtype_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSrvtype_code() {
		return ((String) getAttrVal("Srvtype_code"));
	}	
	/**
	 * 编码
	 * @param Srvtype_code
	 */
	public void setSrvtype_code(String Srvtype_code) {
		setAttrVal("Srvtype_code", Srvtype_code);
	}
	/**
	 * 服务分类编码
	 * @return String
	 */
	public String getSrvca_code() {
		return ((String) getAttrVal("Srvca_code"));
	}	
	/**
	 * 服务分类编码
	 * @param Srvca_code
	 */
	public void setSrvca_code(String Srvca_code) {
		setAttrVal("Srvca_code", Srvca_code);
	}
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getSrvca_name() {
		return ((String) getAttrVal("Srvca_name"));
	}	
	/**
	 * 服务分类名称
	 * @param Srvca_name
	 */
	public void setSrvca_name(String Srvca_name) {
		setAttrVal("Srvca_name", Srvca_name);
	}
	/**
	 * 上级分类服务类型编码
	 * @return String
	 */
	public String getParent_sd_srvtp() {
		return ((String) getAttrVal("Parent_sd_srvtp"));
	}	
	/**
	 * 上级分类服务类型编码
	 * @param Parent_sd_srvtp
	 */
	public void setParent_sd_srvtp(String Parent_sd_srvtp) {
		setAttrVal("Parent_sd_srvtp", Parent_sd_srvtp);
	}
	/**
	 * 父级全名称
	 * @return String
	 */
	public String getFullname_par() {
		return ((String) getAttrVal("Fullname_par"));
	}	
	/**
	 * 父级全名称
	 * @param Fullname_par
	 */
	public void setFullname_par(String Fullname_par) {
		setAttrVal("Fullname_par", Fullname_par);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIp_code() {
		return ((String) getAttrVal("Ip_code"));
	}	
	/**
	 * 编码
	 * @param Ip_code
	 */
	public void setIp_code(String Ip_code) {
		setAttrVal("Ip_code", Ip_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIp_name() {
		return ((String) getAttrVal("Ip_name"));
	}	
	/**
	 * 名称
	 * @param Ip_name
	 */
	public void setIp_name(String Ip_name) {
		setAttrVal("Ip_name", Ip_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOp_name() {
		return ((String) getAttrVal("Op_name"));
	}	
	/**
	 * 名称
	 * @param Op_name
	 */
	public void setOp_name(String Op_name) {
		setAttrVal("Op_name", Op_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOp_code() {
		return ((String) getAttrVal("Op_code"));
	}	
	/**
	 * 编码
	 * @param Op_code
	 */
	public void setOp_code(String Op_code) {
		setAttrVal("Op_code", Op_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getEr_name() {
		return ((String) getAttrVal("Er_name"));
	}	
	/**
	 * 名称
	 * @param Er_name
	 */
	public void setEr_name(String Er_name) {
		setAttrVal("Er_name", Er_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getEr_code() {
		return ((String) getAttrVal("Er_code"));
	}	
	/**
	 * 编码
	 * @param Er_code
	 */
	public void setEr_code(String Er_code) {
		setAttrVal("Er_code", Er_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	/**
	 * 编码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPe_name() {
		return ((String) getAttrVal("Pe_name"));
	}	
	/**
	 * 名称
	 * @param Pe_name
	 */
	public void setPe_name(String Pe_name) {
		setAttrVal("Pe_name", Pe_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHm_code() {
		return ((String) getAttrVal("Hm_code"));
	}	
	/**
	 * 编码
	 * @param Hm_code
	 */
	public void setHm_code(String Hm_code) {
		setAttrVal("Hm_code", Hm_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHm_name() {
		return ((String) getAttrVal("Hm_name"));
	}	
	/**
	 * 名称
	 * @param Hm_name
	 */
	public void setHm_name(String Hm_name) {
		setAttrVal("Hm_name", Hm_name);
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
		return "Id_srvca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srvca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvCateDODesc.class);
	}
	
}