package iih.nm.nbd.nbdntpl.refs;

import iih.nm.nbd.nbdkpi.d.NbdKpiDO;
import iih.nm.nbd.nbdkpi.d.desc.NbdKpiDODesc;
import iih.nm.nbd.nbdntpl.d.NbdNtplDO;
import xap.sys.appfw.refinfo.RefTreeGridModel;

public class NbdNtplRefModel extends RefTreeGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NbdNtplDO.CODE, NbdNtplDO.NAME, NbdNtplDO.VERSION };		
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "版本" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NbdNtplDO.ID_NBD_NTPL, NbdNtplDO.ID_NBD_KPI };
	}

	@Override
	public String getPkFieldCode() {
		return NbdNtplDO.ID_NBD_NTPL;
	}

	@Override
	public String getRefCodeField() {
		return NbdNtplDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return NbdNtplDO.NAME;
	}

	@Override
	public String getTableName() {
		return new NbdNtplDO().getTableName();
	}

	@Override
	public String getClassPkFieldCode() {
		return NbdKpiDO.ID_NBD_KPI;
	}

	@Override
	public String[] getClassFieldCode() {
		return new String[] { NbdKpiDO.ID_NBD_KPI, NbdKpiDO.CODE, NbdKpiDO.NAME, NbdKpiDO.ID_PAR };
	}

	@Override
	public String getClassRefNameField() {
		return NbdKpiDO.NAME;
	}

	@Override
	public String getClassRefCodeField() {
		return NbdKpiDO.CODE;
	}

	@Override
	public String getClassTableName() {
		return NbdKpiDODesc.TABLE_NAME;
	}

	@Override
	public String getDocJoinField() {
		return NbdNtplDO.ID_NBD_KPI;
	}

	@Override
	public String getClassJoinField() {
		return NbdKpiDO.ID_NBD_KPI;
	}

	@Override
	public String getFatherField() {
		return NbdKpiDO.ID_PAR;
	}

	@Override
	public String getChildField() {
		return NbdKpiDO.ID_NBD_KPI;
	}

	@Override
	public String[] getClassWherePart() {
		// TODO Auto-generated method stub
		return super.getClassWherePart();
	}

	@Override
	public String[] getClassOrderPart() {
		// TODO Auto-generated method stub
		return super.getClassOrderPart();
	}
}
