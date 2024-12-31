package iih.bl.cg.s.cglogic.et;

import iih.bd.base.utils.MapUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.dto.cglogic.d.BlCgAccountBizDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgApplyDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.s.cglogic.other.BlCgAccDataWarehouse;
import iih.bl.cg.s.cglogic.other.BlCgAccErrorCollector;
import iih.bl.cg.s.cglogic.util.BlCgAccSetInitUtil;
import iih.bl.cg.s.cglogic.util.BlCgDataUtil;
import iih.bl.cg.s.cglogic.validator.BlCgAccAbleValidator;
import iih.bl.cg.s.cglogic.validator.BlCgAccFeeValidator;
import iih.bl.cg.s.cglogic.validator.BlCgNotNullDataValidator;
import iih.bl.cg.s.cglogic.validator.BlCgRepeatAccValidator;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.comm.util.BlMethodUtil;
import iih.bl.comm.util.BlUpdateOrChargeStateUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.reg.pat.d.PatDO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/**
 * 急诊记账(门诊表)
 * @author ly 2019/03/14
 *
 */
public class BlEtOpKeepAccountBP {

	// 记账配置
	private BlCgOpAccountSetDTO accSet;
	
	// 记账数据仓库
	private BlCgAccDataWarehouse dataWh;

	// 错误信息收集器
	private BlCgAccErrorCollector errClctor;
	
	// 患者id
	private List<String> patList = new ArrayList<String>();

	// 就诊id
	protected List<String> enList = new ArrayList<String>(); //2019-05-24 add
	
	// 流程是否到了保存-->不抛异常模式下，如果保存发生异常，照样抛异常
	private boolean saveOper = false; 
	
	// 患者id-->就诊id map
	private Map<String,String> patEnIdMap = new HashMap<String,String>();
		
	/**
	 * 记账
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountRltDTO exec(BlCgAccountDTO[] accDtos, BlCgAccountSetDTO accSetDto) throws BizException{
		
		if (ArrayUtil.isEmpty(accDtos)) {
			throw new BizException("记账数据为空");
		}
		
		// 初始化配置
		BlCgAccountSetDTO ipSetDto = BlCgAccSetInitUtil.init(accSetDto);

		this.accSet = BlCgAccSetInitUtil.convertToOpSet(ipSetDto);
		
		// 初始化数据仓库
		this.dataWh = new BlCgAccDataWarehouse();
		// 初始化错误收集器
		this.errClctor = new BlCgAccErrorCollector(accSetDto.getFg_singlepat());
		
		// 转换入参为业务处理数据
		BlCgAccountBizDTO[] accBizDtos = new BlCgAccountBizDTO[accDtos.length];
		for (int i = 0; i < accDtos.length; i++) {
			accBizDtos[i] = BlCgDataUtil.convertToBizDTO(accDtos[i]);
		}
		
		BlCgAccountRltDTO rlt = new BlCgAccountRltDTO();
		if(FBoolean.TRUE.equals(accSetDto.getFg_exception())){
			rlt = this.keepAccount(accBizDtos);
		}else{
			rlt = this.keepAccountNoException(accBizDtos);
		}
		
		return rlt;
	}
	
	/**
	 * 记账逻辑
	 * @param accBizDtos
	 * @return
	 * @throws BizException
	 */
	private BlCgAccountRltDTO keepAccount(BlCgAccountBizDTO[] accBizDtos) throws BizException{
		
		// 准备患者和就诊数据
		this.prepayPatAndEnData(accBizDtos);
		
		// 可记账判断
		boolean next = this.checkAccAble();
		if (!next) {
			return this.errClctor.returnUnsuccessRlt();
		}
		accBizDtos = this.errClctor.filterBizData2(accBizDtos);
		
		// 数据按患者分组
		Map<String, List<BlCgAccountBizDTO>> accBizMap = this.groupBizData(accBizDtos);
		
		// 执行计划重复记账判断
		if(FBoolean.FALSE.equals(accSet.getFg_addfee())){
			next = this.checkRepeatAcc(accBizDtos, accBizMap);
			if (!next) {
				return this.errClctor.returnUnsuccessRlt();
			}
			accBizDtos = this.errClctor.filterBizData2(accBizDtos);
		}
		
		// 准备医嘱及服务信息
		this.prepayOrSrvData(accBizDtos);
		
		// 计算费用
		if (FBoolean.TRUE.equals(this.accSet.getFg_price_cal())) {
			this.calPrice(accBizDtos);
		}
		
		// 费用校验
		next = this.checkFee(accBizMap);
		if (!next) {
			return this.errClctor.returnUnsuccessRlt();
		}
		accBizDtos = this.errClctor.filterBizData2(accBizDtos);
				
		//补充单据信息
		this.prepayApplyData(accBizDtos);
		
		//---> 以下开始做保存操作
		this.saveOper = true;
		
		// 组装,保存记账数据
		BlcgoepAggDO[] agAggDos = this.assembleAndSaveData(accBizMap);
		
		//回写账户
		this.writebackAccount();
		
		//回写医嘱状态
		this.writebackOrBlState(agAggDos);
			
		//设置返回值
		BlCgAccountRltDTO rltDto = this.setRtnValue(agAggDos);
		
		return rltDto;
	}
	
