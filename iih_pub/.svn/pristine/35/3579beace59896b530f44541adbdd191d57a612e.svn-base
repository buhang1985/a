package iih.bd.srv.emsobsindex.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.emsobsindex.d.EmsObsIndexDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗单观测指标定义数据维护服务
*/
public interface IEmsobsindexCudService {
	/**
	*  医疗单观测指标定义数据删除
	*/
    public abstract void delete(EmsObsIndexDO[] aggdos) throws BizException;
    
    /**
	*  医疗单观测指标定义数据插入保存
	*/
	public abstract EmsObsIndexDO[] insert(EmsObsIndexDO[] aggdos) throws BizException;
	
    /**
	*  医疗单观测指标定义数据保存
	*/
	public abstract EmsObsIndexDO[] save(EmsObsIndexDO[] aggdos) throws BizException;
	
    /**
	*  医疗单观测指标定义数据更新
	*/
	public abstract EmsObsIndexDO[] update(EmsObsIndexDO[] aggdos) throws BizException;
	
	/**
	*  医疗单观测指标定义数据真删
	*/
	public abstract void logicDelete(EmsObsIndexDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsObsIndexDO[] enableWithoutFilter(EmsObsIndexDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsObsIndexDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsObsIndexDO[] disableVOWithoutFilter(EmsObsIndexDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsObsIndexDO[] dos) throws BizException ;
}
