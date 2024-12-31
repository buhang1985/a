package iih.bl.cg.bp;

import iih.bl.st.dto.d.BlIpOutPatPriDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 组织出院患者费用核查返回信息
 * @author LIM
 *
 */
public class GetBlIpOutPatPriDTOBP {
	/**
	 * 组织出院患者费用核查返回信息
	 * @param code_Type 检查类型
	 * @param fg_Price 是否划价
	 * @param message 返回信息
	 * @return
	 */
	public BlIpOutPatPriDTO exec(String code_Type,FBoolean fg_Price,String message){
		BlIpOutPatPriDTO dto= new BlIpOutPatPriDTO();
		dto.setCode_type(code_Type);
		dto.setFg_price(fg_Price);
		dto.setMessage(message);
		return dto;	
	}
}
