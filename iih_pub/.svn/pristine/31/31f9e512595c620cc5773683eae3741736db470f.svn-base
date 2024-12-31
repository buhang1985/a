package iih.mm.utils;

import iih.bd.bc.param.IMmStParamCodeConst;
import iih.bd.utils.ContextUtils;
import iih.bd.utils.ParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 库存管理域参数工具类
 * 
 * @author hao_wu
 *
 */
public class MmStParamUtils {

	/**
	 * 获取是否开启虚拟库存
	 * 
	 * 
	 * @return 是否开启虚拟库存
	 * @throws BizException
	 */
	public static FBoolean GetOpenVirtualStock() throws BizException {
		FBoolean paramValue = ParamUtils.GetOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IMmStParamCodeConst.OPENVIRTUALSTOCK);
		return paramValue;
	}

	/**
	 * 获取虚拟入库数量
	 * 
	 * 
	 * @return 虚拟入库数量
	 * @throws BizException
	 */
	public static Integer GetVirtualStockInQuan() throws BizException {
		Integer paramValue = ParamUtils.GetOrgParamIntegerValue(ContextUtils.getOrgId(),
				IMmStParamCodeConst.VIRTUALSTOCKINQUAN);
		return paramValue;
	}
}
