package iih.bd.pp.modifypriplan.s.bp;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.utils.BdPpParamUtils;
import iih.bd.utils.log.BdPpLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据计划主键集合进行调价</br>
 * 参数可为空，为空时对所有满足调价要求的计划进行调价
 * 
 * @author hao_wu 2019-3-26
 *
 */
public class ModifyPriceByPlanIdsBp {

	public void exec(String[] planIds, FDateTime endDt) throws BizException {
		// 1.获取未完成的调价计划
		String[] noCompletePlanIds = this.getNoCompletePlanIds(planIds, endDt);
		if (ArrayUtils.isEmpty(noCompletePlanIds)) {
			if (BdPpParamUtils.getBgTaskModifyPriFlag()) {
				String msg = String.format("未查询到待调价计划，截止时间:%s.", endDt);
				throw new BizException(msg);
			} else {
				String msg = "所选调价计划不满足调价要求，请确认所选调价计划计划调价时间小于当前时间且已启用。";
				throw new BizException(msg);
			}
		}

		// 2.按计划调整价格
		StringBuilder errorMsgBuilder = new StringBuilder();
		for (String planId : noCompletePlanIds) {
			try {
				modifyPrice(planId);
			} catch (Exception e) {
				BdPpLogUtils.logEx(e);
				errorMsgBuilder.append(e.getMessage());
				errorMsgBuilder.append(System.getProperty("line.separator"));
			}
		}
		if (errorMsgBuilder.length() > 0) {
			// 各任务不相互影响，错误信息统一抛异常
			throw new BizException(errorMsgBuilder.toString());
		}
	}

	/**
	 * 获取未完成的调价计划
	 * 
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private String[] getNoCompletePlanIds(String[] planIds, FDateTime endDt) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = "fg_active = 'Y' and fg_complete = 'N'";
		wherePartBuilder.append(wherePart);

		SqlParam sqlParam = new SqlParam();
		if (endDt != null) {
			wherePartBuilder.append(" and dt_modifypriplan <= ?");
			sqlParam.addParam(endDt);
		}

		if (ArrayUtils.isNotEmpty(planIds)) {
			wherePart = SqlUtils.getInSqlByIds(ModifyPriPlanDO.ID_MODIFYPRIPLAN, planIds);
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		String sql = String.format("select Id_modifypriplan from bd_modify_pri_plan where %s",
				wherePartBuilder.toString());

		DAFacade daFacade = new DAFacade();
		List<String> planIdList = (List<String>) daFacade.execQuery(sql, sqlParam, new ColumnListHandler());
		return planIdList.toArray(new String[0]);
	}

	/**
	 * 修改价格
	 * 
	 * @param planAgg
	 * @throws BizException
	 */
	private void modifyPrice(String planId) throws BizException {
		ModifyPriceByPlanIdBp bp = new ModifyPriceByPlanIdBp();
		bp.exec(planId);
	}
}
