package iih.pis.mbw.i;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import iih.pis.mbw.dto.csssqappwrapdto.d.CssSqAppWrapDTO;
import iih.pis.mbw.dto.pismbwmedguidedto.d.PismbwMedGuideDTO;
import iih.pis.mbw.dto.pismbwmybilldto.d.PismbwMybillDTO;
import iih.pis.mbw.dto.pismbwmybilldto.d.PismbwMybillDetailDTO;
import iih.pis.mbw.dto.pismbwoepdepdto.d.PismbwOepDepDTO;
import iih.pis.mbw.dto.pismbwpatdto.d.PismbwPatDTO;
import iih.pis.mbw.dto.pismbwpatinsdto.d.PismbwPatInsDTO;
import iih.pis.mbw.dto.pismbwpatopaptlistdto.d.PismbwPatopAptlistDTO;
import iih.pis.mbw.dto.pismbwrequfordrug.d.PismbwRequforDrugDTO;
import iih.pis.mbw.dto.pismbwschlistdto.d.PismbwDateSchlistDTO;
import iih.pis.mbw.dto.pismbwschlistdto.d.PismbwDocSchlistDTO;
import iih.pis.mbw.dto.pismbwudidocdto.d.PismbwUdidocDTO;
import iih.pis.mbw.dto.pismbwwaitquedto.d.PismbwWaitqueDTO;
import xap.mw.core.data.BizException;

@WebService
public interface IPisMbwQueryService {

	public abstract boolean webTest(@WebParam(name="name") String name) throws BizException;
	
	/**
	 * 通过code获取档案信息
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public abstract List<PismbwUdidocDTO> getUdidocIndoByCode(@WebParam(name="code") String code) throws BizException;
	
	/**
	 * 获取满意度调查问卷
	 * @param id_mould
	 * @param canWrite
	 * @return
	 * @throws BizException
	 */
	public abstract CssSqAppWrapDTO getCssTplPsqByRecId(@WebParam(name="id_mould") String id_mould, @WebParam(name="canWrite") boolean canWrite) throws BizException;
	
	/**
	 * 获取门急诊出诊科室列表
	 * @return
	 * @throws BizException
	 */
	public abstract List<PismbwOepDepDTO> getOepDepList() throws BizException;
	
	
	/**
	 * 获取日期门诊排班列表
	 * @param code_dep
	 * @return
	 * @throws BizException
	 */
	public abstract List<PismbwDateSchlistDTO> getDateSchList(@WebParam(name="code_dep") String code_dep, @WebParam(name="qry_date") String qry_date) throws BizException;


	/**
	 * 获取我的就诊人列表
	 * @return
	 * @throws BizException
	 */
	public abstract List<PismbwPatDTO> getPatList() throws BizException;
	
	/**
	 * 获取患者预约记录
	 * @param code_pat
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract List<PismbwPatopAptlistDTO> getPatopAptList(@WebParam(name="code_pat") String code_pat, @WebParam(name="dt_begin") String dt_begin, @WebParam(name="dt_end") String dt_end) throws BizException;


	/**
	 * 获取我的关注列表
	 * @return
	 * @throws BizException
	 */
	public abstract List<PismbwDocSchlistDTO> getFocdocList() throws BizException;
	
	/**
	 * 我的账单
	 * @param code_pat
	 * @throws BizException
	 */
	public abstract List<PismbwMybillDTO> getMyBillList(@WebParam(name="code_pat") String code_pat) throws BizException;
	
	/**
	 * 我的账单明细
	 * @param code_pat
	 * @param code_inccaitm
	 * @return
	 * @throws BizException
	 */
	public abstract List<PismbwMybillDetailDTO> getMyBillDetailList(@WebParam(name="code_pat") String code_pat, @WebParam(name="code_inccaitm") String code_inccaitm) throws BizException;
	
	/**
	 * 获取患者候诊队列
	 * @param code_pat
	 * @return
	 * @throws BizException
	 */
	public abstract List<PismbwWaitqueDTO> getWaitQueList(@WebParam(name="code_pat") String code_pat) throws BizException;


	/**
	 * 获取曾挂号医生列表
	 * @return
	 * @throws BizException
	 */
	public abstract List<PismbwPatopAptlistDTO> getopENDocList() throws BizException;
	
	/**
	 * 获取医生头像地址
	 * @param code_doc
	 * @return
	 * @throws BizException
	 */
	public abstract String getDocPhotoUrl(@WebParam(name="code_doc") String code_doc) throws BizException;
	
	/**
	 * 获取患者领药单信息
	 * @param id_pat
	 * @returns
	 * @throws BizException
	 */
	public abstract List<PismbwRequforDrugDTO> getRequforDrugInfoList(@WebParam(name="id_pat") String id_pat) throws BizException;
	
	/**
	 * 获取患者检查检验信息
	 * @param code_ent
	 * @param dt_begin
	 * @param dt_end
	 * @returns
	 * @throws BizException
	 */
	public abstract PismbwPatInsDTO getPatIns(@WebParam(name="code_ent") String code_ent, @WebParam(name="dt_begin") String dt_begin, @WebParam(name="dt_end") String dt_end) throws BizException;

	/**
	 * 获取就医指南信息
	 * @param id_guidetp
	 * @returns
	 * @throws BizException
	 */
	public abstract List<PismbwMedGuideDTO> getMedGuideList(@WebParam(name="id_guidetp") String id_guidetp) throws BizException;
}
