package iih.en.pv.s.bp.op.st;

import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.en.comm.util.EnContextUtils;
import xap.mw.core.data.BizException;

/**
 * 构造操作员信息DTO
 * 
 * @author yank
 * @since 2016-08-03
 */
public class ConstructOprBP {
	/**
	 * 构造操作员信息DTO
	 * 
	 * @return
	 * @throws BizException
	 */
	public OperatorInfoDTO exec() throws BizException {
		OperatorInfoDTO oprDTO = new OperatorInfoDTO();
		oprDTO.setId_grp(EnContextUtils.getGrpId());
		oprDTO.setId_org(EnContextUtils.getOrgId());
		oprDTO.setId_dep(EnContextUtils.getDeptId());
		oprDTO.setId_emp(EnContextUtils.getPsnId());
		oprDTO.setId_org_emp(EnContextUtils.getOrgId());
		return oprDTO;
	}
}
