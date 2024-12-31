package iih.cssd.dpus.dfpisu.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.utils.BdEnvContextUtil;
import iih.cssd.dpus.dfpisu.d.DfpSendDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class DfpSendRefsModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DfpSendDO.SENDNO, DfpSendDO.DT_SEND, "Name_eu_send", DfpSendDO.NOTE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DfpSendDO.ID_DFP_SEND };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "发放单号", "发放时间", "状态", "备注" };
	}
	
	@Override
	public String getRefNameField() {
		return DfpSendDO.SENDNO;
	}
	
	@Override
	public String getPkFieldCode() {
		return DfpSendDO.ID_DFP_SEND;
	}

	@Override
	public String getTableName() {
		return new DfpSendDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DfpSendDO.SENDNO };
	}

	@Override
	public String getRefSql() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" SELECT                                                                                                          ");
		sqlStr.append(" cssd_dfp_send.SENDNO,                                                                                           ");
		sqlStr.append(" cssd_dfp_send.DT_SEND,                                                                                          ");
		sqlStr.append(" e0.NAME as NAME_EU_SEND,                                                                                        ");
		sqlStr.append(" cssd_dfp_send.NOTE,                                                                                             ");
		sqlStr.append(" cssd_dfp_send.ID_DFP_SEND,                                                                                      ");
		sqlStr.append(" cssd_dfp_send.ID_ORG,                                                                                           ");
		sqlStr.append(" cssd_dfp_send.ID_GRP,                                                                                           ");
		sqlStr.append(" cssd_dfp_send.EU_SEND,                                                                                          ");
		sqlStr.append(" cssd_dfp_send.ID_DEP_SEND,                                                                                      ");
		sqlStr.append(" cssd_dfp_sendb11.NAME as NAME_DEP_SEND,                                                                         ");
		sqlStr.append(" cssd_dfp_send.ID_EMP_SEND,                                                                                      ");
		sqlStr.append(" cssd_dfp_sendb5.NAME as NAME_SEND,                                                                              ");
		sqlStr.append(" cssd_dfp_send.CREATEDBY,                                                                                        ");
		sqlStr.append(" cssd_dfp_send.CREATEDTIME,                                                                                      ");
		sqlStr.append(" cssd_dfp_send.MODIFIEDBY,                                                                                       ");
		sqlStr.append(" cssd_dfp_send.MODIFIEDTIME                                                                                      ");
		sqlStr.append(" FROM CSSD_DFP_SEND cssd_dfp_send                                                                                ");
		sqlStr.append(" left join dm_enumvalue e0 on cssd_dfp_send.EU_SEND = e0.VALUE and e0.ID='C89A577E-BE90-0001-638F-34A015E01D69'  ");
		sqlStr.append(" left join bd_dep cssd_dfp_sendb11 on cssd_dfp_send.ID_DEP_SEND = cssd_dfp_sendb11.ID_DEP                        ");                      
		sqlStr.append(" left join bd_psndoc cssd_dfp_sendb5 on cssd_dfp_send.ID_EMP_SEND = cssd_dfp_sendb5.ID_PSNDOC                    ");
		sqlStr.append(" where cssd_dfp_send.ds = 0                                                                                      ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DfpSendDO(), "cssd_dfp_send");
		sqlStr.append(String.format(" and %s ", BdModeWherePart));
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			
			for (String where : this.getWherePart()) {
				sqlStr.append(" and (").append(where).append(") ");
			}
		}
		sqlStr.append(" order by cssd_dfp_send.DT_SEND desc ");
		return sqlStr.toString();
	}
	
	@Override
	public List<String> getOrderPart() {
		List<String> order = new ArrayList<String>();
		order.add(DfpSendDO.DT_SEND);
		return order;
	}
}
