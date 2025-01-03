package iih.sc.sch.s.bp.oral;

import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 批量获取排班的渠道和号位信息
 * @author Sarah
 *
 */
public class GetOralSchsDetailsBP {

	public SchOralInfoDTO[]  exec (SchOralInfoDTO[] orals) throws BizException {
		if(ArrayUtil.isEmpty(orals)){
			return orals;
		}	
		//1.获取查询条件
		String where = this.getWherePart(orals);
		//2、查询排班号位数据
		ScSchTickDO[] schTickDOs = this.getSchTickByCond(where);
		//3、查询排班渠道数据
		ScSchChlDO[] schChlDOs = this.getSchChlByCond(where);
		//4、获取号位的map
		Map<String,FArrayList> tickMap = this.setTickMap(schTickDOs);
		//5、获取渠道的map
		Map<String,FArrayList>  chlMap = this.SetChlValue(schChlDOs);
		//6、设置值到dto
		this.SetValue(orals, tickMap, chlMap);
		return orals;
	}
	
	/**
	 * 设置值到dto
	 * @param orals
	 * @param tickMap
	 * @param chlMap
	 */
	private void SetValue(SchOralInfoDTO[] orals,Map<String,FArrayList> tickMap,Map<String,FArrayList>  chlMap ){
		for(SchOralInfoDTO oral :orals){
			oral.setSch_chl_list(chlMap.get(oral.getId_sch()));
			oral.setSch_tick_list(tickMap.get(oral.getId_sch()));
		}
	}
	
	
	/**
	 * 设置号位
	 * @param schTickDOs
	 * @param orals
	 */
	private Map<String,FArrayList>  setTickMap(ScSchTickDO[] schTickDOs){
		Map<String,FArrayList> map = new HashMap<>();
		if(ArrayUtil.isEmpty(schTickDOs)){
			return map;
		}
		for(ScSchTickDO tickDO :schTickDOs){
			if(map.containsKey(tickDO.getId_sch())){
				map.get(tickDO.getId_sch()).add(tickDO);
			}else{
				FArrayList list = new FArrayList();
				list.add(tickDO);
				map.put(tickDO.getId_sch(), list);
			}
		}
		return map;
	}				
	
	/**
	 * 设置号段
	 * @param schChlDOs
	 * @param orals
	 */
	private Map<String,FArrayList>  SetChlValue(ScSchChlDO[] schChlDOs){
		Map<String,FArrayList> map = new HashMap<>();
		if(ArrayUtil.isEmpty(schChlDOs)){
			return map;
		}
		for(ScSchChlDO chlDO :schChlDOs){
			if(map.containsKey(chlDO.getId_sch())){
				map.get(chlDO.getId_sch()).add(chlDO);
			}else{
				FArrayList list = new FArrayList();
				list.add(chlDO);
				map.put(chlDO.getId_sch(), list);
			}
		}
		return map;
	}
	
	/**
	 * 根据条件获取排班号位
	 *
	 * @param where 查询条件
	 * @return 排班号位DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchTickDO[] getSchTickByCond(String where) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		return new OralSchEP().getSchTickByCond(where, "queno", null);
	}

	/**
	 * 根据条件获取排班渠道
	 *
	 * @param where 查询条件
	 * @return 排班渠道DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchChlDO[] getSchChlByCond(String where) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		return new OralSchEP().getSchChlByCond(where, "scpolcn");
	}

	
	/**
	 * 获取排班id
	 * @param orals
	 * @param schIdList
	 */
	private String getWherePart(SchOralInfoDTO[] orals){
		List<String> schIdList = new ArrayList<String>();
		for(SchOralInfoDTO dto:orals){
			if(!StringUtil.isEmpty(dto.getId_sch())){
				schIdList.add(dto.getId_sch());
			}
		}
		if(!ListUtil.isEmpty(schIdList)){
			String strId = ScSqlUtils.buildIdStr(schIdList);
			return "id_sch in ("+ strId+")";
		}
		return null;
	}

}
