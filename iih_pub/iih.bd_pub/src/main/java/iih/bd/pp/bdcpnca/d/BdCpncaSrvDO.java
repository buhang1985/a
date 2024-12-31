package iih.bd.pp.bdcpnca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.bdcpnca.d.desc.BdCpncaSrvDODesc;
import java.math.BigDecimal;

/**
 * 优惠券分类_服务 DO数据 
 * 
 */
public class BdCpncaSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//优惠券分类服务主键
	public static final String ID_CPNSRV= "Id_cpnsrv";
	//优惠券分类
	public static final String ID_CPNCA= "Id_cpnca";
	//服务
	public static final String ID_SRV= "Id_srv";
	//可选标志
	public static final String FG_OPTION= "Fg_option";
	//优惠券分类的编码
	public static final String CPNCACODE= "Cpncacode";
	//优惠券分类的名称
	public static final String CPNCANAME= "Cpncaname";
	//服务编码
	public static final String SRVCODE= "Srvcode";
	//服务名称
	public static final String SRVNAME= "Srvname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 优惠券分类服务主键
	 * @return String
	 */
	public String getId_cpnsrv() {
		return ((String) getAttrVal("Id_cpnsrv"));
	}	
	/**
	 * 优惠券分类服务主键
	 * @param Id_cpnsrv
	 */
	public void setId_cpnsrv(String Id_cpnsrv) {
		setAttrVal("Id_cpnsrv", Id_cpnsrv);
	}
	/**
	 * 优惠券分类
	 * @return String
	 */
	public String getId_cpnca() {
		return ((String) getAttrVal("Id_cpnca"));
	}	
	/**
	 * 优惠券分类
	 * @param Id_cpnca
	 */
	public void setId_cpnca(String Id_cpnca) {
		setAttrVal("Id_cpnca", Id_cpnca);
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
	 * 可选标志
	 * @return FBoolean
	 */
	public FBoolean getFg_option() {
		return ((FBoolean) getAttrVal("Fg_option"));
	}	
	/**
	 * 可选标志
	 * @param Fg_option
	 */
	public void setFg_option(FBoolean Fg_option) {
		setAttrVal("Fg_option", Fg_option);
	}
	/**
	 * 优惠券分类的编码
	 * @return String
	 */
	public String getCpncacode() {
		return ((String) getAttrVal("Cpncacode"));
	}	
	/**
	 * 优惠券分类的编码
	 * @param Cpncacode
	 */
	public void setCpncacode(String Cpncacode) {
		setAttrVal("Cpncacode", Cpncacode);
	}
	/**
	 * 优惠券分类的名称
	 * @return String
	 */
	public String getCpncaname() {
		return ((String) getAttrVal("Cpncaname"));
	}	
	/**
	 * 优惠券分类的名称
	 * @param Cpncaname
	 */
	public void setCpncaname(String Cpncaname) {
		setAttrVal("Cpncaname", Cpncaname);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrvcode() {
		return ((String) getAttrVal("Srvcode"));
	}	
	/**
	 * 服务编码
	 * @param Srvcode
	 */
	public void setSrvcode(String Srvcode) {
		setAttrVal("Srvcode", Srvcode);
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
		return "Id_cpnsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "Bd_Cpnca_Srv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdCpncaSrvDODesc.class);
	}
	
}