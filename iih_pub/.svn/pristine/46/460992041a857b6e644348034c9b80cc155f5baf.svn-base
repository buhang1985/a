package iih.ci.ord.i.custom.diseasedes;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 临床病症及体征客开接口基类
 * @author zhangwanqing
 *
 */
public abstract class BaseDiseaseDesListener implements IBusinessListener  {
	public static String DiseaseDesListenerSourceId = "iih.ci.ord.DiseaseDesListener";
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if(!(DiseaseDesListenerSourceId.equals(event.getSourceID())&&IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
			return;
		}
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		String id_ent = (String)newObjs[0];
		FMap2 fmap = (FMap2)newObjs[1];
		doYourAction(id_ent,fmap);
	}
	/**
	 * 将处理结果放入第二个参数FMap2中，key=BaseDiseaseDesListener.DiseaseDesListenerSourceId
	 * @param id_ent
	 * @param fmap2 处理返回结果
	 * @throws BizException
	 */
	public abstract void doYourAction(String id_ent,FMap2 fmap2) throws BizException ;

}
