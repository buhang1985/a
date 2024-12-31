package iih.ci.sdk.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.bdpriboil.d.BdPriBoilDO;
import iih.bd.pp.bdpriboil.d.desc.BdPriBoilDODesc;
import iih.bd.pp.priusg.d.PriUsgDO;
import iih.bd.pp.priusg.d.ScopeEnum;
import iih.bd.pp.priusg.d.desc.PriUsgDODesc;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.or.i.ICiIpOrderMainService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.sdk.cache.BDFreqInfoCache;
import iih.ci.sdk.cache.BDSrvInfoCache;
import iih.ci.sdk.cache.CiDeptInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 用法关联和煎法关联工具类
 * 
 * @author wangqingzhu
 *
 */
public class OrderSrvRefUtils {
	/**
	 * 用法关联费用信息，用法为医嘱层次，因此传入医嘱CiOrderDO
	 * 
	 * @param ctx
	 *            就诊上下文
	 * @param orderInfo
	 *            医嘱CiOrderDO
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvDO[] RouteRelFeeSrvs(CiEnContextDTO ctx, CiOrderDO orderInfo) throws BizException {

		UsageRelFeeSrvDO[] feeSrvDOs = getPriUsgRelFeeSrvInfo(orderInfo.getId_route(), orderInfo.getId_org(),
				ctx.getId_dep_ns());
		if (ObjectUtils.isEmpty(feeSrvDOs))
			return null;
		List<String> relSrvIds = new ArrayList<String>();
		for (UsageRelFeeSrvDO feeSrvDO : feeSrvDOs) {
			relSrvIds.add(feeSrvDO.getId_srv());
		}
		MedSrvDO[] relMedSrvs = CiOrdAppUtils.getMedsrvMDORService().findByBIds(relSrvIds.toArray(new String[0]),
				FBoolean.FALSE);
		// 将服务信息放到hash表中，方便后续查询使用
		Map<String, MedSrvDO> medSrvMap = new HashMap<String, MedSrvDO>();
		for (MedSrvDO srv : relMedSrvs) {
			medSrvMap.put(srv.getId_srv(), srv);
		}
		// 组装用法关联的费用信息
		List<OrdSrvDO> ordSrvs = new ArrayList<OrdSrvDO>();
		for (UsageRelFeeSrvDO feeSrvDO : feeSrvDOs) {
			if (ObjectUtils.isEmpty(feeSrvDO.getReltype())) {
				MedSrvDO srvInfo = BDSrvInfoCache.GetBdSrvInfo(null, feeSrvDO.getId_srv());
				throw new BizException(
						String.format("服务【%s】%s 关联类型为空！，请检查基础服务数据定义", srvInfo.getName(), srvInfo.getCode()));
			}
			MedSrvDO medSrvDO = medSrvMap.get(feeSrvDO.getId_srv());
			OrdSrvDO srvdo = new OrdSrvDO();
			srvdo.setId_or(orderInfo.getId_or());
			srvdo.setId_pat(ctx.getId_pat());
			srvdo.setId_entp(ctx.getId_entp());
			srvdo.setCode_entp(ctx.getCode_entp());
			srvdo.setId_en(ctx.getId_en());
			srvdo.setId_srvtp(medSrvDO.getId_srvtp());
			srvdo.setSd_srvtp(medSrvDO.getSd_srvtp());
			srvdo.setId_srv(feeSrvDO.getId_srv());
			srvdo.setName(medSrvDO.getName());
			srvdo.setFg_dose_anoma(FBoolean.FALSE);
			// //2016-11-14 修正原有的剂量及剂量单位逻辑 下面6行原有的代码注释掉了
			// //要注意的是服务单价是以BD_SRV中的医学单位定义的****计算单价时要考虑两者的单位转换
			// 服务关联时，是定值时实际上是有两层含义（总量定值法、单次定值法）：我们目前情况下是指总量定值法
			if (ObjectUtils.isTrue(feeSrvDO.getIsTotalQuanMd())) {// 2016-11-14
																	// 新增
																	// 服务关联总量模式的赋值逻辑
				srvdo.setQuan_medu(null);
				srvdo.setId_medu(feeSrvDO.getId_unit());
			} else {
				srvdo.setQuan_medu(feeSrvDO.getQuan_medu()); // 2016-06-22修改

				srvdo.setId_medu(feeSrvDO.getId_unit());
			}
			srvdo.setId_route(medSrvDO.getId_route());
			srvdo.setId_routedes(medSrvDO.getId_routedes());
			srvdo.setId_boil(medSrvDO.getId_boil());
			srvdo.setId_boildes(medSrvDO.getId_boildes());

			srvdo.setId_org_srv(CiOrdAppUtils.getEnvContext().getOrgId());
			srvdo.setId_dep_srv(CiOrdAppUtils.getEnvContext().getDeptId());
			srvdo.setId_emp_srv(CiOrdAppUtils.getEnvContext().getUserId());
			srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());
			srvdo.setId_org_mp(CiOrdAppUtils.getDeptQryService().findById(srvdo.getId_dep_mp()).getId_org());
			srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
			srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
			srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);

			ICiIpOrderMainService orderService = ServiceFinder.find(ICiIpOrderMainService.class);
			if (!ObjectUtils.isEmpty(orderService)) {
				srvdo.setDt_last_bl(orderService.getOrderLastDate4DtEffe(orderInfo.getId_freq(), orderInfo.getDt_effe(),
						orderInfo.getQuan_firday_mp(), orderInfo.getFg_long()));
			}

			srvdo.setFg_or(FBoolean.FALSE);
			srvdo.setEu_blmd(medSrvDO.getEu_blmd()); // 本服务定价
			srvdo.setFg_mm(FBoolean.FALSE);
			srvdo.setFg_set(FBoolean.FALSE);
			srvdo.setFg_propc(FBoolean.FALSE);
			srvdo.setFg_self(FBoolean.FALSE);
			srvdo.setFg_pres_outp(FBoolean.FALSE);
			srvdo.setNote_srv("");
			srvdo.setId_srvca(medSrvDO.getId_srvca());
			srvdo.setFg_bl(ObjectUtils.nullBoolean(medSrvDO.getFg_bl()));
			srvdo.setCode_srv(medSrvDO.getCode());
			srvdo.setEu_sourcemd(feeSrvDO.getReltype());
			srvdo.setId_primd(medSrvDO.getId_primd());
			srvdo.setFg_selfsrv(medSrvDO.getFg_ctm());
			srvdo.setId_srv_src(orderInfo.getId_srv());
			srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
			srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId());
			srvdo.setId_freq(orderInfo.getId_freq());
			srvdo.setSd_frequnitct(orderInfo.getSd_frequnitct());
			srvdo.setFreqct(orderInfo.getFreqct());
			srvdo.setFreq_name(orderInfo.getFreq_name());
			srvdo.setQuan_total_medu(OrderEmsQuanUtil.getQuan_cur(srvdo.getQuan_medu(), orderInfo.getTimes_cur()));
			// 折扣价和折扣系数
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(orderInfo.getCode_entp(), srvdo.getId_srv(),
					srvdo.getId_primd(), srvdo);
			// 执行科室赋值
			OrWfDeptInfoDTO wf = CiDeptInfoCache.GetOrWfDeptInfo(ctx, srvdo.getId_srv(), srvdo.getSd_srvtp(),
					srvdo.getId_srvca(),
					ObjectUtils.isTrue(BDFreqInfoCache.GetFgLongOfFreqInfo(orderInfo.getId_freq())),
					srvdo.getId_route(), null, orderInfo.getId_dep_mp(), orderInfo.getDt_effe(),
					orderInfo.getFg_pres_outp());
			if (wf != null) {
				srvdo.setId_dep_mp(wf.getFirstid_mp_dept());
				srvdo.setId_dep_wh(wf.getId_dept_wh());
			}
			srvdo.setFg_feertnable(FBoolean.TRUE);
			srvdo.setStatus(DOStatus.NEW);
			ordSrvs.add(srvdo);
		}
		return ordSrvs.toArray(new OrdSrvDO[0]);
	}

	/**
	 * 煎法关联费用信息，煎法为医嘱层次，因此传入医嘱CiOrderDO
	 * 
	 * @param ctx
	 * @param orderInfo
	 * @return
	 */
	public static OrdSrvDO[] BoilRelFeeSrvs(CiEnContextDTO ctx, CiOrderDO orderInfo) throws BizException {

		UsageRelFeeSrvDO[] feeSrvDOs = getPriBoilRelFeeSrvInfo(ctx.getId_org(), orderInfo.getId_boil(),
				orderInfo.getOrders_boil());
		if (ObjectUtils.isEmpty(feeSrvDOs))
			return null;
		List<String> relSrvIds = new ArrayList<String>();
		for (UsageRelFeeSrvDO feeSrvDO : feeSrvDOs) {
			relSrvIds.add(feeSrvDO.getId_srv());
		}
		MedSrvDO[] relMedSrvs = CiOrdAppUtils.getMedsrvMDORService().findByBIds(relSrvIds.toArray(new String[0]),
				FBoolean.FALSE);
		// 将服务信息放到hash表中，方便后续查询使用
		Map<String, MedSrvDO> medSrvMap = new HashMap<String, MedSrvDO>();
		for (MedSrvDO srv : relMedSrvs) {
			medSrvMap.put(srv.getId_srv(), srv);
		}
		// 组装用法关联的费用信息
		List<OrdSrvDO> ordSrvs = new ArrayList<OrdSrvDO>();
		for (UsageRelFeeSrvDO feeSrvDO : feeSrvDOs) {
			MedSrvDO medSrvDO = medSrvMap.get(feeSrvDO.getId_srv());
			OrdSrvDO srvdo = new OrdSrvDO();
			srvdo.setId_or(orderInfo.getId_or());
			srvdo.setId_pat(ctx.getId_pat());
			srvdo.setId_entp(ctx.getId_entp());
			srvdo.setCode_entp(ctx.getCode_entp());
			srvdo.setId_en(ctx.getId_en());
			srvdo.setId_srvtp(medSrvDO.getId_srvtp());
			srvdo.setSd_srvtp(medSrvDO.getSd_srvtp());
			srvdo.setId_srv(feeSrvDO.getId_srv());
			srvdo.setName(medSrvDO.getName());
			srvdo.setFg_dose_anoma(FBoolean.FALSE);
			srvdo.setId_wg_or(ctx.getId_org());
			// //2016-11-14 修正原有的剂量及剂量单位逻辑 下面6行原有的代码注释掉了
			// //要注意的是服务单价是以BD_SRV中的医学单位定义的****计算单价时要考虑两者的单位转换
			// 服务关联时，是定值时实际上是有两层含义（总量定值法、单次定值法）：我们目前情况下是指总量定值法
			if (ObjectUtils.isTrue(feeSrvDO.getIsTotalQuanMd())) {// 2016-11-14
																	// 新增
																	// 服务关联总量模式的赋值逻辑
				srvdo.setQuan_medu(null);
				srvdo.setId_medu(feeSrvDO.getId_unit());
			} else {
				srvdo.setQuan_medu(feeSrvDO.getQuan_medu()); // 2016-06-22修改

				srvdo.setId_medu(feeSrvDO.getId_unit());
			}
			srvdo.setId_route(medSrvDO.getId_route());
			srvdo.setId_routedes(medSrvDO.getId_routedes());
			srvdo.setId_boil(medSrvDO.getId_boil());
			srvdo.setId_boildes(medSrvDO.getId_boildes());

			srvdo.setId_org_srv(CiOrdAppUtils.getEnvContext().getOrgId());
			srvdo.setId_dep_srv(CiOrdAppUtils.getEnvContext().getDeptId());
			srvdo.setId_emp_srv(ctx.getId_emp_or());
			srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());
			DeptDO do1 = CiOrdAppUtils.getDeptQryService().findById(srvdo.getId_dep_mp());
			if (!ObjectUtils.isEmpty(do1)) {
				srvdo.setId_org_mp(do1.getId_org());
			}

			srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
			srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
			srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);

