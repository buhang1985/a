package iih.ci.ord.s.ems.ip.assi.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.emsqry.d.EmsFunclassKVDTO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrtmplMDORService;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseTplSaveBP;
import iih.ci.ord.s.ems.cache.BDFreqInfoCache;
import iih.ci.ord.s.ems.cache.BDMeterialInfoCache;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院医生站 医嘱模板保存基类
 * @author wangqingzhu
 *
 */
public class BaseIpTplSaveBP extends BaseTplSaveBP {
	
	private IEmsManagementService iemsmanagementservice = ServiceFinder.find(IEmsManagementService.class);
	
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) 
			throws BizException {
		EmsSaveDTO tpl = szEms[0];
		return this.splitTplData(ctx, tpl.getDocument());
	}
	/***
	 * 前端传入的模版明细do进行拆捡按照模版id进行分组
	 * @param tplList
	 * @return
	 * @throws BizException 
	 */
	private EmsRstDTO[] splitTplData(CiEnContextDTO ctx, FArrayList tplList) 
			throws BizException {
		// 存放分组后的集合数据
		FMap result = new FMap();
		for (Object object : tplList) {
			OrTplNItmDO tplItem = (OrTplNItmDO) object;
			if (tplItem.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
				// 西药分组
				this.setOrTplNItmDO(result, tplItem, IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG);
			} else if (tplItem.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				// 草药分组
				this.setOrTplNItmDO(result, tplItem, IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG);
			} else if (tplItem.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				// 检查分组
				this.setOrTplNItmDO(result, tplItem, IBdSrvDictCodeConst.SD_SRVTP_RIS);
			} else if (tplItem.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
				// 检验分组
				this.setOrTplNItmDO(result, tplItem, IBdSrvDictCodeConst.SD_SRVTP_LIS);
			} else if (tplItem.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)) {
				// 手术分组
				this.setOrTplNItmDO(result, tplItem, IBdSrvDictCodeConst.SD_SRVTP_OP);
			} else if (tplItem.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH)) {
				// 死亡分组
				this.setOrTplNItmDO(result, tplItem, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH);
			} else if (tplItem.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT)) {
				// 转科
				this.setOrTplNItmDO(result, tplItem, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT);
			} else if (tplItem.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS)) {
				// 出院
				this.setOrTplNItmDO(result, tplItem, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS);
			} else {
				// 治疗分组
				this.setOrTplNItmDO(result, tplItem, IBdSrvDictCodeConst.SD_SRVTP_TREAT);
			}
		}
		return handleTplMap(ctx, result);
	}
	
	/**
	 * 数据分组
	 * @param fMap
	 * @param tplItem
	 * @param sd_srvtp
	 */
	@SuppressWarnings("unchecked")
	private void setOrTplNItmDO(FMap fMap, OrTplNItmDO tplItem, String sd_srvtp) {
		if (fMap.containsKey(sd_srvtp)) {
			((FArrayList) fMap.get(sd_srvtp)).add(tplItem);
		} else {
			FArrayList list = new FArrayList();
			list.add(tplItem);
			fMap.put(sd_srvtp, list);
		}
	}
	
	/**
	 * 循环处理map中按照类型分组的模版数据
	 * @param ctx
	 * @param tplMap
	 * @throws BizException
	 */
	private EmsRstDTO[] handleTplMap(CiEnContextDTO ctx, FMap tplMap) 
			throws BizException {
		Iterator<Entry<String, Object>> entryKeyIterator = tplMap.entrySet().iterator();  
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		// 循环map调用不同处理驱动
		while (entryKeyIterator.hasNext()) {
			Entry<String, Object> obj = entryKeyIterator.next();
			FArrayList tplList = (FArrayList) obj.getValue();
			String sd_srvtp = obj.getKey();
			if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				// 检查
				rsts.addAll(handleTplMap4Ris(ctx, tplList, sd_srvtp));
			} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
				// 西药
				rsts.addAll(handleTplMap4Drugs(ctx, tplList, sd_srvtp));
			} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				// 草药
				rsts.addAll(handleTplMap4Herbs(ctx, tplList, sd_srvtp));
			} else {
				// 其他
				rsts.addAll(handleTplMap4Common(ctx, tplList, sd_srvtp));
			}
		}
		return rsts.toArray(new EmsRstDTO[] {});
	} 
	
	private String validateTplMap4Drugs(CiEnContextDTO ctx, FArrayList drugList) throws BizException {
		String rst = "";
		for (Object drug : drugList) {
			OrTplNItmDO itmDO = (OrTplNItmDO) drug;
			MeterialDO mmInfo = BDMeterialInfoCache.GetMeterialInfo(ctx, itmDO.getId_mm());
			if (itmDO.getId_freq() == null) {
				rst += String.format("【%s】频次为空！", mmInfo.getName());
			}
			if (itmDO.getId_route() == null) {
				rst += String.format("【%s】用法为空！", mmInfo.getName());
			}
		}
		return rst;
	}
	
	/**
	 * 西药药品数据处理
	 * @param ctx
	 * @param tplList
	 * @param sd_srvtp
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<EmsRstDTO> handleTplMap4Drugs(CiEnContextDTO ctx, FArrayList tplList, String sd_srvtp) 
			throws BizException {
		// 成组西药
		FMap drugGrpMap = new FMap();
		// 药品根据模板id分组
		FMap drugMaps = new FMap();
		// 西药服务idsrv集合
		FArrayList drugIdSrvList = new FArrayList();
		IOrtmplMDORService iortmplmdorservice = ServiceFinder.find(IOrtmplMDORService.class);
		// 分拣 成组西药 和单个药品服务
		for (Object object : tplList) {
  			OrTplNItmDO tplItem = (OrTplNItmDO) object;
			drugIdSrvList.add(tplItem.getId_srv());
  			if (drugGrpMap.containsKey(tplItem.getId_ortmpl())) {
				((FArrayList) drugGrpMap.get(tplItem.getId_ortmpl())).add(tplItem);
			} else {
				OrTmplDO ortmpldo = iortmplmdorservice.findById(tplItem.getId_ortmpl());
				FArrayList list = new FArrayList();
				list.add(tplItem);
				if (ortmpldo.getSd_ortmpltp().equals(IBdSrvDictCodeConst.SD_ORTMPLTP_BASE_WEST)) {
					// 成组西药
 					drugGrpMap.put(tplItem.getId_ortmpl(), list);
 				} else {
					drugMaps.put(tplItem.getId_ortmplitm(), list);
				}
			}
		}
		FMap medSrvMatchEmsMap = medSrvMatchEms(ctx, drugIdSrvList, sd_srvtp);
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		// 循环迭代成组西药
		Iterator<Entry<String, Object>> entryDrugGrpKeyIterator = drugGrpMap.entrySet().iterator();
		while (entryDrugGrpKeyIterator.hasNext()) {
			Entry<String, Object> drugObj = entryDrugGrpKeyIterator.next();
			FArrayList drugList = (FArrayList) drugObj.getValue();
			String errorinfo = this.validateTplMap4Drugs(ctx, drugList);
			if (errorinfo.length() > 0) {
				EmsRstDTO rstDTO = new EmsRstDTO();
				FArrayList errorlist = new FArrayList();
				errorlist.add(errorinfo);
				rstDTO.setErrorEmsList(errorlist);
				rsts.add(rstDTO);
				continue;
			}
			rsts.add(refCallWithDriverInfo(ctx, medSrvMatchEmsMap, drugList));
		}
		// 循环迭代单个西药服务
		Iterator<Entry<String, Object>> entryDrugSingleKeyIterator = drugMaps.entrySet().iterator();
		while (entryDrugSingleKeyIterator.hasNext()) {
			Entry<String, Object> drugObj = entryDrugSingleKeyIterator.next();
			FArrayList drugList = (FArrayList) drugObj.getValue();
			String errorinfo = this.validateTplMap4Drugs(ctx, drugList);
			if (errorinfo.length() > 0) {
				EmsRstDTO rstDTO = new EmsRstDTO();
				FArrayList errorlist = new FArrayList();
				errorlist.add(errorinfo);
				rstDTO.setErrorEmsList(errorlist);
				rsts.add(rstDTO);
				continue;
			}
			rsts.addAll(refCommonCallWithDriverInfo(ctx, medSrvMatchEmsMap, drugList));
		}
		return rsts;
	}
	
	/**
	 * 草药药品数据处理
	 * @param ctx
	 * @param tplList
	 * @param iemsmanagementservice
	 * @param sd_srvtp
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<EmsRstDTO> handleTplMap4Herbs(CiEnContextDTO ctx, FArrayList tplList, String sd_srvtp) 
			throws BizException {
		// 成组草药
		FMap herbGrpMaps = new FMap();
		// 西药服务idsrv集合
		FArrayList herbIdSrvList = new FArrayList();
		// 分拣 成组西药 和单个药品服务
		for (Object object : tplList) {
			OrTplNItmDO tplItem = (OrTplNItmDO) object;
			herbIdSrvList.add(tplItem.getId_srv());
			if (herbGrpMaps.containsKey(tplItem.getId_ortmpl())) {
				((FArrayList) herbGrpMaps.get(tplItem.getId_ortmpl())).add(tplItem);
			} else {
				FArrayList list = new FArrayList();
				list.add(tplItem);
				herbGrpMaps.put(tplItem.getId_ortmpl(), list);
			}
		}
		FMap medSrvMatchEmsMap = medSrvMatchEms(ctx, herbIdSrvList, sd_srvtp);
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		// 循环迭代草药方剂
		Iterator<Entry<String, Object>> entryHerbGrpKeyIterator = herbGrpMaps.entrySet().iterator();
		while (entryHerbGrpKeyIterator.hasNext()) {
			Entry<String, Object> herbObj = entryHerbGrpKeyIterator.next();
			FArrayList herbList = (FArrayList) herbObj.getValue();
			rsts.add(refCallWithDriverInfo(ctx, medSrvMatchEmsMap, herbList));
		}
		return rsts;
	}
	/**
	 * 检查数据处理
	 * @param ctx
	 * @param tplList
	 * @param iemsmanagementservice
	 * @param sd_srvtp
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<EmsRstDTO> handleTplMap4Ris(CiEnContextDTO ctx,FArrayList tplList, String sd_srvtp) 
			throws BizException{
		// 分拣检查数据区分套和非套
		FMap risSingleMap = new FMap();// 套
		FMap risSetMap = new FMap();// 非套
		FArrayList idSrvList = new FArrayList();
		for (Object object : tplList) {
			OrTplNItmDO tplItem = (OrTplNItmDO) object;
			if(!CiOrdUtils.isEmpty(tplItem.getId_srv_set())){
				if (risSetMap.containsKey(tplItem.getId_srv_set())) {
					((FArrayList) risSetMap.get(tplItem.getId_srv_set())).add(tplItem);
				}else{
					FArrayList list = new FArrayList();
					list.add(tplItem);
					risSetMap.put(tplItem.getId_srv_set(), list);
					idSrvList.add(tplItem.getId_srv_set());
				}
			}else{
				FArrayList list = new FArrayList();
				list.add(tplItem);
				risSingleMap.put(tplItem.getId_srv(), list);
				idSrvList.add(tplItem.getId_srv());
			}
		}
		FMap medSrvMatchEmsMap = medSrvMatchEms(ctx, idSrvList,sd_srvtp);
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		// 循环迭代服务套服务
		Iterator<Entry<String, Object>> entryRisSetKeyIterator = risSetMap.entrySet().iterator();
		while (entryRisSetKeyIterator.hasNext()) {
			Entry<String, Object> risObj = entryRisSetKeyIterator.next();
			FArrayList risList = (FArrayList) risObj.getValue();
			rsts.add(refCallWithDriverInfo(ctx, medSrvMatchEmsMap, risList));
		}
		// 循环迭代非套服务
		Iterator<Entry<String, Object>> entryRisSingleKeyIterator = risSingleMap.entrySet().iterator();
		while (entryRisSingleKeyIterator.hasNext()) {
			Entry<String, Object> risObj = entryRisSingleKeyIterator.next();
			FArrayList risList = (FArrayList) risObj.getValue();
			rsts.addAll(refCommonCallWithDriverInfo(ctx, medSrvMatchEmsMap, risList));
		}
		return rsts;
	}
	/**
	 * 通用模版数据处理
	 * @param ctx
	 * @param tplList
	 * @param iemsmanagementservice
	 * @param sd_srvtp
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<EmsRstDTO> handleTplMap4Common(CiEnContextDTO ctx,FArrayList tplList, String sd_srvtp) 
			throws BizException{
		FArrayList idSrvList = new FArrayList();
		for (Object object : tplList) {
			OrTplNItmDO tplItem = (OrTplNItmDO) object;
			idSrvList.add(tplItem.getId_srv());
		}
		FMap medSrvMatchEmsMap = medSrvMatchEms(ctx, idSrvList,sd_srvtp);
		List<EmsRstDTO> rsts = refCommonCallWithDriverInfo(ctx, medSrvMatchEmsMap, tplList);
		return rsts;
	}
	/**
	 * 医疗单匹配
	 * @param ctx
	 * @param tpllist
	 * @return
	 * @throws BizException
	 */
	private FMap medSrvMatchEms(CiEnContextDTO ctx, FArrayList idSrvList, String sd_srvtp)
			throws BizException {
		List<SrvMatchEmsParamDTO> emslist = new ArrayList<SrvMatchEmsParamDTO>();
		if (!CiOrdUtils.isEmpty(idSrvList)) {
			for (Object object : idSrvList) {
				String id_srv = (String) object;
				SrvMatchEmsParamDTO srvmatchemsparamdto = assemblyEmsMatchInfo(ctx, id_srv, sd_srvtp);
				emslist.add(srvmatchemsparamdto);
			}
		}

		return iemsmanagementservice.medSrvMatchEms(emslist.toArray(new SrvMatchEmsParamDTO[] {}));
	}
	
	/**
	 * 拼装查询医疗单驱动的入参对象
	 * @param ctx
	 * @param tplItem
	 * @param isSet
	 * @return
	 */
	private SrvMatchEmsParamDTO assemblyEmsMatchInfo(CiEnContextDTO ctx, String id_srv, String sd_srvtp) {
		SrvMatchEmsParamDTO srvmatchemsparamdto = new SrvMatchEmsParamDTO();
		srvmatchemsparamdto.setCode_entp(ctx.getCode_entp());
		srvmatchemsparamdto.setDt_or(CiOrdAppUtils.getServerDateTime());
		srvmatchemsparamdto.setId_dept(ctx.getId_dep_or());
		srvmatchemsparamdto.setId_emp(ctx.getId_emp_or());
		srvmatchemsparamdto.setId_grp(ctx.getId_grp());
		srvmatchemsparamdto.setId_org(ctx.getId_org());
		srvmatchemsparamdto.setId_srv(id_srv);
		srvmatchemsparamdto.setSd_srvtp(sd_srvtp);
		srvmatchemsparamdto.setEmsappmode(0);
		return srvmatchemsparamdto;
	}
	/**
	 * 通用非套反射调用驱动类
	 * @param ctx
	 * @param medSrvMatchEmsMap
	 * @param tpllist
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<EmsRstDTO> refCommonCallWithDriverInfo(CiEnContextDTO ctx, FMap medSrvMatchEmsMap, FArrayList tpllist) 
			throws BizException {
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		for(Object object : tpllist) {
			FArrayList doc = new FArrayList();
			doc.add(object);
			rsts.add(refCallWithDriverInfo(ctx, medSrvMatchEmsMap, doc));
		}
		return rsts;
	}
	
	/**
	 * 成组药反射调用驱动类
	 * @param ctx
	 * @param medSrvMatchEmsMap
	 * @param tpllist
	 * @throws BizException
	 */
	private EmsRstDTO refCallWithDriverInfo(CiEnContextDTO ctx, FMap medSrvMatchEmsMap, FArrayList tpllist) 
			throws BizException {
		OrTplNItmDO tplItem = (OrTplNItmDO) tpllist.get(0);
		SrvMatchEmsRstDTO srvmatchemsrstdto = (SrvMatchEmsRstDTO) medSrvMatchEmsMap.get(CiOrdUtils.isEmpty(tplItem.getId_srv_set())?tplItem.getId_srv():tplItem.getId_srv_set());
		EmsFunclassKVDTO driverInfo = iemsmanagementservice.getEmsFunclassKVDTO(srvmatchemsrstdto.getFuncclassstr());
		if (null != driverInfo && !CiOrdUtils.isEmpty(driverInfo.getTmpl_Classpath_jar())) {
			// 设置后台驱动描述
			EmsSaveDTO ems = new EmsSaveDTO();
			ems.setDocument(tpllist);
			EmsDriverInfo driver = new EmsDriverInfo();
			driver.setDll(driverInfo.getDll());
			driver.setEmsBackendDriver(driverInfo.getClasspath_jar());
 			driver.setEmsFrontDriver(driverInfo.getClasspath_dll());
			driver.setTmpl_Classpath_jar(driverInfo.getTmpl_Classpath_jar());
			driver.setJsonDriver(srvmatchemsrstdto.getFuncclassstr());
			ems.setDriverInfo(driver);
			// 反射调用医疗单加载方法
			EmsRstDTO[] szRstInfo = ReflClassUtils.ReflCallWith(ems.getDriverInfo().getTmpl_Classpath_jar(), "save", ctx, EmsSaveDTO[].class, new EmsSaveDTO[] { ems });
			return szRstInfo[0];
		}
		return null;
	}
	
	/**
	 * 医嘱信息赋值
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param orderListViewDTO
	 * @throws BizException
	 */
	protected void setEmsViewInfo(CiEnContextDTO ctx, OrTmplDO ortmpldo, OrTplNItmDO ortplnitmdo, MedSrvDO medSrvInfo, EmsDriverInfo driverinfo, OrderListViewDTO orderListViewDTO, String code_or, int index) 
			throws BizException {
		if (ortmpldo == null)
			return;
		FDateTime dt = CiOrdAppUtils.getServerDateTime();
		orderListViewDTO.setCode_or(code_or);
		orderListViewDTO.setSortno_srv(index);
		orderListViewDTO.setId_srvtp(medSrvInfo.getId_srvtp());// 服务类型ID
		orderListViewDTO.setSd_srvtp(medSrvInfo.getSd_srvtp());// 服务类型编码
		orderListViewDTO.setName_srvtp(medSrvInfo.getSrvtp_name());// 服务类型
		
		orderListViewDTO.setId_srv(medSrvInfo.getId_srv());// 服务ID
		orderListViewDTO.setCode_srv(medSrvInfo.getCode());// 服务编码
		orderListViewDTO.setName_srv(medSrvInfo.getName());// 服务
		orderListViewDTO.setQuan_med((CiOrdUtils.isTrue(ortplnitmdo.getIsmuldose()) ? ortplnitmdo.getQuan_med() : new FDouble(1)));// 剂量
		orderListViewDTO.setId_unit_med(ortplnitmdo.getId_unit_med());// 剂量单位ID
		orderListViewDTO.setName_unit_med(ortplnitmdo.getOrtplnitm_unit_name());// 剂量单位
		
		if (!CiOrdUtils.isTrue(medSrvInfo.getIsmulexec())) {
			orderListViewDTO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);// 频次ID
			orderListViewDTO.setName_freq(IBdSrvDictCodeConst.CODE_FREQNUNITCT_ITEM_ONCE);// 频次
			orderListViewDTO.setFreqct(1);// 频次数量
			orderListViewDTO.setSd_frequnitct(IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE);// 频次周期类型编码
			orderListViewDTO.setFg_long(FBoolean.FALSE);// 长临标识
			orderListViewDTO.setFg_long_edit(FBoolean.FALSE);// 长临标识可编辑标识
		} else {
			FreqDefDO freqDefDO = BDFreqInfoCache.GetFreqInfo(ortplnitmdo.getId_freq());
			if (freqDefDO == null) {
				orderListViewDTO.setId_freq(null);
				orderListViewDTO.setName_freq(null);
				orderListViewDTO.setSd_frequnitct(null);
				orderListViewDTO.setFreqct(null);
				orderListViewDTO.setFg_long(null);// 长临标识
				orderListViewDTO.setFg_long_edit(null);// 长临标识可编辑标识
			}else{
				orderListViewDTO.setId_freq(freqDefDO.getId_freq());
				orderListViewDTO.setName_freq(freqDefDO.getCode());
				orderListViewDTO.setSd_frequnitct(freqDefDO.getSd_frequnitct());
				orderListViewDTO.setFreqct(freqDefDO.getFreqct());
				orderListViewDTO.setFg_long(freqDefDO.getFg_long());// 长临标识
				orderListViewDTO.setFg_long_edit(freqDefDO.getFg_long_edit());// 长临标识可编辑标识
			}
		}
		
		orderListViewDTO.setId_route(ortplnitmdo.getId_route());// 用法ID
		orderListViewDTO.setName_route(ortplnitmdo.getOrtplnitm_route_name());// 用法
		orderListViewDTO.setId_routedes(ortplnitmdo.getId_routedes());// 用法要求ID
		orderListViewDTO.setName_routedes(ortplnitmdo.getOrtplnitm_routedes_name());// 用法要求
		orderListViewDTO.setId_emp_or(ctx.getId_emp_or());// 开立医生ID
		orderListViewDTO.setName_emp_or(ctx.getName_emp_or());// 开立医生
		orderListViewDTO.setDt_effe(dt);// 开立时间
		orderListViewDTO.setDt_end(null);// 停止时间
		orderListViewDTO.setDays_or(ortplnitmdo.getDays_or() == null ? 1 : ortplnitmdo.getDays_or());// 医嘱天数
		// orderListViewDTO.setTimes_cur(Times_cur);//次数
		orderListViewDTO.setFg_research(FBoolean.FALSE);// 科研标识
		orderListViewDTO.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);// 医嘱状态：开立
		orderListViewDTO.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);// 医嘱状态：开立
		orderListViewDTO.setFg_set(medSrvInfo.getFg_set());// 服务套标识
		orderListViewDTO.setFg_setradio(medSrvInfo.getFg_setradio());
		orderListViewDTO.setFg_urgent(FBoolean.FALSE);// 加急标识
		orderListViewDTO.setFg_urgent_edit(medSrvInfo.getFg_urgent_ip());//加急可使用标识
		orderListViewDTO.setFg_selfpay(FBoolean.TRUE);// 自费标识
		
		orderListViewDTO.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);//医嘱服务来源方式:医生开立
		orderListViewDTO.setEu_orsrcmdtp(OrSourceFromEnum.IIHORTMPLHELPER);// 医嘱来源方式：医嘱模板
		orderListViewDTO.setIsmuldose(medSrvInfo.getIsmuldose());// 多剂量标识
		orderListViewDTO.setIsmulexec(medSrvInfo.getIsmulexec());// 多次执行标识
		orderListViewDTO.setSd_totalopenmode(medSrvInfo.getSd_totalopenmode());// 总量开单模式
		orderListViewDTO.setEu_blmd(medSrvInfo.getEu_blmd());// 划价方式
		orderListViewDTO.setFg_selfsrv(medSrvInfo.getFg_ctm());// 自定义服务标识
		orderListViewDTO.setFg_use(medSrvInfo.getFg_use_ip());// 住院可使用标识-当前就诊类型
		orderListViewDTO.setId_primd(medSrvInfo.getId_primd());
		orderListViewDTO.setFg_or(medSrvInfo.getFg_or());
		
		// 当前剂量单位和剂量赋值
		orderListViewDTO.setId_medu_cur(orderListViewDTO.getId_unit_med());
		orderListViewDTO.setName_medu_cur(orderListViewDTO.getName_unit_med());
		orderListViewDTO.setQuan_medu_cur(orderListViewDTO.getQuan_med());

		// 医疗单驱动
		orderListViewDTO.setDriverInfo(driverinfo);
		// 医嘱开立方式：默认医嘱列表开立
		orderListViewDTO.setEu_OrderPrescribeModule(OrderPrescribeModuleEnum.ORDERTEMP);
		orderListViewDTO.setFg_pres_outp(FBoolean.FALSE);
		orderListViewDTO.setStatus(DOStatus.NEW);
		
		//取模板配置的执行科室
		orderListViewDTO.setId_dep_mp(ortplnitmdo.getId_dep_mp());
		orderListViewDTO.setName_dep_mp(ortplnitmdo.getOrtplnitm_mp_name());
		
	}
	/**
	 * 设置执行科室信息
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param orderListViewDTO
	 * @throws BizException
	 */
	protected void setOrWfDeptInfo(CiEnContextDTO ctx, MedSrvDO medSrv, OrderListViewDTO orderListViewDTO)
			throws BizException {
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, medSrv.getId_srv(), orderListViewDTO.getId_mm(), orderListViewDTO.getId_route(),null,
				orderListViewDTO.getFg_long(),ctx.getFg_pres_outp(),orderListViewDTO.getDt_effe());
		if (!CiOrdUtils.isEmpty(wf)) {
			// 非物品没有物资仓库（医嘱模板缺物资流向配置）
			if (FBoolean.TRUE.equals(medSrv.getFg_mm())) {
				orderListViewDTO.setId_dep_wh(wf.getId_dept_wh());// 物资仓库ID
				orderListViewDTO.setName_dep_wh(wf.getName_dept_wh());// 物资仓库
				orderListViewDTO.setFilter_dep_wh(wf.getId_dept_whs());// 物资仓库过滤条件
			}
			//如果模板没有配置执行科室或者配置的科室不在执行流向范围内，则重新取值
			if(StringUtils.isNullOrEmpty(orderListViewDTO.getId_dep_mp()) || !wf.getId_mp_depts().contains(orderListViewDTO.getId_dep_mp())){
				orderListViewDTO.setId_dep_mp(wf.getFirstid_mp_dept());// 执行科室ID
				orderListViewDTO.setName_dep_mp(wf.getFirstname_mp_dept());// 执行科室
				orderListViewDTO.setFilter_dep_mp("1".equals(wf.getMp_source()) ? null : wf.getId_mp_depts());// 执行科室过滤条件
			}
		}
	}
	
	/**
	 * 获取拼装后的EmsSaveDTO
	 * @param view
	 * @param driverInfo
	 * @return
	 */
	protected EmsSaveDTO getEmsSaveDTO(FArrayList doc, EmsDriverInfo driverInfo) {
		EmsSaveDTO save = new EmsSaveDTO();
		save.setDriverInfo(driverInfo);
		save.setDocument(doc);
		return save;
	}
}
