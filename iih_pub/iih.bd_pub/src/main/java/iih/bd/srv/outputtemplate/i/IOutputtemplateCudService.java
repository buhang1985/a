package iih.bd.srv.outputtemplate.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.outputtemplate.d.OutputTemplateDO;
import iih.bd.srv.outputtemplate.d.OutputtemplateAggDO;

/**
* 输出模板数据维护服务
*/
public interface IOutputtemplateCudService {
	/**
	*  输出模板数据真删除
	*/
    public abstract void delete(OutputtemplateAggDO[] aggdos) throws BizException;
    
    /**
	*  输出模板数据插入保存
	*/
	public abstract OutputtemplateAggDO[] insert(OutputtemplateAggDO[] aggdos) throws BizException;
	
    /**
	*  输出模板数据保存
	*/
	public abstract OutputtemplateAggDO[] save(OutputtemplateAggDO[] aggdos) throws BizException;
	
    /**
	*  输出模板数据更新
	*/
	public abstract OutputtemplateAggDO[] update(OutputtemplateAggDO[] aggdos) throws BizException;
	
	/**
	*  输出模板数据逻辑删除
	*/
	public abstract void logicDelete(OutputtemplateAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对输出模板数据真删除
	 */
	public abstract void deleteByParentDO(OutputTemplateDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对输出模板数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OutputTemplateDO[] mainDos) throws BizException;
}
