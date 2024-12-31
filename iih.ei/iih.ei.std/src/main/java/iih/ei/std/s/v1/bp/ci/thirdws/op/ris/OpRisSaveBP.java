package iih.ei.std.s.v1.bp.ci.thirdws.op.ris;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.FDoubleUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.ems.d.EmsAppModeEnum;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiAppRisSheetOrDO;
import iih.ci.ord.app.d.CiapprissheetAggDO;
import iih.ci.ord.app.i.ICiapprissheetCudService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.i.external.common.ICIOrdRService;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ei.std.d.v1.ci.base.EmsCommonOrdDTO;
import iih.ei.std.d.v1.ci.base.EmsCommonSrvDTO;
import iih.ei.std.d.v1.ci.base.EmsRstDTO;
import iih.ei.std.d.v1.ci.ent.d.ResultDTO;
import iih.ei.std.d.v1.ci.lis.d.EmsLisSrvDTO;
import iih.ei.std.d.v1.ci.ris.d.EmsRisOrdDTO;
import iih.ei.std.d.v1.ci.ris.d.EmsRisPrintDTO;
import iih.ei.std.d.v1.ci.ris.d.EmsRisSrvDTO;
import iih.ei.std.d.v1.ci.ris.d.EntWsRisDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.BdDiDefUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.DeptUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.LogUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.PsndocUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.ThirdInfoUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.UdidocUtils;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.utils.AuditInfoUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;
/**
 * @code 门诊检查回写BP
 * @author LiYue
 */
public class OpRisSaveBP extends IIHServiceBaseBP<EntWsRisDTO, ResultDTO>{
	public static final String  sd_su_obs="0";
	public static final String id_su_obs="@@@@AA1000000006JVIO";
	public static final String id_udidoclist_code="BD.SRV.1010";//检查部位list编码
	ThirdInfoUtils urils = new ThirdInfoUtils();
	private PatiVisitDO entdo;
	private OutpatientDO entopdo;
	private EntHpDO entHpdo;
	
