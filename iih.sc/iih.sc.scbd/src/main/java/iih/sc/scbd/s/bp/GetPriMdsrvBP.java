package iih.sc.scbd.s.bp;

import java.util.List;
import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetPriMdsrvBP {
	/**
	 * 获取服务标准价格
	 * @param idSrvs
	 * @return
	 * @throws BizException
	 */
	public  FMap exec(String id_srv) throws BizException{
		if(StringUtil.isEmpty(id_srv)) return null;
		String[] idSrvs = StringUtil.split(id_srv, ",");
		String cond = SqlUtils.getInSqlByIds(MedSrvDO.ID_SRV, idSrvs);
		String sql = this.getSql(cond);
		List<MedSrvDO> list = (List<MedSrvDO>)new DAFacade().execQuery(sql,new BeanListHandler(MedSrvDO.class));
		FMap result = new FMap();
		if (!ListUtil.isEmpty(list)) {
			for (MedSrvDO medSrvDO : list) {
				if(!result.containsKey(medSrvDO.getId_srv())){
					result.put(medSrvDO.getId_srv(), medSrvDO.getPri());
				}
			}
		}
		return result;
	}
	/**
	 * 获取查询语句
	 * @param cond
	 * @return
	 */
	private String getSql(String cond){
		StringBuffer sqlQry = new StringBuffer();
		sqlQry.append("select id_srv,price_std as PRI from VIEW_PRICE_STD_RP where ");
		sqlQry.append(cond);
		return sqlQry.toString();
	}
}
