package iih.bd.res.bed.i;

import xap.mw.core.data.BizException;
import iih.bd.res.bed.d.Bdbed;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 床位管理数据维护服务
*/
public interface IBedMDOCudService {
	/**
	*  床位管理数据真删除
	*/
    public abstract void delete(Bdbed[] aggdos) throws BizException;
    
    /**
	*  床位管理数据插入保存
	*/
	public abstract Bdbed[] insert(Bdbed[] aggdos) throws BizException;
	
    /**
	*  床位管理数据保存
	*/
	public abstract Bdbed[] save(Bdbed[] aggdos) throws BizException;
	
    /**
	*  床位管理数据更新
	*/
	public abstract Bdbed[] update(Bdbed[] aggdos) throws BizException;
	
	/**
	*  床位管理数据逻辑删除
	*/
	public abstract void logicDelete(Bdbed[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public Bdbed[] enableWithoutFilter(Bdbed[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(Bdbed[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public Bdbed[] disableVOWithoutFilter(Bdbed[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(Bdbed[] aggdos) throws BizException ;
	
}
