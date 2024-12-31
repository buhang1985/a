package iih.bd.srv.srvrtctl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvrtctl.d.desc.SrvRtItmDODesc;
import java.math.BigDecimal;

/**
 * 服务开立权限项目 DO数据 
 * 
 */
public class SrvRtItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//开立权限项目主键标识
	public static final String ID_SRVRTITM= "Id_srvrtitm";
	//开立权限
	public static final String ID_SRVRT= "Id_srvrt";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//服务类型名称
	public static final String NAME_SRVTP= "Name_srvtp";
	//医疗物品
	public static final String ID_MM= "Id_mm";
	//服务开立权限编码
	public static final String IDSRVITMCODE= "Idsrvitmcode";
	//服务开立权限名称
	public static final String IDSRVITMNAME= "Idsrvitmname";
	//服务编码
	public static final String IDSRVCODE= "Idsrvcode";
	//服务名称
	public static final String IDSRVNAME= "Idsrvname";
	//服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//医疗物品标识
	public static final String FG_MM= "Fg_mm";
	//药品商品名
	public static final String NAME_MM= "Name_mm";
	//药品商品编码
	public static final String CODE_MM= "Code_mm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 开立权限项目主键标识
	 * @return String
	 */
	public String getId_srvrtitm() {
		return ((String) getAttrVal("Id_srvrtitm"));
	}	
	/**
	 * 开立权限项目主键标识
	 * @param Id_srvrtitm
	 */
	public void setId_srvrtitm(String Id_srvrtitm) {
		setAttrVal("Id_srvrtitm", Id_srvrtitm);
	}
	/**
	 * 开立权限
	 * @return String
	 */
	public String getId_srvrt() {
		return ((String) getAttrVal("Id_srvrt"));
	}	
	/**
	 * 开立权限
	 * @param Id_srvrt
	 */
	public void setId_srvrt(String Id_srvrt) {
		setAttrVal("Id_srvrt", Id_srvrt);
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
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务类型名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 服务类型名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 医疗物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 医疗物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 服务开立权限编码
	 * @return String
	 */
	public String getIdsrvitmcode() {
		return ((String) getAttrVal("Idsrvitmcode"));
	}	
	/**
	 * 服务开立权限编码
	 * @param Idsrvitmcode
	 */
	public void setIdsrvitmcode(String Idsrvitmcode) {
		setAttrVal("Idsrvitmcode", Idsrvitmcode);
	}
	/**
	 * 服务开立权限名称
	 * @return String
	 */
	public String getIdsrvitmname() {
		return ((String) getAttrVal("Idsrvitmname"));
	}	
	/**
	 * 服务开立权限名称
	 * @param Idsrvitmname
	 */
	public void setIdsrvitmname(String Idsrvitmname) {
		setAttrVal("Idsrvitmname", Idsrvitmname);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getIdsrvcode() {
		return ((String) getAttrVal("Idsrvcode"));
	}	
	/**
	 * 服务编码
	 * @param Idsrvcode
	 */
	public void setIdsrvcode(String Idsrvcode) {
		setAttrVal("Idsrvcode", Idsrvcode);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getIdsrvname() {
		return ((String) getAttrVal("Idsrvname"));
	}	
	/**
	 * 服务名称
	 * @param Idsrvname
	 */
	public void setIdsrvname(String Idsrvname) {
		setAttrVal("Idsrvname", Idsrvname);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医疗物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	/**
	 * 医疗物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 药品商品名
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 药品商品名
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 药品商品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	/**
	 * 药品商品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
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
		return "Id_srvrtitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_rt_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvRtItmDODesc.class);
	}
	
}