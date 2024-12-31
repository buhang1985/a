package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnDepDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import xap.mw.core.data.BizException;

/**
 * 移动护理数据校验（入科、转入、转出、出院）
 * 
 * @author jizb
 *
 */
public class CheckEnterDepBP {

	/**
	 * 入科前校验
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	public void validateBeforeEnterDep(EnDepDTO enDepDTO) throws BizException {
		if(enDepDTO==null)
			throw new BizException("入科数据不能为空！");
		if (EnValidator.isEmpty(enDepDTO.getDt_acpt()))
			throw new BizException("入科时间不能为空！");
		if (EnValidator.isEmpty(enDepDTO.getId_bed()))
			throw new BizException("入科床位不能为空！");
		if (EnValidator.isEmpty(enDepDTO.getId_wg_phy()))
			throw new BizException("医疗组不能为空！");
		if (EnValidator.isEmpty(enDepDTO.getId_zz_doc()))
			throw new BizException("主治医师不能为空！");
		if (EnValidator.isEmpty(enDepDTO.getId_emp_phy()))
			throw new BizException("责任医生不能为空！");
		if (EnValidator.isEmpty(enDepDTO.getId_emp_nur()))
			throw new BizException("责任护士不能为空！");
	}
	
	/**
	 * 转入前校验
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	public void validateBeforeTransIn(TransDepPatDTO patDTO, EnDepDTO enDepDTO) throws BizException {
		if(enDepDTO==null)
			throw new BizException("入科数据不能为空！");
		if (EnValidator.isEmpty(enDepDTO.getId_bed()))
			throw new BizException("入科床位不能为空！");
		if (EnValidator.isEmpty(enDepDTO.getId_wg_phy()))
			throw new BizException("医疗组不能为空！");
		if (EnValidator.isEmpty(enDepDTO.getId_zz_doc()))
			throw new BizException("主治医师不能为空！");
		if (EnValidator.isEmpty(enDepDTO.getId_emp_phy()))
			throw new BizException("责任医生不能为空！");
		if (EnValidator.isEmpty(enDepDTO.getId_emp_nur()))
			throw new BizException("责任护士不能为空！");
	}
}
