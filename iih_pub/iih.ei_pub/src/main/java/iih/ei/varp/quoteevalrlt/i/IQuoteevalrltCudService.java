package iih.ei.varp.quoteevalrlt.i;

import xap.mw.core.data.BizException;
import iih.ei.varp.quoteevalrlt.d.EiVarpQuoteEvalRltDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 报价器评价结果数据维护服务
*/
public interface IQuoteevalrltCudService {
	/**
	*  报价器评价结果数据真删除
	*/
    public abstract void delete(EiVarpQuoteEvalRltDO[] aggdos) throws BizException;
    
    /**
	*  报价器评价结果数据插入保存
	*/
	public abstract EiVarpQuoteEvalRltDO[] insert(EiVarpQuoteEvalRltDO[] aggdos) throws BizException;
	
    /**
	*  报价器评价结果数据保存
	*/
	public abstract EiVarpQuoteEvalRltDO[] save(EiVarpQuoteEvalRltDO[] aggdos) throws BizException;
	
    /**
	*  报价器评价结果数据更新
	*/
	public abstract EiVarpQuoteEvalRltDO[] update(EiVarpQuoteEvalRltDO[] aggdos) throws BizException;
	
	/**
	*  报价器评价结果数据逻辑删除
	*/
	public abstract void logicDelete(EiVarpQuoteEvalRltDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EiVarpQuoteEvalRltDO[] enableWithoutFilter(EiVarpQuoteEvalRltDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EiVarpQuoteEvalRltDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EiVarpQuoteEvalRltDO[] disableVOWithoutFilter(EiVarpQuoteEvalRltDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EiVarpQuoteEvalRltDO[] dos) throws BizException ;
}
