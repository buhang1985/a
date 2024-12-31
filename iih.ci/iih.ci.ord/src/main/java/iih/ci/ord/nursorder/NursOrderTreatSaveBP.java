package iih.ci.ord.nursorder;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.PharmVerifyStatusEnum;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.bp.ems.save.ip.CiOrDtLastBlCal4OpenBP;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.utils.CiOrFgMpInDefaltUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

public class NursOrderTreatSaveBP {
	private GetTotalTimesBP totalTimesUtils = new GetTotalTimesBP();
	private CalQuantumBP quantumUtils = new CalQuantumBP();
	public EmsRstDTO save(CiEnContextDTO ctx,CiOrderDO order) throws BizException {
		CiorderAggDO aggdo = new CiorderAggDO();
		MedSrvDO medsrv = getMedSrv(order.getId_srv());
		// 创建医嘱信息
		CiOrderDO orderInfo = createOrderInfo(ctx, order,medsrv);
		// 创建主服务
		OrdSrvDO mainSrvInfo = createOrderSrvInfo(ctx, order,medsrv);
		aggdo.setParentDO(orderInfo);
		aggdo.setOrdSrvDO(new OrdSrvDO[]{mainSrvInfo});
		ICiorderCudService orservice=CiOrdAppUtils.getOrAggService();
		CiorderAggDO[] szRstOrdAggInfo=orservice.save(new CiorderAggDO[]{aggdo});
		EmsRstDTO rst = new EmsRstDTO();
		FArrayList rstList = new FArrayList();
		rstList.add(szRstOrdAggInfo[0]);
		rst.setDocument(rstList);
		return rst;
	}
	/**
	 * 查询服务信息
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO getMedSrv(String id_srv) throws BizException {
		return ServiceFinder.find(IMedsrvMDORService.class).findById(id_srv);
	}

	/**
	 * 医嘱主do映射
	 * 
	 * @param medsrv
	 * @param ctx
	 * @param mmdo
	 * @return
	 * @throws BizException
	 */
	protected CiOrderDO createOrderInfo(CiEnContextDTO ctx, CiOrderDO order,MedSrvDO medsrv) throws BizException {

		CiOrderDO ciorderdo = new CiOrderDO();
		ciorderdo.setId_grp(ctx.getId_grp());
		ciorderdo.setId_org(ctx.getId_org());
		ciorderdo.setId_pat(ctx.getId_pat());
		ciorderdo.setId_en(ctx.getId_en());
		ciorderdo.setId_entp(ctx.getId_entp());
		ciorderdo.setCode_entp(ctx.getCode_entp());
		ciorderdo.setId_srvtp(medsrv.getId_srvtp());
		ciorderdo.setSd_srvtp(medsrv.getSd_srvtp());
		ciorderdo.setId_srv(medsrv.getId_srv());
		ciorderdo.setFg_set(medsrv.getFg_set());
		ciorderdo.setDt_effe(order.getDt_effe());
		ciorderdo.setDt_end(order.getDt_end());
		// ciorderdo.setId_srv_pkg("");//--
		ciorderdo.setFg_long(CiOrdUtils.nullHandle(medsrv.getFg_long()));
//		ciorderdo.setCode_or(
//				CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
		ciorderdo.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());
		ciorderdo.setName_or(medsrv.getName());
		ciorderdo.setContent_or(CiOrContentUtils
				.create(medsrv.getSd_srvtp(), medsrv.getName(), medsrv.getRoute_name(), FBoolean.FALSE).toString());
		ciorderdo.setDes_or(order.getDes_or());
		ciorderdo.setId_freq(order.getId_freq());
		ciorderdo.setSd_frequnitct(order.getSd_frequnitct());
		ciorderdo.setFrequnitct(order.getFrequnitct());
		ciorderdo.setFreqct(order.getFreqct());
		ciorderdo.setFreq_name(order.getFreq_name());
		ciorderdo.setOrders(0);// 医嘱付数，前台传入
		ciorderdo.setFg_boil(FBoolean.FALSE);// 代煎标识
		ciorderdo.setOrders_boil(0);// 代煎付数，前台传入
		ciorderdo.setId_dep_mp(order.getId_dep_mp());
		ciorderdo.setId_route(order.getId_route());
		ciorderdo.setId_routedes(medsrv.getId_routedes());
		ciorderdo.setId_boil(medsrv.getId_boil());
		ciorderdo.setId_boildes(medsrv.getId_boildes());
		ciorderdo.setDays_or(1);// 医嘱天数，前台传入
		ciorderdo.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
		ciorderdo.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
		ciorderdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		ciorderdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		ciorderdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		ciorderdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		ciorderdo.setId_org_or(ctx.getId_org());
		ciorderdo.setId_dep_or(ctx.getId_dep_or());
		ciorderdo.setId_wg_or(ctx.getId_wg_or());
		ciorderdo.setId_emp_or(ctx.getId_emp_or());
		ciorderdo.setDt_entry(CiOrdAppUtils.getServerDateTime());
		ciorderdo.setFg_sign(FBoolean.TRUE);
		ciorderdo.setDt_invalid(OrderUtils.getDtInvalid(ctx,ciorderdo.getDt_entry()));
		ciorderdo.setFg_chk(CiOrdUtils.nullHandle(null));
		if (FBoolean.TRUE.equals(medsrv.getFg_long()) && ciorderdo.getDt_end() != null
				&& CiOrdUtils.MAX_SYS_DATETIME.after(ciorderdo.getDt_end())) {
			ciorderdo.setFg_stop(FBoolean.TRUE);
			ciorderdo.setId_emp_stop(ctx.getId_emp_or());
			ciorderdo.setId_dep_stop(ctx.getId_dep_or());
			ciorderdo.setDt_stop(ciorderdo.getDt_entry());
		}
		ciorderdo.setFg_chk_stop(CiOrdUtils.nullHandle(null));
		ciorderdo.setFg_canc(CiOrdUtils.nullHandle(null));
		ciorderdo.setFg_chk_canc(CiOrdUtils.nullHandle(null));
		ciorderdo.setFg_pmor(FBoolean.FALSE);
		ciorderdo.setFg_bb(CiOrdUtils.nullHandle(ctx.getFg_bb()));
		ciorderdo.setNo_bb(ctx.getNo_bb());

