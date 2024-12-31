package iih.mp.mpbd.prnca.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.prnca.d.MpOrPrncaDO;
import iih.mp.mpbd.prnca.d.PrncaAggDO;

/**
* 病区执行打印单据分类数据维护服务
*/
public interface IPrncaCudService {
	/**
	*  病区执行打印单据分类数据真删除
	*/
    public abstract void delete(PrncaAggDO[] aggdos) throws BizException;
    
    /**
	*  病区执行打印单据分类数据插入保存
	*/
	public abstract PrncaAggDO[] insert(PrncaAggDO[] aggdos) throws BizException;
	
    /**
	*  病区执行打印单据分类数据保存
	*/
	public abstract PrncaAggDO[] save(PrncaAggDO[] aggdos) throws BizException;
	
    /**
	*  病区执行打印单据分类数据更新
	*/
	public abstract PrncaAggDO[] update(PrncaAggDO[] aggdos) throws BizException;
	
	/**
	*  病区执行打印单据分类数据逻辑删除
	*/
	public abstract void logicDelete(PrncaAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病区执行打印单据分类数据真删除
	 */
	public abstract void deleteByParentDO(MpOrPrncaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病区执行打印单据分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MpOrPrncaDO[] mainDos) throws BizException;
}
