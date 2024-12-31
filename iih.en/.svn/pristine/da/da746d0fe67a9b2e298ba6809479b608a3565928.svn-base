package iih.en.pv.s.listener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.RadiotherapyOrCheckListener;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.i.IEnIpCmdService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 放疗事件监听
 * 
 * @author renying
 *
 */
public class EnRadiotherapyOrCheckListener extends RadiotherapyOrCheckListener {
	@Override
	protected void doYourActionAfterOrCheck(CiOrderDO[] ors) throws BizException {
		// 更新就诊状态
		EntStateDTO entStateDTO = new EntStateDTO();
		IEnIpCmdService ipCmdService = ServiceFinder.find(IEnIpCmdService.class);
		for (CiOrderDO or : ors) {
			entStateDTO.setId_ent(or.getId_en());
			entStateDTO.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTATE_RADIOTHERPAY);//
			entStateDTO.setVal(IBdFcDictCodeConst.EN_STATE_HASSTATE);//
			entStateDTO.setDt_occ(or.getDt_effe());
			ipCmdService.setEntState(entStateDTO);
		}
	}
}