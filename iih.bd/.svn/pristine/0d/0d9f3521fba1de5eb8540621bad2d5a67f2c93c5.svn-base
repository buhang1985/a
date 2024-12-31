package iih.bd.pp.pripat.s.validator.bp;

import java.util.LinkedList;
import java.util.List;

import iih.bd.pp.pripat.d.PriPatSrvOrCaDO;
import iih.bd.pp.pripat.d.PriRateMdEnum;
import iih.bd.pp.pripat.i.IPriPatSrvOrCaDORService;
import iih.bd.utils.BdPpParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.validation.ValidationFailure;

/**
 * 患者价格分类服务 PriPatSrvOrCaDO保存时校验bp
 * 
 * @author guoyang
 *
 */
public class PriPatSrvOrCaInsertValidatorBp {

	public ValidationFailure exec(Object[] arg0) throws BizException {

		if (arg0 == null || arg0.length <= 0) {
			return null;
		}
		PriPatSrvOrCaDO[] priPatSrvOrCaDOs = Convert2PriPatSrvOrCaDO(arg0);
		return validator(priPatSrvOrCaDOs);
	}

	/**
	 * 转换数据类型
	 * 
	 * @param arg0
	 * @return
	 * @throws BizException
	 */
	private PriPatSrvOrCaDO[] Convert2PriPatSrvOrCaDO(Object[] arg0) throws BizException {

		PriPatSrvOrCaDO[] priPatSrvOrCaDOs = new PriPatSrvOrCaDO[arg0.length];
		for (int i = 0; i < arg0.length; i++) {
			if (arg0[i] instanceof PriPatSrvOrCaDO) {
				priPatSrvOrCaDOs[i] = (PriPatSrvOrCaDO) arg0[i];
			}
		}
		return priPatSrvOrCaDOs;
	}

	/**
	 * 保存前检查：如果新增价表为价格计算模式，如果查询到相同服务 项目且结束日期等于2099-12-31 23:59:59的定价，根
	 * 据参数决定是否提示必须使用调价计划
	 * 
	 * @param object
	 * @return
	 * @throws BizException
	 */
	private ValidationFailure validator(PriPatSrvOrCaDO[] priPatSrvOrCaDOs) throws BizException {

		if (priPatSrvOrCaDOs == null || priPatSrvOrCaDOs.length <= 0) {
			return null;
		}

		List<PriPatSrvOrCaDO> prSrvOrCaDOlist = new LinkedList<PriPatSrvOrCaDO>();

		for (PriPatSrvOrCaDO priPatSrvOrCaDO : priPatSrvOrCaDOs) {
			// 校验开始时间和结束时间，必须结束时间大于开始时间
			if (!priPatSrvOrCaDO.getDt_b().before(priPatSrvOrCaDO.getDt_e())) {
				String msg = String.format("患者价格分类：'%s'下的服务：'%s'结束时间需大于开始时间！", priPatSrvOrCaDO.getPripat_name(),
						priPatSrvOrCaDO.getSrv_name());
				return new ValidationFailure(msg);
			}
			// 价格计算模式
			if (priPatSrvOrCaDO.getEu_pi_priratemd() == PriRateMdEnum.PRICEMODEL) {
				prSrvOrCaDOlist.add(priPatSrvOrCaDO);
			}
		}

		if (prSrvOrCaDOlist == null || prSrvOrCaDOlist.size() <= 0) {
			return null;
		}

		PriPatSrvOrCaDO[] priPatSrvs = findPriPatSrvOrCaBySrv(
				prSrvOrCaDOlist.toArray(new PriPatSrvOrCaDO[prSrvOrCaDOlist.size()]));

		// 如果新增价表为价格计算模式，如果查询到相同服务项目且结束日期
		// 等于2099-12-31 23:59:59的定价，根据参数决定是否提示必须使用调价计划
		if (priPatSrvs != null && priPatSrvs.length > 0 && !BdPpParamUtils.getPlanModifyPriFlag()
				&& BdPpParamUtils.GetWhetherUseModifyPricePlan().booleanValue()) {

			String msg = String.format("患者价格分类：'%s'下的服务：'%s'必须使用调价计划节点进行调价！", priPatSrvs[0].getPripat_name(),
					priPatSrvs[0].getSrv_name());
			return new ValidationFailure(msg);
		}

		return null;
	}

	/**
	 * 查询项目，患者价格分类下的PriPatSrvOrCaDO
	 * 
	 * @param priPatSrvOrCaDOs
	 * @return
	 * @throws BizException
	 */
	private PriPatSrvOrCaDO[] findPriPatSrvOrCaBySrv(PriPatSrvOrCaDO[] priPatSrvOrCaDOs) throws BizException {

		IPriPatSrvOrCaDORService priPatSrvOrCaDORService = ServiceFinder.find(IPriPatSrvOrCaDORService.class);

		String whereStr = getWhereStr(priPatSrvOrCaDOs);

		PriPatSrvOrCaDO[] priPatSrvOrCas = priPatSrvOrCaDORService.find(whereStr, "", FBoolean.FALSE);

		return priPatSrvOrCas;
	}

	/**
	 * 获取where条件
	 * 
	 * @param priPatSrvOrCaDOs
	 * @return
	 */
	private String getWhereStr(PriPatSrvOrCaDO[] priPatSrvOrCaDOs) {
		StringBuffer sb = new StringBuffer(" dt_e = '2099-12-31 23:59:59' ");
		sb.append(" and ( 1 <> 1 ");
		for (PriPatSrvOrCaDO priPatSrvOrCaDO : priPatSrvOrCaDOs) {
			// 当是价格模式时
			if (priPatSrvOrCaDO.getEu_pi_priratemd() == PriRateMdEnum.PRICEMODEL) {
				sb.append(String.format("  or (id_pripat = '%s' and id_srv = '%s')", priPatSrvOrCaDO.getId_pripat(),
						priPatSrvOrCaDO.getId_srv()));
			}
		}
		sb.append(" )");
		return sb.toString();
	}

}
