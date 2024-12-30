package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.desc.DaysLotDODesc;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.sc.scbd.scapptrule.d.ScapptruleDO;
import iih.sc.scbd.scapptrule.i.IScapptruleRService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.desc.ScSchDODesc;
import iih.sc.sch.scsch.i.IScschMDOCudService;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.d.desc.ScSchTickDODesc;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.d.desc.ScSchTicksDODesc;
import iih.sc.sch.scticks.i.IScticksCudService;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.i.IScpltickRService;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.i.IScplticksRService;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
	
/**根据一个计划排班
 * @author ccj
 *
 */
public class AddSchByOnePlanBp {
	/**根据一个计划生产排班
	 * @param startStr 开始排班时间
	 * @param endStr	结束排班时间
	 * @param planDO	计划do
	 * @param fgRecover	 
	 * @return  已经使用过的不能覆盖排班的排班信息arrays
	 * @throws BizException
	 */
	public String exec(String startStr,String endStr,ScPlanDO planDO,FBoolean fgRecover)throws BizException{
		Map<String,ScplweekAggDO> scplWeekaggMap = new HashMap<String,ScplweekAggDO>();
		IScplweekRService weekRSrv = ServiceFinder.find(IScplweekRService.class);
		ISctickCudService tickCudSrv = ServiceFinder.find(ISctickCudService.class);
		IScticksCudService ticksCudSrv = ServiceFinder.find(IScticksCudService.class);
		String planID = planDO.getId_scpl();  // 计划id
		String sd_tickmd = planDO.getSd_tickmd(); // 票号模式编码
		FDate beginDate = new FDate(startStr);  //排班开始时间
		FDate endDate = new FDate(endStr);	//排班结束时间
		Map schMap = new HashMap();  //本次排班时间内 已经存在的排班  || 已经使用过的排班
		String information = ""; // 返回不能覆盖排班信息
		// 覆盖与否
		if(fgRecover.booleanValue()){
			// 覆盖
			information = findNUByPlanIdTime(planID,startStr,endStr,sd_tickmd,schMap);
		}else{
			// 不覆盖
			GetOnlyDaylotAndDateByScPlanBp andDateByScPlanBp = new GetOnlyDaylotAndDateByScPlanBp();
			List list = andDateByScPlanBp.exec(planID, startStr, endStr,null);
			if(CollectionUtils.isNotEmpty(list)){
				for(int i=0;i<list.size();i++){
					Map map=(HashMap)list.get(i);
					schMap.put(map.get("id_dayslot")+"_"+map.get("d_sch"), 1);
				}
			}
		}
		// 周计划array
		ScplweekAggDO[] scplweekAggDOs = weekRSrv.find("Id_scpl='"+planDO.getId_scpl()+"'", "", FBoolean.FALSE);
		if(ArrayUtils.isEmpty(scplweekAggDOs)) return null;
		FArrayList scplWeekIds = new FArrayList();  //周计划Ids
		for (ScplweekAggDO scplweekAggDO : scplweekAggDOs) {
			scplWeekaggMap.put(scplweekAggDO.getParentDO().getId_dayslot()+"_"+scplweekAggDO.getParentDO().getWeekno(), scplweekAggDO);
			scplWeekIds.add(scplweekAggDO.getParentDO().getId_scplweek());
		}
		Map<String,FArrayList> scplWeekTickMap = new HashMap<String,FArrayList>();  // 以 周计划id为key 对所有计划号位和号段 value
		Map<String,Object[]> ticksMap = new HashMap<String,Object[]>(); // 周计划日期分组id+星期数 为key  相对应的计划号段和号位数组为value
		// 取出所有周计划对应的周号位和周号段
		getScplWeekAndTickData(scplWeekIds,planDO.getSd_tickmd(), scplWeekTickMap, scplweekAggDOs, scplWeekaggMap, ticksMap);
		String id_dayslot = scplweekAggDOs[0].getParentDO().getId_dayslot();  //日期分组id
		int numday = endDate.getDaysAfter(beginDate); 	//两个日期的间隔天数
		Map<String, ScplweekAggDO> scplWeekMap = getScplWeekAggMap(id_dayslot, numday, beginDate, schMap, scplWeekaggMap);
		if(scplWeekMap.isEmpty()) return null;
		SaveSchAggBp aggBp = new SaveSchAggBp();
		List<ScSchDO> schDOs = aggBp.exec(planDO,scplWeekMap);  // 排班DoList
		if(CollectionUtils.isEmpty(schDOs)) return information;
		// 所有周计划的号位或号段 转化为 排班的号段和号位
		if(IScDictCodeConst.SD_TICKMD_TICK.equals(planDO.getSd_tickmd())){
			// 号位
			GetSchTickByWeekTickBp byWeekTickBp = new GetSchTickByWeekTickBp();
			List<ScSchTickDO> schTickDOs = new ArrayList<ScSchTickDO>();
			for (ScSchDO schDO : schDOs) {
				int week = schDO.getD_sch().getWeek();
				schTickDOs.addAll(byWeekTickBp.exec((ScPlanWeekTickDO[])ticksMap.get(schDO.getId_dayslot()+"_"+week), schDO.getId_sch()));
			}
			ScSchTickDO[] tickDOs = schTickDOs.toArray(new ScSchTickDO[schTickDOs.size()]);
			tickCudSrv.save(tickDOs);
		}else if(IScDictCodeConst.SD_TICKMD_TICKS.equals(planDO.getSd_tickmd())){
			// 号段
			// 排班规则接口服务
			IScapptruleRService iScapprtuleRService = ServiceFinder.find(IScapptruleRService.class);
			ScapptruleDO scapprtuleDO = iScapprtuleRService.findById(planDO.getId_apptru());
			List<ScSchTicksDO> schTicksDOs = new ArrayList<ScSchTicksDO>();
			GetSchTicksByWeekTicksBp byWeekTicksBp = new GetSchTicksByWeekTicksBp();
			for (ScSchDO schDO : schDOs) {
				int week = schDO.getD_sch().getWeek();
				// 号段保存
				// 計劃號段轉化為排班號段
				List<ScSchTicksDO> scSchTicksDOs = byWeekTicksBp.exec((ScPlanWeekTicksDO[])ticksMap.get(schDO.getId_dayslot()+"_"+week), schDO.getId_sch());
				schTicksDOs.addAll(scSchTicksDOs);
			}
			ScSchTicksDO[] ticksDOs = schTicksDOs.toArray(new ScSchTicksDO[schTicksDOs.size()]);
			ScSchTicksDO[] newTicks = ticksCudSrv.save(ticksDOs);
			//保存号段后生成对应的号位
			SaveTickByTicksBp byTicksBp = new SaveTickByTicksBp();
			byTicksBp.exec(newTicks, scapprtuleDO.getSd_schrule());
		}
		return information;
	}
	
