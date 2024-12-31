package iih.nmr.ha.tcho.bgm.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.bgm.d.TchoBgmPatInfoDO;
import iih.nmr.ha.tcho.bgm.d.BgmAggDO;

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
	public abstract void deleteByParentDO(TchoBgmPatInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对血糖监测表数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(TchoBgmPatInfoDO[] mainDos) throws BizException;
}
