package iih.hp.cp.hpcp.d;

import iih.bd.bc.udi.pub.IHPDictCodeConst;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.server.WfFormInfoCtx;

public class HpcpFormAggDO extends HpcpAggDO implements WfFormInfoCtx {
	private static final long serialVersionUID = 1L;
    private final String TITLE_FIELD = "hpcp_title";
	
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
		return this.getParentDO().ID_TASK;
	}

	@Override
	public String getFrmInsPk() {
		return this.getParentDO().getId_cp();
	}

	@Override
	public Object getAttributeValue(String attrbute) {
		if(TITLE_FIELD.equalsIgnoreCase(attrbute)){
			String plName = "诊疗计划(" + this.getParentDO().getCode() + ")";
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
			String sdSuPl = this.getParentDO().getSd_status();
			if (IHPDictCodeConst.SD_HPCP_STATUS_SUBMIT.equals(sdSuPl)) {
				opt = "提交";
			} else if (IHPDictCodeConst.SD_HPCP_STATUS_NEW.equals(sdSuPl) && StringUtils.isNotEmpty(this.getParentDO().getId_task())) {
				opt = "取回";
			} else if (IHPDictCodeConst.SD_HPCP_STATUS_EXAMCOM.equals(sdSuPl) || IHPDictCodeConst.SD_HPCP_STATUS_EXAMING.equals(sdSuPl)) {
				opt = "审核通过";
			} else if (IHPDictCodeConst.SD_HPCP_STATUS_REJECT.equals(sdSuPl)) {
				opt = "审核驳回";
			} 
			
			title.append("用户[" + createUserName + "]" + opt + "了[" + plName + "]");
			return title.toString();
		}
		return this.getParentDO().getAttrVal(attrbute);
	}

	@Override
	public Object getAllLevelAttributeValue(String attrbute, String BeanID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttributeValue(String name, Object value) {
		if(name != null && value != null){
			// 保存节点任务主键，用于判断当前登录人是否可以审核，但当有多个审核人时，hp_cp中只保留一个id_task ，会导致有用户无法操作审核按钮
			this.getParentDO().setAttrVal(name, value);
		}
	}

	@Override
	public String[] getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}
}
