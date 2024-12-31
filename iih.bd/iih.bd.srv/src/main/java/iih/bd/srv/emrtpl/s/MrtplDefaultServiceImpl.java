package iih.bd.srv.emrtpl.s;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import iih.bd.srv.emrtpl.i.IEmrtplMDORService;
import iih.bd.srv.emrtpl.i.IMrtplDefaultService;
import xap.mw.core.data.Context;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;


/**
 * 选择默认模板服务
 */
@Service(serviceInterfaces={IMrtplDefaultService.class}, binding=Binding.JSONRPC)
public class MrtplDefaultServiceImpl implements IMrtplDefaultService{

	@Override
	public EmrTplDO[] getDefaultMrtpl(String Id_org, String Id_dep,String Id_emp, String id_mrtp,String sd_su_mrtpl)
			throws BizException {
			if(id_mrtp==null)
				return null;
			
			String sql=null;
			if(Id_emp!=null)
			{
				sql= "select * from BD_MRTPL"
						+ "  where  isdefault='Y' and id_emp ='"+Id_emp+"'"
						+"and id_mrtp ='"+ id_mrtp
						+"'";
				
				List<EmrTplDO> list= (List<EmrTplDO>)new DAFacade().execQuery(sql, new BeanListHandler(EmrTplDO.class));
				if(list.size()>0) return list.toArray(new EmrTplDO[0]);
			}
			if(Id_dep!=null)
			{
				sql= "select * from BD_MRTPL"
						+ "  where  isdefault='Y' and id_dept='"+Id_dep+"'"
						+"and id_mrtp ='"+ id_mrtp
						+"' and sd_su_mrptl='"+sd_su_mrtpl+"'";
				
				List<EmrTplDO> list= (List<EmrTplDO>)new DAFacade().execQuery(sql, new BeanListHandler(EmrTplDO.class));
				if(list.size()>0) return list.toArray(new EmrTplDO[0]);
			}
			if(Id_org!=null)
			{
				sql= "select * from BD_MRTPL"
						+ "  where  isdefault='Y' and id_org='"+Id_org+"'"
						+"and id_mrtp ='"+ id_mrtp
						+"'  and sd_su_mrptl='"+sd_su_mrtpl+"'";
				List<EmrTplDO> list= (List<EmrTplDO>)new DAFacade().execQuery(sql, new BeanListHandler(EmrTplDO.class));
				if(list.size()>0) return list.toArray(new EmrTplDO[0]);
			}
			
			return null;
	}
	
