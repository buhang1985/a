package iih.en.pv.s.listener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import iih.ci.ord.pub.listener.AbstractOrStopCheckListener;
import iih.en.comm.ep.EntStateEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.i.IEnIpCmdService;
import iih.en.pv.s.listener.bp.GetMatchLevelValBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 停止营养等级医嘱监听类
 * 
 * @author jizb
 *
 */
public class EnOrStopCheck4Nutrioniet extends AbstractOrStopCheckListener {

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为营养等级医嘱判断
		if (CiOrderTypeEnum.NUTRIONDIETORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}
	
	@Override
	protected void doYourActionAfterOrStopCheck(CiOrderDO[] ors) throws BizException {
		EntStateEP ep = new EntStateEP();	
		EntStateDO[] entStateDOs = ep.getEntstates(ors[0].getId_en(), ors[0].getId_pat(), ors[0].getCode_entp(), new String[]{IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD});
		if (EnValidator.isEmpty(entStateDOs))
			return;
		GetMatchLevelValBP valBp = new GetMatchLevelValBP();
		String val = valBp.exec(IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD, ors[0].getId_srv());
		if (entStateDOs[0].getVal() != null 
				&& entStateDOs[0].getVal().equals(val)
				&& ors[0].getId_or().equals(entStateDOs[0].getId_key_sourse())) {
			EntStateDTO entStateDTO = new EntStateDTO();
			IEnIpCmdService ipCmdService = ServiceFinder.find(IEnIpCmdService.class);
			entStateDTO.setId_ent(ors[0].getId_en());
			entStateDTO.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD);
			entStateDTO.setVal(new EntStateEP().getEnStateDefVal(IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD));
			entStateDTO.setDt_occ(ors[0].getDt_stop());
			ipCmdService.setEntState(entStateDTO);
		}
	}
}
