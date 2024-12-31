package iih.ei.std.s.v1.bp.ci.thirdws.op.apbu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.ems.d.EmsAppModeEnum;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.i.ICiorappbuCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.i.external.common.ICIOrdRService;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ei.std.d.v1.ci.apbu.d.EmsApbuEntDTO;
import iih.ei.std.d.v1.ci.apbu.d.EmsApbuOrdDTO;
import iih.ei.std.d.v1.ci.apbu.d.EmsApbuSrvDTO;
import iih.ei.std.d.v1.ci.ent.d.ResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.BdMeasdocUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.CiorderUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.DeptUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.PsndocUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.ThirdInfoUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.UdidocUtils;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
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
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * @code 门诊用血第三方回传
 * @author LiYue
 */
public class OpApbuSaveBP  extends IIHServiceBaseBP<EmsApbuEntDTO, ResultDTO>{
	ThirdInfoUtils urils = new ThirdInfoUtils();
	private PatiVisitDO entdo;
	private EntHpDO entHpdo;
	
	// 入参校验
	protected void checkParam(EmsApbuEntDTO entDTO) throws BizException {
		 if(entDTO == null ) {
			throw new BizException("未能获取到-就诊信息");
		 }
		//----------------校验数据信息----------
		//1.校验就诊信息

			if(StringUtils.isEmpty(entDTO.getCode_org())) {
				throw new BizException(":未能获取到-所属组织");
			}
			if(StringUtils.isEmpty(entDTO.getCode_pat())) {
				throw new BizException(":未能获取到-患者");
			}
			if(StringUtils.isEmpty(entDTO.getCode_en())) {
				throw new BizException(":未能获取到-就诊编码");
			}
			if(StringUtils.isEmpty(entDTO.getCode_entp())) {
				throw new BizException(":未能获取到-就诊类型编码");
			}
			if(StringUtils.isEmpty(entDTO.getCode_dep_phy())) {
				throw new BizException(":未能获取到-当前就诊科室");
			}
			if(StringUtils.isEmpty(entDTO.getCode_emp_phy())) {
				throw new BizException(":未能获取到-当前主管医生");
			}
			if(StringUtils.isEmpty(entDTO.getSd_bloodtype_pi())) {
				throw new BizException(":未能获取到-患者血型编码");
			}
			if(StringUtils.isEmpty(entDTO.getSd_rhd_pi())) {
				throw new BizException(":未能获取到-患者Rh(D)编码");
			}
				List<EmsApbuOrdDTO> ordList = (List<EmsApbuOrdDTO>)entDTO.getEmsapbuorddto();
		if(ordList == null && ordList.size()<=0) {
			throw new BizException(":未能获取到-医嘱信息");
		}
		int i=0;
		for(EmsApbuOrdDTO ordDTO:ordList) {
			i++;
			//1.1校验医嘱信息

			if(StringUtils.isEmpty(ordDTO.getSortno_or())) {
				throw new BizException("["+i+"]:未能获取到-医嘱序号");
			}
			if(StringUtils.isEmpty(ordDTO.getCode_or())) {
				throw new BizException("["+i+"]:未能获取到-医嘱编码");
			}
			if(StringUtils.isEmpty(ordDTO.getNo_applyform_bu())) {
				throw new BizException("["+i+"]:未能获取到-用血申请单号");
			}
			if(StringUtils.isEmpty(ordDTO.getNo_applyform_bt())) {
				throw new BizException("["+i+"]:未能获取到-备血申请单号");
			}
			if(StringUtils.isEmpty(ordDTO.getDt_bu_plan())) {
				throw new BizException("["+i+"]:未能获取到-计划用血日期");
			}
			if(StringUtils.isEmpty(ordDTO.getQuan_medu_bt())) {
				throw new BizException("["+i+"]:未能获取到-申请用量");
			}
			if(StringUtils.isEmpty(ordDTO.getCode_medu_bt())) {
				throw new BizException("["+i+"]:未能获取到-申请用量单位");
			}
			if(StringUtils.isEmpty(ordDTO.getCode_dep_or())) {
				throw new BizException("["+i+"]:未能获取到-开立部门");
			}
			if(StringUtils.isEmpty(ordDTO.getCode_emp_or())) {
				throw new BizException("["+i+"]:未能获取到-开立医生");
			}
			if(StringUtils.isEmpty(ordDTO.getDt_entry_or())) {
				throw new BizException("["+i+"]:未能获取到-开立日期");
			}
			if(StringUtils.isEmpty(ordDTO.getDt_entry_or())) {
				throw new BizException("["+i+"]:未能获取到-开立日期");
			}
			if(StringUtils.isEmpty(ordDTO.getCode_dep_mp_or())) {
				throw new BizException("["+i+"]:未能获取到-医嘱执行科室");
			}
		
			//1.1.1校验服务信息
			List<EmsApbuSrvDTO> srvList = (List<EmsApbuSrvDTO>)ordDTO.getEmsapbusrvdto();
			if(srvList == null && srvList.size()<=0) {
				throw new BizException("["+i+"]:未能获取到费用明细信息");
			}
			int j=0;
			for(EmsApbuSrvDTO srvDto:srvList) {
				j++;
				//EmsapbusrvDTO srvDto=(EmsapbusrvDTO)commonSrvDTO;
				//校验服务详细信息

				if(StringUtils.isEmpty(srvDto.getCode_srv())) {
					throw new BizException( "["+j+"]:未能获取到-费用项目编码");
				}
				if(StringUtils.isEmpty(srvDto.getQuan_medu_srv())) {
					throw new BizException( "["+j+"]:未能获取到-费用项目单次数量");
				}
				if(StringUtils.isEmpty(srvDto.getPri())) {
					throw new BizException( "["+j+"]:未能获取到-单价");
				}
				if(StringUtils.isEmpty(srvDto.getPri_std())) {
					throw new BizException( "["+j+"]:未能获取到-标准价");
				}
				if(StringUtils.isEmpty(srvDto.getPri_ratio())) {
					throw new BizException( "["+j+"]:未能获取到-价格系数");
				}
				if(StringUtils.isEmpty(srvDto.getCode_dep_mp_srv())) {
					throw new BizException( "["+j+"]:未能获取到-费用执行科室");
				}
						}
		}
	}

