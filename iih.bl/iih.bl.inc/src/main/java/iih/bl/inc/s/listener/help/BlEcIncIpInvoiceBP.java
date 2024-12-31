package iih.bl.inc.s.listener.help;

import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.d.EcIncTypeEnum;
import iih.ei.bl.ecinc.util.EcIncFacade;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;

/**
 * 住院开立电子发票逻辑
 * @author ly 2019/12/16
 *
 */
public class BlEcIncIpInvoiceBP {
	
	/**
	 * 住院开立电子发票
	 * @param enEntDO
	 * @param stDO
	 * @param payAggDO
	 * @param incAggDO
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> exec(PatiVisitDO enEntDO,BlStIpDO stDO,BlpaypatipAggDO payAggDO,BlincipAggDO incAggDO) throws BizException {
		
		EcIncBlFlowInvoiceInDTO inDto = new EcIncBlFlowInvoiceInDTO();
		inDto.setId_pat(stDO.getId_pat());
		inDto.setId_ent(stDO.getId_ent());
		inDto.setId_st(stDO.getId_stip());
		inDto.setId_pay(payAggDO.getParentDO().getId_paypatip());
		inDto.setId_inc(incAggDO.getParentDO().getId_incip());
		inDto.setInctype(EcIncTypeEnum.INCIP);
		
		EcIncFacade incFacade = new EcIncFacade();
		EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = incFacade.invoice(inDto);
		return rlt;
	}
}
