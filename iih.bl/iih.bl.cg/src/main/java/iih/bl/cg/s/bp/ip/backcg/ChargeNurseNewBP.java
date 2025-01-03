package iih.bl.cg.s.bp.ip.backcg;

import iih.bd.base.utils.DateTimeUtils;
import iih.bd.base.utils.PrecisionUtils;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.srvspecround.d.SrvSpecRoundDO;
import iih.bd.pp.srvspecround.i.ISrvspecroundRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.cg.s.bp.ip.backcg.comparator.NurFeeComparator;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.ICiOrdQryService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 护理费新逻辑
 * @author ly 2018/09/10
 *
 */
public class ChargeNurseNewBP extends BaseChargeBP {

	//用于计算按天收费护理服务
	private static final String DT_CHARGE_NEW = "dt_charge_new";
	private static final String QUAN_DAY = "quan_day";
	private static final String QUAN_SECOND = "quan_second";
	
	private boolean hasLoaded = false;
	private Map<String, MedSrvDO> medSrvMap = null;// 医疗服务集合
	private Map<String, PriceResultDTO> priRstMap = null;// 价格集合
	private Map<String, MeasDocDO> timeUnitMap = null;// 时间单位map
	private Map<String, SrvSpecRoundDO> medSrvSpecRoundMap = null;// 项目特殊取整方式

	private String lastNursingSrvs = null;//按照持续医嘱收费的护理服务
	
	public ChargeNurseNewBP(boolean outDept){
		this.setOutDept(outDept);
	}
	
	/**
	 * 记账
	 * 
	 * @param patInfo 患者住院信息
	 * @param pripatAgg 患者价格分类
	 * @param cgEndTime 记账截止时间
	 * @param ordIds 医嘱id
	 * @throws BizException
	 */
	@Override
	public void exec(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime) throws BizException {
		
		//获取已确认的护理医嘱集合
		CiorderAggDO[] orAggs = this.getNurOrList(patInfo);
		if (ArrayUtil.isEmpty(orAggs)) {
			return;
		}
		
		//初始化数据
		this.initSysData();
		
		//过滤有效医嘱
		orAggs = this.filterData(orAggs);
		if (ArrayUtil.isEmpty(orAggs)) {
			return;
		}
		
		String cgMode = BlParams.BLCG0001();
		this.lastNursingSrvs = BlParams.BLCG0021();
		
		if(BlParamValueConst.BLCG0001_SECOND.equals(cgMode)){
			this.accountBySencond(patInfo, pripatAgg, cgEndTime, orAggs);
		}else{
			this.accountByDay(patInfo, pripatAgg, cgEndTime, orAggs, cgMode);
			this.addLastNursingWhenOut(patInfo, pripatAgg, cgEndTime, orAggs, cgMode);
		}
	}

	/**
	 * 当日出院记账
	 * @param patInfo
	 * @param pripatAgg
	 * @param cgEndTime
	 * @throws BizException
	 */
	@Override
	public void execTodayOut(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime) throws BizException{
		//获取已确认的护理医嘱集合
		CiorderAggDO[] orAggs = this.getNurOrList(patInfo);
		if (ArrayUtil.isEmpty(orAggs)) {
			return;
		}
		
		//初始化数据
		this.initSysData();
		
		//过滤有效医嘱
		orAggs = this.filterData(orAggs);
		if (ArrayUtil.isEmpty(orAggs)) {
			return;
		}
		
		String cgMode = BlParams.BLCG0001();
		this.lastNursingSrvs = BlParams.BLCG0021();
		
		if(BlParamValueConst.BLCG0001_SECOND.equals(cgMode)){
			this.accountBySencond(patInfo, pripatAgg, cgEndTime, orAggs);
		}else{
			this.accountByDayToday(patInfo, pripatAgg, cgEndTime, orAggs, cgMode);
		}
	}

