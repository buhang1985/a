package iih.sc.sch.s.task.bp.overduetick;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 处理门诊过期排班号源
 * 
 * @author liubin
 *
 */
public class HandleOpOverdueTickBP {
	/**
	 * 执行任务
	 * @param schId 排班id
	 * @param isCrossDay 是否跨天
	 * @param dayslotId 跨天午别id
	 * @param map
	 * @throws BizException
	 */
	public void exec(String schId,boolean isCrossDay,String dayslotId) throws BizException {
		if(ScValidator.isEmptyIgnoreBlank(schId))
			return;
		//需要过期处理的号位
		List<ScSchTickDO> tickList = new ArrayList<ScSchTickDO>();
		Map<Integer, Integer> polnoMap = initPolnoMap();// key:号源池-value：指定号源池数量
		Map<String, Integer> ticksMap = new HashMap<String,Integer>();//key:号段-value：号段数量
		//初始化数据
		init(schId, tickList, polnoMap, ticksMap,isCrossDay,dayslotId);
		//排班-号位处理
		handleTickAndSch(schId, tickList, polnoMap);
		//号段处理
		handleTicks(ticksMap);
	}
	/**
	 * 初始化号源池和指定号源池数量
	 * 
	 * @return
	 */
	private Map<Integer,Integer> initPolnoMap(){
		Map<Integer,Integer> polnoMap = new HashMap<Integer,Integer>();
		for(int i=0; i<=9; i++)
			polnoMap.put(i, 0);
		return polnoMap;
	}
	/**
	 * 初始化数据
	 * 
	 * @param schId
	 * @param tickList
	 * @param polnoMap
	 * @param ticksMap
	 * @throws BizException
	 */
	private void init(String schId, List<ScSchTickDO> tickList, Map<Integer, Integer> polnoMap, Map<String, Integer> ticksMap,boolean isCrossDay,String dayslotId) throws BizException{
		TickEP tickEP = new TickEP();
		String cond = String.format("Id_sch = '%s' and fg_active = 'Y' and eu_used = '%s' and Eu_usescope = '%s'", schId, EuUseState.WY, EuUseScope.APT);
		ScSchTickDO[] scSchTickDOs = tickEP.getTickByCond(cond, "queno");
		if(ArrayUtil.isEmpty(scSchTickDOs))
			return;
		FDateTime now = ScAppUtils.getServerDateTime();
		if(isCrossDay){
			ScSchDO sch = new SchEP().getById(schId);
			DaysLotDO dayslotDO = (DaysLotDO) new DAFacade().findByPK(DaysLotDO.class, 
					sch.getId_dayslot(), new String[]{DaysLotDO.ID_DAYSLOT, DaysLotDO.TIME_BEGIN,DaysLotDO.TIME_END});
			for(ScSchTickDO scSchTickDO : scSchTickDOs){
				if(scSchTickDO.getPolno() != null)
					polnoMap.put(scSchTickDO.getPolno(), polnoMap.get(scSchTickDO.getPolno()) + 1);
				if(scSchTickDO.getT_e().compareTo(dayslotDO.getTime_begin()) > 0 || (scSchTickDO.getT_e().compareTo(dayslotDO.getTime_begin()) < 0 && scSchTickDO.getT_e().compareTo(now.getUFTime()) <= 0)){
					tickList.add(scSchTickDO);
					if(ScValidator.isNotEmptyIgnoreBlank(scSchTickDO.getId_ticks())){
						if(ticksMap.containsKey(scSchTickDO.getId_ticks())){
							ticksMap.put(scSchTickDO.getId_ticks(), ticksMap.get(scSchTickDO.getId_ticks()) + 1);
						}else{
							ticksMap.put(scSchTickDO.getId_ticks(), 1);
						}
					}
				}
			}
		}else{
			ScSchDO sch = new SchEP().getById(schId);
			if(!StringUtil.isEmpty(dayslotId) && dayslotId.equals(sch.getId_dayslot())){
				DaysLotDO dayslotDO = (DaysLotDO) new DAFacade().findByPK(DaysLotDO.class, 
						sch.getId_dayslot(), new String[]{DaysLotDO.ID_DAYSLOT, DaysLotDO.TIME_BEGIN,DaysLotDO.TIME_END});
				for(ScSchTickDO scSchTickDO : scSchTickDOs){
					if(scSchTickDO.getPolno() != null)
						polnoMap.put(scSchTickDO.getPolno(), polnoMap.get(scSchTickDO.getPolno()) + 1);
					if(scSchTickDO.getT_e().compareTo(dayslotDO.getTime_begin()) > 0 && scSchTickDO.getT_e().compareTo(now.getUFTime()) < 0){
						tickList.add(scSchTickDO);
						if(ScValidator.isNotEmptyIgnoreBlank(scSchTickDO.getId_ticks())){
							if(ticksMap.containsKey(scSchTickDO.getId_ticks())){
								ticksMap.put(scSchTickDO.getId_ticks(), ticksMap.get(scSchTickDO.getId_ticks()) + 1);
							}else{
								ticksMap.put(scSchTickDO.getId_ticks(), 1);
							}
						}
					}
				}
			}else{
				for(ScSchTickDO scSchTickDO : scSchTickDOs){
					if(scSchTickDO.getPolno() != null)
						polnoMap.put(scSchTickDO.getPolno(), polnoMap.get(scSchTickDO.getPolno()) + 1);
					if(scSchTickDO.getT_e().compareTo(now.getUFTime()) < 0){
						tickList.add(scSchTickDO);
						if(ScValidator.isNotEmptyIgnoreBlank(scSchTickDO.getId_ticks())){
							if(ticksMap.containsKey(scSchTickDO.getId_ticks())){
								ticksMap.put(scSchTickDO.getId_ticks(), ticksMap.get(scSchTickDO.getId_ticks()) + 1);
							}else{
								ticksMap.put(scSchTickDO.getId_ticks(), 1);
							}
						}
					}
				}
			}
			
		}
		
	}
	/**
	 * 排班和号位处理
	 * 
	 * @param schId
	 * @param tickList
	 * @param polnoMap
	 * @throws BizException
	 */
	private void handleTickAndSch(String schId, List<ScSchTickDO> tickList, Map<Integer, Integer> polnoMap) throws BizException {
		if(ListUtil.isEmpty(tickList))
			return;
		SchEP schEP = new SchEP();
		TickEP tickEP = new TickEP();
		ScSchDO scSchDO = schEP.getByPK(schId);
		scSchDO.setStatus(DOStatus.UPDATED);
		
		for(ScSchTickDO tick : tickList){
			tick.setStatus(DOStatus.UPDATED);
			tick.setEu_used(EuUseState.GQ);
			scSchDO.setQuan_total_used(scSchDO.getQuan_total_used() + 1);// 排班使用数+1
			if(tick.getPolno()!=null){
				Integer polno = tick.getPolno();
				String usedName = String.format("Quan%s_used", polno);// 号源池i_已用
				scSchDO.setAttrVal(usedName, (Integer)scSchDO.getAttrVal(usedName) + 1);//更新排班号源池使用数
				tick.setPolno_used(polno);
				polnoMap.put(polno, polnoMap.get(polno) -1);
			}else{
				Integer polno = getUsePolno(scSchDO, polnoMap);
				String usedName = String.format("Quan%s_used", polno);// 号源池i_已用
				scSchDO.setAttrVal(usedName, (Integer)scSchDO.getAttrVal(usedName) + 1);//更新排班号源池使用数
				tick.setPolno_used(polno);
			}
		}
		schEP.save(new ScSchDO[] {scSchDO});
		tickEP.save(tickList.toArray(new ScSchTickDO[0]));
	}
	/**
	 * 获取使用的号源池
	 * 
	 * @param scSchDO
	 * @param polnoMap
	 * @return
	 */
	private Integer getUsePolno(ScSchDO scSchDO, Map<Integer, Integer> polnoMap) throws BizException{
		Integer res = null;
		for (int i = 0; i <= 9; i++) {
			String apptName = "Quan" + i + "_appt";
			String apptUsed = "Quan" + i + "_used";
			Integer remain  = (Integer) scSchDO.getAttrVal(apptName) - (Integer) scSchDO.getAttrVal(apptUsed) - polnoMap.get(i) ;//号源池剩余可减数
			if (remain > 0) {
				res = i;
				break;
			}
		}
		if(res == null)
			throw new BizException("获取可使用号源池失败！");
		return res;
	}
	/**
	 * 号段处理
	 * 
	 * @param ticksMap
	 * @throws BizException
	 */
	private void handleTicks(Map<String, Integer> ticksMap) throws BizException {
		if(ticksMap == null || ticksMap.size() <= 0)
			return;
		TicksEP ticksEP = new TicksEP();
		IScticksRService serv = ServiceFinder.find(IScticksRService.class);
		ScSchTicksDO[] scSchTicksDOs = serv.findByIds(ticksMap.keySet().toArray(new String[0]), FBoolean.FALSE);
		if(ArrayUtil.isEmpty(scSchTicksDOs))
			return;
		for(ScSchTicksDO scSchTicksDO : scSchTicksDOs){
			if(ticksMap.containsKey(scSchTicksDO.getId_ticks())){
				scSchTicksDO.setQuecn_used(scSchTicksDO.getQuecn_used() + ticksMap.get(scSchTicksDO.getId_ticks()));// 使用数减少
				scSchTicksDO.setFg_used(new FBoolean(scSchTicksDO.getQuecn_used() >= scSchTicksDO.getQuecn()));// 是否用尽
				scSchTicksDO.setStatus(DOStatus.UPDATED);
			}
		}
		ticksEP.save(scSchTicksDOs);
	}
}
