package iih.bl.st.dto.bloepcharge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收费精确调入条件 DTO数据 
 * 
 */
public class BlOepChargeAccurateCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱id集合
	 * @return FArrayList
	 */
	public FArrayList getId_or() {
		return ((FArrayList) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id集合
	 * @param Id_or
	 */
	public void setId_or(FArrayList Id_or) {
		setAttrVal("Id_or", Id_or);
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