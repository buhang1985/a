package iih.ci.ord.pub.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.i.ICiorappsurgeryMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;
import xap.sys.message.message.i.IGenerateMessageExtdService;
/**
 * 手术医嘱签署后消息发送
 * @author zhangwanqing
 *
 */
public class CiApSugSignListener extends AbstractOrSignListener {
	private String Message_Code="CI_AP_SUG_MESSAGE";
	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException { 
		List<String> id_ors = new ArrayList<String>();
		Map<String,CiOrderDO> orMap = new HashMap<String,CiOrderDO>();
		for(CiOrderDO or : ors){
			id_ors.add(or.getId_or());
			orMap.put(or.getId_or(), or);
		}
		if(id_ors!=null&&id_ors.size()>0){
			ICiorappsurgeryMDORService sugService = ServiceFinder.find(ICiorappsurgeryMDORService.class);
			OrdApOpDO[] ordApOps = sugService.findByAttrValStrings(OrdApOpDO.ID_OR, id_ors.toArray(new String[0]));
			for(OrdApOpDO ordApOp : ordApOps){
				sendMesg(ordApOp,orMap.get(ordApOp.getId_or()));
			}
		}
	}

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		
		return !StringUtils.isEmpty(or.getSd_srvtp())&&or.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP);
	}
	
	private String sendMesg(OrdApOpDO ordApOp,CiOrderDO or) throws BizException{
		Map<String,Object> msgMap = new HashMap<String,Object>();
		msgMap.put(OrdApOpDO.class.getSimpleName(), ordApOp);
		msgMap.put(CiOrderDO.class.getSimpleName(), or);
		IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
		msgService.GenerateMessageAndMap(Message_Code, msgMap, null);
		return "";
	}
}
