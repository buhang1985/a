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
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.dto.prisrvcompratio.d.BdPriSrvCompRatioDTO;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.dto.cglogic.d.BlCgAccountBizDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.s.cglogic.other.BlCgAccDataWarehouse;
import iih.bl.cg.s.cglogic.other.BlCgAccErrorCollector;
import iih.bl.cg.s.cglogic.util.BlCgAccSetInitUtil;
import iih.bl.cg.s.cglogic.util.BlCgDataUtil;
import iih.bl.cg.s.cglogic.validator.BlCgAccFeeValidator;
import iih.bl.cg.s.cglogic.validator.BlCgAccParamValidator;
import iih.bl.cg.s.cglogic.validator.BlCgNotNullDataValidator;
import iih.bl.cg.s.cglogic.validator.BlCgRepeatAccValidator;
import iih.bl.comm.IBlConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.comm.util.BlFlowParamLoader;
import iih.bl.comm.util.BlMethodUtil;
import iih.bl.comm.util.BlPrepayWarnUtil;
import iih.bl.comm.util.BlUpdateOrChargeStateUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.mm.itf.material.d.GetMaterialPriceDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院记账逻辑类
 * 
 * @author ly 2018/06/24
 *
 */
public class BlIpKeepAccountBP  extends BlIpKeepAccountBaseBP{

	// 记账配置
	private BlCgAccountSetDTO accSet;

