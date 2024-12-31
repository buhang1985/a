package iih.pe.pitm.pesrvsetdef.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvsetdef.d.PeSrvSetItmDefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检套餐定义（项目组合）数据维护服务
*/
public interface IPeSrvSetItmDefDOCudService {
	/**
	*  体检套餐定义（项目组合）数据真删除
	*/
    public abstract void delete(PeSrvSetItmDefDO[] aggdos) throws BizException;
    
    /**
	*  体检套餐定义（项目组合）数据插入保存
	*/
	public abstract PeSrvSetItmDefDO[] insert(PeSrvSetItmDefDO[] aggdos) throws BizException;
	
    /**
	*  体检套餐定义（项目组合）数据保存
	*/
	public abstract PeSrvSetItmDefDO[] save(PeSrvSetItmDefDO[] aggdos) throws BizException;
	
    /**
	*  体检套餐定义（项目组合）数据更新
	*/
	public abstract PeSrvSetItmDefDO[] update(PeSrvSetItmDefDO[] aggdos) throws BizException;
	
	/**
	*  体检套餐定义（项目组合）数据逻辑删除
	*/
	public abstract void logicDelete(PeSrvSetItmDefDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSrvSetItmDefDO[] enableWithoutFilter(PeSrvSetItmDefDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSrvSetItmDefDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSrvSetItmDefDO[] disableVOWithoutFilter(PeSrvSetItmDefDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSrvSetItmDefDO[] aggdos) throws BizException ;
	
}
