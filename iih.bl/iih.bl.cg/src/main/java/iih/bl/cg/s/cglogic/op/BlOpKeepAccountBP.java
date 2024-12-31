package iih.bl.cg.s.cglogic.op;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.PrecisionUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.dto.prisrvcompratio.d.BdPriSrvCompRatioDTO;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.dto.cglogic.d.BlCgAccountBizDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgApplyDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.cg.s.cglogic.event.BlOepCgEvent;
import iih.bl.cg.s.cglogic.other.BlCgAccDataWarehouse;
import iih.bl.cg.s.cglogic.other.BlCgAccErrorCollector;
import iih.bl.cg.s.cglogic.util.BlCgAccSetInitUtil;
import iih.bl.cg.s.cglogic.util.BlCgDataUtil;
import iih.bl.cg.s.cglogic.validator.BlCgAccAbleValidator;
import iih.bl.cg.s.cglogic.validator.BlCgAccFeeValidator;
import iih.bl.cg.s.cglogic.validator.BlCgAccParamValidator;
import iih.bl.cg.s.cglogic.validator.BlCgNotNullDataValidator;
import iih.bl.cg.s.cglogic.validator.BlCgRepeatAccValidator;
import iih.bl.comm.IBlConst;
import iih.bl.comm.log.BLTimeLogger;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.comm.util.BlMethodUtil;
import iih.bl.comm.util.BlSqlQueryUtil;
import iih.bl.comm.util.BlUpdateOrChargeStateUtil;
import iih.bl.params.BlParamValueConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mm.itf.material.d.GetMaterialPriceDTO;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.d.ReserveReqDTO;
import iih.mm.itf.material.d.ReserveResultDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
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
 * 门诊记账逻辑类
 * @author ly 2018/11/08
 */
public class BlOpKeepAccountBP{

	// 记账数据仓库
	private BlCgAccDataWarehouse dataWh;

	// 错误信息收集器
	private BlCgAccErrorCollector errClctor;
	
	// 患者id
	private List<String> patList = new ArrayList<String>();
	
	// 记账配置
	private BlCgOpAccountSetDTO accSet;
	
	// 流程是否到了保存-->不抛异常模式下，如果保存发生异常，照样抛异常
	private boolean saveOper = false; 
	
