package iih.pe.pitm.pesrvsetdef.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvsetdef.d.PeSrvSetIllDefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检套餐定义（项目组合）数据维护服务
*/
public interface IPeSrvSetIllDefDOCudService {
	/**
	*  体检套餐定义（项目组合）数据真删除
	*/
    public abstract void delete(PeSrvSetIllDefDO[] aggdos) throws BizException;
    
    /**
	*  体检套餐定义（项目组合）数据插入保存
	*/
	public abstract PeSrvSetIllDefDO[] insert(PeSrvSetIllDefDO[] aggdos) throws BizException;
	
    /**
	*  体检套餐定义（项目组合）数据保存
	*/
	public abstract PeSrvSetIllDefDO[] save(PeSrvSetIllDefDO[] aggdos) throws BizException;
	
    /**
	*  体检套餐定义（项目组合）数据更新
	*/
	public abstract PeSrvSetIllDefDO[] update(PeSrvSetIllDefDO[] aggdos) throws BizException;
	
	/**
	*  体检套餐定义（项目组合）数据逻辑删除
	*/
	public abstract void logicDelete(PeSrvSetIllDefDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSrvSetIllDefDO[] enableWithoutFilter(PeSrvSetIllDefDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSrvSetIllDefDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSrvSetIllDefDO[] disableVOWithoutFilter(PeSrvSetIllDefDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSrvSetIllDefDO[] aggdos) throws BizException ;
	
}
