package iih.ci.mr.cimrvs.rule;

import java.util.ArrayList;
import java.util.List;

import iih.ci.mr.cimrvs.bp.MrVsDeleteRuleBp;
import iih.ci.mr.cimrvs.d.CimrvsAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.orm.model.agg.BaseAggDO;

/**
 * 体征删除校验逻辑
 * @author xuxing_2017-12-7 17:31:332
 *
 * @param <T>
 */
public class MrVsDeleteRule<T extends BaseAggDO> implements IRule<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void process(T... arg0) throws BizException {
		List<CimrvsAggDO> listParam=new ArrayList<CimrvsAggDO>();
		for (T t : arg0) {
			listParam.add((CimrvsAggDO)t);
		}
		MrVsDeleteRuleBp bp=new MrVsDeleteRuleBp();
		bp.exec(listParam.toArray(new CimrvsAggDO[listParam.size()]));
	}
}
