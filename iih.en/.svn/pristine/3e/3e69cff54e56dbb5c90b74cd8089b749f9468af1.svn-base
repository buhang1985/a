package iih.en.pv.s.listener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.IllStateOrCheckListener;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.i.IEnIpCmdService;
import iih.en.pv.s.listener.bp.GetMatchLevelValBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 病情等级监听事件
 * @author renying
 * 
 *
 */
public class EnIllStateOrCheckListener extends IllStateOrCheckListener{
	@Override
	protected void doYourActionAfterOrCheck(CiOrderDO[] ors)throws BizException {
		//更新就诊状态
		EntStateDTO entStateDTO = new EntStateDTO();
		IEnIpCmdService ipCmdService = ServiceFinder.find(IEnIpCmdService.class);
		GetMatchLevelValBP   valBp = new GetMatchLevelValBP();
		for(CiOrderDO or : ors){
			String val = valBp.exec(IBdFcDictCodeConst.SD_ENSTSTATETP_DISE, or.getId_srv());
			if(EnValidator.isEmpty(val))
			{
				continue;
			}
			entStateDTO.setId_ent(or.getId_en());
			entStateDTO.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTSTATETP_DISE);//
			entStateDTO.setVal(val);//
			entStateDTO.setDt_occ(or.getDt_effe());
			entStateDTO.setId_key_sourse(or.getId_or());
			ipCmdService.setEntState(entStateDTO);
		}		
	}
}
