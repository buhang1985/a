package iih.sc.apt.s.bp.mt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;

/**
 * 设置医技预约排班号位或号段BP
 * 
 * @author zhengcm
 * @date 2016-12-08 16:46:44
 *
 */
public class SetMtAptSchTicksBP {

	/**
	 * 设置医技预约排班号位或号段
	 *
	 * @param mtAptDTOs
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	public void exec(List<MtResDTO> mtAptDTOs) throws BizException {
		if (ListUtil.isEmpty(mtAptDTOs)) {
			return;
		}
		List<String> tickMdList = new ArrayList<String>();
		List<String> ticksMdList = new ArrayList<String>();
		for (MtResDTO aptDTO : mtAptDTOs) {
			if (aptDTO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TICK)) {// 号位
				tickMdList.add(aptDTO.getId_sch());
			} else if (aptDTO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TICKS)) {// 号段
				ticksMdList.add(aptDTO.getId_sch());
			}
		}
		Map<String, List<ScSchTickDO>> tickMap = new HashMap<String, List<ScSchTickDO>>();
		Map<String, List<ScSchTicksDO>> ticksMap = new HashMap<String, List<ScSchTicksDO>>();
		OralAptEP aptEP = new OralAptEP();
		if (!ListUtil.isEmpty(tickMdList)) {
			ScSchTickDO[] tickDOs = aptEP.getSchTickByWhereStr(ScSqlUtils.getInSqlByIds("id_sch",
					tickMdList));
			for (ScSchTickDO tickDO : tickDOs) {
				String key = tickDO.getId_sch();
				if (tickMap.containsKey(key)) {
					tickMap.get(key).add(tickDO);
				} else {
					List<ScSchTickDO> list = new ArrayList<ScSchTickDO>();
					list.add(tickDO);
					tickMap.put(key, list);
				}
			}
		}
		if (!ListUtil.isEmpty(ticksMdList)) {
			ScSchTicksDO[] ticksDOs = aptEP.getSchTicksByWhere(
					ScSqlUtils.getInSqlByIds("id_sch", ticksMdList), "t_b");
			for (ScSchTicksDO ticksDO : ticksDOs) {
				String key = ticksDO.getId_sch();
				if (ticksMap.containsKey(key)) {
					ticksMap.get(key).add(ticksDO);
				} else {
					List<ScSchTicksDO> list = new ArrayList<ScSchTicksDO>();
					list.add(ticksDO);
					ticksMap.put(key, list);
				}
			}
		}
		for (MtResDTO aptDTO : mtAptDTOs) {
			if (aptDTO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TICK)) {// 号位
				FArrayList flist = new FArrayList();
				List<ScSchTickDO> tickList = null;
				if (tickMap.containsKey(aptDTO.getId_sch())) {
					tickList = tickMap.get(aptDTO.getId_sch());
					flist.addAll(tickList);
				}
				aptDTO.setFlist_ticks(flist);
			} else if (aptDTO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TICKS)) {// 号段
				FArrayList flist = new FArrayList();
				List<ScSchTicksDO> ticksList = null;
				if (ticksMap.containsKey(aptDTO.getId_sch())) {
					ticksList = ticksMap.get(aptDTO.getId_sch());
					flist.addAll(ticksList);
				}
				aptDTO.setFlist_ticks(flist);
			}
		}
	}

}
