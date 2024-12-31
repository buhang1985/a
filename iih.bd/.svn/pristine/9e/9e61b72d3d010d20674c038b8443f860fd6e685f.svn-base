package iih.bd.srv.operatetype.s;
import iih.bd.srv.operatetype.i.IOperatetypeExtService;
import iih.bd.srv.operatetype.s.bp.GetOperateTypeMaxSortNoBp;
import xap.mw.core.data.BizException;

/**
 * 操作类型扩展服务实现
 */

public class OperatetypeExtServiceImpl implements IOperatetypeExtService {

	@Override
	public int getMaxNo() throws BizException {
		GetOperateTypeMaxSortNoBp bp = new GetOperateTypeMaxSortNoBp();
		return bp.exec();
	}
    
}