	//入参校验
	protected void checkParam(EntWsRisDTO entWsRisDTO) throws BizException {

		if (StringUtils.isEmpty(entWsRisDTO.getCode_org())) {
			throw new BizException("就诊信息中的所属组织不能为空\n");
		}
		if (StringUtils.isEmpty(entWsRisDTO.getCode_pat())) {
			throw new BizException("就诊信息中的患者编码不能为空\n");
		}
		if (StringUtils.isEmpty(entWsRisDTO.getCode_entp())) {
			throw new BizException("就诊信息中的就诊类型编码不能为空\n");
		}
		if (StringUtils.isEmpty(entWsRisDTO.getCode_dep_phy())) {
			throw new BizException("就诊信息中的当前就诊科室不能为空\n");
		}
		if (StringUtils.isEmpty(entWsRisDTO.getCode_emp_phy())) {
			throw new BizException("就诊信息中的当前主管医生不能为空\n");
		}
		List<EmsRisPrintDTO> printList = (List<EmsRisPrintDTO>)entWsRisDTO.getEmsrisprintdto();
		for (int i = 0; i < printList.size(); i++) {
			EmsRisPrintDTO emsRisPrintDTO = printList.get(i);
			if (StringUtils.isEmpty(emsRisPrintDTO.getCode_app())) {
				throw new BizException("第" + (i + 1) + "个打印单据信息中的申请单打印号不能为空\n");
			}
			if (StringUtils.isEmpty(emsRisPrintDTO.getAmt_app())) {
				throw new BizException("第" + (i + 1) + "个打印单据信息中的申请金额不能为空\n");
			}
			List<EmsRisOrdDTO> ordList = (List<EmsRisOrdDTO>)emsRisPrintDTO.getEmsrisorddto();
			for (int j = 0; j < ordList.size(); j++) {
				EmsRisOrdDTO emsRisOrdDTO = ordList.get(j);
				if (StringUtils.isEmpty(emsRisOrdDTO.getSortno_or())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的医嘱序号 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_or())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的医嘱编码 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_srv_or())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的检验项目编码 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getName_srv_or())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的检验项目名称 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getNo_applyform())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的检验申请单号 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getDt_plan())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的计划检查日期不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getSd_pps())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的检查目的 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getQuan_medu_or())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的单次数量 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_org_or())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的开立机构 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_dep_or())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的开立部门 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_emp_or())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的开立医生 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getDt_entry_or())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的开立日期 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_org_mp_or())) {
					throw new BizException("第" + (j + 1) + "个医嘱信息中的医嘱执行机构 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_dep_mp_or())) {

					throw new BizException("第" + (j + 1) + "个医嘱信息中的医嘱执行科室 不能为空\n");
				}
				List<EmsRisSrvDTO> srvList = (List<EmsRisSrvDTO>)emsRisOrdDTO.getEmsrissrvdto();
				for (int k = 0; k < srvList.size(); k++) {
					EmsRisSrvDTO srvDTO = srvList.get(k);
					if (StringUtils.isEmpty(srvDTO.getCode_srv())) {

						throw new BizException("第" + (k + 1) + "个费用明细中的费用项目编码不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getName_srv())) {

						throw new BizException("第" + (k + 1) + "个费用明细中的费用项目名称不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getQuan_medu_srv())) {

						throw new BizException("第" + (k + 1) + "个费用明细中的费用项目单次数量不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getPri())) {

						throw new BizException("第" + (k + 1) + "个费用明细中的单价不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getPri_std())) {

						throw new BizException("第" + (k + 1) + "个费用明细中的标准价不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getPri_ratio())) {

						throw new BizException("第" + (k + 1) + "个费用明细中的价格系数不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getCode_org_mp_srv())) {

						throw new BizException("第" + (k + 1) + "个费用明细中的费用执行机构不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getCode_dep_mp_srv())) {

						throw new BizException("第" + (k + 1) + "个费用明细中的费用执行科室不能为空\n");
					}
				}

			}
		}

	}

	//检查数据组合保存
	protected ResultDTO process(EntWsRisDTO entWsRisDTO) throws BizException {
		// 数据准备
		entdo = urils.getEntDO(entWsRisDTO.getCode_en());
		entopdo = urils.getEnEntOpDO(entdo.getId_ent());
		entHpdo = urils.getEntHpDO(entdo.getId_ent());
		
		//设置Agg容器
		List<CiorderAggDO> ciorderAggDOList = new ArrayList<>();
		//设置检查申请单容器
		List<CiapprissheetAggDO> CiapprissheetAggDOList = new ArrayList<>();
		List<OrdApObsDO> OrdApObsDOlist = new ArrayList<>();
		//获取打印list
		List<EmsRisPrintDTO> emsRisPrintDTOList = (List<EmsRisPrintDTO>)entWsRisDTO.getEmsrisprintdto();
		
		for (EmsRisPrintDTO emsRisPrintDTO : emsRisPrintDTOList) {
			//组装打印数据
			CiAppRisSheetDO ciAppRisSheetDO = new CiAppRisSheetDO();
			List<CiAppRisSheetOrDO> ciAppRisSheetOrDOList = new ArrayList<>();
			
			ciAppRisSheetDO=assmbleRisSheet(emsRisPrintDTO);
			String[] id_sheet = new DBUtil().getOIDs(1);
			ciAppRisSheetDO.setId_ciapprissheet(id_sheet[0]);
			
			FDouble amt_app_all =FDouble.ZERO_DBL;
			List<EmsRisOrdDTO> ordList = (List<EmsRisOrdDTO>)emsRisPrintDTO.getEmsrisorddto();
			for (EmsRisOrdDTO emsRisOrdDTO : ordList) {
				
				//aggdo赋值
				CiorderAggDO aggdo = assebleOrderAgg(emsRisOrdDTO);
				//拼接医嘱内容
				CiOrderDO orderDO = aggdo.getParentDO();
				//
				UdidocDO udidoc = UdidocUtils.getUdidocByCode(id_udidoclist_code, emsRisOrdDTO.getSd_body());
				orderDO.setContent_or(orderDO.getName_or());
				orderDO.setContent_or(ThirdInfoUtils
						.create(orderDO.getSd_srvtp(),emsRisOrdDTO.getName_srv_or(), udidoc.getName(),FBoolean.FALSE)
						.toString());
				//生成主键
				String[] id_or = new DBUtil().getOIDs(2);
				orderDO.setId_or(id_or[0]);
				assebleRisOrder(orderDO,emsRisOrdDTO,aggdo);
				assembleordSrvDO(aggdo,entdo,orderDO);
				

				ciorderAggDOList.add(aggdo);
				
				//打印子表
				CiAppRisSheetOrDO ciAppRisSheetOrDO = new CiAppRisSheetOrDO();
				ciAppRisSheetOrDO.setId_ciapprissheet(id_sheet[0]);
				//ciAppRisSheetOrDO.setAmt_app(new FDouble(ciAppRisSheetDO.getAmt_app()));
				
				ciAppRisSheetOrDO.setId_or(orderDO.getId_or());
				ciAppRisSheetOrDO.setId_orobs(id_or[1]);
				ciAppRisSheetOrDO.setId_srv(orderDO.getId_srv());
				ciAppRisSheetOrDO.setName_or(emsRisOrdDTO.getName_srv_or());
				ciAppRisSheetOrDO.setId_dep_app(orderDO.getId_dep_mp());
				ciAppRisSheetOrDO.setId_dep_mp(orderDO.getId_dep_mp());
				ciAppRisSheetOrDO.setId_emp_app(orderDO.getId_emp_or());
				ciAppRisSheetOrDO.setDt_app(orderDO.getDt_entry());
				ciAppRisSheetOrDO.setSd_pps(emsRisOrdDTO.getSd_pps());
				ciAppRisSheetOrDO.setId_pps(udidoc.getId_udidoc());
				ciAppRisSheetOrDO.setStatus(DOStatus.NEW);
				
				
				
				//打印补充
				ciAppRisSheetDO.setClinicalzztz(emsRisOrdDTO.getClinicalzztz());
				ciAppRisSheetDO.setSd_pps(emsRisOrdDTO.getSd_pps());
				ciAppRisSheetDO.setId_pps(udidoc.getId_udidoc());
				ciAppRisSheetDO.setSd_body(emsRisOrdDTO.getSd_body());
				ciAppRisSheetDO.setDt_plan(new FDateTime(emsRisOrdDTO.getDt_plan()));
				ciAppRisSheetDO.setNo_applyform(emsRisOrdDTO.getNo_applyform());
				ciAppRisSheetDO.setFg_hecominsur(new FBoolean(entWsRisDTO.getFg_hecominsur()));
				ciAppRisSheetDO.setFg_vip(new FBoolean(entWsRisDTO.getFg_vip()));
				ciAppRisSheetDO.setId_pat(entdo.getId_pat());
				ciAppRisSheetDO.setId_entp(entdo.getId_entp());
				ciAppRisSheetDO.setCode_entp(entdo.getCode_entp());
				ciAppRisSheetDO.setId_en(entdo.getId_ent());
				ciAppRisSheetDO.setId_grp(entdo.getId_grp());
				ciAppRisSheetDO.setId_org(entdo.getId_org());
				ciAppRisSheetDO.setId_dep_app(orderDO.getId_dep_mp());
				//ciAppRisSheetDO.setId_dep_app(orderDO.getId_dep_or());
				ciAppRisSheetDO.setId_emp_app(orderDO.getId_emp_or());
				ciAppRisSheetDO.setDt_app(orderDO.getDt_entry());
				
				//计算打印子表金额
				OrdSrvDO[] ordSrvDO = aggdo.getOrdSrvDO();
				FDouble amt_app = FDouble.ZERO_DBL;
				for (OrdSrvDO ordSrvDO2 : ordSrvDO) {
					if(FDoubleUtils.isNullOrZero(ordSrvDO2.getPri()) || FBoolean.FALSE.equals(ordSrvDO2.getFg_bl()))
						continue;
					//单次价格
					FDouble pri = ordSrvDO2.getPri();
					//次数
					Integer times_cur = orderDO.getTimes_cur();
					FDouble time_cur1=new FDouble(times_cur);
					//单次数量
					FDouble quan_medu = ordSrvDO2.getQuan_medu();
					if (time_cur1!=null) {
						FDouble amt_app_srv=time_cur1.multiply(quan_medu).multiply(pri);
						amt_app=amt_app_srv.add(amt_app);
					}
					
				}
				amt_app_all =amt_app.add(amt_app_all);
				ciAppRisSheetOrDO.setOr_total_pri(amt_app);
				ciAppRisSheetDO.setName_app(emsRisOrdDTO.getName_srv_or());
				
				ciAppRisSheetOrDOList.add(ciAppRisSheetOrDO);		
				//组装检验申请单
				OrdApObsDO ordApObsDO =assembleOrdApObs(emsRisOrdDTO,orderDO);
				orderDO.setApplyno(ordApObsDO.getNo_applyform());
				OrdApObsDOlist.add(ordApObsDO);
					
			}
			//打印主表金额
			ciAppRisSheetDO.setAmt_app(amt_app_all);
			//获取医嘱信息
			//打印数据放入集合
			CiapprissheetAggDO ciapprissheetAggDO = new CiapprissheetAggDO();
			ciapprissheetAggDO.setParent(ciAppRisSheetDO);
			ciapprissheetAggDO.setCiAppRisSheetOrDO(ciAppRisSheetOrDOList.toArray(new CiAppRisSheetOrDO[0]));
			CiapprissheetAggDOList.add(ciapprissheetAggDO);
			
			
		}
		//保存 医嘱，打印单，申请单信息
		return saveRisOrder(ciorderAggDOList.toArray(new CiorderAggDO[ciorderAggDOList.size()]),CiapprissheetAggDOList.toArray(new CiapprissheetAggDO[CiapprissheetAggDOList.size()]),OrdApObsDOlist.toArray(new OrdApObsDO[OrdApObsDOlist.size()]));
	
	
	}

	private void assembleordSrvDO(CiorderAggDO aggdo, PatiVisitDO entdo2, CiOrderDO orderDO) {

		OrdSrvDO[] ordSrvDO = aggdo.getOrdSrvDO();
		for (OrdSrvDO srv : ordSrvDO) {
			srv.setFreq_name(IBdSrvDictCodeConst.NAME_FREQNUNITCT_ITEM_ONCE);
			srv.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			srv.setId_en(entdo.getId_ent());
			srv.setId_pat(entdo.getId_pat());
			srv.setId_entp(entdo.getId_entp());
			srv.setCode_entp(entdo.getCode_entp());
			srv.setId_or(orderDO.getId_or());
			srv.setEu_sourcemd(0);
		}
			
	}

	private void assebleRisOrder(CiOrderDO orderDO, EmsRisOrdDTO emsRisOrdDTO, CiorderAggDO aggdo) throws BizException {

		//医嘱拼接
		orderDO.setContent_or(orderDO.getName_or());
		orderDO.setContent_or(urils
				.create(orderDO.getSd_srvtp(), aggdo.getOrdSrvDO()[0].getName(), orderDO.getRoute_name(), orderDO.getFg_urgent())
				.toString());
		orderDO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		orderDO.setId_dep_or(urils.getDep(emsRisOrdDTO.getCode_dep_or()).getId_dep());
		orderDO.setDt_sign(new FDateTime());
		orderDO.setId_srvca(aggdo.getOrdSrvDO()[0].getId_srvca());
		orderDO.setId_srvca(aggdo.getOrdSrvDO()[0].getId_srvtp());
		orderDO.setDt_effe(new FDateTime(emsRisOrdDTO.getDt_plan()));
		orderDO.setId_dep_mp(urils.getDep(emsRisOrdDTO.getCode_dep_mp_or()).getId_dep());
		orderDO.setApplyno(emsRisOrdDTO.getNo_applyform());
		//诊断
		if(StringUtils.isNotEmpty(emsRisOrdDTO.getCode_diag())){
			DiagDefDO didef = BdDiDefUtils.getDiagDefDOByCode(emsRisOrdDTO.getCode_diag());
			if(didef!=null){
				orderDO.setId_didef(didef.getId_didef());
				orderDO.setCode_didef(didef.getCode());
				orderDO.setName_didef(didef.getName());
			}
		}
			
	}

	/**
	 * 组装aggdo
	 */
	public CiorderAggDO assebleOrderAgg(EmsRisOrdDTO emsrisOrdDTO) throws BizException {
		CiorderAggDO aggdo = new CiorderAggDO();
		List<EmsRisSrvDTO> drugssrvs = (List<EmsRisSrvDTO>)emsrisOrdDTO.getEmsrissrvdto();
		CiOrderDO order = this.assembleOrder(emsrisOrdDTO);
		aggdo.setParent(order);
		List<OrdSrvDO> srvdos = asssembleSrv(drugssrvs, order);
		// 通过服务完善医嘱信息
		OrdSrvDO srvdo = srvdos.get(0);
		assembleOrderFromSrv(order, srvdo);
		aggdo.setOrdSrvDO(srvdos.toArray(new OrdSrvDO[0]));
		assembleContent_or(aggdo);
		return aggdo;
	}
	
	private void assembleContent_or(CiorderAggDO aggdo) {
		// TODO Auto-generated method stub
		
	}

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
		order.setFg_mp_in(ThirdInfoUtils.JudgeFgMpIn(order.getCode_entp(), order.getSd_srvtp()));
		if (order.getFg_mp_in()!=null) {
			if (order.getFg_mp_in().booleanValue()) {
				order.setTimes_mp_in(order.getTimes_cur());
			}
		}
	//	order.setId_orpltp(ThirdInfoUtils.getOrCLoopTpId(order));
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

	private List<OrdSrvDO> asssembleSrv(List<EmsRisSrvDTO> drugssrvs, CiOrderDO order) throws BizException {
		List<OrdSrvDO> srvdos = new ArrayList<OrdSrvDO>();
		List<String> code_srvs = new ArrayList<String>();
		List<String> id_srvs = new ArrayList<String>();
		if(drugssrvs!=null) {
		for (EmsRisSrvDTO emsDrugsSrvDTO : drugssrvs) {
			String code_srv = emsDrugsSrvDTO.getCode_srv();	
			if(code_srv==null||code_srv.trim().length()==0)
				continue;
			code_srvs.add(code_srv);
		}		
		}
		if(code_srvs.size()>0) {
		Map<String,MedSrvDO> medSrvMpa = this.getMedSrvMap(code_srvs);
		for (EmsRisSrvDTO emsDrugsSrvDTO : drugssrvs) {
			MedSrvDO medsrv = medSrvMpa.get(emsDrugsSrvDTO.getCode_srv());
			OrdSrvDO srvdo = assembleSrv(emsDrugsSrvDTO,medsrv,order);
			id_srvs.add(srvdo.getId_srv());
			srvdos.add(srvdo);
		}
		}
		//如果医嘱的服务id_srv不为空，并且在费用项目中不存在，需要将医嘱的服务编码对应的服务，存入到ci_or_srv表中
		if(StringUtils.isNotEmpty(order.getId_srv())&&!id_srvs.contains(order.getId_srv())){
			OrdSrvDO srvdo = asssembleSrv(order);
			srvdos.add(0, srvdo);
		}
		return srvdos;
	}
	
	private OrdSrvDO asssembleSrv(CiOrderDO order) throws BizException {
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO medsrv = service.findById(order.getId_srv());
		OrdSrvDO srvdo = new OrdSrvDO();
		String[] id_orsrv = new DBUtil().getOIDs(1);
		srvdo.setId_orsrv(id_orsrv[0]);
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_pat(entdo.getId_pat());
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_entp(entdo.getId_entp());
		srvdo.setCode_entp(entdo.getCode_entp());
		srvdo.setDt_create(new FDateTime());
		srvdo.setId_pripat(entdo.getId_pripat());
		srvdo.setId_grp(entdo.getId_grp());
		srvdo.setId_org(entdo.getId_org());
		srvdo.setSortno(0);
		
		srvdo.setId_org_mp(order.getId_dep_mp());
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_hp(entHpdo.getId_hp());
		
		srvdo.setId_srv(medsrv.getId_srv());
		srvdo.setSd_srvtp(medsrv.getSd_srvtp());
		srvdo.setId_srvtp(medsrv.getId_srvtp());
		srvdo.setCode_srv(medsrv.getCode());
		srvdo.setId_srvca(medsrv.getId_srvca());
		srvdo.setName(medsrv.getName());
		srvdo.setId_primd(medsrv.getId_primd());
		srvdo.setFg_bl(medsrv.getFg_bl());
		srvdo.setFg_or(medsrv.getFg_or());
		srvdo.setName(medsrv.getName());
		srvdo.setName_srv(medsrv.getName());
		
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
		srvdo.setId_dep_mp(order.getId_dep_mp());
		srvdo.setQuan_medu(order.getQuan_medu());
		srvdo.setQuan_total_medu(order.getQuan_medu());
		srvdo.setId_medu(order.getId_unit_med());
		srvdo.setMedu_name(order.getName_unit_med());
		return srvdo;
	}

	/**
	 * 组装服务信息
	 * 
	 * @param srvdto
	 * @param medsrv
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO assembleSrv(EmsRisSrvDTO emsDrugsSrvDTO, MedSrvDO medsrv, CiOrderDO order) {
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		//MedSrvDO medsrv = service.findById(order.getId_srv());
		OrdSrvDO srvdo = new OrdSrvDO();
		String[] id_orsrv = new DBUtil().getOIDs(1);
		srvdo.setId_orsrv(id_orsrv[0]);
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_pat(entdo.getId_pat());
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_entp(entdo.getId_entp());
		srvdo.setCode_entp(entdo.getCode_entp());
		srvdo.setDt_create(new FDateTime());
		srvdo.setId_pripat(entdo.getId_pripat());
		srvdo.setId_grp(entdo.getId_grp());
		srvdo.setId_org(entdo.getId_org());
		srvdo.setSortno(0);
		
		srvdo.setId_org_mp(order.getId_dep_mp());
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_hp(entHpdo.getId_hp());
		
		srvdo.setId_srv(medsrv.getId_srv());
		srvdo.setSd_srvtp(medsrv.getSd_srvtp());
		srvdo.setId_srvtp(medsrv.getId_srvtp());
		srvdo.setCode_srv(medsrv.getCode());
		srvdo.setId_srvca(medsrv.getId_srvca());
		srvdo.setName(medsrv.getName());
		srvdo.setId_primd(medsrv.getId_primd());
		srvdo.setFg_bl(medsrv.getFg_bl());
		srvdo.setFg_or(medsrv.getFg_or());
		srvdo.setName(medsrv.getName());
		srvdo.setName_srv(medsrv.getName());
		
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
		srvdo.setId_dep_mp(order.getId_dep_mp());
		srvdo.setQuan_medu(order.getQuan_medu());
		srvdo.setQuan_total_medu(order.getQuan_medu());
		srvdo.setId_medu(order.getId_unit_med());
		srvdo.setMedu_name(order.getName_unit_med());
		return srvdo;
	}

	/**
	 * 通过服务编码查询服务项目
	 * 
	 * @param code_srvs
	 * @return
	 * @throws BizException
	 */
	private Map<String, MedSrvDO> getMedSrvMap(List<String> code_srvs) throws BizException {
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medsrvs = service.findByAttrValStrings(MedSrvDO.CODE, code_srvs.toArray(new String[0]));
		Map<String, MedSrvDO> map = new HashMap<String, MedSrvDO>();
		for (MedSrvDO medSrvDO : medsrvs) {
			map.put(medSrvDO.getCode(), medSrvDO);
		}
		return map;
	}

	private CiOrderDO assembleOrder(EmsRisOrdDTO ordDTO) throws BizException {


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
		// 取第一个服务然后补齐
		// ordo.setId_srvtp(oridrelinfo.getId_srvtp());
		// ordo.setSd_srvtp(oridrelinfo.getSd_srvtp());
		// ordo.setId_srv(ems.getId_srv());
		ordo.setFg_set(FBoolean.FALSE);
		ordo.setFg_orhp(FBoolean.FALSE);
			ordo.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			ordo.setFg_long(FBoolean.FALSE);
		if(StringUtils.isNotEmpty(ordDTO.getCode_or())){
			ordo.setCode_or(ordDTO.getCode_or());
		}
		ordo.setDes_or(ordDTO.getDes_or());
		ordo.setDays_or(1);
	
		ordo.setFg_urgent(new FBoolean(ordDTO.getFg_urgent()));
		ordo.setFg_pay_unit(new FBoolean(ordDTO.getFg_pay_unit()));
		ordo.setFg_sign(FBoolean.TRUE);
		ordo.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
		ordo.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
		ordo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		ordo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		ordo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		ordo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		if (StringUtils.isNotEmpty(ordDTO.getCode_dep_or())) {
			DeptDO dept_or = DeptUtils.getDeptByCode(ordDTO.getCode_dep_or());
			if (dept_or != null) {
				ordo.setId_dep_or(dept_or.getId_dep());
			}
		}
		ordo.setId_dep_sign(ordo.getId_dep_or());
		//执行科室
		if(StringUtils.isNotEmpty(ordDTO.getCode_dep_mp_or())){
			DeptDO dept_mp = DeptUtils.getDeptByCode(ordDTO.getCode_dep_mp_or());
			if (dept_mp != null) {
				ordo.setId_dep_mp(dept_mp.getId_dep());
			}
		}
	//	ordo.setId_org_or(CiOrdUtils.getOrgOfDept(ordo.getId_dep_or()));
		if (StringUtils.isNotEmpty(ordDTO.getCode_emp_or())) {
			PsnDocDO psndoc = PsndocUtils.getPsnDocByCode(ordDTO.getCode_emp_or());
			if (psndoc != null) {
				ordo.setId_emp_or(psndoc.getId_psndoc());
			}
		}

		ordo.setId_emp_sign(ordo.getId_emp_or());
		if (StringUtils.isNotEmpty(ordDTO.getDt_entry_or())) {
			ordo.setDt_entry(new FDateTime(ordDTO.getDt_entry_or()));
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
		ordo.setFg_pmor(FBoolean.FALSE);
		ordo.setDes_pmor(null);
		ordo.setFg_active_pm(FBoolean.FALSE);
		ordo.setFg_ctlcp(null);
		ordo.setFg_mr(null);
		// 取第一个服务项目后再计算
		ordo.setFg_pres_outp(null);
		
		ordo.setFg_mp_bed(null);
		ordo.setNote_or(ordDTO.getDes_or());
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
		 ordo.setId_didef(ordo.getId_didef());
		 ordo.setCode_didef(ordo.getCode_didef());
		 ordo.setName_didef(ordo.getName_didef());
		if (StringUtils.isNotEmpty(ordDTO.getCode_srv_or())) {
			IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
			MedSrvDO[] medsrvs = service.findByAttrValStrings(MedSrvDO.CODE,new String[]{ordDTO.getCode_srv_or()});
			if(medsrvs!=null&&medsrvs.length>0){
				MedSrvDO medsrv = medsrvs[0];
				ordo.setId_srv(medsrv.getId_srv());
				ordo.setId_srvtp(medsrv.getId_srvtp());
				ordo.setSd_srvtp(medsrv.getSd_srvtp());
				ordo.setId_srvca(medsrv.getId_srvca());
				ordo.setName_or(medsrv.getName());
				if(StringUtils.isNotEmpty(ordDTO.getQuan_medu_or())){
					ordo.setQuan_medu(new FDouble(ordDTO.getQuan_medu_or()));
				}else{
					ordo.setQuan_medu(medsrv.getQuan_med());
				}
				ordo.setId_unit_med(medsrv.getId_unit_med());
			}
		}
		ordo.setStatus(DOStatus.NEW);
		return ordo;
	
	
	}

	private ResultDTO saveRisOrder(CiorderAggDO[] CiAggDo, CiapprissheetAggDO[] risAggDo, OrdApObsDO[] apObsDo) throws BizException {
		ICiorderCudService service = ServiceFinder.find(ICiorderCudService.class);
		ICiapprissheetCudService service1 = ServiceFinder.find(ICiapprissheetCudService.class);
		ICiorapprisCudService service2=ServiceFinder.find(ICiorapprisCudService.class);
		ResultDTO result = new ResultDTO();
		CiAggDo = service.save(CiAggDo);
		service.save(CiAggDo);
		service1.save(risAggDo);
		service2.save(apObsDo);
		this.fireSignEvent(CiAggDo);
		result.setResultcode("0");
		result.setResultmsg("检查医嘱信息保存成功");		
		return result;
	}
	
	private OrdApObsDO assembleOrdApObs(EmsRisOrdDTO emsRisOrdDTO,CiOrderDO orderDO) throws BizException {
		OrdApObsDO ordApObsDO = new OrdApObsDO();
		String[] id_or = new DBUtil().getOIDs(2);
		ordApObsDO.setStatus(DOStatus.NEW);
		ordApObsDO.setId_or(orderDO.getId_or());
		ordApObsDO.setId_orobs(id_or[1]);
		ordApObsDO.setId_di(orderDO.getId_didef());
		ordApObsDO.setNo_applyform(ThirdInfoUtils.getApplyNo(orderDO.getSd_srvtp()));
		ordApObsDO.setDt_plan(new FDateTime(emsRisOrdDTO.getDt_plan()));
		ordApObsDO.setName_diag(emsRisOrdDTO.getName_diag());
		ordApObsDO.setClinicalzztz(emsRisOrdDTO.getClinicalzztz());
		ordApObsDO.setSd_pps(emsRisOrdDTO.getSd_pps());
		UdidocDO udidoc = UdidocUtils.getUdidocByCode(id_udidoclist_code, emsRisOrdDTO.getSd_body());
		if(udidoc!=null){
			LogUtils.Logger("传入的检查部位编码在his中不存在"+emsRisOrdDTO.getSd_body());
			ordApObsDO.setId_pps(udidoc.getId_udidoc());
		}
		ordApObsDO.setFg_urgent(new FBoolean(emsRisOrdDTO.getFg_urgent()));
		ordApObsDO.setCreatedby(emsRisOrdDTO.getCode_emp_or());
		ordApObsDO.setCreatedtime(new FDateTime(emsRisOrdDTO.getDt_entry_or()));
		ordApObsDO.setSd_su_obs(sd_su_obs);
		ordApObsDO.setId_su_obs(id_su_obs);
		return ordApObsDO;
	}
	
	private CiAppRisSheetDO assmbleRisSheet(EmsRisPrintDTO emsRisPrintDTO) {
		CiAppRisSheetDO ciAppRisSheetDO = new CiAppRisSheetDO();
		ciAppRisSheetDO.setStatus(DOStatus.NEW);
		ciAppRisSheetDO.setCode_app(emsRisPrintDTO.getCode_app());
		
		//ciAppRisSheetDO.setAmt_app(new FDouble(emsRisPrintDTO.getAmt_app()));
		
		return ciAppRisSheetDO;
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
}
