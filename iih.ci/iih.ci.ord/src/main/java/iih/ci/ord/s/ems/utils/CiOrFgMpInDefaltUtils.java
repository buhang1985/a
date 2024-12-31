package iih.ci.ord.s.ems.utils;

import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医嘱在院执行默认值
 * 
 * @author zhangwq
 *
 */
public class CiOrFgMpInDefaltUtils {
	/**
	 * 
	 * @param code_entp 就诊类型
	 * @param sd_srvtp 服务类型
	 * @param id_route 用法 可为空
	 * @param fg_mp_in 在院执行 可为空
	 * @return
	 * @throws BizException
	 */
	public static FBoolean GetDefaultFg_mp_in(String code_entp, String sd_srvtp, String id_route, FBoolean fg_mp_in) throws BizException {
		// 在院执行对象为空判断，不为空时无需设置值直接返回
		if (!CiOrdUtils.isEmpty(fg_mp_in))
			return null;

		// 住院情形时，默认值设置
		if (CiOrdUtils.isIpWf(code_entp)) {
			return FBoolean.TRUE;
			// emsdto.setFg_mp_in(FBoolean.TRUE);
		}
		// 非药品医嘱时
		if (!CiOrdUtils.isPharmacy(sd_srvtp)) {
			return FBoolean.TRUE;
			// emsdto.setFg_mp_in(FBoolean.TRUE);
		}

		// 草药医嘱时
		if (CiOrdUtils.isHerbOrder(sd_srvtp)) {
			return FBoolean.FALSE;
			// emsdto.setFg_mp_in(FBoolean.FALSE);
		}

		// 西成药医嘱时
		if (isOrIV(id_route)) {
			// 西成药IV医嘱时
			return FBoolean.TRUE;
			// emsdto.setFg_mp_in(FBoolean.TRUE);
		} else {
			// 西成药非IV医嘱时
			return FBoolean.FALSE;
		}
	}
	/**
	 * 西成药医嘱时，是否为IV医嘱的判断逻辑
	 * @param emsdto
	 * @return
	 * @throws BizException 
	 */
	private static boolean isOrIV(String id_route) throws BizException{
		if(CiOrdUtils.isEmpty(id_route))
			return false;
		return CiOrdUtils.isWesternMedicineIVOr(id_route);
	}
}