	//数据组装 回写
	protected ResultDTO process(EmsApbuEntDTO emsapbuentDTO) throws BizException {	
		// 数据准备
		entdo = urils.getEntDO(emsapbuentDTO.getCode_en());
		urils.getEnEntOpDO(entdo.getId_ent());
		entHpdo = urils.getEntHpDO(entdo.getId_ent());

		//从就诊中获取医嘱集合
		List<EmsApbuOrdDTO> ordList = (List<EmsApbuOrdDTO>) emsapbuentDTO.getEmsapbuorddto();
		//定义医嘱aggDo集合
		List<CiorderAggDO> ciorderAggDOList = new ArrayList<>();
		//定义用血申请集合
		List<OrdAppBtUseDO> ordAppBtUseDOList= new ArrayList<OrdAppBtUseDO>();
 		for (EmsApbuOrdDTO emsapbuordDTO : ordList) {
 			//覆盖某些数值
 			List<EmsApbuSrvDTO> srvList = (List<EmsApbuSrvDTO>)emsapbuordDTO.getEmsapbusrvdto();
 			String code_srv =ParamsetQryUtil.getParaString(Context.get().getOrgId(), "LL_CIOR0425");
 			// 医疗服务
 			IMedsrvMDORService medsrvMDOservice = ServiceFinder.find(IMedsrvMDORService.class);
 			MedSrvDO[] medSrvDO = medsrvMDOservice.find("code='"+code_srv+"'", null, FBoolean.FALSE);
 			if(medSrvDO==null||medSrvDO.length==0)
 			{
 				throw new BizException("LL_CIOR0425参数值不正确，无法查询到服务，请重新配置！");
 			}
 			emsapbuordDTO.setCode_or(srvList.get(0).getCode_srv());
			//医嘱和服务的主子关系都在这方法里
			CiorderAggDO aggdo = this.assebleOrderAgg(emsapbuordDTO);
			ciorderAggDOList.add(aggdo);
			CiOrderDO ciOrderDO=aggdo.getParentDO();//获取当前主表 给后面逻辑用  
			//组装用血申请单
			ordAppBtUseDOList = this.assebleOrdAppBtUseDO(aggdo,emsapbuordDTO,ordAppBtUseDOList);
			//医嘱表设置关联备血申请单
			OrdApBtDO aptDo = getApbtByApplyNo(emsapbuordDTO.getNo_applyform_bt());
			if(aptDo != null) {
				ciOrderDO.setId_or_rel(aptDo.getId_or());
			}else {
				throw new BizException("未查询到与之对应的备血申请单，请查看备血申请单号与备血单的申请单号是否一致");
			}
			//再次组装  之前的组装取不到值 用血的需要取备血的name_or去拼装content_or 用于显示
			this.assembleContent_or(aggdo);
			CiOrderDO c = aggdo.getParentDO();
			if(ordAppBtUseDOList==null&&ordAppBtUseDOList.size()>0) {
				//用服务的申请单号 覆盖父类医嘱给的
				c.setApplyno(ordAppBtUseDOList.get(0).getNo_applyform());
			}
		}
 		//保存
 		ResultDTO retdto= saveValue(ciorderAggDOList, ordAppBtUseDOList);
		return retdto;
	
	}
	//保存逻辑
	private ResultDTO saveValue(List<CiorderAggDO> ciorderAggDOList, List<OrdAppBtUseDO> ordAppBtUseDOList) {
		ResultDTO retdto = new ResultDTO();
 		try {
 			//保存医嘱和服务
 	 		ICiorderCudService service = ServiceFinder.find(ICiorderCudService.class);
 	 		CiorderAggDO[] dos=ciorderAggDOList.toArray(new CiorderAggDO[0]);
 			dos=service.save(dos);
 	 		//保存申请单集合
 	 		if(ordAppBtUseDOList!=null && ordAppBtUseDOList.size()>0) {
 	 			ICiorappbuCudService buService=ServiceFinder.find(ICiorappbuCudService.class);
 	 			buService.save(ordAppBtUseDOList.toArray(new OrdAppBtUseDO[0]));
 	 		}
 	 		//发送事件 0191097 不操作执行
 	 		//this.fireSignEvent(dos);
 	 		retdto.setResultcode("0");
		} catch (Exception e) {
			retdto.setResultcode("1");
			retdto.setResultmsg(e.toString());
		}
 		return retdto;
	}

