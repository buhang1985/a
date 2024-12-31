package iih.ci.mrm.s.mrmcatalog;

import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCataListDTO;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCatalogerDTO;
import iih.ci.mrm.i.mrmcatalog.IMrmcatalogerdtoCrudService;
import iih.ci.mrm.s.mrmcatalog.bp.IMrmCataAssQryBp;
import iih.ci.mrm.s.mrmcatalog.bp.IMrmCataSaveBp;
import iih.ci.mrm.s.mrmcatalog.bp.IMrmCataSaveRepealBp;
import iih.ci.mrm.s.mrmcatalog.bp.IMrmUntalaQryBP;
import iih.ci.mrm.s.mrmcatalog.bp.IMrmcatalogerQryBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces={IMrmcatalogerdtoCrudService.class}, binding=Binding.JSONRPC)
public class IMrmcatalogerdtoCrudServiceImpl implements IMrmcatalogerdtoCrudService{

	@Override
	public PagingRtnData<MrmCatalogerDTO> getMrmCatalogerCrudQuery(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		IMrmcatalogerQryBP catalogerqry = new IMrmcatalogerQryBP();
		
		return catalogerqry.getMrmCatalogerCrudQuery(qryRootNodeDTO, paginationInfo);
	}

	@Override
	public PagingRtnData<MrmCataListDTO> getMrmCatalogAssignQry(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		IMrmCataAssQryBp cataassqry = new IMrmCataAssQryBp();
		
		return cataassqry.getMrmCatalogAssignQry(qryRootNodeDTO, paginationInfo);
	}

	@Override
	public PagingRtnData<MrmCataListDTO> getMrmUntalalogQry(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		IMrmUntalaQryBP untalaqry = new IMrmUntalaQryBP();
		
		return untalaqry.getMrmUntalalogQry(qryRootNodeDTO, paginationInfo);
	}

	@Override
	public FBoolean SaveAmrDO(MrmCatalogerDTO mrmcatalogerdto,MrmCataListDTO []mrmcatalistdto)throws BizException {
		// TODO Auto-generated method stub
		IMrmCataSaveBp catasave = new IMrmCataSaveBp();
		return catasave.SaveAmrDO( mrmcatalogerdto,mrmcatalistdto);
	}

	@Override
	public FBoolean SaveRepeal(MrmCataListDTO[] mrmcatalist) throws BizException {
		// TODO Auto-generated method stub
		IMrmCataSaveRepealBp CataSaveRe = new IMrmCataSaveRepealBp();
		return CataSaveRe.SaveRepeal(mrmcatalist);
	}


}
