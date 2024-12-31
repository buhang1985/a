package iih.mp.mpbd.mpskd.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.mpskd.d.MpSkdDO;
import iih.mp.mpbd.mpskd.d.MpskdAggDO;

/**
* 护理任务定义数据维护服务
*/
public interface IMpskdCudService {
	/**
	*  护理任务定义数据真删除
	*/
    public abstract void delete(MpskdAggDO[] aggdos) throws BizException;
    
    /**
	*  护理任务定义数据插入保存
	*/
	public abstract MpskdAggDO[] insert(MpskdAggDO[] aggdos) throws BizException;
	
    /**
	*  护理任务定义数据保存
	*/
	public abstract MpskdAggDO[] save(MpskdAggDO[] aggdos) throws BizException;
	
    /**
	*  护理任务定义数据更新
	*/
	public abstract MpskdAggDO[] update(MpskdAggDO[] aggdos) throws BizException;
	
	/**
	*  护理任务定义数据逻辑删除
	*/
	public abstract void logicDelete(MpskdAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理任务定义数据真删除
	 */
	public abstract void deleteByParentDO(MpSkdDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理任务定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MpSkdDO[] mainDos) throws BizException;
}
