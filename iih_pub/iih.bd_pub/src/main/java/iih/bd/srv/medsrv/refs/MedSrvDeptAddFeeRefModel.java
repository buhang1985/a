package iih.bd.srv.medsrv.refs;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.bddepcg.d.BdDepCgDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import iih.bd.utils.ParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 科室补录服务参照模型
 * @author ly
 *
 */
public class MedSrvDeptAddFeeRefModel  extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{"Name_srv","Name_mm","Spec","Price","Shortname","Code_srv","Def1"}; 
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{"Id_pk","Id_srv","Id_srvtp","Sd_srvtp","Id_srvca","Quan_med",
				"Id_unit_med","Name_unit_med","Id_unit_pkg","Name_unit_pkg",
				"Id_unit_pkgsp","Id_unit_pkgbase",
				"Fg_mm","Id_mm","Srv_wbcode","Srv_pycode","Factor","Factor_mb","Id_route","Fg_otc", "Id_mmpkgu"};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"服务名称","物品名称","规格","参考价","简称","编码","Def1"};
	}
	
	@Override
	public String getPkFieldCode() {
		//id_srv + id_mm
		return "Id_pk";
	}
	@Override
	public String getRefCodeField() {
		return "Code_srv";
	}
	@Override
	public String getRefNameField() {
		return "Name_srv";
	}

	@Override
	public String getTableName() {
		return "srvmm";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getRefSql() {
		
		String code_entp=(String)this.getExtendAttributeValue("code_entp");//就诊类型
		
		DAFacade daf = new DAFacade();
		String cgSql = "select * from bd_dep_cg "
				+ "where id_dep = '" +Context.get().getDeptId()+"' ";
		if(!StringUtil.isEmpty(code_entp)){
			cgSql += "and code_entp = '" + code_entp + "' ";
		}
		cgSql += "and ds = 0";
		
		
		/*if("00".equals(code_entp)){
			//门诊
			cgSql += "and code_entp = '" + IBdFcDictCodeConst.SD_CODE_ENTP_OP + "' ";
		}else if("10".equals(code_entp)){
			//住院
			cgSql += "and code_entp = '" + IBdFcDictCodeConst.SD_CODE_ENTP_IP + "' ";
		}else if("02".equals(code_entp)){
			//体检
			cgSql += "and code_entp = '" + IBdFcDictCodeConst.SD_CODE_ENTP_PE + "' ";
		}else if("20".equals(code_entp)){
			//家庭病床
			cgSql += "and code_entp = '" + IBdFcDictCodeConst.SD_CODE_ENTP_FA + "' ";
		}else if("30".equals(code_entp)){
			//家庭病床333
			cgSql += "and code_entp = '" + IBdFcDictCodeConst.SD_CODE_ENTP_ES + "' ";
		}*/
		
		BdDepCgDO cgDo = null;
		if(!StringUtil.isEmpty(code_entp)){
			try {
				List<BdDepCgDO> cgList = (List<BdDepCgDO>)daf.execQuery(cgSql, new BeanListHandler(BdDepCgDO.class));
				if(!ListUtil.isEmpty(cgList)){
					cgDo = cgList.get(0);//一个科室只可能有条数据
				}
			} catch (DAException e) {
				e.printStackTrace();
			}
		}
		
		FBoolean mpotparam0024 = FBoolean.FALSE;
		try {
			mpotparam0024 = ParamUtils.getOrgParamFBooleanValue("MPOT0024");
		} catch (BizException e) {
			e.printStackTrace();
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from (select bd_srv.name as name_srv,");
		sql.append("bd_mm.name as name_mm,");
		if (mpotparam0024.booleanValue()) {
			sql.append("case when bd_srv.sd_primd  = '00' then mm.spec else bd_mm.spec end spec, ");
		}else {
			sql.append("bd_mm.spec, ");
		}
		sql.append("case when prisrv.price is null then bd_mm.price else prisrv.price end price,");
		sql.append("bd_srv.shortname as shortname,");
		sql.append("bd_srv.code as code_srv,");
		sql.append("bd_srv.def1,");
		sql.append("bd_srv.id_srv||bd_mm.id_mm||case when nvl(mmpkgu.id_unit_pkg,'~')='~' then bd_srv.id_unit_med else mmpkgu.id_unit_pkg end as id_pk,");
		sql.append("bd_srv.id_srv,");
		sql.append("bd_srv.id_srvtp,");
		sql.append("bd_srv.sd_srvtp,");
		sql.append("bd_srv.id_srvca,");
		//	+ "bd_mm.factor_sb,"//零售系数
		sql.append("decode(mmpkgu.id_mm,null,bd_srv.quan_med,");
		sql.append("ceil( bd_srv.quan_med /(mmpkgu.factor * bd_mm.factor_mb))) as quan_med,");
		sql.append("bd_srv.id_unit_med,");
		sql.append("unitmed.name as name_unit_med,");
		sql.append("case when nvl(mmpkgu.id_unit_pkg,'~')='~' then bd_srv.id_unit_med else mmpkgu.id_unit_pkg end as id_unit_pkg,");
		sql.append("case when mmpkgu.mmpkguname is null then unitmed.name else mmpkgu.mmpkguname end as name_unit_pkg,");
		sql.append("bd_mm.id_unit_pkgsp,");
		sql.append("bd_mm.id_unit_pkgbase,");
		sql.append("bd_srv.fg_mm,");
		sql.append("bd_mm.id_mm,");
		sql.append("bd_srv.wbcode as srv_wbcode,");
		sql.append("bd_srv.pycode as srv_pycode, ");
		sql.append("mmpkgu.factor,");
		sql.append("bd_mm.factor_mb, "); //基本系数
		sql.append("bd_srv.id_route, ");//用法
		sql.append("bd_mm.fg_otc, ");
		sql.append("mmpkgu.id_mmpkgu,  ");
		sql.append("bd_srv.mnecode as srv_mnecode ");
		
		sql.append("from bd_srv ");
		sql.append("left join bd_mm ");
		sql.append("on bd_srv.id_srv = bd_mm.id_srv ");
		sql.append("and bd_srv.fg_mm= 'Y' ");
		sql.append("and bd_mm.ds = 0 ");
		sql.append("and bd_mm.fg_active = 'Y' ");
		sql.append("left join  " + this.mmpkguSubSql(code_entp));
		sql.append("on bd_mm.id_mm = mmpkgu.id_mm ");
		sql.append("left join bd_pri_srv prisrv ");
		sql.append("on bd_srv.id_srv = prisrv.id_srv  and prisrv.fg_active='Y' ");
		sql.append("left join bd_measdoc unitmed ");
		sql.append("on bd_srv.id_unit_med = unitmed.id_measdoc ");
		if (mpotparam0024.booleanValue()) {
			sql.append("left join bd_mm mm ");
			sql.append("on bd_srv.mnecode = mm.code and bd_srv.sd_primd = '00' ");
		}
		sql.append("where bd_srv.ds = 0 ");
		sql.append("and ((bd_srv.fg_active = 'Y' and bd_srv.sd_primd <> '00') or (bd_srv.fg_active_bl = 'Y' and bd_srv.sd_primd = '00')) ");
		
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "bd_srv");
		sql.append(String.format(" and %s ", BdModeWherePart));
		
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp) 
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)){
			sql.append("and substr(bd_srv.sd_srvtp,1,2) <> '01' ");
		}
		
		if (!StringUtil.isEmpty(code_entp)) {
			if (cgDo != null) {
				String subSql = this.getSubSql(cgDo.getId_depcg());
				if (FBoolean.TRUE.equals(cgDo.getFg_black())) {
					// 黑名单
					sql.append("and bd_srv.id_srv not in (" + subSql + ") ");
				} else {
					// 白名单
					sql.append("and bd_srv.id_srv in (" + subSql + ") ");
				}
			}

			sql.append(" order by bd_srv.code,bd_mm.code) srvmm ");

			if (cgDo == null) {
				sql.append("where 1<>1 ");
			} else {
				sql.append("where 1=1 ");
			}
		}else{
			sql.append(" order by bd_srv.code,bd_mm.code) srvmm ");
			sql.append("where 1=1 ");
		}
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sql.append(" And (").append(where).append(") ");
			}
		}
		
		return sql.toString();
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{"name_srv","code_srv","srv_wbcode","srv_pycode","srv_mnecode","def1"};
	}
	
	/**
	 * 科室补费策略_明细sql
	 * @param depCgid
	 * @return
	 */
	private String getSubSql(String depCgid){
		return  "select id_srv from bd_dep_cg_itm where id_depcg = '" +depCgid+ "'";
	}
	
	/**
	 * 物品包装单位子查询
	 * @return
	 */
	private String mmpkguSubSql(String code_entp){
			
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("(select pkgu.id_mm,pkgu.id_mmpkgu,pkgu.id_unit_pkg,pkgu.mmpkguname,pkgu.factor from bd_mm_pkgu pkgu ");
		sqlSb.append("inner join ");
		sqlSb.append("(select id_mm, ");
		if("00".equals(code_entp)){
			sqlSb.append("min(en_oppkgtp) mintp ");
		}else if("10".equals(code_entp)){
			sqlSb.append("min(en_ippkgtp) mintp ");
		}else{
			sqlSb.append("min(en_oppkgtp) mintp ");
		}
		sqlSb.append("from bd_mm_pkgu group by id_mm) subpkgu ");
		sqlSb.append("on pkgu.id_mm = subpkgu.id_mm ");
		if("00".equals(code_entp)){
			sqlSb.append("and pkgu.en_oppkgtp = subpkgu.mintp ");
		}else if("10".equals(code_entp)){
			sqlSb.append("and pkgu.en_ippkgtp = subpkgu.mintp ");
		}else{
			sqlSb.append("and pkgu.en_oppkgtp = subpkgu.mintp ");
		}
		sqlSb.append(") mmpkgu ");
		
		return sqlSb.toString();
	}
}
