package iih.sc.sch.s.bp;

import iih.sc.comm.ScContextUtils;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEmpDO;
import iih.sc.sch.scsch.d.ScschAggDO;
import iih.sc.sch.scsch.i.IScschCudService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekEmpDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存排班aggDo
 * @author ccj
 *
 */
public class SaveSchAggBp {
/**
 * 保存排班aggDo
 * @param planDO 计划do
 * @param map	key 为 id_dayslot_date 组合 value 为 周计划agg
 * @return
 * @throws BizException
 */
public List<ScSchDO> exec(ScPlanDO planDO,Map<String, ScplweekAggDO> map)throws BizException{
	if(planDO == null || map.size() == 0) return null;
	List<ScSchChlDO> schChlDOs = new ArrayList<ScSchChlDO>();
	List<ScSchEmpDO> schEmpDOs = new ArrayList<ScSchEmpDO>();
	List<ScschAggDO> aggDOs = new ArrayList<ScschAggDO>();
	for (Entry<String, ScplweekAggDO> entry : map.entrySet()) {
		String[] strings = entry.getKey().split("_");
		String id_dayslot = strings[0]; //日期分组id
		String date = strings[1];	//日期
		ScSchDO sch = new ScSchDO(); // 排班do
		ScplweekAggDO plwekAgg = entry.getValue();
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
		sch.setQuan_total_used(0);//总使用数
		sch.setAddquecn(0); // 已加号数量  初始化
		sch.setStatus(DOStatus.NEW);
		sch.setFg_active(FBoolean.TRUE);
		ScschAggDO aggDO = new ScschAggDO();
		aggDO.setParentDO(sch);
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
	if(CollectionUtils.isEmpty(aggDOs)) return null;
	List<ScSchDO> schDOs = new ArrayList<ScSchDO>();
	IScschCudService cudService = ServiceFinder.find(IScschCudService.class);
	ScschAggDO[] scschAggDOs = cudService.save(aggDOs.toArray(new ScschAggDO[aggDOs.size()]));
	for (ScschAggDO scschAggDO : scschAggDOs) {
		schDOs.add(scschAggDO.getParentDO());
	}
	return schDOs;
}
}
