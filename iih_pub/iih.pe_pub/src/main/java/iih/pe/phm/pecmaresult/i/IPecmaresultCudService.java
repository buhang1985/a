package iih.pe.phm.pecmaresult.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pecmaresult.d.PeCmaDO;
import iih.pe.phm.pecmaresult.d.PecmaresultAggDO;

/**
* 健康评估自测问卷结果数据维护服务
*/
public interface IPecmaresultCudService {
	/**
	*  健康评估自测问卷结果数据真删除
	*/
    public abstract void delete(PecmaresultAggDO[] aggdos) throws BizException;
    
    /**
	*  健康评估自测问卷结果数据插入保存
	*/
	public abstract PecmaresultAggDO[] insert(PecmaresultAggDO[] aggdos) throws BizException;
	
    /**
	*  健康评估自测问卷结果数据保存
	*/
	public abstract PecmaresultAggDO[] save(PecmaresultAggDO[] aggdos) throws BizException;
	
    /**
	*  健康评估自测问卷结果数据更新
	*/
	public abstract PecmaresultAggDO[] update(PecmaresultAggDO[] aggdos) throws BizException;
	
	/**
	*  健康评估自测问卷结果数据逻辑删除
	*/
	public abstract void logicDelete(PecmaresultAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康评估自测问卷结果数据真删除
	 */
	public abstract void deleteByParentDO(PeCmaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康评估自测问卷结果数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeCmaDO[] mainDos) throws BizException;
}