		ciorderdo.setTimes_cur(totalTimesUtils.getTotalTimes(ciorderdo.getDt_effe(),ciorderdo.getId_freq(), order.getDays_or()));// 总次数
		ciorderdo.setFg_mp_in(CiOrFgMpInDefaltUtils.GetDefaultFg_mp_in(ctx.getCode_entp(), ciorderdo.getSd_srvtp(),
				ciorderdo.getId_route(), null));
		if (FBoolean.TRUE.equals(ciorderdo.getFg_mp_in())) {
			ciorderdo.setTimes_mp_in(1);
		}
		if (CiOrdUtils.isPharmacy(medsrv.getSd_srvtp())) {
			ciorderdo.setEu_verify_pharm(PharmVerifyStatusEnum.UNAUDIT);
		}
		ciorderdo.setId_orpltp(OrderUtils.getOrCLoopTpId(ciorderdo));
		ciorderdo.setId_srvca(medsrv.getId_srvca());
		ciorderdo.setId_unit_med(medsrv.getId_unit_med());
		ciorderdo.setQuan_medu(order.getQuan_medu());
		ciorderdo.setInnercode_srvca(medsrv.getSrvca_innercode());
		ciorderdo.setFg_uncancelable(FBoolean.FALSE);
		ciorderdo.setFg_feertnable(FBoolean.TRUE);
		ciorderdo.setDt_last_bl(ciorderdo.getDt_effe());
		ciorderdo.setEu_orsrcmdtp(ctx.getEu_orsrcmdtp());
		ciorderdo.setBhpjudgerst(ctx.getBhpjudgerst());
		ciorderdo.setDes_bhpjudgerst(ctx.getDes_bhpjudgerst());
		ciorderdo.setFg_vip(ctx.getFg_gcvip());
		
		
		AuditInfoUtil.addData(ciorderdo);// 设置设计信息
		ciorderdo.setStatus(DOStatus.NEW);

