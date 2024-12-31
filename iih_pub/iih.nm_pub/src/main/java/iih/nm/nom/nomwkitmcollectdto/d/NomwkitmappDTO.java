package iih.nm.nom.nomwkitmcollectdto.d;

import xap.mw.core.data.BaseDTO;

/**
 * 护理工作量统计 DTO数据 
 * 
 */
public class NomwkitmappDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 工作量项目id
	 * @return String
	 */
	public String getId_nom_wkitm_app_itm() {
		return ((String) getAttrVal("Id_nom_wkitm_app_itm"));
	}
	/**
	 * 工作量项目id
	 * @param Id_nom_wkitm_app_itm
	 */
	public void setId_nom_wkitm_app_itm(String Id_nom_wkitm_app_itm) {
		setAttrVal("Id_nom_wkitm_app_itm", Id_nom_wkitm_app_itm);
	}
	/**
	 * 工作量数目
	 * @return String
	 */
	public String getCo() {
		return ((String) getAttrVal("Co"));
	}
	/**
	 * 工作量数目
	 * @param Co
	 */
	public void setCo(String Co) {
		setAttrVal("Co", Co);
	}
	/**
	 * 工作量项目名称
	 * @return String
	 */
	public String getName_nom_wkitm() {
		return ((String) getAttrVal("Name_nom_wkitm"));
	}
	/**
	 * 工作量项目名称
	 * @param Name_nom_wkitm
	 */
	public void setName_nom_wkitm(String Name_nom_wkitm) {
		setAttrVal("Name_nom_wkitm", Name_nom_wkitm);
	}
	/**
	 * 顺序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 顺序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 工作量分组Id
	 * @return String
	 */
	public String getId_wkitm_grp() {
		return ((String) getAttrVal("Id_wkitm_grp"));
	}
	/**
	 * 工作量分组Id
	 * @param Id_wkitm_grp
	 */
	public void setId_wkitm_grp(String Id_wkitm_grp) {
		setAttrVal("Id_wkitm_grp", Id_wkitm_grp);
	}
	/**
	 * 工作量分组名称
	 * @return String
	 */
	public String getName_wkitm_grp() {
		return ((String) getAttrVal("Name_wkitm_grp"));
	}
	/**
	 * 工作量分组名称
	 * @param Name_wkitm_grp
	 */
	public void setName_wkitm_grp(String Name_wkitm_grp) {
		setAttrVal("Name_wkitm_grp", Name_wkitm_grp);
	}
	/**
	 * 就诊id集合
	 * @return String
	 */
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}
	/**
	 * 就诊id集合
	 * @param Ctrl1
	 */
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	/**
	 * 人次/人数
	 * @return String
	 */
	public String getPsn_type() {
		return ((String) getAttrVal("Psn_type"));
	}
	/**
	 * 人次/人数
	 * @param Psn_type
	 */
	public void setPsn_type(String Psn_type) {
		setAttrVal("Psn_type", Psn_type);
	}
}