package iih.cssd.dpst.dfpsto.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpst.dfpsto.d.DfpStoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 消毒包储藏数据维护服务
*/
public interface IDfpstoCudService {
	/**
	*  消毒包储藏数据真删除
	*/
    public abstract void delete(DfpStoDO[] aggdos) throws BizException;
    
    /**
	*  消毒包储藏数据插入保存
	*/
	public abstract DfpStoDO[] insert(DfpStoDO[] aggdos) throws BizException;
	
    /**
	*  消毒包储藏数据保存
	*/
	public abstract DfpStoDO[] save(DfpStoDO[] aggdos) throws BizException;
	
    /**
	*  消毒包储藏数据更新
	*/
	public abstract DfpStoDO[] update(DfpStoDO[] aggdos) throws BizException;
	
	/**
	*  消毒包储藏数据逻辑删除
	*/
	public abstract void logicDelete(DfpStoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DfpStoDO[] enableWithoutFilter(DfpStoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DfpStoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DfpStoDO[] disableVOWithoutFilter(DfpStoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DfpStoDO[] dos) throws BizException ;
}
