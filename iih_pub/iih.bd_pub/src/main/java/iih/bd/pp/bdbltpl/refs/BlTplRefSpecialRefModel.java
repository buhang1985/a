package iih.bd.pp.bdbltpl.refs;

import iih.bd.pp.bdbltpl.d.desc.BdBlTplDODesc;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;

import java.util.List;

import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

import com.mysql.jdbc.StringUtils;

/**
 * 一个特异性的参照模型，为了解决门诊收费按费用模板补费的情况
 * @author yangyang
 * 
 */
public class BlTplRefSpecialRefModel extends RefGridModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{"code_bill","name","hpsrvtp_name","name_billtype","price"};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[]{"费用项编码","费用项名称","等级","费用类型","单价"};
	}

	
	@Override
	public String getPkFieldCode() {
		return "ID_BILLITM";
	}

	@Override
	public String getRefCodeField() {
		return "code_bill";
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return "name";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "A";
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{"bill_type","id_billitm","PYCODE","WBCODE","id_unit_med"};
	}

	@Override
	public String[] getBlurFields() {
		return new String[]{"CODE_BILL","NAME","PYCODE","WBCODE"};
	}
	
	@Override
	public String getRefSql() {
		String idHp = (String) this.getExtendAttributeValue("idHp");
		String strIdPripat=(String)this.getExtendAttributeValue("id_pripat");
		//新增一个参数0130986 :过滤sd_bltpltp类型的费用模板,该类型为01，则过滤掉为01的费用模板
		String filterSdbltpltp =(String)this.getExtendAttributeValue("filterSdbltpltp");
		
		if(StringUtils.isEmptyOrWhitespaceOnly(idHp)){
			String sql = " select id_hp from bd_hp where fg_default = 'Y' and rownum < 2 ";
			
			try {
				idHp = (String)new DAFacade().execQuery(sql, new ColumnHandler());
			} catch (DAException e) {				
				e.printStackTrace();
			}
		}
		StringBuilder sb=new StringBuilder();
		//此处费用模板不能关联费用模板明细表，会导致参照有问题，by liwq  2018年2月5日19:59:17
		sb.append(" SELECT CODE_BILL,NAME,hpsrvtp_name,NAME_BILLTYPE,PRICE,BILL_TYPE,ID_BILLITM,PYCODE,WBCODE,ID_UNIT_MED ");
		sb.append(" FROM(");
		sb.append(" SELECT bd_bltpl.CODE AS CODE_BILL,bd_bltpl.NAME, ");
		sb.append(" '模板不对应' hpsrvtp_name ,'费用模板' AS NAME_BILLTYPE,NULL AS PRICE,1 AS BILL_TYPE,bd_bltpl.ID_BLTPL AS ID_BILLITM,bd_bltpl.PYCODE,bd_bltpl.WBCODE,'' as id_unit_med ");
		sb.append(" FROM BD_BLTPL ");
		sb.append(" WHERE ");
		if(!StringUtil.isEmpty(filterSdbltpltp)){
			sb.append(" bd_bltpl.sd_bltpltp <> "+filterSdbltpltp+" and ");
		}
		sb.append(" SD_OWTP='0' OR (SD_OWTP='1' AND ID_DEP='"+Context.get().getDeptId()+"') OR (SD_OWTP='2' AND ID_EMP='"+Context.get().getStuffId()+"') ");
		sb.append(" AND ").append(EnvContextUtil.processEnvContext("",new BdBlTplDODesc(),false));
		
		sb.append("	UNION ALL");
		sb.append(" SELECT SRV.CODE AS CODE_BILL,SRV.NAME,decode(hpsrv.sd_hpsrvtp,'1','甲类','2','乙类','3','丙类','未对应') hpsrvtp_name,'本服务定价' AS NAME_BILLTYPE,VIEWPRI.PRICE_RATIO AS PRICE,3 AS BILL_TYPE,SRV.ID_SRV AS ID_BILLITM,SRV.PYCODE,SRV.WBCODE,srv.id_unit_med ");

		sb.append(" FROM BD_SRV SRV");
		sb.append(" INNER JOIN BD_PRI PRI ON SRV.ID_PRIMD=PRI.ID_PRI");
		sb.append("  left  join bd_hp_srvorca  hpsrv on  (srv.id_srv = hpsrv.id_srv and srv.fg_mm ='N' ) ");
		sb.append(" and hpsrv.id_hp = '").append(idHp).append("' ");
		sb.append(" left join bd_mm mm on srv.id_srv = mm.id_srv and srv.fg_mm='Y' and  mm.id_mm = hpsrv.id_mm ");
		sb.append(" left join view_price_rp viewpri on viewpri.id_srv=srv.id_srv and viewpri.id_pripat='").append(strIdPripat).append("'");
		sb.append(" WHERE SRV.FG_BL='Y' AND SRV.FG_ACTIVE='Y' AND SRV.FG_ACTIVE_bl = 'Y' AND PRI.CODE='"+IBdPrimdCodeConst.CODE_PRI_SRV+"'");
		sb.append(" AND ").append(EnvContextUtil.processEnvContext("",new MedSrvDODesc(),"srv"));
		
		sb.append("	UNION ALL");
		sb.append(" SELECT SRV.CODE AS CODE_BILL,SRV.NAME,decode(hpsrv.sd_hpsrvtp,'1','甲类','2','乙类','3','丙类','组合定价不对应') hpsrvtp_name,'组合定价服务' AS NAME_BILLTYPE,VIEWPRI.PRICE_RATIO AS PRICE,2 AS BILL_TYPE,SRV.ID_SRV AS ID_BILLITM,SRV.PYCODE,SRV.WBCODE,srv.id_unit_med ");

		sb.append(" FROM BD_SRV SRV");
		sb.append(" INNER JOIN BD_PRI PRI ON SRV.ID_PRIMD=PRI.ID_PRI");
		sb.append(" left  join bd_hp_srvorca  hpsrv on  (srv.id_srv = hpsrv.id_srv and srv.fg_mm ='N' )  ");
		sb.append(" and hpsrv.id_hp = '").append(idHp).append("' ");
		sb.append(" left join view_price_rp viewpri on viewpri.id_srv=srv.id_srv and viewpri.id_pripat='").append(strIdPripat).append("'");
		sb.append(" WHERE SRV.FG_BL='N' AND SRV.FG_ACTIVE='Y' AND SRV.FG_ACTIVE_bl = 'Y' AND PRI.CODE='"+IBdPrimdCodeConst.CODE_PRI_SRV_COMP+"'");
		sb.append(" AND ").append(EnvContextUtil.processEnvContext("",new MedSrvDODesc(),"srv"));
		sb.append(" ) A WHERE 1=1");
		String strWherePart="";
		//这个是原有的条件语句
		List<String>  oldWherepartArr = this.getWherePart();
		for(String strWhere :oldWherepartArr )
		{
			sb=sb.append(" and ").append(strWhere);
		}	
		
		
 		return sb.toString();
	}	
}
