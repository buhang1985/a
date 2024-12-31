package iih.ci.event.ord.bps.sign.op.listenerbp;

import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;

public class TestStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		// TODO Auto-generated method stub
		
	}

}