	/**
	 * 获取护理医嘱集合
	 * @param patInfo 就诊信息
	 * @param ordIds 医嘱ID
	 * @return
	 */
	private CiorderAggDO[] getNurOrList(IpCgPatDTO patInfo) throws BizException {
		StringBuffer sqlBuilder = new StringBuffer();
		sqlBuilder.append(" CI_ORDER.SD_SRVTP  LIKE '0601%' ");
		if (patInfo.getDt_backcg() != null) {
			//sqlBuilder.append(" AND (CI_ORDER.DT_END IS NULL) ");
		//} else {
			sqlBuilder.append(" AND (CI_ORDER.DT_END IS NULL OR CI_ORDER.DT_END > '");
			sqlBuilder.append(patInfo.getDt_backcg()).append("')");
		}
		sqlBuilder.append(" AND CI_ORDER.ID_EN = '").append(patInfo.getId_ent()).append("'");
		sqlBuilder.append(" AND CI_OR_SRV.FG_BL='Y' AND CI_ORDER.FG_CHK='Y' ");// 计费项目、已核查
		sqlBuilder.append(" AND CI_ORDER.FG_CANC='N'");//非作废医嘱
		ICiOrdQryService ciOrRService = ServiceFinder.find(ICiOrdQryService.class);
		CiorderAggDO[] ciOrAggDOArr = ciOrRService.getBlFeeCiOrderSrvDto(sqlBuilder.toString(),
				this.getCiOrderAggConlumList());

		if (ArrayUtil.isEmpty(ciOrAggDOArr)) {
			return null;
		}
		return ciOrAggDOArr;
	}

	/**
	 * 过滤有效服务
	 * @param orAggs
	 * @return
	 * @throws BizException
	 */
	private CiorderAggDO[] filterData(CiorderAggDO[] orAggs)  throws BizException {
	
		List<CiorderAggDO> orList = new ArrayList<CiorderAggDO>();
		for (CiorderAggDO aggDO : orAggs) {
			
			boolean effective = false;
			CiOrderDO orderDO = aggDO.getParentDO();
			List<OrdSrvDO> orsrvList = new ArrayList<OrdSrvDO>();
			for (OrdSrvDO orsrvDO : aggDO.getOrdSrvDO()) {
				
				if(this.validateData(orderDO, orsrvDO)){
					orsrvList.add(orsrvDO);
					effective= true;
				}
			}
			
			if(!effective)
				continue;
			
			CiorderAggDO aggDO2 = new CiorderAggDO();
			aggDO2.setParentDO(orderDO);
			aggDO2.setOrdSrvDO(orsrvList.toArray(new OrdSrvDO[0]));
			orList.add(aggDO2);
		}
		
		return orList.toArray(new CiorderAggDO[0]);
	}
	
	/**
	 * 验证数据
	 * @param ciOrdDO
	 * @param ordSrvDO
	 * @return
	 * @throws BizException
	 */
	private boolean validateData(CiOrderDO ciOrdDO,OrdSrvDO ordSrvDO) throws BizException {
		//验证服务
		if(!this.medSrvMap.containsKey(ordSrvDO.getId_srv())){
			BLTaskLogger.error(String.format("医嘱：%s,医嘱服务：%s,不是护理类服务",ciOrdDO.getName_or(),ordSrvDO.getName()));
			return false;
		}
		//验证服务定价
		PriceResultDTO priRst = this.getPrice(this.priRstMap,ordSrvDO.getId_srv());
		if(priRst == null){
			BLTaskLogger.error(String.format("医嘱：%s,医嘱服务：%s,未进行定价",ciOrdDO.getName_or(),ordSrvDO.getName()));
			return false;
		}
		// 是否是时间类型的
		if(!this.timeUnitMap.containsKey(ordSrvDO.getId_medu())){
			BLTaskLogger.error(String.format("医嘱：%s,医嘱服务：%s,单位不是时间单位",ciOrdDO.getName_or(),ordSrvDO.getName()));
			return false;
		}
		return true;
	}
	
	/**
	 * 初始化
	 * 
	 * @throws BizException
	 */
	private void initSysData() throws BizException {
		if (!hasLoaded) {
			// 1、获取所有的护理服务
			medSrvMap = this.getAllNurseSrvList();

			// 2、计算护理服务标准价格
			priRstMap = this.calcSrvStdPri(medSrvMap.keySet().toArray(new String[0]));

			// 3、加载组合计价的信息
			this.loadCompSrvList(this.priRstMap,this.medSrvMap);
			
			// 4、加载时间单位
			timeUnitMap = this.getTimeUnitMap();
			
			// 5、获取所有的项目特殊取整方式
			medSrvSpecRoundMap = this.getAllPrnSrvSpecRoundList();
			hasLoaded = true;
		}
	}

