package iih.bd.pp.incca.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.pp.incca.d.IncCaDO;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.d.InccaAggDO;
import iih.bd.pp.incca.d.UnComparisonedSrvDTO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.incca.i.IInccaitmrelCudService;
import iih.bd.pp.listener.event.BdPpEvent;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class InccaBp {

	@SuppressWarnings("unchecked")
	public UnComparisonedSrvDTO[] findUnComparisonedSrvDTOByIdincca(String id_incca) throws BizException{
		// TODO Auto-generated method stub
		 StringBuffer sb=new StringBuffer();
		   sb.append(" SELECT B.ID_SRVCA, B.NAME, B.CODE, B.ID_PARENT,COUNT(B.ID_SRVCA) as count ");
		   sb.append("  FROM BD_SRV A  ");
		   sb.append("       JOIN BD_SRVCA B  ");
		   sb.append("       ON A.ID_SRVCA = B.ID_SRVCA ");
		   sb.append("         WHERE NOT EXISTS (SELECT t.id_inccaitmrel,t.id_inccaitm,t.id_incca,t.id_srv,t.ds,t.sv,t.id_srvca ");
		   sb.append("                            FROM BD_INCCA_ITM_REL  t ");
		   sb.append("                             WHERE t.ID_SRV = A.ID_SRV ");
		   sb.append("                                   AND t.ID_INCCA =? ) ");
		   sb.append("               AND A.FG_BL = 'Y'   ");
		   sb.append("               and A.fg_active='Y' ");
		   sb.append("               and A.ds=0          ");
		   sb.append("               GROUP BY B.ID_SRVCA, B.CODE, B.NAME,B.ID_PARENT  ");
		   sb.append("               ORDER BY B.CODE ");
		   
		   SqlParam sp=new SqlParam();
		   sp.addParam(id_incca);
		   
		   List<UnComparisonedSrvDTO> list  = (List<UnComparisonedSrvDTO>)new DAFacade().execQuery(sb.toString(),sp, new BeanListHandler(UnComparisonedSrvDTO.class));
		   UnComparisonedSrvDTO[]  ppspDOArr=list.toArray(new UnComparisonedSrvDTO[]{});
		   return ppspDOArr;
	}

	public int getUnComparisonedSrvCount(String str) throws BizException{
		if(str != null && !"".equals(str)){
			StringBuffer sb = new StringBuffer();
			sb.append(" SELECT count (DISTINCT A.ID_SRV) ");
			sb.append(" FROM BD_SRV A ");
			sb.append(" WHERE NOT EXISTS ");
			sb.append("   (SELECT t.id_srv ");
			sb.append("    FROM BD_INCCA_ITM_REL t ");
			sb.append("    WHERE t.ID_SRV = A.ID_SRV ");
			sb.append("    AND t.ID_INCCA = '"+str+"') ");
			sb.append(" AND A.FG_BL = 'Y' ");
			sb.append(" AND A.ds = 0 ");
			sb.append(" AND A.Fg_Active='Y' ");
			sb.append(" AND A.fg_bl = 'Y' ");
			return (int) new DAFacade().execQuery(sb.toString(),new ColumnHandler());
		}
		return 0;
	}
	
	public PagingRtnData<MedSrvDO> findUnComparisonedSrv(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String idIncca, String idSrvca) throws BizException {
		
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithDOName(qryRootNodeDTO,MedSrvDO.class.getName());
		
		StringBuffer sb=new StringBuffer();
		   sb.append(" select DISTINCT  A0.ID_SRV,A0.NAME, A0.CODE,A0.CREATEDBY,A0.DS,A0.DES,A0.ID_GRP,A0.ID_ORG,A0.EU_BLMD,A0.FG_ACTIVE, ");
		   sb.append("    A0.FG_BL,A0.FG_CTM,A0.FG_MM,A0.FG_OR,A0.FG_SET,A0.FG_USE_ER,A0.ID_BOIL,A0.ID_BOILDES,A0.ID_FREQ,A0.ID_SETORD,   ");
		   sb.append("    A0.ID_PRIMD,A0.ID_ROUTE,A0.ID_SRVCA,A0.ID_SRVTP,A0.ID_UNIT_MED,A0.PRI,A0.QUAN_MED,A0.SV      ");
		   sb.append("  FROM  BD_SRV  A0  ");
		   sb.append("   WHERE NOT EXISTS (SELECT t.id_inccaitmrel,t.id_inccaitm,t.id_incca,t.id_srv,t.ds,t.sv,t.id_srvca  ");
		   sb.append("                     FROM BD_INCCA_ITM_REL t  ");
		   sb.append("                      WHERE t.ID_SRV = A0.ID_SRV   ");
		   sb.append("                       AND t.ID_INCCA = '"+idIncca+"')                ");
		   sb.append("        AND A0.FG_BL = 'Y'             ");
		   
		   if(idSrvca!=null && !"".equals(idSrvca)){
				sb.append(" and A0.id_srvca = '"+idSrvca+"'  "); 
			 }
		   
		   if(wherePart != null){
			   sb.append(" and " + wherePart);
		   }
		   sb.append("        and A0.ds=0                             ");
		   sb.append("        and A0.Fg_Active='Y'  and  A0.fg_bl='Y'      ");
		   sb.append("        ORDER BY A0.NAME ;         ");   
		   
		   PagingServiceImpl<MedSrvDO> pagingServiceImpl = new PagingServiceImpl<MedSrvDO>();
		   return pagingServiceImpl.findByPageInfo(new MedSrvDO(), pg, sb.toString(), "", null);
	}
	
	public PagingRtnData<IncCaItmRelDO> findSrvAndSrvcaList( PaginationInfo pg, QryRootNodeDTO[] qryRootNodeDTOArr, IncCaItmDO incCaItmDO) throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT a.ID_SRV, b.NAME AS SRVNAME, b.CODE AS SRVCODE,");
		sb.append("       a.ID_SRVCA, c.NAME AS SRVCANAME, c.CODE AS SRVCACODE,");
		sb.append("       a.ID_INCCA, a.SD_INCCA, d.CODE as INCCACODE, d.NAME AS INCCANAME,");
		sb.append("       a.ID_INCCAITM, e.CODE AS INCCAITM_CODE,e.NAME AS INCCAITM_NAME,");
		sb.append("		  a.ID_INCCAITMREL, a.ID_ORG,a.ID_GRP, a.CREATEDBY, a.CREATEDTIME, a.MODIFIEDBY, a.MODIFIEDTIME, a.DS, a.SV ");
		sb.append("FROM bd_incca_itm_rel a,");
		sb.append("     bd_srv b,");
		sb.append("     bd_srvca c,");
		sb.append("     bd_incca d,");
		sb.append("     bd_incca_itm e ");
		sb.append("WHERE a.ID_SRV = b.ID_SRV");
		sb.append("  AND b.ID_SRVCA = c.ID_SRVCA");
		sb.append("  AND a.ID_INCCA = d.ID_INCCA");
		sb.append("  AND a.ID_INCCAITM = e.ID_INCCAITM");
		sb.append("  AND a.ID_INCCA = '"+incCaItmDO.getId_incca()+"'");
		sb.append("  AND a.ID_INCCAITM = '"+incCaItmDO.getId_inccaitm()+"'");
		sb.append("  AND a.DS = 0");
		if(qryRootNodeDTOArr != null && qryRootNodeDTOArr.length > 0){
			IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
			for(int i = 0; i < qryRootNodeDTOArr.length; i++){
				if(qryRootNodeDTOArr[i] == null)
					break;
				String whereStr = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDTOArr[i]);
				if(!StringUtil.isEmptyWithTrim(whereStr)){
					whereStr = whereStr.substring(0, whereStr.length());
					if(whereStr.contains("id_srvca"))
						sb.append(" AND c."+whereStr);
					else
						sb.append(" AND a."+whereStr);
				}
			}
		}
		PagingServiceImpl<IncCaItmRelDO> pagingServiceImpl = new PagingServiceImpl<IncCaItmRelDO>();
		return pagingServiceImpl.findByPageInfo(new IncCaItmRelDO(), pg, sb.toString(), "ID_SRVCA", null);
	}
	
	@SuppressWarnings("unchecked")
	public MedSrvDO[] findUnComparisonedSrvsByIds(String id_incca,String id_srvca) throws BizException {
		// TODO Auto-generated method stub
//		
//		if(id_srvca==null) {
//			id_srvca="";
//		}
		
		 StringBuffer sb=new StringBuffer();
		   sb.append(" select DISTINCT  A.ID_SRV,A.NAME, A.CODE,A.CREATEDBY,A.DS,A.DES,A.ID_GRP,A.ID_ORG,A.EU_BLMD,A.FG_ACTIVE, ");
		   sb.append("    A.FG_BL,A.FG_CTM,A.FG_MM,A.FG_OR,A.FG_SET,A.FG_USE_ER,A.ID_BOIL,A.ID_BOILDES,A.ID_FREQ,A.ID_SETORD,   ");
		   sb.append("    A.ID_PRIMD,A.ID_ROUTE,A.ID_SRVCA,A.ID_SRVTP,A.ID_UNIT_MED,A.PRI,A.QUAN_MED,A.SV      ");
		   sb.append("  FROM  BD_SRV  A  ");
		   sb.append("   WHERE NOT EXISTS (SELECT t.id_inccaitmrel,t.id_inccaitm,t.id_incca,t.id_srv,t.ds,t.sv,t.id_srvca  ");
		   sb.append("                     FROM BD_INCCA_ITM_REL t  ");
		   sb.append("                      WHERE t.ID_SRV = A.ID_SRV   ");
		   sb.append("                       AND t.ID_INCCA = '"+id_incca+"')                ");
		   sb.append("        AND A.FG_BL = 'Y'             ");
		   
		   if(id_srvca!=null && !"".equals(id_srvca)){
				sb.append(" and A.id_srvca = '"+id_srvca+"'  "); 
			 }
		   
		   sb.append("        and A.ds=0                             ");
		   sb.append("        and A.Fg_Active='Y'  and  A.fg_bl='Y'      ");
		   sb.append("        ORDER BY A.NAME ;         ");

		   List<MedSrvDO> list  = (List<MedSrvDO>)new DAFacade().execQuery(sb.toString(), new BeanListHandler(MedSrvDO.class));
		   MedSrvDO[]  ppspDOArr=list.toArray(new MedSrvDO[]{});
		   return ppspDOArr;
	}

	@SuppressWarnings("unused")
	public FBoolean saveComparisonedSrv(IncCaItmRelDO[]  inccaitmRelDOArr) throws BizException {
		IInccaitmrelCudService  relService=ServiceFinder.find(IInccaitmrelCudService.class);
		IncCaItmRelDO[]  inccaItmRelDOs=relService.insert(inccaitmRelDOArr);
		
		return FBoolean.TRUE;
	}

	@SuppressWarnings("unchecked")
	public IncCaItmRelDO[] findInccaItmRelDtoById(String id_inccaitm,String id_incca,
			String id_srv,String id_srvca) throws BizException {
		// TODO Auto-generated method stub
		//long aa=System.currentTimeMillis();

		 StringBuffer sb=new StringBuffer();
		 sb.append("select distinct a0.Id_incca,     ");
	     sb.append("       a0.Id_inccaitm,           ");
		 sb.append("       a0.Id_inccaitmrel,        ");
		 sb.append("       a0.Id_srv, a0.ds,a0.sv,   "); 
		 sb.append("       c.Id_srvca,               "); 
	     sb.append("       a0b4.name    Inccaname,   ");
		 sb.append("       d.name       Inccaitm_name,");
	     sb.append("       c.name       Srvcaname,   ");
		 sb.append("       a0b3.name    Srvname      ");
	     sb.append(" from bd_incca_itm_rel      a0   ");
		 sb.append("   inner join bd_incca a0b4  ");
		 sb.append("    ON a0.id_incca = a0b4.id_incca  ");
		 sb.append("   inner join bd_incca_itm  d  ");
		 sb.append("    on a0.id_inccaitm=d.id_inccaitm   ");
		 sb.append("   left outer join bd_srvca a0b5  ");
		 sb.append("    ON a0.id_srvca = a0b5.id_srvca  ");
		 sb.append("   left outer join bd_srv a0b3  ");
		 sb.append("    ON a0.id_srv = a0b3.id_srv  ");
		 sb.append("   left outer join bd_srvca c  ");
		 sb.append("    on a0b3.id_srvca = c.id_srvca  ");
		 sb.append("  where  1=1  ");
		
		 if(id_inccaitm!=null  &&  !"".equals(id_inccaitm)){
			 sb.append("  and  a0.id_inccaitm  = '"+id_inccaitm+"'  "); 
		 }
		 
		 if(id_incca!=null && !"".equals(id_incca)){
			sb.append("  and a0.id_incca = '"+id_incca+"' ") ;
		 }
		 
		 if(id_srv!=null && !"".equals(id_srv)){
			sb.append(" and a0.id_srv = '"+id_srv+"' "); 
		 }
		 
		 if(id_srvca!=null && !"".equals(id_srvca)){
			 sb.append("  and  c.id_srvca =  '"+id_srvca+"' ");
		 }
		 
		 sb.append("    and  a0b3.fg_bl='Y' and a0b3.fg_active='Y' ");
		 sb.append("    and  a0.ds = 0    order by  c.name ");
		 
          List<IncCaItmRelDO> list  = (List<IncCaItmRelDO>)new DAFacade().execQuery(sb.toString(), new BeanListHandler(IncCaItmRelDO.class));
		  IncCaItmRelDO[]  ppspDOArr=list.toArray(new IncCaItmRelDO[]{});
		  //System.out.println("查询时间1："+(System.currentTimeMillis()-aa));
          return ppspDOArr;
	}

	@SuppressWarnings("unchecked")
	public IncCaItmRelDO[] getInccaitmRelDOByIdsrvca(String id_incca,
			String id_inccaitm, String id_srvca)throws BizException {
		// TODO Auto-generated method stub
		if(id_inccaitm==null) {
			id_inccaitm="";
		   }
		
		 StringBuffer sb=new StringBuffer();
		 sb.append(" select distinct  a0.Id_incca,  ");
	     sb.append("       a0.Id_inccaitm,  ");
		 sb.append("       a0.Id_inccaitmrel,  ");
		 sb.append("       a0.Id_srv, a0.ds,a0.sv,  "); 
		 sb.append("       b.Id_srv,b.id_srvca,  "); 
		 sb.append("       a.id_srvca, ");
		 sb.append("       a.name         Srvcaname,  ");
		 sb.append("       b.name         Srvname  ");
	     sb.append(" from bd_incca_itm_rel      a0  ");
		 sb.append("   inner join  bd_srv    b  ");
		 sb.append("      on a0.id_srv =b.id_srv  ");
		 sb.append("   inner join  bd_srvca  a ");
		 sb.append("      on a.id_srvca=b.id_srvca    ");
		 sb.append("   where a0.id_incca='"+id_incca+"' and a0.id_inccaitm='"+id_inccaitm+"' and  b.id_srvca='"+id_srvca+"'    ");
		 sb.append("      and b.fg_active='Y' and b.fg_bl='Y'       ");
		 sb.append("      and a0.ds = 0  ");
		
		  List<IncCaItmRelDO> list  = (List<IncCaItmRelDO>)new DAFacade().execQuery(sb.toString(), new BeanListHandler(IncCaItmRelDO.class));
		   IncCaItmRelDO[]  ppspDOArr=list.toArray(new IncCaItmRelDO[]{});
		   return ppspDOArr;
	}
	
	/**
	 * 新增时判断事件类型发送事件
	 * */
	public void invokeInsertEvent(InccaAggDO inccaAggDO) throws BizException{
//		IncCaDO incCaDO = inccaAggDO.getParentDO();
//		IncCaItmDO[] incCaItmDOArr  = inccaAggDO.getIncCaItmDO();
//		BdPpEvent bdPpEvent = new BdPpEvent();
//		if(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE.equals(incCaDO.getCode())){//门诊发票
//			bdPpEvent.invokeInccaItm(incCaItmDOArr, IBdSrvIEEventConst.TYPE_INSERT_INCCA_MZ);
//		}else if(IBdInccaCodeConst.CODE_INHOS_INVOICE.equals(incCaDO.getCode())){//住院发票
//			bdPpEvent.invokeInccaItm(incCaItmDOArr, IBdSrvIEEventConst.TYPE_INSERT_INCCA_ZY);
//		}
	}
	
	/**
	 * 删除时判断事件类型发送事件
	 * */
	public void invokeDeleteEvent(InccaAggDO inccaAggDO) throws BizException{
//		IncCaDO incCaDO = inccaAggDO.getParentDO();
//		IncCaItmDO[] incCaItmDOArr  = inccaAggDO.getIncCaItmDO();
//		BdPpEvent bdPpEvent = new BdPpEvent();
//		if(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE.equals(incCaDO.getCode())){//门诊发票
//			bdPpEvent.invokeInccaItm(incCaItmDOArr, IBdSrvIEEventConst.TYPE_DELETE_INCCA_MZ);
//		}else if(IBdInccaCodeConst.CODE_INHOS_INVOICE.equals(incCaDO.getCode())){//住院发票
//			bdPpEvent.invokeInccaItm(incCaItmDOArr, IBdSrvIEEventConst.TYPE_DELETE_INCCA_ZY);
//		}
	}
	
	/**
	 * 数据分类
	 * */
	public void distinctUpdateData(IncCaItmDO[] incCaItmDOArr,List<IncCaItmDO> inList,List<IncCaItmDO> upList,List<IncCaItmDO> deList){
		for(IncCaItmDO incCaItmDO : incCaItmDOArr){
			if(incCaItmDO.getStatus() == DOStatus.NEW){
				inList.add(incCaItmDO);
			}else if(incCaItmDO.getStatus() == DOStatus.UPDATED){
				upList.add(incCaItmDO);
			}else if(incCaItmDO.getStatus() == DOStatus.DELETED){
				deList.add(incCaItmDO);
			}
		}
	}
	
	/**
	 * 编辑时判断事件类型发送事件
	 * */
	public void invokeUpdateEvent(IncCaDO incCaDO,List<IncCaItmDO> inList,List<IncCaItmDO> upList,List<IncCaItmDO> deList) throws BizException{
//		BdPpEvent bdPpEvent = new BdPpEvent();
//		if(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE.equals(incCaDO.getCode())){//门诊发票
//			if(inList.size() > 0 ){
//				bdPpEvent.invokeInccaItm(inList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_INSERT_INCCA_MZ);
//			}
//			if(upList.size() > 0 ){
//				bdPpEvent.invokeInccaItm(upList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_UPDATE_INCCA_MZ);
//			}
//			if(deList.size() > 0 ){
//				bdPpEvent.invokeInccaItm(deList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_DELETE_INCCA_MZ);
//			}
//		}else if(IBdInccaCodeConst.CODE_INHOS_INVOICE.equals(incCaDO.getCode())){//住院发票
//			if(inList.size() > 0 ){
//				bdPpEvent.invokeInccaItm(inList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_INSERT_INCCA_ZY);
//			}
//			if(upList.size() > 0 ){
//				bdPpEvent.invokeInccaItm(upList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_UPDATE_INCCA_ZY);
//			}
//			if(deList.size() > 0 ){
//				bdPpEvent.invokeInccaItm(deList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_DELETE_INCCA_ZY);
//			}
//		}
	}
	
	/**
	 * 判断事件类型，并发送事件(方法作废)
	 * */
	@Deprecated
	public void invokeEvent(InccaAggDO inccaAggDO) throws BizException{
		IncCaDO incCaDO = inccaAggDO.getParentDO();
		IncCaItmDO[] incCaItmDOArr  = inccaAggDO.getIncCaItmDO();
		if(incCaItmDOArr == null || incCaItmDOArr.length == 0){
			return;
		}
		BdPpEvent bdPpEvent = new BdPpEvent();
		if(incCaDO.getStatus() == DOStatus.NEW){
			if(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE.equals(incCaDO.getCode())){//门诊发票
				bdPpEvent.invokeInccaItm(incCaItmDOArr, IBdSrvIEEventConst.TYPE_INSERT_INCCA_MZ);
			}else if(IBdInccaCodeConst.CODE_INHOS_INVOICE.equals(incCaDO.getCode())){//住院发票
				bdPpEvent.invokeInccaItm(incCaItmDOArr, IBdSrvIEEventConst.TYPE_INSERT_INCCA_ZY);
			}
		}else if(incCaDO.getStatus() == DOStatus.UPDATED){
			List<IncCaItmDO> inList = new ArrayList<IncCaItmDO>();
			List<IncCaItmDO> upList = new ArrayList<IncCaItmDO>();
			List<IncCaItmDO> deList = new ArrayList<IncCaItmDO>();
			for(IncCaItmDO incCaItmDO : incCaItmDOArr){
				if(incCaItmDO.getStatus() == DOStatus.NEW){
					inList.add(incCaItmDO);
				}else if(incCaItmDO.getStatus() == DOStatus.UPDATED){
					upList.add(incCaItmDO);
				}else if(incCaItmDO.getStatus() == DOStatus.DELETED){
					deList.add(incCaItmDO);
				}
			}
			if(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE.equals(incCaDO.getCode())){//门诊发票
				if(inList.size() > 0 ){
					bdPpEvent.invokeInccaItm(inList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_INSERT_INCCA_MZ);
				}
				if(upList.size() > 0 ){
					bdPpEvent.invokeInccaItm(upList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_UPDATE_INCCA_MZ);
				}
				if(deList.size() > 0 ){
					bdPpEvent.invokeInccaItm(deList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_DELETE_INCCA_MZ);
				}
			}else if(IBdInccaCodeConst.CODE_INHOS_INVOICE.equals(incCaDO.getCode())){//住院发票
				if(inList.size() > 0 ){
					bdPpEvent.invokeInccaItm(inList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_INSERT_INCCA_ZY);
				}
				if(upList.size() > 0 ){
					bdPpEvent.invokeInccaItm(upList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_UPDATE_INCCA_ZY);
				}
				if(deList.size() > 0 ){
					bdPpEvent.invokeInccaItm(deList.toArray(new IncCaItmDO[]{}), IBdSrvIEEventConst.TYPE_DELETE_INCCA_ZY);
				}
			}
		}else if(incCaDO.getStatus() == DOStatus.DELETED){
			if(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE.equals(incCaDO.getCode())){//门诊发票
				bdPpEvent.invokeInccaItm(incCaItmDOArr, IBdSrvIEEventConst.TYPE_DELETE_INCCA_MZ);
			}else if(IBdInccaCodeConst.CODE_INHOS_INVOICE.equals(incCaDO.getCode())){//住院发票
				bdPpEvent.invokeInccaItm(incCaItmDOArr, IBdSrvIEEventConst.TYPE_DELETE_INCCA_ZY);
			}
		}
	}
}
