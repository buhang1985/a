package iih.mc.st.inspection.i;

import xap.mw.core.data.BizException;
import iih.mc.st.inspection.d.McInspectionDo;
import iih.mc.st.inspection.d.InspectionAggDO;

/**
* 高值耗材验收表数据维护服务
*/
public interface IInspectionCudService {
	/**
	*  高值耗材验收表数据真删除
	*/
    public abstract void delete(InspectionAggDO[] aggdos) throws BizException;
    
    /**
	*  高值耗材验收表数据插入保存
	*/
	public abstract InspectionAggDO[] insert(InspectionAggDO[] aggdos) throws BizException;
	
    /**
	*  高值耗材验收表数据保存
	*/
	public abstract InspectionAggDO[] save(InspectionAggDO[] aggdos) throws BizException;
	
    /**
	*  高值耗材验收表数据更新
	*/
	public abstract InspectionAggDO[] update(InspectionAggDO[] aggdos) throws BizException;
	
	/**
	*  高值耗材验收表数据逻辑删除
	*/
	public abstract void logicDelete(InspectionAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对高值耗材验收表数据真删除
	 */
	public abstract void deleteByParentDO(McInspectionDo[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对高值耗材验收表数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(McInspectionDo[] mainDos) throws BizException;
}
