package iih.bl.cg.s.bp.ip.backcg;

import iih.bd.base.utils.PrecisionUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.srvdc.d.FixedChargePkgItmDO;
import iih.bd.srv.srvdc.d.SrvdcAggDO;
import iih.bd.srv.srvdc.i.ISrvdcRService;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.comm.IBlImplicitParamKeyConst;
import iih.bl.comm.log.BLTaskLogger;
import iih.en.pv.enfee.d.EnFixedFeeDO;
import iih.en.pv.enfee.d.EnFixedFeeItemDO;
import iih.en.pv.enfee.d.EnfixedfeeAggDO;
import iih.en.pv.enfee.i.IEnfixedfeeRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 固定费用记账
 * 
 * @author yankan
 * @since 2017-09-18
 * @version 2018/05/29 ly 去掉固定包服务校验，修改科室固定包多科室问题
 */
public class ChargeDcgBP extends BaseChargeBP {
	private boolean hasLoaded = false;// 是否已记载
	private List<FixedChargePkgItmDO> hosFixedItmList = null;// 院级固定收费项目
	private Map<String, List<FixedChargePkgItmDO>> depFixedItmMap = null;// 科室固定收费项目
	private Map<String, MedSrvDO> medSrvMap = null;// 医疗服务map
	private Map<String, PriceResultDTO> priRstMap = null;// 服务价格map
	private Map<String, MeasDocDO> unitMap = null;// 单位map

	/**
	 * 默认构造函数
	 */
	public ChargeDcgBP() {
	}

	/**
	 * 构造函数
	 * 
	 * @param isOutDept 是否出院
	 */
	public ChargeDcgBP(Boolean isOutDept) {
		this.setOutDept(isOutDept);
	}

	/**
	 * 记账
	 * 
	 * @param patInfo 患者住院信息
	 * @param pripatAgg 患者价格分类
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 */
	public void exec(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime) throws BizException {
		// 1、获取就诊固定费用
		EnfixedfeeAggDO[] enFixedAggs = this.getPatFixedFeeList(patInfo.getId_ent());

		// 2、初始化系统数据
		this.initSysData();
		
		// 3计算个人收费包中服务价格
		this.loadEnfixedPri(enFixedAggs);

		// 3、记账，（就诊固定收费主表不会为空）
		for (EnfixedfeeAggDO enfixedfeeAgg : enFixedAggs) {
			this.chargeDcg(patInfo, pripatAgg, enfixedfeeAgg, cgEndTime);
		}
	}

	/**
	 * 加载个人收费包中的价格
	 * @param enFixedAggs
	 */
	private void loadEnfixedPri(EnfixedfeeAggDO[] enFixedAggs) throws BizException {
		
		if(ArrayUtil.isEmpty(enFixedAggs))
			return;
		
		Set<String> srvIdSet = new HashSet<String>();
		for (EnfixedfeeAggDO fixedAggDO : enFixedAggs) {
			for (EnFixedFeeItemDO feeItmDO : fixedAggDO.getEnFixedFeeItemDO()) {
				
				if(this.priRstMap.containsKey(feeItmDO.getId_srv())){
					continue;
				}
				srvIdSet.add(feeItmDO.getId_srv());
			}
		}
		
		if(srvIdSet.size() == 0)
			return;
		
		
		Map<String, MedSrvDO> srvMap = this.getSrvList(srvIdSet.toArray(new String[0]));
		Map<String, PriceResultDTO> priMap = this.calcSrvStdPri(srvIdSet.toArray(new String[0]));

		this.loadCompSrvList(priMap, srvMap);
	
		this.medSrvMap.putAll(srvMap);
		this.priRstMap.putAll(priMap);
	}

