package iih.bd.pp.inccasplit.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.inccasplit.d.BdInccaSplitDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 票据分票设置数据维护服务
*/
public interface IInccasplitCudService {
	/**
	*  票据分票设置数据真删除
	*/
    public abstract void delete(BdInccaSplitDO[] aggdos) throws BizException;
    
    /**
	*  票据分票设置数据插入保存
	*/
	public abstract BdInccaSplitDO[] insert(BdInccaSplitDO[] aggdos) throws BizException;
	
    /**
	*  票据分票设置数据保存
	*/
	public abstract BdInccaSplitDO[] save(BdInccaSplitDO[] aggdos) throws BizException;
	
    /**
	*  票据分票设置数据更新
	*/
	public abstract BdInccaSplitDO[] update(BdInccaSplitDO[] aggdos) throws BizException;
	
	/**
	*  票据分票设置数据逻辑删除
	*/
	public abstract void logicDelete(BdInccaSplitDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdInccaSplitDO[] enableWithoutFilter(BdInccaSplitDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdInccaSplitDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdInccaSplitDO[] disableVOWithoutFilter(BdInccaSplitDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdInccaSplitDO[] dos) throws BizException ;
}
