package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.dto.d.AnalyseResult;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 分析已经存在的排班 已使用的，或已过时的排班，不能删除，不能覆盖
 * 
 * @author yank
 *
 */
public class AnalyseExistedSchBP {
	/**
	 * 删除未使用的排班
	 * 
	 * @param planIds 排班计划ID集合
	 * @param schDateList 排班日期集合
	 * @throws BizException
	 */
	public AnalyseResult exec(String[] planIds, FDate[] schDateList) throws BizException {
		AnalyseResult result = new AnalyseResult();
		List<ScSchDO> schList = this.getExitedSch(planIds, schDateList);
		if (ListUtil.isEmpty(schList)) {
			return result;
		}
		// 分析
		SchEP schEP = new SchEP();
		FDateTime currentTime = ScAppUtils.getServerDateTime();
		for (ScSchDO schDO : schList) {
			if (schEP.isUsed(schDO) || schEP.isPast(schDO, currentTime)) {
				result.getUsedOrPastSchList().add(schDO);
			} else {
				result.getCanDeleteSchIdList().add(schDO.getId_sch());
			}
			result.getExistedSchList().add(schDO);
		}
		return result;
	}

	/**
	 * 获取已有的排班数据
	 * 
	 * @param planIds 计划ID集合
	 * @param schDateList 排班日期集合
	 * @return 排班集合
	 * @throws BizException
	 */
	private List<ScSchDO> getExitedSch(String[] planIds, FDate[] schDateList) throws BizException {
		if(ArrayUtil.isEmpty(planIds) || ArrayUtil.isEmpty(schDateList)){
			return null;
		}
		List<String> schDateStrList = new ArrayList<String>();
		for (FDate date : schDateList) {
			schDateStrList.add(date.toLocalString());
		}

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_SCH,ID_SCPL,D_SCH,ID_DAYSLOT,T_E_REG,QUAN_TOTAL_USED ");
		sqlBuilder.append(" FROM SC_SCH ");
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(ScSqlUtils.getInSqlByIds("ID_SCPL", Arrays.asList(planIds)));
		sqlBuilder.append(" AND ");
		sqlBuilder.append(ScSqlUtils.getInSqlByIds("D_SCH", schDateStrList));

		List<ScSchDO> schList = (List<ScSchDO>) new DAFacade().execQuery(sqlBuilder.toString(), null,
				new BeanListHandler(ScSchDO.class));
		return schList;
	}
}
