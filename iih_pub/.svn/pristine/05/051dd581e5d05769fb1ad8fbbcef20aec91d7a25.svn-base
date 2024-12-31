package iih.sc.scbd.schedulesrv.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.SchedulesrvAggDO;

/**
* 排班服务数据维护服务
*/
public interface ISchedulesrvCudService {
	/**
	*  排班服务数据真删除
	*/
    public abstract void delete(SchedulesrvAggDO[] aggdos) throws BizException;
    
    /**
	*  排班服务数据插入保存
	*/
	public abstract SchedulesrvAggDO[] insert(SchedulesrvAggDO[] aggdos) throws BizException;
	
    /**
	*  排班服务数据保存
	*/
	public abstract SchedulesrvAggDO[] save(SchedulesrvAggDO[] aggdos) throws BizException;
	
    /**
	*  排班服务数据更新
	*/
	public abstract SchedulesrvAggDO[] update(SchedulesrvAggDO[] aggdos) throws BizException;
	
	/**
	*  排班服务数据逻辑删除
	*/
	public abstract void logicDelete(SchedulesrvAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对排班服务数据真删除
	 */
	public abstract void deleteByParentDO(ScheduleSrvDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对排班服务数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ScheduleSrvDO[] mainDos) throws BizException;
}
