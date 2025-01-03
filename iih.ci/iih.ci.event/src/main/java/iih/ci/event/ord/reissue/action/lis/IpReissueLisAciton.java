package iih.ci.event.ord.reissue.action.lis;

import iih.ci.event.reissue.d.IEMsgReissueRstDTO;
import xap.mw.core.data.BizException;
/**
 * 消息补发，检验组装数据
 * @author zhangwq
 *
 */
public class IpReissueLisAciton  extends ReissueLisCommonAction  {
	public IpReissueLisAciton(){
		this.reissueBP = new IpReissueLisBP();
	}
	@Override
	public IEMsgReissueRstDTO asseble() throws BizException {
		//住院
		IpReissueLisBP ip = new IpReissueLisBP();
		ip.setiEMsgReissueDTO(this.iEMsgReissueDTO);
		ip.setOrders(this.checkOrders());
		return ip.asseble();	
	}

}
