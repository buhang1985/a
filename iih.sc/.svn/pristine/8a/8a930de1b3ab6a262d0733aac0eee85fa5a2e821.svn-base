package iih.sc.scp.s.bp.oral;

import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scp.dto.d.OralPlTickDTO;
import iih.sc.scp.s.ep.ScplEp;
import iih.sc.scp.s.ep.ScplWeekEP;
import iih.sc.scp.s.ep.ScplWeekTickEP;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.d.desc.ScPlanDODesc;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 获取口清科周计划
 * 
 * @author liubin
 *
 */
public class GetOralPlWeekBP {
	/**
	 * 获取口腔周计划
	 * 
	 * @param scplId
	 * @return
	 * @throws BizException
	 */
	public OralPlTickDTO[] getOralPlTick(String scplId, String deptParamId) throws BizException {
		if(ScValidator.isEmptyIgnoreBlank(scplId))
			return null;
		String whereStr = String.format("%s.%s = '%s' and %s.%s = '%s' ", 
				ScPlanDODesc.TABLE_ALIAS_NAME, ScPlanDO.ID_SCPL, scplId,
				ScPlanDODesc.TABLE_ALIAS_NAME, ScPlanDO.ID_DEPPARAM, deptParamId);
		ScplEp ep = new ScplEp();
		ScPlanDO[] scpls =  ep.getScPls(whereStr, null);
		if(ScValidator.isNullOrEmpty(scpls))
			return null;
		return getOralPlTick(scplId);
	}
	/**
	 * 获取口腔周计划
	 * 
	 * @param scplId
	 * @return
	 * @throws BizException
	 */
	public OralPlTickDTO[] getOralPlTick(String scplId) throws BizException {
		if(ScValidator.isEmptyIgnoreBlank(scplId))
			return null;
		//查询周计划
		ScplweekAggDO[] weekAggs = this.getPlanWeekAggByPlId(scplId);
		//查询号位
		Map<String, FArrayList> tksMap = this.getPlanWeekTick(weekAggs);
		
		return wrapOralPlTick(weekAggs, tksMap);
	}
	/**
	 * 获取口腔周计划
	 * 
	 * @param scplId
	 * @return
	 * @throws BizException
	 */
	public FArrayList getOralPlTickList(String scplId) throws BizException {
		OralPlTickDTO[] plTickDTOs = getOralPlTick(scplId);
		if(ScValidator.isNullOrEmpty(plTickDTOs))
			return null;
		return ScAppUtils.doArray2List(plTickDTOs);
	}
	
	/**
	 * 
	 * @param oralPl
	 * @param weekAggs
	 * @param tksMap
	 */
	@SuppressWarnings("unchecked")
	private OralPlTickDTO[] wrapOralPlTick(ScplweekAggDO[] weekAggs, Map<String, FArrayList> tksMap){
		if(ScValidator.isNullOrEmpty(weekAggs))
			return null;
		List<OralPlTickDTO> list = new ArrayList<OralPlTickDTO>(weekAggs.length);
		for(ScplweekAggDO agg : weekAggs){
			String id_scplweek = agg.getParentDO().getId_scplweek();
			OralPlTickDTO plTk = new OralPlTickDTO();
			plTk.setId_scpl(agg.getParentDO().getId_scpl());
			if(tksMap!=null && tksMap.size()>0&&tksMap.containsKey(id_scplweek))
				plTk.setTick_list(tksMap.get(id_scplweek));
			plTk.setScpl_week_list(ScAppUtils.aggDoArray2List(agg));
			list.add(plTk);
		}
		return list.toArray(new OralPlTickDTO[0]);
	}
	
	/**
	 * 根据计划Id查询周计划
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 */
	private ScplweekAggDO[] getPlanWeekAggByPlId(String scplId) throws BizException {
		ScplweekAggDO[] scplWeekAggs = new ScplWeekEP().getPlWeekAggByPlId(scplId);
		if(ScValidator.isNullOrEmpty(scplWeekAggs))
			return null;
		for(ScplweekAggDO agg : scplWeekAggs){
			this.processScplweekAggDO(agg);
		}
		return scplWeekAggs;
	}
	
	/**
	 * 处理周计划
	 * @param agg
	 */
	private void processScplweekAggDO(ScplweekAggDO agg){
		if(ScValidator.isNullOrEmpty(agg))
			return;
		ScPlanWeekDO plWeek = agg.getParentDO();
		if(ScValidator.isNullOrEmpty(plWeek))
			return;
		ScPlanWeekChlDO[] chls = agg.getScPlanWeekChlDO();
		if(ScValidator.isNullOrEmpty(chls))
			return;
		Map<Integer, ScPlanWeekChlDO> map = new HashMap<>();
		for(ScPlanWeekChlDO chl : chls){
			Integer key = chl.getScpolcn();
			if(ScValidator.isNullOrEmpty(key))
				continue;
			if(map.containsKey(key)){
				ScPlanWeekChlDO value = map.get(key);
				if(!ScValidator.isEmptyIgnoreBlank(value.getId_scchl())){
					value.setId_scchl(value.getId_scchl() + ",");
				}
				value.setId_scchl(value.getId_scchl() + chl.getId_scchl());
				if(!ScValidator.isEmptyIgnoreBlank(value.getName_scchl())){
					value.setName_scchl(value.getName_scchl() + ",");
				}
				value.setName_scchl(value.getName_scchl() + chl.getName_scchl());
			}else{
				Integer scnum = (Integer)plWeek.getAttrVal("Quan"+key+"_appt");
				chl.setScnum(scnum == null ? 0 : scnum);
				map.put(key, chl);
			}
		}
		agg.setScPlanWeekChlDO(map.values().toArray(new ScPlanWeekChlDO[0]));
	}
	
	/**
	 * 获取号位
	 * 
	 * @param weekAggsMap
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, FArrayList> getPlanWeekTick(ScplweekAggDO[] weekAggs) throws BizException {
		if(ScValidator.isNullOrEmpty(weekAggs))
			return null;
		String[] plWeekIds = ScplWeekEP.getPlWeekIds(weekAggs);
		ScplWeekTickEP plTickEp = new ScplWeekTickEP();
		ScPlanWeekTickDO[] plWeekTicks = plTickEp.getTickByWeekIds(plWeekIds);
		if(ScValidator.isNullOrEmpty(plWeekTicks))
			return null;
		Map<String, FArrayList> map = new HashMap<>();
		for(ScPlanWeekTickDO tk : plWeekTicks){
			String key = tk.getId_scplweek();
			if (map.containsKey(key)) {
				map.get(key).add(tk);
			} else {
				FArrayList list = new FArrayList();
				list.add(tk);
				map.put(key, list);
			}
		}
		return map;
	}
}
