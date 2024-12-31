package iih.nmr.pkuf.fivecolor.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.fivecolor.d.FCCMBdDataDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 孕产妇五色卡数据维护服务
*/
public interface IFivecolorCudService {
	/**
	*  孕产妇五色卡数据真删除
	*/
    public abstract void delete(FCCMBdDataDO[] aggdos) throws BizException;
    
    /**
	*  孕产妇五色卡数据插入保存
	*/
	public abstract FCCMBdDataDO[] insert(FCCMBdDataDO[] aggdos) throws BizException;
	
    /**
	*  孕产妇五色卡数据保存
	*/
	public abstract FCCMBdDataDO[] save(FCCMBdDataDO[] aggdos) throws BizException;
	
    /**
	*  孕产妇五色卡数据更新
	*/
	public abstract FCCMBdDataDO[] update(FCCMBdDataDO[] aggdos) throws BizException;
	
	/**
	*  孕产妇五色卡数据逻辑删除
	*/
	public abstract void logicDelete(FCCMBdDataDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public FCCMBdDataDO[] enableWithoutFilter(FCCMBdDataDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(FCCMBdDataDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public FCCMBdDataDO[] disableVOWithoutFilter(FCCMBdDataDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(FCCMBdDataDO[] dos) throws BizException ;
}
