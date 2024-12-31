package iih.bl.comm.util;

import java.util.HashMap;
import java.util.Map;

import iih.bl.params.BlParamConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;

/**
 * 费用域流程参数批量加载器
 * @author ly 2018/12/04
 *
 */
public class BlFlowParamLoader {

	/**
	 * 加载住院记账流程参数
	 * @throws BizException
	 */
	public void loadIpKeepAccountParam() throws BizException{
		
		String[] usedOrgParam = new String[] { BlParamConst.BLAC000001,
				BlParamConst.BLAC000002, BlParamConst.BLSTIP0022,
				BlParamConst.BLSTIP0026 };
		@SuppressWarnings("rawtypes")
		Map<String,Class> paramClassMap = new HashMap<String,Class>();
		paramClassMap.put(BlParamConst.BLAC000001, FBoolean.class);
		paramClassMap.put(BlParamConst.BLAC000002, FBoolean.class);
		paramClassMap.put(BlParamConst.BLSTIP0022, FBoolean.class);
		paramClassMap.put(BlParamConst.BLSTIP0026, FBoolean.class);
		
		BlFlowContextUtil.loadFlowParam(Context.get().getOrgId(), FBoolean.FALSE, usedOrgParam, paramClassMap);
	}
	
	/**
	 * 加载门诊调入流程参数
	 * @throws BizException
	 */
	public void loadOepCostParam() throws BizException{
		
		String[] usedOrgParam = new String[] { BlParamConst.BLSTOEP0004,
				BlParamConst.BLSTOEP0009,BlParamConst.BLSTOEP0010,
				BlParamConst.BLSTOEP0011,BlParamConst.BLSTOEP0012 };
		
		@SuppressWarnings("rawtypes")
		Map<String,Class> paramClassMap = new HashMap<String,Class>();
		paramClassMap.put(BlParamConst.BLSTOEP0004, Integer.class);
		paramClassMap.put(BlParamConst.BLSTOEP0009, Integer.class);
		paramClassMap.put(BlParamConst.BLSTOEP0010, Integer.class);
		paramClassMap.put(BlParamConst.BLSTOEP0011, Integer.class);
		paramClassMap.put(BlParamConst.BLSTOEP0012, Integer.class);
		
		BlFlowContextUtil.loadFlowParam(Context.get().getOrgId(), FBoolean.FALSE, usedOrgParam, paramClassMap);

	}
	
}
