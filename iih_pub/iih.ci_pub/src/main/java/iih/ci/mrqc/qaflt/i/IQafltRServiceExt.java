package iih.ci.mrqc.qaflt.i;

import iih.ci.mrqc.qaflt.d.QaFltDO;
import xap.mw.core.data.BizException;

public interface IQafltRServiceExt {

	public QaFltDO findUserAndDept( String id_ent) throws BizException;
	
	public QaFltDO findUserAndDeptNoCimrfp( String id_ent) throws BizException;
}
