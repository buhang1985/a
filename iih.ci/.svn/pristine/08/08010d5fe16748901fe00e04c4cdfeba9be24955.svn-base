package iih.ci.rcm.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.rcm.conpastreport.d.ConPastReportDO;
import iih.ci.rcm.conpastreport.i.IConpastreportCudService;
import iih.ci.rcm.conpastreport.i.IConpastreportRService;
import iih.ci.rcm.contagion.dto.d.EntDto;
import iih.ci.rcm.i.ICiRcmConPassService;

/**
 * 传染病既往已报相关实现
 * 〈功能详细描述〉
 * @author    [任亚平]
 * @version   [1.0, 2018-04-26]
 */
@Service(serviceInterfaces = {ICiRcmConPassService.class }, binding = Binding.JSONRPC)
public class CiRcmConPassServiceImpl implements ICiRcmConPassService{

	/**
	 * 当次就诊是否存在既往已报
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public Boolean hasCiRcmConPass(String id_ent) throws BizException {
		IConpastreportRService findService = ServiceFinder.find(IConpastreportRService.class);
		ConPastReportDO[] conPastReportDos = findService.findByAttrValString("Id_ent", id_ent);
		if(conPastReportDos!=null&&conPastReportDos.length>0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 创建既往已报数据
	 * @param id_ent
	 * @return true 成功  false 失败
	 * @throws BizException 
	 */
	public Boolean newCiRcmConPass(String id_ent) throws BizException {	
		//构建do并赋值
		ConPastReportDO conPastReportDO = new ConPastReportDO();
		conPastReportDO.setId_ent(id_ent);
		conPastReportDO.setId_grp(Context.get().getGroupId());
		conPastReportDO.setId_org(Context.get().getOrgId());
		conPastReportDO.setId_emp_submit(Context.get().getUserId());
		conPastReportDO.setDt_submit(new FDateTime());
		conPastReportDO.setId_status(ICiMrDictCodeConst.ID_CONPASS_SUBMIT);
		conPastReportDO.setSd_status(ICiMrDictCodeConst.SD_CONPASS_SUBMIT);
		conPastReportDO.setStatus(ICiMrDictCodeConst.DOStatusNew);
		//保存数据
		IConpastreportCudService service = ServiceFinder.find(IConpastreportCudService.class);
		ConPastReportDO[] results = service.save(new ConPastReportDO[]{ conPastReportDO });
		//判断返回
		if(results!=null&&results.length>0)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	/**
	 * 修改既往已报数据状态
	 * @param id_ent
	 * @param id_status
	 * @param sd_status
	 * @return
	 * @throws BizException
	 */
	public Boolean updateCiRcmConPass(String id_mr_con_pa, String id_status,
			String sd_status) throws BizException {
		//初始化服务
		IConpastreportCudService service = ServiceFinder.find(IConpastreportCudService.class);
		IConpastreportRService findService = ServiceFinder.find(IConpastreportRService.class);
		//查询数据并赋值
		ConPastReportDO conPastReportDo = findService.findById(id_mr_con_pa);
		conPastReportDo.setId_status(id_status);
		conPastReportDo.setSd_status(sd_status);
		conPastReportDo.setStatus(ICiMrDictCodeConst.DOStatusUpdate);
		//保存数据并返回是否成功
		ConPastReportDO[] results = service.save(new ConPastReportDO[]{conPastReportDo});
		if(results!=null&&results.length>0)
		{
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * 审核通过既往已报数据
	 * @param entDto
	 * @return
	 * @throws BizException
	 */
	public Boolean submitCiRcmConPass(EntDto entDto) throws BizException {
		IConpastreportCudService service = ServiceFinder.find(IConpastreportCudService.class);
		if(entDto.getSd_status()==null||entDto.getSd_status()=="")
		{
			//不存在既往已报数据直接审核通过           构建do并赋值
			ConPastReportDO conPastReportDO = new ConPastReportDO();
			conPastReportDO.setId_ent(entDto.getId_ent());
			conPastReportDO.setId_grp(Context.get().getGroupId());
			conPastReportDO.setId_org(Context.get().getOrgId());
			conPastReportDO.setId_emp_submit(Context.get().getUserId());
			conPastReportDO.setDt_submit(new FDateTime());
			conPastReportDO.setId_emp_pass(Context.get().getUserId());
			conPastReportDO.setDt_pass(new FDateTime());
			conPastReportDO.setId_status(ICiMrDictCodeConst.ID_CONPASS_PASS);
			conPastReportDO.setSd_status(ICiMrDictCodeConst.SD_CONPASS_PASS);
			conPastReportDO.setStatus(ICiMrDictCodeConst.DOStatusNew);
			//保存数据
			ConPastReportDO[] results = service.save(new ConPastReportDO[]{ conPastReportDO });
			//判断返回
			if(results!=null&&results.length>0)
			{
				return true;
			}else
			{
				return false;
			}
		}else{
			//存在既往已报数据     修改状态及审核人信息		
			IConpastreportRService findService = ServiceFinder.find(IConpastreportRService.class);
			ConPastReportDO conPastReportDo = findService.findById(entDto.getId_mr_con_pa());
			conPastReportDo.setId_emp_pass(Context.get().getUserId());
			conPastReportDo.setDt_pass(new FDateTime());
			conPastReportDo.setId_status(ICiMrDictCodeConst.ID_CONPASS_PASS);
			conPastReportDo.setSd_status(ICiMrDictCodeConst.SD_CONPASS_PASS);
			conPastReportDo.setStatus(ICiMrDictCodeConst.DOStatusUpdate);
			//保存数据
			ConPastReportDO[] results = service.save(new ConPastReportDO[]{ conPastReportDo });
			//判断返回
			if(results!=null&&results.length>0)
			{
				return true;
			}else
			{
				return false;
			}
		}
	}

	/**
	 * 驳回既往已报数据
	 * @param entDto
	 * @return
	 * @throws BizException
	 */
	public Boolean rejectCiRcmConPass(EntDto entDto,String reason) throws BizException {
		//存在既往已报数据     修改状态及审核人信息		
		IConpastreportRService findService = ServiceFinder.find(IConpastreportRService.class);
		IConpastreportCudService service = ServiceFinder.find(IConpastreportCudService.class);
		ConPastReportDO conPastReportDo = findService.findById(entDto.getId_mr_con_pa());
		conPastReportDo.setId_emp_reject(Context.get().getUserId());
		conPastReportDo.setDt_reject(new FDateTime());
		conPastReportDo.setId_status(ICiMrDictCodeConst.ID_CONPASS_REJECT);
		conPastReportDo.setSd_status(ICiMrDictCodeConst.SD_CONPASS_REJECT);
		conPastReportDo.setReason_reject(reason);
		conPastReportDo.setStatus(ICiMrDictCodeConst.DOStatusUpdate);
		//保存数据
		ConPastReportDO[] results = service.save(new ConPastReportDO[]{ conPastReportDo });
		//判断返回
		if(results!=null&&results.length>0)
		{
			return true;
		}else
		{
			return false;
		}
	}
}
