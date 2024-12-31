package iih.pe.papt.dto.pecorplistdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 团体列表 DTO数据 
 * 
 */
public class PeCorpListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检单位主键标识
	 * @return String
	 */
	public String getId_pecorpbinfo() {
		return ((String) getAttrVal("Id_pecorpbinfo"));
	}
	/**
	 * 体检单位主键标识
	 * @param Id_pecorpbinfo
	 */
	public void setId_pecorpbinfo(String Id_pecorpbinfo) {
		setAttrVal("Id_pecorpbinfo", Id_pecorpbinfo);
	}
	/**
	 * 体检单位父ID
	 * @return String
	 */
	public String getId_pecorpbinfo_par() {
		return ((String) getAttrVal("Id_pecorpbinfo_par"));
	}
	/**
	 * 体检单位父ID
	 * @param Id_pecorpbinfo_par
	 */
	public void setId_pecorpbinfo_par(String Id_pecorpbinfo_par) {
		setAttrVal("Id_pecorpbinfo_par", Id_pecorpbinfo_par);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 单位编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_corp() {
		return ((String) getAttrVal("Name_corp"));
	}
	/**
	 * 单位名称
	 * @param Name_corp
	 */
	public void setName_corp(String Name_corp) {
		setAttrVal("Name_corp", Name_corp);
	}
	/**
	 * 体检结束标识
	 * @return FBoolean
	 */
	public FBoolean getFg_finish() {
		return ((FBoolean) getAttrVal("Fg_finish"));
	}
	/**
	 * 体检结束标识
	 * @param Fg_finish
	 */
	public void setFg_finish(FBoolean Fg_finish) {
		setAttrVal("Fg_finish", Fg_finish);
	}
	/**
	 * 体检结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_finish() {
		return ((FDateTime) getAttrVal("Dt_finish"));
	}
	/**
	 * 体检结束时间
	 * @param Dt_finish
	 */
	public void setDt_finish(FDateTime Dt_finish) {
		setAttrVal("Dt_finish", Dt_finish);
	}
}