	/**
	 * 获取所有的护理服务
	 * 
	 * @return
	 * @throws BizException
	 */
	private Map<String, MedSrvDO> getAllNurseSrvList() throws BizException {
		String whereStr = "SD_SRVTP LIKE '0601%' AND FG_OR = 'Y' AND FG_ACTIVE='Y' AND DS = '0' ";// 护理类医嘱
		return this.getSrvListByCond(whereStr);
	}
	
	/**
	 * 获得属于时间的单位
	 * 
	 * @return 单位map，【key:单位ID,value: 单位DO】
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, MeasDocDO> getTimeUnitMap() throws BizException {
		Map<String, MeasDocDO> measDocDOMap = new HashMap<String, MeasDocDO>();
		String whereStr = "SD_OPPDIMEN=?";
		SqlParam param = new SqlParam();
		param.addParam(ISysDictCodeConst.SD_OPPDIMEN_T);// 时间类型
		List<MeasDocDO> measDocDOLst = (List<MeasDocDO>) new DAFacade().findByCond(MeasDocDO.class, whereStr, param);
		if (!ListUtil.isEmpty(measDocDOLst)) {
			for (MeasDocDO measDocDO : measDocDOLst) {
				measDocDOMap.put(measDocDO.getId_measdoc(), measDocDO);
			}
		}
		return measDocDOMap;
	}
	
	/**
	 * 按秒计费
	 * @param patInfo
	 * @param pripatAgg
	 * @param cgEndTime
	 * @param aggDos
	 * @throws BizException
	 */
	private void accountBySencond(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime,CiorderAggDO[] aggDos) throws BizException {
		
		List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
		
		Map<String,FDateTime> orsrvDtMap = new HashMap<String,FDateTime>();
		
		for (CiorderAggDO orAggDO : aggDos) {
			
			List<String> orSrvIdList = new ArrayList<String>();
			CiOrderDO ciOrdDO = orAggDO.getParentDO();
			for (OrdSrvDO ordSrvDO : orAggDO.getOrdSrvDO()) {			
				
				MedSrvDO medSrvDO = medSrvMap.get(ordSrvDO.getId_srv());
				MeasDocDO srvUnitDO = timeUnitMap.get(ordSrvDO.getId_medu());
				//计算数量
				FDouble quan = null;
				quan = this.calcQuanBySec(ciOrdDO, ordSrvDO, cgEndTime);// 按秒计费				
				quan = this.convertByUnit(srvUnitDO, quan.multiply(DateTimeUtils.MS_OF_SEC));//单位换算
				
				if (quan == null || quan.doubleValue() <= 0) {
					continue;
				}
				this.wirteTimeLog(ciOrdDO, ordSrvDO,cgEndTime, quan);
				
				//计算折扣价
				PriceResultDTO stdPriRst = this.getPrice(this.priRstMap,ordSrvDO.getId_srv());
				PriceResultDTO priRst = this.calcPatPri(stdPriRst, pripatAgg);	
				
				BlCgAccountDTO blCgDTO = this.createIpCgParam(patInfo, medSrvDO, priRst, quan, ciOrdDO,ordSrvDO);
				cgAccList.add(blCgDTO);
				orSrvIdList.add(ordSrvDO.getId_orsrv());
				this.writeSrvItmLog(medSrvDO, priRst, quan);// 记录费用项目日志
			}
			
			FDateTime newTime = orAggDO.getParentDO().getDt_end() == null ? 
					cgEndTime : orAggDO.getParentDO().getDt_end().compareTo(cgEndTime) <= 0 ? 
						orAggDO.getParentDO().getDt_end() : cgEndTime;
			//updateOrdSrvBlStatus(orSrvIdList, newTime);
						
			for (String srvId : orSrvIdList) {
				orsrvDtMap.put(srvId, newTime);
			}
		}
		
		// 记账
		this.charge(cgAccList, cgEndTime);
		
		//更新最后记账时间
		if (orsrvDtMap != null && orsrvDtMap.size() > 0) {
			for (Entry<String, FDateTime> entry : orsrvDtMap.entrySet()) {
				this.updateOrdSrvBlStatus(entry.getKey(), entry.getValue());
			}
		}
	}
	
