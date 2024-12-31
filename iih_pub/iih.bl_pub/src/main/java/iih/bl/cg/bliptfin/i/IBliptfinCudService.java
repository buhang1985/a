package iih.bl.cg.bliptfin.i;

import xap.mw.core.data.BizException;
import iih.bl.cg.bliptfin.d.BlCgIpTfInDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门诊转住院记账明细数据维护服务
*/
public interface IBliptfinCudService {
	/**
	*  门诊转住院记账明细数据真删除
	*/
    public abstract void delete(BlCgIpTfInDO[] aggdos) throws BizException;
    
    /**
	*  门诊转住院记账明细数据插入保存
	*/
	public abstract BlCgIpTfInDO[] insert(BlCgIpTfInDO[] aggdos) throws BizException;
	
    /**
	*  门诊转住院记账明细数据保存
	*/
	public abstract BlCgIpTfInDO[] save(BlCgIpTfInDO[] aggdos) throws BizException;
	
    /**
	*  门诊转住院记账明细数据更新
	*/
	public abstract BlCgIpTfInDO[] update(BlCgIpTfInDO[] aggdos) throws BizException;
	
	/**
	*  门诊转住院记账明细数据逻辑删除
	*/
	public abstract void logicDelete(BlCgIpTfInDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlCgIpTfInDO[] enableWithoutFilter(BlCgIpTfInDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlCgIpTfInDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlCgIpTfInDO[] disableVOWithoutFilter(BlCgIpTfInDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlCgIpTfInDO[] dos) throws BizException ;
}
