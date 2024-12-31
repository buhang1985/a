package iih.ci.mr.s;

import java.io.IOException;
import java.util.ArrayList;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrtplsec.d.MrTplSegFsDO;
import iih.bd.srv.mrtplsec.i.IMrtplsecRService;
import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.mrtplseg.i.IMrtplsegRService;
import iih.bd.srv.preformat.d.MrPreFormatDO;
import iih.bd.srv.preformat.i.IPreformatRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.cimrsource.d.CiMrSourceDO;
import iih.ci.mr.cimrsource.i.ICimrsourceCudService;
import iih.ci.mr.i.IIPMrService;
import iih.ci.mr.s.bp.CiMrFsBP;
import iih.ci.mr.s.bp.FastdfsMrLogger;
import iih.ci.mr.s.bp.InHospitalRecallMsgBP;
import iih.ci.mrqc.cimrrecall.d.CiMrRecallDO;
import iih.ci.ord.i.external.provide.ICiOrdMrService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

@Service(serviceInterfaces = { IIPMrService.class }, binding = Binding.JSONRPC)
public class IIPMrServiceImpl implements IIPMrService{

	/**
	 * 保存病历源内容
	 * @param ciMrSourceDOs
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean saveSource(CiMrSourceDO[] ciMrSourceDOs) throws BizException {

		if(ciMrSourceDOs==null&&ciMrSourceDOs.length<=0)
		{
			return Boolean.TRUE;
		}
		
		deleteSource(new String[]{ciMrSourceDOs[0].getId_mr()});
		
		ICimrsourceCudService service = ServiceFinder.find(ICimrsourceCudService.class);
		
		service.save(ciMrSourceDOs);
		
		return Boolean.TRUE;
	}

	/**
	 * 删除病历源内容
	 * @param idMrs
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean deleteSource(String[] idMrs) throws BizException {
		
		if(idMrs==null||idMrs.length<=0)
		{
			return Boolean.TRUE;
		}
		
		String strWhere=" id_mr in (";
		
		for(String str:idMrs)
		{
			strWhere+="'"+str+"',";
		}
		
		strWhere = strWhere.substring(0, strWhere.length()-1)+")";
		
		DAFacade daf = new DAFacade(); 
		
		daf.deleteByWhere(CiMrSourceDO.class, strWhere);
		
		return Boolean.TRUE;
	}

	/**
     * 本次就诊的死亡时间
     * @param id_ent
     * @return
     * @throws BizException
     */
	@Override
	public FDateTime getDeathDateTime(String id_ent) throws BizException {
		ICiOrdMrService service = ServiceFinder.find(ICiOrdMrService.class);
		return service.getDeathDateTime(id_ent);
	}
	
	/**
     * 本次就诊的出院时间
     * @param id_ent
     * @return
     * @throws BizException
     */
/*	@Override
	public FDateTime getLeaveHospitalDateTime(String id_ent) throws BizException {
		ICiOrdMrService service = ServiceFinder.find(ICiOrdMrService.class);
		return service.getPatLeaveHospitalTime(id_ent);
	}
	*/
	@SuppressWarnings("unchecked")
	@Override
	public FArrayList2 getDefaultMrPreFormats(String id_dept)
			throws BizException {
		
		FArrayList2 fArrayList2 = new FArrayList2();
		
		IPreformatRService iPreformatCudService = ServiceFinder.find(IPreformatRService.class);
		IMrtplsecRService iMrtplsecRService = ServiceFinder.find(IMrtplsecRService.class);
		IMrtplsegRService iMrtplsegRService = ServiceFinder.find(IMrtplsegRService.class);
		
		MrPreFormatDO[] preformatDOs = iPreformatCudService.find("id_dept = '"+id_dept+"' and fg_active = 'Y'", "nu_sort asc", FBoolean.FALSE);
		
		
		
        if (preformatDOs == null || preformatDOs.length <= 0)
        {
        	preformatDOs = iPreformatCudService.find("id_entp = '"+ICiMrDictCodeConst.ID_ENTP_ZHUYUAN+"' and fg_active = 'Y'", "nu_sort asc", FBoolean.FALSE);
        }

        if (preformatDOs != null && preformatDOs.length > 0)
        {
        	
        	FArrayList fArrayList = new FArrayList();
        	for(MrPreFormatDO mrPreFormatDO : preformatDOs)
        	{
        		fArrayList.add(mrPreFormatDO);
        	}
        	
        	fArrayList2.add(fArrayList);
            
            ArrayList<String> ls = new ArrayList<String>();
            for (MrPreFormatDO mrPreFormatDO : preformatDOs)
            {
                if (!ls.contains(mrPreFormatDO.getId_mrtplsec()))
                {
                    ls.add(mrPreFormatDO.getId_mrtplsec());
                }
            }

            MrTplSegFsDO[] mrTplSegFsDOs = iMrtplsecRService.findByAttrValStrings("Id_mrtplsec", ls.toArray(new String[0]));

            if(mrTplSegFsDOs!=null&&mrTplSegFsDOs.length>=0)
            {
            	
            	FArrayList fArrayListFs = new FArrayList();
            	for(MrTplSegFsDO mrTplSegFsDO : mrTplSegFsDOs)
            	{
            		fArrayListFs.add(mrTplSegFsDO);
            	}
            	fArrayList2.add(fArrayListFs);
            	
            	
            }
            
            MrTplSegmentDO[] mrTplSegmentDOs = iMrtplsegRService.findByIds(ls.toArray(new String[0]), FBoolean.FALSE);
            
            if(mrTplSegmentDOs!=null&&mrTplSegmentDOs.length>=0)
            {
            	
            	FArrayList fArrayListSeg = new FArrayList();
            	for(MrTplSegmentDO mrTplSegmentDO : mrTplSegmentDOs)
            	{
            		fArrayListSeg.add(mrTplSegmentDO);
            	}
            	fArrayList2.add(fArrayListSeg);
            	
            	
            }
        }
		
		
		return fArrayList2;
	}
	
/*	*//**
	 * 获取患者出院带药同步到病历数据
	 * @param id_ent 就诊id
	 * @return
	 * @throws BizException
	 *//*
	@Override
	public FMap2 getPresOutpOrderMrDtoFlushList(String id_ent) throws BizException{
		ICiOrdMrService service =  ServiceFinder.find(ICiOrdMrService.class);;
		return service.getPresOutpOrderMrDtoFlushList(id_ent);
	}*/

