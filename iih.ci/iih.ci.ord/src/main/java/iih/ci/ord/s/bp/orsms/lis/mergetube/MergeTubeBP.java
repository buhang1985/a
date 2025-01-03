package iih.ci.ord.s.bp.orsms.lis.mergetube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.samppri.d.BdSampPriItmDO;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.ciappdiriveorreldo.d.CiAppDiriveOrRelDO;
import iih.ci.ord.ciappdiriveorreldo.i.ICiappdiriveorreldoCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.dto.ems.EmsCreateParamDTO;
import iih.ci.ord.dto.mergetube.d.MergeTubeRstDTO;
import iih.ci.ord.dto.mergetube.d.MergeTubeRstEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.skintest.sign.SkinOrderSignBP;
import iih.mp.nr.dto.mergedsamppridto.d.LabSampSrvDTO;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.opmergetube.d.SampleOrRelDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 合管后生成容器费医嘱和采集费医嘱
 * 
 * @author zhangwq
 *
 */
public class MergeTubeBP {
	private CiEnContextDTO ctx;
	private ICiOrdMaintainService mainService;
	private IForeignService foreignService;
	/**
	 * 每个单据对应的容器费
	 */
	private Map<String, EmsCreateParamDTO[]> appListSampPriMap;
	/**
	 * 采集费用
	 */
	private Map<String, EmsCreateParamDTO> sampcolMap;
	/**
	 * 签署操作
	 */
	private SkinOrderSignBP signBP;
	/**
	 * 容器费和采集费服务集合
	 */
	private List<String> idsrvs;
	private CreateCiEmsDTOBP createCiEmsDTOBP;

	private MergeTubeBP() {
	}

	public MergeTubeBP(CiEnContextDTO ctx) {
		this.ctx = ctx;
		appListSampPriMap = new HashMap<String, EmsCreateParamDTO[]>();
		sampcolMap = new HashMap<String, EmsCreateParamDTO>();
		idsrvs = new ArrayList<String>();

		mainService = ServiceFinder.find(ICiOrdMaintainService.class);
		signBP = new SkinOrderSignBP();
		createCiEmsDTOBP = new CreateCiEmsDTOBP(ctx);

		foreignService = ServiceFinder.find(IForeignService.class);
	}

	public MergeTubeRstDTO exec(CiapplissheetAggDO[] lissheets) throws BizException {
		if(!FBoolean.TRUE.equals(isCreateSampcol())){
			MergeTubeRstDTO mergeTubeRstDTO = new MergeTubeRstDTO();
			mergeTubeRstDTO.setRstStatus(MergeTubeRstEnum.SUCCESS);
			return mergeTubeRstDTO;
		}
		if (lissheets == null || lissheets.length == 0) {
			return null;
		}
		SampleOrRelDTO[] params = getSampleOrRels(lissheets);
		LabSampSrvDTO[] sampsrvs = foreignService.setSamplePrice(params);
		if (sampsrvs != null && sampsrvs.length > 0) {
			//分拣出来容器费和采集费
			pickContpAndSampcol(sampsrvs, lissheets);
		}
		// 生成医嘱并保存
		return createOrdere();
	}

	/**
	 * 分拣出来容器费和采集费
	 * 
	 * @param sampPriItms
	 */
	protected void pickContpAndSampcol(LabSampSrvDTO[] sampsrvs, CiapplissheetAggDO[] lissheets) {
		if (sampsrvs == null || sampsrvs.length == 0) {
			return;
		}
		for (LabSampSrvDTO itm : sampsrvs) {
			String id_srv = itm.getId_srv();
			if (!idsrvs.contains(id_srv)) {
				idsrvs.add(id_srv);
			}
			Integer eu_pritp = itm.getEu_pritp();// 费用类别
			if (new Integer(1).equals(eu_pritp)) {// 采集费
				EmsCreateParamDTO param = new EmsCreateParamDTO();
				param.setId_srv(id_srv);
				param.setQuan_med(itm.getQuan());
				param.setId_unit_med(itm.getId_unit());
				sampcolMap.put(id_srv, param);
			}
		}
		if (lissheets == null || lissheets.length == 0) {
			return;
		}
		// 获取每个单据的容器费
		for (CiapplissheetAggDO sheet : lissheets) {
			String id_ciapplissheet = sheet.getParentDO().getId_ciapplissheet();
			String code_app = sheet.getParentDO().getCode_app();
			List<EmsCreateParamDTO> params = new ArrayList<EmsCreateParamDTO>();
			if (sampsrvs != null) {
				for (LabSampSrvDTO itm : sampsrvs) {
					String no_bar = itm.getNo_bar();
					if (StringUtils.isNotEmpty(no_bar) && StringUtils.isNotEmpty(code_app) && no_bar.equals(code_app)) {
						Integer eu_pritp = itm.getEu_pritp();// 费用类别
						String id_srv = itm.getId_srv();
						if (new Integer(0).equals(eu_pritp)) {// 容器费
							EmsCreateParamDTO param = new EmsCreateParamDTO();
							param.setId_srv(id_srv);
							param.setQuan_med(itm.getQuan());
							param.setId_unit_med(itm.getId_unit());
							params.add(param);
						}
					}
				}
			}
			if (params.size() > 0) {
				appListSampPriMap.put(id_ciapplissheet, params.toArray(new EmsCreateParamDTO[0]));
			}
		}
	}

