package iih.bd.srv.mrpsnpower2.s;

import iih.bd.srv.mrpsnpower.d.MrPsnPowerDO;
import iih.bd.srv.mrpsnpower2.bp.DeleteAll;
import iih.bd.srv.mrpsnpower2.bp.SavePowerDos;
import iih.bd.srv.mrpsnpower2.bp.GetPsnDos;
import iih.bd.srv.mrpsnpower2.i.IMrpsnpowerService;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 病历人员权限配置-模块相关服务实现类
*/
public class MrpsnpowerServiceImpl implements IMrpsnpowerService{

	/**
	* 人员权限列表的过滤查询
	* @throws BizException 
	*/
	@Override
	public MrPsnPowerDO[] getPsnDos() throws BizException {
		GetPsnDos bp=new GetPsnDos();
		return bp.getPsnDos();
	}
	
	/**
	* 人员权限列表的查询方案过滤查询
	 * @throws BizException 
	*/
	@Override
	public PagingRtnData<MrPsnPowerDO> getPsnDosByQueryNode(QryRootNodeDTO qryRootNodeDto, String orderPart,
			String wherePart, PaginationInfo pg) throws BizException {
		GetPsnDos bp=new GetPsnDos();
		PagingRtnData<MrPsnPowerDO> pagingData = bp.exec(qryRootNodeDto, orderPart, wherePart, pg);
		return pagingData;
	}

	/**
	* 删除某人员所有权限配置
	 * @throws BizException 
	*/
	@Override
	public Boolean deleteAll(String id_psn) throws BizException {
		DeleteAll bp=new DeleteAll();
		return bp.deleteAll(id_psn);
	}

	/**
	* 人员权限明细列表的保存
	* @throws BizException 
	*/
	@Override
	public Boolean savePowerDos(MrPsnPowerDO[] powers,String id_psn)throws BizException {
		SavePowerDos bp=new SavePowerDos();
		return bp.savePowerDos(powers,id_psn);
	}



}
