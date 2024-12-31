package iih.bl.inc.s.listener.help;

import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncFacade;
import xap.mw.core.data.BizException;

/**
 * 住院红冲电子发票逻辑
 * @author ly 2019/12/16
 *
 */
public class BlEcIncIpRedInvoiceBP {

	/**
	 * 住院红冲电子发票
	 * @param oldIncDO
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> exec(BlIncIpDO oldIncDO,BlIncIpDO redIncDO) throws BizException {

		EcIncBlFlowRedInvoiceInDTO inDto = new EcIncBlFlowRedInvoiceInDTO();
		inDto.setId_pat(oldIncDO.getId_pat());
		inDto.setId_st_old(oldIncDO.getId_stip());
		inDto.setId_inc_old(oldIncDO.getId_incip());
		inDto.setId_st_red(redIncDO.getId_stip());
		inDto.setId_inc_red(redIncDO.getId_stip());
		inDto.setEcinc_code(oldIncDO.getEc_inc_code());
		inDto.setEcincno(oldIncDO.getIncno());
		inDto.setInctype(iih.ei.bl.ecinc.d.EcIncTypeEnum.INCIP);
		inDto.setReason("退费");
		
		EcIncFacade incFacade = new EcIncFacade();
		EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> outDto = incFacade.redInvoice(inDto);
		return outDto;
	}
}
