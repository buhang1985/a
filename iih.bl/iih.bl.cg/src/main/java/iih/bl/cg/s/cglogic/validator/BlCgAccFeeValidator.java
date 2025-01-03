package iih.bl.cg.s.cglogic.validator;

import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountBizDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.cg.s.cglogic.util.BlCgDataUtil;
import iih.bl.comm.IBlConst;
import iih.bl.comm.dto.d.BlPrepayWarnHitDTO;
import iih.bl.comm.util.BlAccountUtil;
import iih.bl.comm.util.BlPrepayWarnUtil;
import iih.bl.pay.dto.account.d.BlAccountDTO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;

import java.math.BigDecimal;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 记账费用校验器
 * @author ly 2018/06/27
 *
 */
public class BlCgAccFeeValidator {

	private BlCgAccountSetDTO accSetDto;//记账配置
	private BlCgOpAccountSetDTO opAccSetDto;//门诊记账配置
	
	public BlCgAccFeeValidator(BlCgAccountSetDTO accSetDto){
		this.accSetDto = accSetDto;
	}
	
	public BlCgAccFeeValidator(BlCgOpAccountSetDTO opAccSetDto){
		this.opAccSetDto = opAccSetDto;
	}
	
	/**
	 * 住院个人账户及团体记账费用校验
	 * @param accBizList 记账数据(单患者)
	 * @param balanceDto 账户可用余额数据
	 * @param pebalanceDto 团检账户可用余额数据
	 * @throws BizException
	 */
	public void validate(List<BlCgAccountBizDTO> accBizList,
			BalanceDTO balanceDto, BalanceDTO pebalanceDto, PatiVisitDO enDO,
			BdPreWarnDO[] warnDos) throws BizException {
		
		FDouble sum = new FDouble(0);
		FDouble pesum = new FDouble(0);
		for (BlCgAccountBizDTO bizDto : accBizList) {
			
			if(bizDto.getPrice_std() == null || bizDto.getPrice_ratio() == null){
				throw new BizException("价格获取失败,服务:" + bizDto.getId_srv());
			}
			
			if(bizDto.getRatio_pripat() == null){
				throw new BizException("价格系数获取失败,服务:" + bizDto.getId_srv());
			}
			
			if(FBoolean.TRUE.equals(this.accSetDto.getFg_postpaid()))
				continue;
			
			FDouble amt = bizDto.getPrice_ratio().multiply(bizDto.getQuan(), IBlConst.PRECISION_AMOUNT).multiply(bizDto.getEu_direct());
			if(FBoolean.TRUE.equals(bizDto.getFg_pay_unit())){
				pesum =  pesum.add(amt);
			}else{
				sum = sum.add(amt);
			}
		}
		
		if(FBoolean.TRUE.equals(this.accSetDto.getFg_postpaid()))
			return;
		
		//获取实际可用金额
		BlPrepayWarnHitDTO hitDto = new BlPrepayWarnHitDTO();
		hitDto.SetDepId(enDO.getId_dep_phy());
		hitDto.SetNurId(enDO.getId_dep_nur());
		hitDto.SetPatcaId(enDO.getId_patca());
		//获取医保就诊信息
		List<EntHpDO> entHpList = BlCgDataUtil.getEnHpData(new String[]{enDO.getId_ent()});
		if(!ListUtil.isEmpty(entHpList)){
			hitDto.SetHppatcaId(entHpList.get(0).getId_hppatca());
		}
		
		BdPreWarnDO warnDO = BlPrepayWarnUtil.hitPreWarnSetting(warnDos,hitDto);
		BlAccountDTO blAccDto = BlAccountUtil.convertToBlDto(balanceDto);
		FDouble amtLimit = BlAccountUtil.calcAccBalance(blAccDto, warnDO);
		
		if(sum.compareTo(amtLimit) > 0){
			FDouble sub = sum.sub(amtLimit).setScale(IBlConst.PRECISION_AMOUNT, BigDecimal.ROUND_HALF_UP);
			throw new BizException("不支持后付费，本次记账金额大于账户可用金额,患者:" + accBizList.get(0).getName_pat() + ""
					+ " 差额:" + sub.toString());
		}
		
		if (pebalanceDto != null) {
			if (pesum.compareTo(pebalanceDto.getAvailable()) > 0) {
				throw new BizException("不支持后付费，本次记账金额大于团体账户可用金额,患者:" + accBizList.get(0).getName_pat());
			}
		}
	}
	
