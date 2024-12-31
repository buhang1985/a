package iih.pe.phm.pecmaresult.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pecmaresult.d.PeCmaKeyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康评估自测问卷结果数据维护服务
*/
public interface IPeCmaKeyDOCudService {
	/**
	*  健康评估自测问卷结果数据真删除
	*/
    public abstract void delete(PeCmaKeyDO[] aggdos) throws BizException;
    
    /**
	*  健康评估自测问卷结果数据插入保存
	*/
	public abstract PeCmaKeyDO[] insert(PeCmaKeyDO[] aggdos) throws BizException;
	
    /**
	*  健康评估自测问卷结果数据保存
	*/
	public abstract PeCmaKeyDO[] save(PeCmaKeyDO[] aggdos) throws BizException;
	
    /**
	*  健康评估自测问卷结果数据更新
	*/
	public abstract PeCmaKeyDO[] update(PeCmaKeyDO[] aggdos) throws BizException;
	
	/**
	*  健康评估自测问卷结果数据逻辑删除
	*/
	public abstract void logicDelete(PeCmaKeyDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeCmaKeyDO[] enableWithoutFilter(PeCmaKeyDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeCmaKeyDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeCmaKeyDO[] disableVOWithoutFilter(PeCmaKeyDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeCmaKeyDO[] aggdos) throws BizException ;
	
}
