package iih.nm.nom.nomev.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nomev.d.NomEvPsnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理部大事记数据维护服务
*/
public interface INomEvPsnDOCudService {
	/**
	*  护理部大事记数据真删除
	*/
    public abstract void delete(NomEvPsnDO[] aggdos) throws BizException;
    
    /**
	*  护理部大事记数据插入保存
	*/
	public abstract NomEvPsnDO[] insert(NomEvPsnDO[] aggdos) throws BizException;
	
    /**
	*  护理部大事记数据保存
	*/
	public abstract NomEvPsnDO[] save(NomEvPsnDO[] aggdos) throws BizException;
	
    /**
	*  护理部大事记数据更新
	*/
	public abstract NomEvPsnDO[] update(NomEvPsnDO[] aggdos) throws BizException;
	
	/**
	*  护理部大事记数据逻辑删除
	*/
	public abstract void logicDelete(NomEvPsnDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NomEvPsnDO[] enableWithoutFilter(NomEvPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NomEvPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NomEvPsnDO[] disableVOWithoutFilter(NomEvPsnDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NomEvPsnDO[] aggdos) throws BizException ;
	
}