	/**
	 * 按天计费
	 * @param patInfo
	 * @param pripatAgg
	 * @param cgEndTime
	 * @param aggDos
	 * @param cgMode
	 * @throws BizException
	 */
	private void accountByDay(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime,CiorderAggDO[] aggDos,String cgMode) throws BizException {
		
		//医嘱最小开始时间
		FDateTime minDtEffe = null;
		for (CiorderAggDO aggDO : aggDos) {
			CiOrderDO orDO = aggDO.getParentDO();
			if(minDtEffe == null){
				minDtEffe = orDO.getDt_effe();
			}else if(minDtEffe.compareTo(orDO.getDt_effe()) > 0){
				minDtEffe = orDO.getDt_effe();
			}
		}
		
		//计算需记账的日期
		FDate[] cgDates = this.getNeedCgData(patInfo.getDt_backcg() == null ? minDtEffe : patInfo.getDt_backcg(), cgEndTime);		
		if(ArrayUtil.isEmpty(cgDates))
			return;
		
		Map<String, CiorderAggDO> ordMap = new HashMap<String, CiorderAggDO>();
		for (FDate fDate : cgDates) {
			CiorderAggDO ordAggDO = this.analysisNurByDay(aggDos, fDate, cgEndTime, cgMode);
			if(ordAggDO != null && !ordMap.containsKey(ordAggDO.getParentDO().getId_or())){
				ordMap.put(ordAggDO.getParentDO().getId_or(), ordAggDO);
			}
		}
		
		if(ordMap.size() == 0)
			return;
		
		
		Map<String,FDateTime> orsrvDtMap = new HashMap<String,FDateTime>();
		//记账
		List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
		for (CiorderAggDO orAggDO : ordMap.values()) {
			
			List<String> orSrvIdList = new ArrayList<String>();
			CiOrderDO ordDO = orAggDO.getParentDO();
			
			for (OrdSrvDO ordSrvDO : orAggDO.getOrdSrvDO()) {			
				
				MedSrvDO medSrvDO = medSrvMap.get(ordSrvDO.getId_srv());
				MeasDocDO srvUnitDO = timeUnitMap.get(medSrvDO.getId_unit_med());
				
				FDouble quan = null;
				if(!StringUtil.isEmpty(this.lastNursingSrvs) && this.lastNursingSrvs.contains(ordDO.getId_srv())){
					Integer second = (Integer)ordDO.getAttrVal(QUAN_SECOND);
					quan = this.convertByUnit(srvUnitDO, new FDouble(second).multiply(1000)).setScale(0, FDouble.ROUND_UP);
				
					SrvSpecRoundDO srvSpecRoundDO = medSrvSpecRoundMap.get(medSrvDO.getId_srv());
					if(srvSpecRoundDO != null){
						quan = this.calcSpecRoundQuan(quan, srvSpecRoundDO);// 采用特殊的取整方式
					}
				}else{
					Integer day = (Integer)ordDO.getAttrVal(QUAN_DAY);
					quan = this.convertByUnit(srvUnitDO, new FDouble(day).multiply(DateTimeUtils.MS_OF_DAY)).setScale(4, BigDecimal.ROUND_HALF_UP);
				}

				this.wirteTimeLog(ordDO, ordSrvDO,cgEndTime, quan);
				
				//计算折扣价
				PriceResultDTO stdPriRst = this.getPrice(this.priRstMap,ordSrvDO.getId_srv());
				PriceResultDTO priRst = this.calcPatPri(stdPriRst, pripatAgg);	
				
				BlCgAccountDTO blCgDTO = this.createIpCgParam(patInfo, medSrvDO, priRst, quan, ordDO, ordSrvDO);
				cgAccList.add(blCgDTO);
				orSrvIdList.add(ordSrvDO.getId_orsrv());
				this.writeSrvItmLog(medSrvDO, priRst, quan);// 记录费用项目日志
			}
			
			FDateTime newTime = (FDateTime)orAggDO.getParentDO().getAttrVal(DT_CHARGE_NEW);
			//updateOrdSrvBlStatus(orSrvIdList, newTime);
			for (String srvId : orSrvIdList) {
				orsrvDtMap.put(srvId, newTime);
			}
		}
		
		// 记账
		this.charge(cgAccList, cgEndTime);
		
		//更新最后记账时间
		if (orsrvDtMap != null && orsrvDtMap.size() > 0) {
			for (Entry<String, FDateTime> entry : orsrvDtMap.entrySet()) {
				this.updateOrdSrvBlStatus(entry.getKey(), entry.getValue());
			}
		}
	}
	
