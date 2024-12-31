package iih.pi.card.iss.i;

import xap.mw.core.data.BizException;
import iih.pi.card.iss.d.PiCardIssDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就诊卡发放数据维护服务
*/
public interface IIssCudService {
	/**
	*  就诊卡发放数据删除
	*/
    public abstract void logicDelete(PiCardIssDO[] aggdos) throws BizException;
    
    /**
	*  就诊卡发放数据插入保存
	*/
	public abstract PiCardIssDO[] insert(PiCardIssDO[] aggdos) throws BizException;
	
    /**
	*  就诊卡发放数据保存
	*/
	public abstract PiCardIssDO[] save(PiCardIssDO[] aggdos) throws BizException;
	
    /**
	*  就诊卡发放数据更新
	*/
	public abstract PiCardIssDO[] update(PiCardIssDO[] aggdos) throws BizException;
	
	/**
	*  就诊卡发放数据真删
	*/
	public abstract void delete(PiCardIssDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiCardIssDO[] enableWithoutFilter(PiCardIssDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiCardIssDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiCardIssDO[] disableVOWithoutFilter(PiCardIssDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiCardIssDO[] dos) throws BizException ;
}