	/**
	 * 记账
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountRltDTO exec(BlCgAccountDTO[] accDtos,BlCgOpAccountSetDTO accSetDto) throws BizException{
		
		if(ArrayUtil.isEmpty(accDtos)){
			throw new BizException("记账数据为空");
		}
		
		if(accSetDto == null || StringUtil.isEmpty(accSetDto.getEu_oepcgmode())){
			throw new BizException("记账配置门诊记账模式为空");
		}
		
		//初始化配置
		this.accSet = BlCgAccSetInitUtil.init(accSetDto);
		this.dataWh = new BlCgAccDataWarehouse();
		this.dataWh.loadOepParam();
		// 初始化错误收集器
	    this.errClctor = new BlCgAccErrorCollector(FBoolean.FALSE);
				
		//入参校验
		BlCgAccParamValidator validator = new BlCgAccParamValidator(this.accSet);
		for (int i = 0; i < accDtos.length; i++) {
			validator.validateChargeOep(accDtos[i], i, this.dataWh.getFgZeroCg());
		}
		
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
		//发生事件
		BlOepCgEvent.invokeAccount(rlt, accSetDto);
		return rlt;
	}
	
	/**
	 * 记账逻辑
	 * @param accBizDtos
	 * @return
	 * @throws BizException
	 */
	private BlCgAccountRltDTO keepAccount(BlCgAccountBizDTO[] accBizDtos) throws BizException{
		
		BLTimeLogger timeLogger = new BLTimeLogger();
		timeLogger.begin("门诊记账");
		
		// 准备患者和就诊数据	
		this.prepayPatAndEnData(accBizDtos);
		
		// 可记账判断
		boolean next = this.checkAccAble();
		if (!next) {
			return this.errClctor.returnUnsuccessRlt();
		}
		accBizDtos = this.errClctor.filterBizData2(accBizDtos);
		
		// 准备医嘱及服务信息
		this.prepayOrSrvData(accBizDtos);
		
		if(FBoolean.TRUE.equals(this.accSet.getFg_price_cal())){
			// 计算费用
			this.calPrice(accBizDtos);
		}
		
		// 数据按患者分组
		Map<String, List<BlCgAccountBizDTO>> accBizMap = this.groupBizData(accBizDtos);
		
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
		BlcgoepAggDO[] agAggDos = null;
		
		if(this.accSet.getEu_srctp() == FeeOriginEnum.ENCOUNTER_FEE){
			agAggDos = this.assembleAndSaveDataGroup(accBizMap);
		}else{
			agAggDos = this.assembleAndSaveData(accBizMap);
		}
		
		//回写账户
		this.writebackAccount();
		
		if(FBoolean.TRUE.equals(this.accSet.getFg_updateor())){
			//回写医嘱状态
			this.writebackOrBlState(agAggDos);
		}
		
		timeLogger.end("门诊记账");
		
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
		
		List<String> enList = new ArrayList<String>();
		for (BlCgAccountBizDTO accDto : accBizDtos) {
			if(!this.patList.contains(accDto.getId_pat())){
				this.patList.add(accDto.getId_pat());
			}
			if(!StringUtil.isEmpty(accDto.getId_ent()) && !enList.contains(accDto.getId_ent())){
				enList.add(accDto.getId_ent());
			}
		}
		
		//获取患者，患者账户，就诊信息
		String[] patIds = this.patList.toArray(new String[0]);
		
		this.dataWh.setPatList(BlCgDataUtil.getPatData(patIds));
		this.dataWh.setPatAccList(BlCgDataUtil.getPatAccData(patIds));
		if(enList.size() > 0){
			this.dataWh.setEnList(BlCgDataUtil.getEnData(enList.toArray(new String[0])));
		}
		this.dataWh.setPatBalanceList(BlCgDataUtil.getPatBalanceData(patIds));
		
		//回写关键数据
		for (BlCgAccountBizDTO bizDto : accBizDtos) {
			
			if(!StringUtil.isEmpty(bizDto.getId_ent())){
				PatiVisitDO enDO = this.dataWh.getEnMap().get(bizDto.getId_ent());
				bizDto.setName_pat(enDO.getName_pat());
				if(StringUtil.isEmpty(bizDto.getId_pripat())){
					bizDto.setId_pripat(enDO.getId_pripat());
				}
			}else{
				PatDO patDO = this.dataWh.getPatMap().get(bizDto.getId_pat());
				bizDto.setName_pat(patDO.getName());
				if(StringUtil.isEmpty(bizDto.getId_pripat())){
					bizDto.setId_pripat(patDO.getId_patpritp());
				}
			}
		}
	}
	
