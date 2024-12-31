package iih.nm.nhr.nmnurfreeclinexp.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurfreeclinexp.d.NmnurFreeClinExpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理人员_扶贫义诊经历数据维护服务
*/
public interface INmnurfreeclinexpCudService {
	/**
	*  护理人员_扶贫义诊经历数据真删除
	*/
    public abstract void delete(NmnurFreeClinExpDO[] aggdos) throws BizException;
    
    /**
	*  护理人员_扶贫义诊经历数据插入保存
	*/
	public abstract NmnurFreeClinExpDO[] insert(NmnurFreeClinExpDO[] aggdos) throws BizException;
	
    /**
	*  护理人员_扶贫义诊经历数据保存
	*/
	public abstract NmnurFreeClinExpDO[] save(NmnurFreeClinExpDO[] aggdos) throws BizException;
	
    /**
	*  护理人员_扶贫义诊经历数据更新
	*/
	public abstract NmnurFreeClinExpDO[] update(NmnurFreeClinExpDO[] aggdos) throws BizException;
	
	/**
	*  护理人员_扶贫义诊经历数据逻辑删除
	*/
	public abstract void logicDelete(NmnurFreeClinExpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmnurFreeClinExpDO[] enableWithoutFilter(NmnurFreeClinExpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmnurFreeClinExpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmnurFreeClinExpDO[] disableVOWithoutFilter(NmnurFreeClinExpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmnurFreeClinExpDO[] dos) throws BizException ;
}
