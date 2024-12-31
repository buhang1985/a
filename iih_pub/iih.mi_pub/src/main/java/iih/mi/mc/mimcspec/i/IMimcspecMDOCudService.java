package iih.mi.mc.mimcspec.i;

import xap.mw.core.data.BizException;
import iih.mi.mc.mimcspec.d.MiMcSpecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医保特殊病数据维护服务
*/
public interface IMimcspecMDOCudService {
	/**
	*  医保特殊病数据真删除
	*/
    public abstract void delete(MiMcSpecDO[] aggdos) throws BizException;
    
    /**
	*  医保特殊病数据插入保存
	*/
	public abstract MiMcSpecDO[] insert(MiMcSpecDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病数据保存
	*/
	public abstract MiMcSpecDO[] save(MiMcSpecDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病数据更新
	*/
	public abstract MiMcSpecDO[] update(MiMcSpecDO[] aggdos) throws BizException;
	
	/**
	*  医保特殊病数据逻辑删除
	*/
	public abstract void logicDelete(MiMcSpecDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiMcSpecDO[] enableWithoutFilter(MiMcSpecDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiMcSpecDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiMcSpecDO[] disableVOWithoutFilter(MiMcSpecDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiMcSpecDO[] aggdos) throws BizException ;
	
}
