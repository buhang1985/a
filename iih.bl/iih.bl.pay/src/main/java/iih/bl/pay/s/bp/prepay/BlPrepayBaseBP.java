package iih.bl.pay.s.bp.prepay;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.comm.IBlConst;
import iih.bl.comm.util.BlAccountUtil;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pay.dto.account.d.BlAccountDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预交金操作base类 
 * TODO 所有子类BLPREPAY0007未处理
 * @author ly 2018/07/19
 *
 */
public class BlPrepayBaseBP {

	protected BlPrepaySetDTO setDto;//是否计算账户金额
	protected String accType;//账户类型
	protected String accTpyId;//查询账户对应的id
	
	protected IBlpaypatRService rService;
	protected IBlpaypatCudService cudService;
	
	protected IPrepaypatrcptCudService rcptCudService;
	
	public BlPrepayBaseBP(BlPrepaySetDTO setDto){
		this.setDto = setDto;
		
		if(this.setDto == null){
			this.setDto = new BlPrepaySetDTO();
		}
		
		if(this.setDto.getFg_print() == null){
			this.setDto.setFg_print(FBoolean.TRUE);
		}
		
		if(this.setDto.getFg_accupdate() == null){
			this.setDto.setFg_accupdate(FBoolean.TRUE);
		}
		
		if(this.setDto.getFg_useinc() == null){
			this.setDto.setFg_useinc(FBoolean.TRUE);
		}
		
		this.rService = ServiceFinder.find(IBlpaypatRService.class);
		this.cudService = ServiceFinder.find(IBlpaypatCudService.class);
		this.rcptCudService = ServiceFinder.find(IPrepaypatrcptCudService.class);
	}
	
