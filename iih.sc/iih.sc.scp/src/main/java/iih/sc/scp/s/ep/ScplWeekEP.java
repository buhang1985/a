package iih.sc.scp.s.ep;

import iih.sc.comm.ScValidator;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScPlanWeekEnDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScPlanWeekChlDOCudService;
import iih.sc.scp.scplweek.i.IScPlanWeekChlDORService;
import iih.sc.scp.scplweek.i.IScplweekCudService;
import iih.sc.scp.scplweek.i.IScplweekMDOCudService;
import iih.sc.scp.scplweek.i.IScplweekMDORService;
import iih.sc.scp.scplweek.i.IScplweekRService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 周计划EP
 * 
 * @author liubin
 *
 */
public class ScplWeekEP {

	/**
	 * 获取周计划
	 * 
	 * @param whereStr
	 * @return
	 * @throws BizException
	 */
	public ScPlanWeekDO[] getPlWeeks(String whereStr) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(whereStr))
			return null;
		return getMRServ().find(whereStr, null, FBoolean.FALSE);
	}

	/**
	 * 保存周计划
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 09:49:45
	 *
	 * @param planWeekDOs
	 * @return
	 * @throws BizException
	 */
	public ScPlanWeekDO[] save(ScPlanWeekDO[] planWeekDOs) throws BizException {
		if (ArrayUtil.isEmpty(planWeekDOs)) {
			return null;
		}
		return this.getMCudServ().save(planWeekDOs);
	}

	/**
	 * 获取周计划
	 * 
	 * @param plWeekId
	 * @return
	 * @throws BizException
	 */
	public ScPlanWeekDO getPlWeekById(String plWeekId) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(plWeekId))
			return null;
		return getMRServ().findById(plWeekId);
	}

	/**
	 * 根据条件查询周计划
	 * 
	 * @param whereStr
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	public ScPlanWeekDO[] getPlWeekByCond(String whereStr, String orderStr) throws BizException {
		return getMRServ().find(whereStr, orderStr, FBoolean.FALSE);
	}

	/**
	 * 获取周计划集合
	 * 
	 * @param scplId 计划ID
	 * @return
	 * @throws BizException
	 */
	public ScPlanWeekDO[] getPlWeekByPlId(String scplId) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(scplId))
			return null;
		return getMRServ().findByAttrValString(ScPlanWeekDO.ID_SCPL, scplId);
	}

	/**
	 * 获取
	 * 
	 * @param plWeekId
	 * @return
	 * @throws BizException
	 */
	public ScplweekAggDO getScplweekAggById(String plWeekId) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(plWeekId))
			return null;
		return getAggRServ().findById(plWeekId);
	}

	/**
	 * 根据计划Id查询周计划
	 * 
	 * @param scplId
	 * @return
	 * @throws BizException
	 */
	public ScplweekAggDO[] getPlWeekAggByPlId(String scplId) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(scplId))
			return null;
		// 排班周计划查询服务
		return this.getAggRServ().findByAttrValString(ScPlanWeekDO.ID_SCPL, scplId);
	}

	/**
	 * 保存排班周计划
	 *
	 * @param planWeekAggDOs
	 * @return
	 * @throws BizException
	 */
	public ScplweekAggDO[] savePlanWeekAgg(ScplweekAggDO[] planWeekAggDOs) throws BizException {
		if (ScValidator.isNullOrEmpty(planWeekAggDOs))
			return null;
		// 排班周计划维护服务
		return this.getAggCudServ().save(planWeekAggDOs);
	}

	/**
	 * 删除Agg
	 * 
	 * @param plWeeks
	 * @throws BizException
	 */
	public void deleteByParentDO(ScPlanWeekDO[] plWeeks) throws BizException {
		if (ScValidator.isNullOrEmpty(plWeeks))
			return;
		getAggCudServ().deleteByParentDO(plWeeks);
	}

	/**
	 * 删除Agg
	 * 
	 * @param plWeeks
	 * @throws BizException
	 */
	public void deleteAgg(ScplweekAggDO[] plWeeks) throws BizException {
		if (ScValidator.isNullOrEmpty(plWeeks))
			return;
		getAggCudServ().delete(plWeeks);
	}

	/**
	 * 删除周计划渠道
	 * 
	 * @param plWeekId
	 * @throws BizException
	 */
	public void deleteChlByWeekId(String plWeekId) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(plWeekId))
			return;
		ScPlanWeekChlDO[] chls = this.getChlRServ().findByAttrValString(ScPlanWeekChlDO.ID_SCPLWEEK, plWeekId);
		if (ScValidator.isNullOrEmpty(chls))
			return;
		this.getChlCudServ().delete(chls);
	}

	/**
	 * 删除周计划渠道
	 * 
	 * @param plWeekId
	 * @throws BizException
	 */
	public void deleteChlByWeekIds(String[] plWeekIds) throws BizException {
		if (ScValidator.isNullOrEmpty(plWeekIds))
			return;
		ScPlanWeekChlDO[] chls = this.getChlRServ().findByAttrValStrings(ScPlanWeekChlDO.ID_SCPLWEEK, plWeekIds);
		if (ScValidator.isNullOrEmpty(chls))
			return;
		this.getChlCudServ().delete(chls);
	}
	/**
	 * 界面数据组装的渠道DO与原数据对比，分出新增，删除，修改的渠道DO
	 * 
	 * @param oldAgg
	 * @param newChlsList
	 * @param chlsList
	 */
	public void assemlyWeekChls(ScplweekAggDO oldAgg, List<ScPlanWeekChlDO> newChlsList, List<ScPlanWeekChlDO> chlsList) {
		Map<String, ScPlanWeekChlDO> oldChlMap = assemlyChlMap(oldAgg);
		if(oldChlMap == null || oldChlMap.size() <= 0)
			chlsList.addAll(newChlsList);
		else{
			for(ScPlanWeekChlDO chl : newChlsList){
				String key = chl.getId_scchl() + chl.getScpolcn();
				if(oldChlMap.containsKey(key)){
					//加入修改的渠道DO
					ScPlanWeekChlDO updateChl = oldChlMap.remove(key);
					updateChl.setStatus(DOStatus.UPDATED);
					updateChl.setIds_dep_spec(chl.getIds_dep_spec());
					updateChl.setIds_emp_spec(chl.getIds_emp_spec());
					updateChl.setScnum(chl.getScnum());
					updateChl.setNames_dep_spec(chl.getNames_dep_spec());
					updateChl.setNames_emp_spec(chl.getNames_emp_spec());
					updateChl.setId_entp(chl.getId_entp());//就诊类型
					updateChl.setCode_entp(chl.getCode_entp());
					updateChl.setName_entp(chl.getName_entp());
					chlsList.add(updateChl);
				}else{
					//加入新增的渠道DO
					chlsList.add(chl);
				}
			}
			//加入删除的渠道DO
			for(ScPlanWeekChlDO delChl : oldChlMap.values()){
				delChl.setStatus(DOStatus.DELETED);
				chlsList.add(delChl);
			}
		}
	}
	
	/**
	 * 界面数据组装的渠道DO与原数据对比，分出新增，删除，修改的渠道DO
	 * 
	 * @param oldAgg
	 * @param newChlsList
	 * @param chlsList
	 */
	public void assemlyWeekEns(ScplweekAggDO oldAgg, List<ScPlanWeekEnDO> newEnsList, List<ScPlanWeekEnDO> ensList) {
		Map<String, ScPlanWeekEnDO> oldEnMap = assemlyEnMap(oldAgg);
		if(oldEnMap == null || oldEnMap.size() <= 0)
			ensList.addAll(newEnsList);
		else{
			for(ScPlanWeekEnDO en : newEnsList){
				String key = en.getId_scplweek()+en.getId_entp();
				if(oldEnMap.containsKey(key)){
					//加入修改的渠道DO
					ScPlanWeekEnDO updateEn = oldEnMap.remove(key);
					updateEn.setStatus(DOStatus.UPDATED);
					updateEn.setId_scplweek(en.getId_scplweek());
					updateEn.setId_entp(en.getId_entp());
					updateEn.setSd_entp(en.getSd_entp());
					updateEn.setScpolcn(en.getScpolcn());
					updateEn.setQuan(en.getQuan());
					ensList.add(updateEn);
				}else{
					//加入新增的渠道DO
					ensList.add(en);
				}
			}
			//加入删除的渠道DO
			for(ScPlanWeekEnDO delChl : oldEnMap.values()){
				delChl.setStatus(DOStatus.DELETED);
				ensList.add(delChl);
			}
		}
	}
	
	/**
	 * 获取主DO查询服务
	 * 
	 * @return
	 */
	public IScplweekMDORService getMRServ() {
		return ServiceFinder.find(IScplweekMDORService.class);
	}

	/**
	 * 获取主DO操作服务
	 * 
	 * @return
	 */
	public IScplweekMDOCudService getMCudServ() {
		return ServiceFinder.find(IScplweekMDOCudService.class);
	}

	/**
	 * 获取AggDO查询服务
	 * 
	 * @return
	 */
	public IScplweekRService getAggRServ() {
		return ServiceFinder.find(IScplweekRService.class);
	}

	/**
	 * 获取主AggDO操作服务
	 * 
	 * @return
	 */
	public IScplweekCudService getAggCudServ() {
		return ServiceFinder.find(IScplweekCudService.class);
	}

	/**
	 * 获取周计划渠道查询服务
	 * 
	 * @return
	 */
	public IScPlanWeekChlDORService getChlRServ() {
		return ServiceFinder.find(IScPlanWeekChlDORService.class);
	}

	/**
	 * 获取周计划渠道操作服务
	 * 
	 * @return
	 */
	public IScPlanWeekChlDOCudService getChlCudServ() {
		return ServiceFinder.find(IScPlanWeekChlDOCudService.class);
	}

	/**
	 * 获取周计划ID集合
	 * 
	 * @param weekAggs
	 * @return
	 */
	public static String[] getPlWeekIds(ScplweekAggDO[] weekAggs) {
		if (ScValidator.isNullOrEmpty(weekAggs))
			return null;
		Set<String> set = new HashSet<String>();
		for (ScplweekAggDO week : weekAggs) {
			if (week.getParentDO() != null)
				set.add(week.getParentDO().getId_scplweek());
		}
		return set.toArray(new String[0]);
	}

	/**
	 * 获取周计划ID集合
	 * 
	 * @param weekAggs
	 * @return
	 */
	public static String[] getPlWeekIds(ScPlanWeekDO[] weeks) {
		if (ScValidator.isNullOrEmpty(weeks))
			return null;
		Set<String> set = new HashSet<String>();
		for (ScPlanWeekDO week : weeks) {
			set.add(week.getId_scplweek());
		}
		return set.toArray(new String[0]);
	}
	/**
	 * 组装渠道字典
	 * 
	 * 因号源池开发数为0时，渠道可以为空，因此以（渠道 + 号源池）为字典key值
	 * @param chls
	 * @return
	 */
	private static Map<String, ScPlanWeekChlDO> assemlyChlMap(ScplweekAggDO agg){
		Map<String, ScPlanWeekChlDO> map = new HashMap<>();
		if(agg == null || ArrayUtil.isEmpty(agg.getScPlanWeekChlDO()))
			return map;
		ScPlanWeekChlDO[] chls = agg.getScPlanWeekChlDO();
		for(ScPlanWeekChlDO chl : chls){
			//因号源池开发数为0时，渠道可以为空，因此以（渠道 + 号源池）为字典key值
			String key = chl.getId_scchl() + chl.getScpolcn();
			chl.setScnum((Integer) agg.getParentDO().getAttrVal("Quan" + chl.getScpolcn() + "_appt"));
			map.put(key, chl);
		}
		return map;
	}
	
	/**
	 * 组装渠道字典
	 * 
	 * 计划周  + 就诊类型  为字典key值
	 * @param ens
	 * @return
	 */
	private static Map<String, ScPlanWeekEnDO> assemlyEnMap(ScplweekAggDO agg){
		Map<String, ScPlanWeekEnDO> map = new HashMap<>();
		if(agg == null || ArrayUtil.isEmpty(agg.getScPlanWeekChlDO()))
			return map;
		ScPlanWeekEnDO[] ens = agg.getScPlanWeekEnDO();
		for(ScPlanWeekEnDO en : ens){
			String key = en.getId_scplweek() + en.getId_entp();
			map.put(key, en);
		}
		return map;
	}
}
