package iih.pe.pip.peipdwquery.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pip.peipdwquery.d.desc.PeIpDwQueryDODesc;
import java.math.BigDecimal;

/**
 * 体检住院医生站查询 DO数据 
 * 
 */
public class PeIpDwQueryDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检分检检索主键标识
	public static final String ID_PEDWSQUERY= "Id_pedwsquery";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//结束日期
	public static final String DT_END= "Dt_end";
	//所属诊间
	public static final String ID_DEP= "Id_dep";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//建议过滤
	public static final String SUGGTP= "Suggtp";
	//过滤分类
	public static final String FILTERCA= "Filterca";
	//总检状态过滤
	public static final String FILTEROVAL= "Filteroval";
	//阳性追踪状态过滤
	public static final String FILTERTRACK= "Filtertrack";
	//健康管理状态过滤
	public static final String FILTERHM= "Filterhm";
	//总检排序方式
	public static final String SORTOVAL= "Sortoval";
	//备注
	public static final String RMK_CORP= "Rmk_corp";
	//付款客户
	public static final String ID_CUST= "Id_cust";
	//团检记录
	public static final String ID_PECMPY= "Id_pecmpy";
	//诊间编码
	public static final String CODE_ROOM= "Code_room";
	//诊间名称
	public static final String NAME_ROOM= "Name_room";
	//客户姓名
	public static final String NAME_PSN= "Name_psn";
	//年龄
	public static final String AGE_PSN= "Age_psn";
	//性别编码
	public static final String SD_SEX_PSN= "Sd_sex_psn";
	//体检流程号
	public static final String CARD_PE= "Card_pe";
	//客户编码
	public static final String CODE_CUST= "Code_cust";
	//客户名称
	public static final String NAME_CUST= "Name_cust";
	//团检编码
	public static final String NO_CONTRACT= "No_contract";
	//体检次数
	public static final String TIMES_PE= "Times_pe";
	//团检状态
	public static final String EU_STATUS= "Eu_status";
	//有效标识
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检分检检索主键标识
	 * @return String
	 */
	public String getId_pedwsquery() {
		return ((String) getAttrVal("Id_pedwsquery"));
	}	
	/**
	 * 体检分检检索主键标识
	 * @param Id_pedwsquery
	 */
	public void setId_pedwsquery(String Id_pedwsquery) {
		setAttrVal("Id_pedwsquery", Id_pedwsquery);
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
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 所属诊间
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 所属诊间
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 建议过滤
	 * @return Integer
	 */
	public Integer getSuggtp() {
		return ((Integer) getAttrVal("Suggtp"));
	}	
	/**
	 * 建议过滤
	 * @param Suggtp
	 */
	public void setSuggtp(Integer Suggtp) {
		setAttrVal("Suggtp", Suggtp);
	}
	/**
	 * 过滤分类
	 * @return Integer
	 */
	public Integer getFilterca() {
		return ((Integer) getAttrVal("Filterca"));
	}	
	/**
	 * 过滤分类
	 * @param Filterca
	 */
	public void setFilterca(Integer Filterca) {
		setAttrVal("Filterca", Filterca);
	}
	/**
	 * 总检状态过滤
	 * @return Integer
	 */
	public Integer getFilteroval() {
		return ((Integer) getAttrVal("Filteroval"));
	}	
	/**
	 * 总检状态过滤
	 * @param Filteroval
	 */
	public void setFilteroval(Integer Filteroval) {
		setAttrVal("Filteroval", Filteroval);
	}
	/**
	 * 阳性追踪状态过滤
	 * @return Integer
	 */
	public Integer getFiltertrack() {
		return ((Integer) getAttrVal("Filtertrack"));
	}	
	/**
	 * 阳性追踪状态过滤
	 * @param Filtertrack
	 */
	public void setFiltertrack(Integer Filtertrack) {
		setAttrVal("Filtertrack", Filtertrack);
	}
	/**
	 * 健康管理状态过滤
	 * @return Integer
	 */
	public Integer getFilterhm() {
		return ((Integer) getAttrVal("Filterhm"));
	}	
	/**
	 * 健康管理状态过滤
	 * @param Filterhm
	 */
	public void setFilterhm(Integer Filterhm) {
		setAttrVal("Filterhm", Filterhm);
	}
	/**
	 * 总检排序方式
	 * @return Integer
	 */
	public Integer getSortoval() {
		return ((Integer) getAttrVal("Sortoval"));
	}	
	/**
	 * 总检排序方式
	 * @param Sortoval
	 */
	public void setSortoval(Integer Sortoval) {
		setAttrVal("Sortoval", Sortoval);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRmk_corp() {
		return ((String) getAttrVal("Rmk_corp"));
	}	
	/**
	 * 备注
	 * @param Rmk_corp
	 */
	public void setRmk_corp(String Rmk_corp) {
		setAttrVal("Rmk_corp", Rmk_corp);
	}
	/**
	 * 付款客户
	 * @return String
	 */
	public String getId_cust() {
		return ((String) getAttrVal("Id_cust"));
	}	
	/**
	 * 付款客户
	 * @param Id_cust
	 */
	public void setId_cust(String Id_cust) {
		setAttrVal("Id_cust", Id_cust);
	}
	/**
	 * 团检记录
	 * @return String
	 */
	public String getId_pecmpy() {
		return ((String) getAttrVal("Id_pecmpy"));
	}	
	/**
	 * 团检记录
	 * @param Id_pecmpy
	 */
	public void setId_pecmpy(String Id_pecmpy) {
		setAttrVal("Id_pecmpy", Id_pecmpy);
	}
	/**
	 * 诊间编码
	 * @return String
	 */
	public String getCode_room() {
		return ((String) getAttrVal("Code_room"));
	}	
	/**
	 * 诊间编码
	 * @param Code_room
	 */
	public void setCode_room(String Code_room) {
		setAttrVal("Code_room", Code_room);
	}
	/**
	 * 诊间名称
	 * @return String
	 */
	public String getName_room() {
		return ((String) getAttrVal("Name_room"));
	}	
	/**
	 * 诊间名称
	 * @param Name_room
	 */
	public void setName_room(String Name_room) {
		setAttrVal("Name_room", Name_room);
	}
	/**
	 * 客户姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 客户姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 年龄
	 * @return Integer
	 */
	public Integer getAge_psn() {
		return ((Integer) getAttrVal("Age_psn"));
	}	
	/**
	 * 年龄
	 * @param Age_psn
	 */
	public void setAge_psn(Integer Age_psn) {
		setAttrVal("Age_psn", Age_psn);
	}
	/**
	 * 性别编码
	 * @return Integer
	 */
	public Integer getSd_sex_psn() {
		return ((Integer) getAttrVal("Sd_sex_psn"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex_psn
	 */
	public void setSd_sex_psn(Integer Sd_sex_psn) {
		setAttrVal("Sd_sex_psn", Sd_sex_psn);
	}
	/**
	 * 体检流程号
	 * @return String
	 */
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}	
	/**
	 * 体检流程号
	 * @param Card_pe
	 */
	public void setCard_pe(String Card_pe) {
		setAttrVal("Card_pe", Card_pe);
	}
	/**
	 * 客户编码
	 * @return String
	 */
	public String getCode_cust() {
		return ((String) getAttrVal("Code_cust"));
	}	
	/**
	 * 客户编码
	 * @param Code_cust
	 */
	public void setCode_cust(String Code_cust) {
		setAttrVal("Code_cust", Code_cust);
	}
	/**
	 * 客户名称
	 * @return String
	 */
	public String getName_cust() {
		return ((String) getAttrVal("Name_cust"));
	}	
	/**
	 * 客户名称
	 * @param Name_cust
	 */
	public void setName_cust(String Name_cust) {
		setAttrVal("Name_cust", Name_cust);
	}
	/**
	 * 团检编码
	 * @return String
	 */
	public String getNo_contract() {
		return ((String) getAttrVal("No_contract"));
	}	
	/**
	 * 团检编码
	 * @param No_contract
	 */
	public void setNo_contract(String No_contract) {
		setAttrVal("No_contract", No_contract);
	}
	/**
	 * 体检次数
	 * @return Integer
	 */
	public Integer getTimes_pe() {
		return ((Integer) getAttrVal("Times_pe"));
	}	
	/**
	 * 体检次数
	 * @param Times_pe
	 */
	public void setTimes_pe(Integer Times_pe) {
		setAttrVal("Times_pe", Times_pe);
	}
	/**
	 * 团检状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}	
	/**
	 * 团检状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 有效标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 有效标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
		return "Id_pedwsquery";
	}
	
	@Override
	public String getTableName() {	  
		return "";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeIpDwQueryDODesc.class);
	}
	
}