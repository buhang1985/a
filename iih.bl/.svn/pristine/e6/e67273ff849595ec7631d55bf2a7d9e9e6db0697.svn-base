package iih.bl.cg.s;

import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.bp.DrawbackAccDrugBP;
import iih.bl.cg.bp.oep.ChangeOpRegEntBP;
import iih.bl.cg.dto.alwaysor.d.BlCgAlwaysOrCgInfoDTO;
import iih.bl.cg.dto.cgonlycode.d.BlCgOnlycodeDTO;
import iih.bl.cg.dto.d.BlCgSelfPayDTO;
import iih.bl.cg.i.IBlOutCmdService;
import iih.bl.cg.s.bp.UpdateBlCgIpFgSelfPayBP;
import iih.bl.cg.s.bp.ip.BlCgRefundAlwaysOrBP;
import iih.bl.cg.s.bp.ip.BlCgWriteBackOnlycodeIpBP;
import iih.bl.cg.s.bp.ip.BlIpChargeForIpRegisterBP;
import iih.bl.cg.s.bp.ip.BlTurnDeptChargeBP;
import iih.bl.cg.s.bp.ip.IpOrdChargeBP;
import iih.bl.cg.s.bp.ip.NurseOrdChargeBP;
import iih.bl.cg.s.bp.ip.OutDeptChargeBP;
import iih.bl.cg.s.bp.ip.PrnOrdChargeBP;
import iih.bl.cg.s.bp.op.BlCgWriteBackOnlycodeOpBP;
import iih.bl.cg.s.bp.op.BlRefundForOpRegisterBP;
import iih.bl.cg.s.bp.op.RefundForOpIdOrsBP;
import iih.bl.cg.s.cglogic.pkgbp.ChareForOpPrepayOrBP;
import iih.bl.cg.service.d.CgTypeEnum;
import iih.bl.cg.service.s.bp.SetOrderAppendBillToCgBP;
import iih.bl.cg.service.s.bp.SetOrderRefundBillToCgBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 费用对外命令服务
 * 
 * @author yankan
 * @since 2017-06-19
 *
 */
@Service(serviceInterfaces = { IBlOutCmdService.class }, binding = Binding.JSONRPC)
public class BlOutCmdServiceImpl implements IBlOutCmdService {
	/**
	 * 执行住院后台划价
	 * 
	 * @param patId 患者ID
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public void execIpCgTask(String patId, FDateTime cgEndTime) throws BizException {
		// 和出院逻辑在同一事务，无需另起事务，且不允许部分成功
		OutDeptChargeBP chargeBP = new OutDeptChargeBP();
		chargeBP.exec(patId, cgEndTime);
	}
	/**
	 * 执行住院医嘱记费
	 * 护理、持续医嘱
	 * @param patId 患者ID
	 * @param cgEndTime 计费时间
	 * @throws BizException
	 */
	@Override
	public void chargeIpOrd(String patId,FDateTime cgEndTime) throws BizException{
		IpOrdChargeBP chargeBP = new IpOrdChargeBP();
		chargeBP.exec(patId, cgEndTime);
	}
	/**
	 * 持续医嘱计费
	 * @param patId 患者ID
	 * @param ordIds 医嘱ID集合
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public void chargePrnOrd(String patId,String[] ordIds,FDateTime cgEndTime) throws BizException{
		PrnOrdChargeBP chargeBP = new PrnOrdChargeBP();
		chargeBP.exec(patId, ordIds, cgEndTime);
	}
	/**
	 * 护理医嘱计费
	 * @param patId 患者ID
	 * @param ordIds 医嘱ID集合
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public void chargeNurse(String patId,String[] ordIds,FDateTime cgEndTime) throws BizException{
		NurseOrdChargeBP chargeBP = new NurseOrdChargeBP();
		chargeBP.exec(patId, ordIds, cgEndTime);
	}
	/**
	 * 出院记账
	 * @param patId 患者ID
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public void chargeOutDept(String patId,FDateTime cgEndTime) throws BizException{
		OutDeptChargeBP chargeBP = new OutDeptChargeBP();
		chargeBP.exec(patId, cgEndTime);
	}
	
	/**
	 * 出院记账(就诊id)
	 * @param entId 就诊id
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author ly 2018/11/13
	 */
	@Override
	public void chargeOutDeptByEntId(String entId, FDateTime cgEndTime) throws BizException{
		OutDeptChargeBP chargeBP = new OutDeptChargeBP();
		chargeBP.exec2(entId, cgEndTime);
	}
	
	/**
	 * 转科记账
	 * @param patId
	 * @param cgEndTime
	 * @throws BizException
	 */
	@Override
	public void chargeTurnDept(String patId, FDateTime cgEndTime)throws BizException {
		BlTurnDeptChargeBP bp = new BlTurnDeptChargeBP();
		bp.exec(patId, cgEndTime);
	}
	
