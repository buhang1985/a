package iih.mm.st.stockpriceadjust.d;

import iih.bd.bc.udi.pub.IMmDictCodeConst;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.server.WfFormInfoCtx;

public class StPriceAdjFormAggDO extends StockpriceadjustAggDO implements WfFormInfoCtx{
	private final String TITLE_FIELD = "stpriceadj_title";
	
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
		return this.getParentDO().getId_stpri();
	}

	@Override
	public Object getAttributeValue(String attrbute) {
		if(TITLE_FIELD.equalsIgnoreCase(attrbute)){
			String plName = "调价单(" + this.getParentDO().getCode() + ")";
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
			String sdSuPl = this.getParentDO().getSd_su_stpri();
			if (IMmDictCodeConst.SD_SU_PL_SUBMIT.equals(sdSuPl)) {
				opt = "提交";
			} else if (IMmDictCodeConst.SD_SU_PL_CONFIRM_PASS.equals(sdSuPl) || 
					IMmDictCodeConst.SD_SU_STPRI_CONFIRM_ING.equals(sdSuPl) ||
					IMmDictCodeConst.SD_SU_STPRI_COMPLETE.equals(sdSuPl)) {
				opt = "审核通过";
			} else if (IMmDictCodeConst.SD_SU_PL_CONFIRM_REFUSE.equals(sdSuPl)) {
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
			this.getParentDO().setAttrVal(name, value);
		}
	}

	@Override
	public String[] getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
