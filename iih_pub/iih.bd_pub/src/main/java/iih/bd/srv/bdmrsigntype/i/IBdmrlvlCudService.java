package iih.bd.srv.bdmrsigntype.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.bdmrsigntype.d.BdMrLvlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历审签层级定义数据维护服务
*/
public interface IBdmrlvlCudService {
	/**
	*  病历审签层级定义数据真删除
	*/
    public abstract void delete(BdMrLvlDO[] aggdos) throws BizException;
    
    /**
	*  病历审签层级定义数据插入保存
	*/
	public abstract BdMrLvlDO[] insert(BdMrLvlDO[] aggdos) throws BizException;
	
    /**
	*  病历审签层级定义数据保存
	*/
	public abstract BdMrLvlDO[] save(BdMrLvlDO[] aggdos) throws BizException;
	
    /**
	*  病历审签层级定义数据更新
	*/
	public abstract BdMrLvlDO[] update(BdMrLvlDO[] aggdos) throws BizException;
	
	/**
	*  病历审签层级定义数据逻辑删除
	*/
	public abstract void logicDelete(BdMrLvlDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdMrLvlDO[] enableWithoutFilter(BdMrLvlDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdMrLvlDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdMrLvlDO[] disableVOWithoutFilter(BdMrLvlDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdMrLvlDO[] dos) throws BizException ;
}