	public EmrTplDO[] getDefaultMrtplByEntp(String Id_org, String Id_dep,String Id_emp, String sd_mr_entp,String sd_su_mrtpl)
			throws BizException {
		
		if(sd_mr_entp==null)
			return null;
		
		String sql=null;
		String id_org = Context.get().getOrgId();
		if(Id_emp!=null)
		{
			//activestate = '2'代表已启用
			sql = "select tpl.ID_MRTPL,tpl.ID_GRP,tpl.ID_ORG,tpl.ID_MRTP,tpl.VER,tpl.CODE,tpl.CODE_STD,tpl.NAME,tpl.ID_BASEMRTPL"
					+ " ,tpl.ID_MRED , tpl.FUNC_EDITOR_ARGU, tpl.ID_OWTP ,tpl.SD_OWTP,tpl.ID_EMP,tpl.ID_DEPT,tpl.ID_SU_MRPTL,tpl.SD_SU_MRPTL,"
					+ " tpl.ACTIVESTATE,tpl.ID_EMP_SUBMIT,tpl.DT_SUBMIT,tpl.ID_EMP_REVIEW,tpl.DT_REVIEW,tpl.ID_EMP_ACTIVE,tpl.DT_ACTIVE,"
					+ "tpl.ID_EMP_STOP,tpl.DT_STOP,tpl.CREATEDBY, tpl.TITLE_EXP,tpl.NAME_PRN,tpl.KEYWORDS,tpl.CRITERIAXML, tpl.TASK_ID,tpl.ID_WF_TYPE,"
					+ "tpl.WF_PRODEF, tpl.ID_DI, tpl.NAME_DI,tpl.DS,tpl.ID_MR_SIGN_LVL, tpl.id_org ,tpl.NEWTOP,tpl.NEWEND ,tpl.SIGN_SUGGESTION ,tpl.ISDEFAULT,"
					+ " tpl.ID_GROUP ,tpl.NAME_OWN ,tpl.ORDERID,tpl.RECALLREASON from BD_MRTPL  tpl join bd_mrtp  tp on tpl.id_mrtp = tp.id_mrtp"
					+ " where  tpl.isdefault='Y' and tpl.sd_owtp ='"+ICiMrDictCodeConst.SD_UDIDOLIST_OWTP_PE+"' and tpl.id_emp ='"+Id_emp+"'"
					+" and tp.sd_mr_entp ='"+ sd_mr_entp
					+"' and tpl.activestate = '2' and tpl.id_org = '"+id_org+"'"  ;
			
			List<EmrTplDO> list= (List<EmrTplDO>)new DAFacade().execQuery(sql, new BeanListHandler(EmrTplDO.class));
			if(list.size()>0) return list.toArray(new EmrTplDO[0]);
		}
		if(Id_dep!=null)
		{
			sql = "select tpl.ID_MRTPL,tpl.ID_GRP,tpl.ID_ORG,tpl.ID_MRTP,tpl.VER,tpl.CODE,tpl.CODE_STD,tpl.NAME,tpl.ID_BASEMRTPL"
					+ " ,tpl.ID_MRED , tpl.FUNC_EDITOR_ARGU, tpl.ID_OWTP ,tpl.SD_OWTP,tpl.ID_EMP,tpl.ID_DEPT,tpl.ID_SU_MRPTL,tpl.SD_SU_MRPTL,"
					+ " tpl.ACTIVESTATE,tpl.ID_EMP_SUBMIT,tpl.DT_SUBMIT,tpl.ID_EMP_REVIEW,tpl.DT_REVIEW,tpl.ID_EMP_ACTIVE,tpl.DT_ACTIVE,"
					+ "tpl.ID_EMP_STOP,tpl.DT_STOP,tpl.CREATEDBY, tpl.TITLE_EXP,tpl.NAME_PRN,tpl.KEYWORDS,tpl.CRITERIAXML, tpl.TASK_ID,tpl.ID_WF_TYPE,"
					+ "tpl.WF_PRODEF, tpl.ID_DI, tpl.NAME_DI,tpl.DS,tpl.ID_MR_SIGN_LVL, tpl.id_org ,tpl.NEWTOP,tpl.NEWEND ,tpl.SIGN_SUGGESTION ,tpl.ISDEFAULT,"
					+ " tpl.ID_GROUP ,tpl.NAME_OWN ,tpl.ORDERID,tpl.RECALLREASON from BD_MRTPL  tpl join bd_mrtp  tp on tpl.id_mrtp = tp.id_mrtp"
					+ " where  tpl.isdefault='Y' and tpl.sd_owtp ='"+ICiMrDictCodeConst.SD_UDIDOLIST_OWTP_SE+"' and tpl.id_dept ='"+Id_dep+"'"
					+" and tp.sd_mr_entp ='"+ sd_mr_entp
					+"' and tpl.sd_su_mrptl='"+sd_su_mrtpl
					+"' and tpl.activestate = '2' and tpl.id_org = '"+id_org+"'" ;
			
			@SuppressWarnings("unchecked")
			List<EmrTplDO> list= (List<EmrTplDO>)new DAFacade().execQuery(sql, new BeanListHandler(EmrTplDO.class));
			if(list.size()>0) return list.toArray(new EmrTplDO[0]);
		}
		if(Id_org!=null)
		{
			sql = "select tpl.ID_MRTPL,tpl.ID_GRP,tpl.ID_ORG,tpl.ID_MRTP,tpl.VER,tpl.CODE,tpl.CODE_STD,tpl.NAME,tpl.ID_BASEMRTPL"
					+ " ,tpl.ID_MRED , tpl.FUNC_EDITOR_ARGU, tpl.ID_OWTP ,tpl.SD_OWTP,tpl.ID_EMP,tpl.ID_DEPT,tpl.ID_SU_MRPTL,tpl.SD_SU_MRPTL,"
					+ " tpl.ACTIVESTATE,tpl.ID_EMP_SUBMIT,tpl.DT_SUBMIT,tpl.ID_EMP_REVIEW,tpl.DT_REVIEW,tpl.ID_EMP_ACTIVE,tpl.DT_ACTIVE,"
					+ "tpl.ID_EMP_STOP,tpl.DT_STOP,tpl.CREATEDBY, tpl.TITLE_EXP,tpl.NAME_PRN,tpl.KEYWORDS,tpl.CRITERIAXML, tpl.TASK_ID,tpl.ID_WF_TYPE,"
					+ "tpl.WF_PRODEF, tpl.ID_DI, tpl.NAME_DI,tpl.DS,tpl.ID_MR_SIGN_LVL, tpl.id_org ,tpl.NEWTOP,tpl.NEWEND ,tpl.SIGN_SUGGESTION ,tpl.ISDEFAULT,"
					+ " tpl.ID_GROUP ,tpl.NAME_OWN ,tpl.ORDERID,tpl.RECALLREASON from BD_MRTPL  tpl join bd_mrtp  tp on tpl.id_mrtp = tp.id_mrtp"
					+ " where  tpl.isdefault='Y' and tpl.sd_owtp ='"+ICiMrDictCodeConst.SD_UDIDOLIST_OWTP_HO+"'"
					+" and tp.sd_mr_entp ='"+ sd_mr_entp
					+"' and tpl.sd_su_mrptl='"+sd_su_mrtpl
					+"' and tpl.activestate = '2' and tpl.id_org = '"+id_org+"'"   ;
			List<EmrTplDO> list= (List<EmrTplDO>)new DAFacade().execQuery(sql, new BeanListHandler(EmrTplDO.class));
			if(list.size()>0) return list.toArray(new EmrTplDO[0]);
		}
		
		return null;
	}
	@Override
	public void setDefaultMrtpl(String Id_mrtpl, String Id_owtp,
			String id_mrtp) throws BizException {
		if(Id_mrtpl==null||Id_owtp==null||id_mrtp==null)
			return;
		IEmrtplMDORService  service=ServiceFinder.find(IEmrtplMDORService.class);
		IEmrtplMDOCudService   saveser=ServiceFinder.find(IEmrtplMDOCudService.class);
		String sql=" a0.ID_OWTP ='"+Id_owtp+"'   and  a0.ID_MRTP='"+id_mrtp+"'  and  a0.id_mrtpl <> '"+Id_mrtpl+"'";
//		EmrTplDO [] list=service.find(sql, "", FBoolean.FALSE);
//		if(list.length>0)
//		{
//			for(int i=0;i<list.length;i++)
//			{
//				list[i].setIsdefault(FBoolean.FALSE);
//			}
//		   list=saveser.update(list);
		   int result = new DAFacade().execUpdate("update BD_MRTPL a0 set a0.isdefault='N' where "+sql);
//		}
		   
		EmrTplDO  doDo= service.findById(Id_mrtpl);
		doDo.setIsdefault(FBoolean.TRUE);
		doDo=saveser.update(new EmrTplDO[]{doDo})[0];
	}
	
