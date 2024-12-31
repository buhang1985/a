package iih.bd.srv.mrpsnpower2.i;

import iih.bd.srv.mrpsnpower.d.MrPsnPowerDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 病历人员权限配置-模块相关服务
*/
public interface IMrpsnpowerService {
	
	/**
	* 人员权限列表的过滤查询
	* @throws BizException 
	*/
	public abstract MrPsnPowerDO[] getPsnDos() throws BizException;
	
	/**
	* 人员权限列表的查询方案过滤查询
	 * @throws BizException 
	*/
	public abstract PagingRtnData<MrPsnPowerDO> getPsnDosByQueryNode(QryRootNodeDTO qryRootNodeDto, String orderPart,
			String wherePart, PaginationInfo pg)throws BizException;
	
	/**
	* 删除某人员所有权限配置
	 * @throws BizException 
	*/
	public abstract Boolean deleteAll(String id_psn) throws BizException;
	
	/**
	* 人员权限明细列表的保存
	* @throws BizException 
	*/
	public abstract Boolean savePowerDos(MrPsnPowerDO[] powers,String id_psn) throws BizException;
}
