package iih.bd.fc.mdwfmp.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.mdwfmp.d.MdWfMpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱流向执行参数数据维护服务
*/
public interface IMdwfmpCudService {
	/**
	*  医嘱流向执行参数数据删除
	*/
    public abstract void delete(MdWfMpDO[] aggdos) throws BizException;
    
    /**
	*  医嘱流向执行参数数据插入保存
	*/
	public abstract MdWfMpDO[] insert(MdWfMpDO[] aggdos) throws BizException;
	
    /**
	*  医嘱流向执行参数数据保存
	*/
	public abstract MdWfMpDO[] save(MdWfMpDO[] aggdos) throws BizException;
	
    /**
	*  医嘱流向执行参数数据更新
	*/
	public abstract MdWfMpDO[] update(MdWfMpDO[] aggdos) throws BizException;
	
	/**
	*  医嘱流向执行参数数据真删
	*/
	public abstract void logicDelete(MdWfMpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MdWfMpDO[] enableWithoutFilter(MdWfMpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MdWfMpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MdWfMpDO[] disableVOWithoutFilter(MdWfMpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MdWfMpDO[] aggdos) throws BizException ;
}
