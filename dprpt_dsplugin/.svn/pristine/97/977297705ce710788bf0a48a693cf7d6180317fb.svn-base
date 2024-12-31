package iih.ci.ord.ciordsheet.bp;

import iih.ci.ord.ciordsheet.CiOrdSheetParamDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import xap.mw.coreitf.d.FBoolean;

/**
 * 查询就诊未打印过的医嘱单数据
 * @author Young
 *
 */
public class GetOrdData4PrnBP extends GetOrdSheetDataBaseBP {
	
	/**
	 * 获取where部分语句
	 * @return
	 */
	@Override
	protected String getWhereSqlOrSrvMM(CiOrdSheetParamDTO paramDTO, String pageNums) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format(" where ORD.id_en='%s' and ORD.Eu_orsrcmdtp!='0C' and ORD.sd_orsrcfun='1' and ORD.fg_sign='Y' and ord.fg_prn = 'Y' ", paramDTO.getId_en()));// ORD.fg_chk='Y'
		if (FBoolean.TRUE.equals(paramDTO.getIsPrnNurseChk())) {
			sb.append(" and ORD.fg_chk='Y' ");
		}
		if (FBoolean.FALSE.equals(paramDTO.getIsPrnPresOutp())) {
			sb.append(" and ORD.fg_pres_outp='N' ");
		}
		sb.append(CiorderPrintUtils.getDynamicWhereSql(paramDTO.getFg_long(), paramDTO.getFg_herb(), "ORD"))
		.append(this.getWhereSqlByPrintMode(paramDTO));
		return sb.toString();
	}
	
	/**
	 * 根据打印模式获取拼接续打Sql
	 * @return
	 */
	private String getWhereSqlByPrintMode(CiOrdSheetParamDTO paramDTO) {
		StringBuilder sql = new StringBuilder();
		switch (paramDTO.getPrint_mode()) {
		case "1": // 一般续打：指定就诊，排除已经打印过的医嘱(存在于医嘱打印表ci_or_prn内的有效医嘱)
			sql.append(" and (ORPRN.id_en is null and ORPRN.id_or is null)");
			break;
		case "2": // 重整打印：指定就诊，不包含已经打印完停止信息(执行过停止打印)的记录，并且不包含作废医嘱（不论是否执行过作废打印，都不再显示）
			//sql.append(" and ((ORPRN.id_en is null and ORPRN.id_or is null) or ORPRN.fg_canc_prn!='Y') and ORPRN.fg_reformed!='Y' and ORD.fg_chk_canc!='Y'");
			sql.append(" and ((ORPRN.id_en is null and ORPRN.id_or is null) or ORPRN.fg_canc_prn!='Y') and ORD.fg_chk_canc!='Y'");
//			sql.append(" and ORPRN.id_en is null or ORPRN.fg_canc_prn!='Y' ");
			break;
		}

		return sql.toString();
	}
	
	/**
	 * 获取排序sql
	 * @return
	 */
	@Override
	protected String getOrderBySql() {
		return " order by dt_effe asc,id_or asc,nvl(sortno_srv,0) asc";
	}
}