	/**
	 * 按天计费当天
	 * @param patInfo
	 * @param pripatAgg
	 * @param cgEndTime
	 * @param aggDos
	 * @param cgMode
	 * @throws BizException
	 */
	private void accountByDayToday(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime,CiorderAggDO[] aggDos,String cgMode) throws BizException {
		
		if(patInfo.getDt_backcg() != null && DateTimeUtils.isSameDay(patInfo.getDt_backcg(), cgEndTime))
			return;
		
		FDate fDate = cgEndTime.getBeginDate();
		
		//当日计费校验
		if(this.checkTodayCg(patInfo.getId_ent()))
			return;
		
		CiorderAggDO orAggDO = this.analysisNurByDay(aggDos, fDate, cgEndTime, cgMode);
		if(orAggDO == null)
			return;
		
		List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
		
		List<String> orSrvIdList = new ArrayList<String>();
		CiOrderDO ordDO = orAggDO.getParentDO();
		
		for (OrdSrvDO ordSrvDO : orAggDO.getOrdSrvDO()) {			
			
			MedSrvDO medSrvDO = medSrvMap.get(ordSrvDO.getId_srv());
			MeasDocDO srvUnitDO = timeUnitMap.get(medSrvDO.getId_unit_med());
			
			FDouble quan = null;
			if(!StringUtil.isEmpty(this.lastNursingSrvs) && this.lastNursingSrvs.contains(ordDO.getId_srv())){
				Integer second = (Integer)ordDO.getAttrVal(QUAN_SECOND);
				quan = this.convertByUnit(srvUnitDO, new FDouble(second).multiply(1000)).setScale(0, FDouble.ROUND_UP);
			}else{
				Integer day = (Integer)ordDO.getAttrVal(QUAN_DAY);
				quan = this.convertByUnit(srvUnitDO, new FDouble(day).multiply(DateTimeUtils.MS_OF_DAY)).setScale(4, BigDecimal.ROUND_HALF_UP);
			}

			this.wirteTimeLog(ordDO, ordSrvDO,cgEndTime, quan);
			
			//计算折扣价
			PriceResultDTO stdPriRst = this.getPrice(this.priRstMap,ordSrvDO.getId_srv());
			PriceResultDTO priRst = this.calcPatPri(stdPriRst, pripatAgg);	
			
			BlCgAccountDTO blCgDTO = this.createIpCgParam(patInfo, medSrvDO, priRst, quan, ordDO, ordSrvDO);
			cgAccList.add(blCgDTO);
			orSrvIdList.add(ordSrvDO.getId_orsrv());
			this.writeSrvItmLog(medSrvDO, priRst, quan);// 记录费用项目日志
		}
		
		FDateTime newTime = (FDateTime)orAggDO.getParentDO().getAttrVal(DT_CHARGE_NEW);
		
		// 记账
		this.charge(cgAccList, cgEndTime);
		
		updateOrdSrvBlStatus(orSrvIdList, newTime);
	}
	
