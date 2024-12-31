package iih.sc.pub.listener;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.OpApt4EsDTO;
import xap.ip.cfg.XipCfg;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 门诊预约短信监听器接口
 * @author yank
 *
 */
public abstract class IOpApt4EmsListener implements IBusinessListener {
	
	
	public static final String SC_NOTE_NEED_SEND_MSG = "SC0061";// 预约是否需要IIH发短信
	
	public static final String SC_CANC_APT_NEED_SEND_MSG = "SC0062";// 取消预约是否需要IIH发短信
	
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、包装APT结构
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		OpApt4EsDTO eventSourceDTO = (OpApt4EsDTO) bizUserObj.getUserObj();
		//如果是改约触发的 则预约发送短信 和 取消预约发送短信有任何一个参数时true则都发送
		if(IScDictCodeConst.SC_CHANGE_APT_OPERATE.equals(eventSourceDTO.getOperate_source())){
			if(this.getNeedSendMsg(eventSourceDTO.getId_dep_pl()) || this.getCancAptNeedSendMsg(eventSourceDTO.getId_dep_pl())){
				doYourAction(event);
			}
		}else{
			if(this.getNeedSendMsg(eventSourceDTO.getId_dep_pl())){
				doYourAction(event);
			}
		}
		
	}
	/**
	 * 获取预约是否需要IIH发短信 add by yzh 2019年8月5日15:31:00
	 * 
	 * @author yzh
	 *
	 * @param deptId
	 * @return
	 */
	private Boolean getNeedSendMsg(String deptId) {
		String paramValue = getOrgParamValue(deptId, SC_NOTE_NEED_SEND_MSG);
		return Boolean.parseBoolean(paramValue);
	}
	/**
	 * 获取取消预约是否需要IIH发短信 add by yzh 2019-08-05
	 * 
	 * @author yzh
	 *
	 * @param deptId
	 * @return
	 */
	private Boolean getCancAptNeedSendMsg(String deptId) {
		String paramValue = getOrgParamValue(deptId, SC_CANC_APT_NEED_SEND_MSG);
		return Boolean.parseBoolean(paramValue);
	}
	/**
	 * 获取组织参数 获取方法中，如果没有设置参数，则会抛异常，其实没设置也属于正常业务，所以吃掉异常
	 * 
	 * @param orgId
	 *            组织id
	 * @param paramCode
	 *            参数编码
	 * @return
	 */
	private static String getOrgParamValue(String orgId, String paramCode) {
		String val = "";
		try {
			val = ParamsetQryUtil.getParaString(orgId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return val;
	}
	protected abstract void doYourAction(IBusinessEvent event) throws BizException;
}
