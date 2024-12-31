package iih.ci.ord.dto.ordprintdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

/**
 * 临床医嘱打印参数 DTO数据 
 * @author Young
 *
 */
public class OrdPrintParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 中医标识
	 * @return FBoolean
	 */
	public FBoolean getFg_herb() {
		return ((FBoolean) getAttrVal("Fg_herb"));
	}
	/**
	 * 中医标识
	 * @param Fg_herb
	 */
	public void setFg_herb(FBoolean Fg_herb) {
		setAttrVal("Fg_herb", Fg_herb);
	}
	/**
	 * 患者Id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者Id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊Id
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊Id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 打印模式
	 * @return String
	 */
	public String getPrint_mode() {
		return ((String) getAttrVal("Print_mode"));
	}
	/**
	 * 打印模式
	 * @param Print_mode
	 */
	public void setPrint_mode(String Print_mode) {
		setAttrVal("Print_mode", Print_mode);
	}
	/**
	 * 页号
	 * @return Integer
	 */
	public Integer getPage_num() {
		return ((Integer) getAttrVal("Page_num"));
	}
	/**
	 * 页号
	 * @param Page_num
	 */
	public void setPage_num(Integer Page_num) {
		setAttrVal("Page_num", Page_num);
	}

	/**
	 * 医嘱单签字模式
	 * @return String
	 */
	public String getPosSignMode() {
		return ((String) getAttrVal("PosSignMode"));
	}
	/**
	 * 医嘱单签字模式
	 * @param PosSignMode
	 */
	public void setPosSignMode(String PosSignMode) {
		setAttrVal("PosSignMode", PosSignMode);
	}
	/**
	 * 医嘱单执行信息取值模式
	 * @return String
	 */
	public String getExecutinfoMode() {
		return ((String) getAttrVal("ExecutinfoMode"));
	}
	/**
	 * 医嘱单执行信息取值模式
	 * @param ExecutinfoMode
	 */
	public void setExecutinfoMode(String ExecutinfoMode) {
		setAttrVal("ExecutinfoMode", ExecutinfoMode);
	}
	/**
	 * 单据名称
	 * @return String
	 */
	public String getName_orprn() {
		return ((String) getAttrVal("Name_orprn"));
	}
	/**
	 * 单据名称
	 * @param ExecutinfoMode
	 */
	public void setName_orprn(String Name_orprn) {
		setAttrVal("Name_orprn", Name_orprn);
	}
	
	public String getSd_orsrcfun() {
		return ((String) getAttrVal("Sd_orsrcfun"));
	}	
	public void setSd_orsrcfun(String Sd_orsrcfun) {
		setAttrVal("Sd_orsrcfun", Sd_orsrcfun);
	}
	
	/**
	 * 执行人 执行时间数据来源 1医嘱表 2执行域表 mp_or_nur
	 * @return
	 */
	public String getCheckSourceType(){
		return ((String) getAttrVal("CheckSourceType"));
	}
	public void setCheckSourceType(String CheckSourceType) {
		setAttrVal("CheckSourceType", CheckSourceType);
	}
}