package iih.bd.mm.materialnames.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.materialnames.d.MaterialNamesDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 药品通用名目录数据维护服务
*/
public interface IMaterialnamesMDOCudService {
	/**
	*  药品通用名目录数据真删除
	*/
    public abstract void delete(MaterialNamesDO[] aggdos) throws BizException;
    
    /**
	*  药品通用名目录数据插入保存
	*/
	public abstract MaterialNamesDO[] insert(MaterialNamesDO[] aggdos) throws BizException;
	
    /**
	*  药品通用名目录数据保存
	*/
	public abstract MaterialNamesDO[] save(MaterialNamesDO[] aggdos) throws BizException;
	
    /**
	*  药品通用名目录数据更新
	*/
	public abstract MaterialNamesDO[] update(MaterialNamesDO[] aggdos) throws BizException;
	
	/**
	*  药品通用名目录数据逻辑删除
	*/
	public abstract void logicDelete(MaterialNamesDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MaterialNamesDO[] enableWithoutFilter(MaterialNamesDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MaterialNamesDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MaterialNamesDO[] disableVOWithoutFilter(MaterialNamesDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MaterialNamesDO[] aggdos) throws BizException ;
	
}
