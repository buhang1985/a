package iih.mp.nr.wardprint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import iih.mp.nr.dto.testlable.d.TestLableDTO;
import iih.mp.nr.qry.GetTestLableSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FType;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @Description:获取检验标签信息
 * @author: xu_xing@founder.com.cn
 * @version：2018年8月28日 下午1:34:29 创建
 */
public class GetTestLableInfoBp {

	/**
	 * 主入口
	 * @param id_ents
	 * @param fg_prnt
	 * @param id_samtps
	 * @return
	 * @throws BizException
	 */
	public List<TestLableDTO> exec(String id_ents, String fg_prnt, String samtps) throws BizException {

		// 1、基础校验
		if (!validation(id_ents))
			return null;

		// 2、标签类型
		String[] id_samtps = null;
		if (!StringUtil.isEmptyWithTrim(samtps))
			id_samtps = samtps.split("\\,");

		// 3、查询数据
		List<TestLableDTO> listDatas = queryData(id_ents, fg_prnt, id_samtps);

		return listDatas;
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
	private boolean validation(String id_ents) {
		if (StringUtil.isEmptyWithTrim(id_ents))
			return false;
		if (id_ents.split("\\,").length < 1)
			return false;
		return true;
	}

	/**
	 * 查询数据
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
	private List<TestLableDTO> queryData(String id_ents, String fg_prnt, String[] id_samtps) throws BizException {
		final String entStrs = id_ents;
		final GetTestLableSql sql = new GetTestLableSql(fg_prnt, id_samtps);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<TestLableDTO>>() {
				@SuppressWarnings("unchecked")
				public List<TestLableDTO> doInTransaction(TransactionStatus status) {
					try {
						String nameTable = createTempTable(entStrs);// 创建临时表
						sql.setTemTableName(nameTable);
						String qrySQLStr = sql.getQrySQLStr();
						List<TestLableDTO> reList = (List<TestLableDTO>) new DAFacade().execQuery(qrySQLStr, null, new BeanListHandler(TestLableDTO.class));
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
	private String createTempTable(String id_ents) throws BizException {
		TamTableColumnDTO[] columns = new TamTableColumnDTO[3];
		columns[0] = MpUtils.getTemtableColumn("Id_ent", "VARCHAR2(20)", FType.String);
		columns[1] = MpUtils.getTemtableColumn("Sd_srvtp", "VARCHAR2(50)", FType.String);
		columns[2] = MpUtils.getTemtableColumn("Id_route", "VARCHAR2(20)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		String[] ents = id_ents.split("\\,");
		for (String id_ent : ents) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1(id_ent);
			param.setColumn2("~");
			param.setColumn3("~");
			listData.add(param);
		}
		String tableName = "mp_rpt_or_temp";
		MpUtils.createTemTable(tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}
}
