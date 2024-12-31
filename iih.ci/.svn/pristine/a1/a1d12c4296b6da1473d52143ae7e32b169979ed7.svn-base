package iih.ci.ord.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciordems.d.EmsBuItemDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class getOrderUBDtoBP {
	
	/**
	 * 用血申请单
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public  EmsBuItemDO execub(String id_or)  throws BizException{
		
		StringBuilder builder = new StringBuilder();
		builder.append("Select ORD.id_or_rel as id_or,ORSRV.name as name_srv,APBT.no_applyform as no_applyform_bt,APBU.no_applyform as no_applyform_bu,");
		builder.append("ORSRV.quan_medu as quan_medu_bu,ORSRVREL.quan_medu as quan_medu_bt,BTTEST.num_bt as quan_total_bt,APBT.num_margin_bu as quan_avi_bt,");
		builder.append("ORSRV.id_medu as id_unit,MEAS.name as name_unit,ORD.id_route,ROUTE.name as name_route,");
		builder.append("APBU.dt_bu_plan as dt_pl_bu,ORD.dt_entry as dt_app_bu,");
		builder.append("ORD.id_emp_or as id_emp_bu,PSNDOC.name as name_emp_bu,APBU.applydoctortel,APBU.operationroom,APBU.operationroomtel,ORD.des_or ");
		
		builder.append("from ci_order ORD ");
		builder.append("left join ci_or_srv ORSRV on ORD.id_or=ORSRV.id_or and ORSRV.id_srv=ORD.id_srv ");
		builder.append("left join ci_ap_bu APBU on ORD.id_or=APBU.id_or ");
		builder.append("left join bd_measdoc MEAS on MEAS.id_measdoc=ORSRV.id_medu ");
		builder.append("left join bd_route ROUTE on ROUTE.id_route=ORD.id_route ");
		builder.append("left join ci_ap_bt APBT on APBT.id_or=ORD.id_or_rel ");
		builder.append("left join ci_rpt_bttest BTTEST on BTTEST.id_or=ORD.id_or_rel ");
		builder.append("left join ci_or_srv ORSRVREL on ORSRVREL.id_or=ORD.id_or_rel and ORSRVREL.sd_srvtp='"+IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE+"' ");
		builder.append("left join bd_psndoc PSNDOC on ORD.id_emp_or=PSNDOC.Id_psndoc ");
		
		builder.append("where ORD.id_or=?");
		
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(id_or);
		EmsBuItemDO result = (EmsBuItemDO) new DAFacade().execQuery(sql, param,
				new BeanHandler(EmsBuItemDO.class));

		return result;
	}
	/**
	 * 备血申请列表
	 * @param 
	 * @return
	 * @throws BizException
	 */
	public  EmsBuItemDO[] execpbt(String id_ent)  throws BizException{
		
		StringBuilder builder = new StringBuilder();
		builder.append("select * from (");
		builder.append("select ORD.id_or,ORD.id_srv,ORSRV.name as name_srv,APBT.no_applyform as no_applyform_bt,");
		builder.append("ORSRV.quan_medu as quan_medu_bt,BTTEST.num_bt as quan_total_bt,APBT.num_margin_bu as quan_avi_bt,");
		builder.append("ORSRV.id_medu as id_unit,MEAS.name as name_unit,SRV.id_route,ROUTE.name as name_route,");
		builder.append("BLOODTP.Name as Name_app_bloodtype,RHD.Name as Name_app_rhd,");
		builder.append("APBT.dt_bt_pl as dt_pl_bt,ORD.id_emp_sign as id_emp_bt,PSN.name as Name_emp_bt,APBT.ID_BLODQUAN,APBT.dt_Bt_Pl ");
		
		builder.append("from ci_order ORD ");
		builder.append("left join ci_or_srv ORSRV on ORSRV.id_or=ORD.id_or and ORSRV.id_srv=ORD.id_srv ");
		builder.append("left join bd_srv SRV on SRV.id_srv=ORSRV.id_srv ");
		builder.append("left join bd_route ROUTE on ROUTE.id_route=SRV.id_route ");
		builder.append("left join ci_ap_bt APBT on APBT.id_or=ORD.id_or ");
		builder.append("left join ci_rpt_bttest BTTEST on BTTEST.id_or=ORD.id_or ");
		builder.append("left join bd_measdoc MEAS on MEAS.id_measdoc=ORSRV.id_medu ");
		builder.append("left join bd_psndoc PSN on ORD.id_emp_or=PSN.id_psndoc ");
		builder.append("left join bd_udidoc BLOODTP on APBT.id_bloodtype_ap=BLOODTP.id_udidoc ");
		builder.append("left join bd_udidoc RHD on APBT.id_rhd_ap=RHD.id_udidoc ");
		
		builder.append("where ORD.id_en=? ");
		builder.append("and ORSRV.sd_srvtp='"+IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE+"' ");
		builder.append("and ORD.fg_sign='Y' ");
		builder.append("and ORD.fg_canc='N' ");
		builder.append("and APBT.num_margin_bu>0 ");
		builder.append("and ORD.Fg_Set='N' ");

		builder.append(" union ");
		
		builder.append("select ORD.id_or,ORSRV.id_srv,ORSRV.name as name_srv,APBT.no_applyform as no_applyform_bt,");
		builder.append("ORSRV.quan_medu as quan_medu_bt,BTTEST.num_bt as quan_total_bt,APBT.num_margin_bu as quan_avi_bt,");
		builder.append("ORSRV.id_medu as id_unit,MEAS.name as name_unit,SRV.id_route,ROUTE.name as name_route,");
		builder.append("BLOODTP.Name as Name_app_bloodtype,RHD.Name as Name_app_rhd,");
		builder.append("APBT.dt_bt_pl as dt_pl_bt,ORD.id_emp_sign as id_emp_bt,PSN.name as Name_emp_bt,APBT.ID_BLODQUAN,APBT.dt_Bt_Pl ");
		
		builder.append("from ci_order ORD ");
		builder.append("left join ci_or_srv_set SRVSET on  SRVSET.Id_Or=ORD.ID_OR ");
		builder.append("left join ci_or_srv ORSRV on ORSRV.id_or=ORD.id_or and ORSRV.id_srv=SRVSET.Id_Srvset ");
		builder.append("left join bd_srv SRV on SRV.id_srv=ORSRV.id_srv ");
		builder.append("left join bd_route ROUTE on ROUTE.id_route=SRV.id_route ");
		builder.append("left join ci_ap_bt APBT on APBT.id_or=ORD.id_or ");
		builder.append("left join ci_rpt_bttest BTTEST on BTTEST.id_or=ORD.id_or ");
		builder.append("left join bd_measdoc MEAS on MEAS.id_measdoc=ORSRV.id_medu ");
		builder.append("left join bd_psndoc PSN on ORD.id_emp_or=PSN.id_psndoc ");
		builder.append("left join bd_udidoc BLOODTP on APBT.id_bloodtype_ap=BLOODTP.id_udidoc ");
		builder.append("left join bd_udidoc RHD on APBT.id_rhd_ap=RHD.id_udidoc ");
		
		builder.append("where ORD.id_en=? ");
		builder.append("and ORSRV.sd_srvtp='"+IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE+"' ");
		builder.append("and ORD.fg_sign='Y' ");
		builder.append("and ORD.fg_canc='N' ");
		builder.append("and APBT.num_margin_bu>0 ");
		builder.append("and ORD.Fg_Set='Y' ");
		builder.append(")order by dt_bt_pl");
		
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		param.addParam(id_ent);
		@SuppressWarnings("unchecked")
		List<EmsBuItemDO> result = (List<EmsBuItemDO>)new DAFacade().execQuery(sql, param, new BeanListHandler(EmsBuItemDO.class));
		if(!ListUtil.isEmpty(result)){
			return result.toArray(new EmsBuItemDO[0]);
		}
	    return null;
	}

}