		return ciorderdo;
	}
	/**
	 * 医嘱服务映射
	 * 
	 * @param medsrv
	 * @param ctx
	 * @param mmdo
	 * @return
	 * @throws BizException
	 */
	protected OrdSrvDO createOrderSrvInfo(CiEnContextDTO ctx, CiOrderDO order,MedSrvDO medsrv) throws BizException {
		OrdSrvDO srvdo = new OrdSrvDO();
		srvdo.setId_grp(ctx.getId_grp());
		srvdo.setId_org(ctx.getId_org());
		srvdo.setId_pat(ctx.getId_pat());
		srvdo.setId_entp(ctx.getId_entp());
		srvdo.setCode_entp(ctx.getCode_entp());
		srvdo.setId_en(ctx.getId_en());
		srvdo.setSortno(0);
		srvdo.setId_srvtp(medsrv.getId_srvtp());
		srvdo.setSd_srvtp(medsrv.getSd_srvtp());
		srvdo.setId_srv(medsrv.getId_srv());
		srvdo.setName(medsrv.getName());
		srvdo.setFg_dose_anoma(null);
		srvdo.setQuan_medu(order.getQuan_medu());
		srvdo.setId_medu(order.getId_unit_med());
		srvdo.setId_route(order.getId_route());
		srvdo.setId_routedes(order.getId_routedes());
		srvdo.setId_boil(medsrv.getId_boil());
		srvdo.setId_boildes(medsrv.getId_boildes());
		srvdo.setId_freq(medsrv.getId_freq());
		srvdo.setId_org_srv(ctx.getId_org());
		srvdo.setId_dep_srv(ctx.getId_dep_or());
		srvdo.setId_wg_or(ctx.getId_wg_or());
		srvdo.setId_emp_srv(ctx.getId_emp_or());
		srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());

		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setQuan_total_medu(
				this.quantumUtils.getUnMMQuantum(order.getDt_effe(),srvdo.getId_freq(), order.getDays_or(), srvdo.getQuan_medu()));// 计算服务总量
		srvdo.setFg_or(medsrv.getFg_or());
		srvdo.setEu_blmd(medsrv.getEu_blmd());
		srvdo.setFg_mm(CiOrdUtils.nullHandle(medsrv.getFg_mm()));
		CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ctx.getCode_entp(), medsrv.getId_srv(), medsrv.getId_primd(),
				srvdo);
		srvdo.setFg_set(CiOrdUtils.nullHandle(medsrv.getFg_set()));
		srvdo.setNote_srv(medsrv.getDes());
		srvdo.setId_srvca(medsrv.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(medsrv.getFg_bl()));
		srvdo.setCode_srv(medsrv.getCode());
		srvdo.setId_primd(medsrv.getId_primd());
		if (CiOrdUtils.isTrue(srvdo.getFg_skintest())) {
			srvdo.setSd_reltp(IBdSrvDictCodeConst.SD_RELORDTYPE_SKIN);
		} 
		srvdo.setDt_last_bl(order.getDt_last_bl());
		srvdo.setFg_selfsrv(medsrv.getFg_ctm());
		srvdo.setId_hp(ctx.getId_hp());// 2016-07-12新增医保相关信息
		srvdo.setFg_feertnable(FBoolean.TRUE); // 可退费标识
		srvdo.setStatus(DOStatus.NEW);
		return srvdo;

	}
	private FDateTime getLastDt(String id_freq, FDateTime dt_effe,
			Integer firstdaytimes,FBoolean fg_long) throws BizException {
		CiOrDtLastBlCal4OpenBP bp = new CiOrDtLastBlCal4OpenBP();
		return bp.exec(id_freq, dt_effe, firstdaytimes,fg_long);
	}
}
