package iih.mp.nr.dto.infureg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药品皮试结果 DTO数据 
 * 
 */
public class SkinRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱项目ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱项目ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 服务名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 皮试结果ID
	 * @return String
	 */
	public String getId_rst_skintest() {
		return ((String) getAttrVal("Id_rst_skintest"));
	}
	/**
	 * 皮试结果ID
	 * @param Id_rst_skintest
	 */
	public void setId_rst_skintest(String Id_rst_skintest) {
		setAttrVal("Id_rst_skintest", Id_rst_skintest);
	}
	/**
	 * 皮试结果编码
	 * @return String
	 */
	public String getSd_rst_skintest() {
		return ((String) getAttrVal("Sd_rst_skintest"));
	}
	/**
	 * 皮试结果编码
	 * @param Sd_rst_skintest
	 */
	public void setSd_rst_skintest(String Sd_rst_skintest) {
		setAttrVal("Sd_rst_skintest", Sd_rst_skintest);
	}
	/**
	 * 皮试结果名称
	 * @return String
	 */
	public String getName_rst_skintest() {
		return ((String) getAttrVal("Name_rst_skintest"));
	}
	/**
	 * 皮试结果名称
	 * @param Name_rst_skintest
	 */
	public void setName_rst_skintest(String Name_rst_skintest) {
		setAttrVal("Name_rst_skintest", Name_rst_skintest);
	}
	/**
	 * 是否完成
	 * @return FBoolean
	 */
	public FBoolean getFg_finish() {
		return ((FBoolean) getAttrVal("Fg_finish"));
	}
	/**
	 * 是否完成
	 * @param Fg_finish
	 */
	public void setFg_finish(FBoolean Fg_finish) {
		setAttrVal("Fg_finish", Fg_finish);
	}
}