package iih.bd.fc.orpltpmtpara.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.orpltpmtpara.d.OrpltpmtParaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱执行闭环类型匹配参数数据维护服务
*/
public interface IOrpltpmtparaCudService {
	/**
	*  医嘱执行闭环类型匹配参数数据真删除
	*/
    public abstract void delete(OrpltpmtParaDO[] aggdos) throws BizException;
    
    /**
	*  医嘱执行闭环类型匹配参数数据插入保存
	*/
	public abstract OrpltpmtParaDO[] insert(OrpltpmtParaDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行闭环类型匹配参数数据保存
	*/
	public abstract OrpltpmtParaDO[] save(OrpltpmtParaDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行闭环类型匹配参数数据更新
	*/
	public abstract OrpltpmtParaDO[] update(OrpltpmtParaDO[] aggdos) throws BizException;
	
	/**
	*  医嘱执行闭环类型匹配参数数据逻辑删除
	*/
	public abstract void logicDelete(OrpltpmtParaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrpltpmtParaDO[] enableWithoutFilter(OrpltpmtParaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrpltpmtParaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrpltpmtParaDO[] disableVOWithoutFilter(OrpltpmtParaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrpltpmtParaDO[] dos) throws BizException ;
}
