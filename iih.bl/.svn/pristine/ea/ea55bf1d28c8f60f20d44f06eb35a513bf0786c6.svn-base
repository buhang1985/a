package iih.bl.pay.s.bp.prepay;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.s.bp.util.PrepayAssembleUtil;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import iih.bl.pay.s.event.BlPrepayEvent;
import iih.bl.st.i.IBlStValidateService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 预交金充值
 * @author ly 2018/07/19
 *
 */
public class BlPrepayRechargeBP extends BlPrepayBaseBP{

	public BlPrepayRechargeBP(BlPrepaySetDTO setDto) {
		super(setDto);
	}
	
	/**
	 * 预交金充值
	 * @param dto 充值数据
	 * @return 预交金DO
	 * @throws BizException
	 */
	public BlPrePayPatDO exec(BlPrepayRDTO dto) throws BizException{
		
		this.validate(dto);
		
		this.analysisAccType(dto.getId_pat(), dto.getId_ent(), dto.getId_pecmpy());
		
		//重新判断是否需要进行票据管理
		if(FBoolean.TRUE.equals(this.setDto.getFg_useinc())){
			super.judgeIncManage();
			if(FBoolean.FALSE.equals(this.setDto.getFg_useinc())){
				dto.setCode_req(super.generateAutoCode());
			}
		}
		
		//组装预交金DO数据
		BlPrePayPatDO prepayDO = PrepayAssembleUtil.assembleChargeData(dto, accType);
		if(StringUtil.isEmpty(prepayDO.getId_paypat())){
			prepayDO.setId_paypat( new DBUtil().getOIDs(1)[0]);
		}
		
		//需要打印
		//if(FBoolean.TRUE.equals(this.setDto.getFg_print())){
		PrepayPatRcptEP prepayEp = new PrepayPatRcptEP();
		BlPrepayPatRcptDO rcptDO = null;
		if (FBoolean.TRUE.equals(this.setDto.getFg_useinc())) {
			rcptDO = prepayEp.saveRcptPrint(prepayDO, null);
		} else {
			rcptDO = prepayEp.saveRcptPrintWithCode(prepayDO, dto.getCode_req());
		}
		prepayDO.setCode_rep(rcptDO.getCode_rep());
		//}
		
		//保存
		prepayDO = this.cudService.save(new BlPrePayPatDO[] { prepayDO })[0];
		
		//需要更新账户
		if(FBoolean.TRUE.equals(this.setDto.getFg_accupdate())){
			this.chargeAcc(prepayDO.getAmt().multiply(prepayDO.getEu_direct()));
		}
		
		//发送预交金充值事件
		BlPrepayEvent.invokeCharge(prepayDO);
		
		return prepayDO;
	}
	
	/**
	 * 参数校验
	 * @param dto
	 * @throws BizException
	 */
	void validate(BlPrepayRDTO dto) throws BizException{
		
		if(dto == null){
			throw new ArgumentNullException("预交金充值", "充值数据");
		}
		
		if(StringUtil.isEmpty(dto.getId_pat()) 
				&& StringUtil.isEmpty(dto.getId_ent()) 
				&& StringUtil.isEmpty(dto.getId_pecmpy())){
			throw new BizException("预交金充值:确定类型的字段至少一个需要有值:患者id,就诊id,团检id");
		}
		
		if(dto.getAmt() == null || dto.getAmt().compareTo(FDouble.ZERO_DBL) <= 0){
			throw new BizException("预交金充值:金额不能为空或小于0");
		}
		
		if(StringUtil.isEmpty(dto.getSd_pttp())){
			throw new ArgumentNullException("预交金充值", "收费款终端");
		}
		
		if(StringUtil.isEmpty(dto.getId_pm()) || StringUtil.isEmpty(dto.getSd_pm())){
			throw new ArgumentNullException("预交金充值", "付款方式");
		}
		
		if(!StringUtil.isEmpty(dto.getId_ent())){
			
			IBlStValidateService validateService = ServiceFinder.find(IBlStValidateService.class);
			FBoolean isLap = validateService.isLeaveHosAndPay(dto.getId_ent());
			if(FBoolean.TRUE.equals(isLap)){
				throw new BizException("预交金充值:患者已经做了出院收付款业务，无法进行住院预交金充值");
			}
		}
		
		if(StringUtil.isEmpty(dto.getId_emp_pay())){
			dto.setId_emp_pay(Context.get().getStuffId());
		}
	}
}
