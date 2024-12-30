package iih.sc.scp.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.d.desc.ScPlanWeekTickDODesc;
import iih.sc.scp.scpltick.i.IScpltickCudService;
import iih.sc.scp.scpltick.i.IScpltickRService;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.d.desc.ScPlanWeekTicksDODesc;
import iih.sc.scp.scplticks.i.IScplticksCudService;
import iih.sc.scp.scplticks.i.IScplticksRService;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekCudService;
import iih.sc.scp.scplweek.i.IScplweekRService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

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
public class ReplaceScPlanMtWeekBP {
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
	public void exec(String coverBool,List list,ScplweekAggDO[] aggDOs,ScPlanWeekDO weekDO,String Sd_tickmd) throws BizException{
		if(CollectionUtils.isEmpty(list) || weekDO == null || Sd_tickmd == null) return;
		
		//删除周计划
		if("Y".equals(coverBool) && aggDOs != null && aggDOs.length > 0){
			delScplWeek(aggDOs,Sd_tickmd);
		}
		
		//克隆周计划aggDO
		ScplweekAggDO[] scplweekAggDOs = cloneWeekAggDO(aggDOs,weekDO.getId_scplweek(),coverBool,list);
		if(scplweekAggDOs == null) return;
		
		//复制号位或号段
		copyWeekTickOrTicks(scplweekAggDOs,weekDO,Sd_tickmd);
	}
	
	/**
	 * 删除周计划aggDOs
	 * @param aggDOs
	 * @param Sd_tickmd
	 * @throws BizException
	 */
	public void delScplWeek(ScplweekAggDO[] aggDOs,String Sd_tickmd) throws BizException{
		StringBuffer id_scplweek = new StringBuffer();
		id_scplweek.append("(");
		for(int i = 0; i < aggDOs.length; i++){
			id_scplweek.append("'"+aggDOs[i].getParentDO().getId_scplweek()+"',");
		}
		String scplweek = id_scplweek.substring(0,id_scplweek.length()-1);
		scplweek = scplweek+")";
			
		//删除aggDOs
		IScplweekCudService service = ServiceFinder.find(IScplweekCudService.class);
		service.delete(aggDOs);
		
		//删除号位或号段
		DelScPlTickOrTicksBp bp = new DelScPlTickOrTicksBp();
		bp.exec(scplweek, Sd_tickmd);
	}
	
