package iih.en.er.bp.stayregist;

import iih.en.comm.validator.EnValidator;
import iih.en.er.bp.stayregist.qry.FindObsStayEntInfoBP;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取留观登记信息
 * 
 * @author liubin
 *
 */
public class GetUrgStayRegInfosBP {
	/**
	 * 根据就诊id查询急诊留观登记信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public UrgStayRegistryDTO execByEntId(String entId) throws BizException {
		if (EnValidator.isEmpty(entId))
			return null;
		UrgStayRegistryDTO[] urgStayRegistryDtos = exec(entId, null);
		return EnValidator.isEmpty(urgStayRegistryDtos) ? null : urgStayRegistryDtos[0];
	}

	/**
	 * 根据患者id查询急诊留观登记信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public UrgStayRegistryDTO execByPatId(String patId) throws BizException {
		if (EnValidator.isEmpty(patId))
			return null;
		UrgStayRegistryDTO[] urgStayRegistryDtos = exec(null, patId);
		return EnValidator.isEmpty(urgStayRegistryDtos) ? null : urgStayRegistryDtos[0];
	}

	/**
	 * 查询急诊留观登记信息
	 * 
	 * @param entId
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private UrgStayRegistryDTO[] exec(String entId, String patId)
			throws BizException {
		if (EnValidator.isEmpty(entId) && EnValidator.isEmpty(patId))
			return null;
		UrgStayRegistryDTO[] urgStayRegistrys = (UrgStayRegistryDTO[]) AppFwUtil
				.getDORstWithDao(new FindObsStayEntInfoBP(entId, patId),
						UrgStayRegistryDTO.class);
		if (EnValidator.isEmpty(urgStayRegistrys))
			return null;
		UrgStayRegistryDtoHandle handle = new UrgStayRegistryDtoHandle();
		// 1.处理自定义档案信息
		handle.udidocHandle(urgStayRegistrys);
		// 2.处理科室信息
		handle.deptHandle(urgStayRegistrys);
		// 3.患者地址信息
		handle.patAddrHandle(urgStayRegistrys);
		// 4.处理患者联系人信息
		handle.entContHandle(urgStayRegistrys);
		// 5.处理留观申请单信息
		handle.scAptIpHandle(urgStayRegistrys);
		// 6.处理其他信息（年龄，国籍等）
		handle.otherHanler(urgStayRegistrys);
		
		return urgStayRegistrys;
	}
}
