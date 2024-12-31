package iih.en.que.empque.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.que.empque.d.desc.EnQueEmpDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊_队列医生 DO数据 
 * 
 */
public class EnQueEmpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//id主键
	public static final String ID_QUEEMP= "Id_queemp";
	//出诊队列id
	public static final String ID_QUE= "Id_que";
	//出诊医生id
	public static final String ID_EMP= "Id_emp";
	//出诊日期
	public static final String D_QUE= "D_que";
	//出诊午别
	public static final String ID_DAYSLOT= "Id_dayslot";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//停诊
	public static final String FG_STOP= "Fg_stop";
	//出诊队列编码
	public static final String CODE_QUE= "Code_que";
	//出诊队列名称
	public static final String NAME_QUE= "Name_que";
	//出诊医生编码
	public static final String CODE_EMP= "Code_emp";
	//出诊医生姓名
	public static final String NAME_EMP= "Name_emp";
	//出诊午别编码
	public static final String CODE_DAYSLOT= "Code_dayslot";
	//出诊午别名称
	public static final String NAME_DAYSLOT= "Name_dayslot";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * id主键
	 * @return String
	 */
	public String getId_queemp() {
		return ((String) getAttrVal("Id_queemp"));
	}	
	/**
	 * id主键
	 * @param Id_queemp
	 */
	public void setId_queemp(String Id_queemp) {
		setAttrVal("Id_queemp", Id_queemp);
	}
	/**
	 * 出诊队列id
	 * @return String
	 */
	public String getId_que() {
		return ((String) getAttrVal("Id_que"));
	}	
	/**
	 * 出诊队列id
	 * @param Id_que
	 */
	public void setId_que(String Id_que) {
		setAttrVal("Id_que", Id_que);
	}
	/**
	 * 出诊医生id
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 出诊医生id
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 出诊日期
	 * @return FDate
	 */
	public FDate getD_que() {
		return ((FDate) getAttrVal("D_que"));
	}	
	/**
	 * 出诊日期
	 * @param D_que
	 */
	public void setD_que(FDate D_que) {
		setAttrVal("D_que", D_que);
	}
	/**
	 * 出诊午别
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}	
	/**
	 * 出诊午别
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
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
	 * 停诊
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}	
	/**
	 * 停诊
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 出诊队列编码
	 * @return String
	 */
	public String getCode_que() {
		return ((String) getAttrVal("Code_que"));
	}	
	/**
	 * 出诊队列编码
	 * @param Code_que
	 */
	public void setCode_que(String Code_que) {
		setAttrVal("Code_que", Code_que);
	}
	/**
	 * 出诊队列名称
	 * @return String
	 */
	public String getName_que() {
		return ((String) getAttrVal("Name_que"));
	}	
	/**
	 * 出诊队列名称
	 * @param Name_que
	 */
	public void setName_que(String Name_que) {
		setAttrVal("Name_que", Name_que);
	}
	/**
	 * 出诊医生编码
	 * @return String
	 */
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}	
	/**
	 * 出诊医生编码
	 * @param Code_emp
	 */
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}
	/**
	 * 出诊医生姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	/**
	 * 出诊医生姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 出诊午别编码
	 * @return String
	 */
	public String getCode_dayslot() {
		return ((String) getAttrVal("Code_dayslot"));
	}	
	/**
	 * 出诊午别编码
	 * @param Code_dayslot
	 */
	public void setCode_dayslot(String Code_dayslot) {
		setAttrVal("Code_dayslot", Code_dayslot);
	}
	/**
	 * 出诊午别名称
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}	
	/**
	 * 出诊午别名称
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
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
		return "Id_queemp";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_QUE_EMP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnQueEmpDODesc.class);
	}
	
}