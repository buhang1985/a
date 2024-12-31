package iih.bd.srv.bdmrsigntype.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.bdmrsigntype.d.BdMrLvlItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历审签层级明细数据维护服务
*/
public interface IBdmrlvlitmCudService {
	/**
	*  病历审签层级明细数据真删除
	*/
    public abstract void delete(BdMrLvlItmDO[] aggdos) throws BizException;
    
    /**
	*  病历审签层级明细数据插入保存
	*/
	public abstract BdMrLvlItmDO[] insert(BdMrLvlItmDO[] aggdos) throws BizException;
	
    /**
	*  病历审签层级明细数据保存
	*/
	public abstract BdMrLvlItmDO[] save(BdMrLvlItmDO[] aggdos) throws BizException;
	
    /**
	*  病历审签层级明细数据更新
	*/
	public abstract BdMrLvlItmDO[] update(BdMrLvlItmDO[] aggdos) throws BizException;
	
	/**
	*  病历审签层级明细数据逻辑删除
	*/
	public abstract void logicDelete(BdMrLvlItmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdMrLvlItmDO[] enableWithoutFilter(BdMrLvlItmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdMrLvlItmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdMrLvlItmDO[] disableVOWithoutFilter(BdMrLvlItmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdMrLvlItmDO[] dos) throws BizException ;
}
