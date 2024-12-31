package iih.mbh.en.i;


import javax.jws.WebParam;
import javax.jws.WebService;

import iih.mbh.en.entry.d.PatEnterDeptRequestDTO;
import xap.mw.core.data.BizException;



@WebService
public interface IMbhEnMaintanceService {

	/**
	 * 入科确认保存
	 * @param request
	 * @return
	 * @throws BizException
	 */
	public abstract String savePatEnterDept(@WebParam(name="request") PatEnterDeptRequestDTO request) throws BizException;
	/**
	 * 转科转入确认
	 * @param id_ent
	 * @param bed_code
	 * @param id_dep_nur
	 * @param fgPri
	 * @param id_wg
	 * @param id_zr_doc
	 * @param id_zz_doc
	 * @param id_zy_doc
	 * @return
	 * @throws BizException
	 */
	public abstract String replyTransInApply(@WebParam(name="id_ent") String id_ent, @WebParam(name="bed_code") String bed_code, @WebParam(name="id_dep_nur") String id_dep_nur, @WebParam(name="fgPri") boolean fgPri, @WebParam(name="id_wg") String id_wg, @WebParam(name="id_zr_doc") String id_zr_doc, @WebParam(name="id_zz_doc") String id_zz_doc, @WebParam(name="id_zy_doc") String id_zy_doc, @WebParam(name="id_emp_phy") String id_emp_phy, @WebParam(name="id_emp_nur") String id_emp_nur) throws BizException;
	/**
	 * 转科转出确认
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract String replyTransOutApply(@WebParam(name="id_ent") String id_ent) throws BizException;
	/**
	 * 出院
	 * @param id_ent
	 * @param id_dep_nur
	 * @param dt_outer
	 * @return
	 * @throws BizException
	 */
	public abstract String patientLeaveHos(@WebParam(name="id_ent") String id_ent, @WebParam(name="id_dep_nur") String id_dep_nur, @WebParam(name="dt_outer") String dt_outer) throws BizException;



}
