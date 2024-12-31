package iih.bl.cg.api.s.bp;

import iih.bl.cg.api.d.ApplyInfo;
import iih.bl.cg.api.d.UnpaidInfo;
import iih.bl.cg.bp.self.GetBlOrderBp;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;

/**
 * 获取未缴费列表
 * 
 * @author Liwq
 *
 */
public class GetUnPaymentInfosBp {

	public UnpaidInfo[] exec(String patCode, String beginDateTime, String endDateTime) throws BizException {
		if (patCode == null || beginDateTime == null || endDateTime == null) {
			throw new BizException("传入的参数不能为空！");
		}
		FDateTime beginFDateTime = new FDateTime(beginDateTime);
		FDateTime endFDateTime = new FDateTime(endDateTime);
		//调用统一方法 因获取数据相同 所以合并此功能 yang.lu 2017年10月30日11:04:23
//		List<ApplyInfo> applyInfolist=new ArrayList<ApplyInfo>();
		GetBlOrderBp bp = new GetBlOrderBp();
		ApplyInfo[] apps = bp.getApplyForBlOrder(patCode, "", beginFDateTime, endFDateTime);
//		//自费
//		ApplyInfo[] applyInfoSelf = bp.getApplyForBlOrder(patCode, "0", beginFDateTime, endFDateTime);
//		if(!ArrayUtil.isEmpty(applyInfoSelf) && applyInfoSelf.length>0){
//			for(ApplyInfo app:applyInfoSelf){
//				applyInfolist.add(app);
//			}
//		}
//		//医保
//		ApplyInfo[] applyInfoHp = bp.getApplyForBlOrder(patCode, "1", beginFDateTime, endFDateTime);
//		if(!ArrayUtil.isEmpty(applyInfoHp) && applyInfoHp.length>0){
//			for(ApplyInfo app:applyInfoHp){
//				applyInfolist.add(app);
//			}			
//		}	
//		ApplyInfo[] apps =applyInfolist.toArray(new ApplyInfo[applyInfolist.size()]);
		if(ArrayUtil.isEmpty(apps)){
			return  new UnpaidInfo[]{};
		}
		List<UnpaidInfo> ulist=new ArrayList<UnpaidInfo>();
		for (ApplyInfo appinfoInfo : apps) {
			UnpaidInfo info=new UnpaidInfo();
			info=appinfoInfo;
		//	String presNo= info.getApplyCode();
//			switch (appinfoInfo.getApplyTpCode()) {
//			case "01":
//				info.setApplyTpCode("处方:" + presNo);
//				break;
//			case "02":
//				info.setApplyTpCode("检查:" + presNo);
//				break;
//			case "03":
//				info.setApplyTpCode("检验:" + presNo);
//				break;
//			default:
//				info.setApplyTpCode("诊疗:" + presNo);
//				break;
//			}
			
			ulist.add(info);
		}
		return ulist.toArray(new UnpaidInfo[ulist.size()]);
	}

}
