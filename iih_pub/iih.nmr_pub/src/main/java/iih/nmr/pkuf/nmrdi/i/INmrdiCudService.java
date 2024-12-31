package iih.nmr.pkuf.nmrdi.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrdi.d.NmrDiDO;
import iih.nmr.pkuf.nmrdi.d.NmrdiAggDO;

/**
* 护理诊断数据维护服务
*/
public interface INmrdiCudService {
	/**
	*  护理诊断数据真删除
	*/
    public abstract void delete(NmrdiAggDO[] aggdos) throws BizException;
    
    /**
	*  护理诊断数据插入保存
	*/
	public abstract NmrdiAggDO[] insert(NmrdiAggDO[] aggdos) throws BizException;
	
    /**
	*  护理诊断数据保存
	*/
	public abstract NmrdiAggDO[] save(NmrdiAggDO[] aggdos) throws BizException;
	
    /**
	*  护理诊断数据更新
	*/
	public abstract NmrdiAggDO[] update(NmrdiAggDO[] aggdos) throws BizException;
	
	/**
	*  护理诊断数据逻辑删除
	*/
	public abstract void logicDelete(NmrdiAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理诊断数据真删除
	 */
	public abstract void deleteByParentDO(NmrDiDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理诊断数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmrDiDO[] mainDos) throws BizException;
}
