package iih.ci.ord.i.external.provide;

import java.util.List;

import iih.ci.mrfp.cimrsugdto.d.CiMrSugDTO;
import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import iih.ci.ord.dto.enappointmentdto.d.EnappointmentDTO;
import iih.ci.ord.i.external.provide.meta.en.ReservedSurgeryAppDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;

/**
 * 就诊预约接口
 * 
 * @author li_zheng
 *
 */
public interface ICiOrdEnService {

	/**
	 * 取消接诊校验是否存在有效医嘱
	 * 
	 * @param id_en 就诊号
	 * @param Mode4CheckExistValidOrdersEnum 判断类型：<br/>
	 *            ORDERSTATUS0，是否存在未作废未退费医嘱；<br/>
	 *            ORDERSTATUS1，是否存在有效医嘱；<br/>
	 *            ORDERSTATUS2，是否存在已交费的有效医嘱
	 * @return
	 */
	public abstract FBoolean isExistValidOrders(String id_en, String mode) throws DAException;

	/**
	 * 诊毕校验是否存在开立医嘱
	 * 
	 * @param id_en 就诊号
	 * @return
	 */
	public abstract FBoolean isExistOpenOrders(String id_en) throws DAException;

	/**
	 * 就诊预约接口：按照患者查询未预约的申请单
	 * 
	 * @param enappointmentDTO
	 * @return
	 */
	public abstract AppObsDto[] getAllAppRequisitionByIdPat(EnappointmentDTO enappointmentDTO) throws BizException;

	/**
	 * 就诊预约接口：按照执行科室查询未预约的申请单
	 * 
	 * @param enappointmentDTO
	 * @return
	 */
	public abstract AppObsDto[] getAllAppRequisitionByIdDept(EnappointmentDTO enappointmentDTO) throws BizException;

	/**
	 * 就诊预约接口：按照执行科室查询未预约的申请单
	 * 
	 * @param enappointmentDTO
	 * @return
	 */
	public abstract AppObsDto getRisAppByNO(String no) throws BizException;

	/**
	 * 更新申请单状态
	 * 
	 * @param id_or
	 * @param status Y 预约 N 取消预约（申请状态）
	 * @return
	 * @throws Exception
	 */
	public abstract String updateAppStatus(String id_or, Boolean status,FDateTime datetime) throws BizException;

	/**
	 * 手术预约回调接口，用于更新手术申请单状态等信息
	 * 
	 * @param id_or， 医嘱Id
	 * @param dt_appointment, 预约时间
	 * @param id_operator，预约操作人 @return， 成功 范围
	 * @throws BizException
	 */
	public FBoolean updateAppSurgeryAppointmentStatus(String id_or, FDateTime dt_appointment, String id_operator)
			throws BizException;

	/**
	 * 取消手术预约申请
	 * 
	 * @param id_or
	 * @param id_operator
	 * @return
	 * @throws BizException
	 */
	public FBoolean cancelAppSurgeryAppointmentStatus(String id_or, String id_operator) throws BizException;

	/**
	 * 查看患者待预约手术
	 * 
	 * @param id_pat , id_pat患者id，id_or医嘱id，二者互斥，至少有一个有值
	 * @param id_or 医嘱id
	 * @return
	 * @throws BizException
	 */
	public ReservedSurgeryAppDTO[] getReservedSurgeryAppInfos(String id_pat, String id_or, FBoolean status)
			throws BizException;
	/**
	 * 核对，在给定时间之前是否存在有效的医嘱（未作废的医嘱）
	 * @param id_en
	 * @param dt_acpt
	 */
	public void checkLiveOrdBeforeDtAcpt(String id_en,FDateTime dt_acpt) throws BizException;
	
	
	/**
	 * 就诊手术信息接口：  就诊的最后一次有效手术医嘱的手术信息
	 * @param idEnt
	 * @return
	 * @throws BizException
	 */
	public abstract List<CiMrSugDTO> getCiOrdSurgeryInfo(String idEnt) throws BizException;
}
