package iih.bd.srv.medvalidate.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.medvalidate.d.BDErrorInfoDO;
import iih.bd.srv.medvalidate.d.MedvalidateAggDO;

/**
* 基础数据服务校验数据维护服务
*/
public interface IMedvalidateCudService {
	/**
	*  基础数据服务校验数据真删除
	*/
    public abstract void delete(MedvalidateAggDO[] aggdos) throws BizException;
    
    /**
	*  基础数据服务校验数据插入保存
	*/
	public abstract MedvalidateAggDO[] insert(MedvalidateAggDO[] aggdos) throws BizException;
	
    /**
	*  基础数据服务校验数据保存
	*/
	public abstract MedvalidateAggDO[] save(MedvalidateAggDO[] aggdos) throws BizException;
	
    /**
	*  基础数据服务校验数据更新
	*/
	public abstract MedvalidateAggDO[] update(MedvalidateAggDO[] aggdos) throws BizException;
	
	/**
	*  基础数据服务校验数据逻辑删除
	*/
	public abstract void logicDelete(MedvalidateAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对基础数据服务校验数据真删除
	 */
	public abstract void deleteByParentDO(BDErrorInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对基础数据服务校验数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BDErrorInfoDO[] mainDos) throws BizException;
}