	/**
	 * 以日期分组id+排班日期 为key 周计划weekAggDO 为值 Map
	 * @param id_dayslot  日期分组id
	 * @param numday  两个日期的间隔天数
	 * @param beginDate 排班开始日期
	 * @param schMap 本次排班时间内 已经存在的排班  || 已经使用过的排班
	 * @param scplWeekaggMap 周计划
	 * @return
	 * @throws BizException 
	 */
	private Map<String, ScplweekAggDO> getScplWeekAggMap(String id_dayslot,int numday,FDate beginDate,Map schMap,Map<String,ScplweekAggDO> scplWeekaggMap) throws BizException{
		IDayslotMDORService dayslotSrv = ServiceFinder.find(IDayslotMDORService.class);
		DaysLotDO daysLotDO = dayslotSrv.findById(id_dayslot); 
		DaysLotDO[] daysLotDOs = dayslotSrv.find(DaysLotDODesc.TABLE_ALIAS_NAME+".id_dayslotca = '"+daysLotDO.getId_dayslotca()+"'", null, FBoolean.TRUE);
		Map<String, ScplweekAggDO> scplWeekMap = new HashMap<String, ScplweekAggDO>();  
		for(int daysi =0;daysi<daysLotDOs.length;daysi++){
			// 日期分组id
			String daysLotID = daysLotDOs[daysi].getId_dayslot();	
			for(int i = 0; i <= numday;i++){
				// 求出相差天数之后的日期
				FDate curData =  beginDate.getDateAfter(i);
			
				if(!schMap.containsKey(daysLotID+"_"+curData.toString())){
					//  当前日期是星期几
					int week = curData.getWeek();
					ScplweekAggDO onePlanWeek = scplWeekaggMap.get(daysLotID+"_"+week);
					if(onePlanWeek == null) continue;
					scplWeekMap.put(daysLotID+"_"+curData.toString(), onePlanWeek);
				}
			}
		}
		return scplWeekMap;
	}
	
