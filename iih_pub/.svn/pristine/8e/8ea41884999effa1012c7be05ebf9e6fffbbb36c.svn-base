package iih.bd.srv.nurcustomca.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.nurcustomca.d.NurCustomcaDO;
import iih.bd.srv.nurcustomca.d.NurcustomcaAggDO;

/**
* 医疗记录_护理文书分类数据维护服务
*/
public interface INurcustomcaCudService {
	/**
	*  医疗记录_护理文书分类数据真删除
	*/
    public abstract void delete(NurcustomcaAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录_护理文书分类数据插入保存
	*/
	public abstract NurcustomcaAggDO[] insert(NurcustomcaAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录_护理文书分类数据保存
	*/
	public abstract NurcustomcaAggDO[] save(NurcustomcaAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录_护理文书分类数据更新
	*/
	public abstract NurcustomcaAggDO[] update(NurcustomcaAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录_护理文书分类数据逻辑删除
	*/
	public abstract void logicDelete(NurcustomcaAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗记录_护理文书分类数据真删除
	 */
	public abstract void deleteByParentDO(NurCustomcaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗记录_护理文书分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NurCustomcaDO[] mainDos) throws BizException;
}
