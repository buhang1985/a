package iih.sc.apt.s.bp.oral;

import iih.sc.apt.dto.d.AptOralDTO;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.scsch.d.ScSchDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;

/**
 * 设置口腔预约排班版本BP
 * 
 * @author zhengcm
 * @date 2016-12-26 20:07:40
 *
 */
public class SetOralAptSchVersionBP {

	/**
	 * 设置口腔预约排班版本
	 *
	 * @param dtoList
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(List<AptOralDTO> dtoList) throws BizException {
		if (ListUtil.isEmpty(dtoList)) {
			return;
		}
		// 排班主键
		List<String> schIdList = this.getSchIds(dtoList);

		// 查询排班版本
		Map<String, Integer> verMap = this.getSchVerMap(schIdList);

		// 设置排班版本
		this.setSchVer(dtoList, verMap);
	}

	/**
	 * 获取排班主键
	 *
	 * @param dtoList
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> getSchIds(List<AptOralDTO> dtoList) throws BizException {
		if (ListUtil.isEmpty(dtoList)) {
			return null;
		}
		List<String> ids = new ArrayList<String>();
		for (AptOralDTO dto : dtoList) {
			String schId = dto.getId_sch();
			if (!ids.contains(schId)) {
				ids.add(schId);
			}
		}
		return ids;
	}

	/**
	 * 获取排班版本
	 *
	 * @param ids
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, Integer> getSchVerMap(List<String> ids) throws BizException {
		if (ListUtil.isEmpty(ids)) {
			return null;
		}
		String cond = ScSqlUtils.getInSqlByIds("id_sch", ids);
		ScSchDO[] schDOs = new OralAptEP().getSchByWhere(cond);
		if (ArrayUtil.isEmpty(schDOs)) {
			return null;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (ScSchDO schDO : schDOs) {
			String key = schDO.getId_sch();
			Integer ver = schDO.getVer();
			if (!map.containsKey(key)) {
				map.put(key, ver);
			}
		}
		return map;
	}

	/**
	 * 设置排班版本
	 *
	 * @param dtoList
	 * @param verMap
	 * @throws BizException
	 * @author zhengcm
	 */
	private void setSchVer(List<AptOralDTO> dtoList, Map<String, Integer> verMap)
			throws BizException {
		if (ListUtil.isEmpty(dtoList) || null == verMap || verMap.isEmpty()) {
			return;
		}
		for (AptOralDTO dto : dtoList) {
			String key = dto.getId_sch();
			if (verMap.containsKey(key)) {
				dto.setVer(verMap.get(key));
			}
		}
	}
}