	/**
	 * 准备服务数据
	 * @throws BizException
	 */
	private void prepayOrSrvData(BlCgAccountBizDTO[] accBizDtos) throws BizException {
		
		Set<String> srvSet = new HashSet<String>();
		Set<String> orSet = new HashSet<String>();
		Set<String> orsrvSet = new HashSet<String>();
		Set<String> orsrvFormmSet = new HashSet<String>();
		Set<String> mmSet = new HashSet<String>();
		
		for (BlCgAccountBizDTO accBizDto : accBizDtos) {
			
			srvSet.add(accBizDto.getId_srv());
			
			if(!StringUtil.isEmpty(accBizDto.getId_or())){
				orSet.add(accBizDto.getId_or());
			}
			
			if (!StringUtil.isEmpty(accBizDto.getId_orsrv())) {
				orsrvSet.add(accBizDto.getId_orsrv());
			}

			if (!StringUtil.isEmpty(accBizDto.getId_orsrv())
					&& FBoolean.TRUE.equals(accBizDto.getFg_mm())) {
				orsrvFormmSet.add(accBizDto.getId_orsrv());
			}

			if (!StringUtil.isEmpty(accBizDto.getId_mm())) {
				mmSet.add(accBizDto.getId_mm());
			}
		}
		
		String[] srvArr = srvSet.toArray(new String[0]);
		this.dataWh.setSrvList(BlCgDataUtil.getSrvData(srvArr));
		this.dataWh.setCaItmRelList(BlCgDataUtil.getCaItmRelData(
				IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE, srvArr));

		if(IBdPpCodeTypeConst.SD_OUTREGISTER_INVIOCE.equals(this.dataWh.getRegInccaCode()) && FeeOriginEnum.ENCOUNTER_FEE.equals(this.accSet.getEu_srctp())){
			this.dataWh.setCaItmRelRegList(BlCgDataUtil.getCaItmRelData(
					IBdPpCodeTypeConst.SD_OUTREGISTER_INVIOCE, srvArr));
		}
		
		if (orSet.size() > 0) {
			this.dataWh.setOrList(BlCgDataUtil.getCiOrderData(orSet.toArray(new String[0])));
		}
		if (orsrvSet.size() > 0) {
			this.dataWh.setOrsrvList(BlCgDataUtil.getCiOrsrvData(orsrvSet.toArray(new String[0])));
		}
		if (orsrvFormmSet.size() > 0) {
			this.dataWh.setOrsrvmmList(BlCgDataUtil.getCiOrsrvmmData(orsrvFormmSet.toArray(new String[0])));
		}
		if(mmSet.size() > 0) {
			this.dataWh.setMmList(BlCgDataUtil.getMMData(mmSet.toArray(new String[0])));
		}
		
		Set<String> srvOrSet = new HashSet<String>();
		for (BlCgAccountBizDTO bizDto : accBizDtos) {
			MedSrvDO medsrvDO = this.dataWh.getSrvMap().get(bizDto.getId_srv());
			bizDto.setName_srv(medsrvDO.getName());
			
			if(StringUtil.isEmpty(bizDto.getId_unit_srv()) && StringUtil.isEmpty(bizDto.getId_mm())){
				bizDto.setId_unit_srv(medsrvDO.getId_unit_med());
			}
			bizDto.setEu_blmd(medsrvDO.getEu_blmd());
			
			if(!StringUtil.isEmpty(bizDto.getId_orsrv())){
				OrdSrvDO orsrvDO = this.dataWh.getOrsrvMap().get(bizDto.getId_orsrv());
				bizDto.setFg_or(orsrvDO.getFg_or());
			}
			
			if(!StringUtil.isEmpty(bizDto.getId_or())&&StringUtil.isEmpty(bizDto.getPecode())){
				CiOrderDO ordDO = this.dataWh.getOrMap().get(bizDto.getId_or());
				bizDto.setId_srv_or(ordDO.getId_srv());
				srvOrSet.add(ordDO.getId_srv());
			}
		}
		
		//组合计价特殊比例数据
		if(srvOrSet.size() > 0){
			this.dataWh.setCompRatioMap(BlCgDataUtil.getSpecialCompRatioData(srvOrSet.toArray(new String[0])));
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
				validator.validate(this.dataWh.getPatMap().get(patId),
						this.dataWh.getPatAccMap().get(patId), this.accSet);
			} catch (BizException e) {
				this.errClctor.collect(patId, true, e);
			}
		}

