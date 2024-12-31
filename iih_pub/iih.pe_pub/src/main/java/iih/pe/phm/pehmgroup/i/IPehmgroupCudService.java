package iih.pe.phm.pehmgroup.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pehmgroup.d.PeHmGroupDO;
import iih.pe.phm.pehmgroup.d.PehmgroupAggDO;

/**
* 体检健康群体管理数据维护服务
*/
public interface IPehmgroupCudService {
	/**
	*  体检健康群体管理数据真删除
	*/
    public abstract void delete(PehmgroupAggDO[] aggdos) throws BizException;
    
    /**
	*  体检健康群体管理数据插入保存
	*/
	public abstract PehmgroupAggDO[] insert(PehmgroupAggDO[] aggdos) throws BizException;
	
    /**
	*  体检健康群体管理数据保存
	*/
	public abstract PehmgroupAggDO[] save(PehmgroupAggDO[] aggdos) throws BizException;
	
    /**
	*  体检健康群体管理数据更新
	*/
	public abstract PehmgroupAggDO[] update(PehmgroupAggDO[] aggdos) throws BizException;
	
	/**
	*  体检健康群体管理数据逻辑删除
	*/
	public abstract void logicDelete(PehmgroupAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检健康群体管理数据真删除
	 */
	public abstract void deleteByParentDO(PeHmGroupDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检健康群体管理数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeHmGroupDO[] mainDos) throws BizException;
}
