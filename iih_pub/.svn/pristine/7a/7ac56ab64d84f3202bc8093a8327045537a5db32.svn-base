package iih.ems.eass.adj.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.eass.adj.d.desc.EmsAdjDODesc;
import java.math.BigDecimal;

/**
 * 价值变更 DO数据 
 * 
 */
public class EmsAdjDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//价值变更主键
	public static final String ID_ADJ= "Id_adj";
	//资产卡
	public static final String ID_CARD= "Id_card";
	//资产卡号
	public static final String CARD_NO= "Card_no";
	//分类树内码
	public static final String EMCA_INRCODE= "Emca_inrcode";
	//资产卡名称
	public static final String CARD_NAME= "Card_name";
	//设备科室编码
	public static final String ID_DEPT= "Id_dept";
	//设备编码
	public static final String ID_EM= "Id_em";
	//规格
	public static final String SPECS= "Specs";
	//型号
	public static final String MODEL= "Model";
	//单位
	public static final String UNIT= "Unit";
	//资产原值
	public static final String SOURCE_PRICE= "Source_price";
	//资产净值
	public static final String NET_PRICE= "Net_price";
	//资产残值
	public static final String LEAVE_PRICE= "Leave_price";
	//初始数量
	public static final String INIT_NUM= "Init_num";
	//购入价格
	public static final String BUY_PRICE= "Buy_price";
	//购入金额
	public static final String BUY_COST= "Buy_cost";
	//折旧方式
	public static final String ID_DETP= "Id_detp";
	//折旧年限
	public static final String DE_YEAR= "De_year";
	//已折旧月份
	public static final String LESS_MONTH= "Less_month";
	//预计净残值
	public static final String PRE_NET_PRICE= "Pre_net_price";
	//变更后资产原值
	public static final String HIND_SOURCE_PRICE= "Hind_source_price";
	//变更后资产净值
	public static final String HIND_NET_PRICE= "Hind_net_price";
	//变更后残值
	public static final String HIND_LEAVE_PRICE= "Hind_leave_price";
	//变更后折旧年限
	public static final String HIND_DE_YEAR= "Hind_de_year";
	//变更后已折旧月份
	public static final String HIND_LESS_MONTH= "Hind_less_month";
	//变更后预计净残值
	public static final String HIND_PRE_NET_PRICE= "Hind_pre_net_price";
	//变更原因
	public static final String ADJUST_CAUSE= "Adjust_cause";
	//保管等级
	public static final String ID_STOR_LEVEL= "Id_stor_level";
	//保管等级编码
	public static final String SD_STOR_LEVEL= "Sd_stor_level";
	//保管科室
	public static final String ID_STOR_DEPT= "Id_stor_dept";
	//保管人
	public static final String ID_STOR_OPER= "Id_stor_oper";
	//申请状态
	public static final String ID_STU= "Id_stu";
	//申请状态编码
	public static final String SD_STU= "Sd_stu";
	//申请单号
	public static final String CODE= "Code";
	//申请单名称
	public static final String NAME= "Name";
	//申请人
	public static final String ID_APPLY_OPER= "Id_apply_oper";
	//申请科室
	public static final String ID_APPLY_DEPT= "Id_apply_dept";
	//申请仓库
	public static final String ID_WH= "Id_wh";
	//申请时间
	public static final String DT_APPLY= "Dt_apply";
	//登记人
	public static final String ID_REG_OPER= "Id_reg_oper";
	//登记科室
	public static final String ID_REG_DEPT= "Id_reg_dept";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//核准人
	public static final String ID_APPROVE_OPER= "Id_approve_oper";
	//核准科室
	public static final String ID_APPROVE_DEPT= "Id_approve_dept";
	//审核时间
	public static final String DT_APPROVE= "Dt_approve";
	//作废人
	public static final String ID_WASTE_OPER= "Id_waste_oper";
	//作废科室
	public static final String ID_WASTE_DEPT= "Id_waste_dept";
	//作废时间
	public static final String DT_WASTE= "Dt_waste";
	//作废原因
	public static final String WASTE_CAUSE= "Waste_cause";
	//备注
	public static final String REMARK= "Remark";
	//设备分类
	public static final String ID_EMCA= "Id_emca";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GROUP= "Id_group";
	//财务年月
	public static final String YEAR_MONTH= "Year_month";
	//变更后折旧方式
	public static final String HIND_DETP= "Hind_detp";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//编码
	public static final String CODE_DEPT= "Code_dept";
	//设备名称
	public static final String NAME_EM= "Name_em";
	//设备编码
	public static final String CODE_EM= "Code_em";
	//折旧名称
	public static final String NAME_DETP= "Name_detp";
	//名称
	public static final String NAME_STOR_LEVEL= "Name_stor_level";
	//名称
	public static final String NAME_STOR_DEPT= "Name_stor_dept";
	//姓名
	public static final String NAME_STOR_OPER= "Name_stor_oper";
	//名称
	public static final String NAME_STU= "Name_stu";
	//姓名
	public static final String NAME_APPLY_OPER= "Name_apply_oper";
	//名称
	public static final String NAME_APPLY_DEPT= "Name_apply_dept";
	//仓库名称
	public static final String NAME_WH= "Name_wh";
	//姓名
	public static final String NAME_REG_OPER= "Name_reg_oper";
	//名称
	public static final String NAME_REG_DEPT= "Name_reg_dept";
	//姓名
	public static final String NAME_APPROVE_OPER= "Name_approve_oper";
	//名称
	public static final String NAME_APPROVE_DEPT= "Name_approve_dept";
	//姓名
	public static final String NAME_WASTE_OPER= "Name_waste_oper";
	//名称
	public static final String NAME_WASE_OPER= "Name_wase_oper";
	//编码
	public static final String CODE_EMCA= "Code_emca";
	//名称
	public static final String NAME_EMCA= "Name_emca";
	//折旧名称
	public static final String HIND_NAME= "Hind_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 价值变更主键
	 * @return String
	 */
	public String getId_adj() {
		return ((String) getAttrVal("Id_adj"));
	}	
	/**
	 * 价值变更主键
	 * @param Id_adj
	 */
	public void setId_adj(String Id_adj) {
		setAttrVal("Id_adj", Id_adj);
	}
	/**
	 * 资产卡
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 资产卡
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 资产卡号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 资产卡号
	 * @param Card_no
	 */
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	/**
	 * 分类树内码
	 * @return String
	 */
	public String getEmca_inrcode() {
		return ((String) getAttrVal("Emca_inrcode"));
	}	
	/**
	 * 分类树内码
	 * @param Emca_inrcode
	 */
	public void setEmca_inrcode(String Emca_inrcode) {
		setAttrVal("Emca_inrcode", Emca_inrcode);
	}
	/**
	 * 资产卡名称
	 * @return String
	 */
	public String getCard_name() {
		return ((String) getAttrVal("Card_name"));
	}	
	/**
	 * 资产卡名称
	 * @param Card_name
	 */
	public void setCard_name(String Card_name) {
		setAttrVal("Card_name", Card_name);
	}
	/**
	 * 设备科室编码
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 设备科室编码
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 设备编码
	 * @return String
	 */
	public String getId_em() {
		return ((String) getAttrVal("Id_em"));
	}	
	/**
	 * 设备编码
	 * @param Id_em
	 */
	public void setId_em(String Id_em) {
		setAttrVal("Id_em", Id_em);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpecs() {
		return ((String) getAttrVal("Specs"));
	}	
	/**
	 * 规格
	 * @param Specs
	 */
	public void setSpecs(String Specs) {
		setAttrVal("Specs", Specs);
	}
	/**
	 * 型号
	 * @return String
	 */
	public String getModel() {
		return ((String) getAttrVal("Model"));
	}	
	/**
	 * 型号
	 * @param Model
	 */
	public void setModel(String Model) {
		setAttrVal("Model", Model);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}	
	/**
	 * 单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	/**
	 * 资产原值
	 * @return FDouble
	 */
	public FDouble getSource_price() {
		return ((FDouble) getAttrVal("Source_price"));
	}	
	/**
	 * 资产原值
	 * @param Source_price
	 */
	public void setSource_price(FDouble Source_price) {
		setAttrVal("Source_price", Source_price);
	}
	/**
	 * 资产净值
	 * @return FDouble
	 */
	public FDouble getNet_price() {
		return ((FDouble) getAttrVal("Net_price"));
	}	
	/**
	 * 资产净值
	 * @param Net_price
	 */
	public void setNet_price(FDouble Net_price) {
		setAttrVal("Net_price", Net_price);
	}
	/**
	 * 资产残值
	 * @return FDouble
	 */
	public FDouble getLeave_price() {
		return ((FDouble) getAttrVal("Leave_price"));
	}	
	/**
	 * 资产残值
	 * @param Leave_price
	 */
	public void setLeave_price(FDouble Leave_price) {
		setAttrVal("Leave_price", Leave_price);
	}
	/**
	 * 初始数量
	 * @return Integer
	 */
	public Integer getInit_num() {
		return ((Integer) getAttrVal("Init_num"));
	}	
	/**
	 * 初始数量
	 * @param Init_num
	 */
	public void setInit_num(Integer Init_num) {
		setAttrVal("Init_num", Init_num);
	}
	/**
	 * 购入价格
	 * @return FDouble
	 */
	public FDouble getBuy_price() {
		return ((FDouble) getAttrVal("Buy_price"));
	}	
	/**
	 * 购入价格
	 * @param Buy_price
	 */
	public void setBuy_price(FDouble Buy_price) {
		setAttrVal("Buy_price", Buy_price);
	}
	/**
	 * 购入金额
	 * @return FDouble
	 */
	public FDouble getBuy_cost() {
		return ((FDouble) getAttrVal("Buy_cost"));
	}	
	/**
	 * 购入金额
	 * @param Buy_cost
	 */
	public void setBuy_cost(FDouble Buy_cost) {
		setAttrVal("Buy_cost", Buy_cost);
	}
	/**
	 * 折旧方式
	 * @return String
	 */
	public String getId_detp() {
		return ((String) getAttrVal("Id_detp"));
	}	
	/**
	 * 折旧方式
	 * @param Id_detp
	 */
	public void setId_detp(String Id_detp) {
		setAttrVal("Id_detp", Id_detp);
	}
	/**
	 * 折旧年限
	 * @return Integer
	 */
	public Integer getDe_year() {
		return ((Integer) getAttrVal("De_year"));
	}	
	/**
	 * 折旧年限
	 * @param De_year
	 */
	public void setDe_year(Integer De_year) {
		setAttrVal("De_year", De_year);
	}
	/**
	 * 已折旧月份
	 * @return Integer
	 */
	public Integer getLess_month() {
		return ((Integer) getAttrVal("Less_month"));
	}	
	/**
	 * 已折旧月份
	 * @param Less_month
	 */
	public void setLess_month(Integer Less_month) {
		setAttrVal("Less_month", Less_month);
	}
	/**
	 * 预计净残值
	 * @return FDouble
	 */
	public FDouble getPre_net_price() {
		return ((FDouble) getAttrVal("Pre_net_price"));
	}	
	/**
	 * 预计净残值
	 * @param Pre_net_price
	 */
	public void setPre_net_price(FDouble Pre_net_price) {
		setAttrVal("Pre_net_price", Pre_net_price);
	}
	/**
	 * 变更后资产原值
	 * @return FDouble
	 */
	public FDouble getHind_source_price() {
		return ((FDouble) getAttrVal("Hind_source_price"));
	}	
	/**
	 * 变更后资产原值
	 * @param Hind_source_price
	 */
	public void setHind_source_price(FDouble Hind_source_price) {
		setAttrVal("Hind_source_price", Hind_source_price);
	}
	/**
	 * 变更后资产净值
	 * @return FDouble
	 */
	public FDouble getHind_net_price() {
		return ((FDouble) getAttrVal("Hind_net_price"));
	}	
	/**
	 * 变更后资产净值
	 * @param Hind_net_price
	 */
	public void setHind_net_price(FDouble Hind_net_price) {
		setAttrVal("Hind_net_price", Hind_net_price);
	}
	/**
	 * 变更后残值
	 * @return FDouble
	 */
	public FDouble getHind_leave_price() {
		return ((FDouble) getAttrVal("Hind_leave_price"));
	}	
	/**
	 * 变更后残值
	 * @param Hind_leave_price
	 */
	public void setHind_leave_price(FDouble Hind_leave_price) {
		setAttrVal("Hind_leave_price", Hind_leave_price);
	}
	/**
	 * 变更后折旧年限
	 * @return Integer
	 */
	public Integer getHind_de_year() {
		return ((Integer) getAttrVal("Hind_de_year"));
	}	
	/**
	 * 变更后折旧年限
	 * @param Hind_de_year
	 */
	public void setHind_de_year(Integer Hind_de_year) {
		setAttrVal("Hind_de_year", Hind_de_year);
	}
	/**
	 * 变更后已折旧月份
	 * @return Integer
	 */
	public Integer getHind_less_month() {
		return ((Integer) getAttrVal("Hind_less_month"));
	}	
	/**
	 * 变更后已折旧月份
	 * @param Hind_less_month
	 */
	public void setHind_less_month(Integer Hind_less_month) {
		setAttrVal("Hind_less_month", Hind_less_month);
	}
	/**
	 * 变更后预计净残值
	 * @return FDouble
	 */
	public FDouble getHind_pre_net_price() {
		return ((FDouble) getAttrVal("Hind_pre_net_price"));
	}	
	/**
	 * 变更后预计净残值
	 * @param Hind_pre_net_price
	 */
	public void setHind_pre_net_price(FDouble Hind_pre_net_price) {
		setAttrVal("Hind_pre_net_price", Hind_pre_net_price);
	}
	/**
	 * 变更原因
	 * @return String
	 */
	public String getAdjust_cause() {
		return ((String) getAttrVal("Adjust_cause"));
	}	
	/**
	 * 变更原因
	 * @param Adjust_cause
	 */
	public void setAdjust_cause(String Adjust_cause) {
		setAttrVal("Adjust_cause", Adjust_cause);
	}
	/**
	 * 保管等级
	 * @return String
	 */
	public String getId_stor_level() {
		return ((String) getAttrVal("Id_stor_level"));
	}	
	/**
	 * 保管等级
	 * @param Id_stor_level
	 */
	public void setId_stor_level(String Id_stor_level) {
		setAttrVal("Id_stor_level", Id_stor_level);
	}
	/**
	 * 保管等级编码
	 * @return String
	 */
	public String getSd_stor_level() {
		return ((String) getAttrVal("Sd_stor_level"));
	}	
	/**
	 * 保管等级编码
	 * @param Sd_stor_level
	 */
	public void setSd_stor_level(String Sd_stor_level) {
		setAttrVal("Sd_stor_level", Sd_stor_level);
	}
	/**
	 * 保管科室
	 * @return String
	 */
	public String getId_stor_dept() {
		return ((String) getAttrVal("Id_stor_dept"));
	}	
	/**
	 * 保管科室
	 * @param Id_stor_dept
	 */
	public void setId_stor_dept(String Id_stor_dept) {
		setAttrVal("Id_stor_dept", Id_stor_dept);
	}
	/**
	 * 保管人
	 * @return String
	 */
	public String getId_stor_oper() {
		return ((String) getAttrVal("Id_stor_oper"));
	}	
	/**
	 * 保管人
	 * @param Id_stor_oper
	 */
	public void setId_stor_oper(String Id_stor_oper) {
		setAttrVal("Id_stor_oper", Id_stor_oper);
	}
	/**
	 * 申请状态
	 * @return String
	 */
	public String getId_stu() {
		return ((String) getAttrVal("Id_stu"));
	}	
	/**
	 * 申请状态
	 * @param Id_stu
	 */
	public void setId_stu(String Id_stu) {
		setAttrVal("Id_stu", Id_stu);
	}
	/**
	 * 申请状态编码
	 * @return String
	 */
	public String getSd_stu() {
		return ((String) getAttrVal("Sd_stu"));
	}	
	/**
	 * 申请状态编码
	 * @param Sd_stu
	 */
	public void setSd_stu(String Sd_stu) {
		setAttrVal("Sd_stu", Sd_stu);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 申请单号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 申请单名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 申请单名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getId_apply_oper() {
		return ((String) getAttrVal("Id_apply_oper"));
	}	
	/**
	 * 申请人
	 * @param Id_apply_oper
	 */
	public void setId_apply_oper(String Id_apply_oper) {
		setAttrVal("Id_apply_oper", Id_apply_oper);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getId_apply_dept() {
		return ((String) getAttrVal("Id_apply_dept"));
	}	
	/**
	 * 申请科室
	 * @param Id_apply_dept
	 */
	public void setId_apply_dept(String Id_apply_dept) {
		setAttrVal("Id_apply_dept", Id_apply_dept);
	}
	/**
	 * 申请仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 申请仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_apply() {
		return ((FDateTime) getAttrVal("Dt_apply"));
	}	
	/**
	 * 申请时间
	 * @param Dt_apply
	 */
	public void setDt_apply(FDateTime Dt_apply) {
		setAttrVal("Dt_apply", Dt_apply);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_reg_oper() {
		return ((String) getAttrVal("Id_reg_oper"));
	}	
	/**
	 * 登记人
	 * @param Id_reg_oper
	 */
	public void setId_reg_oper(String Id_reg_oper) {
		setAttrVal("Id_reg_oper", Id_reg_oper);
	}
	/**
	 * 登记科室
	 * @return String
	 */
	public String getId_reg_dept() {
		return ((String) getAttrVal("Id_reg_dept"));
	}	
	/**
	 * 登记科室
	 * @param Id_reg_dept
	 */
	public void setId_reg_dept(String Id_reg_dept) {
		setAttrVal("Id_reg_dept", Id_reg_dept);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 核准人
	 * @return String
	 */
	public String getId_approve_oper() {
		return ((String) getAttrVal("Id_approve_oper"));
	}	
	/**
	 * 核准人
	 * @param Id_approve_oper
	 */
	public void setId_approve_oper(String Id_approve_oper) {
		setAttrVal("Id_approve_oper", Id_approve_oper);
	}
	/**
	 * 核准科室
	 * @return String
	 */
	public String getId_approve_dept() {
		return ((String) getAttrVal("Id_approve_dept"));
	}	
	/**
	 * 核准科室
	 * @param Id_approve_dept
	 */
	public void setId_approve_dept(String Id_approve_dept) {
		setAttrVal("Id_approve_dept", Id_approve_dept);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_approve() {
		return ((FDateTime) getAttrVal("Dt_approve"));
	}	
	/**
	 * 审核时间
	 * @param Dt_approve
	 */
	public void setDt_approve(FDateTime Dt_approve) {
		setAttrVal("Dt_approve", Dt_approve);
	}
	/**
	 * 作废人
	 * @return String
	 */
	public String getId_waste_oper() {
		return ((String) getAttrVal("Id_waste_oper"));
	}	
	/**
	 * 作废人
	 * @param Id_waste_oper
	 */
	public void setId_waste_oper(String Id_waste_oper) {
		setAttrVal("Id_waste_oper", Id_waste_oper);
	}
	/**
	 * 作废科室
	 * @return String
	 */
	public String getId_waste_dept() {
		return ((String) getAttrVal("Id_waste_dept"));
	}	
	/**
	 * 作废科室
	 * @param Id_waste_dept
	 */
	public void setId_waste_dept(String Id_waste_dept) {
		setAttrVal("Id_waste_dept", Id_waste_dept);
	}
	/**
	 * 作废时间
	 * @return FDateTime
	 */
	public FDateTime getDt_waste() {
		return ((FDateTime) getAttrVal("Dt_waste"));
	}	
	/**
	 * 作废时间
	 * @param Dt_waste
	 */
	public void setDt_waste(FDateTime Dt_waste) {
		setAttrVal("Dt_waste", Dt_waste);
	}
	/**
	 * 作废原因
	 * @return String
	 */
	public String getWaste_cause() {
		return ((String) getAttrVal("Waste_cause"));
	}	
	/**
	 * 作废原因
	 * @param Waste_cause
	 */
	public void setWaste_cause(String Waste_cause) {
		setAttrVal("Waste_cause", Waste_cause);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	/**
	 * 备注
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 设备分类
	 * @return String
	 */
	public String getId_emca() {
		return ((String) getAttrVal("Id_emca"));
	}	
	/**
	 * 设备分类
	 * @param Id_emca
	 */
	public void setId_emca(String Id_emca) {
		setAttrVal("Id_emca", Id_emca);
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
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	/**
	 * 集团
	 * @param Id_group
	 */
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	/**
	 * 财务年月
	 * @return String
	 */
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	/**
	 * 财务年月
	 * @param Year_month
	 */
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	/**
	 * 变更后折旧方式
	 * @return String
	 */
	public String getHind_detp() {
		return ((String) getAttrVal("Hind_detp"));
	}	
	/**
	 * 变更后折旧方式
	 * @param Hind_detp
	 */
	public void setHind_detp(String Hind_detp) {
		setAttrVal("Hind_detp", Hind_detp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 设备名称
	 * @return String
	 */
	public String getName_em() {
		return ((String) getAttrVal("Name_em"));
	}	
	/**
	 * 设备名称
	 * @param Name_em
	 */
	public void setName_em(String Name_em) {
		setAttrVal("Name_em", Name_em);
	}
	/**
	 * 设备编码
	 * @return String
	 */
	public String getCode_em() {
		return ((String) getAttrVal("Code_em"));
	}	
	/**
	 * 设备编码
	 * @param Code_em
	 */
	public void setCode_em(String Code_em) {
		setAttrVal("Code_em", Code_em);
	}
	/**
	 * 折旧名称
	 * @return String
	 */
	public String getName_detp() {
		return ((String) getAttrVal("Name_detp"));
	}	
	/**
	 * 折旧名称
	 * @param Name_detp
	 */
	public void setName_detp(String Name_detp) {
		setAttrVal("Name_detp", Name_detp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stor_level() {
		return ((String) getAttrVal("Name_stor_level"));
	}	
	/**
	 * 名称
	 * @param Name_stor_level
	 */
	public void setName_stor_level(String Name_stor_level) {
		setAttrVal("Name_stor_level", Name_stor_level);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stor_dept() {
		return ((String) getAttrVal("Name_stor_dept"));
	}	
	/**
	 * 名称
	 * @param Name_stor_dept
	 */
	public void setName_stor_dept(String Name_stor_dept) {
		setAttrVal("Name_stor_dept", Name_stor_dept);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_stor_oper() {
		return ((String) getAttrVal("Name_stor_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_stor_oper
	 */
	public void setName_stor_oper(String Name_stor_oper) {
		setAttrVal("Name_stor_oper", Name_stor_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stu() {
		return ((String) getAttrVal("Name_stu"));
	}	
	/**
	 * 名称
	 * @param Name_stu
	 */
	public void setName_stu(String Name_stu) {
		setAttrVal("Name_stu", Name_stu);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_apply_oper() {
		return ((String) getAttrVal("Name_apply_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_apply_oper
	 */
	public void setName_apply_oper(String Name_apply_oper) {
		setAttrVal("Name_apply_oper", Name_apply_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_apply_dept() {
		return ((String) getAttrVal("Name_apply_dept"));
	}	
	/**
	 * 名称
	 * @param Name_apply_dept
	 */
	public void setName_apply_dept(String Name_apply_dept) {
		setAttrVal("Name_apply_dept", Name_apply_dept);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getName_wh() {
		return ((String) getAttrVal("Name_wh"));
	}	
	/**
	 * 仓库名称
	 * @param Name_wh
	 */
	public void setName_wh(String Name_wh) {
		setAttrVal("Name_wh", Name_wh);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_reg_oper() {
		return ((String) getAttrVal("Name_reg_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_reg_oper
	 */
	public void setName_reg_oper(String Name_reg_oper) {
		setAttrVal("Name_reg_oper", Name_reg_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_reg_dept() {
		return ((String) getAttrVal("Name_reg_dept"));
	}	
	/**
	 * 名称
	 * @param Name_reg_dept
	 */
	public void setName_reg_dept(String Name_reg_dept) {
		setAttrVal("Name_reg_dept", Name_reg_dept);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_approve_oper() {
		return ((String) getAttrVal("Name_approve_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_approve_oper
	 */
	public void setName_approve_oper(String Name_approve_oper) {
		setAttrVal("Name_approve_oper", Name_approve_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_approve_dept() {
		return ((String) getAttrVal("Name_approve_dept"));
	}	
	/**
	 * 名称
	 * @param Name_approve_dept
	 */
	public void setName_approve_dept(String Name_approve_dept) {
		setAttrVal("Name_approve_dept", Name_approve_dept);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_waste_oper() {
		return ((String) getAttrVal("Name_waste_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_waste_oper
	 */
	public void setName_waste_oper(String Name_waste_oper) {
		setAttrVal("Name_waste_oper", Name_waste_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_wase_oper() {
		return ((String) getAttrVal("Name_wase_oper"));
	}	
	/**
	 * 名称
	 * @param Name_wase_oper
	 */
	public void setName_wase_oper(String Name_wase_oper) {
		setAttrVal("Name_wase_oper", Name_wase_oper);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_emca() {
		return ((String) getAttrVal("Code_emca"));
	}	
	/**
	 * 编码
	 * @param Code_emca
	 */
	public void setCode_emca(String Code_emca) {
		setAttrVal("Code_emca", Code_emca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_emca() {
		return ((String) getAttrVal("Name_emca"));
	}	
	/**
	 * 名称
	 * @param Name_emca
	 */
	public void setName_emca(String Name_emca) {
		setAttrVal("Name_emca", Name_emca);
	}
	/**
	 * 折旧名称
	 * @return String
	 */
	public String getHind_name() {
		return ((String) getAttrVal("Hind_name"));
	}	
	/**
	 * 折旧名称
	 * @param Hind_name
	 */
	public void setHind_name(String Hind_name) {
		setAttrVal("Hind_name", Hind_name);
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
		return "Id_adj";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_adj";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsAdjDODesc.class);
	}
	
}