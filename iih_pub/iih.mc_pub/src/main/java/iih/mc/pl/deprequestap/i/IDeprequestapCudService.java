package iih.mc.pl.deprequestap.i;

import xap.mw.core.data.BizException;
import iih.mc.pl.deprequestap.d.McDepReqApOrderDO;
import iih.mc.pl.deprequestap.d.DeprequestapAggDO;

/**
* 部门领用申请单数据维护服务
*/
public interface IDeprequestapCudService {
	/**
	*  部门领用申请单数据真删除
	*/
    public abstract void delete(DeprequestapAggDO[] aggdos) throws BizException;
    
    /**
	*  部门领用申请单数据插入保存
	*/
	public abstract DeprequestapAggDO[] insert(DeprequestapAggDO[] aggdos) throws BizException;
	
    /**
	*  部门领用申请单数据保存
	*/
	public abstract DeprequestapAggDO[] save(DeprequestapAggDO[] aggdos) throws BizException;
	
    /**
	*  部门领用申请单数据更新
	*/
	public abstract DeprequestapAggDO[] update(DeprequestapAggDO[] aggdos) throws BizException;
	
	/**
	*  部门领用申请单数据逻辑删除
	*/
	public abstract void logicDelete(DeprequestapAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对部门领用申请单数据真删除
	 */
	public abstract void deleteByParentDO(McDepReqApOrderDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对部门领用申请单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(McDepReqApOrderDO[] mainDos) throws BizException;
}
