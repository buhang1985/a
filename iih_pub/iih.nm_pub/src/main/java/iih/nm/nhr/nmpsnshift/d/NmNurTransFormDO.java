package iih.nm.nhr.nmpsnshift.d;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.INmNurDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.server.WfFormInfoCtx;

public class NmNurTransFormDO implements WfFormInfoCtx {

	private static final long serialVersionUID = 1L;
	private final String TITLE_FIELD = "NmNurTran_title";

	private NmNurTransDO _transDo;

	public void setTransDo(NmNurTransDO transDO) {
		this._transDo = transDO;
	}

	public NmNurTransDO getTransDo() {

		if (_transDo == null) {

			return new NmNurTransDO();
		} else {

			return this._transDo;
		}
	}

	@Override
	public String getFrmInsPk() {
		// TODO Auto-generated method stub
		return _transDo.getId_nur_trans();
	}

	@Override
	public String getFrmTaskPkField() {

		return _transDo.ID_TASK;
	}

	@Override
	public void setAttributeValue(String name, Object value) {
		if (name != null && value != null) {
			this._transDo.setAttrVal(name, value);
		}
	}

	@Override
	public Object getAttributeValue(String attrbute) {
		if (TITLE_FIELD.equalsIgnoreCase(attrbute)) {
			String plName = "人员(" + this._transDo.getName_nur() + ")";
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
			String sdSuPl = this._transDo.getSd_applystatus();
			if ("02".equals(sdSuPl)) {
				opt = "提交";
			} else if ("03".equals(sdSuPl)) {
				opt = "审核通过";
			} else if ("04".equals(sdSuPl)) {
				opt = "驳回";
			}

			title.append("用户[" + createUserName + "]" + opt + "了[" + plName + "] 的调动记录");
			return title.toString();
		}
		return this._transDo.getAttrVal(attrbute);
	}

	@Override
	public Object getAllLevelAttributeValue(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeDateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeDeptField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeNumbField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillMakeUserField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmAuditDateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmAuditUserField() {
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
		// TODO Auto-generated method stub
		return null;
	}

}
