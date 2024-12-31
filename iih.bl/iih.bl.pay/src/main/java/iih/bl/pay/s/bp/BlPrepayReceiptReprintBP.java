package iih.bl.pay.s.bp;

import org.springframework.util.StringUtils;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.i.IBlinccancCudService;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.i.IBlIncQryService;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pay.dto.prepayreceipt.d.BlPrepayReceiptDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.bl.pay.s.bp.util.PrepayReceiptAssembleUtil;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预交金票据重打
 * @author ly 2018/06/21
 *
 */
public class BlPrepayReceiptReprintBP {
	
	/**
	 * 预交金票据重打
	 * @param rcptDto 票据信息
	 * @throws BizException
	 */
	public void exec(BlPrepayReceiptDTO rcptDto) throws BizException{
		
		this.validate(rcptDto);
		
		//查询预交金数据
		BlPrePayPatDO prepayDO = this.qryPrepayData(rcptDto.getId_paypat());
		
		//查询上次打印数据
		BlPrepayPatRcptDO lastRcptDO = this.qryLastRcptData(rcptDto.getId_paypat());
		//获取参数--住院空白押金条上是否印制有票据号
		FBoolean blPrePay0007=BlParams.BLPREPAY0007();
		//可重打校验
		this.validatePrint(lastRcptDO,blPrePay0007);
		
		//票据上印有票号模式           
		//by lim 2018-08-02 门诊转住院预交金如果blpre00011参数设成false，预交金不生成票号，所以重打时，要跳号，不然又打一张空票
		if(FBoolean.TRUE.equals(blPrePay0007) || StringUtils.isEmpty(rcptDto.getCode_rep())){
			
			// 判断是否自动生成票据号 2019/10/21
			String code = this.autoCode(prepayDO);
			
			if(StringUtil.isEmpty(code)){
				//校验票号
				BlIncIssDO incIssDO = this.checkCode(rcptDto, prepayDO.getId_incca());
				
				//保存票据数据
				BlPrepayPatRcptDO rcptDO = this.saveRcptData(prepayDO, incIssDO,lastRcptDO.getPrint_times() + 1,rcptDto.getId_resreprint());
				
				//回写预交金数据
				this.updatePrepayData(prepayDO, rcptDO);
				
				//将原票据作废票号回写到空白作废票 by lim 2018-07-28
				if(!StringUtils.isEmpty(rcptDto.getCode_rep())){
					this.saveIncCancData(lastRcptDO);
				}
				//票号过号
				this.nextNo(prepayDO.getId_incca());
			}else{
				
				IPrepaypatrcptCudService cudService = ServiceFinder.find(IPrepaypatrcptCudService.class);
				BlPrepayPatRcptDO rcptDO = PrepayReceiptAssembleUtil.assemble(prepayDO, null, code,
						lastRcptDO.getPrint_times() + 1, rcptDto.getId_resreprint());
				rcptDO = cudService.insert(new BlPrepayPatRcptDO[]{rcptDO})[0];
				
				//回写预交金数据
				this.updatePrepayData(prepayDO, rcptDO);
				
				//将原票据作废票号回写到空白作废票 by lim 2018-07-28
				if(!StringUtils.isEmpty(rcptDto.getCode_rep())){
					this.saveIncCancData(lastRcptDO);
				}
			}
		}else{
			//更新打印次数
			new PrepayPatRcptEP().refreshPrintTimes(lastRcptDO);
		}
	}
	
	/**
	 * 入参校验
	 * @param rcptDto
	 * @throws BizException
	 */
	private void validate(BlPrepayReceiptDTO rcptDto) throws BizException{
		if(rcptDto == null){
			throw new ArgumentNullException("预交金票据重打", "预交金票据打印dto");
		}
		
		if(StringUtil.isEmpty(rcptDto.getId_paypat())){
			throw new ArgumentNullException("预交金票据重打", "预交金id");
		}
	}
	
