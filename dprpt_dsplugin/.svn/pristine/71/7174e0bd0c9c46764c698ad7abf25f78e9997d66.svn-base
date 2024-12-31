package iih.mp.nr.wardprint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.dto.HerbalLabelDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import iih.mp.nr.qry.GetHerbalLabelSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FType;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 草药签
 * 
 * @Description:
 * @author: xu_xing@founder.com.cn
 * @version：2018年9月19日 下午6:09:41 迭代
 */
public class GetHearbalLabelBp {

	/**
	 * 主入口
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param ct_print
	 * @return
	 */
	public List<HerbalLabelDTO> exec(String id_ents, String dt_begin, String dt_end, String eu_prnt) {

		// 1.基础校验
		if (!validation(id_ents, dt_begin, dt_end, eu_prnt))
			return null;

		// 2.查询数据
		List<HerbalLabelDTO> list = queryData(id_ents, dt_begin, dt_end, eu_prnt);

		// 3.解析草药签数据
		List<HerbalLabelDTO> rtn = GetHerbalLabelData(list);

		return rtn;
	}

	/**
	 * 数据校验
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param ct_print
	 * @return
	 */
	private boolean validation(String id_ents, String dt_begin, String dt_end, String ct_print) {
		if (StringUtil.isEmptyWithTrim(id_ents))
			return false;
		if (id_ents.split("\\,").length < 1)
			return false;
		if (StringUtil.isEmptyWithTrim(dt_begin))
			return false;
		if (StringUtil.isEmptyWithTrim(dt_end))
			return false;
		if (StringUtil.isEmptyWithTrim(ct_print))
			return false;
		return true;

	}

	/**
	 * 查询数据
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param ct_print
	 * @return
	 */
	private List<HerbalLabelDTO> queryData(String id_ents, String dt_begin, String dt_end, String ct_print) {
		final String entStrs = id_ents;
		final GetHerbalLabelSql sql = new GetHerbalLabelSql(dt_begin, dt_end, ct_print);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<HerbalLabelDTO>>() {
				@SuppressWarnings("unchecked")
				public List<HerbalLabelDTO> doInTransaction(TransactionStatus status) {
					try {
						String nameTable = createTempTable(entStrs);// 创建临时表
						sql.setTemTableName(nameTable);
						String qrySQLStr = sql.getQrySQLStr();
						List<HerbalLabelDTO> reList = (List<HerbalLabelDTO>) new DAFacade().execQuery(qrySQLStr, sql.getQryParameter(null), new BeanListHandler(HerbalLabelDTO.class));
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
	private String createTempTable(String id_ents) throws BizException {
		TamTableColumnDTO[] columns = new TamTableColumnDTO[2];
		columns[0] = MpUtils.getTemtableColumn("Id_ent", "VARCHAR2(20)", FType.String);
		columns[1] = MpUtils.getTemtableColumn("Sd_srvtp", "VARCHAR2(50)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		String[] ents = id_ents.split("\\,");
		for (String id_ent : ents) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1(id_ent);
			param.setColumn2("~");
			listData.add(param);
		}
		String tableName = "mp_rpt_or_temp";
		MpUtils.createTemTable(tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}

	/**
	 * 解析草药签数据
	 * 
	 * @param list
	 * @return
	 */
	private List<HerbalLabelDTO> GetHerbalLabelData(List<HerbalLabelDTO> list) {
		if (list == null || list.isEmpty())
			return null;
		for (HerbalLabelDTO dto : list) {
			if (dto.getContent_or() != null) {
				String[] split = dto.getContent_or().split("\\|");
				// 草药剂数
				dto.setCounts(split[1]);
				// 药品明细
				String drugs = split[2].replace("&", " ").replace("^", "；");
				dto.setDrug_list(drugs);
				// 总价
				String[] split2 = split[3].split("&");
				dto.setPrice(split2[3]);
			}
		}
		return list;
	}
}
