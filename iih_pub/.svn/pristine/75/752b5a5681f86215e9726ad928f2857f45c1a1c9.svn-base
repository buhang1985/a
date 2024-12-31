package iih.bd.mm.listener;


import iih.bd.bc.udi.pub.IBdMmDictCodeConst;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.d.desc.UdidocDODesc;
import xap.sys.xbd.udi.i.IUdidoclistRService;

public abstract class AbstractUdidocListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		//事件源及事件类型判断 
		if(!(event.getSourceID().equals(UdidocDODesc.CLASS_FULLNAME)
			&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
		
		//物品类型数据及空判断逻辑
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		
		//获得物品类型数据信息
		UdidocDO[] ors=getOrdInfo8Status(newObjs);
		if(ors==null || ors.length==0)
			return;
		
		//实现自身业务逻辑
		doYourActionAfter(ors);
		
	}
	/**
	 * 实现自身业务逻辑
	 * @param ors
	 * @throws BizException 
	 */
	protected abstract void doYourActionAfter(UdidocDO[] ors)  throws BizException;

	protected UdidocDO[] getOrdInfo8Status(Object[] newObjs) throws BizException {
		UdidocDO ordo;
		ArrayList<UdidocDO> rtn=new ArrayList<UdidocDO>();
		
		//遍历
		for(Object obj: newObjs ){
			ordo=(UdidocDO) obj;
			
			//是否为物品类型
			if(!isSpecificOrder(ordo))continue;
			
			//加入列表中
			rtn.add(ordo);
	}
		//空判断
		if(rtn==null || rtn.size()==0)return null;
				
		//返回值
		return rtn.toArray(new UdidocDO[0]);
		
	}
	/**
	 * 获得物品类型信息
	 * @param newObjs
	 * @return
	 * @throws BizException 
	 */
	private boolean isSpecificOrder(UdidocDO ordo) throws BizException {
		if(ordo == null)
		{return false;}
		//获取主DO
		UdidoclistDO udidoclistDo = getudidocListDo(ordo);
		if(udidoclistDo == null)
		{
			return false;
		}
		if(udidoclistDo.getCode().equals(IBdMmDictCodeConst.SD_MMTP))
		{
			return true;
		}
		return false;
	}
	
	
	private UdidoclistDO getudidocListDo(UdidocDO ordo) throws BizException {
		IUdidoclistRService service =  ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO udidoclistDo = service.findById(ordo.getId_udidoclist());
		
		return udidoclistDo;
	}
}
	
