package iih.en.er.bp.stayregist;

import iih.en.comm.validator.EnValidator;
import iih.en.er.bp.stayregist.qry.FindObsAptIpInfosBP;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取未使用的留观申请单信息
 * 
 * @author liubin
 *
 */
public class GetObsScAptIpInfosBP {
	/**
	 * 获取未使用的留观申请单信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public UrgStayRegistryDTO[] exec(String patId) throws BizException {
		if (EnValidator.isEmpty(patId))
			return null;
		UrgStayRegistryDTO[] urgStayRegistrys = (UrgStayRegistryDTO[]) AppFwUtil
				.getDORstWithDao(new FindObsAptIpInfosBP(patId),
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
		handle.patContHandle(urgStayRegistrys);
		// 5.处理其他信息（年龄，国籍等）
		handle.otherHanler(urgStayRegistrys);
		// 6.患者分类处理
		handle.patCaHandle(urgStayRegistrys);
		// 7.设置住院次数
		handle.setTimesIp(urgStayRegistrys, patId);
		return urgStayRegistrys;
	}
}
