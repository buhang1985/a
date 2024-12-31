package iih.ei.std.s.v1.bp.mr;

import java.io.IOException;
import iih.ci.mr.mrws.hosgetmr.i.IMrWsForHosSysService;
import iih.ei.std.d.v1.mr.thirdpartypdfdto.d.ThirdPartyPDFParamDTO;
import iih.ei.std.d.v1.mr.thirdpartypdfdto.d.ThirdPartyPDFResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 病案系统中，接收第三方pdf的接口对接
 * 
 * @author 病历
 * @date: 2019-10-29
 */
public class MrGetThirdPartyPDFBp extends IIHServiceBaseBP<ThirdPartyPDFParamDTO, ThirdPartyPDFResultDTO> {

	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(ThirdPartyPDFParamDTO param) throws BizException {
		if (param.getCode_pat() == null) {
			param.setCode_pat("");
		}
		if (param.getTimes_inhos() == null) {
			param.setTimes_inhos("");
		}
		if (param.getCode_ent() == null) {
			param.setCode_ent("");
		}
		if (param.getId_busy() == null) {
			param.setId_busy("");
		}
		if (param.getId_set() == null) {
			param.setId_set("");
		}
		if (param.getName() == null) {
			param.setName("");
		}
		if (param.getFile() == null) {
			param.setFile("");
		}
		if (param.getSortno() == null) {
			param.setSortno(0);
		}
		if (param.getTcount() == null) {
			param.setTcount(0);
		}
	}

	/**
	 * 核心处理
	 */
	@Override
	protected ThirdPartyPDFResultDTO process(ThirdPartyPDFParamDTO param) throws BizException {
		IMrWsForHosSysService service = ServiceFinder.find(IMrWsForHosSysService.class);
		ThirdPartyPDFResultDTO result = new ThirdPartyPDFResultDTO();
		result.setFlag(FBoolean.FALSE);
		Boolean flag = false;
		Boolean isclear = false;
		if (param.getIsclear() == FBoolean.TRUE) {
			isclear = true;
		}
		try {
			flag = service.UpLoadMrmFileInfo(param.getCode_pat(), param.getTimes_inhos(), param.getCode_ent(),
					param.getId_busy(), param.getId_set(), param.getName(), param.getFile(), isclear,
					param.getSortno().intValue(), param.getTcount().intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (flag == true) {
			result.setFlag(FBoolean.TRUE);
		}
		return result;
	}

}
