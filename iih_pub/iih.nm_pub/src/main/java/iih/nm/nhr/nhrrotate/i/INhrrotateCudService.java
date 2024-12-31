package iih.nm.nhr.nhrrotate.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nhrrotate.d.NhrRotateDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理人员轮转记录数据维护服务
*/
public interface INhrrotateCudService {
	/**
	*  护理人员轮转记录数据真删除
	*/
    public abstract void delete(NhrRotateDO[] aggdos) throws BizException;
    
    /**
	*  护理人员轮转记录数据插入保存
	*/
	public abstract NhrRotateDO[] insert(NhrRotateDO[] aggdos) throws BizException;
	
    /**
	*  护理人员轮转记录数据保存
	*/
	public abstract NhrRotateDO[] save(NhrRotateDO[] aggdos) throws BizException;
	
    /**
	*  护理人员轮转记录数据更新
	*/
	public abstract NhrRotateDO[] update(NhrRotateDO[] aggdos) throws BizException;
	
	/**
	*  护理人员轮转记录数据逻辑删除
	*/
	public abstract void logicDelete(NhrRotateDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NhrRotateDO[] enableWithoutFilter(NhrRotateDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NhrRotateDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NhrRotateDO[] disableVOWithoutFilter(NhrRotateDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NhrRotateDO[] dos) throws BizException ;
}