	/**
	 * 门诊个人账户费用校验
	 * @param accBizList
	 * @param balanceDto
	 * @throws BizException
	 */
	public void validate(List<BlCgAccountBizDTO> accBizList, PatRelAmountInfoDTO balanceDto) throws BizException{
		
		FDouble sum = new FDouble(0);
		for (BlCgAccountBizDTO bizDto : accBizList) {
			
			if(bizDto.getPrice_std() == null || bizDto.getPrice_ratio() == null){
				throw new BizException("价格获取失败,服务:" + bizDto.getId_srv());
			}
			
			if(bizDto.getRatio_pripat() == null){
				throw new BizException("价格系数获取失败,服务:" + bizDto.getId_srv());
			}
			
			if(!OepCgModeEnum.PREPAY_CG.equals(this.opAccSetDto.getEu_oepcgmode()))
				continue;
		
			FDouble amt = bizDto.getPrice_ratio().multiply(bizDto.getQuan(), IBlConst.PRECISION_AMOUNT).multiply(bizDto.getEu_direct());
			sum = sum.add(amt);
		}
		
		if(sum.compareTo(balanceDto.getMoney_canuse()) > 0){
			throw new BizException("患者:" + accBizList.get(0).getName_pat() + "预交金不足，不支持预交金记账。本次待记账金额:"
					+ sum.setScale(IBlConst.PRECISION_AMOUNT, BigDecimal.ROUND_HALF_UP).toString() + " 账户可用余额:"
					+ balanceDto.getMoney_canuse().setScale(IBlConst.PRECISION_AMOUNT, BigDecimal.ROUND_HALF_UP).toString() + " 差额:"
					+ sum.sub(balanceDto.getMoney_canuse()).setScale(IBlConst.PRECISION_AMOUNT, BigDecimal.ROUND_HALF_UP).toString());
		}
	}

	/**
	 * 急诊个人账户费用校验
	 * @param accBizList
	 * @param balanceDto
	 * @throws BizException
	 */
	public void validateEt(List<BlCgAccountBizDTO> accBizList, PatRelAmountInfoDTO balanceDto) throws BizException{
		
		FDouble sum = new FDouble(0);
		for (BlCgAccountBizDTO bizDto : accBizList) {
			
			if(bizDto.getPrice_std() == null || bizDto.getPrice_ratio() == null){
				throw new BizException("价格获取失败,服务:" + bizDto.getId_srv());
			}
			
			if(bizDto.getRatio_pripat() == null){
				throw new BizException("价格系数获取失败,服务:" + bizDto.getId_srv());
			}
		
			FDouble amt = bizDto.getPrice_ratio().multiply(bizDto.getQuan()).multiply(bizDto.getEu_direct());
			sum = sum.add(amt);
		}
		
		if(this.accSetDto != null){
			if(FBoolean.TRUE.equals(this.accSetDto.getFg_postpaid()))
				return;
		}
		
		if(this.opAccSetDto != null){
			if(FBoolean.TRUE.equals(this.opAccSetDto.getFg_postpaid()))
				return;
		}
		
		if(sum.compareTo(balanceDto.getMoney_canuse_emgstay()) > 0){
			throw new BizException("患者:" + accBizList.get(0).getName_pat() + "账户余额不足，不支持记账。本次待记账金额:"
					+ sum.setScale(IBlConst.PRECISION_AMOUNT, BigDecimal.ROUND_HALF_UP).toString() + " 账户可用余额:"
					+ balanceDto.getMoney_canuse_emgstay().setScale(IBlConst.PRECISION_AMOUNT, BigDecimal.ROUND_HALF_UP).toString() + " 差额:"
					+ sum.sub(balanceDto.getMoney_canuse_emgstay()).setScale(IBlConst.PRECISION_AMOUNT, BigDecimal.ROUND_HALF_UP).toString());
		}
	}
}
