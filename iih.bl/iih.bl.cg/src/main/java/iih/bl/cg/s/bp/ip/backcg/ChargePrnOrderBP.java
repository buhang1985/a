package iih.bl.cg.s.bp.ip.backcg;

import iih.bd.base.utils.DateTimeUtils;
import iih.bd.base.utils.PrecisionUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.srvspecround.d.SrvSpecRoundDO;
import iih.bd.pp.srvspecround.i.ISrvspecroundRService;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.params.BlParams;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.pv.i.IEnOutCmdService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 记账持续医嘱
 * 
 * @author yankan
 * @since 2017-09-20
 * @version ly 2018/08/04 非特殊项目不取整
 */
public class ChargePrnOrderBP extends BaseChargeBP {
	private boolean hasLoaded = false;
	private Map<String, MedSrvDO> medSrvMap = null;// 医疗服务
	private Map<String, SrvSpecRoundDO> medSrvSpecRoundMap = null;// 项目特殊取整方式
	private Map<String, PriceResultDTO> priRstMap = null;// 计价结果
	private List<String> prnFreqIdList = null;// 持续频次集合
	private Map<String, MeasDocDO> timeUnitMap = null;// 时间单位map

	private String outUnCgSrvStr = null;//不计出的服务
	/**
	 * 默认构造函数
	 */
	public ChargePrnOrderBP() {
	}

	/**
	 * 构造函数
	 * 
	 * @param isOutDept 是否出院
	 */
	public ChargePrnOrderBP(Boolean isOutDept) {
		this.setOutDept(isOutDept);
	}

	/**
	 * 持续医嘱记账
	 * 
	 * @param patInfo 住院就诊信息
	 * @param chargeTime 记账时间
	 * @param cgMode 记账模式
	 * @throws BizException
	 */
	public void exec(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime chargeTime) throws BizException {
		// 参数校验
		this.validateParam(patInfo, pripatAgg, chargeTime);
		// 持续医嘱记账
		this.exec(patInfo, pripatAgg, chargeTime, null);
	}

	/**
	 * 
	 * @param patInfo
	 * @param pripatAgg
	 * @param chargeTime
	 * @param ordIds
	 * @throws BizException
	 */
	public void exec(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime chargeTime, String[] ordIds)
			throws BizException {
		// 1、记载持续医嘱频次
		if (ListUtil.isEmpty(prnFreqIdList)) {
			prnFreqIdList = this.getPrnFreqIdList();
			if (ListUtil.isEmpty(prnFreqIdList)) {
				BLTaskLogger.error("持续频次为空");
				return;
			}
		}

		// 2、获取持续医嘱集合
		CiorderAggDO[] ciOrdAggs = this.getPrnOrList(patInfo, prnFreqIdList, ordIds);
		if (ArrayUtil.isEmpty(ciOrdAggs)) {
			return;
		}
		// 3、懒加载系统数据
		this.initSysData();

		// 4、记录持续医嘱，事务中处理
		this.wirteStartLog();
		for (final CiorderAggDO orAggDO : ciOrdAggs) {
			this.chargePrn(patInfo, pripatAgg, orAggDO, chargeTime);
		}
	}

	/**
	 * 验证参数
	 * 
	 * @param patInfo
	 * @param pripatAgg
	 * @param chargeTime
	 * @throws BizException
	 */
	private void validateParam(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime chargeTime) throws BizException {
		ParamValidator.validateNotNull("住院患者信息", patInfo);
		ParamValidator.validateNotNull("患者价格分类", pripatAgg);
		ParamValidator.validateNotNull("记账时间", chargeTime);
	}

	/**
	 * 初始化
	 * 
	 * @throws BizException
	 */
	public void initSysData() throws BizException {
		if (!hasLoaded) {
			// 1、加载时间单位
			timeUnitMap = this.getTimeUnitMap();

			// 2、获取所有的持续医嘱服务，不过当前其他服务在医嘱开立时都可修改为持续医嘱
			medSrvMap = this.getAllPrnSrvList();

			// 3、计算护理服务标准价格
			priRstMap = this.calcSrvStdPri(medSrvMap.keySet().toArray(new String[0]));

			// 4、加载组合计价的信息
			this.loadCompSrvList(this.priRstMap, this.medSrvMap);

			// 5、获取所有的项目特殊取整方式
			medSrvSpecRoundMap = this.getAllPrnSrvSpecRoundList();
			
			this.outUnCgSrvStr = BlParams.BLCG0022();

			hasLoaded = true;// 修改加载标志
		}
	}

