package iih.nmr.pkuf.sporecord.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.sporecord.d.SporecordDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 血氧饱和度监测记录单数据维护服务
*/
public interface ISporecord1CudService {
	/**
	*  血氧饱和度监测记录单数据真删除
	*/
    public abstract void delete(SporecordDO[] aggdos) throws BizException;
    
    /**
	*  血氧饱和度监测记录单数据插入保存
	*/
	public abstract SporecordDO[] insert(SporecordDO[] aggdos) throws BizException;
	
    /**
	*  血氧饱和度监测记录单数据保存
	*/
	public abstract SporecordDO[] save(SporecordDO[] aggdos) throws BizException;
	
    /**
	*  血氧饱和度监测记录单数据更新
	*/
	public abstract SporecordDO[] update(SporecordDO[] aggdos) throws BizException;
	
	/**
	*  血氧饱和度监测记录单数据逻辑删除
	*/
	public abstract void logicDelete(SporecordDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SporecordDO[] enableWithoutFilter(SporecordDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SporecordDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SporecordDO[] disableVOWithoutFilter(SporecordDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SporecordDO[] dos) throws BizException ;
}
