package iih.bl.cg.s.cglogic.ip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.MapUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountBizDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgErrorDTO;
import iih.bl.cg.s.cglogic.other.BlCgAccDataWarehouse;
import iih.bl.cg.s.cglogic.other.BlCgAccErrorCollector;
import iih.bl.cg.s.cglogic.util.BlCgAccSetInitUtil;
import iih.bl.cg.s.cglogic.util.BlCgDataUtil;
import iih.bl.cg.s.cglogic.validator.BlCgAccFeeValidator;
import iih.bl.cg.s.cglogic.validator.BlCgAccParamValidator;
import iih.bl.cg.s.cglogic.validator.BlCgNotNullDataValidator;
import iih.bl.cg.s.cglogic.validator.BlCgRepeatAccValidator;
import iih.bl.comm.util.BlPrepayWarnUtil;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院记账记账前校验
 * @author ly 2018/10/05
 *
 */
public class BlIpCheckBeforeKeepBP extends BlIpKeepAccountBaseBP{
	
	// 记账配置
	private BlCgAccountSetDTO accSet;
	
	/**
	 * 住院记账校验逻辑
	 * 目前用于药品记账前校验
	 * @param accDtos 待记账数据
	 * @param accSetDto 记账配置
	 * @return 校验结果
	 * @throws BizException
	 */
	public BlCgErrorDTO[] exec(BlCgAccountDTO[] accDtos, BlCgAccountSetDTO accSetDto) throws BizException {
	
		if (ArrayUtil.isEmpty(accDtos)) {
			throw new BizException("记账数据为空");
		}

		// 初始化配置
		this.accSet = BlCgAccSetInitUtil.init(accSetDto);
		// 初始化数据仓库
		this.dataWh = new BlCgAccDataWarehouse();
		this.dataWh.loadIpParam();
		// 初始化错误收集器
		this.errClctor = new BlCgAccErrorCollector(FBoolean.TRUE);
		
		// 入参校验
		BlCgAccParamValidator validator = new BlCgAccParamValidator(this.accSet);
		for (int i = 0; i < accDtos.length; i++) {
			validator.validateCharge(accDtos[i], i, this.dataWh.getFgZeroCg());
		}

		// 转换入参为业务处理数据
		BlCgAccountBizDTO[] accBizDtos = new BlCgAccountBizDTO[accDtos.length];
		for (int i = 0; i < accDtos.length; i++) {
			accBizDtos[i] = BlCgDataUtil.convertToBizDTO(accDtos[i]);
		}
		
		// 准备就诊关联的数据
		this.prepareEnRelatedData(accBizDtos);
		
		// 可记账判断
		boolean next = super.checkAccAble();
		if (!next) {
			return this.errClctor.getFailRltList().toArray(new BlCgErrorDTO[0]);
		}
		accBizDtos = this.errClctor.filterBizData(accBizDtos);
		
		// 准备服务数据
		this.prepaySrvData(accBizDtos);
		
		// 数据按患者分组
		Map<String, List<BlCgAccountBizDTO>> accBizMap = this.groupBizData(accBizDtos);
				
		// 执行计划重复记账判断
		if(FBoolean.FALSE.equals(accSet.getFg_addfee())){
			next = this.checkRepeatAcc(accBizDtos, accBizMap);
			if (!next) {
				return this.errClctor.getFailRltList().toArray(new BlCgErrorDTO[0]);
			}
			accBizDtos = this.errClctor.filterBizData(accBizDtos);
		}
		
		// 计价
		if (FBoolean.TRUE.equals(this.accSet.getFg_price_cal())) {
			this.calPrice(accBizDtos);
		}

		// 费用校验
		this.checkFee(accBizMap);
		
	    return this.errClctor.getFailRltList().toArray(new BlCgErrorDTO[0]);
	}
	
