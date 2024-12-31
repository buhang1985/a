package iih.ci.mr.s.bp;

import java.io.IOException;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueCudService;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 病历保存事务处理
 * @author F
 *
 */
public class MrSaveTransactionBp {
	
	/**
	 * 保存病历
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @return
	 * @throws IOException 
	 * @throws BizException 
	 */
	public FArrayList2 SaveMr(CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException, IOException
	{
		FArrayList2 fArrayList2 = new FArrayList2();		
		ICiemrCudService iCiemrCudService = ServiceFinder.find(ICiemrCudService.class);		
		CiMrDO[] ciMrDOs = iCiemrCudService.save(new CiMrDO[]{ ciMrDO });
		if(ciMrDOs != null && ciMrDOs.length>0)
		{
			ciMrFsDO.setId_mr(ciMrDOs[0].getId_mr());
			CiMrFsBP ciMrFsBP = new CiMrFsBP();
			fArrayList2 = ciMrFsBP.SaveCiMrFsDO(ciMrDOs[0], ciMrFsDO);	
			
		}		
		return fArrayList2;
	}
	
	/**
	 * 保存病历和引用
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @return
	 * @throws BizException
	 * @throws IOException
	 */
	public FArrayList2 saveMrAndRef(MrDocRefValueDO[] mrDocRefValueDOs,CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException, IOException
	{
		FArrayList2 fArrayList2 = new FArrayList2();
		
		ICiemrCudService iCiemrCudService = ServiceFinder.find(ICiemrCudService.class);
		
		Boolean b = (ciMrDO.getStatus()==2);	
		
		IMrdocrefvalueCudService cudservice = ServiceFinder.find(IMrdocrefvalueCudService.class);
		IMrdocrefvalueRService rservice = ServiceFinder.find(IMrdocrefvalueRService.class);
		
		if(!b)
		{
			MrDocRefValueDO[] mrDocRefValueDOs_d = rservice.find("id_mr = '"+ ciMrDO.getId_mr() +"'", "", FBoolean.FALSE);
			if(mrDocRefValueDOs_d!=null&&mrDocRefValueDOs_d.length>0)
			{
				cudservice.delete(mrDocRefValueDOs_d);
			}
		}
		
		if (mrDocRefValueDOs != null && mrDocRefValueDOs.length > 0) {
			if (mrDocRefValueDOs[0].getId_mr() == null || mrDocRefValueDOs[0].getId_mr().equals("")) {
				if (b) {
					for (MrDocRefValueDO mrDocRefValueDOc : mrDocRefValueDOs) {
						 mrDocRefValueDOc.setId_mr(ciMrDO.getId_ent());
					}
				}else
				{
					for (MrDocRefValueDO mrDocRefValueDOc : mrDocRefValueDOs) {
						 mrDocRefValueDOc.setId_mr(ciMrDO.getId_mr());
					}
				}
			}
			mrDocRefValueDOs = cudservice.save(mrDocRefValueDOs);
		}
		
		CiMrDO[] ciMrDOs = iCiemrCudService.save(new CiMrDO[]{ ciMrDO });
		if(ciMrDOs != null && ciMrDOs.length>0)
		{
			ciMrFsDO.setId_mr(ciMrDOs[0].getId_mr());
			CiMrFsBP ciMrFsBP = new CiMrFsBP();
			fArrayList2 = ciMrFsBP.SaveCiMrFsDO(ciMrDOs[0], ciMrFsDO);	
			//测试异常throw new BizException();
			
		}	
		
		if(ciMrDOs != null && ciMrDOs.length>0)
		{
			if (b) {
				MrDocRefValueDO[] mrDocRefValueDOs_u = rservice.find("id_mr = '"+ ciMrDO.getId_ent() +"'", "", FBoolean.FALSE);
				if (mrDocRefValueDOs_u != null && mrDocRefValueDOs_u.length > 0) {				
						for (MrDocRefValueDO mrDocRefValueDOc : mrDocRefValueDOs_u) {
							mrDocRefValueDOc.setId_mr(ciMrDOs[0].getId_mr());
							mrDocRefValueDOc.setStatus(1);
						}					
						cudservice.save(mrDocRefValueDOs_u);
				}
			}
		}
		return fArrayList2;
	}
	
	/**
	 * 门诊病历保存；
	 * 如果门诊病历提交，需要将其他相关病历一起提交
	 * @throws BizException 
	 * @throws IOException 
	 */
	public FArrayList2 saveOPMrAndRef(MrDocRefValueDO[] mrDocRefValueDOs,CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException, IOException
	{
		FArrayList2 fArrayList2 = new FArrayList2();
		fArrayList2 = saveMrAndRef(mrDocRefValueDOs, ciMrDO,  ciMrFsDO);
		if(fArrayList2.size()>0)
		{
			CiMrDO ciMrDoSaved = (CiMrDO)fArrayList2.get(0);
			if(ciMrDoSaved!=null)
				saveOpMrForSubmit(ciMrDoSaved);
		}
		
		return fArrayList2;
	}
	
	/**
	 * 如果门诊提交
	 * @throws BizException 
	 */
	private void saveOpMrForSubmit(CiMrDO ciMrDO) throws BizException
	{

		ICiemrCudService iCiemrCudService = ServiceFinder.find(ICiemrCudService.class);

			ICiemrRService iCiemrRService=ServiceFinder.find(ICiemrRService.class);
			CiMrDO[] ciMrDOsu = iCiemrRService.find(" id_ent = '"+ciMrDO.getId_ent() +"' and id_mr <> '"+ciMrDO.getId_mr()+"' and sd_su_mr = '"+ICiMrDictCodeConst.SD_SU_MR_NEW+"'","",FBoolean.FALSE);
			if(ciMrDOsu!=null&&ciMrDOsu.length>0)
			{
				for(CiMrDO ciMrDOu : ciMrDOsu)
				{
					ciMrDOu.setStatus(1);
					ciMrDOu.setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_SUBMIT);
					ciMrDOu.setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_SUBMIT);						
				}
				iCiemrCudService.save(ciMrDOsu );
			}
		
	}
}
