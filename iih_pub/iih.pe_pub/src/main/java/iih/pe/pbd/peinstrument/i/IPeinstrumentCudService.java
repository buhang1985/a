package iih.pe.pbd.peinstrument.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.peinstrument.d.PeInstrumentDO;
import iih.pe.pbd.peinstrument.d.PeinstrumentAggDO;

/**
* 仪器设备定义数据维护服务
*/
public interface IPeinstrumentCudService {
	/**
	*  仪器设备定义数据真删除
	*/
    public abstract void delete(PeinstrumentAggDO[] aggdos) throws BizException;
    
    /**
	*  仪器设备定义数据插入保存
	*/
	public abstract PeinstrumentAggDO[] insert(PeinstrumentAggDO[] aggdos) throws BizException;
	
    /**
	*  仪器设备定义数据保存
	*/
	public abstract PeinstrumentAggDO[] save(PeinstrumentAggDO[] aggdos) throws BizException;
	
    /**
	*  仪器设备定义数据更新
	*/
	public abstract PeinstrumentAggDO[] update(PeinstrumentAggDO[] aggdos) throws BizException;
	
	/**
	*  仪器设备定义数据逻辑删除
	*/
	public abstract void logicDelete(PeinstrumentAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对仪器设备定义数据真删除
	 */
	public abstract void deleteByParentDO(PeInstrumentDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对仪器设备定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeInstrumentDO[] mainDos) throws BizException;
}
