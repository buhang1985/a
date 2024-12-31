package iih.bl.cg.i;

import java.util.Map;

import iih.bl.cg.dto.accenough.d.BlCgAccEnoughRltDTO;
import iih.bl.comm.dto.d.BlCheckResultDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 费用记帐校验服务
 * @author ly 2018/07/17
 *
 */
public interface IBlCgValidateService {

	/**
	 * 是否收取过挂号费
	 * @param entIds 就诊id数组
	 * @return 校验结果 true:收取过 false:未收取过
	 * @throws BizExeception
	 * @author ly 2018/07/17
	 */
	public abstract FBoolean hasChargedRegisterCost(String[] entIds) throws BizException;
	

	/**
	 * 校验账户余额是否大于指定服务金额
	 * 服务数量按1算
	 * 目前用于挂号费记账前校验
	 * @param patId 患者id
	 * @param pripatId 患者价格分类
	 * @param srvIds 服务id数组
	 * @throws BizException 
	 * @author ly 2018/08/15
	 */
	public abstract BlCgAccEnoughRltDTO ifOpAccIsEnough(String patId, String pripatId, String[] srvIds) throws BizException; 

	/**
	 * 门诊医嘱服务是否已经结算
	 * @param orsrvIds 医嘱服务数组
	 * @return 0:未结算 1:普通结算 2:医保结算 -->枚举值BlStStateEnum
	 * @throws BizException
	 * @author ly 2018/08/23
	 */
	public abstract Integer orsrvHasSettled(String[] orsrvIds) throws BizException; 

	/**
	 * 门诊医嘱是否已经结算
	 * 医嘱下有服务结算即结算
	 * 备注:前台调用请自行封装返回值
	 * @param orIds 医嘱数据
	 * @return key:医嘱id value: 是否结算
	 * @throws BizException
	 * @author ly 2019/06/17
	 */
	public abstract Map<String, FBoolean> orHasSettled(String[] orIds) throws BizException; 
	
	/**
	 * 门诊医嘱服务是否已经结算
	 * 备注:前台调用请自行封装返回值
	 * @param orIds 医嘱数据
	 * @return key:医嘱id value: 是否结算
	 * @throws BizException
	 * @author ly 2019/12/17
	 */
	public abstract Map<String, FBoolean> orsrvHasSettled2(String[] orsrvIds) throws BizException;
	
	/**
	 * 校验指定终端是否可以退号
	 * @param entId 就诊id
	 * @param sdPttp 终端类型
	 * @return 校验结果
	 * @throws BizException
	 * @author ly 2019/12/26
	 */
	public abstract BlCheckResultDTO canOpUnregister(String entId,String sdPttp) throws BizException;
} 