	/**
	 * 获取持续频次ID集合
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<String> getPrnFreqIdList() throws BizException {
		String[] selectedFields = { FreqDefDO.ID_FREQ };
		List<FreqDefDO> freqList = (List<FreqDefDO>) new DAFacade().findByAttrValString(FreqDefDO.class,
				FreqDefDO.ID_FREQUNITCT, IBdSrvDictCodeConst.ID_FREQNUNITCT_ALWAYS, selectedFields);
		if (ListUtil.isEmpty(freqList)) {
			return null;
		}

		List<String> freqIdList = new ArrayList<String>();
		for (FreqDefDO freqDO : freqList) {
			freqIdList.add(freqDO.getId_freq());
		}
		return freqIdList;
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
	 * 获取所有的持续服务
	 * 
	 * @return
	 * @throws BizException
	 */
	private Map<String, MedSrvDO> getAllPrnSrvList() throws BizException {
		String whereStr = " SD_SRVTP NOT LIKE '0601%' ";// 非护理医嘱
		whereStr += " AND " + SqlUtils.getInSqlByIds(MedSrvDO.ID_UNIT_MED, timeUnitMap.keySet().toArray(new String[0]));
		return this.getSrvListByCond(whereStr);
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

	/**
	 * 获取持续医嘱集合
	 * 
	 * @param patInfo 就诊信息
	 * @param prnFreqIdList 持续频次ID集合
	 * @param ordIds 医嘱ID集合,如果为空则加载所有
	 * @return
	 */
	private CiorderAggDO[] getPrnOrList(IpCgPatDTO patInfo, List<String> prnFreqIdList, String[] ordIds)
			throws BizException {
		StringBuffer sqlBuilder = new StringBuffer();
		sqlBuilder.append(SqlUtils.getInSqlByIds(" CI_ORDER.ID_FREQ", prnFreqIdList));// 持续医嘱
		sqlBuilder.append(" AND CI_ORDER.SD_SRVTP NOT LIKE '0601%' ");// 非护理
		/*if (patInfo.getDt_backcg() != null) {
			sqlBuilder.append(" AND (CI_ORDER.DT_END IS NULL OR CI_ORDER.DT_END > '");
			sqlBuilder.append(patInfo.getDt_backcg()).append("')");
		}*/
		sqlBuilder.append(" AND CI_ORDER.ID_EN = '").append(patInfo.getId_ent()).append("'");
		sqlBuilder.append(" AND CI_OR_SRV.FG_BL='Y' AND CI_ORDER.FG_CHK='Y'");
		sqlBuilder.append(" AND CI_ORDER.FG_CANC='N'");// 非作废医嘱
		if (!ArrayUtil.isEmpty(ordIds)) {
			sqlBuilder.append(" AND " + SqlUtils.getInSqlByIds("CI_ORDER.ID_OR", ordIds));// 确切的持续医嘱ID
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
	 * 记录持续医嘱收费项目
	 * 
	 * @param patInfo
	 * @param pripatAgg
	 * @param ciOrdAggs
	 * @param chargeTime
	 * @throws BizException
	 */
	private void chargePrn(IpCgPatDTO patInfo, PripatAggDO pripatAgg, CiorderAggDO orAggDO, FDateTime chargeTime)
			throws BizException {
		FDateTime dt_last_cg = chargeTime;
		CiOrderDO ciOrdDO = orAggDO.getParentDO();
		// 1、创建记账信息DTO
		List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
		Map<String, FDateTime> orSrvMap = new HashMap<String, FDateTime>();
		for (OrdSrvDO ordSrvDO : orAggDO.getOrdSrvDO()) {
			if (!this.validateOrdSrv(ciOrdDO, ordSrvDO)) {
				continue;
			}
			
			// 2018/10/24 非当日出院并且不记出包含当前服务时
			if(!this.isTodayOut && this.IsOutDept() && 
					!StringUtil.isEmpty(this.outUnCgSrvStr) && 
					this.outUnCgSrvStr.contains(ordSrvDO.getId_srv())){
				
				if(ordSrvDO.getDt_last_cg() != null && DateTimeUtils.isSameDay(ordSrvDO.getDt_last_cg(), chargeTime)){
					continue;
				}
			}
			
			// 计算数量
			SrvRoundResult roundRst = this.calcQuan(ciOrdDO, ordSrvDO, chargeTime, dt_last_cg);
			dt_last_cg = roundRst.getLastCgTime();// 最后记账时间取调整后的时间
			FDouble quan = roundRst.getQuan();
			if (quan == null || quan.doubleValue() <= 0) {
				continue;
			}

			// 计算折扣价格
			PriceResultDTO stdPriRst = this.getPrice(this.priRstMap, ordSrvDO.getId_srv());
			PriceResultDTO priRst = this.calcPatPri(stdPriRst, pripatAgg);
			MedSrvDO medSrvDO = medSrvMap.get(ordSrvDO.getId_srv());// 医疗服务
			BlCgAccountDTO blCgDTO = this.createIpCgParam(patInfo, medSrvDO, priRst, quan, ciOrdDO,ordSrvDO);
			cgAccList.add(blCgDTO);
			orSrvMap.put(ordSrvDO.getId_orsrv(), dt_last_cg);

			this.wirteTimeLog(ciOrdDO, ordSrvDO, chargeTime, quan);// 写日志
			this.writeSrvItmLog(medSrvDO, priRst, quan);// 记录费用项目日志
		}

		// 2、 保存记账信息
		this.chargeToBill(cgAccList, chargeTime);

		// 3、 更新医嘱服务记账状态
		if (orSrvMap != null && orSrvMap.size() > 0) {
			for (Entry<String, FDateTime> entry : orSrvMap.entrySet()) {
				this.updateOrdSrvBlStatus(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * 验证医嘱服务 验证持续服务、单位、定价
	 * 
	 * @param ordSrvDO
	 * @return
	 */
	private Boolean validateOrdSrv(CiOrderDO ciOrdDO, OrdSrvDO ordSrvDO) {
		if (!medSrvMap.containsKey(ordSrvDO.getId_srv())) {
			BLTaskLogger.error(String.format("医嘱：%s,医嘱服务：%s,不是持续类型的服务", ciOrdDO.getName_or(), ordSrvDO.getName()));
			return false;
		}
		if (!timeUnitMap.containsKey(ordSrvDO.getId_medu())) {
			BLTaskLogger.error(String.format("医嘱：%s,医嘱服务：%s,单位不是时间单位", ciOrdDO.getName_or(), ordSrvDO.getName()));
			return false;
		}
		PriceResultDTO priRst = this.getPrice(this.priRstMap, ordSrvDO.getId_srv());
		if (priRst == null) {
			BLTaskLogger.error(String.format("医嘱：%s,医嘱服务：%s,未进行定价", ciOrdDO.getName_or(), ordSrvDO.getName()));
			return false;
		}
		return true;
	}

	/**
	 * 计算数量
	 * 
	 * @param ciOrdDO
	 * @param ordSrvDO
	 * @param chargeTime
	 * @param dt_last_cg
	 * @return
	 */
	private SrvRoundResult calcQuan(CiOrderDO ciOrdDO, OrdSrvDO ordSrvDO, FDateTime chargeTime, FDateTime dt_last_cg) throws BizException {
		FDouble quan = FDouble.ZERO_DBL;
		// 计算毫秒数
		FDouble timeSpanMinSecs = this.calcQuanByMinSec(ciOrdDO, ordSrvDO, chargeTime);
		if (timeSpanMinSecs.doubleValue() > 0) {
			// 计算数量,换算为单位服务的数量,需要判断是不是特殊的取整方式
			MedSrvDO medSrvDO = medSrvMap.get(ordSrvDO.getId_srv());
			MeasDocDO timeUnitDO = timeUnitMap.get(medSrvDO.getId_unit_med());
			quan = this.convertByUnit(timeUnitDO, timeSpanMinSecs);// 单位转换			
			SrvSpecRoundDO srvSpecRoundDO = medSrvSpecRoundMap.get(medSrvDO.getId_srv());
			
			// 取整后续调整服务的最后记账时间
			FDateTime lastCgTime = this.getBeginTime(ciOrdDO.getDt_effe(), ordSrvDO.getDt_last_cg());
			
			if (srvSpecRoundDO != null) {
				quan = this.calcSpecRoundQuan(quan, srvSpecRoundDO);// 采用特殊的取整方式
				dt_last_cg = this.adjustDtAfterRound(timeUnitDO, quan, lastCgTime);
			} else {  
				
				//ly 2018/08/04  不取整
				//quan = new FDouble(Math.ceil(quan.doubleValue()));// 默认向上取整
				
				//dt_last_cg = lastCgTime.addSeconds(timeSpanMinSecs.div(1000).intValue());
				quan = quan.setScale(BlParams.BLCG0036(), BigDecimal.ROUND_CEILING);
				dt_last_cg = this.adjustDtAfterRound(timeUnitDO, quan, lastCgTime);
			}
		}
		SrvRoundResult roundRst = new SrvRoundResult();
		roundRst.setQuan(quan);
		roundRst.setLastCgTime(dt_last_cg);
		return roundRst;
	}

	/**
	 * 修改患者就诊账户的最后记账时间
	 * 
	 * @param entAccId 患者就诊账户ID
	 * @param endTime 记账结束时间
	 * @throws BizException
	 */
	public void updatePatEntDtEnd(String entAccId, FDateTime endTime) throws BizException {
		IEnOutCmdService service = ServiceFinder.find(IEnOutCmdService.class);
		service.updateEnAccDtEnd(entAccId, endTime);
	}

	/**
	 * 写开始日志
	 */
	private void wirteStartLog() {
		BLTaskLogger.info(IBackCgLogConst.ONE_LEBEL_INDENT + "**持续性医嘱费用");
	}

	/**
	 * 写时间日志
	 * 
	 * @param beginTime
	 * @param endTime
	 * @param quan
	 */
	private void wirteTimeLog(CiOrderDO ciOrdDO, OrdSrvDO ordSrvDO, FDateTime cgEndTime, FDouble quan) {
		FDateTime beginTime = this.getBeginTime(ciOrdDO.getDt_effe(), ordSrvDO.getDt_last_cg());
		FDateTime endTime = this.getEndTime(ciOrdDO.getDt_end(), cgEndTime);
		MeasDocDO timeUnitDO = timeUnitMap.get(ordSrvDO.getId_medu());
		BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT + ciOrdDO.getName_or());// 记录日志
		BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT + String.format("起=%s 止=%s 归整=1 %s=%s", beginTime, endTime,
				timeUnitDO.getName(), PrecisionUtils.formatQuan(quan)));
	}

	/**
	 * 记录费用项目日志
	 * 
	 * @param medSrvDO
	 * @param priRst
	 * @param quan
	 */
	private void writeSrvItmLog(MedSrvDO medSrvDO, PriceResultDTO priRst, FDouble quan) {
		MeasDocDO timeUnitDO = timeUnitMap.get(medSrvDO.getId_unit_med());
		FDouble price = PrecisionUtils.formatPrice(priRst.getPrice_ratio());
		quan = PrecisionUtils.formatQuan(quan);
		FDouble amt = PrecisionUtils.formatAmt(priRst.getPrice_ratio().multiply(quan));
		BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT + String.format("--%s  类别: %s  代码:%s 规格: / 单位:%s  数量:1.0 ",
				medSrvDO.getName(), medSrvDO.getSd_srvtp(), medSrvDO.getCode(), timeUnitDO.getName()));
		BLTaskLogger.info(
				IBackCgLogConst.THREE_LEBEL_INDENT + String.format("价格:%s  总数量:%s  金额:%s  应收:%s", price, quan, amt, amt));
	}
}
