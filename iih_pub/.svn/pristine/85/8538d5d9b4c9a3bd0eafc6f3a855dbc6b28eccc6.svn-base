package iih.en.pv.pub.listener;

import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 出院监听器抽象类
 * @author yank
 * @since 2016-07-12
 *
 */
public abstract class AbstractLvHosListener  implements IBusinessListener  {
	/**
	 * 执行
	 * @param event 事件
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// PV修改时候触发
		if (!(event.getSourceID().equals(PatiVisitDODesc.CLASS_FULLNAME)
				&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))
			return;

		// 获取出院记录
		PatiVisitDO[] pvDOs = getLvHosPvDOList(event);
		if (ArrayUtil.isEmpty(pvDOs))
			return;

		// 执行出院后命令
		this.doActionAfterLvHos(pvDOs);
	}
	/**
	 * 出院后，执行其他业务处理
	 * @param pvDOs
	 * @throws BizException 
	 */
	protected abstract void doActionAfterLvHos(PatiVisitDO[] pvDOs) throws BizException;
	/**
	 * 获取出院的就诊信息
	 * @param newObjs
	 * @return
	 */
	private PatiVisitDO[] getLvHosPvDOList(IBusinessEvent event) {
		BDCommonEvent dbevent = (BDCommonEvent) event;
		Object[] newObjs = dbevent.getNewObjs();
		Object[] oldObjs = dbevent.getOldObjs();
		if (ArrayUtil.isEmpty(newObjs))
			return null;

		List<PatiVisitDO> pvDOList = new ArrayList<PatiVisitDO>();
		PatiVisitDO nPvDO;
		PatiVisitDO oldPvDO;
		for (int i = 0; i < newObjs.length; i++) {
			nPvDO = (PatiVisitDO) newObjs[i];
			oldPvDO = (PatiVisitDO) oldObjs[i];
			if (isLvHos(nPvDO, oldPvDO)) {
				pvDOList.add(nPvDO);
			}
		}
		return pvDOList.toArray(new PatiVisitDO[0]);
	}
	/**
	 * 是否出院
	 * @param newPvDO 新就诊DO
	 * @param oldPvDO 旧就诊DO
	 * @return
	 */
	private boolean isLvHos(PatiVisitDO newPvDO, PatiVisitDO oldPvDO) {
		if(oldPvDO==null || newPvDO==null){
			return false;
		}
		// 由在院改为离院,且不是当日退院
		return !FBoolean.TRUE.equals(newPvDO.getFg_canc())
				&&(FBoolean.FALSE.equals(newPvDO.getFg_ip()) && FBoolean.TRUE.equals(oldPvDO.getFg_ip()));
	}
}
