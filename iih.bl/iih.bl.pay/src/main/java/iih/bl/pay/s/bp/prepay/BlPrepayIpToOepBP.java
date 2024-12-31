package iih.bl.pay.s.bp.prepay;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.s.bp.util.PrepayAssembleUtil;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 预交金退充值
 * @author hanjq 2020/05/12
 *
 */
public class BlPrepayIpToOepBP extends BlPrepayBaseBP{

	public BlPrepayIpToOepBP(BlPrepaySetDTO setDto) {
		super(setDto);
	}

	/**
	 * 预住院预交金转门诊
	 * 两种模式:1.按主键退原记录 2.按照输入金额退3.根据主键原记录半退
	 * @param dto 退充值数据
	 * @return 预交金DO
	 * @throws BizException
	 */
	public BlPrePayPatDO exec(BlPrepayRDTO dto) throws BizException{
		this.refundIp(dto);
		
		dto.setEu_direct(1);
		dto.setId_prepay_old(null);
		dto.setId_ent(null);
		
		return this.rechargeOep(dto);
	}
	
	/**
	 * 退预交金
	 * @param dto
	 * @throws BizException
	 */
	private void refundIp(BlPrepayRDTO dto) throws BizException{
		BlPrepayRefundBP bp = new BlPrepayRefundBP(this.setDto);
		bp.validate(dto);		
		bp.analysisAccType(dto.getId_pat(), dto.getId_ent(), dto.getId_pecmpy());
		
		//重新判断是否需要进行票据管理
		if(FBoolean.TRUE.equals(bp.setDto.getFg_useinc())){
			bp.judgeIncManage();
		}
		
		BlPrePayPatDO prepayDO = null;
		String pk = new DBUtil().getOIDs(1)[0];
		
		PrepayPatRcptEP rcptEp = new PrepayPatRcptEP();
		if(StringUtil.isEmpty(dto.getId_prepay_old())){
			//处理预交金  产生新一条记录
			prepayDO = bp.dealPrepayNew(dto);
			prepayDO.setId_paypat(pk);
			//可退性校验
			bp.validateCanRefundNew(prepayDO);
			//处理票据
			BlPrepayPatRcptDO rcptDO = null;
			if (FBoolean.TRUE.equals(bp.setDto.getFg_useinc())) {
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
			prepayDO = bp.dealPrepayNew(dto);
			prepayDO.setId_paypat(pk);
			//退费主键
			prepayDO.setId_par(dto.getId_prepay_old());
			//更新原纪录 可退金额字段
			bp.updateOriginAmtRet(dto);
			//处理票据
			BlPrepayPatRcptDO rcptDO = null;
			if (FBoolean.TRUE.equals(bp.setDto.getFg_useinc())) {
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
			prepayDO = bp.dealPrepayOrigin(dto);
			prepayDO.setId_paypat(pk);
			//可退性校验
			bp.validateCanRefundOrigin(prepayDO);
			//处理票据
			bp.dealRcptOrigin(dto.getId_prepay_old(), prepayDO);
		}
		
		//保存预交金
		prepayDO = this.cudService.insert(new BlPrePayPatDO[] { prepayDO })[0];
		
		//需要更新账户
		if(FBoolean.TRUE.equals(this.setDto.getFg_accupdate())){
			bp.chargeAcc(prepayDO.getAmt().multiply(prepayDO.getEu_direct()));
		}		
	}
	
	private BlPrePayPatDO rechargeOep(BlPrepayRDTO dto) throws BizException{
		BlPrepayRechargeBP bp = new BlPrepayRechargeBP(this.setDto);
		
		
		bp.validate(dto);
		
		bp.analysisAccType(dto.getId_pat(), dto.getId_ent(), dto.getId_pecmpy());
		
		//重新判断是否需要进行票据管理
		if(FBoolean.TRUE.equals(bp.setDto.getFg_useinc())){
			bp.judgeIncManage();
			if(FBoolean.FALSE.equals(bp.setDto.getFg_useinc())){
				dto.setCode_req(bp.generateAutoCode());
			}
		}
		
		//组装预交金DO数据
		BlPrePayPatDO prepayDO = PrepayAssembleUtil.assembleChargeData(dto, bp.accType);
		if(StringUtil.isEmpty(prepayDO.getId_paypat())){
			prepayDO.setId_paypat( new DBUtil().getOIDs(1)[0]);
		}
		
		//需要打印
		//if(FBoolean.TRUE.equals(this.setDto.getFg_print())){
		PrepayPatRcptEP prepayEp = new PrepayPatRcptEP();
		BlPrepayPatRcptDO rcptDO = null;
		if (FBoolean.TRUE.equals(bp.setDto.getFg_useinc())) {
			rcptDO = prepayEp.saveRcptPrint(prepayDO, null);
		} else {
			rcptDO = prepayEp.saveRcptPrintWithCode(prepayDO, dto.getCode_req());
		}
		prepayDO.setCode_rep(rcptDO.getCode_rep());
		//}
		
		//保存
		prepayDO = this.cudService.save(new BlPrePayPatDO[] { prepayDO })[0];
		
		//需要更新账户
		if(FBoolean.TRUE.equals(bp.setDto.getFg_accupdate())){
			bp.chargeAcc(prepayDO.getAmt().multiply(prepayDO.getEu_direct()));
		}
		return prepayDO;
	}
	
}
