package iih.nm.nhr.psnshiftdto.d;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.INmNurDictCodeConst;
import iih.nm.nhr.nmpsnshift.d.NmNurTransDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.server.WfFormInfoCtx;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年1月4日 下午7:20:04
 * 类说明：
 * Company: Copyright 2016 by PKU healthcare IT Co.Ltd.
 */
public class NmNurTransFormDO extends NmNurTransDO implements WfFormInfoCtx {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 private final String TITLE_FIELD = "hpcp_title";
	
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
		if(TITLE_FIELD.equalsIgnoreCase(attrbute)){
			String plName = "人员(" + this.getName_nur() + ")";
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
			String sdSuPl = this.getSd_applystatus();
			if (INmNurDictCodeConst.SD_APPLY_STATUS_COMMIT.equals(sdSuPl)) {
				opt = "提交";
			} else if (INmNurDictCodeConst.SD_APPLY_STATUS_PASS.equals(sdSuPl)) {
				opt = "审核通过";
			} else if (INmNurDictCodeConst.SD_APPLY_STATUS_REJECT.equals(sdSuPl)) {
				opt = "审核驳回";
			}
			
			title.append("用户[" + createUserName + "]" + opt + "了[" + plName + "] 的调动记录");
			return title.toString();
		}
		return this.getAttrVal(attrbute);
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
		
		return this.getId_nur_trans();
	}

	@Override
	public String getFrmStateField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrmTaskPkField() {

		return NmNurTransDO.ID_TASK;
	}

	@Override
	public String getFrmTitileField() {
		// TODO Auto-generated method stub
		return TITLE_FIELD;
	}

	@Override
	public void setAttributeValue(String name, Object value) {
		if(name != null && value != null){
			this.setAttrVal(name, value);
		}

	}

}
