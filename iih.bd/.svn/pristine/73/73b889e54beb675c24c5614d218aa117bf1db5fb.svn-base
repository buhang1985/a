package iih.bd.pp.anhuisrvorca.s;

import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import iih.bd.pp.anhuisrvorca.i.IFwssCompCudService;
import iih.bd.pp.anhuisrvorca.i.IFwssCompRService;
import iih.bd.pp.anhuisrvorca.s.bp.AutoCompFwssBp;
import iih.bd.pp.anhuisrvorca.s.bp.CompInsurFwssDataBp;
import iih.bd.pp.anhuisrvorca.s.bp.DeleteFwssCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindAllFwssCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindFwssCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.RefreshFwssCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.SaveFwssCompBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 服务设施对照信息服务
 * 
 * @author hao_wu
 *
 */
public class FwssCompCrudServiceImpl implements IFwssCompRService, IFwssCompCudService {

	@Override
	public PagingRtnData<FwssCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String hpCode, PaginationInfo pg)
			throws BizException {
		FindFwssCompBp bp = new FindFwssCompBp();
		PagingRtnData<FwssCompDTO> result = bp.exec(qryRootNodeDto, hpCode, pg);
		return result;
	}

	@Override
	public FwssCompDTO[] CompInsurFwssData(FwssCompDTO[] fwssCompDTOs) throws BizException {
		CompInsurFwssDataBp bp = new CompInsurFwssDataBp();
		bp.exec(fwssCompDTOs);
		return fwssCompDTOs;
	}

	@Override
	public FwssCompDTO[] SaveFwssComp(FwssCompDTO[] fwssCompDTOs) throws BizException {
		SaveFwssCompBp bp = new SaveFwssCompBp();
		FwssCompDTO[] result = bp.exec(fwssCompDTOs);
		return result;
	}

	@Override
	public FwssCompDTO[] DeleteFwssComp(FwssCompDTO[] FwssCompDTOs) throws BizException {
		DeleteFwssCompBp bp = new DeleteFwssCompBp();
		FwssCompDTO[] result = bp.exec(FwssCompDTOs);
		return result;
	}

	@Override
	public FwssCompDTO[] FindAllFwssComp(String hpCode) throws BizException {
		FindAllFwssCompBp bp = new FindAllFwssCompBp();
		FwssCompDTO[] result = bp.exec(hpCode);
		return result;
	}

	@Override
	public void AutoComp(String hpCode) throws BizException {
		AutoCompFwssBp bp = new AutoCompFwssBp();
		bp.exec(hpCode);
	}

	@Override
	public void RefreshComp(String hpCode) throws BizException {
		RefreshFwssCompBp bp = new RefreshFwssCompBp();
		bp.exec(hpCode);
	}
}
