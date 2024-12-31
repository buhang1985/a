package iih.ci.ord.s.external.thirdws.op.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
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
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.external.common.ICIOrdRService;
import iih.ci.ord.i.external.thirdws.base.EmsCommonOrdDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.DateUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.s.external.thirdws.utils.BdMeasdocUtils;
import iih.ci.ord.s.external.thirdws.utils.DeptUtils;
import iih.ci.ord.s.external.thirdws.utils.FreqUtils;
import iih.ci.ord.s.external.thirdws.utils.PsndocUtils;
import iih.ci.ord.s.external.thirdws.utils.RouteUtils;
import iih.ci.ord.s.external.thirdws.utils.UdidocUtils;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.utils.AuditInfoUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
import xap.sys.xbd.udi.d.UdidocDO;

public class OpCommonSaveAction extends OpBaseSaveAction {

	/**
	 * 组装aggdo
	 * 
	 * @param emsDrugsOrdDTO
	 * @return
	 * @throws BizException
	 */
	public CiorderAggDO assebleOrderAgg(EmsCommonOrdDTO emsDrugsOrdDTO) throws BizException {
		CiorderAggDO aggdo = new CiorderAggDO();

		List<EmsCommonSrvDTO> drugssrvs = emsDrugsOrdDTO.getSrvList();

		CiOrderDO order = this.assembleOrder(emsDrugsOrdDTO);

		aggdo.setParent(order);

//		if (drugssrvs == null || drugssrvs.size() == 0) {
		//	new BizException("服务费用信息传入为空");
//		} else {
			List<OrdSrvDO> srvdos = asssembleSrv(drugssrvs, order);
			// 通过服务完善医嘱信息
			OrdSrvDO srvdo = srvdos.get(0);
			assembleOrderFromSrv(order, srvdo);
			aggdo.setOrdSrvDO(srvdos.toArray(new OrdSrvDO[0]));
//		}
		assembleContent_or(aggdo);
		return aggdo;
	}