	/**
	 * 记录固定费用
	 * 
	 * @param patInfo 患者信息
	 * @param pripatAgg 患者价格分类
	 * @param enfixedfeeAgg 固定费用包
	 * @param cgEndTime 记账截止时间
	 */
	private void chargeDcg(IpCgPatDTO patInfo, PripatAggDO pripatAgg, EnfixedfeeAggDO enfixedfeeAgg,
			FDateTime cgEndTime) throws BizException {
		// 1、 计算天数
		FDateTime lastCgTime = enfixedfeeAgg.getParentDO().getDt_dcg_bill();
		FDouble day_quan = this.calcQuanByDay(patInfo.getDt_acpt(), lastCgTime, patInfo.getDt_end(), lastCgTime,
				cgEndTime);
		if (day_quan == null || day_quan.doubleValue() <= 0) {
			return;
		}
		FDateTime endTime = this.getEndTime(patInfo.getDt_end(), cgEndTime);
		this.writeStartLog(lastCgTime, endTime, day_quan);// 写摘要日志

		// 2、获取需收费的固定收费项目
		List<FixedChargePkgItmDO> fixCgItmList = this.getNeedCgFixedItmList(enfixedfeeAgg, patInfo.getId_dep_nur());
		if (ListUtil.isEmpty(fixCgItmList)) {
			return;
		}

		// 3、记账
		this.chargeDcg(patInfo, pripatAgg, enfixedfeeAgg.getParentDO(), fixCgItmList, cgEndTime, day_quan);

		// 4、更新固定费用记账时间
		String enDcgId = enfixedfeeAgg.getParentDO().getId_entdcg();
		this.updateEnDcg(enDcgId, cgEndTime);
	}

	/**
	 * 初始化系统数据
	 * 
	 * @throws BizException
	 */
	private void initSysData() throws BizException {
		if (hasLoaded) {
			return;
		}
		// 1、加载所有固定收费项目
		this.loadFixedChgItm();

		// 2、获取所有的固定收费服务项目
		List<String> srvIdList = this.getFixedSrvIdList();
		medSrvMap = this.getSrvList(srvIdList.toArray(new String[0]));

		// 3、计算护理服务标准价格
		priRstMap = this.calcSrvStdPri(medSrvMap.keySet().toArray(new String[0]));

		// 4、加载组合计价的信息
		this.loadCompSrvList(this.priRstMap, this.medSrvMap);

		// 5、加载服务单位
		List<String> unitIdList = new ArrayList<String>();
		for (MedSrvDO medSrvDO : medSrvMap.values()) {
			if (!unitIdList.contains(medSrvDO.getId_unit_med())) {
				unitIdList.add(medSrvDO.getId_unit_med());
			}
		}
		unitMap = this.getUnitMap(unitIdList);

		hasLoaded = true;// 修改加载标志
	}

	/**
	 * 加载固定收费项目
	 * 
	 * @throws BizException
	 */
	private void loadFixedChgItm() throws BizException {
		hosFixedItmList = new ArrayList<FixedChargePkgItmDO>();
		depFixedItmMap = new HashMap<String, List<FixedChargePkgItmDO>>();
		// 获取所有的固定费用
		SrvdcAggDO[] aggs = this.getAllDcAggList();
		if (ArrayUtil.isEmpty(aggs)) {
			return;
		}
		// 划分科室和院级
		for (SrvdcAggDO aggDO : aggs) {
			if (aggDO == null || ArrayUtil.isEmpty(aggDO.getFixedChargePkgItmDO())) {
				continue;
			}
			switch (aggDO.getParentDO().getSd_owtp()) {
			case IBdSrvDictCodeConst.SD_OWTP_HOSPIAL:
				for (FixedChargePkgItmDO fixItmDO : aggDO.getFixedChargePkgItmDO()) {
					hosFixedItmList.add(fixItmDO);
				}
				break;
			case IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT:
				//多科室
				String[] depIds = aggDO.getParentDO().getId_dep().split(",");
				if(ArrayUtil.isEmpty(depIds))
					break;
				
				for (String depId : depIds) {
					List<FixedChargePkgItmDO> fixedList = depFixedItmMap.get(depId);
					if (fixedList == null) {
						fixedList = new ArrayList<FixedChargePkgItmDO>();
						depFixedItmMap.put(depId, fixedList);
					}
					for (FixedChargePkgItmDO fixItmDO : aggDO.getFixedChargePkgItmDO()) {
						fixedList.add(fixItmDO);
					}
				}
				break;
			}
		}
	}

	/**
	 * 获取固定收费项目ID
	 * 
	 * @return
	 */
	private List<String> getFixedSrvIdList() {
		List<String> srvIdList = new ArrayList<String>();
		for (FixedChargePkgItmDO fixedItm : hosFixedItmList) {
			if (!srvIdList.contains(fixedItm.getId_srv())) {
				srvIdList.add(fixedItm.getId_srv());
			}
		}
		for (List<FixedChargePkgItmDO> fixedList : depFixedItmMap.values()) {
			if (ListUtil.isEmpty(fixedList))
				continue;
			for (FixedChargePkgItmDO fixedItm : fixedList) {
				if (!srvIdList.contains(fixedItm.getId_srv())) {
					srvIdList.add(fixedItm.getId_srv());
				}
			}
		}
		return srvIdList;
	}

