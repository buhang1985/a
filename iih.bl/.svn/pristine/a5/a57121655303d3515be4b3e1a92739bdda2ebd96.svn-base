package iih.bl.hp.rule;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;

/**
 * 获取西药医嘱天数、中药医嘱付数
 * 
 * @author LIM
 *
 */
public class GetOpDaysBP {
	/**
	 * 
	 * @param ordType
	 *            医嘱类型
	 * @param ciOrderDO
	 *            医嘱
	 * @return
	 */
	public int exec(String ordType, CiOrderDO ciOrderDO) {
		int days = 0;
		if (IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG.equals(ordType)) {// 草药
			if (ciOrderDO.getOrders() != null) {
				days = ciOrderDO.getOrders();
			}
		} else if (IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG.equals(ordType)) {// 西药
			if (ciOrderDO.getDays_or() != null) {
				days = ciOrderDO.getDays_or();
			}
		}
		return days;
	}
}
