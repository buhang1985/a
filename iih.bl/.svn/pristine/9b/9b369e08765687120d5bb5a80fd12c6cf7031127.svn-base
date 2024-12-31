package iih.bl.pay.s.bp;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BlPrepayPatReprintDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pay.blpaypat.i.IBlpaypatreprintCudService;
import iih.bl.pay.blpaypat.i.IBlpaypatreprintRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 保存预交金重打记录
 * @author 
 *
 */
public class BlPaySaveReprintPrepayInfoBP {
	
	/**
	 * 保存预交金重打记录
	 * @param paypatId 患者预交金收付款id
	 * @param idResReprint 重打原因
	 * @throws BizException
	 * @author liwenqiang
	 * 
	 */
	public void exec(String paypatId,String idResReprint) throws BizException{
		if(StringUtil.isEmpty(paypatId)){
			throw new BizException("收付款Id不能为空");
		}
		//组装重打数据
		BlPrepayPatReprintDO reprintDo=new BlPrepayPatReprintDO();
		reprintDo.setId_org(Context.get().getOrgId());
		reprintDo.setId_grp(Context.get().getGroupId());
		//就诊编号
		IBlpaypatRService service=ServiceFinder.find(IBlpaypatRService.class);
		BlPrePayPatDO prePayPat=service.findById(paypatId);
		reprintDo.setId_ent(prePayPat.getId_ent());
		reprintDo.setId_pat(prePayPat.getId_pat());
		reprintDo.setDt_reprint(new FDateTime());
		reprintDo.setId_paypat(paypatId);
		reprintDo.setId_emp_org(Context.get().getOrgId());
		reprintDo.setId_emp_grp(Context.get().getGroupId());
		reprintDo.setId_emp_reprint(Context.get().getUserId());
		//重打次数
		IBlpaypatreprintRService reprintRservice=ServiceFinder.find(IBlpaypatreprintRService.class);
		BlPrepayPatReprintDO[] reprints= reprintRservice.find("id_paypat='"+paypatId+"'", "", FBoolean.FALSE);
		reprintDo.setReprint_times(reprints.length+1);
		reprintDo.setId_res_reprint(idResReprint);
		//查询重打原因
		IUdidocRService udidocRService=ServiceFinder.find(IUdidocRService.class);
		UdidocDO udidoc=udidocRService.findById(idResReprint);
		reprintDo.setSd_res_reprint(udidoc.getCode());
		//保存重打记录
		IBlpaypatreprintCudService reprintCudService=ServiceFinder.find(IBlpaypatreprintCudService.class);
		reprintCudService.insert(new BlPrepayPatReprintDO[]{reprintDo});
	}
}
