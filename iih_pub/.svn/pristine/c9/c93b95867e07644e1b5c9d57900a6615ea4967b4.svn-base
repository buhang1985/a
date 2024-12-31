package iih.pe.pps.pepositrack.i;

import xap.mw.core.data.BizException;
import iih.pe.pps.pepositrack.d.PePosiTrackDO;
import iih.pe.pps.pepositrack.d.PepositrackAggDO;

/**
* 体检阳性结果追踪数据维护服务
*/
public interface IPepositrackCudService {
	/**
	*  体检阳性结果追踪数据真删除
	*/
    public abstract void delete(PepositrackAggDO[] aggdos) throws BizException;
    
    /**
	*  体检阳性结果追踪数据插入保存
	*/
	public abstract PepositrackAggDO[] insert(PepositrackAggDO[] aggdos) throws BizException;
	
    /**
	*  体检阳性结果追踪数据保存
	*/
	public abstract PepositrackAggDO[] save(PepositrackAggDO[] aggdos) throws BizException;
	
    /**
	*  体检阳性结果追踪数据更新
	*/
	public abstract PepositrackAggDO[] update(PepositrackAggDO[] aggdos) throws BizException;
	
	/**
	*  体检阳性结果追踪数据逻辑删除
	*/
	public abstract void logicDelete(PepositrackAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检阳性结果追踪数据真删除
	 */
	public abstract void deleteByParentDO(PePosiTrackDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检阳性结果追踪数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PePosiTrackDO[] mainDos) throws BizException;
}
