package iih.ci.ord.pub.listener;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 健康便民门户平台消息推送
 * @author zhangwq
 *
 */
public class EhcPortalPusUtils {
	/**
	 * 
	 * @param id_ors 
	 * @param optionStyle 操作：0，签署；1，结算
	 * @throws BizException
	 */
	public static void  FireEvent(String[] id_ors,String optionStyle) throws BizException{
		if(id_ors == null || id_ors.length == 0){
			return;
		}
		Object[] params = new Object[]{id_ors,optionStyle};
		FireEvent(params);
	}
	/**
	 * 
	 * @param orders
	 * @param optionStyle 操作：0，签署；1，结算
	 * @throws BizException
	 */
	public static void FireEvent(CiOrderDO[] orders,String optionStyle) throws BizException{
		if(orders == null || orders.length == 0){
			return;
		}
		List<String> id_ors = new ArrayList<String>();
		for (CiOrderDO order : orders) {
			id_ors.add(order.getId_or());
		}
		FireEvent(id_ors.toArray(new String[0]),optionStyle);
	}
	public static void FireEvent(Object[] params) throws BizException{
		if(params == null || params.length == 0){
			return;
		}
		BDCommonEvent event = new BDCommonEvent("EhcPortalPush", IEventType.TYPE_UPDATE_AFTER, params);
		EventDispatcher.fireEvent(event);
	}
}
