package iih.mc.common.params;

import iih.bd.bc.udi.pub.IHPDictCodeConst;
import iih.bd.bc.udi.pub.IMmDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class McParams {
	
	/**
	 * 是否启用临床路径
	 * 
	 * @return
	 * @throws BizException
	 */
	public static FBoolean HPCP0502() throws BizException {

		Context ctx = Context.get();
		return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), IHPDictCodeConst.SD_HP_USING_ENABLE);
	}
	
	/**
	 * 高值耗材设备科一级库ID
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String MCHV0001() throws BizException {

		Context ctx = Context.get();
		return ParamsetQryUtil.getParaString(ctx.getOrgId(), IMmDictCodeConst.MC_ST_HVWHID);
	}
	
	/**
	 * 高值补费取价格方式
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String MCITF001() throws BizException {

		Context ctx = Context.get();
		return ParamsetQryUtil.getParaString(ctx.getOrgId(), "MCITF001");
	}
	
	/**
	 * 耗材入库采购价获取来源
	 * 药品基本信息价格=1,供应商协议价=2
	 * @return
	 * @throws BizException
	 */
	public static Integer MCDG0001() throws BizException {
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.SD_MM_PURPRICE_SOURCE);
	}
	
	/**
	 * 领用计划和申请是否通过库存获取物品信息还是仓库关系下所有物品都显示 1 仓库关系下所有物品都显示 0 只显示用库存的物品
	 * 
	 * @return
	 * @throws BizException
	 */
	public static int MCBLREF1() throws BizException {

		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(),"MCBLREF1");
	}	
	/**
	 * 采购发票模式
	 * @return
	 * @throws BizException
	 */
	public static Integer MCPO0001() throws BizException{
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaInt(ctx.getOrgId(), IMmDictCodeConst.SD_MM_PURINV_MODE);
	}
	
	
	/**
	 * 采购订单协议价模式
	 * @return
	 * @throws BizException
	 */
	public static String MCPL0005() throws BizException{
		Context ctx = Context.get();
		return ParamsetQryUtil.getParaString(ctx.getOrgId(), "MCPL0005");
	}
}
