package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.MtSchDTO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.i.IScplweekMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 查找周对应的周计划
 * 
 * @author renying
 */
public class GetMtSchWkPlsBP {
	/**
	 * 查找周对应的周计划
	 * 
	 * @param idx_week
	 * @return
	 * @throws BizException
	 */
	public MtSchDTO[] exec(String scplId, Integer idx_week) throws BizException {
		// 1.校验参数
		ScValidator.validateParam("scplId", scplId);
		ScValidator.validateParam("idx_week", idx_week);
		// 2.调用服务查找对应的周计划
		List<MtSchDTO> list = this.getMtSchWkPls(scplId, idx_week);
		// 3.组装成前台所需的dto
		if(ListUtil.isEmpty(list))
			return null;
		return list.toArray(new MtSchDTO[]{});
	}

	/**
	 * 2.调用服务查找对应的周计划
	 * 
	 * @param scplId
	 * @param idx_week
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<MtSchDTO> getMtSchWkPls(String scplId, Integer idx_week) throws BizException {
		IScplweekMDORService rservice = ServiceFinder.find(IScplweekMDORService.class);
		ScPlanWeekDO[] scPlWeeks = rservice.find("id_scpl = '" + scplId + "'and  idx_week ='" + idx_week + "'", "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(scPlWeeks)) {
			throw new BizException("未找到该计划对应的第" + idx_week + "周周计划");
		}
		List<MtSchDTO> dtoList = new ArrayList<MtSchDTO>();
		Map<Integer, List<ScPlanWeekDO>> map = this.getSchMap(scPlWeeks);
		for (Entry<Integer, List<ScPlanWeekDO>> entry : map.entrySet()) {
			MtSchDTO mtschDTO = new MtSchDTO();
			FArrayList flist = new FArrayList();
			flist.addAll(entry.getValue());
			mtschDTO.setPlweeks(flist);
			mtschDTO.setWeekno(entry.getKey());
			dtoList.add(mtschDTO);
		}
		return dtoList;
	}

	/**
	 * 按照天对周计划分类
	 * @param scPlWeeks
	 */
	private Map<Integer, List<ScPlanWeekDO>>  getSchMap(ScPlanWeekDO[] scPlWeeks) {
		Map<Integer, List<ScPlanWeekDO>> map = new HashMap<Integer, List<ScPlanWeekDO>>();
		for (ScPlanWeekDO plWkDO : scPlWeeks) {
			if (map.containsKey(plWkDO.getWeekno())) {
				map.get(plWkDO.getWeekno()).add(plWkDO);
			}else{
				List<ScPlanWeekDO> list = new ArrayList<ScPlanWeekDO>();
				list.add(plWkDO);
				map.put(plWkDO.getWeekno(), list);
			}
		}
		return map;
	}
}
