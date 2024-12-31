package iih.ci.mrqc.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.ci.mrqc.cimrtaskdto.d.CiMrTaskDTO;
import iih.ci.mrqc.i.IMrqcQryService;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.qcresult.d.QcPatResultListDTO;
import iih.ci.mrqc.s.bp.medicaldepqc.MedicalDepPageQryBP;
import iih.ci.mrqc.s.bp.medicaldepqc.MedicalDepQcExeBp;
import iih.ci.mrqc.s.bp.mrtask.MrWriteTaskQryByBP;

@Service(serviceInterfaces={IMrqcQryService.class}, binding=Binding.JSONRPC)
public class MrqcQryServiceImpl implements IMrqcQryService {
	/**
	 * 待书写任务列表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<MrTaskDO> getMrTaskByIdUserQryList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		// TODO Auto-generated method stub
		MrWriteTaskQryByBP qryBp=new MrWriteTaskQryByBP();
		return qryBp.getMrTaskByIdUserQryList(qryRootNodeDTO, paginationInfo);
	}
	/**
	 * 科室查看医务要求的书写项
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<CiMrTaskDTO> getDepCheckMedicalQcItmList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		MedicalDepQcExeBp exeBp=new MedicalDepQcExeBp();
		return exeBp.getDepCheckMedicalQcItmList(qryRootNodeDTO, paginationInfo);
	}
	/**
	 * 医务查看扣分项
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<QcPatResultListDTO> getMedicalQcItmResultList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		MedicalDepPageQryBP qryBP=new MedicalDepPageQryBP();
		return qryBP.getMedicalQcItmResultList(qryRootNodeDTO, paginationInfo);
	}

}
