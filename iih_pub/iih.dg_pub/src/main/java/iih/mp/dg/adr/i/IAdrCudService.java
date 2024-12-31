package iih.mp.dg.adr.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.adr.d.MpDgAdrDO;
import iih.mp.dg.adr.d.AdrAggDO;

/**
* 药品不良反应数据维护服务
*/
public interface IAdrCudService {
	/**
	*  药品不良反应数据真删除
	*/
    public abstract void delete(AdrAggDO[] aggdos) throws BizException;
    
    /**
	*  药品不良反应数据插入保存
	*/
	public abstract AdrAggDO[] insert(AdrAggDO[] aggdos) throws BizException;
	
    /**
	*  药品不良反应数据保存
	*/
	public abstract AdrAggDO[] save(AdrAggDO[] aggdos) throws BizException;
	
    /**
	*  药品不良反应数据更新
	*/
	public abstract AdrAggDO[] update(AdrAggDO[] aggdos) throws BizException;
	
	/**
	*  药品不良反应数据逻辑删除
	*/
	public abstract void logicDelete(AdrAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对药品不良反应数据真删除
	 */
	public abstract void deleteByParentDO(MpDgAdrDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对药品不良反应数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MpDgAdrDO[] mainDos) throws BizException;
}
