package iih.mi.itf2.factory;

import iih.mi.itf2.bizflowitf.IBdFlowItf;
import iih.mi.itf2.bizflowitf.IOepFlowItf;
import iih.mi.itf2.dto.MiContext;

/**
 * 医保平台抽象工厂
 * @author ly
 *
 */
public abstract class MiAbstractFactory {

	/**
	 * 实例化基础数据接口
	 * @param context
	 * @return
	 */
	public abstract IBdFlowItf createIBdFlowItfInstance(MiContext context);
	
	/**
	 * 实例化门诊医保接口
	 * @param context
	 * @return
	 */
	public abstract IOepFlowItf createIOepFlowItfInstance(MiContext context);
}
