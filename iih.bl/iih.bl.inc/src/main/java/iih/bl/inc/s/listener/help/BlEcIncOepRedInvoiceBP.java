package iih.bl.inc.s.listener.help;

import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncFacade;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 门诊红冲电子发票逻辑
 * @author ly 2019/12/16
 *
 */
public class BlEcIncOepRedInvoiceBP {

	/**
	 * 门诊红冲电子发票
	 * @param oldIncDO
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> exec(BlIncOepDO oldIncDO, BlIncOepDO redIncDO) throws BizException {
		DAFacade daf = new DAFacade();
		
		BlStIpDO stDO = (BlStIpDO) daf.findByPK(BlStIpDO.class, oldIncDO.getId_stoep(),
				new String[] { BlStIpDO.ID_PAT, BlStIpDO.ID_ENT, BlStIpDO.ID_STIP, BlStIpDO.ID_PAR});
		
		EcIncBlFlowRedInvoiceInDTO inDto = new EcIncBlFlowRedInvoiceInDTO();
		inDto.setId_pat(oldIncDO.getId_pat());
		inDto.setId_st_old(oldIncDO.getId_stoep());
		inDto.setId_inc_old(oldIncDO.getId_incoep());
		inDto.setId_st_red(redIncDO.getId_stoep());
		inDto.setId_inc_red(redIncDO.getId_stoep());
		inDto.setEcinc_code(oldIncDO.getEc_inc_code());
		inDto.setEcincno(oldIncDO.getIncno());
		inDto.setInctype(stDO!=null &&  StTypeEnum.ST_OEP_REG.equals(stDO.getEu_sttp()) ? iih.ei.bl.ecinc.d.EcIncTypeEnum.INCREGISTER : iih.ei.bl.ecinc.d.EcIncTypeEnum.INCOEP);
		inDto.setReason("退费");
		
		EcIncFacade incFacade = new EcIncFacade();
		EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> outDto = incFacade.redInvoice(inDto);
		return outDto;
	}
	
}
