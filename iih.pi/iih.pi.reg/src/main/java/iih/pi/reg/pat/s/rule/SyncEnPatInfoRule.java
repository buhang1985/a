package iih.pi.reg.pat.s.rule;

import org.apache.commons.lang.ArrayUtils;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.s.bp.PiPatSyncEnDataBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 更新就诊患者信息规则
 * 
 * @author hao_wu
 *
 */
public class SyncEnPatInfoRule<T> implements IRule<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void process(T... datas) throws BizException {
		if (ArrayUtils.isEmpty(datas)) {
			return;
		}

		if (datas[0] instanceof PatiAggDO) {
			syncEnPatInfo((PatiAggDO[]) datas);
		} else if (datas[0] instanceof PatDO) {
			syncEnPatInfo((PatDO[]) datas);
		}
	}

	private void syncEnPatInfo(PatiAggDO[] patAggs) throws BizException {
		PiPatSyncEnDataBP bp = new PiPatSyncEnDataBP();
		for (PatiAggDO patiAggDO : patAggs) {
			bp.exec(patiAggDO);
		}
	}

	private void syncEnPatInfo(PatDO[] pats) throws BizException {
		PiPatSyncEnDataBP bp = new PiPatSyncEnDataBP();
		for (PatDO patDo : pats) {
			bp.exec(patDo);
		}
	}
}
