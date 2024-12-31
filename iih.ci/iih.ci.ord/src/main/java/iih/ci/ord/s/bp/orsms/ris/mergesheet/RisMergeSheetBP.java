package iih.ci.ord.s.bp.orsms.ris.mergesheet;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.srv.oth.d.BdRelSrvParamDTO;
import iih.ci.ord.app.d.CiAppRisSheetOrDO;
import iih.ci.ord.app.d.CiapprissheetAggDO;
import iih.ci.ord.ciappdiriveorreldo.d.CiAppDiriveOrRelDO;
import iih.ci.ord.ciappdiriveorreldo.i.ICiappdiriveorreldoCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.save.op.GetRelBdSrv8InfluFactorsBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查合单，生成图文报告逻辑
 * 
 * @author zhangwq
 *
 */
public class RisMergeSheetBP {
	public List<CiOrderDO> exec(CiEnContextDTO ctx,CiapprissheetAggDO[] risSheetAggs,List<CiOrderDO> orderList ) throws BizException {
		if (risSheetAggs == null || risSheetAggs.length == 0 ||orderList == null) {
			return null;
		}
		List<CiOrderDO> rstList = new ArrayList<CiOrderDO>();
		Map<String, CiOrderDO> ciOrderMap = new HashMap<String,CiOrderDO>();
		for(CiOrderDO order:orderList){
			ciOrderMap.put(order.getId_or(), order);
		}
		String[] id_ors = ciOrderMap.keySet().toArray(new String[0]);
		Long startTIme = System.currentTimeMillis();
		// 套明细，ci_or_srv_set
		Map<String, List<OrdSrvSetDO>> srvsettemp = getOrdSrvSetTemp(id_ors);
		CiOrdUtils.getlogger()
		.info("CiLisOrSmsHandlerBP 检查生成图文报告, 查询套明细单耗时 .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		for (CiapprissheetAggDO risSheetAgg : risSheetAggs) {
			CiAppRisSheetOrDO[] rissheets = risSheetAgg.getCiAppRisSheetOrDO();
			startTIme = System.currentTimeMillis();
			List<UsageRelFeeSrvDO> relSrvList = getRelFeesSrvs(rissheets,ciOrderMap,srvsettemp);
			CiOrdUtils.getlogger()
			.info("CiLisOrSmsHandlerBP 检查生成图文报告, 查询关联服务耗时 .." + (System.currentTimeMillis() - startTIme) + "毫秒");
			if(relSrvList==null || relSrvList.size() == 0){
				continue;
			}
			//筛选，相同服务的取数量的最大值的服务
			UsageRelFeeSrvDO[] relFeeSrvArrays = pickMoreNumFeeSrv(relSrvList);
			CiOrderDO orderdo = ciOrderMap.get(rissheets[0].getId_or());
			startTIme = System.currentTimeMillis();
			//生成医嘱项目
			List<CiOrderDO> newOrders = imageTextReport(ctx,relFeeSrvArrays,orderdo);
			CiOrdUtils.getlogger()
			.info("CiLisOrSmsHandlerBP 检查生成图文报告, 查询关联服务耗时 .." + (System.currentTimeMillis() - startTIme) + "毫秒");
			if(newOrders != null){
				rstList.addAll(newOrders);
				SaveAppDiriveOrRel(newOrders,risSheetAgg.getParentDO().getId_ciapprissheet());
			}
			
		}
		return rstList;
	}
	private CiAppDiriveOrRelDO[] SaveAppDiriveOrRel(List<CiOrderDO> newOrders,String id_appsheet) throws BizException{
		List<CiAppDiriveOrRelDO> rels = new ArrayList<CiAppDiriveOrRelDO>();
		for (CiOrderDO ciOrderDO : newOrders) {
			//创建管理单据派生医嘱关联关系
			CiAppDiriveOrRelDO rel = new CiAppDiriveOrRelDO();
			rel.setStatus(DOStatus.NEW);
			rel.setId_app(id_appsheet);
			rel.setId_relor(ciOrderDO.getId_or());
			rels.add(rel);
		}
		//保存
		ICiappdiriveorreldoCudService service = ServiceFinder.find(ICiappdiriveorreldoCudService.class);
		return service.save(rels.toArray(new CiAppDiriveOrRelDO[0]));
	}
	/**
	 * 图文报告
	 * @param relFeeSrvArrays
	 * @param orderdo
	 * @throws BizException 
	 */
	private List<CiOrderDO> imageTextReport(CiEnContextDTO ctx,UsageRelFeeSrvDO[] relFeeSrvArrays, CiOrderDO orderdo) throws BizException {
		ImageTextReportBP bp = new ImageTextReportBP(ctx);
		return bp.exec(relFeeSrvArrays, orderdo);
	}
	/**
	 * 挑选出相同项目数量较大的
	 * @param relSrvList
	 * @return
	 */
	private UsageRelFeeSrvDO[] pickMoreNumFeeSrv(List<UsageRelFeeSrvDO> relSrvList) {
		Map<String,UsageRelFeeSrvDO> temap = new HashMap<String,UsageRelFeeSrvDO>();
		for (UsageRelFeeSrvDO usageRelFeeSrvDO : relSrvList) {
			String id_srv = usageRelFeeSrvDO.getId_srv();
			if(temap.containsKey(id_srv)){
				UsageRelFeeSrvDO prevSrv = temap.get(id_srv);
				if(usageRelFeeSrvDO.getQuan_medu() != null && usageRelFeeSrvDO.getQuan_medu().compareTo(prevSrv.getQuan_medu())>0){
					temap.put(id_srv,usageRelFeeSrvDO);
				}
			}else{
				temap.put(id_srv,usageRelFeeSrvDO);
			}
		}
		return temap.values().toArray(new UsageRelFeeSrvDO[0]);
	}
	/**
	 * 根据服务关联策略，查询检查项目带出的图文报告费用
	 * @param rissheets
	 * @param ciOrderMap
	 * @param srvsettemp
	 * @return
	 * @throws BizException
	 */
	private List<UsageRelFeeSrvDO> getRelFeesSrvs(CiAppRisSheetOrDO[] rissheets, Map<String, CiOrderDO> ciOrderMap,Map<String, List<OrdSrvSetDO>> srvsettemp) throws BizException {
		List<UsageRelFeeSrvDO> relSrvList = new ArrayList<UsageRelFeeSrvDO>();
		for (CiAppRisSheetOrDO ciAppRisSheetOrDO : rissheets) {
			String id_or = ciAppRisSheetOrDO.getId_or();
			if (ciOrderMap.containsKey(id_or)) {
				CiOrderDO orderdo = ciOrderMap.get(id_or);
				BdRelSrvParamDTO relparam = getBdRelSrvParamDTO(orderdo, srvsettemp);
				GetRelBdSrv8InfluFactorsBP bp = new GetRelBdSrv8InfluFactorsBP();
				try {
					UsageRelFeeSrvDO[] relReeSrvs = bp.getSheetAppRelFees(relparam);
					if (relReeSrvs != null && relReeSrvs.length > 0) {
						relSrvList.addAll(Arrays.asList(relReeSrvs));
					}
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| NoSuchMethodException | SecurityException | IllegalArgumentException
						| InvocationTargetException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		return relSrvList;
	}

	/**
	 * 组装查询服务关联策略的参数
	 * @param orderdo
	 * @return
	 * @throws BizException
	 */
	private BdRelSrvParamDTO getBdRelSrvParamDTO(CiOrderDO orderdo, Map<String, List<OrdSrvSetDO>> srvsettemp)
			throws BizException {
		BdRelSrvParamDTO param = new BdRelSrvParamDTO();
		// 参数
		param.setId_grp(orderdo.getId_grp());
		param.setId_org(orderdo.getId_org());
		param.setCode_entp(orderdo.getCode_entp());
		param.setId_bizs1(orderdo.getId_srv());
		if (FBoolean.TRUE.equals(orderdo.getFg_set()) && srvsettemp.containsKey(orderdo.getId_or())) {
			OrdSrvSetDO[] srvsets = srvsettemp.get(orderdo.getId_or()).toArray(new OrdSrvSetDO[0]);
			String rtn = "";
			for (OrdSrvSetDO ordSrvSetDO : srvsets) {
				rtn += CiOrdUtils.COMMA_STR + ordSrvSetDO.getId_srvset();
			}
			if (!CiOrdUtils.isEmpty(rtn)) {
				param.setId_bizs2(rtn.substring(1));
			}
		}

		param.setId_dep_ns(orderdo.getId_dep_nur());
		param.setId_dep_en(orderdo.getId_dep_ns());
		param.setId_dep_or(orderdo.getId_dep_or());
		param.setQuan_medu(orderdo.getQuan_medu());
		param.setId_unit_med(orderdo.getId_unit_med());
		return param;
	}

	/**
	 * 查询套明细
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private Map<String, List<OrdSrvSetDO>> getOrdSrvSetTemp(String[] id_ors) throws BizException {
		Map<String, List<OrdSrvSetDO>> map = new HashMap<String, List<OrdSrvSetDO>>();
		IOrdsrvsetRService setservice = ServiceFinder.find(IOrdsrvsetRService.class);
		OrdSrvSetDO[] srvsets = setservice.findByAttrValStrings(OrdSrvSetDO.ID_OR, id_ors);
		if (srvsets != null && srvsets.length > 0) {
			for (OrdSrvSetDO ordSrvSetDO : srvsets) {
				String id_or = ordSrvSetDO.getId_or();
				List<OrdSrvSetDO> list = null;
				if (map.containsKey(id_or)) {
					list = map.get(id_or);
				} else {
					list = new ArrayList<OrdSrvSetDO>();
					map.put(id_or, list);
				}
				list.add(ordSrvSetDO);
			}
		}
		return map;
	}
}
