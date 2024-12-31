package iih.bd.fc.enstatetpext.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.enstatetpext.d.BdEnStateTpExtDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就诊状况类型定义扩展数据维护服务
*/
public interface IBdenstatetpextCudService {
	/**
	*  就诊状况类型定义扩展数据真删除
	*/
    public abstract void delete(BdEnStateTpExtDO[] aggdos) throws BizException;
    
    /**
	*  就诊状况类型定义扩展数据插入保存
	*/
	public abstract BdEnStateTpExtDO[] insert(BdEnStateTpExtDO[] aggdos) throws BizException;
	
    /**
	*  就诊状况类型定义扩展数据保存
	*/
	public abstract BdEnStateTpExtDO[] save(BdEnStateTpExtDO[] aggdos) throws BizException;
	
    /**
	*  就诊状况类型定义扩展数据更新
	*/
	public abstract BdEnStateTpExtDO[] update(BdEnStateTpExtDO[] aggdos) throws BizException;
	
	/**
	*  就诊状况类型定义扩展数据逻辑删除
	*/
	public abstract void logicDelete(BdEnStateTpExtDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdEnStateTpExtDO[] enableWithoutFilter(BdEnStateTpExtDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdEnStateTpExtDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdEnStateTpExtDO[] disableVOWithoutFilter(BdEnStateTpExtDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdEnStateTpExtDO[] dos) throws BizException ;
}
