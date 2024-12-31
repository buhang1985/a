package iih.mp.nr.foreign.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体征模板明细 DTO数据 
 * 
 */
public class TemplateDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 模板名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 模板名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 医疗记录模板ID
	 * @return String
	 */
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}
	/**
	 * 医疗记录模板ID
	 * @param Id_mrtpl
	 */
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
	}
	/**
	 * 测量项目模板ID
	 * @return String
	 */
	public String getId_mrtplvt() {
		return ((String) getAttrVal("Id_mrtplvt"));
	}
	/**
	 * 测量项目模板ID
	 * @param Id_mrtplvt
	 */
	public void setId_mrtplvt(String Id_mrtplvt) {
		setAttrVal("Id_mrtplvt", Id_mrtplvt);
	}
	/**
	 * 测量项目模板编码
	 * @return String
	 */
	public String getCode_mrtplvt() {
		return ((String) getAttrVal("Code_mrtplvt"));
	}
	/**
	 * 测量项目模板编码
	 * @param Code_mrtplvt
	 */
	public void setCode_mrtplvt(String Code_mrtplvt) {
		setAttrVal("Code_mrtplvt", Code_mrtplvt);
	}
	/**
	 * 测量项目ID
	 * @return String
	 */
	public String getId_mrtplvtitm() {
		return ((String) getAttrVal("Id_mrtplvtitm"));
	}
	/**
	 * 测量项目ID
	 * @param Id_mrtplvtitm
	 */
	public void setId_mrtplvtitm(String Id_mrtplvtitm) {
		setAttrVal("Id_mrtplvtitm", Id_mrtplvtitm);
	}
	/**
	 * 服务项目ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 生命体征项目编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 生命体征项目编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 下限值
	 * @return FDouble
	 */
	public FDouble getValmin() {
		return ((FDouble) getAttrVal("Valmin"));
	}
	/**
	 * 下限值
	 * @param Valmin
	 */
	public void setValmin(FDouble Valmin) {
		setAttrVal("Valmin", Valmin);
	}
	/**
	 * 上限值
	 * @return FDouble
	 */
	public FDouble getValmax() {
		return ((FDouble) getAttrVal("Valmax"));
	}
	/**
	 * 上限值
	 * @param Valmax
	 */
	public void setValmax(FDouble Valmax) {
		setAttrVal("Valmax", Valmax);
	}
}