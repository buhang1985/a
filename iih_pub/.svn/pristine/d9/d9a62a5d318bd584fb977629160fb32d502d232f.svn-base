package iih.pe.pqn.pediabmodel.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.pediabmodel.d.PeDiabModelDO;
import iih.pe.pqn.pediabmodel.d.PediabmodelAggDO;

/**
* 健康评估模型_糖尿病数据维护服务
*/
public interface IPediabmodelCudService {
	/**
	*  健康评估模型_糖尿病数据真删除
	*/
    public abstract void delete(PediabmodelAggDO[] aggdos) throws BizException;
    
    /**
	*  健康评估模型_糖尿病数据插入保存
	*/
	public abstract PediabmodelAggDO[] insert(PediabmodelAggDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_糖尿病数据保存
	*/
	public abstract PediabmodelAggDO[] save(PediabmodelAggDO[] aggdos) throws BizException;
	
    /**
	*  健康评估模型_糖尿病数据更新
	*/
	public abstract PediabmodelAggDO[] update(PediabmodelAggDO[] aggdos) throws BizException;
	
	/**
	*  健康评估模型_糖尿病数据逻辑删除
	*/
	public abstract void logicDelete(PediabmodelAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康评估模型_糖尿病数据真删除
	 */
	public abstract void deleteByParentDO(PeDiabModelDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康评估模型_糖尿病数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeDiabModelDO[] mainDos) throws BizException;
}
