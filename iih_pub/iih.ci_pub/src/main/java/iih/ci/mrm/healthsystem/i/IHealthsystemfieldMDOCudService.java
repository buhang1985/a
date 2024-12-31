package iih.ci.mrm.healthsystem.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.healthsystem.d.FieldContrastDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 字段转换数据维护服务
*/
public interface IHealthsystemfieldMDOCudService {
	/**
	*  字段转换数据真删除
	*/
    public abstract void delete(FieldContrastDO[] aggdos) throws BizException;
    
    /**
	*  字段转换数据插入保存
	*/
	public abstract FieldContrastDO[] insert(FieldContrastDO[] aggdos) throws BizException;
	
    /**
	*  字段转换数据保存
	*/
	public abstract FieldContrastDO[] save(FieldContrastDO[] aggdos) throws BizException;
	
    /**
	*  字段转换数据更新
	*/
	public abstract FieldContrastDO[] update(FieldContrastDO[] aggdos) throws BizException;
	
	/**
	*  字段转换数据逻辑删除
	*/
	public abstract void logicDelete(FieldContrastDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public FieldContrastDO[] enableWithoutFilter(FieldContrastDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(FieldContrastDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public FieldContrastDO[] disableVOWithoutFilter(FieldContrastDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(FieldContrastDO[] aggdos) throws BizException ;
	
}