	/**
	 * 记账逻辑(不抛异常)
	 * @param accDtos
	 * @return
	 * @throws BizException
	 */
	private BlCgAccountRltDTO keepAccountNoException(BlCgAccountBizDTO[] accBizDtos) throws BizException{
		
		BlCgAccountRltDTO rlt = null;

		try {
			rlt = this.keepAccount(accBizDtos);
		} catch (BizException e) {
			
			if(this.saveOper){
				//保存流程中发生异常，直接抛出
				throw e;
			}
			
			rlt = new BlCgAccountRltDTO();
			rlt.setFg_success(FBoolean.FALSE);
			rlt.setErr_msg(e.getMessage());
			rlt.setExcptionstack(BlMethodUtil.getStackInfo(e));
		}

		return rlt;
	}

	/**
	 * 准备患者和就诊数据
	 * @param accBizDtos
	 */
	private void prepayPatAndEnData(BlCgAccountBizDTO[] accBizDtos) throws BizException{	
		//List<String> enList = new ArrayList<String>();  //2019-05-24 delete
		for (BlCgAccountBizDTO accDto : accBizDtos) {
			if(!this.patList.contains(accDto.getId_pat())){
				this.patList.add(accDto.getId_pat());
			}
			if(!StringUtil.isEmpty(accDto.getId_ent()) && ! this.enList.contains(accDto.getId_ent())){
				this.enList.add(accDto.getId_ent());
				this.patEnIdMap.put(accDto.getId_pat(), accDto.getId_ent());
			}

		}
		
		//获取患者，患者账户，就诊信息
		String[] patIds = this.patList.toArray(new String[0]);
		
		this.dataWh.setPatList(BlCgDataUtil.getPatData(patIds));
		this.dataWh.setPatAccList(BlCgDataUtil.getPatAccData(patIds));
		if(this.enList.size() > 0){
			this.dataWh.setEnList(BlCgDataUtil.getEnData(this.enList.toArray(new String[0])));
		}
		this.dataWh.setPatBalanceList(BlCgDataUtil.getPatBalanceData(patIds));
		
		//回写关键数据
		for (BlCgAccountBizDTO bizDto : accBizDtos) {
			
			if(!StringUtil.isEmpty(bizDto.getId_ent())){
				PatiVisitDO enDO = this.dataWh.getEnMap().get(bizDto.getId_ent());
				bizDto.setName_pat(enDO.getName_pat());
				bizDto.setId_pripat(enDO.getId_pripat());
			}else{
				PatDO patDO = this.dataWh.getPatMap().get(bizDto.getId_pat());
				bizDto.setName_pat(patDO.getName());
				bizDto.setId_pripat(patDO.getId_patpritp());
			}
		}
	}

