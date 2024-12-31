package iih.bd.pp.pricelistqry.bp;

import java.util.List;

import iih.bd.pp.dto.d.PricelistqrySrvDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class PricelistqryBp {

	public PricelistqrySrvDTO[] getSrvlistByQrynamesrv(String qryNamesrv) throws BizException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("    select  a.id_srv ,a.name name_srv,a.fg_mm,      ");
		sql.append("            b.id_mm,b.name name_mm,b.spec,b.price   ");
		sql.append("                                               ");
		sql.append("                                               ");
		sql.append("                                               ");
		sql.append("                                               ");
		sql.append("   from bd_srv a                               ");
		sql.append("    join bd_mm b on a.id_srv = b.id_srv        ");
		sql.append("    where    a.name like    ?                   ");
		sql.append("         and a.fg_bl='Y'                        ");
		sql.append("         and a.ds=0                             ");
		// sql.append(" and a.fg_active='Y' ");

		List<PricelistqrySrvDTO> list = (List<PricelistqrySrvDTO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(PricelistqrySrvDTO.class));
		return list.toArray(new PricelistqrySrvDTO[] {});
	}

	public PricelistqrySrvDTO[] getPricelistqrySrvDTOByIdsrv(String id_srv) throws BizException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append(
				"    select a.id_srv,b.name as name_srv , b.code      as code_srv,  b.id_unit_med id_unit,  c.name  name_unit,a.price as price_prilist,a.dt_b,a.dt_e,a.fg_active,a.ds ,a.des      ");
		sql.append("           from      bd_pri_srv a                                                    ");
		sql.append("         inner join  bd_srv     b on a.id_srv = b.id_srv                             ");
		sql.append("         inner join bd_measdoc c on b.id_unit_med=c.id_measdoc                       ");
		sql.append("           where                                                                     ");
		sql.append("                b.fg_bl='Y'                                                          ");
		sql.append("                and b.id_srv= ?                                                      ");
		sql.append("                and a.ds=0                                                           ");

		SqlParam sp = new SqlParam();
		sp.addParam(id_srv);

		List<PricelistqrySrvDTO> list = (List<PricelistqrySrvDTO>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(PricelistqrySrvDTO.class));
		return list.toArray(new PricelistqrySrvDTO[] {});
	}

	public PagingRtnData<PricelistqrySrvDTO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereStr = ser.getQueryStringWithoutDesc(qryRootNodeDTO);

		StringBuffer sql = new StringBuffer();
		sql.append("");

		sql.append(
				"  select   id_srv,name_srv,code_srv,id_unit_med,id_srvca,fg_mm,id_mm,name_mm,code_mm,spec,price,name_unit  from    ");
		sql.append("    (select  a.id_srv ,a.name name_srv,a.code code_srv,a.id_unit_med,a.id_srvca,a.fg_mm,       ");
		sql.append(
				"             b.id_mm,b.name name_mm,b.spec,nvl(b.price, a.pri) as price ,c.name as name_unit,nvl(b.code,a.code)  as code_mm    "); // 非物品显示服务编码，物品显示物品编码（或增加物品编码列）
		sql.append("                                               ");
		sql.append("                                               ");
		sql.append("   from bd_srv a                               ");
		sql.append("   left  join bd_mm b on a.id_srv = b.id_srv        ");
		sql.append("   inner join bd_measdoc   c on a.id_unit_med=c.id_measdoc   ");
		sql.append("    where     a.fg_bl='Y'                     ");
		sql.append("         and  a.ds=0                          ");

		// 管控语句添加
		String bdModeWherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "a");
		if (bdModeWherePart != null && bdModeWherePart != "") {
			sql.append(String.format(" and %s ", bdModeWherePart));
		}

		sql.append("         and  a.fg_active='Y')X            ");

		if (whereStr == null) {
			sql.append("     where  ");
			sql.append("1=1");
		} else {
			sql.append("     where  ");
			sql.append(whereStr);
		}

		sql.append(" order by code_srv asc ");

		// List<PricelistqrySrvDTO> list = (List<PricelistqrySrvDTO>)new
		// DAFacade().execQuery(sql.toString(), new
		// BeanListHandler(PricelistqrySrvDTO.class));

		PricelistqrySrvDTO incdto = new PricelistqrySrvDTO();
		PagingServiceImpl<PricelistqrySrvDTO> pagingServiceImpl = new PagingServiceImpl<PricelistqrySrvDTO>();

		// IPriCalService prical=
		// (IPriCalService)ServiceFinder.find(IPriCalService.class);
		// PriStdSrvDTO[] pssDTO= new PriStdSrvDTO[list.size()];
		// List<PriStdSrvDTO> newl=new ArrayList<PriStdSrvDTO>();
		// for(int i=0; i<list.size();i++){
		// PricelistqrySrvDTO itm = list.get(i);
		// PriStdSrvDTO pssDTO = new PriStdSrvDTO();
		// if(itm!=null && ! itm.getFg_mm().booleanValue()){
		// String idsrv=itm.getId_srv();
		// if(idsrv!=null){
		// pssDTO.setId_srv(idsrv);
		// }
		// String namesrv=itm.getName_srv();
		// if(namesrv!=null){
		// pssDTO.setName_srv(namesrv);
		// }
		// newl.add(pssDTO);
		// }
		// }
		// Map<String,FDouble>
		// priInfo=prical.CalManySrvStdPriceMap(newl.toArray(new
		// PriStdSrvDTO[]{}));
		// for(int j=0;j< priInfo.size();j++){
		// PricelistqrySrvDTO item= list.get(j);
		// if(item!=null){
		// String idsrv=item.getId_srv();
		// if(idsrv!=null){
		// FDouble fd= priInfo.get(idsrv);
		// item.setPrice(fd);
		// }
		// }
		// }
		// PricelistqrySrvDTO[] plssDTO=list.toArray(new
		// PricelistqrySrvDTO[]{});
		PagingRtnData<PricelistqrySrvDTO> prd = pagingServiceImpl.findByPageInfo(incdto, pg, sql.toString(), "", null);
		return prd;
	}

}
