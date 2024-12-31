package iih.mp.ne.transfusion.i;

import xap.mw.core.data.BizException;
import iih.mp.ne.transfusion.d.NeBtrVtDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 输血执行数据维护服务
*/
public interface INeBtrVtDOCudService {
	/**
	*  输血执行数据真删除
	*/
    public abstract void delete(NeBtrVtDO[] aggdos) throws BizException;
    
    /**
	*  输血执行数据插入保存
	*/
	public abstract NeBtrVtDO[] insert(NeBtrVtDO[] aggdos) throws BizException;
	
    /**
	*  输血执行数据保存
	*/
	public abstract NeBtrVtDO[] save(NeBtrVtDO[] aggdos) throws BizException;
	
    /**
	*  输血执行数据更新
	*/
	public abstract NeBtrVtDO[] update(NeBtrVtDO[] aggdos) throws BizException;
	
	/**
	*  输血执行数据逻辑删除
	*/
	public abstract void logicDelete(NeBtrVtDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NeBtrVtDO[] enableWithoutFilter(NeBtrVtDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NeBtrVtDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NeBtrVtDO[] disableVOWithoutFilter(NeBtrVtDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NeBtrVtDO[] aggdos) throws BizException ;
	
}
