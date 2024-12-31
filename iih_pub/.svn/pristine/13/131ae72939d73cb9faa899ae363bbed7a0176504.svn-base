package iih.bd.srv.i;

import java.util.Map;

/**
 * 同步参考价格接口
 * @author qzwang
 *
 */
public interface ISyncBdSrvPriceService {

	/**
	 * 同步数据库中所有符合要求的服务价格和物品价格
	 * @return
	 */
	public abstract boolean SyncBdSrvPrice();
	
	/**
	 * 同步给定服务的参考价格
	 * @param id_srv
	 * @return
	 */
	public boolean SyncBdSrvPrice(String id_srv);
	
	/**
	 * 2017-07-26 09:23:37 by yzh
	 * 患者价格维护模块——>手工价格同步按钮——>调用后台价格任务SyncBdSrvPriceTask
	 * @param map 操作来源 key:operate 01 患者价格分类 02 价表维护
	 * @return
	 */
	public boolean SyncBdSrvPriceEx(Map<String,Object> map);
}
