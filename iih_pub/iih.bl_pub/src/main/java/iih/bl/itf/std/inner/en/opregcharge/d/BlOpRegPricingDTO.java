package iih.bl.itf.std.inner.en.opregcharge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 挂号划价入参 DTO数据 
 * 
 */
public class BlOpRegPricingDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类id
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 患者价格分类id
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 患者价格分类id
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 明细
	 * @return FArrayList
	 */
	public FArrayList getDetail() {
		return ((FArrayList) getAttrVal("Detail"));
	}
	/**
	 * 明细
	 * @param Detail
	 */
	public void setDetail(FArrayList Detail) {
		setAttrVal("Detail", Detail);
	}
	/**
	 * 医保产品id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保产品id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保读卡信息
	 * @return String
	 */
	public String getHpcardinfo() {
		return ((String) getAttrVal("Hpcardinfo"));
	}
	/**
	 * 医保读卡信息
	 * @param Hpcardinfo
	 */
	public void setHpcardinfo(String Hpcardinfo) {
		setAttrVal("Hpcardinfo", Hpcardinfo);
	}
}