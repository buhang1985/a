package iih.ei.std.s.v1.bp.pe.updatastatus;

import java.util.ArrayList;
import java.util.List;

import iih.ei.std.d.v1.mp.updatestatus.d.OrderstateDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.StatusContrastDTO;
import iih.ei.std.s.v1.bp.mp.updatastatus.qry.GetOrpltpFuncSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetPeStatusContractNewBp {
	
	/**
	 * 主入口
	 * 
	 * @param params
	 * @param code_org厂商s
	 * @param code_product产品
	 * @return
	 * @throws BizException
	 */
	public StatusContrastDTO[] exec(OrderstateDTO[] params, String code_org, String code_product) throws BizException {
		
		// 1、基础校验
		if (!validation(params, code_org, code_product)) {
			return null;
		}
		
		// 2、获取不重复的状态集合
		String[] status = getStatus(params);
		
		// 3.获取对照关系
		StatusContrastDTO[] rtns = getContrast(status, code_org, code_product);
		return rtns;
	}

	private boolean validation(OrderstateDTO[] params, String code_org, String code_product) {
		if (params == null || params.length < 1) {
			return false;
		}

		if (StringUtil.isEmptyWithTrim(code_org)) {
			return false;
		}

		if (StringUtil.isEmptyWithTrim(code_product)) {
			return false;
		}

		return true;
	}

	/**
	 * 获取不重复的状态集合
	 * @param params
	 * @return
	 */
	private String[] getStatus(OrderstateDTO[] params) {
		List<String> reList = new ArrayList<String>();
		for (OrderstateDTO param : params) {
			if (!reList.contains(param.getCode_status())) {
				reList.add(param.getCode_status());
			}
		}
		return reList.toArray(new String[reList.size()]);
	}

	/**
	 * 获取状态对照关系
	 * @param status
	 * @param code_org
	 * @param code_product
	 * @return
	 * @throws BizException 
	 */
	private StatusContrastDTO[] getContrast(String[] status, String code_org, String code_product) throws BizException {
		GetOrpltpFuncSql sql = new GetOrpltpFuncSql(status, code_org, code_product);
		StatusContrastDTO[] rtns = (StatusContrastDTO[]) AppFwUtil.getDORstWithDao(sql, StatusContrastDTO.class);
		return rtns;
	}
}
