package iih.ci.mr.s.bp.write;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrtplsec.d.MrTplSegFsDO;
import iih.bd.srv.mrtplsec.i.IMrtplsecRService;
import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.mrtplseg.i.IMrtplsegRService;
import iih.bd.srv.preformat.d.MrPreFormatDO;
import iih.bd.srv.preformat.i.IPreformatRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 病历书写 获取 处置数据BP
 * @author zhq
 *
 */
public class MrWritePreBP {
    /**
     * 获取处置模板信息
     * @param id_dept
     * @return
     * @throws BizException
     */
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
}
