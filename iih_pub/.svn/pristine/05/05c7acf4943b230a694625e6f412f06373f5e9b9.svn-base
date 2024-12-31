package iih.pe.pitm.pesrvsetdef.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvsetdef.d.PeSrvSetDefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检套餐定义（项目组合）数据维护服务
*/
public interface IPesrvsetdefMDOCudService {
	/**
	*  体检套餐定义（项目组合）数据真删除
	*/
    public abstract void delete(PeSrvSetDefDO[] aggdos) throws BizException;
    
    /**
	*  体检套餐定义（项目组合）数据插入保存
	*/
	public abstract PeSrvSetDefDO[] insert(PeSrvSetDefDO[] aggdos) throws BizException;
	
    /**
	*  体检套餐定义（项目组合）数据保存
	*/
	public abstract PeSrvSetDefDO[] save(PeSrvSetDefDO[] aggdos) throws BizException;
	
    /**
	*  体检套餐定义（项目组合）数据更新
	*/
	public abstract PeSrvSetDefDO[] update(PeSrvSetDefDO[] aggdos) throws BizException;
	
	/**
	*  体检套餐定义（项目组合）数据逻辑删除
	*/
	public abstract void logicDelete(PeSrvSetDefDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSrvSetDefDO[] enableWithoutFilter(PeSrvSetDefDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSrvSetDefDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSrvSetDefDO[] disableVOWithoutFilter(PeSrvSetDefDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSrvSetDefDO[] aggdos) throws BizException ;
	
}
