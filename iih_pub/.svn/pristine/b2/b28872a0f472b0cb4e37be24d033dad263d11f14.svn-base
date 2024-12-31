package iih.en.pv.entplan.i;

import xap.mw.core.data.BizException;
import iih.en.pv.entplan.d.EntCpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就诊临床路径数据维护服务
*/
public interface IEntcpCudService {
	/**
	*  就诊临床路径数据真删除
	*/
    public abstract void delete(EntCpDO[] aggdos) throws BizException;
    
    /**
	*  就诊临床路径数据插入保存
	*/
	public abstract EntCpDO[] insert(EntCpDO[] aggdos) throws BizException;
	
    /**
	*  就诊临床路径数据保存
	*/
	public abstract EntCpDO[] save(EntCpDO[] aggdos) throws BizException;
	
    /**
	*  就诊临床路径数据更新
	*/
	public abstract EntCpDO[] update(EntCpDO[] aggdos) throws BizException;
	
	/**
	*  就诊临床路径数据逻辑删除
	*/
	public abstract void logicDelete(EntCpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EntCpDO[] enableWithoutFilter(EntCpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EntCpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EntCpDO[] disableVOWithoutFilter(EntCpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EntCpDO[] dos) throws BizException ;
}
