package iih.bd.fc.queben.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.queben.d.desc.QueBenDODesc;
import java.math.BigDecimal;

/**
 * 队列工作台 DO数据 
 * 
 */
public class QueBenDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//就诊队列工作台主键
	public static final String ID_QUEBEN= "Id_queben";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//队列工作台类型
	public static final String ID_QUEBENTP= "Id_quebentp";
	//队列工作台类型编码
	public static final String SD_QUEBENTP= "Sd_quebentp";
	//工作台编码
	public static final String CODE= "Code";
	//工作台名称
	public static final String NAME= "Name";
	//工作台描述
	public static final String DES= "Des";
	//默认屏幕地址
	public static final String ADDR_BOARD= "Addr_board";
	//默认队列分诊规则
	public static final String ID_QUERULE= "Id_querule";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//管理科室
	public static final String IDS_DEP_USE= "Ids_dep_use";
	//停用时间
	public static final String DT_ENDTIME= "Dt_endtime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//分诊实体类型
	public static final String ID_ENTITYTP= "Id_entitytp";
	//分诊实体类型编码
	public static final String SD_ENTITYTP= "Sd_entitytp";
	//分诊台状态
	public static final String EU_PAUSE= "Eu_pause";
	//重新签到方式
	public static final String SD_RESIGN_METHOD= "Sd_resign_method";
	//名称
	public static final String QUE_NAME= "Que_name";
	//编码
	public static final String QUE_CODE= "Que_code";
	//管理科室
	public static final String NAMES_DEP_USE= "Names_dep_use";
	//分诊实体类型编码
	public static final String CODE_ENTITYTP= "Code_entitytp";
	//分诊实体类型名称
	public static final String NAME_ENTITYTP= "Name_entitytp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 就诊队列工作台主键
	 * @return String
	 */
	public String getId_queben() {
		return ((String) getAttrVal("Id_queben"));
	}	
	/**
	 * 就诊队列工作台主键
	 * @param Id_queben
	 */
	public void setId_queben(String Id_queben) {
		setAttrVal("Id_queben", Id_queben);
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
	 * 队列工作台类型
	 * @return String
	 */
	public String getId_quebentp() {
		return ((String) getAttrVal("Id_quebentp"));
	}	
	/**
	 * 队列工作台类型
	 * @param Id_quebentp
	 */
	public void setId_quebentp(String Id_quebentp) {
		setAttrVal("Id_quebentp", Id_quebentp);
	}
	/**
	 * 队列工作台类型编码
	 * @return String
	 */
	public String getSd_quebentp() {
		return ((String) getAttrVal("Sd_quebentp"));
	}	
	/**
	 * 队列工作台类型编码
	 * @param Sd_quebentp
	 */
	public void setSd_quebentp(String Sd_quebentp) {
		setAttrVal("Sd_quebentp", Sd_quebentp);
	}
	/**
	 * 工作台编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 工作台编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 工作台名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 工作台名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 工作台描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 工作台描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 默认屏幕地址
	 * @return String
	 */
	public String getAddr_board() {
		return ((String) getAttrVal("Addr_board"));
	}	
	/**
	 * 默认屏幕地址
	 * @param Addr_board
	 */
	public void setAddr_board(String Addr_board) {
		setAttrVal("Addr_board", Addr_board);
	}
	/**
	 * 默认队列分诊规则
	 * @return String
	 */
	public String getId_querule() {
		return ((String) getAttrVal("Id_querule"));
	}	
	/**
	 * 默认队列分诊规则
	 * @param Id_querule
	 */
	public void setId_querule(String Id_querule) {
		setAttrVal("Id_querule", Id_querule);
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
	 * 管理科室
	 * @return String
	 */
	public String getIds_dep_use() {
		return ((String) getAttrVal("Ids_dep_use"));
	}	
	/**
	 * 管理科室
	 * @param Ids_dep_use
	 */
	public void setIds_dep_use(String Ids_dep_use) {
		setAttrVal("Ids_dep_use", Ids_dep_use);
	}
	/**
	 * 停用时间
	 * @return FDateTime
	 */
	public FDateTime getDt_endtime() {
		return ((FDateTime) getAttrVal("Dt_endtime"));
	}	
	/**
	 * 停用时间
	 * @param Dt_endtime
	 */
	public void setDt_endtime(FDateTime Dt_endtime) {
		setAttrVal("Dt_endtime", Dt_endtime);
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
	 * 分诊实体类型
	 * @return String
	 */
	public String getId_entitytp() {
		return ((String) getAttrVal("Id_entitytp"));
	}	
	/**
	 * 分诊实体类型
	 * @param Id_entitytp
	 */
	public void setId_entitytp(String Id_entitytp) {
		setAttrVal("Id_entitytp", Id_entitytp);
	}
	/**
	 * 分诊实体类型编码
	 * @return String
	 */
	public String getSd_entitytp() {
		return ((String) getAttrVal("Sd_entitytp"));
	}	
	/**
	 * 分诊实体类型编码
	 * @param Sd_entitytp
	 */
	public void setSd_entitytp(String Sd_entitytp) {
		setAttrVal("Sd_entitytp", Sd_entitytp);
	}
	/**
	 * 分诊台状态
	 * @return String
	 */
	public String getEu_pause() {
		return ((String) getAttrVal("Eu_pause"));
	}	
	/**
	 * 分诊台状态
	 * @param Eu_pause
	 */
	public void setEu_pause(String Eu_pause) {
		setAttrVal("Eu_pause", Eu_pause);
	}
	/**
	 * 重新签到方式
	 * @return String
	 */
	public String getSd_resign_method() {
		return ((String) getAttrVal("Sd_resign_method"));
	}	
	/**
	 * 重新签到方式
	 * @param Sd_resign_method
	 */
	public void setSd_resign_method(String Sd_resign_method) {
		setAttrVal("Sd_resign_method", Sd_resign_method);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getQue_name() {
		return ((String) getAttrVal("Que_name"));
	}	
	/**
	 * 名称
	 * @param Que_name
	 */
	public void setQue_name(String Que_name) {
		setAttrVal("Que_name", Que_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getQue_code() {
		return ((String) getAttrVal("Que_code"));
	}	
	/**
	 * 编码
	 * @param Que_code
	 */
	public void setQue_code(String Que_code) {
		setAttrVal("Que_code", Que_code);
	}
	/**
	 * 管理科室
	 * @return String
	 */
	public String getNames_dep_use() {
		return ((String) getAttrVal("Names_dep_use"));
	}	
	/**
	 * 管理科室
	 * @param Names_dep_use
	 */
	public void setNames_dep_use(String Names_dep_use) {
		setAttrVal("Names_dep_use", Names_dep_use);
	}
	/**
	 * 分诊实体类型编码
	 * @return String
	 */
	public String getCode_entitytp() {
		return ((String) getAttrVal("Code_entitytp"));
	}	
	/**
	 * 分诊实体类型编码
	 * @param Code_entitytp
	 */
	public void setCode_entitytp(String Code_entitytp) {
		setAttrVal("Code_entitytp", Code_entitytp);
	}
	/**
	 * 分诊实体类型名称
	 * @return String
	 */
	public String getName_entitytp() {
		return ((String) getAttrVal("Name_entitytp"));
	}	
	/**
	 * 分诊实体类型名称
	 * @param Name_entitytp
	 */
	public void setName_entitytp(String Name_entitytp) {
		setAttrVal("Name_entitytp", Name_entitytp);
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
		return "Id_queben";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_que_ben";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QueBenDODesc.class);
	}
	
}