	/**
	 * 保存新增数据的号位或号段
	 * @param aggDOs
	 * @param weekDO
	 * @param Sd_tickmd
	 * @throws BizException
	 */
	public void copyWeekTickOrTicks(ScplweekAggDO[] aggDOs,ScPlanWeekDO weekDO,String Sd_tickmd) throws BizException{
		if (Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICK)) {
			// 号位模式
			IScpltickRService tickRSrv = ServiceFinder.find(IScpltickRService.class);
			String sql = String.format("%s.id_scplweek = '%s'", ScPlanWeekTickDODesc.TABLE_ALIAS_NAME,weekDO.getId_scplweek());
			ScPlanWeekTickDO[] tickDOs = tickRSrv.find(sql, "", FBoolean.TRUE);
			if(ArrayUtils.isNotEmpty(tickDOs)){
				ArrayList<ScPlanWeekTickDO> arrayList = new ArrayList<ScPlanWeekTickDO>();
				for(ScplweekAggDO aggDO:aggDOs){
					String id_scplweek = aggDO.getParentDO().getId_scplweek();
					for(ScPlanWeekTickDO tickDO: tickDOs){
						tickDO.setId_scplweek(id_scplweek);
						tickDO.setId_tick(null);
						tickDO.setStatus(DOStatus.NEW);
						arrayList.add(tickDO);
					}
				}
				IScpltickCudService tickCudSrv = ServiceFinder.find(IScpltickCudService.class);
				tickCudSrv.save(arrayList.toArray(new ScPlanWeekTickDO[arrayList.size()]));
			}
		}else if(Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICKS)){
			// 号段模式
			IScplticksRService ticksRSrv = ServiceFinder.find(IScplticksRService.class);
			String sql = String.format("%s.id_scplweek = '%s'", ScPlanWeekTicksDODesc.TABLE_ALIAS_NAME,weekDO.getId_scplweek());
			ScPlanWeekTicksDO[] ticksDOs = ticksRSrv.find(sql, "", FBoolean.TRUE);
			if(ArrayUtils.isNotEmpty(ticksDOs)){
				ArrayList<ScPlanWeekTicksDO> arrayList = new ArrayList<ScPlanWeekTicksDO>();
				for(ScplweekAggDO aggDO:aggDOs){
					String id_scplweek = aggDO.getParentDO().getId_scplweek();
					for(ScPlanWeekTicksDO ticksDO: ticksDOs){
						ticksDO.setId_scplweek(id_scplweek);
						ticksDO.setId_ticks(null);
						ticksDO.setStatus(DOStatus.NEW);
						arrayList.add(ticksDO);
					}
				}
				IScplticksCudService ticksCudSrv = ServiceFinder.find(IScplticksCudService.class);
				ticksCudSrv.save(arrayList.toArray(new ScPlanWeekTicksDO[arrayList.size()]));
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
	public ScplweekAggDO[] cloneWeekAggDO(ScplweekAggDO[] aggDOs,String id_scplweek,String coverBool,List list) throws BizException{
		if(StringUtils.isBlank(id_scplweek) || list == null || list.size() == 0) return null;
		List<ScplweekAggDO> weekSaveAggDOList = new ArrayList<ScplweekAggDO>();
		
		IScplweekRService weekService  = ServiceFinder.find(IScplweekRService.class);
		IScplweekCudService aggser = ServiceFinder.find(IScplweekCudService.class);
		ScplweekAggDO scplweekAggDO = weekService.findById(id_scplweek);
		if(scplweekAggDO == null) return null;
		Map map = getWeekAndIdx(aggDOs);
		
		//若不覆盖移除map中含有的list值
		if("N".equals(coverBool)){//不覆盖
			if(map != null){
				for(int i = 0; i < list.size(); i++){
					String str = (String)list.get(i);
					if(map.containsKey(str)){
						list.remove(list.get(i));
					}
				}
			}
		}
		//复制数据
		for(int i = 0; i < list.size(); i++){
			String str = (String)list.get(i);
			String[] dayslots = str.split("_");
			String dayslotid = dayslots[0];
			int weeknewno = Integer.parseInt(dayslots[1]);
			int idx_week = Integer.parseInt(dayslots[2]);
			ScplweekAggDO copyAggDO = cloneWeekAggDO(scplweekAggDO,dayslotid,weeknewno,idx_week);
			weekSaveAggDOList.add(copyAggDO);
		} 
		ScplweekAggDO[] weekAggDOSave = new ScplweekAggDO[weekSaveAggDOList.size()];
		weekSaveAggDOList.toArray(weekAggDOSave);
		return aggser.save(weekAggDOSave);
	}
	/**
	 * 单一克隆周计划
	 * @param scplweekAggDO 被克隆的源aggDO
	 * @param dayslotid 午别
	 * @param weeknewno 周期数
	 * @return ScplweekAggDO
	 */
	public ScplweekAggDO cloneWeekAggDO(ScplweekAggDO scplweekAggDO, String dayslotid, int weeknewno,int idx_week){
		if(scplweekAggDO == null || StringUtils.isBlank(dayslotid)) return null;
		
		ScplweekAggDO copyAggDO = (ScplweekAggDO) scplweekAggDO.clone();//克隆aggDO数据
		copyAggDO.getParentDO().setId_dayslot(dayslotid);
		copyAggDO.getParentDO().setWeekno(weeknewno);
		copyAggDO.getParentDO().setIdx_week(idx_week);		
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

	/**
	 * 获取aggdo的星期数+周数Map
	 * @param aggDOs
	 * @return
	 */
	public Map getWeekAndIdx(ScplweekAggDO[] aggDOs){
		if(aggDOs == null || aggDOs.length == 0) return null;
		
		Map map = new HashMap();
		for(int i = 0; i < aggDOs.length; i++){
			Integer weekno = aggDOs[i].getParentDO().getWeekno();
			Integer idx_week = aggDOs[i].getParentDO().getIdx_week();
			String id_dayslot = aggDOs[i].getParentDO().getId_dayslot();
			map.put(id_dayslot+"_"+weekno+"_"+idx_week, "");
		}
		return map;
	}
}
