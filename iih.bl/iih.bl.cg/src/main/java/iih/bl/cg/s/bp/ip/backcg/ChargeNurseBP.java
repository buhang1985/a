package iih.bl.cg.s.bp.ip.backcg;

import iih.bd.base.utils.DateTimeUtils;
import iih.bd.base.utils.PrecisionUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.cg.dto.d.NurseTPOrderCGModeEnum;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.params.BlParams;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.ICiOrdQryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 护理费--记账
 * 
 * @author yankan
 * @since 2017-09-18
 *
 */
public class ChargeNurseBP extends BaseChargeBP {
	private boolean hasLoaded = false;
	private Map<String, MedSrvDO> medSrvMap = null;// 医疗服务集合
	private Map<String, PriceResultDTO> priRstMap = null;// 价格集合
	private Map<String, MeasDocDO> timeUnitMap = null;// 时间单位map

	/**
	 * 默认构造函数
	 */
	public ChargeNurseBP() {}
	/**
	 * 构造函数
	 * @param isOutDept 是否出院
	 */
	public ChargeNurseBP(Boolean isOutDept) {
		this.setOutDept(isOutDept);
	}
	/**
	 * 护理费记账
	 * 
	 * @param patInfo
	 * @param pripatAgg
	 * @param cgEndTime
	 * @throws BizException
	 */
	public void exec(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime) throws BizException {
		this.exec(patInfo, pripatAgg, cgEndTime, null);
	}
	/**
	 * 护理费记账
	 * 
	 * @param patInfo
	 * @param pripatAgg
	 * @param cgEndTime
	 * @param ordIds
	 * @throws BizException
	 */
	public void exec(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime,String[] ordIds) throws BizException {
		// 1、获取已确认的护理医嘱集合
		CiorderAggDO[] orAggs = this.getNurOrList(patInfo,ordIds);
		if (ArrayUtil.isEmpty(orAggs)) {
			return;
		}

		// 2、获取记账模式
		String cgMode = BlParams.BLCG0001();

		// 3、过滤需记账的护理医嘱
		List<CiorderAggDO> orAggList = this.filterCgNurOrList(orAggs, cgMode);
		if (ListUtil.isEmpty(orAggList)) {
			return;
		}

		// 4、根据记账模式算法进行排斥，并计算天数
		// Map<String, DayFeeParam> chooseRstMap = this.excludeByMode(orAggList,
		// cgEndTime, cgMode);
		// Map<CiorderAggDO, Integer> ordDaysMap =
		// this.calcAcumDays(chooseRstMap);

		// 4、懒加载护理项目
		this.initSysData();

		// 5、记账
		this.wirteStartLog();
		for (CiorderAggDO orAggDO : orAggList) {
			this.chargeNurse(patInfo, pripatAgg, orAggDO, cgMode, cgEndTime);
		}
	}
	/**
	 * 初始化
	 * 
	 * @throws BizException
	 */
	public void initSysData() throws BizException {
		if (!hasLoaded) {
			// 1、获取所有的护理服务
			medSrvMap = this.getAllNurseSrvList();

			// 2、计算护理服务标准价格
			priRstMap = this.calcSrvStdPri(medSrvMap.keySet().toArray(new String[0]));

			// 3、加载组合计价的信息
			this.loadCompSrvList(this.priRstMap,this.medSrvMap);
			
			// 4、加载时间单位
			timeUnitMap = this.getTimeUnitMap();
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
	 * 获取护理医嘱集合
	 * 
	 * @param patInfo 就诊信息
	 * @param ordIds 医嘱ID
	 * @return
	 */
	private CiorderAggDO[] getNurOrList(IpCgPatDTO patInfo,String[] ordIds) throws BizException {
		StringBuffer sqlBuilder = new StringBuffer();
		sqlBuilder.append(" CI_ORDER.SD_SRVTP  LIKE '0601%' ");
		if (patInfo.getDt_backcg() != null) {
		/*	sqlBuilder.append(" AND (CI_ORDER.DT_END IS NULL) ");
		} else {*/
			sqlBuilder.append(" AND (CI_ORDER.DT_END IS NULL OR CI_ORDER.DT_END > '");
			sqlBuilder.append(patInfo.getDt_backcg()).append("')");
		}
		sqlBuilder.append(" AND CI_ORDER.ID_EN = '").append(patInfo.getId_ent()).append("'");
		sqlBuilder.append(" AND CI_OR_SRV.FG_BL='Y' AND CI_ORDER.FG_CHK='Y' ");// 计费项目、已核查
		sqlBuilder.append(" AND CI_ORDER.FG_CANC='N'");//非作废医嘱
		if (!ArrayUtil.isEmpty(ordIds)) {
			sqlBuilder.append(" AND " + SqlUtils.getInSqlByIds("CI_ORDER.ID_OR", ordIds));// 确切的护理医嘱ID
		}
		ICiOrdQryService ciOrRService = ServiceFinder.find(ICiOrdQryService.class);
		CiorderAggDO[] ciOrAggDOArr = ciOrRService.getBlFeeCiOrderSrvDto(sqlBuilder.toString(),
				this.getCiOrderAggConlumList());

		if (ArrayUtil.isEmpty(ciOrAggDOArr)) {
			return null;
		}
		return ciOrAggDOArr;
	}

	
	/**
	 * 获得属于时间的单位
	 * 
	 * @return 单位map，【key:单位ID,value: 单位DO】
	 * @throws BizException
	 */
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
	 *  验证数据
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
	 * 过滤需记账的护理医嘱
	 * 
	 * @param orAggs
	 * @return
	 */
	private List<CiorderAggDO> filterCgNurOrList(CiorderAggDO[] orAggs, String cgMode) {
		List<CiorderAggDO> orAggList = new ArrayList<CiorderAggDO>();
		if (ArrayUtil.isEmpty(orAggs)) {
			return orAggList;
		}
		// 按秒计返回所有
		if (NurseTPOrderCGModeEnum.SECOND.equals(cgMode)) {
			return Arrays.asList(orAggs);
		}
		// 如果同一天有多个护理医嘱，按优先原则进行取舍，TODO 此规则暂时不支持
		// 原则2017-10-18跟李永伟、王琪沟通确认，按计费点使用的医嘱为准，之前跨天的需计费，中间开立停掉的不参与计费，如若需要可进行补费
		for (CiorderAggDO aggDO : orAggs) {
			CiOrderDO ciOrdDO = aggDO.getParentDO();
			if (ciOrdDO.getDt_stop() == null) {
				orAggList.add(aggDO);// 当前仍在使用，参与计费
			} else if (!DateTimeUtils.isSameDay(ciOrdDO.getDt_effe(), ciOrdDO.getDt_stop())) {
				orAggList.add(aggDO);// 不再使用，但是跨天需参与计费
			} else if (orAggs.length == 1) {
				orAggList.add(aggDO);// 只有一条护理医嘱且当天结束，参与计费
			}
		}
		return orAggList;
	}

	/**
	 * 按记账模式进行排斥
	 * 
	 * @param orAggList
	 * @param cgEndTime
	 * @param cgMode
	 * @return
	 */
	private Map<String, DayFeeParam> excludeByMode(List<CiorderAggDO> orAggList, FDateTime cgEndTime, String cgMode) {
		// 1、构造计算参数
		List<DayFeeParam> feeParamList = new ArrayList<DayFeeParam>();
		for (CiorderAggDO orAggDO : orAggList) {
			CiOrderDO ordDO = orAggDO.getParentDO();
			for (OrdSrvDO ordSrvDO : orAggDO.getOrdSrvDO()) {
				DayFeeParam feeParam = new DayFeeParam();
				feeParam.setId(ordDO.getId_or());
				feeParam.setDt_b(ordDO.getDt_effe());
				feeParam.setDt_e(ordDO.getDt_stop());
				feeParam.setDt_chg_bill(ordSrvDO.getDt_last_cg());
				PriceResultDTO priRst = this.getPrice(priRstMap,ordSrvDO.getId_srv());
				feeParam.setPrice(priRst.getPrice_std());
				feeParam.setRealObj(orAggDO);
			}
		}
		// 2、 根据不同的计价模式创建比较器
		Comparator comparator = null;
		switch (cgMode) {
		case NurseTPOrderCGModeEnum.FRONT:
			comparator = ComparatorFactory.createEarlierComp();
			break;
		case NurseTPOrderCGModeEnum.BACK:
			comparator = ComparatorFactory.createLatterComp();
			break;
		case NurseTPOrderCGModeEnum.LOW:
			comparator = ComparatorFactory.createLowerComp();
			break;
		case NurseTPOrderCGModeEnum.HIGH:
			comparator = ComparatorFactory.createHigherComp();
			break;
		default:
			comparator = ComparatorFactory.createEarlierComp();// 默认时间优先
			break;
		}
		// 3、根据优先选择器进行处理
		IChooser chooser = new DayFeeExclChooser();
		Map<String, DayFeeParam> chooseRstMap = chooser.choose(feeParamList, cgEndTime, comparator);

		return chooseRstMap;
	}

	/**
	 * 计算累计天数
	 * 
	 * @param chooseRstMap
	 * @return
	 */
	private Map<CiorderAggDO, Integer> calcAcumDays(Map<String, DayFeeParam> chooseRstMap) {
		Map<CiorderAggDO, Integer> ordMap = new LinkedHashMap<CiorderAggDO, Integer>();
		CiorderAggDO lastKey = null;
		Integer i = 0;
		for (DayFeeParam feeParam : chooseRstMap.values()) {
			CiorderAggDO key = (CiorderAggDO) feeParam.getRealObj();
			if (i == chooseRstMap.size() && i > 1) {
				continue;// 计入不计出，最后一个不计入
			}
			if (key.equals(lastKey)) {
				ordMap.put(key, ordMap.get(key) + 1);
			} else {
				ordMap.put(key, 1);
			}
			lastKey = key;
			i++;
		}
		return ordMap;
	}

	/**
	 * 记账
	 * 
	 * @param patInfo 患者信息
	 * @param pripatAgg 患者价格分类
	 * @param orAggDO 医嘱
	 * @param cgMode 记账模型
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 */
	private void chargeNurse(IpCgPatDTO patInfo, PripatAggDO pripatAgg, CiorderAggDO orAggDO, String cgMode,
			FDateTime cgEndTime) throws BizException {
		List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
		List<String> orSrvIdList = new ArrayList<String>();
		CiOrderDO ciOrdDO = orAggDO.getParentDO();
		for (OrdSrvDO ordSrvDO : orAggDO.getOrdSrvDO()) {			
			if(!this.validateData(ciOrdDO,ordSrvDO)){
				continue;// 验证基本数据
			}
			MedSrvDO medSrvDO = medSrvMap.get(ordSrvDO.getId_srv());
			MeasDocDO srvUnitDO = timeUnitMap.get(medSrvDO.getId_unit_med());
			// 1、计算数量
			FDouble quan = null;
			if (NurseTPOrderCGModeEnum.SECOND.equals(cgMode)) {
				quan = this.calcQuanBySec(ciOrdDO, ordSrvDO, cgEndTime);// 按秒计费				
				quan = this.convertByUnit(srvUnitDO, quan.multiply(DateTimeUtils.MS_OF_SEC));//单位换算
			}else{
				quan = this.calcQuanByDay(patInfo.getDt_entry(), ciOrdDO.getDt_effe(), ciOrdDO.getDt_end(),
						ordSrvDO.getDt_last_cg(), cgEndTime);//按天计费
				quan = this.convertByUnit(srvUnitDO, quan.multiply(DateTimeUtils.MS_OF_DAY));//单位换算
			}
			if (quan == null || quan.doubleValue() <= 0) {
				continue;
			}
			this.wirteTimeLog(ciOrdDO, ordSrvDO,cgEndTime, quan);
			
			// 2、计算折扣价
			PriceResultDTO stdPriRst = this.getPrice(this.priRstMap,ordSrvDO.getId_srv());
			PriceResultDTO priRst = this.calcPatPri(stdPriRst, pripatAgg);	
			
			
			
			BlCgAccountDTO blCgDTO = this.createIpCgParam(patInfo, medSrvDO, priRst, quan, ciOrdDO,ordSrvDO);
			cgAccList.add(blCgDTO);
			orSrvIdList.add(ordSrvDO.getId_orsrv());
			this.writeSrvItmLog(medSrvDO, priRst, quan);// 记录费用项目日志
		}
		if (!ListUtil.isEmpty(cgAccList)) {
			// 记账
			chargeToBill(cgAccList, cgEndTime);
			
			FDateTime newTime = orAggDO.getParentDO().getDt_end() == null ? 
					cgEndTime : orAggDO.getParentDO().getDt_end().compareTo(cgEndTime) <= 0 ? 
						orAggDO.getParentDO().getDt_end() : cgEndTime;
			updateOrdSrvBlStatus(orSrvIdList, newTime);
		}
	}


	/**
	 * 写开始日志
	 */
	private void wirteStartLog() {
		BLTaskLogger.info(IBackCgLogConst.ONE_LEBEL_INDENT + "**护理费");
	}

	/**
	 * 写时间日志
	 * @param ciOrdDO
	 * @param ordSrvDO
	 * @param cgEndTime
	 * @param quan
	 */
	private void wirteTimeLog(CiOrderDO ciOrdDO, OrdSrvDO ordSrvDO, FDateTime cgEndTime,
			FDouble quan) {
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
}