	private SampleOrRelDTO[] getSampleOrRels(CiapplissheetAggDO[] lissheets) {
		if (lissheets == null || lissheets.length == 0) {
			return null;
		}
		List<SampleOrRelDTO> reldtos = new ArrayList<SampleOrRelDTO>();
		for (CiapplissheetAggDO ciapplissheetAggDO : lissheets) {
			SampleOrRelDTO reldto = new SampleOrRelDTO();
			reldtos.add(reldto);
			String code_app = ciapplissheetAggDO.getParentDO().getCode_app();
			reldto.setNo_bar(code_app);
			CiAppLisSheetOrDO[] sheetors = ciapplissheetAggDO.getCiAppLisSheetOrDO();
			List<String> listOrs = new ArrayList<String>();
			if (sheetors != null && sheetors.length > 0) {
				for (CiAppLisSheetOrDO ciAppLisSheetOrDO : sheetors) {
					listOrs.add(ciAppLisSheetOrDO.getId_or());
				}
			}
			reldto.setListOrs(listOrs);
		}
		return reldtos.toArray(new SampleOrRelDTO[0]);
	}

	public MergeTubeRstDTO exec(CiapplissheetAggDO[] lissheets, CiOrderDO[] ciors) throws BizException {
		if(!FBoolean.TRUE.equals(isCreateSampcol())){
			MergeTubeRstDTO mergeTubeRstDTO = new MergeTubeRstDTO();
			mergeTubeRstDTO.setRstStatus(MergeTubeRstEnum.SUCCESS);
			return mergeTubeRstDTO;
		}
		// 将检验医嘱给筛选出来
		CiOrderDO[] lisords = getLisOrders(ciors);
		if (lisords == null || lisords.length == 0) {
			return null;
		}
		Map<String, String> ordSrvMap = getOrdSrvMap(lisords);
		if (ordSrvMap.isEmpty()) {
			return null;
		}
		// 新生成的管费和采集费的医嘱id_or集合
		List<CiOrderDO> newOrders = new ArrayList<CiOrderDO>();
		// 获取服务项目关联的所有的容器和采集费
		BdSampPriItmDO[] sampPriItms = getSampPriItms(ordSrvMap.values().toArray(new String[0]));
		// 分拣出来每个单据的容器和采集
		pickContpAndSampcol(sampPriItms, lissheets, ordSrvMap);
		// 生成医嘱并保存
		return createOrdere();
	}

