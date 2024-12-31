package iih.nm.nhr.nmnurspcev.d;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.INmNurDictCodeConst;
import iih.nm.nhr.nmnurlv.d.NmNurLvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.server.WfFormInfoCtx;

public class NmSpcEvFormDO implements WfFormInfoCtx{
	private NmSpcEvDO nmSpcevDO;
	
	
	private static final String TITLE_FIELD = " NmNurSpcev_title";
	
	public void setTransDo(NmSpcEvDO transDO) {
		this.nmSpcevDO = transDO;
	}
	
	public NmSpcEvDO getTransDo(){
		if(this.nmSpcevDO == null){
			return new NmSpcEvDO();
		}
		return this.nmSpcevDO;
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
	public Object getAttributeValue(String attrbute) {
		if (TITLE_FIELD.equalsIgnoreCase(attrbute)) {
			String plName = "人员(" + this.nmSpcevDO.getName_nur() + ")";
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
			String sdSuPl = this.nmSpcevDO.getSd_status();
			if (INmNurDictCodeConst.CODE_NMNURLV_SUBMIT_NUM.equals(sdSuPl)) {
				opt = "提交";
			} else if (INmNurDictCodeConst.CODE_NMNURLV_PASS_NUM.equals(sdSuPl)) {
				opt = "审核通过";
			} else if (INmNurDictCodeConst.CODE_NMNURLV_BACK_NUM.equals(sdSuPl)) {
				opt = "审核驳回";
			}

			title.append("用户[" + createUserName + "]" + opt + "了[" + plName + "] 的调动记录");
			return title.toString();
		}
		return this.nmSpcevDO.getAttrVal(attrbute);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmStateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmTaskPkField() {
		// TODO Auto-generated method stub
		return NmNurLvDO.ID_TASK;
	}

	@Override
	public String getFrmTitileField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttributeValue(String name, Object value) {
		if (name != null && value != null) {
			this.nmSpcevDO.setAttrVal(name, value);
		}
		
	}

}
