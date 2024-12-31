package iih.nmr.pkuf.regformfordeliver.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.regformfordeliver.d.RegformDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 分娩登记表数据维护服务
*/
public interface IRegformfordeliverMDOCudService {
	/**
	*  分娩登记表数据真删除
	*/
    public abstract void delete(RegformDO[] aggdos) throws BizException;
    
    /**
	*  分娩登记表数据插入保存
	*/
	public abstract RegformDO[] insert(RegformDO[] aggdos) throws BizException;
	
    /**
	*  分娩登记表数据保存
	*/
	public abstract RegformDO[] save(RegformDO[] aggdos) throws BizException;
	
    /**
	*  分娩登记表数据更新
	*/
	public abstract RegformDO[] update(RegformDO[] aggdos) throws BizException;
	
	/**
	*  分娩登记表数据逻辑删除
	*/
	public abstract void logicDelete(RegformDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public RegformDO[] enableWithoutFilter(RegformDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(RegformDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public RegformDO[] disableVOWithoutFilter(RegformDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(RegformDO[] aggdos) throws BizException ;
	
}
