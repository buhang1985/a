package iih.ci.mr.middle.nmr.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.middle.nmr.d.CiMrMiddleNmrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历中间表护理文书数据维护服务
*/
public interface ICimrmiddlenmrdoCudService {
	/**
	*  病历中间表护理文书数据真删除
	*/
    public abstract void delete(CiMrMiddleNmrDO[] aggdos) throws BizException;
    
    /**
	*  病历中间表护理文书数据插入保存
	*/
	public abstract CiMrMiddleNmrDO[] insert(CiMrMiddleNmrDO[] aggdos) throws BizException;
	
    /**
	*  病历中间表护理文书数据保存
	*/
	public abstract CiMrMiddleNmrDO[] save(CiMrMiddleNmrDO[] aggdos) throws BizException;
	
    /**
	*  病历中间表护理文书数据更新
	*/
	public abstract CiMrMiddleNmrDO[] update(CiMrMiddleNmrDO[] aggdos) throws BizException;
	
	/**
	*  病历中间表护理文书数据逻辑删除
	*/
	public abstract void logicDelete(CiMrMiddleNmrDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrMiddleNmrDO[] enableWithoutFilter(CiMrMiddleNmrDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrMiddleNmrDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrMiddleNmrDO[] disableVOWithoutFilter(CiMrMiddleNmrDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrMiddleNmrDO[] dos) throws BizException ;
}