	/**
	 * 准备服务数据
	 * @throws BizException
	 */
	private void prepayOrSrvData(BlCgAccountBizDTO[] accBizDtos) throws BizException {
		
		List<String> srvList = new ArrayList<String>();
		List<String> orList = new ArrayList<String>();
		List<String> orsrvList = new ArrayList<String>();
		List<String> orsrvFormmList = new ArrayList<String>();
		List<String> mmList = new ArrayList<String>();
		
		//2019-05-24 add -b 解决mantis：0157943
		List<String> noOrsrvSrvList = new ArrayList<String>();//无医嘱服务服务集合
		List<String> noOrsrvMmList = new ArrayList<String>();//无医嘱服务物品集合
		//2019-05-24 add -e
		
		for (BlCgAccountBizDTO accBizDto : accBizDtos) {
			
			if(!srvList.contains(accBizDto.getId_srv())){
				srvList.add(accBizDto.getId_srv());
			}
			
			if(!StringUtil.isEmpty(accBizDto.getId_or()) 
					&& !orList.contains(accBizDto.getId_or())){
				orList.add(accBizDto.getId_or());
			}
			
			if (!StringUtil.isEmpty(accBizDto.getId_orsrv())
					&& !orsrvList.contains(accBizDto.getId_orsrv())) {
				orsrvList.add(accBizDto.getId_orsrv());
			}

			if (!StringUtil.isEmpty(accBizDto.getId_orsrv())
					&& FBoolean.TRUE.equals(accBizDto.getFg_mm())
					&& !orsrvFormmList.contains(accBizDto.getId_orsrv())) {
				orsrvFormmList.add(accBizDto.getId_orsrv());
			}

			if (!StringUtil.isEmpty(accBizDto.getId_mm())
					&& !mmList.contains(accBizDto.getId_mm())) {
				mmList.add(accBizDto.getId_mm());
			}
			
			//2019-05-24 add -b 解决mantis：0157943
			if(StringUtil.isEmpty(accBizDto.getId_orsrv())){
				
				if(!noOrsrvSrvList.contains(accBizDto.getId_srv())){
					noOrsrvSrvList.add(accBizDto.getId_srv());
				}
				
				if(!StringUtil.isEmpty(accBizDto.getId_mm()) && 
						!noOrsrvMmList.contains(accBizDto.getId_mm())){
					noOrsrvMmList.add(accBizDto.getId_mm());
				}
			}
			//2019-05-24 add -e
		}
		
		String[] srvArr = srvList.toArray(new String[0]);
		this.dataWh.setSrvList(BlCgDataUtil.getSrvData(srvArr));
		this.dataWh.setCaItmRelList(BlCgDataUtil.getCaItmRelData(IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE, srvArr));

		if (orList.size() > 0) {
			this.dataWh.setOrList(BlCgDataUtil.getCiOrderData(orList.toArray(new String[0])));
		}
		if (orsrvList.size() > 0) {
			this.dataWh.setOrsrvList(BlCgDataUtil.getCiOrsrvData(orsrvList.toArray(new String[0])));
		}
		if (orsrvFormmList.size() > 0) {
			this.dataWh.setOrsrvmmList(BlCgDataUtil.getCiOrsrvmmData(orsrvFormmList.toArray(new String[0])));
		}
		if(mmList.size() > 0) {
			this.dataWh.setMmList(BlCgDataUtil.getMMData(mmList.toArray(new String[0])));
		}
		
		for (BlCgAccountBizDTO bizDto : accBizDtos) {
			MedSrvDO medsrvDO = this.dataWh.getSrvMap().get(bizDto.getId_srv());
			bizDto.setName_srv(medsrvDO.getName());
			
			if(StringUtil.isEmpty(bizDto.getId_unit_srv()) && StringUtil.isEmpty(bizDto.getId_mm())){
				bizDto.setId_unit_srv(medsrvDO.getId_unit_med());
			}
			bizDto.setEu_blmd(medsrvDO.getEu_blmd());
		}
		
		//2019-05-24 add -b 解决mantis：0157943
		// 存在无医嘱费用时，需要查询医保目录
		if (noOrsrvSrvList.size() > 0 || noOrsrvMmList.size() > 0) {
			this.dataWh.setEntHpList(BlCgDataUtil.getEnHpData(this.enList.toArray(new String[0])));

			if (!ListUtil.isEmpty(this.dataWh.getEntHpList())) {				
				List<String> hpIdList = new ArrayList<String>();
				
				for (EntHpDO entHpDO : this.dataWh.getEntHpList()) {
					if (hpIdList.contains(entHpDO.getId_hp()) || StringUtils.isEmpty(entHpDO.getId_hp()))
						continue;
					hpIdList.add(entHpDO.getId_hp());
				}

				// 查询对照数据
				for (String hpId : hpIdList) {
					ThreeDirCompInfoDTO[] compInfoDtos = BlCgDataUtil.getHpCompInfo(hpId,
							noOrsrvSrvList.toArray(new String[0]), noOrsrvMmList.toArray(new String[0]));
					this.dataWh.loadHpCompData(hpId, compInfoDtos);
				}
			}
		}
		//2019-05-24 -e
	}
	
