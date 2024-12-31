package iih.bd.srv.mrctmca.refs;

import java.util.List;

import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.mrctmca.d.MrCaCtmItmDO;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年5月10日 下午3:59:27 类说明：自定义分类项目参照，用于文书结构化存储 Company: Copyright
 *          2017 by PKU healthcare IT Co.,Ltd.
 */
public class MrCaCtmRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_ctm", "name_mrtp" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MrCtmCaDO.ID_MRCACTM, MrTpDO.ID_MRTP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "自定义分类名称", "医疗记录类型名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "name" };
	}
	
	@Override
	public String getPkFieldCode() {
		return MrCaCtmItmDO.ID_MRCACTMITM;
	}

	@Override
	public String getTableName() {
		return " mrtp ";
	}

	@Override
	public String getRefCodeField() {
		return MrCtmCaDO.ID_MRCACTM;
	}

	@Override
	public String getRefNameField() {
		return MrTpDO.ID_MRTP;
	}

	@Override
	public String getRefSql() {

		StringBuffer sqlString = new StringBuffer();

		sqlString.append(" select bd_mrca_ctm.name as name_ctm,");
		sqlString.append(" mrtp.name as name_mrtp,");
		sqlString.append(" bd_mrca_ctm.id_mrcactm,");
		sqlString.append(" mrtp.id_mrtp");
		sqlString.append("  from bd_mrca_ctm_itm ctmitm ");
		sqlString.append(" inner join bd_mrtp mrtp on mrtp.id_mrtp = ctmitm.id_mrtp");
		sqlString.append(
				" inner join bd_mrca_ctm bd_mrca_ctm on bd_mrca_ctm.id_mrcactm = ctmitm.id_mrcactm where ctmitm.ds=0 and bd_mrca_ctm.docornur in( 20,30) ");

		
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MrCaCtmItmDO(), "ctmitm");
		BdModeWherePart = String.format(" and %s ", BdModeWherePart);
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sqlString.append(" and (").append(where).append(") ");
			}
		}
		
		sqlString.append(BdModeWherePart);
		
		return sqlString.toString();
	}
}
