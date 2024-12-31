package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule;

import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.FBooleanUtils;
import iih.mi.constant.IMiMcCheckConst;
import iih.mi.mc.dto.mimcwholerule.d.MiMcCheckFailResultEnum;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvResultDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleInParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleOutParamDTO;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.GetHisOrderListBP;
import iih.mi.mc.s.ctrlcore.rule.MiMcCheckRule;
import iih.mi.mc.s.util.MiBaseInfoUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
/**
 * 医保开单整体校验
 * @author LIM
 * @since 2019-09-23
 *
 */
public class MiWholeCheckRule extends MiMcCheckRule{
	/**
	 * 医保整体开单校验
	 * @param inParamDto
	 * @return
	 * @throws BizException
	 */
	public MiMcWholeRuleOutParamDTO exec(MiMcWholeRuleInParamDTO inParamDto)throws BizException{
		MiMcWholeRuleOutParamDTO outParamDto= new MiMcWholeRuleOutParamDTO();	
		outParamDto.setErroritm_list(new FArrayList());
		// 初始化参数
		this.initParamData(inParamDto);
		// 获取医保规则所对应策略
		HashMap<String,String> ruleMap=this.getCheckRule(inParamDto.getId_hp(), inParamDto.getCode_entp(), IMiMcCheckConst.ID_MIMC_TACTICS_WHOLE);
		if(ruleMap==null){
			outParamDto.setFg_checkflag(FBoolean.TRUE);
			return outParamDto;
		}
		// 1、执行单方规则校验
		if(ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_WHOLE_SINGLEPRE))
			this.execSinglePreRule(inParamDto, outParamDto);
		// 2、执行放射类校验规则
		if(ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_WHOLE_RADIATION))
			this.execRadiationRule(inParamDto, outParamDto);
		// 3、执行重复开药限制规则
		if(ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_WHOLE_REBILL))
			this.execReBillRule(inParamDto, outParamDto);
		// 4、执行单次执行领量限制  
		if(ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_WHOLE_PICKBYONEPERFORM))
			this.execPickByOnePerformRule(inParamDto, outParamDto);
		// 5、执行门诊领料量校验规则
		if(ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_WHOLE_OPPICK))
			this.execOpPickRule(inParamDto, outParamDto);
		// 6、执行门诊持有量校验规则
		if(ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_WHOLE_OPHOLD))
			this.execOpHoldRule(inParamDto, outParamDto);
		// 7、执行急诊领料量规则
		if(ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_WHOLE_EMPICK))
			this.execEmPickRule(inParamDto, outParamDto);
		// 8、特殊病开单规则校验
		if(ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_WHOLE_SPEC))
			this.execSpecRule(inParamDto, outParamDto);	
		// 9、执行门诊领药量校验规则(按实际使用天数)
		if(ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_WHOLE_OPDOSAGE))
			this.execOpDosageRule(inParamDto, outParamDto);
		// end、汇总错误信息
		this.processCheckResult(outParamDto);
		return outParamDto;
	}
	
	/**
	 * 初始化参数
	 * 
	 * @param ciHpCheckDTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void initParamData(MiMcWholeRuleInParamDTO inParamDto) throws BizException {

		// 1、设置历史医嘱信息
		GetHisOrderListBP bp= new GetHisOrderListBP();
		FArrayList2 hisOrList = bp.exec(inParamDto.getId_pat(), inParamDto.getId_hp());
		if(!ListUtil.isEmpty(hisOrList))
			Context.get().setAttribute(IMiMcCheckConst.CHECKWHOLE_HISCIORDERLIST, hisOrList);
		
		// 2、设置不限量药品信息
		List<String> unLimitDrugList=MiBaseInfoUtil.getBdHpUnlimitDrugDOLst(inParamDto.getId_hp());
		if(!ListUtil.isEmpty(unLimitDrugList))
			Context.get().setAttribute(IMiMcCheckConst.CHECKWHOLE_UNLIMITDRUGLIST, unLimitDrugList);
	}
	
	/**
	 * 执行单方校验规则
	 * 
	 * @param inParamDto
	 * @param outParamDto
	 * @throws BizException
	 */
	private void execSinglePreRule(MiMcWholeRuleInParamDTO inParamDto, MiMcWholeRuleOutParamDTO outParamDto) throws BizException {
		MiCheckSinglePresRule checkRule = new MiCheckSinglePresRule();
		MiMcWholeRuleOutParamDTO ruleCheckRst = checkRule.exec(inParamDto);
		this.addErrorToMain(ruleCheckRst, outParamDto);
	}
	
	/**
	 * 执行放射类限制规则
	 * 
	 * @param inParamDto
	 * @param outParamDto
	 * @throws BizException
	 */
	private void execRadiationRule(MiMcWholeRuleInParamDTO inParamDto, MiMcWholeRuleOutParamDTO outParamDto) throws BizException {
		MiCheckRadiationRule checkRule = new MiCheckRadiationRule();
		MiMcWholeRuleOutParamDTO ruleCheckRst = checkRule.exec(inParamDto);
		this.addErrorToMain(ruleCheckRst, outParamDto);
	}
	
	/**
	 * 执行重复开药限制规则
	 * 
	 * @param inParamDto
	 * @param outParamDto
	 * @throws BizException
	 */
	private void execReBillRule(MiMcWholeRuleInParamDTO inParamDto, MiMcWholeRuleOutParamDTO outParamDto) throws BizException {
		MiCheckReBillRule checkRule = new MiCheckReBillRule();
		MiMcWholeRuleOutParamDTO ruleCheckRst = checkRule.exec(inParamDto);
		this.addErrorToMain(ruleCheckRst, outParamDto);
	}
	
	/**
	 * 执行单次执行领量限制规则
	 * 
	 * @param inParamDto
	 * @param outParamDto
	 * @throws BizException
	 */
	private void execPickByOnePerformRule(MiMcWholeRuleInParamDTO inParamDto, MiMcWholeRuleOutParamDTO outParamDto) throws BizException {
		MiCheckPickByOnePerformRule checkRule = new MiCheckPickByOnePerformRule();
		MiMcWholeRuleOutParamDTO ruleCheckRst = checkRule.exec(inParamDto);
		this.addErrorToMain(ruleCheckRst, outParamDto);
	}
	
	/**
	 * 执行门诊开单量规则
	 * 
	 * @param inParamDto
	 * @param outParamDto
	 * @throws BizException
	 */
	private void execOpPickRule(MiMcWholeRuleInParamDTO inParamDto, MiMcWholeRuleOutParamDTO outParamDto) throws BizException {
		MiCheckOpPickRule checkRule = new MiCheckOpPickRule();
		MiMcWholeRuleOutParamDTO ruleCheckRst = checkRule.exec(inParamDto);
		this.addErrorToMain(ruleCheckRst, outParamDto);
	}
	
	/**
	 * 执行门诊持有量规则
	 * 
	 * @param inParamDto
	 * @param outParamDto
	 * @throws BizException
	 */
	private void execOpHoldRule(MiMcWholeRuleInParamDTO inParamDto, MiMcWholeRuleOutParamDTO outParamDto) throws BizException {
		MiCheckOpHoldRule checkRule = new MiCheckOpHoldRule();
		MiMcWholeRuleOutParamDTO ruleCheckRst = checkRule.exec(inParamDto);
		this.addErrorToMain(ruleCheckRst, outParamDto);
	}
	
	/**
	 * 执行急诊领料量规则
	 * 
	 * @param inParamDto
	 * @param outParamDto
	 * @throws BizException
	 */
	private void execEmPickRule(MiMcWholeRuleInParamDTO inParamDto, MiMcWholeRuleOutParamDTO outParamDto) throws BizException {
		MiCheckEmPickRule checkRule = new MiCheckEmPickRule();
		MiMcWholeRuleOutParamDTO ruleCheckRst = checkRule.exec(inParamDto);
		this.addErrorToMain(ruleCheckRst, outParamDto);
	}
	
	/**
	 * 特殊病开单规则校验
	 * 
	 * @param inParamDto
	 * @param outParamDto
	 * @throws BizException
	 */
	private void execSpecRule(MiMcWholeRuleInParamDTO inParamDto, MiMcWholeRuleOutParamDTO outParamDto) throws BizException {
		MiCheckSpecRule checkRule = new MiCheckSpecRule();
		MiMcWholeRuleOutParamDTO ruleCheckRst = checkRule.exec(inParamDto);
		this.addErrorToMain(ruleCheckRst, outParamDto);
	}
	
	/**
	 * 执行门诊领药量校验规则(按实际使用天数)
	 * @description:
	 * @author:hanjq  2020年7月8日
	 * @param inParamDto
	 * @param outParamDto
	 * @throws BizException
	 */
	private void execOpDosageRule(MiMcWholeRuleInParamDTO inParamDto, MiMcWholeRuleOutParamDTO outParamDto) throws BizException {
		MiCheckOpDosageRule checkRule = new MiCheckOpDosageRule();
		MiMcWholeRuleOutParamDTO ruleCheckRst = checkRule.exec(inParamDto);
		this.addErrorToMain(ruleCheckRst, outParamDto);
	}
	
	/**
	 * 合并到主结果
	 * 
	 * @param ruleCheckRst
	 * @param checkResultDTO
	 */
	@SuppressWarnings("unchecked")
	private void addErrorToMain(MiMcWholeRuleOutParamDTO checkResultDTO, MiMcWholeRuleOutParamDTO outParamDto ) {
		if (FBooleanUtils.isNullOrFalse(checkResultDTO.getFg_checkflag())) {
			if (CollectionUtils.isNotEmpty(checkResultDTO.getErroritm_list())) {
				outParamDto.getErroritm_list().addAll(checkResultDTO.getErroritm_list());
			}
		}
	}
	
	/**
	 * 处理校验结果 合并同项目的错误信息
	 * 
	 * @param checkResultDTO
	 */
	private void processCheckResult(MiMcWholeRuleOutParamDTO checkResultDTO) {
		if (CollectionUtils.isEmpty(checkResultDTO.getErroritm_list())) {
			checkResultDTO.setFg_checkflag(FBoolean.TRUE);// 如果无错误信息，则校验通过
		} else {
			int size = checkResultDTO.getErroritm_list() == null ? 0 : checkResultDTO.getErroritm_list().size();
			checkResultDTO.setFg_checkflag(FBoolean.FALSE);
			Map<String, MiMcOrdSrvResultDTO> itmRstMap = new HashMap<String, MiMcOrdSrvResultDTO>();
			for (int i = 0; i < size; i++) {
				MiMcOrdSrvResultDTO itm = (MiMcOrdSrvResultDTO) checkResultDTO.getErroritm_list().get(i);
				if (itm == null)
					continue;

				// 判断添加错误信息中是否包含单方类型的错误信息
				boolean isHaveSpr = false;
				String errkey = "";
				Object errval = null;
				for (Map.Entry<String, Object> entry : itm.getError_map().entrySet()) {
					if (MiMcCheckFailResultEnum.SINGLEIDSRV.equals(entry.getKey())) {
						isHaveSpr = true;
						errkey = entry.getKey();
						errval = entry.getValue();
					}
				}

				// 获取对应map的主键
				String key = this.getItmRstKey(itm);
				// 获取已有的错误数据 如果为空 添加
				MiMcOrdSrvResultDTO existItm = itmRstMap.get(key);

				// 判断已有数据中 是否包含 单方类型
				if (existItm != null && !isHaveSpr) {
					for (Map.Entry<String, Object> entry : existItm.getError_map().entrySet()) {
						if (MiMcCheckFailResultEnum.SINGLEIDSRV.equals(entry.getKey())) {
							isHaveSpr = true;
							errkey = entry.getKey();
							errval = entry.getValue();
						}
					}
				}

				if (isHaveSpr) {
					// 如果包含只添加单方类型的错误信息从新new错误数据 添加 当方错误
					itm.setError_map(new FMap());
					itm.getError_map().put(errkey, errval);
				}

				if (existItm == null) {
					itmRstMap.put(key, itm);
				} else if (itm.getError_map() != null) {
					// 如果不包含 添加所有错误信息
					if (!isHaveSpr) {
						existItm.getError_map().putAll(itm.getError_map());
					} else {
						// 如果包含只添加单方类型的错误信息从新new错误数据 添加 当方错误
						existItm.setError_map(new FMap());
						existItm.getError_map().put(errkey, errval);
					}
				}
			}
			FArrayList itmList = CollectionUtils.toFArrayList(itmRstMap.values().toArray(new MiMcOrdSrvResultDTO[0]));
			checkResultDTO.setErroritm_list(itmList);
		}
	}

	/**
	 * 获取key
	 * 
	 * @param itmRst
	 * @return
	 */
	private String getItmRstKey(MiMcOrdSrvResultDTO itmRst) {
		String mmId = itmRst.getId_mm();
		if (StringUtil.isEmpty(mmId)) {
			mmId = "~";
		}
		return itmRst.getCode_or() + '|' + itmRst.getId_srv() + '|' + mmId;
	}
}
