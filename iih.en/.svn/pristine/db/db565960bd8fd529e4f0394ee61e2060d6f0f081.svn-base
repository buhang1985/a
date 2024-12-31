package iih.en.pv.inpatient.s.rule;

import iih.en.comm.ep.EnExtEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.NewbornDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 新增或修改新生儿记录修改扩展表身高体重规则
 * 
 * @author liubin
 *
 */
public class UpdateExtForInsertOrUpdateNbAfterRule implements IRule<NewbornDO> {

	@Override
	public void process(NewbornDO... paramArrayOfT) throws BizException {
		if(EnValidator.isEmpty(paramArrayOfT))
			return;
		new EnExtEP().updateWeightAndHeight(paramArrayOfT);
	}

}
