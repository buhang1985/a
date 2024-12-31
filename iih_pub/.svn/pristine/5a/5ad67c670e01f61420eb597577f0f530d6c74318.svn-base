package iih.ei.hwi.eihwiregdo.i;

import xap.mw.core.data.BizException;
import iih.ei.hwi.eihwiregdo.d.EiHwiRegDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* EiHwiRegDO数据维护服务
*/
public interface IEihwiregdoCudService {
	/**
	*  EiHwiRegDO数据真删除
	*/
    public abstract void delete(EiHwiRegDO[] aggdos) throws BizException;
    
    /**
	*  EiHwiRegDO数据插入保存
	*/
	public abstract EiHwiRegDO[] insert(EiHwiRegDO[] aggdos) throws BizException;
	
    /**
	*  EiHwiRegDO数据保存
	*/
	public abstract EiHwiRegDO[] save(EiHwiRegDO[] aggdos) throws BizException;
	
    /**
	*  EiHwiRegDO数据更新
	*/
	public abstract EiHwiRegDO[] update(EiHwiRegDO[] aggdos) throws BizException;
	
	/**
	*  EiHwiRegDO数据逻辑删除
	*/
	public abstract void logicDelete(EiHwiRegDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EiHwiRegDO[] enableWithoutFilter(EiHwiRegDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EiHwiRegDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EiHwiRegDO[] disableVOWithoutFilter(EiHwiRegDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EiHwiRegDO[] dos) throws BizException ;
}
