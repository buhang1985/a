package iih.ci.ord.s.ems.cache;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.meta.StringList;

/**
 * 基础缓存处理
 * @author wangqingzhu
 *
 */
public class BaseCacheAction  {
	/**
	 * 准备L2缓存
	 * @param key
	 * @param ctx
	 * @return
	 */
	public boolean prepareCacheL2(CiEnContextDTO ctx ){
		
		return false;
	}
	
	/**
	 * 准备L3缓存
	 * @param key
	 * @param ctx
	 * @return
	 */
	public boolean prepareCacheL3(CiEnContextDTO ctx){
		
		return false;
	}
	
	/**
	 * 准备医疗单L2缓存
	 * @param key
	 * @param ctx
	 * @return
	 */
	public boolean prepareCacheL2(CiEnContextDTO ctx, StringList ids){
		
		return false;
	}
	
	/**
	 * 准备医疗单L3缓存
	 * @param key
	 * @param ctx
	 * @return
	 */
	public boolean prepareCacheL3(CiEnContextDTO ctx, StringList ids){
		
		return false;
	}
	
}
