package iih.nm.nqm.qctplmaintenance.d;

import iih.bd.bc.udi.pub.IHPDictCodeConst;
import iih.bd.bc.udi.pub.INmNurDictCodeConst;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.server.WfFormInfoCtx;

public class NmQctplFormDO implements WfFormInfoCtx {

	private static final long serialVersionUID = 1L;
	private final String TITLE_FIELD = "Qctpl_title";

	private NmQctplDO _tplDo;

	public void settplDo(NmQctplDO tplDo) {
		this._tplDo = tplDo;
	}

	public NmQctplDO gettplDo( ) {

		if (_tplDo == null) {

			return new NmQctplDO();
		} else {

			return this._tplDo;
		}
	}

	@Override
	public String getBillMakeDateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeUserField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeNumbField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeDeptField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmAuditUserField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmAuditDateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmStateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmTitileField() {
		return TITLE_FIELD;
	}

	@Override
	public String getFrmTaskPkField() {
		return this._tplDo.ID_TASK;
	}

	@Override
	public String getFrmInsPk() {
		return this._tplDo.getId_qctpl();
	}

	@Override
	public Object getAllLevelAttributeValue(String attrbute, String BeanID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttributeValue(String name, Object value) {
		if (name != null && value != null) {
			this._tplDo.setAttrVal(name, value);
		}
	}

	@Override
	public String[] getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAttributeValue(String attrbute) {
		if (TITLE_FIELD.equalsIgnoreCase(attrbute)) {
			String plName = "质量模板(" + this._tplDo.getName() + ")";
			String createUserId = Context.get().getUserId();
			StringBuffer title = new StringBuffer();

			String createUserName = "iih";
			IUserRService userRService = ServiceFinder.find(IUserRService.class);
			if (!StringUtils.isBlank(createUserId)) {
				try {
					UserDO userDO = userRService.findById(createUserId);
					if (userDO != null) {
						createUserName = userDO.getName();
					}
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			String opt = "提交";
			String sdSuPl = this._tplDo.getSd_status();
			if (INmNurDictCodeConst.SD_QCTPL_STATUS_SUBMIT.equals(sdSuPl)) {
				opt = "提交";
			} else if (IHPDictCodeConst.SD_HPCP_STATUS_EXAMCOM.equals(sdSuPl)) {
				opt = "审核通过";
			} else if (IHPDictCodeConst.SD_HPCP_STATUS_REJECT.equals(sdSuPl)) {
				opt = "审核驳回";
			}

			title.append("用户[" + createUserName + "]" + opt + "了[" + plName + "]");
			return title.toString();
		}
		return this._tplDo.getAttrVal(attrbute);
	}
}
