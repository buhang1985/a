package iih.bd.srv.RefModels;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvVtDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class SrvVtRefModel2 extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { MedSrvDO.NAME, MedSrvDO.CODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { MedSrvDO.ID_SRV, MedSrvVtDO.ID_SRVVT };
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[] { "服务名称", "编码" };
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return MedSrvDO.ID_SRV;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return MedSrvDO.CODE;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return MedSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return "srv";
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "code", "name", "Wbcode", "Pycode" };
	}

	@Override
	public String getRefSql() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                             ");
		sqlStr.append(" srv.name,                                                          ");
		sqlStr.append(" srv.code,                                                          ");
		sqlStr.append(" srv.id_srv,                                                        ");
		sqlStr.append(" srvvt.id_srvvt                                                     ");
		sqlStr.append(" from  BD_SRV srv                                              ");
		sqlStr.append(" inner join BD_SRV_VT srvvt on srvvt.id_srv = srv.id_srv and srv.ds='0'  ");
		sqlStr.append(" where " + BdEnvContextUtil.processEnvContext(new MedSrvDO(), "srv"));
		sqlStr.append(" and srvvt.ds = '0' and srv.sd_srvtp='" + IBdSrvDictCodeConst.SD_SRVTP_NURSE_VS + "'");
		List<String> listWhere = this.getWherePart();
		if (listWhere.size() > 0) {
			for (String whereStr : listWhere) {
				if (!StringUtil.isEmpty(whereStr)) {
					sqlStr.append(" and ( ");
					sqlStr.append(whereStr);
					sqlStr.append(" )");
				}
			}
		}
		return sqlStr.toString();
	}
}