		this.errClctor.filterEnOrPatList(this.patList);
		return this.patList.size() > 0;
	}

	/**
	 * 计算价格
	 * 暂时不处理物品无Id_orsrv情况
	 * @param accBizDtos
	 * @throws BizException
	 */
	private void calPrice(BlCgAccountBizDTO[] accBizDtos) throws BizException {
		
		List<String> srvList = new ArrayList<String>();
		List<String> pripatList = new ArrayList<String>();
		List<String> mmList = new ArrayList<String>();
		List<ReserveReqDTO> reserveList = new ArrayList<ReserveReqDTO>();
		List<GetStockReqDTO> stockList = new ArrayList<GetStockReqDTO>();
		Set<String> otMMHashSet = new HashSet<String>();
		
		for (BlCgAccountBizDTO bizDto : accBizDtos) {

			if (FBoolean.TRUE.equals(bizDto.getFg_mm())) {
				if(FBoolean.FALSE.equals(bizDto.getFg_or())){
					String key = bizDto.getId_mm() + "," + bizDto.getId_pkgu_cur();
					otMMHashSet.add(key);
				}else if(FBoolean.TRUE.equals(this.accSet.getFg_reserve())){
					ReserveReqDTO reqDto = new ReserveReqDTO();
					reqDto.setId_mm(bizDto.getId_mm());
					reqDto.setId_dep(bizDto.getId_dep_wh());
					reqDto.setReq_num(bizDto.getQuan());
					reqDto.setReq_unit_id(bizDto.getId_pkgu_cur());
					reqDto.setId_orsrv(bizDto.getId_orsrv());
					
					reserveList.add(reqDto);
				}else{
					if(!mmList.contains(bizDto.getId_mm())){
						GetStockReqDTO reqDto = new GetStockReqDTO();
						reqDto.setId_mm(bizDto.getId_mm());
						reqDto.setId_dep(bizDto.getId_dep_wh());
						reqDto.setReq_unit_id(bizDto.getId_pkgu_cur());
						
						stockList.add(reqDto);
						mmList.add(bizDto.getId_mm());
					}
				}
			}else{
				if (!srvList.contains(bizDto.getId_srv())) {
					srvList.add(bizDto.getId_srv());
				}
				if (!pripatList.contains(bizDto.getId_pripat())) {
					pripatList.add(bizDto.getId_pripat());
				}
			}
		}
		
		Map<String, BdPriViewDTO> priMap = new HashMap<String, BdPriViewDTO>();
		if (srvList.size() > 0){
			IBdPriCalService calService = ServiceFinder.find(IBdPriCalService.class);
			BdPriViewDTO[] priViewDtos = calService.calSrvPrice(
					srvList.toArray(new String[0]),
					pripatList.toArray(new String[0]));
			
			if(!ArrayUtil.isEmpty(priViewDtos)){
				priMap = (Map<String, BdPriViewDTO>) MapUtils
						.convertArrayToMap(priViewDtos, "Id_srv,Id_pripat");
			}
		}
		
		IMaterialStockService materialService = ServiceFinder.find(IMaterialStockService.class);
		IMaterialBaseInfoService materialBaseService = ServiceFinder.find(IMaterialBaseInfoService.class);
		Map<String, ReserveResultDTO> reserveMap = new HashMap<String, ReserveResultDTO>();
		Map<String, MaterialStockDTO> stockMap = new HashMap<String, MaterialStockDTO>();
		Map<String, GetMaterialPriceDTO> otMMMap = new HashMap<String,GetMaterialPriceDTO>();
		
		if(reserveList.size() > 0){
			ReserveResultDTO[] reserveRlt = materialService.reserveMaterials(
					IMaterialStockService.TYPE_RESERVE, reserveList.toArray(new ReserveReqDTO[0]));
			reserveMap = (Map<String, ReserveResultDTO>)MapUtils.
					convertArrayToMap(reserveRlt, "Id_orsrv");
		}
		
		if(stockList.size() > 0){
			MaterialStockDTO[] stockRlt =  materialService.getMaterialStocks(
					stockList.toArray(new GetStockReqDTO[0]));
			stockMap = (Map<String, MaterialStockDTO>)MapUtils.
					convertArrayToMap(stockRlt, "Id_dep,Id_mm,Req_unit_id");
		}
		
		if(otMMHashSet.size() > 0){
			
			for (String key : otMMHashSet) {
				String[] values = key.split(",");
				GetMaterialPriceDTO otMMRlt = materialBaseService.MaterialPriceForOt(values[0], values[1]);
				otMMMap.put(key, otMMRlt);
			}
		}
		
		if(BlParamValueConst.BLSTOEP0016_WHENORDER.equals(this.dataWh.getOepCgMode())){
			//医嘱开立计价
			for (BlCgAccountBizDTO bizDto : accBizDtos) {
				
				//医嘱计价暂不处理药品
				if(FBoolean.TRUE.equals(bizDto.getFg_mm())){
					
					this.calMMPrice(bizDto, reserveMap, stockMap, otMMMap);
					
				}else{
					if(!StringUtil.isEmpty(bizDto.getId_orsrv())){
						OrdSrvDO orsrvDO =	this.dataWh.getOrsrvMap().get(bizDto.getId_orsrv());
						if(orsrvDO != null && orsrvDO.getPri() != null){
							bizDto.setPrice_ratio(orsrvDO.getPri());
							bizDto.setPrice_std(orsrvDO.getPri_std());
							bizDto.setRatio_pripat(orsrvDO.getPri_ratio());
						}
					}else{
						String key = bizDto.getId_srv() + bizDto.getId_pripat();
						BdPriViewDTO priDto = priMap.get(key);
						if(priDto != null && MedSrvBlModeEnum.AUTOBL == bizDto.getEu_blmd()){
							bizDto.setPrice_std(priDto.getPrice_std());
							bizDto.setPrice_ratio(priDto.getPrice_ratio());
							bizDto.setRatio_pripat(priDto.getRate());
						}
					}
				}
			}
		}else{
			for (BlCgAccountBizDTO bizDto : accBizDtos) {
				
				if(FBoolean.TRUE.equals(bizDto.getFg_mm())){
					
					this.calMMPrice(bizDto, reserveMap, stockMap, otMMMap);
					
				}else{
					if (MedSrvBlModeEnum.MANUALBL == bizDto.getEu_blmd()){
						OrdSrvDO orsrvDO = dataWh.getOrsrvMap().get(bizDto.getId_orsrv());
						if(orsrvDO != null && orsrvDO.getPri() != null && !FDouble.ZERO_DBL.equals(orsrvDO.getPri())){
							bizDto.setPrice_ratio(orsrvDO.getPri());
							bizDto.setPrice_std(orsrvDO.getPri());
							bizDto.setRatio_pripat(FDouble.ONE_DBL);
						}
					}else{
						String key = bizDto.getId_srv() + bizDto.getId_pripat();
						BdPriViewDTO priDto = priMap.get(key);
						if(priDto != null){
							bizDto.setPrice_std(priDto.getPrice_std());
							bizDto.setPrice_ratio(priDto.getPrice_ratio());
							bizDto.setRatio_pripat(priDto.getRate());
						}
					}
				}
			}
			
			// 组合计价重新计算折扣率
			for (BlCgAccountBizDTO bizDto : accBizDtos) {
				
				if(FBoolean.TRUE.equals(bizDto.getFg_mm()))
					continue;
				
				if(StringUtil.isEmpty(bizDto.getId_srv_or()))
					continue;
				
				if (MedSrvBlModeEnum.MANUALBL == bizDto.getEu_blmd())
					continue;
				
				String key = bizDto.getId_srv_or() + bizDto.getId_srv();
				BdPriSrvCompRatioDTO compRatioDto = this.dataWh.getCompRatioMap().get(key);
				if(compRatioDto != null){
					bizDto.setPrice_ratio(bizDto.getPrice_ratio().multiply(compRatioDto.getRatio(), IBlConst.PRECISION_PRICE));
					bizDto.setRatio_pripat(bizDto.getRatio_pripat().multiply(compRatioDto.getRatio(), IBlConst.PRECISION_PRICE));
				}
			}
		}
	}

	/**
	 * 物品计价
	 * @param bizDto
	 * @param reserveMap
	 * @param stockMap
	 * @param otMMMap
	 * @throws BizException
	 */
	private void calMMPrice(BlCgAccountBizDTO bizDto, Map<String, ReserveResultDTO> reserveMap,
			Map<String, MaterialStockDTO> stockMap, Map<String, GetMaterialPriceDTO> otMMMap) throws BizException {
		
		if(FBoolean.FALSE.equals(bizDto.getFg_or())){
			String key = bizDto.getId_mm() + "," + bizDto.getId_pkgu_cur();
			GetMaterialPriceDTO priceDto = otMMMap.get(key);
			if(priceDto != null){
				bizDto.setPrice_std(PrecisionUtils.formatPrice(priceDto.getPrice_act()));
				bizDto.setPrice_ratio(PrecisionUtils.formatPrice(priceDto.getPrice_act()));
				bizDto.setRatio_pripat(FDouble.ONE_DBL);
			}
		}else if(FBoolean.TRUE.equals(this.accSet.getFg_reserve())){
			ReserveResultDTO reserveDto = reserveMap.get(bizDto.getId_orsrv());
			if(reserveDto != null){
				bizDto.setPrice_std(PrecisionUtils.formatPrice(reserveDto.getPrice_act()));
				bizDto.setPrice_ratio(PrecisionUtils.formatPrice(reserveDto.getPrice_act()));
				bizDto.setRatio_pripat(FDouble.ONE_DBL);
			}
		}else{
			String key = bizDto.getId_dep_wh() + bizDto.getId_mm() + bizDto.getId_pkgu_cur();
			MaterialStockDTO stockDto = stockMap.get(key);
			if(stockDto != null){
				bizDto.setPrice_std(PrecisionUtils.formatPrice(stockDto.getPrice_act()));
				bizDto.setPrice_ratio(PrecisionUtils.formatPrice(stockDto.getPrice_act()));
				bizDto.setRatio_pripat(FDouble.ONE_DBL);
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
	 * @param accBizMap
	 * @return
	 */
	private boolean checkFee(Map<String, List<BlCgAccountBizDTO>> accBizMap) throws BizException {
		
		BlCgAccFeeValidator feeValidator = new BlCgAccFeeValidator(this.accSet);
		BlCgNotNullDataValidator nullValidator = new BlCgNotNullDataValidator();
		BlCgRepeatAccValidator repeatValidator = new BlCgRepeatAccValidator();
		for (String patId : accBizMap.keySet()) {
			
			try {
				List<BlCgAccountBizDTO> accBizList = accBizMap.get(patId);

				feeValidator.validate(accBizList, this.dataWh.getPatBalanceMap().get(patId));

				nullValidator.validate(accBizList, this.dataWh);
				
				repeatValidator.validateOep(accBizList, dataWh);
			} catch (BizException e) {
				this.errClctor.collect(patId, true, e);
			}
		}
		
		this.errClctor.filterEnOrPatList(this.patList);
		return this.patList.size() > 0;
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
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getPresCode(drugOrsrvSet.toArray(new String[0]));
			if(!ArrayUtil.isEmpty(applyDtos)){
				this.dataWh.addItmToApplyMap(applyDtos);
			}
		}
		
		if(risOrSet.size() > 0){
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getRisCode(risOrSet.toArray(new String[0]));
			if(!ArrayUtil.isEmpty(applyDtos)){
				this.dataWh.addItmToApplyMap(applyDtos);
			}
		}
		
		if(lisOrSet.size() > 0){
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getLisCode(lisOrSet.toArray(new String[0]));
			if(!ArrayUtil.isEmpty(applyDtos)){
				this.dataWh.addItmToApplyMap(applyDtos);
			}
		}
		
		if(bingliOrSet.size() > 0){
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getBingliCode(bingliOrSet.toArray(new String[0]));
			if(!ArrayUtil.isEmpty(applyDtos)){
				this.dataWh.addItmToApplyMap(applyDtos);
			}
		}
		
		if(otherOrsrvSet.size() > 0){
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getOtherPrnCode(otherOrsrvSet.toArray(new String[0]));
			if(!ArrayUtil.isEmpty(applyDtos)){
				this.dataWh.addItmToApplyMap(applyDtos);
			}
		}
	}
	
	/**
	 * 组装保存记账数据(记账数据一主多子，id_ent分组)
	 * @param accBizMap
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO[] assembleAndSaveDataGroup(Map<String, List<BlCgAccountBizDTO>> accBizMap) throws BizException {
		
		List<BlcgoepAggDO> aggList = new ArrayList<BlcgoepAggDO>();
		
		//按照患者id,id_ent分组
		Map<String, List<BlCgAccountBizDTO>> newAccBizMap = new HashMap<String, List<BlCgAccountBizDTO>>();
		for (String key : accBizMap.keySet()) {
			for (BlCgAccountBizDTO bizDto : accBizMap.get(key)) {
				
				String newKey = bizDto.getId_pat() + bizDto.getId_ent();
				List<BlCgAccountBizDTO> bizList = null;
				if (newAccBizMap.containsKey(newKey)) {
					bizList = newAccBizMap.get(newKey);
				} else {
					bizList = new ArrayList<BlCgAccountBizDTO>();
					newAccBizMap.put(newKey, bizList);
				}
				bizList.add(bizDto);
			}
		}
		
		IBillcodeManage iBillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		String[] codes = iBillcodeManage.getBatchBillCodes_RequiresNew(BlCgOepDO.class.getName(),new BlCgOepDO(), newAccBizMap.size());
		
		int i = 0;
		for (String key : newAccBizMap.keySet()) {
			
			List<BlCgAccountBizDTO> bizAccList = newAccBizMap.get(key);
			BlcgoepAggDO cgAggDO = BlCgDataUtil.buildCgData(bizAccList, codes[i], this.accSet, this.dataWh);
			//统计消费金额
			if(OepCgModeEnum.PREPAY_CG.equals(this.accSet.getEu_oepcgmode())){
				
				BlCgOepDO cgHeadDO = cgAggDO.getParentDO();
				for (BlCgItmOepDO cgItmDO : cgAggDO.getBlCgItmOepDO()) {
					this.dataWh.countConsume(cgItmDO.getId_pat(), cgItmDO.getAmt_ratio()
							.multiply(cgHeadDO.getEu_direct()),FBoolean.FALSE);
				}
			}
			
			aggList.add(cgAggDO);
			i++;
		}

		IBlcgoepCudService cudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] newAggDos = cudService.insert(aggList.toArray(new BlcgoepAggDO[0]));
		
		return newAggDos;
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
		
		if(!OepCgModeEnum.PREPAY_CG.equals(this.accSet.getEu_oepcgmode()))
			return;
		
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
		
		String sqlTemp = "update pi_pat_acc set acc_lock = acc_lock + (?) where id_patacc = ? ";
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
		
		/*ICiOrdMaintainService orService = ServiceFinder.find(ICiOrdMaintainService.class);
		orService.UpdateOrdChargeRelInfo2(orsrvSet.toArray(new String[0]),
				ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID, ICiDictCodeConst.SD_SU_BL_ACCOUNT, 
				BlFlowContextUtil.getNowTime(), FeeReverseType.NOBLCANCEL);*/
		
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
