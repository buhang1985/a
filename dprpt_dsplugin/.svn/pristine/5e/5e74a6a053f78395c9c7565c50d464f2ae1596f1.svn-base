package iih.mp.nr.wardprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.common.WardPrintUtils;
import iih.mp.nr.dto.LiquidCheckDTO;
import iih.mp.nr.dto.PatLiquidCheckdDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import iih.mp.nr.qry.GetPatExeListSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FType;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 执行单逻辑
 * 
 * @ClassName: GetPatExeListInfoBp
 * @Description: TODO
 * @author Fengjj
 * @date 2018年8月31日 下午1:40:51 创建
 * @version xuxing_2018年9月17日16:30:40，迭代
 */
public class GetPatExeListInfoBp {

	/**
	 * 主入口
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param eu_long
	 * @param id_routes
	 * @param sd_srvtps
	 * @param fg_unfold
	 * @param no_spec_fre
	 * @param fg_fre
	 * @return
	 * @throws DAException
	 */
	public List<PatLiquidCheckdDTO> exec(String id_ents, String dt_begin, String dt_end, String eu_long, String id_routes, String sd_srvtps, String fg_unfold, String no_spec_fre, String fg_fre) throws DAException {

		// 1、数据校验
		if (!validation(id_ents, dt_begin, dt_end, sd_srvtps, id_routes, fg_unfold))
			return null;

		// 2、获取用法
		String[] routes = null;
		if (!StringUtil.isEmptyWithTrim(id_routes))
			routes = id_routes.split(",");

		// 3、转换长临
		String fg_long = getFgLong(eu_long);

		// 4、处理非特殊频次情况
		if (!Boolean.parseBoolean(fg_fre))
			no_spec_fre = "";

		// 5、查询数据
		List<LiquidCheckDTO> listDatas = queryData(id_ents, sd_srvtps, dt_begin, dt_end, fg_long, routes, no_spec_fre);

		// 6、数据分组
		HashMap<String, List<String>> mapDtPlan = new HashMap<String, List<String>>();
		LinkedHashMap<String, PatLiquidCheckdDTO> mapRtn = WardPrintUtils.groupData(listDatas, mapDtPlan, Boolean.parseBoolean(fg_unfold));

		// 7、处理返回值
		List<PatLiquidCheckdDTO> rtns = WardPrintUtils.handleRtn(mapRtn, mapDtPlan);

		return rtns;
	}

	/**
	 * 数据校验
	 *
	 */
	private boolean validation(String id_ents, String dt_begin, String dt_end, String sd_srvtps, String id_routes, String fg_unfold) {
		if (StringUtil.isEmptyWithTrim(id_ents))
			return false;
		if (id_ents.split("\\,").length < 1)
			return false;
		if (StringUtil.isEmptyWithTrim(dt_begin))
			return false;
		if (StringUtil.isEmptyWithTrim(dt_end))
			return false;
		if (StringUtil.isEmptyWithTrim(sd_srvtps))
			return false;
		if (sd_srvtps.split("\\,").length < 1)
			return false;
		if (fg_unfold == null)
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
	 */
	private List<LiquidCheckDTO> queryData(String id_ents, String sd_srvtps, String dt_begin, String dt_end, String fg_long, String[] routes, String no_spec_fre) {
		final String entStrs = id_ents;
		final String srvtpStrs = sd_srvtps;
		final GetPatExeListSql sql = new GetPatExeListSql(dt_begin, dt_end, routes, fg_long, no_spec_fre);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<LiquidCheckDTO>>() {
				@SuppressWarnings("unchecked")
				public List<LiquidCheckDTO> doInTransaction(TransactionStatus status) {
					try {
						String nameTable = createTempTable(entStrs, srvtpStrs);// 创建临时表
						sql.setTemTableName(nameTable);
						List<LiquidCheckDTO> reList = (List<LiquidCheckDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), null, new BeanListHandler(LiquidCheckDTO.class));
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
	 * @return
	 * @throws BizException
	 */
	private String createTempTable(String id_ents, String sd_srvtps) throws BizException {
		TamTableColumnDTO[] columns = new TamTableColumnDTO[3];
		columns[0] = MpUtils.getTemtableColumn("Id_ent", "VARCHAR2(20)", FType.String);
		columns[1] = MpUtils.getTemtableColumn("Sd_srvtp", "VARCHAR2(50)", FType.String);
		columns[2] = MpUtils.getTemtableColumn("Id_route", "VARCHAR2(20)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		String[] ents = id_ents.split("\\,");
		String[] srvtps = sd_srvtps.split("\\,");
		int length = ents.length > srvtps.length ? ents.length : srvtps.length;// 两个数组中大的那个长度
		for (int i = 0; i < length; i++) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1("~");
			param.setColumn2("~");
			param.setColumn3("~");
			if (ents.length >= i + 1)
				param.setColumn1(ents[i]);
			if (srvtps.length >= i + 1)
				param.setColumn2(srvtps[i]);
			listData.add(param);
		}
		String tableName = "mp_rpt_or_temp";
		MpUtils.createTemTable(tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}

}
