package iih.pe.pitm.perstdidef.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.perstdidef.d.PeRstDiDefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检诊断定义数据维护服务
*/
public interface IPerstdidefMDOCudService {
	/**
	*  体检诊断定义数据真删除
	*/
    public abstract void delete(PeRstDiDefDO[] aggdos) throws BizException;
    
    /**
	*  体检诊断定义数据插入保存
	*/
	public abstract PeRstDiDefDO[] insert(PeRstDiDefDO[] aggdos) throws BizException;
	
    /**
	*  体检诊断定义数据保存
	*/
	public abstract PeRstDiDefDO[] save(PeRstDiDefDO[] aggdos) throws BizException;
	
    /**
	*  体检诊断定义数据更新
	*/
	public abstract PeRstDiDefDO[] update(PeRstDiDefDO[] aggdos) throws BizException;
	
	/**
	*  体检诊断定义数据逻辑删除
	*/
	public abstract void logicDelete(PeRstDiDefDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeRstDiDefDO[] enableWithoutFilter(PeRstDiDefDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeRstDiDefDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeRstDiDefDO[] disableVOWithoutFilter(PeRstDiDefDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeRstDiDefDO[] aggdos) throws BizException ;
	
}
