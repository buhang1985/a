package iih.ci.mb.dcmo.i;

import xap.mw.core.data.BizException;
import iih.ci.mb.dcmo.d.DoctorMemoDO;
import iih.ci.mb.dcmo.d.DoctormemoAggDO;

/**
* 医生备忘录数据维护服务
*/
public interface IDoctormemoCudService {
	/**
	*  医生备忘录数据真删除
	*/
    public abstract void delete(DoctormemoAggDO[] aggdos) throws BizException;
    
    /**
	*  医生备忘录数据插入保存
	*/
	public abstract DoctormemoAggDO[] insert(DoctormemoAggDO[] aggdos) throws BizException;
	
    /**
	*  医生备忘录数据保存
	*/
	public abstract DoctormemoAggDO[] save(DoctormemoAggDO[] aggdos) throws BizException;
	
    /**
	*  医生备忘录数据更新
	*/
	public abstract DoctormemoAggDO[] update(DoctormemoAggDO[] aggdos) throws BizException;
	
	/**
	*  医生备忘录数据逻辑删除
	*/
	public abstract void logicDelete(DoctormemoAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医生备忘录数据真删除
	 */
	public abstract void deleteByParentDO(DoctorMemoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医生备忘录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DoctorMemoDO[] mainDos) throws BizException;
}
