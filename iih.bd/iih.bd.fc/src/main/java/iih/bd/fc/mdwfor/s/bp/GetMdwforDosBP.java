package iih.bd.fc.mdwfor.s.bp;

import iih.bd.fc.mdwfor.d.MdWfOrDO;
import iih.bd.fc.mdwfor.s.bp.qry.MdwforQry;
import iih.bd.fc.wforqry.d.WforQryCondDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据医嘱开立查询条件获取医嘱开立操作BP
 */
public class GetMdwforDosBP {

	/**
	 * 根据医嘱开立查询条件获取医嘱开立信息
	 * 
	 * @param cond
	 *            医嘱开立查询条件DTO
	 * @return 医嘱开立DO
	 * @throws BizException
	 */
	public MdWfOrDO[] exec(WforQryCondDTO cond) throws BizException {
		if (!isValidate(cond))
			return null;

		MdwforQry qry = new MdwforQry(cond);
		MdWfOrDO[] rtn = (MdWfOrDO[]) AppFwUtil.getDORstWithDao(qry,
				MdWfOrDO.class);
		return rtn;
	}

	/**
	 * 有效性校验
	 * 
	 * @param cond
	 * @return
	 */
	private boolean isValidate(WforQryCondDTO cond) {
		if (cond == null)
			return false;
		return true;
	}
}
