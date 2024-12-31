package iih.bl.pay.s.bp.prepay;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.comm.IBlConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.account.d.BlAccountDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.s.bp.util.PrepayAssembleUtil;
import iih.bl.pay.s.bp.util.PrepayReceiptAssembleUtil;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import iih.bl.pay.s.event.BlPrepayEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 
 * 预交金作废
 * @author ly 2019/04/01
 *
 */
public class BlPrepayAbolishBP extends BlPrepayBaseBP{

	public BlPrepayAbolishBP(BlPrepaySetDTO setDto) {
		super(setDto);
	}
	
	/**
	 * 预交金作废
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO exec(BlPrepayRDTO dto) throws BizException{
		
		this.validate(dto);
		this.setDto.setFg_checkacc(FBoolean.FALSE);
		
		this.analysisAccType(dto.getId_pat(), dto.getId_ent(), dto.getId_pecmpy());
		
		BlPrePayPatDO prepayDO = null;
		String pk = new DBUtil().getOIDs(1)[0];
		
		//处理预交金
		prepayDO = this.dealPrepayOrigin(dto);
		prepayDO.setId_paypat(pk);

		//处理票据
		this.dealRcptOrigin(dto.getId_prepay_old(), prepayDO);
		
		//保存预交金
		prepayDO = this.cudService.insert(new BlPrePayPatDO[] { prepayDO })[0];
		
		//需要更新账户
		if(FBoolean.TRUE.equals(this.setDto.getFg_accupdate())){
			this.chargeAcc(prepayDO.getAmt().multiply(prepayDO.getEu_direct()));
		}
		
		//发送预交金退充值事件
		BlPrepayEvent.invokeRefund(prepayDO);
		
		return prepayDO;
	}
	
	/**
	 * 参数校验
	 * @param dto
	 * @throws BizException
	 */
	private void validate(BlPrepayRDTO dto) throws BizException{
		
		if(dto == null){
			throw new ArgumentNullException("预交金作废", "退充值数据");
		}
		
		if(StringUtil.isEmpty(dto.getId_pat()) 
				&& StringUtil.isEmpty(dto.getId_ent()) 
				&& StringUtil.isEmpty(dto.getId_pecmpy())){
			throw new BizException("预交金作废:确定类型的字段至少一个需要有值:患者id,就诊id,团检id");
		}
		
		if(StringUtil.isEmpty(dto.getId_prepay_old())){
			throw new BizException("预交金作废:原充值预交金id不能为空");
		}
		
		if(StringUtil.isEmpty(dto.getId_emp_pay())){
			dto.setId_emp_pay(Context.get().getStuffId());
		}
	}
	
	/**
	 * 可退性校验
	 * @param prepayDO
	 * @param fgNew
	 */
	private void validateCanRefundOrigin(BlPrePayPatDO prepayDO) throws BizException{
		
		if(FBoolean.TRUE.equals(prepayDO.getFg_canc())){
			throw new BizException("该预交金已作废，无法作废");
		}
		
		if(FBoolean.TRUE.equals(prepayDO.getFg_rep_return())){
			throw new BizException("该预交金已经消费，无法作废");
		}
		
		if(!FBoolean.FALSE.equals(this.setDto.getFg_checkacc())){
			//金额限制
			BlAccountDTO account =  super.getAcc();
			if(prepayDO.getAmt().abs().compareTo(account.getAmt_bal()) > 0){
				throw new BizException("账户可用余额不足，无法作废");
			}
		}
	}
	
	/**
	 * 按原记录处理
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO dealPrepayOrigin(BlPrepayRDTO dto) throws BizException {
		
		BlPrePayPatDO oldPrepayDO = this.rService.findById(dto.getId_prepay_old());
		
		this.validateCanRefundOrigin(oldPrepayDO);
		
		BlPrePayPatDO prepayDO = PrepayAssembleUtil.reserveWhenVoid(oldPrepayDO, accType, null,
				String.format(IBlConst.NOTE_PREPAYVOID, oldPrepayDO.getCode_rep()),dto.getSd_pttp(),dto.getId_pm(),dto.getSd_pm(),null);		
		
		if(IBlConst.PREPAY_IPACC.equals(this.accType)){
			//退充值的支付方式全部修改为12
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
		}
		
		//原票据修改
		oldPrepayDO.setFg_canc(FBoolean.TRUE);
		oldPrepayDO.setFg_rep_return(FBoolean.TRUE);
		oldPrepayDO.setDt_canc(BlFlowContextUtil.getNowTime());
		oldPrepayDO.setId_emp_canc(Context.get().getStuffId());
		oldPrepayDO.setNote(IBlConst.NOTE_PREPAYABOLISH);
		oldPrepayDO.setStatus(DOStatus.UPDATED);
		
		this.cudService.update(new BlPrePayPatDO[] { oldPrepayDO });
		
		return prepayDO;
	}
	
	/**
	 * 处理原票据
	 * @param oldPrepayId
	 * @param prepayDO
	 * @return
	 * @throws BizException
	 */
	private void dealRcptOrigin(String oldPrepayId,BlPrePayPatDO prepayDO) throws BizException{
		
		PrepayPatRcptEP rcptEp = new PrepayPatRcptEP();
		BlPrepayPatRcptDO oldRcptDO = rcptEp.findLastRcptByPrepayId(oldPrepayId);
		
		if(oldRcptDO == null)
			return;
		
		BlPrepayPatRcptDO rcptDO = PrepayReceiptAssembleUtil.reserveRcpt(oldRcptDO,
				String.format(IBlConst.NOTE_PREPAYVOID, oldRcptDO.getCode_rep()));	
		if(rcptDO!=null){
			rcptDO.setId_paypat(prepayDO.getId_paypat());
		}
		this.rcptCudService.insert(new BlPrepayPatRcptDO[]{rcptDO});
	}
}