	/**
	 * 创建医嘱
	 * 
	 * @return
	 * @throws BizException
	 */
	private MergeTubeRstDTO createOrdere() throws BizException {
		MergeTubeRstDTO mergeTubeRstDTO = new MergeTubeRstDTO();
		// 新生成的管费和采集费的医嘱id_or集合
		List<CiOrderDO> newOrders = new ArrayList<CiOrderDO>();
		// 如果患者是儿童，将容器费和采集费映射成儿童的费用
		//mappingToChildSrv();
		if (!sampcolMap.isEmpty()) {
			// 容器费用是可以直接生成医嘱的，但采集费用需要判断是否已经存在了,如果已经存在需要询问医生
			String[] sampSrvs = sampcolMap.keySet().toArray(new String[0]);
			
			/**
			 * 如果是预住院患者，则根据参数判断是否需要医生判断后再生成采集费
			 * 1) 当【CIOR0805预住院是否有医生】=Y时，关联生成费用处理逻辑，保持当前处理方法，需要进行交互提示。
			 * 2) 当【CIOR0805预住院是否有医生】=N时，关联生成费用，不需要进行判断提示，直接生成。
			 */
			EmsCreateParamDTO[] beHasSampcolOrds = null;
			boolean needJudge = true;
			if (IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(ctx.getCode_entp()) ) {
			    FBoolean paraBoolean = ParamsetQryUtil.getParaBoolean(ctx.getId_org(), "CIOR0805");
			    if (!paraBoolean.booleanValue()) {
			        needJudge = false;
			    }
			}
			
			if (needJudge) {
			    beHasSampcolOrds = beHasOrders(sampSrvs, ctx.getId_en());	    			    
			}
			
			if (beHasSampcolOrds != null && beHasSampcolOrds.length > 0) {
				// 判断是全包含和部分包含
				if (sampSrvs.length == beHasSampcolOrds.length) {
					// 全包含
					mergeTubeRstDTO.setAllBeHave(FBoolean.TRUE);
				} else {
					// 部分包含
					mergeTubeRstDTO.setAllBeHave(FBoolean.FALSE);
				}
				mergeTubeRstDTO.setBeHasSampcolOrds(HasSampcolOrds(beHasSampcolOrds));
				mergeTubeRstDTO.setNotHasSampcolOrds(NotHasSampcolOrds(beHasSampcolOrds));
				if (!appListSampPriMap.isEmpty()) {
					// 将容器费也记录下来,返回前台
					FMap contpsMap = new FMap();
					for (String key : appListSampPriMap.keySet()) {
						FArrayList list = new FArrayList();
						list.addAll(Arrays.asList(appListSampPriMap.get(key)));
						contpsMap.put(key, list);
					}
					mergeTubeRstDTO.setContpOrds(contpsMap);
				}
				mergeTubeRstDTO.setRstStatus(MergeTubeRstEnum.FAIL);// 异常
				return mergeTubeRstDTO;
			}
			// 采集不存在，需要全部生成，生成采集费用医嘱
			List<CiEmsDTO> ciEmsDTOs = createCiEmsDTOBP.exec(sampcolMap.values().toArray(new EmsCreateParamDTO[0]));
			List<CiOrderDO> orders = saveOrder(ciEmsDTOs);
			if (orders != null && orders.size() > 0) {
				newOrders.addAll(orders);
			}
		}
		if (!appListSampPriMap.isEmpty()) {
			Iterator<String> iterator = appListSampPriMap.keySet().iterator();
			// 生成容器费医嘱
			while (iterator.hasNext()) {
				// 每一次遍历，就是一个申请单
				String key = iterator.next();// 单据主键
				EmsCreateParamDTO[] priItms = appListSampPriMap.get(key);
				List<CiEmsDTO> ciEmsDTOs = createCiEmsDTOBP.exec(priItms);
				List<CiOrderDO> orders = saveOrder(ciEmsDTOs, key);
				if (orders != null && orders.size() > 0) {
					newOrders.addAll(orders);
				}
			}
		}
		mergeTubeRstDTO.setRstStatus(MergeTubeRstEnum.SUCCESS);
		mergeTubeRstDTO.setNewCreateOrders(newOrders);
		return mergeTubeRstDTO;
	}

