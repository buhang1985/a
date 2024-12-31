package iih.bd.srv.emrtpl.s;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.ISuMrptlConst;
import iih.bd.srv.emreditor.i.IEmreditorRService;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplDOAssignment;
import iih.bd.srv.emrtpl.i.IEmrtplMDORService;
import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.emrtype.i.IEmrtypeRService;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.srv.mrbasetpl.i.IMrbasetplRService;
import iih.bd.srv.mrtpltreeitem.d.MrtplTreeItemDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 工厂类赋初值
 */
@Service(serviceInterfaces={IEmrtplDOAssignment.class}, binding=Binding.JSONRPC)
public class IEmrtplDOAssignmentImpl implements IEmrtplDOAssignment{


    
    /**
     * 集团模板Do赋初值
     * @throws BizException 
     */
    @Override
    public EmrTplDO[] getGrpmrtplDO(MrtplTreeItemDTO treedto) throws BizException
    {
    	EmrTplDO mrtplDo = new EmrTplDO();
		mrtplDo.setOwtp_name("集团");
		mrtplDo.setId_owtp("0001AA1000000006JAOU");
		mrtplDo.setId_group(Context.get().getGroupId());
		this.setValue(mrtplDo,treedto.getId_mrcactm(),treedto.getId_mrtp());
		return new EmrTplDO[]{mrtplDo};
    }
    /**
     * 全院模板Do赋初值
     * @throws BizException 
     */
    @Override
    public EmrTplDO[] getHosmrtplDO(MrtplTreeItemDTO treedto) throws BizException
    {
    	
    	EmrTplDO mrtplDo = new EmrTplDO();
		mrtplDo.setOwtp_name(ICiMrDictCodeConst.NAME_UDIDOLIST_OWTP_HO);
		mrtplDo.setId_owtp(ICiMrDictCodeConst.ID_UDIDOLIST_OWTP_HO);
		mrtplDo.setId_ownorg(Context.get().getOrgId());
		mrtplDo.setOrderid(GetEmrTpDOByMrcactm(treedto.getId_mrcactm(),null,null,Context.get().getOrgId(),ICiMrDictCodeConst.ID_UDIDOLIST_OWTP_HO));
		this.setValue(mrtplDo,treedto.getId_mrcactm(),treedto.getId_mrtp());
		return new EmrTplDO[]{mrtplDo};
    }
    /**
     * 科室模板Do赋初值
     * @throws BizException 
     */
    @Override
    public EmrTplDO[] getDeptmrtplDO(MrtplTreeItemDTO treedto) throws BizException
    {
    	EmrTplDO mrtplDo = new EmrTplDO();
		mrtplDo.setOwtp_name(ICiMrDictCodeConst.NAME_UDIDOLIST_OWTP_SE);
		mrtplDo.setId_owtp(ICiMrDictCodeConst.ID_UDIDOLIST_OWTP_SE);
		mrtplDo.setId_dept(Context.get().getDeptId());
		mrtplDo.setOrderid(GetEmrTpDOByMrcactm(treedto.getId_mrcactm(),null,Context.get().getDeptId(),null,ICiMrDictCodeConst.ID_UDIDOLIST_OWTP_SE));
		this.setValue(mrtplDo,treedto.getId_mrcactm(),treedto.getId_mrtp());
		return new EmrTplDO[]{mrtplDo};
    }
    /**
     * 个人模板Do赋初值
     * @throws BizException 
     */
    @Override
    public EmrTplDO[] getPermrtplDO(MrtplTreeItemDTO treedto) throws BizException
    {
    	EmrTplDO mrtplDo = new EmrTplDO();
		mrtplDo.setOwtp_name(ICiMrDictCodeConst.NAME_UDIDOLIST_OWTP_PE);
		mrtplDo.setId_owtp(ICiMrDictCodeConst.ID_UDIDOLIST_OWTP_PE);
		mrtplDo.setId_emp(Context.get().getUserId());
		mrtplDo.setOrderid(GetEmrTpDOByMrcactm(treedto.getId_mrcactm(),Context.get().getUserId(),null,null,ICiMrDictCodeConst.ID_UDIDOLIST_OWTP_PE));
		this.setValue(mrtplDo,treedto.getId_mrcactm(),treedto.getId_mrtp());
		return new EmrTplDO[]{mrtplDo};
    }
    
