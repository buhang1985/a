package iih.en.pv.s.listener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import iih.ci.ord.pub.listener.AbstractOrCancelCheckListener;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.i.IEnIpCmdService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class EnOrCancelCheckListener extends AbstractOrCancelCheckListener {
	
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为出院医嘱判断
		if (CiOrderTypeEnum.OUTHOSPORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}
	
	@Override
	protected void doYourActionAfterOrCancelCheck(CiOrderDO[] ors) throws BizException {
		EntStateDTO entStateDTO = new EntStateDTO();
		IEnIpCmdService ipCmdService = ServiceFinder.find(IEnIpCmdService.class);
		entStateDTO.setId_ent(ors[0].getId_en());
		entStateDTO.setFg_del(FBoolean.TRUE);
		entStateDTO.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTATE_TOBEDISCHARGE);
		entStateDTO.setVal(IBdFcDictCodeConst.EN_STATE_HASSTATE);
		entStateDTO.setDt_occ(ors[0].getDt_canc());
		ipCmdService.setEntState(entStateDTO);
	}
}
