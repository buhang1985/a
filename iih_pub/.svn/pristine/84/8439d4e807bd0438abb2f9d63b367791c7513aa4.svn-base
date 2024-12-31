package iih.pi.card.act.i;

import xap.mw.core.data.BizException;
import iih.pi.card.act.d.PiCardActDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就诊卡操作记录数据维护服务
*/
public interface IActCudService {
	/**
	*  就诊卡操作记录数据删除
	*/
    public abstract void logicDelete(PiCardActDO[] aggdos) throws BizException;
    
    /**
	*  就诊卡操作记录数据插入保存
	*/
	public abstract PiCardActDO[] insert(PiCardActDO[] aggdos) throws BizException;
	
    /**
	*  就诊卡操作记录数据保存
	*/
	public abstract PiCardActDO[] save(PiCardActDO[] aggdos) throws BizException;
	
    /**
	*  就诊卡操作记录数据更新
	*/
	public abstract PiCardActDO[] update(PiCardActDO[] aggdos) throws BizException;
	
	/**
	*  就诊卡操作记录数据真删
	*/
	public abstract void delete(PiCardActDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiCardActDO[] enableWithoutFilter(PiCardActDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiCardActDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiCardActDO[] disableVOWithoutFilter(PiCardActDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiCardActDO[] dos) throws BizException ;
}
