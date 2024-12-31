package iih.pi.reg.pat.s.rule;

import java.util.ArrayList;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.s.bp.PiPatInsertHistoryBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 患者变更记录规则
 * 
 * @author hao_wu
 *
 */
public class PatChangedRecordRule<T> implements ICompareRule<T> {

	@Override
	public void process(T[] newDatas, T[] oldDatas) throws BizException {
		if (newDatas == null || newDatas.length <= 0) {
			return;
		}

		if (newDatas[0] instanceof PatiAggDO) {
			patChangedRecord((PatiAggDO[]) newDatas, (PatiAggDO[]) oldDatas);
		} else if (newDatas[0] instanceof PatDO) {
			patChangedRecord((PatDO[]) newDatas, (PatDO[]) oldDatas);
		}

	}

	/**
	 * 患者变更记录
	 * 
	 * @param newPatAggs
	 * @param oldPatAggs
	 * @throws BizException
	 */
	private void patChangedRecord(PatiAggDO[] newPatAggs, PatiAggDO[] oldPatAggs) throws BizException {
		PatDO[] newPats = getPats(newPatAggs);
		PatDO[] oldPats = getPats(oldPatAggs);
		patChangedRecord(newPats, oldPats);
	}

	/**
	 * 获取患者主信息列表
	 * 
	 * @param oldPatAggs
	 * @return
	 */
	private PatDO[] getPats(PatiAggDO[] oldPatAggs) {
		ArrayList<PatDO> patList = new ArrayList<PatDO>();
		for (PatiAggDO patiAggDO : oldPatAggs) {
			patList.add(patiAggDO.getParentDO());
		}
		return patList.toArray(new PatDO[0]);
	}

	/**
	 * 患者变更记录
	 * 
	 * @param newPats
	 * @param oldPats
	 * @throws BizException
	 */
	private void patChangedRecord(PatDO[] newPats, PatDO[] oldPats) throws BizException {
		PiPatInsertHistoryBP hisBp = new PiPatInsertHistoryBP();
		for (int i = 0; i < newPats.length; i++) {
			hisBp.exec(oldPats[i], newPats[i], false);
		}
	}
}
