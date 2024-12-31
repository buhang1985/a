package iih.bl.st.dto.bloepcharge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊调入互斥信息 DTO数据 
 * 
 */
public class BlOepMutexInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 互斥信息
	 * @return String
	 */
	public String getMutex_note() {
		return ((String) getAttrVal("Mutex_note"));
	}
	/**
	 * 互斥信息
	 * @param Mutex_note
	 */
	public void setMutex_note(String Mutex_note) {
		setAttrVal("Mutex_note", Mutex_note);
	}
	/**
	 * 医嘱服务id集合
	 * @return FArrayList
	 */
	public FArrayList getId_orsrv() {
		return ((FArrayList) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务id集合
	 * @param Id_orsrv
	 */
	public void setId_orsrv(FArrayList Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 记账明细id集合
	 * @return FArrayList
	 */
	public FArrayList getId_cgitm() {
		return ((FArrayList) getAttrVal("Id_cgitm"));
	}
	/**
	 * 记账明细id集合
	 * @param Id_cgitm
	 */
	public void setId_cgitm(FArrayList Id_cgitm) {
		setAttrVal("Id_cgitm", Id_cgitm);
	}
}