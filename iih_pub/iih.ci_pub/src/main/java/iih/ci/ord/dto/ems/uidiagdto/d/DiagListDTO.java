package iih.ci.ord.dto.ems.uidiagdto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

public class DiagListDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 诊断ID
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 诊断ID
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 西医诊断
	 * @return FArrayList
	 */
	public FArrayList getWestDiagList() {
		return ((FArrayList) getAttrVal("WestDiagList"));
	}
	/**
	 * 西医诊断
	 * @param WestDiagList
	 */
	public void setWestDiagList(FArrayList WestDiagList) {
		setAttrVal("WestDiagList", WestDiagList);
	}
	/**
	 * 中医诊断
	 * @return FArrayList
	 */
	public FArrayList getChineseDiagList() {
		return ((FArrayList) getAttrVal("ChineseDiagList"));
	}
	/**
	 * 中医诊断
	 * @param ChineseDiagList
	 */
	public void setChineseDiagList(FArrayList ChineseDiagList) {
		setAttrVal("ChineseDiagList", ChineseDiagList);
	}
}