	/**
	 * 如果是儿童就诊将采集费和容器费映射成儿童服务
	 * 
	 * @throws DAException
	 */
	private void mappingToChildSrv() throws DAException {
		if ((sampcolMap == null || sampcolMap.isEmpty())
				&& (appListSampPriMap == null || appListSampPriMap.isEmpty())) {
			return;
		}
		Integer childMonth = getMPNR0175();
		if (childMonth == null) {
			return;
		}
		String sql = "select dt_birth from pi_pat where id_pat =?";
		DAFacade fa = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(ctx.getId_pat());
		String str_birth = (String) fa.execQuery(sql, param, new ColumnHandler());
		if (str_birth != null) {
			int months = this.getMonths(new FDate(str_birth));
			if (months <= childMonth) {

				String mappingSql = "select id_srv_base,cnst.id_srv,srv.id_unit_med,srv.quan_med,srv.name as name_srv from bd_samp_pri_chldcnst cnst inner join bd_srv srv on srv.id_srv = cnst.id_srv where ";
				mappingSql += (SqlUtils.getInSqlByIds("cnst.id_srv_base", this.idsrvs));
				List<EmsCreateParamDTO> cnsts = (List<EmsCreateParamDTO>) fa.execQuery(mappingSql,
						new BeanListHandler(EmsCreateParamDTO.class));
				if (cnsts != null && cnsts.size() > 0) {
					Map<String, EmsCreateParamDTO> tempCnsts = new HashMap<String, EmsCreateParamDTO>();
					for (EmsCreateParamDTO sampPriChldCnstDO : cnsts) {
						tempCnsts.put(sampPriChldCnstDO.getId_srv_base(), sampPriChldCnstDO);
					}
					// 采集费映射
					if (sampcolMap != null && !sampcolMap.isEmpty()) {
						Collection<EmsCreateParamDTO> allItms = this.sampcolMap.values();
						for (EmsCreateParamDTO itm : allItms) {
							if (tempCnsts.containsKey(itm.getId_srv())) {
								EmsCreateParamDTO mappingItm = tempCnsts.get(itm.getId_srv());
								itm.setId_srv(mappingItm.getId_srv());
								itm.setId_unit_med(mappingItm.getId_unit_med());
								//映射的儿童费的数量等于标本费用对照维护的数量,因此不用从新赋值 20191211，zhangwq，已和妍妍确认
								itm.setQuan_med(mappingItm.getQuan_med());
								itm.setName_srv(mappingItm.getName_srv());
							}
						}
					}
					if (!appListSampPriMap.isEmpty()) {
						Iterator<String> iterator = appListSampPriMap.keySet().iterator();
						// 容器费映射
						while (iterator.hasNext()) {
							String key = iterator.next();// 单据主键
							EmsCreateParamDTO[] priItms = appListSampPriMap.get(key);
							for (EmsCreateParamDTO itm : priItms) {
								if (tempCnsts.containsKey(itm.getId_srv())) {
									EmsCreateParamDTO mappingItm = tempCnsts.get(itm.getId_srv());
									itm.setId_srv(mappingItm.getId_srv());
									itm.setId_unit_med(mappingItm.getId_unit_med());
									//映射的儿童费的数量等于标本费用对照维护的数量,因此不用从新赋值 20191211，zhangwq，已和妍妍确认
									itm.setQuan_med(mappingItm.getQuan_med());
									itm.setName_srv(mappingItm.getName_srv());
								}
							}
						}
					}
				}
			}
		}
	}

