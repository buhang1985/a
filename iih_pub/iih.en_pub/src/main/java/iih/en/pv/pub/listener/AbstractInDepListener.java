package iih.en.pv.pub.listener;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 入科抽象监听器
 * @author yank
 * @since 2016-07-15
 *
 */
public abstract class AbstractInDepListener  implements IBusinessListener{
	/**
	 * 执行
	 * @param event 事件
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 住院信息修改时候触发
		if (!(event.getSourceID().equals(InpatientDODesc.CLASS_FULLNAME)
				&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))
			return;

		// 获取入科记录
		InpatientDO[] ipDOs = this.getInDeptIpDOList(event);
		if (ArrayUtil.isEmpty(ipDOs))
			return;

		// 执行出院后命令
		this.doActionAfterInDept(ipDOs);
	}
	/**
	 * 入科后，执行其他业务处理
	 * @param ipDOs
	 * @throws BizException 
	 */
	protected abstract void doActionAfterInDept(InpatientDO[] ipDOs) throws BizException;
	/**
	 * 获取入科的住院信息
	 * @param newObjs
	 * @return
	 */
	private InpatientDO[] getInDeptIpDOList(IBusinessEvent event) {
		BDCommonEvent dbevent = (BDCommonEvent) event;
		Object[] newObjs = dbevent.getNewObjs();
		Object[] oldObjs = dbevent.getOldObjs();
		if (ArrayUtil.isEmpty(newObjs))
			return null;

		List<InpatientDO> ipDOList = new ArrayList<InpatientDO>();
		InpatientDO newIpDO;
		InpatientDO oldIpDO;
		for (int i = 0; i < newObjs.length; i++) {
			newIpDO = (InpatientDO) newObjs[i];
			oldIpDO = (InpatientDO) oldObjs[i];
			if (isEnterDept(newIpDO, oldIpDO)) {
				ipDOList.add(newIpDO);
			}
		}
		return ipDOList.toArray(new InpatientDO[0]);
	}
	/**
	 * 是否入科
	 * 由入院改为入科状态
	 * @param newIpDO 新住院DO
	 * @param oldIpDO 旧住院DO
	 * @return
	 */
	private boolean isEnterDept(InpatientDO newIpDO, InpatientDO oldIpDO) {
		if (newIpDO == null || oldIpDO == null) {
			return false;
		}
		return IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN.equals(oldIpDO.getSd_status())
				&& IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN.equals(newIpDO.getSd_status());
	}

}