	/**
	 * 补充出院持续护理计费
	 * @param patInfo
	 * @param pripatAgg
	 * @param cgEndTime
	 * @param aggDos
	 * @throws BizException
	 */
	private void addLastNursingWhenOut(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime,CiorderAggDO[] aggDos,String cgMode) throws BizException {
		
		if(StringUtil.isEmpty(this.lastNursingSrvs) || !this.IsOutDept())
			return;
		
		List<CiorderAggDO> aggDOList = new ArrayList<CiorderAggDO>();
		for (CiorderAggDO orAggDO : aggDos) {
			CiOrderDO ordDO = orAggDO.getParentDO();
			if(this.lastNursingSrvs.contains(ordDO.getId_srv())){
				
				boolean hasCg = false;
				for (OrdSrvDO orsrvDO : orAggDO.getOrdSrvDO()) {
					if(ordDO.getDt_end() != null && 
							orsrvDO.getDt_last_cg() != null && 
							ordDO.getDt_end().compareTo(orsrvDO.getDt_last_cg()) <= 0){
						hasCg = true;
					}
				}
				
				if(!hasCg){
					aggDOList.add(orAggDO);
				}
			}
		}
		
		if(aggDOList.size() == 0)
			return;
		
		Map<String, CiorderAggDO> ordMap = new HashMap<String, CiorderAggDO>();
		for (CiorderAggDO aggDO : aggDOList) {
			ordMap.put(aggDO.getParentDO().getId_or(), aggDO);
		}
		
		Map<String,FDateTime> orsrvDtMap = new HashMap<String,FDateTime>();
		
		//记账
		List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
		for (CiorderAggDO orAggDO : ordMap.values()) {
			
			List<String> orSrvIdList = new ArrayList<String>();
			CiOrderDO ordDO = orAggDO.getParentDO();
			
			FDateTime begin = DateTimeUtils.getDayBeginTime(cgEndTime);
			FDateTime calBegin = begin.compareTo(ordDO.getDt_effe()) > 0 ? begin : ordDO.getDt_effe();
			FDateTime calEnd = ordDO.getDt_end() != null ? ordDO.getDt_end() : cgEndTime;
			
			//清空计算时长
			for (OrdSrvDO ordSrvDO : orAggDO.getOrdSrvDO()) {			
				
				MedSrvDO medSrvDO = medSrvMap.get(ordSrvDO.getId_srv());
				MeasDocDO srvUnitDO = timeUnitMap.get(medSrvDO.getId_unit_med());
				
				Integer second = FDateTime.getSecondsBetween(calBegin, calEnd);
				FDouble quan = this.convertByUnit(srvUnitDO, new FDouble(second).multiply(1000)).setScale(0, FDouble.ROUND_UP);
				
				if(quan.compareTo(FDouble.ZERO_DBL) <= 0)
					continue;
				
				this.wirteTimeLog(ordDO, ordSrvDO,cgEndTime, quan);
				
				//计算折扣价
				PriceResultDTO stdPriRst = this.getPrice(this.priRstMap,ordSrvDO.getId_srv());
				PriceResultDTO priRst = this.calcPatPri(stdPriRst, pripatAgg);	
				
				BlCgAccountDTO blCgDTO = this.createIpCgParam(patInfo, medSrvDO, priRst, quan, ordDO, ordSrvDO);
				cgAccList.add(blCgDTO);
				orSrvIdList.add(ordSrvDO.getId_orsrv());
				this.writeSrvItmLog(medSrvDO, priRst, quan);// 记录费用项目日志
			}
			
			//updateOrdSrvBlStatus(orSrvIdList, calEnd);
			for (String srvId : orSrvIdList) {
				orsrvDtMap.put(srvId, calEnd);
			}
		}
		
		// 记账
		this.charge(cgAccList, cgEndTime);
		
		//更新最后记账时间
		if (orsrvDtMap != null && orsrvDtMap.size() > 0) {
			for (Entry<String, FDateTime> entry : orsrvDtMap.entrySet()) {
				this.updateOrdSrvBlStatus(entry.getKey(), entry.getValue());
			}
		}
	}
	
