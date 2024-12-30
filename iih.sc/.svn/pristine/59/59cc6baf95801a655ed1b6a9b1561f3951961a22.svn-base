package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import iih.ci.ord.i.ICiOrdQryService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.scbd.scsrvexcl.d.ScSrvExclDO;

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
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * 项目互斥检查BP
 * 
 * @author zhengcm
 * @date 2016-09-05 17:07:27
 *
 */

public class SrvMutexCheckBP {

	/**
	 * 项目互斥检查
	 *
	 * @param id_pat 患者id
	 * @param id_srv 检查服务id
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(String id_pat, String id_srv) throws BizException {

		// 1、参数校验
		ScValidator.validateParam(id_pat, id_srv);

		// 2、根据系统参数[最大检查互斥天数]计算开始时间
		int days = ScParamUtils.getExcluMaxDay();
		FDateTime nowTime = ScAppUtils.getServerDateTime();
		FDate today = nowTime.getBeginDate();
		FDateTime begin_date = new FDateTime(today.getDateBefore(days).toString() + " "
				+ nowTime.toString().substring(11));

		// 3、调用CI接口，取出患者最近一段时间内已预约和已检查的申请单
		ICiOrdQryService ordQryService = ServiceFinder.find(ICiOrdQryService.class);
		AppObsDto[] appDTOs = ordQryService.getCiApObsDtoIdPatAndDate(new String[] { id_pat },
				begin_date, nowTime, new String[] { ICiDictCodeConst.SD_CI_OBS_YAP,
						ICiDictCodeConst.SD_CI_OBS_YJC });
		if (ArrayUtil.isEmpty(appDTOs)) {
			return;
		}

		// 4、获取已预约和已检查的检查单对应的检查服务
		List<String> srvList = new ArrayList<String>();
		// 记录检查单数据
		Map<String, List<AppObsDto>> appMap = new HashMap<String, List<AppObsDto>>();
		for (AppObsDto appDTO : appDTOs) {
			// 记录已预约和已检查的检查单供查询使用
			srvList.add(appDTO.getId_srv());
			// 记录已预约和已检查的检查单供后面校验
			if (appMap.containsKey(appDTO.getId_srv())) {
				appMap.get(appDTO.getId_srv()).add(appDTO);
			} else {
				List<AppObsDto> temp = new ArrayList<AppObsDto>();
				temp.add(appDTO);
				appMap.put(appDTO.getId_srv(), temp);
			}
		}

		// 5、互斥检查
		this.mutexCheck(id_srv, srvList, appMap, nowTime);
	}

	/**
	 * 服务互斥检查
	 *
	 * @param id_srv 申请单服务id
	 * @param srvList 患者已预约和已检查的检查单List
	 * @param appMap 患者已预约和已检查的检查单Map
	 * @param nowTime 当前服务器时间
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void mutexCheck(String id_srv, List<String> srvList,
			Map<String, List<AppObsDto>> appMap, FDateTime nowTime) throws BizException {
		if (ListUtil.isEmpty(srvList)) {
			return;
		}

		// 正向检查
		StringBuilder sb = this.getSqlByType(id_srv, srvList, 0);
		List<ScSrvExclDO> datas = (List<ScSrvExclDO>) new DAFacade().execQuery(sb.toString(), null,
				new BeanListHandler(ScSrvExclDO.class));
		this.check(datas, appMap, nowTime, 0);

		// 反向检查
		sb = this.getSqlByType(id_srv, srvList, 1);
		datas = (List<ScSrvExclDO>) new DAFacade().execQuery(sb.toString(), null,
				new BeanListHandler(ScSrvExclDO.class));
		this.check(datas, appMap, nowTime, 1);
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
	private void check(List<ScSrvExclDO> datas, Map<String, List<AppObsDto>> appMap,
			FDateTime nowTime, int type) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		// 查询服务对照关系
		IScheduleSrvRelDORService relQryService = ServiceFinder
				.find(IScheduleSrvRelDORService.class);
		// 记录满足条件的排班服务和检查服务的对照关系
		Map<String, String> srvMap = new HashMap<String, String>();
		// 记录排班服务
		List<String> scSrvList = new ArrayList<String>();
		for (ScSrvExclDO exclDO : datas) {
			if (type == 0) {
				scSrvList.add(exclDO.getId_scsrv_b());
			} else {
				scSrvList.add(exclDO.getId_scsrv_a());
			}
		}
		// 查询排班服务对照关系
		String where = "id_scsrv in (" + ScSqlUtils.buildIdStr(scSrvList) + ")";
		ScheduleSrvRelDO[] relDOs = relQryService.find(where, null, FBoolean.FALSE);
		// 记录对照关系
		for (ScheduleSrvRelDO relDO : relDOs) {
			srvMap.put(relDO.getId_scsrv(), relDO.getId_mdsrv());
		}
		// 互斥检查
		for (ScSrvExclDO exclDO : datas) {
			long exclSeconds = this.getExclSeconds(exclDO);
			String key = exclDO.getId_scsrv_b();
			if (type == 1) {
				key = exclDO.getId_scsrv_a();
			}
			if (!srvMap.containsKey(key)) {
				continue;
			}
			String srv_key = srvMap.get(key);
			if (!appMap.containsKey(srv_key)) {
				continue;
			}
			List<AppObsDto> appDTOs = appMap.get(srv_key);
			for (AppObsDto appDTO : appDTOs) {
				int appSeconds = FDateTime.getSecondsBetween(appDTO.getDt_effe(), nowTime);
				if (exclSeconds > appSeconds) {
					throw new BizException(exclDO.getNote());// 提示互斥信息
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
	private StringBuilder getSqlByType(String id_srv, List<String> srvList, int type)
			throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("excl.* ");
		sb.append("from ");
		sb.append("sc_srv_excl excl ");
		if (type == 0) {// 正向
			sb.append("inner join sc_srv_rel rela on rela.id_scsrv = excl.id_scsrv_a and rela.id_mdsrv = '"
					+ id_srv + "' ");
			sb.append("inner join sc_srv_rel relb on relb.id_scsrv = excl.id_scsrv_b and relb.id_mdsrv in ("
					+ ScSqlUtils.buildIdStr(srvList) + ")");
		} else {// 反向
			sb.append("inner join sc_srv_rel rela on rela.id_scsrv = excl.id_scsrv_a and rela.id_mdsrv in ("
					+ ScSqlUtils.buildIdStr(srvList) + ")");
			sb.append("inner join sc_srv_rel relb on relb.id_scsrv = excl.id_scsrv_b and relb.id_mdsrv = '"
					+ id_srv + "' ");
		}
		return sb;
	}

	/**
	 * 根据服务排斥DO获取间隔时间的秒数
	 *
	 * @param exclDO 服务排斥DO
	 * @return 时间间隔秒数
	 * @throws BizException
	 * @author zhengcm
	 */
	private long getExclSeconds(ScSrvExclDO exclDO) throws BizException {
		IMeasdocRService qryService = ServiceFinder.find(IMeasdocRService.class);
		MeasDocDO docDO = qryService.findById(exclDO.getId_measdoc_period());
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
}
