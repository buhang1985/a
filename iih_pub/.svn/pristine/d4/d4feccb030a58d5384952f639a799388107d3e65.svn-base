package iih.pe.pqc.peqcchart.i;

import xap.mw.core.data.BizException;
import iih.pe.pqc.peqcchart.d.PeQcChartDO;
import iih.pe.pqc.peqcchart.d.PeqcchartAggDO;

/**
* 体检质控图数据维护服务
*/
public interface IPeqcchartCudService {
	/**
	*  体检质控图数据真删除
	*/
    public abstract void delete(PeqcchartAggDO[] aggdos) throws BizException;
    
    /**
	*  体检质控图数据插入保存
	*/
	public abstract PeqcchartAggDO[] insert(PeqcchartAggDO[] aggdos) throws BizException;
	
    /**
	*  体检质控图数据保存
	*/
	public abstract PeqcchartAggDO[] save(PeqcchartAggDO[] aggdos) throws BizException;
	
    /**
	*  体检质控图数据更新
	*/
	public abstract PeqcchartAggDO[] update(PeqcchartAggDO[] aggdos) throws BizException;
	
	/**
	*  体检质控图数据逻辑删除
	*/
	public abstract void logicDelete(PeqcchartAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检质控图数据真删除
	 */
	public abstract void deleteByParentDO(PeQcChartDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检质控图数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeQcChartDO[] mainDos) throws BizException;
}