	/**
	 * 重打校验
	 * @param rcptDO
	 * @throws BizException
	 */
	private void validatePrint(BlPrepayPatRcptDO rcptDO,FBoolean blPrePay0007) throws BizException{
		if (FBoolean.TRUE.equals(rcptDO.getFg_cc_rcpt())
				&& !StringUtil.isEmpty(rcptDO.getId_cc()) && FBoolean.TRUE.equals(blPrePay0007)) {
			throw new BizException("该票据已经结账，无法重打");
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
	 * 查询上次票据数据
	 * @param payPatId
	 * @return
	 * @throws BizException
	 */
	private BlPrepayPatRcptDO qryLastRcptData(String payPatId) throws BizException{
		BlPrepayPatRcptDO lastRcptDO = new PrepayPatRcptEP().findLastRcptByPrepayId(payPatId);
		if(lastRcptDO == null){
			throw new BizException("未查询到上次票据记录，无法保存预交金票据");
		}
		
		return lastRcptDO;
	}

	/**
	 * 票号校验
	 * @param rcptDto
	 * @param inccaId
	 * @throws BizException
	 */
	private BlIncIssDO checkCode(BlPrepayReceiptDTO rcptDto,String inccaId) throws BizException{
		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		BlIncIssDO incIssDO = incService.getCurInvoiceDO(Context.get().getStuffId(),Context.get().getClientHost(), inccaId);
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
	private BlPrepayPatRcptDO saveRcptData(BlPrePayPatDO prepayDO,BlIncIssDO incIssDO,Integer printTimes,String idReprintRes)throws BizException{
		IPrepaypatrcptCudService cudService = ServiceFinder.find(IPrepaypatrcptCudService.class);
		BlPrepayPatRcptDO rcptDO = PrepayReceiptAssembleUtil.assemble(prepayDO, incIssDO.getCode_incpkg(),incIssDO.getIncno_cur(), printTimes, idReprintRes);
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
		prepayDO.setCode_rep(rcptDO.getCode_rep());
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
		incService.nextInvoiceNo(Context.get().getStuffId(),Context.get().getClientHost() ,inccaId);
	}
	
	/**
	 * 将作废票号回写到空白作废票
	 * @param id_emp
	 * @param lastRcptDO
	 * @return
	 * @throws BizException
	 */
	private void saveIncCancData(BlPrepayPatRcptDO lastRcptDO) throws BizException{
		//1.组织空白作废票信息
		BlIncCancDO blIncCancDO=PrepayReceiptAssembleUtil.assembleCancInc(lastRcptDO);
		//2.新增空白作废票
		if (blIncCancDO == null) {
			throw new BizException("新增空白作废票不能为空");
		}
		//3.校验该票号是否被作废
		IBlIncQryService ser= ServiceFinder.find(IBlIncQryService.class);
		FBoolean bCanc=ser.getCurnoCancStatus(blIncCancDO.getIncno(), IBdPpCodeTypeConst.SD_INHOS_DEPOSIT);	
		if (FBoolean.TRUE.equals(bCanc)) {
			throw new BizException("该票号已经被作废，不能再次作废！");
		}
		//4.保存作废票信息
		IBlinccancCudService iBlinccancCudService = ServiceFinder.find(IBlinccancCudService.class);
		BlIncCancDO[] blIncCancDO1 = iBlinccancCudService.save(new BlIncCancDO[] { blIncCancDO });
		if (blIncCancDO1 == null) {
			throw new BizException("保存空白作废票失败");
		}
	}

	/**
	 * 自动生成票据号
	 * 如果是自动生成自返回票号，如果不是则返回空
	 * @param prepayDO
	 * @return
	 * @throws BizException
	 */
	private String autoCode(BlPrePayPatDO prepayDO) throws BizException{
		
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(prepayDO.getCode_enttp())){
			if(FBoolean.TRUE.equals( BlParams.BLINC0018())){
				return BlCodeUtils.generateIpPrepayCode();
			}
		}else{
			if(FBoolean.TRUE.equals( BlParams.BLINC0017())){
				return BlCodeUtils.generateOpPrepayCode();
			}
		}
		
		return null;
	}
}
