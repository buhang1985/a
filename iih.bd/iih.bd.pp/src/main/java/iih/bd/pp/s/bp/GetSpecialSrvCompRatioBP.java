package iih.bd.pp.s.bp;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.dto.prisrvcompratio.d.BdPriSrvCompRatioDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取组合定价特殊比例
 * @author ly 2019/09/23
 *
 */
public class GetSpecialSrvCompRatioBP {

	/**
	 * 获取组合定价特殊比例
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BdPriSrvCompRatioDTO[] exec(String[] srvIds) throws BizException{
		
		if(ArrayUtil.isEmpty(srvIds))
			return null;
		
		DAFacade daf = new DAFacade();
		List<BdPriSrvCompRatioDTO> rlt = (List<BdPriSrvCompRatioDTO>)daf.execQuery(
				this.getSql(srvIds), new BeanListHandler(BdPriSrvCompRatioDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BdPriSrvCompRatioDTO[0]);
	}
	
	/**
	 * sql
	 * @return
	 */
	private String getSql(String[] srvIds){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select id_srv,id_srv_bl,ratio,id_mm,id_unit ");
		sqlSb.append("from bd_pri_srv_comp ");
		sqlSb.append("where (ratio <> 1 or nvl(id_mm,'~') <> '~' ) ");
		sqlSb.append("and " + SqlUtils.getInSqlByIds("id_srv", srvIds));
		return sqlSb.toString();
	}
}
