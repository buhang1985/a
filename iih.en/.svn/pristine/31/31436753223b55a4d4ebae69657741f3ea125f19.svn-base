package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IMpEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IMpNsDictCodeConst;
import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.fc.enstate.d.desc.BdEnStateDODesc;
import iih.bd.fc.enstate.i.IEnstateRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.i.IEnIpCmdService;
import iih.mp.nr.foreign.d.ForEnTemDataDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/***
 * 孕产妇风险等级监听器
 * @author zhangpp
 *
 */
public class EnPregRiskLevelMpListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if (!IMpNsDictCodeConst.EVENT_MP_EN_TEMDATA.equals(event.getSourceID()) 
				|| !IMpEventConst.SD_FIVE_COLOR.equals(event.getEventType()))
			return;
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		ForEnTemDataDTO[] temDatas = (ForEnTemDataDTO[]) bizUserObj.getUserObj();
		if(EnValidator.isEmpty(temDatas))
			return;
		BdEnStateDO[] bdEnStates = this.getBdEnStates();
		if(bdEnStates == null)
			return;
		IEnIpCmdService ipCmdService = ServiceFinder.find(IEnIpCmdService.class);
		EntStateDTO entState = null;
		for(ForEnTemDataDTO temData : temDatas){
			if(temData.getValue() == null)
				continue;
			entState = new EntStateDTO();
			entState.setId_ent(temData.getId_ent());
			entState.setDt_occ(EnAppUtils.getServerDateTime());
			boolean isTrue = false;
			for(BdEnStateDO enState : bdEnStates){
				if(EnValidator.isEmpty(enState.getVal()))
					continue;
				if(enState.getVal().equals(temData.getValue().toString())){
					isTrue = true;
					entState.setSd_enstatetp(enState.getSd_enstatetp());
					entState.setVal(enState.getVal());
					break;
				}
			}
			if (FBoolean.TRUE.equals(temData.getFg_del())) {
				entState.setFg_del(FBoolean.TRUE);
			}
			if(!isTrue)
				continue;
			ipCmdService.setEntState(entState);
		}
	}
	/**
	 * 获取孕产妇风险等级就诊状况
	 * 
	 * @return
	 * @throws BizException
	 */
	private BdEnStateDO[] getBdEnStates() throws BizException{
		IEnstateRService serv = ServiceFinder.find(IEnstateRService.class);
		String whereStr = String.format("%s.Sd_enstatetp = '%s' and %s.Fg_active = 'Y'", 
				BdEnStateDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_ENTSTATETP_GRAVIDARISK,
				BdEnStateDODesc.TABLE_ALIAS_NAME);
		String orderStr = String.format("%s.Sd_enstatetp", BdEnStateDODesc.TABLE_ALIAS_NAME);
		return serv.find(whereStr, orderStr, FBoolean.FALSE);
	}
}
