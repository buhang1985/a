package iih.bl.inc.s.task;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.blinciss.i.IBlincissCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 
 * 第三方系统领取预交金票据任务
 * @author ly 2018/09/19
 *
 */
public class ThridSystemGetReceiptTask implements IBackgroundWorkPlugin {

	private FDateTime now;
	
	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		
		Context.get().setGroupId("0001HH100000000001OE");
		Context.get().setGroupNumber("1001");
		Context.get().setOrgId("0001Z8100000000006BQ");//兰陵县医院
		Context.get().setUserId("0001Z810000000000DZO");//管理员
		now = AppUtils.getServerDateTime();
		
		//以后再适配多种情况
		String opBeginCode  = "zz001";
		String ipBeginCode = "zz021";
		
		String[] opArr = this.splitLetter(opBeginCode);
		String opHead = opArr[0];
		int opBeginNum = Integer.parseInt(opArr[1]);
		
		
		
		for (int i = 0; i < 20; i++) {
			
			int num = opBeginNum + i;
			String psnCode = this.getPsnCode(opHead, opBeginCode.length(), num);
			
			IPsndocMDORService psnService = ServiceFinder.find(IPsndocMDORService.class);
			PsnDocDO[] psnDos = psnService.findByAttrValString(PsnDocDO.CODE, psnCode);
			if(ArrayUtil.isEmpty(psnDos)){
				throw new BizException("根据该人员编码未查询到对应人员,编码:" + psnCode);
			}
			
			Context.get().setStuffId(psnDos[0].getId_psndoc());
			
			String numStr = Integer.toString(num);
			String codeBegin = "1" + (numStr.length() > 1 ? numStr : "0" + numStr) + "00000000";
			String codeEnd = "1" + (numStr.length() > 1 ? numStr : "0" + numStr) + "99999999";
			
			BlIncIssDO incDO = this.assembleData(psnCode, true, codeBegin, codeEnd);
			
			IBlincissCudService issService = ServiceFinder.find(IBlincissCudService.class);
			issService.insert(new BlIncIssDO[]{incDO});
		}		
		
		String[] ipArr = this.splitLetter(ipBeginCode);
		String ipHead = opArr[0];
		int ipBeginNum = Integer.parseInt(ipArr[1]);
		
		for (int i = 0; i < 40; i++) {
			
			int num = ipBeginNum + i;
			String psnCode = this.getPsnCode(ipHead, ipBeginCode.length(), num);
			
			IPsndocMDORService psnService = ServiceFinder.find(IPsndocMDORService.class);
			PsnDocDO[] psnDos = psnService.findByAttrValString(PsnDocDO.CODE, psnCode);
			if(ArrayUtil.isEmpty(psnDos)){
				throw new BizException("根据该人员编码未查询到对应人员,编码:" + psnCode);
			}
			
			Context.get().setStuffId(psnDos[0].getId_psndoc());
			
			String numStr = Integer.toString(num);
			String codeBegin = "1" + (numStr.length() > 1 ? numStr : "0" + numStr) + "00000000";
			String codeEnd = "1" + (numStr.length() > 1 ? numStr : "0" + numStr) + "99999999";
			
			BlIncIssDO incDO = this.assembleData(psnCode, false, codeBegin, codeEnd);
			
			IBlincissCudService issService = ServiceFinder.find(IBlincissCudService.class);
			issService.insert(new BlIncIssDO[]{incDO});
		}

		return null;
	}
	
	/**
	 * 分隔字母和数字
	 * @param code
	 * @return
	 */
	private String[] splitLetter(String code){
		
		int splitIndex = -1;
		char[] c = code.toCharArray();
		for (int i = c.length - 1; i >= 0; i--) {
			if((int)c[i] < 48 || (int)c[i] > 57){
				splitIndex = i;
				break;
			}
			
			if(c.length - i > 9){
				splitIndex = i;
				break;
			}
		}
		
		
		
		String[] array = new String[2];
		array[0] = code.substring(0, splitIndex + 1);
		array[1] = code.substring(splitIndex + 1, code.length());
		
		return array;
	}
	
	/**
	 * 获取人员编码
	 * @param beginCode
	 * @param next
	 * @return
	 */
	private String getPsnCode(String head,int lenth,int num){
		
		String strNum = Integer.toString(num);
		int diffLenth = lenth - head.length() - strNum.length();
		for (int i = 0; i < diffLenth; i++) {
			strNum = "0" + strNum;
		}
		
		return head + strNum;
	}

	/**
	 * 组装票据领用数据
	 * @return
	 * @throws BizException
	 */
	private BlIncIssDO assembleData(String pkgCode, boolean op,
			String codeBegin, String codeEnd) throws BizException {
	
		BlIncIssDO incDO = new BlIncIssDO();
		incDO.setId_grp(Context.get().getGroupId());
		incDO.setId_org(Context.get().getOrgId());
		incDO.setId_incca(op ?  IBdPpCodeTypeConst.ID_OUTPATIENT_DEPOSIT : IBdPpCodeTypeConst.ID_INHOS_DEPOSIT);
		incDO.setCode_incpkg(pkgCode);
		incDO.setId_emp_iss(Context.get().getStuffId());
		incDO.setDt_iss(now);
		incDO.setNum_b(codeBegin);
		incDO.setNum_e(codeEnd);
		incDO.setInccn(calNum(codeBegin, codeEnd));
		incDO.setInccn_use(0);
		incDO.setIncno_cur(codeBegin);
		incDO.setFg_curuse(FBoolean.TRUE);
		incDO.setFg_active(FBoolean.TRUE);
		incDO.setInccn_trans(0);
		incDO.setInccn_canc(0);
		incDO.setInccn_ret(0);
		incDO.setInccn_wf(0);
		incDO.setNote("init");
		
		incDO.setStatus(DOStatus.NEW);
		return incDO;
	}
	
	private int calNum(String begin, String end) {

		String[] beginArr = splitLetter(begin);
		String[] endArr = splitLetter(end);
		
		return  Integer.parseInt(endArr[1]) - Integer.parseInt(beginArr[1]) + 1;
		
	}
}
