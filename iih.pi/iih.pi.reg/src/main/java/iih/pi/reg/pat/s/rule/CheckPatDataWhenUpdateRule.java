package iih.pi.reg.pat.s.rule;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 患者更新前数据检查规则
 * 
 * @author hao_wu 2018-6-6
 *
 * @param <T>
 */
public class CheckPatDataWhenUpdateRule<T> implements ICompareRule<T> {

	@Override
	public void process(T[] newDatas, T[] oldDatas) throws BizException {
		if (newDatas == null || newDatas.length <= 0) {
			return;
		}

		for (T t : newDatas) {
			if (t instanceof PatiAggDO) {
				checkData((PatiAggDO[]) newDatas);
			} else if (t instanceof PatDO) {
				checkData((PatDO[]) newDatas);
			}
		}
	}

	private void checkData(PatDO[] pats) {
		// TODO Auto-generated method stub

	}

	private void checkData(PatiAggDO[] patAggs) throws BizException {
		CheckPatAggDataBp bp = new CheckPatAggDataBp();
		bp.exec(patAggs);
	}
}