	/**
	 * 补充单据信息
	 * @param accBizDtos
	 * @throws BizException
	 */
	private void prepayApplyData(BlCgAccountBizDTO[] accBizDtos) throws BizException {
		
		Set<String> drugOrsrvSet = new HashSet<String>();//药品
		Set<String> risOrSet = new HashSet<String>(); //检查
		Set<String> lisOrSet = new HashSet<String>(); //检验
		Set<String> bingliOrSet = new HashSet<String>(); //病理
		Set<String> otherOrsrvSet = new HashSet<String>(); //其他
		
		for (BlCgAccountBizDTO bizDto : accBizDtos) {
		
			//暂时只处理原医嘱数据
			if(StringUtil.isEmpty(bizDto.getId_or()) || StringUtil.isEmpty(bizDto.getId_orsrv()))
				continue;
			
			CiOrderDO ordDO = this.dataWh.getOrMap().get(bizDto.getId_or());
			
			if(ordDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
				drugOrsrvSet.add(bizDto.getId_orsrv());
			}else if(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI.equals(ordDO.getSd_srvtp())){
				bingliOrSet.add(bizDto.getId_or());
			}else if(ordDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)){
				risOrSet.add(bizDto.getId_or());
			}else if(ordDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){
				lisOrSet.add(bizDto.getId_or());
			}else{
				otherOrsrvSet.add(bizDto.getId_orsrv());
			}
		}
		
		//Map<String, BlCgApplyDTO> applyMap = new HashMap<String, BlCgApplyDTO>();
		
		if(drugOrsrvSet.size() > 0){
			BlCgApplyDTO[] applyDtos = BlCgDataUtil.getPresCode(drugOrsrvSet.toArray(new String[0]));
			if(!ArrayUtil.isEmpty(applyDtos)){
				this.dataWh.addItmToApplyMap(applyDtos);
			}
		}
		
		if(risOrSet.size() > 0){
			BlCgApplyDTO[] applyDtos = BlCgDataUtil.getRisCode(risOrSet.toArray(new String[0]));
			if(!ArrayUtil.isEmpty(applyDtos)){
				this.dataWh.addItmToApplyMap(applyDtos);
			}
		}
		
		if(lisOrSet.size() > 0){
			BlCgApplyDTO[] applyDtos = BlCgDataUtil.getLisCode(lisOrSet.toArray(new String[0]));
			if(!ArrayUtil.isEmpty(applyDtos)){
				this.dataWh.addItmToApplyMap(applyDtos);
			}
		}
		
		if(bingliOrSet.size() > 0){
			BlCgApplyDTO[] applyDtos = BlCgDataUtil.getBingliCode(bingliOrSet.toArray(new String[0]));
			if(!ArrayUtil.isEmpty(applyDtos)){
				this.dataWh.addItmToApplyMap(applyDtos);
			}
		}
		
