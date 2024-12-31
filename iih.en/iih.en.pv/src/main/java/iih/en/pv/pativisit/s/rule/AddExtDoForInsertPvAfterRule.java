package iih.en.pv.pativisit.s.rule;

import iih.en.comm.ep.EnExtEP;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;
/**
 * 新增En_ent后自动新增En_ent_ext记录
 * 
 * @author liubin
 *
 */
public class AddExtDoForInsertPvAfterRule implements IRule<PatiVisitDO> {

	/**
	 * 新增En_ent后自动新增En_ent_ext记录
	 */
	@Override
	public void process(PatiVisitDO... paramArrayOfT) throws BizException {
		new EnExtEP().insertExt(paramArrayOfT);
	}

}
