package iih.nm.nqm.nmnqmcstmpl.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmcstmpl.d.NmnqmtmplitmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理管理_检查标准模板数据维护服务
*/
public interface INmnqmtmplitmDOCudService {
	/**
	*  护理管理_检查标准模板数据真删除
	*/
    public abstract void delete(NmnqmtmplitmDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_检查标准模板数据插入保存
	*/
	public abstract NmnqmtmplitmDO[] insert(NmnqmtmplitmDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_检查标准模板数据保存
	*/
	public abstract NmnqmtmplitmDO[] save(NmnqmtmplitmDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_检查标准模板数据更新
	*/
	public abstract NmnqmtmplitmDO[] update(NmnqmtmplitmDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_检查标准模板数据逻辑删除
	*/
	public abstract void logicDelete(NmnqmtmplitmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmnqmtmplitmDO[] enableWithoutFilter(NmnqmtmplitmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmnqmtmplitmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmnqmtmplitmDO[] disableVOWithoutFilter(NmnqmtmplitmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmnqmtmplitmDO[] aggdos) throws BizException ;
	
}
