package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.OtAppDTO;
import iih.sc.apt.scaptappl.d.EuAptmd;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplOptDO;
import iih.sc.apt.scaptappl.d.ScaptapplAggDO;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import iih.sc.apt.scaptappl.i.IScaptapplCudService;
import iih.sc.apt.scaptappl.i.IScaptapplRService;
import iih.sc.comm.ScCollectionUtils;
import iih.sc.comm.ScContextUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

public class SaveAddAptApplBP {
	
	/**
	 * 手术预约   手工增加申请单
	 * @param appDTO
	 * @throws BizException 
	 */
	public void exec(OtAppDTO appDTO) throws BizException
	{
		ScaptapplAggDO aggDO = null;
		if(!StringUtil.isEmpty(appDTO.getId_aptappl()))
		{
			IScaptapplRService rService = ServiceFinder.find(IScaptapplRService.class);
			aggDO = rService.findById(appDTO.getId_aptappl());
		}
		else
		{
			aggDO = new ScaptapplAggDO();
		}
		
		//申请表
        ScAptApplDO applDO = null ;
        if(StringUtil.isEmpty(appDTO.getId_aptappl()))
        {
        	applDO = new ScAptApplDO();
        	applDO.setStatus(DOStatus.NEW);
            applDO.setId_dep_mp(ScContextUtils.getDeptId());
            applDO.setId_pi(appDTO.getId_pi());
            applDO.setPiname(appDTO.getPiname());
            applDO.setId_sex(appDTO.getId_sex());
            applDO.setSd_sex(appDTO.getSd_sex());
            applDO.setD_pi(appDTO.getD_pi());
            applDO.setPimobile(appDTO.getPimobile());
            applDO.setEu_aptmd(EuAptmd.MANUAL);//预约模式--1:手工预约   0:有申请单预约
            applDO.setApplyno(this.createScAptApplCode(IScDictCodeConst.SD_SCTP_OT));//申请单号
            applDO.setFg_bl(FBoolean.FALSE);//收费标识
            applDO.setFg_comfirm(FBoolean.FALSE);//确认标识
            applDO.setId_org(ScContextUtils.getOrgId());
            applDO.setId_grp(ScContextUtils.getGrpId());
            applDO.setSd_sctp(IScDictCodeConst.SD_SCTP_OT);//排班类型
            
        }
        else
        {
        	applDO = aggDO.getParentDO();
        	applDO.setStatus(DOStatus.UPDATED);
        }

        applDO.setId_entp(appDTO.getId_enttp());//就诊类型id
        applDO.setCode_entp(appDTO.getCode_enttp());//就诊类型
        applDO.setName(appDTO.getName_or());//医嘱内容
        applDO.setId_emp_appl(appDTO.getId_emp_appl());//申请医生
        applDO.setDt_appl(appDTO.getDt_appl());//申请时间
        applDO.setId_dep_appl(appDTO.getId_appl_dep());//申请科室
        applDO.setFg_urgent(appDTO.getFg_urgent());//紧急标识
        applDO.setContent_or(appDTO.getName_or());//医嘱内容
        applDO.setDes(appDTO.getDes());//描述
    	applDO.setPriority(0);//优先级
    	applDO.setD_b(appDTO.getDt_appl().getDate());
        aggDO.setParentDO(applDO);
        
        //申请表--手术
        ScAptApplOptDO optDO = null;
        if(StringUtil.isEmpty(appDTO.getId_aptappl()))
        {
        	optDO = new ScAptApplOptDO();
        	optDO.setStatus(DOStatus.NEW);
        }
        else
        {
        	optDO = aggDO.getScAptApplOptDO()[0];
        	optDO.setStatus(DOStatus.UPDATED);
        }
        optDO.setId_anestp(appDTO.getId_anestp());//麻醉方式
        optDO.setSd_anestp(appDTO.getCode_anestp());
        optDO.setSpecialreq(appDTO.getSpecialreq());//特殊用物
        optDO.setSpecialinstrument(appDTO.getSpecialinstrument());//特殊仪器
        optDO.setSpecialdes(appDTO.getSpecialdes());//特殊准备
        optDO.setId_di(appDTO.getId_di());//诊断
        optDO.setName_di(appDTO.getName_di());
        optDO.setCode_di(appDTO.getCode_di());
        optDO.setAnnouncements(appDTO.getAnnouncements());//注意事项
        optDO.setSug_require(appDTO.getSug_require());//手术要求
        aggDO.setScAptApplOptDO(new ScAptApplOptDO[]{optDO});
        
        IScaptapplCudService cudService = ServiceFinder.find(IScaptapplCudService.class);
        cudService.save(new ScaptapplAggDO[]{aggDO});
	}
	
	/**
	 * 创建预约申请编码
	 *
	 * @author zhengcm
	 * 
	 * @param sd_entp 就诊类型编码
	 * @return 编码
	 * @throws BizException
	 */
	private String createScAptApplCode(String sd_entp) throws BizException {
		//FIXME 更换为ScCodeUtils中的创建code方法 2019年3月25日 20:52:39 yzh
		String code = this.createCode(ScAptApplDODesc.CLASS_FULLNAME);
		if (!StringUtil.isEmptyWithTrim(sd_entp)) {
			code = code.substring(0, 3) + sd_entp + code.substring(3);
		}
		return code;
	}
	/**
	 * 生成编码
	 * 
	 * @param doDescFullName 实体元数据类全名
	 * @return 根据编码规则生成编码
	 * @throws BizException
	 */
	private String createCode(String doDescFullName) throws BizException {
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = codeManage.getPreBillCode_RequiresNew(doDescFullName);
		return code;
	}
}