	private Integer getMPNR0175() {
		try {
			String param = ParamsetQryUtil.getParaString(this.ctx.getId_org(), "MPNR0175");
			return Integer.parseInt(param);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 已存在的采集费
	 * 
	 * @param beHasSampcolOrds
	 * @return
	 */
	protected FArrayList HasSampcolOrds(EmsCreateParamDTO[] beHasSampcolOrds) {
		if (this.sampcolMap == null || this.sampcolMap.isEmpty()) {
			return null;
		}
		FArrayList list = new FArrayList();
		Collection<EmsCreateParamDTO> allItms = this.sampcolMap.values();
		for (EmsCreateParamDTO itm : allItms) {
			for (EmsCreateParamDTO hasItm : beHasSampcolOrds) {
				if (StringUtils.isNotEmpty(itm.getId_srv()) && itm.getId_srv().equals(hasItm.getId_srv())) {
					itm.setName_srv(hasItm.getName_srv());
					list.add(itm);
				}
			}
		}
		return list;
	}

	/**
	 * 分拣出来容器费和采集费
	 * 
	 * @param sampPriItms
	 */
	protected void pickContpAndSampcol(BdSampPriItmDO[] sampPriItms, CiapplissheetAggDO[] lissheets,
			Map<String, String> ordSrvMap) {
		if (sampPriItms == null || sampPriItms.length == 0) {
			return;
		}
		Map<String, List<BdSampPriItmDO>> tempMap = new HashMap<String, List<BdSampPriItmDO>>();
		for (BdSampPriItmDO itm : sampPriItms) {
			String id_srv = itm.getId_srv();
			String id_pri_srv = itm.getId_samp_pri_itm();
			List<BdSampPriItmDO> listSrvPris = new ArrayList<BdSampPriItmDO>();
			if (tempMap.containsKey(id_pri_srv)) {
				listSrvPris = tempMap.get(id_pri_srv);
			} else {
				tempMap.put(id_pri_srv, listSrvPris);
			}
			listSrvPris.add(itm);
			Integer eu_pritp = itm.getEu_pritp();// 费用类别
			if (new Integer(1).equals(eu_pritp)) {// 采集费
				if (sampcolMap.containsKey(id_srv)) {
					EmsCreateParamDTO preItm = sampcolMap.get(id_srv);
					FDouble quan_medu = itm.getQuan_medu();
					if (quan_medu != null && quan_medu.compareTo(preItm.getQuan_med()) > 0) {
						preItm.setQuan_med(quan_medu);
					}
				} else {
					EmsCreateParamDTO param = new EmsCreateParamDTO();
					param.setId_srv(id_srv);
					param.setQuan_med(itm.getQuan_medu());
					param.setName_srv(itm.getSrvname());
					param.setId_unit_med(itm.getId_unit());
					sampcolMap.put(id_srv, param);
				}
			}
		}
		if (lissheets == null || lissheets.length == 0) {
			return;
		}
		// 获取每个单据的容器费
		for (CiapplissheetAggDO sheet : lissheets) {
			CiAppLisSheetOrDO[] listSheetOrs = sheet.getCiAppLisSheetOrDO();
			if (listSheetOrs == null || listSheetOrs.length == 0) {
				continue;
			}
			String id_ciapplissheet = sheet.getParentDO().getId_ciapplissheet();
			Map<String, EmsCreateParamDTO> map = new HashMap<String, EmsCreateParamDTO>();
			for (CiAppLisSheetOrDO lisSheetOr : listSheetOrs) {
				String id_or = lisSheetOr.getId_or();
				String id_srv = ordSrvMap.get(id_or);
				List<BdSampPriItmDO> listSrvPris = tempMap.get(id_srv);
				if (listSrvPris != null) {
					for (BdSampPriItmDO itm : listSrvPris) {
						Integer eu_pritp = itm.getEu_pritp();// 费用类别
						String id_pri_srv = itm.getId_srv();
						if (new Integer(0).equals(eu_pritp)) {// 容器费
							if (map.containsKey(id_pri_srv)) {
								EmsCreateParamDTO preItm = map.get(id_pri_srv);
								FDouble quan_medu = itm.getQuan_medu();
								if (quan_medu != null && quan_medu.compareTo(preItm.getQuan_med()) > 0) {
									preItm.setQuan_med(quan_medu);
								}
							} else {
								EmsCreateParamDTO param = new EmsCreateParamDTO();
								param.setId_srv(id_pri_srv);
								param.setQuan_med(itm.getQuan_medu());
								param.setName_srv(itm.getSrvname());
								param.setId_unit_med(itm.getId_unit());
								map.put(id_pri_srv, param);
							}
						}
					}
				}
			}
			if (!map.isEmpty()) {
				appListSampPriMap.put(id_ciapplissheet, map.values().toArray(new EmsCreateParamDTO[0]));
			}
		}
	}

	/**
	 * 获得医嘱和服务的关系
	 * 
	 * @param lisords
	 * @return
	 */
	protected Map<String, String> getOrdSrvMap(CiOrderDO[] lisords) {
		Map<String, String> ordSrvMap = new HashMap<String, String>();
		for (CiOrderDO order : lisords) {
			ordSrvMap.put(order.getId_or(), order.getId_srv());
		}
		return ordSrvMap;
	}

	/**
	 * 获得所有的服务项目
	 * 
	 * @param lisords
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<String> getListSrvs(CiOrderDO[] lisords) {
		List<String> idsrvs = new ArrayList<String>();
		for (CiOrderDO order : lisords) {
			idsrvs.add(order.getId_srv());
		}
		return idsrvs;
	}

	/**
	 * 将检验医嘱给筛选出来
	 * 
	 * @param ciors
	 * @return
	 */
	protected CiOrderDO[] getLisOrders(CiOrderDO[] ciors) {
		List<CiOrderDO> list = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : ciors) {
			// 取检验医嘱
			if (StringUtils.isNotEmpty(order.getSd_srvtp())
					&& order.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
				list.add(order);
			}
		}
		return list.toArray(new CiOrderDO[0]);
	}

	/**
	 * 缓存到map中，用于后续取值
	 * 
	 * @param ciors
	 * @return
	 */
	@SuppressWarnings("unused")
	private Map<String, CiOrderDO> lisOrderTeamMap(CiOrderDO[] ciors) {
		if (ciors == null || ciors.length == 0) {
			return null;
		}
		Map<String, CiOrderDO> map = new HashMap<String, CiOrderDO>();
		for (CiOrderDO order : ciors) {
			map.put(order.getId_or(), order);
		}
		return map;
	}

	/**
	 * 查询服务所有关联的容器和采集费用项目
	 * 
	 * @param lissrvs
	 * @return
	 * @throws BizException
	 */
	protected BdSampPriItmDO[] getSampPriItms(String[] lissrvs) throws BizException {
		if (lissrvs == null || lissrvs.length == 0) {
			return null;
		}
		String sql = "select sp.id_srv as Id_samp_pri_itm,itm.id_srv,itm.quan_medu ,itm.id_unit,itm.Eu_pritp,srv.name as Srvname from bd_samp_pri sp "
				+ "inner join bd_samp_pri_itm itm on sp.id_samp_pri = itm.id_samp_pri inner join bd_srv srv on srv.id_srv = itm.id_srv where ";
		sql += (SqlUtils.getInSqlByIds("sp.id_srv", lissrvs));
		DAFacade fa = new DAFacade();
		List<BdSampPriItmDO> priitms = (List<BdSampPriItmDO>) fa.execQuery(sql,
				new BeanListHandler(BdSampPriItmDO.class));
		if (priitms == null || priitms.size() == 0) {
			return null;
		}
		// 将容器费和采集费服务id记录下来，用于后面如果患者是儿童时，进行服务映射
		for (BdSampPriItmDO bdSampPriItmDO : priitms) {
			if (!idsrvs.contains(bdSampPriItmDO.getId_srv())) {
				idsrvs.add(bdSampPriItmDO.getId_srv());
			}
		}
		return priitms.toArray(new BdSampPriItmDO[0]);
	}

	/**
	 * 已经存在的采集费用
	 * 
	 * @param idsrvs
	 * @return
	 * @throws DAException
	 */
	protected EmsCreateParamDTO[] beHasOrders(String[] idsrvs, String id_en) throws DAException {
		if (idsrvs == null || idsrvs.length == 0) {
			return null;
		}
		String sql = beHasOrdersSql(idsrvs);
		SqlParam param = new SqlParam();
		param.addParam(id_en);
		List<EmsCreateParamDTO> orders = (List<EmsCreateParamDTO>) new DAFacade().execQuery(sql, param,
				new BeanListHandler(EmsCreateParamDTO.class));
		if (orders != null && orders.size() > 0) {
			return orders.toArray(new EmsCreateParamDTO[0]);
		}
		return null;
	}

	private String beHasOrdersSql(String[] idsrvs) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select distinct c.id_srv,c.name_or as name_srv ");
		sb.append(" from ci_order c ");
		sb.append(" where c.fg_sign='Y' and c.fg_canc='N' and c.sd_su_bl <> '2' and c.id_srv in ('"
				+ CiOrdUtils.ConcatInSqlMark(idsrvs) + "') and c.id_en=? ");
		return sb.toString();
	}

