package iih.mp.ot.deptmp.i;

import xap.mw.core.data.BizException;
import  iih.mp.ot.deptmp.d.DeptmpAggDO;

/**
* 通用医技科室模板数据维护服务
*/
public interface IDeptmpCudService {
	/**
	*  通用医技科室模板数据真删除
	*/
    public abstract void delete(DeptmpAggDO[] aggdos) throws BizException;
    
    /**
	*  通用医技科室模板数据插入保存
	*/
	public abstract DeptmpAggDO[] insert(DeptmpAggDO[] aggdos) throws BizException;
	
    /**
	*  通用医技科室模板数据保存
	*/
	public abstract DeptmpAggDO[] save(DeptmpAggDO[] aggdos) throws BizException;
	
    /**
	*  通用医技科室模板数据更新
	*/
	public abstract DeptmpAggDO[] update(DeptmpAggDO[] aggdos) throws BizException;
	
	/**
	*  通用医技科室模板数据逻辑删除
	*/
	public abstract void logicDelete(DeptmpAggDO[] aggdos) throws BizException;
}