    public int GetEmrTpDOByMrcactm(String id_mrcactm,String id_emp,String id_dept,String id_ownorg,String id_owtp) throws BizException
    {
    	
    	String whereStr=" id_mrtp in (select t1.id_mrtp from bd_mrca_ctm_itm t1 where t1.id_mrcactm='"+id_mrcactm+"') ";
    	if(id_emp!=null)
    	{
    		whereStr+=(" and id_emp='"+id_emp+"'");    		
    	}
    	if(id_dept!=null)
    	{
    		whereStr+=(" and id_dept = '"+id_dept+"'");
    	}
    	if(id_ownorg!=null)
    	{
    		whereStr+=(" and id_ownorg='"+id_ownorg+"'");
    	}
    		whereStr+=("and id_owtp='"+id_owtp+"' ");
    	
    	IEmrtplMDORService emrtplServices = ServiceFinder.find(IEmrtplMDORService.class);
    	EmrTplDO[] emrTplDOs = emrtplServices.find(whereStr, " orderid desc", FBoolean.FALSE);
    	if(emrTplDOs!=null&&emrTplDOs.length>0)
    	{
    		EmrTplDO emrTplDO = emrTplDOs[0];
    		if(emrTplDO.getOrderid()!=null)
    		{
    			return emrTplDO.getOrderid()+1;    			
    		}
    	}
    	
    	return 1;
    	
    }

    
	
	public void setValue(EmrTplDO mrtplDo,String Id_mrcactm,String Id_mrtp) throws BizException {

	    IMrbasetplRService basetpl=ServiceFinder.find(IMrbasetplRService.class);
	    IEmreditorRService mreds=ServiceFinder.find(IEmreditorRService.class);
	    IEmrtypeRService  emrtypr=ServiceFinder.find(IEmrtypeRService.class);
		mrtplDo.setCreatedby(Context.get().getUserId());
		mrtplDo.setCreatedtime(new FDateTime());
		mrtplDo.setId_su_mrptl(ISuMrptlConst.ID_SUMRPTL_NEW);
		mrtplDo.setSd_su_mrptl(ISuMrptlConst.SD_SUMRPTL_NEW);
		EmrBaseTplDO[] baseDOs=basetpl.find("1=1 and id_su_basemrtpl='"+ICiMrDictCodeConst.ID_UDIDOLIST_BASETPLSATE_ACTIVE+"'", null, FBoolean.FALSE);
		if(baseDOs.length>0 && baseDOs!=null)
		{
	        mrtplDo.setId_basemrtpl(baseDOs[0].getId_basemrtpl());
	        mrtplDo.setBase_name(baseDOs[0].getName());
	        mrtplDo.setId_mred(baseDOs[0].getId_mred());
	        mrtplDo.setBase_idmred(baseDOs[0].getId_mred());
		}

		 MrTpDO[] MrTpdos;
		 String rootsql = "a0.id_mrtp in( select bmci.id_mrtp from bd_mrca_ctm_itm bmci where bmci.id_mrcactm like ( select id_mrcactm from (select id_mrcactm from BD_MRCA_CTM order by code ) where rownum=1 ))";
		 String prientsql= "(a0.id_mrtp in (select bmci.id_mrtp from bd_mrca_ctm_itm bmci where  bmci.id_mrcactm like '" + Id_mrcactm + "' ))";
		 String sonsql ="a0.id_mrtp in (select id_mrtp from BD_MRTP  where ID_MRTP  like '"+Id_mrtp+"' )";
		 
		 if (Id_mrcactm.equals("%"))
        {
        	MrTpdos=emrtypr.find(rootsql, "", FBoolean.FALSE);
        }
        else
        {
    	  if (Id_mrtp.equals("%"))
          {
          	MrTpdos=emrtypr.find(prientsql, "", FBoolean.FALSE);
          }
          else
          {
          	MrTpdos=emrtypr.find(sonsql, "", FBoolean.FALSE);
          }
        }
		if(MrTpdos.length>0 && MrTpdos!=null)
		{
	        mrtplDo.setId_mrtp(MrTpdos[0].getId_mrtp());
	        mrtplDo.setMrtp_name(MrTpdos[0].getName());
	        mrtplDo.setId_mr_sign_lvl(MrTpdos[0].getMr_sign_lvl_cd());
	        mrtplDo.setSign_name(MrTpdos[0].getSign_name());
	        mrtplDo.setId_wf_type(MrTpdos[0].getSign_flowtype()); 
		}
	}
}