package iih.sc.apt.s.bp.op.qry;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScValidator;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 查询门诊选号预约号位或号段BP
 * 
 * @author zhengcm
 * @date 2017-01-11 11:00:33
 *
 */
public class GetOpAptTicksBP {

	/**
	 * 查询门诊选号预约号位或号段
	 *
	 * @param id_sch
	 * @param sd_tickmd
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	public FArrayList exec(String id_sch, String sd_tickmd) throws BizException {
		// 参数检查
		ScValidator.validateParam("id_sch", id_sch);
		ScValidator.validateParam("sd_tickmd", sd_tickmd);

		// 处理号位或号段
		FArrayList flist = new FArrayList();
		if (sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICK)) {
			ScSchTickDO[] tickDOs = this.getTick(id_sch);
			if (!ArrayUtil.isEmpty(tickDOs)) {
				for (ScSchTickDO tickDO : tickDOs) {
					flist.add(tickDO);
				}
			}
		} else if (sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICKS)) {
			ScSchTicksDO[] ticksDOs = this.getTicks(id_sch);
			if (!ArrayUtil.isEmpty(ticksDOs)) {
				for (ScSchTicksDO ticksDO : ticksDOs) {
					flist.add(ticksDO);
				}
			}
		}

		return flist;
	}

	/**
	 * 获取号位
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchTickDO[] getTick(String id_sch) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_sch)) {
			return null;
		}
		String cond = "id_sch = ?";
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(id_sch);
		return new OralAptEP().getSchTickByWhere(cond,param);
	}

	/**
	 * 获取号段
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchTicksDO[] getTicks(String id_sch) throws BizException {
		String cond = String.format("id_sch = '%s'", id_sch);
		return new OralAptEP().getSchTicksByWhere(cond, "t_b");
	}

}
