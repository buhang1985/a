package iih.bl.itf.bltranscall.i;

import xap.mw.core.data.BizException;
import iih.bl.itf.bltranscall.d.BlTransCalledRcdDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 费用对外交易接口调用日志数据维护服务
*/
public interface IBltranscallCudService {
	/**
	*  费用对外交易接口调用日志数据真删除
	*/
    public abstract void delete(BlTransCalledRcdDO[] aggdos) throws BizException;
    
    /**
	*  费用对外交易接口调用日志数据插入保存
	*/
	public abstract BlTransCalledRcdDO[] insert(BlTransCalledRcdDO[] aggdos) throws BizException;
	
    /**
	*  费用对外交易接口调用日志数据保存
	*/
	public abstract BlTransCalledRcdDO[] save(BlTransCalledRcdDO[] aggdos) throws BizException;
	
    /**
	*  费用对外交易接口调用日志数据更新
	*/
	public abstract BlTransCalledRcdDO[] update(BlTransCalledRcdDO[] aggdos) throws BizException;
	
	/**
	*  费用对外交易接口调用日志数据逻辑删除
	*/
	public abstract void logicDelete(BlTransCalledRcdDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlTransCalledRcdDO[] enableWithoutFilter(BlTransCalledRcdDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlTransCalledRcdDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlTransCalledRcdDO[] disableVOWithoutFilter(BlTransCalledRcdDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlTransCalledRcdDO[] dos) throws BizException ;
}