		if(otherOrsrvSet.size() > 0){
			BlCgApplyDTO[] applyDtos = BlCgDataUtil.getOtherPrnCode(otherOrsrvSet.toArray(new String[0]));
			if(!ArrayUtil.isEmpty(applyDtos)){
				this.dataWh.addItmToApplyMap(applyDtos);
			}
		}
	}
	
	/**
	 * 可记账校验
	 * @return
	 * @throws BizException
	 */
	private boolean checkAccAble() throws BizException {
		
		BlCgAccAbleValidator validator = new BlCgAccAbleValidator();
		for (String patId : this.patList) {
			try {
				validator.validateEt(this.dataWh.getPatMap().get(patId),
						this.dataWh.getPatAccMap().get(patId));
			} catch (BizException e) {
				this.errClctor.collect(patId, this.patEnIdMap.get(patId) , true, e);
			}
		}

		this.errClctor.filterEnOrPatList(this.patList);
		return this.patList.size() > 0;
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
		
		Map<String,FDouble> prsrvQuanMap = BlCgDataUtil.getPrsrvCgQuanEt(prsrvList.toArray(new String[0]));
		if(prsrvQuanMap.size() == 0)
			return true;
		
		BlCgRepeatAccValidator validator = new BlCgRepeatAccValidator();
		for (String patId : accBizMap.keySet()) {
			
			if(!this.patList.contains(patId))
				continue;
			
			try {
				List<BlCgAccountBizDTO> accBizList = accBizMap.get(patId);
				validator.validate(accBizList, prsrvQuanMap);
			} catch (BizException e) {
				this.errClctor.collect(patId, this.patEnIdMap.get(patId) , true, e);
			}
		}

		this.errClctor.filterEnOrPatList(this.patList);
		return this.patList.size() > 0;
	}
	
	/**
	 * 计价
	 * @param accBizDtos 记账业务数据
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
	 * 数据按患者分组
	 * @param accBizDtos
	 * @return
	 */
	private Map<String, List<BlCgAccountBizDTO>> groupBizData(BlCgAccountBizDTO[] accBizDtos) {
		
		Map<String, List<BlCgAccountBizDTO>> map = new HashMap<String, List<BlCgAccountBizDTO>>();
		for (BlCgAccountBizDTO bizDto : accBizDtos) {

			List<BlCgAccountBizDTO> bizList = null;
			if (map.containsKey(bizDto.getId_pat())) {
				bizList = map.get(bizDto.getId_pat());
			} else {
				bizList = new ArrayList<BlCgAccountBizDTO>();
				map.put(bizDto.getId_pat(), bizList);
			}
			bizList.add(bizDto);
		}

		return map;
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

		for (String patId : accBizMap.keySet()) {
			
			if(!this.patList.contains(patId))
				continue;
			
			try {
				List<BlCgAccountBizDTO> accBizList = accBizMap.get(patId);

				feeValidator.validateEt(accBizList, this.dataWh.getPatBalanceMap().get(patId));

				nullValidator.validate(accBizList, this.dataWh);
				
			} catch (BizException e) {
				this.errClctor.collect(patId, this.patEnIdMap.get(patId) , true, e);
			}
		}

		this.errClctor.filterEnOrPatList(this.patList);
		return this.patList.size() > 0;
	}

	/**
	 * 组装保存记账数据(记账数据一主一子)
	 * @param accBizMap
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO[] assembleAndSaveData(Map<String, List<BlCgAccountBizDTO>> accBizMap) throws BizException {
		
		List<BlcgoepAggDO> aggList = new ArrayList<BlcgoepAggDO>();
		
		int count = 0;
		for (String key : accBizMap.keySet()) {
			count += accBizMap.get(key).size();
		}
		
		IBillcodeManage iBillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		String[] codes = iBillcodeManage.getBatchBillCodes_RequiresNew(BlCgOepDO.class.getName(),new BlCgOepDO(), count);
		
		int i = 0;
		for (String key : accBizMap.keySet()) {
			
			List<BlCgAccountBizDTO> bizAccList = accBizMap.get(key);
			
			for (BlCgAccountBizDTO bizDto : bizAccList) {
				
				BlcgoepAggDO cgAggDO = BlCgDataUtil.buildCgData(bizDto, codes[i], this.accSet, this.dataWh);
				
				//统计消费金额
				BlCgOepDO cgHeadDO = cgAggDO.getParentDO();
				for (BlCgItmOepDO cgItmDO : cgAggDO.getBlCgItmOepDO()) {
					this.dataWh.countConsume(cgItmDO.getId_pat(), cgItmDO.getAmt_ratio()
							.multiply(cgHeadDO.getEu_direct()),FBoolean.FALSE);
				}
				
				aggList.add(cgAggDO);
				i++;
			}
		}

		IBlcgoepCudService cudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] newAggDos = cudService.insert(aggList.toArray(new BlcgoepAggDO[0]));
		
		return newAggDos;
	}
	/**
	 * 回写账户状态
	 * @throws BizException
	 */
	private void writebackAccount() throws BizException {
		
		Set<String> lockKeyList = new HashSet<String>();
		Set<String> accIdList = new HashSet<String>();
		
		for (String key : this.dataWh.getPersonalConsumeMap().keySet()) {
			PiPatAccDO acc = this.dataWh.getPatAccMap().get(key);
			String lockKey = acc.getId_pat() + acc.getId_patacc();
			lockKeyList.add(lockKey);
			accIdList.add(acc.getId_patacc());
		}

		if (accIdList.size() == 0)
			return;
		
		//加锁
		boolean lock = PKLock.getInstance().addBatchDynamicLock(lockKeyList.toArray(new String[0]), 5 * 1000);
		if(!lock){
			throw new BizException("当前PI_PAT_ACC数据正在被他人修改，请刷新重试:" + accIdList.toArray(new String[0])[0]);
		}
		
		String sqlTemp = "update pi_pat_acc set acc_lock_emgstay = acc_lock_emgstay + (?) where id_patacc = ? ";
		PersistMgr persist = null;
		PersistSession session = null;
		
		try {
			
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			
			for (String key : this.dataWh.getPersonalConsumeMap().keySet()) {
				FDouble amt = this.dataWh.getPersonalConsumeMap().get(key);
				PiPatAccDO acc = this.dataWh.getPatAccMap().get(key);
				
				SqlParam param = new SqlParam();
				param.addParam(amt);
				param.addParam(acc.getId_patacc());
				session.addBatch(sqlTemp, param);
			}
			session.execBatch();
		} catch (Exception e) {
			throw new BizException("更新账户异常，失败原因为："+e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
	}
	
	/**
	 * 回写医嘱记账状态
	 * @param ipDos
	 * @throws BizException
	 */
	private void writebackOrBlState(BlcgoepAggDO[] agAggDos) throws BizException{
		
		Set<String> orsrvSet = new HashSet<String>();
		for (BlcgoepAggDO cgAggDO : agAggDos) {
			for (BlCgItmOepDO cgItmDO : cgAggDO.getBlCgItmOepDO()) {
			
				if(!StringUtil.isEmpty(cgItmDO.getId_orsrv())){
					orsrvSet.add(cgItmDO.getId_orsrv());
				}
			}
		}
		
		if(orsrvSet.size() == 0)
			return;
		
		BlUpdateOrChargeStateUtil.updateChargeStatus(orsrvSet.toArray(new String[0]),
				BlFlowContextUtil.getNowTime(), FeeReverseType.NOBLCANCEL);
	}
	
	/**
	 * 设置返回值
	 * @param agAggDos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlCgAccountRltDTO setRtnValue(BlcgoepAggDO[] agAggDos) throws BizException {

		BlCgAccountRltDTO rltDto = new BlCgAccountRltDTO();
		rltDto.setFg_success(FBoolean.TRUE);

		FArrayList cgList = new FArrayList();
		cgList.addAll(Arrays.asList(agAggDos));
		rltDto.setCglist(cgList);

		FArrayList errList = new FArrayList();
		errList.addAll(this.errClctor.getFailRltList());

		rltDto.setError_entlist(errList);

		return rltDto;
	}
}
