package iih.pi.reg.pat.s.bp;

import java.util.ArrayList;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;

/**
 * 患者Agg建档日志业务逻辑
 * 
 * @author hao_wu
 *
 */
public class PiPatAggCreateLogBp {

	public void exec(PatiAggDO[] aggs, String createType) {
		if (aggs == null || aggs.length <= 0) {
			return;
		}

		PatDO[] pats = getPats(aggs);

		PiPatCreateLogBp bp = new PiPatCreateLogBp();
		bp.exec(pats, createType);
	}

	/**
	 * 获取患者信息集合
	 * 
	 * @param aggs
	 * @return
	 */
	private PatDO[] getPats(PatiAggDO[] aggs) {
		ArrayList<PatDO> patList = new ArrayList<PatDO>();
		for (PatiAggDO patiAggDO : aggs) {
			PatDO patDO = patiAggDO.getParentDO();
			patList.add(patDO);
		}
		return patList.toArray(new PatDO[0]);
	}
}
