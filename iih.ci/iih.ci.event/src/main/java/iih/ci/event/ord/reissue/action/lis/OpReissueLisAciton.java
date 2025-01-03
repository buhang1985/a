package iih.ci.event.ord.reissue.action.lis;

import iih.ci.event.reissue.d.IEMsgReissueRstDTO;
import xap.mw.core.data.BizException;
/**
 * 消息补发，检验组装数据
 * @author zhangwq
 *
 */
public class OpReissueLisAciton  extends ReissueLisCommonAction  {
	public OpReissueLisAciton(){
		this.reissueBP = new OpReissueLisBP();
	}
	@Override
	public IEMsgReissueRstDTO asseble() throws BizException {
		OpReissueLisBP op = new OpReissueLisBP();
		op.setiEMsgReissueDTO(this.iEMsgReissueDTO);
		op.setOrders(this.checkOrders());
		return op.asseble();	
	}
}