	/**
	 * 获取周计划Map 和对应的 号段号位 Map  数据
	 * @param scplWeekIds  周计划 ids
	 * @param tickmd	票号模式
	 * @param scplWeekTickMap	周计划id key 对应号段号位value
	 * @param weekDO	周计划 arrays
	 * @param scplWeekaggMap 周计划 arraysMap	
	 * @param ticksMap 日期分组+星期数  
	 * @throws BizException
	 */
	private void getScplWeekAndTickData(FArrayList scplWeekIds,String tickmd,Map<String,FArrayList> scplWeekTickMap,ScplweekAggDO[] scplweekAggDOs
			,Map<String,ScplweekAggDO> scplWeekaggMap,Map<String,Object[]> ticksMap) throws BizException{
		IScpltickRService ticksrv = ServiceFinder.find(IScpltickRService.class);
		IScplticksRService tickssrv = ServiceFinder.find(IScplticksRService.class);
		if(IScDictCodeConst.SD_TICKMD_TICK.equals(tickmd)){
			ScPlanWeekTickDO[] planWeekTickDOs = ticksrv.findByAttrValList(ScPlanWeekTickDO.ID_SCPLWEEK, scplWeekIds);
			
			for (ScPlanWeekTickDO scPlanWeekTickDO : planWeekTickDOs) {
				if (scplWeekTickMap.containsKey(scPlanWeekTickDO.getId_scplweek())){
					FArrayList arrayList = scplWeekTickMap.get(scPlanWeekTickDO.getId_scplweek());
					arrayList.add(scPlanWeekTickDO);
				}else{
					FArrayList arrayList = new FArrayList();
					arrayList.add(scPlanWeekTickDO);
					scplWeekTickMap.put(scPlanWeekTickDO.getId_scplweek(), arrayList);
				}
			}
			// 周号位
			for(int weeki =0;weeki<scplweekAggDOs.length;weeki++){
				//计划对应的周计划 将周计划日期分组id+星期数为键值 
				scplWeekaggMap.put( scplweekAggDOs[weeki].getParentDO().getId_dayslot()+"_"+scplweekAggDOs[weeki].getParentDO().getWeekno(), scplweekAggDOs[weeki]);	
				if(scplWeekTickMap.containsKey(scplweekAggDOs[weeki].getParentDO().getId_scplweek())){
					FArrayList arrayList = scplWeekTickMap.get(scplweekAggDOs[weeki].getParentDO().getId_scplweek());
					ticksMap.put(scplweekAggDOs[weeki].getParentDO().getId_dayslot()+"_"+scplweekAggDOs[weeki].getParentDO().getWeekno(), arrayList.toArray(new ScPlanWeekTickDO[arrayList.size()]));
				}
			}
		}else if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickmd)){
			// 周号段
			ScPlanWeekTicksDO[] planWeekTicksDOs = tickssrv.findByAttrValList(ScPlanWeekTickDO.ID_SCPLWEEK, scplWeekIds);
			for (ScPlanWeekTicksDO scPlanWeekTicksDO : planWeekTicksDOs) {
				if (scplWeekTickMap.containsKey(scPlanWeekTicksDO.getId_scplweek())){
					FArrayList arrayList = scplWeekTickMap.get(scPlanWeekTicksDO.getId_scplweek());
					arrayList.add(scPlanWeekTicksDO);
				}else{
					FArrayList arrayList = new FArrayList();
					arrayList.add(scPlanWeekTicksDO);
					scplWeekTickMap.put(scPlanWeekTicksDO.getId_scplweek(), arrayList);
				}
			}
			for(int weeki =0;weeki<scplweekAggDOs.length;weeki++){
				//计划对应的周计划 将周计划日期分组id+星期数为键值
				scplWeekaggMap.put(scplweekAggDOs[weeki].getParentDO().getId_dayslot()+"_"+scplweekAggDOs[weeki].getParentDO().getWeekno(), scplweekAggDOs[weeki]);	
				if(scplWeekTickMap.containsKey(scplweekAggDOs[weeki].getParentDO().getId_scplweek())){
					FArrayList arrayList = scplWeekTickMap.get(scplweekAggDOs[weeki].getParentDO().getId_scplweek());
					ticksMap.put(scplweekAggDOs[weeki].getParentDO().getId_dayslot()+"_"+scplweekAggDOs[weeki].getParentDO().getWeekno(), arrayList.toArray(new ScPlanWeekTicksDO[arrayList.size()]));
				}
			}
		}
	}

	/**在覆盖情况下,删除没有预约和挂号的排班，提示有预约或挂号的排班不能删除
	 * @param Id_plan  计划id
	 * @param startStr  开始时间
	 * @param endStr  结束时间
	 * @param sd_tickmd  票号模式coed  
	 * @return string 提示信息
	 * @throws BizException 
	 */
	private String findNUByPlanIdTime(String Id_plan,String startStr,String endStr,String sd_tickmd,Map map) throws BizException{
		IScschMDORService rService = ServiceFinder.find(IScschMDORService.class);
		IScschMDOCudService mdoCudService = ServiceFinder.find(IScschMDOCudService.class);
		ScSchDO[] schDOs = rService.find(ScSchDODesc.TABLE_ALIAS_NAME+".id_scpl = '"+Id_plan+"' and "+ScSchDODesc.TABLE_ALIAS_NAME+".d_sch >= '"+startStr+"' and "+ScSchDODesc.TABLE_ALIAS_NAME+".d_sch <= '"+endStr+"'", null, FBoolean.TRUE);
		if(schDOs == null || schDOs.length<=0) return null;
		List<ScSchDO> list = new ArrayList<ScSchDO>();
		StringBuffer sb = new StringBuffer();
		StringBuffer ids_sch = new StringBuffer(); //已经使用排班id集合
		for (int i = 0; i < schDOs.length; i++) {
			// 可预约数和可挂号数都为null或0时 
			if( (schDOs[i].getQuan_total_used() == null || schDOs[i].getQuan_total_used() == 0 ) ){
				list.add(schDOs[i]);
				sb.append("'");
				sb.append(schDOs[i].getId_sch());
				sb.append("',");
			}else{
				// 提示有预约或挂号的排班不能删除
				ids_sch.append("'");
				ids_sch.append(schDOs[i].getId_sch());
				ids_sch.append("',");
			}
		}
		String information = null;
		if(ids_sch.length()>0){
			information = getMationScSch(ids_sch.substring(0, ids_sch.length()-1),map);
		}
		ISctickCudService cudService = ServiceFinder.find(ISctickCudService.class); 
		ISctickRService iSctickRService = ServiceFinder.find(ISctickRService.class); 
		if(StringUtils.isNotEmpty(sb.toString())){
			String sql = sb.toString().substring(0, sb.lastIndexOf(","));
			// 号位号段 都要删除号位 所有删除号位为公共
			ScSchTickDO[] schTickDOs =  iSctickRService.find(ScSchTickDODesc.TABLE_ALIAS_NAME+".id_sch in ("+sql+")", null, FBoolean.TRUE);
			cudService.delete(schTickDOs);
			if(IScDictCodeConst.SD_TICKMD_TICKS.equals(sd_tickmd)){
				IScticksRService scticksRService = ServiceFinder.find(IScticksRService.class);
				IScticksCudService iScticksCudService = ServiceFinder.find(IScticksCudService.class);
				ScSchTicksDO[] schTicksDOs = scticksRService.find(ScSchTicksDODesc.TABLE_ALIAS_NAME+".id_sch in ("+sql+")", null, FBoolean.TRUE);
				iScticksCudService.delete(schTicksDOs);
			}
			mdoCudService.delete(list.toArray(new ScSchDO[list.size()]));
		}
		return information;
	}
	
	/**根据排班DO生成该排班相关信息
	 * @param schDO  排班do
	 * @return string 提示信息
	 * @return
	 */
	private String getMationScSch(String ids_sch,Map map) throws BizException {
		if(StringUtils.isBlank(ids_sch) || map == null) return null;
		StringBuffer schInfo = new StringBuffer();	//返回排班信息
		GetSchAllInfoBp allInfoBp = new GetSchAllInfoBp();
		List list = allInfoBp.exec(ids_sch);  
		if(list == null || list.size() == 0 ) return null;
		schInfo.append("已经有挂号或预约，不能生成如下排班：");
		for (Object object : list) {
			Map map1 = (Map) object;
			schInfo.append(map1.get("srv_name"));
			schInfo.append(map1.get("res_name"));
			schInfo.append(map1.get("d_sch"));
			schInfo.append(map1.get("lot_name"));
			schInfo.append("、");
			map.put(map1.get("id_dayslot")+"_"+map1.get("d_sch"), 1);
		}
		String message =  schInfo.substring(0, schInfo.length()-1);
		return message;
	}
	
}
