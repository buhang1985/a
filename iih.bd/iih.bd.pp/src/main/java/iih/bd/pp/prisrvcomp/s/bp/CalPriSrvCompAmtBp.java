package iih.bd.pp.prisrvcomp.s.bp;

import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import xap.mw.coreitf.d.FDouble;

/**
 * 计算组合定价子项金额业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CalPriSrvCompAmtBp {

	public void exec(PriSrvCompDO[] result) {
		if (result == null || result.length <= 0) {
			return;
		}

		CalPriSrvCompAmt(result);
	}

	/**
	 * 计算组合定价子项金额
	 * 
	 * @param result
	 */
	private void CalPriSrvCompAmt(PriSrvCompDO[] result) {
		for (PriSrvCompDO priSrvCompDO : result) {
			CalPriSrvCompAmt(priSrvCompDO);
		}
	}

	/**
	 * 计算组合定价金额
	 * 
	 * @param priSrvCompDO
	 */
	private void CalPriSrvCompAmt(PriSrvCompDO priSrvCompDO) {
		if (priSrvCompDO != null) {
			FDouble amt = CalAmt(priSrvCompDO.getQuan(), priSrvCompDO.getPrice(), priSrvCompDO.getRatio());
			priSrvCompDO.setAmt(amt);
		}
	}

	/**
	 * 计算金额
	 * 
	 * @param quan  数量
	 * @param pri   单价
	 * @param ratio 单价折扣
	 * @return
	 */
	private FDouble CalAmt(FDouble quan, FDouble pri, FDouble ratio) {
		if (quan != null && pri != null && ratio != null) {
			FDouble ratioPri = pri.multiply(ratio).setScale(4, FDouble.ROUND_HALF_UP);
			FDouble amt = quan.multiply(ratioPri).setScale(2, FDouble.ROUND_HALF_UP);
			return amt;
		}
		return null;
	}
}
