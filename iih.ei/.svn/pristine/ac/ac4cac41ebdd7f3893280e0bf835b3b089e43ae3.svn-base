package iih.ei.bl.ecinc.bosssoft.v2.s;

import iih.ei.bl.ecinc.bosssoft.v2.s.bp.BossSoftEcIncBlAssistBatchInvoiceBP;
import iih.ei.bl.ecinc.bosssoft.v2.s.bp.BossSoftEcIncBlAssistGetStatusBP;
import iih.ei.bl.ecinc.d.EcIncBlAssistBatchInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlAssistBatchInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncBlAssistGetStatusInDTO;
import iih.ei.bl.ecinc.d.EcIncBlAssistGetStatusOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.s.EcIncBlAssistBaseServiceImpl;
import xap.mw.core.data.BizException;

/**
 * 博思电子发票费用辅助处理
 * @author ly 2019/12/03
 *
 */
public class BossSoftEcIncBlAssistServiceImpl extends EcIncBlAssistBaseServiceImpl{

	private static BossSoftEcIncBlAssistServiceImpl instance;
	
	static{
		instance = new BossSoftEcIncBlAssistServiceImpl();
	}
	
	public static BossSoftEcIncBlAssistServiceImpl getInstance(){
		return instance;
	}
	
	@Override
	public EcIncResultDTO<EcIncBlAssistBatchInvoiceOutDTO> batchInvoice(EcIncBlAssistBatchInvoiceInDTO dto) throws BizException {
		BossSoftEcIncBlAssistBatchInvoiceBP bp = new BossSoftEcIncBlAssistBatchInvoiceBP();
		return bp.exec(dto);
	}
	
	@Override
	public EcIncResultDTO<EcIncBlAssistGetStatusOutDTO> getEcIncStatus(EcIncBlAssistGetStatusInDTO dto) throws BizException {
		BossSoftEcIncBlAssistGetStatusBP bp = new BossSoftEcIncBlAssistGetStatusBP();
		return bp.exec(dto);
	}
}
