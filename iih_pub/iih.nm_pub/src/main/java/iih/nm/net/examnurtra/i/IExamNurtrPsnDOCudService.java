package iih.nm.net.examnurtra.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examnurtra.d.ExamNurtrPsnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理人员培训数据维护服务
*/
public interface IExamNurtrPsnDOCudService {
	/**
	*  护理人员培训数据真删除
	*/
    public abstract void delete(ExamNurtrPsnDO[] aggdos) throws BizException;
    
    /**
	*  护理人员培训数据插入保存
	*/
	public abstract ExamNurtrPsnDO[] insert(ExamNurtrPsnDO[] aggdos) throws BizException;
	
    /**
	*  护理人员培训数据保存
	*/
	public abstract ExamNurtrPsnDO[] save(ExamNurtrPsnDO[] aggdos) throws BizException;
	
    /**
	*  护理人员培训数据更新
	*/
	public abstract ExamNurtrPsnDO[] update(ExamNurtrPsnDO[] aggdos) throws BizException;
	
	/**
	*  护理人员培训数据逻辑删除
	*/
	public abstract void logicDelete(ExamNurtrPsnDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ExamNurtrPsnDO[] enableWithoutFilter(ExamNurtrPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ExamNurtrPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ExamNurtrPsnDO[] disableVOWithoutFilter(ExamNurtrPsnDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ExamNurtrPsnDO[] aggdos) throws BizException ;
	
}