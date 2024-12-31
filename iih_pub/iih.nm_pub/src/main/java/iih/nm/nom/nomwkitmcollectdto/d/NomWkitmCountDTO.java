package iih.nm.nom.nomwkitmcollectdto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDouble;

/**
 * 类型与对应数量 DTO数据 
 * 
 */
public class NomWkitmCountDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 类型对应数目Id
	 * @return String
	 */
	public String getId_nom_wkitmcount() {
		return ((String) getAttrVal("Id_nom_wkitmcount"));
	}
	/**
	 * 类型对应数目Id
	 * @param Id_nom_wkitmcount
	 */
	public void setId_nom_wkitmcount(String Id_nom_wkitmcount) {
		setAttrVal("Id_nom_wkitmcount", Id_nom_wkitmcount);
	}
	/**
	 * 类型编码
	 * @return String
	 */
	public String getSd_type() {
		return ((String) getAttrVal("Sd_type"));
	}
	/**
	 * 类型编码
	 * @param Sd_type
	 */
	public void setSd_type(String Sd_type) {
		setAttrVal("Sd_type", Sd_type);
	}
	/**
	 * 工作量数目
	 * @return Integer
	 */
	public Integer getCount() {
		return ((Integer) getAttrVal("Count"));
	}
	/**
	 * 工作量数目
	 * @param Count
	 */
	public void setCount(Integer Count) {
		setAttrVal("Count", Count);
	}
	/**
	 * 类型Id
	 * @return String
	 */
	public String getId_type() {
		return ((String) getAttrVal("Id_type"));
	}
	/**
	 * 类型Id
	 * @param Id_type
	 */
	public void setId_type(String Id_type) {
		setAttrVal("Id_type", Id_type);
	}
	/**
	 * 就诊Id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊Id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 计量数目
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 计量数目
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
}