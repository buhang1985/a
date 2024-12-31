package iih.ci.ord.s.bp.cfg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cfg.cirulecfg.d.RuleCheckPoint;
import iih.ci.ord.cfg.cirulecfg.d.RuleType;
import iih.ci.ord.cfg.cirulecfg.d.RuleUseScope;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.cfg.rulecfg.meta.RuleCfgParamDTO;
import iih.ci.ord.i.external.obtain.ICiOrdPiRService;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.cfg.rulecfg.AbstractRuleExecutor;
import iih.ci.ord.s.bp.cfg.rulecfg.RuleCfgChainFacory;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 规则执行类对外服务
 * 
 * @author HUMS
 *
 */
public class CiRuleCfgExecutorBP {

	/**
	 * 执行分方
	 * 
	 * @param presList 待拆分的处方集合
	 * @return 拆分后的处方集合
	 * @throws BizException
	 */
	public List<CiOrPresSplitList> execSplitPres(CiEnContextDTO ctx, List<CiOrPresSplitList> presList) throws BizException {

		//CiEnContextDTO ctx = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		
		RuleCfgChainFacory<List<CiOrPresSplitList>> ruleCfgChainFacory = new RuleCfgChainFacory<List<CiOrPresSplitList>>();

		List<CiOrPresSplitList> presSplitList = new ArrayList<CiOrPresSplitList>();

		// 待进行分方的草药集合
		List<CiOrPresSplitList> herbsPresList = new ArrayList<CiOrPresSplitList>();
		// 待分方的非草药集合
		List<CiOrPresSplitList> drugsPresList = new ArrayList<CiOrPresSplitList>();

		if (presList == null || presList.size() == 0) {
			return presSplitList;
		}
		
		// 根据参数模板确定当前就诊类型是否为急诊
		String code_entp_ext = null;
		
		try {
			//获取 是否急诊就诊判断方式  0 按就诊类型判断 1按科室判断  如果为null  默认为就诊类型判断
			String isErenMd = ParamsetQryUtil.getParaString(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_IsErenMd);
			if("1".equals(isErenMd)){
				//按就诊科室判断
				//1、获取当前科室
				String dept = Context.get().getDeptId();
				//2、获取急诊科室    
				String IsErenDeps = ParamsetQryUtil.getParaString(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_IsErenDeps);
				//3、就诊科室里 如果存在当前科室则进行急诊规则校验
				if(IsErenDeps != null && IsErenDeps.contains(dept)){
					code_entp_ext = IBdFcDictCodeConst.SD_CODE_ENTP_ET;
				}
			}
		} catch (Exception e) {
			OrdBizLogger.info(ctx, e.getMessage() );
		}
								

		// 设置患者分类，患者分类为公费医疗时生成公费医疗处方笺
		// 根据就诊id获取患者分类编码，用于判断是否为公费医疗，患者分类为公费医疗需要生成公费医疗处方
		ICiOrdPiRService piRService = (ICiOrdPiRService) ServiceFinder.find(ICiOrdPiRService.class);
		String patcaCode = piRService.getPatcaCodeByIden(ctx.getId_en());

		for (CiOrPresSplitList presSplit : presList) {

			// 待进行分方的草药集合
			List<OrderPresSplitDTO> herbsOrdPresList = new ArrayList<OrderPresSplitDTO>();
			// 待分方的非草药集合
			List<OrderPresSplitDTO> drugsOrdPresList = new ArrayList<OrderPresSplitDTO>();

			List<OrderPresSplitDTO> orderPresSplit = presSplit.getOrderList();

			for (OrderPresSplitDTO orderPres : orderPresSplit) {
				// 设置患者分类，用于生成公费医疗处方笺
				orderPres.setCode_hpkind(patcaCode);
				orderPres.setCode_entp_ext(code_entp_ext);

				if (IBdMmDictCodeConst.SD_MMTP_DRUG_CHIHE.equals(orderPres.getSd_mmtp())) {
					herbsOrdPresList.add(orderPres);
				} else {
					drugsOrdPresList.add(orderPres);
				}
			}

			// 草药待分方数据
			if (herbsOrdPresList.size() > 0) {

				CiOrPresSplitList herbsPresSplit = new CiOrPresSplitList();
				BeanUtils.copyProperties(presSplit, herbsPresSplit, new String[] { "orderList", "cfgProps" });
				herbsPresSplit.setOrderList(herbsOrdPresList);
				herbsPresList.add(herbsPresSplit);
			}

			// 非草药待分方数据
			if (drugsOrdPresList.size() > 0) {
				CiOrPresSplitList drugPresSplit = new CiOrPresSplitList();
				BeanUtils.copyProperties(presSplit, drugPresSplit, new String[] { "orderList", "cfgProps" });
				drugPresSplit.setOrderList(drugsOrdPresList);
				drugsPresList.add(drugPresSplit);
			}

		}

		if (herbsPresList.size() > 0) {
			
			RuleCfgParamDTO herbsRuleCfgParam = new RuleCfgParamDTO();
			herbsRuleCfgParam.setCode_entp(ctx.getCode_entp());
			herbsRuleCfgParam.setCheck_point(RuleCheckPoint.SIGN);
			herbsRuleCfgParam.setRule_type(RuleType.MERGE_HERBS_PRES);
			
			AbstractRuleExecutor<List<CiOrPresSplitList>> herbsRuleExecutor = ruleCfgChainFacory.getRuleChain(herbsRuleCfgParam);
			List<CiOrPresSplitList> newHerbsPresList = herbsRuleExecutor.startExecuteRule(herbsPresList);
			presSplitList.addAll(newHerbsPresList);
		}

		if (drugsPresList.size() > 0) {
			
			RuleCfgParamDTO herbsRuleCfgParam = new RuleCfgParamDTO();
			herbsRuleCfgParam.setCode_entp(ctx.getCode_entp());
			herbsRuleCfgParam.setCheck_point(RuleCheckPoint.SIGN);
			herbsRuleCfgParam.setRule_type(RuleType.MERGE_PRES);
			
			AbstractRuleExecutor<List<CiOrPresSplitList>> ruleExecutor = ruleCfgChainFacory.getRuleChain(herbsRuleCfgParam);

			List<CiOrPresSplitList> newDrugPresList = ruleExecutor.startExecuteRule(drugsPresList);
			presSplitList.addAll(newDrugPresList);
		}

		return presSplitList;
	}

