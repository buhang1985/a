package iih.sc.apt.s.bp.oral;

import iih.sc.apt.dto.d.AptOralDTO;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.scsch.d.ScschAggDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;

/**
 * 设置口腔预约号源池剩余数量BP
 * 
 * @author zhengcm
 * @date 2016-11-23 19:46:41
 *
 */
public class SetOralAptQuanCanUseBP {

	/**
	 * 设置口腔预约号源池剩余数量
	 *
	 * @param oralAptDTOList
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(List<AptOralDTO> oralAptDTOList) throws BizException {
		if (ListUtil.isEmpty(oralAptDTOList)) {
			return;
		}

		// 1、获取排班PK
		List<String> ids = this.getSchIdList(oralAptDTOList);

		// 2、查询排班数据
		ScschAggDO[] aggDOs = this.getAllSchAggDOs(ids);

		// 3、转换排班数据
		Map<String, ScschAggDO> map = this.processAggDO(aggDOs);

		// 4、计算排班的号源池剩余数量
		this.setQuanCanUse(oralAptDTOList, map);
	}

	/**
	 * 获取排班PK
	 *
	 * @param oralAptDTOList
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> getSchIdList(List<AptOralDTO> oralAptDTOList) throws BizException {
		if (ListUtil.isEmpty(oralAptDTOList)) {
			return null;
		}
		List<String> ids = new ArrayList<String>();
		for (AptOralDTO dto : oralAptDTOList) {
			String id_sch = dto.getId_sch();
			if (!ids.contains(id_sch)) {
				ids.add(id_sch);
			}
		}
		return ids;
	}

	/**
	 * 查询所有排班
	 *
	 * @param ids
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScschAggDO[] getAllSchAggDOs(List<String> ids) throws BizException {
		if (ListUtil.isEmpty(ids)) {
			return null;
		}
		return new OralAptEP().getSchAggDOs(ScSqlUtils.getInSqlByIds("id_sch", ids));
	}

	/**
	 * 转换排班数据
	 *
	 * @param aggDOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, ScschAggDO> processAggDO(ScschAggDO[] aggDOs) throws BizException {
		if (ArrayUtil.isEmpty(aggDOs)) {
			return null;
		}
		Map<String, ScschAggDO> map = new HashMap<String, ScschAggDO>();
		for (ScschAggDO aggDO : aggDOs) {
			String key = aggDO.getParentDO().getId_sch();
			if (!map.containsKey(key)) {
				map.put(key, aggDO);
			}
		}
		return map;
	}

	/**
	 * 设置排班号源剩余数量
	 *
	 * @param oralAptDTOList
	 * @param map
	 * @throws BizException
	 * @author zhengcm
	 */
	private void setQuanCanUse(List<AptOralDTO> oralAptDTOList, Map<String, ScschAggDO> map)
			throws BizException {
		if (ListUtil.isEmpty(oralAptDTOList) || null == map || map.isEmpty()) {
			return;
		}
		for (AptOralDTO dto : oralAptDTOList) {
			String id_sch = dto.getId_sch();
			String id_scchl = dto.getId_scchl();
			ScschAggDO aggDO = map.get(id_sch);
			dto.setQuan_can_appt(new OralAptEP().calSchQuanCanUse(aggDO, id_scchl));
		}
	}
}
