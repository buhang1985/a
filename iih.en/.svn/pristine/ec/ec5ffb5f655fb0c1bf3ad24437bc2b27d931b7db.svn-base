package iih.en.comm.bp;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnAgeCalcDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.appfw.orm.dataaccess.TmpTableFactory;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询计算年龄所需字段
 * 
 * @author liubin
 *
 */
public class EnAgeCalcBP {
	/**
	 * 查询计算年龄所需字段
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public EnAgeCalcDTO[] exec(String[] entIds) throws BizException {
		if(EnValidator.isEmpty(entIds))
			return null;
		if(entIds.length > 10)
			return execQueryTemp(entIds);
		return execQuery(entIds);
	}
	/**
	 * 查询数据
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	private EnAgeCalcDTO[] execQuery(String[] entIds) throws BizException {
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		this.setSql(sqlBuilder);
		sqlBuilder.append(EnSqlUtils.getInSqlByIds(" WHERE EN.ID_ENT ", entIds));
		List<EnAgeCalcDTO> list = (List<EnAgeCalcDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(EnAgeCalcDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new EnAgeCalcDTO[0]);
	}
	/**
	 * 查询数据_临时表
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	private EnAgeCalcDTO[] execQueryTemp(final String[] entIds) throws BizException {
		return TransactionExecutor.executeRequired(new TransactionalOperation<EnAgeCalcDTO[]>() {
			@Override
			public EnAgeCalcDTO[] doInTransaction(TransactionStatus arg0)
					throws InvocationTargetException {
			    try{
			    	// 生成临时表
			    	String tmpTableName = new TmpTableFactory().get(entIds);
			    	StringBuilder sqlBuilder = new StringBuilder();
			    	setSql(sqlBuilder);
			    	sqlBuilder.append("INNER JOIN ").append(tmpTableName).append(" TEMPTABLE ON EN.ID_ENT = TEMPTABLE.ID1 ");;
			    	List<EnAgeCalcDTO> list = (List<EnAgeCalcDTO>) new DAFacade().execQuery(sqlBuilder.toString(), new BeanListHandler(EnAgeCalcDTO.class));
					return EnValidator.isEmpty(list) ? null : list.toArray(new EnAgeCalcDTO[0]);
			    }catch (BizException e) {
					throw new BizRuntimeException(e.getMessage());
				}
			}
		});
	}
	
	/**
	 * 设置查询sql
	 * 
	 * @param sqlBuilder
	 */
	private void setSql(StringBuilder sqlBuilder){
		sqlBuilder.append(" SELECT EN.ID_ENT AS ID_ENT, ");
		sqlBuilder.append(" NVL(EN.DT_BIRTH_PAT, PAT.DT_BIRTH) AS DT_BIRTH, ");
		sqlBuilder.append(" PAT.DT_BIRTH_HMS AS DT_BIRTH_HMS, ");
		sqlBuilder.append(" EN.FG_IP AS FG_IP, ");
		sqlBuilder.append(" IP.FG_NEWBORN AS FG_NEWBORN, ");
		sqlBuilder.append(" EN.DT_ACPT AS DT_ACPT, ");
		sqlBuilder.append(" EN.DT_ENTRY AS DT_ENTRY ");
		sqlBuilder.append(" FROM EN_ENT EN ");
		sqlBuilder.append(" LEFT JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
		sqlBuilder.append(" LEFT JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
	}
}