	/**
	 * 创建并签署医嘱
	 * 
	 * @param ciEmsDTO
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	protected List<CiOrderDO> saveOrder(List<CiEmsDTO> ciEmsDTOs) throws BizException {
		if (ciEmsDTOs == null || ciEmsDTOs.size() == 0) {
			return null;
		}
		// 新生成的管费和采集费的医嘱id_or集合
		List<CiOrderDO> orders = new ArrayList<CiOrderDO>();
		for (CiEmsDTO ciEmsDTO : ciEmsDTOs) {
			ciEmsDTO.setEu_orsrcmdtp(OrSourceFromEnum.IIHORRELSAMPPRI);
			ciEmsDTO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);
			ciEmsDTO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);
			CiOrderDO order = saveOrder(ciEmsDTO);
			orders.add(order);
		}
		return orders;
	}

	/**
	 * 容器费用医嘱的保存,记录关联关系
	 * 
	 * @param ciEmsDTOs
	 * @param id_appsheet
	 * @throws BizException
	 */
	protected List<CiOrderDO> saveOrder(List<CiEmsDTO> ciEmsDTOs, String id_appsheet) throws BizException {
		if (ciEmsDTOs == null || StringUtils.isEmpty(id_appsheet)) {
			return null;
		}
		// 新生成的管费和采集费的医嘱id_or集合
		List<CiOrderDO> orders = new ArrayList<CiOrderDO>();
		List<CiAppDiriveOrRelDO> rels = new ArrayList<CiAppDiriveOrRelDO>();
		for (CiEmsDTO ciEmsDTO : ciEmsDTOs) {
			ciEmsDTO.setEu_orsrcmdtp(OrSourceFromEnum.IIHORRELCONTP);
			CiOrderDO order = saveOrder(ciEmsDTO);
			// 创建管理单据派生医嘱关联关系
			CiAppDiriveOrRelDO rel = new CiAppDiriveOrRelDO();
			rel.setStatus(DOStatus.NEW);
			rel.setId_app(id_appsheet);
			rel.setId_relor(order.getId_or());
			rels.add(rel);
			orders.add(order);
		}
		// 保存
		ICiappdiriveorreldoCudService service = ServiceFinder.find(ICiappdiriveorreldoCudService.class);
		service.save(rels.toArray(new CiAppDiriveOrRelDO[0]));
		return orders;
	}

