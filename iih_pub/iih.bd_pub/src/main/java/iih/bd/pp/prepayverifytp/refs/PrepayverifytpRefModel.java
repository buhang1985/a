package iih.bd.pp.prepayverifytp.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.pp.prepayverifytp.d.PrepayverifytpDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 预交金支付身份校验类型参照模型
 * 
 * @author ly 2018/01/15
 *
 */
public class PrepayverifytpRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "code", "name" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_prepay_verifytp", "verifytp_lv" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", };
	}

	@Override
	public String getPkFieldCode() {
		return "id_prepay_verifytp";
	}

	@Override
	public String getTableName() {
		return "prepay";
	}

	@Override
	public String getRefCodeField() {
		return "code";

	}

	@Override
	public String getRefNameField() {
		return "name";
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "code", "name" };
	}

	@Override
	public String getRefSql() {

		String sdScene = (String) this.getExtendAttributeValue("sd_scene");
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select * from (");
		sqlSb.append("select doc.code,doc.name,bdpre.id_prepay_verifytp,bdpre.verifytp_lv ");
		sqlSb.append("from bd_prepay_verifytp bdpre ");
		sqlSb.append("left join bd_udidoc doc ");
		sqlSb.append("on bdpre.id_verifytp = doc.id_udidoc ");
		if(!StringUtil.isEmpty(sdScene)){
			sqlSb.append("where bdpre.sd_scene like '%" + sdScene + "%' ");
		}
		sqlSb.append("AND " + EnvContextUtil.processEnvContext("", new PrepayverifytpDO(), "bdpre") + " ");
		sqlSb.append(") prepay ");
		sqlSb.append("where 1=1 ");
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sqlSb.append(" And (").append(where).append(") ");
			}
		}

		return sqlSb.toString();
	}
	
	@Override
	public List<String> getOrderPart() {
		List<String> orderList = super.getOrderPart();
		if(orderList == null){
			orderList = new ArrayList<String>();
		}
		
		if(!orderList.contains("verifytp_lv")){
			orderList.add("verifytp_lv");
		}
		
		return orderList;
	}
}
