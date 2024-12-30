package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.sch.i.IScSchOutQryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 计算排班对应渠道剩余可预约数量BP
 * 
 * @author zhengcm
 * @date 2018-04-26 14:11:47
 *
 */
public class CalcSchChlRemainBP {

	/**
	 * 计算排班对应渠道剩余可预约数量
	 * 
	 * @author zhengcm
	 *
	 * @param resDTOList
	 * @throws BizException
	 */
	public void exec(List<MtResDTO> resDTOList) throws BizException {
		if (ListUtil.isEmpty(resDTOList)) {
			return;
		}
		String id_scchl = resDTOList.get(0).getId_scchl();
		List<String> schIdList = new ArrayList<String>();
		for (MtResDTO resDTO : resDTOList) {
			String schId = resDTO.getId_sch();
			if (!schIdList.contains(schId)) {
				schIdList.add(schId);
			}
		}
		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		Map<String,Map<Integer, Integer>> map = schOutQryService.batchGetChlSchRemainAmount(schIdList, id_scchl);
		if (null == map || map.isEmpty()) {
			return;
		}
		for (MtResDTO resDTO : resDTOList) {
			String key = resDTO.getId_sch();
			if (!map.containsKey(key) || null == map.get(key)) {
				continue;
			}
			resDTO.setQuan_remain(map.get(key).get(IScDictCodeConst.SC_CHL_REMAIN));
		}
	}

}
