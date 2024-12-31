package iih.bl.comm.util;

import java.util.HashMap;
import java.util.Map;

import iih.bd.base.utils.AppUtils;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.comm.log.BLBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.paramset.i.IParamsetRServiceExt;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 费用流程上下文帮助类
 * @author ly 2018/07/23
 *
 */
public class BlFlowContextUtil {

	/**
	 * 获取上下文当前时间
	 * @return
	 */
	public static FDateTime getNowTime() {
		if(Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_NOW) == null){
			Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_NOW, AppUtils.getServerDateTime());
		}
		return (FDateTime)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_NOW);
	}
	
	/**
	 * 加载本次流程使用的参数
	 * 用于一个流程处理开始时
	 * 一次只能取一种类型参数：比如组织参数，实体参数
	 * @param instance 组织或实体id
	 * @param fgInst 是否实体参数
	 * @param params 参数编码
	 * @param paramClassMap 参数对应类型
	 */
	@SuppressWarnings("rawtypes")
	public static void loadFlowParam(String instance,FBoolean fgInst, String[] params, Map<String, Class> paramClassMap) throws BizException{
	
		Map<String,String> paramMap = new HashMap<String,String>();
		if(FBoolean.TRUE.equals(fgInst)){
			paramMap = ParamsetQryUtil.getParasStringByInstance(instance, params);
		}else{
			IParamsetRServiceExt paramServiceExt = ServiceFinder.find(IParamsetRServiceExt.class);
			paramMap = paramServiceExt.queryBatchParaValues(instance, params);
		}
		
		if(paramMap == null)
			return;
		
		for (String paramCode : paramMap.keySet()) {
			
			Class type = paramClassMap.get(paramCode);
			String paramValue = paramMap.get(paramCode);
			String key = IBlFlowKeyConst.BL_FLOW_KEY + paramCode + instance;
			
			try {
				if(type == String.class){
					Context.get().setAttribute(key, paramValue);
				}else if(type == Integer.class){
					Integer intValue = Integer.valueOf(paramValue);
					Context.get().setAttribute(key, intValue);
				}else if(type == FDouble.class){
					FDouble dblValue = new FDouble(paramValue);
					Context.get().setAttribute(key, dblValue);
				}else if(type == FBoolean.class){
					FBoolean boolValue = new FBoolean(paramValue);
					Context.get().setAttribute(key, boolValue);
				}else{
					Context.get().setAttribute(key, paramValue);
				}	
			} catch (Exception e) {
				BLBizLogger.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * 获取操作人员
	 * @return
	 * @throws BizException
	 * @author ly 2020/01/17
	 */
	public static String getEmpId() throws BizException{
		String empId = Context.get().getStuffId();
		String flowEmpId = Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_ID_EMP, String.class);
		if(!StringUtil.isEmpty(flowEmpId)){
			empId = flowEmpId;
		}
		return empId;
	}
}
