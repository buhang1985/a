package iih.ci.ord.s.utils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class GetCiOrdEnInfoUtils {
	/**
	 * 判断是否是急诊，如果是返回true，如果不是返回false
	 * @param ciEms
	 * @return
	 * @throws BizException 
	 */
     public Boolean isEren(CiEmsDTO ciEms) throws BizException {
		
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		String isErenMd = null;
		String IsErenDeps = null;
//		try {
			//获取 是否急诊就诊判断方式  0 按就诊类型判断 1按科室判断  如果为null  默认为就诊类型判断
			isErenMd = ParamsetQryUtil.getParaString(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_IsErenMd);
			if("1".equals(isErenMd)){//按就诊科室判断
				//1、获取当前科室
				String dept = Context.get().getDeptId();
				//2、获取参数：急诊科室    
				IsErenDeps = ParamsetQryUtil.getParaString(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_IsErenDeps);
				//3、就诊科室里 如果存在当前科室则进行急诊规则校验
				if(IsErenDeps.contains(dept)){
					return true;  //如果当前科室是急诊科室  则不进行门诊规则校验
				}
			}
//		} catch (Exception e) {
//			OrdBizLogger.info(ctx, e.getMessage());
//		}
//		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ciEms.getCode_entp())){
//			return true;
//		}
		return false;
	}

}
