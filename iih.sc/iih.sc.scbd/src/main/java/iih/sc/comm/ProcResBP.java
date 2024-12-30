package iih.sc.comm;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 统一处理号源信息
 * 
 * @author liubin
 *
 */
public class ProcResBP {
	/**
	 * 统一处理号源信息
	 * 
	 * @param resList
	 * @param isNeedRemoval 是否去除重复id_sch数据
	 * @return
	 * @throws BizException 
	 */
	public RegResDTO[] exec(List<RegResDTO> resList, boolean isNeedRemoval) throws BizException{
		if(ListUtil.isEmpty(resList)){
			return null;
		}
		if(isNeedRemoval){
			resList = this.removal(resList);
		}
		this.procRes(resList);
		return resList.toArray(new RegResDTO[0]);
	}
	/**
	 * 加工挂号资源
	 * 
	 * @param resList
	 * @throws BizException 
	 */
	private void procRes(List<RegResDTO> resList) throws BizException {
		if (ListUtil.isEmpty(resList)) {
			return;
		}
		Map<String, DaysLotDO> dayslotMap = assemLyDayslotMap(resList);
		Iterator<RegResDTO> iterator = resList.iterator();
		FDateTime nowDateTime = ScAppUtils.getServerDateTime();
		while (iterator.hasNext()) {
			RegResDTO resDTO = iterator.next();
			//超过停止挂号时间，把号源停止标志置上
			resDTO.setFg_stop(new FBoolean(isStopReg(dayslotMap, resDTO, nowDateTime)));
			if(FBoolean.TRUE.equals(resDTO.getFg_stop()) || FBoolean.FALSE.equals(resDTO.getFg_active())){
				resDTO.setName_scpl("(停)" + resDTO.getName_scpl());// 增加停诊标识
			}
			if (FBoolean.FALSE.equals(resDTO.getFg_active())) {
				resDTO.setRemain(0);// 如果已经停诊，剩余号源为0
			} else {
				resDTO.setRemain(resDTO.getTotal() - resDTO.getUsed());
			}
		}
		this.sortRes(resList);
	}
	/**
	 * 去除重复id_sch数据
	 * 
	 * @param resList
	 * @return
	 */
	private List<RegResDTO> removal(List<RegResDTO> resList){
		Map<String,RegResDTO> resMap = new LinkedHashMap<String,RegResDTO>();
		Iterator<RegResDTO> iterator = resList.iterator();
		while(iterator.hasNext()){
			RegResDTO resDTO = iterator.next();
			if(!resMap.containsKey(resDTO.getId_sch())){
				resMap.put(resDTO.getId_sch(), resDTO);
			}else if(resMap.get(resDTO.getId_sch()).getRemain()< resDTO.getRemain()){
				//取剩余数大的资源
				resMap.put(resDTO.getId_sch(), resDTO);
			}
		}
		return new ArrayList<RegResDTO>(resMap.values());
	}
	/**
	 * 
	 * 
	 * @param resList
	 * @return
	 * @throws BizException
	 */
	private Map<String, DaysLotDO> assemLyDayslotMap(List<RegResDTO> resList) throws BizException {
		Set<String> set = new HashSet<String>();
		Map<String, DaysLotDO> map = new HashMap<String, DaysLotDO>();
		for(RegResDTO res : resList)
			set.add(res.getId_dayslot());
		IDayslotMDORService serv = ServiceFinder.find(IDayslotMDORService.class);
		DaysLotDO[] dayslots = serv.findByIds(set.toArray(new String[0]), FBoolean.FALSE);
		if(ArrayUtil.isEmpty(dayslots))
			return null;
		for(DaysLotDO dayslot : dayslots){
			if(!map.containsKey(dayslot.getId_dayslot()))
				map.put(dayslot.getId_dayslot(), dayslot);
		}
		return map;
	}
	/**
	 * 是否停止挂号
	 * 
	 * @param map
	 * @param resDTO
	 * @param nowDateTime
	 * @return
	 */
	private boolean isStopReg(Map<String, DaysLotDO> map, RegResDTO res, FDateTime nowDateTime){
		if(map == null || !map.containsKey(res.getId_dayslot()) || res.getT_e_reg() == null)
			return false;
		DaysLotDO dayslot = map.get(res.getId_dayslot());
		FDateTime endDateTime = new FDateTime(res.getD_sch(), res.getT_e_reg());
		if(dayslot.getTime_begin().after(dayslot.getTime_end()))
			endDateTime = new FDateTime(res.getD_sch().getDateAfter(1), res.getT_e_reg());
		return nowDateTime.after(endDateTime);
	}
	/**
	 * 排班资源排序
	 * 
	 * @param resList
	 */
	private void sortRes(List<RegResDTO> resList){
		Collections.sort(resList, new Comparator<RegResDTO>(){
			@Override
			public int compare(RegResDTO o1, RegResDTO o2) {
				if(FBoolean.TRUE.equals(o1.getFg_stop()) && FBoolean.FALSE.equals(o2.getFg_stop())){
					return 1;
				}else if(FBoolean.TRUE.equals(o2.getFg_stop()) && FBoolean.FALSE.equals(o1.getFg_stop())){
					return -1;
				}else{
					if(o1.getRemain() == 0 && o2.getRemain() != 0)
						return 1;
					else if(o2.getRemain() == 0 && o1.getRemain() != 0)
						return -1;
					//相同科室和日期分组按剩余号倒序排列
					else if(o1.getD_sch().equals(o2.getD_sch()) && o1.getId_dep().equals(o2.getId_dep()) && o1.getId_dayslot().equals(o2.getId_dayslot())) {
						int res = o2.getRemain() - o1.getRemain();
						if(res > 0)
							return 1;
						if(res < 0)
							return -1;
					}
					return 0;
				}
			}
		});
	}
}
