package iih.bd.mm.task.bp.qry;

import iih.bd.base.utils.SqlUtils;
import iih.mm.pl.poplanstrategy.d.PoPlanStrategyDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPlItemDosSql implements ITransQry{

	private String _ids;
	private String _whId;
	private int _supType;
	private String _quanType;
	private int _daysAve;
	private int _daysPl;
	private int _whtp;//过滤仓库类型：1 药库； 2药房
	private String _idWhs;//需要统计的药房集合
	
	public GetPlItemDosSql(String where, PoPlanStrategyDO strategy) {
		this._ids = where;
		this._whId = strategy.getId_wh();
		this._supType = strategy.getPosuptype();
		this._quanType = strategy.getSd_quancaltp_pl();
		this._daysAve = strategy.getDays_avguse();
		this._daysPl = strategy.getDays_poplan();
		if(strategy.getWhtp_name() != null && strategy.getWhtp_name().equals("药房")) {
			this._whtp = 2;
		}else {
			this._whtp = 1;
		}
		if(this._whtp == 2) {
			String[] id_whs = strategy.getId_wh_range().split(",");
			this._idWhs = SqlUtils.getInSqlByIds("MM_OUT.Id_Wh", id_whs);
		}
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this._whId);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("select rownum as sortno,                                                                                        ");
		sql.append("       cfg.id_mm,                                                                                               ");
		sql.append("       basepkgu.id_mmpkgu as id_mmpkgu_base,                                                                    ");
		sql.append("       actpkgu.id_mmpkgu  as id_mmpkgu_actual,                                                                  ");
		sql.append("       actpkgu.factor,                                                                                          ");
		sql.append("       sup.id_sup,                                                                                              ");
		if(this._quanType.equals("0")) {
			String cond = String.format("round(((nvl(quan.num, 0) / actpkgu.factor) / %d) * %d, 0) as quan_pl_actual ", this._daysAve, this._daysPl);
			sql.append(cond);
		}else if(this._quanType.equals("1")) {
			String cond = String.format("round(((nvl(quan.num, 0) / actpkgu.factor) / %d) * %d - (nvl(b.num_actual, 0) / actpkgu.factor), 0) as quan_pl_actual ", this._daysAve, this._daysPl);
			sql.append(cond);
		}else if(this._quanType.equals("2")) {
			String cond = String.format("round(((nvl(quan.num, 0) / actpkgu.factor) / %d) * %d - (nvl(c.all_stock, 0) / actpkgu.factor), 0) as quan_pl_actual ", this._daysAve, this._daysPl);
			sql.append(cond);
		}else if(this._quanType.equals("3")) {
			String cond = String.format("round(((nvl(quan.num, 0) / actpkgu.factor) / %d) * %d - (nvl(b.num_usable, 0) / actpkgu.factor), 0) as quan_pl_actual ", this._daysAve, this._daysPl);
			sql.append(cond);
		}else if(this._quanType.equals("4")) {
			String cond = String.format("round(((nvl(quan.num, 0) / actpkgu.factor) / %d) * %d - (nvl(c.all_usable, 0) / actpkgu.factor), 0) as quan_pl_actual ", this._daysAve, this._daysPl);
			sql.append(cond);
		}
		sql.append("  from mm_addst_cfg cfg                                                                                         ");
		sql.append("  left join bd_mm_pkgu basepkgu                                                                                 ");
		sql.append("    on cfg.id_mm = basepkgu.id_mm                                                                               ");
		sql.append("   and basepkgu.sd_mmpkgupro = '0'                                                                              ");
		sql.append("  left join bd_mm_pkgu actpkgu                                                                                  ");
		sql.append("    on cfg.id_mm = actpkgu.id_mm                                                                                ");
		sql.append("  left join bd_wh_pkgutp pkgutp                                                                                 ");
		sql.append("    on actpkgu.id_mmpkgutp = pkgutp.id_mmpkgutp                                                                 ");
		sql.append("   and pkgutp.id_wh = ?                                                                                         ");
		if(2 == this._supType) {
			sql.append("  left join (select mmsup.id_mm,                                                                                ");
			sql.append("                    prot.id_sup,                                                                                ");
			sql.append("                    ROW_NUMBER() over(partition by mmsup.id_mm, prot.id_sup order by prot.sd_priority) as flag  ");
			sql.append("               from bd_mm_sup mmsup                                                                             ");
			sql.append("               left join bd_sup_prot prot                                                                       ");
			sql.append("                 on mmsup.id_sup_prot = prot.id_sup_prot                                                        ");
			sql.append("              where prot.fg_active = 'Y'                                                                        ");
			sql.append("                and prot.sd_su_prot = '2'                                                                       ");
			sql.append("                and prot.da_b <= to_char(sysdate, 'yyyy-MM-dd')                                                ");
			sql.append("                and prot.da_e >= to_char(sysdate, 'yyyy-MM-dd')) sup                                           ");
			sql.append("    on cfg.id_mm = sup.id_mm                                                                                    ");
			sql.append("   and sup.flag = 1                                                                                             ");
			
		}else {
			sql.append("  left join (select itm.id_mm,                                                              ");
			sql.append("                    mmin.id_sup,                                                            ");
			sql.append("                    mmin.sv,                                                                ");
			sql.append("                    ROW_NUMBER() over(partition by itm.id_mm order by mmin.sv desc) as flag ");
			sql.append("               from mm_in_itm itm                                                           ");
			sql.append("               left join mm_in mmin                                                         ");
			sql.append("                 on itm.id_in = mmin.id_in                                                  ");
			sql.append("              where mmin.sd_sttp = '11'                                                     ");
			sql.append("                and mmin.red_blue = 'N'                                                     ");
			sql.append("                and mmin.sd_su_st = '1') sup                                                ");
			sql.append("    on cfg.id_mm = sup.id_mm                                                                ");
			sql.append("   and sup.flag = 1                                                                         ");
		}
		if(this._whtp == 1) {
			sql.append("left join (select ITM.Id_Mm,                                                 ");
			sql.append("                    sum(ITM.Quan_Actual * (act.Factor / base.Factor)) as num ");
			sql.append("               from mm_out_itm ITM                                           ");
			sql.append("               left join mm_out MM_OUT                                       ");
			sql.append("                 on ITM.Id_Out = MM_OUT.Id_Out                               ");
			sql.append("               left join bd_mm_pkgu act                                      ");
			sql.append("                 on ITM.Id_Mmpkgu_Actual = act.Id_Mmpkgu                     ");
			sql.append("               left join bd_mm_pkgu base                                     ");
			sql.append("                 on ITM.Id_Mmpkgu_Base = base.Id_Mmpkgu                      ");
			sql.append("               left join mm_tr TR                                            ");
			sql.append("                 on MM_OUT.Id_Out = TR.Id_Out                                ");
			sql.append("               left join bd_wh WH                                            ");
			sql.append("                 on TR.Id_Wh_Ap = WH.Id_Wh                                   ");
			sql.append("              where MM_OUT.Sd_Sttp = '23'                                    ");
			sql.append("                and Mm_Out.Sd_Su_St = '1'                                    ");
			sql.append("                and WH.Sd_Whtp = '02'                                        ");
			sql.append("                and MM_OUT.Dt_Conf >=                                        ");
			sql.append("                    to_char(sysdate - " + this._daysAve + ", 'yyyy-mm-dd hh24:mi:ss')            ");
			sql.append("              group by ITM.Id_Mm) quan                                       ");
			sql.append("    on cfg.id_mm = quan.id_mm                                                ");
		}else {
			sql.append(" left join (select ITM.Id_Mm,                                                ");
			sql.append(" sum(ITM.Quan_Actual * (ACTPKGU.Factor / BASEPKGU.Factor)) as num            ");
			sql.append(" from mm_out_itm ITM                                                         ");
			sql.append(" left join mm_out MM_OUT                                                     ");
			sql.append(" on ITM.Id_Out = MM_OUT.Id_Out                                               ");
			sql.append(" left join bd_mm_pkgu ACTPKGU                                                ");
			sql.append(" on ITM.Id_Mmpkgu_Actual = ACTPKGU.Id_Mmpkgu                                 ");
			sql.append(" left join bd_mm_pkgu BASEPKGU                                               ");
			sql.append(" on ITM.Id_Mmpkgu_Base = BASEPKGU.Id_Mmpkgu                                  ");
			sql.append(" where MM_OUT.Sd_Sttp = '24'                                                 ");
			sql.append(" and Mm_Out.Sd_Su_St = '1'                                                   ");
			sql.append(" and " + this._idWhs + " ");
			sql.append(" and MM_OUT.Dt_Conf >= to_char(sysdate - " + this._daysAve +", 'yyyy-mm-dd hh24:mi:ss') ");
			sql.append(" group by ITM.Id_Mm) quan                                                    ");
			sql.append(" on cfg.id_mm = quan.id_mm                                                   ");
		}
		
		if(this._quanType.equals("1") || this._quanType.equals("3")) {
			sql.append("left join (select BL.Id_Mm,                           ");
			sql.append("                    sum(BL.Quan_Stock) as num_actual, ");
			sql.append("                    sum(BL.Quan_Usable) as num_usable ");
			sql.append("               from mm_bl bl                          ");
			sql.append("              where bl.Id_Wh = '" + this._whId + "'   ");
			sql.append("              group by bl.Id_Mm) b                    ");
			sql.append("    on cfg.id_mm = b.id_mm                            ");
		}else if(this._quanType.equals("2") || this._quanType.equals("4")) {
			sql.append("left join (select BL.Id_Mm,                           ");
			sql.append("                    sum(BL.Quan_Stock) as all_stock,  ");
			sql.append("                    sum(BL.Quan_Usable) as all_usable ");
			sql.append("               from mm_bl BL                          ");
			sql.append("              group by BL.Id_Mm) c                    ");
			sql.append("    on cfg.id_mm = c.id_mm                            ");
		}
		sql.append(" where " + this._ids);
		sql.append("   and pkgutp.fg_def = 'Y'                                ");
		return sql.toString();
	}

}
