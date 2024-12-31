package iih.pi.reg.pat.s.rule;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

public class CheckPatDataWhenInsertRule<T> implements IRule<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void process(T... datas) throws BizException {
		if (datas == null || datas.length <= 0) {
			return;
		}

		for (T t : datas) {
			if (t instanceof PatiAggDO) {
				checkData((PatiAggDO[]) datas);
			} else if (t instanceof PatDO) {
				checkData((PatDO[]) datas);
			}
		}
	}

	private void checkData(PatiAggDO[] patAggs) throws BizException {
		CheckPatAggDataBp bp = new CheckPatAggDataBp();
		bp.exec(patAggs);
	}

	private void checkData(PatDO[] pats) {
		// TODO Auto-generated method stub

	}

}
