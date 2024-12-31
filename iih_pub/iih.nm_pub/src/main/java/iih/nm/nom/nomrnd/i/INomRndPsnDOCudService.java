package iih.nm.nom.nomrnd.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nomrnd.d.NomRndPsnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理查房记录数据维护服务
*/
public interface INomRndPsnDOCudService {
	/**
	*  护理查房记录数据真删除
	*/
    public abstract void delete(NomRndPsnDO[] aggdos) throws BizException;
    
    /**
	*  护理查房记录数据插入保存
	*/
	public abstract NomRndPsnDO[] insert(NomRndPsnDO[] aggdos) throws BizException;
	
    /**
	*  护理查房记录数据保存
	*/
	public abstract NomRndPsnDO[] save(NomRndPsnDO[] aggdos) throws BizException;
	
    /**
	*  护理查房记录数据更新
	*/
	public abstract NomRndPsnDO[] update(NomRndPsnDO[] aggdos) throws BizException;
	
	/**
	*  护理查房记录数据逻辑删除
	*/
	public abstract void logicDelete(NomRndPsnDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NomRndPsnDO[] enableWithoutFilter(NomRndPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NomRndPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NomRndPsnDO[] disableVOWithoutFilter(NomRndPsnDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NomRndPsnDO[] aggdos) throws BizException ;
	
}
