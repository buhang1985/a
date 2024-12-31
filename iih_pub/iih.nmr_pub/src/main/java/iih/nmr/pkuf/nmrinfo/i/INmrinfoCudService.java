package iih.nmr.pkuf.nmrinfo.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrinfo.d.NmrInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理文书告知单数据维护服务
*/
public interface INmrinfoCudService {
	/**
	*  护理文书告知单数据真删除
	*/
    public abstract void delete(NmrInfoDO[] aggdos) throws BizException;
    
    /**
	*  护理文书告知单数据插入保存
	*/
	public abstract NmrInfoDO[] insert(NmrInfoDO[] aggdos) throws BizException;
	
    /**
	*  护理文书告知单数据保存
	*/
	public abstract NmrInfoDO[] save(NmrInfoDO[] aggdos) throws BizException;
	
    /**
	*  护理文书告知单数据更新
	*/
	public abstract NmrInfoDO[] update(NmrInfoDO[] aggdos) throws BizException;
	
	/**
	*  护理文书告知单数据逻辑删除
	*/
	public abstract void logicDelete(NmrInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmrInfoDO[] enableWithoutFilter(NmrInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmrInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmrInfoDO[] disableVOWithoutFilter(NmrInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmrInfoDO[] dos) throws BizException ;
}
