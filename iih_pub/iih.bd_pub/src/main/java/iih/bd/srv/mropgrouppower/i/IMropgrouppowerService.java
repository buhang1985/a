package iih.bd.srv.mropgrouppower.i;

import iih.bd.srv.mropgrouppower.d.MrOpGroupPowerDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMropgrouppowerService {

	//删除业务组下所有权限
	public Boolean deletePower(String idmropgrouppower)throws BizException; 
	
	//删除业务组层级下所有的权限
	public Boolean deleteDetail(String Idmropgroup,String Idmropgrouplevel)throws BizException;
	
	//获取病历业务组数据
	public abstract MrOpGroupPowerDO[] getpowerlist()throws BizException;
	
	//通过查询条件获取数据
	public MrOpGroupPowerDO[] getlistByQueryNode(String sqlWhere) throws BizException;
}
