package iih.sc.sch.s.bp;

import iih.sc.comm.ScValidator;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FTime;

/**
 * 口腔科排班减少加号数量检查BP
 * 
 * @author zhengcm
 * @date 2016-09-18 19:25:52
 *
 */

public class OralSubQuecnCheckBP {

	/**
	 * 已使用的加号号位不允许删除
	 *
	 * @param depId 科室id
	 * @param schId 排班id
	 * @param dayslotId 日期分组id
	 * @return 布尔值
	 * @throws BizException
	 * @author zhengcm
	 */
	public boolean exec(String depId, String schId, String dayslotId) throws BizException {
		ScValidator.validateParam("depId", depId);
		ScValidator.validateParam("schId", schId);
		ScValidator.validateParam("dayslotId", dayslotId);

		boolean isUsed = false;

		String where = String
				.format("id_dayslot = '%s' and id_deptparam = (select id_deptparam from sc_dep_param where id_dep = '%s')",
						dayslotId, depId);
		ScDeptParamDsDO[] deptParamDsDOs = new OralSchEP().getScDeptParamDsByCond(where, null);
		if (ArrayUtil.isEmpty(deptParamDsDOs)) {
			return isUsed;
		}
		// 参数中的结束时间
		FTime endTime = deptParamDsDOs[0].getT_end();

		where = "id_sch = ?";
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(schId);
		String order = "queno desc";
		ScSchTickDO[] tickDOs = new OralSchEP().getSchTickByCond(where, order, param);

		if (ArrayUtil.isEmpty(tickDOs)) {
			return isUsed;
		}
		// 结束时间大于参数结束时间的号位为加号
		if (tickDOs[0].getT_e().compareTo(endTime) > 0 && tickDOs[0].getEu_used() == EuUseState.SY) {
			isUsed = true;
		}
		return isUsed;
	}
}
