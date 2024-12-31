package iih.ei.bl.ecinc.i;

import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import xap.mw.core.data.BizException;

/**
 * 电子票据费用流程接口
 * @author ly 2019/12/02
 *
 */
public interface IEcIncBlFlowService {

	/**
	 * 电子票据开具
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2019/12/02
	 */
	public abstract EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> invoice(EcIncBlFlowInvoiceInDTO dto) throws BizException;
	
	/**
	 * 电子票据红冲
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2019/12/02
	 */
	public abstract EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> redInvoice(EcIncBlFlowRedInvoiceInDTO dto) throws BizException;
	
}
