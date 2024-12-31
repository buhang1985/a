package iih.ci.mrm.s.mrmprint.audlogic;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.bd.srv.mrmtype.i.IMrmtypeMDORService;
import iih.bd.srv.outputtemplate.d.OutputTemplateMedRedTypeDO;
import iih.bd.srv.outputtemplate.i.IOutputTemplateMedRedTypeDORService;
import iih.ci.mrm.bp.common.CiMrMParamUtils;
import iih.ci.mrm.cimrmcopy.d.CiMrmCopyDO;
import iih.ci.mrm.cimrmcopy.i.ICimrmcopyCudService;
import iih.ci.mrm.cimrmcopy.i.ICimrmcopyRService;
import iih.ci.mrm.cimrmsp.d.CiMrmMailDO;
import iih.ci.mrm.cimrmsp.i.ICimrmspCudService;
import iih.ci.mrm.cimrmsp.i.ICimrmspRService;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.dto.mrmprintdto.d.MrmPrintDTO;
import iih.ci.mrm.i.mrmprint.audlogic.IMrmPrintAudLogicService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces={IMrmPrintAudLogicService.class}, binding=Binding.JSONRPC)
public class IMrmPrintAudLogicServiceImpl implements IMrmPrintAudLogicService{

	/**
	 * 根据idamr查询复印历史
	 * @param id_amr
	 * @return
	 */
	@Override
	public CiMrmCopyDO[] qryCiMrmCopyDOList(String id_amr) throws BizException {
		// TODO Auto-generated method stub
		ICimrmcopyRService service =ServiceFinder.find(ICimrmcopyRService.class);
		CiMrmCopyDO[] doArr=service.find(" id_amr='"+id_amr+"'", " sv desc", FBoolean.FALSE);
		return doArr;
	}
	/**
	 * 根据参数获取打印的单价 废弃 不用
	 * @return
	 */
	@Override
	public double getPrintOnceCopyMoney() throws BizException {
		// TODO Auto-generated method stub
		double price =0.2;
		//取参数
		String srvCode=CiMrMParamUtils.getSysParamPrintCharge(Context.get().getOrgId());
		IMedsrvMDORService medSrvService=ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] srvDoArr=medSrvService.find(" code='"+srvCode+"'", " sv desc", FBoolean.FALSE);
		if (srvDoArr.length>0) {
			return srvDoArr[0].getPri().doubleValue();
		}else {
			return price;//查不出来就先按两毛一张算
		}
		
	}
	
	/**
	 * 根据输出模板 获得对应病案分类
	 * @return
	 */
	@Override
	public MrmTypeDO[] getMrmTypeDOForPrint(String id_bd_mrm_pt)
			throws BizException {
		// TODO Auto-generated method stub
		
		//查询中间表
		IOutputTemplateMedRedTypeDORService oupputService = ServiceFinder.find(IOutputTemplateMedRedTypeDORService.class);
		OutputTemplateMedRedTypeDO[] outputDoArr = oupputService.find(" id_bd_mrm_pt='"+id_bd_mrm_pt+"'", "", FBoolean.FALSE);
		if (outputDoArr.length<=0) {
			return new MrmTypeDO[]{};
		}
		//得到中间表所有的 病案分类主键
		List<String> mrm_tpIdList =new ArrayList<String>();
		for (OutputTemplateMedRedTypeDO ciMrmQryListDTO : outputDoArr) {
			mrm_tpIdList.add(ciMrmQryListDTO.getId_bd_mrm_tp());
		}
		if (mrm_tpIdList.size()<=0) {
			return new MrmTypeDO[]{};
		}
		String[] id_bd_mrm_tps = mrm_tpIdList.toArray(new String[0]);
		//根据查询出来的主键 查询病案
		IMrmtypeMDORService mrmService = ServiceFinder.find(IMrmtypeMDORService.class);
		MrmTypeDO[] mrmDos = mrmService.findByIds(id_bd_mrm_tps, FBoolean.FALSE);
		return mrmDos;
	}
	
	/**
	 * 病案复印登记信息保存（改变邮寄状态）
	 */
	public boolean saveCiMrmCopyDO(CiMrmQryListDTO ciMrmQryListDto, CiMrmCopyDO ciMrmCopyDo, MrmPrintDTO mrmPrintDto)
			throws BizException {
		
		ICimrmcopyCudService service = ServiceFinder.find(ICimrmcopyCudService.class);
		ICimrmspRService rService = ServiceFinder.find(ICimrmspRService.class);
		ICimrmspCudService cudService = ServiceFinder.find(ICimrmspCudService.class);
		
		boolean result = false;
        CiMrmCopyDO mrmCopyDo=new CiMrmCopyDO();
        
        mrmCopyDo.setId_amr(ciMrmQryListDto.getId_amr());
        mrmCopyDo.setId_bd_mrm_pt(ciMrmCopyDo.getId_bd_mrm_pt());
        mrmCopyDo.setCode_amr(ciMrmQryListDto.getAmrcode_and_times());
        mrmCopyDo.setCopies(mrmPrintDto.getCopies());
        mrmCopyDo.setCopynum(mrmPrintDto.getCopynum());
        mrmCopyDo.setTotal(mrmPrintDto.getTotal());
        mrmCopyDo.setCode_file(mrmPrintDto.getCode_file());
        mrmCopyDo.setStatus(DOStatus.NEW);
        
        CiMrmCopyDO[] ciMrmCopyDOs = service.save(new CiMrmCopyDO[] {mrmCopyDo});
        
        // 保存成功后将邮寄状态更改为已打印
        if (ciMrmCopyDOs.length > 0) {
        	
        	result = true;
        	
			// 根据当前的病案id查询病案邮寄表
        	String id_amr = ciMrmQryListDto.getId_amr();
			CiMrmMailDO[] ciMrmMailDOs = rService.find(" id_ci_amr = '"+id_amr+"'", "", FBoolean.FALSE);
			
			List<CiMrmMailDO> mailArr = new ArrayList<CiMrmMailDO>();
			
			for (CiMrmMailDO ciMrmMailDO : ciMrmMailDOs) {
				
				String mailState = ciMrmMailDO.getId_mail_state();
				String beforeMail = ICiMrDictCodeConst.ID_MRM_MA_STATE_UNEXECUTED;
				
				if (mailState != null && !mailState.equals("") && mailState.equals(beforeMail)) {
					ciMrmMailDO.setId_mail_state(ICiMrDictCodeConst.ID_MRM_MA_STATE_PRINTED);
					ciMrmMailDO.setSd_mail_state(ICiMrDictCodeConst.SD_MRM_MA_STATE_PRINTED);
				}
				
				mailArr.add(ciMrmMailDO);
				
			}
			
			CiMrmMailDO[] ciMrmMailDOArr = cudService.update(mailArr.toArray(new CiMrmMailDO[0]));
        	
			if (ciMrmMailDOArr.length <= 0) {
				result = false;
			}
			
        }
		
		return result;
	}

}
