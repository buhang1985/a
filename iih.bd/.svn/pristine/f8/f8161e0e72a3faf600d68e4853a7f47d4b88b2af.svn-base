package iih.bd.pp.prisrvcomp.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据医疗服务主键查询组合定价列表</br>
 * 增加了金额的计算
 * 
 * @author hao_wu
 *
 */
public class FindByMedsrvIdBp {

	public PriSrvCompDO[] exec(String medsrvId, String orderByPart) throws BizException {
		if (StringUtils.isEmpty(medsrvId)) {

		}
		PriSrvCompDO[] result = FindByMedsrvId(medsrvId, orderByPart);
		return result;
	}

	/**
	 * 据医疗服务主键查询组合定价列表
	 * 
	 * @param medsrvId
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
	private PriSrvCompDO[] FindByMedsrvId(String medsrvId, String orderByPart) throws BizException {
		String whereStr = String.format("id_srv = '%s'", medsrvId);

		IPrisrvcompRService prisrvcompRService = ServiceFinder.find(IPrisrvcompRService.class);
		PriSrvCompDO[] result = prisrvcompRService.find(whereStr, orderByPart, FBoolean.FALSE);
		SetMedSrvPrice(result);
		CalAmt(result);
		return result;
	}

	/**
	 * 设置医疗服务单价
	 * 
	 * @param result
	 * @throws BizException
	 */
	private void SetMedSrvPrice(PriSrvCompDO[] priSrvComps) throws BizException {
		SetMedSrvCompItemPriceBp bp = new SetMedSrvCompItemPriceBp();
		bp.exec(priSrvComps);
	}

	/**
	 * 计算金额
	 * 
	 * @param result
	 */
	private void CalAmt(PriSrvCompDO[] result) {
		CalPriSrvCompAmtBp bp = new CalPriSrvCompAmtBp();
		bp.exec(result);
	}

}
