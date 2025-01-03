package iih.bd.srv.medsrv.refs.sql.ip;

import org.apache.commons.lang3.StringUtils;

import xap.lui.core.cache.XapCacheMgr;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 住院服务参照显示模式
 * @author zhangwq
 *
 */
public class DrugCheckDisplayMd4IP {
	// 获得住院服务参照药品显示模式值
	public static final String SYS_PARAM_CIOR0421 = "CIOR0421";
	//获得参照药品分组显示集合模式值
	public static final String SYS_PARAM_CIOR0540 = "CIOR0540";
	
	private static DrugCheckDisplayMd4IP drugCheckDisplayMd4IP;
	private DrugCheckDisplayMd4IP(){
	}
	public static DrugCheckDisplayMd4IP getInstance()	{
		if(drugCheckDisplayMd4IP==null){
			drugCheckDisplayMd4IP = new DrugCheckDisplayMd4IP();
		}
		return drugCheckDisplayMd4IP;
	}
	/**
	 * 获得住院服务参照药品显示模式值
	 * @return
	 */
	public String getDrugCheckDisplayMd4IP(){
		String key = MakeRedisKey(Context.get().getGroupId(), Context.get().getOrgId(), DrugCheckDisplayMd4IP.class.getName(), DrugCheckDisplayMd4IP.class.getName());
		String id_org = Context.get().getOrgId();
		if(XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4IP.class.getName()).containsKey(key)){
			return (String)XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4IP.class.getName()).get(key);
		}else{
			try {
				String str = ParamsetQryUtil.getParaString(id_org,SYS_PARAM_CIOR0421);
				XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4IP.class.getName()).put(key, str);
			} catch (BizException e) {
				XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4IP.class.getName()).put(key, "11");
			}	
		}
		return (String)XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4IP.class.getName()).get(key);
	}
	public static void clear(){
		XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4IP.class.getName()).clear();
	}
	
	/**
	 * 获得参照药品分组显示集合模式值
	 * @return
	 */
	public String getDrugGroupParam(){
		String key = MakeRedisKey(Context.get().getGroupId(), Context.get().getOrgId(), DrugCheckDisplayMd4IP.class.getName(), "ParamCIOR0540");
		String id_org = Context.get().getOrgId();
		if(XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4IP.class.getName()).containsKey(key)){
			return (String)XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4IP.class.getName()).get(key);
		}else{
			try {
				String str = ParamsetQryUtil.getParaString(id_org,SYS_PARAM_CIOR0540);
				//数据校验
				if(StringUtils.isEmpty(str)) {
					str="''";
				}else {
					//数据清洗
					String[] CodeArr = str.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("，", ",").split(",");
					String strParam ="";
					for (String Code : CodeArr) {
						if(StringUtils.isNotEmpty(Code)) {
							strParam += ("'"+Code+"',");
						}
					}
					//清洗后的数据校验
					if(StringUtils.isNotEmpty(strParam)) {
						str = strParam.substring(0,strParam.length()-1);
					}else {
						str="''";
					}
				}
				XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4IP.class.getName()).put(key, str);
			} catch (BizException e) {
				XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4IP.class.getName()).put(key, "''");
			}	
		}
		return (String)XapCacheMgr.getStrongCacheAdapter(DrugCheckDisplayMd4IP.class.getName()).get(key);
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
