package iih.ci.ord.app.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiapprissheetAggDO;

/**
* 检查打印申请单数据维护服务
*/
public interface ICiapprissheetCudService {
	/**
	*  检查打印申请单数据真删除
	*/
    public abstract void delete(CiapprissheetAggDO[] aggdos) throws BizException;
    
    /**
	*  检查打印申请单数据插入保存
	*/
	public abstract CiapprissheetAggDO[] insert(CiapprissheetAggDO[] aggdos) throws BizException;
	
    /**
	*  检查打印申请单数据保存
	*/
	public abstract CiapprissheetAggDO[] save(CiapprissheetAggDO[] aggdos) throws BizException;
	
    /**
	*  检查打印申请单数据更新
	*/
	public abstract CiapprissheetAggDO[] update(CiapprissheetAggDO[] aggdos) throws BizException;
	
	/**
	*  检查打印申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiapprissheetAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对检查打印申请单数据真删除
	 */
	public abstract void deleteByParentDO(CiAppRisSheetDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对检查打印申请单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiAppRisSheetDO[] mainDos) throws BizException;
}
