package iih.ci.ord.s.ems.op.ems;

import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.StackPointDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.i.op.ems.ICiOpEmsMainService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseEmsMainService;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { ICiOpEmsMainService.class }, binding = Binding.JSONRPC)
public class CiOpEmsMainServiceImpl extends BaseEmsMainService implements ICiOpEmsMainService {

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsarray) throws BizException {
			
		if (OrSourceFromEnum.IIHSRVREF.equals(ctx.getEu_orsrcmdtp())) {
			return matchCreateEmsDriver(ctx, emsarray);
		} 

		return null;
	}

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] emsarray) throws BizException {
		if (OrSourceFromEnum.IIHSRVREF.equals(ctx.getEu_orsrcmdtp())) {
			EmsRstDTO[] emsRsts = matchLoadEmsDriver(ctx, emsarray);
			return emsRsts;
		} 
		return null;
	}

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {

		if (OrSourceFromEnum.IIHSRVREF.equals(ctx.getEu_orsrcmdtp())) {
			return doSaveEmsInfo(ctx, szEms);
		}

		return null;
	}

	/**
	 * 处理服务参照发送过来的医疗单保存请求
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private EmsRstDTO[] doSaveEmsInfo(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {
		// 断点分支判断
		if (!CiOrdUtils.isEmpty(szEms[0].getDocument()) && szEms[0].getDocument().size() > 0) {
			if (szEms[0].getDocument().get(0) instanceof StackPointDTO) {
				return new EmsRstDTO[] { doStackPoint(ctx, szEms[0]) };
			} else {
				return new EmsRstDTO[] { matchSaveEmsDriver(ctx, szEms[0]) };
		}
	}

		return null;
	}

	

}
