package iih.en.pv.s.listener.bp;

import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.fc.enstate.i.IEnstateRService;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取匹配的等级信息
 * 含病情等级、护理等级、膳食等级
 * @author Administrator
 *
 */
public class GetMatchLevelValBP {
	/**
	 * 获取匹配的等级信息
	 * @param profileTypeId 自定义档案类型ID
	 * @param srvId 服务ID
	 * @return 自定档案值的编码
	 * @throws BizException
	 */
	public String exec(String stateSd, String srvId) throws BizException{

		IEnstateRService enStateService = ServiceFinder.find(IEnstateRService.class);
		BdEnStateDO[] enStateDos = enStateService.findByAttrValString("Sd_enstatetp", stateSd);
		if (EnValidator.isEmpty(enStateDos)){
			return null;
		}
		for(BdEnStateDO enStateDo:enStateDos){
			if(enStateDo.getIds_srv() != null && enStateDo.getIds_srv().contains(srvId)){
				return enStateDo.getVal();
			}
		}
		return null;
	}
}

