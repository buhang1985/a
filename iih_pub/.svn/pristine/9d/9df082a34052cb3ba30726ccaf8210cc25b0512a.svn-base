package iih.bd.fc.tagtp.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.tagtp.d.BdTagTpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 标签数据维护服务
*/
public interface ITagtpCudService {
	/**
	*  标签数据真删除
	*/
    public abstract void delete(BdTagTpDO[] aggdos) throws BizException;
    
    /**
	*  标签数据插入保存
	*/
	public abstract BdTagTpDO[] insert(BdTagTpDO[] aggdos) throws BizException;
	
    /**
	*  标签数据保存
	*/
	public abstract BdTagTpDO[] save(BdTagTpDO[] aggdos) throws BizException;
	
    /**
	*  标签数据更新
	*/
	public abstract BdTagTpDO[] update(BdTagTpDO[] aggdos) throws BizException;
	
	/**
	*  标签数据逻辑删除
	*/
	public abstract void logicDelete(BdTagTpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdTagTpDO[] enableWithoutFilter(BdTagTpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdTagTpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdTagTpDO[] disableVOWithoutFilter(BdTagTpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdTagTpDO[] dos) throws BizException ;
}
