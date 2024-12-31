package iih.nmr.pkuf.carecord.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.carecord.d.CarecorDO;
import iih.nmr.pkuf.carecord.d.Carecord1AggDO;

/**
* 护理记录单数据维护服务
*/
public interface ICarecord1CudService {
	/**
	*  护理记录单数据真删除
	*/
    public abstract void delete(Carecord1AggDO[] aggdos) throws BizException;
    
    /**
	*  护理记录单数据插入保存
	*/
	public abstract Carecord1AggDO[] insert(Carecord1AggDO[] aggdos) throws BizException;
	
    /**
	*  护理记录单数据保存
	*/
	public abstract Carecord1AggDO[] save(Carecord1AggDO[] aggdos) throws BizException;
	
    /**
	*  护理记录单数据更新
	*/
	public abstract Carecord1AggDO[] update(Carecord1AggDO[] aggdos) throws BizException;
	
	/**
	*  护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(Carecord1AggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(CarecorDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CarecorDO[] mainDos) throws BizException;
}
