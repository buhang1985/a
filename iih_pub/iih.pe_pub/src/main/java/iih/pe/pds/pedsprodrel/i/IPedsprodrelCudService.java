package iih.pe.pds.pedsprodrel.i;

import xap.mw.core.data.BizException;
import iih.pe.pds.pedsprodrel.d.PeDsProdRelDO;
import iih.pe.pds.pedsprodrel.d.PedsprodrelAggDO;

/**
* 体检产品项目关联关系数据维护服务
*/
public interface IPedsprodrelCudService {
	/**
	*  体检产品项目关联关系数据真删除
	*/
    public abstract void delete(PedsprodrelAggDO[] aggdos) throws BizException;
    
    /**
	*  体检产品项目关联关系数据插入保存
	*/
	public abstract PedsprodrelAggDO[] insert(PedsprodrelAggDO[] aggdos) throws BizException;
	
    /**
	*  体检产品项目关联关系数据保存
	*/
	public abstract PedsprodrelAggDO[] save(PedsprodrelAggDO[] aggdos) throws BizException;
	
    /**
	*  体检产品项目关联关系数据更新
	*/
	public abstract PedsprodrelAggDO[] update(PedsprodrelAggDO[] aggdos) throws BizException;
	
	/**
	*  体检产品项目关联关系数据逻辑删除
	*/
	public abstract void logicDelete(PedsprodrelAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检产品项目关联关系数据真删除
	 */
	public abstract void deleteByParentDO(PeDsProdRelDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检产品项目关联关系数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeDsProdRelDO[] mainDos) throws BizException;
}
