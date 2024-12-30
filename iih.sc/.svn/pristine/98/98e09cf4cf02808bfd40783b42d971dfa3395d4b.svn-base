package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.scbd.scsrvexcl.d.ScSrvExclDO;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * 医技预约项目互斥检查BP
 * 
 * @author zhengcm
 * @date 2017-03-03 14:07:27
 *
 */

public class SrvMutexCheck4MtAptBP {

	/**
	 * 项目互斥检查
	 *
	 * @param id_pat 患者id
	 * @param id_srv 检查服务id
	 * @param tickDO 号位DO
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(String id_pat, String id_srv, FDateTime aptTime) throws BizException {

		// 1、根据系统参数[最大检查互斥天数]计算开始时间
		int days = ScParamUtils.getExcluMaxDay();
		FDate today = aptTime.getDate().asBegin();
		FDate begin_date = today.getDateBefore(days);
		FDate end_date = aptTime.getDate();

		// 2.询日期区间内患者已预约的排班服务
		List<ScAptDO> aptDOList = this.getPatAptScSrvList(id_pat, begin_date, end_date);

		// 3、互斥检查
		this.mutexCheck(id_srv, aptDOList, aptTime);
	}

	@SuppressWarnings("unchecked")
	private List<ScAptDO> getPatAptScSrvList(String id_pat, FDate begin, FDate end) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select * ");
		sb.append("from ");
		sb.append("sc_apt apt ");
		sb.append("where ");
		sb.append("apt.fg_canc = 'N' ");
		sb.append("and apt.sd_sctp = '" + IScDictCodeConst.SD_SCTP_MT + "' ");
		sb.append("and apt.id_pat = ? ");
		sb.append("and apt.dt_b >= ? ");
		sb.append("and apt.dt_b < ? ");

		SqlParam params = new SqlParam();
		params.addParam(id_pat);
		params.addParam(begin);
		params.addParam(end);

		List<ScAptDO> list = (List<ScAptDO>) new DAFacade().execQuery(sb.toString(), params, new BeanListHandler(
				ScAptDO.class));

		return list;
	}

	/**
	 * 服务互斥检查
	 *
	 * @param id_srv 申请单服务id
	 * @param srvList 患者已预约和已检查的检查单List
	 * @param nowTime 当前服务器时间
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void mutexCheck(String id_srv, List<ScAptDO> aptDOList, FDateTime nowTime) throws BizException {
		if (ListUtil.isEmpty(aptDOList)) {
			return;
		}

		List<String> scsrvList = new ArrayList<String>();
		for (ScAptDO aptDO : aptDOList) {
			scsrvList.add(aptDO.getId_scsrv());
		}

		// 正向检查
		StringBuilder sb = this.getSqlByType(id_srv, scsrvList, 0);
		List<ScSrvExclDO> datas = (List<ScSrvExclDO>) new DAFacade().execQuery(sb.toString(), null,
				new BeanListHandler(ScSrvExclDO.class));
		this.check(id_srv, datas, aptDOList, nowTime, 0);

		// 反向检查
		sb = this.getSqlByType(id_srv, scsrvList, 1);
		datas = (List<ScSrvExclDO>) new DAFacade().execQuery(sb.toString(), null,
				new BeanListHandler(ScSrvExclDO.class));
		this.check(id_srv, datas, aptDOList, nowTime, 1);
	}

	/**
	 * 正向和反向互斥检查
	 *
	 * @param datas 满足条件的互斥服务
	 * @param appMap 满足条件的检查单
	 * @param nowTime 当前时间
	 * @param type 正向和反向类型
	 * @throws BizException
	 * @author zhengcm
	 */
	private void check(String id_srv, List<ScSrvExclDO> datas, List<ScAptDO> aptDOList, FDateTime nowTime, int type)
			throws BizException {
		if (ListUtil.isEmpty(aptDOList)) {
			return;
		}
		// 查询服务对照关系
		IScheduleSrvRelDORService relQryService = ServiceFinder.find(IScheduleSrvRelDORService.class);
		// 记录满足条件的排班服务和检查服务的对照关系
		Map<String, List<String>> srvMap = new HashMap<String, List<String>>();
		// 记录排班服务
		List<String> scSrvList = new ArrayList<String>();
		// 互斥单位
		List<String> measIdList = new ArrayList<String>();
		for (ScSrvExclDO exclDO : datas) {
			if (type == 0) {
				scSrvList.add(exclDO.getId_scsrv_b());
			} else {
				scSrvList.add(exclDO.getId_scsrv_a());
			}
			if (null != exclDO.getId_measdoc_period() && !measIdList.contains(exclDO.getId_measdoc_period())) {
				measIdList.add(exclDO.getId_measdoc_period());
			}
		}
		// 查询排班服务对照关系
		String where = "id_scsrv in (" + ScSqlUtils.buildIdStr(scSrvList) + ")";
		ScheduleSrvRelDO[] relDOs = relQryService.find(where, null, FBoolean.FALSE);
		// 记录对照关系
		for (ScheduleSrvRelDO relDO : relDOs) {
			String key = relDO.getId_scsrv();
			if (srvMap.containsKey(key)) {
				srvMap.get(key).add(relDO.getId_mdsrv());
			} else {
				List<String> temp = new ArrayList<String>();
				temp.add(relDO.getId_mdsrv());
				srvMap.put(key, temp);
			}
		}
		// 互斥单位
		Map<String, MeasDocDO> docMap = this.getMeasMap(measIdList);
		// 互斥检查
		for (ScSrvExclDO exclDO : datas) {
			String key = exclDO.getId_scsrv_b();
			if (type == 1) {
				key = exclDO.getId_scsrv_a();
			}
			for (ScAptDO aptDO : aptDOList) {
				if (aptDO.getId_scsrv().equals(key)) {
					MeasDocDO docDO = null;
					if (null != docMap && docMap.containsKey(exclDO.getId_measdoc_period())) {
						docDO = docMap.get(exclDO.getId_measdoc_period());
					}
					if (null == docDO) {
						throw new BizException("服务互斥期限单位为空，请检查！");
					}
					if (docDO.getCode().equals("D")) {// 天按照自然天来处理
						int btw = FDate.getDaysBetween(new FDate(aptDO.getDt_b().getDate().toLocalString()), new FDate(
								nowTime.getDate().toLocalString()));
						if (btw < exclDO.getPeriod()) {
							throw new BizException(exclDO.getNote());// 提示互斥信息
						}
					} else {
						long exclSeconds = this.getExclSeconds(exclDO, docDO, aptDO);
						int appSeconds = FDateTime.getSecondsBetween(aptDO.getDt_b(), nowTime);
						if (exclSeconds > appSeconds) {
							throw new BizException(exclDO.getNote());// 提示互斥信息
						}
					}
				}
			}
		}
	}

