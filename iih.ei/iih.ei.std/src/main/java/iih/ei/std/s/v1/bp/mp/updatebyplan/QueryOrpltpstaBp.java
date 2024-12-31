package iih.ei.std.s.v1.bp.mp.updatebyplan;

import iih.ei.std.s.v1.bp.mp.updatebyplan.qry.GetOrpltpFuncByStatusSql;
import iih.mp.nr.api.d.StatusContrastDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据闭环类型和状态编码查询闭环功能对照
 * @author hjh
 *
 */
public class QueryOrpltpstaBp {
	/**
	 * 主入口
	 * 
	 * @param params
	 * @param code_org厂商s
	 * @param code_product产品
	 * @return
	 * @throws BizException
	 */
	public StatusContrastDTO[] exec(String code_status,String id_orpltp) throws BizException {

		// 1、基础校验
		if (!validation(code_status, id_orpltp)) {
			return null;
		}

		// 3、获取状态对照关系
		StatusContrastDTO[] rtns = getContrast(code_status,id_orpltp);
		
		return rtns;
	}

	/**
	 * 基础校验
	 * 
	 * @param params
	 * @return
	 */
	private boolean validation(String code_status,String id_orpltp) {

		if (StringUtil.isEmptyWithTrim(code_status)) {
			return false;
		}

		if (StringUtil.isEmptyWithTrim(id_orpltp)) {
			return false;
		}

		return true;
	}

	/**
	 * 获取状态对照关系
	 * 
	 * @param status
	 * @param code_org
	 * @param code_product
	 * @return
	 * @throws BizException
	 */
	private StatusContrastDTO[] getContrast(String code_status,String id_orpltp) throws BizException {
		GetOrpltpFuncByStatusSql sql = new GetOrpltpFuncByStatusSql(code_status,id_orpltp);
		StatusContrastDTO[] rtns = (StatusContrastDTO[]) AppFwUtil.getDORstWithDao(sql, StatusContrastDTO.class);
		return rtns;
	}
}
