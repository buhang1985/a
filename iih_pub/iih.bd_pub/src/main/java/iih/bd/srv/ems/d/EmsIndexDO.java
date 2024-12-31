package iih.bd.srv.ems.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ems.d.desc.EmsIndexDODesc;
import java.math.BigDecimal;

/**
 * 医疗单关联的指标项 DO数据 
 * 
 */
public class EmsIndexDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗单动态指标主键标识
	public static final String ID_SRVOFDYNCITM= "Id_srvofdyncitm";
	//医疗单
	public static final String ID_SRVOF= "Id_srvof";
	//指标服务
	public static final String ID_SRV= "Id_srv";
	//指标名称
	public static final String NAME_DISP= "Name_disp";
	//序号
	public static final String SORTNO= "Sortno";
	//允许为空标识
	public static final String FG_ALLOWEMPTY= "Fg_allowempty";
	//服务名称
	public static final String SRVNAME= "Srvname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗单动态指标主键标识
	 * @return String
	 */
	public String getId_srvofdyncitm() {
		return ((String) getAttrVal("Id_srvofdyncitm"));
	}	
	/**
	 * 医疗单动态指标主键标识
	 * @param Id_srvofdyncitm
	 */
	public void setId_srvofdyncitm(String Id_srvofdyncitm) {
		setAttrVal("Id_srvofdyncitm", Id_srvofdyncitm);
	}
	/**
	 * 医疗单
	 * @return String
	 */
	public String getId_srvof() {
		return ((String) getAttrVal("Id_srvof"));
	}	
	/**
	 * 医疗单
	 * @param Id_srvof
	 */
	public void setId_srvof(String Id_srvof) {
		setAttrVal("Id_srvof", Id_srvof);
	}
	/**
	 * 指标服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 指标服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 指标名称
	 * @return String
	 */
	public String getName_disp() {
		return ((String) getAttrVal("Name_disp"));
	}	
	/**
	 * 指标名称
	 * @param Name_disp
	 */
	public void setName_disp(String Name_disp) {
		setAttrVal("Name_disp", Name_disp);
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
	 * 允许为空标识
	 * @return FBoolean
	 */
	public FBoolean getFg_allowempty() {
		return ((FBoolean) getAttrVal("Fg_allowempty"));
	}	
	/**
	 * 允许为空标识
	 * @param Fg_allowempty
	 */
	public void setFg_allowempty(FBoolean Fg_allowempty) {
		setAttrVal("Fg_allowempty", Fg_allowempty);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}	
	/**
	 * 服务名称
	 * @param Srvname
	 */
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
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
		return "Id_srvofdyncitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_of_dyncitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsIndexDODesc.class);
	}
	
}