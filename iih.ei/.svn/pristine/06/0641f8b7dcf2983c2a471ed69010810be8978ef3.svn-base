package iih.ei.std.s.v1.bp.en;

import com.mysql.jdbc.StringUtils;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.en.cfmpaidapt.d.CfmPaidAptParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.sc.apt.i.IScAptOutCmdService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 已收费预约取号
 * @author fanlq
 * @date: 2019年10月12日 上午11:32:52
 */
public class CfmPaidAptBP extends IIHServiceBaseBP<CfmPaidAptParamDTO, NoParamDTO> {

	@Override
	protected void checkParam(CfmPaidAptParamDTO param) throws BizException {
		if(StringUtils.isNullOrEmpty(param.getId_apt()))
			throw new BizException("预约Id不能为空！");
		if(StringUtils.isNullOrEmpty(param.getCode_opr()))
			throw new BizException("操作员编码不能为空！");
	}

	@Override
	protected NoParamDTO process(CfmPaidAptParamDTO param) throws BizException {
		IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
		serv.takeApptNoForAptNew(param.getId_apt(), param.getCode_opr());
		return null;
	}
	
}
