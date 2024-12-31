package iih.ei.bl.ecinc.bosssoft.v2.s.bp.help;

import org.springframework.beans.BeanUtils;

import iih.bl.st.blstoep.d.BlStOepDO;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceOpParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoicePeParam;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import xap.mw.core.data.BizException;

/**
 * 电子发票开具体检数据组装
 * @author ly 2020/05/07
 *
 */
public class PeEcIncDataBP {

	/**
	 * TODO
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcInvoicePeParam exec(EcIncBlFlowInvoiceInDTO dto) throws BizException{
		return null;
	}
	
	/**
	 * 转换门诊结果为体检结果
	 * @param opParam
	 * @return
	 * @throws BizException
	 */
	public EcInvoicePeParam exec2(EcInvoiceOpParam opParam, BlStOepDO stDO) throws BizException{
		
		EcInvoicePeParam peParam = new EcInvoicePeParam();
		BeanUtils.copyProperties(opParam, peParam);
		peParam.setBusType("05");
		peParam.setPatientNo(stDO.getPecode());
		peParam.setCheckUpNo(stDO.getPecode());
		return peParam;
	}
}
