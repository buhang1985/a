package iih.sc.comm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;

/**
 * 推荐号源标识
 * @author ltf
 *
 */
public class ProcSuggResBp {

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
		Iterator<RegResDTO> iterator = resList.iterator();
		while (iterator.hasNext()) {
			RegResDTO resDTO = iterator.next();
			resDTO.setRemain(resDTO.getTotal() - resDTO.getUsed());
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
	 * 排班资源排序
	 * 
	 * @param resList
	 */
	private void sortRes(List<RegResDTO> resList){
		Collections.sort(resList, new Comparator<RegResDTO>(){
			@Override
			public int compare(RegResDTO o1, RegResDTO o2) {
					//同一天相同科室和日期分组按剩余号倒序排列
				if(o1.getD_sch().equals(o2.getD_sch()) && o1.getId_dep().equals(o2.getId_dep()) && o1.getId_dayslot().equals(o2.getId_dayslot())) {
					int res = o2.getRemain() - o1.getRemain();
					if(res > 0)
						return 1;
					if(res < 0)
						return -1;
				}
					return 0;
			}
		});
	}
}
