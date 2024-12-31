package iih.nmr.pkuf.iototal.i;

import iih.nmr.pkuf.iototal.d.InOutTotalDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 出入液量统计数据维护服务
*/
public interface IIototalCudService {
	/**
	*  出入液量统计数据真删除
	*/
    public abstract void delete(InOutTotalDO[] aggdos) throws BizException;
    
    /**
	*  出入液量统计数据插入保存
	*/
	public abstract InOutTotalDO[] insert(InOutTotalDO[] aggdos) throws BizException;
	
    /**
	*  出入液量统计数据保存
	*/
	public abstract InOutTotalDO[] save(InOutTotalDO[] aggdos) throws BizException;
	
    /**
	*  出入液量统计数据更新
	*/
	public abstract InOutTotalDO[] update(InOutTotalDO[] aggdos) throws BizException;
	
	/**
	*  出入液量统计数据逻辑删除
	*/
	public abstract void logicDelete(InOutTotalDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public InOutTotalDO[] enableWithoutFilter(InOutTotalDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(InOutTotalDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public InOutTotalDO[] disableVOWithoutFilter(InOutTotalDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(InOutTotalDO[] dos) throws BizException ;
}
