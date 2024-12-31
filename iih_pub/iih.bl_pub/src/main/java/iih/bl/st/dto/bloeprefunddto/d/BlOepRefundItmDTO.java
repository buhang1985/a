package iih.bl.st.dto.bloeprefunddto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊退费明细(接口入参) DTO数据 
 * 
 */
public class BlOepRefundItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记账主键
	 * @return String
	 */
	public String getId_cgitm() {
		return ((String) getAttrVal("Id_cgitm"));
	}
	/**
	 * 记账主键
	 * @param Id_cgitm
	 */
	public void setId_cgitm(String Id_cgitm) {
		setAttrVal("Id_cgitm", Id_cgitm);
	}
	/**
	 * 退费数量
	 * @return FDouble
	 */
	public FDouble getQuan_bk() {
		return ((FDouble) getAttrVal("Quan_bk"));
	}
	/**
	 * 退费数量
	 * @param Quan_bk
	 */
	public void setQuan_bk(FDouble Quan_bk) {
		setAttrVal("Quan_bk", Quan_bk);
	}
	/**
	 * 是否已经发药
	 * @return FBoolean
	 */
	public FBoolean getFg_getdrug() {
		return ((FBoolean) getAttrVal("Fg_getdrug"));
	}
	/**
	 * 是否已经发药
	 * @param Fg_getdrug
	 */
	public void setFg_getdrug(FBoolean Fg_getdrug) {
		setAttrVal("Fg_getdrug", Fg_getdrug);
	}
}