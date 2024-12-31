package iih.en.pv.s.bp.ip;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.dto.d.EnAccDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.SqlBuildHelper;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取就诊账户信息
 * 
 * @author yank
 *
 */
public class GetEnAccBP {
	/**
	 * 获取就诊账户信息 信用额度=患者信用分类的就诊信用额度+就诊账户的信用额度 账户余额=就诊预交金-消费金额
	 * 可用余额=患者信用分类的就诊信用额度+就诊账户的信用额度 + 预交金-消费金额
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	public EnAccDTO exec(String entId) throws BizException {
		if (EnValidator.isEmpty(entId)) {
			return null;
		}

		SqlBuildHelper sqlBuilder = new SqlBuildHelper();
		sqlBuilder.append("SELECT ACC.ID_ENT,");
		sqlBuilder.append("ACC.ID_ENTACC,");
		sqlBuilder.append("ISNULL(ACC.AMT_PREPAY,0) AMT_PREPAY,");// 就诊账户预交金
		sqlBuilder.append("ISNULL(ACC.AMT_CRED,0) AS AMT_CRED_ACC,");// 就诊账户信用额度
		sqlBuilder.append("ISNULL(CRET.ENCRED,0) AS AMT_CRED_PRIPAT,");// 患者信用分类的就诊信用额度
		sqlBuilder.append("ISNULL(ACC.AMT_CRED,0) + ISNULL(CRET.ENCRED,0) AMT_CRED,");// 信用额度
		sqlBuilder.append("ISNULL(ACC.AMT_UNCG,0) AMT_UNCG,");// 未结算费用
		sqlBuilder.append("ISNULL(ACC.AMT_PREPAY,0) - ISNULL(ACC.AMT_UNCG,0) AMT_BAL,");// 就诊账户余额
		sqlBuilder
				.append("ISNULL(ACC.AMT_PREPAY,0) + ISNULL(ACC.AMT_CRED,0) + ISNULL(CRET.ENCRED,0) - ISNULL(ACC.AMT_UNCG,0) AVAILABLE, ");// 可用余额
		sqlBuilder.append("ISNULL(ACC.AMT_HP,0) AMT_HP,");// 医保预支付金额
		sqlBuilder.append("AMT_OWELIMIT,DT_BACKCG,DT_BACKCGLASTACT,FG_FREEZE ");
		sqlBuilder.append("FROM EN_ENT_ACC ACC ");
		sqlBuilder.append("INNER JOIN EN_ENT ENT ON ENT.ID_ENT = ACC.ID_ENT ");
		sqlBuilder.append("LEFT JOIN PI_PAT_CRET CRET ON ENT.ID_PATCRET = CRET.ID_PATCRET ");
		sqlBuilder.append("WHERE 1=1 AND ");
		sqlBuilder.append("ACC.ID_ENT=?");

		SqlParam param = new SqlParam();
		param.addParam(entId);

		@SuppressWarnings("unchecked")
		List<EnAccDTO> result = (List<EnAccDTO>) new DAFacade().execQuery(sqlBuilder.toString(),
				param, new BeanListHandler(EnAccDTO.class));

		if (EnValidator.isEmpty(result)) {
			return null;
		}
		return result.get(0);
	}
}
