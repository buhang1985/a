package iih.bd.srv.emreditor.bp;

import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

public class EmreditorBp {

	public int getMaxVersionByCode(String code) throws BizException {
		String sql = " SELECT MAX(ver) FROM　bd_mred WHERE CODE = '" + code + "' AND " + getBdModeWherePart();
		Integer version = (Integer) new DAFacade().execQuery(sql, new ColumnHandler());
		if (version != null)
			return version;
		return 0;
	}

	public String CopyEmreditor(EmrEditorDO emrEditorDO) throws BizException {
		EmrEditorDO emrDO = emrEditorDO;
		emrDO.setVer(null);
		emrDO.setSv((new FDateTime()));
		emrDO.setActivestate(1);
		String str = new DAFacade().insertDO(emrDO);
		return str;
	}

	/**
	 * 获取基础数据管控条件语句
	 * 
	 * @return
	 */
	protected String getBdModeWherePart() {
		String bdModeWherePart = BdEnvContextUtil.processEnvContext(new EmrEditorDO(), false);
		return bdModeWherePart;
	}
}
