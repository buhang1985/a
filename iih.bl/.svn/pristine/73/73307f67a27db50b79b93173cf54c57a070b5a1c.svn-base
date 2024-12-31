package iih.bl.cg.s;

import java.util.Map;

import iih.bl.cg.dto.accenough.d.BlCgAccEnoughRltDTO;
import iih.bl.cg.i.IBlCgValidateService;
import iih.bl.cg.s.bp.validate.OpAccIsEnoughBP;
import iih.bl.cg.s.bp.validate.OpCanUnregisterBP;
import iih.bl.cg.s.bp.validate.OpHasChargedRegisterCostBP;
import iih.bl.cg.s.bp.validate.OpOrdHasSettledBP;
import iih.bl.cg.s.bp.validate.OpOrsrvHasSettled2BP;
import iih.bl.cg.s.bp.validate.OpOrsrvHasSettledBP;
import iih.bl.comm.dto.d.BlCheckResultDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 费用记帐校验服务
 * @author ly 2018/07/17
 *
 */
@Service(serviceInterfaces = { IBlCgValidateService.class }, binding = Binding.JSONRPC)
public class BlCgValidateServiceImpl implements IBlCgValidateService {

	/**
	 * 是否收取过挂号费
	 * @param entIds 就诊id数组
	 * @return 校验结果 true:收取过 false:未收取过
	 * @throws BizExeception
	 * @author ly 2018/07/17
	 */
	@Override
	public FBoolean hasChargedRegisterCost(String[] entIds) throws BizException {
		OpHasChargedRegisterCostBP bp = new OpHasChargedRegisterCostBP();
		return bp.exec(entIds);
	}

	/**
	 * 校验账户余额是否大于指定服务金额
	 * @param patId 患者id
	 * @param pripatId 患者价格分类
	 * @param srvIds 服务id数组
	 * @throws BizException 
	 * @author ly 2018/08/15
	 */
	@Override
	public BlCgAccEnoughRltDTO ifOpAccIsEnough(String patId, String pripatId, String[] srvIds) throws BizException{
		OpAccIsEnoughBP bp = new OpAccIsEnoughBP();
		return bp.exec(patId, pripatId, srvIds);
	} 
	
	/**
	 * 门诊医嘱服务是否已经结算
	 * @param orsrvIds 医嘱服务数组
	 * @return 0:未结算 1:普通结算 2:医保结算 -->枚举值BlStStateEnum
	 * @throws BizException
	 * @author ly 2018/08/23
	 */
	public Integer orsrvHasSettled(String[] orsrvIds) throws BizException{
		OpOrsrvHasSettledBP bp = new OpOrsrvHasSettledBP();
		return bp.exec(orsrvIds);
	}
	
	/**
	 * 门诊医嘱是否已经结算
	 * 医嘱下有服务结算即结算
	 * @param orIds 医嘱数据
	  * @return key:医嘱id value: 是否结算
	 * @throws BizException
	 * @author ly 2019/06/17
	 */
	public Map<String, FBoolean> orHasSettled(String[] orIds) throws BizException{
		OpOrdHasSettledBP bp = new OpOrdHasSettledBP();
		return bp.exec(orIds);
	}

	/**
	 * 门诊医嘱服务是否已经结算
	 * 备注:前台调用请自行封装返回值
	 * @param orIds 医嘱数据
	 * @return key:医嘱id value: 是否结算
	 * @throws BizException
	 * @author ly 2019/12/17
	 */
	@Override
	public Map<String, FBoolean> orsrvHasSettled2(String[] orsrvIds) throws BizException {
		OpOrsrvHasSettled2BP bp = new OpOrsrvHasSettled2BP();
		return bp.exec(orsrvIds);
	}
	
	/**
	 * 校验指定终端是否可以退号
	 * @param entId 就诊id
	 * @param sdPttp 终端类型
	 * @return 校验结果
	 * @throws BizException
	 * @author ly 2019/12/26
	 */
	@Override
	public BlCheckResultDTO canOpUnregister(String entId,String sdPttp) throws BizException{
		OpCanUnregisterBP bp = new OpCanUnregisterBP();
		return bp.exec(entId, sdPttp);
	}
}
