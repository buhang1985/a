package iih.en.pv.s.listener.ip.mp;

import iih.bd.bc.event.pub.IMpEventConst;
import iih.bd.bc.udi.pub.IMpNsDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.mp.nr.foreign.d.ForEnTemDataDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 就诊添加执行生命体征信息监听器基类
 * 
 * @author liubin
 *
 */
public abstract class EnVitalSignsMpAbstractListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//事件校验
		if(!validate(event))
			return;
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		ForEnTemDataDTO[] temDatas = (ForEnTemDataDTO[]) bizUserObj.getUserObj();
		if(EnValidator.isEmpty(temDatas))
			return;
		//过滤体征项
		ForEnTemDataDTO[] datas = filter(temDatas);
		if(EnValidator.isEmpty(datas))
			return;
		//处理
		doYourAction(datas);
	}
	/**
	 * 过滤体征项
	 * 
	 * @param datas
	 * @return
	 * @throws BizException
	 */
	public abstract ForEnTemDataDTO[] filter(ForEnTemDataDTO[] datas) throws BizException;
	/**
	 * 自己业务
	 * 
	 * @param datas
	 * @throws BizException
	 */
	public abstract void doYourAction(ForEnTemDataDTO[] datas) throws BizException;
	/**
	 * 校验
	 * 
	 * @param event
	 */
	private Boolean validate(IBusinessEvent event){
		return IMpNsDictCodeConst.EVENT_MP_EN_TEMDATA.equals(event.getSourceID()) && IMpEventConst.SD_VS_DATA.equals(event.getEventType());
	}

}
