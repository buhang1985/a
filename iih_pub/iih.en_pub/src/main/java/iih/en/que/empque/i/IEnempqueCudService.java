package iih.en.que.empque.i;

import xap.mw.core.data.BizException;
import iih.en.que.empque.d.EnQueEmpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者就诊_队列医生数据维护服务
*/
public interface IEnempqueCudService {
	/**
	*  患者就诊_队列医生数据真删除
	*/
    public abstract void delete(EnQueEmpDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_队列医生数据插入保存
	*/
	public abstract EnQueEmpDO[] insert(EnQueEmpDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_队列医生数据保存
	*/
	public abstract EnQueEmpDO[] save(EnQueEmpDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_队列医生数据更新
	*/
	public abstract EnQueEmpDO[] update(EnQueEmpDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_队列医生数据逻辑删除
	*/
	public abstract void logicDelete(EnQueEmpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnQueEmpDO[] enableWithoutFilter(EnQueEmpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnQueEmpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnQueEmpDO[] disableVOWithoutFilter(EnQueEmpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnQueEmpDO[] dos) throws BizException ;
}
