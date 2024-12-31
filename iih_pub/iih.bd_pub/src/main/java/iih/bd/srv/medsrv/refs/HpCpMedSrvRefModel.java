package iih.bd.srv.medsrv.refs;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 临床路径管理的服务参照
 * @author hums
 *
 */
public class HpCpMedSrvRefModel extends RefGridModel {
	
	private String sd_inputmethod = "";
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] {"name_srvtp", MedSrvDO.NAME, MedSrvDO.CODE, MedSrvDO.MNECODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MedSrvDO.FG_MM, MedSrvDO.ID_SRV, MedSrvDO.ID_SRVTP, MedSrvDO.FG_OR, MedSrvDO.FG_ACTIVE,
				MedSrvDO.QUAN_MED, MedSrvDO.ID_UNIT_MED, MedSrvDO.FG_SET, MedSrvDO.ID_SRVCA, MedSrvDO.SD_SRVTP,
				MedSrvDO.PRI, MedSrvDO.DS, MedSrvDO.SHORTNAME, MedSrvDO.FG_CTM };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "开单类型",  "服务名称", "编码", "助记码"};
	}

	@Override
	public String getPkFieldCode() {
		return MedSrvDO.ID_SRV;
	}

	@Override
	public String getRefCodeField() {
		return MedSrvDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MedSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return "bdsrvmm";//new MedSrvDO().getTableName();
	}

	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}

	@Override
	public String getRefSql() {
		
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = getMedSrvSQL();

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
		}

		return refSql;
	}

	/**
	 * 获得查询语句
	 * 
	 * @return
	 */
	protected String getMedSrvSQL() {

		StringBuffer refSqlBuffer = new StringBuffer();
		refSqlBuffer.append("select udisrvtp.ctrl2 name_srvtp,bdsrvmm.*");		
		refSqlBuffer.append(" from ");
		refSqlBuffer.append("(" + this.getBdSrvMmSql() + ") bdsrvmm ");
		refSqlBuffer.append(", bd_udidoc udisrvtp ");
		refSqlBuffer.append(" where udisrvtp.code = bdsrvmm.ctm_srvtp and udisrvtp.id_udidoclist = '"+IBdSrvDictCodeTypeConst.ID_SRVTP+"'");
		
		List<String> wherePart = this.getWherePart();
		List<String> orderPart = this.getOrderPart();
		if(wherePart!=null&&wherePart.size()>0){
			refSqlBuffer.append(" ");			
			for(String wp : wherePart){
				refSqlBuffer.append(" and "+ wp);
			}
		}
		
		if(orderPart!=null&&orderPart.size()>0){
			refSqlBuffer.append(" order by bdsrvmm.name,bdsrvmm.code ");
			for(String orp : orderPart){
				refSqlBuffer.append(","+ orp);
			}
		}
		return refSqlBuffer.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart.replaceAll("bd_srv.", "bdsrvmm.")));

		String srvtp = (String) this.getExtendAttributeValue("Sd_srvtp");
		String wherePart = (String) this.getExtendAttributeValue("wherePart");

		if (StringUtils.isNotEmpty(wherePart)) {
			if (!wherePart.trim().toLowerCase().startsWith("and")) {
				stringBuilder.append(" and ");
			}
			stringBuilder.append(wherePart);
		}

		return stringBuilder.toString();
	}
	
	protected String getBdSrvMmSql(){
		
		StringBuffer bdSrvMmBuffer = new StringBuffer();
		bdSrvMmBuffer.append("select ");
		bdSrvMmBuffer.append("bdsrv.Name");
		bdSrvMmBuffer.append(",bdsrv.Code" );
		bdSrvMmBuffer.append(",bdsrv.Mnecode");
		bdSrvMmBuffer.append(",bdsrv.Fg_mm" );
		bdSrvMmBuffer.append(",bdsrv.Id_srv" );
		bdSrvMmBuffer.append(",bdsrv.Id_srvtp" );
		bdSrvMmBuffer.append(",bdsrv.Fg_or" );
		bdSrvMmBuffer.append(",bdsrv.Fg_active"); 
		bdSrvMmBuffer.append(",bdsrv.Quan_med" );
		bdSrvMmBuffer.append(",bdsrv.Id_unit_med"); 
		bdSrvMmBuffer.append(",bdsrv.Fg_set" );
		bdSrvMmBuffer.append(",bdsrv.Id_srvca" );
		bdSrvMmBuffer.append(",bdsrv.Sd_srvtp" );
		bdSrvMmBuffer.append(",bdsrv.Pri" );
		bdSrvMmBuffer.append(",bdsrv.Ds" );
		bdSrvMmBuffer.append(",bdsrv.Shortname"); 
		bdSrvMmBuffer.append(",bdsrv.Fg_ctm ");
		bdSrvMmBuffer.append(",decode(substr(sd_srvtp, 1, 2), '01', substr(sd_srvtp, 1, 4), '14', substr(sd_srvtp, 1, 4), substr(sd_srvtp, 1, 2)) ctm_srvtp");
		bdSrvMmBuffer.append(",bdsrv.id_org");
		bdSrvMmBuffer.append(",bdsrv.Pycode");
		bdSrvMmBuffer.append(" from bd_srv bdsrv where bdsrv.fg_active='Y' and bdsrv.ds=0 and bdsrv.fg_or='Y' and fg_mm = 'N' and bdsrv.fg_use_ip='Y'");
		
		bdSrvMmBuffer.append(" union all ");
		
		bdSrvMmBuffer.append("select ");
		bdSrvMmBuffer.append("bdsrv.Name as name");
		bdSrvMmBuffer.append(",bdsrv.Code" );
		bdSrvMmBuffer.append(",bdsrv.Mnecode");
		bdSrvMmBuffer.append(",bdsrv.Fg_mm" );
		bdSrvMmBuffer.append(",bdsrv.Id_srv" );
		bdSrvMmBuffer.append(",bdsrv.Id_srvtp" );
		bdSrvMmBuffer.append(",bdsrv.Fg_or" );
		bdSrvMmBuffer.append(",bdsrv.Fg_active"); 
		bdSrvMmBuffer.append(",bdsrv.Quan_med" );
		bdSrvMmBuffer.append(",bdsrv.Id_unit_med"); 
		bdSrvMmBuffer.append(",bdsrv.Fg_set" );
		bdSrvMmBuffer.append(",bdsrv.Id_srvca" );
		bdSrvMmBuffer.append(",bdsrv.Sd_srvtp" );
		bdSrvMmBuffer.append(",bdsrv.Pri" );
		bdSrvMmBuffer.append(",bdsrv.Ds" );
		bdSrvMmBuffer.append(",bdsrv.Shortname"); 
		bdSrvMmBuffer.append(",bdsrv.Fg_ctm");
		bdSrvMmBuffer.append(",decode(substr(sd_srvtp, 1, 2), '01', substr(sd_srvtp, 1, 4), '14', substr(sd_srvtp, 1, 4), substr(sd_srvtp, 1, 2)) ctm_srvtp");
		bdSrvMmBuffer.append(",bdsrv.id_org");
		bdSrvMmBuffer.append(",bdsrv.Pycode");
		bdSrvMmBuffer.append(" from bd_srv bdsrv where bdsrv.fg_active='Y' and bdsrv.ds=0 and bdsrv.fg_or='Y' and fg_mm = 'Y' and bdsrv.fg_use_ip='Y'");
		bdSrvMmBuffer.append(" and bdsrv.fg_mm='Y' and exists (select 1 from bd_mm bdmm where bdmm.fg_active='Y' and bdmm.ds=0 and bdmm.fg_use_ip='Y' and bdmm.fg_out = 'N' )");
		
		return bdSrvMmBuffer.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.toString();
	}

	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "name", MedSrvDO.CODE, MedSrvDO.PYCODE, MedSrvDO.MNECODE };
	}
}
