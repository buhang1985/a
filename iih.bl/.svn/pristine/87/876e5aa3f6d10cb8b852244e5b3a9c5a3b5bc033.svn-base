package iih.bl.hp.rule;

import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.FBooleanUtils;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.bl.hp.s.bp.GetHisOrderListBP;
import iih.bl.params.BlParams;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医保规则执行器 1、单方校验规则 2、放射类校验 3、重复开药 4、单次执行领量 5、门诊开单量校验 6、门诊持有量校验 7、急诊开单量校验
 * 
 * @author yankan
 * @since 2017-09-12
 *
 */
public class HpRuleExecuter {
	/**
	 * 用于医生开单的各服务的合计值和配合度等需要在最后保存签署环节才能校验的校验接口， 如单方、领量、持有量等
	 * 
	 * @param checkParamDTO
	 *            开单需要进行校验的相关信息
	 * @return CiHpCheckResultDTO 开单结果。 首先，获得CiHpCheckResultDTO.CheckFlag，
	 *         如果为TRUE,则校验通过，可以保存； 如果为FALSE，则校验失败，
	 *         失败，通过CiHpCheckResultDTO.FailIdorsrvMap获得失败的原因<失败的id_srv,失败原因描述>
	 * @throws BizException
	 */
	public CiHpCheckResultDTO exec(CiHpCheckDTO checkParamDTO) throws BizException {
		CiHpCheckResultDTO checkResultDTO = new CiHpCheckResultDTO();
		checkResultDTO.setCheckflag(FBoolean.TRUE);// 默认通过校验
		checkResultDTO.setErroritm_list(new FArrayList());

		// 初始化参数
//		this.initParamData(checkParamDTO);
//
//		// 1、执行单方规则校验
//		this.execSinglePreRule(checkParamDTO, checkResultDTO);
//
//		// 2、执行放射类校验规则
//		this.execRadiationRule(checkParamDTO, checkResultDTO);
//
//		// 3、执行重复开药限制规则
//		this.execReBillRule(checkParamDTO, checkResultDTO);
//
//		// 4、执行单次执行领量限制   mantis:0113422 去掉单次执行限制
//		//this.execPickByOnePerformRule(checkParamDTO, checkResultDTO);
//
//		// 5、执行门诊领料量校验规则
//		this.execOpPickRule(checkParamDTO, checkResultDTO);
//
//		// 6、执行门诊持有量校验规则
//		this.execOpHoldRule(checkParamDTO, checkResultDTO);
//
//		// 7、执行急诊领料量规则
//		this.execEmPickRule(checkParamDTO, checkResultDTO);
//
//		// 汇总错误信息
//		this.processCheckResult(checkResultDTO);

		return checkResultDTO;
	}

	/**
	 * 初始化参数
	 * 
	 * @param ciHpCheckDTO
	 * @throws BizException
	 */
	private void initParamData(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		// 1、设置就诊信息
		PatiVisitDO patiVisitDO = this.getPatiVisitDO(ciHpCheckDTO.getId_ent());
		ciHpCheckDTO.setEntdo(patiVisitDO);

		// 2、设置患者信息
		PatDO patDO = this.getPatDO(ciHpCheckDTO.getId_pat());
		ciHpCheckDTO.setPatdo(patDO);

		// 3、设置医保计划
		FArrayList2 entHpDOList = this.getEntHpDOLst(ciHpCheckDTO.getId_ent());
		ciHpCheckDTO.setEnthpdo(entHpDOList);

		// 4、设置不限定药品列表
		List<String> unlimitMmList = getBdHpUnlimitDrugDOLst(patiVisitDO.getId_hp());
		ciHpCheckDTO.setId_mmLst(unlimitMmList);

		// 5、设置历史医嘱信息
		ciHpCheckDTO.setQuerydays(BlParams.BLHP000015()); // 默认50天
		GetHisOrderListBP getHisOrBP = new GetHisOrderListBP();
		FArrayList2 hisOrList = getHisOrBP.exec(ciHpCheckDTO, true);
		ciHpCheckDTO.setHistorycidto(hisOrList);
	}

	/**
	 * 执行单方校验规则
	 * 
	 * @param checkParamDTO
	 * @param variable
	 * @param checkResultDTO
	 * @throws BizException
	 */
	private void execSinglePreRule(CiHpCheckDTO checkParamDTO, CiHpCheckResultDTO checkResultDTO) throws BizException {
		CheckSinglePresRule checkRule = new CheckSinglePresRule();
		CiHpCheckResultDTO ruleCheckRst = checkRule.exec(checkParamDTO);
		this.addErrorToMain(ruleCheckRst, checkResultDTO);
	}

