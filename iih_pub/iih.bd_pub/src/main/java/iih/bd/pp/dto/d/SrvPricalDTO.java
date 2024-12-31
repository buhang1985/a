package iih.bd.pp.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDouble;
/**
 * 服务计价比例DTO
 * @author 唐婵懿 2016-1-7
 *
 */
public class SrvPricalDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务分类或项目
	 * @return
	 */
	public int getEu_srvorca() {
		return ((int) getAttrVal("Eu_srvorca"));
	}	
	public void setEu_srvorca(int Eu_srvorca) {
		setAttrVal("Eu_srvorca", Eu_srvorca);
	}
	/**
	 * 服务分类
	 * @return
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 服务项目
	 * @return
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 价格系数
	 * @return
	 */
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Eu_srvorca"));
	}	
	public void setRate(FDouble Eu_srvorca) {
		setAttrVal("Eu_srvorca", Eu_srvorca);
	}

}
