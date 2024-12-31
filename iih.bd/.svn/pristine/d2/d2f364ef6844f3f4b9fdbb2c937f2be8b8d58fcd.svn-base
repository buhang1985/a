package iih.bd.srv.mrmtype.s;
import iih.bd.srv.mrmtype.i.IMrmtypeExtService;
import iih.bd.srv.mrmtype.s.bp.GetMrmTypeMaxSortNoBp;
import xap.mw.core.data.BizException;


/**
 * 病案分类扩展服务实现类
 */
public class MrmtypeExtServiceImpl implements IMrmtypeExtService {

	@Override
	public int getMaxNo(String idStr, Boolean isentp) throws BizException {
		GetMrmTypeMaxSortNoBp bp = new GetMrmTypeMaxSortNoBp();
		return bp.exec(idStr, isentp);
	}
}
