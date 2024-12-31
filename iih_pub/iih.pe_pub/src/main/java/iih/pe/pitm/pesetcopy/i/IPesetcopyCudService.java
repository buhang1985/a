package iih.pe.pitm.pesetcopy.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesetcopy.d.PeSetCopyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检套餐复制数据维护服务
*/
public interface IPesetcopyCudService {
	/**
	*  体检套餐复制数据真删除
	*/
    public abstract void delete(PeSetCopyDO[] aggdos) throws BizException;
    
    /**
	*  体检套餐复制数据插入保存
	*/
	public abstract PeSetCopyDO[] insert(PeSetCopyDO[] aggdos) throws BizException;
	
    /**
	*  体检套餐复制数据保存
	*/
	public abstract PeSetCopyDO[] save(PeSetCopyDO[] aggdos) throws BizException;
	
    /**
	*  体检套餐复制数据更新
	*/
	public abstract PeSetCopyDO[] update(PeSetCopyDO[] aggdos) throws BizException;
	
	/**
	*  体检套餐复制数据逻辑删除
	*/
	public abstract void logicDelete(PeSetCopyDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSetCopyDO[] enableWithoutFilter(PeSetCopyDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSetCopyDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSetCopyDO[] disableVOWithoutFilter(PeSetCopyDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSetCopyDO[] dos) throws BizException ;
}