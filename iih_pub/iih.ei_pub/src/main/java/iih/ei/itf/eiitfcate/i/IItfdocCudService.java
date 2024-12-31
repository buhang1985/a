package iih.ei.itf.eiitfcate.i;

import xap.mw.core.data.BizException;
import iih.ei.itf.eiitfcate.d.ItfDocTaskDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 接口文档数据维护服务
*/
public interface IItfdocCudService {
	/**
	*  接口文档数据真删除
	*/
    public abstract void delete(ItfDocTaskDO[] aggdos) throws BizException;
    
    /**
	*  接口文档数据插入保存
	*/
	public abstract ItfDocTaskDO[] insert(ItfDocTaskDO[] aggdos) throws BizException;
	
    /**
	*  接口文档数据保存
	*/
	public abstract ItfDocTaskDO[] save(ItfDocTaskDO[] aggdos) throws BizException;
	
    /**
	*  接口文档数据更新
	*/
	public abstract ItfDocTaskDO[] update(ItfDocTaskDO[] aggdos) throws BizException;
	
	/**
	*  接口文档数据逻辑删除
	*/
	public abstract void logicDelete(ItfDocTaskDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ItfDocTaskDO[] enableWithoutFilter(ItfDocTaskDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ItfDocTaskDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ItfDocTaskDO[] disableVOWithoutFilter(ItfDocTaskDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ItfDocTaskDO[] dos) throws BizException ;
}
