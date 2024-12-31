package iih.ei.bl.ecinc.bosssoft.v2.s;

import iih.ei.bl.ecinc.bosssoft.v2.s.bp.BossSoftEcIncBlFlowInvoiceBP;
import iih.ei.bl.ecinc.bosssoft.v2.s.bp.BossSoftEcIncBlFlowRedInvoiceBP;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.s.EcIncBlFlowBaseServiceImpl;
import xap.mw.core.data.BizException;

/**
 * 博思电子发票费用流程处理
 * @author ly 2019/12/03
 *
 */
public class BossSoftEcIncBlFlowServiceImpl extends EcIncBlFlowBaseServiceImpl{

	private static BossSoftEcIncBlFlowServiceImpl instance;
	
	static{
		instance = new BossSoftEcIncBlFlowServiceImpl();
	}
	
	public static BossSoftEcIncBlFlowServiceImpl getInstance(){
		return instance;
	}
	
	@Override
	public EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> invoice(EcIncBlFlowInvoiceInDTO dto) throws BizException {
		BossSoftEcIncBlFlowInvoiceBP bp = new BossSoftEcIncBlFlowInvoiceBP();
		return bp.exec(dto);
	}
	
	@Override
	public EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> redInvoice(EcIncBlFlowRedInvoiceInDTO dto) throws BizException {
		BossSoftEcIncBlFlowRedInvoiceBP bp = new BossSoftEcIncBlFlowRedInvoiceBP();
		return bp.exec(dto);
	}
}
