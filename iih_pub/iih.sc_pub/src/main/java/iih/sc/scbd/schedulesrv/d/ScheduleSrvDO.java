package iih.sc.scbd.schedulesrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.schedulesrv.d.desc.ScheduleSrvDODesc;
import java.math.BigDecimal;

/**
 * 排班服务 DO数据 
 * 
 */
public class ScheduleSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//排班服务ID
	public static final String ID_SCSRV= "Id_scsrv";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//排班类型编码
	public static final String SD_SCTP= "Sd_sctp";
	//排班类型
	public static final String ID_SCTP= "Id_sctp";
	//排班分类
	public static final String ID_SCCA= "Id_scca";
	//排班服务编码
	public static final String CODE= "Code";
	//内部编码
	public static final String INNERCODE= "Innercode";
	//排班服务名称
	public static final String NAME= "Name";
	//排班服务简称
	public static final String SHORTNAME= "Shortname";
	//排班资源描述
	public static final String DES= "Des";
	//默认号源池总数
	public static final String SCPOLCN= "Scpolcn";
	//票号模式编码
	public static final String SD_TICKMD= "Sd_tickmd";
	//票号模式
	public static final String ID_TICKMD= "Id_tickmd";
	//号别id
	public static final String ID_SRVTP= "Id_srvtp";
	//号别编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//默认单个服务时间(分钟)
	public static final String SRVSLOT= "Srvslot";
	//生成号位标志
	public static final String FG_TICK= "Fg_tick";
	//优先开放规则
	public static final String ID_APPTRU= "Id_apptru";
	//父服务id
	public static final String ID_PARENT= "Id_parent";
	//路径
	public static final String PATH= "Path";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//注意事项
	public static final String NOTE= "Note";
	//编码
	public static final String CODE_SCTP= "Code_sctp";
	//名称
	public static final String NAME_SCTP= "Name_sctp";
	//排班分类编码
	public static final String CODE_SCCA= "Code_scca";
	//排班分类名称
	public static final String NAME_SCCA= "Name_scca";
	//票号模式名称
	public static final String NAME_TICKMD= "Name_tickmd";
	//票号模式编码
	public static final String CODE_TICKMD= "Code_tickmd";
	//编码
	public static final String CODE_SRVTP= "Code_srvtp";
	//名称
	public static final String NAME_SRVTP= "Name_srvtp";
	//开放规则编码
	public static final String CODE_APPTRU= "Code_apptru";
	//开放规则名称
	public static final String NAME_APPTRU= "Name_apptru";
	//开放规则类型编码
	public static final String SD_SCHRULE= "Sd_schrule";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 排班服务ID
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}	
	/**
	 * 排班服务ID
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
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
	 * 排班类型编码
	 * @return String
	 */
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}	
	/**
	 * 排班类型编码
	 * @param Sd_sctp
	 */
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	/**
	 * 排班类型
	 * @return String
	 */
	public String getId_sctp() {
		return ((String) getAttrVal("Id_sctp"));
	}	
	/**
	 * 排班类型
	 * @param Id_sctp
	 */
	public void setId_sctp(String Id_sctp) {
		setAttrVal("Id_sctp", Id_sctp);
	}
	/**
	 * 排班分类
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}	
	/**
	 * 排班分类
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	/**
	 * 排班服务编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 排班服务编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 排班服务名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 排班服务名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 排班服务简称
	 * @return String
	 */
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	/**
	 * 排班服务简称
	 * @param Shortname
	 */
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	/**
	 * 排班资源描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 排班资源描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 默认号源池总数
	 * @return Integer
	 */
	public Integer getScpolcn() {
		return ((Integer) getAttrVal("Scpolcn"));
	}	
	/**
	 * 默认号源池总数
	 * @param Scpolcn
	 */
	public void setScpolcn(Integer Scpolcn) {
		setAttrVal("Scpolcn", Scpolcn);
	}
	/**
	 * 票号模式编码
	 * @return String
	 */
	public String getSd_tickmd() {
		return ((String) getAttrVal("Sd_tickmd"));
	}	
	/**
	 * 票号模式编码
	 * @param Sd_tickmd
	 */
	public void setSd_tickmd(String Sd_tickmd) {
		setAttrVal("Sd_tickmd", Sd_tickmd);
	}
	/**
	 * 票号模式
	 * @return String
	 */
	public String getId_tickmd() {
		return ((String) getAttrVal("Id_tickmd"));
	}	
	/**
	 * 票号模式
	 * @param Id_tickmd
	 */
	public void setId_tickmd(String Id_tickmd) {
		setAttrVal("Id_tickmd", Id_tickmd);
	}
	/**
	 * 号别id
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 号别id
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 号别编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 号别编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 默认单个服务时间(分钟)
	 * @return Integer
	 */
	public Integer getSrvslot() {
		return ((Integer) getAttrVal("Srvslot"));
	}	
	/**
	 * 默认单个服务时间(分钟)
	 * @param Srvslot
	 */
	public void setSrvslot(Integer Srvslot) {
		setAttrVal("Srvslot", Srvslot);
	}
	/**
	 * 生成号位标志
	 * @return FBoolean
	 */
	public FBoolean getFg_tick() {
		return ((FBoolean) getAttrVal("Fg_tick"));
	}	
	/**
	 * 生成号位标志
	 * @param Fg_tick
	 */
	public void setFg_tick(FBoolean Fg_tick) {
		setAttrVal("Fg_tick", Fg_tick);
	}
	/**
	 * 优先开放规则
	 * @return String
	 */
	public String getId_apptru() {
		return ((String) getAttrVal("Id_apptru"));
	}	
	/**
	 * 优先开放规则
	 * @param Id_apptru
	 */
	public void setId_apptru(String Id_apptru) {
		setAttrVal("Id_apptru", Id_apptru);
	}
	/**
	 * 父服务id
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	/**
	 * 父服务id
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 路径
	 * @return String
	 */
	public String getPath() {
		return ((String) getAttrVal("Path"));
	}	
	/**
	 * 路径
	 * @param Path
	 */
	public void setPath(String Path) {
		setAttrVal("Path", Path);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 注意事项
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 注意事项
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_sctp() {
		return ((String) getAttrVal("Code_sctp"));
	}	
	/**
	 * 编码
	 * @param Code_sctp
	 */
	public void setCode_sctp(String Code_sctp) {
		setAttrVal("Code_sctp", Code_sctp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sctp() {
		return ((String) getAttrVal("Name_sctp"));
	}	
	/**
	 * 名称
	 * @param Name_sctp
	 */
	public void setName_sctp(String Name_sctp) {
		setAttrVal("Name_sctp", Name_sctp);
	}
	/**
	 * 排班分类编码
	 * @return String
	 */
	public String getCode_scca() {
		return ((String) getAttrVal("Code_scca"));
	}	
	/**
	 * 排班分类编码
	 * @param Code_scca
	 */
	public void setCode_scca(String Code_scca) {
		setAttrVal("Code_scca", Code_scca);
	}
	/**
	 * 排班分类名称
	 * @return String
	 */
	public String getName_scca() {
		return ((String) getAttrVal("Name_scca"));
	}	
	/**
	 * 排班分类名称
	 * @param Name_scca
	 */
	public void setName_scca(String Name_scca) {
		setAttrVal("Name_scca", Name_scca);
	}
	/**
	 * 票号模式名称
	 * @return String
	 */
	public String getName_tickmd() {
		return ((String) getAttrVal("Name_tickmd"));
	}	
	/**
	 * 票号模式名称
	 * @param Name_tickmd
	 */
	public void setName_tickmd(String Name_tickmd) {
		setAttrVal("Name_tickmd", Name_tickmd);
	}
	/**
	 * 票号模式编码
	 * @return String
	 */
	public String getCode_tickmd() {
		return ((String) getAttrVal("Code_tickmd"));
	}	
	/**
	 * 票号模式编码
	 * @param Code_tickmd
	 */
	public void setCode_tickmd(String Code_tickmd) {
		setAttrVal("Code_tickmd", Code_tickmd);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_srvtp() {
		return ((String) getAttrVal("Code_srvtp"));
	}	
	/**
	 * 编码
	 * @param Code_srvtp
	 */
	public void setCode_srvtp(String Code_srvtp) {
		setAttrVal("Code_srvtp", Code_srvtp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 开放规则编码
	 * @return String
	 */
	public String getCode_apptru() {
		return ((String) getAttrVal("Code_apptru"));
	}	
	/**
	 * 开放规则编码
	 * @param Code_apptru
	 */
	public void setCode_apptru(String Code_apptru) {
		setAttrVal("Code_apptru", Code_apptru);
	}
	/**
	 * 开放规则名称
	 * @return String
	 */
	public String getName_apptru() {
		return ((String) getAttrVal("Name_apptru"));
	}	
	/**
	 * 开放规则名称
	 * @param Name_apptru
	 */
	public void setName_apptru(String Name_apptru) {
		setAttrVal("Name_apptru", Name_apptru);
	}
	/**
	 * 开放规则类型编码
	 * @return String
	 */
	public String getSd_schrule() {
		return ((String) getAttrVal("Sd_schrule"));
	}	
	/**
	 * 开放规则类型编码
	 * @param Sd_schrule
	 */
	public void setSd_schrule(String Sd_schrule) {
		setAttrVal("Sd_schrule", Sd_schrule);
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
		return "Id_scsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_srv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScheduleSrvDODesc.class);
	}
	
}