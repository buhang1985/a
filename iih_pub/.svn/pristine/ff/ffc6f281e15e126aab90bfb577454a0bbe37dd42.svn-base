package iih.en.pv.pub.listener;

import iih.en.pv.dto.d.EnHosRegDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 住院登记抽象监听器
 * @author yank
 *
 */
public abstract class AbstractIpRegListener implements IBusinessListener{
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		BDCommonEvent dbevent = (BDCommonEvent) event;
		Object[] newObjs = dbevent.getNewObjs();
		if(ArrayUtil.isEmpty(newObjs)){
			return;
		}
		
		EnHosRegDTO ipRegDTO = (EnHosRegDTO)newObjs[0]; 
		
		// 执行出院后命令
		this.doActionAfterIpReg(ipRegDTO);
	}
	/**
	 * 住院登记后，执行其他业务处理
	 * @param ipDOs
	 * @throws BizException 
	 */
	protected abstract void doActionAfterIpReg(EnHosRegDTO ipRegDTO) throws BizException;
}