	/**
	 * 执行放射类限制规则
	 * 
	 * @param checkParamDTO
	 * @param checkResultDTO
	 * @throws BizException
	 */
	private void execRadiationRule(CiHpCheckDTO checkParamDTO, CiHpCheckResultDTO checkResultDTO) throws BizException {
		CheckRadiationRule checkRule = new CheckRadiationRule();
		CiHpCheckResultDTO ruleCheckRst = checkRule.exec(checkParamDTO);
		this.addErrorToMain(ruleCheckRst, checkResultDTO);
	}

	/**
	 * 执行重复开药限制规则
	 * 
	 * @param checkDTO
	 * @param checkResultDTO
	 * @throws BizException
	 */
	private void execReBillRule(CiHpCheckDTO checkDTO, CiHpCheckResultDTO checkResultDTO) throws BizException {
		CheckReBillRule checkRule = new CheckReBillRule();
		CiHpCheckResultDTO ruleCheckRst = checkRule.exec(checkDTO);
		this.addErrorToMain(ruleCheckRst, checkResultDTO);
	}

	/**
	 * 执行单次执行领量限制规则
	 * 
	 * @param checkDTO
	 * @param checkResultDTO
	 * @throws BizException
	 */
	private void execPickByOnePerformRule(CiHpCheckDTO checkDTO, CiHpCheckResultDTO checkResultDTO) throws BizException {
		CheckPickByOnePerformRule checkRule = new CheckPickByOnePerformRule();
		CiHpCheckResultDTO ruleCheckRst = checkRule.exec(checkDTO);
		this.addErrorToMain(ruleCheckRst, checkResultDTO);
	}

	/**
	 * 执行门诊开单量规则
	 * 
	 * @param checkParamDTO
	 * @param checkResultDTO
	 * @throws BizException
	 */
	private void execOpPickRule(CiHpCheckDTO checkParamDTO, CiHpCheckResultDTO checkResultDTO) throws BizException {
		CheckOpBillDaysRule checkRule = new CheckOpBillDaysRule();
		CiHpCheckResultDTO ruleCheckRst = checkRule.exec(checkParamDTO);
		this.addErrorToMain(ruleCheckRst, checkResultDTO);
	}

	/**
	 * 执行门诊持有量规则
	 * 
	 * @param checkParamDTO
	 * @param checkResultDTO
	 * @throws BizException
	 */
	private void execOpHoldRule(CiHpCheckDTO checkParamDTO, CiHpCheckResultDTO checkResultDTO) throws BizException {
		CheckOpHoldRule checkRule = new CheckOpHoldRule();
		CiHpCheckResultDTO ruleCheckRst = checkRule.exec(checkParamDTO);
		this.addErrorToMain(ruleCheckRst, checkResultDTO);
	}

	/**
	 * 执行急诊领料量规则
	 * 
	 * @param checkParamDTO
	 * @param checkResultDTO
	 * @throws BizException
	 */
	private void execEmPickRule(CiHpCheckDTO checkParamDTO, CiHpCheckResultDTO checkResultDTO) throws BizException {
		CheckEmPickRule checkRule = new CheckEmPickRule();
		CiHpCheckResultDTO ruleCheckRst = checkRule.exec(checkParamDTO);
		this.addErrorToMain(ruleCheckRst, checkResultDTO);
	}

	/**
	 * 合并到主结果
	 * 
	 * @param ruleCheckRst
	 * @param checkResultDTO
	 */
	private void addErrorToMain(CiHpCheckResultDTO ruleCheckRst, CiHpCheckResultDTO checkResultDTO) {
		if (FBooleanUtils.isNullOrFalse(ruleCheckRst.getCheckflag())) {
			if (CollectionUtils.isNotEmpty(ruleCheckRst.getErroritm_list())) {
				checkResultDTO.getErroritm_list().addAll(ruleCheckRst.getErroritm_list());
			}
		}
	}