	/**
	 * 获取所有的固定收费包
	 * 
	 * @return
	 * @throws BizException
	 */
	private SrvdcAggDO[] getAllDcAggList() throws BizException {
		ISrvdcRService dcRService = ServiceFinder.find(ISrvdcRService.class);
		return dcRService.find("fg_active = 'Y'", null, FBoolean.FALSE);
	}

	/**
	 * 获得单位集合
	 * 
	 * @param unitIdList
	 * @return 单位map，【key:单位ID,value: 单位DO】
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, MeasDocDO> getUnitMap(List<String> unitIdList) throws BizException {
		Map<String, MeasDocDO> measDocDOMap = new HashMap<String, MeasDocDO>();
		String whereStr = SqlUtils.getInSqlByIds(MeasDocDO.ID_MEASDOC, unitIdList);
		List<MeasDocDO> measDocDOLst = (List<MeasDocDO>) new DAFacade().findByCond(MeasDocDO.class, whereStr);
		if (!ListUtil.isEmpty(measDocDOLst)) {
			for (MeasDocDO measDocDO : measDocDOLst) {
				measDocDOMap.put(measDocDO.getId_measdoc(), measDocDO);
			}
		}
		return measDocDOMap;
	}

	/**
	 * 获取患者未记账的固定收费Agg集合
	 * 
	 * @param entId 就诊ID
	 * @return 固定收费Agg集合
	 * @throws BizException
	 */
	private EnfixedfeeAggDO[] getPatFixedFeeList(String entId) throws BizException {
		String whereStr = String.format("ID_ENT='%s'", entId);
		IEnfixedfeeRService fixfeeRService = ServiceFinder.find(IEnfixedfeeRService.class);
		EnfixedfeeAggDO[] fixedfeeAggs = fixfeeRService.find(whereStr, null, FBoolean.FALSE);
		return fixedfeeAggs;
	}

	/**
	 * 获取固定收费项目集合 1、如果就诊固定收费项目只个人固定收费模式，按个人的固定项目收取
	 * 2、如果是科室，则科室固定收费项目存在，则按科室固定收费项目收取,否则收取院级固定收费项目
	 * 
	 * @param enFeeAgg 就诊固定收费项目
	 * @param deptId 科室ID
	 * @return 固定收费项目集合
	 */
	private List<FixedChargePkgItmDO> getNeedCgFixedItmList(EnfixedfeeAggDO enFeeAgg, String deptId) {
		List<FixedChargePkgItmDO> fixCgItmList = new ArrayList<FixedChargePkgItmDO>();
		if (enFeeAgg != null && IEnDictCodeConst.SD_DCG_MODE_PAT.equals(enFeeAgg.getParentDO().getSd_dcg_mode())) {
			// 取个人固定收费项目
			for (EnFixedFeeItemDO enFeeItmDO : enFeeAgg.getEnFixedFeeItemDO()) {
				FixedChargePkgItmDO fixItm = new FixedChargePkgItmDO();
				fixItm.setId_srv(enFeeItmDO.getId_srv());
				fixItm.setQuan(enFeeItmDO.getQuan());
				fixItm.setId_mm(enFeeItmDO.getId_mm());
				fixCgItmList.add(fixItm);
			}
		} else {
			List<FixedChargePkgItmDO> depFixCgItmList = depFixedItmMap.get(deptId);
			if (!ListUtil.isEmpty(depFixCgItmList)) {
				fixCgItmList.addAll(depFixCgItmList);// 取科室固定收费项目
			} else {
				fixCgItmList.addAll(hosFixedItmList);// 如果科室项目为空，则取院级项目
			}
		}

		return fixCgItmList;
	}

