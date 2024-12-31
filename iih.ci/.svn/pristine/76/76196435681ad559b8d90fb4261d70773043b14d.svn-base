package iih.ci.ord.s.ems.ip.ems;

import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.StackPointDTO;
import iih.ci.ord.i.ip.ems.ICiIpEmsMainService;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseEmsMainService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 住院医生站医疗单主服务实现逻辑
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiIpEmsMainService.class }, binding = Binding.JSONRPC)
public class CiIpEmsMainServiceImpl extends BaseEmsMainService implements ICiIpEmsMainService {
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
			return matchLoadEmsDriver(ctx, emsarray);
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
