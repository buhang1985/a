package iih.mbh.mp.nurpatrol.i;

import xap.mw.core.data.BizException;
import iih.mbh.mp.nurpatrol.d.PatrolDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理巡房数据维护服务
*/
public interface INurpatrolCudService {
	/**
	*  护理巡房数据真删除
	*/
    public abstract void delete(PatrolDO[] aggdos) throws BizException;
    
    /**
	*  护理巡房数据插入保存
	*/
	public abstract PatrolDO[] insert(PatrolDO[] aggdos) throws BizException;
	
    /**
	*  护理巡房数据保存
	*/
	public abstract PatrolDO[] save(PatrolDO[] aggdos) throws BizException;
	
    /**
	*  护理巡房数据更新
	*/
	public abstract PatrolDO[] update(PatrolDO[] aggdos) throws BizException;
	
	/**
	*  护理巡房数据逻辑删除
	*/
	public abstract void logicDelete(PatrolDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PatrolDO[] enableWithoutFilter(PatrolDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PatrolDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PatrolDO[] disableVOWithoutFilter(PatrolDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PatrolDO[] dos) throws BizException ;
}
