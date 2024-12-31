package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvNurseDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务护理属性 DO数据 
 * 
 */
public class MedSrvNurseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗服务护理属性主键标识
	public static final String ID_SRVNU= "Id_srvnu";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属医疗服务
	public static final String ID_SRV= "Id_srv";
	//服务名称
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗服务护理属性主键标识
	 * @return String
	 */
	public String getId_srvnu() {
		return ((String) getAttrVal("Id_srvnu"));
	}	
	/**
	 * 医疗服务护理属性主键标识
	 * @param Id_srvnu
	 */
	public void setId_srvnu(String Id_srvnu) {
		setAttrVal("Id_srvnu", Id_srvnu);
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
	 * 所属医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 所属医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 服务名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_srvnu";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_nu";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvNurseDODesc.class);
	}
	
}