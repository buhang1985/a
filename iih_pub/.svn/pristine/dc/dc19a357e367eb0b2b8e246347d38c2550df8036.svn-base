package iih.ci.mr.nu.bgm.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.bgm.d.BgmPatInfoDO;
import iih.ci.mr.nu.bgm.d.BgmAggDO;

/**
* 血糖监测表数据维护服务
*/
public interface IBgmCudService {
	/**
	*  血糖监测表数据真删除
	*/
    public abstract void delete(BgmAggDO[] aggdos) throws BizException;
    
    /**
	*  血糖监测表数据插入保存
	*/
	public abstract BgmAggDO[] insert(BgmAggDO[] aggdos) throws BizException;
	
    /**
	*  血糖监测表数据保存
	*/
	public abstract BgmAggDO[] save(BgmAggDO[] aggdos) throws BizException;
	
    /**
	*  血糖监测表数据更新
	*/
	public abstract BgmAggDO[] update(BgmAggDO[] aggdos) throws BizException;
	
	/**
	*  血糖监测表数据逻辑删除
	*/
	public abstract void logicDelete(BgmAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对血糖监测表数据真删除
	 */
	public abstract void deleteByParentDO(BgmPatInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对血糖监测表数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BgmPatInfoDO[] mainDos) throws BizException;
}
