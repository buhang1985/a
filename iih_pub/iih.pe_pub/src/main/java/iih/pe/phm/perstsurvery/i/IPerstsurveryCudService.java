package iih.pe.phm.perstsurvery.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.perstsurvery.d.PeRstSurveryDO;
import iih.pe.phm.perstsurvery.d.PerstsurveryAggDO;

/**
* 体检问卷结果数据维护服务
*/
public interface IPerstsurveryCudService {
	/**
	*  体检问卷结果数据真删除
	*/
    public abstract void delete(PerstsurveryAggDO[] aggdos) throws BizException;
    
    /**
	*  体检问卷结果数据插入保存
	*/
	public abstract PerstsurveryAggDO[] insert(PerstsurveryAggDO[] aggdos) throws BizException;
	
    /**
	*  体检问卷结果数据保存
	*/
	public abstract PerstsurveryAggDO[] save(PerstsurveryAggDO[] aggdos) throws BizException;
	
    /**
	*  体检问卷结果数据更新
	*/
	public abstract PerstsurveryAggDO[] update(PerstsurveryAggDO[] aggdos) throws BizException;
	
	/**
	*  体检问卷结果数据逻辑删除
	*/
	public abstract void logicDelete(PerstsurveryAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检问卷结果数据真删除
	 */
	public abstract void deleteByParentDO(PeRstSurveryDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检问卷结果数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRstSurveryDO[] mainDos) throws BizException;
}
