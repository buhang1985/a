package iih.mm.bl.blreserve.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.bl.blreserve.d.desc.StockBlReserveDODesc;
import java.math.BigDecimal;

/**
 * 物品结存预留处理表 DO数据 
 * 
 */
public class StockBlReserveDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//结存预留主键
	public static final String ID_RSV= "Id_rsv";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//仓库主键
	public static final String ID_WH= "Id_wh";
	//物品主键
	public static final String ID_MM= "Id_mm";
	//请求量单位
	public static final String REQ_UNIT_ID= "Req_unit_id";
	//服务条目ID
	public static final String ID_ORSRV= "Id_orsrv";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//操作类型
	public static final String EN_OPERTYPE= "En_opertype";
	//操作人员
	public static final String ID_EMP_OPE= "Id_emp_ope";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//取消人员姓名
	public static final String EMP_CANCEL_NAME= "Emp_cancel_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 结存预留主键
	 * @return String
	 */
	public String getId_rsv() {
		return ((String) getAttrVal("Id_rsv"));
	}	
	/**
	 * 结存预留主键
	 * @param Id_rsv
	 */
	public void setId_rsv(String Id_rsv) {
		setAttrVal("Id_rsv", Id_rsv);
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
	 * 仓库主键
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库主键
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 请求量单位
	 * @return String
	 */
	public String getReq_unit_id() {
		return ((String) getAttrVal("Req_unit_id"));
	}	
	/**
	 * 请求量单位
	 * @param Req_unit_id
	 */
	public void setReq_unit_id(String Req_unit_id) {
		setAttrVal("Req_unit_id", Req_unit_id);
	}
	/**
	 * 服务条目ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	/**
	 * 服务条目ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 操作类型
	 * @return Integer
	 */
	public Integer getEn_opertype() {
		return ((Integer) getAttrVal("En_opertype"));
	}	
	/**
	 * 操作类型
	 * @param En_opertype
	 */
	public void setEn_opertype(Integer En_opertype) {
		setAttrVal("En_opertype", En_opertype);
	}
	/**
	 * 操作人员
	 * @return String
	 */
	public String getId_emp_ope() {
		return ((String) getAttrVal("Id_emp_ope"));
	}	
	/**
	 * 操作人员
	 * @param Id_emp_ope
	 */
	public void setId_emp_ope(String Id_emp_ope) {
		setAttrVal("Id_emp_ope", Id_emp_ope);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
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
	 * 取消人员姓名
	 * @return String
	 */
	public String getEmp_cancel_name() {
		return ((String) getAttrVal("Emp_cancel_name"));
	}	
	/**
	 * 取消人员姓名
	 * @param Emp_cancel_name
	 */
	public void setEmp_cancel_name(String Emp_cancel_name) {
		setAttrVal("Emp_cancel_name", Emp_cancel_name);
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
		return "Id_rsv";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_BL_RESERVE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockBlReserveDODesc.class);
	}
	
}