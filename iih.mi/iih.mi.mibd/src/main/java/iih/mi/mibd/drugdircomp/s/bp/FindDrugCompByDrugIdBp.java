package iih.mi.mibd.drugdircomp.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.drugdircomp.d.DrugDirCompDTO;
import iih.mi.mibd.drugdircomp.s.bp.sql.FindDrugDirCompSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/** 
* 通过药品ID查询药品对照
* 
* @author hexx 
*/
public class FindDrugCompByDrugIdBp {

	/**  
	* @Title: exec  
	* @Description: 执行
	* @param misId
	* @param drugIds
	* @return
	* @throws BizException   
	*/ 
	@SuppressWarnings("unchecked")
	public DrugDirCompDTO[] exec(String misId, String[] drugIds) throws BizException {
		String wherePart = SqlUtils.getInSqlByIds("BD_MM.ID_MM", drugIds);
		FindDrugDirCompSql sql = new FindDrugDirCompSql(misId, wherePart);
		DAFacade daFacade = new DAFacade();
		ArrayList<DrugDirCompDTO> result = (ArrayList<DrugDirCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DrugDirCompDTO.class));
		return result.toArray(new DrugDirCompDTO[0]);
	}	
}
