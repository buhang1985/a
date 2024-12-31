package iih.ci.ord.s.ems.op.order.copy.copylistener;

import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
/**
 * 医嘱复制，拼接医嘱内容公共监听类
 * 复制的备注，只有草药的可以有，别的不拼接
 * @author F
 *
 * @date 2019年12月17日下午3:50:03
 *
 * @classpath iih.ci.ord.s.ems.op.order.copy.copylistener.OrderCopyContentOrAbstractListener
 */
public abstract class OrderCopyContentOrAbstractListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【医嘱复制公共监听类】");
		if(CiOrdUtils.isEmpty(event))return;
		//是否满足事件源和事件类型
		if(!isMatchSourceIdAndEventType(event)) return;
		//转换获取到的数据
		transformData(event);
		doYourAction(event);
	}
	/**
	 * 事件源和事件类型判断
	 * @param event
	 * @return
	 * @throws BizException
	 */
	public abstract boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException;
	/**
	 * 数据转换
	 * @param event
	 * @throws BizException
	 */
	public abstract void transformData(IBusinessEvent event)throws BizException;
	/**
	 * 逻辑实现
	 * @param event
	 * @throws BizException
	 */
	public abstract void doYourAction(IBusinessEvent event) throws BizException ;
	/**
	 * 封装返回数据的对象
	 */
	private CiOrContentDO ciOrContentDO;
	/**
	 * 所传整体参数(内可能包含多个对象)
	 */
	private BaseDTO param;
	public CiOrContentDO getCiOrContentDO() {
		return ciOrContentDO;
	}
	public void setCiOrContentDO(CiOrContentDO ciOrContentDO) {
		this.ciOrContentDO = ciOrContentDO;
	}
	public BaseDTO getParam() {
		return param;
	}
	public void setParam(BaseDTO param) {
		this.param = param;
	}
	
}
