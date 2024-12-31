package iih.nm.nca.satsrvyrecord.i;

import xap.mw.core.data.BizException;
import iih.nm.nca.satsrvyrecord.d.NmNcaSrvyRecordDO;
import iih.nm.nca.satsrvyrecord.d.SatsrvyAggDO;

/**
* 满意度调查记录数据维护服务
*/
public interface ISatsrvyCudService {
	/**
	*  满意度调查记录数据真删除
	*/
    public abstract void delete(SatsrvyAggDO[] aggdos) throws BizException;
    
    /**
	*  满意度调查记录数据插入保存
	*/
	public abstract SatsrvyAggDO[] insert(SatsrvyAggDO[] aggdos) throws BizException;
	
    /**
	*  满意度调查记录数据保存
	*/
	public abstract SatsrvyAggDO[] save(SatsrvyAggDO[] aggdos) throws BizException;
	
    /**
	*  满意度调查记录数据更新
	*/
	public abstract SatsrvyAggDO[] update(SatsrvyAggDO[] aggdos) throws BizException;
	
	/**
	*  满意度调查记录数据逻辑删除
	*/
	public abstract void logicDelete(SatsrvyAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对满意度调查记录数据真删除
	 */
	public abstract void deleteByParentDO(NmNcaSrvyRecordDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对满意度调查记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNcaSrvyRecordDO[] mainDos) throws BizException;
}
