package iih.ci.ord.s.ems.defsave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.PharmVerifyStatusEnum;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.cache.BDFreqInfoCache;
import iih.ci.ord.s.ems.itf.IDefaultCreateOrderInfo;
import iih.ci.ord.s.ems.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfoList;
import iih.ci.ord.s.ems.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.utils.AuditInfoUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;

/**
 * 默认医嘱生成  -- 基类
 * @author wangqingzhu
 *
 */
public class DefaultBaseCreateOrderInfo implements IDefaultCreateOrderInfo{
	private int pretreatmentCodingPks = 1;
	// 就诊上下文
	private CiEnContextDTO enContextInfo;

	// 默认使用天数
	protected int nUseDays = 1;

	/**
	 * 总量计算逻辑
	 */
	private CalQuantumBP quantumUtils = new CalQuantumBP();
	/**
	 * 医嘱总次数计算逻辑
	 */
	private GetTotalTimesBP totalTimesUtils = new GetTotalTimesBP();




	public CiEnContextDTO getEnContextInfo() {
		return enContextInfo;
	}

	public void setEnContextInfo(CiEnContextDTO enContextInfo) {
		this.enContextInfo = enContextInfo;
	}

	public int getUseDays() {
		return nUseDays;
	}

	public void setUseDays(int nUseDays) {
		this.nUseDays = nUseDays;
	}

	/**
	 * 计算总量工具
	 * @return
	 */
	public CalQuantumBP getQuantumUtils() {
		return quantumUtils;
	}

	/**
	 * 医嘱总次数计算逻辑
	 * @return
	 */
	public GetTotalTimesBP getTotalTimesUtils() {
		return totalTimesUtils;
	}



	protected String[] generatePks(int size){
		if (this.pretreatmentCodingPks == 1){
			return new DBUtil().getOIDs(size);
		}
		else{
			return new String[size];
		}
	}

	protected String generatePks(){
		if (this.pretreatmentCodingPks == 1){
			return new DBUtil().getOIDs(1)[0];
		}
		else{
			return null;
		}
	}
	/**
	 * 强制类型转化
	 * @param iDefCrtOrdInfo
	 * @return
	 */
	public <T extends DefaultBaseCreateOrderInfo> T Cast(T o,IDefaultCreateOrderInfo iDefCrtOrdInfo){
		return ((T)iDefCrtOrdInfo);
	}

	/**
	 * 处理组装医嘱服务和其他扩展表格信息
	 * @author wangqingzhu  
	 * @param ctx 就诊上下文
	 * @param szParam 默认创建参数集合
	 * @return
	 * @throws BizException  
	 * @since JDK 1.8
	 */
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException{
		this.setEnContextInfo(ctx);
		// 新建医嘱包对象列表
		OrderPackageInfoList listOrderPakageInfo = new OrderPackageInfoList();
		// 遍历处理批量创建内容
		for (DefaultCreateParam param : szParam){

			// 判断参数列表是否有效
			if (CiOrdUtils.isEmpty(param.getBdSrvMmInfoList())){
				return null;
			}

			// 创建医嘱包信息
			OrderPackageInfo orderPakageInfo = new OrderPackageInfo();
			orderPakageInfo.setStatus(DOStatus.NEW);
			// 设置服务信息
			orderPakageInfo.setBdSrvList(param.getBdSrvMmInfoList().asBdSrvInfoList()) ;
			// 设置医嘱用户UI对象
			orderPakageInfo.setUiModel(param.getUiModel());
			//获取主服务
			MedSrvDO mainbdsrv = null;
			for (MedSrvDO bdsrv : orderPakageInfo.getBdSrvList()) {
				if(mainbdsrv != null){
					break;
				}
				String id_srv = "";
				if (param.getUiModel() instanceof OrderListViewDTO) {
					id_srv = ((OrderListViewDTO) param.getUiModel()).getId_srv();
				} else {
					id_srv = ((ArrayList<OrderListViewDTO>) param.getUiModel()).get(0).getId_srv();
				}
				if (bdsrv.getId_srv().equals(id_srv)) {
					mainbdsrv = bdsrv;
				}
			}

			// 创建医嘱信息
			createOrderInfo(orderPakageInfo, mainbdsrv)
			// 创建服务和扩展信息
			.createOrderSrvAExtInfo(orderPakageInfo,param.getBdSrvMmInfoList());

			// 将医嘱信息添加到医嘱包对象中
			listOrderPakageInfo.add(orderPakageInfo);
		}
		return listOrderPakageInfo.asArray();
	}

