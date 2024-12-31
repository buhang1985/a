package iih.nm.nhr.nmoptplpsn.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmoptplpsn.d.NmOptPlPsnDO;
import iih.nm.nhr.nmoptplpsn.d.NmoptplpsnAggDO;

/**
* 实习计划_参与人员数据维护服务
*/
public interface INmoptplpsnCudService {
	/**
	*  实习计划_参与人员数据真删除
	*/
    public abstract void delete(NmoptplpsnAggDO[] aggdos) throws BizException;
    
    /**
	*  实习计划_参与人员数据插入保存
	*/
	public abstract NmoptplpsnAggDO[] insert(NmoptplpsnAggDO[] aggdos) throws BizException;
	
    /**
	*  实习计划_参与人员数据保存
	*/
	public abstract NmoptplpsnAggDO[] save(NmoptplpsnAggDO[] aggdos) throws BizException;
	
    /**
	*  实习计划_参与人员数据更新
	*/
	public abstract NmoptplpsnAggDO[] update(NmoptplpsnAggDO[] aggdos) throws BizException;
	
	/**
	*  实习计划_参与人员数据逻辑删除
	*/
	public abstract void logicDelete(NmoptplpsnAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对实习计划_参与人员数据真删除
	 */
	public abstract void deleteByParentDO(NmOptPlPsnDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对实习计划_参与人员数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmOptPlPsnDO[] mainDos) throws BizException;
}
