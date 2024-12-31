package iih.mp.nr.wardprint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.TransactionStatus;
import org.springframework.util.CollectionUtils;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.dto.SurgicalOrderInfoDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import iih.mp.nr.qry.GetSurgicalOrderSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FType;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetSurgicalOrderInfoBp {

	public List<SurgicalOrderInfoDTO> exec(String id_ents, String dt_begin, String dt_end, String eu_prn, String sd_srvtps, String sd_exetp) {

		// 1.基础参数校验
		if (!validation(id_ents, dt_begin, dt_end, eu_prn, sd_srvtps, sd_exetp)) {
			return null;
		}

		// 2.数据获取
		List<SurgicalOrderInfoDTO> orderInfoDTOs = getSurgicalOrderInfoDTO(id_ents, dt_begin, dt_end, eu_prn, sd_srvtps, sd_exetp);

		// 3.医嘱内容处理
		setDisContent(orderInfoDTOs);

		return orderInfoDTOs;
	}

	/**
	 * 基础参数校验
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param eu_prn
	 * @return
	 */
	private boolean validation(String id_ents, String dt_begin, String dt_end, String eu_prn, String sd_srvtps, String sd_exetp) {

		if (StringUtil.isEmptyWithTrim(id_ents)) {
			return false;
		}
		if (StringUtil.isEmptyWithTrim(dt_begin)) {
			return false;
		}
		if (StringUtil.isEmptyWithTrim(dt_end)) {
			return false;
		}
		if (StringUtil.isEmptyWithTrim(eu_prn)) {
			return false;
		}

		if (StringUtil.isEmptyWithTrim(sd_srvtps)) {
			return false;
		}
		if (StringUtil.isEmptyWithTrim(sd_exetp)) {
			return false;
		}
		return true;

	}

	/**
	 * 数据获取
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param eu_prn
	 * @return
	 */
	private List<SurgicalOrderInfoDTO> getSurgicalOrderInfoDTO(String id_ents, String dt_begin, String dt_end, String eu_prn, String sd_srvtps, String sd_exetp) {

		final String entStrs = id_ents;
		final String srvtpStrs = sd_srvtps;

		final GetSurgicalOrderSql sql = new GetSurgicalOrderSql(dt_begin, dt_end, eu_prn, sd_exetp);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<SurgicalOrderInfoDTO>>() {
				@SuppressWarnings("unchecked")
				public List<SurgicalOrderInfoDTO> doInTransaction(TransactionStatus status) {
					try {
						String nameTable = createTempTable(entStrs, srvtpStrs);// 创建临时表
						sql.setTempTablename(nameTable);
						List<SurgicalOrderInfoDTO> reList = (List<SurgicalOrderInfoDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(SurgicalOrderInfoDTO.class));
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
		TamTableColumnDTO[] columns = new TamTableColumnDTO[2];
		columns[0] = MpUtils.getTemtableColumn("Id_ent", "VARCHAR2(20)", FType.String);
		columns[1] = MpUtils.getTemtableColumn("Sd_srvtp", "VARCHAR2(50)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		String[] ents = id_ents.split("\\,");
		String[] srvtps = sd_srvtps.split("\\,");
		int length = ents.length > srvtps.length ? ents.length : srvtps.length;// 两个数组中大的那个长度
		for (int i = 0; i < length; i++) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1("~");
			param.setColumn2("~");
			if (ents.length >= i + 1)
				param.setColumn1(ents[i]);
			if (srvtps.length >= i + 1)
				param.setColumn2(srvtps[i]);
			listData.add(param);
		}
		String tableName = "surg_order_temp";
		MpUtils.createTemTable(tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}

	/**
	 * 医嘱内容特殊处理
	 * 
	 * @param orderInfoDTOs
	 */
	private void setDisContent(List<SurgicalOrderInfoDTO> orderInfoDTOs) {

		if (CollectionUtils.isEmpty(orderInfoDTOs))
			return;
		DateFormat dateformat=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
		for (SurgicalOrderInfoDTO surgicalOrderInfoDTO : orderInfoDTOs) {
			String dt_plan = "";
			if (!StringUtil.isEmptyWithTrim(surgicalOrderInfoDTO.getDt_plan())) {
				FDateTime dt_mp_plan = new FDateTime(surgicalOrderInfoDTO.getDt_plan());
				dt_plan=dt_mp_plan.toString(FDateTime.BASE_TIMEZONE, dateformat);
			}
		    StringBuilder content_or=new StringBuilder();
			if(!StringUtil.isEmptyWithTrim(dt_plan))
				content_or.append("拟于 " + dt_plan);
		    if(!StringUtil.isEmptyWithTrim(surgicalOrderInfoDTO.getSugmeod()))
		    		content_or.append(" 在"+surgicalOrderInfoDTO.getSugmeod());
		    if(!StringUtil.isEmptyWithTrim(surgicalOrderInfoDTO.getSugplace()))
		    	content_or.append("下 行"+surgicalOrderInfoDTO.getName_or());
		    if(!StringUtil.isEmptyWithTrim( surgicalOrderInfoDTO.getSugplace()))
		    	content_or.append(" ("+surgicalOrderInfoDTO.getSugplace()+")");
			surgicalOrderInfoDTO.setDiscontent(content_or.toString());
		}
	}
}
