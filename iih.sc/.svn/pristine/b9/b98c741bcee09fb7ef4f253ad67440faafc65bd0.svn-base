package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.desc.DaysLotDODesc;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.scapptrule.d.ScapptruleDO;
import iih.sc.scbd.scapptrule.i.IScapptruleRService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEmpDO;
import iih.sc.sch.scsch.d.ScschAggDO;
import iih.sc.sch.scsch.d.desc.ScSchDODesc;
import iih.sc.sch.scsch.i.IScschCudService;
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
import iih.sc.scp.i.IScScpOutCmdService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.i.IScpltickRService;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.i.IScplticksRService;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekEmpDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 医技排班生成
 * @author ccj
 *
 */
public class AddMtSchBp {
	
	/**
	 * 排班生成
	 * @param begin_date 开始排班日期
	 * @param end_date 结束排班日期
	 * @param schDataMap 周数+星期  key 年月日
	 * @param id_scpl 计划id
	 * @param fg_recover	是否覆盖
	 * @param excludeDates 排除日期s
	 * @throws BizException
	 */
	public String exec(String begin_date,String end_date,Map<String,String> schDataMap,String id_scpl,FBoolean fg_recover,String excludeDates) throws BizException{
		if(MapUtils.isEmpty(schDataMap) || StringUtils.isEmpty(id_scpl) || fg_recover == null
				|| StringUtils.isEmpty(begin_date) || StringUtils.isEmpty(end_date) ) return null;
		IScplanRService iScplanRService = ServiceFinder.find(IScplanRService.class);
		ScPlanDO scPlanDO = iScplanRService.findById(id_scpl);
		if(scPlanDO == null) throw new BizException("");
		String information = ""; // 返回不能覆盖排班信息
		Map usedOrExisSchMap = new HashMap();  //本次排班时间内 已经存在的排班  || 已经使用过的排班
		if(fg_recover.booleanValue()){
			// 覆盖
			information = findNUByPlanIdTime(id_scpl,begin_date,end_date,scPlanDO.getSd_tickmd(),usedOrExisSchMap,excludeDates);
		}else{
			// 不覆盖
			GetOnlyDaylotAndDateByScPlanBp andDateByScPlanBp = new GetOnlyDaylotAndDateByScPlanBp();
			List list = andDateByScPlanBp.exec(id_scpl, begin_date, end_date,excludeDates);
			if(CollectionUtils.isNotEmpty(list)){
				for(int i=0;i<list.size();i++){
					usedOrExisSchMap.put(((Map) list.get(i)).get("id_dayslot")+"_"+((Map) list.get(i)).get("d_sch"), 1);
				}
			}
		}
		IScplweekRService weekRSrv = ServiceFinder.find(IScplweekRService.class);
		// 周计划array
		ScplweekAggDO[] scplweekAggDOs = weekRSrv.find("Id_scpl='"+id_scpl+"'", "", FBoolean.FALSE);
		if(ArrayUtils.isEmpty(scplweekAggDOs)) throw new BizException("");
		FArrayList scplWeekIds = new FArrayList();  //周计划Ids
		Map<String,ScplweekAggDO> scplWeekaggMap = new HashMap<String,ScplweekAggDO>();
		for (ScplweekAggDO scplweekAggDO : scplweekAggDOs) {
			scplWeekaggMap.put(scplweekAggDO.getParentDO().getId_dayslot()+"_"+scplweekAggDO.getParentDO().getWeekno()+"_"+scplweekAggDO.getParentDO().getIdx_week(), scplweekAggDO);
			scplWeekIds.add(scplweekAggDO.getParentDO().getId_scplweek());
		}
		Map<String,FArrayList> scplWeekTickMap = new HashMap<String,FArrayList>();  // 以 周计划id为key 对所有计划号位和号段 value
		// 取出所有周计划对应的周号位和周号段
		getScplWeekAndTickData(scplWeekIds,scPlanDO.getSd_tickmd(), scplWeekTickMap, scplweekAggDOs, scplWeekaggMap);
		String id_dayslot = scplweekAggDOs[0].getParentDO().getId_dayslot();  //日期分组id
		Map<String, ScplweekAggDO> scplWeekMap = getScplWeekAggMap(id_dayslot,schDataMap,usedOrExisSchMap,scplWeekaggMap);
		if(scplWeekMap.isEmpty()) return null;
		exec(scPlanDO,scplWeekMap,scplWeekTickMap);  // 排班DoList
		return information;
	}
	
