package iih.ei.std.s.v1.bp.ci.thirdws.op.lis;

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
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.app.i.ICiapplissheetCudService;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.i.ICiorapplisCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.external.common.ICIOrdRService;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ei.std.d.v1.ci.ent.d.ResultDTO;
import iih.ei.std.d.v1.ci.lis.d.EmsLisOrdDTO;
import iih.ei.std.d.v1.ci.lis.d.EmsLisPrintDTO;
import iih.ei.std.d.v1.ci.lis.d.EmsLisSrvDTO;
import iih.ei.std.d.v1.ci.lis.d.EntLisDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.BdDiDefUtils;
import iih.ei.std.s.v1.bp.ci.thirdws.utils.ConvertDTOs2XmlUtils;
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
 * @code 检验回写
 * @author LiYue
 */
public class OpLisSaveBP extends IIHServiceBaseBP<EntLisDTO, ResultDTO>  {
	/**
	 * 初始化检验过程状态  
	 */
	private static String ID_SU_LAB = "@@@@Z81000000011R04M";
	private static String SD_SU_LAB = "0";
	ThirdInfoUtils urils = new ThirdInfoUtils();
	private PatiVisitDO entdo;
	private OutpatientDO entopdo;
	private EntHpDO entHpdo;
	
	//入参校验
	protected void checkParam(EntLisDTO entdo) throws BizException {

		List<EmsLisPrintDTO> printDTOs = (List<EmsLisPrintDTO>) entdo.getEmslisprintdto();
		//就诊信息校验
		checkEmpty(entdo.getCode_org(),"所属组织" );
		checkEmpty(entdo.getCode_pat(),"患者" );
		checkEmpty(entdo.getCode_entp(),"就诊类型编码" );
		checkEmpty(entdo.getCode_dep_phy(),"当前就诊科室" );
		checkEmpty(entdo.getCode_emp_phy(),"当前主管医生" );
		//打印信息校验
		for (EmsLisPrintDTO emsLisPrintDTO : printDTOs) {		
			checkEmpty(emsLisPrintDTO.getCode_app(),"申请单打印号" );
			checkEmpty(emsLisPrintDTO.getAmt_app(),"申请金额" );
			
			List<EmsLisOrdDTO> ordList = emsLisPrintDTO.getEmslisorddto();
			//医嘱信息校验
			for (EmsLisOrdDTO emsLisOrdDTO : ordList) {
				checkEmpty(emsLisOrdDTO.getSortno_or(),"医嘱序号" );
				checkEmpty(emsLisOrdDTO.getCode_or(),"医嘱编码" );
				checkEmpty(emsLisOrdDTO.getCode_srv_or(),"检验项目编码" );
				checkEmpty(emsLisOrdDTO.getName_srv_or(),"检验项目名称" );
				checkEmpty(emsLisOrdDTO.getNo_applyform(),"检验申请单号" );
				checkEmpty(emsLisOrdDTO.getSd_samptp(),"标本类型" );
				checkEmpty(emsLisOrdDTO.getDt_plan(),"计划检验日期" );
				checkEmpty(emsLisOrdDTO.getQuan_medu_or(),"单次数量" );
				checkEmpty(emsLisOrdDTO.getCode_org_or(),"开立机构" );
				checkEmpty(emsLisOrdDTO.getCode_dep_or(),"开立部门" );
				checkEmpty(emsLisOrdDTO.getCode_emp_or(),"开立医生" );
				checkEmpty(emsLisOrdDTO.getDt_entry_or(),"开立日期" );
				checkEmpty(emsLisOrdDTO.getCode_org_mp_or(),"医嘱执行机构" );
				checkEmpty(emsLisOrdDTO.getCode_dep_mp_or(),"医嘱执行科室" );
				//费用信息校验
				List<EmsLisSrvDTO> srvList = emsLisOrdDTO.getEmslissrvdto();
				for (EmsLisSrvDTO emsCommonSrvDTO : srvList) {
					checkEmpty(emsCommonSrvDTO.getCode_srv(),"费用项目编码" );
					checkEmpty(emsCommonSrvDTO.getQuan_medu_srv(),"费用项目单次数量" );
					checkEmpty(emsCommonSrvDTO.getPri(),"单价" );
					checkEmpty(emsCommonSrvDTO.getPri_std(),"标准价" );
					checkEmpty(emsCommonSrvDTO.getPri_ratio(),"价格系数" );
					checkEmpty(emsCommonSrvDTO.getCode_org_mp_srv(),"费用执行机构" );
					checkEmpty(emsCommonSrvDTO.getCode_dep_mp_srv(),"费用执行科室" );	
				}
			}
		}
	}
	@Override
	protected ResultDTO process(EntLisDTO entlisdto) throws BizException {
		// 数据准备
		
		entdo = urils.getEntDO(entlisdto.getCode_en());
		entopdo = urils.getEnEntOpDO(entdo.getId_ent());
		entHpdo = urils.getEntHpDO(entdo.getId_ent());
		
		//设置Agg容器
		List<CiorderAggDO> ciorderAggDOList = new ArrayList<>();
		List<CiapplissheetAggDO> ciapplissheetAggList = new ArrayList<>();
		List<OrdApLabDO> lisLabList = new ArrayList<>();
		//获取打印list
		List<EmsLisPrintDTO> printList = entlisdto.getEmslisprintdto();
			for(int i=0;i<printList.size();i++ ) {
			String[] id_sheet = new DBUtil().getOIDs(1);
			EmsLisPrintDTO printDTO = printList.get(i);
			List <EmsLisOrdDTO> emsLisOrdDTOs =  (List<EmsLisOrdDTO>)printDTO.getEmslisorddto();
			//组装打印数据
			CiAppLisSheetDO lisSheetDo = assembleLisSheet(printDTO,id_sheet,emsLisOrdDTOs.get(i));
			List<CiAppLisSheetOrDO> lisOrList = new ArrayList<>();
			//获取医嘱list
			for(int j=0; j < emsLisOrdDTOs.size(); j++) {
				EmsLisOrdDTO ordDTO =(EmsLisOrdDTO)	emsLisOrdDTOs.get(j);
				CiorderAggDO aggdo = assebleOrderAgg(ordDTO);
				//生成主键和申请单主键
				String[] Id_orlab = new DBUtil().getOIDs(2);
				aggdo.getParentDO().setId_or(Id_orlab[1]);
				CiOrderDO orderDO = aggdo.getParentDO();
				assebleLisOrder(orderDO,ordDTO,aggdo);
				aggdo.setParent(orderDO);
				
				//检验申请单
				OrdApLabDO ordApLabDO = assebleOrdApLabDO(orderDO,Id_orlab[0], lisSheetDo, ordDTO);
				orderDO.setApplyno(ordApLabDO.getNo_applyform());
				for (OrdSrvDO srv : aggdo.getOrdSrvDO()) {
					srv.setId_or(orderDO.getId_or());
					assebleSrvDO(srv);
				}
				//打印子表
				CiAppLisSheetOrDO lisOrDo = new CiAppLisSheetOrDO();
				//设置子表价格
				assebleCiAppLisSheetOrDO(aggdo.getOrdSrvDO(),orderDO,ordDTO,lisOrDo);
				lisOrDo.setStatus(DOStatus.NEW);
				lisOrDo.setId_orlab(Id_orlab[0]);
				lisOrDo.setId_ciapplissheet(id_sheet[0]);
				lisOrDo.setId_or(orderDO.getId_or());
				lisOrList.add(lisOrDo);
				
				//打印补充
				lisSheetDo.setId_di(orderDO.getId_didef());
				lisSheetDo.setId_diitm(orderDO.getId_didef());
				lisSheetDo.setName_diag(orderDO.getName_didef());
				//计算总金额 将子表叠加
				FDouble price_total = FDouble.ZERO_DBL;
				for (CiAppLisSheetOrDO Sheet : lisOrList) {
					price_total.add(Sheet.getAmt_app());
				}
				lisSheetDo.setAmt_app_total(price_total);
				lisLabList.add(ordApLabDO);
				ciorderAggDOList.add(aggdo);
			}
			//打印数据放入集合
			CiapplissheetAggDO ciapplissheetAggDO = new CiapplissheetAggDO();
			ciapplissheetAggDO.setParent(lisSheetDo);
			ciapplissheetAggDO.setCiAppLisSheetOrDO(lisOrList.toArray(new CiAppLisSheetOrDO[0]));
			ciapplissheetAggList.add(ciapplissheetAggDO);
			
		}
		CiorderAggDO[] CiAggDo = ciorderAggDOList.toArray(new CiorderAggDO[0]);
		CiapplissheetAggDO[] lisAggDo = ciapplissheetAggList.toArray(new CiapplissheetAggDO[0]);
		//保存方法
		ResultDTO rstDTO= save(CiAggDo,lisAggDo,lisLabList.toArray(new OrdApLabDO[0]));
		return rstDTO;
	
	}
	/**
	 * 组装医嘱信息
	 * 
	 * @param orddto
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO assembleOrder(EmsLisOrdDTO ordDTO) throws BizException {


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
		// 0179265: 急诊系统接口增加两个参数，容器类型的code和id [南大象湖]
		ICiOrdMaintainService serviceTimes = ServiceFinder.find(ICiOrdMaintainService.class);
		ordo.setTimes_cur(serviceTimes.getTotalTimes(ordo.getDt_effe(),ordo.getId_freq(), ordo.getDays_or()));
		
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
		// ordo.setId_didef(ems.getId_didef());
		// ordo.setCode_didef(ems.getCode_didef());
		// ordo.setName_didef(ems.getName_didef());
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
	private CiorderAggDO assebleOrderAgg(EmsLisOrdDTO emsDrugsOrdDTO) throws BizException {

		CiorderAggDO aggdo = new CiorderAggDO();
		List<EmsLisSrvDTO> drugssrvs = (List<EmsLisSrvDTO>)emsDrugsOrdDTO.getEmslissrvdto();
		CiOrderDO order = this.assembleOrder(emsDrugsOrdDTO);
		aggdo.setParent(order);
		if (drugssrvs == null || drugssrvs.size() == 0) {
			new BizException("服务费用信息传入为空");
		} else {
			List<OrdSrvDO> srvdos = asssembleSrv(drugssrvs, order);
			// 通过服务完善医嘱信息
			OrdSrvDO srvdo = srvdos.get(0);
			assembleOrderFromSrv(order, srvdo);
			aggdo.setOrdSrvDO(srvdos.toArray(new OrdSrvDO[0]));
		}
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
		order.setFg_mp_in(ThirdInfoUtils.JudgeFgMpIn(order.getCode_entp(), order.getSd_srvtp()));
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
	/**
	 * 组装服务，需要子类实现
	 * 
	 * @param drugssrvs
	 * @param order
	 * @return
	 * @throws BizException
	 */
	public List<OrdSrvDO> asssembleSrv(List<EmsLisSrvDTO> drugssrvs, CiOrderDO order) throws BizException {
		List<OrdSrvDO> srvdos = new ArrayList<OrdSrvDO>();
		List<String> code_srvs = new ArrayList<String>();
		List<String> id_srvs = new ArrayList<String>();
		if(drugssrvs!=null) {
		for (EmsLisSrvDTO emsDrugsSrvDTO : drugssrvs) {
			String code_srv = emsDrugsSrvDTO.getCode_srv();	
			if(code_srv==null||code_srv.trim().length()==0)
				continue;
			code_srvs.add(code_srv);
		}		
		}
		if(code_srvs.size()>0) {
		Map<String,MedSrvDO> medSrvMpa = this.getMedSrvMap(code_srvs);
		for (EmsLisSrvDTO emsDrugsSrvDTO : drugssrvs) {
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
	 * 通过服务编码查询服务项目
	 * 
	 * @param code_srvs
	 * @return
	 * @throws BizException
	 */
	protected Map<String, MedSrvDO> getMedSrvMap(List<String> code_srvs) throws BizException {
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medsrvs = service.findByAttrValStrings(MedSrvDO.CODE, code_srvs.toArray(new String[0]));
		Map<String, MedSrvDO> map = new HashMap<String, MedSrvDO>();
		for (MedSrvDO medSrvDO : medsrvs) {
			map.put(medSrvDO.getCode(), medSrvDO);
		}
		return map;
	}

	/*校验异常信息
	 */
    public void checkEmpty(String attribute,String ErrMsg) throws BizException {
    	if(StringUtils.isEmpty(attribute)) {
			throw new BizException("'"+ErrMsg+"' 不能为空！");
		}
    }


	/*
	 *  计算价格
	 */
	private void assebleCiAppLisSheetOrDO(OrdSrvDO[] ordSrvDO, CiOrderDO orderDO, EmsLisOrdDTO lisOrdDTO, CiAppLisSheetOrDO lisOrDo) {
        //总金额
		FDouble price_total = FDouble.ZERO_DBL;
		for (OrdSrvDO srv : ordSrvDO) {
			if(FDoubleUtils.isNullOrZero(srv.getPri()) || FBoolean.FALSE.equals(srv.getFg_bl()))
				continue;
			// 单价
			FDouble pri = new FDouble(srv.getPri());
			// 次数 0179265: 急诊系统接口增加两个参数，容器类型的code和id [南大象湖]
			FDouble Times_cur = new FDouble(orderDO.getTimes_cur()==null?0:orderDO.getTimes_cur());
			// 单次数量
			FDouble quan_medu_or = new FDouble(lisOrdDTO.getQuan_medu_or());
			
			if (FDoubleUtils.isNotNullOrZero(pri) && FDoubleUtils.isNotNullOrZero(Times_cur)
					&& FDoubleUtils.isNotNullOrZero(quan_medu_or)) {
				price_total.add(pri.multiply(Times_cur).multiply(quan_medu_or));
			}
		}
		lisOrDo.setAmt_app(price_total);
	}
	private void assebleSrvDO(OrdSrvDO srv) {
		srv.setFreq_name(IBdSrvDictCodeConst.NAME_FREQNUNITCT_ITEM_ONCE);
		srv.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		srv.setId_en(entdo.getId_ent());
		srv.setId_pat(entdo.getId_pat());
		srv.setId_entp(entdo.getId_entp());
		srv.setCode_entp(entdo.getCode_entp());
		srv.setEu_sourcemd(0);
	}
	private void assebleLisOrder(CiOrderDO orderDO, EmsLisOrdDTO lisOrdDTO, CiorderAggDO aggdo) throws BizException {
		//医嘱拼接
		orderDO.setContent_or(ThirdInfoUtils
				.create(orderDO.getSd_srvtp(), aggdo.getOrdSrvDO()[0].getName(), orderDO.getRoute_name(), orderDO.getFg_urgent())
				.toString());
		orderDO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		orderDO.setId_dep_or(urils.getDep(lisOrdDTO.getCode_dep_or()).getId_dep());
		orderDO.setDt_effe(new FDateTime(lisOrdDTO.getDt_plan()));
		orderDO.setId_srvca(aggdo.getOrdSrvDO()[0].getId_srvca());
		orderDO.setId_srvtp(aggdo.getOrdSrvDO()[0].getId_srvtp());
		orderDO.setId_dep_mp(urils.getDep(lisOrdDTO.getCode_dep_mp_or()).getId_dep());
		orderDO.setApplyno(lisOrdDTO.getNo_applyform());
		//诊断
		if(StringUtils.isNotEmpty(lisOrdDTO.getCode_diag())){
			DiagDefDO didef = BdDiDefUtils.getDiagDefDOByCode(lisOrdDTO.getCode_diag());
			if(didef!=null){
				LogUtils.Logger("传入的诊断编码编码在his中不存在："+lisOrdDTO.getCode_diag());
				orderDO.setId_didef(didef.getId_didef());
				orderDO.setCode_didef(didef.getCode());
				orderDO.setName_didef(didef.getName());
			}
		}
		
	}
	//组装申请单
	private OrdApLabDO assebleOrdApLabDO(CiOrderDO orderDO, String id_orlab, CiAppLisSheetDO lisSheetDo, EmsLisOrdDTO lisOrdDTO) throws BizException {
		//标本
		UdidocDO biaoben = UdidocUtils.getUdidocByCode("BD.SRV.0555", lisOrdDTO.getSd_samptp());
				//标本采集时间
		UdidocDO biaobenTime = UdidocUtils.getUdidocByCode("BD.BC.0600", lisOrdDTO.getSd_sampcollecttimetp());
				
		OrdApLabDO ordApLabDO = new OrdApLabDO();
		ordApLabDO.setStatus(DOStatus.NEW);
		ordApLabDO.setId_or(orderDO.getId_or());
		ordApLabDO.setId_orlab(id_orlab);
		ordApLabDO.setId_samptp(biaoben.getId_udidoc());
//		ordApLabDO.setId_sampcoltime(biaobenTime.getId_udidoc());
//		ordApLabDO.setSd_sampcoltime(lisOrdDTO.getSd_sampcollecttimetp());
		ordApLabDO.setId_sampcollecttimetp(biaobenTime.getId_udidoc());
		//检验申请补充
		ordApLabDO.setId_di(orderDO.getId_didef());
		ordApLabDO.setId_diitm(orderDO.getId_didef());
		ordApLabDO.setName_diag(orderDO.getName_didef());
		ordApLabDO.setStr_id_diitm(orderDO.getId_didef());
		ordApLabDO.setStr_name_di(orderDO.getName_didef());
		ordApLabDO.setStr_code_di(orderDO.getCode_didef());
	//	ordApLabDO.setNo_applyform(CiOrdUtils.getApplyNo(orderDO.getSd_srvtp()));
		ordApLabDO.setId_su_lab(ID_SU_LAB);
		ordApLabDO.setSd_su_lab(SD_SU_LAB);
		ordApLabDO.setSd_samptp(lisOrdDTO.getSd_samptp());
		
		ordApLabDO.setSd_sampcollecttimetp(lisOrdDTO.getSd_sampcollecttimetp());
		ordApLabDO.setDt_plan(new FDateTime(lisOrdDTO.getDt_plan()));
		//0179265: 急诊系统接口增加两个参数，容器类型的code和id [南大象湖]
		ordApLabDO.setId_contp(lisOrdDTO.getId_contp());
		ordApLabDO.setSd_contp(lisOrdDTO.getSd_contp());
		return ordApLabDO;
	}
	//保存入库
	public ResultDTO save(CiorderAggDO[] CiAggDo , CiapplissheetAggDO[] lisAggDo , OrdApLabDO[] LablisDO) throws BizException {
		ResultDTO retdto = new ResultDTO();
		ICiorderCudService service = ServiceFinder.find(ICiorderCudService.class);
		ICiapplissheetCudService lisService = ServiceFinder.find(ICiapplissheetCudService.class);
		ICiorapplisCudService LablisService = ServiceFinder.find(ICiorapplisCudService.class);
		try {
			//TODO:
			CiAggDo = service.save(CiAggDo);
			lisService.save(lisAggDo);
			LablisService.save(LablisDO);
			retdto.setResultcode("0");
			retdto.setResultmsg("检验保存成功！");
			this.fireSignEvent(CiAggDo);
		} catch (Exception e) {
			retdto.setResultcode("1");
			retdto.setResultmsg(e.toString());
			throw new BizException(e);
		}
		return retdto;
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
	
	//todo:
	private void getMergeTubeSendToMPBP(CiapplissheetAggDO[] lisAggDo,String id_org) throws BizException {
//		LogUtils.Logger("检验签署后调用执行域同步合管数据:组织id_org="+id_org+"----------");
//		MergeTubeSendToMPBP MPbp = new MergeTubeSendToMPBP();
//		CiEnContextDTO ctx = new CiEnContextDTO();
//		ctx.setId_org(id_org);
//		MPbp.exec(ctx, lisAggDo);
		
	}
	//组装打印
	public CiAppLisSheetDO assembleLisSheet(EmsLisPrintDTO emsLisPrintDTO, String[] id_sheet,EmsLisOrdDTO lisOrdDTO) throws BizException {
		//标本
		UdidocDO biaoben = UdidocUtils.getUdidocByCode("BD.SRV.0555", lisOrdDTO.getSd_samptp());
		//标本采集时间
		UdidocDO biaobenTime = UdidocUtils.getUdidocByCode("BD.BC.0600", lisOrdDTO.getSd_sampcollecttimetp());
		
		CiAppLisSheetDO lisSheetDo = new CiAppLisSheetDO();
		lisSheetDo.setStatus(DOStatus.NEW);
		lisSheetDo.setCode_app(emsLisPrintDTO.getCode_app());
		lisSheetDo.setId_ciapplissheet(id_sheet[0]);
		lisSheetDo.setId_org(entdo.getId_org());
		lisSheetDo.setSd_samptp(lisOrdDTO.getSd_samptp());
		if(biaoben!=null)
		lisSheetDo.setId_samptp(biaoben.getId_udidoc());
		if(biaobenTime!=null)
		lisSheetDo.setId_sampcollecttimetp(biaobenTime.getId_udidoc());
		lisSheetDo.setSd_sampcollecttimetp(lisOrdDTO.getSd_sampcollecttimetp());
		lisSheetDo.setDt_plan(new FDateTime(lisOrdDTO.getDt_plan()));
		lisSheetDo.setId_sampcoltime(lisSheetDo.getId_sampcollecttimetp());
		lisSheetDo.setId_sampcollecttimetp(lisSheetDo.getId_sampcollecttimetp());
		lisSheetDo.setSd_sampcollecttimetp(lisSheetDo.getSd_sampcollecttimetp());
		lisSheetDo.setLen_sampcoltime(lisSheetDo.getLen_sampcoltime());
		lisSheetDo.setId_unit_sampcoltime(lisSheetDo.getId_unit_sampcoltime());
		lisSheetDo.setId_en(entdo.getId_ent());
		lisSheetDo.setId_pat(entdo.getId_pat());
		lisSheetDo.setId_entp(entdo.getId_entp());
		lisSheetDo.setCode_entp(entdo.getCode_entp());
		return lisSheetDo;
	}
	public OrdSrvDO assembleSrv(EmsLisSrvDTO emsDrugsSrvDTO) throws BizException {
		OrdSrvDO srvdo = new OrdSrvDO();
		String[] id_orsrv = new DBUtil().getOIDs(1);
		srvdo.setId_orsrv(id_orsrv[0]);
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_pat(entdo.getId_pat());
		srvdo.setId_en(entdo.getId_ent());
		srvdo.setId_entp(entdo.getId_entp());
		srvdo.setCode_entp(entdo.getCode_entp());
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
		srvdo.setId_hpsrvtp(entHpdo.getId_hp());
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
	/**
	 * 组装服务信息
	 * 
	 * @param srvdto
	 * @param medsrv
	 * @return
	 * @throws BizException
	 */
	public OrdSrvDO assembleSrv(EmsLisSrvDTO srvdto, MedSrvDO medsrv, CiOrderDO order) throws BizException {
		OrdSrvDO srvdo = assembleSrv(srvdto);
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
	/**
	 * 组装医嘱内容
	 * @param dataSource
	 * @param aggarrays
	 */
	protected void assembleContent_or(CiorderAggDO agg){
		
	}
}
