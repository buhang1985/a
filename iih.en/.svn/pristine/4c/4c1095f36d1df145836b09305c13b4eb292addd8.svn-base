package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.ep.EntAuthEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.inpatient.dto.d.PatientsDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 获取授权患者
 * 
 * @author liubin
 *
 */
public class GetAuthPatsBP {
	/**
	 * 根据部门id，患者id，时间
	 * 
	 * @param depId
	 * @param empId
	 * @return
	 * @throws BizException
	 */
	public PatientsDTO[] exec(EntQryModDTO entQryDto) throws BizException {
		if (EnValidator.isEmpty(entQryDto.getId_dep()) || EnValidator.isEmpty(entQryDto.getId_emp())) {
			return null;
		}
		FDateTime now = EnAppUtils.getServerDateTime();
		List<String> list = new EntAuthEP().getEntIdsList(entQryDto, now);
		if (!EnValidator.isEmpty(list)) {
			return new GetIpDocStationPatsBP().exec(list, entQryDto.getId_emp());
		}
		return null;
	}
}
