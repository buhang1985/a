package iih.bl.inc.s.listener.help;

import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.d.EcIncTypeEnum;
import iih.ei.bl.ecinc.util.EcIncFacade;
import xap.mw.core.data.BizException;

/**
 * 门诊开立电子发票逻辑
 * @author ly 2019/12/16
 *
 */
public class BlEcIncOepInvoiceBP {

	/**
	 * 门诊开立电子发票
	 * @param cgAggDos
	 * @param stDO
	 * @param payAggDO
	 * @param incAggDos
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> exec(BlcgoepAggDO[] cgAggDos, BlStOepDO stDO,
			BlpaypatoepAggDO payAggDO, BlincoepAggDO[] incAggDos) throws BizException {
	
		EcIncBlFlowInvoiceInDTO inDto = new EcIncBlFlowInvoiceInDTO();
		inDto.setId_pat(stDO.getId_pat());
		inDto.setId_ent(stDO.getId_ent());
		inDto.setId_st(stDO.getId_stoep());
		inDto.setId_pay(payAggDO.getParentDO().getId_paypatoep());
		inDto.setId_inc(incAggDos[0].getParentDO().getId_incoep());
		inDto.setInctype(StTypeEnum.ST_OEP_REG.equals(stDO.getEu_sttp()) ? EcIncTypeEnum.INCREGISTER : EcIncTypeEnum.INCOEP);
		
		EcIncFacade incFacade = new EcIncFacade();
		EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = incFacade.invoice(inDto);
		return rlt;
	}
}
