package iih.en.comm.bp;

import iih.bd.base.utils.SqlUtils;
import iih.en.comm.custom.EnIpCustomServiceUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.dto.d.BalanceDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 批量获取就诊账户余额
 * @author yank
 *
 */
public class BatchGetBalanceBP {
	/**
	 * 查询就诊账户余额
	 * 信用额度=患者信用分类的就诊信用额度+就诊账户的信用额度
	 * 账户余额=就诊预交金-消费金额
	 * 可用余额=患者信用分类的就诊信用额度+就诊账户的信用额度 + 预交金-消费金额	 
	 * @param entIds 就诊id数组
	 * @return DTO包含：患者预交金总金额、患者信用度总额、未结算费用总额、患者可用费用余额
	 * @throws BizException
	 * @author yank
	 * @version ly 2018/04/26 修改 -->可用余额=患者信用额度 + 就诊账户的信用额度 + 预交金 + 可报销医保额度 -消费金额	 
	 */
	public BalanceDTO[] exec(String[] entIds) throws BizException{	
		if(EnValidator.isEmpty(entIds)) return null;		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ACC.ID_ENT,");
		sqlBuilder.append("ISNULL(ACC.AMT_PREPAY,0) AMT_PREPAY,");
        sqlBuilder.append("ISNULL(ACC.AMT_CRED,0) + ISNULL(CRET.ENCRED,0) AMT_CRED,");
        sqlBuilder.append("ISNULL(ACC.AMT_UNCG,0) AMT_UNCG,");
        sqlBuilder.append("ISNULL(ACC.AMT_HP,0) AMT_HP,");
        sqlBuilder.append("ISNULL(ACC.AMT_PREPAY,0) - ISNULL(ACC.AMT_UNCG,0) AMT_BAL,");
        sqlBuilder.append("ISNULL(ACC.AMT_PREPAY,0) + ISNULL(ACC.AMT_CRED,0) + ISNULL(CRET.ENCRED,0) + ISNULL(ACC.AMT_HP,0) - ISNULL(ACC.AMT_UNCG,0) AVAILABLE ");
        sqlBuilder.append("FROM EN_ENT_ACC ACC ");
        sqlBuilder.append("INNER JOIN EN_ENT ENT ON ENT.ID_ENT = ACC.ID_ENT ");
        sqlBuilder.append("LEFT JOIN PI_PAT_CRET CRET ON ENT.ID_PATCRET = CRET.ID_PATCRET ");
        sqlBuilder.append("WHERE 1=1 AND ");
        sqlBuilder.append(SqlUtils.getInSqlByIds("ACC.ID_ENT", entIds));
        
        @SuppressWarnings("unchecked")
		List<BalanceDTO> result =(List<BalanceDTO>)new DAFacade().execQuery(sqlBuilder.toString(), 
        		new BeanListHandler(BalanceDTO.class));
        
        if(EnValidator.isEmpty(result))
        	return null;
        BalanceDTO[] balanceDTOs = result.toArray(new BalanceDTO[0]);
        EnIpCustomServiceUtils.handleBalanceDTO(balanceDTOs);//客开处理就诊账户信息
		return balanceDTOs;
	}
}
