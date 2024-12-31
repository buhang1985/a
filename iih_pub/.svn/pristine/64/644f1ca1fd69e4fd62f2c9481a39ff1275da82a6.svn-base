package iih.bd.srv.ems.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ems.d.desc.EmsPrnTmplRelSrvDODesc;
import java.math.BigDecimal;

/**
 * 医疗单打印模板关联服务 DO数据 
 * 
 */
public class EmsPrnTmplRelSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//打印模板关联服务主键标识
	public static final String ID_EMSPRNTMPLRELSRV= "Id_emsprntmplrelsrv";
	//医疗单打印模板
	public static final String ID_EMSPRNTMPL= "Id_emsprntmpl";
	//关联类型
	public static final String EU_OFREFTP= "Eu_ofreftp";
	//服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务
	public static final String ID_SRV= "Id_srv";
	//增减项
	public static final String EU_DIRECT= "Eu_direct";
	//服务类型
	public static final String SRVTP_NAME= "Srvtp_name";
	//服务名称
	public static final String SRVNAME= "Srvname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 打印模板关联服务主键标识
	 * @return String
	 */
	public String getId_emsprntmplrelsrv() {
		return ((String) getAttrVal("Id_emsprntmplrelsrv"));
	}	
	/**
	 * 打印模板关联服务主键标识
	 * @param Id_emsprntmplrelsrv
	 */
	public void setId_emsprntmplrelsrv(String Id_emsprntmplrelsrv) {
		setAttrVal("Id_emsprntmplrelsrv", Id_emsprntmplrelsrv);
	}
	/**
	 * 医疗单打印模板
	 * @return String
	 */
	public String getId_emsprntmpl() {
		return ((String) getAttrVal("Id_emsprntmpl"));
	}	
	/**
	 * 医疗单打印模板
	 * @param Id_emsprntmpl
	 */
	public void setId_emsprntmpl(String Id_emsprntmpl) {
		setAttrVal("Id_emsprntmpl", Id_emsprntmpl);
	}
	/**
	 * 关联类型
	 * @return String
	 */
	public String getEu_ofreftp() {
		return ((String) getAttrVal("Eu_ofreftp"));
	}	
	/**
	 * 关联类型
	 * @param Eu_ofreftp
	 */
	public void setEu_ofreftp(String Eu_ofreftp) {
		setAttrVal("Eu_ofreftp", Eu_ofreftp);
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
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
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
	 * 增减项
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 增减项
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	/**
	 * 服务类型
	 * @param Srvtp_name
	 */
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
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
		return "Id_emsprntmplrelsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_ems_prntmpl_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsPrnTmplRelSrvDODesc.class);
	}
	
}