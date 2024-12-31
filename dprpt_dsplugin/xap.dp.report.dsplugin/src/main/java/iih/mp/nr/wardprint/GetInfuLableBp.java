package iih.mp.nr.wardprint;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.dto.MpOrPrDTO;
import iih.mp.nr.dto.infulable.d.InfuDrugInfoDTO;
import iih.mp.nr.dto.infulable.d.InfuLableDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import iih.mp.nr.qry.GetInfuLableSql;
import iih.mp.nr.qry.GetMporPrSql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FType;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @Description:输液贴查询逻辑
 * @author: xu_xing@founder.com.cn
 * @version：2018年8月28日 上午10:04:42 创建
 * @version xuxing_2018年9月20日18:07:00,输液贴增加剂量显示
 * @version hjh _2019年9月25日17:29:36优化输液贴查询逻辑  静配特殊逻辑放到sql里处理(union方式)
 */
public class GetInfuLableBp {

	/**
	 * 主入口
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param eu_long
	 * @param id_routes
	 * @return
	 * @throws BizException
	 */
	public List<InfuLableDTO> exec(String id_ents, String dt_begin, String dt_end, String eu_long, String eu_prnt, String id_routes, String fg_pois, String paramcode) throws BizException {

		// 1、基础校验
		if (!validation(id_ents, dt_begin, dt_end, id_routes))
			return null;

		// 2、转换长临
		String fg_long = getFgLong(eu_long);

		// 2.1 获取静配参数id主键：0001Z8100000000007NJ
		// String id_dep_wh = "0001Z8100000000007NJ";
		// 查询执行计划数据
		List<MpOrPrDTO> orprList = queryMporprData(id_ents, dt_begin, dt_end, fg_long, paramcode,eu_prnt, id_routes.split("\\,"));

		// 3、查询数据
		List<InfuLableDTO> listDatas = queryData(orprList,fg_pois, paramcode);

		// 4、判断listDatas如果过滤静配的药，需要单独查询静配的药品
		//listDatas = findSpecial(listDatas, id_ents, dt_begin, dt_end, fg_long, eu_prnt, id_routes, fg_pois, paramcode);

		// 5、数据分组
		List<InfuLableDTO> rtns = packageRtns(listDatas);

		// 6、数据拼接
		handleData(rtns);

		return rtns;
	}

