package iih.bd.pp.bdbltpl.refs;

import iih.bd.pp.bdbltpl.d.desc.BdBlTplDODesc;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;

import java.util.List;

import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 一个特异性的参照模型，为了解决住院护士补费时按费用模板补费的情况
 * @author 
 * 
 */
public class BlTplIPRefSpecialRefModel extends RefGridModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{"code_bill","name","name_billtype"};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[]{"费用项编码","费用项名称","费用类型"};
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
		return new String[]{"bill_type","id_billitm"};
	}

	@Override
	public String[] getBlurFields() {
		return new String[]{"CODE_BILL","NAME"};
	}
	
	@Override
	public String getRefSql() {
		StringBuilder sb=new StringBuilder();
		sb.append(" SELECT CODE_BILL,NAME,NAME_BILLTYPE,BILL_TYPE,ID_BILLITM");
		sb.append(" FROM(");
		sb.append(" SELECT CODE AS CODE_BILL,NAME,'费用模板' AS NAME_BILLTYPE,1 AS BILL_TYPE,ID_BLTPL AS ID_BILLITM");
		sb.append(" FROM BD_BLTPL");
		sb.append(" WHERE SD_OWTP='0' OR (SD_OWTP='1' AND ID_DEP='"+Context.get().getDeptId()+"') OR (SD_OWTP='2' AND ID_EMP='"+Context.get().getUserId()+"')");
		sb.append(" AND ").append(EnvContextUtil.processEnvContext("",new BdBlTplDODesc(),false));
		sb.append("	UNION ALL");
		sb.append(" SELECT SRV.CODE AS CODE_BILL,SRV.NAME,'组合计价服务' AS NAME_BILLTYPE,2 AS BILL_TYPE,SRV.ID_SRV AS ID_BILLITM");
		sb.append(" FROM BD_SRV SRV");
		sb.append(" INNER JOIN BD_PRI PRI ON SRV.ID_PRIMD=PRI.ID_PRI");
		sb.append(" WHERE PRI.CODE in ('"+IBdPrimdCodeConst.CODE_PRI_SRV_COMP+"','"+IBdPrimdCodeConst.CODE_PRI_SRV+"')");
		sb.append(" AND ").append(EnvContextUtil.processEnvContext("",new MedSrvDODesc(),"srv"));
		
		sb.append(" union all ");
		sb.append(" select srv.code code_bill,srv.name,'非物品的本服务计价' name_billtype,3 bill_type ,srv.id_srv id_billitm ");
		sb.append(" from  bd_srv srv  ");
		sb.append(" where fg_bl='Y' and fg_mm='N' and fg_active='Y' and id_primd !='@@@@AA1000000000VBBQ' ");
		
		sb.append(" union all ");
		sb.append(" SELECT MM.CODE CODE_BILL,MM.NAME, '物品服务'  AS  NAME_BILLTYPE,  4 AS BILL_TYPE, MM.ID_MM AS ID_BILLITM");
		sb.append(" FROM BD_SRV SRV");
		sb.append(" INNER JOIN BD_MM MM ON SRV.ID_SRV = MM.ID_SRV ");
		sb.append(" WHERE  MM.FG_CHARGE='N' and fg_mm='Y' and srv.fg_active='Y'");
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

