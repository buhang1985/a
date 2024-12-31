package iih.nm.net.examnurtra.i;

import xap.mw.core.data.BizException;
import iih.nm.net.examnurtra.d.ExamNurtraDO;
import iih.nm.net.examnurtra.d.ExamnurtraAggDO;

/**
* 护理人员培训数据维护服务
*/
public interface IExamnurtraCudService {
	/**
	*  护理人员培训数据真删除
	*/
    public abstract void delete(ExamnurtraAggDO[] aggdos) throws BizException;
    
    /**
	*  护理人员培训数据插入保存
	*/
	public abstract ExamnurtraAggDO[] insert(ExamnurtraAggDO[] aggdos) throws BizException;
	
    /**
	*  护理人员培训数据保存
	*/
	public abstract ExamnurtraAggDO[] save(ExamnurtraAggDO[] aggdos) throws BizException;
	
    /**
	*  护理人员培训数据更新
	*/
	public abstract ExamnurtraAggDO[] update(ExamnurtraAggDO[] aggdos) throws BizException;
	
	/**
	*  护理人员培训数据逻辑删除
	*/
	public abstract void logicDelete(ExamnurtraAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理人员培训数据真删除
	 */
	public abstract void deleteByParentDO(ExamNurtraDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理人员培训数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ExamNurtraDO[] mainDos) throws BizException;
}
