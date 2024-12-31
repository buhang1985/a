package iih.pe.pqn.pehramodel.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.pehramodel.d.PeHraModelDO;
import iih.pe.pqn.pehramodel.d.PehramodelAggDO;

/**
* 体检疾病风险评估模型数据维护服务
*/
public interface IPehramodelCudService {
	/**
	*  体检疾病风险评估模型数据真删除
	*/
    public abstract void delete(PehramodelAggDO[] aggdos) throws BizException;
    
    /**
	*  体检疾病风险评估模型数据插入保存
	*/
	public abstract PehramodelAggDO[] insert(PehramodelAggDO[] aggdos) throws BizException;
	
    /**
	*  体检疾病风险评估模型数据保存
	*/
	public abstract PehramodelAggDO[] save(PehramodelAggDO[] aggdos) throws BizException;
	
    /**
	*  体检疾病风险评估模型数据更新
	*/
	public abstract PehramodelAggDO[] update(PehramodelAggDO[] aggdos) throws BizException;
	
	/**
	*  体检疾病风险评估模型数据逻辑删除
	*/
	public abstract void logicDelete(PehramodelAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检疾病风险评估模型数据真删除
	 */
	public abstract void deleteByParentDO(PeHraModelDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检疾病风险评估模型数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeHraModelDO[] mainDos) throws BizException;
}
