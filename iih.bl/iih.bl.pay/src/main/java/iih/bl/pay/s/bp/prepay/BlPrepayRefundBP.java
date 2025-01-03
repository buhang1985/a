package iih.bl.pay.s.bp.prepay;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.comm.IBlConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.account.d.BlAccountDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.s.bp.util.PrepayAssembleUtil;
import iih.bl.pay.s.bp.util.PrepayReceiptAssembleUtil;
import iih.bl.pay.s.ep.PrepayPatEP;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import iih.bl.pay.s.event.BlPrepayEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 预交金退充值
 * @author ly 2018/07/19
 *
 */
public class BlPrepayRefundBP extends BlPrepayBaseBP{

	public BlPrepayRefundBP(BlPrepaySetDTO setDto) {
		super(setDto);
	}

	/**
	 * 预交金退充值
	 * 两种模式:1.按主键退原记录 2.按照输入金额退3.根据主键原记录半退
	 * @param dto 退充值数据
	 * @return 预交金DO
	 * @throws BizException
	 */
	public BlPrePayPatDO exec(BlPrepayRDTO dto) throws BizException{
		
		this.validate(dto);
		
		this.analysisAccType(dto.getId_pat(), dto.getId_ent(), dto.getId_pecmpy());
		
		//重新判断是否需要进行票据管理
		if(FBoolean.TRUE.equals(this.setDto.getFg_useinc())){
			super.judgeIncManage();
		}
		
		BlPrePayPatDO prepayDO = null;
		String pk = new DBUtil().getOIDs(1)[0];
		
		PrepayPatRcptEP rcptEp = new PrepayPatRcptEP();
		if(StringUtil.isEmpty(dto.getId_prepay_old())){
			//处理预交金  产生新一条记录
			prepayDO = this.dealPrepayNew(dto);
			prepayDO.setId_paypat(pk);
			//可退性校验
			this.validateCanRefundNew(prepayDO);
			//处理票据
			BlPrepayPatRcptDO rcptDO = null;
			if (FBoolean.TRUE.equals(this.setDto.getFg_useinc())) {
				rcptDO = rcptEp.saveRcptPrint(prepayDO, null);
			} else {
				rcptDO = rcptEp.saveRcptPrintWithCode(prepayDO, super.generateAutoCode());
			}
			//设置预交金票号
			if(rcptDO!=null){
				prepayDO.setCode_rep(rcptDO.getCode_rep());
			}
		//走 第三种模式   根据原交易记录 半退的情况
		}else if(!StringUtil.isEmpty(dto.getId_prepay_old())&&dto.getIshalfrefund()!=null&&dto.getIshalfrefund().booleanValue()){
			//处理预交金  产生新一条记录
			prepayDO = this.dealPrepayNew(dto);
			prepayDO.setId_paypat(pk);
			//退费主键
			prepayDO.setId_par(dto.getId_prepay_old());
			//更新原纪录 可退金额字段
			updateOriginAmtRet(dto);
			//处理票据
			BlPrepayPatRcptDO rcptDO = null;
			if (FBoolean.TRUE.equals(this.setDto.getFg_useinc())) {
				rcptDO = rcptEp.saveRcptPrint(prepayDO, null);
			} else {
				rcptDO = rcptEp.saveRcptPrintWithCode(prepayDO, super.generateAutoCode());
			}
			//设置预交金票号
			if(rcptDO!=null){
				prepayDO.setCode_rep(rcptDO.getCode_rep());
			}
		}else {
			//处理预交金 按原纪录
			prepayDO = this.dealPrepayOrigin(dto);
			prepayDO.setId_paypat(pk);
			//可退性校验
			this.validateCanRefundOrigin(prepayDO);
			//处理票据
			this.dealRcptOrigin(dto.getId_prepay_old(), prepayDO);
		}
		
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
	void validate(BlPrepayRDTO dto) throws BizException{
		
		if(dto == null){
			throw new ArgumentNullException("预交金退充值", "退充值数据");
		}
		
		if(StringUtil.isEmpty(dto.getId_pat()) 
				&& StringUtil.isEmpty(dto.getId_ent()) 
				&& StringUtil.isEmpty(dto.getId_pecmpy())){
			throw new BizException("预交金退充值:确定类型的字段至少一个需要有值:患者id,就诊id,团检id");
		}
		
		if(StringUtil.isEmpty(dto.getId_prepay_old())){
		
			if(dto.getAmt() == null || dto.getAmt().compareTo(FDouble.ZERO_DBL) <= 0){
				throw new BizException("预交金退充值:金额不能为空或小于0");
			}
			
			if(StringUtil.isEmpty(dto.getSd_pttp())){
				throw new ArgumentNullException("预交金退充值", "收费款终端");
			}
		}
		
		if(StringUtil.isEmpty(dto.getId_pm()) || StringUtil.isEmpty(dto.getSd_pm())){
			throw new ArgumentNullException("预交金退充值", "付款方式");
		}
		
		if(StringUtil.isEmpty(dto.getId_emp_pay())){
			dto.setId_emp_pay(Context.get().getStuffId());
		}
	}

	/**
	 * 按新入参处理
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	BlPrePayPatDO dealPrepayNew(BlPrepayRDTO dto) throws BizException{
		
		BlPrePayPatDO prepayDO = PrepayAssembleUtil.assembleChargeData(dto, this.accType);
		return prepayDO;
	}
	
	/**
	 * 按原记录处理
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	BlPrePayPatDO dealPrepayOrigin(BlPrepayRDTO dto) throws BizException {
		
		BlPrePayPatDO oldPrepayDO = this.rService.findById(dto.getId_prepay_old());
		
		if(FBoolean.TRUE.equals(oldPrepayDO.getFg_rep_return()) || FBoolean.TRUE.equals(oldPrepayDO.getFg_canc())){
			String whereStr = "CODE_REP = '"+oldPrepayDO.getCode_rep()+"' and Fg_canc ='N' and Fg_rep_return = 'N' and EU_DIRECT = 1";
			BlPrePayPatDO[] prePays = this.rService.find(whereStr, "", FBoolean.FALSE);
			if(prePays == null || prePays.length == 0){
				throw new BizException("票据号为 “"+oldPrepayDO.getCode_rep()+"” 的预交金已经被使用");
			}
			oldPrepayDO = prePays[0];
		}
		
		BlPrePayPatDO prepayDO = PrepayAssembleUtil.reserveWhenVoid(oldPrepayDO, accType, null,
				String.format(IBlConst.NOTE_PREPAYVOID, oldPrepayDO.getCode_rep()),dto.getSd_pttp(),dto.getId_pm(),dto.getSd_pm(),dto.getFg_refund_manual());		
		if(StringUtils.isNotEmpty(dto.getId_emp_pay())){
			prepayDO.setId_emp_pay(dto.getId_emp_pay());
		}
		
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(oldPrepayDO.getCode_enttp())
				|| IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(oldPrepayDO.getCode_enttp())) {
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
		} else {
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
		}
		//by lim  保存退费传过来的值 2020-06-15
		prepayDO.setId_bank(dto.getId_bank());
		prepayDO.setBankno(dto.getBankno());
		prepayDO.setPaymodenode(dto.getPaymodenode());
		prepayDO.setBankcardno(dto.getBankcardno());
		
		//原票据修改
		oldPrepayDO.setFg_canc(FBoolean.TRUE);
		oldPrepayDO.setFg_rep_return(FBoolean.TRUE);
		oldPrepayDO.setDt_canc(BlFlowContextUtil.getNowTime());
		oldPrepayDO.setId_emp_canc(StringUtils.isNotEmpty(dto.getId_emp_pay())?dto.getId_emp_pay():Context.get().getStuffId());
		oldPrepayDO.setNote(IBlConst.NOTE_PREPAYREFUND);
		oldPrepayDO.setStatus(DOStatus.UPDATED);
		
		this.cudService.update(new BlPrePayPatDO[] { oldPrepayDO });
		
		return prepayDO;
	}
	/**
	 * 更新原纪录的已退金额
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	void updateOriginAmtRet(BlPrepayRDTO dto) throws BizException{
		
		BlPrePayPatDO oldPrepayDO = this.rService.findById(dto.getId_prepay_old());
		//如果原来的可退金额为空 则 取dto 中的金额，如果不为空 则用可退金额 减去 dto 中的金额
		FDouble amt_ret =oldPrepayDO.getAmt_ret()==null?dto.getAmt():oldPrepayDO.getAmt_ret().add(dto.getAmt());
		oldPrepayDO.setAmt_ret(amt_ret);
		this.cudService.update(new BlPrePayPatDO[] { oldPrepayDO });
	}
	
	/**
	 * 处理原票据
	 * @param oldPrepayId
	 * @param prepayDO
	 * @return
	 * @throws BizException
	 */
	void dealRcptOrigin(String oldPrepayId,BlPrePayPatDO prepayDO) throws BizException{
		
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
	
	/**
	 * 可退性校验
	 * @param prepayDO
	 * @param fgNew
	 */
	void validateCanRefundNew(BlPrePayPatDO prepayDO) throws BizException{
		
		//支付方式校验 TODO
		if(FBoolean.FALSE.equals(this.setDto.getFg_checkacc())){
			return;
		}
		
		//账户金额汇总校验
		BlAccountDTO account =  super.getAcc();
		if(prepayDO.getAmt().abs().compareTo(account.getAmt_bal()) > 0){
			throw new BizException("账户可用余额不足，无法退费");
		}
		
		//支付方式金额汇总校验
		if(!IBdPripmCodeConst.CODE_PRI_PM_CASH.equals(prepayDO.getSd_pm())){
			
			PrepayPatEP prepayEp = new PrepayPatEP();
			FDouble prepay = prepayEp.getPrepayByPm(prepayDO.getId_pm(), this.accTpyId, this.accType);
			
			if(prepayDO.getAmt().abs().compareTo(prepay) > 0){
				throw new BizException("该支付方式可用总金额不足，无法退费。可用总金额：" + prepay.toString());
			}
		}
	}
	
	/**
	 * 可退性校验
	 * @param prepayDO
	 * @param fgNew
	 */
	void validateCanRefundOrigin(BlPrePayPatDO prepayDO) throws BizException{
		
		if(FBoolean.TRUE.equals(prepayDO.getFg_canc())){
			throw new BizException("该预交金已作废，无法退费");
		}
		
		if(FBoolean.TRUE.equals(prepayDO.getFg_rep_return())){
			throw new BizException("该预交金已经消费，无法再次退费");
		}
		
		if(!FBoolean.FALSE.equals(this.setDto.getFg_checkacc())){
			//金额限制
			BlAccountDTO account =  super.getAcc();
			if(prepayDO.getAmt().abs().compareTo(account.getAmt_bal()) > 0){
				throw new BizException("账户可用余额不足，无法退费");
			}
		}
	}
}
