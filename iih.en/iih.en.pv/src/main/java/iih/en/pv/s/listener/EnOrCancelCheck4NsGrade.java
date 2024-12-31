package iih.en.pv.s.listener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import iih.ci.ord.pub.listener.AbstractOrCancelCheckListener;
import iih.en.comm.ep.EntStateEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.i.IEnIpCmdService;
import iih.en.pv.s.listener.bp.GetMatchLevelValBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 作废护理级别医嘱监听类
 * 
 * @author jizb
 *
 */
public class EnOrCancelCheck4NsGrade extends AbstractOrCancelCheckListener {
	
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为护理级别医嘱判断
		if (CiOrderTypeEnum.NSGRADEORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}
	
	@Override
	protected void doYourActionAfterOrCancelCheck(CiOrderDO[] ors) throws BizException {
		EntStateEP ep = new EntStateEP();	
		EntStateDO[] entStateDOs = ep.getEntstates(ors[0].getId_en(), ors[0].getId_pat(), ors[0].getCode_entp(), new String[]{IBdFcDictCodeConst.SD_ENSTSTATETP_NUR});
		if (EnValidator.isEmpty(entStateDOs))
			return;
		GetMatchLevelValBP valBp = new GetMatchLevelValBP();
		String val = valBp.exec(IBdFcDictCodeConst.SD_ENSTSTATETP_NUR, ors[0].getId_srv());
		if (entStateDOs[0].getVal() != null 
				&& entStateDOs[0].getVal().equals(val)
				&& ors[0].getId_or().equals(entStateDOs[0].getId_key_sourse())) {
			EntStateDTO entStateDTO = new EntStateDTO();
			IEnIpCmdService ipCmdService = ServiceFinder.find(IEnIpCmdService.class);
			entStateDTO.setId_ent(ors[0].getId_en());
			entStateDTO.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTSTATETP_NUR);
			entStateDTO.setVal(new EntStateEP().getEnStateDefVal(IBdFcDictCodeConst.SD_ENSTSTATETP_NUR));
			entStateDTO.setDt_occ(ors[0].getDt_canc());
			ipCmdService.setEntState(entStateDTO);
		}
	}
}