	/**
	 * 组装服务，需要子类实现
	 * 
	 * @param drugssrvs
	 * @param order
	 * @return
	 * @throws BizException
	 */
	public List<OrdSrvDO> asssembleSrv(List<EmsCommonSrvDTO> drugssrvs, CiOrderDO order) throws BizException {
		List<OrdSrvDO> srvdos = new ArrayList<OrdSrvDO>();
		List<String> code_srvs = new ArrayList<String>();
		List<String> id_srvs = new ArrayList<String>();
		if(drugssrvs!=null) {
		for (EmsCommonSrvDTO emsDrugsSrvDTO : drugssrvs) {
			String code_srv = emsDrugsSrvDTO.getCode_srv();	
			if(code_srv==null||code_srv.trim().length()==0)
				continue;
			code_srvs.add(code_srv);
		}		
		}
		if(code_srvs.size()>0) {
		Map<String,MedSrvDO> medSrvMpa = this.getMedSrvMap(code_srvs);
		for (EmsCommonSrvDTO emsDrugsSrvDTO : drugssrvs) {
			MedSrvDO medsrv = medSrvMpa.get(emsDrugsSrvDTO.getCode_srv());
			OrdSrvDO srvdo = assembleSrv(emsDrugsSrvDTO,medsrv,order);
			emsDrugsSrvDTO.setOrdSrvDO(srvdo);
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
	/**
	 * 组装医嘱对应的服务信息
	 * @param order
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO asssembleSrv(CiOrderDO order) throws BizException {
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO medsrv = service.findById(order.getId_srv());
		OrdSrvDO srvdo = new OrdSrvDO();
		String[] id_orsrv = new DBUtil().getOIDs(1);
		srvdo.setId_orsrv(id_orsrv[0]);
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_pat(this.getEntdo().getId_pat());
		srvdo.setId_en(this.getEntdo().getId_ent());
		srvdo.setId_entp(this.getEntdo().getId_entp());
		srvdo.setCode_entp(this.getEntdo().getCode_entp());
		srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());
		srvdo.setId_pripat(this.getEntdo().getId_pripat());
		srvdo.setId_grp(this.getEntdo().getId_grp());
		srvdo.setId_org(this.getEntdo().getId_org());
		srvdo.setSortno(0);
		
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(order.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		srvdo.setId_en(this.getEntdo().getId_ent());
		srvdo.setId_hp(this.getEntHpdo().getId_hp());
		
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

	@Override
	public OrdSrvDO assembleSrv(BaseDTO srvdto) throws BizException {
		EmsCommonSrvDTO emsDrugsSrvDTO = (EmsCommonSrvDTO) srvdto;
		OrdSrvDO srvdo = new OrdSrvDO();
		String[] id_orsrv = new DBUtil().getOIDs(1);
		srvdo.setId_orsrv(id_orsrv[0]);
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_pat(this.getEntdo().getId_pat());
		srvdo.setId_en(this.getEntdo().getId_ent());
		srvdo.setId_entp(this.getEntdo().getId_entp());
		srvdo.setCode_entp(this.getEntdo().getCode_entp());
		srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());
		srvdo.setId_pripat(this.getEntdo().getId_pripat());
		srvdo.setId_grp(this.getEntdo().getId_grp());
		srvdo.setId_org(this.getEntdo().getId_org());
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
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		srvdo.setId_en(this.getEntdo().getId_ent());
		srvdo.setId_hp(this.getEntHpdo().getId_hp());
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
	public OrdSrvDO assembleSrv(BaseDTO srvdto, MedSrvDO medsrv, CiOrderDO order) throws BizException {
		OrdSrvDO srvdo = this.assembleSrv(srvdto);
		if (medsrv != null) {
			srvdo.setId_srv(medsrv.getId_srv());
			srvdo.setSd_srvtp(medsrv.getSd_srvtp());
			srvdo.setId_srvtp(medsrv.getId_srvtp());
			srvdo.setCode_srv(medsrv.getCode());
			srvdo.setId_srvca(medsrv.getId_srvca());
			srvdo.setName(medsrv.getName());
			srvdo.setId_primd(medsrv.getId_primd());
			srvdo.setFg_bl(medsrv.getFg_bl());
			if(StringUtils.isEmpty(srvdo.getId_medu())){
				srvdo.setId_medu(medsrv.getId_unit_med());
				srvdo.setMedu_name(medsrv.getMed_name());
			}
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
	 * 组装医嘱信息
	 * 
	 * @param orddto
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO assembleOrder(EmsCommonOrdDTO orddto) throws BizException {
		CiOrderDO ordo = new CiOrderDO();
		ordo.setStatus(DOStatus.NEW);
		String[] id_ors = new DBUtil().getOIDs(1);
		ordo.setId_or(id_ors[0]);
		
		ICIOrdRService ciOrdRService = ServiceFinder.find(ICIOrdRService.class);
		Integer result = ciOrdRService.getOrdMaxSortno(this.getEntdo().getId_ent());
		ordo.setSortno(++result);
		
		// 草药是否院内制剂
		ordo.setFg_hospital_herbpres(FBoolean.FALSE);
		ordo.setId_grp(this.getEntdo().getId_grp());
		ordo.setId_org(this.getEntdo().getId_org());
		ordo.setId_pat(this.getEntdo().getId_pat());
		ordo.setId_en(this.getEntdo().getId_ent());
		ordo.setId_entp(this.getEntdo().getId_entp());
		ordo.setCode_entp(this.getEntdo().getCode_entp());
		// 取第一个服务然后补齐
		// ordo.setId_srvtp(oridrelinfo.getId_srvtp());
		// ordo.setSd_srvtp(oridrelinfo.getSd_srvtp());
		// ordo.setId_srv(ems.getId_srv());
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
			ordo.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());
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
		ordo.setId_org_or(CiOrdUtils.getOrgOfDept(ordo.getId_dep_or()));
		// ordo.setId_wg_or(ems.getId_wg_or());没有
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
			ordo.setDt_entry(CiOrdAppUtils.getServerDateTime());
		}
		ordo.setDt_sign(ordo.getDt_entry());
		ordo.setDt_effe(ordo.getDt_entry());
		if (ordo.getDays_or() != null) {
			ordo.setDt_end(ordo.getDt_effe().getDateTimeAfter(ordo.getDays_or()));
		}
		ordo.setDt_last_mp(ordo.getDt_effe());
		ordo.setDt_last_bl(ordo.getDt_effe());
		ordo.setDt_invalid(getDt_invalid(ordo.getDt_effe()));
		ordo.setFg_chk(CiOrdUtils.nullHandle(null));

		ordo.setFg_chk_stop(CiOrdUtils.nullHandle(null));
		ordo.setFg_canc(CiOrdUtils.nullHandle(null));
		ordo.setFg_chk_canc(CiOrdUtils.nullHandle(null));
		ordo.setFg_pmor(FBoolean.FALSE);
		ordo.setDes_pmor(null);
		ordo.setFg_active_pm(FBoolean.FALSE);
		ordo.setFg_ctlcp(null);
		ordo.setFg_mr(null);
		// 取第一个服务项目后再计算
		// ordo.setFg_mp_in(CiOrdUtils.JudgeFgMpIn(ordo.getCode_entp(),ordo.getSd_srvtp()));
		ordo.setFg_pres_outp(null);
		GetTotalTimesBP times = new GetTotalTimesBP();
		ordo.setTimes_cur(times.getTotalTimes(ordo.getDt_effe(),ordo.getId_freq(), ordo.getDays_or()));
		
		ordo.setFg_mp_bed(null);
		ordo.setNote_or(orddto.getDes_or());
		// 诊疗医嘱需要保存
		// ordo.setApplyno(ems.getApplyno());
		AuditInfoUtil.addData(ordo);// 设置设计信息
		ordo.setFg_skintest(null);
		ordo.setFg_feertnable(FBoolean.TRUE); // 可退费标识

		// 添加字段 医嘱来源
		ordo.setFg_uncancelable(FBoolean.FALSE);// 医嘱执行不可逆标识
		ordo.setEu_orsrcmdtp(OrSourceFromEnum.THIRDPARTYSYS);
		// 第三方调用医嘱，保存医嘱医生站
		ordo.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_MT);
		ordo.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_MT);

		ordo.setFg_vip(this.getEntdo().getFg_ip());// vip号
		// 诊断信息
		// ordo.setId_didef(ems.getId_didef());
		// ordo.setCode_didef(ems.getCode_didef());
		// ordo.setName_didef(ems.getName_didef());
		if (StringUtils.isNotEmpty(orddto.getCode_srv_or())) {
			IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
			MedSrvDO[] medsrvs = service.findByAttrValStrings(MedSrvDO.CODE,new String[]{orddto.getCode_srv_or()});
			if(medsrvs!=null&&medsrvs.length>0){
				MedSrvDO medsrv = medsrvs[0];
				ordo.setId_srv(medsrv.getId_srv());
				ordo.setId_srvtp(medsrv.getId_srvtp());
				ordo.setSd_srvtp(medsrv.getSd_srvtp());
				ordo.setId_srvca(medsrv.getId_srvca());
				ordo.setName_or(medsrv.getName());
				if(StringUtils.isNotEmpty(orddto.getQuan_medu_or())){
					ordo.setQuan_medu(new FDouble(orddto.getQuan_medu_or()));
				}else{
					ordo.setQuan_medu(medsrv.getQuan_med());
				}
				ordo.setId_unit_med(medsrv.getId_unit_med());
			}
		}
		ordo.setStatus(DOStatus.NEW);
		return ordo;
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

	/**
	 * 医嘱的过期时间
	 * 
	 * @param dt_effe
	 * @return
	 */
	private FDateTime getDt_invalid(FDateTime dt_effe) {
		try {
			Integer hours = ParamsetQryUtil.getParaInt(CiOrdAppUtils.getEnvContext().getOrgId(),
					ICiOrdNSysParamConst.SYS_PARAM_OpOrValidTime);
			if (hours <= 0)
				hours = 24;
			return DateUtils.getDateTimeAfter(dt_effe, hours);
		} catch (Exception ex) {
			// 若参数不存在，不给该字段赋值
		}
		return null;
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
		order.setFg_mp_in(CiOrdUtils.JudgeFgMpIn(order.getCode_entp(), order.getSd_srvtp()));
		if (order.getFg_mp_in()!=null) {
			if (order.getFg_mp_in().booleanValue()) {
				order.setTimes_mp_in(order.getTimes_cur());
			}
		}
		order.setId_orpltp(OrderUtils.getOrCLoopTpId(order));
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
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER,
				orders.toArray(new CiOrderDO[0]));
	}
	/**
	 * 组装医嘱内容
	 * @param dataSource
	 * @param aggarrays
	 */
	protected void assembleContent_or(CiorderAggDO agg){
		
	}
}
