package iih.mp.mpbd.mprs.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.mprs.d.MpRsDO;
import iih.mp.mpbd.mprs.d.MprsAggDO;

/**
* 护士站滚屏数据维护服务
*/
public interface IMprsCudService {
	/**
	*  护士站滚屏数据真删除
	*/
    public abstract void delete(MprsAggDO[] aggdos) throws BizException;
    
    /**
	*  护士站滚屏数据插入保存
	*/
	public abstract MprsAggDO[] insert(MprsAggDO[] aggdos) throws BizException;
	
    /**
	*  护士站滚屏数据保存
	*/
	public abstract MprsAggDO[] save(MprsAggDO[] aggdos) throws BizException;
	
    /**
	*  护士站滚屏数据更新
	*/
	public abstract MprsAggDO[] update(MprsAggDO[] aggdos) throws BizException;
	
	/**
	*  护士站滚屏数据逻辑删除
	*/
	public abstract void logicDelete(MprsAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护士站滚屏数据真删除
	 */
	public abstract void deleteByParentDO(MpRsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护士站滚屏数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MpRsDO[] mainDos) throws BizException;
}
