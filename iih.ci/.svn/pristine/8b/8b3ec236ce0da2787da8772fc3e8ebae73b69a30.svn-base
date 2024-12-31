package iih.ci.ord.s.bp.cfg.rulecfg.validator.drug.excessive;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.Context;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 超量开单原因 - 无超量情况<br>
 * 急诊默认最大 开药天数 3 天
 * 
 * @author HUMS
 *
 */
public class ExcessiveReasonNormalIpValidator extends AbstractExcessiveDrugValidator {

	@Override
	protected String getExcessiveReasonIdentity() {
		// 无超量情况
		return ICiDictCodeConst.ID_EXCESSIVE_REASON_NORMAL;
	}

	@Override
	protected String getExcessiveReasonMsg() {

		return "急诊";
	}

	@Override
	protected int getDefaultUseDays() {
		return 3;
	}

	@Override
	protected boolean isConformToTheRules(CiEmsDTO ciEms) {
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		String isErenMd = null;
		String IsErenDeps = null;
		try {
			//获取 是否急诊就诊判断方式  0 按就诊类型判断 1按科室判断  如果为null  默认为就诊类型判断
			isErenMd = ParamsetQryUtil.getParaString(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_IsErenMd);
			if("1".equals(isErenMd)){
				//按就诊科室判断
				//1、获取当前科室
				String dept = Context.get().getDeptId();
				//2、获取急诊科室    
				IsErenDeps = ParamsetQryUtil.getParaString(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_IsErenDeps);
				//3、就诊科室里 如果存在当前科室则进行急诊规则校验
				if(IsErenDeps.contains(dept)){
					return true;
				}
			}
		} catch (Exception e) {
			OrdBizLogger.info(ctx, e.getMessage() );
		}
		if(ciEms.getCode_entp().startsWith(IBdFcDictCodeConst.SD_CODE_ENTP_ET)){
			return true;
		}
		return false;
	}
}
