package iih.ci.mrm.s.mrmregisterqry;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.cimrmqrylist.ICimrmqrylistCrudService;
import iih.ci.mrm.s.mrmregisterqry.bp.IMrmRegisterListDetailQry;
import iih.ci.mrm.s.mrmregisterqry.bp.IMrmRegisterListQry;
import iih.ci.mrm.s.mrmregisterqry.bp.IMrmRegisterSuppListQry;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces={ICimrmqrylistCrudService.class}, binding=Binding.JSONRPC)
public class ICimrmqrylistCrudServiceImpl implements ICimrmqrylistCrudService{

	@Override
	public PagingRtnData<CiMrmQryListDTO> GetRegisterQryList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException{
		// TODO Auto-generated method stub
		IMrmRegisterListQry Registerlist = new IMrmRegisterListQry();
		
		return Registerlist.GetRegisterQryList(qryRootNodeDTO, paginationInfo);
	}

	@Override
	public PagingRtnData<CiMrmQryListDTO> GetRegisterDetailQryList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException{
		// TODO Auto-generated method stub
		
		IMrmRegisterListDetailQry Registerlistdetail = new IMrmRegisterListDetailQry();
		
		return null;
	}

	@Override
	public PagingRtnData<CiMrmQryListDTO> GetRegisterSuppQryList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		
		IMrmRegisterSuppListQry RegisterSupp = new IMrmRegisterSuppListQry();
		return RegisterSupp.GetRegisterSuppQryList(qryRootNodeDTO, paginationInfo);
	}

}
