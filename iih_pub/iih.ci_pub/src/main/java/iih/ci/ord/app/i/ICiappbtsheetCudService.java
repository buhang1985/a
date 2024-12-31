package iih.ci.ord.app.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.app.d.CiAppBtSheetDO;
import iih.ci.ord.app.d.CiappbtsheetAggDO;

/**
* 备血打印申请单数据维护服务
*/
public interface ICiappbtsheetCudService {
	/**
	*  备血打印申请单数据真删除
	*/
    public abstract void delete(CiappbtsheetAggDO[] aggdos) throws BizException;
    
    /**
	*  备血打印申请单数据插入保存
	*/
	public abstract CiappbtsheetAggDO[] insert(CiappbtsheetAggDO[] aggdos) throws BizException;
	
    /**
	*  备血打印申请单数据保存
	*/
	public abstract CiappbtsheetAggDO[] save(CiappbtsheetAggDO[] aggdos) throws BizException;
	
    /**
	*  备血打印申请单数据更新
	*/
	public abstract CiappbtsheetAggDO[] update(CiappbtsheetAggDO[] aggdos) throws BizException;
	
	/**
	*  备血打印申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiappbtsheetAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对备血打印申请单数据真删除
	 */
	public abstract void deleteByParentDO(CiAppBtSheetDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对备血打印申请单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiAppBtSheetDO[] mainDos) throws BizException;
}
