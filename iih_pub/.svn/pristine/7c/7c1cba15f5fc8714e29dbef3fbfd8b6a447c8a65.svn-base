package iih.pe.pitm.perulecombine.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.perulecombine.d.PeRuleCombineItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检组合规则定义数据维护服务
*/
public interface IPeRuleCombineItemDOCudService {
	/**
	*  体检组合规则定义数据真删除
	*/
    public abstract void delete(PeRuleCombineItemDO[] aggdos) throws BizException;
    
    /**
	*  体检组合规则定义数据插入保存
	*/
	public abstract PeRuleCombineItemDO[] insert(PeRuleCombineItemDO[] aggdos) throws BizException;
	
    /**
	*  体检组合规则定义数据保存
	*/
	public abstract PeRuleCombineItemDO[] save(PeRuleCombineItemDO[] aggdos) throws BizException;
	
    /**
	*  体检组合规则定义数据更新
	*/
	public abstract PeRuleCombineItemDO[] update(PeRuleCombineItemDO[] aggdos) throws BizException;
	
	/**
	*  体检组合规则定义数据逻辑删除
	*/
	public abstract void logicDelete(PeRuleCombineItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeRuleCombineItemDO[] enableWithoutFilter(PeRuleCombineItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeRuleCombineItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeRuleCombineItemDO[] disableVOWithoutFilter(PeRuleCombineItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeRuleCombineItemDO[] aggdos) throws BizException ;
	
}
