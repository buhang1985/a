package iih.bd.srv.diagcate.s.rule;

import iih.bd.srv.diagcate.d.DiCateItemDO;
import iih.bd.srv.diagcate.s.bp.UpdateDiagDefBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 疾病诊断分类项目更新后规则
 * @author guoyang
 *
 */
public class DiCateItemAfterDeleteRule implements IRule<DiCateItemDO> {

	@Override
	public void process(DiCateItemDO... arg0) throws BizException {
		UpdateDiagDefBp bp = new UpdateDiagDefBp(true);
		bp.exec(arg0);
	}

}