	private void assembleContent_or(CiorderAggDO agg) {
		CiOrderDO orderDO = agg.getParentDO();
		StringBuilder stringBuilder=new StringBuilder();
		//查询所关联的备血的名字 
		String id_or_rel=orderDO.getId_or_rel();
		try {
			CiOrderDO ciOrderDO=CiorderUtils.getCiOrderDO(CiOrderDO.ID_OR,id_or_rel);
			stringBuilder.append("输"+(ciOrderDO==null?orderDO.getName_or():ciOrderDO.getName_or())+orderDO.getQuan_medu()+"次");
			String string=ThirdInfoUtils.create(orderDO.getSd_srvtp(), stringBuilder.toString(), orderDO.getRoute_name(), FBoolean.FALSE)
					.toString();
			System.out.println("content_or:----"+string+"---------");
			orderDO.setContent_or(string);
		} catch (BizException e) {
			e.printStackTrace();
		}
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
	
	/**
	 * 获取申请单
	 * @param applyNo
	 * @return
	 * @throws DAException 
	 * @throws BizException
	 */
	private OrdApBtDO getApbtByApplyNo(String applyNo) throws DAException {

		if (StringUtil.isEmpty(applyNo))
			return null;

		String sql = "select * from ci_ap_bt where no_applyform = ?  ";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(applyNo);

		OrdApBtDO apt = (OrdApBtDO) new DAFacade().execQuery(sql, sqlParam, new BeanHandler(OrdApBtDO.class));
		System.out.println("apt:"+(apt==null?"null":apt.toString()));
		return apt;
	}

	private List<OrdAppBtUseDO> assebleOrdAppBtUseDO(CiorderAggDO aggdo, EmsApbuOrdDTO emsapbuordDTO,
			List<OrdAppBtUseDO> ordAppBtUseDOList) {
		OrdAppBtUseDO userDo=new OrdAppBtUseDO();
		CiOrderDO ciOrderDO = aggdo.getParentDO();
		userDo.setStatus(DOStatus.NEW);
		//医嘱id
		userDo.setId_or(ciOrderDO.getId_or());
		//19用血申请单号no_applyform_bu
		userDo.setNo_applyform(emsapbuordDTO.getNo_applyform_bu());
		//21手术间operationroom
		userDo.setOperationroom(emsapbuordDTO.getOperationroom());
		//22手术间电话operationroomtel
		userDo.setOperationroomtel(emsapbuordDTO.getOperationroomtel());
		//23医生联系电话applydoctortel
		userDo.setApplydoctortel(emsapbuordDTO.getApplydoctortel());
		//24计划用血日期dt_bu_plan
		if(StringUtils.isNotEmpty(emsapbuordDTO.getDt_bu_plan())) {
			userDo.setDt_bu_plan(new FDateTime(emsapbuordDTO.getDt_bu_plan()));
		}
		ordAppBtUseDOList.add(userDo);
		return ordAppBtUseDOList;
	}
	/**
	 * 组装医嘱和服务
	 */
	private CiorderAggDO assebleOrderAgg(EmsApbuOrdDTO emsapbuordDTO) throws BizException {
		CiorderAggDO aggdo = assebleOrderAggSuper(emsapbuordDTO);
		//补充其他数据在这里
		//医嘱和服务设置id_or
		String[] id_or = new DBUtil().getOIDs(1);
		System.out.println("id_or:=================="+id_or[0]+"=====================");
		CiOrderDO ciOrderDO=aggdo.getParentDO();
		ciOrderDO.setId_or(id_or[0]);
		ciOrderDO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);//医嘱来源功能sd
		ciOrderDO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);//医嘱来源功能id
		OrdSrvDO[] srvDOs=(OrdSrvDO[]) aggdo.getChildrenDO();
		if(srvDOs!=null && srvDOs.length>0) {
			for(OrdSrvDO srv:srvDOs) {
				srv.setId_or(id_or[0]);
				//频次
				srv.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
				srv.setFreq_name(IBdSrvDictCodeConst.NAME_FREQNUNITCT_ITEM_ONCE);
				//服务单位 从医嘱26申请用量单位出获取
				if(StringUtils.isNotEmpty(emsapbuordDTO.getCode_medu_bt())&&(StringUtils.isEmpty(srv.getId_medu())||srv.getId_srv().equals(aggdo.getParentDO().getId_srv()))) {
					MeasDocDO meas=BdMeasdocUtils.getMeasDocDOByCode(emsapbuordDTO.getCode_medu_bt());
					if(meas!=null) {
						srv.setId_medu(meas.getId_measdoc());
					}
				}
			}
		}
		return aggdo;
	}

	private CiorderAggDO assebleOrderAggSuper(EmsApbuOrdDTO emsapbuordDTO) throws BizException {
		CiorderAggDO aggdo = new CiorderAggDO();
		List<EmsApbuSrvDTO> drugssrvs = (List<EmsApbuSrvDTO>)emsapbuordDTO.getEmsapbusrvdto();
		CiOrderDO order = assembleOrderSuper(emsapbuordDTO);
		aggdo.setParent(order);
		List<OrdSrvDO> srvdos = asssembleSrv(drugssrvs, order);
		// 通过服务完善医嘱信息
		OrdSrvDO srvdo = srvdos.get(0);
		assembleOrderFromSrv(order, srvdo);
		aggdo.setOrdSrvDO(srvdos.toArray(new OrdSrvDO[0]));
		assembleContent_or(aggdo);
		return aggdo;
	}

	/**
	 * 通过服务完善医嘱信息
	 * 
	 * @param order
	 * @param srvdo
	 * @throws BizException
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

	private List<OrdSrvDO> asssembleSrv(List<EmsApbuSrvDTO> drugssrvs, CiOrderDO order) throws BizException {
		List<OrdSrvDO> srvdos = new ArrayList<OrdSrvDO>();
		List<String> code_srvs = new ArrayList<String>();
		List<String> id_srvs = new ArrayList<String>();
		if (drugssrvs != null) {
			for (EmsApbuSrvDTO emsDrugsSrvDTO : drugssrvs) {
				String code_srv = emsDrugsSrvDTO.getCode_srv();
				if (code_srv == null || code_srv.trim().length() == 0)
					continue;
				code_srvs.add(code_srv);
			}
		}

		// 如果医嘱的服务id_srv不为空，并且在费用项目中不存在，需要将医嘱的服务编码对应的服务，存入到ci_or_srv表中
		if (StringUtils.isNotEmpty(order.getId_srv()) && !id_srvs.contains(order.getId_srv())) {
			OrdSrvDO srvdo = asssembleSrv(order);
			srvdos.add(srvdo);
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
	//	srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());
		srvdo.setId_pripat(entdo.getId_pripat());
		srvdo.setId_grp(entdo.getId_grp());
		srvdo.setId_org(entdo.getId_org());
		srvdo.setSortno(0);
		
	//	srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(order.getId_dep_mp()));
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

	private OrdSrvDO assembleSrv(EmsApbuSrvDTO emsDrugsSrvDTO, MedSrvDO medsrv, CiOrderDO order) throws BizException {
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

	private OrdSrvDO assembleSrvSuper(EmsApbuSrvDTO emsDrugsSrvDTO) throws BizException {
		OrdSrvDO srvdo = new OrdSrvDO();
		String[] id_orsrv = new DBUtil().getOIDs(1);
		srvdo.setId_orsrv(id_orsrv[0]);
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_pat(entdo.getId_pat());
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_entp(entdo.getId_entp());
		srvdo.setCode_entp(entdo.getCode_entp());
	//	srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());
		srvdo.setId_pripat(entdo.getId_pripat());
		srvdo.setId_grp(entdo.getId_grp());
		srvdo.setId_org(entdo.getId_org());
	
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
	//	srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_hp(entHpdo.getId_hp());
		return srvdo;
	}

	private Map<String, MedSrvDO> getMedSrvMap(List<String> code_srvs) {
		// TODO Auto-generated method stub
		return null;
	}

	private CiOrderDO assembleOrderSuper(EmsApbuOrdDTO orddto) throws BizException {
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
		if (StringUtils.isNotEmpty(orddto.getCode_or())) {
			ordo.setCode_or(orddto.getCode_or());
		} else {
			ordo.setDes_or(orddto.getDes_or());
			ordo.setFg_urgent(new FBoolean(orddto.getFg_urgent()));
			ordo.setFg_sign(FBoolean.TRUE);
			ordo.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
			ordo.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
			ordo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
			ordo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
			ordo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			ordo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		}
		if (StringUtils.isNotEmpty(orddto.getCode_dep_or())) {
			DeptDO dept_or = DeptUtils.getDeptByCode(orddto.getCode_dep_or());
			if (dept_or != null) {
				ordo.setId_dep_or(dept_or.getId_dep());
			}
		}
		ordo.setId_dep_sign(ordo.getId_dep_or());
		// 执行科室
		if (StringUtils.isNotEmpty(orddto.getCode_dep_mp_or())) {
			DeptDO dept_mp = DeptUtils.getDeptByCode(orddto.getCode_dep_mp_or());
			if (dept_mp != null) {
				ordo.setId_dep_mp(dept_mp.getId_dep());
			}
		}
		// ordo.setId_org_or(CiOrdUtils.getOrgOfDept(ordo.getId_dep_or()));
		if (StringUtils.isNotEmpty(orddto.getCode_emp_or())) {
			PsnDocDO psndoc = PsndocUtils.getPsnDocByCode(orddto.getCode_emp_or());
			if (psndoc != null) {
				ordo.setId_emp_or(psndoc.getId_psndoc());
			}
		}

		ordo.setId_emp_sign(ordo.getId_emp_or());
		ordo.setDt_entry(new FDateTime(orddto.getDt_entry_or()));
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
		// ordo.setId_didef(ems.getId_didef());
		// ordo.setCode_didef(ems.getCode_didef());
		// ordo.setName_didef(ems.getName_didef());
		if (StringUtils.isNotEmpty(orddto.getCode_or())) {
			IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
			MedSrvDO[] medsrvs = service.findByAttrValStrings(MedSrvDO.CODE, new String[] { orddto.getCode_or() });
			if (medsrvs != null && medsrvs.length > 0) {
				MedSrvDO medsrv = medsrvs[0];
				ordo.setId_srv(medsrv.getId_srv());
				ordo.setId_srvtp(medsrv.getId_srvtp());
				ordo.setSd_srvtp(medsrv.getSd_srvtp());
				ordo.setId_srvca(medsrv.getId_srvca());
				ordo.setName_or(medsrv.getName());
				ordo.setId_unit_med(medsrv.getId_unit_med());
			}
		}
		ordo.setStatus(DOStatus.NEW);
		return ordo;
	}
}