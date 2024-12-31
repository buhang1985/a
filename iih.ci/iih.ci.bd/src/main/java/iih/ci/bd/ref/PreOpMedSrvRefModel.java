package iih.ci.bd.ref;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.bd.utils.BdEnvContextUtil;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.refinfo.RefGridModel;

public class PreOpMedSrvRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MedSrvDO.NAME, MedSrvDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "服务名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MedSrvDO.FG_MM, MedSrvDO.ID_SRV, MedSrvDO.ID_SRVTP, MedSrvDO.FG_OR,
				MedSrvDO.QUAN_MED, MedSrvDO.ID_UNIT_MED, MedSrvDO.FG_SET, MedSrvDO.ID_SRVCA, MedSrvDO.SD_SRVTP,
				MedSrvDO.PRI};
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MedSrvDO.NAME, MedSrvDO.CODE, MedSrvDO.PYCODE, MedSrvDO.WBCODE, MedSrvDO.MNECODE };
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
		return MedSrvDODesc.TABLE_NAME;
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (StringUtils.isNotEmpty(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (StringUtils.isNotEmpty(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = getMedSrvSQL();

		} finally {
			if (StringUtils.isNotEmpty(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (StringUtils.isNotEmpty(orderPart)) {
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
		return super.getRefSql();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("fg_or = 'Y' and ds = 0 and fg_active = 'Y' and fg_use_pip='Y' and ((fg_bl = 'Y'and bd_srv.fg_active_bl='Y') or fg_bl='N') ");
		
//		Object objValue = this.getExtendAttributeValue("");
//		if(objValue!=null && objValue instanceof CiEnContextDTO){
//			CiEnContextDTO ctx=(CiEnContextDTO)objValue;
//			if(ctx.getCode_entp()!=null && "".equals(ctx.getCode_entp())){
//				
//			}
//			
//		}		

		/*String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));*/

		String wherePart = (String) this.getExtendAttributeValue("wherePart");
		if (StringUtils.isNotEmpty(wherePart)) {
			stringBuilder.append(wherePart);
		}
		
		// 获取客户端参照过滤条件
		/*List<String> whereList = this.getWherePart();
		if(null != whereList && whereList.size() > 0) {
			stringBuilder.append(" and ");
			for(String item : whereList) {
				stringBuilder.append(item);
			}
		}*/

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", MedSrvDO.CODE));
		return stringBuilder.toString();
	}
}
