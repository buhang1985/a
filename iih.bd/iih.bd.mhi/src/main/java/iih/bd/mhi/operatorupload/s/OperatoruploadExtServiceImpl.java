package iih.bd.mhi.operatorupload.s;

import iih.bd.mhi.operatorupload.i.IOperatoruploadExtService;
import iih.bd.mhi.operatorupload.s.bp.SynchronizationBp;
import xap.mw.core.data.BizException;

public class OperatoruploadExtServiceImpl implements IOperatoruploadExtService{

	@Override
	public void synchronization() throws BizException {
		SynchronizationBp bp = new SynchronizationBp();
		bp.exec();
	}
}