	/**
	 * 创建并签署医嘱
	 * 
	 * @param ciEmsDTO
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	protected CiOrderDO saveOrder(CiEmsDTO ciEmsDTO) throws BizException {
		CiOrderDO ciOrderDO = mainService.SaveCiEmsDTO(ciEmsDTO, ctx);
		// 新生成的管费和采集费的医嘱保存成功后不签署，改为和医生开立的医嘱一块签署 20190603
		if (ciOrderDO != null) {
			// OrderRstDTO rst = signBP.exec(ctx, ciOrderDO.getId_or());
			return ciOrderDO;
		}
		return null;
	}

	/**
	 * 未存在的采集费
	 * 
	 * @param beHasSampcolOrds
	 * @return
	 */
	protected FArrayList NotHasSampcolOrds(EmsCreateParamDTO[] beHasSampcolOrds) {
		if (this.sampcolMap == null || this.sampcolMap.isEmpty()) {
			return null;
		}
		FArrayList list = new FArrayList();
		Collection<EmsCreateParamDTO> allItms = this.sampcolMap.values();
		for (EmsCreateParamDTO itm : allItms) {
			for (EmsCreateParamDTO hasItm : beHasSampcolOrds) {
				if (StringUtils.isNotEmpty(itm.getId_srv()) && !itm.getId_srv().equals(hasItm.getId_srv())) {
					list.add(itm);
				}
			}
		}
		return list;
	}

	public MergeTubeRstDTO exec(MergeTubeRstDTO mergeTubeRstDTO) throws BizException {
		FBoolean allBeHave = mergeTubeRstDTO.getAllBeHave();
		// 医生的选择
		String doctorOpt = mergeTubeRstDTO.getDoctorOpt();
		FArrayList beHasSampcolOrds = mergeTubeRstDTO.getBeHasSampcolOrds();
		FArrayList notHasSampcolOrds = mergeTubeRstDTO.getNotHasSampcolOrds();
		// 新生成的管费和采集费的医嘱id_or集合
		List<CiOrderDO> newOrders = new ArrayList<CiOrderDO>();
		// 采集费
		if ("0".equals(doctorOpt)) {// 要全部重新生成
			if (notHasSampcolOrds != null) {
				beHasSampcolOrds.addAll(notHasSampcolOrds);
			}
			List<CiEmsDTO> ciEmsDTOs = createCiEmsDTOBP
					.exec((EmsCreateParamDTO[]) beHasSampcolOrds.toArray(new EmsCreateParamDTO[0]));
			List<CiOrderDO> orders = saveOrder(ciEmsDTOs);
			if (orders != null && orders.size() > 0) {
				newOrders.addAll(orders);
			}
		} else if ("1".equals(doctorOpt)) {// 否只生成不存在的
			if (FBoolean.FALSE.equals(allBeHave)) {
				if (notHasSampcolOrds != null) {
					List<CiEmsDTO> ciEmsDTOs = createCiEmsDTOBP
							.exec((EmsCreateParamDTO[]) notHasSampcolOrds.toArray(new EmsCreateParamDTO[0]));
					List<CiOrderDO> orders = saveOrder(ciEmsDTOs);
					if (orders != null && orders.size() > 0) {
						newOrders.addAll(orders);
					}
				}
			}
		}
		// 容器费
		FMap contpOrdsMap = mergeTubeRstDTO.getContpOrds();
		if (contpOrdsMap != null && !contpOrdsMap.isEmpty()) {
			Iterator<String> iterator = contpOrdsMap.keySet().iterator();
			// 生成容器费医嘱
			while (iterator.hasNext()) {
				// 每一次遍历，就是一个申请单
				String key = iterator.next();// 单据主键
				FArrayList priItms = (FArrayList) contpOrdsMap.get(key);
				if (priItms != null) {
					List<CiEmsDTO> ciEmsDTOs = createCiEmsDTOBP
							.exec((EmsCreateParamDTO[]) priItms.toArray(new EmsCreateParamDTO[0]));
					List<CiOrderDO> orders = saveOrder(ciEmsDTOs, key);
					if (orders != null && orders.size() > 0) {
						newOrders.addAll(orders);
					}
				}
			}
		}
		mergeTubeRstDTO.setRstStatus(MergeTubeRstEnum.SUCCESS);
		mergeTubeRstDTO.setNewCreateOrders(newOrders);
		return mergeTubeRstDTO;
	}

	public CiEnContextDTO getCtx() {
		return ctx;
	}

	public void setCtx(CiEnContextDTO ctx) {
		this.ctx = ctx;
	}

	public ICiOrdMaintainService getMainService() {
		return mainService;
	}

	public void setMainService(ICiOrdMaintainService mainService) {
		this.mainService = mainService;
	}

	public Map<String, EmsCreateParamDTO[]> getAppListSampPriMap() {
		return appListSampPriMap;
	}

