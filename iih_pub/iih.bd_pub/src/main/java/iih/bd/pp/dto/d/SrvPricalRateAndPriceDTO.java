package iih.bd.pp.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDouble;

/**
 * 服务计价比例和单价DTO
 * 
 * @author 唐婵懿 2016-1-7
 *
 */
public class SrvPricalRateAndPriceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 服务分类或项目
	 * 
	 * @return
	 */
	public int getEu_srvorca() {
		return ((int) getAttrVal("Eu_srvorca"));
	}

	public void setEu_srvorca(int Eu_srvorca) {
		setAttrVal("Eu_srvorca", Eu_srvorca);
	}

	// /**
	// * 服务分类
	// * @return
	// */
	// public String getId_srvca() {
	// return ((String) getAttrVal("Id_srvca"));
	// }
	// public void setId_srvca(String Id_srvca) {
	// setAttrVal("Id_srvca", Id_srvca);
	// }
	/**
	 * 服务项目
	 * 
	 * @return
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}

	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}

	/**
	 * 物品
	 * 
	 * @return
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}

	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	
	/**
	 * 包装单位
	 * 
	 * @return
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}

	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	
	/**
	 * 价格系数
	 * 
	 * @return
	 */
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Rate"));
	}

	public void setRate(FDouble Rate) {
		setAttrVal("Rate", Rate);
	}

	/**
	 * 标准价格
	 * 
	 * @return
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}

	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}

	/**
	 * 折扣价格
	 * 
	 * @return
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}

	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}

	/**
	 * 数量
	 * 
	 * @return
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}

	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}


	/**
	 * 价格比例模式
	 * 
	 * @return
	 */
	public Integer getEu_pi_priratemd() {
		return ((Integer) getAttrVal("Eu_pi_priratemd"));
	}

	/**
	 * 价格比例模式
	 * 
	 * @return
	 */
	public void setEu_pi_priratemd(Integer Eu_pi_priratemd) {
		setAttrVal("Eu_pi_priratemd", Eu_pi_priratemd);
	}

	/**
	 * 价格模式
	 * 
	 * @return
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}

	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	
	/**
	 * 错误信息，用于批量数据处理时，存储错误信息
	 * 
	 * @return
	 */
	public String getError_msg() {
		return ((String) getAttrVal("Error_msg"));
	}

	public void setError_msg(String Error_msg) {
		setAttrVal("Error_msg", Error_msg);
	}
}
