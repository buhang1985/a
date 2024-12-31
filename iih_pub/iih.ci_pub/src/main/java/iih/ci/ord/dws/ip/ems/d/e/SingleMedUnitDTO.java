package iih.ci.ord.dws.ip.ems.d.e;


import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;

/**
 * 计量单位信息
 * @author liuxiaoying
 *
 */
public class SingleMedUnitDTO extends BaseDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2785211825062839630L;
	public SingleMedUnitDTO(){
		this.setStatus(DOStatus.NEW);
	}

	/**
	 * 单位ID
	 * @return String
	 */
	public String getId_measdoc() {
		return ((String) getAttrVal("Id_measdoc"));
	}
	/**
	 * 单位ID
	 * @param Id_measdoc
	 */
	public void setId_measdoc(String Id_measdoc) {
		setAttrVal("Id_measdoc", Id_measdoc);
	}
	
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_measdoc() {
		return ((String) getAttrVal("Name_measdoc"));
	}
	/**
	 * 单位名称
	 * @param Name_measdoc
	 */
	public void setName_measdoc(String Name_measdoc) {
		setAttrVal("Name_measdoc", Name_measdoc);
	}
	
	/**
	 * 换算系数
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}
	/**
	 * 换算系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	
	
}
