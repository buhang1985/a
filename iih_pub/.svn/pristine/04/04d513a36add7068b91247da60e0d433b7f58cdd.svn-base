package iih.ci.mr.nu.intervopre.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.intervopre.d.InterPatInfoDO;
import iih.ci.mr.nu.intervopre.d.IntervopreAggDO;

/**
* 介入手术护理记录单数据维护服务
*/
public interface IIntervopreCudService {
	/**
	*  介入手术护理记录单数据真删除
	*/
    public abstract void delete(IntervopreAggDO[] aggdos) throws BizException;
    
    /**
	*  介入手术护理记录单数据插入保存
	*/
	public abstract IntervopreAggDO[] insert(IntervopreAggDO[] aggdos) throws BizException;
	
    /**
	*  介入手术护理记录单数据保存
	*/
	public abstract IntervopreAggDO[] save(IntervopreAggDO[] aggdos) throws BizException;
	
    /**
	*  介入手术护理记录单数据更新
	*/
	public abstract IntervopreAggDO[] update(IntervopreAggDO[] aggdos) throws BizException;
	
	/**
	*  介入手术护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(IntervopreAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对介入手术护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(InterPatInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对介入手术护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(InterPatInfoDO[] mainDos) throws BizException;
}