	/**
	 * 查询执行计划
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param fg_long
	 * @param eu_prnt
	 * @return
	 */
	private List<MpOrPrDTO> queryMporprData(String id_ents, String dt_begin, String dt_end, String fg_long, String paramcode,String eu_prnt, String[] id_routes) {

		final String entStrs = id_ents;
		final String[] routes = id_routes;
		final GetMporPrSql sql = new GetMporPrSql(dt_begin, dt_end, fg_long, paramcode,eu_prnt);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<MpOrPrDTO>>() {
				@SuppressWarnings("unchecked")
				public List<MpOrPrDTO> doInTransaction(TransactionStatus status) {
					try {
						String nameTable = createTempTable(entStrs, routes);// 创建临时表
						sql.setTemTableName(nameTable);
						String qrySQLStr = sql.getQrySQLStr();
						List<MpOrPrDTO> reList = (List<MpOrPrDTO>) new DAFacade().execQuery(qrySQLStr, sql.getQryParameter(null), new BeanListHandler(MpOrPrDTO.class));
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
	 * 基础校验
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param eu_long
	 * @return
	 */
	private boolean validation(String id_ents, String dt_begin, String dt_end, String id_routes) {
		if (StringUtil.isEmptyWithTrim(id_ents))
			return false;
		if (id_ents.split("\\,").length < 1)
			return false;
		if (StringUtil.isEmptyWithTrim(dt_begin))
			return false;
		if (StringUtil.isEmptyWithTrim(dt_end))
			return false;
		if (StringUtil.isEmptyWithTrim(id_routes))
			return false;
		return true;
	}

	/**
	 * 转换长临
	 * 
	 * @param eu_long
	 * @return
	 */
	private String getFgLong(String eu_long) {
		if (eu_long.equals("1"))
			return "Y";
		if (eu_long.equals("2"))
			return "N";
		return null;
	}

	/**
	 * 查询数据
	 * 
	 * @param orprList
	 * 
	 * @param id_ents
	 * @param sd_srvtps
	 * @param dt_begin
	 * @param dt_end
	 * @param fg_long
	 * @param id_routes
	 * @return
	 * @throws Exception
	 */
	private List<InfuLableDTO> queryData(List<MpOrPrDTO> orprList,  String fg_pois, String paramcode) throws BizException {
		final List<MpOrPrDTO> orPrList = orprList;
		final GetInfuLableSql sql = new GetInfuLableSql( fg_pois, paramcode);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<InfuLableDTO>>() {
				@SuppressWarnings("unchecked")
				public List<InfuLableDTO> doInTransaction(TransactionStatus status) {
					try {
						String orprNameTable = createOrprTempTable(orPrList);
						sql.setOrprTemp(orprNameTable);
						String qrySQLStr = sql.getQrySQLStr();
						List<InfuLableDTO> reList = (List<InfuLableDTO>) new DAFacade().execQuery(qrySQLStr, sql.getQryParameter(null), new BeanListHandler(InfuLableDTO.class));
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
	 * 判断listDatas如果过滤静配的药，需要单独查询静配的药品
	 * 
	 * @param listDatas
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param fg_long
	 * @param eu_prnt
	 * @param id_routes
	 * @param fg_pois
	 * @param paramcode
	 * @return
	 * @throws BizException
	 */
//	private List<InfuLableDTO> findSpecial(List<InfuLableDTO> listDatas, String id_ents, String dt_begin, String dt_end, String fg_long, String eu_prnt, String id_routes, String fg_pois, String paramcode) throws BizException {
//		if (!StringUtil.isEmptyWithTrim(paramcode)) {
//			// 1、 查询长期医嘱第二天的数据(因为第一天没有数据，所以dt_e为dt_end之后一天,赋值给dt_mp_plan)
//			FDateTime dt_afterEnd = new FDateTime(dt_end);
//			FDateTime dt_e = dt_afterEnd.getDateTimeAfter(1);
//			List<MpOrPrDTO> orprList = queryMporprData(id_ents, dt_begin, dt_e.toString(), fg_long, eu_prnt, id_routes.split("\\,"));
//			List<InfuLableDTO> secondDayDatas = querySecondDayData(orprList, dt_begin, dt_end,  fg_pois, paramcode);
//
//			// 2、 过滤第二天的数据医嘱开立时间相差计划执行时间1天,与listDatas合并
//			listDatas = addToList(listDatas, secondDayDatas);
//		}
//		return listDatas;
//	}

	/**
	 * 查询长期医嘱第二天的数据
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param fg_long
	 * @param eu_prnt
	 * @param id_routes
	 * @param fg_pois
	 * @param paramcode
	 * @return
	 * @throws BizException
	 */
//	private List<InfuLableDTO> querySecondDayData(List<MpOrPrDTO> orprList,String dt_begin, String dt_end, String fg_pois, String paramcode) throws BizException {
//		final List<MpOrPrDTO> orPrList = orprList;
//		final GetInfuLable2Sql sql = new GetInfuLable2Sql(dt_begin, dt_end,fg_pois, paramcode);
//		try {
//			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<InfuLableDTO>>() {
//				@SuppressWarnings("unchecked")
//				public List<InfuLableDTO> doInTransaction(TransactionStatus status) {
//					try {
//						String orprNameTable = createOrprTempTable(orPrList);
//						sql.setOrprTemp(orprNameTable);
//						String qrySQLStr = sql.getQrySQLStr();
//						List<InfuLableDTO> reList = (List<InfuLableDTO>) new DAFacade().execQuery(qrySQLStr, sql.getQryParameter(null), new BeanListHandler(InfuLableDTO.class));
//						return reList;
//					} catch (Exception e) {
//						return null;
//					}
//				}
//			});
//		} catch (Exception e) {
//			return null;
//		}
//	}

	/**
	 * 过滤第二天的数据医嘱开立时间相差计划执行时间1天,与listDatas合并
	 * 
	 * @param listDatas
	 * @param secondDayDatas
	 * @return
	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	private List<InfuLableDTO> addToList(List<InfuLableDTO> listDatas, List<InfuLableDTO> secondDayDatas) {
//		for (InfuLableDTO dto : secondDayDatas) {
//			if (FDateTime.getDaysBetween(new FDate(dto.getDt_effe()), new FDate(dto.getDt_mp_plan())) == 1) {
//				FDateTime dt_mp_plan = new FDateTime(dto.getDt_mp_plan()).getDateTimeBefore(1);
//				String dt_new = dt_mp_plan.toString();
//				dto.setDt_mp_plan(dt_new);
//				listDatas.add(dto);
//			}
//		}
//		// 排序
//		Collections.sort(listDatas, new Comparator() {
//			@Override
//			public int compare(Object o1, Object o2) {
//				String[] arrs = new String[] { "Name_bed", "Dt_mp_plan", "Name" };
//				int i = 0;
//				for (String arr : arrs) {
//					if (arr.equals("Name_bed")) {
//						InfuLableDTO e1 = (InfuLableDTO) o1;
//						InfuLableDTO e2 = (InfuLableDTO) o2;
//						i = e1.getName_bed().compareTo(e2.getName_bed());
//						if (i != 0) {
//							break;
//						}
//					}
//					if (arr.equals("Dt_mp_plan")) {
//						InfuLableDTO e1 = (InfuLableDTO) o1;
//						InfuLableDTO e2 = (InfuLableDTO) o2;
//						i = e1.getDt_mp_plan().compareTo(e2.getDt_mp_plan());
//						if (i != 0) {
//							break;
//						}
//					}
//					if (arr.equals("Name")) {
//						InfuLableDTO e1 = (InfuLableDTO) o1;
//						InfuLableDTO e2 = (InfuLableDTO) o2;
//						i = e1.getName().compareTo(e2.getName());
//						if (i != 0) {
//							break;
//						}
//					}
//				}
//				return i;
//			}
//		});
//		return listDatas;
//	}

	/**
	 * 创建临时表
	 * 
	 * @param id_ents
	 * @param sd_srvtps
	 * @return
	 * @throws BizException
	 */
	private String createTempTable(String id_ents, String[] id_routes) throws BizException {
		TamTableColumnDTO[] columns = new TamTableColumnDTO[3];
		columns[0] = MpUtils.getTemtableColumn("Id_ent", "VARCHAR2(20)", FType.String);
		columns[1] = MpUtils.getTemtableColumn("Sd_srvtp", "VARCHAR2(50)", FType.String);
		columns[2] = MpUtils.getTemtableColumn("Id_route", "VARCHAR2(20)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		String[] ents = id_ents.split("\\,");
		int length = ents.length;
		if (length < id_routes.length)
			length = id_routes.length;
		for (int i = 0; i < length; i++) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1("~");
			param.setColumn2("~");
			param.setColumn3("~");
			if (ents.length > i)
				param.setColumn1(ents[i]);
			if (id_routes.length > i)
				param.setColumn3(id_routes[i]);
			listData.add(param);
		}
		String tableName = "mp_rpt_or_temp";
		MpUtils.createTemTable(tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}

	/**
	 * 创建执行计划临时表
	 * 
	 * @param id_ents
	 * @param sd_srvtps
	 * @return
	 * @throws BizException
	 */
	private String createOrprTempTable(List<MpOrPrDTO> orprList) throws BizException {

		TamTableColumnDTO[] columns = new TamTableColumnDTO[4];
		columns[0] = MpUtils.getTemtableColumn("Id_or", "VARCHAR2(20)", FType.String);
		columns[1] = MpUtils.getTemtableColumn("Id_or_pr", "VARCHAR2(20)", FType.String);
		columns[2] = MpUtils.getTemtableColumn("Dt_mp_plan", "CHAR(19)", FType.String);
		columns[3] = MpUtils.getTemtableColumn("No_bar", "VARCHAR2(20)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		for (MpOrPrDTO mpOrPrDTO : orprList) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1(mpOrPrDTO.getId_or());
			param.setColumn2(mpOrPrDTO.getId_or_pr());
			param.setColumn3(mpOrPrDTO.getDt_mp_plan());
			param.setColumn4(mpOrPrDTO.getNo_bar());
			listData.add(param);
		}

		String tableName = "mp_or_pr_rpt_temp";
		MpUtils.createTemTable(tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}

	/**
	 * 组装输液贴数据
	 * 
	 * @param rtns
	 * @return
	 */
	private List<InfuLableDTO> packageRtns(List<InfuLableDTO> rtns) {
		List<InfuLableDTO> reList = new ArrayList<InfuLableDTO>();
		if (rtns != null && rtns.size() > 0) {
			HashMap<String, InfuLableDTO> mapInfu = new HashMap<String, InfuLableDTO>();
			for (InfuLableDTO rtn : rtns) {
				// 记录当前操作的输液贴
				InfuLableDTO lable = null;
				if (!mapInfu.containsKey(rtn.getId_or_pr())) {
					// 转换时间显示格式
					FDateTime dt_mp_plan = new FDateTime(rtn.getDt_mp_plan());
					// rtn.setDt_mp_plan(dt_mp_plan.getDate().toLocalString());
					int hour = dt_mp_plan.getHour();
					String trg = "AM";
					if (hour > 12)
						trg = "PM";
					rtn.setDt_hour(hour + " " + trg);
					mapInfu.put(rtn.getId_or_pr(), rtn);
					reList.add(rtn);
				}
				lable = mapInfu.get(rtn.getId_or_pr());
				InfuDrugInfoDTO drug = new InfuDrugInfoDTO();
				drug.setId_orsrv(rtn.getId_orsrv());
				drug.setName(rtn.getName());
				drug.setSpec(rtn.getSpec());
				drug.setQuan_medu(rtn.getQuan_medu());
				drug.setName_measdoc(rtn.getName_measdoc());
				drug.setFg_highrisk(rtn.getFg_highrisk());
				if (StringUtils.isNotBlank(rtn.getDes_or())) {
					drug.setDes_or("(" + rtn.getDes_or() + ")");
				} else {
					drug.setDes_or("");
				}
				if (lable.getArraydrugs() == null)
					lable.setArraydrugs(new ArrayList<InfuDrugInfoDTO>());
				lable.getArraydrugs().add(drug);
			}
		}
		return reList;
	}

	/**
	 * 数据拼接
	 * 
	 * @param rtns
	 */
	private void handleData(List<InfuLableDTO> rtns) {
		if (rtns != null && rtns.size() > 0) {
			for (InfuLableDTO infuLableDTO : rtns) {
				List<InfuDrugInfoDTO> list = infuLableDTO.getArraydrugs();
				String name = "";
				for (InfuDrugInfoDTO drugDTO : list) {
					name += ((StringUtil.isEmptyWithTrim(name)) ? "" : "<br/>") + (drugDTO.getName() + (StringUtil.isEmptyWithTrim(drugDTO.getSpec()) ? "" : ("*" + drugDTO.getSpec())) + "*" + drugDTO.getQuan_medu() + drugDTO.getName_measdoc());
					// name += ((StringUtil.isEmptyWithTrim(name)) ? "" :
					// "<br/>") + (drugDTO.getName() + "*" +
					// drugDTO.getQuan_medu() + drugDTO.getName_measdoc());
					name = ("Y".equals(drugDTO.getFg_highrisk())?"☆":"")+name;
				}
				infuLableDTO.setName(name + ((StringUtil.isEmptyWithTrim(infuLableDTO.getDes_or())) ? "" : infuLableDTO.getDes_or()));
			}
		}
	}
}
