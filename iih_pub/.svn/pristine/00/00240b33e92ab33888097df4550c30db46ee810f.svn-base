package iih.mm.pl.stockplan.d;

import iih.bd.bc.udi.pub.IMmDictCodeConst;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.server.WfFormInfoCtx;

public class StockPlanFormAggDO extends StockplanAggDO implements WfFormInfoCtx {
	private final String TITLE_FIELD = "test_title";
	
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
	public Object getAttributeValue(String arg0) {
		if(TITLE_FIELD.equalsIgnoreCase(arg0)){
			String plName = this.getParentDO().getName();
			String createUserId = this.getParentDO().getCreatedby();
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
			String sdSuPl = this.getParentDO().getSd_su_pl();
			if (IMmDictCodeConst.SD_SU_PL_SUBMIT.equals(sdSuPl)) {
				opt = "提交";
			} else if (IMmDictCodeConst.SD_SU_PL_CONFIRM_PASS.equals(sdSuPl)) {
				opt = "审核通过";
			} else if (IMmDictCodeConst.SD_SU_PL_CONFIRM_REFUSE.equals(sdSuPl)) {
				opt = "审核驳回";
			} else {
				opt = "修改";
			}
			
			
			title.append("用户[" + createUserName + "]" + opt + "了[" + plName + "]");
			return title.toString();
		}
		return this.getParentDO().getAttrVal(arg0);
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
	public String getFrmInsPk() {
		return this.getParentDO().getPkVal();
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

//	@Override
//	public String getTaskId() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void setAttributeValue(String arg0, Object arg1) {
		if(arg0 != null && arg1 != null){
			this.getParentDO().setAttrVal(arg0, arg1);
		}
		
	}

	@Override
	public String getFrmTaskPkField() {
		// TODO Auto-generated method stub
		return null;
	}

}
