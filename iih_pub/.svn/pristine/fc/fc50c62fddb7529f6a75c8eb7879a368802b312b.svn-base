package iih.ci.mr.nu.childhealthedu.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.childhealthedu.d.ChildHealthEduDO;
import iih.ci.mr.nu.childhealthedu.d.ChildhealtheduAggDO;

/**
* 儿科住院健康教育评价单数据维护服务
*/
public interface IChildhealtheduCudService {
	/**
	*  儿科住院健康教育评价单数据真删除
	*/
    public abstract void delete(ChildhealtheduAggDO[] aggdos) throws BizException;
    
    /**
	*  儿科住院健康教育评价单数据插入保存
	*/
	public abstract ChildhealtheduAggDO[] insert(ChildhealtheduAggDO[] aggdos) throws BizException;
	
    /**
	*  儿科住院健康教育评价单数据保存
	*/
	public abstract ChildhealtheduAggDO[] save(ChildhealtheduAggDO[] aggdos) throws BizException;
	
    /**
	*  儿科住院健康教育评价单数据更新
	*/
	public abstract ChildhealtheduAggDO[] update(ChildhealtheduAggDO[] aggdos) throws BizException;
	
	/**
	*  儿科住院健康教育评价单数据逻辑删除
	*/
	public abstract void logicDelete(ChildhealtheduAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对儿科住院健康教育评价单数据真删除
	 */
	public abstract void deleteByParentDO(ChildHealthEduDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对儿科住院健康教育评价单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ChildHealthEduDO[] mainDos) throws BizException;
}
