package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.dto.d.SchKey;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 删除需覆盖的排班
 * @author yankan
 *
 */
public class DeleteCoverSchBP {
	/**
	 * 
	 * @param schKeyList
	 * @throws BizException
	 */
	public void exec(List<SchKey> schKeyList) throws BizException{
		if(ListUtil.isEmpty(schKeyList)){
			return;
		}
		
		//1、获取预删除的排班集合
		List<String> schIdList = this.getCanDelSchIdList(schKeyList);
		
		//2、删除排班
		DeleteSchBP deleteBP = new DeleteSchBP();
		deleteBP.exec(schIdList);
	}
	/**
	 * 获取可删除排班ID集合
	 * @param schKeyList
	 * @return
	 * @throws BizException
	 */
	private List<String> getCanDelSchIdList(List<SchKey> schKeyList) throws BizException{
		if(ListUtil.isEmpty(schKeyList)){
			return null;
		}
		List<String> keyList = new ArrayList<String>();
		for(SchKey key : schKeyList){
			keyList.add(key.toString());
		}
		String wherePart = ScSqlUtils.getInSqlByIds("ID_SCPL||','||D_SCH||','||ID_DAYSLOT", keyList);
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_SCH,ID_SCPL,D_SCH,ID_DAYSLOT,T_E_REG,QUAN_TOTAL_USED ");
		sqlBuilder.append(" FROM SC_SCH ");
		sqlBuilder.append("WHERE 1=1 ");		
		sqlBuilder.append(" AND ").append(wherePart);
		
		List<String> schIdList = (List<String>) new DAFacade().execQuery(sqlBuilder.toString(), new ColumnListHandler());		
		return schIdList;
	}
}
