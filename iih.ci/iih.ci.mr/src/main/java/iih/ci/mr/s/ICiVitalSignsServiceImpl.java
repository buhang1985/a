package iih.ci.mr.s;

import iih.ci.mr.cimrpatsigns.d.VitalSignsDTO;
import iih.ci.mr.i.ICiVitalSignsService;
import iih.ci.mr.s.bp.VitalSignsbp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { ICiVitalSignsService.class }, binding = Binding.JSONRPC)
public class ICiVitalSignsServiceImpl implements ICiVitalSignsService {

	/*
	 * 获取患者指定日期内的全部体征数据 就诊ID 开始时间 结束时间
	 */
	@Override
	public VitalSignsDTO[] GetVitalSignsDTOList(String Id_ent, String BeginDate, String EndDate) throws BizException {

		VitalSignsbp bp = new VitalSignsbp();

		return bp.exec(Id_ent, BeginDate, EndDate);
	}

}