	/**
	 * 获取需要记账的日期
	 * @param maxDtChg
	 * @param cgEndTime
	 * @return
	 * @throws BizException
	 */
	private FDate[] getNeedCgData(FDateTime maxDtChg, FDateTime cgEndTime) throws BizException {
		
		int day = DateTimeUtils.getNatDaysBetween(maxDtChg, cgEndTime);
		FDate[] dates = new FDate[day];
		
		FDate endDate = cgEndTime.getBeginDate();
		for (int i = 0; i < day; i++) {
			dates[i] = endDate.getDateBefore(day - i);
		}
		
		return dates;
	}
	
	/**
	 * 分析需要收取的护理医嘱
	 * @param aggDos
	 * @param fDate
	 * @param cgEndTime
	 * @param cgMode
	 * @return
	 * @throws BizException
	 */
	private CiorderAggDO analysisNurByDay(CiorderAggDO[] aggDos,FDate fDate, FDateTime cgEndTime, String cgMode) throws BizException {
		
		// 按照终止时间倒序，返回第一条数据
		FDateTime begin = DateTimeUtils.getDayBeginTime(fDate);
		FDateTime end = begin.equals(DateTimeUtils.getDayBeginTime(cgEndTime)) ? cgEndTime : DateTimeUtils.getDayEndTime(fDate);
		
		List<DayFeeParam> feeList = new ArrayList<DayFeeParam>();
		for (CiorderAggDO ordAggDO : aggDos) {
			
			CiOrderDO orderDO = ordAggDO.getParentDO();
			
			// 不在收费区间
			if (orderDO.getDt_effe().compareTo(end) > 0 || (orderDO.getDt_end() != null && orderDO.getDt_end().compareTo(begin) < 0))
				continue;

			//计算价格
			FDouble totalPrice = FDouble.ZERO_DBL;
			for (OrdSrvDO orsrvDO : ordAggDO.getOrdSrvDO()) {
				PriceResultDTO priRst = this.getPrice(priRstMap,orsrvDO.getId_srv());
				totalPrice = totalPrice.add(priRst.getPrice_std());
			}
			
			DayFeeParam feeParam = new DayFeeParam();
			feeParam.setDt_b(orderDO.getDt_effe());
			feeParam.setPrice(totalPrice);
			feeParam.setRealObj(ordAggDO);
			
			feeList.add(feeParam);
		}
		
		if(feeList.size() == 0)
			return null;
		
		Collections.sort(feeList, new NurFeeComparator(cgMode));
		
		CiorderAggDO ordAggDO = (CiorderAggDO)feeList.get(0).getRealObj();
		CiOrderDO ordDO = ordAggDO.getParentDO();

		FDateTime endCgTime = ordDO.getDt_end() == null ? end : 
			ordDO.getDt_end().compareTo(end) > 0 ? end : ordDO.getDt_end();
			
		if(endCgTime.equals(end)){
			//补偿一秒
			endCgTime = endCgTime.addSeconds(1);
		}
		
		if(!StringUtil.isEmpty(this.lastNursingSrvs) && this.lastNursingSrvs.contains(ordDO.getId_srv())){
			// 按照持续医嘱计费,暂不考虑频次
			FDateTime calBegin = begin.compareTo(ordDO.getDt_effe()) > 0 ? begin : ordDO.getDt_effe();
			FDateTime calEnd = endCgTime;
			
			int secs = FDateTime.getSecondsBetween(calBegin, calEnd);
			Integer second =  ordDO.getAttrVal(QUAN_SECOND) == null ? secs : (Integer) ordDO.getAttrVal(QUAN_SECOND) + secs;
			
			ordDO.setAttrVal(QUAN_SECOND, second);
			ordDO.setAttrVal(DT_CHARGE_NEW, endCgTime);
			
		}else{
			// 按照天计费
			Integer day = ordDO.getAttrVal(QUAN_DAY) == null ? 1 : (Integer) ordDO.getAttrVal(QUAN_DAY) + 1;		

			ordDO.setAttrVal(QUAN_DAY, day);
			ordDO.setAttrVal(DT_CHARGE_NEW, endCgTime);
		}
		
		return ordAggDO;
	}
	
