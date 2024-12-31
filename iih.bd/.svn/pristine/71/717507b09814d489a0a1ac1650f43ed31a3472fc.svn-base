package iih.bd.pp.bp;

import iih.bd.pp.srvspecround.d.SrvSpecRoundDO;
import xap.mw.coreitf.d.FDouble;

/**
 * 特殊取整
 * @author yankan
 * @since 2017-11-07
 *
 */
public class SpecRoundBP {
	/**
	 * 特殊取整
	 * 
	 * @param quan 数量
	 * @param specRoundDO 特殊取整DO
	 * @return
	 */
	public FDouble exec(FDouble quan, SrvSpecRoundDO specRoundDO) {
		if (specRoundDO == null) {
			return quan;
		}
		FDouble max_quan = new FDouble(Math.ceil((quan.multiply(specRoundDO.getRound_denominator())).doubleValue()));
//		max_quan = max_quan.multiply(specRoundDO.getRound_numerator());// 分子设计时，恒为1
		FDouble ret_quan = max_quan.div(specRoundDO.getRound_denominator());
		return ret_quan;
	}
}
