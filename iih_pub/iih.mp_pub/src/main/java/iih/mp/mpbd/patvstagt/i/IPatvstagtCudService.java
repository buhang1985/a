package iih.mp.mpbd.patvstagt.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.patvstagt.d.PatVsTagtDO;
import iih.mp.mpbd.patvstagt.d.PatvstagtAggDO;

/**
* 患者体征采集指标数据维护服务
*/
public interface IPatvstagtCudService {
	/**
	*  患者体征采集指标数据真删除
	*/
    public abstract void delete(PatvstagtAggDO[] aggdos) throws BizException;
    
    /**
	*  患者体征采集指标数据插入保存
	*/
	public abstract PatvstagtAggDO[] insert(PatvstagtAggDO[] aggdos) throws BizException;
	
    /**
	*  患者体征采集指标数据保存
	*/
	public abstract PatvstagtAggDO[] save(PatvstagtAggDO[] aggdos) throws BizException;
	
    /**
	*  患者体征采集指标数据更新
	*/
	public abstract PatvstagtAggDO[] update(PatvstagtAggDO[] aggdos) throws BizException;
	
	/**
	*  患者体征采集指标数据逻辑删除
	*/
	public abstract void logicDelete(PatvstagtAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者体征采集指标数据真删除
	 */
	public abstract void deleteByParentDO(PatVsTagtDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者体征采集指标数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PatVsTagtDO[] mainDos) throws BizException;
}
