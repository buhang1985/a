package iih.bd.srv.medsrv.refs.sql.op;

import xap.lui.core.cache.XapCacheMgr;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 门诊服务参照药品显示模式
 * @author zhangwq
 *
 */
public class DrugCheckDisplayMd4OP {
	private static DrugCheckDisplayMd4OP drugCheckDisplayMd4OP;
	private DrugCheckDisplayMd4OP(){
	}
	public static DrugCheckDisplayMd4OP getInstance()	{
		if(drugCheckDisplayMd4OP==null){
			drugCheckDisplayMd4OP = new DrugCheckDisplayMd4OP();
		}
		return drugCheckDisplayMd4OP;
	}
	/**
	 * 获得门诊服务参照药品显示模式值
	 * @return
	 */
	public String getDrugCheckDisplayMd4OP(){
		String key = MakeRedisKey(Context.get().getGroupId(), Context.get().getOrgId(), DrugCheckDisplayMd4OP.class.getName(), DrugCheckDisplayMd4OP.class.getName());
		String id_org = Context.get().getOrgId();
		if(XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4OP.class.getName()).containsKey(key)){
			return (String)XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4OP.class.getName()).get(key);
		}else{
			try {
				String str = ParamsetQryUtil.getParaString(id_org,"CIOR0423");
				XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4OP.class.getName()).put(key, str);
			} catch (BizException e) {
				XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4OP.class.getName()).put(key, "11");
			}	
		}
		return (String)XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4OP.class.getName()).get(key);
	}
	public static void clear(){
		XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4OP.class.getName()).clear();
	}
	/**
	 * 构建Redis缓存key
	 * 
	 * @param sid
	 * @param key
	 * @return
	 */
	public static String MakeRedisKey(String groupID, String orgID, String sid, String key) {
		return String.format("%s/%s/%s@%s", groupID, orgID, sid, key);
	}
}
