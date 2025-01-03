package iih.ci.ord.s.external.thirdws.op.drugs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.i.ICiOrdLogService;
import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsRstDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EmsDrugsOrdDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EmsDrugsPresDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EntWsDrugsDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.i.IPresCudService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.orcontent.dto.DrugOrContentParam;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.OrContentDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpCommonSaveAction;
import iih.ci.ord.s.external.thirdws.utils.BdDiDefUtils;
import iih.ci.ord.s.external.thirdws.utils.BdMeasdocUtils;
import iih.ci.ord.s.external.thirdws.utils.UdidocUtils;
import iih.mp.dg.i.IMpDgOutService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.udi.d.UdidocDO;

public class EmsDrugSaveAction extends OpCommonSaveAction{
	// 缓存物品,key:mmcode,value:MeterialDO
	private Map<String, MeterialDO> meterialMapTemp;
	@Override
	public String save(EntWsDTO entwsdto) throws BizException {
		super.save(entwsdto);
		EntWsDrugsDTO entdrugsdto = (EntWsDrugsDTO) entwsdto;

		List<EmsDrugsPresDTO> presList = entdrugsdto.getPresList();
		List<CiorderAggDO> aggs = new ArrayList<CiorderAggDO>();
		List<CiPresDO> preses = new ArrayList<CiPresDO>();
		List<OrdSrvMmDO> ordsrvmms = new ArrayList<OrdSrvMmDO>();

		for (EmsDrugsPresDTO emsDrugsPresDTO : presList) {
			CiPresDO ciPresDo = assemblePres(emsDrugsPresDTO);
			preses.add(ciPresDo);
			List<EmsDrugsOrdDTO> drugsOrds = emsDrugsPresDTO.getOrdList();
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
					List<EmsCommonSrvDTO> emsDrugsSrvs = emsDrugsOrdDTO.getSrvList();
					for (EmsCommonSrvDTO emsDrugsSrvDTO : emsDrugsSrvs) {
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
		EmsRstDTO rst = new EmsRstDTO();
		rst.setResultcode("0");
		rst.setResultmsg("药品医嘱保存成功");
		return this.rstMsg(rst);
	}

	/**
	 * 组装OrdSrvMmDO信息
	 * 
	 * @param srvdto
	 * @return
	 * @throws BizException
	 */
	private OrdSrvMmDO assembleSrvMM(EmsCommonSrvDTO srvdto) throws BizException {
		OrdSrvDO srvdo = srvdto.getOrdSrvDO();
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
				srvmmdo.setId_medu_cur(measdoc.getId_measdoc());
			}
		}
		// 总量
		if (StringUtils.isNotEmpty(srvdto.getQuan_cur())) {
			srvmmdo.setQuan_cur(new FDouble(srvdto.getQuan_cur()));
		}
		// 剂量
		if (StringUtils.isNotEmpty(srvdto.getQuan_medu_cur())) {
			srvmmdo.setQuan_medu_cur(new FDouble(srvdto.getQuan_medu_cur()));
		}
	
		if (StringUtils.isNotEmpty(srvdto.getPri())) {
			srvmmdo.setPrice_pgku_cur(new FDouble(srvdto.getPri()));
		} else {
			srvmmdo.setPrice_pgku_cur(CiOrdUtils.getOrSrvMMPrice(srvmmdo.getId_mm(), srvmmdo.getId_pgku_base()));
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
			srvmmdo.setFactor_cur(srvdto.getFactor_cur());
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
		pres.setId_grp(this.getEntdo().getId_grp());
		pres.setId_org(this.getEntdo().getId_org());
		pres.setId_pati(this.getEntdo().getId_pat());
		pres.setId_entp(this.getEntdo().getId_entp());
		pres.setCode_entp(this.getEntdo().getCode_entp());
		pres.setId_en(this.getEntdo().getId_ent());
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
	public List<OrdSrvDO> asssembleSrv(List<EmsCommonSrvDTO> drugssrvs, CiOrderDO order) throws BizException {
		List<OrdSrvDO> srvdos = new ArrayList<OrdSrvDO>();
		List<String> code_mms = new ArrayList<String>();
		for (EmsCommonSrvDTO emsDrugsSrvDTO : drugssrvs) {
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
		for (EmsCommonSrvDTO emsDrugsSrvDTO : drugssrvs) {
			MeterialDO mm = meterialMap.get(emsDrugsSrvDTO.getCode_mm());
			MedSrvDO medsrv = medSrvMpa.get(mm.getId_srv());
			OrdSrvDO srvdo = assembleSrv(emsDrugsSrvDTO, medsrv, order);
			emsDrugsSrvDTO.setOrdSrvDO(srvdo);
			// 组装完服务的同时，将ci_or_srv_mm表组装一下
			srvdos.add(srvdo);
		}
		return srvdos;
	}

	/**
	 * 医嘱内容拼接
	 */
	@Override
	protected void assembleContent_or(CiorderAggDO agg) {
		List<OrContentDTO> orContentDtos = new ArrayList<OrContentDTO>();
		CiOrderDO order = agg.getParentDO();
		OrdSrvDO[] ordsrvs = agg.getOrdSrvDO();
		for (int i = 0; i < ordsrvs.length; i++) {
			OrdSrvDO ordsrv = (OrdSrvDO) ordsrvs[i];
			OrContentDTO orContentDTO = new OrContentDTO(ordsrv.getName_srv(), ordsrv.getQuan_medu(),
					ordsrv.getMedu_name(), ordsrv.getFg_self() == null ? false : ordsrv.getFg_self().booleanValue());
			orContentDtos.add(orContentDTO);
			DrugOrContentParam param = new DrugOrContentParam(order.getSd_srvtp(), order.getFreq_name(),
					order.getDays_or(), order.getRoute_name(), order.getNote_or(), orContentDtos);
			CiOrContentDO ciOrContentDO = CiOrContentUtils.create(param);
			ciOrContentDO.setTitle(order.getOrders() == null ? "" : order.getOrders() + "");
			order.setContent_or(ciOrContentDO.toString());
		}

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
