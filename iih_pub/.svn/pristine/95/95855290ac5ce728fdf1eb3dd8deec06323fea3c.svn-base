package iih.pe.pps.peinterview.i;

import xap.mw.core.data.BizException;
import iih.pe.pps.peinterview.d.PeInterviewDO;
import iih.pe.pps.peinterview.d.PeinterviewAggDO;

/**
* 体检检后随访数据维护服务
*/
public interface IPeinterviewCudService {
	/**
	*  体检检后随访数据真删除
	*/
    public abstract void delete(PeinterviewAggDO[] aggdos) throws BizException;
    
    /**
	*  体检检后随访数据插入保存
	*/
	public abstract PeinterviewAggDO[] insert(PeinterviewAggDO[] aggdos) throws BizException;
	
    /**
	*  体检检后随访数据保存
	*/
	public abstract PeinterviewAggDO[] save(PeinterviewAggDO[] aggdos) throws BizException;
	
    /**
	*  体检检后随访数据更新
	*/
	public abstract PeinterviewAggDO[] update(PeinterviewAggDO[] aggdos) throws BizException;
	
	/**
	*  体检检后随访数据逻辑删除
	*/
	public abstract void logicDelete(PeinterviewAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检检后随访数据真删除
	 */
	public abstract void deleteByParentDO(PeInterviewDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检检后随访数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeInterviewDO[] mainDos) throws BizException;
}
