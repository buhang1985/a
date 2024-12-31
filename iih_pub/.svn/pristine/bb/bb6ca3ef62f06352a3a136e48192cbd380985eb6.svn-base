package iih.bd.srv.mrelement.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrelement.d.MrEleValDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 病历元素数据维护服务
*/
public interface IMrEleValDOCudService {
	/**
	*  病历元素数据真删除
	*/
    public abstract void delete(MrEleValDO[] aggdos) throws BizException;
    
    /**
	*  病历元素数据插入保存
	*/
	public abstract MrEleValDO[] insert(MrEleValDO[] aggdos) throws BizException;
	
    /**
	*  病历元素数据保存
	*/
	public abstract MrEleValDO[] save(MrEleValDO[] aggdos) throws BizException;
	
    /**
	*  病历元素数据更新
	*/
	public abstract MrEleValDO[] update(MrEleValDO[] aggdos) throws BizException;
	
	/**
	*  病历元素数据逻辑删除
	*/
	public abstract void logicDelete(MrEleValDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrEleValDO[] enableWithoutFilter(MrEleValDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrEleValDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrEleValDO[] disableVOWithoutFilter(MrEleValDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrEleValDO[] aggdos) throws BizException ;
	
}
