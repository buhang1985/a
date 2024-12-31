package iih.bl.hp.Service.s;

import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

import com.ymer.designer.scripteditor.MvelExtMethod;

import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.rule.CheckEmPickRule;
import iih.bl.hp.rule.CheckOpBillDaysRule;
import iih.bl.hp.rule.CheckOpHoldRule;
import iih.bl.hp.rule.CheckPickByOnePerformRule;
import iih.bl.hp.rule.CheckRadiationRule;
import iih.bl.hp.rule.CheckReBillRule;
import iih.bl.hp.rule.CheckSinglePresRule;
import iih.bl.hp.rule.CleanBeforeValidateBP;
import xap.mw.core.data.BizException;

/**
 * 医保开单整体校验：排除不限量药品，门诊持有量限制，重复开药限制，急诊领量限制，单方限制，放射类医嘱校验，门诊领量限制，单次执行医嘱领量限制
 * 
 * @author tcy
 * @author yangyang review
 * @date review 2017-06-21
 */
public class IHpQueServiceBpImpl implements MvelExtMethod {

	/**
	 * 返回的内容中不包括不限量药品
	 * 
	 * @param ciHpCheckDTO 原始保存的医嘱
	 * @return
	 * @throws BizException
	 */
	public CiHpCheckDTO cleanBeforeValidate(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CleanBeforeValidateBP cleanBP = new CleanBeforeValidateBP();
		return cleanBP.exec(ciHpCheckDTO);
	}
	/**
	 * 门诊持有量限制: 医保为防止患者通过多天开药，积累持有的药品，造成资源浪费， 所以限制患者手中持有的药品的数量不得超过30天的用量。  2017年8月22日 改为50天
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 * @author LIM modify
	 */
	public static CiHpCheckResultDTO check_GREATER_THAN_OWN_OEP(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CheckOpHoldRule checkBP = new CheckOpHoldRule();
		return checkBP.exec(ciHpCheckDTO);
	}
	
	/**
	 * 重复开药: 医生不允许在1天内给同一患者重复开同一种药品，以下情况除处： 溶媒不限制； 单次执行(频次ST、ONCE、PRN)的医嘱不限制；
	 * 儿科、传染病门诊（发热门诊、肝炎门诊、消化道门诊三个科室）开的频次为QD、BID、TID的医嘱不限制； （待确认，与测试不符，测试用医生为急诊内科医生） 急诊不进行校验2017-8-23
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 */
	public static CiHpCheckResultDTO check_REPEAT_PRES_DRUG(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CheckReBillRule reBillRule = new CheckReBillRule();
		return reBillRule.exec(ciHpCheckDTO);
	}

	/**
	 * 急诊领量限制
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 */
	public static CiHpCheckResultDTO check_GREATER_THAN_GET_ER(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CheckEmPickRule emPickRule = new CheckEmPickRule();
		return emPickRule.exec(ciHpCheckDTO);
	}

	/**
	 * 门诊领量限制
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 */
	public static CiHpCheckResultDTO check_GREATER_THAN_GET_OEP(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CheckOpBillDaysRule checkBP = new CheckOpBillDaysRule();
		return checkBP.exec(ciHpCheckDTO);
	}
	/**
	 * 医保，当日CT类医嘱只能开一次
	 * CT类医嘱校验
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 * @author LIM
	 * @since 2017-08-30
	 */
	public static CiHpCheckResultDTO check_RADIATION_CLASS_ORDER(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CheckRadiationRule checkBP = new CheckRadiationRule();
		return checkBP.exec(ciHpCheckDTO);
	}
	 /**
	 * 单次执行医嘱领量限制
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 */
	public static CiHpCheckResultDTO check_GREATER_THAN_ONE_TIME(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CheckPickByOnePerformRule pickByOnePerformRule = new CheckPickByOnePerformRule();
		return pickByOnePerformRule.exec(ciHpCheckDTO);
	}