	@Override
	public void setDefaultMrtplDept(String Id_mrtpl, String Id_owtp,
			String id_mrtp,String Id_dept) throws BizException {
		if(Id_mrtpl==null||Id_owtp==null||id_mrtp==null)
			return;
		IEmrtplMDORService  service=ServiceFinder.find(IEmrtplMDORService.class);
		IEmrtplMDOCudService   saveser=ServiceFinder.find(IEmrtplMDOCudService.class);
		String sql=" a0.ID_OWTP ='"+Id_owtp+"'   and  a0.ID_MRTP='"+id_mrtp+"'  and  a0.id_mrtpl <> '"+Id_mrtpl+"' and a0.id_dept='"+Id_dept+"'";
//		EmrTplDO [] list=service.find(sql, "", FBoolean.FALSE);
//		if(list.length>0)
//		{
//			for(int i=0;i<list.length;i++)
//			{
//				list[i].setIsdefault(FBoolean.FALSE);
//			}
//		   list=saveser.update(list);
		   int result = new DAFacade().execUpdate("update BD_MRTPL a0 set a0.isdefault='N' where "+sql);
//		}
		   
		EmrTplDO  doDo= service.findById(Id_mrtpl);
		doDo.setIsdefault(FBoolean.TRUE);
		doDo=saveser.update(new EmrTplDO[]{doDo})[0];
	}
	
