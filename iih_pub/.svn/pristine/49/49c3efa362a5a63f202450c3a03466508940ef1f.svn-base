package iih.mp.ot.otoradd.i;

import xap.mw.core.data.BizException;
import iih.mp.ot.otoradd.d.MpOtOrAddDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医技补录项目暂存实体数据维护服务
*/
public interface IOtoraddCudService {
	/**
	*  医技补录项目暂存实体数据真删除
	*/
    public abstract void delete(MpOtOrAddDO[] aggdos) throws BizException;
    
    /**
	*  医技补录项目暂存实体数据插入保存
	*/
	public abstract MpOtOrAddDO[] insert(MpOtOrAddDO[] aggdos) throws BizException;
	
    /**
	*  医技补录项目暂存实体数据保存
	*/
	public abstract MpOtOrAddDO[] save(MpOtOrAddDO[] aggdos) throws BizException;
	
    /**
	*  医技补录项目暂存实体数据更新
	*/
	public abstract MpOtOrAddDO[] update(MpOtOrAddDO[] aggdos) throws BizException;
	
	/**
	*  医技补录项目暂存实体数据逻辑删除
	*/
	public abstract void logicDelete(MpOtOrAddDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpOtOrAddDO[] enableWithoutFilter(MpOtOrAddDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpOtOrAddDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpOtOrAddDO[] disableVOWithoutFilter(MpOtOrAddDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpOtOrAddDO[] dos) throws BizException ;
}
