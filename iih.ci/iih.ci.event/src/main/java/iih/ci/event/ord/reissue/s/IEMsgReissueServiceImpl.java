package iih.ci.event.ord.reissue.s;

import iih.ci.event.i.reissue.IIEMsgReissueService;
import iih.ci.event.ord.reissue.action.ReissueAction;
import iih.ci.event.ord.reissue.common.ReissueRstXmlUtils;
import iih.ci.event.ord.utils.OrdEventLogger;
/**
 * 集成平台消息补发
 * @author zhangwq
 *
 */
public class IEMsgReissueServiceImpl implements IIEMsgReissueService {

	@Override
	public String process(String xml) {
		OrdEventLogger.info("", xml);
		try{
			ReissueAction action = new ReissueAction();
			return action.exec(xml);
		}catch(Exception ex){
			ex.printStackTrace();
			return ReissueRstXmlUtils.ErrorMsg(ex.getMessage());
		}
	}
}