	@Override
	public Boolean sendRecallApplyMsg(CiMrRecallDO ciMrRecallDO)
			throws BizException {
		InHospitalRecallMsgBP bp = new InHospitalRecallMsgBP();
		bp.recallApplyMsg(ciMrRecallDO);
		return true;
	}

	@Override
	public Boolean sendRecallAuditMsg(CiMrRecallDO ciMrRecallDO)
			throws BizException {
		InHospitalRecallMsgBP bp = new InHospitalRecallMsgBP();
		bp.recallAuditMsg(ciMrRecallDO);
		return true;
	}

	/**
	 * 获取文书二进制返回
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrFsDO getCiMrFsDO(CiMrDO ciMrDO) throws BizException {
		CiMrFsBP ciMrFsBP = new CiMrFsBP();
		try {
			return ciMrFsBP.GetCiMrFsDO(ciMrDO);
		} catch (IOException e) {
			FastdfsMrLogger.error("病历："+e.getMessage() +e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 保存二进制返回
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @return
	 * @throws BizException
	 */
	@Override
	public FArrayList2 saveCiMrFsDO(CiMrDO ciMrDO, CiMrFsDO ciMrFsDO)
			throws BizException {
		CiMrFsBP ciMrFsBP = new CiMrFsBP();
		try {
			return ciMrFsBP.SaveCiMrFsDO(ciMrDO, ciMrFsDO);
		} catch (IOException e) {
			FastdfsMrLogger.error("病历："+e.getMessage()+e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 物理删除
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @throws BizException
	 */
	@Override
	public FBoolean deleteCiMrFsDO(CiMrDO ciMrDO, CiMrFsDO ciMrFsDO)
			throws BizException {
		CiMrFsBP ciMrFsBP = new CiMrFsBP();
		return ciMrFsBP.DeleteCiMrFsDO(ciMrDO, ciMrFsDO); 
	}
	
   /*  *//***
	 * 根据患者就诊id和医生iduser获取此次就诊该医生的上级医师id
	 * zhq
	 * @param id_ent
	 * @param id_psn
	 * @return
	 * @throws BizException
	 *//*
	@Override
	public String[] GetPatEntSuperiorDocList(String id_ent, String id_user,String id_dep) throws BizException {
		IUserRService userService=ServiceFinder.find(IUserRService.class);
		UserDO userdo=userService.findById(id_user);
		if (userdo!=null) {
			IEnOutQryService enServce=ServiceFinder.find(IEnOutQryService.class);
			String[] upList=enServce.GetPatEntSuperiorDocList(id_ent, userdo.getId_psn(),id_dep);
			if (upList!=null) {
				return upList;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}*/

	@Override
	public Boolean sendRejectMrfpMsg(PatiVisitDO patiVisitDO) throws BizException {
		InHospitalRecallMsgBP bp = new InHospitalRecallMsgBP();
		bp.rejectMrfpMsg(patiVisitDO);
		return true;
	}

//@Override
//public FDateTime getDeathDateTime(String id_ent) throws BizException {
//	// TODO Auto-generated method stub
//	return null;
//}
}