	/**
	 * 出院带药分方
	 * 
	 * @param presList 待拆分的处方集合
	 * @return 拆分后的处方集合
	 * @throws BizException
	 */
	public List<CiOrPresSplitList> execOutpSplitPres(CiEnContextDTO ctx,List<CiOrPresSplitList> presList) throws BizException {

		//CiEnContextDTO ctx = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");

		RuleCfgChainFacory<List<CiOrPresSplitList>> ruleCfgChainFacory = new RuleCfgChainFacory<List<CiOrPresSplitList>>();

		List<CiOrPresSplitList> presSplitList = new ArrayList<CiOrPresSplitList>();

		// 待进行分方的草药集合
		List<CiOrPresSplitList> herbsPresList = new ArrayList<CiOrPresSplitList>();
		// 待分方的非草药集合
		List<CiOrPresSplitList> drugsPresList = new ArrayList<CiOrPresSplitList>();

		if (presList == null || presList.size() == 0) {
			return presSplitList;
		}

		// 设置患者分类，患者分类为公费医疗时生成公费医疗处方笺
		// 根据就诊id获取患者分类编码，用于判断是否为公费医疗，患者分类为公费医疗需要生成公费医疗处方
		ICiOrdPiRService piRService = (ICiOrdPiRService) ServiceFinder.find(ICiOrdPiRService.class);
		String patcaCode = piRService.getPatcaCodeByIden(ctx.getId_en());

		for (CiOrPresSplitList presSplit : presList) {

			// 待进行分方的草药集合
			List<OrderPresSplitDTO> herbsOrdPresList = new ArrayList<OrderPresSplitDTO>();
			// 待分方的非草药集合
			List<OrderPresSplitDTO> drugsOrdPresList = new ArrayList<OrderPresSplitDTO>();

			List<OrderPresSplitDTO> orderPresSplit = presSplit.getOrderList();

			for (OrderPresSplitDTO orderPres : orderPresSplit) {
				// 设置患者分类，用于生成公费医疗处方笺
				orderPres.setCode_hpkind(patcaCode);

				if (IBdMmDictCodeConst.SD_MMTP_DRUG_CHIHE.equals(orderPres.getSd_mmtp())) {
					herbsOrdPresList.add(orderPres);
				} else {
					drugsOrdPresList.add(orderPres);
				}
			}

			// 草药待分方数据
			if (herbsOrdPresList.size() > 0) {

				CiOrPresSplitList herbsPresSplit = new CiOrPresSplitList();
				BeanUtils.copyProperties(presSplit, herbsPresSplit, new String[] { "orderList", "cfgProps" });
				herbsPresSplit.setOrderList(herbsOrdPresList);
				herbsPresList.add(herbsPresSplit);
			}

			// 非草药待分方数据
			if (drugsOrdPresList.size() > 0) {
				CiOrPresSplitList drugPresSplit = new CiOrPresSplitList();
				BeanUtils.copyProperties(presSplit, drugPresSplit, new String[] { "orderList", "cfgProps" });
				drugPresSplit.setOrderList(drugsOrdPresList);
				drugsPresList.add(drugPresSplit);
			}

		}

		if (herbsPresList.size() > 0) {

			RuleCfgParamDTO herbsRuleCfgParam = new RuleCfgParamDTO();
			herbsRuleCfgParam.setCode_entp(ctx.getCode_entp());
			herbsRuleCfgParam.setCheck_point(RuleCheckPoint.SIGN);
			herbsRuleCfgParam.setRule_type(RuleType.MERGE_HERBS_PRES);
			herbsRuleCfgParam.setUse_scope(RuleUseScope.RULE_USE_IP_OUTP);

			AbstractRuleExecutor<List<CiOrPresSplitList>> herbsRuleExecutor = ruleCfgChainFacory.getRuleChain(herbsRuleCfgParam);
			List<CiOrPresSplitList> newHerbsPresList = herbsRuleExecutor.startExecuteRule(herbsPresList);
			presSplitList.addAll(newHerbsPresList);
		}

		if (drugsPresList.size() > 0) {

			RuleCfgParamDTO herbsRuleCfgParam = new RuleCfgParamDTO();
			herbsRuleCfgParam.setCode_entp(ctx.getCode_entp());
			herbsRuleCfgParam.setCheck_point(RuleCheckPoint.SIGN);
			herbsRuleCfgParam.setRule_type(RuleType.MERGE_PRES);
			herbsRuleCfgParam.setUse_scope(RuleUseScope.RULE_USE_IP_OUTP);

			AbstractRuleExecutor<List<CiOrPresSplitList>> ruleExecutor = ruleCfgChainFacory.getRuleChain(herbsRuleCfgParam);

			List<CiOrPresSplitList> newDrugPresList = ruleExecutor.startExecuteRule(drugsPresList);
			presSplitList.addAll(newDrugPresList);
		}

		return presSplitList;
	}
}
