package iih.bl.st.s;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.st.blauditip.bp.BlAuditIpBp;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blcgipdto.d.BlStBaseInfo;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRltDTO;
import iih.bl.st.dto.d.BlOepQuickChargeDTO;
import iih.bl.st.dto.d.PaymentViewDTO;
import iih.bl.st.ettoipsettle.d.EtToIpSettleInfoDTO;
import iih.bl.st.i.IBlStCmdService;
import iih.bl.st.s.bp.CancelSettleBp;
import iih.bl.st.s.bp.DoIntegratedDepricingBp;
import iih.bl.st.s.bp.DoIpCancelSettlementBP;
import iih.bl.st.s.bp.DoIpSettlementBP;
import iih.bl.st.s.bp.DoPricedCiOderBp;
import iih.bl.st.s.bp.DoSignCiOrderBp;
import iih.bl.st.s.bp.DoTurnInsureBP;
import iih.bl.st.s.bp.EtToIpSettlementCancelBP;
import iih.bl.st.s.bp.GetCombinedValationItemBP;
import iih.bl.st.s.bp.IsTurnInsureBP;
import iih.bl.st.s.bp.OepQuickChargeBP;
import iih.bl.st.s.bp.ip.BlEtToIpStBP;
import iih.bl.st.s.bp.ip.BlStIpAuditAndStBP;
import iih.bl.st.s.bp.ip.IpStCancelTradeBP;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.mi.biz.dto.d.CommonPropDataDTO;
import iih.mi.miinsurebiz.etsettleparam.d.EtSettleRtnValDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 结算命令服务
 * 
 * @author yankan
 * @since 2017-06-15
 *
 */
@Service(serviceInterfaces = { IBlStCmdService.class }, binding = Binding.JSONRPC)
public class BlStCmdServiceImpl implements IBlStCmdService {

	/**
	 * 住院结算
	 * 
	 * @param id_pat
	 * @param id_ent
	 * @param id_dep
	 * @param id_emp
	 * @param dt_end
	 * @return
	 * @throws BizException
	 * @author liwq
	 * @since 2017-7-13 11:33:26
	 */
	public String doSettlement(String id_pat, String id_ent, String id_dep,
			String id_emp, FDateTime dt_end) throws BizException {
		DoIpSettlementBP settleBp = new DoIpSettlementBP();
		return settleBp.exec(id_pat, id_ent, id_dep, id_emp, dt_end);
	}
	/**
	 * 住院结算-选中结算范围
	 */
	public String doSettlementByCgIps( String id_ent, String id_emp,String[] idCgIps) throws BizException {
		DoIpSettlementBP settleBp = new DoIpSettlementBP();
		return settleBp.exec(id_ent, id_emp, idCgIps);
	}

	/**
	 * 住院取消结算
	 * 
	 * @param blStIpDO
	 *            结算DO
	 * @return
	 * @throws BizException
	 * @author liwq
	 * @since 2017-7-13 11:33:26
	 */
	public FBoolean doCancelSettlement(BlStIpDO blStIpDO) throws BizException {
		DoIpCancelSettlementBP cancelSettleBp = new DoIpCancelSettlementBP();
		return cancelSettleBp.exec(blStIpDO);
	}
	
	/**
	 * 住院取消出纳
	 * @param stIpId 结算id
	 * @return 患者预交金患者记录
	 * @throws BizException
	 * @author ly 2018/04/24
	 */
	public void cancelTrade(String idEnt, String stIpId, FBoolean isSaveProp) throws BizException{
		IpStCancelTradeBP bp = new IpStCancelTradeBP();
		bp.exec(idEnt,stIpId,isSaveProp);
	}

	/**
	 * 铜陵门诊收费单版
	 * 
	 * @param regPat
	 * @param dep_ent
	 * @param chargeItemArr
	 * @return
	 * @throws BizException
	 */
	public BlCgOepAggDTO doPricingFee(OpRegPatDTO regPat,
			BlOrderAppendBillParamDTO[] chargeItemArr,
			OperatorInfoDTO psnInfoDto) throws BizException {
		DoPricedCiOderBp bp = new DoPricedCiOderBp();
		return bp.exec(regPat, chargeItemArr, psnInfoDto);
	}

	
	@Override
	public BlCgOepAggDTO doSignCiOrder(OpRegPatDTO regPat, BlOrderAppendBillParamDTO[] chargeItemArr,
			OperatorInfoDTO psnInfoDto) throws BizException {
		DoSignCiOrderBp handlerBp=new DoSignCiOrderBp();
		return handlerBp.exec(regPat, chargeItemArr, psnInfoDto);
	}

	/**
	 * 一体化取消（删除相应的记账表和医嘱信息）
	 * 
	 * @param id_cgArr
	 *            (已记账的主键id)
	 * @return
	 * @throws BizException
	 */
	public FBoolean doIntegratedDepricing(String[] id_cgArr)
			throws BizException {
		DoIntegratedDepricingBp bp = new DoIntegratedDepricingBp();
		return bp.exec(id_cgArr);
	}

