package iih.en.que.s.bp.op.qry.benmgr;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.sc.scbd.i.IScDaysLotService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 找到医生出诊队列(队列管理)
 * 
 * @author liubin
 *
 */
public class GetQue4BenMgrBP {
	/**
	 * 找到医生出诊队列(队列管理)
	 * 
	 * @param empId 
	 * 		出诊医生ID
	 * @param deptId   
	 * 		出诊科室ID
	 * @param dayslotId 
	 * 		日期分组Id
	 * @return 出诊队列DO
	 * @throws BizException
	 * @author liubin
	 */
	public QueDO[] exec(EnTrDocSiteInfoDTO siteInfo) throws BizException {
		String[] queIds = getEmpQuesNoSite(siteInfo);
		if(EnValidator.isEmpty(queIds))
			return null;
		IQueRService serv = ServiceFinder.find(IQueRService.class);
		return serv.findByIds(queIds, FBoolean.FALSE);
	}
	/**
	 * 获取可用的日期分组
	 * 
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	public static String[] getDayslotIds(String dayslotId) throws BizException{
		IScDaysLotService serv = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO[] days = serv.getDaysLotDOs(IScDictCodeConst.SD_SCTP_OP);
		if(EnValidator.isEmpty(days))
			return new String[]{dayslotId};
		Set<String> set = new HashSet<>();
		for(DaysLotDO day : days){
			set.add(day.getId_dayslot());
			if(day.getId_dayslot().equals(dayslotId))
				break;
		}
		return set.toArray(new String[0]);
	}
	/**
	 * 获取站点出诊队列
	 * 
	 * @param siteId
	 * @param deptId
	 * @param dayslotId
	 * @param benId
	 * @return
	 * @throws BizException
	 */
	public String[] getQueIdsBySiteId(EnTrDocSiteInfoDTO siteInfo) throws BizException{
		if(siteInfo == null)
			return null;
		if(EnValidator.isEmpty(siteInfo.getId_quesite()))
			return getEmpQuesNoSite(siteInfo);
		return getEmpQuesWithSite(siteInfo);
	}
	/**
	 * 获取站点出诊队列
	 * 
	 * @param siteId
	 * @param deptId
	 * @param dayslotId
	 * @param benId
	 * @return
	 * @throws BizException
	 */
	public QueDO[] getQuesBySiteId(EnTrDocSiteInfoDTO siteInfo) throws BizException{
		String[] queIds = getQueIdsBySiteId(siteInfo);
		if(EnValidator.isEmpty(queIds))
			return null;
		IQueRService serv = ServiceFinder.find(IQueRService.class);
		return serv.findByIds(queIds, FBoolean.FALSE);
	}
	
	/**
	 * 无站点时查询医生出诊队列
	 * 
	 * @param siteInfo
	 * @param dayslotIds
	 * @return
	 * @throws BizException
	 */
	private String[] getEmpQuesNoSite(EnTrDocSiteInfoDTO siteInfo) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT DISTINCT BQ.ID_QUE ");
		sqlBuilder.append(" FROM BD_QUE BQ  ");
		sqlBuilder.append(" INNER JOIN EN_QUE_EMP EMP ON BQ.ID_QUE = EMP.ID_QUE ");
		sqlBuilder.append(" WHERE BQ.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" AND EMP.FG_ACTIVE = 'Y'  ");
		sqlBuilder.append(" AND EMP.FG_STOP = 'N' ");
		sqlBuilder.append(" AND EMP.ID_EMP = ?  ");
		//sqlBuilder.append(" AND BQ.ID_DEP = ?  ");
		sqlBuilder.append(" AND EMP.D_QUE = ?  ");
		param.addParam(siteInfo.getId_emp());
		//param.addParam(siteInfo.getId_dep());
		param.addParam(EnAppUtils.getServerDate());
		if(!EnValidator.isEmpty(siteInfo.getId_queben())){
			sqlBuilder.append(" AND BQ.ID_QUEBEN = ? ");
			param.addParam(siteInfo.getId_queben());
		}
		String[] dayslotIds = getDayslotIds(siteInfo.getId_dayslot());
		if(!EnValidator.isEmpty(dayslotIds)){
			sqlBuilder.append(EnSqlUtils.getInSqlByIds(" and EMP.id_dayslot ", dayslotIds));
		}
		List<String> list = (List<String>) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.toArray(new String[0]);
	}
	/**
	 * 无站点时查询医生出诊队列
	 * 
	 * @param siteInfo
	 * @param dayslotIds
	 * @return
	 * @throws BizException
	 */
	private String[] getEmpQuesWithSite(EnTrDocSiteInfoDTO siteInfo) throws BizException{
		if(siteInfo == null)
			return null;
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT DISTINCT BQ.ID_QUE ");
		sqlBuilder.append(" FROM BD_QUE_SITE BS  ");
		sqlBuilder.append(" INNER JOIN EN_QUE_EMP EMP ON BS.ID_EMP = EMP.ID_EMP ");
		sqlBuilder.append(" INNER JOIN BD_QUE BQ ON BQ.ID_QUE = EMP.ID_QUE ");
		sqlBuilder.append(" WHERE BS.ID_QUESITE = ? ");
		sqlBuilder.append(" AND BQ.FG_ACTIVE = 'Y'  ");
		sqlBuilder.append(" AND EMP.FG_ACTIVE = 'Y'  ");
		sqlBuilder.append(" AND EMP.FG_STOP = 'N' ");
		//sqlBuilder.append(" AND BQ.ID_DEP = BS.ID_DEP ");
		sqlBuilder.append(" AND EMP.D_QUE = ?  ");
		sqlBuilder.append(" AND BQ.ID_QUEBEN = BS.ID_QUEBEN ");
		param.addParam(siteInfo.getId_quesite());
		param.addParam(siteInfo.getDate());
		String[] dayslotIds = getDayslotIds(siteInfo.getId_dayslot());
		if(!EnValidator.isEmpty(dayslotIds)){
			sqlBuilder.append(EnSqlUtils.getInSqlByIds(" and EMP.id_dayslot ", dayslotIds));
		}
		List<String> list = (List<String>) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.toArray(new String[0]);
	}
}
