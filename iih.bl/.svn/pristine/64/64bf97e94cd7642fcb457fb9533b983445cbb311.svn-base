package iih.bl.pay.s.bp;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pay.dto.prepayreceipt.d.BlPrepayReceiptDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.bl.pay.s.bp.util.PrepayReceiptAssembleUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预交金票据打印
 * @author ly 2018/06/21
 *
 */
public class BlPrepayReceiptPrintBP {

	/**
	 * 预交金票据打印
	 * @param rcptDto 票据信息
	 * @throws BizException
	 */
	public void exec(BlPrepayReceiptDTO rcptDto) throws BizException{
		
		this.validate(rcptDto);
		
		//查询预交金数据
		BlPrePayPatDO prepayDO = this.qryPrepayData(rcptDto.getId_paypat());
		
		//校验票号
		BlIncIssDO incIssDO = this.checkCode(rcptDto, prepayDO.getId_incca());
		
		//保存票据数据
		BlPrepayPatRcptDO rcptDO = this.saveRcptData(prepayDO, incIssDO);
		
		//回写预交金数据
		this.updatePrepayData(prepayDO, rcptDO);
		
		//票号过号
		this.nextNo(prepayDO.getId_incca());
	}
	
	/**
	 * 入参校验
	 * @param rcptDto
	 * @throws BizException
	 */
	private void validate(BlPrepayReceiptDTO rcptDto) throws BizException{
		if(rcptDto == null){
			throw new ArgumentNullException("预交金票据打印", "预交金票据打印dto");
		}
		
		if(StringUtil.isEmpty(rcptDto.getId_paypat())){
			throw new ArgumentNullException("预交金票据打印", "预交金id");
		}
	}

	/**
	 * 查询预交金数据
	 * @param payPatId
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO qryPrepayData(String payPatId) throws BizException{
		IBlpaypatRService prepayRService = ServiceFinder.find(IBlpaypatRService.class);
		BlPrePayPatDO prepayDO = prepayRService.findById(payPatId);
		if(prepayDO == null){
			throw new BizException("未查询到预交金数据，无法保存预交金票据");
		}
		
		return prepayDO;
	}
	
	/**
	 * 票号校验
	 * @param rcptDto
	 * @param inccaId
	 * @throws BizException
	 */
	private BlIncIssDO checkCode(BlPrepayReceiptDTO rcptDto,String inccaId) throws BizException{
		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		BlIncIssDO incIssDO = incService.getCurInvoiceDO(Context.get().getStuffId(), Context.get().getClientHost(),inccaId);
		if(FBoolean.TRUE.equals(rcptDto.getFg_checkcode()) && !incIssDO.getIncno_cur().equals(rcptDto.getCode_rep())){
			throw new BizException("当前票据已被他人修改，请刷新界面，重做业务！");
		}
		
		return incIssDO;
	}

	/**
	 * 保存票据记录数据
	 * @param prepayDO
	 * @param incIssDO
	 * @return
	 * @throws BizException
	 */
	private BlPrepayPatRcptDO saveRcptData(BlPrePayPatDO prepayDO,BlIncIssDO incIssDO)throws BizException{
		IPrepaypatrcptCudService cudService = ServiceFinder.find(IPrepaypatrcptCudService.class);
		BlPrepayPatRcptDO rcptDO = PrepayReceiptAssembleUtil.assemble(prepayDO, incIssDO.getCode_incpkg(),incIssDO.getIncno_cur(), 1, null);
		BlPrepayPatRcptDO[] dos = cudService.insert(new BlPrepayPatRcptDO[]{rcptDO});
		return dos[0];
	}

	/**
	 * 回写预交金数据
	 * @param prepayDO
 * @param rcptDO
	 * @throws BizException
	 */
	private void updatePrepayData(BlPrePayPatDO prepayDO,BlPrepayPatRcptDO rcptDO) throws BizException{
		IBlpaypatCudService cudService = ServiceFinder.find(IBlpaypatCudService.class);
		prepayDO.setCode_rep(prepayDO.getCode_rep());
		prepayDO.setStatus(DOStatus.UPDATED);
		
		cudService.update(new BlPrePayPatDO[]{prepayDO});
	}
	
	/**
	 * 票据包过号
	 * @param inccaId
	 * @throws BizException
	 */
	private void nextNo(String inccaId)throws BizException{
		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		incService.nextInvoiceNo(Context.get().getStuffId(),Context.get().getClientHost(), inccaId);
	}
}
