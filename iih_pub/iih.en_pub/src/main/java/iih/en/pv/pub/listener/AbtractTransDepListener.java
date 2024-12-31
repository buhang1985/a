package iih.en.pv.pub.listener;

import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 转科监听器抽象类
 * @author yank
 * @since 2016-07-12
 *
 */
public abstract class AbtractTransDepListener implements IBusinessListener  {
	/**
	 * 执行
	 * @param event 事件
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//PV修改时候触发
		if(!(event.getSourceID().equals(PatiVisitDODesc.CLASS_FULLNAME)
			&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
		
		//获取转科记录
		PatiVisitDO[] pvDOs = getTransDepPvDOList(event);
		if(ArrayUtil.isEmpty(pvDOs))return;
		
		//执行转科后命令
		this.doActionAfterTransDept(pvDOs);
	}
	/**
	 * 出院后，执行其他业务处理
	 * @param pvDOs
	 * @throws BizException 
	 */
	protected abstract void doActionAfterTransDept(PatiVisitDO[] pvDOs) throws BizException;
	/**
	 * 获取出院的就诊信息
	 * @param newObjs
	 * @return
	 */
	private PatiVisitDO[] getTransDepPvDOList(IBusinessEvent event){
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		Object[] oldObjs = dbevent.getOldObjs();
		if(ArrayUtil.isEmpty(newObjs))return null;
		
		List<PatiVisitDO> pvDOList = new ArrayList<PatiVisitDO>();
		PatiVisitDO nPvDO;
		PatiVisitDO oldPvDO;
		for(int i=0;i<newObjs.length;i++){
			nPvDO = (PatiVisitDO)newObjs[i];
			oldPvDO =(PatiVisitDO)oldObjs[i];
			if(isTransDept(nPvDO,oldPvDO)){
				pvDOList.add(nPvDO);
			}			
		}
		return pvDOList.toArray(new PatiVisitDO[0]);
	}
	/**
	 * 是否转科
	 * 科室或病区发生改变则为转科
	 * @param newPvDO 新就诊DO
	 * @param oldPvDO 旧就诊DO
	 * @return
	 */
	private boolean isTransDept(PatiVisitDO newPvDO,PatiVisitDO oldPvDO){
		if(oldPvDO==null || newPvDO==null){
			return false;
		}
		return !(newPvDO.getId_dep_phy().equals(oldPvDO.getId_dep_phy()))
				||!(newPvDO.getId_dep_nur().equals(oldPvDO.getId_dep_nur()));
	}
}
