package iih.ci.mr.cimrvs.rule;

import java.util.ArrayList;
import java.util.List;

import iih.ci.mr.cimrvs.d.CimrvsAggDO;
import iih.mp.nr.i.IMpNrMaintanceService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.orm.model.agg.BaseAggDO;

/**
 * 体征信息编辑规则
 * 
 * @author xuxing_2017年12月15日15:07:00
 *
 * @param <T>
 */
public class MrVsUpdateRule<T extends BaseAggDO> implements IRule<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void process(T... arg0) throws BizException {
		List<CimrvsAggDO> listParam = new ArrayList<CimrvsAggDO>();
		for (T t : arg0) {
			listParam.add((CimrvsAggDO) t);
		}
		ServiceFinder.find(IMpNrMaintanceService.class).mrVsSaveValidation(listParam.toArray(new CimrvsAggDO[listParam.size()]));
	}
}
