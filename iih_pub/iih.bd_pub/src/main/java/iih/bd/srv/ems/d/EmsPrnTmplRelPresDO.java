package iih.bd.srv.ems.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ems.d.desc.EmsPrnTmplRelPresDODesc;
import java.math.BigDecimal;

/**
 * 医疗单打印模板关联处方类型 DO数据 
 * 
 */
public class EmsPrnTmplRelPresDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//打印模板关联处方主键标识
	public static final String ID_EMSPRNTMPLRELPRES= "Id_emsprntmplrelpres";
	//医疗单打印模板
	public static final String ID_EMSPRNTMPL= "Id_emsprntmpl";
	//处方类型
	public static final String ID_PRESTP= "Id_prestp";
	//处方类型编码
	public static final String SD_PRESTP= "Sd_prestp";
	//处方标识类型
	public static final String ID_PRESTPWORD= "Id_prestpword";
	//处方标识类型编码
	public static final String SD_PRESTPWORD= "Sd_prestpword";
	//增减项
	public static final String EU_DIRECT= "Eu_direct";
	//处方打印关联因素类型
	public static final String EU_PRESPRNRELFACTORTP= "Eu_presprnrelfactortp";
	//处方类型名称
	public static final String NAME_PRESTP= "Name_prestp";
	//处方标识类型名称
	public static final String PRESTPWORD_NAME= "Prestpword_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 打印模板关联处方主键标识
	 * @return String
	 */
	public String getId_emsprntmplrelpres() {
		return ((String) getAttrVal("Id_emsprntmplrelpres"));
	}	
	/**
	 * 打印模板关联处方主键标识
	 * @param Id_emsprntmplrelpres
	 */
	public void setId_emsprntmplrelpres(String Id_emsprntmplrelpres) {
		setAttrVal("Id_emsprntmplrelpres", Id_emsprntmplrelpres);
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
	 * 处方类型
	 * @return String
	 */
	public String getId_prestp() {
		return ((String) getAttrVal("Id_prestp"));
	}	
	/**
	 * 处方类型
	 * @param Id_prestp
	 */
	public void setId_prestp(String Id_prestp) {
		setAttrVal("Id_prestp", Id_prestp);
	}
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}	
	/**
	 * 处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 处方标识类型
	 * @return String
	 */
	public String getId_prestpword() {
		return ((String) getAttrVal("Id_prestpword"));
	}	
	/**
	 * 处方标识类型
	 * @param Id_prestpword
	 */
	public void setId_prestpword(String Id_prestpword) {
		setAttrVal("Id_prestpword", Id_prestpword);
	}
	/**
	 * 处方标识类型编码
	 * @return String
	 */
	public String getSd_prestpword() {
		return ((String) getAttrVal("Sd_prestpword"));
	}	
	/**
	 * 处方标识类型编码
	 * @param Sd_prestpword
	 */
	public void setSd_prestpword(String Sd_prestpword) {
		setAttrVal("Sd_prestpword", Sd_prestpword);
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
	 * 处方打印关联因素类型
	 * @return String
	 */
	public String getEu_presprnrelfactortp() {
		return ((String) getAttrVal("Eu_presprnrelfactortp"));
	}	
	/**
	 * 处方打印关联因素类型
	 * @param Eu_presprnrelfactortp
	 */
	public void setEu_presprnrelfactortp(String Eu_presprnrelfactortp) {
		setAttrVal("Eu_presprnrelfactortp", Eu_presprnrelfactortp);
	}
	/**
	 * 处方类型名称
	 * @return String
	 */
	public String getName_prestp() {
		return ((String) getAttrVal("Name_prestp"));
	}	
	/**
	 * 处方类型名称
	 * @param Name_prestp
	 */
	public void setName_prestp(String Name_prestp) {
		setAttrVal("Name_prestp", Name_prestp);
	}
	/**
	 * 处方标识类型名称
	 * @return String
	 */
	public String getPrestpword_name() {
		return ((String) getAttrVal("Prestpword_name"));
	}	
	/**
	 * 处方标识类型名称
	 * @param Prestpword_name
	 */
	public void setPrestpword_name(String Prestpword_name) {
		setAttrVal("Prestpword_name", Prestpword_name);
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
		return "Id_emsprntmplrelpres";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_ems_prntmpl_relpres";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsPrnTmplRelPresDODesc.class);
	}
	
}