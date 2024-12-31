package iih.ci.ord.s.ems.third.def;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.PharmVerifyStatusEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrSrvPriCalGetBP;
import iih.ci.ord.s.bp.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.OrederPriCalParam;
import iih.ci.ord.s.ems.third.base.OrderPakageInfo;
import iih.ci.ord.s.ems.utils.CiOrFgMpInDefaltUtils;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

/**
 * 默认医嘱生成 -- 基类
 * 
 * @author zhangwanqing
 *
 */
public class DefaultBaseCreateOrderInfo {


	public OrderPakageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam)
			throws BizException {
		List<OrderPakageInfo> listOrderPakageInfo = new ArrayList<OrderPakageInfo>();
		for (DefaultCreateParam param : szParam){
			// 新建 医嘱聚合结构Agg
			CiorderAggDO aggdo = new CiorderAggDO();
			
			// 查询服务信息
			MedsrvAggDO[] szMedsrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findByIds(param.getSzId_srv(), FBoolean.FALSE);
			if (CiOrdUtils.isEmpty(szMedsrvAggInfo)){
				return null;
			}
			
			OrderPakageInfo orderPakageInfo = new OrderPakageInfo();
			orderPakageInfo.setUiModel(param.getUiModel());
			
			MedSrvDO medsrv = szMedsrvAggInfo[0].getParentDO();
			// 创建医嘱信息
			CiOrderDO orderInfo = createOrderInfo(ctx,medsrv);
			aggdo.setParentDO(orderInfo);
			// 获得医嘱服务do
			List<OrdSrvDO> listOrdSrvDO = new ArrayList<OrdSrvDO>();
			
			// 创建主服务
			OrdSrvDO mainSrvInfo = createOrderSrvInfo(ctx,medsrv,null);
			// 计算执行科室和填充医嘱主服务信息
			handleOrderMainSrvInfo(ctx, orderInfo, mainSrvInfo,null);
			listOrdSrvDO.add(mainSrvInfo);
			
			for (int index = 1; index < szMedsrvAggInfo.length; ++index){		
				OrdSrvDO srvInfo = createOrderSrvInfo(ctx,szMedsrvAggInfo[index].getParentDO(),null);
				// 处理项目的执行科室和物资流向科室
				handleMpWhDeptInfo(ctx,orderInfo.getId_dep_mp(),srvInfo,null,orderInfo.getFg_long());
				listOrdSrvDO.add(srvInfo);
			}
			// 获得医嘱服务do
			aggdo.setOrdSrvDO(listOrdSrvDO.toArray(new OrdSrvDO[listOrdSrvDO.size()]));
			
			orderPakageInfo.setOrderAggInfo(aggdo);
			
			listOrderPakageInfo.add(orderPakageInfo);
		}
		return listOrderPakageInfo.toArray(new OrderPakageInfo[listOrderPakageInfo.size()]);
	}

	protected int nUseDays = 1;
	/**
	 * 总量计算逻辑
	 */
	private CalQuantumBP quantumUtils = new CalQuantumBP();
	/**
	 * 医嘱总次数计算逻辑
	 */
	private GetTotalTimesBP totalTimesUtils = new GetTotalTimesBP();

	/**
	 * 计算总量工具
	 * 
	 * @return
	 */
	public CalQuantumBP getQuantumUtils() {
		return quantumUtils;
	}

	/**
	 * 医嘱总次数计算逻辑
	 * 
	 * @return
	 */
	public GetTotalTimesBP getTotalTimesUtils() {
		return totalTimesUtils;
	}

	/**
	 * 
	 * @param ctx
	 * @param id_srv
	 * @param id_mm
	 * @return
	 * @throws BizException
	 */
	public OrderPakageInfo[] createOrdeAggInfo(CiEnContextDTO ctx, String[] szId_srv, String[] szId_mm,
			List<Object> listExtParam) throws BizException {
		return null;
	}
	/**
	 * 批量创建默认医嘱
	 * 
	 * @param id_srv
	 * @param id_mm
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public CiorderAggDO getDefaultCiordeAggDO(String[] id_srv, String[] id_mm, CiEnContextDTO ctx) throws BizException {
		return null;
	}

	public OrderPakageInfo[] createOrdeAggInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		List<OrderPakageInfo> listOrderPakageInfo = new ArrayList<OrderPakageInfo>();
		for (DefaultCreateParam param : szParam) {
			// 新建 医嘱聚合结构Agg
			CiorderAggDO aggdo = new CiorderAggDO();
			// 查询服务信息
			MedsrvAggDO[] szMedsrvAggInfo = CiOrdAppUtils.getIMedSrvExtRService().FindByIdsAndLength(param.getSzId_srv(), FBoolean.FALSE);
			if (CiOrdUtils.isEmpty(szMedsrvAggInfo)) {
				return null;
			}

			OrderPakageInfo orderPakageInfo = new OrderPakageInfo();
			orderPakageInfo.setUiModel(param.getUiModel());

			MedSrvDO medsrv = szMedsrvAggInfo[0].getParentDO();
			//第三方医技补录频次必须为once，临时
			medsrv.setFg_long(FBoolean.FALSE);
			medsrv.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			medsrv.setSd_frequnitct(IBdSrvDictCodeConst.CODE_FREQNUNITCT_ITEM_ONCE);
			medsrv.setFrequnitct(1);
			// 创建医嘱信息
			CiOrderDO orderInfo = createOrderInfo(ctx, medsrv);
			aggdo.setParentDO(orderInfo);
			// 获得医嘱服务do
			List<OrdSrvDO> listOrdSrvDO = new ArrayList<OrdSrvDO>();

			// 创建主服务
			OrdSrvDO mainSrvInfo = createOrderSrvInfo(ctx, medsrv, this.getId_mm(param.getSzId_mm(), 0));
			// 计算执行科室和填充医嘱主服务信息
			handleOrderMainSrvInfo(ctx, orderInfo, mainSrvInfo, null);
			listOrdSrvDO.add(mainSrvInfo);

			for (int index = 1; index < szMedsrvAggInfo.length; ++index) {
				OrdSrvDO srvInfo = createOrderSrvInfo(ctx, szMedsrvAggInfo[index].getParentDO(),this.getId_mm(param.getSzId_mm(), 0));
				// 处理项目的执行科室和物资流向科室
				handleMpWhDeptInfo(ctx, orderInfo.getId_dep_mp(), srvInfo, this.getId_mm(param.getSzId_mm(), 0),medsrv.getFg_long());
				listOrdSrvDO.add(srvInfo);
			}
			// 获得医嘱服务do
			aggdo.setOrdSrvDO(listOrdSrvDO.toArray(new OrdSrvDO[listOrdSrvDO.size()]));

			orderPakageInfo.setOrderAggInfo(aggdo);

			listOrderPakageInfo.add(orderPakageInfo);
		}
		return listOrderPakageInfo.toArray(new OrderPakageInfo[listOrderPakageInfo.size()]);
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
	protected CiOrderDO createOrderInfo(CiEnContextDTO ctx, MedSrvDO medsrv) throws BizException {

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
		// ciorderdo.setId_srv_pkg("");//--
		ciorderdo.setFg_long(CiOrdUtils.nullHandle(medsrv.getFg_long()));
//		ciorderdo.setCode_or(
//				CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
		ciorderdo.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());
		ciorderdo.setName_or(medsrv.getName());
		ciorderdo.setContent_or(CiOrContentUtils
				.create(medsrv.getSd_srvtp(), medsrv.getName(), medsrv.getRoute_name(), FBoolean.FALSE).toString());
		ciorderdo.setDes_or(medsrv.getDes());
		ciorderdo.setId_freq(medsrv.getId_freq());
		ciorderdo.setSd_frequnitct(medsrv.getSd_frequnitct());
		ciorderdo.setFrequnitct(medsrv.getFrequnitct());
		ciorderdo.setFreqct(medsrv.getFreqct());
		ciorderdo.setFreq_name(medsrv.getFreq_name());
		ciorderdo.setOrders(null);// 医嘱付数，前台传入
		ciorderdo.setFg_boil(FBoolean.FALSE);// 代煎标识
												// CiOrdUtils.nullHandle(medsrv.getFg_boil())
		ciorderdo.setOrders_boil(0);// 代煎付数，前台传入
		ciorderdo.setId_route(medsrv.getId_route());
		ciorderdo.setId_routedes(medsrv.getId_routedes());
		ciorderdo.setId_boil(medsrv.getId_boil());
		ciorderdo.setId_boildes(medsrv.getId_boildes());
		ciorderdo.setDays_or(1);// 医嘱天数，前台传入
		ciorderdo.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
		ciorderdo.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
		ciorderdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		ciorderdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		ciorderdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		ciorderdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		ciorderdo.setId_org_or(ctx.getId_org());
		ciorderdo.setId_dep_or(ctx.getId_dep_or());
		ciorderdo.setId_wg_or(ctx.getId_wg_or());
		ciorderdo.setId_emp_or(ctx.getId_emp_or());
		ciorderdo.setDt_entry(CiOrdAppUtils.getServerDateTime());
		ciorderdo.setFg_sign(CiOrdUtils.nullHandle(null));
		//开单病区
		ciorderdo.setId_dep_nur_or(ctx.getId_dep_ns());
		// ciorderdo.setId_emp_sign();
		// ciorderdo.setId_dep_sign();
		// ciorderdo.setDt_sign();
		// FDateTime[] dtSE = OrderUtils.getDtBeginEnd(ctx);
		// ciorderdo.setDt_effe(dtSE[0]);
		// ciorderdo.setDt_end(dtSE[1]);
		ciorderdo.setDt_invalid(OrderUtils.getDtInvalid(ctx,ciorderdo.getDt_entry()));
		ciorderdo.setFg_chk(CiOrdUtils.nullHandle(null));
		// ciorderdo.setId_emp_chk();
		// ciorderdo.setId_dep_chk();
		// ciorderdo.setDt_chk();
		if (FBoolean.TRUE.equals(medsrv.getFg_long()) && ciorderdo.getDt_end() != null
				&& CiOrdUtils.MAX_SYS_DATETIME.after(ciorderdo.getDt_end())) {
			ciorderdo.setFg_stop(FBoolean.TRUE);
			ciorderdo.setId_emp_stop(ctx.getId_emp_or());
			ciorderdo.setId_dep_stop(ctx.getId_dep_or());
			ciorderdo.setDt_stop(ciorderdo.getDt_entry());
		}
		ciorderdo.setFg_chk_stop(CiOrdUtils.nullHandle(null));
		// ciorderdo.setId_emp_chk_stop();
		// ciorderdo.setId_dep_chk_stop();
		// ciorderdo.setDt_chk_stop();
		ciorderdo.setFg_canc(CiOrdUtils.nullHandle(null));
		// ciorderdo.setId_emp_canc();
		// ciorderdo.setId_dep_canc();
		// ciorderdo.setDt_canc();
		ciorderdo.setFg_chk_canc(CiOrdUtils.nullHandle(null));
		// ciorderdo.setId_emp_chk_canc();
		// ciorderdo.setId_dep_chk_canc();
		// ciorderdo.setDt_chk_canc();
		ciorderdo.setFg_pmor(FBoolean.FALSE);
		// ciorderdo.setDes_pmor(medsrv.getDes_pmor());
		// ciorderdo.setFg_active_pm(CiOrdUtils.nullHandle(medsrv.getFg_active_pm()));
		// ciorderdo.setId_reltp(medsrv.getId_reltp());
		// ciorderdo.setSd_reltp(medsrv.getId_reltp());
		// ciorderdo.setId_or_rel(medsrv.getId_or_rel());
		ciorderdo.setFg_bb(CiOrdUtils.nullHandle(ctx.getFg_bb()));
		ciorderdo.setNo_bb(ctx.getNo_bb());
		// ciorderdo.setFg_ctlcp(CiOrdUtils.nullHandle(medsrv.getFg_ctlcp()));
		// ciorderdo.setFg_mr(CiOrdUtils.nullHandle(medsrv.getFg_mr()));

		ciorderdo.setTimes_cur(getTotalTimesUtils().getTotalTimes(ciorderdo.getDt_effe(),ciorderdo.getId_freq(), nUseDays));// 总次数
		ciorderdo.setFg_mp_in(CiOrFgMpInDefaltUtils.GetDefaultFg_mp_in(ctx.getCode_entp(), ciorderdo.getSd_srvtp(),
				ciorderdo.getId_route(), null));
		if (FBoolean.TRUE.equals(ciorderdo.getFg_mp_in())) {
			ciorderdo.setTimes_mp_in(1);
		}
		// ciorderdo.setFg_mp_bed(CiOrdUtils.nullHandle(medsrv.getFg_mp_bed()));
		// ciorderdo.setNote_or(medsrv.getNote());//--
		// ciorderdo.setCreatedby();
		// ciorderdo.setCreatedtime();
		// ciorderdo.setModifiedby();
		// ciorderdo.setModifiedtime();
		if (CiOrdUtils.isPharmacy(medsrv.getSd_srvtp())) {
			ciorderdo.setEu_verify_pharm(PharmVerifyStatusEnum.UNAUDIT);
		}
		// ciorderdo.setDes_verify_phar();
		// ciorderdo.setId_ecep_level_pharm();
		// ciorderdo.setSd_excep_level_pharm();
		// ciorderdo.setDes_verify_sys();
		// ciorderdo.setId_ecep_level_sys();
		// ciorderdo.setSd_excep_level_sys();
		// ciorderdo.setId_emp_verify_sys();
		// ciorderdo.setDt_verify_pharm();
		// ciorderdo.setDes_bk_pharm();
		// ciorderdo.setDt_bk_pharm();
		// ciorderdo.setId_emp_bk_pharm();
		// ciorderdo.setFg_pkg();
		// ciorderdo.setStr_long();//废弃不用的字段
		// ciorderdo.setQuan_firday_mp(Integer.parseInt(medsrv.getFirst_freq()));//首日执行次数，前台带回
		// ciorderdo.setFg_or_form();//医嘱单标识
		// ciorderdo.setId_skintest_skip_reason();//废弃不用的字段
		// ciorderdo.setSd_skintest_skip_reason();//废弃不用的字段
		// ciorderdo.setFg_pres_outp(CiOrdUtils.nullHandle(medsrv.getFg_outp()));//出院带药
		// ciorderdo.setFuncclassstr(medsrv.getFuncclassstr());//医疗单url
		// ciorderdo.setId_srvof(medsrv.getId_srvof());//医疗单
		// ciorderdo.setFg_quickwflow(medsrv.getFg_quickwflow());
		// ciorderdo.setApplyno(medsrv.getApplyno());//申请单号
		// ciorderdo.setDt_last_bl(
		// OrderUtils.getLastDt(ciorderdo.getId_freq(), ciorderdo.getDt_effe(),
		// 0, ciorderdo.getFg_long()));
		// ciorderdo.setFg_urgent(srvInfo.getFg_urgent());//加急
		// ciorderdo.setOrd_colligate(); //医嘱综合状态
		// ciorderdo.setAmount(); //金额
		// ciorderdo.setResult();//废弃不用的字段
		ciorderdo.setId_orpltp(OrderUtils.getOrCLoopTpId(ciorderdo));
		ciorderdo.setId_srvca(medsrv.getId_srvca());
		// ciorderdo.setTimes_cur(medsrv.getTimes_cur());//次数
		// ciorderdo.setId_orrsttp();//医嘱结果
		// ciorderdo.setSd_orrsttp();
		// ciorderdo.setId_dep_mp(medsrv.getId_dep());
		// ciorderdo.setDt_last_mp(dtSE[0]);
		ciorderdo.setId_unit_med(medsrv.getId_unit_med());
		ciorderdo.setQuan_medu(medsrv.getQuan_med());
		ciorderdo.setInnercode_srvca(medsrv.getSrvca_innercode());
		ciorderdo.setFg_uncancelable(FBoolean.FALSE);
		// ciorderdo.setEu_hpindicjudge();
		// ciorderdo.setEu_uncpordoctorjudge();
		// ciorderdo.setEu_uncporjudge(medsrv.getEu_uncporjudge());//???
		// ciorderdo.setReason_uncporuse();
		// ciorderdo.setPurpose_or(medsrv.getPurpose_or());//???
		// ciorderdo.setFg_flush2mr();
		ciorderdo.setFg_feertnable(FBoolean.TRUE);

		ciorderdo.setEu_orsrcmdtp(ctx.getEu_orsrcmdtp());
		// ciorderdo.setId_orsrc_main(medsrv.getId_orsrc_main()); //???
		// ciorderdo.setId_orsrc_sub(medsrv.getId_orsrc_sub());//???
		// ciorderdo.setId_orsrc_subsub(medsrv.getId_orsrc_subsub()); //???
		ciorderdo.setBhpjudgerst(ctx.getBhpjudgerst());
		ciorderdo.setDes_bhpjudgerst(ctx.getDes_bhpjudgerst());
		ciorderdo.setFg_vip(ctx.getFg_gcvip());
		// ciorderdo.setFg_prepay();
		// ciorderdo.setFg_orhp();
		// ciorderdo.setEu_feereversetp();
		// ciorderdo.setMdicalinfo();
		
		
		ciorderdo.setTimes_cur(getTotalTimesUtils().getTotalTimes(ciorderdo.getDt_effe(),ciorderdo.getId_freq(), nUseDays));// 总次数
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
	protected OrdSrvDO createOrderSrvInfo(CiEnContextDTO ctx, MedSrvDO medsrv, String id_mm) throws BizException {

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
		srvdo.setMedu_name(medsrv.getMed_name());
		srvdo.setQuan_medu(medsrv.getQuan_med());
		srvdo.setId_medu(getObjectUnit(ctx, medsrv, id_mm));
		srvdo.setId_route(medsrv.getId_route());
		srvdo.setId_routedes(medsrv.getId_routedes());
		srvdo.setId_boil(medsrv.getId_boil());
		srvdo.setId_boildes(medsrv.getId_boildes());
		srvdo.setId_freq(medsrv.getId_freq());
		srvdo.setId_org_srv(ctx.getId_org());
		srvdo.setId_dep_srv(ctx.getId_dep_or());
		srvdo.setId_wg_or(ctx.getId_wg_or());
		srvdo.setId_emp_srv(ctx.getId_emp_or());
		srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());

		// srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvInfo.getId_mp_dep()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setQuan_total_medu(
				this.getQuantumUtils().getUnMMQuantum(null,srvdo.getId_freq(), nUseDays, srvdo.getQuan_medu()));// 计算服务总量
		srvdo.setFg_or(medsrv.getFg_or());
		srvdo.setEu_blmd(medsrv.getEu_blmd());
		srvdo.setFg_mm(CiOrdUtils.nullHandle(medsrv.getFg_mm()));
		srvdo.setId_mm(id_mm);
		// if (CiOrdUtils.isEmpty(medsrv.getPri())) {
		// 映射折扣价，如果折扣价为空，则后台再查询折扣价
		CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ctx.getCode_entp(), medsrv.getId_srv(), medsrv.getId_primd(),
				srvdo);
		// } else {
		// srvdo.setPri(medsrv.getPri());
		// srvdo.setPri_std(medsrv.getPri());// 标准价
		// // srvdo.setPri_ratio(medsrv.getPri_ratio());//价格系数??
		// srvdo.setId_pripat(ctx.getEnt4BannerDTO().getId_pripat());// 患者价格分类
		// }
		srvdo.setFg_set(CiOrdUtils.nullHandle(medsrv.getFg_set()));
		// srvdo.setFg_indic((medsrv.getFg_hpindicjudged()));//之前关闭，现在打开了（zhangwq）//???字段类型不符合
		// srvdo.setFg_propc(CiOrdUtils.nullHandle(medsrv.getFg_propc()));
		// srvdo.setFg_self(CiOrdUtils.nullHandle(srvInfo.getFg_self()));
		// srvdo.setFg_pres_outp(CiOrdUtils.nullHandle(null));//--
		srvdo.setNote_srv(medsrv.getDes());
		srvdo.setId_srvca(medsrv.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(medsrv.getFg_bl()));
		srvdo.setCode_srv(medsrv.getCode());
		// srvdo.setEu_sourcemd(Integer.parseInt(ctx.getEu_orsrcmdtp()));
		srvdo.setId_primd(medsrv.getId_primd());

		// srvdo.setId_reltp(srvInfo.getId_reltp());//2016-03-25 新增 关联类型
		// srvdo.setFg_hpindicjudged(srvInfo.getFg_hpindicjudged());//0不需要判断，1待判断，2已判断;
		// srvdo.setFg_extdispense(srvInfo.getFg_extdispense());//外配药标识
		if (CiOrdUtils.isTrue(srvdo.getFg_skintest())) {
			srvdo.setSd_reltp(IBdSrvDictCodeConst.SD_RELORDTYPE_SKIN);
		} else {
			// srvdo.setSd_reltp(srvInfo.getSd_reltp());//2016-03-25 新增 关联类型编码
		}
		// srvdo.setId_or_rel(srvInfo.getId_or_rel());//2016-03-25 新增 对应关联医嘱id
		srvdo.setFg_selfsrv(medsrv.getFg_ctm());
		// srvdo.setId_srv_src(srvInfo.getId_srv_src());
		// srvdo.setQuan_total_medu(srvInfo.getQuan_cur());
		// srvdo.setFg_selfpay(srvInfo.getFg_selfpay());//2016-07-08新增自费标识
		srvdo.setId_hp(ctx.getId_hp());// 2016-07-12新增医保相关信息
		// srvdo.setId_hpsrvtp(ctx.getId_hpsrvtp()); 
		// srvdo.setSd_hpsrvtp(ctx.getSd_hpsrvtp());
		// srvdo.setDes_hplimit(ctx.getLimit());

		// srvdo.setId_dep_mp(srvInfo.getId_mp_dep());
		// srvdo.setId_dep_wh(mmdo.getId_dep_wh());
		// srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		// srvdo.setFg_base(srvInfo.getFg_base());//???

		srvdo.setFg_feertnable(FBoolean.TRUE); // 可退费标识
		srvdo.setStatus(DOStatus.NEW);
		// 医嘱项目对应的物品处理???计算接口参数不符
		// if(OrSrvSplitUtil.isTrue(srvInfo.getFg_mm())){
		// if(!CiOrdUtils.isEmpty(srvInfo.getId_mm())){
		// OrdSrvMmDO ordsrvmmdo=createCiOrdSrvMmDO(srvdo,srvInfo);//??放到哪？
		//
		//
		// //2016-07-21 新增 毒麻药品服务 代办人信息核对登录处理逻辑
		// // if(CiOrdUtils.isSrvPoisonHandle(srvdto)){
		// // OrSrvAgentInfoDO orsrvagentdo=createSrvAgentInfoDO(srvdto);
		// // }
		//
		// }
		// }
		// 变动用药处理???计算接口参数不符
		// if(OrSrvSplitUtil.isTrue(srvInfo.getFg_dose_anoma())){
		// // OrdSrvDoseDO[] dosedos=getOrdSrvDoses(srvdo,srvdto);
		// // if(dosedos!=null && dosedos.length!=0){
		// // rtn.setSrvdoses(dosedos);
		// // }
		// }

		
		return srvdo;

	}	
	
	/**
	 * 处理医嘱和主服务信息
	 * @param ctx
	 * @param orderInfo
	 * @param srvInfo
	 * @throws BizException 
	 */
	protected void handleOrderMainSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO srvInfo, String id_mm) throws BizException{
		handleMpWhDeptInfo(ctx,null,srvInfo,id_mm,orderInfo.getFg_long());
		orderInfo.setId_dep_mp(srvInfo.getId_dep_mp());
		orderInfo.setId_route(srvInfo.getId_route());
		orderInfo.setId_freq(srvInfo.getId_freq());
		orderInfo.setSd_frequnitct(srvInfo.getSd_frequnitct());
	}

	/**
	 * 处理执行科室和物资流向科室
	 * 
	 * @param ctx
	 * @param id_dep_main
	 * @param srvInfo
	 * @throws BizException
	 */
	protected void handleMpWhDeptInfo(CiEnContextDTO ctx, String id_dep_main, OrdSrvDO srvInfo, String id_mm,FBoolean isLong)
			throws BizException {
		//ctx.getCode_entp(), sd_srvtp, id_srvca,id_srv,id_route, id_mm, ctx.getId_dep_or(), ctx.getId_dep_ns(), ctx.getId_dep_en(),id_dep_main,isLong
		OrdBizLogger.info(ctx, "医技补录费用计算执行科室入参:就诊类型："+ctx.getCode_entp()+"服务id_srv:"+srvInfo.getId_srv()+" 服务类型sd_srvtp:"+srvInfo.getSd_srvtp()+" 服务分类:"+srvInfo.getId_srvca()+" 用法："+srvInfo.getId_route()+" 物品id_mm:"+id_mm+" 长临标识:"+isLong);
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, srvInfo.getId_srv(),id_mm, srvInfo.getId_route(), id_dep_main,isLong,ctx.getFg_pres_outp(),CiOrdAppUtils.getServerDateTime());
		if (wf != null) {
			srvInfo.setId_dep_mp(wf.getFirstid_mp_dept());
			srvInfo.setId_dep_wh(wf.getId_dept_wh());
			OrdBizLogger.info(ctx, "医技补录费用计算执行科室出参:执行科室id_dep_mp:"+wf.getFirstid_mp_dept()+" 物质流向id_dep_wh:"+wf.getId_dept_wh());
		}
	}

	/**
	 * 获取费用对照所关联医嘱服务项目
	 * 
	 * @param aggdos
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public Map<String, List<OrdSrvDO>> createPriCalOrSrvInfo(MedsrvAggDO[] aggdos, CiEnContextDTO ctx)
			throws BizException {
		// 组合参数
		List<OrederPriCalParam> params = new ArrayList<OrederPriCalParam>();
		for (MedsrvAggDO aggdo : aggdos) {

			OrederPriCalParam param = new OrederPriCalParam();
			param.setId_srv(aggdo.getParentDO().getId_srv());
			param.setName_srv(aggdo.getParentDO().getName());
			param.setId_primd(aggdo.getParentDO().getId_primd());
			if (CiOrdUtils.isTrue(aggdo.getParentDO().getFg_set())) {
				param.setNum(aggdo.getMedSrvSetItemDO().length + 1);
			}
		}
		return getCiordPriCalSrvInfo(params.toArray(new OrederPriCalParam[params.size()]), ctx);
	}

	/**
	 * 获取费用对照
	 * 
	 * @param params
	 * @param ctx
	 * @return Map<String,List<OrdSrvDO>> key:服务ID, value:该服务ID对应的费用项目srvdo列表
	 * @throws BizException
	 */
	public Map<String, List<OrdSrvDO>> getCiordPriCalSrvInfo(OrederPriCalParam[] params, CiEnContextDTO ctx)
			throws BizException {

		Map<String, List<String>> srvmap = new HashMap<String, List<String>>();
		List<String> id_srvlist = new ArrayList<String>();
		// 获得服务对应的费用项
		CiOrSrvPriCalGetBP bp = new CiOrSrvPriCalGetBP();
		Map<String, Map<String, SrvPricalRateAndPriceDTO>> pricalmap = bp.exec(params,
				ctx.getId_pripat());

		for (String id_srv : pricalmap.keySet()) {
			List<String> idlist = new ArrayList<String>();
			for (String idsrv : pricalmap.get(id_srv).keySet()) {
				idlist.add(idsrv);
				if (id_srvlist.contains(idsrv))
					continue;
				id_srvlist.add(idsrv);
			}
			srvmap.put(id_srv, idlist);
		}
		if (id_srvlist.size() == 0)
			return null;
		// 获取medsrv
		MedSrvDO[] medsrvs = ServiceFinder.find(IMedsrvMDORService.class)
				.findByBIds(id_srvlist.toArray(new String[id_srvlist.size()]), FBoolean.FALSE);

		Map<String, OrdSrvDO> orsrvmap = new HashMap<String, OrdSrvDO>();
		for (MedSrvDO med : medsrvs) {
			OrdSrvDO ordsrv = createOrderSrvInfo(ctx, med,null);
			orsrvmap.put(med.getId_srv(), ordsrv);
		}

		Map<String, List<OrdSrvDO>> ordsrvmap = new HashMap<String, List<OrdSrvDO>>();
		for (String id_srv : srvmap.keySet()) {
			List<OrdSrvDO> ordsrvList = new ArrayList<OrdSrvDO>();
			for (String idsrv : srvmap.get(id_srv)) {
				if (!orsrvmap.containsKey(idsrv))
					continue;
				ordsrvList.add(orsrvmap.get(idsrv));
			}
			ordsrvmap.put(id_srv, ordsrvList);
		}

		return ordsrvmap;
	}
	public String getId_mm(String[] id_mms,int index){
		if(CiOrdUtils.isEmpty(id_mms)){
			return null;
		}
		return id_mms[index];
	}

	//0195799: 医生开立有原液批示的药品的医嘱，自动生成的皮试医嘱，ci_or_srv.id_medu为空
	protected String getObjectUnit(CiEnContextDTO ctx, MedSrvDO medsrv, String id_mm) throws BizException {
		return medsrv.getId_unit_med();
	}
}
