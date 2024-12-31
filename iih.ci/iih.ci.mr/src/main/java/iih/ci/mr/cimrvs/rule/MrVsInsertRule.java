package iih.ci.mr.cimrvs.rule;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IMpNsDictCodeConst;
import iih.ci.mr.cimrvs.d.CimrvsAggDO;
import iih.mp.nr.i.IMpNrMaintanceService;
import iih.nmr.common.i.INmrMaintainService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.orm.model.agg.BaseAggDO;

/**
 * 生命体征新增规则（记录采集记录）
 * 
 * @author xuxing_2017年12月7日17:25:27 * @param <T>
 */
public class MrVsInsertRule<T extends BaseAggDO> implements IRule<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void process(T... arg0) throws BizException {
		List<CimrvsAggDO> listParam = new ArrayList<CimrvsAggDO>();
		for (T t : arg0) {
			listParam.add((CimrvsAggDO) t);
		}
		ServiceFinder.find(INmrMaintainService.class).addMedicalRecordSet(arg0, IMpNsDictCodeConst.ID_TEMCHAR_SET, "47303020");// 记录文书数据集采集记录
		ServiceFinder.find(IMpNrMaintanceService.class).mrVsSaveValidation(listParam.toArray(new CimrvsAggDO[listParam.size()]));// 体征信息保存前（数据完整性）校验
	}
}
