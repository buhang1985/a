package iih.ei.std.s.v1.bp.ci.thirdws.op.drug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.ems.d.EmsAppModeEnum;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.d.MedUsageDesDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.i.ICiOrdLogService;
import iih.ci.ord.i.external.common.ICIOrdRService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.i.IPresCudService;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ei.std.d.v1.ci.drugs.d.EmsDrugsOrdDTO;
import iih.ei.std.d.v1.ci.drugs.d.EmsDrugsPresDTO;
import iih.ei.std.d.v1.ci.drugs.d.EmsDrugsSrvDTO;
import iih.ei.std.d.v1.ci.drugs.d.EntWsDrugsDTO;
import iih.ei.std.d.v1.ci.ent.d.ResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.BdDiDefUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.BdMeasdocUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.DeptUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.FreqUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.PsndocUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.RouteUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.ThirdInfoUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.UdidocUtils;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mp.dg.i.IMpDgOutService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.utils.AuditInfoUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * @code 第三方门诊药品回传BP
 * @author LiYue
 */
public class OpDrugSaveBP extends IIHServiceBaseBP<EntWsDrugsDTO, ResultDTO> {
	private PatiVisitDO entdo;
	private OutpatientDO entopdo;
	private EntHpDO entHpdo;
	// 缓存物品,key:mmcode,value:MeterialDO
	private Map<String, MeterialDO> meterialMapTemp;

	/*入参校验
	 */
	protected void checkParam(EntWsDrugsDTO param) throws BizException {
		
		//就诊信息校验
		checkEmpty(param.getCode_org(),"所属组织" );
		checkEmpty(param.getCode_pat(),"患者" );
		checkEmpty(param.getCode_entp(),"就诊类型编码" );
		checkEmpty(param.getCode_dep_phy(),"当前就诊科室" );
		checkEmpty(param.getCode_emp_phy(),"当前主管医生" );
		//处方信息校验
		List<EmsDrugsPresDTO> prelist = (List<EmsDrugsPresDTO>)param.getEmsdrugspresdto();
		for (EmsDrugsPresDTO emsDrugsPresDTO : prelist) {
			checkEmpty( emsDrugsPresDTO.getCode_pres(), "处方号" );
			checkEmpty( emsDrugsPresDTO.getCodes_diag(), "临床诊断编码" );
			checkEmpty( emsDrugsPresDTO.getNames_diag(), "临床诊断名称" );
			checkEmpty( emsDrugsPresDTO.getSd_prestp(), "处方类型" );
			
			//医嘱校验
			List<EmsDrugsOrdDTO> ordList = (List<EmsDrugsOrdDTO>)emsDrugsPresDTO.getEmsdrugsorddto();
			for (EmsDrugsOrdDTO emsDrugsOrdDTO : ordList) {
				checkEmpty( emsDrugsOrdDTO.getSortno_or(), "医嘱序号" );
				checkEmpty( emsDrugsOrdDTO.getCode_or(), "医嘱编码" );
				checkEmpty( emsDrugsOrdDTO.getCode_org_or(), "开立机构" );
				checkEmpty( emsDrugsOrdDTO.getCode_dep_or(), "开立部门" );
				checkEmpty( emsDrugsOrdDTO.getCode_emp_or(), "开立医生" );
				checkEmpty( emsDrugsOrdDTO.getDt_entry_or(), "开立日期" );
				checkEmpty( emsDrugsOrdDTO.getCode_org_mp_or(), "医嘱执行机构" );
				checkEmpty( emsDrugsOrdDTO.getCode_dep_mp_or(), "医嘱执行科室" );
				
				List<EmsDrugsSrvDTO> srvList = (List<EmsDrugsSrvDTO>)emsDrugsOrdDTO.getEmsdrugssrvdto();
				for (EmsDrugsSrvDTO emsCommonSrvDTO : srvList) {
					checkEmpty( emsCommonSrvDTO.getSortno_srv(), "序号" );
					checkEmpty( emsCommonSrvDTO.getFg_or(), "药品/费用标识" );
					checkEmpty( emsCommonSrvDTO.getCode_mm(), "药品/费用项目编码" );
					checkEmpty( emsCommonSrvDTO.getName_mm(), "药品/费用项目名称" );
					checkEmpty( emsCommonSrvDTO.getQuan_medu_cur(), "界面录入单次用量" );
					checkEmpty( emsCommonSrvDTO.getCode_medu_cur(), "界面录入单次用量单位" );
					checkEmpty( emsCommonSrvDTO.getFactor_cur(), "界面录入单次用量单位和基本包装单位换算系数" );
					checkEmpty( emsCommonSrvDTO.getQuan_cur(), "总量" );
					checkEmpty( emsCommonSrvDTO.getCode_pgku_cur(), "总量单位" );
					checkEmpty( emsCommonSrvDTO.getFactor_pgku_cur(), "总量单位换算系数" );
					checkEmpty( emsCommonSrvDTO.getPri(), "单价" );
					checkEmpty( emsCommonSrvDTO.getPri_std(), "标准价" );
					checkEmpty( emsCommonSrvDTO.getPri_ratio(), "价格系数" );
					checkEmpty( emsCommonSrvDTO.getCode_org_mp_srv(), "项目执行机构" );
					checkEmpty( emsCommonSrvDTO.getCode_dep_mp_srv(), "项目执行科室" );
				}
			}
		}
		
	}

