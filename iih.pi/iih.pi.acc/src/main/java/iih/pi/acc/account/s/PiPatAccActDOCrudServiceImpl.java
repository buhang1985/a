package iih.pi.acc.account.s;
import java.util.HashMap;
import java.util.Map;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.pi.acc.account.d.desc.PiPatAccActDODesc;
import iih.pi.acc.account.d.PiPatAccActDO;
import iih.pi.acc.account.i.IPiPatAccActDOCudService;
import iih.pi.acc.account.i.IPiPatAccActDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.EnvContextUtil;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者账户主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatAccActDOCudService.class,IPiPatAccActDORService.class}, binding=Binding.JSONRPC)
public class PiPatAccActDOCrudServiceImpl extends BaseDOService<PiPatAccActDO> implements IPiPatAccActDOCudService,IPiPatAccActDORService {

	private DAFacade facade=new DAFacade(); 
	
    public PiPatAccActDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatAccActDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    
    
    @Override
	public PagingRtnData<PiPatAccActDO> findByQCondAndPageInfo(
			QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException {
    	PagingRtnData<PiPatAccActDO> ret=null;
    	ret=super.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
    	if(ret!=null&&ret.getPageData()!=null&&ret.getPageData().size()>0) {
    		FArrayList fa=ret.getPageData();
    		String sql="select pat.name from pi_pat_acc acc "
    				+ "left join pi_pat pat on acc.id_pat=pat.id_pat "
    				+ " where acc.id_patacc=? ";
    		Map<String,String>map=new HashMap<>();
    		
    		for(Object o:fa) {
    			PiPatAccActDO act=(PiPatAccActDO)o;
    			act.setOperate_direct_text("减少");
    			if(new Integer(1).equals(act.getOperate_direct())) {
    				act.setOperate_direct_text("增加");			
    			}
    			if(map.containsKey(act.getId_patacc())) {
    				String name=map.get(act.getId_patacc());
    				setNote(act,name);
    			}else {
    				ColumnHandler h=new ColumnHandler();
    				SqlParam param=new SqlParam();
    				param.addParam(act.getId_patacc());
    				String name=(String)facade.execQuery(sql, param, h);
    				map.put(act.getId_patacc(), name);
    				setNote(act,name);
    			}
    		}
    	}
    	
		return ret;
	}
    
    private void setNote(PiPatAccActDO act,String patname) {
    	if(!StringUtil.isEmptyWithTrim(act.getNote())
				&&!StringUtil.isEmptyWithTrim(patname)) {
			act.setNote(act.getNote()+"@@"+patname);
		}else if(StringUtil.isEmptyWithTrim(act.getNote())){
			act.setNote("@name@"+patname);
		}else if(StringUtil.isEmptyWithTrim(patname)) {
			act.setNote("@note@"+act.getNote());
		}
    }
    



	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
	
	@Override
	public PagingRtnData<PiPatAccActDO> findByPageInfo(PaginationInfo pg,
			String whereStr, String orderStr) throws BizException {
		String orgSql = EnvContextUtil.processEnvContext("",new PiPatAccActDO(),true);
		whereStr += " AND " + orgSql;
		return super.findByPageInfo(pg, whereStr, orderStr);
	}
}

