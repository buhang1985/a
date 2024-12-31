package iih.bd.mm.listener;

import iih.bd.bc.udi.pub.ISysDictCodeConst;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.d.desc.MeasDocDODesc;

public abstract class AbstractMeasdocListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		//事件源及药品包装单位计量单位字典判断 
		if(!(event.getSourceID().equals(MeasDocDODesc.CLASS_FULLNAME)
			&& event.getEventType().equals(IEventType.TYPE_DELETE_AFTER)))return;
		
		//物品类型数据及空判断逻辑
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		
		//获得药品包装单位计量单位字典数据信息
		MeasDocDO[] ors=getOrdInfo8Status(newObjs);
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
	protected abstract void doYourActionAfter(MeasDocDO[] ors)  throws BizException;

	private MeasDocDO[] getOrdInfo8Status(Object[] newObjs) {
		MeasDocDO ordo;
		ArrayList<MeasDocDO> rtn=new ArrayList<MeasDocDO>();
		
		//遍历
		for(Object obj: newObjs ){
			ordo=(MeasDocDO) obj;
			
			//是否为药品包装单位计量单位
			if(!isSpecificOrder(ordo))continue;
			
			//加入列表中
			rtn.add(ordo);
	}
		//空判断
		if(rtn==null || rtn.size()==0)return null;
				
		//返回值
		return rtn.toArray(new MeasDocDO[0]);
	}

	private boolean isSpecificOrder(MeasDocDO ordo) {
		if(ordo == null)
		{return false;}
		if(ordo.getSd_oppdimen().equals(ISysDictCodeConst.SD_OPPDIMEN_B))
		{
			return true;
		}
		return false;
	}
}
