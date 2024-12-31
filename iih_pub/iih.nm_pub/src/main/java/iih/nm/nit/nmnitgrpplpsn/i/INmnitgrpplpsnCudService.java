package iih.nm.nit.nmnitgrpplpsn.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nmnitgrpplpsn.d.NmNitGrpPlPsnDO;
import iih.nm.nit.nmnitgrpplpsn.d.NmnitgrpplpsnAggDO;

/**
* 护理管理_实习小组计划_人员数据维护服务
*/
public interface INmnitgrpplpsnCudService {
	/**
	*  护理管理_实习小组计划_人员数据真删除
	*/
    public abstract void delete(NmnitgrpplpsnAggDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_实习小组计划_人员数据插入保存
	*/
	public abstract NmnitgrpplpsnAggDO[] insert(NmnitgrpplpsnAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_实习小组计划_人员数据保存
	*/
	public abstract NmnitgrpplpsnAggDO[] save(NmnitgrpplpsnAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_实习小组计划_人员数据更新
	*/
	public abstract NmnitgrpplpsnAggDO[] update(NmnitgrpplpsnAggDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_实习小组计划_人员数据逻辑删除
	*/
	public abstract void logicDelete(NmnitgrpplpsnAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_实习小组计划_人员数据真删除
	 */
	public abstract void deleteByParentDO(NmNitGrpPlPsnDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_实习小组计划_人员数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNitGrpPlPsnDO[] mainDos) throws BizException;
}
