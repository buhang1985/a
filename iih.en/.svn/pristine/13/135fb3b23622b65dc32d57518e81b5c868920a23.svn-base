package iih.en.pv.appoint.s.bp;

import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.i.IBlStQryService;
import iih.en.comm.validator.EnValidator;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取结算信息
 * 
 * @author liubin
 *
 */
public class GetStOepInfoBP {

	/**
	 * 根据预约id查询结算信息
	 * 
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	public BlStOepDO queryByAptId(String aptId) throws BizException {
		String cgId = getCgId(null, aptId);
		if(EnValidator.isEmpty(cgId))
			return null;
		return getBlOepStByIdCg(cgId);
	}
	/**
	 * 根据预约id查询结算信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public BlStOepDO queryByEntId(String entId) throws BizException {
		String cgId = getCgId(entId, null);
		if(EnValidator.isEmpty(cgId))
			return null;
		return getBlOepStByIdCg(cgId);
	}
	/**
	 * 根据预约id查询结算信息
	 * 
	 * @param cgId
	 * @return
	 * @throws BizException
	 */
	public BlStOepDO queryByCgId(String cgId) throws BizException {
		if(EnValidator.isEmpty(cgId))
			return null;
		return getBlOepStByIdCg(cgId);
	}
	/**
	 * 获取退号结算信息
	 * 
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	public BlStOepDO queryCancStByAptId(String aptId) throws BizException {
		BlStOepDO st = queryByAptId(aptId);
		if(st == null)
			return null;
		List<BlStOepDO> list = (List<BlStOepDO>) new DAFacade().findByAttrValString(BlStOepDO.class, BlStOepDO.ID_PAR, st.getId_stoep(), null);
		return EnValidator.isEmpty(list) ? null : list.get(0);
	}
	/**
	 * 获取结算id
	 * 
	 * @param entId
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	private String getCgId(String entId, String aptId) throws BizException {
		if(EnValidator.isEmpty(entId) && EnValidator.isEmpty(aptId))
			return null;
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT OP.ID_CG FROM EN_ENT EN INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append(" WHERE 1=1 ");
		if(!EnValidator.isEmpty(entId)){
			sqlBuilder.append(" AND EN.ID_ENT = ? ");
			param.addParam(entId);
		}
		if(!EnValidator.isEmpty(aptId)){
			sqlBuilder.append(" AND OP.ID_SCHAPT = ? ");
			param.addParam(aptId);
		}
		List<String> list = (List<String>) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.get(0);
	}
	
	/**
	 * 获取结算信息
	 * 
	 * @param cgId
	 * @return
	 * @throws BizException
	 */
	private BlStOepDO getBlOepStByIdCg(String cgId) throws BizException{
		IBlStQryService serv = ServiceFinder.find(IBlStQryService.class);
		return serv.getBlOepStByIdCg(cgId);
	}
}
