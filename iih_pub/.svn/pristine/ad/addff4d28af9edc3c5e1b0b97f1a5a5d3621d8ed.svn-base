package iih.bd.fc.que.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.que.d.QueDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 队列参照模型
 * @author renying
 *
 */
public class QueRefModelNew extends RefGridModel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { QueDO.CODE, QueDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { QueDO.ID_QUE , QueDO.ID_QUETP, QueDO.SD_QUETP, QueDO.ID_QUEBEN, QueDO.ID_DEP, QueDO.ID_SCRES, QueDO.ID_SCSRV
				,QueDO.ID_ORG,QueDO.ID_GRP,"sd_screstp"};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { QueDO.CODE, QueDO.NAME, QueDO.PYCODE, QueDO.WBCODE, QueDO.MNECODE };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return QueDO.ID_QUE;
	}

	@Override
	public String getRefCodeField() {
		return QueDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return QueDO.NAME;
	}

	@Override
	public String getTableName() {
		return new QueDO().getTableName();
	}

	@Override
	public String getRefSql() {	
		StringBuilder sb = new  StringBuilder();
		sb.append("	select BD_QUE.code,");
		sb.append(" BD_QUE.name,");
		sb.append(" BD_QUE.id_que,");
		sb.append(" BD_QUE.id_quetp,");
		sb.append(" BD_QUE.sd_quetp,");
		sb.append(" BD_QUE.id_queben,");
		sb.append(" BD_QUE.id_dep,");
		sb.append(" BD_QUE.id_scres,");
		sb.append(" BD_QUE.id_scsrv,");
		sb.append(" BD_QUE.id_org,");
		sb.append(" BD_QUE.id_grp,");
		sb.append(" res.sd_screstp");      
		sb.append(" from bd_que BD_QUE");               
		sb.append(" left outer join sc_res res");               
		sb.append(" on res.id_scres = BD_QUE.id_scres");   
		sb.append(" where 1=1 ");  
		List<String> whereList = getWherePart();
		if (whereList.size() > 0) {
			for (String where : whereList) {
				sb.append(" And (").append(where).append(") ");
			}
		}    
		
		sb.append("   order by bd_que.code");
		return sb.toString();
	}


	@Override
	public List<String> getWherePart() {
		List<String> wherePart = super.getWherePart();
		if (wherePart==null) {
			wherePart=new ArrayList<String>();
		}
		//增加集团管控
		wherePart.add(BdEnvContextUtil.processEnvContext(new QueDO(), false));
		return wherePart;
	}


}
