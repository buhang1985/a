package iih.bd.mm.task.bp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.core.SqlUtils;

import iih.bd.bc.udi.pub.IMmDictCodeConst;
import iih.bd.mm.autoreplenishconfigure.d.AutoReplenishConfigureDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.mm.supplierprotocol.i.ds.ISupplierProtocolService;
import iih.bd.mm.task.bp.qry.GetInQueryPriActSql;
import iih.bd.mm.task.bp.qry.GetPkguspListSql;
import iih.bd.mm.task.bp.qry.GetPlItemDosSql;
import iih.bd.mm.task.bp.qry.GetReplenishDoListSql;
import iih.bd.mm.task.bp.qry.GetTrConfMapSql;
import iih.bd.mm.task.bp.qry.GetTrItemDosSql;
import iih.mm.common.MMParams;
import iih.mm.pl.poplanstrategy.d.PoPlanStrategyDO;
import iih.mm.pl.poplanstrategy.i.IPoplanstrategyRService;
import iih.mm.pl.stockplan.d.StockPlanDO;
import iih.mm.pl.stockplan.d.StockPlanItmDO;
import iih.mm.pl.stockplan.d.StockplanAggDO;
import iih.mm.pl.stockplan.d.desc.StockPlanDODesc;
import iih.mm.pl.stockplan.i.IStockplanCudService;
import iih.mm.pl.traprequest.d.TrapReqItemDO;
import iih.mm.pl.traprequest.d.TrapReqOrderDO;
import iih.mm.pl.traprequest.d.TraprequestAggDO;
import iih.mm.pl.traprequest.d.desc.TrapReqOrderDODesc;
import iih.mm.pl.traprequest.i.ITraprequestCudService;
import iih.mm.qy.stockininfo.d.StockInQueryView;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class AutoreplenishBp {

	public void exec(BgWorkingContext arg0) throws BizException {
		this.valid(arg0);
		//采购list
		List<AutoReplenishConfigureDO> plList = new ArrayList<AutoReplenishConfigureDO>();
		//调拨list
		List<AutoReplenishConfigureDO> trList = new ArrayList<AutoReplenishConfigureDO>();
		//根据补货方式获取补货配置list
		this.getReplenishDoList(plList, trList);
		//生成采购计划
		this.creatPl(plList);
		//生成调拨申请单
		this.creatTrap(trList);
	}

	private void valid(BgWorkingContext arg0) throws BizException {
		if (arg0.getKeyMap() == null || !arg0.getKeyMap().containsKey("USERID")) {
			throw new BizException("参数USERID不允许为空。");
		}
		if (arg0.getKeyMap() == null || !arg0.getKeyMap().containsKey("ORGID")) {
			throw new BizException("参数ORGID不允许为空。");
		}
		Context.get().setOrgId(arg0.getKeyMap().get("ORGID").toString());
		Context.get().setUserId(arg0.getKeyMap().get("USERID").toString());
		Context.get().setGroupId(arg0.getKeyMap().get("GRPID").toString());
	}
	
	private void getReplenishDoList(List<AutoReplenishConfigureDO> plList, List<AutoReplenishConfigureDO> trList) throws BizException {
		int dt_rep = 0;
		//获取当天是星期几，只操作配置为当天补货的药品
		Calendar calendar=Calendar.getInstance();
		if(1 == calendar.get(Calendar.DAY_OF_WEEK)) {
			dt_rep = 6;
		}else {
			dt_rep = calendar.get(Calendar.DAY_OF_WEEK) - 2;
		}
		calendar.get(Calendar.DAY_OF_WEEK);
		GetReplenishDoListSql sql = new GetReplenishDoListSql(dt_rep);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<AutoReplenishConfigureDO> list = (ArrayList<AutoReplenishConfigureDO>) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(AutoReplenishConfigureDO.class));
		if(list != null && list.size() > 0) {
			for(AutoReplenishConfigureDO rep : list) {
				if("01".equals(rep.getReptp_code())) {
					plList.add(rep);
				}else {
					trList.add(rep);
				}
			}
		}
	}
	
	private void creatPl(List<AutoReplenishConfigureDO> plList) throws BizException {
		if(plList != null && plList.size() > 0) {
			//根据仓库分类
			Map<String, List<AutoReplenishConfigureDO>> map = this.getPlMapByWh(plList);
			//生成采购计划入库单
			StockplanAggDO[] aggDos = this.getPlAggDos(map);
			IStockplanCudService plService = ServiceFinder.find(IStockplanCudService.class);
			plService.insert(aggDos);
		}
	}

	private Map<String, List<AutoReplenishConfigureDO>> getPlMapByWh(List<AutoReplenishConfigureDO> plList) {
		Map<String, List<AutoReplenishConfigureDO>> map = new HashMap<String, List<AutoReplenishConfigureDO>>();
		for(AutoReplenishConfigureDO rep : plList) {
			if(map.containsKey(rep.getId_wh())) {
				List<AutoReplenishConfigureDO> list = map.get(rep.getId_wh());
				list.add(rep);
			}
			else {
				List<AutoReplenishConfigureDO> list = new ArrayList<AutoReplenishConfigureDO>();
				list.add(rep);
				map.put(rep.getId_wh(), list);
			}
		}
		return map;
	}
	
	private StockplanAggDO[] getPlAggDos(Map<String, List<AutoReplenishConfigureDO>> map) throws BizException {
		List<StockplanAggDO> aggList = new ArrayList<StockplanAggDO>();
		String orgId = Context.get().getOrgId();
		String grpId = Context.get().getGroupId();
		String userId = Context.get().getUserId();
		IBillcodeManage billCodeSrv = ServiceFinder.find(IBillcodeManage.class);
		Integer choosePurchasePrice = MMParams.MMDG0001();
		IMeterialService meterialService = ServiceFinder.find(IMeterialService.class);
		ISupplierProtocolService supPriceSrv = ServiceFinder.find(ISupplierProtocolService.class);
		
		for(String whId : map.keySet()) {
			StockplanAggDO aggDo = new StockplanAggDO();
			StockPlanDO parentDo = new StockPlanDO();
			parentDo.setId_org(orgId);
			parentDo.setId_grp(grpId);
			parentDo.setId_emp_st(userId); 
			parentDo.setId_wh(whId);
			String code = billCodeSrv.getPreBillCode_RequiresNew(StockPlanDODesc.CLASS_FULLNAME);
			parentDo.setCode(code);
			parentDo.setName(new FDate().toString());
			parentDo.setId_su_pl("@@@@AA1000000001D8DL");
			parentDo.setSd_su_pl("0");
			parentDo.setDate_reqr(new FDate());
			parentDo.setDt_st(new FDateTime());
			parentDo.setDt_st_short(new FDate());
			parentDo.setFg_active(new FBoolean(true));
			aggDo.setParentDO(parentDo);
			
			List<AutoReplenishConfigureDO> confList = map.get(whId);
			//根据策略进行分类，便于计算供应商和数量
			Map<String, List<AutoReplenishConfigureDO>> strategyMap = new HashMap<String, List<AutoReplenishConfigureDO>>();
			for(AutoReplenishConfigureDO confDo : confList) {
				if(strategyMap.containsKey(confDo.getId_strategy())) {
					List<AutoReplenishConfigureDO> list = strategyMap.get(confDo.getId_strategy());
					list.add(confDo);
				}else {
					List<AutoReplenishConfigureDO> list = new ArrayList<AutoReplenishConfigureDO>();
					list.add(confDo);
					strategyMap.put(confDo.getId_strategy(), list);
				}
			}
			IPoplanstrategyRService strategyService = ServiceFinder.find(IPoplanstrategyRService.class);
			List<StockPlanItmDO> itemList = new ArrayList<StockPlanItmDO>();
			for(String strategyId : strategyMap.keySet()) {
				List<AutoReplenishConfigureDO> list = strategyMap.get(strategyId);
				PoPlanStrategyDO strategy = strategyService.findById(strategyId);
				
				List<String> confIds = new ArrayList<String>();
				for(AutoReplenishConfigureDO confDo : list) {
					confIds.add(confDo.getId_addstrec());
				}
				String where = SqlUtils.getInSqlByIds(" cfg.id_addstrec ", confIds);
				GetPlItemDosSql sql = new GetPlItemDosSql(where, strategy);
				DAFacade daFacade = new DAFacade();
				@SuppressWarnings("unchecked")
				ArrayList<StockPlanItmDO> items = (ArrayList<StockPlanItmDO>) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(StockPlanItmDO.class));
				
				//药品基本信息
				Map<String, MeterialDO> mmMap = new HashMap<String, MeterialDO>();
				//历史入库信息
				Map<String, StockInQueryView> inQueryMap = new HashMap<String, StockInQueryView>();
				//获取药品基本信息和历史入库信息，为取价格做准备
				this.getMmMap(items, whId, mmMap, inQueryMap);
				
				for(StockPlanItmDO item : items) {
					//设置价格
					FDouble pri = null;
					if(IMmDictCodeConst.SD_MM_PURPRICE_SOURCE_1.equals(choosePurchasePrice.toString())) {
						pri = meterialService.packageUnitConversion(IMeterialService.TYPE_PRICE, mmMap.get(item.getId_mm()).getPrice_in(), mmMap.get(item.getId_mm()).getId_unit_pkgsp(), item.getId_mmpkgu_actual());
					}else {
						pri = supPriceSrv.getMmSupproPrice(item.getId_sup(), item.getId_mm(), new FDate());
						pri = meterialService.packageUnitConversion(IMeterialService.TYPE_PRICE, pri, mmMap.get(item.getId_mm()).getId_unit_pkgsp(), item.getId_mmpkgu_actual());
					}
					if(pri == null || pri.doubleValue() == FDouble.ZERO_DBL.doubleValue()) {
						if(inQueryMap.containsKey(item.getId_mm())) {
							pri = inQueryMap.get(item.getId_mm()).getPri_act();
							pri = meterialService.packageUnitConversion(IMeterialService.TYPE_PRICE, pri, inQueryMap.get(item.getId_mm()).getId_mmpkgu_actual(), item.getId_mmpkgu_actual());
						}
					}
					item.setPri_act(pri);
					//设置金额
					if(item.getPri_act() != null && item.getQuan_pl_actual() != null) {
						FDouble amt = item.getPri_act().multiply(item.getQuan_pl_actual());
						item.setAmt(amt);
					}
					//计算数量为负数的赋值为0
					if(item.getQuan_pl_actual().doubleValue() < 0) {
						item.setQuan_pl_actual(FDouble.ZERO_DBL);
					}
					itemList.add(item);
				}
			}
			StockPlanItmDO[] itemArray = itemList.toArray(new StockPlanItmDO[itemList.size()]);
			aggDo.setStockPlanItmDO(itemArray);
			aggList.add(aggDo);
		}
		return aggList.toArray(new StockplanAggDO[aggList.size()]);
	}

	private void getMmMap(ArrayList<StockPlanItmDO> items, String whId, Map<String, MeterialDO> mmMap, Map<String, StockInQueryView> inQueryMap) throws BizException {
		
		List<String> mmIdList = new ArrayList<String>();
		for(StockPlanItmDO item : items) {
			mmIdList.add(item.getId_mm());
		}
		String ids = SqlUtils.getInSqlByIds("MM.Id_Mm", mmIdList);
		GetPkguspListSql sql = new GetPkguspListSql(ids);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<MeterialDO> mmList = (List<MeterialDO>) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MeterialDO.class));
		if(mmList == null || mmList.size() <= 0) {
			throw new BizException("获取零售单位出错！");
		}
		for(MeterialDO mmDo : mmList) {
			mmMap.put(mmDo.getId_mm(), mmDo);
		}
		
		//历史入库价格
		GetInQueryPriActSql inQuerySql = new GetInQueryPriActSql(whId, ids);
		@SuppressWarnings("unchecked")
		List<StockInQueryView> inQueryViews = (List<StockInQueryView>) daFacade.execQuery(inQuerySql.getQrySQLStr(), inQuerySql.getQryParameter(null), new BeanListHandler(StockInQueryView.class));
		for(StockInQueryView view : inQueryViews) {
			if(inQueryMap.containsKey(view.getId_mm())) {
				continue;
			}
			inQueryMap.put(view.getId_mm(), view);
		}
	}

	private void creatTrap(List<AutoReplenishConfigureDO> trList) throws BizException {
		if(trList != null && trList.size() > 0) {
			//根据转入仓库和响应仓库（转出仓库）分类
			Map<String, List<AutoReplenishConfigureDO>> map = this.getTrMapByWh(trList);
			//生成调拨申请单
			TraprequestAggDO[] aggDos = this.getTrAggDos(map);
			ITraprequestCudService trService = ServiceFinder.find(ITraprequestCudService.class);
			trService.insert(aggDos);
		}
	}

	private Map<String, List<AutoReplenishConfigureDO>> getTrMapByWh(List<AutoReplenishConfigureDO> trList) throws BizException {
		Map<String, List<AutoReplenishConfigureDO>> map = new HashMap<String, List<AutoReplenishConfigureDO>>();
		List<String> idList = new ArrayList<String>();
		for(AutoReplenishConfigureDO confDo : trList) {
			idList.add(confDo.getId_addstrec());
		}
		String where = SqlUtils.getInSqlByIds(" cfg.id_addstrec ", idList);
		//根据仓库ID和响应仓库ID来分类，响应仓库为转出仓库
		GetTrConfMapSql sql = new GetTrConfMapSql(where);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<AutoReplenishConfigureDO> confList = (ArrayList<AutoReplenishConfigureDO>) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(AutoReplenishConfigureDO.class));
		for(AutoReplenishConfigureDO confDo : confList) {
			if(map.containsKey(confDo.getId_wh())) {
				List<AutoReplenishConfigureDO> list = map.get(confDo.getId_wh());
				list.add(confDo);
			}else {
				List<AutoReplenishConfigureDO> list = new ArrayList<AutoReplenishConfigureDO>();
				list.add(confDo);
				map.put(confDo.getId_wh(), list);
			}
		}
		return map;
	}
	
	private TraprequestAggDO[] getTrAggDos(Map<String, List<AutoReplenishConfigureDO>> map) throws BizException {
		List<TraprequestAggDO> aggList = new ArrayList<TraprequestAggDO>();
		String orgId = Context.get().getOrgId();
		String grpId = Context.get().getGroupId();
		String userId = Context.get().getUserId();
		IBillcodeManage billCodeSrv = ServiceFinder.find(IBillcodeManage.class);
		
		for(String whId : map.keySet()) {
			TraprequestAggDO aggDo = new TraprequestAggDO();
			TrapReqOrderDO parentDo = new TrapReqOrderDO();
			parentDo.setId_org(orgId);
			parentDo.setId_grp(grpId);
			parentDo.setId_emp_st(userId);
			String code = billCodeSrv.getPreBillCode_RequiresNew(TrapReqOrderDODesc.CLASS_FULLNAME);
			parentDo.setCode(code);
			parentDo.setDate_reqr(new FDate());
			parentDo.setId_da_pl("@@@@AA1000000003AZ6M");
			parentDo.setSd_da_pl("0");
			parentDo.setDt_st(new FDateTime());
			parentDo.setDt_st_short(new FDate());
			String[] idWhs = whId.split("&");
			parentDo.setId_wh_ap(idWhs[0]);
			parentDo.setId_wh(idWhs[1]);
			aggDo.setParentDO(parentDo);
			List<AutoReplenishConfigureDO> confList = map.get(whId);
			//根据策略进行分类，便于计算调拨量
			Map<String, List<AutoReplenishConfigureDO>> strategyMap = new HashMap<String, List<AutoReplenishConfigureDO>>();
			for(AutoReplenishConfigureDO confDo : confList) {
				if(strategyMap.containsKey(confDo.getId_strategy())) {
					List<AutoReplenishConfigureDO> list = strategyMap.get(confDo.getId_strategy());
					list.add(confDo);
				}else {
					List<AutoReplenishConfigureDO> list = new ArrayList<AutoReplenishConfigureDO>();
					list.add(confDo);
					strategyMap.put(confDo.getId_strategy(), list);
				}
			}
			
			
			IPoplanstrategyRService strategyService = ServiceFinder.find(IPoplanstrategyRService.class);
			List<TrapReqItemDO> itemList = new ArrayList<TrapReqItemDO>();
			for(String strategyId : strategyMap.keySet()) {
				List<AutoReplenishConfigureDO> list = strategyMap.get(strategyId);
				PoPlanStrategyDO strategy = strategyService.findById(strategyId);
				
				List<String> confIds = new ArrayList<String>();
				for(AutoReplenishConfigureDO confDo : list) {
					confIds.add(confDo.getId_addstrec());
				}
				String where = SqlUtils.getInSqlByIds(" cfg.id_addstrec ", confIds);
				GetTrItemDosSql sql = new GetTrItemDosSql(where, whId, strategy);
				DAFacade daFacade = new DAFacade();
				@SuppressWarnings("unchecked")
				ArrayList<TrapReqItemDO> items = (ArrayList<TrapReqItemDO>) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(TrapReqItemDO.class));
				for(TrapReqItemDO item : items) {
					//设置金额，数量和价格都有多种情况，写在SQL里不方便
					item.setAmt_da(item.getPri_act().multiply(item.getQuan_da_act()));
					//计算数量为负数的赋值为0
					if(item.getQuan_da_act().doubleValue() < 0) {
						item.setQuan_da_act(FDouble.ZERO_DBL);
					}
					itemList.add(item);
				}
			}
			TrapReqItemDO[] itemArray = itemList.toArray(new TrapReqItemDO[itemList.size()]);
			aggDo.setTrapReqItemDO(itemArray);
			aggList.add(aggDo);
		}
		return aggList.toArray(new TraprequestAggDO[aggList.size()]);
	}
}
