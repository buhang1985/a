package iih.bl.cg.s.bp.ip.backcg;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.dto.d.PriceRateDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPpQryService;
import iih.bd.pp.i.IBdPriCalcService;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.pripat.i.IPripatMDORService;
import iih.bd.pp.srvspecround.d.SrvSpecRoundDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.cg.i.IBlCgAccountPackService;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.util.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DataCloneUtils;
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
 * 记账基类
 * 
 * @author yankan
 * @since 2017-09-18
 * @version ly 2018/05/11 修改价格系数获取
 * @version ly 2018/07/18 调用记账新接口
 */
public abstract class BaseChargeBP implements ICharge {
	// 服务基本字段集合
	private static final String[] SRV_BASIC_FIELDS = new String[] { MedSrvDO.ID_SRV, MedSrvDO.ID_SRVTP,
			MedSrvDO.SD_SRVTP, MedSrvDO.CODE, MedSrvDO.NAME, MedSrvDO.ID_SRVCA, MedSrvDO.ID_UNIT_MED,
			MedSrvDO.QUAN_MED };
	private static final Integer CHARGE_HEAD_SECONDS = 1;// 记账截止时间提前，默认一秒钟，保证记录到当日
	private Boolean isOutDept = false;// 是否出院
	protected Boolean isTodayOut = false;// 当日出院
	
	/**
	 * 获取是否出院
	 * 
	 * @return
	 */
	public Boolean IsOutDept() {
		return isOutDept;
	}

	/**
	 * 设置是否出院
	 * 
	 * @param isOutDept
	 */
	public void setOutDept(Boolean isOutDept) {
		this.isOutDept = isOutDept;
	}

	/**
	 * 记账
	 * 
	 * @param patInfo 患者住院信息
	 * @param pripatAgg 患者价格分类
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 */
	public abstract void exec(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime) throws BizException;

	/**
	 * 当日出院记账
	 * @param patInfo
	 * @param pripatAgg
	 * @param cgEndTime
	 * @throws BizException
	 */
	@Override
	public void execTodayOut(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime) throws BizException{
		this.isTodayOut = true;
		this.exec(patInfo, pripatAgg, cgEndTime);
	}
	
	/**
	 * 获取服务map
	 * 
	 * @param srvIds 服务ID集合
	 * @return 服务map，【key：服务ID，value：服务DO】
	 * @throws BizException
	 */
	public Map<String, MedSrvDO> getSrvList(String[] srvIds) throws BizException {
		Map<String, MedSrvDO> srvMap = new HashMap<String, MedSrvDO>();
		if (ArrayUtil.isEmpty(srvIds)) {
			return srvMap;
		}

		List<MedSrvDO> srvList = (List<MedSrvDO>) new DAFacade().findByPKs(MedSrvDO.class, srvIds, SRV_BASIC_FIELDS);
		if (!ListUtil.isEmpty(srvList)) {
			for (MedSrvDO srvDO : srvList) {
				srvMap.put(srvDO.getId_srv(), srvDO);
			}
		}
		return srvMap;
	}

	/**
	 * 根据条件查询服务
	 * 
	 * @param whereStr 过滤条件
	 * @return 服务map，【key：服务ID，value：服务DO】
	 * @throws BizException
	 */
	public Map<String, MedSrvDO> getSrvListByCond(String whereStr) throws BizException {
		List<MedSrvDO> srvList = (List<MedSrvDO>) new DAFacade().findByCond(MedSrvDO.class, whereStr, SRV_BASIC_FIELDS);
		Map<String, MedSrvDO> srvMap = new HashMap<String, MedSrvDO>();
		if (!ListUtil.isEmpty(srvList)) {
			for (MedSrvDO srvDO : srvList) {
				srvMap.put(srvDO.getId_srv(), srvDO);
			}
		}
		return srvMap;
	}

