package iih.ci.mrm.s.mrmcatalog;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCataListDTO;
import iih.ci.mrm.i.mrmcatalog.IMrmCataListService;
import iih.ci.mrm.s.mrmcatalog.bp.MrmCataListQryBP;
import iih.ci.mrm.s.mrmcatalog.bp.MrmCataListQryPageBP;
import iih.ci.mrm.s.mrmcatalog.bp.MrmCataListRecallBP;

/**
 * 病案编目列表服务
 * @author 张静波
 * @date 2018年8月27日 下午3:08:28
 */
@Service(serviceInterfaces={IMrmCataListService.class}, binding=Binding.JSONRPC)
public class MrmCataListServiceImpl implements IMrmCataListService {

	@Override
	public MrmCataListDTO[] getMrmCataList(String sqlWhere) throws DAException {
		// TODO Auto-generated method stub
		MrmCataListQryBP qryBP = new MrmCataListQryBP(); 	
		return qryBP.getMrmCataList(sqlWhere);
	}

	@Override
	public PagingRtnData<MrmCataListDTO> getMrmCataListByQry(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		MrmCataListQryPageBP qryPageBp = new MrmCataListQryPageBP();
		return qryPageBp.getMrmCataListByQry(qryRootNodeDTO, paginationInfo);
	}
	
	@Override
	public PagingRtnData<MrmCataListDTO> getMrmUnCataListByQry(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		MrmCataListQryPageBP qryPageBp = new MrmCataListQryPageBP();
		return qryPageBp.getMrmUnCataListByQry(qryRootNodeDTO, paginationInfo);
	}

	@Override
	public FBoolean reCallMrmCataRecord(String[] id_ent,
			String id_user_catalogue,String id_dep_catalogue) throws BizException {
		// TODO Auto-generated method stub
		MrmCataListRecallBP recallBp = new MrmCataListRecallBP();
		return recallBp.reCallMrmCataRecord(id_ent, id_user_catalogue, id_dep_catalogue);
	}
	
	@Override
	public PagingRtnData<MrmCataListDTO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)throws BizException
	{
		MrmCataListQryPageBP qryPageBp = new MrmCataListQryPageBP();
		return qryPageBp.findByPageInfo(pg, wherePart, orderByPart);
	}

}
