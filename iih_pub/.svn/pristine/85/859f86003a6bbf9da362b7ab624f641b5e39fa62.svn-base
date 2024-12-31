package iih.pe.phm.pehmriskdef.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pehmriskdef.d.PeHmRiskDefDO;
import iih.pe.phm.pehmriskdef.d.PehmriskdefAggDO;

/**
* 健康危险因素定义数据维护服务
*/
public interface IPehmriskdefCudService {
	/**
	*  健康危险因素定义数据真删除
	*/
    public abstract void delete(PehmriskdefAggDO[] aggdos) throws BizException;
    
    /**
	*  健康危险因素定义数据插入保存
	*/
	public abstract PehmriskdefAggDO[] insert(PehmriskdefAggDO[] aggdos) throws BizException;
	
    /**
	*  健康危险因素定义数据保存
	*/
	public abstract PehmriskdefAggDO[] save(PehmriskdefAggDO[] aggdos) throws BizException;
	
    /**
	*  健康危险因素定义数据更新
	*/
	public abstract PehmriskdefAggDO[] update(PehmriskdefAggDO[] aggdos) throws BizException;
	
	/**
	*  健康危险因素定义数据逻辑删除
	*/
	public abstract void logicDelete(PehmriskdefAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康危险因素定义数据真删除
	 */
	public abstract void deleteByParentDO(PeHmRiskDefDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康危险因素定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeHmRiskDefDO[] mainDos) throws BizException;
}
