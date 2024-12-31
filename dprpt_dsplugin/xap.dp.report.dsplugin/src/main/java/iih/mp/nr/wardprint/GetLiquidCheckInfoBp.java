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
import iih.mp.nr.qry.GetLiquidCheckSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FType;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 液体核对卡
 * 
 * @ClassName: GetLiquidCheckInfoBp
 * @Description: TODO
 * @author Fengjj
 * @date 2018年8月31日 下午5:58:58 修改 --与执行卡通用数据处理的逻辑
 */
public class GetLiquidCheckInfoBp {

	/**
	 * 主入口
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param fg_unfold
	 * @param sd_srvtps
	 * @param id_routes
	 * @return
	 * @throws BizException
	 */
	public List<PatLiquidCheckdDTO> exec(String id_ents, String dt_begin, String dt_end, String fg_unfold, String sd_srvtps, String id_routes) throws BizException {

		// 1、基础校验
		if (!validation(id_ents, dt_begin, dt_end, sd_srvtps, id_routes))
			return null;

		// 2、查询数据
		List<LiquidCheckDTO> listDatas = queryData(id_ents, dt_begin, dt_end, sd_srvtps.split("\\,"), id_routes.split("\\,"));

		// 3.数据分组
		HashMap<String, List<String>> mapDtPlan = new HashMap<String, List<String>>();
		LinkedHashMap<String, PatLiquidCheckdDTO> mapRtn = WardPrintUtils.groupData(listDatas, mapDtPlan, Boolean.parseBoolean(fg_unfold));

		// 4、处理返回值
		List<PatLiquidCheckdDTO> rtns = WardPrintUtils.handleRtn(mapRtn, mapDtPlan);

		return rtns;
	}

	/**
	 * 数据校验
	 * 
	 * @param id_ents
	 * @param dt_selected
	 * @param id_routes
	 * @return
	 */
	private boolean validation(String id_ents, String dt_begin, String dt_end, String sd_srvtps, String id_routes) {
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
		if (StringUtil.isEmptyWithTrim(id_routes))
			return false;
		return true;
	}

	/**
	 * 查询数据
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param id_routes
	 * @return
	 */
	private List<LiquidCheckDTO> queryData(String id_ents, String dt_begin, String dt_end, String[] sd_srvtps, String[] id_routes) {
		final String entStrs = id_ents;
		final String[] srvtps = sd_srvtps;
		final String[] routes = id_routes;
		final GetLiquidCheckSql sql = new GetLiquidCheckSql(dt_begin, dt_end);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<LiquidCheckDTO>>() {
				@SuppressWarnings("unchecked")
				public List<LiquidCheckDTO> doInTransaction(TransactionStatus status) {
					try {
						String nameTable = createTempTable(entStrs, srvtps, routes);// 创建临时表
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
	private String createTempTable(String id_ents, String[] srvtps, String[] routes) throws BizException {
		TamTableColumnDTO[] columns = new TamTableColumnDTO[3];
		columns[0] = MpUtils.getTemtableColumn("Id_ent", "VARCHAR2(20)", FType.String);
		columns[1] = MpUtils.getTemtableColumn("Sd_srvtp", "VARCHAR2(50)", FType.String);
		columns[2] = MpUtils.getTemtableColumn("Id_route", "VARCHAR2(20)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		String[] ents = id_ents.split("\\,");
		int len = ents.length;
		if (srvtps.length > len)
			len = srvtps.length;
		if (routes != null && routes.length > len)
			len = routes.length;
		for (int i = 0; i < len; i++) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1("~");
			param.setColumn2("~");
			param.setColumn3("~");
			if (ents.length >= i + 1)
				param.setColumn1(ents[i]);
			if (srvtps.length >= i + 1)
				param.setColumn2(srvtps[i]);
			if (routes != null && routes.length >= i + 1)
				param.setColumn3(routes[i]);
			listData.add(param);
		}
		String tableName = "mp_rpt_or_temp";
		MpUtils.createTemTable(tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}
}
