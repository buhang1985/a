package iih.bl.st.i;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blcgipdto.d.BlStBaseInfo;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRltDTO;
import iih.bl.st.dto.d.BlOepQuickChargeDTO;
import iih.bl.st.dto.d.PaymentViewDTO;
import iih.bl.st.ettoipsettle.d.EtToIpSettleInfoDTO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.mi.biz.dto.d.CommonPropDataDTO;
import iih.mi.miinsurebiz.etsettleparam.d.EtSettleRtnValDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 结算命令服务
 * @author yankan
 * @since 2017-06-15
 *
 */
public interface IBlStCmdService {

	/**
	 * 住院结算
	 * 
	 * @param id_pat
	 * @param id_ent
	 * @param id_dep
	 * @param id_emp
	 * @param dt_end
	 * @return 结算id
	 * @throws BizException
	 * @author liwq
	 * @since 2017-7-13 11:33:26
	 */
	public String doSettlement(String id_pat, String id_ent, String id_dep, String id_emp, FDateTime dt_end) throws BizException ;
	
	/**
	 * 住院结算-根据记账信息结算
	 * @param id_pat
	 * @param id_ent
	 * @param id_emp
	 * @param idCgIps
	 * @return
	 * @throws BizException
	 */
	public String doSettlementByCgIps(String id_ent, String id_emp,String[] idCgIps) throws BizException ;
	/**
	 * 住院取消结算(改造)
	 * 
	 * @param blStIpDO 结算DO
	 * @return
	 * @throws BizException
	 * @author liwq
	 * @since 2017-7-13 11:33:26
	 */
	public FBoolean doCancelSettlement(BlStIpDO blStIpDO) throws BizException ;

	/**
	 * 住院取消出纳
	 * @param stIpId 结算id
	 * @return 患者预交金患者记录
	 * @throws BizException
	 * @author ly 2018/04/24
	 */
	public abstract void cancelTrade(String idEnt, String stIpId, FBoolean isSaveProp) throws BizException;
	
	/**
	 * 一体化划价(注册挂号，开立医嘱，划价）
	 * @param regPat
	 * @param dep_ent
	 * @param chargeItemArr
	 * @param psnInfoDto
	 * @return
	 * @throws BizException
	 */
	public BlCgOepAggDTO doPricingFee(OpRegPatDTO regPat, BlOrderAppendBillParamDTO[] chargeItemArr, OperatorInfoDTO psnInfoDto) throws BizException ;
	
	
	/**
	 * 便民工作站，只生成处方不直接划价
	 * @param regPat
	 * @param chargeItemArr
	 * @param psnInfoDto
	 * @return
	 * @throws BizException
	 */
	public BlCgOepAggDTO doSignCiOrder(OpRegPatDTO regPat, BlOrderAppendBillParamDTO[] chargeItemArr, OperatorInfoDTO psnInfoDto) throws BizException;
	/**
	 * 一体化取消（删除相应的记账表和医嘱信息）
	 * @param id_cgArr(已记账的主键id)
	 * @return
	 * @throws BizException
	 */
	public FBoolean doIntegratedDepricing(String[] id_cgArr) throws BizException;
	
	/**
	 * 保存住院审核（insert新记录）
	 * @param 患者就诊id_ent
	 * @param OperatorInfoDTO 个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp saveIpAudit(String id_ent, OperatorInfoDTO operatorInfoDTO) throws BizException;
	
	/**
	 * 取消住院审核（更新住院审核标志）
	 * @param 费用已审核记录主键id_auditip
	 * @param OperatorInfoDTO 个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp cancelIpAudit(BlAuditIp auditIp, OperatorInfoDTO operatorInfoDTO) throws BizException;
	
	/**
	 * 医保审核（更新医保审核标志）
	 * @param 费用已审核记录主键id_auditip
	 * @param OperatorInfoDTO 个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp saveHpAudit(String id_ent, OperatorInfoDTO operatorInfoDTO) throws BizException;
	
	/**
	 * 取消医保审核（更新医保审核标志）
	 * @param id_auditip
	 * @param OperatorInfoDTO 个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp cancelHpAudit(BlAuditIp auditip, OperatorInfoDTO operatorInfoDTO) throws BizException;
	
	/**
	 * 根据就诊id对患者就诊账户进行冻结或解封
	 * @param bFlag 真：冻结  假：解封
	 * @param id_ent
	 * @author liwq
	 */
	public FBoolean doFreezeEnAccBoolean(String id_ent,String id_emp, FBoolean bFlag) throws BizException;
	
	/**
	 * 住院取消结算(改造)
	 * @param blStBaseInfo
	 * @return
	 * @author liwenqiang
	 */
	public FBoolean DoCancelSettlementReform(BlStBaseInfo blStBaseInfo) throws BizException;
	
	/**
	 * 自费转医保功能
	 * @param idEns 就诊编号集合
	 * @param noHp 医保卡号
	 * @throws BizException
	 * @author yang.lu
	 */
	public abstract void doTurnInsure(String[] idEns, String noHp, String idHp) throws BizException;
	

	/**
	 * 是否已经是医保患者 如果是报出异常
	 * @param idEns 就诊编号集合
	 * @throws BizException
	 * @author yang.lu
	 */
	public abstract void isTurnInsure(String[] idEns) throws BizException;
	
	/**
	 * 自动审核结算全部费用(出院结算)
	 * @param entId 就诊id
	 * @return 结算do
	 * @throws BizException
	 * @author ly 2019/04/08
	 */
	public abstract BlStIpDO auditAndSettlement(String entId) throws BizException;
	/**
	 * 急诊转住院费用结算
	 * @param entId 住院患者就诊ID
	 * @param cgOepIds 转移门诊数据记账id
	 * @param propData 医保分摊数据
	 * @return 预交金充值记录
	 * @throws BizException
	 */
	public abstract BlPrePayPatDO[] etToIpSettlement(EtToIpSettleInfoDTO stInfoDto,String[] cgOepIds,CommonPropDataDTO propData,EtSettleRtnValDTO hpPayRtnValDto) throws BizException;

	/**
	 * 急诊转住院结算撤销
	 * @param stPropxyhpId
	 * @return
	 * @throws BizException
	 */
	public abstract BlPrePayPatDO[] etToIpSettlementCancel(String stPropxyhpId)throws BizException;
	/**
	 * 获取组合计价对应的服务明细
	 * @param id_srv_comp
	 * @param id_pripat
	 * @return
	 * @throws BizException 
	 */
	public abstract  BlOrderAppendBillParamDTO[] getCombinedValationItem(String id_srv_comp,String id_pripat) throws BizException;
	
	/**
	 * 门诊快捷收费（划价+收付款）
	 * @param selectDTOArr
	 * @param amtPayArr
	 * @param blInc0028
	 * @return
	 * @throws BizException
	 */
	public abstract BlPayOepRltDTO oepQuickCharge(BlOepQuickChargeDTO[] selectDTOArr, PaymentViewDTO[] amtPayArr, BlPayOepPmDTO changeInfo, Boolean blInc0028) throws BizException;
}
