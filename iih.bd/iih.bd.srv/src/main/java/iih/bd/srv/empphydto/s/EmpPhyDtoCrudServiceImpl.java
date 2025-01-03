package iih.bd.srv.empphydto.s;

import iih.bd.srv.empphydto.d.EmpphyDTO;
import iih.bd.srv.empphydto.i.IEmpPhyDtoCudService;
import iih.bd.srv.empphydto.i.IEmpPhyDtoRService;
import iih.bd.srv.empphydto.s.bp.AuthorizeBp;
import iih.bd.srv.empphydto.s.bp.CancleAuthorizeBp;
import iih.bd.srv.empphydto.s.bp.GetEmpPhyDtoByPageInfoBp;
import iih.bd.srv.empphydto.s.bp.GetEmpPhyDtoByQCondAndPageInfoBp;
import iih.bd.srv.empphydto.s.bp.SaveEmpPhyDtoBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医师属性dto实现类
 * 
 * @author guoyang
 *
 */
@Service(serviceInterfaces = { IEmpPhyDtoRService.class, IEmpPhyDtoCudService.class }, binding = Binding.JSONRPC)
public class EmpPhyDtoCrudServiceImpl implements IEmpPhyDtoRService, IEmpPhyDtoCudService {

	@Override
	public PagingRtnData<EmpphyDTO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {
		GetEmpPhyDtoByPageInfoBp bp = new GetEmpPhyDtoByPageInfoBp();
		return bp.exec(pg, wherePart, orderByPart);
	}

	@Override
	public PagingRtnData<EmpphyDTO> FindByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String condition,
			String orderStr, PaginationInfo pg) throws BizException {
		GetEmpPhyDtoByQCondAndPageInfoBp bp = new GetEmpPhyDtoByQCondAndPageInfoBp();
		return bp.exec(qryRootNodeDTO, condition, orderStr, pg);
	}

	@Override
	public void Authorize(EmpphyDTO[] empphyDtos) throws BizException {
		AuthorizeBp bp = new AuthorizeBp();
		bp.exec(empphyDtos);
	}

	@Override
	public void CancleAuthorize(EmpphyDTO[] empphyDtos) throws BizException {
		CancleAuthorizeBp bp = new CancleAuthorizeBp();
		bp.exec(empphyDtos);
	}

	@Override
	public EmpphyDTO saveEmpPhyDto(EmpphyDTO empPhyDTO) throws BizException {
		SaveEmpPhyDtoBp bp=new SaveEmpPhyDtoBp();
		EmpphyDTO result = 	bp.exec(empPhyDTO);
		return result;
	}
}