	@Override
	public void setDefaultMrtplPerson(String Id_mrtpl, String Id_owtp,
			String id_mrtp,String Id_person) throws BizException {
		if(Id_mrtpl==null||Id_owtp==null||id_mrtp==null)
			return;
		IEmrtplMDORService  service=ServiceFinder.find(IEmrtplMDORService.class);
		IEmrtplMDOCudService   saveser=ServiceFinder.find(IEmrtplMDOCudService.class);
		String sql=" a0.ID_OWTP ='"+Id_owtp+"'   and  a0.ID_MRTP='"+id_mrtp+"'  and  a0.id_mrtpl <> '"+Id_mrtpl+"' and a0.id_emp = '"+Id_person+"'";
//		EmrTplDO [] list=service.find(sql, "", FBoolean.FALSE);
//		if(list.length>0)
//		{
//			for(int i=0;i<list.length;i++)
//			{
//				list[i].setIsdefault(FBoolean.FALSE);
//			}
//		   list=saveser.update(list);
		   int result = new DAFacade().execUpdate("update BD_MRTPL a0 set a0.isdefault='N' where "+sql);
//		}
		   
		EmrTplDO  doDo= service.findById(Id_mrtpl);
		doDo.setIsdefault(FBoolean.TRUE);
		doDo=saveser.update(new EmrTplDO[]{doDo})[0];
	}
	
	@Override
	public void setDefaultMrtplHospital(String Id_mrtpl, String Id_owtp,
			String id_mrtp,String Id_ownorg) throws BizException {
		if(Id_mrtpl==null||Id_owtp==null||id_mrtp==null)
			return;
		IEmrtplMDORService  service=ServiceFinder.find(IEmrtplMDORService.class);
		IEmrtplMDOCudService   saveser=ServiceFinder.find(IEmrtplMDOCudService.class);
		String sql=" a0.ID_OWTP ='"+Id_owtp+"'   and  a0.ID_MRTP='"+id_mrtp+"'  and  a0.id_mrtpl <> '"+Id_mrtpl+"' and a0.id_org='"+Id_ownorg+"'";
//		EmrTplDO [] list=service.find(sql, "", FBoolean.FALSE);
//		if(list.length>0)
//		{
//			for(int i=0;i<list.length;i++)
//			{
//				list[i].setIsdefault(FBoolean.FALSE);
//			}
//		   list=saveser.update(list);
		   int result = new DAFacade().execUpdate("update BD_MRTPL a0 set a0.isdefault='N' where "+sql);
//		}
		   
		EmrTplDO  doDo= service.findById(Id_mrtpl);
		doDo.setIsdefault(FBoolean.TRUE);
		doDo=saveser.update(new EmrTplDO[]{doDo})[0];
	}

}
