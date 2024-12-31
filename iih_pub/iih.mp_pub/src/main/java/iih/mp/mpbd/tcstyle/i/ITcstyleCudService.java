package iih.mp.mpbd.tcstyle.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.tcstyle.d.TcstyleDO;
import iih.mp.mpbd.tcstyle.d.TcstyleAggDO;

/**
* 体温单样式数据维护服务
*/
public interface ITcstyleCudService {
	/**
	*  体温单样式数据真删除
	*/
    public abstract void delete(TcstyleAggDO[] aggdos) throws BizException;
    
    /**
	*  体温单样式数据插入保存
	*/
	public abstract TcstyleAggDO[] insert(TcstyleAggDO[] aggdos) throws BizException;
	
    /**
	*  体温单样式数据保存
	*/
	public abstract TcstyleAggDO[] save(TcstyleAggDO[] aggdos) throws BizException;
	
    /**
	*  体温单样式数据更新
	*/
	public abstract TcstyleAggDO[] update(TcstyleAggDO[] aggdos) throws BizException;
	
	/**
	*  体温单样式数据逻辑删除
	*/
	public abstract void logicDelete(TcstyleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体温单样式数据真删除
	 */
	public abstract void deleteByParentDO(TcstyleDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体温单样式数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(TcstyleDO[] mainDos) throws BizException;
}