	/**
	 * 准备就诊关联数据
	 * @param accBizDtos
	 * @throws BizException
	 */
	private void prepareEnRelatedData(BlCgAccountBizDTO[] accBizDtos) throws BizException {
		
		for (BlCgAccountBizDTO accDto : accBizDtos) {
			if (!StringUtil.isEmpty(accDto.getId_ent())
					&& !this.enList.contains(accDto.getId_ent())) {
				this.enList.add(accDto.getId_ent());
			}
		}
		
		//查询就诊关联数据
		super.queryEnRelatedData();
		
		//准备预交金策略数据
		if(FBoolean.FALSE.equals(this.accSet.getFg_postpaid())){
			
			Set<String> patcaIdSet = new HashSet<String>();
			Set<String> depIdSet = new HashSet<String>();
			
			for (PatiVisitDO enDO : this.dataWh.getEnList()) {
				patcaIdSet.add(enDO.getId_patca());
				depIdSet.add(enDO.getId_dep_phy());
			}
			
			BdPreWarnDO[] warnDos = BlPrepayWarnUtil.getPreWarnSetting(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			this.dataWh.setWarnDos(warnDos);
		}
		
		// 回写关键数据
		for (BlCgAccountBizDTO bizDto : accBizDtos) {

			PatiVisitDO enDO = this.dataWh.getEnMap().get(bizDto.getId_ent());
			bizDto.setName_pat(enDO.getName_pat());
			bizDto.setId_pripat(enDO.getId_pripat());
			
			NewbornDO bornDO = this.dataWh.getNbMap().get(bizDto.getId_ent());
			if (bornDO != null) {
				bizDto.setId_ent_mm(bornDO.getId_ent_mom());
				bizDto.setFg_bb(FBoolean.TRUE);
				bizDto.setNo_bb(bornDO.getNo_bb());
			}
		}
	}

	/**
	 * 准备服务数据
	 * @param accBizDtos
	 * @throws BizException
	 */
	private void prepaySrvData(BlCgAccountBizDTO[] accBizDtos) throws BizException {
		
		List<String> srvList = new ArrayList<String>();
		
		for (BlCgAccountBizDTO bizDto : accBizDtos) {

			if (!srvList.contains(bizDto.getId_srv())) {
				srvList.add(bizDto.getId_srv());
			}
		}
		
		String[] srvArr = srvList.toArray(new String[0]);
		this.dataWh.setSrvList(BlCgDataUtil.getSrvData(srvArr));
		this.dataWh.setCaItmRelList(BlCgDataUtil.getCaItmRelData(
				IBdPpCodeTypeConst.SD_INHOS_INVOICE, srvArr));
		
		// 回写关键数据
		for (BlCgAccountBizDTO bizDto : accBizDtos) {
			MedSrvDO medsrvDO = this.dataWh.getSrvMap().get(bizDto.getId_srv());
			bizDto.setName_srv(medsrvDO.getName());
			
			if(StringUtil.isEmpty(bizDto.getId_unit_srv()) && StringUtil.isEmpty(bizDto.getId_mm())){
				bizDto.setId_unit_srv(medsrvDO.getId_unit_med());
			}
			bizDto.setEu_blmd(medsrvDO.getEu_blmd());
		}
	}

	/**
	 * 按患者分组数据
	 * 
	 * @param accBizDtos
	 * @return
	 */
	private Map<String, List<BlCgAccountBizDTO>> groupBizData(
			BlCgAccountBizDTO[] accBizDtos) {

		Map<String, List<BlCgAccountBizDTO>> map = new HashMap<String, List<BlCgAccountBizDTO>>();
		for (BlCgAccountBizDTO bizDto : accBizDtos) {

			List<BlCgAccountBizDTO> bizList = null;
			if (map.containsKey(bizDto.getId_ent())) {
				bizList = map.get(bizDto.getId_ent());
			} else {
				bizList = new ArrayList<BlCgAccountBizDTO>();
				map.put(bizDto.getId_ent(), bizList);
			}
			bizList.add(bizDto);
		}

		return map;
	}
	
	/**
	 * 重复计费校验
	 * 
	 * @param accBizDtos
	 * @return
	 */
	private boolean checkRepeatAcc(BlCgAccountBizDTO[] accBizDtos, Map<String, List<BlCgAccountBizDTO>> accBizMap) throws BizException {
		
		List<String> prsrvList = new ArrayList<String>();
		for (BlCgAccountBizDTO accDto : accBizDtos) {
			if(!StringUtil.isEmpty(accDto.getId_or_prsrv())){
				prsrvList.add(accDto.getId_or_prsrv());
			}
		}
		
		if(ListUtil.isEmpty(prsrvList))
			return true;
		
		Map<String,FDouble> prsrvQuanMap = BlCgDataUtil.getPrsrvCgQuan(prsrvList.toArray(new String[0]));
		if(prsrvQuanMap.size() == 0)
			return true;
		
		BlCgRepeatAccValidator validator = new BlCgRepeatAccValidator();
		for (String entId : accBizMap.keySet()) {
			
			if(!this.enList.contains(entId))
				continue;
			
			try {
				List<BlCgAccountBizDTO> accBizList = accBizMap.get(entId);
				validator.validate(accBizList, prsrvQuanMap);
			} catch (BizException e) {
				this.errClctor.collect(entId, false, e);
			}
		}

		this.errClctor.filterEnOrPatList(this.enList);
		return this.enList.size() > 0;
	}

	/**
	 * 计价
	 * 
	 * @param accBizDtos
	 *            记账业务数据
	 * @return
	 * @throws BizException
	 */
	private void calPrice(BlCgAccountBizDTO[] accBizDtos) throws BizException {

		List<String> srvList = new ArrayList<String>();
		List<String> pripatList = new ArrayList<String>();

		for (BlCgAccountBizDTO bizDto : accBizDtos) {

			if (FBoolean.TRUE.equals(bizDto.getFg_mm())) {
				continue;
			}

			if (!srvList.contains(bizDto.getId_srv())) {
				srvList.add(bizDto.getId_srv());
			}

			if (!pripatList.contains(bizDto.getId_pripat())) {
				pripatList.add(bizDto.getId_pripat());
			}
		}

		if (srvList.size() == 0)
			return;

		IBdPriCalService calService = ServiceFinder.find(IBdPriCalService.class);
		BdPriViewDTO[] priViewDtos = calService.calSrvPrice(
				srvList.toArray(new String[0]),
				pripatList.toArray(new String[0]));

		if (ArrayUtil.isEmpty(priViewDtos))
			return;

		// 回写单价
		@SuppressWarnings("unchecked")
		Map<String, BdPriViewDTO> priMap = (Map<String, BdPriViewDTO>) MapUtils
				.convertArrayToMap(priViewDtos, "Id_srv,Id_pripat");

		for (BlCgAccountBizDTO bizDto : accBizDtos) {

			if (FBoolean.TRUE.equals(bizDto.getFg_mm())) {
				bizDto.setRatio_pripat(FDouble.ONE_DBL);
				continue;
			}
			
			if (MedSrvBlModeEnum.MANUALBL == bizDto.getEu_blmd()){
				if (bizDto.getPrice_ratio() != null
						&& !FDouble.ZERO_DBL.equals(bizDto.getPrice_ratio())) {
					bizDto.setPrice_std(bizDto.getPrice_ratio());
					bizDto.setRatio_pripat(FDouble.ONE_DBL);
				}else if(!StringUtil.isEmpty(bizDto.getId_orsrv())){
					OrdSrvDO orsrvDO = dataWh.getOrsrvMap().get(bizDto.getId_orsrv());
					if(orsrvDO != null && orsrvDO.getPri() != null && !FDouble.ZERO_DBL.equals(orsrvDO.getPri())){
						bizDto.setPrice_ratio(orsrvDO.getPri());
						bizDto.setPrice_std(orsrvDO.getPri());
						bizDto.setRatio_pripat(FDouble.ONE_DBL);
					}
				}
				
				if(bizDto.getPrice_ratio() != null && !FDouble.ZERO_DBL.equals(bizDto.getPrice_ratio()))
					continue;
			}

			String key = bizDto.getId_srv() + bizDto.getId_pripat();
			BdPriViewDTO priDto = priMap.get(key);

			if (priDto != null) {
				bizDto.setPrice_std(priDto.getPrice_std());
				bizDto.setPrice_ratio(priDto.getPrice_ratio());
				bizDto.setRatio_pripat(priDto.getRate());
			}
		}
	}

	/**
	 * 费用校验
	 * 
	 * @param accBizMap
	 * @return 是否可进行下一环节
	 * @throws BizException
	 */
	private boolean checkFee(Map<String, List<BlCgAccountBizDTO>> accBizMap)
			throws BizException {

		BlCgAccFeeValidator feeValidator = new BlCgAccFeeValidator(this.accSet);
		BlCgNotNullDataValidator nullValidator = new BlCgNotNullDataValidator();

		for (String entId : accBizMap.keySet()) {
			
			if(!this.enList.contains(entId))
				continue;
			
			try {
				List<BlCgAccountBizDTO> accBizList = accBizMap.get(entId);

				String peId = this.dataWh.getEntPeMap().get(entId);
				BalanceDTO peBalance = null;
				if (!StringUtil.isEmpty(peId)) {
					peBalance = this.dataWh.getPebalanceMap().get(peId);
				}
				feeValidator.validate(accBizList,this.dataWh.getBalanceMap().get(entId), peBalance,
						this.dataWh.getEnMap().get(entId), this.dataWh.getWarnDos());

				nullValidator.validate(accBizList, this.dataWh);
			} catch (BizException e) {
				this.errClctor.collect(entId, false, e);
			}
		}

		this.errClctor.filterEnOrPatList(this.enList);
		return this.enList.size() > 0;
	}
}
