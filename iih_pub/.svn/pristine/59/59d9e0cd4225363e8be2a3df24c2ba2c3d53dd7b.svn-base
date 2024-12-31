package iih.nm.net.examappqu.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examappqu.d.NmExamAppQuDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 人员考试题目数据维护服务
*/
public interface IExamappquMDOCudService {
	/**
	*  人员考试题目数据真删除
	*/
    public abstract void delete(NmExamAppQuDO[] aggdos) throws BizException;
    
    /**
	*  人员考试题目数据插入保存
	*/
	public abstract NmExamAppQuDO[] insert(NmExamAppQuDO[] aggdos) throws BizException;
	
    /**
	*  人员考试题目数据保存
	*/
	public abstract NmExamAppQuDO[] save(NmExamAppQuDO[] aggdos) throws BizException;
	
    /**
	*  人员考试题目数据更新
	*/
	public abstract NmExamAppQuDO[] update(NmExamAppQuDO[] aggdos) throws BizException;
	
	/**
	*  人员考试题目数据逻辑删除
	*/
	public abstract void logicDelete(NmExamAppQuDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmExamAppQuDO[] enableWithoutFilter(NmExamAppQuDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmExamAppQuDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmExamAppQuDO[] disableVOWithoutFilter(NmExamAppQuDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmExamAppQuDO[] aggdos) throws BizException ;
	
}
