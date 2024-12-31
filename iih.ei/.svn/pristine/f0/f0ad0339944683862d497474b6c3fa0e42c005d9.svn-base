package iih.ei.std.cr_technology.v1.s.bp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasFindMpPlansMpPlanBean;
import iih.ei.std.cr_technology.v1.d.PivasFindMpPlansParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindMpPlansResultBean;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindMpPlansQry;
import xap.mw.core.data.BizException;

/**
 * Pivas查询药品执行计划业务逻辑
 * 
 * @author hao_wu 2018-6-26
 *
 */
public class PivasFindMpPlansBp {

	public PivasFindMpPlansResultBean exec(PivasFindMpPlansParamBean paramBean) throws BizException {
		if (StringUtils.isEmpty(paramBean.getsDate())) {
			throw new BizException("开始日期不允许为空。");
		}
		if (StringUtils.isEmpty(paramBean.geteDate())) {
			throw new BizException("结束日期不允许为空。");
		}

		Pattern pattern = Pattern.compile("^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$");
		Matcher matcher = pattern.matcher(paramBean.getsDate());
		if (!matcher.find()) {
			throw new BizException("开始日期格式不正确,标准格式\"2099-01-01\"。");
		}

		matcher = pattern.matcher(paramBean.geteDate());
		if (!matcher.find()) {
			throw new BizException("结束日期格式不正确,标准格式\"2099-01-01\"。");
		}
		
		//初始化上下文
		initContext();
		//构建返回结果
		PivasFindMpPlansResultBean result = findMpPlans(paramBean);
		return result;
	}

	/**
	 * 初始化上下文
	 * 
	 * @throws BizException
	 */
	private void initContext() throws BizException {
		//静配中新科室编码
		String deptCode = "600902";
		InitContextByDepBp bp = new InitContextByDepBp();
		bp.exec(deptCode);
	}

	/**
	 * 查询药品执行计划
	 * 
	 * @param paramBean
	 * @return
	 * @throws BizException
	 */
	private PivasFindMpPlansResultBean findMpPlans(PivasFindMpPlansParamBean paramBean) throws BizException {
		PivasFindMpPlansQry qry = new PivasFindMpPlansQry(paramBean);
		PivasFindMpPlansMpPlanBean[] mpPlanBeans = CommDAFacade.execQuery(qry, PivasFindMpPlansMpPlanBean.class);

		PivasFindMpPlansResultBean result = new PivasFindMpPlansResultBean();
		result.setMpPlans(mpPlanBeans);
		return result;
	}

}
