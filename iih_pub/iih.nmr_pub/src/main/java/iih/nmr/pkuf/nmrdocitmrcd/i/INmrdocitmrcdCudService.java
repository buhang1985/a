package iih.nmr.pkuf.nmrdocitmrcd.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrdocitmrcd.d. NmrCollRecordDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理文书采集审核记录组件数据维护服务
*/
public interface INmrdocitmrcdCudService {
	/**
	*  护理文书采集审核记录组件数据真删除
	*/
    public abstract void delete( NmrCollRecordDO[] aggdos) throws BizException;
    
    /**
	*  护理文书采集审核记录组件数据插入保存
	*/
	public abstract  NmrCollRecordDO[] insert( NmrCollRecordDO[] aggdos) throws BizException;
	
    /**
	*  护理文书采集审核记录组件数据保存
	*/
	public abstract  NmrCollRecordDO[] save( NmrCollRecordDO[] aggdos) throws BizException;
	
    /**
	*  护理文书采集审核记录组件数据更新
	*/
	public abstract  NmrCollRecordDO[] update( NmrCollRecordDO[] aggdos) throws BizException;
	
	/**
	*  护理文书采集审核记录组件数据逻辑删除
	*/
	public abstract void logicDelete( NmrCollRecordDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public  NmrCollRecordDO[] enableWithoutFilter( NmrCollRecordDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO( NmrCollRecordDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public  NmrCollRecordDO[] disableVOWithoutFilter( NmrCollRecordDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO( NmrCollRecordDO[] dos) throws BizException ;
}
