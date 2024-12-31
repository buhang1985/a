package iih.ei.std.s.v1.bp.en;

import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.mysql.jdbc.StringUtils;

import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.i.IBlStQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

public class SetStInfoByAptId {

	/**
	 * 获取退号结算信息
	 * 
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	public BlStOepDO queryCancStByAptId(String aptId) throws BizException {
		String cgId = getCgId(aptId);
		if(StringUtils.isNullOrEmpty(cgId))
			return null;
		IBlStQryService serv = ServiceFinder.find(IBlStQryService.class);
		BlStOepDO st = serv.getBlOepStByIdCg(cgId);
		if(st == null)
			return null;
		List<BlStOepDO> list = (List<BlStOepDO>) new DAFacade().findByAttrValString(BlStOepDO.class, BlStOepDO.ID_PAR, st.getId_stoep(), null);
		return ListUtil.isEmpty(list) ? null : list.get(0);
	}

	/**
	 * 获取结算id
	 * 
	 * @param entId
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	private String getCgId(String aptId) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT OP.ID_CG FROM EN_ENT EN INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append(" WHERE 1=1 ");
		if(!StringUtils.isNullOrEmpty(aptId)){
			sqlBuilder.append(" AND OP.ID_SCHAPT = ? ");
			param.addParam(aptId);
		}
		List<String> list = (List<String>) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnListHandler());
		return ListUtil.isEmpty(list) ? null : list.get(0);
	}
}