	/*核心业务： 西药数据回写
	 */
	protected ResultDTO process(EntWsDrugsDTO param) throws BizException {

		//数据准备
		ThirdInfoUtils urils = new ThirdInfoUtils();
		entdo = urils.getEntDO(param.getCode_en());
		entopdo = urils.getEnEntOpDO(entdo.getId_ent());
		entHpdo = urils.getEntHpDO(entdo.getId_ent());
		
		List<EmsDrugsPresDTO> presList =(List<EmsDrugsPresDTO>) param.getEmsdrugspresdto();
		List<CiorderAggDO> aggs = new ArrayList<CiorderAggDO>();
		List<CiPresDO> preses = new ArrayList<CiPresDO>();
		List<OrdSrvMmDO> ordsrvmms = new ArrayList<OrdSrvMmDO>();

		for (EmsDrugsPresDTO emsDrugsPresDTO : presList) {
			CiPresDO ciPresDo = assemblePres(emsDrugsPresDTO);
			preses.add(ciPresDo);
			List<EmsDrugsOrdDTO> drugsOrds = (List<EmsDrugsOrdDTO>)emsDrugsPresDTO.getEmsdrugsorddto();
			if (drugsOrds == null || drugsOrds.size() == 0) {
				throw new BizException("医嘱信息传入为空");
			} else {
				for (EmsDrugsOrdDTO emsDrugsOrdDTO : drugsOrds) {
					CiorderAggDO aggdo = assebleOrderAgg(emsDrugsOrdDTO);
					aggs.add(aggdo);
					CiOrderDO order = aggdo.getParentDO();
					order.setId_didef(ciPresDo.getId_di());
					order.setCode_didef(emsDrugsPresDTO.getCodes_diag());
					
					ciPresDo.setDt_entry(order.getDt_effe());
					ciPresDo.setId_dep_or(order.getId_dep_or());
					ciPresDo.setId_emp_or(order.getId_emp_or());
					
					OrdSrvDO[] ordsrvs = aggdo.getOrdSrvDO();
					for (OrdSrvDO ordSrvDO : ordsrvs) {
						ordSrvDO.setId_pres(ciPresDo.getId_pres());
						// 物品临床标识为Y，物品标识就为Y
						ordSrvDO.setFg_mm(ordSrvDO.getFg_or());
					}
					ciPresDo.setId_dep_mp(ordsrvs[0].getId_dep_wh());
					ciPresDo.setId_prestp(ordsrvs[0].getId_srvtp());
					ciPresDo.setSd_srvtp(ordsrvs[0].getSd_srvtp());
					List<EmsDrugsSrvDTO> emsDrugsSrvs = (List<EmsDrugsSrvDTO>)emsDrugsOrdDTO.getEmsdrugssrvdto();
					for (EmsDrugsSrvDTO emsDrugsSrvDTO : emsDrugsSrvs) {
						// 组装ci_or_srv_mm信息
						OrdSrvMmDO ordsrvmm = assembleSrvMM(emsDrugsSrvDTO);
						ordsrvmms.add(ordsrvmm);
					}
				}
			}
		}
		// 保存
		ICiorderCudService ordAggService = ServiceFinder.find(ICiorderCudService.class);
		IOrdsrvmmCudService mmService = ServiceFinder.find(IOrdsrvmmCudService.class);
		IPresCudService presService = ServiceFinder.find(IPresCudService.class);
		CiorderAggDO[] aggarrays = ordAggService.save(aggs.toArray(new CiorderAggDO[0]));
		mmService.save(ordsrvmms.toArray(new OrdSrvMmDO[0]));
		//处方逻辑
		CiPresDO[] presArrays = presService.save(preses.toArray(new CiPresDO[0]));
		if(presArrays!=null&& presArrays.length>0){
			List<String> id_preses = new ArrayList<String>();
			for (CiPresDO presdo : presArrays) {
				id_preses.add(presdo.getId_pres());
			}
			ServiceFinder.find(IMpDgOutService.class).insertPresStatusData(id_preses.toArray(new String[0]));
		}
		//发送消息给执行域 
		this.fireSignEvent(aggarrays);
		ResultDTO rst = new ResultDTO();
		rst.setResultcode("0");
		rst.setResultmsg("药品医嘱保存成功");
		return rst;
	
	}