	/**
	 * 组装正向和反向检查的查询SQL
	 *
	 * @param id_srv 服务id
	 * @param srvList 满足条件的服务List
	 * @param type 正向和反向类型
	 * @return SQL
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSqlByType(String id_srv, List<String> srvList, int type) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct ");
		sb.append("excl.* ");
		sb.append("from ");
		sb.append("sc_srv_excl excl ");
		if (type == 0) {// 正向
			sb.append("inner join sc_srv_rel rela on rela.id_scsrv = excl.id_scsrv_a and rela.id_mdsrv = '" + id_srv
					+ "' ");
			sb.append("inner join sc_srv_rel relb on relb.id_scsrv = excl.id_scsrv_b and relb.id_scsrv in ("
					+ ScSqlUtils.buildIdStr(srvList) + ")");
		} else {// 反向
			sb.append("inner join sc_srv_rel rela on rela.id_scsrv = excl.id_scsrv_a and rela.id_scsrv in ("
					+ ScSqlUtils.buildIdStr(srvList) + ")");
			sb.append("inner join sc_srv_rel relb on relb.id_scsrv = excl.id_scsrv_b and relb.id_mdsrv = '" + id_srv
					+ "' ");
		}
		return sb;
	}

	/**
	 * 根据服务排斥DO获取间隔时间的秒数
	 *
	 * @param exclDO 服务排斥DO
	 * @param docDO 单位DO
	 * @param aptDO 预约DO
	 * @return 时间间隔秒数
	 * @throws BizException
	 * @author zhengcm
	 */
	private long getExclSeconds(ScSrvExclDO exclDO, MeasDocDO docDO, ScAptDO aptDO) throws BizException {
		long multiple = 1;
		switch (docDO.getCode()) {
		case IScDictCodeConst.S:// 秒
			multiple = 1;
			break;
		case IScDictCodeConst.MIN:// 分
			multiple = 60;
			break;
		case IScDictCodeConst.HR:// 时
			multiple = 60 * 60;
			break;
		case IScDictCodeConst.D:// 天
			multiple = 60 * 60 * 24;
			break;
		default:
			multiple = 1;
			break;
		}
		return exclDO.getPeriod() * multiple;
	}

	/**
	 * 获取服务互斥计量单位
	 * 
	 * @author zhengcm
	 *
	 * @param measIdList
	 * @return
	 * @throws BizException
	 */
	private Map<String, MeasDocDO> getMeasMap(List<String> measIdList) throws BizException {
		if (ListUtil.isEmpty(measIdList)) {
			return null;
		}
		IMeasdocRService qryService = ServiceFinder.find(IMeasdocRService.class);
		MeasDocDO[] docDOs = qryService.find(ScSqlUtils.getInSqlByIds("id_measdoc", measIdList), null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(docDOs)) {
			return null;
		}
		Map<String, MeasDocDO> map = new HashMap<String, MeasDocDO>();
		for (MeasDocDO docDO : docDOs) {
			String key = docDO.getId_measdoc();
			if (!map.containsKey(key)) {
				map.put(key, docDO);
			}
		}
		return map;
	}
}
