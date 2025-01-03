package iih.mp.nr.mpwardprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import iih.mp.nr.common.IMpDictCodeConst;
import iih.mp.nr.common.MpUtils;
import iih.mp.nr.common.ParamUtils;
import iih.mp.nr.dto.mpwardprint.d.MpOrPrnPlanSrvDTO;
import iih.mp.nr.dto.mpwardprint.d.WardPrntCondDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import iih.mp.nr.mpwardprint.qry.GetMpOrPrnPlanSrvInfosSql;
import iih.mp.nr.mpwardprint.qry.GetOpMeMpOrPrnPlanSrvInfosSql;
import iih.mp.nr.mpwardprint.qry.GetRoutesSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FType;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 病区执行打印查询服务维度数据 （公共的）
 * 
 * @author fengjj
 * @date 2019年3月15日18:07:21 创建
 * @version: xuxing_2019年5月23日18:49:45，迭代
 * @version xuxing_2019年6月6日13:30:37，增加毒麻过滤，增加仓库过滤
 * @version fengjj_2019年7月8日16:00:17，增加医疗服务过滤
 * @version dukx_2019年8月9日16:00:17，兼容门急诊执行打印
 * @version xuxing_2019年10月9日13:54:16，代码整理，支持医嘱ID二次过滤
 * @version fengjj_2019年10月31日19:06:57,表单设置默认值之后，有的报表没有某些字段导致值为null，
 *          有的没有判断null的情况，做修复
 */
public class GetSrvPlanCommonBp {

	private String tableName = "mp_rpt_or_temp";// 病区执行打印临时表

	/**
	 * 服务计划维度查结果 主入口
	 * 
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public List<MpOrPrnPlanSrvDTO> exec(WardPrntCondDTO param) throws BizException {

		// 1、参数校验 
		if (!validate(param))
			throw new BizException("参数有误！");

		// 2、长临转换
		convertEuLong(param);

		// 3、转换频次
		String[] id_freqs = getFreqs(param);

		// 4、查询数据
		List<MpOrPrnPlanSrvDTO> list = queryData(param, id_freqs);

		// 5、计算年龄、设置报表中描述内容 转换医嘱用法
		List<MpOrPrnPlanSrvDTO> listDatas = cacAge(list);
  		
		return listDatas;
	}

	/**
	 * 参数校验
	 * 
	 * @param paramDTO
	 * @throws BizException
	 */
	private boolean validate(WardPrntCondDTO param) throws BizException {
		if (param == null)
			return false;
		if (StringUtil.isEmptyWithTrim(param.getDt_begin()))
			throw new BizException("查询区间开始时间不能为空！");
		if (StringUtil.isEmptyWithTrim(param.getDt_end()))
			throw new BizException("查询区间结束时间不能为空！");
		if (StringUtil.isEmptyWithTrim(param.getId_ents()) && StringUtil.isEmptyWithTrim(param.getId_pats()))
			throw new BizException("患者id不能为空！");
		if (StringUtil.isEmptyWithTrim(param.getSd_srvtps()))
			throw new BizException("医疗服务类型不能为空！");
		if (StringUtil.isEmptyWithTrim(param.getId_ents()))
			param.setId_ents("");
		if (StringUtil.isEmptyWithTrim(param.getId_pats()))
			param.setId_pats("");
		if (StringUtil.isEmptyWithTrim(param.getId_ors()))
			param.setId_ors("");
		return true;
	}

	/**
	 * 转换长临
	 * 
	 * @param eu_long
	 * @return
	 */
	private void convertEuLong(WardPrntCondDTO param) {
		if ("1".equals(param.getEu_long())) {
			param.setEu_long("Y");
		} else if ("2".equals(param.getEu_long())) {
			param.setEu_long("N");
		} else {
			param.setEu_long("");
		}
	}

	/**
	 * 获取有效频次信息
	 * 
	 * @param param
	 * @return
	 */
	private String[] getFreqs(WardPrntCondDTO param) {
		if (!"True".equals(param.getFg_spec_freq()))
			return null;
		if (StringUtil.isEmptyWithTrim(param.getId_freqs()))
			return null;
		return param.getId_freqs().split("\\,");
	}

