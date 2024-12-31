package iih.ei.bl.ecinc.i;

import iih.ei.bl.ecinc.d.EcIncBlAssistBatchInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlAssistBatchInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncBlAssistGetStatusInDTO;
import iih.ei.bl.ecinc.d.EcIncBlAssistGetStatusOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import xap.mw.core.data.BizException;

/**
 * 电子票据费用辅助功能接口
 * @author ly 2019/12/02
 *
 */
public interface IEcIncBlAssistService {

	/**
	 * 电子发票批量开具
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract EcIncResultDTO<EcIncBlAssistBatchInvoiceOutDTO> batchInvoice(EcIncBlAssistBatchInvoiceInDTO dto) throws BizException;

	/**
	 * 电子发票状态获取
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract EcIncResultDTO<EcIncBlAssistGetStatusOutDTO> getEcIncStatus(EcIncBlAssistGetStatusInDTO dto) throws BizException;
}