	/**
	 * 以日期分组id+排班日期 为key 周计划weekAggDO 为值 Map
	 * @param id_dayslot  日期分组id
	 * @param schMap 本次排班时间内 已经存在的排班  || 已经使用过的排班
	 * @param scplWeekaggMap 周计划
	 * @return
	 * @throws BizException 
	 */
	private Map<String, ScplweekAggDO> getScplWeekAggMap(String id_dayslot,Map<String,String> schDataMap,Map usedOrExisSchMap,Map<String,ScplweekAggDO> scplWeekaggMap) throws BizException{
		IDayslotMDORService dayslotSrv = ServiceFinder.find(IDayslotMDORService.class);
		DaysLotDO daysLotDO = dayslotSrv.findById(id_dayslot); 
		DaysLotDO[] daysLotDOs = dayslotSrv.find(DaysLotDODesc.TABLE_ALIAS_NAME+".id_dayslotca = '"+daysLotDO.getId_dayslotca()+"'", null, FBoolean.TRUE);
		Map<String, ScplweekAggDO> scplWeekMap = new HashMap<String, ScplweekAggDO>();  
		for(int daysi =0;daysi<daysLotDOs.length;daysi++){
			String daysLotID = daysLotDOs[daysi].getId_dayslot();	 // 日期分组id
			Iterator iterator =  schDataMap.entrySet().iterator();
			while (iterator.hasNext())
			{
		        Entry<String,String> pairs = (Entry<String,String>)iterator.next();
	        	String[] schDateArray = pairs.getValue().split(",");
	        	for (String curDate : schDateArray) {
	        		if(!usedOrExisSchMap.containsKey(daysLotID+"_"+curDate)){
	        			String[] dxWeekAndWeekArr = pairs.getKey().split("-");  //周序号+星期数
						ScplweekAggDO onePlanWeek = scplWeekaggMap.get(daysLotID+"_"+dxWeekAndWeekArr[1]+"_"+dxWeekAndWeekArr[0]);
						if(onePlanWeek == null) continue;
						scplWeekMap.put(daysLotID+"_"+curDate, onePlanWeek);
					}
				}
			 }
		}
		return scplWeekMap;
	}
	
	
	/**
	 * 保存排班aggDo
	 * @param planDO 计划do
	 * @param scplWeekMap	key 为 id_dayslot_date 组合 value 为 周计划agg
	 * @param   tickOrTicksMap  key 周计划id value 对应号段或号位 list
	 * @return
	 * @throws BizException
	 */
	public void exec(ScPlanDO planDO,Map<String, ScplweekAggDO> scplWeekMap,Map<String,FArrayList> tickOrTicksMap)throws BizException{
		if(planDO == null || MapUtils.isEmpty(scplWeekMap) || MapUtils.isEmpty(tickOrTicksMap)) return;
		List<ScSchChlDO> schChlDOs = new ArrayList<ScSchChlDO>();
		List<ScSchEmpDO> schEmpDOs = new ArrayList<ScSchEmpDO>();
		List<ScschAggDO> aggDOs = new ArrayList<ScschAggDO>();
		List<ScSchTickDO> schTickList = new ArrayList<ScSchTickDO>(); //排班号位list
		List<ScSchTicksDO> schTicksList = new ArrayList<ScSchTicksDO>(); //排班号段list
		DBUtil dbutil = new DBUtil();
		GetSchTickByWeekTickBp makeTickBp = new GetSchTickByWeekTickBp();
		GetSchTicksByWeekTicksBp makeTicksBp = new GetSchTicksByWeekTicksBp();
		FDate lastSchFDate = null; //最后排班日期
 		for (Entry<String, ScplweekAggDO> entry : scplWeekMap.entrySet()) {
			String[] strings = entry.getKey().split("_");
			String id_dayslot = strings[0]; //日期分组id
			String date = strings[1];	//日期
			if(lastSchFDate == null || new FDate(date).after(lastSchFDate)){
				lastSchFDate = new FDate(date);
			}
			ScSchDO sch = new ScSchDO(); // 排班do
			ScplweekAggDO plwekAgg = entry.getValue();
			sch.setSd_tickmd(planDO.getSd_tickmd());  // 票号模式
			sch.setD_sch(new FDate(date));
			sch.setId_dayslot(id_dayslot);
			sch.setId_scpl(planDO.getId_scpl());
			for (int i = 0; i < planDO.getScpolcn(); i++) {
				sch.setAttrVal("Quan"+i+"_appt", plwekAgg.getParentDO().getAttrVal("Quan"+i+"_appt"));
				sch.setAttrVal("Quan"+i+"_used", 0);
			}
			sch.setId_grp(ScContextUtils.getGrpId());  //集团
			sch.setId_org(ScContextUtils.getOrgId());  // 组织
			sch.setQuan_total(plwekAgg.getParentDO().getQuan_total());
			sch.setQuan_total_appt(plwekAgg.getParentDO().getQuan_total_appt());
			sch.setId_scca(planDO.getId_scca());
			sch.setId_sctp(planDO.getId_sctp());
			sch.setSd_sctp(planDO.getSd_sctp());
			sch.setScpolcn(plwekAgg.getParentDO().getScpolcn());  //号源池总数
			sch.setId_apptru(planDO.getId_apptru()); //预约规则
			sch.setQuan_total_used(0);//总使用数
			sch.setAddquecn(0); // 已加号数量  初始化
			sch.setT_b_acpt(plwekAgg.getParentDO().getT_b_acpt());  //开始就诊时间
			sch.setT_e_acpt(plwekAgg.getParentDO().getT_e_acpt()); //结束就诊时间
			sch.setFg_std_acpt(plwekAgg.getParentDO().getFg_std_acpt()); //是否标准就诊时间
			sch.setSrvslot(plwekAgg.getParentDO().getSrvslot());  //单服务时长(分钟)
			sch.setSugest_exmint(plwekAgg.getParentDO().getSugest_exmint());  //推荐提前报到时间
			sch.setSugest_num_tick(plwekAgg.getParentDO().getSugest_num_tick());  //号数
			sch.setSugest_num_mint(plwekAgg.getParentDO().getSugest_num_mint());  //分钟数
			sch.setT_e_reg(plwekAgg.getParentDO().getT_e_reg());  //停诊挂号时间
			sch.setStatus(DOStatus.NEW);
			sch.setFg_active(FBoolean.TRUE);
			String[] id_schs = dbutil.getOIDs(1);
			sch.setId_sch(id_schs[0]);
			ScschAggDO aggDO = new ScschAggDO();
			aggDO.setParentDO(sch);
			// 
			String id_scplWeek = plwekAgg.getParentDO().getId_scplweek();  //周计划id
			FArrayList tickList =  tickOrTicksMap.get(id_scplWeek);
			if(tickList == null) continue;
			if(IScDictCodeConst.SD_TICKMD_TICK.equals(planDO.getSd_tickmd())){
				//号位
				schTickList.addAll(makeTickBp.exec((ScPlanWeekTickDO[]) tickList.toArray(new ScPlanWeekTickDO[tickList.size()]) , id_schs[0]));
			}else if(IScDictCodeConst.SD_TICKMD_TICKS.equals(planDO.getSd_tickmd())){
				//号段
				schTicksList.addAll(makeTicksBp.exec((ScPlanWeekTicksDO[]) tickList.toArray(new ScPlanWeekTicksDO[tickList.size()]), id_schs[0])); 
			}
			// 计划周渠道 =》 排班渠道
			ScPlanWeekChlDO[] chl = plwekAgg.getScPlanWeekChlDO();		
			if(chl!=null && chl.length>0){
				for(int i=0;i<chl.length;i++)
				{
					ScSchChlDO chlDO = new ScSchChlDO();
					chlDO.setId_grp(ScContextUtils.getGrpId());  //集团
					chlDO.setId_org(ScContextUtils.getOrgId());  // 组织
					chlDO.setId_scchl(chl[i].getId_scchl());
					chlDO.setScpolcn(chl[i].getScpolcn());
					chlDO.setIds_emp_spec(chl[i].getIds_emp_spec()); //授权医生
					chlDO.setIds_dep_spec(chl[i].getIds_dep_spec()); //授权科室
					chlDO.setStatus(DOStatus.NEW);
					schChlDOs.add(chlDO);
				}
			}
			aggDO.setScSchChlDO(schChlDOs.toArray(new ScSchChlDO[schChlDOs.size()]));
			// 计划周人员 => 排班人员
			ScPlanWeekEmpDO[] emp = plwekAgg.getScPlanWeekEmpDO();		
			if(emp!=null && emp.length>0){
				for(int i=0;i<emp.length;i++)
				{
					ScSchEmpDO empDO = new ScSchEmpDO();
					empDO.setId_grp(ScContextUtils.getGrpId());  //集团
					empDO.setId_org(ScContextUtils.getOrgId());  // 组织
					empDO.setId_emp(emp[i].getId_emp());
					empDO.setStatus(DOStatus.NEW);
					schEmpDOs.add(empDO);
				}
			}
			aggDO.setScSchEmpDO(schEmpDOs.toArray(new ScSchEmpDO[schEmpDOs.size()]));
			aggDOs.add(aggDO);
			schChlDOs.clear();
			schEmpDOs.clear();
		}
		if(CollectionUtils.isEmpty(aggDOs)) return;
		IScScpOutCmdService scpOutCmdService = ServiceFinder.find(IScScpOutCmdService.class);
		scpOutCmdService.updateLastSchDate(lastSchFDate.toString(), planDO.getId_scpl());
		IScschCudService cudService = ServiceFinder.find(IScschCudService.class);
		cudService.save(aggDOs.toArray(new ScschAggDO[aggDOs.size()]));
		ISctickCudService sctickCudService = ServiceFinder.find(ISctickCudService.class);
		IScticksCudService scticksCudService = ServiceFinder.find(IScticksCudService.class);
		ScSchTicksDO[] scSchTicksDOs =  scticksCudService.save(schTicksList.toArray(new ScSchTicksDO[schTicksList.size()] ));
		SaveMtTickBp mtTickBp = new SaveMtTickBp();
		IScapptruleRService scapptruleRService = ServiceFinder.find(IScapptruleRService.class);
		ScapptruleDO scapptruleDO = scapptruleRService.findById(planDO.getId_apptru());
		for (ScSchTicksDO scSchTicksDO : scSchTicksDOs) {
			schTickList.addAll(mtTickBp.exec(scSchTicksDO.getT_b(), scSchTicksDO.getT_e(), scSchTicksDO.getId_sch(), scSchTicksDO.getQuecn(), scSchTicksDO.getQuecn_appt(), scSchTicksDO.getQueno_b(), scSchTicksDO.getQueno_b()+scSchTicksDO.getQuecn(), scSchTicksDO.getId_ticks(), scapptruleDO.getSd_schrule(),scSchTicksDO.getId_scsrv()));
		}
		sctickCudService.save(schTickList.toArray(new ScSchTickDO[schTickList.size()] ));
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
			,Map<String,ScplweekAggDO> scplWeekaggMap) throws BizException{
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
				scplWeekaggMap.put(scplweekAggDOs[weeki].getParentDO().getId_dayslot()+"_"+scplweekAggDOs[weeki].getParentDO().getWeekno()+"_"+scplweekAggDOs[weeki].getParentDO().getIdx_week(), scplweekAggDOs[weeki]);	
				if(scplWeekTickMap.containsKey(scplweekAggDOs[weeki].getParentDO().getId_scplweek())){
					FArrayList arrayList = scplWeekTickMap.get(scplweekAggDOs[weeki].getParentDO().getId_scplweek());
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
				scplWeekaggMap.put(scplweekAggDOs[weeki].getParentDO().getId_dayslot()+"_"+scplweekAggDOs[weeki].getParentDO().getWeekno()+"_"+scplweekAggDOs[weeki].getParentDO().getIdx_week(), scplweekAggDOs[weeki]);	
				if(scplWeekTickMap.containsKey(scplweekAggDOs[weeki].getParentDO().getId_scplweek())){
					FArrayList arrayList = scplWeekTickMap.get(scplweekAggDOs[weeki].getParentDO().getId_scplweek());
				}
			}
		}
	}
	
	
	
	/**
	 * 在覆盖情况下,删除没有预约和挂号的排班，提示有预约或挂号的排班不能删除
	 * @param Id_plan  计划id
	 * @param startStr  开始时间
	 * @param endStr  结束时间
	 * @param sd_tickmd  票号模式coed 
	 * @param map
	 * @param  excludeDates 排除日期s
	 * @return string 提示信息
	 * @throws BizException 
	 */
	private String findNUByPlanIdTime(String id_plan,String startStr,String endStr,String sd_tickmd,Map map,String excludeDates) throws BizException{
		IScschMDORService rService = ServiceFinder.find(IScschMDORService.class);
		IScschMDOCudService mdoCudService = ServiceFinder.find(IScschMDOCudService.class);
		String paramSql = ScSchDODesc.TABLE_ALIAS_NAME+".id_scpl = '"+id_plan+"' and "+ScSchDODesc.TABLE_ALIAS_NAME+".d_sch >= '"+startStr+"' and "+ScSchDODesc.TABLE_ALIAS_NAME+".d_sch <= '"+endStr+"'";
		if(StringUtils.isNotEmpty(excludeDates)){
			paramSql += " and "+ScSchDODesc.TABLE_ALIAS_NAME+".d_sch not in ("+excludeDates+")";
		}
		ScSchDO[] schDOs = rService.find(paramSql, "", FBoolean.TRUE);
		if(ArrayUtils.isEmpty(schDOs)) return null;
		List<ScSchDO> schDOlist = new ArrayList<ScSchDO>();
		List<String> noUsedSchList = new ArrayList<String>();  //未使用排班id
		List<String> usedSchList = new ArrayList<String>();	//已使用排班id
		for (int i = 0; i < schDOs.length; i++) {
			// 使用数量 
			if( (schDOs[i].getQuan_total_used() == null || schDOs[i].getQuan_total_used() == 0 ) ){
				schDOlist.add(schDOs[i]);
				noUsedSchList.add(schDOs[i].getId_sch());
			}else{
				// 提示有预约或挂号的排班不能删除
				usedSchList.add(schDOs[i].getId_sch());
			}
		}
		String information = null;
		if(CollectionUtils.isNotEmpty(usedSchList)){
			information = getMationScSch(ScSqlUtils.buildIdStr(usedSchList),map);
		}
		ISctickCudService cudService = ServiceFinder.find(ISctickCudService.class); 
		ISctickRService iSctickRService = ServiceFinder.find(ISctickRService.class); 
		if( CollectionUtils.isNotEmpty(noUsedSchList)){
			String sql = ScSqlUtils.buildIdStr(noUsedSchList);
			// 号位号段 都要删除号位 所有删除号位为公共
			ScSchTickDO[] schTickDOs =  iSctickRService.find(ScSchTickDODesc.TABLE_ALIAS_NAME+".id_sch in ("+sql+")", null, FBoolean.TRUE);
			cudService.delete(schTickDOs);
			if(IScDictCodeConst.SD_TICKMD_TICKS.equals(sd_tickmd)){
				IScticksRService scticksRService = ServiceFinder.find(IScticksRService.class);
				IScticksCudService iScticksCudService = ServiceFinder.find(IScticksCudService.class);
				ScSchTicksDO[] schTicksDOs = scticksRService.find(ScSchTicksDODesc.TABLE_ALIAS_NAME+".id_sch in ("+sql+")", null, FBoolean.TRUE);
				iScticksCudService.delete(schTicksDOs);
			}
			mdoCudService.delete(schDOlist.toArray(new ScSchDO[schDOlist.size()]));
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
