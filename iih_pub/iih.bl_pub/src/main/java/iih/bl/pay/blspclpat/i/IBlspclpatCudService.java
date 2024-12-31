package iih.bl.pay.blspclpat.i;

import xap.mw.core.data.BizException;
import iih.bl.pay.blspclpat.d.BlSpclPatDO;
import iih.bl.pay.blspclpat.d.BlspclpatAggDO;

/**
* 患者专用款数据维护服务
*/
public interface IBlspclpatCudService {
	/**
	*  患者专用款数据真删除
	*/
    public abstract void delete(BlspclpatAggDO[] aggdos) throws BizException;
    
    /**
	*  患者专用款数据插入保存
	*/
	public abstract BlspclpatAggDO[] insert(BlspclpatAggDO[] aggdos) throws BizException;
	
    /**
	*  患者专用款数据保存
	*/
	public abstract BlspclpatAggDO[] save(BlspclpatAggDO[] aggdos) throws BizException;
	
    /**
	*  患者专用款数据更新
	*/
	public abstract BlspclpatAggDO[] update(BlspclpatAggDO[] aggdos) throws BizException;
	
	/**
	*  患者专用款数据逻辑删除
	*/
	public abstract void logicDelete(BlspclpatAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者专用款数据真删除
	 */
	public abstract void deleteByParentDO(BlSpclPatDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者专用款数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlSpclPatDO[] mainDos) throws BizException;
}
