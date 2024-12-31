package iih.nm.nit.nitlv.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitlv.d.NitLvDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 实习生请假数据维护服务
*/
public interface INitlvCudService {
	/**
	*  实习生请假数据真删除
	*/
    public abstract void delete(NitLvDO[] aggdos) throws BizException;
    
    /**
	*  实习生请假数据插入保存
	*/
	public abstract NitLvDO[] insert(NitLvDO[] aggdos) throws BizException;
	
    /**
	*  实习生请假数据保存
	*/
	public abstract NitLvDO[] save(NitLvDO[] aggdos) throws BizException;
	
    /**
	*  实习生请假数据更新
	*/
	public abstract NitLvDO[] update(NitLvDO[] aggdos) throws BizException;
	
	/**
	*  实习生请假数据逻辑删除
	*/
	public abstract void logicDelete(NitLvDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NitLvDO[] enableWithoutFilter(NitLvDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NitLvDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NitLvDO[] disableVOWithoutFilter(NitLvDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NitLvDO[] dos) throws BizException ;
}