	/**
	 * 发送消息给执行域进行医嘱的拆分
	 * @param aggarrays
	 * @throws BizException
	 */
	protected void fireSignEvent(CiorderAggDO[] aggarrays) throws BizException {
		// 发送消息给执行域，进行拆分
		List<CiOrderDO> orders = new ArrayList<CiOrderDO>();
		for (CiorderAggDO ciorderAggDO : aggarrays) {
			orders.add(ciorderAggDO.getParentDO());
		}

		
		BDCommonEvent event = new BDCommonEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID,
				IEventType.TYPE_UPDATE_AFTER, orders.toArray(new CiOrderDO[0]));
		EventDispatcher.fireEvent(event);
	}
	
	/*校验异常信息
	 */
    public void checkEmpty(String attribute,String ErrMsg) throws BizException {
    	if(StringUtils.isEmpty(attribute)) {
			throw new BizException("'"+ErrMsg+"' 不能为空！");
		}
    }

	
	private CiorderAggDO assebleOrderAgg(EmsDrugsOrdDTO emsDrugsOrdDTO) throws BizException {
		CiorderAggDO aggdo = new CiorderAggDO();
		List<EmsDrugsSrvDTO> drugssrvs = emsDrugsOrdDTO.getEmsdrugssrvdto();
		CiOrderDO order = this.assembleOrder(emsDrugsOrdDTO);
		aggdo.setParent(order);
		List<OrdSrvDO> srvdos = asssembleSrv(drugssrvs, order);
		// 通过服务完善医嘱信息
		OrdSrvDO srvdo = srvdos.get(0);
		assembleOrderFromSrv(order, srvdo);
		aggdo.setOrdSrvDO(srvdos.toArray(new OrdSrvDO[0]));
		return aggdo;
	}

	/*组装服务信息
	 */
    private void assembleOrderFromSrv(CiOrderDO order, OrdSrvDO srvdo) throws BizException {
    	if(StringUtils.isEmpty(order.getId_srv())){
			order.setId_srv(srvdo.getId_srv());
			order.setId_srvtp(srvdo.getId_srvtp());
			order.setSd_srvtp(srvdo.getSd_srvtp());
			order.setId_srvca(srvdo.getId_srvca());
			order.setId_srv(srvdo.getId_srv());
			order.setName_or(srvdo.getName());
			order.setId_unit_med(srvdo.getId_medu());
			order.setQuan_medu(srvdo.getQuan_medu());
		}
	//	order.setFg_mp_in(CiOrdUtils.JudgeFgMpIn(order.getCode_entp(), order.getSd_srvtp()));
		if (order.getFg_mp_in()!=null) {
			if (order.getFg_mp_in().booleanValue()) {
				order.setTimes_mp_in(order.getTimes_cur());
			}
		}
	//	order.setId_orpltp(OrderUtils.getOrCLoopTpId(order));
		SrvMatchEmsParamDTO srvMatchEmsParamDTO = new SrvMatchEmsParamDTO();
		srvMatchEmsParamDTO.setId_srv(order.getId_srv());
		srvMatchEmsParamDTO.setCode_entp(order.getCode_entp());
		srvMatchEmsParamDTO.setId_emp(order.getId_emp_or());
		srvMatchEmsParamDTO.setId_dept(order.getId_dep_or());
		srvMatchEmsParamDTO.setId_org(order.getId_org());
		srvMatchEmsParamDTO.setId_grp(order.getId_grp());
		srvMatchEmsParamDTO.setSd_srvtp(order.getSd_srvtp());
		srvMatchEmsParamDTO.setDt_or(order.getDt_effe());
		srvMatchEmsParamDTO.setEmsappmode(EmsAppModeEnum.SVEMSAPPMODE);
		IEmsManagementService emsManagementService = ServiceFinder.find(IEmsManagementService.class);
		// 调用匹配医疗单算法服务
		FMap rstMap = emsManagementService.medSrvMatchEms(new SrvMatchEmsParamDTO[] { srvMatchEmsParamDTO });
		SrvMatchEmsRstDTO emsrstdto = (SrvMatchEmsRstDTO) rstMap.get(order.getId_srv());
		if (emsrstdto != null) {
			order.setId_srvof(emsrstdto.getId_ems());
			order.setFg_quickwflow(emsrstdto.getFg_quickwflow());
			order.setFuncclassstr(emsrstdto.getFuncclassstr());
		}else {			
			throw new BizException("没有匹配到医疗单");
		}		
	}

	/*组装医嘱信息
     */
	private CiOrderDO assembleOrder(EmsDrugsOrdDTO orddto) throws BizException {

		CiOrderDO ordo = new CiOrderDO();
		ordo.setStatus(DOStatus.NEW);
		String[] id_ors = new DBUtil().getOIDs(1);
		ordo.setId_or(id_ors[0]);
		
		ICIOrdRService ciOrdRService = ServiceFinder.find(ICIOrdRService.class);
		Integer result = ciOrdRService.getOrdMaxSortno(entdo.getId_ent());
		ordo.setSortno(++result);
		
		// 草药是否院内制剂
		ordo.setFg_hospital_herbpres(FBoolean.FALSE);
		ordo.setId_grp(entdo.getId_grp());
		ordo.setId_org(entdo.getId_org());
		ordo.setId_pat(entdo.getId_pat());
		ordo.setId_en(entdo.getId_ent());
		ordo.setId_entp(entdo.getId_entp());
		ordo.setCode_entp(entdo.getCode_entp());
		ordo.setFg_set(FBoolean.FALSE);
		ordo.setFg_orhp(FBoolean.FALSE);
		if (StringUtils.isNotEmpty(orddto.getSd_dripspeed())) {
			// 滴速档案 CI.OR.0991
			UdidocDO speed = UdidocUtils.getUdidocByCode("CI.OR.0991", orddto.getSd_dripspeed());
			if (speed != null) {
				ordo.setId_dripspeed(speed.getId_udidoc());
				ordo.setName_dripspeed(speed.getName());
			}
		}
		if (StringUtils.isNotEmpty(orddto.getSd_excessive_reason())) {
			// 超量开单原因 CI.OR.0815
			UdidocDO reasion = UdidocUtils.getUdidocByCode("CI.OR.0815", orddto.getSd_excessive_reason());
			if (reasion != null) {
				ordo.setId_excessive_reason(reasion.getId_udidoc());
				ordo.setSd_excessive_reason(reasion.getCode());
			}
		}
		if (StringUtils.isNotEmpty(orddto.getCode_freq_or())) {
			FreqDefDO freqdo = FreqUtils.getFreqDOByCode(orddto.getCode_freq_or());
			if(freqdo!=null){
				ordo.setFg_long(freqdo.getFg_long());
				ordo.setId_freq(freqdo.getId_freq());
				ordo.setFreqct(freqdo.getFreqct());
				ordo.setFrequnitct(freqdo.getFrequnitct());
				ordo.setFreq_name(freqdo.getName());
			}
		}else {
			ordo.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			ordo.setFg_long(FBoolean.FALSE);
		}
		if(StringUtils.isNotEmpty(orddto.getCode_or())){
			ordo.setCode_or(orddto.getCode_or());
		}else{
//			ordo.setCode_or(CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
		}
		// 取第一个服务赋值
		// ordo.setName_or(SetNameOR(ems));
		// 后面再加
		// ordo.setContent_or(oridrelinfo.getContent());
		ordo.setDes_or(orddto.getDes_or());
		if (StringUtils.isNotEmpty(orddto.getDays_or())) {
			ordo.setDays_or(new Integer(orddto.getDays_or()));
		}else {
			ordo.setDays_or(1);
		}
		if (StringUtils.isNotEmpty(orddto.getCode_route())) {
			MedUsageDO usage = RouteUtils.getMedUsageDO(orddto.getCode_route());
			if (usage != null) {
				ordo.setId_route(usage.getId_route());
				ordo.setRoute_name(usage.getName());
			}
		}
		ordo.setFg_urgent(new FBoolean(orddto.getFg_urgent()));
		ordo.setFg_pay_unit(new FBoolean(orddto.getFg_pay_unit()));
		ordo.setFg_sign(FBoolean.TRUE);
		ordo.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
		ordo.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
		ordo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		ordo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		ordo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		ordo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		if (StringUtils.isNotEmpty(orddto.getCode_dep_or())) {
			DeptDO dept_or = DeptUtils.getDeptByCode(orddto.getCode_dep_or());
			if (dept_or != null) {
				ordo.setId_dep_or(dept_or.getId_dep());
			}
		}
		ordo.setId_dep_sign(ordo.getId_dep_or());
		//执行科室
		if(StringUtils.isNotEmpty(orddto.getCode_dep_mp_or())){
			DeptDO dept_mp = DeptUtils.getDeptByCode(orddto.getCode_dep_mp_or());
			if (dept_mp != null) {
				ordo.setId_dep_mp(dept_mp.getId_dep());
			}
		}
		ordo.setId_org_or(ThirdInfoUtils.getOrgOfDept(ordo.getId_dep_or()));
		if (StringUtils.isNotEmpty(orddto.getCode_emp_or())) {
			PsnDocDO psndoc = PsndocUtils.getPsnDocByCode(orddto.getCode_emp_or());
			if (psndoc != null) {
				ordo.setId_emp_or(psndoc.getId_psndoc());
			}
		}

		ordo.setId_emp_sign(ordo.getId_emp_or());
		if (StringUtils.isNotEmpty(orddto.getDt_entry_or())) {
			ordo.setDt_entry(new FDateTime(orddto.getDt_entry_or()));
		} else {
	//		ordo.setDt_entry(CiOrdAppUtils.getServerDateTime());
		}
		ordo.setDt_sign(ordo.getDt_entry());
		ordo.setDt_effe(ordo.getDt_entry());
		if (ordo.getDays_or() != null) {
			ordo.setDt_end(ordo.getDt_effe().getDateTimeAfter(ordo.getDays_or()));
		}
		ordo.setDt_last_mp(ordo.getDt_effe());
		ordo.setDt_last_bl(ordo.getDt_effe());
	//	ordo.setDt_invalid(getDt_invalid(ordo.getDt_effe()));
		ordo.setFg_chk(ThirdInfoUtils.nullHandle(null));
		ordo.setFg_chk_stop(ThirdInfoUtils.nullHandle(null));
		ordo.setFg_canc(ThirdInfoUtils.nullHandle(null));
		ordo.setFg_chk_canc(ThirdInfoUtils.nullHandle(null));
		ordo.setFg_pmor(FBoolean.FALSE);
		ordo.setDes_pmor(null);
		ordo.setFg_active_pm(FBoolean.FALSE);
		ordo.setFg_ctlcp(null);
		ordo.setFg_mr(null);
		// 取第一个服务项目后再计算
		ordo.setFg_pres_outp(null);
//		GetTotalTimesBP times = new GetTotalTimesBP();
//		ordo.setTimes_cur(times.getTotalTimes(ordo.getDt_effe(),ordo.getId_freq(), ordo.getDays_or()));
//		
		ordo.setFg_mp_bed(null);
		ordo.setNote_or(orddto.getDes_or());
		// 诊疗医嘱需要保存
		AuditInfoUtil.addData(ordo);// 设置设计信息
		ordo.setFg_skintest(null);
		ordo.setFg_feertnable(FBoolean.TRUE); // 可退费标识

		// 添加字段 医嘱来源
		ordo.setFg_uncancelable(FBoolean.FALSE);// 医嘱执行不可逆标识
		ordo.setEu_orsrcmdtp(OrSourceFromEnum.THIRDPARTYSYS);
		// 第三方调用医嘱，保存医嘱医生站
		ordo.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_MT);
		ordo.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_MT);

		ordo.setFg_vip(entdo.getFg_ip());// vip号
		// 诊断信息
