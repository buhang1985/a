package iih.pe.pitm.perstillness.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.perstillness.d.PeRstIllnessDO;
import iih.pe.pitm.perstillness.d.PerstillnessAggDO;

/**
* 体检疾病定义数据维护服务
*/
public interface IPerstillnessCudService {
	/**
	*  体检疾病定义数据真删除
	*/
    public abstract void delete(PerstillnessAggDO[] aggdos) throws BizException;
    
    /**
	*  体检疾病定义数据插入保存
	*/
	public abstract PerstillnessAggDO[] insert(PerstillnessAggDO[] aggdos) throws BizException;
	
    /**
	*  体检疾病定义数据保存
	*/
	public abstract PerstillnessAggDO[] save(PerstillnessAggDO[] aggdos) throws BizException;
	
    /**
	*  体检疾病定义数据更新
	*/
	public abstract PerstillnessAggDO[] update(PerstillnessAggDO[] aggdos) throws BizException;
	
	/**
	*  体检疾病定义数据逻辑删除
	*/
	public abstract void logicDelete(PerstillnessAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检疾病定义数据真删除
	 */
	public abstract void deleteByParentDO(PeRstIllnessDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检疾病定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRstIllnessDO[] mainDos) throws BizException;
}