	/**
	 * 查询数据
	 * 
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	private List<MpOrPrnPlanSrvDTO> queryData(WardPrntCondDTO param, String[] id_freqs) throws BizException {
		final String entStrs = param.getId_ents();// 就诊id
		final String code_entp = param.getCode_entp();// 就诊类型
		final String sd_srvtps = param.getSd_srvtps();
		final String id_routes = param.getId_routes();
		final String id_dep_whs = StringUtil.isEmptyWithTrim(param.getId_dep_whs()) ? "" : param.getId_dep_whs();
		final String id_srvs = StringUtil.isEmptyWithTrim(param.getId_srvs()) ? "" : param.getId_srvs();
		final String patStrs = param.getId_pats();// 患者id
		final String id_ors = param.getId_ors();// 医嘱id
		FBoolean flag = (FBoolean) new ParamUtils<>().paramValue(param.getId_org(), "MPNR0200");
		final GetMpOrPrnPlanSrvInfosSql sql1 = new GetMpOrPrnPlanSrvInfosSql(this.tableName, param, id_freqs, flag);
		final GetOpMeMpOrPrnPlanSrvInfosSql sql2 = new GetOpMeMpOrPrnPlanSrvInfosSql(this.tableName, param, id_freqs);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<MpOrPrnPlanSrvDTO>>() {
				@SuppressWarnings("unchecked")
				public List<MpOrPrnPlanSrvDTO> doInTransaction(TransactionStatus status) {
					try {
						List<MpOrPrnPlanSrvDTO> reList = new ArrayList<>();
						if ("10".equals(code_entp)) {// 病区执行打印通用查询服务
							createTempTable(code_entp, "", entStrs, sd_srvtps, id_routes, id_dep_whs, id_srvs, id_ors, tableName);// 创建临时表
							reList = (List<MpOrPrnPlanSrvDTO>) new DAFacade().execQuery(sql1.getQrySQLStr(), sql1.getQryParameter(null), new BeanListHandler(MpOrPrnPlanSrvDTO.class));
						} else if ("00".equals(code_entp)) {// 门急诊执行打印通用查询服务
							createTempTable(code_entp, patStrs, "", sd_srvtps, id_routes, id_dep_whs, id_srvs, id_ors, tableName);// 创建临时表
							reList = (List<MpOrPrnPlanSrvDTO>) new DAFacade().execQuery(sql2.getQrySQLStr(), sql2.getQryParameter(null), new BeanListHandler(MpOrPrnPlanSrvDTO.class));
						}
						return reList;
					} catch (Exception e) {
						return null;
					}
				}
			});
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 创建临时表
	 * 
	 * @param id_ents
	 * @param sd_srvtps
	 * @return
	 * @throws BizException
	 */
	private String createTempTable(String code_entp, String id_pats, String id_ents, String sd_srvtps, String id_routes, String id_dep_whs, String id_srvs, String id_ors, String tableName)
			throws BizException {
		TamTableColumnDTO[] columns = new TamTableColumnDTO[7];
		columns[0] = MpUtils.getTemtableColumn("Id_ent", "VARCHAR2(20)", FType.String);
		columns[1] = MpUtils.getTemtableColumn("Sd_srvtp", "VARCHAR2(50)", FType.String);
		columns[2] = MpUtils.getTemtableColumn("Id_route", "VARCHAR2(20)", FType.String);
		columns[3] = MpUtils.getTemtableColumn("Id_dep_whs", "VARCHAR2(20)", FType.String);
		columns[4] = MpUtils.getTemtableColumn("Id_srv", "VARCHAR2(20)", FType.String);
		columns[5] = MpUtils.getTemtableColumn("Id_pat", "VARCHAR2(20)", FType.String);
		columns[6] = MpUtils.getTemtableColumn("Id_or", "VARCHAR2(20)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		String[] ents = id_ents.split("\\,");
		String[] srvtps = sd_srvtps.split("\\,");
		String[] routes = id_routes.split("\\,");
		String[] depwhs = id_dep_whs.split("\\,");
		String[] srvs = id_srvs.split("\\,");
		String[] pats = id_pats.split("\\,");
		String[] ors = id_ors.split("\\,");
		int lenMax = ents.length;
		if (srvtps.length > lenMax)
			lenMax = srvtps.length;
		if (srvtps.length > lenMax)
			lenMax = srvtps.length;
		if (routes.length > lenMax)
			lenMax = routes.length;
		if (depwhs.length > lenMax)
			lenMax = depwhs.length;
		if (srvs.length > lenMax)
			lenMax = srvs.length;
		if (pats.length > lenMax)
			lenMax = pats.length;
		if (ors.length > lenMax)
			lenMax = ors.length;
		for (int i = 0; i < lenMax; i++) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1("~");
			param.setColumn2("~");
			param.setColumn3("~");
			param.setColumn4("~");
			param.setColumn5("~");
			param.setColumn6("~");
			param.setColumn7("~");
			if (ents.length >= i + 1 && !StringUtil.isEmptyWithTrim(ents[i]))
				param.setColumn1(ents[i]);
			if (srvtps.length >= i + 1 && !StringUtil.isEmptyWithTrim(srvtps[i]))
				param.setColumn2(srvtps[i]);
			if (routes.length >= i + 1 && !StringUtil.isEmptyWithTrim(routes[i]))
				param.setColumn3(routes[i]);
			if (depwhs.length >= i + 1 && !StringUtil.isEmptyWithTrim(depwhs[i]))
				param.setColumn4(depwhs[i]);
			if (srvs.length >= i + 1 && !StringUtil.isEmptyWithTrim(srvs[i]))
				param.setColumn5(srvs[i]);
			if (pats.length >= i + 1 && !StringUtil.isEmptyWithTrim(pats[i]))
				param.setColumn6(pats[i]);
			if (ors.length >= i + 1 && !StringUtil.isEmptyWithTrim(ors[i]))
				param.setColumn7(ors[i]);
			listData.add(param);
		}
		MpUtils.createTemTable(tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}

	/**
	 * 计算年龄、设置报表中描述内容
	 * 
	 * @param listDatas
	 * @return
	 * @throws BizException 
	 */
	private List<MpOrPrnPlanSrvDTO> cacAge(List<MpOrPrnPlanSrvDTO> listDatas) throws BizException {
		if (listDatas == null || listDatas.size() == 0)
			return null;
		List<String> list = new ArrayList<String>();
		for (MpOrPrnPlanSrvDTO MpOrPrnPlanSrvDTO : listDatas) {
			if (!StringUtil.isEmptyWithTrim(MpOrPrnPlanSrvDTO.getId_routedes())) {
				if (!list.contains(MpOrPrnPlanSrvDTO.getId_or())) {
					list.add(MpOrPrnPlanSrvDTO.getId_or());
				}
			}
			if (StringUtil.isEmptyWithTrim(MpOrPrnPlanSrvDTO.getDt_birth_pat()))
				MpOrPrnPlanSrvDTO.setAge("不详");
			else
				MpOrPrnPlanSrvDTO.setAge(AgeCalcUtil.getAge(new FDate(MpOrPrnPlanSrvDTO.getDt_birth_pat())));
			MpOrPrnPlanSrvDTO.setName_grp(MpOrPrnPlanSrvDTO.getName_bed() + "床      " + MpOrPrnPlanSrvDTO.getName_pat());
			// 转换时间显示格式
			if (MpOrPrnPlanSrvDTO.getDt_mp_plan() != null) {
				FDateTime dt_mp_plan = new FDateTime(MpOrPrnPlanSrvDTO.getDt_mp_plan());
				int hour = dt_mp_plan.getHour();
				String trg = "AM";
				if (hour > 12)
					trg = "PM";
				MpOrPrnPlanSrvDTO.setDt_hour(hour + " " + trg);
			}
			// 设置报表中显示的内容
			String rptDes = "";
			if ("Y".equals(MpOrPrnPlanSrvDTO.getFg_skintest()))
				rptDes = "★：皮试";
			if (MpOrPrnPlanSrvDTO.getDes_or() != null)
				rptDes += rptDes.length() == 0 ? "备注:" + MpOrPrnPlanSrvDTO.getDes_or() : "<br/>备注:" + MpOrPrnPlanSrvDTO.getDes_or();
			MpOrPrnPlanSrvDTO.setRpt_des(rptDes);
			if (IMpDictCodeConst.SD_ABRD.equals(MpOrPrnPlanSrvDTO.getSd_abrd()))
				MpOrPrnPlanSrvDTO.setSd_abrd("（进口）");
			else
				MpOrPrnPlanSrvDTO.setSd_abrd("");
		}
		if (list.size() > 0)
			queryList(list, listDatas);
		return listDatas;
	}

	/**
	 * 获取医嘱执行用法
	 * 
	 * @param list
	 * @param listDatas
	 */
	private void queryList(List<String> list, List<MpOrPrnPlanSrvDTO> listDatas) throws BizException{
		//获取需要行转列的数据集合
		HashMap<String, String> map = new HashMap<String, String>();
		GetRoutesSql sql = new GetRoutesSql(list.toArray(new String[0]));
		List<MpOrPrnPlanSrvDTO> srvDTOs = (List<MpOrPrnPlanSrvDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MpOrPrnPlanSrvDTO.class));
		if(srvDTOs==null||srvDTOs.size()<1)
			return;
		for (MpOrPrnPlanSrvDTO MpOrPrnPlanSrvDTO : srvDTOs) {
			if (!StringUtil.isEmptyWithTrim(MpOrPrnPlanSrvDTO.getName_routedes())) {
				if (!map.containsKey(MpOrPrnPlanSrvDTO.getId_or())) {
					map.put(MpOrPrnPlanSrvDTO.getId_or(), MpOrPrnPlanSrvDTO.getName_routedes());
				}
			}
		}
		//给页面展示的数据赋值
		for (MpOrPrnPlanSrvDTO MpOrPrnPlanSrvDTO : listDatas) {
			if (map.containsKey(MpOrPrnPlanSrvDTO.getId_or())) {
				MpOrPrnPlanSrvDTO.setName_routedes(map.get(MpOrPrnPlanSrvDTO.getId_or()));
			}
		}
	}

}
