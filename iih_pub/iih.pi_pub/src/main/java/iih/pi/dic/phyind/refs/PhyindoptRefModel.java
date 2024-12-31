package iih.pi.dic.phyind.refs;

import iih.pi.dic.phyind.d.PiPatPhyIndDO;
import iih.pi.dic.phyind.d.PiPatPhyIndOptDO;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

public class PhyindoptRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode(){
		return new String[]{PiPatPhyIndOptDO.CODE,PiPatPhyIndOptDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{PiPatPhyIndOptDO.ID_PATPHYINDOPT,PiPatPhyIndOptDO.ID_PATPHYIND,PiPatPhyIndOptDO.IND_NAME};
	}
	@Override
	public String[] getShowFieldName(){
		return new String[]{"编码","名称"};
	}
	@Override
	public String getPkFieldCode(){
		return PiPatPhyIndOptDO.ID_PATPHYINDOPT;
	}
	@Override
	public String getTableName(){
		return new PiPatPhyIndOptDO().getTableName();
	}
	@Override
	public String getRefCodeField(){
		return PiPatPhyIndOptDO.CODE;
	}
	@Override
	public String[] getBlurFields() {
		return new String[] { PiPatPhyIndOptDO.CODE, PiPatPhyIndOptDO.NAME, PiPatPhyIndOptDO.PYCODE, PiPatPhyIndOptDO.WBCODE };
	}
	@Override
	public String getRefNameField(){
		return PiPatPhyIndOptDO.NAME;
	}
	@Override
	public String getRefSql() {
		
		String refSql="select pi_pat_phyindopt.code, pi_pat_phyindopt.name, pi_pat_phyindopt.id_patphyindopt,"
		             +" pi_pat_phyind.id_patphyind,pi_pat_phyind.name as ind_name "
                     +" from pi_pat_phyindopt"
                     +" inner join pi_pat_phyind on pi_pat_phyindopt.id_patphyind = pi_pat_phyind.id_patphyind";
		
		StringBuilder sb = new StringBuilder(refSql);
		sb.append(" where pi_pat_phyindopt.ds=0 ");
		
		//添加组织条件
		String orgSql = EnvContextUtil.processEnvContext("", new PiPatPhyIndDO(), "pi_pat_phyind");
		if(!StringUtil.isEmpty(orgSql)){
			sb.append("and " + orgSql);
		}
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
				
		return sb.toString()+" ORDER BY pi_pat_phyindopt.code  ";
	}
}
