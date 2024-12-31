package iih.bd.srv.ortpl.dto.ortmplcareldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱模板套DTO DTO数据 
 * 
 */
public class OrtmplSetDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 使用天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}
	/**
	 * 使用天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 剂量
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 剂量
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}
	/**
	 * 次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 是否多剂量
	 * @return FBoolean
	 */
	public FBoolean getIsmuldose() {
		return ((FBoolean) getAttrVal("Ismuldose"));
	}
	/**
	 * 是否多剂量
	 * @param Ismuldose
	 */
	public void setIsmuldose(FBoolean Ismuldose) {
		setAttrVal("Ismuldose", Ismuldose);
	}
	/**
	 * 是否多执行
	 * @return FBoolean
	 */
	public FBoolean getIsmulexec() {
		return ((FBoolean) getAttrVal("Ismulexec"));
	}
	/**
	 * 是否多执行
	 * @param Ismulexec
	 */
	public void setIsmulexec(FBoolean Ismulexec) {
		setAttrVal("Ismulexec", Ismulexec);
	}
	/**
	 * 总量开单原因
	 * @return String
	 */
	public String getSd_totalopenmode() {
		return ((String) getAttrVal("Sd_totalopenmode"));
	}
	/**
	 * 总量开单原因
	 * @param Sd_totalopenmode
	 */
	public void setSd_totalopenmode(String Sd_totalopenmode) {
		setAttrVal("Sd_totalopenmode", Sd_totalopenmode);
	}
}