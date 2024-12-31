package iih.pi.acc.s.bp;

import iih.pi.acc.dto.d.PiPrepayQryDTO;
import iih.pi.acc.s.bp.qry.GetPiPrePayListQry;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 获取预交金收取记录
 * @author zhangxin
 * @date 2019年4月30日
 */
public class GetPrePayListBP {
    

	public PagingRtnData<PiPrepayQryDTO> exec(QryRootNodeDTO qryRoot,PaginationInfo pg) throws BizException{
		//拼装查询面板条件
 	    IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
 	    String whereStr = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRoot);
 	    //查询预交金列表数据
 	    GetPiPrePayListQry qry = new GetPiPrePayListQry(whereStr);
 	    //分页方法实现
 	    PagingServiceImpl<PiPrepayQryDTO> pagingServiceImpl = new PagingServiceImpl<PiPrepayQryDTO>();
		PagingRtnData<PiPrepayQryDTO> result = pagingServiceImpl.findByPageInfo(new PiPrepayQryDTO(), pg,
				qry.getQrySQLStr(), "Dt_st desc", qry.getQryParameter(null));
    	 return result;
     }
}
