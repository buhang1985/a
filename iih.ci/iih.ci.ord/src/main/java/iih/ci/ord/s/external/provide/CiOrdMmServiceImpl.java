package iih.ci.ord.s.external.provide;

import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.i.external.provide.ICiOrdMmService;
import iih.ci.ord.i.external.provide.meta.mm.CiOrderPendingAccountDTO;
import iih.ci.ord.i.external.provide.meta.mm.CiOrderStatusDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdCommenChangedSrvValidateBP;
import iih.ci.ord.s.external.bp.mm.GetPendingAccontOrdersBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 提供给物品域实现
 * 
 * @author HUMS
 *
 */
public class CiOrdMmServiceImpl implements ICiOrdMmService {

	@Override
	public String[] getOrderInfosOfUnPay(String id_dep_mp, String id_pat) throws BizException {
		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb = new StringBuffer();
		sqlb.append("select id_or from ci_order where fg_canc = 'N' and id_su_bl=? and fg_sign =? and id_dep_mp =? and id_pat = ?");
		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		param.addParam("Y");
		param.addParam(id_dep_mp);
		param.addParam(id_pat);
		List<String> result = (List<String>) dafacade.execQuery(sqlb.toString(), param, new ColumnListHandler());
		if (!CiOrdUtils.isEmpty(result))
			return (String[]) result.toArray(new String[result.size()]);
		return null;
	}

	/**
	 * 删除
	 */
	@Override
	@Deprecated
	public CiOrderStatusDTO[] getOrderAccontStatus(String[] id_ors) throws BizException {

		if (id_ors == null || id_ors.length == 0) {

			return new CiOrderStatusDTO[0];
		}

		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb = new StringBuffer();

		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		param.addParam("Y");

		for (String id_or : id_ors) {
			param.addParam(id_or);
			sqlb.append(",?");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct c.id_or "); 
		sb.append("from ci_order c ");
		sb.append("left join ci_or_srv s on c.id_or = s.id_or "); 
		sb.append("where c.id_su_bl = ? and s.fg_self ='N' and c.fg_sign=? and c.id_or in ("+sqlb.substring(1)+")");

		List<CiOrderStatusDTO> resultList = (List<CiOrderStatusDTO>) dafacade.execQuery(sb.toString(), param,
				new BeanListHandler(CiOrderStatusDTO.class));

		return resultList.toArray(new CiOrderStatusDTO[resultList.size()]);
	}
	
	/**
	 * 根据医嘱id获取未记账医嘱属性集合
	 */
	@Override
	public String[] getPendingAccontOrdersByIds(String[] id_ors) throws BizException{
			
		GetPendingAccontOrdersBP bp = new GetPendingAccontOrdersBP();
		List<String> idOrList =  bp.exec(id_ors);
		return idOrList.toArray(new String[idOrList.size()]);
	}

	/**
	 * 根据患者id，执行科室获取待记账的费用项目集合
	 */
	@Override
	public CiOrderPendingAccountDTO[] getPendingAccontOrdersByPat(String id_pat, String id_dep_mp) throws BizException {
		
		GetPendingAccontOrdersBP bp = new GetPendingAccontOrdersBP();
		List<CiOrderPendingAccountDTO> orderSrvList =  bp.getPendingAccountOrders(id_pat, id_dep_mp,false);
		return orderSrvList.toArray(new CiOrderPendingAccountDTO[orderSrvList.size()]);
	}

	/**
	 * 根据患者id，执行科室获取获取待记账的费用项目集合（排除物品）
	 */
	@Override
	public CiOrderPendingAccountDTO[] getPendingAccontOrdersExcludeMmByPat(String id_pat, String id_dep_mp) throws BizException {
		
		GetPendingAccontOrdersBP bp = new GetPendingAccontOrdersBP();
		List<CiOrderPendingAccountDTO> orderSrvList =  bp.getPendingAccountOrders(id_pat, id_dep_mp,true);
		return orderSrvList.toArray(new CiOrderPendingAccountDTO[orderSrvList.size()]);
	}
	
	/**
	 * @code 临床提供基础数据启用校验接口 实现类
	 * @author LiYue
	 * @date 2020年1月16日,上午10:58:35
	 */
	@Override
	public FMap2 ChangedSrvValidate(MedSrvDO[] medSrvDOs) throws BizException {
		OrdCommenChangedSrvValidateBP bd = new OrdCommenChangedSrvValidateBP();
		return bd.exec(medSrvDOs);
	}
}
