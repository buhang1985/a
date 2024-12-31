package iih.bd.srv.outputtemplate.s;
import iih.bd.srv.outputtemplate.i.IOutputtemplateExtService;
import iih.bd.srv.outputtemplate.s.bp.GetOutputTemplateMaxSortNoBp;
import xap.mw.core.data.BizException;

/**
 * 输出模板扩展服务实现
 */

public class OutputtemplateExtServiceImpl implements IOutputtemplateExtService {

	@Override
	public int getMaxNo() throws BizException {
		GetOutputTemplateMaxSortNoBp bp = new GetOutputTemplateMaxSortNoBp();
		return bp.exec();
	}

}