	/**
	 * 处理校验结果 合并同项目的错误信息
	 * 
	 * @param checkResultDTO
	 */
	private void processCheckResult(CiHpCheckResultDTO checkResultDTO) {
		if (CollectionUtils.isEmpty(checkResultDTO.getErroritm_list())) {
			checkResultDTO.setCheckflag(FBoolean.TRUE);// 如果无错误信息，则校验通过
		} else {
			int size = checkResultDTO.getErroritm_list() == null ? 0 : checkResultDTO.getErroritm_list().size();
			checkResultDTO.setCheckflag(FBoolean.FALSE);
			Map<String, ItmChkRstDTO> itmRstMap = new HashMap<String, ItmChkRstDTO>();
			for (int i = 0; i < size; i++) {
				ItmChkRstDTO itm = (ItmChkRstDTO) checkResultDTO.getErroritm_list().get(i);
				if (itm == null)
					continue;

				// 判断添加错误信息中是否包含单方类型的错误信息
				boolean isHaveSpr = false;
				String errkey = "";
				Object errval = null;
				for (Map.Entry<String, Object> entry : itm.getError_map().entrySet()) {
					if (CiHpCheckFailResultEnum.SINGLEIDSRV.equals(entry.getKey())) {
						isHaveSpr = true;
						errkey = entry.getKey();
						errval = entry.getValue();
					}
				}

				// 获取对应map的主键
				String key = this.getItmRstKey(itm);
				// 获取已有的错误数据 如果为空 添加
				ItmChkRstDTO existItm = itmRstMap.get(key);

				// 判断已有数据中 是否包含 单方类型
				if (existItm != null && !isHaveSpr) {
					for (Map.Entry<String, Object> entry : existItm.getError_map().entrySet()) {
						if (CiHpCheckFailResultEnum.SINGLEIDSRV.equals(entry.getKey())) {
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
			FArrayList itmList = CollectionUtils.toFArrayList(itmRstMap.values().toArray(new ItmChkRstDTO[0]));
			checkResultDTO.setErroritm_list(itmList);
		}
	}

	/**
	 * 获取key
	 * 
	 * @param itmRst
	 * @return
	 */
	private String getItmRstKey(ItmChkRstDTO itmRst) {
		String mmId = itmRst.getId_mm();
		if (StringUtil.isEmpty(mmId)) {
			mmId = "~";
		}
		return itmRst.getCode_or() + '|' + itmRst.getId_srv() + '|' + mmId;
	}

	/**
	 * 获取检查数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getPatiVisitDO(String id_ent) throws BizException {
		IPativisitRService iPativisitRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = iPativisitRService.findById(id_ent);
		return patiVisitDO;
	}

	/**
	 * 获得指定医保计划下无限制用量的药品名单ID_MM
	 * 
	 * @param id_hp
	 *            医保计划
	 * @return
	 * @throws BizException
	 */
	private List<String> getBdHpUnlimitDrugDOLst(String id_hp) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT HPSRV.ID_MM FROM BD_HP_SRVORCA HPSRV ");
		sqlBuilder.append(" INNER JOIN BD_HP_UNLIMIT_DRUG UNLIMIT_DRUG ON UNLIMIT_DRUG.CODE_HP=HPSRV.CODE ");
		sqlBuilder.append(" AND UNLIMIT_DRUG.ID_HP=HPSRV.ID_HP ");
		sqlBuilder.append(" WHERE HPSRV.ID_HP=?");

		SqlParam param = new SqlParam();
		param.addParam(id_hp);

		// 查询不限量药品
		List<HPSrvorcaDO> hPSrvorcaDOList = (List<HPSrvorcaDO>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(HPSrvorcaDO.class));

		List<String> unlimitDrugLst = new ArrayList<String>();
		if (hPSrvorcaDOList != null) {
			for (HPSrvorcaDO hPSrvorcaDO : hPSrvorcaDOList) {
				unlimitDrugLst.add(hPSrvorcaDO.getId_mm());
			}
		}

		return unlimitDrugLst;
	}

	/**
	 * 获取患者信息
	 * 
	 * @param patId
	 *            患者ID
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatDO(String patId) throws BizException {
		IPatiMDORService pipatService = ServiceFinder.find(IPatiMDORService.class);
		PatDO pipatdo = pipatService.findById(patId);
		return pipatdo;
	}

	/**
	 * 获取医保计划
	 * 
	 * @param entId
	 *            就诊ID
	 * @return
	 * @throws BizException
	 */
	private FArrayList2 getEntHpDOLst(String entId) throws BizException {
		IEnthpRService iEnthpRService = ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] entHpDOArr = iEnthpRService.findByAttrValString(EntHpDO.ID_ENT, entId);
		FArrayList2 entHpDOFLst = new FArrayList2();
		if (!ArrayUtil.isEmpty(entHpDOArr)) {
			entHpDOFLst = CollectionUtils.toFArrayList2(entHpDOArr);
		}

		return entHpDOFLst;
	}
}
