package iih.nm.net.examappqu.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examappqu.d.NmExamAppQuAnsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 人员考试题目数据维护服务
*/
public interface INmExamAppQuAnsDOCudService {
	/**
	*  人员考试题目数据真删除
	*/
    public abstract void delete(NmExamAppQuAnsDO[] aggdos) throws BizException;
    
    /**
	*  人员考试题目数据插入保存
	*/
	public abstract NmExamAppQuAnsDO[] insert(NmExamAppQuAnsDO[] aggdos) throws BizException;
	
    /**
	*  人员考试题目数据保存
	*/
	public abstract NmExamAppQuAnsDO[] save(NmExamAppQuAnsDO[] aggdos) throws BizException;
	
    /**
	*  人员考试题目数据更新
	*/
	public abstract NmExamAppQuAnsDO[] update(NmExamAppQuAnsDO[] aggdos) throws BizException;
	
	/**
	*  人员考试题目数据逻辑删除
	*/
	public abstract void logicDelete(NmExamAppQuAnsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmExamAppQuAnsDO[] enableWithoutFilter(NmExamAppQuAnsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmExamAppQuAnsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmExamAppQuAnsDO[] disableVOWithoutFilter(NmExamAppQuAnsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmExamAppQuAnsDO[] aggdos) throws BizException ;
	
}
