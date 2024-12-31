package iih.bd.srv.mropgrouppower.s;

import iih.bd.srv.mropgrouppower.d.MrOpGroupPowerDO;
import iih.bd.srv.mropgrouppower.i.IMropgrouppowerService;
import iih.bd.srv.mropgrouppower.s.bp.deletePowerBp;
import iih.bd.srv.mropgrouppower.s.bp.findPowerListBp;
import iih.bd.srv.mrpsnpower.d.MrPsnPowerDO;
import xap.lui.exta.qrytmpl.qryscheme.xml.QueryNode;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces={IMropgrouppowerService.class}, binding=Binding.JSONRPC)
public class MropgrouppowerServiceImpl extends PagingServiceImpl<MrOpGroupPowerDO> implements IMropgrouppowerService{

	@Override
	public MrOpGroupPowerDO[] getpowerlist() throws BizException {
		findPowerListBp bp = new findPowerListBp();
		return bp.getpowerlist();
	}
	
	@Override
	public MrOpGroupPowerDO[] getlistByQueryNode(String sqlWhere) throws BizException {
		findPowerListBp bp = new findPowerListBp();
		return bp.exec(sqlWhere);
	}

	@Override
	public Boolean deletePower(String Idmropgroup) throws BizException {
		deletePowerBp delbp = new deletePowerBp();
		
		return delbp.deletegrouppower(Idmropgroup);
	}

	@Override
	public Boolean deleteDetail(String Idmropgroup,String Idmropgrouplevel) throws BizException {
		deletePowerBp delbp = new deletePowerBp();
		return delbp.deletedetail(Idmropgroup,Idmropgrouplevel);
	}

	

}
