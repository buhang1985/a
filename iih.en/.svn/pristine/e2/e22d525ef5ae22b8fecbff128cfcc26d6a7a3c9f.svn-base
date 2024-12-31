package iih.en.pv.s.listener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.NsGradeOrCheckListener;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.i.IEnIpCmdService;
import iih.en.pv.s.listener.bp.GetMatchLevelValBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 护理等级监听事件
 * 
 * @author renying
 *
 */
public class EnNsGradeOrCheckListener extends NsGradeOrCheckListener {
	@Override
	protected void doYourActionAfterOrCheck(CiOrderDO[] ors) throws BizException {
		// 更新就诊状态
		EnLogUtil.getInstance().logInfo("接收护理登记监听事件");
		EntStateDTO entStateDTO = new EntStateDTO();
		IEnIpCmdService ipCmdService = ServiceFinder.find(IEnIpCmdService.class);
		GetMatchLevelValBP valBp = new GetMatchLevelValBP();
		for (CiOrderDO or : ors) {
			String val = valBp.exec(IBdFcDictCodeConst.SD_ENSTSTATETP_NUR, or.getId_srv());
			EnLogUtil.getInstance().logInfo("接收护理登记监听事件 ：id_or"+or.getId_or() + ";  id_ent:"
		+or.getId_en()+";  val"+val);
			if(EnValidator.isEmpty(val))
			{
				continue;
			}
			entStateDTO.setId_ent(or.getId_en());
			entStateDTO.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTSTATETP_NUR);//
			entStateDTO.setVal(val);//
			entStateDTO.setDt_occ(or.getDt_chk());// 确认时间
			entStateDTO.setId_key_sourse(or.getId_or());
			ipCmdService.setEntState(entStateDTO);
		}
	}
}