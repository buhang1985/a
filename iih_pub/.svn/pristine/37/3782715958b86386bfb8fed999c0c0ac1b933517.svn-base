package iih.bd.srv.bdmrsigntype.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.bdmrsigntype.d.BdMrLvlItmTitleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历审签层级明细对应职称数据维护服务
*/
public interface IBdmrlvlitmtitleCudService {
	/**
	*  病历审签层级明细对应职称数据真删除
	*/
    public abstract void delete(BdMrLvlItmTitleDO[] aggdos) throws BizException;
    
    /**
	*  病历审签层级明细对应职称数据插入保存
	*/
	public abstract BdMrLvlItmTitleDO[] insert(BdMrLvlItmTitleDO[] aggdos) throws BizException;
	
    /**
	*  病历审签层级明细对应职称数据保存
	*/
	public abstract BdMrLvlItmTitleDO[] save(BdMrLvlItmTitleDO[] aggdos) throws BizException;
	
    /**
	*  病历审签层级明细对应职称数据更新
	*/
	public abstract BdMrLvlItmTitleDO[] update(BdMrLvlItmTitleDO[] aggdos) throws BizException;
	
	/**
	*  病历审签层级明细对应职称数据逻辑删除
	*/
	public abstract void logicDelete(BdMrLvlItmTitleDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdMrLvlItmTitleDO[] enableWithoutFilter(BdMrLvlItmTitleDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdMrLvlItmTitleDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdMrLvlItmTitleDO[] disableVOWithoutFilter(BdMrLvlItmTitleDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdMrLvlItmTitleDO[] dos) throws BizException ;
}
