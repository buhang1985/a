package iih.sc.sch.s.bp.mt.apt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlAggDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlRService;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取指定渠道的排班剩余可预约数，渠道为空时取总可预约数BP
 * 
 * @author zhengcm
 * @date 2018-04-26 11:35:19
 *
 */
public class GetChlSchApptAmount4AutoBP {

	/**
	 * 获取指定渠道的排班剩余可预约数，渠道为空时取总可预约数
	 * 
	 * @author zhengcm
	 *
	 * @param schIdList
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	public Map<String, Map<Integer,Integer>> exec(List<String> schIdList, String id_enttp,String id_scchl) throws BizException {
		if (ListUtil.isEmpty(schIdList)) {
			return null;
		}
		// 查询排班
		ScSchDO[] schDOs = new SchEP().getByIds(schIdList.toArray(new String[0]));
		
		//查询渠道
		ISchedulechlRService schedulechlRService = ServiceFinder.find(ISchedulechlRService.class);
		SchedulechlAggDO schedulechlAggDO = schedulechlRService.findById(id_scchl);
		String code_scchl = schedulechlAggDO.getParentDO().getCode();//渠道编码
				
		
		// 查询排班中的指定排班渠道
		ScSchChlDO[] schChlDOs = null;
		if(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM.equals(code_scchl))
		{
			schChlDOs = new OralSchEP().getSchChlByCond(
					String.format(ScSqlUtils.getInSqlByIds("id_sch", schIdList) 
							+ " and id_scchl = '%s'"
							+ " and (ids_dep_spec is null or ids_dep_spec like '%s' )"
							+ " and (ids_emp_spec is null or ids_emp_spec like '%s' )",
							id_scchl,"%"+ScContextUtils.getDeptId()+"%","%"+ScContextUtils.getPsnId()+"%"), null);
		}
		else
		{
			schChlDOs = new OralSchEP().getSchChlByCond(
					String.format(ScSqlUtils.getInSqlByIds("id_sch", schIdList) + " and id_scchl = '%s'", id_scchl), null);
		}
		//如果没有指定渠道排班则返回空
		if(ArrayUtil.isEmpty(schChlDOs)) return null;
		// 记录排班
		Map<String, ScSchDO> schMap = new HashMap<String, ScSchDO>();
		for (ScSchDO schDO : schDOs) {
			String key = schDO.getId_sch();
			if (!schMap.containsKey(key)) {
				schMap.put(key, schDO);
			}
		}
		
		// 原来是一个号源池对应一个渠道 现在多个号源池都可以包含同一个渠道
		// 记录排班渠道号源池
		Map<String, List<ScSchChlDO>> chlPolcnMap = new HashMap<String, List<ScSchChlDO>>();
		if (!ArrayUtil.isEmpty(schChlDOs)) {
			for (ScSchChlDO chlDO : schChlDOs) {
				boolean isSetEntp = schMap.get(chlDO.getId_sch()).getFg_setentp().booleanValue();
				String key = chlDO.getId_sch();
				if (!chlPolcnMap.containsKey(key)) {
					List<ScSchChlDO> scpolcnList = new ArrayList<ScSchChlDO>();
					if(isSetEntp){
						if(!StringUtil.isEmpty(id_enttp) && chlDO.getId_entp() != null && chlDO.getId_entp().contains(id_enttp)){
							scpolcnList.add(chlDO);
						}
					}else{
						scpolcnList.add(chlDO);
					}
					chlPolcnMap.put(key, scpolcnList);
				}else{
					if(isSetEntp){
						if(chlDO.getId_entp().contains(id_enttp)){
							chlPolcnMap.get(key).add(chlDO);
						}
					}else{
						chlPolcnMap.get(key).add(chlDO);
					}
				}
			}
		}
		// 记录排班指定了渠道的号位
		Map<String, List<ScSchTickDO>> tickMap = new HashMap<String, List<ScSchTickDO>>();
		ScSchTickDO[] tickDOs = new OralSchEP().getSchTickByCond(String.format(
				ScSqlUtils.getInSqlByIds("id_sch", schIdList)
						+ " and ids_scchl is not null and eu_used = %d and eu_usescope = %d", EuUseState.WY,
				EuUseScope.APT), null, null);
		if (!ArrayUtil.isEmpty(tickDOs)) {
			for (ScSchTickDO tickDO : tickDOs) {
				String key = tickDO.getId_sch();
				if (tickMap.containsKey(key)) {
					tickMap.get(key).add(tickDO);
				} else {
					List<ScSchTickDO> temp = new ArrayList<ScSchTickDO>();
					temp.add(tickDO);
					tickMap.put(key, temp);
				}
			}
		}
		Map<String, Map<Integer,Integer>> apptMap = new HashMap<String, Map<Integer,Integer>>();
		for (ScSchDO schDO : schDOs) {
			String key = schDO.getId_sch();
			if (apptMap.containsKey(key)) {
				continue;
			}
			apptMap.put(key, this.calcChlApptAmount(schDO, tickMap, chlPolcnMap,id_enttp, id_scchl));
		}
		return apptMap;
	}

	/**
	 * 计算指定渠道的可预约数
	 * 
	 * @author zhengcm
	 *
	 * @param schDO
	 * @param tickMap
	 * @param chlPolcnMap
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	private Map<Integer,Integer> calcChlApptAmount(ScSchDO schDO, Map<String, List<ScSchTickDO>> tickMap,
			Map<String, List<ScSchChlDO>> chlPolcnMap, String id_enttp,String id_scchl) throws BizException {
		Map<Integer,Integer> result = new HashMap<Integer,Integer>();
		String key = schDO.getId_sch();
		List<ScSchChlDO> polcnList = chlPolcnMap.containsKey(key) ? chlPolcnMap.get(key) : null;
		// 剩余可预约数
		int remain = schDO.getQuan_total_appt() - schDO.getQuan_total_used();
		List<ScSchChlDO> scSchChlList = new ArrayList<ScSchChlDO>();
		//FIXME 过滤就诊类型
		if(!StringUtil.isEmpty(id_enttp)){
			FBoolean fg_setentp = schDO.getFg_setentp() == null?FBoolean.FALSE:schDO.getFg_setentp();
			if (fg_setentp.booleanValue()) {
				for (ScSchChlDO scSchChlDO : polcnList) {
					if(!StringUtil.isEmpty(scSchChlDO.getId_entp()) && scSchChlDO.getId_entp().contains(id_enttp)){
						scSchChlList.add(scSchChlDO);
					}
				}
				if(!ListUtil.isEmpty(scSchChlList)){
					polcnList.clear();
					polcnList.addAll(scSchChlList);
				}
			}
		}
		if (StringUtil.isEmptyWithTrim(id_scchl)) {
			result.put(IScDictCodeConst.SC_CHL_REMAIN, remain);
			return result;
		}
		if(!ListUtil.isEmpty(polcnList)){
			remain = 0;
			for (ScSchChlDO polcn : polcnList) {
				int polcnRemain = (schDO.getAttrVal("Quan" + polcn.getScpolcn() + "_appt") == null ? 0
						: (int) schDO.getAttrVal("Quan" + polcn.getScpolcn() + "_appt"))
						- (schDO.getAttrVal("Quan" + polcn.getScpolcn() + "_used") == null ? 0
								: (int) schDO.getAttrVal("Quan" + polcn.getScpolcn() + "_used"));
				result.put(polcn.getScpolcn(), polcnRemain);
				remain += polcnRemain;
			}
		}
		
		// 减去同号源池且不包含本渠道的号位数量
		List<ScSchTickDO> tickList = tickMap.get(key);
		if (ListUtil.isEmpty(tickList)) {
			result.put(IScDictCodeConst.SC_CHL_REMAIN, remain);
			return result;
		}
		for (ScSchChlDO polcn : polcnList) {
			for (ScSchTickDO tickDO : tickList) {
				if (null != tickDO.getPolno() && tickDO.getPolno() == polcn.getScpolcn() && !tickDO.getIds_scchl().contains(id_scchl)) {
					remain = remain - 1;
				}
			}
		}
		result.put(IScDictCodeConst.SC_CHL_REMAIN, remain);
		return result;
	}
}