	/**
	 * 单方校验
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 */
	public static CiHpCheckResultDTO checkSingleSrv(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CheckSinglePresRule singlePreRule = new CheckSinglePresRule();
		return singlePreRule.exec(ciHpCheckDTO);
	}

	@Override
	public String getClazzDesc() {
		return "医保开单整体校验：门诊持有量限制，重复开药限制，急诊领量限制，单方限制，放射类医嘱校验，门诊领量限制，单次执行医嘱领量限制";
	}

	@Override
	public Map<String, String> getMethodParamsDesc() {

		Map<String, String> descs = new HashMap<String, String>();
		descs.put("checkSingleSrv", CiHpCheckDTO.class.getName());
		descs.put("check_GREATER_THAN_ONE_TIME", CiHpCheckDTO.class.getName());
		descs.put("check_GREATER_THAN_OWN_OEP", CiHpCheckDTO.class.getName());
		descs.put("check_GREATER_THAN_ONE_TIME", CiHpCheckDTO.class.getName());
		descs.put("check_REPEAT_PRES_DRUG", CiHpCheckDTO.class.getName());
		descs.put("check_GREATER_THAN_GET_ER", CiHpCheckDTO.class.getName());
		descs.put("check_RADIATION_CLASS_ORDER", CiHpCheckDTO.class.getName());

		return descs;
	}

	@Override
	public Map<String, String> getReturnTypes() {
		Map<String, String> returnTypes = new HashMap<String, String>();
		returnTypes.put("checkSingleSrv", CiHpCheckResultDTO.class.getName());
		returnTypes.put("check_GREATER_THAN_ONE_TIME", CiHpCheckResultDTO.class.getName());
		returnTypes.put("check_GREATER_THAN_OWN_OEP", CiHpCheckResultDTO.class.getName());
		returnTypes.put("check_REPEAT_PRES_DRUG", CiHpCheckResultDTO.class.getName());
		returnTypes.put("check_GREATER_THAN_GET_ER", CiHpCheckResultDTO.class.getName());
		returnTypes.put("check_GREATER_THAN_GET_OEP", CiHpCheckResultDTO.class.getName());
		returnTypes.put("check_RADIATION_CLASS_ORDER", CiHpCheckResultDTO.class.getName());
		return returnTypes;

	}

	@Override
	public void importMethod(ParserContext ctx) {
		ctx.addImport("checkSingleSrv",
				MVEL.getStaticMethod(IHpQueServiceBpImpl.class, "checkSingleSrv", new Class[] { CiHpCheckDTO.class }));
		ctx.addImport("check_GREATER_THAN_ONE_TIME", MVEL.getStaticMethod(IHpQueServiceBpImpl.class,
				"check_GREATER_THAN_ONE_TIME", new Class[] { CiHpCheckDTO.class }));
		ctx.addImport("check_GREATER_THAN_OWN_OEP", MVEL.getStaticMethod(IHpQueServiceBpImpl.class,
				"check_GREATER_THAN_OWN_OEP", new Class[] { CiHpCheckDTO.class }));
		ctx.addImport("check_REPEAT_PRES_DRUG", MVEL.getStaticMethod(IHpQueServiceBpImpl.class,
				"check_REPEAT_PRES_DRUG", new Class[] { CiHpCheckDTO.class }));
		ctx.addImport("check_GREATER_THAN_GET_ER", MVEL.getStaticMethod(IHpQueServiceBpImpl.class,
				"check_GREATER_THAN_GET_ER", new Class[] { CiHpCheckDTO.class }));
		ctx.addImport("check_GREATER_THAN_GET_OEP", MVEL.getStaticMethod(IHpQueServiceBpImpl.class,
				"check_GREATER_THAN_GET_OEP", new Class[] { CiHpCheckDTO.class }));
		ctx.addImport("check_RADIATION_CLASS_ORDER", MVEL.getStaticMethod(IHpQueServiceBpImpl.class,
				"check_RADIATION_CLASS_ORDER", new Class[] { CiHpCheckDTO.class }));
	}

}
