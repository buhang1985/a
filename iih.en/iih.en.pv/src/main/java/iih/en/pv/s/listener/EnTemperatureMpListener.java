package iih.en.pv.s.listener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IMpNsDictCodeConst;
import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.fc.enstate.d.desc.BdEnStateDODesc;
import iih.bd.fc.enstate.i.IEnstateRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.i.IEnIpCmdService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.mp.nr.foreign.d.ForEnTemDataDTO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 体温监听器
 * 
 * @author liubin
 *
 */
public class EnTemperatureMpListener  implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if (!(event.getSourceID().equals(IMpNsDictCodeConst.EVENT_MP_EN_TEMDATA) && event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))
			return;
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		ForEnTemDataDTO[] temDatas = (ForEnTemDataDTO[]) bizUserObj.getUserObj();
		if(EnValidator.isEmpty(temDatas))
			return;
		Map<String, FBoolean> map = getMap(temDatas);
		if(map == null || map.size() <= 0)
			return;
		IEnIpCmdService ipCmdService = ServiceFinder.find(IEnIpCmdService.class);
		BdEnStateDO[] bdEnStates = null;
		EntStateDTO entState = null;
		FDouble lowFever = null;
		FDouble hightFever = null;
		for(ForEnTemDataDTO temData : temDatas){
			if(temData.getValue() == null)
				continue;
			if(!map.containsKey(temData.getId_ent()))
				continue;
			entState = new EntStateDTO();
			entState.setId_ent(temData.getId_ent());
			entState.setDt_occ(EnAppUtils.getServerDateTime());
			FBoolean isNewBorn = map.get(temData.getId_ent());
			if(FBoolean.TRUE.equals(isNewBorn)){
				if(lowFever == null)
					lowFever = EnParamUtils.getNbLowFever();
				if(hightFever == null)
					hightFever = EnParamUtils.getNbHightFever();
				if(lowFever == null || hightFever == null)
					continue;
				if(temData.getValue().compareTo(lowFever) >= 0 
						&& temData.getValue().compareTo(hightFever) < 0)
					entState.setVal(IBdFcDictCodeConst.EN_FEVER_LOW);
				else if(temData.getValue().compareTo(hightFever)>=0)
					entState.setVal(IBdFcDictCodeConst.EN_FEVER_HIGH);
				else
					entState.setVal(IBdFcDictCodeConst.EN_FEVER_NONE);
				entState.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTSTATETP_FEVER);
			}else{
				if(bdEnStates == null)
					bdEnStates = getBdEnStates();
				if(bdEnStates == null)
					continue;
				boolean isTrue = false;
				for(BdEnStateDO enState : bdEnStates){
					if(enState.getMin() == null || enState.getMax() == null)
						break;
					if(temData.getValue().compareTo(enState.getMin()) >=0 
							&& temData.getValue().compareTo(enState.getMax()) < 0){
						isTrue = true;
						entState.setSd_enstatetp(enState.getSd_enstatetp());
						entState.setVal(enState.getVal());
						break;
					}
				}
				if(!isTrue)
					continue;
			}
			ipCmdService.setEntState(entState);
		}
	}
	/**
	 * 组装就诊数据字典
	 * 
	 * @param temDatas
	 * @return
	 * @throws BizException
	 */
	private Map<String, FBoolean> getMap(ForEnTemDataDTO[] temDatas) throws BizException{
		Set<String> set = new HashSet<String>();
		for(ForEnTemDataDTO temData : temDatas)
			set.add(temData.getId_ent());
		List<InpatientDO> list = (List<InpatientDO>) new DAFacade().findByAttrValStrings(InpatientDO.class, 
				InpatientDO.ID_ENT, set.toArray(new String[0]), new String[]{InpatientDO.ID_ENT, InpatientDO.FG_NEWBORN});
		if(EnValidator.isEmpty(list))
			return null;
		Map<String, FBoolean> map = new HashMap<>();
		for(InpatientDO ipdo : list)
			map.put(ipdo.getId_ent(), ipdo.getFg_newborn());
		return map;
	}
	/**
	 * 获取发烧就诊状况
	 * 
	 * @return
	 * @throws BizException
	 */
	private BdEnStateDO[] getBdEnStates() throws BizException{
		IEnstateRService serv = ServiceFinder.find(IEnstateRService.class);
		String whereStr = String.format("%s.Sd_enstatetp = '%s' and %s.Fg_active = 'Y'", 
				BdEnStateDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_ENSTSTATETP_FEVER,
				BdEnStateDODesc.TABLE_ALIAS_NAME);
		String orderStr = String.format("%s.Sd_enstatetp", BdEnStateDODesc.TABLE_ALIAS_NAME);
		return serv.find(whereStr, orderStr, FBoolean.FALSE);
	}
}
