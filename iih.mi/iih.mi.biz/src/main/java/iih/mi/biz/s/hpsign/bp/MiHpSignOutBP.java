package iih.mi.biz.s.hpsign.bp;

import iih.bd.base.utils.AppUtils;
import iih.mi.biz.hpsignin.d.MiHpSignInDO;
import iih.mi.biz.hpsignin.i.IHpsigninCudService;
import iih.mi.biz.hpsignin.i.IHpsigninRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医保签退
 * @author ly 2018/03/14
 *
 */
public class MiHpSignOutBP {

	/**
	 * 签退
	 * @param empId操作员ID
	 * @param bizType 业务类型
	 * @throws BizException
	 */
	public void exec(String empId,String bizNo) throws BizException {
		
		if (StringUtil.isEmpty(empId)) {
			throw new BizException("医保签到:操作人员不能为空");
		}
		
		//获取当前用户是否有业务周期号 如果有 返回异常
		MiHpSignInDO[] signDos = this.findSignInfo(empId,bizNo);
		if(ArrayUtil.isEmpty(signDos))
			return;
		
		if(signDos.length > 1 ){
			throw new BizException("当前用户有多条签到数据，请及时联系管理员");
		}
		
		signDos[0].setDt_e(new FDateTime());
		signDos[0].setFg_active(FBoolean.FALSE);
		signDos[0].setStatus(DOStatus.UPDATED);
		signDos[0].setDt_e(AppUtils.getServerDateTime());
		//保存签到数据
		IHpsigninCudService cudService = ServiceFinder.find(IHpsigninCudService.class);
		cudService.save(signDos);
		
	}
	
	/**
	 * 查询登记信息
	 * @param empId
	 * @param bizCode
	 * @param bizType
	 * @return
	 * @throws BizException
	 */
	private MiHpSignInDO[] findSignInfo(String empId,String bizNo)throws BizException {
		
		IHpsigninRService rService = ServiceFinder.find(IHpsigninRService.class);
		
		String sqlWhere = " id_emp='" + empId + "' and fg_active='Y' and code_business='"+bizNo+"'";		
		MiHpSignInDO[] rlt = rService.find(sqlWhere, "", FBoolean.FALSE);
		return rlt;
	}
}