	/**
	 * 保存住院审核（insert新记录）
	 * 
	 * @param 患者就诊id_ent
	 * @param OperatorInfoDTO
	 *            个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp saveIpAudit(String id_ent, OperatorInfoDTO operatorInfoDTO)
			throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.saveIpAudit(id_ent, operatorInfoDTO);
	}

	/**
	 * 取消住院审核（更新住院审核标志）
	 * 
	 * @param 费用已审核记录主键id_auditip
	 * @param OperatorInfoDTO
	 *            个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp cancelIpAudit(BlAuditIp auditIp,
			OperatorInfoDTO operatorInfoDTO) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.cancelIpAudit(auditIp, operatorInfoDTO);
	}

	/**
	 * 医保审核（更新医保审核标志）
	 * 
	 * @param 费用已审核记录主键id_auditip
	 * @param OperatorInfoDTO
	 *            个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp saveHpAudit(String idEnt, OperatorInfoDTO operatorInfoDTO)
			throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.saveHpAudit(idEnt, operatorInfoDTO);
	}

	/**
	 * 取消医保审核（更新医保审核标志）
	 * 
	 * @param id_auditip
	 * @param OperatorInfoDTO
	 *            个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp cancelHpAudit(BlAuditIp blAuditIp,
			OperatorInfoDTO operatorInfoDTO) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.cancelHpAudit(blAuditIp, operatorInfoDTO);
	}

	/**
	 * 根据就诊id对患者就诊账户进行冻结或解封
	 * 
	 * @param bFlag
	 *            真：冻结 假：解封
	 * @param id_ent
	 * @author liwq
	 */
	public FBoolean doFreezeEnAccBoolean(String id_ent, String id_emp,
			FBoolean bFlag) throws BizException {
		BlAuditIpBp getBlAuditIpBp = new BlAuditIpBp();
		return getBlAuditIpBp.doFreezeEnAccBoolean(id_ent, id_emp, bFlag);
	}

	/**
	 * 住院取消结算(改造)
	 * 
	 * @param blStBaseInfo
	 * @return
	 * @author liwenqiang
	 */
	public FBoolean DoCancelSettlementReform(BlStBaseInfo blStBaseInfo)
			throws BizException {
		CancelSettleBp bp=new CancelSettleBp();
		return bp.exec(blStBaseInfo);
	}
	/**
	 * 自费转医保功能
	 * 
	 * @param idEns
	 *            就诊编号集合
	 * @param noHp
	 *            医保卡号
	 * @throws BizException
	 * @author liwq
	 */
	@Override
	public void doTurnInsure(String[] idEns, String noHp,String idHp) throws BizException {
		DoTurnInsureBP bp = new DoTurnInsureBP();
		bp.exec(idEns, noHp,idHp);
	}
	
	/**
	 * 是否已经是医保患者 如果是报出异常
	 * @param idEns
	 */
	@Override
	public void isTurnInsure(String[] idEns) throws BizException {
		IsTurnInsureBP bp=new IsTurnInsureBP();
		bp.exec(idEns);
	}
	
	/**
	 * 自动审核结算全部费用(出院结算)
	 * @param entId 就诊id
	 * @return 结算do
	 * @throws BizException
	 * @author ly 2019/04/08
	 */
	@Override
	public BlStIpDO auditAndSettlement(String entId) throws BizException{
		BlStIpAuditAndStBP bp = new BlStIpAuditAndStBP();
		return bp.exec(entId);
	}
	
	/**
	 * 急诊转住院费用结算
	 * @param entId 住院患者就诊ID
	 * @param cgOepIds 转移门诊数据记账id
	 * @param propData 医保分摊数据
	 * @return 预交金充值记录
	 * @author LIM 2019/07/02
	 * @throws BizException 
	 */
	@Override
	public BlPrePayPatDO[] etToIpSettlement(EtToIpSettleInfoDTO stInfoDto,String[] cgOepIds,CommonPropDataDTO propData,EtSettleRtnValDTO hpPayRtnValDto) throws BizException
	{
		BlEtToIpStBP bp= new BlEtToIpStBP();
		return bp.exec(stInfoDto, cgOepIds, propData,hpPayRtnValDto);
	}
	
	/**
	 * 急诊转住院结算撤销
	 * @param stPropxyhpId
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[] etToIpSettlementCancel(String stPropxyhpId)throws BizException
	{
		EtToIpSettlementCancelBP bp=new EtToIpSettlementCancelBP();
		return bp.exec(stPropxyhpId);
	}
	/**
	 * 获取组合计价对应的服务明细
	 * @param id_srv_comp
	 * @param id_pripat
	 * @return
	 * @throws BizException 
	 */
	public BlOrderAppendBillParamDTO[] getCombinedValationItem(String id_srv_comp,String id_pripat) throws BizException{
		GetCombinedValationItemBP bp = new GetCombinedValationItemBP();
		return bp.exec(id_srv_comp, id_pripat);
	}

	/**
	 * 门诊快捷收费（划价+收付款）
	 */
	@Override
	public BlPayOepRltDTO oepQuickCharge(BlOepQuickChargeDTO[] selectDTOArr, PaymentViewDTO[] amtPayArr,BlPayOepPmDTO changeInfo, Boolean blInc0028) throws BizException {
		OepQuickChargeBP bp = new OepQuickChargeBP();
		return bp.exec(selectDTOArr, amtPayArr,changeInfo,blInc0028);
	}

}
