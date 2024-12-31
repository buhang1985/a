package iih.pis.ivx.apt.i;

import iih.en.pv.appoint.bean.WaitQueParam;
import iih.en.pv.appoint.result.WaitQueResult;
import xap.mw.core.data.BizException;

public interface IAptQueryService {
	public WaitQueResult[] getWaitQue(WaitQueParam waitQuePara) throws BizException;
}