	/**
	 * 分析账户类型
	 * @param patId
	 * @param entId
	 * @param pecmpyId
	 */
	protected void analysisAccType(String patId, String entId, String pecmpyId) {
		
		if(!StringUtil.isEmpty(pecmpyId)){
			this.accType = IBlConst.PREPAY_PEACC;
			this.accTpyId = pecmpyId;
		} else if (!StringUtil.isEmpty(entId)) {
			PatiVisitDO entDO = new PatiVisitDO();
			IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
			try {
				entDO = entService.findById(entId);
				if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(entDO.getCode_entp())) {
					this.accType = IBlConst.PREPAY_ETACC;
					this.accTpyId = patId;

				} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(entDO.getCode_entp()) || IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(entDO.getCode_entp())) {
					this.accType = IBlConst.PREPAY_IPACC;
					this.accTpyId = entId;
				}

			} catch (BizException e) {
				e.printStackTrace();
			}

		}
		else{
			this.accType = IBlConst.PREPAY_OPACC;
			this.accTpyId = patId;
		}
	}
	
	/**
	 * 充值账户
	 * @param amt
	 * @throws BizException
	 */
	protected void chargeAcc(FDouble amt) throws BizException{
		
		switch (this.accType) {
		case IBlConst.PREPAY_OPACC:
			IPatAccServiceExt opService = ServiceFinder.find(IPatAccServiceExt.class);
			opService.updatePatPrepay(this.accTpyId, amt);
			break;
		case IBlConst.PREPAY_IPACC:
			IEnOutCmdService ipService = ServiceFinder.find(IEnOutCmdService.class);
			ipService.recharge(this.accTpyId, amt);
			break;
		case IBlConst.PREPAY_PEACC:
			IEnOutCmdService peSerice = ServiceFinder.find(IEnOutCmdService.class);
			peSerice.cmpyRecharge(this.accTpyId, amt);
			break;
		case IBlConst.PREPAY_ETACC:
			IPatAccServiceExt etService = ServiceFinder.find(IPatAccServiceExt.class);
			etService.updatePatETPrePay(this.accTpyId, amt);
			break;
		default:
			throw new BizException("请在更新账户处理前调用账户类型分析方法");
		}
	}
	
	/**
	 * 获取账户余额
	 * @return
	 * @throws BizException
	 */
	protected BlAccountDTO getAcc() throws BizException{
		
		BlAccountDTO accDto = null;
		
		//暂时回写关键字段
		switch (this.accType) {
		case IBlConst.PREPAY_OPACC:
			IPatAccServiceExt opService = ServiceFinder.find(IPatAccServiceExt.class);
			PatRelAmountInfoDTO patAccInfo = opService.GetPatRelAmountInfo(this.accTpyId);
			accDto = BlAccountUtil.convertToBlDto(patAccInfo);
			break;
		case IBlConst.PREPAY_IPACC:
			IEnOutQryService ipService = ServiceFinder.find(IEnOutQryService.class);
			BalanceDTO ipAccInfo = ipService.getBalanceDTO(this.accTpyId);
			accDto = BlAccountUtil.convertToBlDto(ipAccInfo);
			break;
		case IBlConst.PREPAY_PEACC:
			IEnOutQryService peService = ServiceFinder.find(IEnOutQryService.class);
			BalanceDTO peAccInfo = peService.getPeCmpyBalance(this.accTpyId);
			accDto = BlAccountUtil.convertToBlDto(peAccInfo);
			break;
		case IBlConst.PREPAY_ETACC:
			IPatAccServiceExt etService = ServiceFinder.find(IPatAccServiceExt.class);
			PatRelAmountInfoDTO patEtAccInfo = etService.GetPatRelAmountInfo(this.accTpyId);
			accDto = BlAccountUtil.convertToBlDtoForEt(patEtAccInfo);
			break;
		default:
			throw new BizException("请在更新账户处理前调用账户类型分析方法");
		}
		
		accDto.setId_pk(this.accTpyId);
		return accDto;
	}
	
	/**
	 * 当红冲时修改原预交金数据
	 * @param oldPrepayDO
	 * @param note
	 * @throws BizException
	 */
	protected void modifyPrepayWhenRedReserve(BlPrePayPatDO oldPrepayDO, String note) throws BizException {
		oldPrepayDO.setFg_canc(FBoolean.TRUE);
		oldPrepayDO.setDt_canc(BlFlowContextUtil.getNowTime());
		oldPrepayDO.setId_emp_canc(Context.get().getStuffId());
		oldPrepayDO.setFg_rep_return(FBoolean.TRUE);
		if(!StringUtil.isEmpty(note)){
			oldPrepayDO.setNote(oldPrepayDO.getNote() + "->" + note);
		}
		oldPrepayDO.setStatus(DOStatus.UPDATED);
	}
	
	/**
	 * 修改原结转票据数据
	 * @param oldRcptDO
	 */
	protected void modifyRcptWhenRedReserve(BlPrepayPatRcptDO oldRcptDO){
		//增加判断是否为null（门诊不打票）  by lim 2018-08-02
		if(oldRcptDO==null){
			return;
		}
		oldRcptDO.setFg_rep_return(FBoolean.TRUE);
		oldRcptDO.setStatus(DOStatus.UPDATED);
	}
	
	/**
	 * 判断是否相同类型
	 * @param codeEntp
	 * @return
	 */
	protected boolean isSameType(String codeEntp){
		
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(codeEntp)
				&& IBlConst.PREPAY_OPACC.equals(this.accType)) {
			return true;
		}

		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(codeEntp)
				&& (IBlConst.PREPAY_IPACC.equals(this.accType) || IBlConst.PREPAY_PEACC.equals(this.accType))) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断是是否需要票据管理
	 * @param dto
	 * @throws BizException
	 * @return 返回无需票据管理时的预交金号
	 */
	protected void judgeIncManage() throws BizException{
		
		FBoolean autoCode = null;
		if(this.accType.equals(IBlConst.PREPAY_OPACC) || 
				(this.accType.equals(IBlConst.PREPAY_ETACC) && BlParams.BLST0002().equals(BlParamValueConst.BLST0002_OP))){
			autoCode = BlParams.BLINC0017();
		}else{
			autoCode = BlParams.BLINC0018();
		}
		
		if(FBoolean.TRUE.equals(autoCode)){
			this.setDto.setFg_useinc(FBoolean.FALSE);
		}
	}
	
	/**
	 * 非票据管理时生成预交金票号
	 * @param num
	 * @return
	 * @throws BizException
	 */
	protected String[] generateAutoCodes(int num) throws BizException {

		String[] codes = new String[num];
		if (this.accType.equals(IBlConst.PREPAY_OPACC)) {
			for (int i = 0; i < num; i++) {
				codes[i] = BlCodeUtils.generateOpPrepayCode();
			}
		} else {
			for (int i = 0; i < num; i++) {
				codes[i] = BlCodeUtils.generateIpPrepayCode();
			}
		}
		return codes;
	}
	
	/**
	 * 非票据管理时生成预交金票号
	 * @return
	 * @throws BizException
	 */
	protected String generateAutoCode() throws BizException {
		return this.generateAutoCodes(1)[0];
	}
}
