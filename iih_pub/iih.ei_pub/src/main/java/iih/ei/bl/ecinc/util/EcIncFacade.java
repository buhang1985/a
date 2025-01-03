package iih.ei.bl.ecinc.util;

import java.util.List;

import iih.bd.base.utils.CtmItfFinder;
import iih.ei.bl.ecinc.d.EcIncBlAssistBatchInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlAssistBatchInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncBlAssistGetStatusInDTO;
import iih.ei.bl.ecinc.d.EcIncBlAssistGetStatusOutDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeInDTO;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeOutDTO;
import iih.ei.bl.ecinc.d.EcIncPaperCurIncNoInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperCurIncNoOutDTO;
import iih.ei.bl.ecinc.d.EcIncPaperReSwitchInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperReSwitchOutDTO;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.i.IEcIncFactory;
import xap.mw.core.data.BizException;

/**
 * 电子发票处理门面类
 * @author ly 2019/12/02
 *
 */
public class EcIncFacade {

	private IEcIncFactory incFactory;
	
	public EcIncFacade() throws BizException{
		incFactory = CtmItfFinder.find(IEcIncFactory.class);
		//incFactory = ServiceFinder.find(IEcIncFactory.class);//TODO 后续改为动态配置
		if (incFactory == null) {
			throw new BizException("电子发票:未配置工厂实例");
		}
	}
	
	/**********************电子票据费用流程**********************/
	/**
	 * 电子票据开具
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> invoice(EcIncBlFlowInvoiceInDTO dto) throws BizException{
		return this.incFactory.createBlFlowInstance().invoice(dto);
	}
	
	/**
	 * 电子票据红冲
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> redInvoice(EcIncBlFlowRedInvoiceInDTO dto) throws BizException{
		return this.incFactory.createBlFlowInstance().redInvoice(dto);
	}
	/**********************电子票据辅助方法**********************/
	
	/**
	 * 电子发票批量开具
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlAssistBatchInvoiceOutDTO> batchInvoice(EcIncBlAssistBatchInvoiceInDTO dto) throws BizException{
		return this.incFactory.createBlAssistInstance().batchInvoice(dto);
	}
	
	/**
	 * 电子发票状态获取
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlAssistGetStatusOutDTO> getEcIncStatus(EcIncBlAssistGetStatusInDTO dto) throws BizException{
		return this.incFactory.createBlAssistInstance().getEcIncStatus(dto);
	}
	
	/**********************电子票据纸质票据**********************/
	/**
	 * 获取纸质发票当前票号
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncPaperCurIncNoOutDTO> getCurIncNo(EcIncPaperCurIncNoInDTO dto) throws BizException {
		return this.incFactory.createPaperInstance().getCurIncNo(dto);
	}
	
	/**
	 * 换开纸质发票
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncPaperSwitchOutDTO> swichPaperInc(EcIncPaperSwitchInDTO dto) throws BizException {
		return this.incFactory.createPaperInstance().swichPaperInc(dto);
	}
	
	/**
	 * 重新换开纸质发票
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncPaperReSwitchOutDTO> reSwichPaperInc(EcIncPaperReSwitchInDTO dto) throws BizException{
		return this.incFactory.createPaperInstance().reSwichPaperInc(dto);
	}
	
	/**********************电子票据库存管理**********************/
	
	/**
	 * 获取纸质发票有效票据代码
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<List<EcIncManagePaperIncCodeOutDTO>> getPaperActiveIncCode(EcIncManagePaperIncCodeInDTO dto) throws BizException{
		return this.incFactory.createManageInstance().getPaperActiveIncCode(dto);
	}
	
	/**********************电子票据数据核对**********************/
	
	
	/**********************电子票据财务**********************/
}