	/**
	 * 记账
	 * @param cgAccList
	 * @param cgEndTime
	 * @throws BizException
	 */
	private void charge(List<BlCgAccountDTO> cgAccList,FDateTime cgEndTime) throws BizException {
		
		List<String> orList = new ArrayList<String>();
		for (BlCgAccountDTO accDto : cgAccList) {
			
			if(!orList.contains(accDto.getId_or())){
				orList.add(accDto.getId_or());
			}
		}
		
		//记账
		chargeToBill(cgAccList, cgEndTime);
		
		//更新执行计划
		//IForeignService mpService = ServiceFinder.find(IForeignService.class);
		//mpService.rollingAccount(orList.toArray(new String[0]), cgEndTime);
	}
	
	/**
	 * 写时间日志
	 * @param ciOrdDO
	 * @param ordSrvDO
	 * @param cgEndTime
	 * @param quan
	 */
	private void wirteTimeLog(CiOrderDO ciOrdDO, OrdSrvDO ordSrvDO, FDateTime cgEndTime, FDouble quan) {
		FDateTime beginTime = this.getBeginTime(ciOrdDO.getDt_effe(),ordSrvDO.getDt_last_cg());
		FDateTime endTime = this.getEndTime(ciOrdDO.getDt_stop(), cgEndTime);
		BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT + ciOrdDO.getName_or());// 记录日志
		BLTaskLogger.info(
				IBackCgLogConst.TWO_LEBEL_INDENT + String.format("起=%s 止=%s 归整=1  天=%s 系数=1.0", beginTime, endTime, PrecisionUtils.formatQuan(quan)));
	}
	
	/**
	 * 记录费用项目日志
	 * 
	 * @param medSrvDO
	 * @param priRst
	 * @param quan
	 */
	private void writeSrvItmLog(MedSrvDO medSrvDO, PriceResultDTO priRst, FDouble quan) {
		MeasDocDO unitDO = timeUnitMap.get(medSrvDO.getId_unit_med());
		FDouble price = PrecisionUtils.formatPrice(priRst.getPrice_ratio());
		quan = PrecisionUtils.formatQuan(quan);
		FDouble amt = PrecisionUtils.formatAmt(priRst.getPrice_ratio().multiply(quan));
		BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT
				+ String.format("--%s  类别: %s 代码: %s  规格: / 单位: %s  数量: 1.0", medSrvDO.getName(), medSrvDO.getSd_srvtp(),
						medSrvDO.getCode(), unitDO.getName()));
		BLTaskLogger.info(IBackCgLogConst.THREE_LEBEL_INDENT + String.format("价格:%s  总数量:%s  金额:%s 应收:%s", price, quan, amt, amt));
	}

	/**
	 * 校验当日是否收取了护理费
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private boolean checkTodayCg(String entId) throws BizException{
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select count(1) ");
		sqlSb.append("from bl_cg_ip ");
		sqlSb.append("where id_ent = ? ");
		sqlSb.append("and sd_srvtp like '0601%' ");
		sqlSb.append("and nvl(id_or,'~') <> '~' ");
		
		SqlParam param = new SqlParam();
		param.addParam(entId);
		
		DAFacade daf = new DAFacade();
		Integer cnt = (Integer)daf.execQuery(sqlSb.toString(), param, new ColumnHandler());
		
		if(cnt == null || cnt == 0)
			return false;
		
		return true;
	}
	
	/**
	 * 获取所有服务特殊取整方式
	 * 
	 * @return
	 * @throws BizException
	 */
	private Map<String, SrvSpecRoundDO> getAllPrnSrvSpecRoundList() throws BizException {
		ISrvspecroundRService iSrvspecroundRService = ServiceFinder.find(ISrvspecroundRService.class);
		SrvSpecRoundDO[] srvSpecRoundDO_arr = iSrvspecroundRService.find("1=1", "", FBoolean.FALSE);
		Map<String, SrvSpecRoundDO> srvSpecRoundMap = new HashMap<String, SrvSpecRoundDO>();
		if (!ArrayUtil.isEmpty(srvSpecRoundDO_arr)) {
			for (SrvSpecRoundDO srvSpecRoundDO : srvSpecRoundDO_arr) {
				srvSpecRoundMap.put(srvSpecRoundDO.getId_srv(), srvSpecRoundDO);
			}
		}
		return srvSpecRoundMap;
	}
}
