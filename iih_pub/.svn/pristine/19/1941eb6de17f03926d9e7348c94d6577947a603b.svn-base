package iih.ci.tsip.i;

import xap.mw.core.data.BizException;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.d.CitsorderAggDO;

/**
* 治疗方案医嘱数据维护服务
*/
public interface ICitsorderCudService {
	/**
	*  治疗方案医嘱数据真删除
	*/
    public abstract void delete(CitsorderAggDO[] aggdos) throws BizException;
    
    /**
	*  治疗方案医嘱数据插入保存
	*/
	public abstract CitsorderAggDO[] insert(CitsorderAggDO[] aggdos) throws BizException;
	
    /**
	*  治疗方案医嘱数据保存
	*/
	public abstract CitsorderAggDO[] save(CitsorderAggDO[] aggdos) throws BizException;
	
    /**
	*  治疗方案医嘱数据更新
	*/
	public abstract CitsorderAggDO[] update(CitsorderAggDO[] aggdos) throws BizException;
	
	/**
	*  治疗方案医嘱数据逻辑删除
	*/
	public abstract void logicDelete(CitsorderAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对治疗方案医嘱数据真删除
	 */
	public abstract void deleteByParentDO(CiTsOrDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对治疗方案医嘱数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiTsOrDO[] mainDos) throws BizException;
}
