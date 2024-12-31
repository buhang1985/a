package iih.mp.mpbd.mpmbhfunca.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.mpmbhfunca.d.MpMbhAppCaDO;
import iih.mp.mpbd.mpmbhfunca.d.MpmbhfuncaAggDO;

/**
* 移动医疗功能分类数据维护服务
*/
public interface IMpmbhfuncaCudService {
	/**
	*  移动医疗功能分类数据真删除
	*/
    public abstract void delete(MpmbhfuncaAggDO[] aggdos) throws BizException;
    
    /**
	*  移动医疗功能分类数据插入保存
	*/
	public abstract MpmbhfuncaAggDO[] insert(MpmbhfuncaAggDO[] aggdos) throws BizException;
	
    /**
	*  移动医疗功能分类数据保存
	*/
	public abstract MpmbhfuncaAggDO[] save(MpmbhfuncaAggDO[] aggdos) throws BizException;
	
    /**
	*  移动医疗功能分类数据更新
	*/
	public abstract MpmbhfuncaAggDO[] update(MpmbhfuncaAggDO[] aggdos) throws BizException;
	
	/**
	*  移动医疗功能分类数据逻辑删除
	*/
	public abstract void logicDelete(MpmbhfuncaAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对移动医疗功能分类数据真删除
	 */
	public abstract void deleteByParentDO(MpMbhAppCaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对移动医疗功能分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MpMbhAppCaDO[] mainDos) throws BizException;
}
