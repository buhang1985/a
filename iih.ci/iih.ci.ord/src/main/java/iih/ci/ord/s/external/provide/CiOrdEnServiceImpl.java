package iih.ci.ord.s.external.provide;

import java.util.List;

import iih.ci.mrfp.cimrsugdto.d.CiMrSugDTO;
import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import iih.ci.ord.dto.enappointmentdto.d.EnappointmentDTO;
import iih.ci.ord.i.external.provide.ICiOrdEnService;
import iih.ci.ord.i.external.provide.meta.en.ReservedSurgeryAppDTO;
import iih.ci.ord.s.external.bp.ExistOpenOrdersBp;
import iih.ci.ord.s.external.bp.ExistValidOrdersBp;
import iih.ci.ord.s.external.bp.SurgeryAppointmentApplicationBP;
import iih.ci.ord.s.external.bp.UpdateAppStatusBP;
import iih.ci.ord.s.external.bp.getAllAppByIdDeptBP;
import iih.ci.ord.s.external.bp.getAllAppByIdPatBP;
import iih.ci.ord.s.external.bp.en.CheckLiveOrdBeforeDtAcptBP;
import iih.ci.ord.s.external.bp.en.GetEnLastSurgeryOrdBP;
import iih.ci.ord.s.external.bp.en.GetRisAppByNOBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces = { ICiOrdEnService.class }, binding = Binding.JSONRPC)
public class CiOrdEnServiceImpl implements ICiOrdEnService {

	/**
	 * 取消接诊校验是否存在有效医嘱
	 * 
	 * @throws DAException
	 */
	@Override
	public FBoolean isExistValidOrders(String id_en, String mode) throws DAException {
		ExistValidOrdersBp bp = new ExistValidOrdersBp();
		return bp.exec(id_en, mode);
	}

	/**
	 * 诊毕校验是否存在开立医嘱
	 * 
	 * @throws DAException
	 */
	@Override
	public FBoolean isExistOpenOrders(String id_en) throws DAException {
		ExistOpenOrdersBp bp = new ExistOpenOrdersBp();
		return bp.exec(id_en);
	}

	/**
	 * 就诊预约接口：按照患者查询未预约的申请单
	 * 
	 * @param enappointmentDTO
	 * @return
	 */
	@Override
	public AppObsDto[] getAllAppRequisitionByIdPat(EnappointmentDTO enappointmentDTO) throws BizException {
		// TODO Auto-generated method stub
		if (enappointmentDTO == null || enappointmentDTO.getId_pat() == null)
			return null;
		return getAllAppByIdPatBP.getInstance().getAllAppRequisitionByIdPatBP(enappointmentDTO);
	}

	/**
	 * 就诊预约接口：按照执行科室查询未预约的申请单
	 * 
	 * @param enappointmentDTO
	 * @return
	 */
	@Override
	public AppObsDto[] getAllAppRequisitionByIdDept(EnappointmentDTO enappointmentDTO) throws BizException {
		// TODO Auto-generated method stub
		if (enappointmentDTO == null || enappointmentDTO.getId_dept() == null)
			return null;
		return getAllAppByIdDeptBP.getInstance().getAllAppRequisitionByIdDeptBP(enappointmentDTO);
	}

	/**
	 * 更新申请单状态
	 * 
	 * @param id_or
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@Override
	public String updateAppStatus(String id_or, Boolean status,FDateTime datetime) throws BizException {
		UpdateAppStatusBP bp = new UpdateAppStatusBP();
		return bp.UpdateAppStatus(id_or, status,datetime);
	}

	@Override
	public FBoolean updateAppSurgeryAppointmentStatus(String id_or, FDateTime dt_appointment, String id_operator)
			throws BizException {
		// 执行更新手术申请单的预约状态信息
		return new SurgeryAppointmentApplicationBP().UpdateAppSurgeryAppointmentStatus(id_or, dt_appointment,
				id_operator) ? FBoolean.TRUE : FBoolean.FALSE;
	}

	@Override
	public FBoolean cancelAppSurgeryAppointmentStatus(String id_or, String id_operator) throws BizException {
		return new SurgeryAppointmentApplicationBP().CancelAppSurgeryAppointmentStatus(id_or, id_operator)
				? FBoolean.TRUE : FBoolean.FALSE;
	}

	@Override
	public ReservedSurgeryAppDTO[] getReservedSurgeryAppInfos(String id_pat, String id_or, FBoolean status)
			throws BizException {
		return new SurgeryAppointmentApplicationBP().GetReservedSurgeryAppInfos(id_pat, id_or,
				FBoolean.TRUE.equals(status));
	}

	@Override
	public AppObsDto getRisAppByNO(String no) throws BizException {
		GetRisAppByNOBP bp = new GetRisAppByNOBP();
		return bp.exec(no);
	}
	@Override
	public void checkLiveOrdBeforeDtAcpt(String id_en, FDateTime dt_acpt) throws BizException {
		CheckLiveOrdBeforeDtAcptBP bp = new CheckLiveOrdBeforeDtAcptBP();
	    bp.exec(id_en, dt_acpt);
	}
	
	/**
	 * 
	 * 就诊手术信息接口：  就诊的最后一次有效手术医嘱的手术信息
	 * @param idEnt
	 * @return
	 * @throws BizException
	 */
	@Override
	public List<CiMrSugDTO> getCiOrdSurgeryInfo(String idEnt) throws BizException {
		GetEnLastSurgeryOrdBP bp = new GetEnLastSurgeryOrdBP();
		return bp.exe(idEnt);
	}
	
}