//		 ordo.setId_didef(ems.getId_didef());
//		 ordo.setCode_didef(ems.getCode_didef());
//		 ordo.setName_didef(ems.getName_didef());
		if (StringUtils.isNotEmpty(orddto.getCode_or())) {
			IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
			MedSrvDO[] medsrvs = service.findByAttrValStrings(MedSrvDO.CODE,new String[]{orddto.getCode_or()});
			if(medsrvs!=null&&medsrvs.length>0){
				MedSrvDO medsrv = medsrvs[0];
				ordo.setId_srv(medsrv.getId_srv());
				ordo.setId_srvtp(medsrv.getId_srvtp());
				ordo.setSd_srvtp(medsrv.getSd_srvtp());
				ordo.setId_srvca(medsrv.getId_srvca());
				ordo.setName_or(medsrv.getName());
				ordo.setQuan_medu(medsrv.getQuan_med());
				ordo.setId_unit_med(medsrv.getId_unit_med());
			}
		}
		ordo.setStatus(DOStatus.NEW);
		return ordo;
	
	}

	/**
	 * 组装OrdSrvMmDO信息
	 * 
	 * @param srvdto
	 * @return
	 * @throws BizException
	 */
	private OrdSrvMmDO assembleSrvMM(EmsDrugsSrvDTO srvdto) throws BizException {
		OrdSrvDO srvdo = new OrdSrvDO();
		MeterialDO mm = this.meterialMapTemp.get(srvdto.getCode_mm());
		OrdSrvMmDO srvmmdo = new OrdSrvMmDO();
		srvmmdo.setStatus(DOStatus.NEW);
		srvmmdo.setId_orsrv(srvdo.getId_orsrv());
		srvmmdo.setId_mm(mm.getId_mm());
		srvmmdo.setCode_mm(mm.getCode());
		srvmmdo.setName_mm(mm.getName());
		// 基本包装单位
		if (StringUtils.isNotEmpty(srvdto.getCode_pgku_base())) {
			MeasDocDO measdoc = BdMeasdocUtils.getMeasDocDOByCode(srvdto.getCode_pgku_base());
			if(measdoc!=null){
				srvmmdo.setId_pgku_base(measdoc.getId_measdoc());
			}
		}
		// 总量单位
		if (StringUtils.isNotEmpty(srvdto.getCode_pgku_cur())) {
			MeasDocDO measdoc = BdMeasdocUtils.getMeasDocDOByCode(srvdto.getCode_pgku_cur());
			if(measdoc!=null){
				srvmmdo.setId_pgku_cur(measdoc.getId_measdoc());
			}
		}
		// 总量
		if (StringUtils.isNotEmpty(srvdto.getQuan_cur())) {
			srvmmdo.setQuan_cur(new FDouble(srvdto.getQuan_cur()));
		}
		if (StringUtils.isNotEmpty(srvdto.getPri())) {
			srvmmdo.setPrice_pgku_cur(new FDouble(srvdto.getPri()));
		} else {
		//	srvmmdo.setPrice_pgku_cur(CiOrdUtils.getOrSrvMMPrice(srvmmdo.getId_mm(), srvmmdo.getId_pgku_base()));
		}
		if (StringUtils.isNotEmpty(srvdto.getQuan_num_base())) {
			srvmmdo.setQuan_num_base(new Integer(srvdto.getQuan_num_base()));
		}
		if (StringUtils.isNotEmpty(srvdto.getQuan_den_base())) {
			srvmmdo.setQuan_den_base(new Integer(srvdto.getQuan_den_base()));
		}
		// 零集换算系数
		if (StringUtils.isNotEmpty(srvdto.getFactor_pgku_cur())) {
			srvmmdo.setFactor(new FDouble(srvdto.getFactor_pgku_cur()));
		}
		// 医基换算系数
		if (StringUtils.isNotEmpty(srvdto.getFactor_cur())) {
			srvmmdo.setFactor_mb(new FDouble(srvdto.getFactor_cur()));
		}
		// srvmmdo.setId_dosage(srvdto.getId_dosage());
		// srvmmdo.setSd_dosage(srvdto.getSd_dosage());
		// srvmmdo.setId_pharm(srvdto.getId_pharm());
		// srvmmdo.setSd_pharm(srvdto.getSd_pharm());
		// srvmmdo.setId_val(srvdto.getId_val());
		// srvmmdo.setSd_val(srvdto.getSd_val());
		// srvmmdo.setId_pois(srvdto.getId_pois());
		// srvmmdo.setSd_pois(srvdto.getSd_pois());
		// srvmmdo.setId_anti(srvdto.getId_anti());
		// srvmmdo.setSd_anti(srvdto.getSd_anti());
		// srvmmdo.setId_mmtp(srvdto.getId_mmtp());
		// srvmmdo.setSd_mmtp(srvdto.getSd_mmtp());
		srvmmdo.setId_srv(srvdo.getId_srv());
		srvmmdo.setFg_otc(null);
		srvmmdo.setDays_available(null);// 领可用天数（门诊用）
		return srvmmdo;
	}

	/**
	 * 组装处方信息
	 * 
	 * @param emsDrugsPresDTO
	 * @return
	 * @throws BizException
	 */
	private CiPresDO assemblePres(EmsDrugsPresDTO emsDrugsPresDTO) throws BizException {
		CiPresDO pres = new CiPresDO();
		pres.setStatus(DOStatus.NEW);
		String[] id_press = new DBUtil().getOIDs(1);
		pres.setId_pres(id_press[0]);
		pres.setId_grp(entdo.getId_grp());
		pres.setId_org(entdo.getId_org());
		pres.setId_pati(entdo.getId_pat());
		pres.setId_entp(entdo.getId_entp());
		pres.setCode_entp(entdo.getCode_entp());
		pres.setId_en(entdo.getId_ent());
		pres.setCode(emsDrugsPresDTO.getCode_pres());
		pres.setCode_pois(emsDrugsPresDTO.getCode_pois());
		pres.setSd_prestp(emsDrugsPresDTO.getSd_prestp());
		// 处方类型
		UdidocDO prestpdoc = UdidocUtils.getUdidocByCode("CI.OR.0515", emsDrugsPresDTO.getSd_prestp());
		if (prestpdoc != null) {
			pres.setId_prestp(prestpdoc.getId_udidoc());
		}
		pres.setSd_prestpword(emsDrugsPresDTO.getSd_prestpword());
		UdidocDO presworddoc = UdidocUtils.getUdidocByCode("CI.OR.0800", emsDrugsPresDTO.getSd_prestpword());
		if(presworddoc!=null){
			pres.setId_prestpword(presworddoc.getId_udidoc());
		}
		if (StringUtils.isNotEmpty(emsDrugsPresDTO.getCodes_diag())) {
			DiagDefDO didef = BdDiDefUtils.getDiagDefDOByCode(emsDrugsPresDTO.getCodes_diag());
			if(didef!=null){
				pres.setId_di(didef.getId_didef());
				pres.setId_diitm(didef.getId_didef());
			}
		}
		return pres;
	}

	/**
	 * 组装服务，需要子类实现
	 * 
	 * @param drugssrvs
	 * @param order
	 * @return
	 * @throws BizException
	 */
	public List<OrdSrvDO> asssembleSrv(List<EmsDrugsSrvDTO> drugssrvs, CiOrderDO order) throws BizException {
		List<OrdSrvDO> srvdos = new ArrayList<OrdSrvDO>();
		List<String> code_mms = new ArrayList<String>();
		for (EmsDrugsSrvDTO emsDrugsSrvDTO : drugssrvs) {
			String code_mm = emsDrugsSrvDTO.getCode_mm();
			code_mms.add(code_mm);
		}
		MeterialDO[] meterials = this.getMeterialDOs(code_mms.toArray(new String[0]));
		Map<String, MeterialDO> meterialMap = this.getMeterialDOMap(meterials);
		if(meterialMap==null) {
			ICiOrdLogService logService = ServiceFinder.find(ICiOrdLogService.class);
			logService.log("急诊药品接口：传入的物品编码"+code_mms+"在IIH数据库中没有对应的物品！", Level.INFO);
		}
		if (meterialMapTemp == null) {
			meterialMapTemp = new HashMap<String, MeterialDO>();
		}
		meterialMapTemp.putAll(meterialMap);
		Map<String, MedSrvDO> medSrvMpa = this.getMedSrvMap(meterials);
		for (EmsDrugsSrvDTO emsDrugsSrvDTO : drugssrvs) {
			MeterialDO mm = meterialMap.get(emsDrugsSrvDTO.getCode_mm());
			MedSrvDO medsrv = medSrvMpa.get(mm.getId_srv());
			OrdSrvDO srvdo = assembleSrv(emsDrugsSrvDTO, medsrv, order);
			srvdos.add(srvdo);
		}
		return srvdos;
	}


	private OrdSrvDO assembleSrv(EmsDrugsSrvDTO emsDrugsSrvDTO, MedSrvDO medsrv, CiOrderDO order) throws BizException {

		OrdSrvDO srvdo = assembleSrvSuper(emsDrugsSrvDTO);
		if (medsrv != null) {
			srvdo.setId_srv(medsrv.getId_srv());
			srvdo.setSd_srvtp(medsrv.getSd_srvtp());
			srvdo.setId_srvtp(medsrv.getId_srvtp());
			srvdo.setCode_srv(medsrv.getCode());
			srvdo.setId_srvca(medsrv.getId_srvca());
			srvdo.setName(medsrv.getName());
			srvdo.setId_primd(medsrv.getId_primd());
			srvdo.setFg_bl(medsrv.getFg_bl());
		}
		srvdo.setId_or(order.getId_or());
		srvdo.setDt_last_bl(order.getDt_effe());
		srvdo.setDt_last_mp(order.getDt_effe());
		srvdo.setId_route(order.getId_route());
		srvdo.setId_freq(order.getId_freq());
		//开立相关信息  从ciorder获取
		srvdo.setId_org_srv(order.getId_org_or());//开立机构
		srvdo.setId_dep_srv(order.getId_dep_or());//开立科室
		srvdo.setId_wg_or(order.getId_wg_or());//开立医疗组
		srvdo.setId_emp_srv(order.getId_emp_or());//开立医生
		srvdo.setDt_create(order.getDt_entry());//开始时间
		return srvdo;
	
	}

	private OrdSrvDO assembleSrvSuper(EmsDrugsSrvDTO emsDrugsSrvDTO) throws BizException {
		OrdSrvDO srvdo = new OrdSrvDO();
		String[] id_orsrv = new DBUtil().getOIDs(1);
		srvdo.setId_orsrv(id_orsrv[0]);
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_pat(entdo.getId_pat());
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_entp(entdo.getId_entp());
		srvdo.setCode_entp(entdo.getCode_entp());
		srvdo.setDt_create(ThirdInfoUtils.getServerDateTime());
		srvdo.setId_pripat(entdo.getId_pripat());
		srvdo.setId_grp(entdo.getId_grp());
		srvdo.setId_org(entdo.getId_org());
		if(emsDrugsSrvDTO.getSortno_srv()!=null){
		srvdo.setSortno(new Integer(emsDrugsSrvDTO.getSortno_srv()));
		}
		if(StringUtils.isNotEmpty(emsDrugsSrvDTO.getSortno_srv())) 
		{
			srvdo.setSortno(new Integer(emsDrugsSrvDTO.getSortno_srv()));
		}
		srvdo.setFg_or(new FBoolean(emsDrugsSrvDTO.getFg_or()));
		srvdo.setName(emsDrugsSrvDTO.getName_mm());
		srvdo.setName_srv(emsDrugsSrvDTO.getName_mm());
		if(StringUtils.isNotEmpty(emsDrugsSrvDTO.getCode_dep_wh()))
		{
			DeptDO whdept = DeptUtils.getDeptByCode(emsDrugsSrvDTO.getCode_dep_wh());
			if (whdept != null) {
				srvdo.setId_dep_wh(whdept.getId_dep());
			}
		}
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getQuan_medu_cur())) {
			srvdo.setQuan_medu(new FDouble(emsDrugsSrvDTO.getQuan_medu_cur()));
		}
		if(StringUtils.isNotEmpty(emsDrugsSrvDTO.getQuan_cur())){
			srvdo.setQuan_total_medu(new FDouble(emsDrugsSrvDTO.getQuan_cur()));
		}
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getCode_medu_cur())) {
			MeasDocDO measdoc = BdMeasdocUtils.getMeasDocDOByCode(emsDrugsSrvDTO.getCode_medu_cur());
			if(measdoc==null)
				throw new BizException("单位编码："+emsDrugsSrvDTO.getCode_medu_cur()+" 不存在");
			srvdo.setId_medu(measdoc.getId_measdoc());
			srvdo.setMedu_name(measdoc.getName());
		}
		if(StringUtils.isNotEmpty(emsDrugsSrvDTO.getCode_routedes())) {
			MedUsageDesDO usage = RouteUtils.getUsageDes(emsDrugsSrvDTO.getCode_routedes());
			if (usage != null) {
				srvdo.setId_routedes(usage.getId_routedes());
				srvdo.setRoutedes_name(usage.getName());
			}
		}
		
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getSd_skintest_skip_reason())) {
			// 不皮试原因 CI.OR.0760
			UdidocDO udidoc = UdidocUtils.getUdidocByCode("CI.OR.0760", emsDrugsSrvDTO.getSd_skintest_skip_reason());
			if (udidoc != null) {
				srvdo.setId_skintest_skip_reason(udidoc.getId_udidoc());
			}
			srvdo.setSd_skintest_skip_reason(emsDrugsSrvDTO.getSd_skintest_skip_reason());
		}
		srvdo.setFg_base(new FBoolean(emsDrugsSrvDTO.getFg_base()));
		// 是否预防用药
		srvdo.setFg_propc((emsDrugsSrvDTO.getSd_propc() == null || "0".equals(emsDrugsSrvDTO.getSd_propc()))
				? FBoolean.FALSE : FBoolean.TRUE);
		// 不计费类型
		if(StringUtils.isNotEmpty(emsDrugsSrvDTO.getSd_nodispense())) {
			srvdo.setSd_nodispense(emsDrugsSrvDTO.getSd_nodispense());
		}
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getSd_nodispense())) {
			// 不计费类型档案 CI.OR.0865
			UdidocDO udidoc = UdidocUtils.getUdidocByCode("CI.OR.0865", emsDrugsSrvDTO.getSd_skintest_skip_reason());
			if (udidoc != null) {
				srvdo.setId_nodispense(udidoc.getId_udidoc());
			}
		}
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getPri())) {
			srvdo.setPri(new FDouble(emsDrugsSrvDTO.getPri()));
		}
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getPri_std())) {
			srvdo.setPri_std(new FDouble(emsDrugsSrvDTO.getPri_std()));
		}
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getPri_ratio())) {
			srvdo.setPri_ratio(new FDouble(emsDrugsSrvDTO.getPri_ratio()));
		}
		srvdo.setSd_hpsrvtp(emsDrugsSrvDTO.getSd_hpsrvtp());
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getSd_hpsrvtp())) {
			// 医保目录对照 BD.BL.1020
			UdidocDO udidoc = UdidocUtils.getUdidocByCode("BD.BL.1020", emsDrugsSrvDTO.getSd_hpsrvtp());
			srvdo.setId_hpsrvtp(udidoc.getId_udidoc());
		}
		srvdo.setFg_selfpay(new FBoolean(emsDrugsSrvDTO.getFg_selfpay()));
		srvdo.setFg_specill(new FBoolean(emsDrugsSrvDTO.getFg_specill()));
		srvdo.setFg_research(new FBoolean(emsDrugsSrvDTO.getFg_research()));
		
		// 科研项目产品还没有这个逻辑，后面可以添加
		if (StringUtils.isNotEmpty(emsDrugsSrvDTO.getCode_dep_mp_srv())) {
			DeptDO mpdept = DeptUtils.getDeptByCode(emsDrugsSrvDTO.getCode_dep_mp_srv());
			if (mpdept != null) {
				srvdo.setId_dep_mp(mpdept.getId_dep());
			}
		}
		srvdo.setId_org_mp(ThirdInfoUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_hp(entHpdo.getId_hp());
		return srvdo;
	}


	/**
	 * 通过物品编码查询出物品信息
	 * 
	 * @param code_mms
	 * @return
	 * @throws BizException
	 */
	private MeterialDO[] getMeterialDOs(String[] code_mms) throws BizException {
		IMeterialMDORService service = ServiceFinder.find(IMeterialMDORService.class);
		MeterialDO[] mms = service.findByAttrValStrings(MeterialDO.CODE, code_mms);
		return mms;
	}

	/**
	 * 将物品信息缓存在map中
	 * 
	 * @param code_mms
	 * @return
	 * @throws BizException
	 */
	private Map<String, MeterialDO> getMeterialDOMap(MeterialDO[] merials) throws BizException {
		if (merials != null && merials.length > 0) {
			Map<String, MeterialDO> map = new HashMap<String, MeterialDO>();
			for (MeterialDO meterialDO : merials) {
				map.put(meterialDO.getCode(), meterialDO);
			}
			return map;
		}
		return null;
	}

	/**
	 * 查询服务信息
	 * 
	 * @param meterials
	 * @return
	 * @throws BizException
	 */
	private Map<String, MedSrvDO> getMedSrvMap(MeterialDO[] meterials) throws BizException {
		List<String> id_srvs = new ArrayList<String>();
		for (MeterialDO meterial : meterials) {
			id_srvs.add(meterial.getId_srv());
		}
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medsrvs = service.findByIds(id_srvs.toArray(new String[0]), FBoolean.FALSE);
		Map<String, MedSrvDO> map = new HashMap<String, MedSrvDO>();
		for (MedSrvDO medSrvDO : medsrvs) {
			map.put(medSrvDO.getId_srv(), medSrvDO);
		}
		return map;
	}
}
