package iih.nmr.pkuf.laborprorecord.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.laborprorecord.d.PuerperainfoDO;
import iih.nmr.pkuf.laborprorecord.d.LaborprorecordAggDO;

/**
* 产程观察护理记录数据维护服务
*/
public interface ILaborprorecordCudService {
	/**
	*  产程观察护理记录数据真删除
	*/
    public abstract void delete(LaborprorecordAggDO[] aggdos) throws BizException;
    
    /**
	*  产程观察护理记录数据插入保存
	*/
	public abstract LaborprorecordAggDO[] insert(LaborprorecordAggDO[] aggdos) throws BizException;
	
    /**
	*  产程观察护理记录数据保存
	*/
	public abstract LaborprorecordAggDO[] save(LaborprorecordAggDO[] aggdos) throws BizException;
	
    /**
	*  产程观察护理记录数据更新
	*/
	public abstract LaborprorecordAggDO[] update(LaborprorecordAggDO[] aggdos) throws BizException;
	
	/**
	*  产程观察护理记录数据逻辑删除
	*/
	public abstract void logicDelete(LaborprorecordAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对产程观察护理记录数据真删除
	 */
	public abstract void deleteByParentDO(PuerperainfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对产程观察护理记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PuerperainfoDO[] mainDos) throws BizException;
}
