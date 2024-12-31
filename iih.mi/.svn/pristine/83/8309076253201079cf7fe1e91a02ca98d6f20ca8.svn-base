package iih.mi.biz.s.hpsign.bp;

import iih.mi.biz.hpsignin.d.MiHpSignInDO;
import iih.mi.biz.hpsignin.i.IHpsigninCudService;
import iih.mi.biz.hpsignin.i.IHpsigninRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医保签到
 * @author ly 2018/03/14
 *
 */
public class MiHpSignInBP {

	/**
	 * 医保签到
	 * @param empId 操作员ID
	 * @param bizCode 业务周期号
	 * @param bizType 业务类型
	 * @param mac mac地址
	 * @throws BizException
	 */
	public void exec(String empId, String bizCode, Integer bizType,String mac,String idHp) throws BizException {
		
		if(StringUtil.isEmpty(empId) || StringUtil.isEmpty(bizCode)){
			throw new BizException("医保签到:操作人员和业务周期号不能为空");
		}
		
		//获取当前用户是否有业务周期号 如果有 返回异常
		MiHpSignInDO[] signDos = this.findSgnInfo(empId, bizType,idHp);
		if(!ArrayUtil.isEmpty(signDos)){
			throw new BizException("当前用户已经存在签到记录，请先签退后重新签到！");
		}
		
		//保存签到数据
		MiHpSignInDO signInDO = new MiHpSignInDO();
		signInDO.setStatus(DOStatus.NEW);
		signInDO.setId_emp(empId);
		signInDO.setCode_business(bizCode);
		signInDO.setMac(mac);
		signInDO.setId_hp(idHp);
		if(bizType != null){
			signInDO.setEu_biztype(Integer.valueOf(bizType));
		}
		signInDO.setDt_b(new FDateTime());
		signInDO.setFg_active(FBoolean.TRUE);
		signInDO.setId_org(Context.get().getOrgId());
		signInDO.setId_grp(Context.get().getGroupId());

		IHpsigninCudService cudService = ServiceFinder.find(IHpsigninCudService.class);
		cudService.insert(new MiHpSignInDO[] { signInDO });
	}
	
	/**
	 * 查询登记信息
	 * @param empId
	 * @param bizCode
	 * @param bizType
	 * @return
	 * @throws BizException
	 */
	private MiHpSignInDO[] findSgnInfo(String empId, Integer bizType,String idHp)throws BizException {
		
		IHpsigninRService rService = ServiceFinder.find(IHpsigninRService.class);
		
		String sqlWhere = " id_emp='" + empId + "' and fg_active='Y' and id_hp='"+idHp+"' ";
		if(bizType != null){
			sqlWhere += " and eu_biztype = " + bizType;
		}
		
		MiHpSignInDO[] rlt = rService.find(sqlWhere, "", FBoolean.FALSE);
		return rlt;
	}
}