			ICiIpOrderMainService orderService = ServiceFinder.find(ICiIpOrderMainService.class);
			srvdo.setDt_last_bl(orderService.getOrderLastDate4DtEffe(orderInfo.getId_freq(), orderInfo.getDt_effe(),
					orderInfo.getQuan_firday_mp(), orderInfo.getFg_long()));
			srvdo.setFg_or(FBoolean.FALSE);
			srvdo.setEu_blmd(medSrvDO.getEu_blmd()); // 本服务定价
			srvdo.setFg_mm(FBoolean.FALSE);
			srvdo.setFg_set(FBoolean.FALSE);
			srvdo.setFg_propc(FBoolean.FALSE);
			srvdo.setFg_self(FBoolean.FALSE);
			srvdo.setFg_pres_outp(FBoolean.FALSE);
			srvdo.setNote_srv("");
			srvdo.setId_srvca(medSrvDO.getId_srvca());
			srvdo.setFg_bl(ObjectUtils.nullBoolean(medSrvDO.getFg_bl()));
			srvdo.setCode_srv(medSrvDO.getCode());
			srvdo.setEu_sourcemd(feeSrvDO.getReltype());
			srvdo.setId_primd(medSrvDO.getId_primd());
			srvdo.setFg_selfsrv(medSrvDO.getFg_ctm());
			srvdo.setId_srv_src(orderInfo.getId_srv());
			srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
			srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId());
			srvdo.setId_freq(orderInfo.getId_freq());
			srvdo.setSd_frequnitct(orderInfo.getSd_frequnitct());
			srvdo.setFreqct(orderInfo.getFreqct());
			srvdo.setFreq_name(orderInfo.getFreq_name());
			srvdo.setQuan_total_medu(OrderEmsQuanUtil.getQuan_cur(srvdo.getQuan_medu(), orderInfo.getOrders()));
			// 折扣价和折扣系数
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(orderInfo.getCode_entp(), srvdo.getId_srv(),
					srvdo.getId_primd(), srvdo);
			// 执行科室赋值
			OrWfDeptInfoDTO wf = CiDeptInfoCache.GetOrWfDeptInfo(ctx, srvdo.getId_srv(), srvdo.getSd_srvtp(),
					srvdo.getId_srvca(),
					ObjectUtils.isTrue(BDFreqInfoCache.GetFgLongOfFreqInfo(orderInfo.getId_freq())),
					srvdo.getId_route(), srvdo.getId_dep_mp(), orderInfo.getId_dep_mp(), orderInfo.getDt_effe(),
					orderInfo.getFg_pres_outp());
			if (wf != null) {
				srvdo.setId_dep_mp(wf.getFirstid_mp_dept());
				srvdo.setId_dep_wh(wf.getId_dept_wh());
			}
			srvdo.setFg_feertnable(FBoolean.TRUE);
			srvdo.setStatus(DOStatus.NEW);
			ordSrvs.add(srvdo);
		}
		return ordSrvs.toArray(new OrdSrvDO[0]);
	}

	/**
	 * 获得用法对应的费用集合
	 * 
	 * @param id_route
	 * @param id_scope_rel
	 * @param isscopedept是否科室范围
	 * @return
	 * @throws BizException
	 */
	public static UsageRelFeeSrvDO[] getPriUsgRelFeeSrvInfo(String id_route, String id_scope_org, String id_scope_dept)
			throws BizException {
		String tbaliasname = PriUsgDODesc.TABLE_ALIAS_NAME;
		if (id_route == null || id_route == "")
			return null;
		String condstr = getCondStr(tbaliasname, id_scope_org, id_scope_dept);
		PriUsgDO[] do1 = CiOrdAppUtils.getPriusgRService().find(tbaliasname + ".id_route='" + id_route + "'" + condstr,
				"eu_scope,sortno", FBoolean.FALSE);
		if (do1 == null || do1.length == 0) {
			// Logger.info("用法【"+id_route+"】未关联费用项目。");
			return null;
		}

		ArrayList<UsageRelFeeSrvDO> list = new ArrayList<UsageRelFeeSrvDO>();
		int iN = do1.length, imatch = 0;
		if (ScopeEnum.INPATIENTAREA.equals(do1[iN - 1].getEu_scope())) {
			imatch = 1;
		}
		for (int i = 0; i < iN; i++) {
			if (imatch == do1[i].getEu_scope()) {
				list.add(getUsageRelFeeSrv(do1[i]));
			}
		}
		return (UsageRelFeeSrvDO[]) list.toArray((UsageRelFeeSrvDO[]) Array.newInstance(UsageRelFeeSrvDO.class, 0));
	}

	private static UsageRelFeeSrvDO getUsageRelFeeSrv(PriUsgDO usgdo) {
		UsageRelFeeSrvDO rtn = new UsageRelFeeSrvDO();
		rtn.setId_srv(usgdo.getId_srv());
		rtn.setId_unit(usgdo.getId_unit());
		rtn.setQuan_medu(usgdo.getQuan_medu());
		rtn.setReltype(OrSrvSourceFromEnum.USAGERELFEE);
		return rtn;
	}

	/**
	 * 获得用法对应的费用条件串
	 * 
	 * @param tbaliasname
	 * @param id_scope_org
	 * @param id_scope_dept
	 * @return
	 */
	private static String getCondStr(String tbaliasname, String id_scope_org, String id_scope_dept) {
		String deptid = "";
		String orgid = tbaliasname + ".eu_scope=" + IBdSrvDictCodeConst.SD_OWTP_HOSPIAL + " and " + tbaliasname
				+ ".id_org_scope='" + id_scope_org + "'";
		if (!ObjectUtils.isEmpty(id_scope_dept)) {
			deptid = "(" + orgid + " and " + tbaliasname + ".id_dep_nur='" + id_scope_dept + "')";
			return " and (" + orgid + " or " + deptid + ") ";
		} else {
			return " and " + orgid;
		}
	}

	/**
	 * 获得代煎对应的费用集合
	 * 
	 * @param id_org
	 * @param id_boil
	 * @param quan_boil
	 * @return
	 * @throws BizException
	 */
	public static UsageRelFeeSrvDO[] getPriBoilRelFeeSrvInfo(String id_org, String id_boil, Integer quan_boil)
			throws BizException {
		String tblaliasname = BdPriBoilDODesc.TABLE_ALIAS_NAME;
		String whereStr = tblaliasname + "." + BdPriBoilDO.ID_BOIL + "='" + id_boil + "' and " + tblaliasname + "."
				+ BdPriBoilDO.ID_ORG + "='" + id_org + "' ";
		BdPriBoilDO[] boilpris = CiOrdAppUtils.getIBdpriboilRService().find(whereStr, "", FBoolean.FALSE);
		if (ObjectUtils.isEmpty(boilpris)) {
			return null;
		}
		UsageRelFeeSrvDO[] rtn = new UsageRelFeeSrvDO[boilpris.length];
		int i = 0;
		for (BdPriBoilDO bdPriBoilInfo : boilpris) {
			MedSrvDO srvdo = CiOrdAppUtils.getMedsrvMDORService().findById(bdPriBoilInfo.getId_srv());

			UsageRelFeeSrvDO feesrv = new UsageRelFeeSrvDO();
			feesrv.setId_srv(bdPriBoilInfo.getId_srv());
			feesrv.setId_unit(bdPriBoilInfo.getId_unit_med());
			feesrv.setQuan_medu(bdPriBoilInfo.getQuan_medu().multiply(srvdo.getQuan_med()));
			feesrv.setReltype(OrSrvSourceFromEnum.BOILRELFEE);

			rtn[i++] = feesrv;

		}
		return rtn;

	}
}
