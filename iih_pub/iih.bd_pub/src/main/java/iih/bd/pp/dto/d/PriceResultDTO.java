package iih.bd.pp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 计价结果DTO DTO数据 
 * 
 */
public class PriceResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 医疗服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 标准价格
	 * @return FDouble
	 */
	public FDouble getPrice_std() {
		return ((FDouble) getAttrVal("Price_std"));
	}
	/**
	 * 标准价格
	 * @param Price_std
	 */
	public void setPrice_std(FDouble Price_std) {
		setAttrVal("Price_std", Price_std);
	}
	/**
	 * 价格系数
	 * @return FDouble
	 */
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Rate"));
	}
	/**
	 * 价格系数
	 * @param Rate
	 */
	public void setRate(FDouble Rate) {
		setAttrVal("Rate", Rate);
	}
	/**
	 * 折后价格
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 折后价格
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 错误信息
	 * @return String
	 */
	public String getError_msg() {
		return ((String) getAttrVal("Error_msg"));
	}
	/**
	 * 错误信息
	 * @param Error_msg
	 */
	public void setError_msg(String Error_msg) {
		setAttrVal("Error_msg", Error_msg);
	}
	/**
	 * 子服务集合
	 * @return FArrayList
	 */
	public FArrayList getSrvitm_list() {
		return ((FArrayList) getAttrVal("Srvitm_list"));
	}
	/**
	 * 子服务集合
	 * @param Srvitm_list
	 */
	public void setSrvitm_list(FArrayList Srvitm_list) {
		setAttrVal("Srvitm_list", Srvitm_list);
	}
}