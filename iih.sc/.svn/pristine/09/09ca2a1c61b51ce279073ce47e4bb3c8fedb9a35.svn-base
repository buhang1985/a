package iih.sc.scp.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.i.IScpltickCudService;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.i.IScplticksCudService;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekCudService;
import iih.sc.scp.scplweek.i.IScplweekMDOCudService;
import iih.sc.scp.scplweek.i.IScplweekRService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.concurrent.ConcurrentUtils;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 批量调整计划
 * @author zhouliming
 *
 */
public class ReplaceScPlanWeekBP {
	/**
	 * 批量调整计划
	 * @param coverBool 是否覆盖
	 * @param list 勾选的位置集合 
	 * @param map 已存在的数据
	 * @param weekDO 要复制的源DO
	 * @param Sd_tickmd 票号模式
	 * @throws BizException
	 * @throws ParseException 
	 */
	public void exec(String coverBool,List list,Map map,ScPlanWeekDO weekDO,String Sd_tickmd) throws BizException{
		if(CollectionUtils.isEmpty(list) || map == null || weekDO == null || Sd_tickmd == null) return;
		//克隆周计划aggDO
		ScplweekAggDO[] scplweekAggDOs = cloneWeekAggDO(weekDO.getId_scplweek(),coverBool,list,map);
		if(scplweekAggDOs == null) return;
		
//		复制号位或号段
		// 号段
		List<ScPlanWeekTicksDO> scPlTicksList = new ArrayList<ScPlanWeekTicksDO>();
		// 号位
		List<ScPlanWeekTickDO> scPlTickList = new ArrayList<ScPlanWeekTickDO>();
		SavePlanWeekBP bp = new SavePlanWeekBP();
		String id_scplweek = weekDO.getId_scplweek();//周计划id
		
		if (Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICK)) {// 号位模式
			IScpltickCudService ticksrv = ServiceFinder.find(IScpltickCudService.class);
			DelScPlWeekTickBP ep = new DelScPlWeekTickBP();
			for(ScplweekAggDO scplweekAggDO : scplweekAggDOs){
				ScPlanWeekDO scPlanWeekDo = scplweekAggDO.getParentDO();
				bp.planToTick(scPlanWeekDo, scPlTickList);
				// 保存号位
				if (scPlTickList.size() > 0) {
					ep.exec(scPlanWeekDo.getId_scplweek());//删除旧数据
					ticksrv.save(scPlTickList.toArray(new ScPlanWeekTickDO[0]));//保存新数据
				}
			}
		}else if(Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICKS)){// 号段模式
			IScplticksCudService tickssrv = ServiceFinder.find(IScplticksCudService.class);
			DelScPlWeekTicksBP ep = new DelScPlWeekTicksBP();
			for(ScplweekAggDO scplweekAggDO : scplweekAggDOs){
				ScPlanWeekDO scPlanWeekDo = scplweekAggDO.getParentDO();
				bp.planToTicks(scPlanWeekDo, scPlTicksList);
				// 保存号段
				ScPlanWeekTicksDO[] ticksDOs = scPlTicksList.toArray(new ScPlanWeekTicksDO[0]);
				if (scPlTicksList.size() > 0) {
					ep.exec(scPlanWeekDo.getId_scplweek());//删除旧数据
					tickssrv.save(ticksDOs);//保存新数据
				}
			}
		}
	}
	/**
	 * 批量克隆周计划
	 * @param id_scplweek 被克隆的周计划id
	 * @param coverBool 是否覆盖标志
	 * @param list 勾选的位置集合 
	 * @param map 已存在的数据
	 * @return ScplweekAggDO
	 * @throws BizException
	 */
	public ScplweekAggDO[] cloneWeekAggDO(String id_scplweek,String coverBool,List list,Map map) throws BizException{
		if(StringUtils.isBlank(id_scplweek) || list == null || list.size() == 0) return null;
		List<ScplweekAggDO> weekSaveAggDOList = new ArrayList<ScplweekAggDO>();
		
		IScplweekRService weekService  = ServiceFinder.find(IScplweekRService.class);
		IScplweekCudService aggser = ServiceFinder.find(IScplweekCudService.class);
		ScplweekAggDO scplweekAggDO = weekService.findById(id_scplweek);
		if(scplweekAggDO == null) return null;
		
		if("Y".equals(coverBool)){
			List delDOList  = new ArrayList();
			for(int i = 0; i < list.size(); i++){
				String str = (String)list.get(i);
				if(map.containsKey(str)){
					delDOList.add(map.get(str));
				}
				String[] dayslots = str.split("_");
				String dayslotid = dayslots[0];
				int weeknewno = Integer.parseInt(dayslots[1]);
				
				ScplweekAggDO copyAggDO = cloneWeekAggDO(scplweekAggDO,dayslotid,weeknewno);
				weekSaveAggDOList.add(copyAggDO);
			}
			ScplweekAggDO[] weekDelDOs = new ScplweekAggDO[delDOList.size()];
			delDOList.toArray(weekDelDOs);
			aggser.delete(weekDelDOs);
		}else{
			for(int i=0;i<list.size();i++){
				String str = (String)list.get(i);
				if(!map.containsKey(str)){
					String[] dayslots = str.split("_");
					String dayslotid = dayslots[0];
					int weeknewno = Integer.parseInt(dayslots[1]);
					ScplweekAggDO copyAggDO = cloneWeekAggDO(scplweekAggDO,dayslotid,weeknewno);
					weekSaveAggDOList.add(copyAggDO);
				}
			}
		}
		ScplweekAggDO[] weekAggDOSave = new ScplweekAggDO[weekSaveAggDOList.size()];
		weekSaveAggDOList.toArray(weekAggDOSave);
		weekAggDOSave = aggser.save(weekAggDOSave);
		
		return weekAggDOSave;
	}
	/**
	 * 单一克隆周计划
	 * @param scplweekAggDO 被克隆的源aggDO
	 * @param dayslotid 午别
	 * @param weeknewno 周期数
	 * @return ScplweekAggDO
	 */
	public ScplweekAggDO cloneWeekAggDO(ScplweekAggDO scplweekAggDO, String dayslotid, int weeknewno){
		if(scplweekAggDO == null || StringUtils.isBlank(dayslotid)) return null;
		
		ScplweekAggDO copyAggDO = (ScplweekAggDO) scplweekAggDO.clone();//克隆aggDO数据
		copyAggDO.getParentDO().setId_dayslot(dayslotid);
		copyAggDO.getParentDO().setWeekno(weeknewno);
		copyAggDO.getParentDO().setStatus(DOStatus.NEW);
		copyAggDO.getParent().setPkVal(null);//主键清空
		
		if (copyAggDO.getAllChildrenDO() != null && copyAggDO.getAllChildrenDO().length > 0) {
			for (BaseDO baseDO : copyAggDO.getAllChildrenDO()) {
				baseDO.setStatus(DOStatus.NEW);
				baseDO.setPkVal(null);//主键清空
			}
		}
		return copyAggDO;
	}
}
