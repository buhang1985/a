package iih.pi.reg.pat.s.rule;

import java.util.ArrayList;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.s.bp.PiPatCreateAccBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 创建患者账户规则
 * 
 * @author hao_wu
 *
 */
public class CreatePatAccRule<T> implements IRule<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void process(T... datas) throws BizException {

		if (datas == null || datas.length <= 0) {
			return;
		}

		if (datas[0] instanceof PatiAggDO) {
			createPatAcc((PatiAggDO[]) datas);
		} else if (datas[0] instanceof PatDO) {
			createPatAcc((PatDO[]) datas);
		}
	}

	/**
	 * 创建患者账户
	 * 
	 * @param pats
	 * @throws BizException
	 */
	private void createPatAcc(PatDO[] pats) throws BizException {
		PiPatCreateAccBP bp = new PiPatCreateAccBP();
		bp.exec(pats);
	}

	/**
	 * 创建患者账户
	 * 
	 * @param patAggs
	 * @throws BizException
	 */
	private void createPatAcc(PatiAggDO[] patAggs) throws BizException {
		PatDO[] pats = getPats(patAggs);
		createPatAcc(pats);
	}

	/**
	 * 获取患者主信息数组
	 * 
	 * @param patAggs
	 * @return
	 */
	private PatDO[] getPats(PatiAggDO[] patAggs) {
		ArrayList<PatDO> patList = new ArrayList<PatDO>();
		for (PatiAggDO patiAggDO : patAggs) {
			patList.add(patiAggDO.getParentDO());
		}
		return patList.toArray(new PatDO[0]);
	}
}
