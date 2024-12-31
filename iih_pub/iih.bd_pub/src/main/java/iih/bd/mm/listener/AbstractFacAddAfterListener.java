package iih.bd.mm.listener;

import java.util.ArrayList;

import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.supplier.d.desc.SupplierDODesc;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 生产厂商新增后侦听器抽象类。
 * @author shao_yuan
 *
 */
public abstract class AbstractFacAddAfterListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//事件源及生产厂商字典判断 
		if(!(event.getSourceID().equals(SupplierDODesc.CLASS_FULLNAME)
				&& event.getEventType().equals(IEventType.TYPE_INSERT_AFTER)))return;
			
			//生产厂商字典数据及空判断逻辑
			BDCommonEvent dbevent=(BDCommonEvent) event;	
			Object[] newObjs=dbevent.getNewObjs();
			if(ArrayUtils.isEmpty(newObjs))return;
			
			//获得生产厂商字典数据信息
			SupplierDO[] ors=getOrdInfo8Status(newObjs);
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
	protected abstract void doYourActionAfter(SupplierDO[] ors)  throws BizException;

	private SupplierDO[] getOrdInfo8Status(Object[] newObjs) {
		SupplierDO ordo;
		ArrayList<SupplierDO> rtn=new ArrayList<SupplierDO>();
		
		//遍历
		for(Object obj: newObjs ){
			ordo=(SupplierDO) obj;
			
			//是否为生产厂商
			if(!isSupplier(ordo))continue;
			
			//加入列表中
			rtn.add(ordo);
	}
		//空判断
		if(rtn==null || rtn.size()==0)return null;
				
		//返回值
		return rtn.toArray(new SupplierDO[0]);
	}

	private boolean isSupplier(SupplierDO ordo) {
		if(ordo == null)
		{return false;}
		if(ordo.getFg_fac().booleanValue())
		{
			return true;
		}
		return false;
	}

}