	/**
	 * 记账
	 * 
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountRltDTO exec(BlCgAccountDTO[] accDtos, BlCgAccountSetDTO accSetDto) throws BizException {

		if (ArrayUtil.isEmpty(accDtos)) {
			throw new BizException("记账数据为空");
		}
		
		//加载流程参数
		BlFlowParamLoader flowLoader = new BlFlowParamLoader();
		flowLoader.loadIpKeepAccountParam();

		// 初始化配置
		this.accSet = BlCgAccSetInitUtil.init(accSetDto);
		// 初始化数据仓库
		this.dataWh = new BlCgAccDataWarehouse();
		this.dataWh.loadIpParam();
		// 初始化错误收集器
		this.errClctor = new BlCgAccErrorCollector(this.accSet.getFg_singlepat());

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

		BlCgAccountRltDTO rlt = new BlCgAccountRltDTO();
		if (FBoolean.TRUE.equals(this.accSet.getFg_exception())) {
			rlt = this.keepAccount(accBizDtos);
		} else {
			rlt = this.keepAccountNoException(accBizDtos);
		}

		return rlt;
	}

	/**
	 * 记账逻辑
	 * 
	 * @param accBizDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	private BlCgAccountRltDTO keepAccount(BlCgAccountBizDTO[] accBizDtos)
			throws BizException {

		// 准备就诊关联的数据
		this.prepareEnRelatedData(accBizDtos);

		// 处理母婴
		//this.dataWh.handleMomBabyAcc();

		// 可记账判断
		boolean next = super.checkAccAble();
		if (!next) {
			return this.errClctor.returnUnsuccessRlt();
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
				return this.errClctor.returnUnsuccessRlt();
			}
			accBizDtos = this.errClctor.filterBizData(accBizDtos);
		}
		
		// 准备医嘱相关数据
		this.prepayOrData(accBizDtos);
				
		// 计价
		if (FBoolean.TRUE.equals(this.accSet.getFg_price_cal())) {
			this.calPrice(accBizDtos);
		}

		// 费用校验
		next = this.checkFee(accBizMap);
		if (!next) {
			return this.errClctor.returnUnsuccessRlt();
		}
		accBizDtos = this.errClctor.filterBizData(accBizDtos);

		//---> 以下开始做保存操作
		super.saveOper = true;
		
		// 组装,保存记账数据
		BlCgIpDO[] ipDos = this.assembleAndSaveData(accBizDtos);

		// 回写账户
		super.writebackAccount();
		
		// 回写医嘱状态
		this.writebackOrBlState(ipDos);
		
		// 发送事件
		super.invokeEvent(ipDos, true);

		// 设置返回值
		BlCgAccountRltDTO rltDto = super.setRtnValue(ipDos);

		return rltDto;
	}

	/**
	 * 记账逻辑(不抛异常)
	 * 
	 * @param accDtos
	 * @return
	 * @throws BizException
	 */
	private BlCgAccountRltDTO keepAccountNoException(BlCgAccountBizDTO[] accBizDtos) throws BizException {

		BlCgAccountRltDTO rlt = null;

		try {
			rlt = this.keepAccount(accBizDtos);
		} catch (BizException e) {
			
			if(super.saveOper){
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
			
			//BdPreWarnDO[] warnDos = BlPrepayWarnUtil.getPreWarnSetting(IBdFcDictCodeConst.SD_CODE_ENTP_IP,
			BdPreWarnDO[] warnDos = BlPrepayWarnUtil.getPreWarnSetting(this.dataWh.getEnList().get(0).getCode_entp());
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
		//Set<String> otMMHashSet = new HashSet<String>();
		
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
		
		/*Map<String, GetMaterialPriceDTO> otMMMap = new HashMap<String,GetMaterialPriceDTO>();
		if(otMMHashSet.size() > 0){
			IMaterialBaseInfoService materialBaseService = ServiceFinder.find(IMaterialBaseInfoService.class);
			for (String key : otMMHashSet) {
				String[] values = key.split(",");
				GetMaterialPriceDTO otMMRlt = materialBaseService.MaterialPriceForOt(values[0], values[1]);
				otMMMap.put(key, otMMRlt);
			}
		}*/

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
	 * 准备医嘱相关数据
	 * 
	 * @param accBizDtos
	 * @throws BizException
	 */
	private void prepayOrData(BlCgAccountBizDTO[] accBizDtos) throws BizException {

		List<String> orSet = new ArrayList<String>();
		List<String> orsrvSet = new ArrayList<String>();
		List<String> orsrvFormmSet = new ArrayList<String>();
		List<String> mmSet = new ArrayList<String>();
		
		List<String> noOrsrvSrvSet = new ArrayList<String>();//无医嘱服务服务集合
		List<String> noOrsrvMmSet = new ArrayList<String>();//无医嘱服务物品集合

		for (BlCgAccountBizDTO bizDto : accBizDtos) {
			
			if (!StringUtil.isEmpty(bizDto.getId_or())) {
				orSet.add(bizDto.getId_or());
			}

			if (!StringUtil.isEmpty(bizDto.getId_orsrv())) {
				orsrvSet.add(bizDto.getId_orsrv());
			}

			if (!StringUtil.isEmpty(bizDto.getId_orsrv())
					&& FBoolean.TRUE.equals(bizDto.getFg_mm())) {
				orsrvFormmSet.add(bizDto.getId_orsrv());
			}

			if (!StringUtil.isEmpty(bizDto.getId_mm())) {
				mmSet.add(bizDto.getId_mm());
			}
			
			if(StringUtil.isEmpty(bizDto.getId_orsrv())){
				
				noOrsrvSrvSet.add(bizDto.getId_srv());
				
				if(!StringUtil.isEmpty(bizDto.getId_mm())){
					noOrsrvMmSet.add(bizDto.getId_mm());
				}
			}
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
		// 回写关键数据
		for (BlCgAccountBizDTO bizDto : accBizDtos) {

			if (!StringUtil.isEmpty(bizDto.getId_orsrv())){
				OrdSrvDO orsrvDO = this.dataWh.getOrsrvMap().get(bizDto.getId_orsrv());
				if (orsrvDO != null) {
					bizDto.setFg_pay_unit(orsrvDO.getFg_pay_unit());
					bizDto.setFg_or(orsrvDO.getFg_or());
				}
			}
			
			if(!StringUtil.isEmpty(bizDto.getId_or())){
				CiOrderDO ordDO = this.dataWh.getOrMap().get(bizDto.getId_or());
				bizDto.setId_srv_or(ordDO.getId_srv());
				srvOrSet.add(ordDO.getId_srv());
			}
		}
		
		//组合计价特殊比例数据
		if(srvOrSet.size() > 0){
			this.dataWh.setCompRatioMap(BlCgDataUtil.getSpecialCompRatioData(srvOrSet.toArray(new String[0])));
		}
		
		// 存在无医嘱费用时，需要查询医保目录
		if(noOrsrvSrvSet.size() > 0 || noOrsrvMmSet.size() > 0){
			this.dataWh.setEntHpList(BlCgDataUtil.getEnHpData(enList.toArray(new String[0])));
			
			if(!ListUtil.isEmpty(this.dataWh.getEntHpList())){
				List<String> hpIdList = new ArrayList<String>();
				
				for (EntHpDO entHpDO : this.dataWh.getEntHpList()) {
					if(hpIdList.contains(entHpDO.getId_hp()))
						continue;
					
					hpIdList.add(entHpDO.getId_hp());
				}
				
				//查询对照数据
				for (String hpId : hpIdList) {
					ThreeDirCompInfoDTO[] compInfoDtos = BlCgDataUtil
							.getHpCompInfo(hpId,
									noOrsrvSrvSet.toArray(new String[0]),
									noOrsrvMmSet.toArray(new String[0]));
					this.dataWh.loadHpCompData(hpId, compInfoDtos);
				}
			}
		}
	}

	/**
	 * 组装保存记账数据
	 * 
	 * @param accBizDtos
	 * @throws BizException
	 */
	private BlCgIpDO[] assembleAndSaveData(BlCgAccountBizDTO[] accBizDtos)
			throws BizException {

		BlCgIpDO[] dos = new BlCgIpDO[accBizDtos.length];
		for (int i = 0; i < dos.length; i++) {
			dos[i] = BlCgDataUtil.buildCgData(accBizDtos[i], this.accSet, this.dataWh);
			
			//补充组合计价物品信息
			this.addCompMMInfo(dos[i], accBizDtos[i]);
			
			//科研不统计消费
			if(!FBoolean.TRUE.equals(dos[i].getFg_research())){
				//统计消费金额
				this.dataWh.countConsume(dos[i].getId_ent(), 
						dos[i].getAmt_ratio().multiply(dos[i].getEu_direct()), dos[i].getFg_pay_unit());
			}
		}

		IBlcgqueryCudService cudService = ServiceFinder.find(IBlcgqueryCudService.class);
		dos = cudService.insert(dos);

		return dos;
	}

	/**
	 * 回写医嘱记账状态
	 * @param ipDos
	 * @throws BizException
	 */
	private void writebackOrBlState(BlCgIpDO[] ipDos) throws BizException{
		
		List<String> orsrvList = new ArrayList<String>();
		for (BlCgIpDO cgDO : ipDos) {
			
			if(BookRtnDirectEnum.CHARGES.equals(cgDO.getEu_direct()) && 
					!StringUtil.isEmpty(cgDO.getId_orsrv()) && !orsrvList.contains(cgDO.getId_orsrv())){
				orsrvList.add(cgDO.getId_orsrv());
			}
		}
		
		if(orsrvList.size() == 0)
			return;
		
		/*ICiOrdMaintainService orService = ServiceFinder.find(ICiOrdMaintainService.class);
		orService.UpdateOrdChargeRelInfo2(orsrvList.toArray(new String[0]),
				ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID, ICiDictCodeConst.SD_SU_BL_ACCOUNT, 
				BlFlowContextUtil.getNowTime(), FeeReverseType.NOBLCANCEL);*/
		
		BlUpdateOrChargeStateUtil.updateChargeStatus(orsrvList.toArray(new String[0]),
				BlFlowContextUtil.getNowTime(), FeeReverseType.NOBLCANCEL);
	}

	/**
	 * 补充组合计价物品信息
	 * @param cgDO
	 * @param bizDto
	 * @throws BizException
	 */
	private void addCompMMInfo(BlCgIpDO cgDO, BlCgAccountBizDTO bizDto) throws BizException{
		
		if(FBoolean.TRUE.equals(bizDto.getFg_mm()))
			return;
		
		if(StringUtil.isEmpty(bizDto.getId_srv_or()))
			return;
		
		if (MedSrvBlModeEnum.MANUALBL == bizDto.getEu_blmd())
			return;
		
		String key = bizDto.getId_srv_or() + bizDto.getId_srv();
		BdPriSrvCompRatioDTO compRatioDto = this.dataWh.getCompRatioMap().get(key);
		if(compRatioDto != null){
			
			if(StringUtil.isEmpty(compRatioDto.getId_mm()))
				return;
			
			List<MeterialDO> mmList = BlCgDataUtil.getMMData(new String[]{compRatioDto.getId_mm()});
			if(ListUtil.isEmpty(mmList))
				return;
			
			MeterialDO mmDO = mmList.get(0);
			
			//补充物品信息
			cgDO.setFg_mm(FBoolean.TRUE);
			cgDO.setId_mm(mmDO.getId_mm());
			cgDO.setCode_mm(mmDO.getCode());
			cgDO.setName_mm(mmDO.getName());
			cgDO.setId_mmtp(mmDO.getId_mmtp());
			cgDO.setSd_mmtp(mmDO.getSd_mmtp());
			cgDO.setSpec(mmDO.getSpec());
			cgDO.setSrvu(compRatioDto.getId_unit());
			cgDO.setPgku_base(mmDO.getId_unit_pkgbase());
			cgDO.setPgku_cur(compRatioDto.getId_unit());
			FDouble price= this.GetMMPrice(mmDO.getId_mm(),compRatioDto.getId_unit());
			cgDO.setPrice_ratio(price);
			cgDO.setPrice(price);
			cgDO.setAmt(price.multiply(cgDO.getQuan(),IBlConst.PRECISION_AMOUNT));
			cgDO.setAmt_std(price.multiply(cgDO.getQuan(), IBlConst.PRECISION_AMOUNT));
			cgDO.setAmt_ratio(cgDO.getAmt());
			cgDO.setAmt_pat(cgDO.getAmt());
		}
	}
	
	/**
	 * 获取物品价格
	 * @param id_mm
	 * @param id_unit
	 * @return
	 * @throws BizException
	 */
	private FDouble GetMMPrice(String id_mm,String id_unit) throws BizException{
		IMaterialBaseInfoService ser= ServiceFinder.find(IMaterialBaseInfoService.class);
		GetMaterialPriceDTO dto= ser.MaterialPriceForOt(id_mm,id_unit);
		if(dto!=null && dto.getFg_success().booleanValue()){
			return dto.getPrice_act();
		}
		return new FDouble(0);
	}
}
