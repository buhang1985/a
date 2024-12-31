package iih.pe.pitm.pesrvitem.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvitem.d.PeSrvitmOptsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检检查项目结果数据维护服务
*/
public interface IPeSrvitmOptsDOCudService {
	/**
	*  体检检查项目结果数据真删除
	*/
    public abstract void delete(PeSrvitmOptsDO[] aggdos) throws BizException;
    
    /**
	*  体检检查项目结果数据插入保存
	*/
	public abstract PeSrvitmOptsDO[] insert(PeSrvitmOptsDO[] aggdos) throws BizException;
	
    /**
	*  体检检查项目结果数据保存
	*/
	public abstract PeSrvitmOptsDO[] save(PeSrvitmOptsDO[] aggdos) throws BizException;
	
    /**
	*  体检检查项目结果数据更新
	*/
	public abstract PeSrvitmOptsDO[] update(PeSrvitmOptsDO[] aggdos) throws BizException;
	
	/**
	*  体检检查项目结果数据逻辑删除
	*/
	public abstract void logicDelete(PeSrvitmOptsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSrvitmOptsDO[] enableWithoutFilter(PeSrvitmOptsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSrvitmOptsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSrvitmOptsDO[] disableVOWithoutFilter(PeSrvitmOptsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSrvitmOptsDO[] aggdos) throws BizException ;
	
}