	/**
	 * 计算标准价格
	 * 
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	public Map<String, PriceResultDTO> calcSrvStdPri(String[] srvIds) throws BizException {
		IBdPriCalcService calcPriService = ServiceFinder.find(IBdPriCalcService.class);
		return calcPriService.batchCalcStdPrice(srvIds);
	}

	/**
	 * 计算服务的所有折扣价格
	 * 
	 * @param srvIds
	 * @return 计价结果Map,[Key：患者价格分类ID-服务ID,value：计算价格结果]
	 * @throws BizException
	 */
	public Map<String, PriceResultDTO> calcSrvsPripatPri(String[] srvIds) throws BizException {
		// 1.提取数据库中的患者价格分类
		IPripatMDORService iPripatMDORService = ServiceFinder.find(IPripatMDORService.class);
		PriPatDO[] priPatDOs = iPripatMDORService.find("1=1", "", FBoolean.FALSE);
		Map<String, PriceResultDTO> patSrvPriMap = new HashMap<String, PriceResultDTO>();
		IBdPriCalcService calcPriService = ServiceFinder.find(IBdPriCalcService.class);
		for (PriPatDO priPatDO : priPatDOs) {
			try {
				Map<String, PriceResultDTO> temp_patSrvPriMap = calcPriService.batchCalcPatPrice(srvIds,
						priPatDO.getId_pripat());
				Iterator iter = temp_patSrvPriMap.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry entry = (Map.Entry) iter.next();
					patSrvPriMap.put(priPatDO.getId_pripat() + "-" + entry.getKey(),
							temp_patSrvPriMap.get(entry.getKey()));
				}
			} catch (Exception ex) {
				// 异常后记录异常信息，下一个可继续执行
				BLTaskLogger.error("记账出现异常:获取患者分类下折扣价格失败！患者分类:" + priPatDO.getId_pripat());
				BLTaskLogger.error("后台记账发生异常，异常信息：" + ex.getMessage());
				BLTaskLogger.error(ExceptionUtils.getFullStackTrace(ex));
			}
		}
		return patSrvPriMap;
	}

	/**
	 * 加载组合计价的服务
	 * 
	 * @param priRstMap 计价结果
	 * @param medSrvMap 医疗服务集合
	 * @throws BizException
	 */
	protected void loadCompSrvList(Map<String, PriceResultDTO> priRstMap, Map<String, MedSrvDO> medSrvMap)
			throws BizException {
		if (CollectionUtils.isEmpty(priRstMap)) {
			return;
		}
		List<String> relSrvIdList = new ArrayList<String>();
		for (PriceResultDTO srvPri : priRstMap.values()) {
			if (CollectionUtils.isEmpty(srvPri.getSrvitm_list())) {
				continue;
			}
			for (Object relItmObj : srvPri.getSrvitm_list()) {
				PriceResultDTO relItmPri = (PriceResultDTO) relItmObj;
				if (!relSrvIdList.contains(relItmPri.getId_srv())) {
					relSrvIdList.add(relItmPri.getId_srv());
				}
			}
		}
		if (ListUtil.isEmpty(relSrvIdList)) {
			return;
		}
		// 加载服务
		if (medSrvMap == null) {
			medSrvMap = new HashMap<String, MedSrvDO>();
		}
		Map<String, MedSrvDO> srvMap = this.getSrvList(relSrvIdList.toArray(new String[0]));
		for (MedSrvDO srvDO : srvMap.values()) {
			if (!medSrvMap.containsKey(srvDO.getId_srv())) {
				medSrvMap.put(srvDO.getId_srv(), srvDO);
			}
		}
	}

	/**
	 * 获取服务价格
	 * 
	 * @param priRstMap
	 * @param srvId
	 * @return
	 */
	protected PriceResultDTO getPrice(Map<String, PriceResultDTO> priRstMap, String srvId) {
		if (StringUtil.isEmpty(srvId) || CollectionUtils.isEmpty(priRstMap)) {
			return null;
		}
		PriceResultDTO priRst = priRstMap.get(srvId);
		if (priRst != null) {
			return priRst;
		}
		// 组合计价，尝试从关联服务中获取
		for (PriceResultDTO srvPri : priRstMap.values()) {
			if (CollectionUtils.isEmpty(srvPri.getSrvitm_list())) {
				continue;
			}
			for (Object relItmObj : srvPri.getSrvitm_list()) {
				PriceResultDTO relItmPri = (PriceResultDTO) relItmObj;
				if (srvId.equals(relItmPri.getId_srv())) {
					return relItmPri;
				}
			}
		}
		return priRst;
	}

	/**
	 * 计算患者价格
	 * 
	 * @param priRst
	 * @param pripatAgg
	 * @return
	 */
	public PriceResultDTO calcPatPri(PriceResultDTO priRst, PripatAggDO pripatAgg) throws BizException {
		PriceResultDTO patPriRst = DataCloneUtils.clone(priRst);
		FDateTime currentTime = AppUtils.getServerDateTime();
		IBdPriCalcService calcService = ServiceFinder.find(IBdPriCalcService.class);
		PriceRateDTO rateDto = calcService.calcPatPriRate(pripatAgg, priRst.getId_srv(), priRst.getSd_srvtp(), currentTime);
		patPriRst.setRate(rateDto.getRate());
		if(rateDto.getPrice_ratio() == null){
			patPriRst.setPrice_ratio(patPriRst.getPrice_std().multiply(patPriRst.getRate()));// 折扣价
		}else{
			patPriRst.setPrice_ratio(rateDto.getPrice_ratio());
		}
		
		return patPriRst;
	}

	/**
	 * 组装调用医嘱接口的参数（List中存放需要获取的字段）
	 * 
	 * @return
	 */
	public List<String> getCiOrderAggConlumList() {
		List<String> list = new ArrayList<String>();
		list.add("ci_order." + CiOrderDO.ID_OR);
		list.add("ci_order." + CiOrderDO.ID_PAT);
		list.add("ci_order." + CiOrderDO.ID_EN);
		list.add("ci_order." + CiOrderDO.ID_ENTP);
		list.add("ci_order." + CiOrderDO.CODE_ENTP);
		list.add("ci_order." + CiOrderDO.CODE_OR);
		list.add("ci_order." + CiOrderDO.NAME_OR);
		list.add("ci_order." + CiOrderDO.CONTENT_OR);
		list.add("ci_order." + CiOrderDO.ID_FREQ);
		list.add("ci_order." + CiOrderDO.DT_ENTRY);
		list.add("ci_order." + CiOrderDO.DT_EFFE);
		list.add("ci_order." + CiOrderDO.DT_STOP);
		list.add("ci_order." + CiOrderDO.DT_END);
		list.add("ci_order." + CiOrderDO.ID_EMP_OR);
		list.add("ci_order." + CiOrderDO.ID_DEP_OR);
		list.add("ci_order." + CiOrderDO.ID_ORG_OR);
		list.add("ci_order." + CiOrderDO.ID_WG_OR);
		list.add("ci_order." + CiOrderDO.ID_DEP_MP);
		list.add("ci_order." + CiOrderDO.DT_LAST_BL);
		list.add("ci_order." + CiOrderDO.DS);
		list.add("ci_order." + CiOrderDO.SV);
		list.add("ci_or_srv." + OrdSrvDO.ID_ORSRV);
		list.add("ci_or_srv." + OrdSrvDO.NAME);
		list.add("ci_or_srv." + OrdSrvDO.ID_SRV);
		list.add("ci_or_srv." + OrdSrvDO.ID_SRVTP);// 记账应该使用服务的类型
		list.add("ci_or_srv." + OrdSrvDO.SD_SRVTP);
		list.add("ci_or_srv." + OrdSrvDO.ID_SRVCA);
		list.add("ci_or_srv." + OrdSrvDO.FG_MM);
		list.add("ci_or_srv." + OrdSrvDO.FG_BL);
		list.add("ci_or_srv." + OrdSrvDO.DT_LAST_CG);
		list.add("ci_or_srv." + OrdSrvDO.QUAN_MEDU);
		list.add("ci_or_srv." + OrdSrvDO.QUAN_TOTAL_MEDU);
		list.add("ci_or_srv." + OrdSrvDO.ID_MEDU);
		list.add("ci_or_srv." + OrdSrvDO.ID_DEP_MP);
		list.add("ci_or_srv." + OrdSrvDO.DS);
		list.add("ci_or_srv." + OrdSrvDO.SV);
		list.add("ci_or_srv." + OrdSrvDO.SD_SU_BL);
		return list;
	}

	/**
	 * 创建记账参数信息DTO
	 * 
	 * @param patInfo 住院患者信息
	 * @param medSrvDO 医疗服务DO
	 * @param priRst 服务价格
	 * @param quan 数量
	 * @param ciOrderDO 医嘱
	 * @param ordSrvDO 医嘱服务
	 * @param cgTime 记账时间
	 * @return 记账参数信息DTO
	 *//*
	public BlOrderAppendBillParamDTO createIpCgParam(IpCgPatDTO patInfo, MedSrvDO medSrvDO, PriceResultDTO priRst,
			FDouble quan, CiOrderDO ciOrderDO, OrdSrvDO ordSrvDO, FDateTime cgTime) {
		if (DateTimeUtils.isDayBegin(cgTime.getUFTime())) {
			cgTime = cgTime.addSeconds(-1 * CHARGE_HEAD_SECONDS);// 单日起始，则是记昨天的费用，需要减1秒，记账时间需提前于记账截止时间
		}

		BlOrderAppendBillParamDTO blCgDTO = new BlOrderAppendBillParamDTO();
		blCgDTO.setId_pat(patInfo.getId_pat());
		blCgDTO.setId_ent(patInfo.getId_ent());
		blCgDTO.setId_enttp(patInfo.getId_entp());
		blCgDTO.setCode_enttp(patInfo.getCode_entp());

		// 服务信息
		blCgDTO.setId_srvtp(medSrvDO.getId_srvtp());
		blCgDTO.setSd_srvtp(medSrvDO.getSd_srvtp());
		blCgDTO.setId_srvca(medSrvDO.getId_srvca());
		blCgDTO.setId_srv(medSrvDO.getId_srv());
		blCgDTO.setCode_srv(medSrvDO.getCode());
		blCgDTO.setName_srv(medSrvDO.getName());
		blCgDTO.setSrvu(medSrvDO.getId_unit_med());// 服务项目单位

		// 价格
		blCgDTO.setId_pripat(patInfo.getId_pripat());
		blCgDTO.setPrice(PrecisionUtils.formatPrice(priRst.getPrice_std()));// 标准价格
		blCgDTO.setRatio_pripat(priRst.getRate());// 折扣系数
		// TODO:TCY 铜陵的护理费和持续医嘱费用，目前用标准价算的
		if (priRst.getPrice_ratio() == null) {
			blCgDTO.setPrice_ratio(PrecisionUtils.formatPrice(priRst.getPrice_std()));
		} else {
			blCgDTO.setPrice_ratio(PrecisionUtils.formatPrice(priRst.getPrice_ratio()));// 折扣价
		}
		// 数量与金额
		blCgDTO.setQuan(PrecisionUtils.formatQuan(quan));// 数量
		blCgDTO.setAmt_std(PrecisionUtils.formatAmt(blCgDTO.getPrice().multiply(blCgDTO.getQuan())));
		blCgDTO.setAmt_ratio(PrecisionUtils.formatAmt(blCgDTO.getPrice_ratio().multiply(blCgDTO.getQuan())));
		blCgDTO.setAmt_pat(blCgDTO.getAmt_ratio());// 自付金额=折后金额
		blCgDTO.setAmt(blCgDTO.getAmt_ratio());// 金额=折后金额
		blCgDTO.setAmt_hp(FDouble.ZERO_DBL);

		// 记账信息
		blCgDTO.setId_org(patInfo.getId_org());
		blCgDTO.setId_grp(patInfo.getId_grp());
		blCgDTO.setId_emp_cg(ContextUtils.getPsnId());// 记账员
		blCgDTO.setId_org_cg(patInfo.getId_org());
		blCgDTO.setId_dep_cg(null);// 记账科室
		blCgDTO.setId_dep_mp(patInfo.getId_dep_nur());// 执行科室默认为病区
		blCgDTO.setFg_mm(FBoolean.FALSE);
		blCgDTO.setDt_cg(cgTime);
		blCgDTO.setSupportAppendBill(FBoolean.TRUE);// 后台划价支持后付费
		blCgDTO.setDt_last_bl(cgTime);// 计费时间
		blCgDTO.setEu_direct(BookRtnDirectEnum.CHARGE);// //收费
		blCgDTO.setSrcfunc_des(IBlCgCodeConst.PricingCg); // 来源于后台划价程序

		// 医嘱信息
		if (ciOrderDO != null) {
			blCgDTO.setId_or(ciOrderDO.getId_or());// 医嘱ID
			blCgDTO.setId_emp_or(ciOrderDO.getId_emp_or());// 开单医生
			blCgDTO.setId_dep_or(ciOrderDO.getId_dep_or());// 开单科室
			blCgDTO.setDt_or(ciOrderDO.getDt_effe());// 应该取医嘱生效时间
			if (ordSrvDO != null) {
				blCgDTO.setId_orsrv(ordSrvDO.getId_orsrv());
				blCgDTO.setFg_mm(ordSrvDO.getFg_mm());
				blCgDTO.setSrvu(ordSrvDO.getId_medu());// 服务项目单位
				blCgDTO.setId_dep_mp(ordSrvDO.getId_dep_mp());// 执行科室
			}
		}

		BlOrderAppendInpBillParamDTO inpBillDTO = new BlOrderAppendInpBillParamDTO();
		inpBillDTO.setFg_pddisc(null);// 出院带药标志
		inpBillDTO.setId_wg_or(null);// 医疗组
		inpBillDTO.setId_dep_nur(patInfo.getId_dep_nur());
		inpBillDTO.setFg_bb(FBoolean.FALSE);// 婴儿标志
		blCgDTO.setInpBillDTO(inpBillDTO);
		return blCgDTO;
	}*/

	/**
	 * 记账
	 * 
	 * @param cgParamList
	 * @param entpCode
	 * @throws BizException
	 *//*
	public void chargeToBill(List<BlOrderAppendBillParamDTO> cgParamList, String entpCode) throws BizException {
		if (ListUtil.isEmpty(cgParamList)) {
			return;
		}
		IBLOrderAppendBillService bollService = ServiceFinder.find(IBLOrderAppendBillService.class);
		bollService.SetOrderAppendBill_ByItms(cgParamList.toArray(new BlOrderAppendBillParamDTO[0]), entpCode);
	}*/
	
	/**
	 * 组装数据(新)
	 * @param patInfo
	 * @param medSrvDO
	 * @param priRst
	 * @param quan
	 * @param ciOrderDO
	 * @param ordSrvDO
	 * @return
	 */
	public BlCgAccountDTO createIpCgParam(IpCgPatDTO patInfo, MedSrvDO medSrvDO, PriceResultDTO priRst,
			FDouble quan, CiOrderDO ciOrderDO, OrdSrvDO ordSrvDO) {
		
		
		BlCgAccountDTO accDto = new BlCgAccountDTO();
		accDto.setId_ent(patInfo.getId_ent());
		accDto.setId_pat(patInfo.getId_pat());
		if(ciOrderDO != null){
			accDto.setId_or(ciOrderDO.getId_or());
		}else{
			accDto.setId_dep_or(patInfo.getId_dep_phy());
			accDto.setId_dep_mp(patInfo.getId_dep_nur());
			accDto.setId_emp_or(patInfo.getId_emp_phy());
		}
		
		if(ordSrvDO != null){
			accDto.setId_orsrv(ordSrvDO.getId_orsrv());
		}
		accDto.setId_srv(medSrvDO.getId_srv());
		accDto.setFg_mm(FBoolean.FALSE);
		accDto.setId_unit_srv(medSrvDO.getId_unit_med());
		accDto.setPrice_std(priRst.getPrice_std());
		accDto.setPrice_ratio(priRst.getPrice_ratio());
		accDto.setRatio_pripat(priRst.getRate());
		accDto.setQuan(quan);
		accDto.setEu_direct(BookRtnDirectEnum.CHARGE);
		
		return accDto;
	}
	
	/**
	 * 记账(新)
	 * @param cgAccList
	 * @param cgTime
	 * @throws BizException
	 */
	public void chargeToBill(List<BlCgAccountDTO> cgAccList,FDateTime cgTime)throws BizException {
		
		if(ListUtil.isEmpty(cgAccList))
			return;
		
		BlCgAccountSetDTO accSetDto = new BlCgAccountSetDTO();
		accSetDto.setId_emp_cg(Context.get().getStuffId());
		accSetDto.setId_org_cg(Context.get().getOrgId());
		accSetDto.setId_dep_cg(Context.get().getDeptId());
		accSetDto.setDt_cg(this.getDtCg(cgTime));
		accSetDto.setFg_price_cal(FBoolean.FALSE);
		accSetDto.setSrcfunc_des(IBlCgFuncConst.FUNC_IPBL_BACKKEEPACCOUNT);
		accSetDto.setEu_srctp(FeeOriginEnum.ORDERS_FEE);
		
		IBlCgAccountPackService service = ServiceFinder.find(IBlCgAccountPackService.class);
		service.keepAccountForIpFlow(cgAccList.toArray(new BlCgAccountDTO[0]), accSetDto);
		//IBlCgAccountService service = ServiceFinder.find(IBlCgAccountService.class);
		//service.keepAccountForIp(cgAccList.toArray(new BlCgAccountDTO[0]), accSetDto);
	}

	/**
	 * 医嘱记账
	 * 
	 * @param cgParamList
	 * @param entpCode
	 * @throws BizException
	 *//*
	public void chargeToBillWithOr(List<BlOrderAppendBillParamDTO> cgParamList, String entpCode) throws BizException {
		if (ListUtil.isEmpty(cgParamList)) {
			return;
		}
		IBLOrderAppendBillService bollService = ServiceFinder.find(IBLOrderAppendBillService.class);
		bollService.SetOrderAppendBill_ByIdorsrv(cgParamList.toArray(new BlOrderAppendBillParamDTO[0]), entpCode);
	}*/

	/**
	 * 更新医嘱服务的记账状态
	 * 
	 * @param orSrvIdList 医嘱服务ID集合
	 * @param chargeTime 记账时间
	 * @throws BizException
	 */
	public void updateOrdSrvBlStatus(List<String> orSrvIdList, FDateTime chargeTime) throws BizException {
		if (ListUtil.isEmpty(orSrvIdList))
			return;

		// 更新医嘱服务的记账状态
		String sql = "UPDATE CI_OR_SRV SET DT_LAST_CG=?,SD_SU_BL=?,ID_SU_BL=? ";
		sql += " WHERE " + SqlUtils.getInSqlByIds(OrdSrvDO.ID_ORSRV, orSrvIdList);

		SqlParam param = new SqlParam();
		param.addParam(chargeTime);
		param.addParam(ICiDictCodeConst.SD_SU_BL_ACCOUNT);
		param.addParam(ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID);
		new DAFacade().execUpdate(sql, param);
	}

	/**
	 * 更新医嘱服务的记账状态
	 * 
	 * @param orSrvId 医嘱服务ID
	 * @param chargeTime 记账时间
	 * @throws BizException
	 */
	public void updateOrdSrvBlStatus(String orSrvId, FDateTime chargeTime) throws BizException {
		if (StringUtils.isEmpty(orSrvId) || chargeTime == null)
			return;

		// 更新医嘱服务的记账状态
		String sql = "UPDATE CI_OR_SRV SET DT_LAST_CG=?,SD_SU_BL=?,ID_SU_BL=? ";
		sql += " WHERE ID_ORSRV=?";

		SqlParam param = new SqlParam();
		param.addParam(chargeTime);
		param.addParam(ICiDictCodeConst.SD_SU_BL_ACCOUNT);
		param.addParam(ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID);
		param.addParam(orSrvId);
		new DAFacade().execUpdate(sql, param);
	}

	/**
	 * 计算秒数
	 * 
	 * @param ciOrdDO
	 * @param ordSrvDO
	 * @param cgEndTime
	 * @return
	 */
	protected FDouble calcQuanBySec(CiOrderDO ciOrdDO, OrdSrvDO ordSrvDO, FDateTime cgEndTime) {
		FDateTime beginTime = this.getBeginTime(ciOrdDO.getDt_effe(), ordSrvDO.getDt_last_cg());
		FDateTime endTime = this.getEndTime(ciOrdDO.getDt_end(), cgEndTime);
		if (beginTime.after(endTime)) {
			return FDouble.ZERO_DBL;
		}
		int secs = FDateTime.getSecondsBetween(beginTime, endTime);
		return new FDouble(secs);
	}
	/**
	 * 计算秒数
	 * 
	 * @param ciOrdDO
	 * @param ordSrvDO
	 * @param cgEndTime
	 * @return
	 */
	protected FDouble calcQuanByMinSec(CiOrderDO ciOrdDO, OrdSrvDO ordSrvDO, FDateTime cgEndTime) {
		FDouble secs = this.calcQuanBySec(ciOrdDO, ordSrvDO, cgEndTime);
		return secs.multiply(1000);//秒转换为毫秒
	}
	/**
	 * 计算天数
	 * 
	 * @param entryTime 入院时间
	 * @param dtBegin 开始时间
	 * @param dtEnd 结束时间
	 * @param lastCgTime 上次记账时间
	 * @param cgEndTime 本次记账截止时间
	 * @return
	 */
	protected FDouble calcQuanByDay(FDateTime entryTime, FDateTime dtBegin, FDateTime dtEnd, FDateTime lastCgTime,
			FDateTime cgEndTime) {
		FDateTime beginTime = this.getBeginTime(dtBegin, lastCgTime);
		FDateTime endTime = this.getEndTime(dtEnd, cgEndTime);
		if (beginTime.after(endTime)) {
			return FDouble.ZERO_DBL;
		}
		Integer spanDays = DateTimeUtils.getNatDaysBetween(beginTime, endTime);// 计算自然天
		// 如果当日入出院，需要记录一天费用
		if (spanDays == 0) {
			if (isOutDept && DateTimeUtils.isSameDay(entryTime, cgEndTime)
					&& (lastCgTime == null || lastCgTime.equals(entryTime))) {
				spanDays = 1;
			}
		}
		return new FDouble(spanDays);
	}
	/**
	 * 按秒计算数量
	 * @param ciOrdDO
	 * @param ordSrvDO
	 * @param cgEndTime
	 * @return
	 */
	public FDouble calcTimeQuan(CiOrderDO ciOrdDO,OrdSrvDO ordSrvDO,MeasDocDO unitDO,FDateTime cgEndTime) {
		//1、计算时间间隔
		FDouble timeSpanMinSecs = this.calcQuanByMinSec(ciOrdDO, ordSrvDO, cgEndTime);
		//2、单位换算
		FDouble quan = this.convertByUnit(unitDO, timeSpanMinSecs);
		return quan;
	}
	/**
	 * 计算开始时间
	 * 
	 * @param dtBegin
	 * @param lastCgTime
	 * @return
	 */
	protected FDateTime getBeginTime(FDateTime dtBegin, FDateTime lastCgTime) {
		return lastCgTime != null ? lastCgTime : dtBegin;
	}

	/**
	 * 计算结束时间
	 * 
	 * @param dtEnd
	 * @param cgEndTime
	 * @return
	 */
	protected FDateTime getEndTime(FDateTime dtEnd, FDateTime cgEndTime) {
		if (dtEnd == null || dtEnd.after(cgEndTime)) {
			return cgEndTime;// 如果截止时间为空，或者停止时间晚于记账时间，则取记账时间
		}
		return dtEnd;
	}
	/**
	 * 单位换算 
	 * 只跟时间有关，跟医嘱开立数量无关，2017-09-29跟妍妍、婵懿确认 持续医嘱只跟时间有关，跟服务开立的服务数量无关
	 * 服务中的默认用量，只跟开单有关，其他地方不用
	 * 
	 * @param srvUnitDO 医疗服务的单位
	 * @param minSecs 间隔微妙数
	 * @return 数量
	 */
	protected FDouble convertByUnit(MeasDocDO srvUnitDO, FDouble minSecs) {
		if(minSecs==null || minSecs.doubleValue()<=0){
			return FDouble.ZERO_DBL;
		}
		FDouble factor = srvUnitDO.getScalefactor();// 单位换算系数
		FDouble quan = minSecs.div(factor);
		return quan;// 计算数量过程中不能舍弃小数
	}
	/**
	 * TCY 特殊取整方式后，计算医嘱最后一次划价时间 按特殊取整方式计算划价后，需要再次计算医嘱最后一次划价时间，例如不足半天收半天费用。
	 * 计算单位数量 只跟时间有关，跟医嘱开立数量无关，2017-09-29跟妍妍、婵懿确认 持续医嘱只跟时间有关，跟服务开立的服务数量无关
	 * 备注：本算法只支持诊疗服务用量定义为1
	 * 
	 * @param srvUnitDO 医疗服务的单位
	 * @param new_quan 经过特殊取整计算后的数量
	 * @param dt_last_bl 上一次划价时间
	 * @return 经过特殊计算后的本次划价时间
	 */
	public FDateTime adjustDtAfterRound(MeasDocDO srvUnitDO, FDouble new_quan, FDateTime dt_last_bl) {
		FDouble factor = srvUnitDO.getScalefactor();// 单位换算系数
		FDouble seconds = new_quan.multiply(factor).div(1000L);
		return dt_last_bl.addSeconds(seconds.intValue());
	}
	/**
	 * 特殊取整
	 * @param quan
	 * @param specRoundDO
	 * @return
	 */
	protected FDouble calcSpecRoundQuan(FDouble quan,SrvSpecRoundDO specRoundDO) throws BizException{
		IBdPpQryService ppQryService = ServiceFinder.find(IBdPpQryService.class);
		return ppQryService.specRound(quan, specRoundDO);
	}
	
	/**
	 * 记账日期 如果是后台划价 ,则为前一天的23:59:59(后台自动划价时间传进来的是当前日期的00:00:00)
	 * @param dt_cg
	 * @return
	 */
	private FDateTime getDtCg(FDateTime dtCg){
		FDateTime dtBegin =  DateTimeUtils.getDayBeginTime(dtCg);
		if(dtCg.equals(dtBegin)){
			//-1秒
			dtCg = dtBegin.addSeconds(-1);
		}
		return dtCg;
	}

}