	/**
	 * 创建医嘱Order对象结构
	 * @param ctx
	 * @param orderPakageInfo
	 * @param medsrv
	 * @return
	 * @throws BizException 
	 */
	protected DefaultBaseCreateOrderInfo createOrderInfo(OrderPackageInfo orderPakageInfo,MedSrvDO mainBdSrvInfo) throws BizException{
		// 创建医嘱信息
		orderPakageInfo.setOrderInfo(assembleOrderInfo(this.getEnContextInfo(),mainBdSrvInfo));
		return this;
	}


	/**
	 * 处理组装医嘱服务和其他扩展表格信息
	 * @author wangqingzhu  
	 * @param ctx
	 * @param orderPakageInfo
	 * @param bdSrvMmInfoList
	 * @return
	 * @throws BizException  
	 * @since JDK 1.8
	 */
	protected DefaultBaseCreateOrderInfo createOrderSrvAExtInfo(OrderPackageInfo orderPakageInfo,BdSrvMmInfoList bdSrvMmInfoList) throws BizException{

		return this;
	}

	/**
	 * 创建医嘱对象
	 * @param ctx
	 * @param medsrv
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO createOrderInfo(CiEnContextDTO ctx, MedSrvDO medsrv) throws BizException{
		return assembleOrderInfo(ctx, medsrv);
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
	protected CiOrderDO assembleOrderInfo(CiEnContextDTO ctx, MedSrvDO medsrv) throws BizException {

		CiOrderDO ciorderdo = new CiOrderDO();
		OrWfDeptInfoDTO orWfDeptInfoDTO = DeptInfoUtils.GetOrWfDeptInfo(ctx, medsrv.getId_srv(), "",medsrv.getId_route(),null,medsrv.getFg_long(),ctx.getFg_pres_outp(),CiOrdAppUtils.getServerDateTime());
		ciorderdo.setId_dep_mp(orWfDeptInfoDTO.getFirstid_mp_dept());
		ciorderdo.setId_or(generatePks());
		ciorderdo.setFg_mp_in(CiOrdUtils.JudgeFgMpIn(ctx, medsrv));
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
		ciorderdo.setDes_or(medsrv.getDes());
		ciorderdo.setId_freq(medsrv.getId_freq());
		ciorderdo.setSd_frequnitct(medsrv.getSd_frequnitct());
		ciorderdo.setFrequnitct(medsrv.getFrequnitct());
		ciorderdo.setFreqct(medsrv.getFreqct());
		ciorderdo.setFreq_name(medsrv.getFreq_name());
		//ciorderdo.setOrders(0);// 医嘱付数，前台传入
		ciorderdo.setFg_boil(FBoolean.FALSE);// 代煎标识
		// CiOrdUtils.nullHandle(medsrv.getFg_boil())
		//		ciorderdo.setOrders_boil(0);
		ciorderdo.setId_route(medsrv.getId_route());
		ciorderdo.setId_routedes(medsrv.getId_routedes());
		//ciorderdo.setId_boil(medsrv.getId_boil());
		ciorderdo.setId_boildes(medsrv.getId_boildes());
		ciorderdo.setDays_or(1);// 医嘱天数，前台传入
		ciorderdo.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
		ciorderdo.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
		ciorderdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		ciorderdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		ciorderdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		ciorderdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		ciorderdo.setId_org_or(ctx.getId_org());
		if("2".equals(ctx.getSd_orsrcfun())) {
			ciorderdo.setId_dep_or(CiOrdUtils.getIdDepNur(ctx.getId_en()));
		}else {
			ciorderdo.setId_dep_or(ctx.getId_dep_or());
		}
		ciorderdo.setId_wg_or(ctx.getId_wg_or());
		ciorderdo.setId_emp_or(ctx.getId_emp_or());
		ciorderdo.setDt_entry(CiOrdAppUtils.getServerDateTime());
		ciorderdo.setFg_sign(CiOrdUtils.nullHandle(null));
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

		// if(ciorderdo.getFg_mp_in() == FBoolean.TRUE){
		// ciorderdo.setTimes_mp_in(medsrv.getTimes_mp_in());
		// if(medsrv.getTimes_mp_in() != null){
		// ciorderdo.setTimes_mp_in(medsrv.getTimes_mp_in());
		// }else{
		// ciorderdo.setTimes_mp_in(medsrv.getTimes_cur());
		// medsrv.setTimes_mp_in(medsrv.getTimes_cur());
		// }
		// }
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
		//		 ciorderdo.setFg_or_form(FBoolean.TRUE);//医嘱单标识//暂时不赋值，没有用到
		// ciorderdo.setId_skintest_skip_reason();//废弃不用的字段
		// ciorderdo.setSd_skintest_skip_reason();//废弃不用的字段
		// ciorderdo.setFg_pres_outp(CiOrdUtils.nullHandle(medsrv.getFg_outp()));//出院带药
		// ciorderdo.setFuncclassstr(medsrv.getFuncclassstr());//医疗单url
		// ciorderdo.setId_srvof(medsrv.getId_srvof());//医疗单
		// ciorderdo.setFg_quickwflow(medsrv.getFg_quickwflow());
		// ciorderdo.setApplyno(medsrv.getApplyno());//申请单号
		//默认开始时间
		ciorderdo.setDt_effe(new FDateTime());
		//ciorderdo.setDt_last_bl(
		//		OrderUtils.getLastDt(ciorderdo.getId_freq(), ciorderdo.getDt_effe(), 0, ciorderdo.getFg_long()));
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
     * 
     * @param id_ent
     * @param id_dep_or
     * @param sd_orsrvfun
     * @return
     */
    private String getIdDepNur(String id_ent)throws BizException {
    	String sql =" select id_dep_nur from en_ent where id_ent='"+id_ent+"'";
    	PatiVisitDO pativaisitDO = (PatiVisitDO)new DAFacade().execQuery(sql, new BeanHandler(PatiVisitDO.class));
    	return pativaisitDO.getId_dep_nur();
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
	protected OrdSrvDO assembleOrderSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, BdSrvMmInfo bdSrvMmInfo) 
			throws BizException {
		OrdSrvDO srvdo = new OrdSrvDO();
		srvdo.setId_primd(bdSrvMmInfo.getBdSrvInfo().getId_primd());
		srvdo.setPri(bdSrvMmInfo.getBdSrvInfo().getPri());
//		srvdo.setSortno(index);
		srvdo.setId_or(orderInfo.getId_or());
		srvdo.setId_orsrv(generatePks());
		srvdo.setId_pat(ctx.getId_pat());
		srvdo.setId_entp(ctx.getId_entp());
		srvdo.setCode_entp(ctx.getCode_entp());
		srvdo.setId_en(ctx.getId_en());
		srvdo.setId_srvtp(bdSrvMmInfo.getBdSrvInfo().getId_srvtp());
		srvdo.setSd_srvtp(bdSrvMmInfo.getBdSrvInfo().getSd_srvtp());
		srvdo.setId_srv(bdSrvMmInfo.getBdSrvInfo().getId_srv());
		srvdo.setName(bdSrvMmInfo.getBdSrvInfo().getName());
		srvdo.setFg_dose_anoma(null);
		if(CiOrdUtils.isEmpty(bdSrvMmInfo.getBdSrvSetItemInfo())){
			srvdo.setQuan_medu(bdSrvMmInfo.getBdSrvInfo().getQuan_med());
			srvdo.setId_medu(bdSrvMmInfo.getBdSrvInfo().getId_unit_med());
		}else{
			srvdo.setQuan_medu(bdSrvMmInfo.getBdSrvSetItemInfo().getQuan_medu());
			srvdo.setId_medu(bdSrvMmInfo.getBdSrvSetItemInfo().getId_medu());
		}
		srvdo.setId_route(bdSrvMmInfo.getBdSrvInfo().getId_route());
		srvdo.setId_routedes(bdSrvMmInfo.getBdSrvInfo().getId_routedes());
		srvdo.setId_boil(bdSrvMmInfo.getBdSrvInfo().getId_boil());
		srvdo.setId_boildes(bdSrvMmInfo.getBdSrvInfo().getId_boildes());
		srvdo.setId_freq(bdSrvMmInfo.getBdSrvInfo().getId_freq()); 
		srvdo.setId_org_srv(ctx.getId_org());
		srvdo.setId_dep_srv(ctx.getId_dep_or());
		srvdo.setId_wg_or(ctx.getId_wg_or());
		srvdo.setId_emp_srv(ctx.getId_emp_or());
		srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());

		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setQuan_total_medu(this.getQuantumUtils().getUnMMQuantum(orderInfo.getDt_effe(),srvdo.getId_freq(), nUseDays, srvdo.getQuan_medu()));// 计算服务总量
		srvdo.setFg_or(bdSrvMmInfo.getBdSrvInfo().getFg_or());
		srvdo.setEu_blmd(bdSrvMmInfo.getBdSrvInfo().getEu_blmd());
		srvdo.setFg_mm(CiOrdUtils.nullHandle(bdSrvMmInfo.getBdSrvInfo().getFg_mm()));
		if(CiOrdUtils.isTrue(srvdo.getFg_mm()) && !CiOrdUtils.isEmpty(bdSrvMmInfo.getMmInfo())) {
			srvdo.setId_mm(CiOrdUtils.nullHandle(bdSrvMmInfo.getMmInfo().getId_mm()));
		}
		//if (CiOrdUtils.isEmpty(bdSrvMmInfo.getBdSrvInfo().getPri())) {
		// 映射折扣价，如果折扣价为空，则后台再查询折扣价
		CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ctx.getCode_entp(), bdSrvMmInfo.getBdSrvInfo().getId_srv(),
				bdSrvMmInfo.getBdSrvInfo().getId_primd(), srvdo);
		//		} else {
		//			srvdo.setPri(bdSrvMmInfo.getBdSrvInfo().getPri());
		//			srvdo.setPri_std(bdSrvMmInfo.getBdSrvInfo().getPri());// 标准价
		//			// srvdo.setPri_ratio(bdSrvMmInfo.getBdSrvInfo().getPri_ratio());//价格系数??
		//			srvdo.setId_pripat(ctx.getEnt4BannerDTO().getId_pripat());// 患者价格分类
		//		}
		OrWfDeptInfoDTO orWfDeptInfoDTO = DeptInfoUtils.GetOrWfDeptInfo(ctx, bdSrvMmInfo.getBdSrvInfo().getId_srv(), bdSrvMmInfo.getMmInfo()==null?null:bdSrvMmInfo.getMmInfo().getId_mm(),bdSrvMmInfo.getBdSrvInfo().getId_route() ,orderInfo.getId_dep_mp(),
				bdSrvMmInfo.getBdSrvInfo().getFg_long(), ctx.getFg_pres_outp(),orderInfo.getDt_effe());
		srvdo.setId_dep_mp(orWfDeptInfoDTO.getFirstid_mp_dept());
		if(CiOrdUtils.isTrue(srvdo.getFg_mm())){
			srvdo.setId_dep_wh(orWfDeptInfoDTO.getId_dept_wh());
		}
		srvdo.setFg_set(CiOrdUtils.nullHandle(bdSrvMmInfo.getBdSrvInfo().getFg_set()));
		// srvdo.setFg_indic((bdSrvMmInfo.getBdSrvInfo().getFg_hpindicjudged()));//之前关闭，现在打开了（zhangwq）//???字段类型不符合
		// srvdo.setFg_propc(CiOrdUtils.nullHandle(bdSrvMmInfo.getBdSrvInfo().getFg_propc()));
		// srvdo.setFg_self(CiOrdUtils.nullHandle(srvInfo.getFg_self()));
		// srvdo.setFg_pres_outp(CiOrdUtils.nullHandle(null));//--
		srvdo.setNote_srv(bdSrvMmInfo.getBdSrvInfo().getDes());
		srvdo.setId_srvca(bdSrvMmInfo.getBdSrvInfo().getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(bdSrvMmInfo.getBdSrvInfo().getFg_bl()));
		srvdo.setCode_srv(bdSrvMmInfo.getBdSrvInfo().getCode());
		// 服务来源