	public void setAppListSampPriMap(Map<String, EmsCreateParamDTO[]> appListSampPriMap) {
		this.appListSampPriMap = appListSampPriMap;
	}

	public Map<String, EmsCreateParamDTO> getSampcolMap() {
		return sampcolMap;
	}

	public void setSampcolMap(Map<String, EmsCreateParamDTO> sampcolMap) {
		this.sampcolMap = sampcolMap;
	}

	public SkinOrderSignBP getSignBP() {
		return signBP;
	}

	public void setSignBP(SkinOrderSignBP signBP) {
		this.signBP = signBP;
	}

	public CreateCiEmsDTOBP getCreateCiEmsDTOBP() {
		return createCiEmsDTOBP;
	}

	public void setCreateCiEmsDTOBP(CreateCiEmsDTOBP createCiEmsDTOBP) {
		this.createCiEmsDTOBP = createCiEmsDTOBP;
	}

	/**
	 * 处理第三方返回的数据
	 * 
	 * @param lissheets
	 * @param ciors
	 * @param orsmsiolists
	 * @return
	 * @throws BizException
	 */
	public MergeTubeRstDTO customMergeTubeOrds(CiapplissheetAggDO[] lissheets, CiOrderDO[] ciors,
			List<CiLisOrSmsIoDTO> orsmsiolists) throws BizException {
		if(!FBoolean.TRUE.equals(isCreateSampcol())){
			MergeTubeRstDTO mergeTubeRstDTO = new MergeTubeRstDTO();
			mergeTubeRstDTO.setRstStatus(MergeTubeRstEnum.SUCCESS);
			return mergeTubeRstDTO;
		}
		// 新生成的管费和采集费的医嘱id_or集合
		List<CiOrderDO> newOrders = new ArrayList<CiOrderDO>();
		MergeTubeRstDTO mergeTubeRstDTO = new MergeTubeRstDTO();
		for (CiLisOrSmsIoDTO smsiodtos : orsmsiolists) {
			FArrayList tubsList = smsiodtos.getTubes();
			if (tubsList != null && tubsList.size() > 0) {
				try {
					List<EmsCreateParamDTO> params = new ArrayList<EmsCreateParamDTO>();
					for (Object obj : tubsList) {
						if (obj instanceof BdSampPriItmDO) {
							EmsCreateParamDTO param = new EmsCreateParamDTO();
							BdSampPriItmDO priItm = (BdSampPriItmDO) obj;
							param.setId_srv(priItm.getId_srv());
							param.setQuan_med(priItm.getQuan_medu());
							param.setId_unit_med(priItm.getId_unit());
							params.add(param);
						} else if (obj instanceof EmsCreateParamDTO) {
							params.add((EmsCreateParamDTO) obj);
						}
					}
					List<CiEmsDTO> ciEmsDTOs = createCiEmsDTOBP
							.exec((EmsCreateParamDTO[]) params.toArray(new EmsCreateParamDTO[] {}));
					List<CiOrderDO> orders = saveOrder(ciEmsDTOs, smsiodtos.getId_ciapplissheet());
					if (orders != null && orders.size() > 0) {
						newOrders.addAll(orders);
					}
				} catch (ArrayStoreException e) {
					throw new BizException("第三方返回对象错误，应该返回iih.ci.ord.dto.ems.EmsCreateParamDTO");
				}
			}
		}
		mergeTubeRstDTO.setRstStatus(MergeTubeRstEnum.SUCCESS);
		mergeTubeRstDTO.setNewCreateOrders(newOrders);
		return mergeTubeRstDTO;
	}

	/**
	 * 是否生成采集费和容器費
	 * 
	 * @return
	 */
	protected FBoolean isCreateSampcol() {
		try {
			return ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),
					ICiOrdNSysParamConst.SYS_PARAM_OP_LIS_CREATEBLORDER);
		} catch (BizException e) {
			return FBoolean.FALSE;
		}
	}

	/**
	 * 获得当前年龄的月数
	 * 
	 * @param birth
	 * @return
	 */
	private int getMonths(FDate birth) {
		FDate curDate = CiOrdAppUtils.getServerDateTime().getDate().asBegin();
		int months = curDate.getLocalMonth() - birth.getLocalMonth()
				+ 12 * (curDate.getLocalYear() - birth.getLocalYear());
		FDate changeDate = getAfterMonths(birth, months);
		int totalMonth = changeDate.after(curDate) ? months - 1 : months;
		return totalMonth;
	}

	private static FDate getAfterMonths(FDate date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date.toDate());
		cal.add(2, months);
		return new FDate(cal.getTime());
	}
}
