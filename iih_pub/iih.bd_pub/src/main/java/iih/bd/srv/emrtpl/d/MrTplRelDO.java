package iih.bd.srv.emrtpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emrtpl.d.desc.MrTplRelDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录模板适用条件 DO数据 
 * 
 */
public class MrTplRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗记录疾病主键标识
	public static final String ID_MRTPLDIREL= "Id_mrtpldirel";
	//医疗记录模板
	public static final String ID_MRTPL= "Id_mrtpl";
	//疾病诊断
	public static final String ID_DI= "Id_di";
	//描述
	public static final String DES= "Des";
	//医疗记录类型
	public static final String ID_MRTP= "Id_mrtp";
	//医疗记录模板名称
	public static final String NAME= "Name";
	//诊断编码
	public static final String DI_CODE= "Di_code";
	//诊断名称
	public static final String DI_NAME= "Di_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗记录疾病主键标识
	 * @return String
	 */
	public String getId_mrtpldirel() {
		return ((String) getAttrVal("Id_mrtpldirel"));
	}	
	/**
	 * 医疗记录疾病主键标识
	 * @param Id_mrtpldirel
	 */
	public void setId_mrtpldirel(String Id_mrtpldirel) {
		setAttrVal("Id_mrtpldirel", Id_mrtpldirel);
	}
	/**
	 * 医疗记录模板
	 * @return String
	 */
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}	
	/**
	 * 医疗记录模板
	 * @param Id_mrtpl
	 */
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
	}
	/**
	 * 疾病诊断
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	/**
	 * 疾病诊断
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 医疗记录类型
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	/**
	 * 医疗记录类型
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 医疗记录模板名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 医疗记录模板名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDi_code() {
		return ((String) getAttrVal("Di_code"));
	}	
	/**
	 * 诊断编码
	 * @param Di_code
	 */
	public void setDi_code(String Di_code) {
		setAttrVal("Di_code", Di_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}	
	/**
	 * 诊断名称
	 * @param Di_name
	 */
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
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
		return "Id_mrtpldirel";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrtpl_di_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrTplRelDODesc.class);
	}
	
}