//		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		srvdo.setId_primd(bdSrvMmInfo.getBdSrvInfo().getId_primd());

		// srvdo.setId_reltp(srvInfo.getId_reltp());//2016-03-25 新增 关联类型
		// srvdo.setFg_hpindicjudged(srvInfo.getFg_hpindicjudged());//0不需要判断，1待判断，2已判断;
		// srvdo.setFg_extdispense(srvInfo.getFg_extdispense());//外配药标识
		if (CiOrdUtils.isTrue(srvdo.getFg_skintest())) {
			srvdo.setSd_reltp(IBdSrvDictCodeConst.SD_RELORDTYPE_SKIN);
		} else {
			// srvdo.setSd_reltp(srvInfo.getSd_reltp());//2016-03-25 新增 关联类型编码
		}
		// srvdo.setId_or_rel(srvInfo.getId_or_rel());//2016-03-25 新增 对应关联医嘱id
		srvdo.setFg_selfsrv(bdSrvMmInfo.getBdSrvInfo().getFg_ctm());
		if(!CiOrdUtils.isEmpty(srvdo.getId_srv()) && !srvdo.getId_srv().equals(orderInfo.getId_srv())) srvdo.setId_srv_src(orderInfo.getId_srv());
		srvdo.setQuan_total_medu(bdSrvMmInfo.getBdSrvInfo().getQuan_med());
		srvdo.setFg_selfpay(FBoolean.TRUE);//2016-07-08新增自费标识
		srvdo.setId_hp(ctx.getId_hp());// 2016-07-12新增医保相关信息
		// srvdo.setId_hpsrvtp(ctx.getId_hpsrvtp());
		// srvdo.setSd_hpsrvtp(ctx.getSd_hpsrvtp());
		// srvdo.setDes_hplimit(ctx.getLimit());

		//srvdo.setId_dep_mp(orderInfo.getId_dep_mp());
		// srvdo.setId_dep_wh(mmdo.getId_dep_wh());
		// srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(orderInfo.getId_dep_mp()));
		// srvdo.setFg_base(srvInfo.getFg_base());//???
		srvdo.setInnercode_srvca(bdSrvMmInfo.getBdSrvInfo().getSrvca_innercode());
		srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
		srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId());
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
	 * 处理医嘱物品信息
	 * @param ctx
	 * @param orderPakageInfo
	 * @param mmdo
	 * @throws BizException
	 */
	protected OrdSrvMmDO assembleSrvMmInfo(CiEnContextDTO ctx,OrdSrvDO orderSrvInfo,MeterialDO mmdo, MedSrvDrugDO medSrvDrugDO) throws BizException{
		if (mmdo == null) return null;

		return assembleSrvMmInfo(orderSrvInfo,medSrvDrugDO, mmdo,ctx.getCode_entp());
	}

	/**
	 * 医嘱物品映射
	 * 
	 * @param medsrvagg
	 * @param mmdo
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	protected OrdSrvMmDO assembleSrvMmInfo(OrdSrvDO orderSrvInfo,MedSrvDrugDO drugdo, MeterialDO mmdo, String code_entp)
			throws BizException {
		OrdSrvMmDO srvmmdo = new OrdSrvMmDO();
		srvmmdo.setStatus(DOStatus.NEW);
//		srvmmdo.setId_pgku_cur(mmdo.getId_unit_pkgsp());//包装单位
//		srvmmdo.setPrice_pgku_cur(mmdo.getPrice());//参考价
//		srvmmdo.setFactor(mmdo.getFactor_sb());//换算系数
		//CalQuantumBP quantumBP = new CalQuantumBP();
		//srvmmdo.setQuan_cur(quantumBP.geteUnMMQuantum(orderSrvInfo.getId_freq(), orderSrvInfo.getUse_days(), ems.getQuan_med()));
		srvmmdo.setId_orsrvmm(generatePks());//医嘱服务物品主键标识
		srvmmdo.setId_orsrv(orderSrvInfo.getId_orsrv());//医嘱服务项目

		srvmmdo.setId_mm(mmdo.getId_mm()); // 医疗物品
		srvmmdo.setCode_mm(mmdo.getCode()); // 物品编码
		srvmmdo.setName_mm(mmdo.getName()); // 物品名称

		srvmmdo.setId_pgku_base(mmdo.getId_unit_pkgbase()); // 基本包装单位
		// srvmmdo.setQuan_bed_medu(); //床边剩余量_医学单
		srvmmdo.setId_dosage(drugdo.getId_dosage()); // 药品剂型
		srvmmdo.setSd_dosage(drugdo.getSd_dosage()); // 药品剂型编码
		srvmmdo.setId_pharm(drugdo.getId_pharm()); // 药理分类
		srvmmdo.setSd_pharm(drugdo.getSd_pharm()); // 药理分类编码
		// srvmmdo.setId_val(drugdo.geti); //价值分类--
		// srvmmdo.setSd_val(); //价值分类编码--
		srvmmdo.setId_pois(drugdo.getId_pois()); // 毒麻分类
		srvmmdo.setSd_pois(drugdo.getSd_pois()); // 毒麻分类编码
		srvmmdo.setId_anti(drugdo.getId_anti()); // 抗菌药分类
		srvmmdo.setSd_anti(drugdo.getSd_anti()); // 抗菌药分类编码
		srvmmdo.setId_mmtp(mmdo.getId_mmtp()); // 物品类型
		srvmmdo.setSd_mmtp(mmdo.getSd_mmtp()); // 物品类型编码
		// srvmmdo.setId_antipsy(drugdo.getid); //抗精神分类编码 --
		// srvmmdo.setSd_antipsy(); //抗精神分类--
		srvmmdo.setFg_otc(mmdo.getFg_otc()); // OTC标识
		// srvmmdo.setQuan_bed_transit();//床边余量_在途
		// srvmmdo.setDays_available(); //领量可用天数（门诊）
		if (code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)) {
			srvmmdo.setId_mupkgutp(mmdo.getId_opmutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_opmutp()); // 包装单位取整模式编码
		} else if (code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)) {
			srvmmdo.setId_mupkgutp(mmdo.getId_mupkgutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_mupkgutp()); // 包装单位取整模式编码
		} else if (code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW)) {
			srvmmdo.setId_mupkgutp(mmdo.getId_ermutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_ermutp()); // 包装单位取整模式编码
		} else if (code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID)) {
			srvmmdo.setId_mupkgutp(mmdo.getId_er1mutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_er1mutp()); // 包装单位取整模式编码
		} else if (code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS)) {
			srvmmdo.setId_mupkgutp(mmdo.getId_er2mutp()); // 包装单位取整模式
			srvmmdo.setSd_mupkgutp(mmdo.getSd_er2mutp()); // 包装单位取整模式编码
		} 
		srvmmdo.setId_srv(drugdo.getId_srv()); // 药品服务id
		return srvmmdo;

	}

	/**
	 * 处理执行科室和物资流向科室
	 * @param ctx
	 * @param id_dep_main
	 * @param srvInfo
	 * @throws BizException
	 */
	protected DefaultBaseCreateOrderInfo handleMpWhDeptInfo(CiEnContextDTO ctx, String id_dep_main, OrdSrvDO srvInfo, String id_mm) throws BizException{
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, srvInfo.getId_srv(), id_mm, srvInfo.getId_route(), id_dep_main,BDFreqInfoCache.GetFgLongOfFreqInfo(srvInfo.getId_freq()),ctx.getFg_pres_outp(),CiOrdAppUtils.getServerDateTime());
		if (wf != null){
			srvInfo.setId_dep_mp(wf.getFirstid_mp_dept());
			if(CiOrdUtils.isTrue(srvInfo.getFg_mm())){
				srvInfo.setId_dep_wh(wf.getId_dept_wh());
			}
		}
		return this;
	}

	/**
	 * 处理服务物品信息
	 * @param ctx
	 * @param orderPakageInfo
	 * @param tmpMmInfoMap
	 * @throws BizException
	 */
	protected DefaultBaseCreateOrderInfo handleSrvMmInfo(CiEnContextDTO ctx, OrderPackageInfo orderPakageInfo , Map<String,MeterialDO> tmpMmInfoMap) throws BizException{
		OrderSrvMmList listOrdSrvMmInfo = orderPakageInfo.getOrderSrvMmList();
		StringList idSrvList = new StringList();
		for (OrderSrvMmInfo orderSrvMmInfo : listOrdSrvMmInfo){
			idSrvList.add(orderSrvMmInfo.getOrderSrvInfo().getId_srv());
		}

		MedSrvDrugDO[] szMedSrvDrugDO = ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValStrings("Id_srv", idSrvList.asArray());
		Map<String,MedSrvDrugDO> tmpMedSrvDrugDOCache = new HashMap<String,MedSrvDrugDO>();
		for (MedSrvDrugDO msdd :szMedSrvDrugDO){
			tmpMedSrvDrugDOCache.put(msdd.getId_srv(), msdd);
		}

		for (OrderSrvMmInfo orderSrvMmInfo : listOrdSrvMmInfo){
			orderSrvMmInfo.setOrderSrvMmInfo(
					assembleSrvMmInfo(ctx, 
							orderSrvMmInfo.getOrderSrvInfo(), 
							tmpMmInfoMap.get(orderSrvMmInfo.getOrderSrvInfo().getId_mm()), 
							tmpMedSrvDrugDOCache.get(orderSrvMmInfo.getOrderSrvInfo().getId_srv()))
					);
		}

		return this;
	}

	/**
	 * 给定基础数据服务数组创建医嘱服务聚集列表
	 * @param ctx  就诊上下文
	 * @param orderInfo  医嘱对象
	 * @param szMedSrvInfo  基础数据bd_srv数组
	 * @param eu_sourcemd  医嘱服务来源  OrSrvSourceFromEnum
	 * @return
	 * @throws BizException
	 */
	protected OrderSrvMmList createOrderSrvMmList(CiEnContextDTO ctx,CiOrderDO orderInfo, MedSrvDO[] szMedSrvInfo, int eu_sourcemd) throws BizException{
		OrderSrvMmList osmil = new OrderSrvMmList();
		for (MedSrvDO srvInfo : szMedSrvInfo) {			
			osmil.add(createOrderSrvMmInfo(ctx,orderInfo,srvInfo,eu_sourcemd));
		}
		return osmil;
	}

	/**
	 * 给定单个基础数据服务，创建医嘱服务对象聚集结构
	 * @param ctx  就诊上下文
	 * @param orderInfo  医嘱对象
	 * @param srvInfo  基础数据bd_srv数据对象
	 * @param eu_sourcemd  服务来源 OrSrvSourceFromEnum
	 * @param index  排序号
	 * @return
	 * @throws BizException
	 */
	public OrderSrvMmInfo createOrderSrvMmInfo(CiEnContextDTO ctx,CiOrderDO orderInfo, MedSrvDO srvInfo, int eu_sourcemd) throws BizException{
		BdSrvMmInfo bdSrvMmInfo = new BdSrvMmInfo();
		bdSrvMmInfo.createSrvMmInfo(srvInfo, ctx.getId_org(), ctx.getId_dep_or());
		OrderSrvMmInfo ordSrvMmInfo = new OrderSrvMmInfo(assembleOrderSrvInfo(ctx, orderInfo, bdSrvMmInfo),null);
		ordSrvMmInfo.getOrderSrvInfo().setEu_sourcemd(eu_sourcemd); // 服务来源
		if (CiOrdUtils.isTrue(ordSrvMmInfo.getOrderSrvInfo().getFg_mm()) && bdSrvMmInfo.createSrvMmInfo(ctx.getId_org(), ctx.getId_dep_or())) {
			assert !CiOrdUtils.isEmpty(bdSrvMmInfo.getSrvDrugInfo()) : String
			.format("[%s]获取服务药品属性信息失败，请检查：BdSrvMmInfo.createSrvMmInfo", srvInfo.getName());
			ordSrvMmInfo.setOrderSrvMmInfo(assembleSrvMmInfo(ctx, ordSrvMmInfo.getOrderSrvInfo(), bdSrvMmInfo.getMmInfo(), bdSrvMmInfo.getSrvDrugInfo()));
		}
		return ordSrvMmInfo;
	}

	/**
	 * 成员合计计算套内项目时候使用
	 * @param ctx
	 * @param orderInfo
	 * @param bdSrvMmInfo
	 * @param eu_sourcemd
	 * @param index
	 * @return
	 * @throws BizException
	 */
	public OrderSrvMmInfo createOrderSrvMmInfo(CiEnContextDTO ctx,CiOrderDO orderInfo, BdSrvMmInfo bdSrvMmInfo, int eu_sourcemd) throws BizException{

		OrderSrvMmInfo ordSrvMmInfo = new OrderSrvMmInfo(assembleOrderSrvInfo(ctx, orderInfo, bdSrvMmInfo),bdSrvMmInfo.getUiModel());
		ordSrvMmInfo.getOrderSrvInfo().setEu_sourcemd(eu_sourcemd); // 服务来源
		if (CiOrdUtils.isTrue(ordSrvMmInfo.getOrderSrvInfo().getFg_mm()) && bdSrvMmInfo.createSrvMmInfo(ctx.getId_org(), ctx.getId_dep_or())) {
			assert !CiOrdUtils.isEmpty(bdSrvMmInfo.getSrvDrugInfo()) : String
			.format("[%s]获取服务药品属性信息失败，请检查：BdSrvMmInfo.createSrvMmInfo", bdSrvMmInfo.getBdSrvInfo().getName());
			ordSrvMmInfo.setOrderSrvMmInfo(assembleSrvMmInfo(ctx, ordSrvMmInfo.getOrderSrvInfo(), bdSrvMmInfo.getMmInfo(), bdSrvMmInfo.getSrvDrugInfo()));
		}
		return ordSrvMmInfo;
	}

	/**
	 * 创建给定医嘱下的药品服务信息对象（OrderSrvMmInfo）
	 * @param ctx
	 * @param orderInfo
	 * @param id_srv
	 * @param id_mm
	 * @param eu_sourcemd
	 * @param index
	 * @return
	 * @throws BizException
	 */
	public OrderSrvMmInfo createOrderSrvMmInfo(CiEnContextDTO ctx,CiOrderDO orderInfo, String id_srv, String id_mm, int eu_sourcemd) throws BizException{
		// 新建基础数据服务物品信息聚集结构
		BdSrvMmInfo bdSrvMmInfo = new BdSrvMmInfo();
		if (bdSrvMmInfo.createSrvMmInfo(id_srv,id_mm, ctx.getId_org(), ctx.getId_dep_or())){
			// 调试态断言校验
			assert !CiOrdUtils.isEmpty(bdSrvMmInfo.getSrvDrugInfo()) : String
			.format("[%s]获取服务药品属性信息失败，请检查：BdSrvMmInfo.createSrvMmInfo", id_srv);

			// 创建 临床【服务】信息对象
			OrderSrvMmInfo ordSrvMmInfo = new OrderSrvMmInfo(assembleOrderSrvInfo(ctx, orderInfo, bdSrvMmInfo),null);

			// 设置服务来源枚举值
			ordSrvMmInfo.getOrderSrvInfo().setEu_sourcemd(eu_sourcemd); // 服务来源

			// 创建 临床【物品】信息对象
			ordSrvMmInfo.setOrderSrvMmInfo(assembleSrvMmInfo(ctx, ordSrvMmInfo.getOrderSrvInfo(), bdSrvMmInfo.getMmInfo(), bdSrvMmInfo.getSrvDrugInfo()));

			// 返回
			return ordSrvMmInfo;
		}
		// 发生错误返回空值
		return null;
	}

}
