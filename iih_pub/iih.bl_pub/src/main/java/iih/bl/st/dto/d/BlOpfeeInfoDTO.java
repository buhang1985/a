package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class BlOpfeeInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 收费信息
	 * @return FArrayList2
	 */
	public FArrayList2 getBlopfeeoutfiledto() {
		return ((FArrayList2) getAttrVal("Blopfeeoutfiledto"));
	}
	/**
	 * 收费信息
	 * @param Blopfeeoutfiledto
	 */
	public void setBlopfeeoutfiledto(FArrayList2 Blopfeeoutfiledto) {
		setAttrVal("Blopfeeoutfiledto", Blopfeeoutfiledto);
	}
	/**
	 * 处方信息
	 * @return FArrayList2
	 */
	public FArrayList2 getBlstpresinfodtoarr() {
		return ((FArrayList2) getAttrVal("Blstpresinfodtoarr"));
	}
	/**
	 * 处方信息
	 * @param Blstpresinfodtoarr
	 */
	public void setBlstpresinfodtoarr(FArrayList2 Blstpresinfodtoarr) {
		setAttrVal("Blstpresinfodtoarr", Blstpresinfodtoarr);
	}
	/**
	 * 费用明细
	 * @return FArrayList2
	 */
	public FArrayList2 getBlstcginfodtoarr() {
		return ((FArrayList2) getAttrVal("Blstcginfodtoarr"));
	}
	/**
	 * 费用明细
	 * @param Blstcginfodtoarr
	 */
	public void setBlstcginfodtoarr(FArrayList2 Blstcginfodtoarr) {
		setAttrVal("Blstcginfodtoarr", Blstcginfodtoarr);
	}
	/**
	 * 退费信息
	 * @return FArrayList2
	 */
	public FArrayList2 getBlstrefundinfodtoarr() {
		return ((FArrayList2) getAttrVal("Blstrefundinfodtoarr"));
	}
	/**
	 * 退费信息
	 * @param Blstrefundinfodtoarr
	 */
	public void setBlstrefundinfodtoarr(FArrayList2 Blstrefundinfodtoarr) {
		setAttrVal("Blstrefundinfodtoarr", Blstrefundinfodtoarr);
	}
}