package iih.pe.pbd.peagegroup.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.peagegroup.d.PeAgeDO;
import iih.pe.pbd.peagegroup.d.PeagegroupAggDO;

/**
* 体检年龄分组数据维护服务
*/
public interface IPeagegroupCudService {
	/**
	*  体检年龄分组数据真删除
	*/
    public abstract void delete(PeagegroupAggDO[] aggdos) throws BizException;
    
    /**
	*  体检年龄分组数据插入保存
	*/
	public abstract PeagegroupAggDO[] insert(PeagegroupAggDO[] aggdos) throws BizException;
	
    /**
	*  体检年龄分组数据保存
	*/
	public abstract PeagegroupAggDO[] save(PeagegroupAggDO[] aggdos) throws BizException;
	
    /**
	*  体检年龄分组数据更新
	*/
	public abstract PeagegroupAggDO[] update(PeagegroupAggDO[] aggdos) throws BizException;
	
	/**
	*  体检年龄分组数据逻辑删除
	*/
	public abstract void logicDelete(PeagegroupAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检年龄分组数据真删除
	 */
	public abstract void deleteByParentDO(PeAgeDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检年龄分组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeAgeDO[] mainDos) throws BizException;
}