	/**
	 * 记录固定费用
	 * 
	 * @param patInfo 住院患者信息
	 * @param pripatAgg 患者价格分类
	 * @param enFixedFeeDO 患者就诊固定费用
	 * @param fixCgItmList 固定收费项目集合
	 * @param cgEndTime 记账时间
	 * @param days 天数
	 * @throws BizException
	 */
	private void chargeDcg(IpCgPatDTO patInfo, PripatAggDO pripatAgg, EnFixedFeeDO enFixedFeeDO,
			List<FixedChargePkgItmDO> fixCgItmList, FDateTime cgEndTime, FDouble days) throws BizException {
		// 如果记账费用为空，则返回
		if (ListUtil.isEmpty(fixCgItmList)) {
			return;
		}
		List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
		for (FixedChargePkgItmDO feeItmDO : fixCgItmList) {
			if (!this.validateData(feeItmDO)) {
				continue;
			}
			// 计算数量，收费数量=天数*固定收费包的定义数量
			FDouble quan = feeItmDO.getQuan().multiply(days);
			// 计算折扣价格
			PriceResultDTO stdPriRst = this.getPrice(this.priRstMap, feeItmDO.getId_srv());
			PriceResultDTO priRst = this.calcPatPri(stdPriRst, pripatAgg);
			MedSrvDO medSrvDO = medSrvMap.get(feeItmDO.getId_srv());
			BlCgAccountDTO blCgDTO = this.createIpCgParam(patInfo, medSrvDO, priRst, quan, null, null);
			//补充就诊固定费用id ly 2018/08/23
			blCgDTO.setAttrVal(IBlImplicitParamKeyConst.BL_ID_ENTDCG, enFixedFeeDO.getId_entdcg());
			cgAccList.add(blCgDTO);
			this.writeFixItmLog(feeItmDO, medSrvDO, priRst, days);// 记录人日志
		}

		// 记账
		this.chargeToBill(cgAccList, cgEndTime);
	}

	/**
	 * 验证固定项目
	 * 
	 * @param feeItmDO
	 * @return
	 */
	private boolean validateData(FixedChargePkgItmDO feeItmDO) {
		//自定义固定收费项目无需在固定收费包里
		/*if (!medSrvMap.containsKey(feeItmDO.getId_srv())) {
			BLTaskLogger.error(String.format("固定收费项目：%s,医疗服务不存在", feeItmDO.getSrv_name()));
			return false;
		}*/
		PriceResultDTO priRst = this.getPrice(this.priRstMap, feeItmDO.getId_srv());
		if (priRst == null) {
			BLTaskLogger.error(String.format("固定收费项目：%s,未进行定价", feeItmDO.getSrv_name()));
			return false;
		}
		return true;
	}

	/**
	 * 更新就诊固定费用的最后记账日期
	 * 
	 * @param enDcgId 就诊固定费用ID
	 * @param chargeTime 记账时间
	 * @throws BizException
	 */
	private void updateEnDcg(String enDcgId, FDateTime chargeTime) throws BizException {
		if (enDcgId == null || chargeTime == null) {
			return;
		}
		String sql = "UPDATE EN_ENT_DCG SET DT_DCG_BILL=? WHERE ID_ENTDCG=?";
		SqlParam param = new SqlParam();
		param.addParam(chargeTime);
		param.addParam(enDcgId);
		new DAFacade().execUpdate(sql, param);
	}

	/**
	 * 记录固定费用开始日志
	 * 
	 * @param beginTime
	 * @param endTime
	 * @param days
	 */
	private void writeStartLog(FDateTime beginTime, FDateTime endTime, FDouble days) {
		days = PrecisionUtils.formatQuan(days);
		BLTaskLogger.info(IBackCgLogConst.ONE_LEBEL_INDENT + "**固定费用 ");
		BLTaskLogger.info(
				IBackCgLogConst.TWO_LEBEL_INDENT + String.format("起=%s 止=%s 归整=1   天=%s 系数=1.0 ", beginTime, endTime, days));
	}

	/**
	 * 记录固定费用项目日志
	 * 
	 * @param feeItmDO
	 * @param medSrvDO
	 * @param priRst
	 * @param days
	 */
	private void writeFixItmLog(FixedChargePkgItmDO feeItmDO, MedSrvDO medSrvDO, PriceResultDTO priRst, FDouble days) {
		MeasDocDO unitDO = unitMap.get(medSrvDO.getId_unit_med());
		String unitName = unitDO == null ? "" : unitDO.getName();
		FDouble price = PrecisionUtils.formatPrice(priRst.getPrice_ratio());
		FDouble quan = PrecisionUtils.formatQuan(feeItmDO.getQuan().multiply(days));
		FDouble amt = PrecisionUtils.formatAmt(priRst.getPrice_ratio().multiply(quan));
		BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT + String.format("--%s  类别: %s 代码:%s 规格:/ 单位: %s  数量:1.0 ",
				medSrvDO.getName(), medSrvDO.getSd_srvtp(), medSrvDO.getCode(), unitName));
		BLTaskLogger.info(
				IBackCgLogConst.THREE_LEBEL_INDENT + String.format("价格:%s  总数量:%s  金额:%s  应收:%s", price, quan, amt, amt));
	}
}