	/**
	 * 转科记账(就诊id)
	 * @param entId 就诊id
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author ly 2019/01/31
	 */
	@Override
	public void chargeTurnDeptByEntId(String entId, FDateTime cgEndTime) throws BizException{
		BlTurnDeptChargeBP bp = new BlTurnDeptChargeBP();
		bp.exec2(entId, cgEndTime);
	}
	
	
	/**
	 * 退记账的药品
	 * @param entId 就诊ID
	 * @param backDrugMap 退药品MAP，[key:医嘱服务ID，value:需退数量]
	 * @throws BizException
	 * @author yankan
	 * @author yanglu
	 */
	@Override
	public void drawbackAccDrug(String entId,Map<String,FDouble> backDrugMap) throws BizException{
		DrawbackAccDrugBP drawbackBP = new DrawbackAccDrugBP();
		drawbackBP.exec(entId, backDrugMap);
	}	
	/**
	 * 改变门诊挂号就诊
	 * 将之前的费用明细进行红冲，并修改就诊ID
	 * @param cgId 原挂号记账ID
	 * @param targetEntId 目标就诊ID
	 * @return 新的记账ID
	 * @throws BizException
	 * @author 
	 */
	@Override
	public String changeOpRegEnt(String cgId,String targetEntId) throws BizException{
		ChangeOpRegEntBP changeEntBP = new ChangeOpRegEntBP();
		return changeEntBP.exec(cgId, targetEntId);
	}
	
	/**
	 * 入院登记自动记账
	 * @param entId 就诊id
	 * @param fgFirst 是否首次入院                   
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean chargeForIpRegister(String entId,FBoolean fgFirst) throws BizException{
		BlIpChargeForIpRegisterBP bp = new BlIpChargeForIpRegisterBP();
		return bp.exec(entId,fgFirst);
	}
	
	/**
	 * 门诊预付费记账
	 * @param entId
	 * @param empId
	 * @param ordIds
	 * @param srcFunc
	 * @return
	 * @throws BizException
	 * @author ly 2018/04/17
	 */
	@Override
	public  BlOrderAppendBillParamDTO[] chargeForOpPrepay(String entId, String empId, String[] ordIds,String srcFunc) throws BizException{
		SetOrderAppendBillToCgBP bp = new SetOrderAppendBillToCgBP();
		return bp.exec(entId, CgTypeEnum.CG_PREPAY, empId, ordIds, srcFunc);
	}
	
	/**
	 * 门诊预付费记账
	 * 单患者医嘱记账
	 * @param patId 患者id
	 * @param ordIds 医嘱id数组
	 * @param srcFunc 费用产生功能点描述
	 * @return 记账明细
	 * @throws BizException
	 * @author ly 2018/11/29
	 */
	@Override
	public BlcgoepAggDO chareForOpPrepayOr(String patId, String[] ordIds, String srcFunc) throws BizException{
		ChareForOpPrepayOrBP bp = new ChareForOpPrepayOrBP();
		return bp.exec(patId, ordIds, srcFunc);
	}
	
	/**
	 * 门诊预付费销账
	 * @param entId 就诊id
	 * @param empId 记账人员id
	 * @param ordIds 需销账医嘱id
	 * @return 
	 * @throws BizException
	 * @author ly 2018/04/18
	 */
	@Override
	public void refundForOpPrepay(String entId,String empId, String[] ordIds) throws BizException{
		SetOrderRefundBillToCgBP bp = new SetOrderRefundBillToCgBP();
		bp.exec(entId, CgTypeEnum.CG_PREPAY, empId, ordIds);
	}
	
	/**
	 * 高值耗材回写记账数据唯一码
	 * @param dtos 唯一码信息
	 *             id_orsrv为空时，使用id_or及id_srv组合进行检索
	 * @param codeEntp
	 * @throws BizException
	 * @author ly 2018/03/04
	 */
	@Override
	public void writebackOnlycodeToCgItm(BlCgOnlycodeDTO[] dtos,String codeEntp) throws BizException{
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(codeEntp)){
			new BlCgWriteBackOnlycodeIpBP().exec(dtos, codeEntp);
		}else{
			new BlCgWriteBackOnlycodeOpBP().exec(dtos, codeEntp);
		}
	}
	
	/**
	 * 挂号费退记账
	 * @param entId 就诊id
	 * @throws BizException
	 * @author ly 2018/08/26
	 */
	@Override
	public void refundForOpRegister(String entId) throws BizException{
		BlRefundForOpRegisterBP bp = new BlRefundForOpRegisterBP();
		bp.exec(entId);
	}
	
	/**
	 * 医嘱作废时退记账
	 * @param orIds
	 * @throws BizException
	 * @author ly 2018/09/25
	 */
	@Override
	public void refundForIpOrderCancel(String[] orIds) throws BizException{
		
	}
	
	/**
	 * 门诊预付费销账
	 * @param entId 就诊id
	 * @param empId 记账人员id
	 * @param ordIds 需销账医嘱id
	 * @return 
	 * @throws BizException
	 * @author wq.li 2018年12月21日
	 */
	@Override
	public void refundForOpIdOrs(String entId, String empId, String[] ordIds) throws BizException {
		RefundForOpIdOrsBP bp = new RefundForOpIdOrsBP();
		bp.exec(entId, empId, ordIds);
	}
	
	@Override
	public void updateBlCgIpFgSelfPay(BlCgSelfPayDTO[] dtos) throws BizException {
		UpdateBlCgIpFgSelfPayBP bp = new UpdateBlCgIpFgSelfPayBP();
		bp.exec(dtos);
	}
	
	/**
	 * 持续医嘱停止时退记账
	 * @param cgDtos 持续医嘱记账信息
	 * @throws BizException
	 * @author ly 2020/03/12
	 */
	@Override
	public void refundAlwaysOrCg(BlCgAlwaysOrCgInfoDTO[] cgDtos) throws BizException{
		BlCgRefundAlwaysOrBP bp = new BlCgRefundAlwaysOrBP();
		bp.exec(cgDtos);
	}
}
