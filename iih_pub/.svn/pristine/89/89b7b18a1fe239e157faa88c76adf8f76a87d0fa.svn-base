package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvExecDeptDODesc;
import java.math.BigDecimal;

/**
 * 服务项目的执行科室 DO数据 
 * 
 */
public class MedSrvExecDeptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务项目执行科室
	public static final String ID_SRVDEPMPREF= "Id_srvdepmpref";
	//服务
	public static final String ID_SRV= "Id_srv";
	//序号
	public static final String SORTNO= "Sortno";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//名称
	public static final String DEPT_NAME= "Dept_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 服务项目执行科室
	 * @return String
	 */
	public String getId_srvdepmpref() {
		return ((String) getAttrVal("Id_srvdepmpref"));
	}	
	/**
	 * 服务项目执行科室
	 * @param Id_srvdepmpref
	 */
	public void setId_srvdepmpref(String Id_srvdepmpref) {
		setAttrVal("Id_srvdepmpref", Id_srvdepmpref);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	/**
	 * 名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
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
		return "Id_srvdepmpref";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_depmp_ref";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvExecDeptDODesc.class);
	}
	
}