package iih.nm.nhr.nmnhrsi.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnhrsi.d.NmNhrSiBedDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 班次信息数据维护服务
*/
public interface INmNhrSiBedDOCudService {
	/**
	*  班次信息数据真删除
	*/
    public abstract void delete(NmNhrSiBedDO[] aggdos) throws BizException;
    
    /**
	*  班次信息数据插入保存
	*/
	public abstract NmNhrSiBedDO[] insert(NmNhrSiBedDO[] aggdos) throws BizException;
	
    /**
	*  班次信息数据保存
	*/
	public abstract NmNhrSiBedDO[] save(NmNhrSiBedDO[] aggdos) throws BizException;
	
    /**
	*  班次信息数据更新
	*/
	public abstract NmNhrSiBedDO[] update(NmNhrSiBedDO[] aggdos) throws BizException;
	
	/**
	*  班次信息数据逻辑删除
	*/
	public abstract void logicDelete(NmNhrSiBedDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNhrSiBedDO[] enableWithoutFilter(NmNhrSiBedDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNhrSiBedDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNhrSiBedDO[] disableVOWithoutFilter(NmNhrSiBedDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNhrSiBedDO[] aggdos) throws BizException ;
	
}
