package iih.mp.ot.i;

import iih.mp.ot.dto.confirm.d.MpOtOrderInfoDTO;
import iih.mp.ot.dto.confirm.d.MpOtSrvInfoDTO;
import iih.mp.ot.dto.exerefund.d.RfnOrderDTO;
import xap.mw.core.data.BizException;

/**
 * 执行域通用医技服务
 * 
 * @author ly
 *
 */
public interface IMpOtMaintainService {

	/**
	 * 门诊医技补录项目保存
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract void opSaveCompensation(MpOtOrderInfoDTO[] dtos) throws BizException;

	/**
	 * 门诊医技补录项目就诊补费数据保存
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract void opEnsrvSaveCompensation(MpOtSrvInfoDTO[] dtos) throws BizException;

	/**
	 * 门诊医技取消补录项目
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract void opCancelCompensation(MpOtSrvInfoDTO[] dtos) throws BizException;

	/**
	 * 门诊医技执行确认
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract void opConfirmPerformance(MpOtOrderInfoDTO[] dtos) throws BizException;

	/**
	 * 门诊医技取消执行
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract void opCancelPerformance(MpOtOrderInfoDTO[] dtos) throws BizException;

	/**
	 * 住院医技补录项目保存
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract void ipSaveCompensation(MpOtOrderInfoDTO[] dtos) throws BizException;

	/**
	 * 住院医技执行确认
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract void ipConfirmPerformance(MpOtOrderInfoDTO[] dtos) throws BizException;

	/**
	 * 住院医技取消补录项目
	 * 
	 * @param dtos 医嘱服务信息
	 * @throws BizException
	 */
	public abstract void ipCancelCompensation(MpOtSrvInfoDTO[] dtos) throws BizException;

	/**
	 * 住院医技取消执行
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract void ipCancelPerformance(MpOtOrderInfoDTO[] dtos) throws BizException;

	/**
	 * 门诊医技补录项目记账
	 * 
	 * @param dtos 医嘱服务信息
	 * @throws BizException
	 */
	public abstract void opCalcCompensation(MpOtSrvInfoDTO[] toCostArray) throws BizException;

	/**
	 * 门诊医技补录项目预交金退费
	 * 
	 * @param dtos 医嘱服务信息
	 * @throws BizException
	 */
	public abstract void opRefundCompensation(MpOtSrvInfoDTO[] toCostArray) throws BizException;

	/**
	 * 住院医技补录项目退费
	 * 
	 * @param toCostArray
	 * @throws BizException
	 */
	public abstract void ipRefundCompensation(MpOtSrvInfoDTO[] toCostArray) throws BizException;

	/**
	 * 确认退费保存
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract void opRfndSave(RfnOrderDTO[] params) throws BizException;

	/**
	 * 住院医技补录临时保存补录项目
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] ipTempSaveCompensation(MpOtOrderInfoDTO[] dtos) throws BizException;

	/**
	 * 执行确认-预付费记账
	 * 
	 * @param toCostArray
	 * @throws BizException
	 */
	public abstract void opConfirmCalcCompensation(MpOtSrvInfoDTO[] toCostArray) throws BizException;

	/**
	 * 执行确认-预付费退费
	 * 
	 * @param toCostArray
	 * @throws BizException
	 */
	public abstract void opConfirmRefundCompensation(MpOtSrvInfoDTO[] toCostArray) throws BizException;

	/**
	 * 门诊医技补录项目保存(新)
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract void opNewSaveCompensation(MpOtOrderInfoDTO[] dtos) throws BizException;

	/**
	 * 门诊医技补录项目记账(新)
	 * 
	 * @param dtos 医嘱服务信息
	 * @throws BizException
	 */
	public abstract void opNewCalcCompensation(MpOtSrvInfoDTO[] toCostArray) throws BizException;

	/**
	 * 门诊医技补录项目预交金退费(新)
	 * 
	 * @param dtos 医嘱服务信息
	 * @throws BizException
	 */
	public abstract void opNewRefundCompensation(MpOtSrvInfoDTO[] toCostArray) throws BizException;

	/**
	 * 住院医技补录临时保存补录项目(新)
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] ipNewTempSaveCompensation(MpOtOrderInfoDTO[] dtos) throws BizException;

	/**
	 * 住院医技补录项目保存(新)
	 * 
	 * @param dtos 医嘱信息
	 * @throws BizException
	 */
	public abstract void ipNewSaveCompensation(MpOtOrderInfoDTO[] dtos) throws BizException;

	/**
	 * 门诊获取已记账的服务项目
	 * 
	 * 
	 * 医嘱信息
	 * 
	 * @throws BizException
	 */
	public abstract MpOtSrvInfoDTO[] getPreyMpOtSrvInfoDTO(String id_pat) throws BizException;

	/**
	 * 医技记账
	 * 
	 * @param id_or_prs
	 * @return
	 * @throws BizException
	 */
	public abstract String techCharge(String[] id_or_prs, String id_dep, String id_emp, String dt_cg) throws BizException;

	/**
	 * 根据耗材唯一码获取补录服务信息
	 * 
	 * @param onlyCode 耗材唯一码
	 * @return 补录服务信息
	 * @throws BizException
	 */
	public abstract MpOtSrvInfoDTO getAddSrvByOnlyCode(String onlyCode) throws BizException;
	
	/**
	 * 拒绝执行
	 * @param params
	 * @throws BizException
	 */
	public abstract void execRefuse(MpOtOrderInfoDTO[] params) throws BizException;
}
