package iih.ci.event.ord.reissue.action.ris;

import iih.ci.event.ord.bps.sign.ip.listenerbp.IpRisSignStandardBP;
import iih.ci.event.ord.reissue.common.ReissueCommonBP;
/**
 * 消息补发，检查组装数据
 * @author zhangwq
 *
 */
public class IpReissueRisBP extends ReissueCommonBP {

	public IpReissueRisBP() {
		this.listener = new IpRisSignStandardBP();
	}
}
