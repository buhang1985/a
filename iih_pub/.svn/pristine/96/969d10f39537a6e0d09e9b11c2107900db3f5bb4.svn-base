package iih.bl.cg.i;

import java.util.Map;

import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.dto.alwaysor.d.BlCgAlwaysOrCgInfoDTO;
import iih.bl.cg.dto.cgonlycode.d.BlCgOnlycodeDTO;
import iih.bl.cg.dto.d.BlCgSelfPayDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 费用对外命令服务
 * 
 * @author yankan
 * @since 2017-06-13
 *
 */
public interface IBlOutCmdService {
	/**
	 * 执行住院后台划价
	 * @param patId 患者ID
	 * @param cgEndTime 记账截止时间
	 * 
	 * 
	 * @throws BizException
	 * @author yankan
	 */
	public abstract void execIpCgTask(String patId,FDateTime cgEndTime) throws BizException;
	/**
	 * 执行住院医嘱记费
	 * 护理、持续医嘱
	 * @param patId 患者ID
	 * @param cgEndTime 计费时间
	 * @throws BizException
	 */
	public abstract void chargeIpOrd(String patId,FDateTime cgEndTime) throws BizException;
	/**
	 * 持续医嘱计费
	 * @param patId 患者ID
	 * @param ordIds 医嘱ID集合
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author yankan
	 */
	public abstract void chargePrnOrd(String patId,String[] ordIds,FDateTime cgEndTime) throws BizException;
	/**
	 * 护理医嘱计费
	 * @param patId 患者ID
	 * @param ordIds 医嘱ID集合
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author yankan
	 */
	public abstract void chargeNurse(String patId,String[] ordIds,FDateTime cgEndTime) throws BizException;
	/**
	 * 出院记账
	 * @param patId 患者ID
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author yankan
	 */
	public abstract void chargeOutDept(String patId,FDateTime cgEndTime) throws BizException;

	/**
	 * 出院记账(就诊id)
	 * @param entId 就诊id
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author ly 2018/11/13
	 */
	public abstract void chargeOutDeptByEntId(String entId, FDateTime cgEndTime) throws BizException;
	
	/**
	 * 转科记账
	 * @param patId
	 * @param cgEndTime
	 * @throws BizException
	 */
	public abstract void chargeTurnDept(String patId,FDateTime cgEndTime) throws BizException;
	
	/**
	 * 转科记账(就诊id)
	 * @param entId 就诊id
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author ly 2019/01/31
	 */
	public abstract void chargeTurnDeptByEntId(String entId, FDateTime cgEndTime) throws BizException;
	
	/**
	 * 退记账的药品
	 * @param entId 就诊ID
	 * @param backDrugMap 退药品MAP，[key:医嘱服务ID，value:需退数量]
	 * @throws BizException
	 * @author yankan
	 * @author yanglu
	 */
	public abstract void drawbackAccDrug(String entId,Map<String,FDouble> backDrugMap) throws BizException;	
	
	/**
	 * 改变门诊挂号就诊
	 * 将之前的费用明细进行红冲，并修改就诊ID
	 * @param cgId 原挂号的记账ID
	 * @param targetEntId 目标就诊ID
	 * @return 新的记账ID
	 * @throws BizException
	 * @author 
	 */
	public abstract String changeOpRegEnt(String cgId,String targetEntId) throws BizException;
	
	/**
	 * 入院登记自动记账
	 * @param entId 就诊id
	 * @param fgFirst 是否首次入院
	 * @return
	 * @throws BizException
	 * @author ly
	 */
	public abstract FBoolean chargeForIpRegister(String entId,FBoolean fgFirst) throws BizException;

	/**
	 * 门诊预付费记账
	 * @param entId 就诊id
	 * @param empId 记账人员id
	 * @param ordIds 需记账医嘱id
	 * @param srcFunc 费用产生功能点描述
	 * @return 记账明细
	 * @throws BizException
	 * @author ly 2018/04/17
	 */
	public abstract BlOrderAppendBillParamDTO[] chargeForOpPrepay(String entId,String empId, String[] ordIds,String srcFunc) throws BizException;

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
	public abstract BlcgoepAggDO chareForOpPrepayOr(String patId, String[] ordIds, String srcFunc) throws BizException;
	
	/**
	 * 门诊预付费销账
	 * @param entId 就诊id
	 * @param empId 记账人员id
	 * @param ordIds 需销账医嘱id
	 * @return 
	 * @throws BizException
	 * @author ly 2018/04/18
	 */
	public abstract void refundForOpPrepay(String entId,String empId, String[] ordIds) throws BizException;

	/**
	 * 高值耗材回写记账数据唯一码
	 * @param dtos 唯一码信息
	 *             id_orsrv为空时，使用id_or及id_srv组合进行检索
	 * @param codeEntp 就诊类型编码
	 * @throws BizException
	 * @author ly 2018/03/04
	 */
	public abstract void writebackOnlycodeToCgItm(BlCgOnlycodeDTO[] dtos,String codeEntp) throws BizException;

	/**
	 * 挂号费退记账
	 * @param entId 就诊id
	 * @throws BizException
	 * @author ly 2018/08/26
	 */
	public abstract void refundForOpRegister(String entId) throws BizException;

	/**
	 * 医嘱作废时退记账
	 * @param orIds
	 * @throws BizException
	 * @author ly 2018/09/25
	 */
	public abstract void refundForIpOrderCancel(String[] orIds) throws BizException;
	
	/**
	 * 门诊预付费销账
	 * @param entId 就诊id
	 * @param empId 记账人员id
	 * @param ordIds 需销账医嘱id
	 * @return 
	 * @throws BizException
	 * @author wq.li 2018年12月21日
	 */
	public abstract void refundForOpIdOrs(String entId,String empId, String[] ordIds) throws BizException;
	
	/**
	 * 更新住院记账自费标识
	 * @author : hanjq 2019年9月11日 下午1:05:53
	 * @param dtos
	 * @throws BizException
	 */
	public abstract void updateBlCgIpFgSelfPay(BlCgSelfPayDTO[] dtos) throws BizException;

	/**
	 * 持续医嘱停止时退记账
	 * @param cgDtos 持续医嘱记账信息
	 * @throws BizException
	 * @author ly 2020/03/12
	 */
	public abstract void refundAlwaysOrCg(BlCgAlwaysOrCgInfoDTO[] cgDtos) throws BizException;
}
