package iih.mp.nr.nurhdv.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.nurhdv.d.HdvEntDO;
import iih.mp.nr.nurhdv.d.NurhdvAggDO;

/**
* 护士交接班数据维护服务
*/
public interface INurhdvCudService {
	/**
	*  护士交接班数据真删除
	*/
    public abstract void delete(NurhdvAggDO[] aggdos) throws BizException;
    
    /**
	*  护士交接班数据插入保存
	*/
	public abstract NurhdvAggDO[] insert(NurhdvAggDO[] aggdos) throws BizException;
	
    /**
	*  护士交接班数据保存
	*/
	public abstract NurhdvAggDO[] save(NurhdvAggDO[] aggdos) throws BizException;
	
    /**
	*  护士交接班数据更新
	*/
	public abstract NurhdvAggDO[] update(NurhdvAggDO[] aggdos) throws BizException;
	
	/**
	*  护士交接班数据逻辑删除
	*/
	public abstract void logicDelete(NurhdvAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护士交接班数据真删除
	 */
	public abstract void deleteByParentDO(HdvEntDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护士交接班数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HdvEntDO[] mainDos) throws BizException;
}
