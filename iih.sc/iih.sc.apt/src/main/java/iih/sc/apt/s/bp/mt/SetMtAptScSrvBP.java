package iih.sc.apt.s.bp.mt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 设置医技预约排班服务BP
 * 
 * @author zhengcm
 * @date 2016-12-08 16:50:05
 *
 */
public class SetMtAptScSrvBP {

	/**
	 * 设置医技预约排班服务
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
		for (MtResDTO resDTO : mtAptDTOs) {
			FArrayList flist = resDTO.getFlist_ticks();
			if (flist != null && flist.size() > 0) {
				List<ScheduleSrvDO> srvList = new ArrayList<ScheduleSrvDO>();
				List<String> nameList = new ArrayList<String>();
				if (resDTO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TICK)) {// 号位
					List<ScSchTickDO> tickDOs = (List<ScSchTickDO>) flist;
					for (ScSchTickDO tickDO : tickDOs) {
						if (!StringUtil.isEmptyWithTrim(tickDO.getName_srv())
								&& !nameList.contains(tickDO.getName_srv())) {
							ScheduleSrvDO srvDO = new ScheduleSrvDO();
							srvDO.setId_scsrv(tickDO.getId_scsrv());
							srvDO.setName(tickDO.getName_srv());
							srvList.add(srvDO);
							nameList.add(tickDO.getName_srv());
						}
					}
				} else if (resDTO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TICKS)) {// 号段
					List<ScSchTicksDO> ticksDOs = (List<ScSchTicksDO>) flist;
					for (ScSchTicksDO ticksDO : ticksDOs) {
						if (!StringUtil.isEmptyWithTrim(ticksDO.getName_srv())
								&& !nameList.contains(ticksDO.getName_srv())) {
							ScheduleSrvDO srvDO = new ScheduleSrvDO();
							srvDO.setId_scsrv(ticksDO.getId_scsrv());
							srvDO.setName(ticksDO.getName_srv());
							srvList.add(srvDO);
							nameList.add(ticksDO.getName_srv());
						}
					}
				}
				FArrayList flist_srv = new FArrayList();
				flist_srv.addAll(srvList);
				resDTO.setFlist_scsrv(flist_srv);
			}
		}
	}

}
