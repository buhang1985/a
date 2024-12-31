package iih.mi.mibd.treatdircomp.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.treatdircomp.d.TreatDirCompDTO;
import iih.mi.mibd.treatdircomp.s.bp.sql.FindTreatCompSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/** 
 * @ClassName: FindTreatCompByTreatIdBp 
 * @Description: 通过医保系统ID,查找保存过的数据服务
 * @author: dj.zhang
 * @date: 2018年2月1日 下午8:10:53  
 */
public class FindTreatCompByTreatIdBp {

	/**  
	* @Title: exec  
	* @Description: 执行
	* @param misId
	* @param treatIds
	* @return
	* @throws BizException   
	*/  
	@SuppressWarnings("unchecked")
	public TreatDirCompDTO[] exec(String misId, String[] treatIds) throws BizException {

		String wherePart = SqlUtils.getInSqlByIds("BD_SRV.ID_SRV", treatIds);
		FindTreatCompSql sql = new FindTreatCompSql(misId, wherePart);

		DAFacade daFacade = new DAFacade();
		ArrayList<TreatDirCompDTO> result = (ArrayList<TreatDirCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(TreatDirCompDTO.class));
		if(result == null){
			return null;
		}
		return result.toArray(new TreatDirCompDTO[0]);
	}

}
