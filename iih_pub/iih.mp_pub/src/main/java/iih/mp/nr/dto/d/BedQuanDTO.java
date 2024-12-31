package iih.mp.nr.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药品床旁余量列表 DTO数据 
 * 
 */
public class BedQuanDTO extends BaseDTO {
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
	 * 项目ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 项目ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 床旁余量
	 * @return FDouble
	 */
	public FDouble getQuan_bed_medu() {
		return ((FDouble) getAttrVal("Quan_bed_medu"));
	}
	/**
	 * 床旁余量
	 * @param Quan_bed_medu
	 */
	public void setQuan_bed_medu(FDouble Quan_bed_medu) {
		setAttrVal("Quan_bed_medu", Quan_bed_medu);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}
	/**
	 * 医学单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_medu() {
		return ((String) getAttrVal("Name_medu"));
	}
	/**
	 * 单位名称
	 * @param Name_medu
	 */
	public void setName_medu(String Name_medu) {
		setAttrVal("Name_medu", Name_medu);
	}
}